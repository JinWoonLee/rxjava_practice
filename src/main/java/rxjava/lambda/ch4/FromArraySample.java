package rxjava.lambda.ch4;

import io.reactivex.Flowable;

public class FromArraySample {

    public static void main(String[] args) {
        Flowable flowable = Flowable.fromArray(1, 2, 3, 4, 5, 6);

        flowable.subscribe(new DebugSubscriber("fromArray"));
    }
}
