package rxjava.lambda.ch4_3;

import io.reactivex.Flowable;
import rxjava.lambda.ch4.DebugSubscriber;

import java.util.concurrent.TimeUnit;

public class ThrottleLastSample {

    public static void main(String[] args) throws InterruptedException {
        Flowable<Long> longFlowable = Flowable.interval(300L, TimeUnit.MILLISECONDS)
                .throttleLast(1000L, TimeUnit.MILLISECONDS);

        longFlowable.subscribe(new DebugSubscriber<>("throttleLast"));

        Thread.sleep(5000);
    }
}
