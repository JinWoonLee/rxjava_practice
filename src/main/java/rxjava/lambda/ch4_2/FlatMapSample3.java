package rxjava.lambda.ch4_2;

import io.reactivex.Flowable;
import rxjava.lambda.ch4.DebugSubscriber;

public class FlatMapSample3 {

    public static void main(String[] args) {
        Flowable<Integer> flowable = Flowable.just(5, 3, 2, 0, 2, 4)
                .flatMap(
                        data -> Flowable.just(10 / data),
                        error -> Flowable.just(-1),
                        () -> Flowable.just(100)
                );

        flowable.subscribe(new DebugSubscriber<>("flatMap"));

    }
}
