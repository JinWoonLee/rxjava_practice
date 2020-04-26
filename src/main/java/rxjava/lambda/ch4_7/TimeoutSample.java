package rxjava.lambda.ch4_7;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import rxjava.lambda.ch4.DebugSubscriber;

import java.util.concurrent.TimeUnit;

public class TimeoutSample {

    public static void main(String[] args) {
        Flowable<Object> timeout = Flowable.create(emitter -> {
            emitter.onNext(1);
            emitter.onNext(2);

            try {
                Thread.sleep(1200);
            } catch (InterruptedException e) {
                emitter.onError(e);
            }

            emitter.onNext(3);
            emitter.onComplete();
        }, BackpressureStrategy.BUFFER)
        .timeout(1000, TimeUnit.MILLISECONDS);

        timeout.subscribe(new DebugSubscriber<>("timeout"));
    }
}
