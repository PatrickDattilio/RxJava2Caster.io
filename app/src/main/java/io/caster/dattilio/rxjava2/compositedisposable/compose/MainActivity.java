package io.caster.dattilio.rxjava2.compositedisposable.compose;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import io.caster.dattilio.rxjava2.R;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {

  CompositeDisposable compositeDisposable;
  Disposable disposable1;
  Disposable disposable2;
  Disposable disposable3;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    compositeDisposable = new CompositeDisposable();
  }

  @Override
  protected void onStart() {
    super.onStart();
    compositeDisposable.addAll(
        Observable.just(1, 2, 3).subscribe(),
        Observable.just(4, 5, 6).subscribe(),
        Observable.just(7, 8, 9).subscribe());
  }

  @Override
  protected void onStop() {
    super.onStop();
    disposable1.dispose();
    disposable2.dispose();
    disposable3.dispose();
  }
}
