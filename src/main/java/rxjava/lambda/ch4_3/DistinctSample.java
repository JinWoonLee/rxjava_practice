package rxjava.lambda.ch4_3;

import io.reactivex.Flowable;
import rxjava.lambda.ch4.DebugSubscriber;

public class DistinctSample {

    public static void main(String[] args) {
        Flowable<String> distinct = Flowable.just("A", "a", "B", "b", "b", "A")
                .distinct(String::toLowerCase);

        distinct.subscribe(new DebugSubscriber<>("distinct"));
    }
}
