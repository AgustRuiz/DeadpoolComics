package es.agustruiz.deadpoolcomics.presentation.di.module;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import es.agustruiz.deadpoolcomics.data.executor.JobExecutor;
import es.agustruiz.deadpoolcomics.data.repository.ComicDataRepository;
import es.agustruiz.deadpoolcomics.domain.executor.PostExecutionThread;
import es.agustruiz.deadpoolcomics.domain.executor.ThreadExecutor;
import es.agustruiz.deadpoolcomics.domain.repository.ComicDomainRepository;
import es.agustruiz.deadpoolcomics.App;
import es.agustruiz.deadpoolcomics.presentation.UIThread;
import es.agustruiz.deadpoolcomics.presentation.navigator.Navigator;
import es.agustruiz.deadpoolcomics.presentation.presenter.ComicListPresenter;

@Module
public class ApplicationModule {

    private final App mApp;

    public ApplicationModule(App app) {
        mApp = app;
    }

    @Provides
    @Singleton
    Context provideApplicationContext(){
        return mApp.getApplicationContext();
    }

    @Provides
    @Singleton
    Navigator provideNavigator(){
        return new Navigator();
    }

    @Provides
    @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides
    @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }

    @Provides
    @Singleton
    ComicDomainRepository provideComicDomainRepository(ComicDataRepository comicDataRepository) {
        return comicDataRepository;
    }

}
