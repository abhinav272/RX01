import rx.Observable;
import rx.functions.Action1;
import rx.functions.Action2;

/**
 * Created by abhinav.sharma on 10/14/2016.
 */
public class JustOperator {

    private Observable<String> myObservable;
    private Action1<String> customNextAction1;
    private Action2<String, String> customNextAction2;

    public static void main(String[] args) {
        JustOperator justOperator = new JustOperator();

        justOperator.myObservable = Observable.just("Just operator observable");
//        justOperator.myObservable = Observable.just("Just 2", "Yo its working..!!");
        justOperator.customNextAction1 = new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println(s + " From action1");
            }
        };
        justOperator.customNextAction2 = new Action2<String, String>() {
            @Override
            public void call(String s, String s2) {
                System.out.println(s + "From action2");
                System.out.println(s2 + "From action2");
            }
        };

        justOperator.myObservable.subscribe(justOperator.customNextAction1);

    }
}
