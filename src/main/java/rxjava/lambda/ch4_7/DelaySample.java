package rxjava.lambda.ch4_7;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import rxjava.lambda.ch4.DebugSubscriber;

import java.util.concurrent.TimeUnit;

public class DelaySample {

    public static void main(String[] args) throws InterruptedException {
        printInfo("run app");

        Flowable<Integer> emitStart = Flowable.<Integer>create(emitter -> {
            printInfo("emitStart");

            emitter.onNext(1);
            emitter.onNext(2);
            emitter.onNext(3);

            emitter.onComplete();
        }, BackpressureStrategy.BUFFER)
        .delay(3000L, TimeUnit.MILLISECONDS)
        .doOnNext(data -> printInfo(String.valueOf(data)));

        emitStart.subscribe(new DebugSubscriber<>("delay"));

        Thread.sleep(10000);
    }

    private static void printInfo(String data) {
        long currentTime = System.currentTimeMillis();
        String threadName = Thread.currentThread().getName();

        System.out.println(threadName + " " + currentTime + " : " + data);
    }

}
