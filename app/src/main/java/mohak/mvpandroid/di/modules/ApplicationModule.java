package mohak.mvpandroid.di.modules;

import android.app.Activity;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import mohak.mvpandroid.di.qualifiers.ActivityContext;
import mohak.mvpandroid.di.scopes.ActivityScope;
import mohak.mvpandroid.ui.Main.MainMvpPresenter;
import mohak.mvpandroid.ui.Main.MainMvpView;
import mohak.mvpandroid.ui.Main.MainPresenter;

/**
 * Created by mohak on 19/5/17.
 */

@Module
public class ApplicationModule {

    private Activity activity;

    public ApplicationModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return activity;
    }

    @Provides
    @ActivityScope
    MainMvpPresenter<MainMvpView> provideMainPresenter(MainPresenter<MainMvpView> presenter) {
        return presenter;
    }

}
