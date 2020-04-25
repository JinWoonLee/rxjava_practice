package rxjava.lambda.ch4_3;

import io.reactivex.Flowable;
import rxjava.lambda.ch4.DebugSubscriber;

import java.util.concurrent.TimeUnit;

public class TakeWhileSample {

    public static void main(String[] args) throws InterruptedException {
        Flowable<Long> takeWhile = Flowable.interval(100L, TimeUnit.MILLISECONDS)
                                            .takeWhile(data -> data != 3);

        takeWhile.subscribe(new DebugSubscriber<>("takeWhile"));

        Thread.sleep(3000L);
    }
}
