package com.ecuca.immunecircle.utils;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/1/23 0023.
 */

public class RxUtils {
    /**
     * 计数
     *
     * @param count
     * @return
     */
    public static Observable<Long> countDown(int count) {
        if (count < 0) count = 0;
        final int finalCount = count;
        return Observable.interval(1, TimeUnit.SECONDS)
                .take(finalCount + 1)
                .map(aLong -> finalCount - aLong);
    }

    /**
     * .subscribeOn 指定被观察者执行的线程
     * .observeOn 指定观察者执行的线程
     * @param <T>
     * @return
     */
    public static <T> Observable.Transformer<T, T> applySchedulers() {
        return observable -> observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
