package rxjava.lambda.ch4_2;

import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import rxjava.lambda.ch4.DebugSubscriber;

import java.util.List;

public class ToListSample {

    public static void main(String[] args) throws InterruptedException {
        Single<List<Integer>> toList = Flowable.just(1, 2, 3, 4)
                                                .toList();

        toList.subscribe(new SingleObserver<List<Integer>>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("disposable in");
            }

            @Override
            public void onSuccess(List<Integer> integers) {
                integers.forEach(data -> {
                    System.out.println(data);
                });

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }
        });

        Thread.sleep(3000);
    }
}
