package rxjava.lambda.ch4_3;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;

public class ElementAtSample {

    public static void main(String[] args) throws InterruptedException {
        Maybe<Integer> maybe = Flowable.range(10, 50)
                                    .elementAt(10);

        maybe.subscribe(new MaybeObserver<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(Integer integer) {
                System.out.println("value : " + integer);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        });


        Thread.sleep(5000);
    }
}
