package rxjava.lambda.ch4_4;

import io.reactivex.Flowable;
import rxjava.lambda.ch4.DebugSubscriber;

import java.util.concurrent.TimeUnit;

public class MergeSample {

    public static void main(String[] args) throws InterruptedException {
        Flowable<Long> flowable1 = Flowable.interval(300L, TimeUnit.MILLISECONDS)
                .take(5);

        Flowable<Long> flowable2 = Flowable.interval(500L, TimeUnit.MILLISECONDS)
                .take(2)
                .map(data -> data + 100);

        Flowable.merge(flowable1, flowable2)
                .subscribe(new DebugSubscriber<>("merge"));

        Thread.sleep(5000);
    }
}
