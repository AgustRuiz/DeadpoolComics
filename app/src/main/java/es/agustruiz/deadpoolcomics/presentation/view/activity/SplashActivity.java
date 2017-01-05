package es.agustruiz.deadpoolcomics.presentation.view.activity;

import android.os.Bundle;
import android.util.Log;

import es.agustruiz.deadpoolcomics.R;
import es.agustruiz.deadpoolcomics.Utils;

public class SplashActivity extends BaseActivity {

    private static final String LOG_TAG = SplashActivity.class.getSimpleName() + Utils.AGUST_TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        navigator.goToComicList(this);
        finish();
    }
}
