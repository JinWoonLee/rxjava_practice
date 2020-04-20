package rxjava.lambda.ch3;

import io.reactivex.Flowable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class ConcatMapSample {

    public static void main(String[] args) throws InterruptedException {
        Flowable<String> flowable = Flowable.just("A", "B", "C")
                .concatMap(strData -> {
                    String threadName = Thread.currentThread().getName();
                    System.out.println(threadName + " " + strData);
                    return Flowable.just(strData).delay(1000, TimeUnit.MILLISECONDS);
                });

        flowable.subscribe(concatMapData -> {
            String threadName = Thread.currentThread().getName();
            String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd hhmmss.SSS"));

            System.out.println(threadName + " " + time + " " + concatMapData);
        });

        Thread.sleep(5000);
    }
}
