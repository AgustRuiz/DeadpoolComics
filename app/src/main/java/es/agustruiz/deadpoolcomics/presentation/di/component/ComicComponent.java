package es.agustruiz.deadpoolcomics.presentation.di.component;

import dagger.Component;
import es.agustruiz.deadpoolcomics.presentation.di.module.ActivityModule;
import es.agustruiz.deadpoolcomics.presentation.di.module.ComicModule;
import es.agustruiz.deadpoolcomics.presentation.di.scope.PerActivityScope;
import es.agustruiz.deadpoolcomics.presentation.view.fragment.ComicDetailsFragment;
import es.agustruiz.deadpoolcomics.presentation.view.fragment.ComicListFragment;

@PerActivityScope
@Component(
        dependencies = ApplicationComponent.class,
        modules = {ActivityModule.class, ComicModule.class}
)
public interface ComicComponent extends ActivityComponent {

    void inject(ComicListFragment fragment);

    void inject(ComicDetailsFragment fragment);

}
