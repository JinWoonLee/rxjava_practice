package rxjava.lambda.ch3;

import io.reactivex.Flowable;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SyncFasterSample {

    public static void main(String[] args) throws InterruptedException {
        Flowable.interval(1000L, TimeUnit.MILLISECONDS)
                .doOnNext(data -> {
                    System.out.println(new Date(System.currentTimeMillis()) + " " + data);
                })
                .subscribe(data -> Thread.sleep(500));

        Thread.sleep(5000);
    }
}
