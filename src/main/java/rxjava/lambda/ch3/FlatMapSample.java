package rxjava.lambda.ch3;

import io.reactivex.Flowable;

import java.util.concurrent.TimeUnit;

public class FlatMapSample {

    public static void main(String[] args) throws InterruptedException {
        Flowable<Integer> flowable = Flowable.just(1, 2, 3)
                .flatMap(data -> {
                    String threadName = Thread.currentThread().getName();
                    System.out.println(threadName + " " + data + " in producer");
                    return Flowable.just(data).delay(1000L, TimeUnit.MILLISECONDS);
                });

        flowable.subscribe(data -> {
           String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " " + data + " in consumer");
        });


        Thread.sleep(2000);
    }

}
