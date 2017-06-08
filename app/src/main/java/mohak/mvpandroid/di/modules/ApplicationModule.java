package mohak.mvpandroid.di.modules;

import android.content.Context;
import android.widget.Toast;

import dagger.Module;
import dagger.Provides;
import mohak.mvpandroid.MvpAndroid;
import mohak.mvpandroid.Utils.Constants;
import mohak.mvpandroid.data.DataManager.AppDataManager;
import mohak.mvpandroid.data.DataManager.DataManager;
import mohak.mvpandroid.data.DataManager.Preference.AppPreferenceManager;
import mohak.mvpandroid.data.DataManager.Preference.PreferenceHelper;
import mohak.mvpandroid.data.DataManager.network.AppNetworkManager;
import mohak.mvpandroid.data.DataManager.network.NetworkHelper;
import mohak.mvpandroid.di.qualifiers.ApplicationContext;
import mohak.mvpandroid.di.qualifiers.PrefFile;
import mohak.mvpandroid.di.scopes.ApplicationScope;

/**
 * Created by mohak on 19/5/17.
 */

@Module
public class ApplicationModule {

    private MvpAndroid app;

    public ApplicationModule(MvpAndroid app) {
        this.app = app;
    }

    @ApplicationContext
    @Provides
    Context provideContext() {
        return app;
    }

    @PrefFile
    @Provides
    String providePrefFile() {
        return Constants.PREF_FILENAME;
    }

    @ApplicationScope
    @Provides
    DataManager provideDataManger(AppDataManager appDataManager) {
        return appDataManager;
    }

    @ApplicationScope
    @Provides
    PreferenceHelper providePreferenceHelper(AppPreferenceManager appPreferenceManager) {
        return appPreferenceManager;
    }

    @ApplicationScope
    @Provides
    NetworkHelper provideNetworkHelper(AppNetworkManager networkManager) {
        return networkManager;
    }
}
