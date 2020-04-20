package rxjava.lambda.ch3;

import io.reactivex.Flowable;
import io.reactivex.subscribers.ResourceSubscriber;

public class OnErrorReturnItemSample {

    public static final int DEFAULT_ITEM = 0;

    public static void main(String[] args) {
        Flowable<Integer> flowable = Flowable.just(100, 2, 4, 0, 4, 7)
                .map(data->100/data)
                .onErrorReturnItem(DEFAULT_ITEM);

        flowable.subscribe(new ResourceSubscriber<Integer>() {
            @Override
            public void onNext(Integer integer) {
                System.out.println("data:"+integer);
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("error occur");
            }

            @Override
            public void onComplete() {
                System.out.println("completed");
            }
        });
    }

}
