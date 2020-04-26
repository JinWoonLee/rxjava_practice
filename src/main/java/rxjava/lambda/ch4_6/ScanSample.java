package rxjava.lambda.ch4_6;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import rxjava.lambda.ch4.DebugSubscriber;

public class ScanSample {

    public static void main(String[] args) {
        Flowable<Integer> scan = Flowable.<Integer>create(emitter -> {
            for (int i = 1; i <= 5; i++) {
                emitter.onNext(i);
            }
            emitter.onComplete();
        }, BackpressureStrategy.BUFFER)
        .scan(0, (sum, data) -> sum + data);

        scan.subscribe(new DebugSubscriber<>("scan"));
    }
}
