package mohak.mvpandroid.data.DataManager;

import android.content.Context;

import javax.inject.Inject;

import io.reactivex.Observable;
import mohak.mvpandroid.data.DataManager.Preference.PreferenceHelper;
import mohak.mvpandroid.data.DataManager.network.NetworkHelper;
import mohak.mvpandroid.data.Model.TvModelResult;
import mohak.mvpandroid.data.Model.TvShowDetail;
import mohak.mvpandroid.di.qualifiers.ApplicationContext;
import mohak.mvpandroid.di.scopes.ApplicationScope;
import retrofit2.Response;

/**
 * Created by mohak on 26/5/17.
 */

@ApplicationScope
public class AppDataManager implements DataManager {

    private PreferenceHelper mPreferenceHelper;
    private NetworkHelper mNetworkHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context, NetworkHelper networkHelper,
                          PreferenceHelper preferenceHelper) {
        this.mPreferenceHelper = preferenceHelper;
        this.mNetworkHelper = networkHelper;
    }

    @Override
    public Observable<Response<TvModelResult>> getTvPopularList(String pageNo) {
        return mNetworkHelper.getTvPopularList(pageNo);
    }

    @Override
    public Observable<Response<TvModelResult>> getTvTopRatedList(String pageNo) {
        return mNetworkHelper.getTvTopRatedList(pageNo);
    }

    @Override
    public Observable<Response<TvShowDetail>> getTvShowDetails(int tv_id) {
        return mNetworkHelper.getTvShowDetails(tv_id);
    }

    @Override
    public void addCurrentUserEmail(String email) {
        mPreferenceHelper.addCurrentUserEmail(email);

    }

    @Override
    public String getCurrentUserEmail() {
        return mPreferenceHelper.getCurrentUserEmail();
    }

    @Override
    public void deleteCredentials() {
        mPreferenceHelper.deleteCredentials();
    }
}
