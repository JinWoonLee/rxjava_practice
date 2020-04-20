package rxjava.lambda.ch3;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

public class SubscribeOnSample {

    public static void main(String[] args) throws InterruptedException {
        Flowable.just(1, 2, 3)
                .subscribeOn(Schedulers.io()) // RxCachedThreadScheduler
                .subscribeOn(Schedulers.single()) //RxSingleScheduler
                .subscribeOn(Schedulers.computation()) //RxComputationThreadPool
                .subscribe(data -> {
                    String threadName = Thread.currentThread().getName();
                    System.out.println(threadName + " : " + data);
                });

        Thread.sleep(5000);
    }
}
