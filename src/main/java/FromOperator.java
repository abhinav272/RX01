import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import rx.functions.Func2;

import java.util.ArrayList;

/**
 * Created by abhinav.sharma on 10/15/2016.
 */
public class FromOperator {
    private ArrayList<String> al;
    private Integer[] integers;
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

    private Integer[] getIntegerArray() {
        return integers = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
    }

    private void startListeningStrings(Observable observable, Subscriber<String> subscriber){
        /*observable.filter(new Func1<String, Boolean>() {
                    @Override
                    public Boolean call(String s) {
                        return (s.contains("animals") || s.contains(".."));
                    }
                })
                .subscribe(subscriber);

        observable.scan(new Func2<String, String, String>(){
            @Override
            public String call(String s, String s2) {
                return s+s2;
            }
        }).subscribe(subscriber);*/


        observable.filter(new Func1<String, Boolean>() {
            @Override
            public Boolean call(String s) {
                return (s.contains("animals") || s.contains(".."));
            }
        }).scan(new Func2<String, String, String>() {
            int i=0;
            @Override
            public String call(String s, String s2) {
//                System.out.println(i);
//                i++;
//                System.out.println(s);
//                System.out.println(s2);
//                return "Custom Text";
                return s+s2;
            }
        }).subscribe(subscriber);

    }

    private void startListeningIntegers(Observable observable, Subscriber<Integer> subscriber){
        observable.scan(new Func2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer integer, Integer integer2) {
                return integer+integer2;
            }
        });
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

        fromOperator.startListeningStrings(fromOperator.observableFromArrayList, fromOperator.subscriber);
    }
}
