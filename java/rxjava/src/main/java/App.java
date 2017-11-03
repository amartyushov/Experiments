import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class App {
    public String getGreeting() {
        return "Hello world.";
    }

    public static void main(String[] args) {
        fakeUserInput()
                .observeOn(Schedulers.trampoline())
                .flatMapMaybe(x -> RxFibonacci.fibs().elementAt(x))
                .blockingSubscribe(s -> System.out.println(s));
    }

    public static Observable<Long> fakeUserInput() {
        Random random = new Random();
        return Observable.intervalRange(0, 20, 500, 500, TimeUnit.MILLISECONDS);
    }
}
