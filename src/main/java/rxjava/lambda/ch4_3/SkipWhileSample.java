package rxjava.lambda.ch4_3;

import io.reactivex.Flowable;
import rxjava.lambda.ch4.DebugSubscriber;

public class SkipWhileSample {

    public static void main(String[] args) {
        Flowable<Integer> flowable = Flowable.fromArray(2, 1, 3)
                .skipWhile(data -> data != 3);

        flowable.subscribe(new DebugSubscriber<>("skipWhile"));

    }
}
