package rxjava.lambda.ch4_2;

import io.reactivex.Flowable;
import rxjava.lambda.ch4.DebugSubscriber;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BufferSample {

    public static void main(String[] args) throws InterruptedException {
        Flowable<String> flowable = Flowable.interval(100L, TimeUnit.MILLISECONDS)
                                    .take(10)
                                    .buffer(3)
                                    .map(dataList -> DateTimeFormatter.ofPattern("HHmmss").format(LocalTime.now()) + " " + dataList);

        flowable.subscribe(new DebugSubscriber<>("buffer"));

        Thread.sleep(5000);
    }

}
