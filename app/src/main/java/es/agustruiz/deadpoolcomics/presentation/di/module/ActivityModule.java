package es.agustruiz.deadpoolcomics.presentation.di.module;

import dagger.Module;
import dagger.Provides;
import es.agustruiz.deadpoolcomics.presentation.di.scope.PerActivityScope;
import es.agustruiz.deadpoolcomics.presentation.view.activity.BaseActivity;

@Module
public class ActivityModule {

    private final BaseActivity activity;

    public ActivityModule(BaseActivity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivityScope
    BaseActivity provideBaseActivity() {
        return activity;
    }

}
