package rxjava.lambda.ch5;

import io.reactivex.processors.BehaviorProcessor;
import rxjava.lambda.ch4.DebugSubscriber;

public class BehaviorProcessorSample {

    public static void main(String[] args) {
        BehaviorProcessor<Integer> behaviorProcessor = BehaviorProcessor.create();

        behaviorProcessor.subscribe(new DebugSubscriber<>("No1"));
        behaviorProcessor.onNext(1);
        behaviorProcessor.onNext(2);
        behaviorProcessor.onNext(3);

        behaviorProcessor.subscribe(new DebugSubscriber<>("No2"));
        behaviorProcessor.onNext(4);
        behaviorProcessor.onNext(5);

        behaviorProcessor.onComplete();
        behaviorProcessor.subscribe(new DebugSubscriber<>("No3"));
    }
}
