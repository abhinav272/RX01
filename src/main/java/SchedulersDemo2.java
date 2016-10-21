import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by abhinav.sharma on 10/21/2016.
 */
public class SchedulersDemo2 {
    public static void main(String[] args) throws InterruptedException {
        /*
        * Looks like range is Cold Observable
        */
        Observable<Integer> observable = Observable.range(1, 10);

        observable.map(i -> i * 10)
                .doOnNext(integer -> {
                    System.out.println(integer + " on " + Thread.currentThread().getName());
                })
                .observeOn(Schedulers.computation())
                .subscribe(integer -> System.out.println(integer + " Yo Printing on " + Thread.currentThread().getName()));

        Thread.sleep(1000);
    }
}
