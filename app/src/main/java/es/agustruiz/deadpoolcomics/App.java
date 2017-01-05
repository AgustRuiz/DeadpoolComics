package es.agustruiz.deadpoolcomics;

import android.app.Application;

import es.agustruiz.deadpoolcomics.presentation.di.component.ApplicationComponent;
import es.agustruiz.deadpoolcomics.presentation.di.component.DaggerApplicationComponent;
import es.agustruiz.deadpoolcomics.presentation.di.module.ApplicationModule;

public class App extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.initializeInjector();
    }

    private void initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }

}
