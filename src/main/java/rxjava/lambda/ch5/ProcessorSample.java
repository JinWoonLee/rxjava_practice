package rxjava.lambda.ch5;

import io.reactivex.processors.PublishProcessor;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class ProcessorSample {

    public static void main(String[] args) {
        PublishProcessor<Integer> publishProcessor = PublishProcessor.create();

        publishProcessor.subscribe(new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription s) {
                s.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("onNext : " + integer);
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("onError : " + t.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        });

        publishProcessor.onNext(1);
        publishProcessor.onNext(2);
        publishProcessor.onNext(3);
    }

}
