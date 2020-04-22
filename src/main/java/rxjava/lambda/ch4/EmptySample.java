package rxjava.lambda.ch4;

import io.reactivex.Flowable;

public class EmptySample {

    public static void main(String[] args) {
        Flowable<Object> objectFlowable = Flowable.just(1, 2, 3)
                .map(String::valueOf)
                .flatMap(numStr -> Flowable.empty());

        objectFlowable.subscribe(new DebugSubscriber<>("empty"));
    }
}
