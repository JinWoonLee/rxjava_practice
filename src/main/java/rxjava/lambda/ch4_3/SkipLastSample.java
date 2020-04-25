package rxjava.lambda.ch4_3;

import io.reactivex.Flowable;
import rxjava.lambda.ch4.DebugSubscriber;

public class SkipLastSample {

    public static void main(String[] args) {
        Flowable<Integer> flowable = Flowable.range(10, 3)
                .skipLast(1);

        flowable.subscribe(new DebugSubscriber<>("skip"));
    }
}
