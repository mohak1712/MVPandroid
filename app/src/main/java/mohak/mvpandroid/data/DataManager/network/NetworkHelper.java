package mohak.mvpandroid.data.DataManager.network;

import mohak.mvpandroid.data.Model.TvModelResult;
import mohak.mvpandroid.data.Model.TvShowDetail;
import retrofit2.Call;

/**
 * Created by mohak on 26/5/17.
 */

public interface NetworkHelper {

     Call<TvModelResult> getTvPopularList(String pageNo);

     Call<TvModelResult> getTvTopRatedList(String pageNo);

    Call<TvShowDetail> getTvShowDetails(int movie_id);
}
