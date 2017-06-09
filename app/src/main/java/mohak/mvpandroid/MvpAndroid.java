package mohak.mvpandroid;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import javax.inject.Inject;

import mohak.mvpandroid.data.DataManager.DataManager;
import mohak.mvpandroid.di.components.ApplicationComponent;
import mohak.mvpandroid.di.components.DaggerApplicationComponent;
import mohak.mvpandroid.di.modules.ApplicationModule;
import mohak.mvpandroid.di.modules.NetworkModule;
import mohak.mvpandroid.di.qualifiers.ApplicationContext;



/**
 * Created by mohak on 19/5/17.
 */

public class MvpAndroid extends Application {

    private ApplicationComponent mApplicationComponent;

    @Inject
    @ApplicationContext
    Context applicationContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationComponent = DaggerApplicationComponent.builder()
                .networkModule(new NetworkModule())
                .applicationModule(new ApplicationModule(this)).build();

        mApplicationComponent.inject(this);

    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }

    public Context getApplicationContext() {
        return applicationContext;
    }

}
