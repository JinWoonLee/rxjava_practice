package rxjava.lambda.ch4_2;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DebugSingleOperator<T> implements SingleObserver<T> {
    @Override
    public void onSubscribe(Disposable d) {
        System.out.println("Subscribe Completed" + d.isDisposed());
    }

    @Override
    public void onSuccess(T value) {
        String dateTime = DateTimeFormatter.ofPattern("yyyyMMdd HHmmss")
                .format(LocalDateTime.now());

        String threadName = Thread.currentThread().getName();

        System.out.println("[Single Operator] " + " " + threadName + " " + dateTime + " : " + value);
    }

    @Override
    public void onError(Throwable e) {
        String dateTime = DateTimeFormatter.ofPattern("yyyyMMdd HHmmss")
                .format(LocalDateTime.now());

        System.out.println("[Single Operator] " + dateTime + " : " + e.getMessage());
    }
}
