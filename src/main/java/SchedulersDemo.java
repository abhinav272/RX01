import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by abhinav.sharma on 10/20/2016.
 */
public class SchedulersDemo {
    public static void main(String[] args) {
        Observable source = Observable.just("Hello", "Animals", "Mama");
        //noinspection unchecked
        Observable length = source
                .map(new Func1<String, Integer>() {
                    @Override
                    public Integer call(String s) {
                        System.out.println("The current thread is : " + Thread.currentThread().getName());
                        return s.length();
                    }
                })
                .subscribeOn(Schedulers.computation())
                .observeOn(Schedulers.newThread());

        length.subscribe(o -> System.out.println("Length is : " + o + " " + Thread.currentThread().getName()));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /*
        * Since emissions is made from Compution thread subscriber does not
        * get chance to catch the emissions, Hence sleep is invoked for 2 seconds
        */
    }
}
