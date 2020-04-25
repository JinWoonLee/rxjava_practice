package rxjava.lambda.ch4_3;

import io.reactivex.Flowable;
import rxjava.lambda.ch4.DebugSubscriber;

public class DistinctUntilChangedSample {

    public static void main(String[] args) {
        Flowable<String> flowable = Flowable.just("A", "B", "A", "A", "B")
                                            .distinctUntilChanged();

        flowable.subscribe(new DebugSubscriber<>("distinctUntilChanged"));
    }
}
