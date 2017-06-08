package mohak.mvpandroid.data.DataManager.Preference;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import javax.inject.Inject;

import mohak.mvpandroid.Utils.Constants;
import mohak.mvpandroid.data.DataManager.network.TvDbService;
import mohak.mvpandroid.di.qualifiers.ApplicationContext;
import mohak.mvpandroid.di.qualifiers.PrefFile;
import mohak.mvpandroid.di.scopes.ApplicationScope;

/**
 * Created by mohak on 26/5/17.
 */

@ApplicationScope
public class AppPreferenceManager implements PreferenceHelper {

    private SharedPreferences mPrefs;
    private Context context;

    @Inject
    public AppPreferenceManager(@ApplicationContext Context context, @PrefFile String prefName) {
        mPrefs = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
        this.context = context;
    }

    @Override
    public void addCurrentUserEmail(final String email) {
        mPrefs.edit().putString(Constants.PREF_USER_EMAIL, email).apply();
    }

    @Override
    public String getCurrentUserEmail() {
        return mPrefs.getString(Constants.PREF_USER_EMAIL, null);
    }

    @Override
    public void deleteCredentials() {
        mPrefs.edit().clear().apply();
    }


}
