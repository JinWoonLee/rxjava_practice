package rxjava.lambda.ch3;

import io.reactivex.Flowable;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SyncSlowerSample {

    public static void main(String[] args) throws InterruptedException {
        Flowable.interval(1000L, TimeUnit.MILLISECONDS)
                .doOnNext(data -> {
                    System.out.println("Publisher end : " + new Date(System.currentTimeMillis()) + " : " + data);
                })
                .subscribe(data -> {
                    Thread.sleep(2000);
                });

        Thread.sleep(5000L);

        System.out.println("main run");
    }
}
