package rxjava.lambda.ch5;

import io.reactivex.processors.AsyncProcessor;
import rxjava.lambda.ch4.DebugSubscriber;

public class AsyncProcessorSample {

    public static void main(String[] args) {
        AsyncProcessor<Object> asyncProcessor = AsyncProcessor.create();

        asyncProcessor.subscribe(new DebugSubscriber<>("No1"));

        asyncProcessor.onNext(1);
        asyncProcessor.onNext(2);

        asyncProcessor.subscribe(new DebugSubscriber<>("No2"));

        asyncProcessor.onNext(3);
        asyncProcessor.onNext(4);

        asyncProcessor.subscribe(new DebugSubscriber<>("No3"));
        asyncProcessor.onNext(5);

        asyncProcessor.onComplete();

        asyncProcessor.subscribe(new DebugSubscriber<>("No4"));
    }
}
