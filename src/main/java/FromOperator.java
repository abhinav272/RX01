import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

import java.util.ArrayList;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * Created by abhinav.sharma on 10/15/2016.
 */
public class FromOperator {
    private ArrayList<String> al;
    private Observable observableFromArrayList;
    private Subscriber<String> subscriber;

    private ArrayList<String> getAl() {
        al = new ArrayList();
        al.add("Hellow..");
        al.add("from ");
        al.add("the ");
        al.add("other side.. ");
        al.add("Baby ");
        al.add("I don't ");
        al.add("need ");
        al.add("$ bills ");
        al.add("to ");
        al.add("have fun ");
        al.add("tonight..!!");
        al.add("Baby ");
        al.add("Iam ");
        al.add("preying ");
        al.add("on you tonight ");
        al.add("Hunt you ");
        al.add("down ");
        al.add("eat you alive ");
        al.add("Just ");
        al.add("like animals, ");
        al.add("animals, ");
        al.add("like animals, ");
        return al;
    }

    private void startListening(Observable observable, Subscriber<String> subscriber){
        observable.filter(new Func1<String, Boolean>() {
                    @Override
                    public Boolean call(String s) {
                        return (s.contains("animals") || s.contains(".."));
                    }
                })
                .subscribe(subscriber);

    }

    public static void main(String[] args) {
        FromOperator fromOperator = new FromOperator();

        fromOperator.observableFromArrayList = Observable.from(fromOperator.getAl());
        fromOperator.subscriber = new Subscriber() {
            @Override
            public void onCompleted() {
                System.out.println("Complete");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("error");
                e.printStackTrace();
            }

            @Override
            public void onNext(Object s) {
                System.out.println(s);
            }
        };

        fromOperator.startListening(fromOperator.observableFromArrayList, fromOperator.subscriber);
    }
}
