package io.caster.dattilio.rxjava2.compose;

import io.reactivex.Observable;

interface Api {

  Observable<ApiResponse> makeRequest();
  Observable<ApiResponse> makeOtherRequest();
  Observable<ApiResponse> makeOneMoreRequest();
}
