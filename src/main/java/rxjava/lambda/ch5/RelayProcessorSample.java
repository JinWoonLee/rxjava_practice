package rxjava.lambda.ch5;

import io.reactivex.processors.ReplayProcessor;
import rxjava.lambda.ch4.DebugSubscriber;

public class RelayProcessorSample {

    public static void main(String[] args) {
        ReplayProcessor<Integer> replayProcessor = ReplayProcessor.create();

        replayProcessor.onNext(1);

        replayProcessor.subscribe(new DebugSubscriber<>("No1"));
        replayProcessor.onNext(2);
        replayProcessor.onNext(3);

        replayProcessor.subscribe(new DebugSubscriber<>("No3"));
        replayProcessor.onNext(4);

        replayProcessor.onComplete();
        replayProcessor.subscribe(new DebugSubscriber<>("No4"));
    }
}
