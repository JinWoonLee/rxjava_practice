package rxjava.lambda.ch4_2;

import io.reactivex.Flowable;
import rxjava.lambda.ch4.DebugSubscriber;

import java.util.concurrent.TimeUnit;

public class TakeLastSample {

    public static void main(String[] args) throws InterruptedException {
        Flowable<Long> flowable = Flowable.interval(100L, TimeUnit.MILLISECONDS)
                                        .take(5)
                                        .takeLast(2);

        flowable.subscribe(new DebugSubscriber<>("takeLast"));

        Thread.sleep(3000L);
    }
}
