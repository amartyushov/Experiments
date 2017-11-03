import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.io.BufferedReader;

/**
 * Created by Aleksandr Martiushov.
 */
public class RxReader {

    Observable<Object> lines(BufferedReader reader){
        return Observable.create(subscriber -> {
            String line;

            while ((line = reader.readLine()) != null) {
                subscriber.onNext(line);

                if (subscriber.isDisposed()) {
                    break;
                }
            }
            subscriber.onComplete();
        }).subscribeOn(Schedulers.io());
    }
}
