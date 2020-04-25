package rxjava.lambda.ch4_2;

import io.reactivex.Flowable;
import rxjava.lambda.ch4.DebugSubscriber;

import java.util.concurrent.TimeUnit;

public class ConcatMapEagerSample {

    public static void main(String[] args) throws InterruptedException {
        Flowable flowable = Flowable.range(10, 3)
                                    .concatMapEager(sourceData -> Flowable.interval(500L, TimeUnit.MILLISECONDS)
                                                                    .take(2)
                                                                    .map(data -> {
                                                                        Long time = System.currentTimeMillis();
                                                                        return time + "[" + sourceData + "] " + data;
                                                                    }));

        flowable.subscribe(new DebugSubscriber("concatMapEager"));

        Thread.sleep(5000L);
    }
}
