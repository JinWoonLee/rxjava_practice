package rxjava.lambda.ch4_3;

import io.reactivex.Flowable;
import rxjava.lambda.ch4.DebugSubscriber;

import java.util.concurrent.TimeUnit;

public class SkipUntilSample {

    public static void main(String[] args) throws InterruptedException {
        Flowable<Long> skipUntil = Flowable.interval(300L, TimeUnit.MILLISECONDS)
                .skipUntil(Flowable.timer(1000L, TimeUnit.MILLISECONDS));

        skipUntil.subscribe(new DebugSubscriber<>("skipUntil"));

        Thread.sleep(3000L);
    }
}
