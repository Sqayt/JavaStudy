package ru.ivanovds.threads.rx;

import io.reactivex.rxjava3.core.Observable;

import java.util.Arrays;
import java.util.List;

public class MyRXJava {
    public static void main(String[] args) {
//        createObservableWithJust();
//        createObservableFromIterable();
        createObservableUsingCreate();
    }

    private static void createObservableWithJust() {
        Observable<Integer> observable = Observable.just(1, 2, 3, 4, 5);

        observable.subscribe(System.out::println);
    }

    private static void createObservableFromIterable() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Observable<Integer> observable = Observable.fromIterable(list);

        observable.subscribe(System.out::println);
    }

    private static void createObservableUsingCreate() {
        Observable<Integer> observable = Observable.create(emitter -> {
            for (int i = 1; i <= 5; i++) {
                emitter.onNext(i);
            }
            emitter.onNext(null);
            emitter.onComplete();
        });
        observable.subscribe(System.out::println,
                error -> System.out.println("There was error: " + error.getLocalizedMessage()),
                () -> System.out.println("Completed"));
    }
}
