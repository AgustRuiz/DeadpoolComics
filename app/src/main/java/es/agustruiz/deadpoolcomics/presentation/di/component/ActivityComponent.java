package es.agustruiz.deadpoolcomics.presentation.di.component;

import dagger.Component;
import es.agustruiz.deadpoolcomics.presentation.di.module.ActivityModule;
import es.agustruiz.deadpoolcomics.presentation.di.scope.PerActivityScope;
import es.agustruiz.deadpoolcomics.presentation.view.activity.BaseActivity;

@PerActivityScope
@Component(
        dependencies = ApplicationComponent.class,
        modules = ActivityModule.class
)
public interface ActivityComponent {
    BaseActivity activity();
}
