package rxjava.lambda.ch4_2;

import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

import java.util.Map;

public class ToMapSample {

    public static void main(String[] args) {
        Single<Map<Object, String>> flowable = Flowable.just("A1", "A2", "A1")
                                                        .toMap(s -> s);

        flowable.subscribe(new SingleObserver<Map<Object, String>>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("On Subscribe " + d.isDisposed());
            }

            @Override
            public void onSuccess(Map<Object, String> objectStringMap) {
                objectStringMap.forEach((o, s) -> System.out.println(o + " " + s));
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }
        });





    }
}
