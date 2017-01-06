package es.agustruiz.deadpoolcomics.domain.interactor;

import java.util.Collection;

import es.agustruiz.deadpoolcomics.domain.exception.ErrorBundle;
import es.agustruiz.deadpoolcomics.domain.model.ComicDomain;

public interface GetComicListUseCase extends Interactor {

    void execute(final int limit, final int offset, Callback callback);

    interface Callback {
        void onComicListLoaded(Collection<ComicDomain> comicDomainCollection);
        void onError(ErrorBundle errorBundle);
    }

}
