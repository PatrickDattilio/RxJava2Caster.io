package io.caster.dattilio.rxjava2.compose;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.annotations.NonNull;

public class Example1 {

    public void example(){
        Observable.just(0,1,2,3).compose(new ObservableTransformer<Integer, Integer>() {
            @Override
            public ObservableSource<Integer> apply(@NonNull Observable<Integer> upstream) {
                return null;
            }
        });
    }
}
