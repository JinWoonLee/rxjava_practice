package rxjava.lambda.ch4_7;

import io.reactivex.Flowable;
import rxjava.lambda.ch4.DebugSubscriber;

import java.util.concurrent.TimeUnit;

public class RepeatSample {

    public static void main(String[] args) throws InterruptedException {
        Flowable<Long> repeat = Flowable.interval(1000L, TimeUnit.MILLISECONDS)
                .take(3)
                .repeat(3);

        repeat.subscribe(new DebugSubscriber<>("repeat"));

        Thread.sleep(10000);
    }
}
