package mohak.mvpandroid.di.modules;

import android.app.Activity;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import mohak.mvpandroid.di.qualifiers.ActivityContext;

/**
 * Created by mohak on 19/5/17.
 */

@Module
public class ActivityModule {

    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return activity;
    }

//    @Provides
//    @ActivityScope
//    MainMvpPresenter<MainMvpView> provideMainPresenter(MainPresenter<MainMvpView> presenter) {
//        return presenter;
//    }



}
