package mohak.mvpandroid.di.modules;

import android.app.Activity;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import mohak.mvpandroid.MvpAndroid;
import mohak.mvpandroid.di.qualifiers.ActivityContext;
import mohak.mvpandroid.di.qualifiers.ApplicationContext;
import mohak.mvpandroid.di.scopes.ActivityScope;
import mohak.mvpandroid.ui.Main.MainMvpPresenter;
import mohak.mvpandroid.ui.Main.MainMvpView;
import mohak.mvpandroid.ui.Main.MainPresenter;
import retrofit2.Retrofit;

/**
 * Created by mohak on 19/5/17.
 */

@Module
public class ApplicationModule {

    private MvpAndroid app;

    public ApplicationModule(MvpAndroid app) {
        this.app = app;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return app;
    }

}
