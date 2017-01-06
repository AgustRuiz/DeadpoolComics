package es.agustruiz.deadpoolcomics.data.repository.datasource;

import android.content.Context;

import javax.inject.Inject;
import javax.inject.Singleton;

import es.agustruiz.deadpoolcomics.data.internet.MarvelApi;

@Singleton
public class ComicDataStoreFactory {

    private final Context mContext;

    @Inject
    public ComicDataStoreFactory(Context context){
        if(context == null){
            throw new IllegalArgumentException("Constructor parameter cannot be null");
        }
        mContext = context;
    }

    public ComicDataStore create(){
        ComicDataStore comicDataStore;
        comicDataStore = createCloudDataStore();
        return comicDataStore;
    }

    public ComicDataStore createCloudDataStore(){
        MarvelApi marvelApi = new MarvelApi(this.mContext);
        return new CloudComicDataStore(marvelApi);
    }

}
