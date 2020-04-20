package rxjava.lambda.ch3;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class MissingBackpressureFlowableSample {

    public static void main(String[] args) throws InterruptedException {
        Flowable.interval(10L, TimeUnit.MILLISECONDS)
                .doOnNext(System.out::println)
                .observeOn(Schedulers.computation())
                .subscribe(data -> {
                    System.out.println("Subscriber : " + data);
                    Thread.sleep(1000);
                });

        Thread.sleep(5000);
    }
}
