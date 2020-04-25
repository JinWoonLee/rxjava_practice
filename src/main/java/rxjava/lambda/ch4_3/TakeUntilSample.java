package rxjava.lambda.ch4_3;

import io.reactivex.Flowable;
import rxjava.lambda.ch4.DebugSubscriber;

import java.util.concurrent.TimeUnit;

public class TakeUntilSample {

    public static void main(String[] args) throws InterruptedException {
        Flowable<Long> flowable = Flowable.interval(1000L, TimeUnit.MILLISECONDS)
                                            .takeUntil(data -> data == 5);

        flowable.subscribe(new DebugSubscriber<>("flowable"));

        Thread.sleep(6000);
    }

}
