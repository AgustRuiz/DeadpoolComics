package es.agustruiz.deadpoolcomics.data.repository.datasource;

import es.agustruiz.deadpoolcomics.data.internet.MarvelApi;

public class CloudComicDataStore implements ComicDataStore {

    @Override
    public void getComicResultMarvelList(ComicListCallback comicListCallback) {
        MarvelApi.GetComicList(comicListCallback);
    }
}
