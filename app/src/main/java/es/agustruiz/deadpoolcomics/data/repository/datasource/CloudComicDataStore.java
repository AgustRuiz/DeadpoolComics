package es.agustruiz.deadpoolcomics.data.repository.datasource;

import es.agustruiz.deadpoolcomics.data.internet.MarvelApi;

public class CloudComicDataStore implements ComicDataStore {

    private final MarvelApi mMarvelApi;

    public CloudComicDataStore(MarvelApi marvelApi){
        if(marvelApi==null){
            throw new IllegalArgumentException("Constructor paremeters cannot be null");
        }
        mMarvelApi = marvelApi;
    }

    @Override
    public void getComicResultMarvelList(final int limit, final int offset, ComicListCallback comicListCallback) {
        mMarvelApi.GetComicList(limit, offset, comicListCallback);
    }
}
