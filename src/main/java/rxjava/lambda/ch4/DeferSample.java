package rxjava.lambda.ch4;

import io.reactivex.Flowable;

import java.time.LocalTime;

public class DeferSample {

    public static void main(String[] args) throws InterruptedException {
        Flowable flowable
                = Flowable.defer(() -> {
                    System.out.println(Thread.currentThread().getName());
                    return Flowable.just(LocalTime.now());
                });

        flowable.subscribe(new DebugSubscriber("defer"));

        Thread.sleep(2000);

        flowable.subscribe(new DebugSubscriber("defer2"));

        Flowable flowable2 = Flowable.just(LocalTime.now());

        flowable2.subscribe(new DebugSubscriber("just"));

        Thread.sleep(2000);

        flowable2.subscribe(new DebugSubscriber("just"));
    }


}
