package rxjava.lambda.ch3;

import io.reactivex.Flowable;
import io.reactivex.subscribers.ResourceSubscriber;

import java.util.concurrent.TimeUnit;

public class NonMainThreadSample {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("start");

        Flowable.interval(1000L, TimeUnit.MILLISECONDS)
                .subscribe(new ResourceSubscriber<Long>() {
                    @Override
                    public void onNext(Long data) {
                        String threadName = Thread.currentThread().getName();
                        System.out.println(threadName + " " + data);
                    }

                    @Override
                    public void onError(Throwable t) {
                        t.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        String threadName = Thread.currentThread().getName();
                        System.out.println(threadName + " data emit end");
                    }
                });

        System.out.println("end");
        Thread.sleep(5000);
    }
}
