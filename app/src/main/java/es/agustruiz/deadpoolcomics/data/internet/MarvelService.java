package es.agustruiz.deadpoolcomics.data.internet;

import es.agustruiz.deadpoolcomics.data.model.marvel.ComicMarvel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MarvelService {

    @GET("characters/{characterId}/comics")
    Call<ComicMarvel> getComicsByCharacter(
            @Path("characterId") String characterId,
            @Query("ts") long timestamp,
            @Query("apikey") String apiKey,
            @Query("hash") String hash,
            @Query("limit") int limit,
            @Query("offset") int offset
    );

}
