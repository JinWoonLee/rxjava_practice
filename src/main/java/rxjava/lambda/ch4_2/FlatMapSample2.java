package rxjava.lambda.ch4_2;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import rxjava.lambda.ch4.DebugSubscriber;

import java.time.LocalDate;
import java.time.LocalTime;

public class FlatMapSample2 {

    public static void main(String[] args) {
        Flowable<Object> flowable = Flowable.create(emitter -> {
            for (int i = 0; i < 3; i++) {
                emitter.onNext(LocalTime.now().toString());
                Thread.sleep(2000);
            }
        }, BackpressureStrategy.BUFFER)
                //mapper의 결과와 원본 데이터의 결과를 합해 새로운 데이터 생성
                .flatMap(time -> Flowable.just(LocalDate.now().toString() + time)
                        , (time, dateTime) -> time + dateTime);

        flowable.subscribe(new DebugSubscriber<>("flatMap2"));
    }

}
