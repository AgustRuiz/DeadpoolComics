package es.agustruiz.deadpoolcomics.data.repository;

import java.util.Collection;

import javax.inject.Inject;
import javax.inject.Singleton;

import es.agustruiz.deadpoolcomics.data.exception.RepositoryErrorBundle;
import es.agustruiz.deadpoolcomics.data.model.mapper.ComicMapper;
import es.agustruiz.deadpoolcomics.data.model.marvel.ComicResultMarvel;
import es.agustruiz.deadpoolcomics.data.repository.datasource.ComicDataStore;
import es.agustruiz.deadpoolcomics.data.repository.datasource.ComicDataStoreFactory;
import es.agustruiz.deadpoolcomics.domain.repository.ComicDomainRepository;

@Singleton
public class ComicDataRepository implements ComicDomainRepository {

    private final ComicDataStoreFactory mComicDataStoreFactory;
    private final ComicMapper mComicMapper;

    @Inject
    public ComicDataRepository(ComicDataStoreFactory comicDataStoreFactory,
                               ComicMapper comicMapper) {
        mComicDataStoreFactory = comicDataStoreFactory;
        mComicMapper = comicMapper;
    }

    //region [ComicDomainRepository methods]
    @Override
    public void getComicList(final ComicListCallback comicListCallback) {
        final ComicDataStore comicDataStore = mComicDataStoreFactory.create();
        comicDataStore.getComicResultMarvelList(new ComicDataStore.ComicListCallback() {
            @Override
            public void onComicListLoaded(Collection<ComicResultMarvel> collection) {
                comicListCallback.onComicListLoaded(mComicMapper.mapComicMarvelToComic(collection));
            }

            @Override
            public void onError(Exception exception) {
                comicListCallback.onError(new RepositoryErrorBundle(exception));
            }
        });
    }
    //endregion

}
