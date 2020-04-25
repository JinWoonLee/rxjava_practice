package rxjava.lambda.ch4_3;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import rxjava.lambda.ch4.DebugSubscriber;

import java.util.concurrent.TimeUnit;

public class ThrottleWithTimeoutSample {

    public static void main(String[] args) {
        Flowable<Integer> flowable = Flowable.<Integer>create(emitter -> {
            emitter.onNext(3);
            Thread.sleep(300);
            emitter.onNext(5);

            emitter.onNext(6);
            Thread.sleep(1000);

            emitter.onNext(7);
            Thread.sleep(3000);

            emitter.onComplete();
        }, BackpressureStrategy.BUFFER)
                .throttleWithTimeout(500L, TimeUnit.MILLISECONDS);

        flowable.subscribe(new DebugSubscriber<>("throttleWithTimeout"));
    }
}
