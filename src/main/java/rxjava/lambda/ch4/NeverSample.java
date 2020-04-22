package rxjava.lambda.ch4;

import io.reactivex.Flowable;

public class NeverSample {

    public static void main(String[] args) {
        Flowable flowable = Flowable.never();

        flowable.subscribe(new DebugSubscriber("never"));
    }

}
