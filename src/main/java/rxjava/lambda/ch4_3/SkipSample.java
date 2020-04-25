package rxjava.lambda.ch4_3;

import io.reactivex.Flowable;
import rxjava.lambda.ch4.DebugSubscriber;

import java.util.concurrent.TimeUnit;

public class SkipSample {

    public static void main(String[] args) throws InterruptedException {
        Flowable<Long> skip = Flowable.interval(100L, TimeUnit.MILLISECONDS)
                                    .skip(2);

        skip.subscribe(new DebugSubscriber<>("skip"));

        Thread.sleep(5000);
    }
}
