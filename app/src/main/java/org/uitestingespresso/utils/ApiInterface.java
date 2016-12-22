package org.uitestingespresso.utils;

import org.uitestingespresso.model.FlickerResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by pace-android on 16/12/16.
 */

public interface ApiInterface {

    @GET("services/feeds/photos_public.gne")
    Call<FlickerResponse> getFlikerImages( @Query("tags") String tags, @Query("tagmode") String tagmode, @Query("format") String format,@Query("nojsoncallback") int value);
}
