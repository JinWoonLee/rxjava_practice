package rxjava.lambda.ch3;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;

import java.util.concurrent.TimeUnit;

public class ObserveOnSample {

    public static void main(String[] args) throws InterruptedException {
        Flowable.interval(300L, TimeUnit.MILLISECONDS)
                .onBackpressureDrop()
                .observeOn(Schedulers.computation(), false, 1)
                .subscribe(new ResourceSubscriber<Long>() {
                    @Override
                    public void onNext(Long data) {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            System.exit(1);
                        }
                        String threadName = Thread.currentThread().getName();
                        String threadGroup = Thread.currentThread().getThreadGroup().getName();

                        System.out.println(threadGroup + " " + threadName + " " + data);
                    }

                    @Override
                    public void onError(Throwable t) {
                        t.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete called");
                    }
                });

        Thread.sleep(6000);
    }
}
