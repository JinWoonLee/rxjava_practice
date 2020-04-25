package rxjava.lambda.ch4_2;

import io.reactivex.Flowable;
import rxjava.lambda.ch4.DebugSubscriber;

public class FlatMapSample1 {

    public static void main(String[] args) {
        Flowable<String> flowable = Flowable.just("A", "B", "", "C")
                .flatMap(data -> {
                    if (data.equals("")) {
                        return Flowable.empty();
                    } else {
                        return Flowable.just(data.toLowerCase());
                    }
                });

        flowable.subscribe(new DebugSubscriber<>("flatMap1"));
    }

}
