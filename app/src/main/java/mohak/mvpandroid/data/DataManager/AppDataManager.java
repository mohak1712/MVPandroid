package mohak.mvpandroid.data.DataManager;

import android.content.Context;
import android.os.Handler;

import javax.inject.Inject;

import mohak.mvpandroid.data.DataManager.Preference.PreferenceHelper;
import mohak.mvpandroid.data.DataManager.network.NetworkHelper;
import mohak.mvpandroid.di.qualifiers.ApplicationContext;
import mohak.mvpandroid.di.scopes.ApplicationScope;

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
    public void getTvPopularList() {

    }

    @Override
    public void addCurrentUserEmail(String email) {
        mPreferenceHelper.addCurrentUserEmail(email);

    }

    @Override
    public String getCurrentUserEmail() {
        return mPreferenceHelper.getCurrentUserEmail();
    }
}
