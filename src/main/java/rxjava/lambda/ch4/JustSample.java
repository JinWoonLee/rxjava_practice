package rxjava.lambda.ch4;

import io.reactivex.Flowable;

public class JustSample {

    public static void main(String[] args) {
        Flowable<Integer> flowable = Flowable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        flowable.subscribe(new DebugSubscriber<>("just"));
    }
}
