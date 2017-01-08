package es.agustruiz.deadpoolcomics.data.repository;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import es.agustruiz.deadpoolcomics.data.exception.RepositoryErrorBundle;
import es.agustruiz.deadpoolcomics.data.model.mapper.ComicMapper;
import es.agustruiz.deadpoolcomics.data.model.marvel.ComicResultMarvel;
import es.agustruiz.deadpoolcomics.data.repository.datasource.ComicDataStore;
import es.agustruiz.deadpoolcomics.data.repository.datasource.ComicDataStoreFactory;
import es.agustruiz.deadpoolcomics.domain.model.ComicDomain;
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
    public void getComicList(final int limit, final int offset, final ComicListCallback comicListCallback) {
        final ComicDataStore comicDataStore = mComicDataStoreFactory.create();
        comicDataStore.getComicResultMarvelList(limit, offset,
                new ComicDataStore.ComicListCallback() {
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

    @Override
    public void getComicDetails(int comicId, final ComicDetailsCallback comicDetailsCallback) {
        final ComicDataStore comicDataStore = mComicDataStoreFactory.create();
        comicDataStore.getComicResultMarvelById(comicId, new ComicDataStore.ComicDetailsCallback() {
            @Override
            public void onComicDetailsLoaded(Collection<ComicResultMarvel> comicDomain) {
                List<ComicDomain> mapped = mComicMapper.mapComicMarvelToComic(comicDomain);
                if (mapped!=null && mapped.size()>0){
                    comicDetailsCallback.onComicDetailsLoaded(mapped.get(0));
                }else{
                    comicDetailsCallback.onError(
                            new RepositoryErrorBundle(new Exception("No results")));
                }
            }

            @Override
            public void onError(Exception exception) {
                comicDetailsCallback.onError(new RepositoryErrorBundle(exception));
            }
        });
    }

    //endregion

}
