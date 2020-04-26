package rxjava.lambda.ch5;

import io.reactivex.processors.UnicastProcessor;
import rxjava.lambda.ch4.DebugSubscriber;

public class UnicastProcessorSample {

    public static void main(String[] args) {
        UnicastProcessor<Integer> unicastProcessor = UnicastProcessor.create();

        unicastProcessor.onNext(1);
        unicastProcessor.onNext(2);

        DebugSubscriber<Integer> no1 = new DebugSubscriber<>("No1");
        unicastProcessor.subscribe(no1);

        unicastProcessor.onNext(3);
        unicastProcessor.subscribe(new DebugSubscriber<>("No2"));

        unicastProcessor.onComplete();

    }
}
