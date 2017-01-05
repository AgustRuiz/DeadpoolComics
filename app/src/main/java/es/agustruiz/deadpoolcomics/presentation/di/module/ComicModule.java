package es.agustruiz.deadpoolcomics.presentation.di.module;

import dagger.Module;
import dagger.Provides;
import es.agustruiz.deadpoolcomics.domain.interactor.GetComicListUseCase;
import es.agustruiz.deadpoolcomics.domain.interactor.GetComicListUseCaseImpl;
import es.agustruiz.deadpoolcomics.presentation.di.scope.PerActivityScope;

@Module
public class ComicModule {

    @Provides
    @PerActivityScope
    GetComicListUseCase provideGetComicListUseCase(GetComicListUseCaseImpl getComicListUseCase){
        return getComicListUseCase;
    }

}
