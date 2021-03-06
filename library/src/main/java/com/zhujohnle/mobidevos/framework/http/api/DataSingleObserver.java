package com.zhujohnle.mobidevos.framework.http.api;

import android.app.Dialog;

import com.zhujohnle.mobidevos.utils.ToastUtils;

import io.reactivex.disposables.Disposable;

/**
 * Created by Allen on 2017/10/31.
 *
 * @author Allen
 *         <p>
 *         针对特定格式的时候设置的通用的Observer
 *         用户可以根据自己需求自定义自己的类继承BaseDataObserver<T>即可
 *         适用于

 */

public abstract class DataSingleObserver<T> extends BaseSingleDataObserver<T> {

    private Dialog mProgressDialog;
    private Disposable disposable;

    public DataSingleObserver() {
    }

    public DataSingleObserver(Dialog progressDialog) {
        mProgressDialog = progressDialog;
    }

    /**
     * 失败回调
     *
     * @param errorMsg 错误信息
     */
    protected abstract void onError(String errorMsg);

    /**
     * 成功回调
     *
     * @param结果
     */
  /*  protected abstract void onSuccess(T data);*/

    @Override
    public void doOnSubscribe(Disposable d) {
        disposable = d;
    }



    @Override
    public void doOnError(String errorMsg) {

        dismissLoading();
        if (!isHideToast()) {
            ToastUtils.showLong(errorMsg);
        }
        onError(errorMsg);
    }

    @Override
    public void doOnNext(T responseBean) {

    }

    @Override
    public void doOnCompleted() {
        dismissLoading();
    }

    /**
     * 隐藏loading对话框
     */
    private void dismissLoading() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
    }
}
