package es.agustruiz.deadpoolcomics.data.repository.datasource;

import java.util.Collection;

import es.agustruiz.deadpoolcomics.data.model.marvel.ComicResultMarvel;

public interface ComicDataStore {

    void getComicResultMarvelList(final int limit, final int offset,
                                  ComicListCallback comicListCallback);

    interface ComicListCallback {
        void onComicListLoaded(Collection<ComicResultMarvel> collection);
        void onError(Exception exception);
    }

}
