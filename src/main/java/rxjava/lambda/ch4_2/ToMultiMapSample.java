package rxjava.lambda.ch4_2;

import io.reactivex.Flowable;
import io.reactivex.Single;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ToMultiMapSample {

    public static void main(String[] args) throws InterruptedException {
        Single<Map<String, Collection<Long>>> toMultimap
                = Flowable.interval(500L, TimeUnit.MILLISECONDS)
                            .take(5)
                            .toMultimap(data -> {
                                long keySelector = data % 2;
                                if (keySelector == 0) {
                                    return "짝수";
                                } else {
                                    return "홀수";
                                }
                            });

        toMultimap.subscribe(new DebugSingleOperator<>());

        Thread.sleep(3000);
    }
}
