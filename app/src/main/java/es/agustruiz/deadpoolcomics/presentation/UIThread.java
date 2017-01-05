package es.agustruiz.deadpoolcomics.presentation;

import android.os.Handler;
import android.os.Looper;

import javax.inject.Inject;
import javax.inject.Singleton;

import es.agustruiz.deadpoolcomics.domain.executor.PostExecutionThread;

@Singleton
public class UIThread implements PostExecutionThread {

    private final Handler mHandler;

    @Inject
    public UIThread() {
        mHandler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void post(Runnable runnable) {
        mHandler.post(runnable);
    }
}
