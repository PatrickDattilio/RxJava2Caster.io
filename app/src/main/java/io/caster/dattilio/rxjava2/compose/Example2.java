package io.caster.dattilio.rxjava2.compose;

import io.reactivex.CompletableTransformer;
import io.reactivex.FlowableTransformer;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.SingleTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class Example2 {

  Api api;

  public void example() {
    api.makeRequest()
        .compose(getData())
        .compose(processOtherDataOnMain())
        .subscribe();
    new CompletableTransformer()
        new FlowableTransformer<>()
new SingleTransformer<>()
    new CompletableTransformer()
        new MaybeTransformer

    api.makeOtherRequest()
        .compose(getData())
        .subscribe();

    api.makeOneMoreRequest()
        .compose(getData())
        .compose(processOtherDataOnMain())
        .subscribe();
  }

  public ObservableTransformer<Data,OtherData> processOtherDataOnMain(){
    return new ObservableTransformer<Data, OtherData>() {
      @Override
      public ObservableSource<OtherData> apply(@NonNull Observable<Data> upstream) {
        return upstream.map(new Function<Data, OtherData>() {
          @Override
          public OtherData apply(@NonNull Data data) throws Exception {
            return new OtherData(data);
          }
        })
                   .observeOn(AndroidSchedulers.mainThread());
      }
    };

  }
  public ObservableTransformer<ApiResponse,Data> getData() {
    return new ObservableTransformer<ApiResponse, Data>() {
      @Override
      public ObservableSource<Data> apply(@NonNull Observable<ApiResponse> upstream) {
        return upstream.map(new Function<ApiResponse, Data>() {
          @Override
          public Data apply(@NonNull ApiResponse apiResponse) throws Exception {
            return apiResponse.data;
          }
        })
                   .observeOn(Schedulers.io());
      }
    };

  }
}
