package rxjava.lambda.ch4_3;

import io.reactivex.Flowable;
import rxjava.lambda.ch4.DebugSubscriber;

import java.util.concurrent.TimeUnit;

public class ThrottleFirstSample {

    public static void main(String[] args) throws InterruptedException {
        Flowable<Long> flowable = Flowable.interval(300L, TimeUnit.MILLISECONDS)
                .throttleFirst(1000L, TimeUnit.MILLISECONDS);

        flowable.subscribe(new DebugSubscriber<>("throttleFirst"));

        Thread.sleep(5000L);
    }
}
