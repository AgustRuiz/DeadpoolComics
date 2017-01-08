package es.agustruiz.deadpoolcomics.domain.interactor;

import es.agustruiz.deadpoolcomics.domain.exception.ErrorBundle;
import es.agustruiz.deadpoolcomics.domain.model.ComicDomain;

public interface GetComicDetailsUseCase extends Interactor {

    interface Callback{
        void onComicDataLoaded(ComicDomain comicDomain);
        void onError(ErrorBundle errorBundle);
    }

    void execute(int comicId, Callback callback);

}
