package rxjava.lambda.ch5;

import io.reactivex.processors.PublishProcessor;
import rxjava.lambda.ch4.DebugSubscriber;

public class PublishProcessorSample {

    public static void main(String[] args) {
        PublishProcessor<Integer> publishProcessor = PublishProcessor.create();

        publishProcessor.subscribe(new DebugSubscriber<>("No 1"));
        publishProcessor.onNext(1);
        publishProcessor.onNext(2);
        publishProcessor.onNext(3);

        publishProcessor.subscribe(new DebugSubscriber<>("No 2"));
        publishProcessor.onNext(4);
        publishProcessor.onNext(5);

        publishProcessor.onComplete();

        publishProcessor.subscribe(new DebugSubscriber<>("No 3"));
    }
}
