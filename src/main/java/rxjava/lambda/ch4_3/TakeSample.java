package rxjava.lambda.ch4_3;

import io.reactivex.Flowable;
import rxjava.lambda.ch4.DebugSubscriber;

import java.util.concurrent.TimeUnit;

public class TakeSample {

    public static void main(String[] args) throws InterruptedException {
        Flowable<Long> flowable = Flowable.interval(100L, TimeUnit.MILLISECONDS)
                                        .take(3);

        flowable.subscribe(new DebugSubscriber<>("take"));

        Thread.sleep(3000L);
    }
}
