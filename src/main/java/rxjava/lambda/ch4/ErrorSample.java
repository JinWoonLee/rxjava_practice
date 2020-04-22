package rxjava.lambda.ch4;

import io.reactivex.Flowable;

public class ErrorSample {

    public static void main(String[] args) {
        Flowable flowable = Flowable.error(new RuntimeException("error occur"));

        flowable.subscribe(new DebugSubscriber("error"));
    }

}
