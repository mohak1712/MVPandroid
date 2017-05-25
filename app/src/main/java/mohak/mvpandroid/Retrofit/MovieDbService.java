package mohak.mvpandroid.Retrofit;

import java.util.Map;

import mohak.mvpandroid.data.Model.TvModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by mohak on 25/5/17.
 */

public interface MovieDbService {

    @GET("tv/popular")
    Call<TvModel> getpopular(@QueryMap Map<String, String> queries);



}
