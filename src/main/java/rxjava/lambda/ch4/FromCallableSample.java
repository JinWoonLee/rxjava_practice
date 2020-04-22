package rxjava.lambda.ch4;

import io.reactivex.Flowable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FromCallableSample {

    public static void main(String[] args) {
        Flowable<String> flowable = Flowable.fromCallable(() -> {
            String now = DateTimeFormatter.ofPattern("yyyyMMdd HHmmss").format(LocalDateTime.now());
            Thread.sleep(1000);
            return now;
        });
        String now = DateTimeFormatter.ofPattern("yyyyMMdd HHmmss").format(LocalDateTime.now());
        System.out.println(now);
        flowable.subscribe(new DebugSubscriber<>("fromCallable"));
    }
}
