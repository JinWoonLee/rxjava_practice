package rxjava.lambda.ch4_2;

import io.reactivex.Flowable;
import rxjava.lambda.ch4.DebugSubscriber;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class ConcatMapSample {

    public static void main(String[] args) throws InterruptedException {
        Flowable flowable = Flowable.range(10, 3)
                                    .concatMap(sourceData ->
                                        Flowable.interval(500L, TimeUnit.MILLISECONDS)
                                                .take(2)
                                                .map(data -> {
                                                    //String dateTime = DateTimeFormatter.ofPattern("yyyyMMdd HHmmss").format(LocalDateTime.now());
                                                    String dateTime = String.valueOf(System.currentTimeMillis());
                                                    return dateTime + " [" + sourceData + "]" + data;
                                                })
                                    );

        flowable.subscribe(new DebugSubscriber("concatMap"));

        Thread.sleep(8000L);
    }
}
