package rxjava.lambda.ch3;

import com.sun.javafx.binding.StringFormatter;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.Formatter;


@Slf4j
public class RetrySample {

    public static void main(String[] args) throws Exception {
        Flowable<Integer> flowable = Flowable.<Integer>create(emitter -> {
            System.out.println("Publisher start");

            for(int data = 1; data <=3; data++){
                if(data == 2)
                    throw new Exception("exception occur");

                emitter.onNext(data);
            }

            emitter.onComplete();
        }, BackpressureStrategy.BUFFER)
        .doOnSubscribe(subscription -> System.out.println("Publisher subscription start"))
        .retry(2);

        flowable.subscribe(new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription s) {
                System.out.println("Subscriber subscription start");
                s.request(Long.MAX_VALUE);
            }
            @Override
            public void onNext(Integer data) {
                System.out.println(StringFormatter.format("data=%s", data).get());
            }
            @Override
            public void onError(Throwable t) {
                System.out.println("Subscriber error received : " + t.getMessage());
            }
            @Override
            public void onComplete() {
                System.out.println("Subscriber Completed");
            }
        });

        Thread.sleep(5000);
    }
}
