package rxjava.lambda.ch3;

import io.reactivex.Flowable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class ConcatMapEager {

    public static void main(String[] args) throws InterruptedException {
        Flowable<String> flowable = Flowable.just("A", "B", "C")
                .concatMapEager(strData -> {
                    String threadName = Thread.currentThread().getName();
                    String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd HHmmss SSS"));
                    System.out.println(threadName + " " + dateTime + " " + strData);
                    return Flowable.just(strData).delay(1000, TimeUnit.MILLISECONDS);
                });

        flowable.subscribe(concatMapEagerStr -> {
           String threadName = Thread.currentThread().getName();
           String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd HHmmss SSS"));
            System.out.println(threadName + " " + dateTime + " " + concatMapEagerStr);
        });

        Thread.sleep(5000);
    }
}
