package rxjava.lambda.ch3;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CounterWithMergeSample {

    private static final CounterSample.Counter counter = new CounterSample.Counter();

    public static void main(String[] args) throws InterruptedException {
        Flowable<Integer> flowable1 = Flowable.range(1, 10000)
                .subscribeOn(Schedulers.computation())
                .observeOn(Schedulers.computation());

        Flowable<Integer> flowable2 = Flowable.range(1, 10000)
                .subscribeOn(Schedulers.computation())
                .observeOn(Schedulers.computation());

        Flowable.merge(flowable1, flowable2)
                .subscribe(
                        data -> {
                            String threadName = Thread.currentThread().getThreadGroup().getName() + "-" + Thread.currentThread().getName();
                            String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd HHmmss"));
                            System.out.println(threadName + " " + dateTime + " " + data);
                            counter.increment();
                        },
                        error -> error.printStackTrace(),
                        () -> System.out.println(counter.getNum())
                );

        Thread.sleep(3000);
    }
}
