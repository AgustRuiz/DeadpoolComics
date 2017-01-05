package es.agustruiz.deadpoolcomics.presentation.view.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import es.agustruiz.deadpoolcomics.App;
import es.agustruiz.deadpoolcomics.presentation.di.component.ApplicationComponent;
import es.agustruiz.deadpoolcomics.presentation.di.module.ActivityModule;
import es.agustruiz.deadpoolcomics.presentation.navigator.Navigator;
import es.agustruiz.deadpoolcomics.presentation.view.fragment.BaseFragment;

public abstract class BaseActivity extends AppCompatActivity {

    @Inject
    Navigator navigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getApplicationComponent().inject(this);
    }

    protected void addFragment(int containerViewId, BaseFragment baseFragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(containerViewId, baseFragment);
        fragmentTransaction.commit();

    }

    protected ApplicationComponent getApplicationComponent() {
        return ((App) getApplication()).getApplicationComponent();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

}
