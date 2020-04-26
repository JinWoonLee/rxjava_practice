package rxjava.lambda.ch4_6;

import io.reactivex.Flowable;
import io.reactivex.Single;
import rxjava.lambda.ch4_2.DebugSingleOperator;

public class ReduceSample {

    public static void main(String[] args) {
        Single<Integer> reduce = Flowable.range(10, 10)
                .reduce(0, (sum, data) -> sum + data);

        reduce.subscribe(new DebugSingleOperator<>());
    }
}
