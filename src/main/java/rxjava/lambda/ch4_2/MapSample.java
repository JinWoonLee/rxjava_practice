package rxjava.lambda.ch4_2;

import io.reactivex.Flowable;
import rxjava.lambda.ch4.DebugSubscriber;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MapSample {

    private final static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd HHmmss");

    public static void main(String[] args) {
        Flowable<String> flowable = Flowable.fromCallable(LocalDateTime::now)
                .map(dateTimeFormatter::format);

        flowable.subscribe(new DebugSubscriber<>("map"));
    }
}
