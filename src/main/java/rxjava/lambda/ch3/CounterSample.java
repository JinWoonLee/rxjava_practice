package rxjava.lambda.ch3;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CounterSample {

    private static Counter counter = new Counter();

    public static void main(String[] args) throws InterruptedException {
        Flowable.range(1, 10000)
                .subscribeOn(Schedulers.computation())
                .doOnNext(data -> {
                    String threadName = Thread.currentThread().getName() + Thread.currentThread().getThreadGroup().getName();
                    String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd HHmmss"));
                    System.out.println("Publisher1 " + threadName + " " + dateTime + " " + data);
                })
                .observeOn(Schedulers.computation())
                .subscribe(
                  //onNext
                  data -> {
                      String threadName = Thread.currentThread().getName() + Thread.currentThread().getThreadGroup().getName();
                      String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd HHmmss"));
                      System.out.println("Subscriber1 " + threadName + " " + dateTime + " " + data);
                      counter.increment();
                  },
                  //onError
                  error -> error.printStackTrace(),
                  //onCompleted
                  () -> System.out.println("completed called " + counter.getNum())
                );

        Flowable.range(1, 10000)
                .subscribeOn(Schedulers.computation())
                .doOnNext(data -> {
                    String threadName = Thread.currentThread().getName() + Thread.currentThread().getThreadGroup().getName();
                    String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd HHmmss"));
                    System.out.println("Publisher2 " + threadName + " " + dateTime + " " + data);
                })
                .observeOn(Schedulers.computation())
                .subscribe(
                        //onNext
                        data -> {
                            String threadName = Thread.currentThread().getName() + Thread.currentThread().getThreadGroup().getName();
                            String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd HHmmss"));
                            System.out.println("Subscriber2 " + threadName + " " + dateTime + " " + data);
                            counter.increment();
                        },
                        //onError
                        error -> error.printStackTrace(),
                        //onCompleted
                        () -> System.out.println("completed called " + counter.getNum())
                );

        Thread.sleep(5000);
    }


    public static class Counter {
        private volatile int num = 0;

        public void increment(){
            num++;
        }

        public int getNum() {
            return num;
        }
    }
}
