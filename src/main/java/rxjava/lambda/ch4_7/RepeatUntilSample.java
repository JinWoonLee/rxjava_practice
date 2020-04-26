package rxjava.lambda.ch4_7;

import io.reactivex.Flowable;
import rxjava.lambda.ch4.DebugSubscriber;

import java.util.concurrent.TimeUnit;

public class RepeatUntilSample {

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();

        Flowable<Long> longFlowable = Flowable.interval(1000L, TimeUnit.MILLISECONDS)
                .take(3)
                .repeatUntil(() -> System.currentTimeMillis() - startTime > 10000);

        longFlowable.subscribe(new DebugSubscriber<>("repeatUntil"));

        Thread.sleep(20000);
    }
}
