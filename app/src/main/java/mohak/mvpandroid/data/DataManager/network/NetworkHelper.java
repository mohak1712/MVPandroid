package mohak.mvpandroid.data.DataManager.network;

import io.reactivex.Observable;
import mohak.mvpandroid.data.Model.TvModelResult;
import mohak.mvpandroid.data.Model.TvShowDetail;
import retrofit2.Response;

/**
 * Created by mohak on 26/5/17.
 */

public interface NetworkHelper {

     Observable<Response<TvModelResult>> getTvPopularList(String pageNo);

     Observable<Response<TvModelResult>> getTvTopRatedList(String pageNo);

    Observable<Response<TvShowDetail>> getTvShowDetails(int movie_id);
}
