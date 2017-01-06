package es.agustruiz.deadpoolcomics.data.internet;

import android.content.Context;
import android.util.Log;

import javax.inject.Inject;

import es.agustruiz.deadpoolcomics.BuildConfig;
import es.agustruiz.deadpoolcomics.Utils;
import es.agustruiz.deadpoolcomics.data.exception.NetworkConnectionException;
import es.agustruiz.deadpoolcomics.data.model.mapper.ComicMapper;
import es.agustruiz.deadpoolcomics.data.model.marvel.ComicMarvel;
import es.agustruiz.deadpoolcomics.data.repository.datasource.ComicDataStore;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MarvelApi {

    private static final String LOG_TAG = Utils.buildLogTag(MarvelApi.class.getSimpleName());

    public static final ComicMapper comicMapper = new ComicMapper();

    public static final String DEADPOOL_ID = "1009268";
    private static final String BASE_URL = "http://gateway.marvel.com:80/v1/public/";
    private static final String MARVEL_API_PUBLIC_KEY = BuildConfig.MARVEL_API_PUBLIC_KEY;
    private static final String MARVEL_API_PRIVATE_KEY = BuildConfig.MARVEL_API_PRIVATE_KEY;

    private Context mContext;

    public MarvelApi(Context context){
        if(context==null){
            throw new IllegalArgumentException("Constructor parameters cannot be null");
        }
        mContext = context;
    }

    public void GetComicList(final int limit, final int offset,
                             final ComicDataStore.ComicListCallback comicListCallback) {
        if (Utils.isThereInternetConnection(mContext)) {
            long timestamp = System.currentTimeMillis();
            String hash = getApiHash(timestamp, MARVEL_API_PRIVATE_KEY, MARVEL_API_PUBLIC_KEY);
            Call<ComicMarvel> call = makeComicService()
                    .getComicsByCharacter(DEADPOOL_ID, timestamp, MARVEL_API_PUBLIC_KEY, hash,
                            limit, offset);
            Log.d(LOG_TAG, "Calling comics...");
            call.enqueue(new Callback<ComicMarvel>() {
                @Override
                public void onResponse(Call<ComicMarvel> call, Response<ComicMarvel> response) {
                    comicListCallback.onComicListLoaded(
                            comicMapper.mapComicMarvelToCollection(response.body()));
                }

                @Override
                public void onFailure(Call<ComicMarvel> call, Throwable t) {
                    comicListCallback.onError((Exception) t);
                }
            });
        } else {
            comicListCallback.onError(new NetworkConnectionException());
        }
    }

    private static MarvelService makeComicService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(MarvelService.class);
    }

    private static String getApiHash(long timestamp, String privateKey, String publicKey) {
        return Utils.md5(timestamp + privateKey + publicKey);
    }

}
