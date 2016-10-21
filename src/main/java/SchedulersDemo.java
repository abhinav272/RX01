import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * Created by abhinav.sharma on 10/20/2016.
 */
public class SchedulersDemo {
    public static void main(String[] args) {
        Observable source = Observable.just("Hello", "Animals", "Mama");
        //noinspection unchecked
        Observable length = source.map(new Func1<String, Integer>() {
            @Override
            public Integer call(String s) {
                return s.length();
            }
        });

        length.subscribe(o -> System.out.println("Length is : "+o));
    }
}
