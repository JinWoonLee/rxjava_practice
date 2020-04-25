package rxjava.lambda.ch4_3;

import io.reactivex.Flowable;
import rxjava.lambda.ch4.DebugSubscriber;

import java.util.concurrent.TimeUnit;

public class FilterSample {

    public static void main(String[] args) throws InterruptedException {
        Flowable<Long> flowable = Flowable.interval(500L, TimeUnit.MILLISECONDS)
                                            .filter(data -> data%2 == 0);

        flowable.subscribe(new DebugSubscriber<>("filter"));

        Thread.sleep(3000);
    }
}
