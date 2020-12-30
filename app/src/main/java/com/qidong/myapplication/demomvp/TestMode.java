package com.qidong.myapplication.demomvp;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public class TestMode {
    public String name;
    public String sex;

    public Observable<String> getDataMode() {
        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("恭喜您，数据加载成功");
            }
        });
        return observable;
    }
}
