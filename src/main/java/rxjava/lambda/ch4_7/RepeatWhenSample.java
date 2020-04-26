package rxjava.lambda.ch4_7;

import io.reactivex.Flowable;
import rxjava.lambda.ch4.DebugSubscriber;

import java.util.concurrent.TimeUnit;

public class RepeatWhenSample {

    public static void main(String[] args) throws InterruptedException {
        justSample();

        System.out.println("----------");

        intervalSample();
    }

    private static void intervalSample() throws InterruptedException {
        Flowable<Long> repeatWhen = Flowable.interval(100L, TimeUnit.MILLISECONDS)
                .take(5)
                .repeatWhen(objectFlowable -> {
                    String threadName = Thread.currentThread().getName();
                    return objectFlowable
                            .delay(1000L, TimeUnit.MILLISECONDS)
                            .take(2)
                            .doOnNext(data -> System.out.println(threadName + "(repeatHandler) : " + data))
                            .doOnComplete(() -> System.out.println(threadName + "(repeatHandler) : completed"));
                });
        repeatWhen.subscribe(new DebugSubscriber<>("repeatWhen"));


        Thread.sleep(10000);
    }

    private static void justSample() throws InterruptedException {
        Flowable<Integer> repeatWhen = Flowable.just(1, 2, 3, 4)
                .repeatWhen(objectFlowable -> {
                    String threadName = Thread.currentThread().getName();
                    return objectFlowable
                            .delay(1000L, TimeUnit.MILLISECONDS)
                            .take(2)
                            .doOnNext(data -> System.out.println(threadName + "(repeatHandler) : " + data))
                            .doOnComplete(() -> System.out.println(threadName + "(repeatHandler) : completed"));
                });
        repeatWhen.subscribe(new DebugSubscriber<>("repeatWhen"));


        Thread.sleep(10000);
    }
}
