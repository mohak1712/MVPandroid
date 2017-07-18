package mohak.mvpandroid.data.DataManager.network;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;
import mohak.mvpandroid.Utils.Constants;
import mohak.mvpandroid.data.Model.TvModelResult;
import mohak.mvpandroid.data.Model.TvShowDetail;
import mohak.mvpandroid.di.scopes.ApplicationScope;
import retrofit2.Response;

/**
 * Created by mohak on 26/5/17.
 */

@ApplicationScope
public class AppNetworkManager implements NetworkHelper {

    TvDbService dbService;

    @Inject
    public AppNetworkManager(TvDbService dbService) {
        this.dbService = dbService;
    }

    @Override
    public Observable<Response<TvModelResult>> getTvPopularList(String pageNo) {

        Map<String, String> param = new HashMap<>();
        param.put("api_key", Constants.API_KEY);
        param.put("language", "en-US");
        param.put("page", pageNo);

        return dbService.getpopular(param);

    }

    @Override
    public Observable<Response<TvModelResult>> getTvTopRatedList(String pageNo) {

        Map<String, String> param = new HashMap<>();
        param.put("api_key", Constants.API_KEY);
        param.put("language", "en-US");
        param.put("page", pageNo);

        return dbService.getTopRated(param);
    }

    @Override
    public Observable<Response<TvShowDetail>> getTvShowDetails(int tv_id) {

        Map<String, String> param = new HashMap<>();
        param.put("api_key", Constants.API_KEY);
        param.put("language", "en-US");

        return dbService.getShowData(tv_id,param);
    }
}
