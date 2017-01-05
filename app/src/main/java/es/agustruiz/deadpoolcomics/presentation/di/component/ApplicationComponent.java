package es.agustruiz.deadpoolcomics.presentation.di.component;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import es.agustruiz.deadpoolcomics.domain.executor.PostExecutionThread;
import es.agustruiz.deadpoolcomics.domain.executor.ThreadExecutor;
import es.agustruiz.deadpoolcomics.domain.repository.ComicDomainRepository;
import es.agustruiz.deadpoolcomics.presentation.di.module.ApplicationModule;
import es.agustruiz.deadpoolcomics.presentation.view.activity.BaseActivity;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    void inject(BaseActivity baseActivity);

    Context context();

    ThreadExecutor threadExecutor();

    PostExecutionThread postExecutionThread();

    ComicDomainRepository comicDomainRepository();

}
