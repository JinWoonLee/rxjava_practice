package rxjava.lambda.ch4_2;

import io.reactivex.Flowable;
import rxjava.lambda.ch4.DebugSubscriber;

import java.util.concurrent.TimeUnit;

public class BufferSample3 {

    public static void main(String[] args) throws InterruptedException {
        Flowable flowable = Flowable.interval(300L, TimeUnit.MILLISECONDS)
                                    .take(10)
                                    .buffer(Flowable.just(3), data -> {
                                        System.out.println(data);
                                        if(data < 1) return Flowable.just(data);
                                        return Flowable.just(1);
                                    });

        flowable.subscribe(new DebugSubscriber("buffer"));

        Thread.sleep(5000);
    }
}
