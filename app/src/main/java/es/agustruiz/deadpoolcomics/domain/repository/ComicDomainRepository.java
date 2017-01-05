package es.agustruiz.deadpoolcomics.domain.repository;

import java.util.Collection;

import es.agustruiz.deadpoolcomics.domain.exception.ErrorBundle;
import es.agustruiz.deadpoolcomics.domain.model.ComicDomain;

public interface ComicDomainRepository {

    interface ComicListCallback {
        void onComicListLoaded(Collection<ComicDomain> comicDomainCollection);
        void onError(ErrorBundle errorBundle);
    }

    void getComicList(ComicListCallback comicListCallback);

}
