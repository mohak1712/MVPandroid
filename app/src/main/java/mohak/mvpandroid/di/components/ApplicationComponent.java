package mohak.mvpandroid.di.components;

import dagger.Component;
import mohak.mvpandroid.MvpAndroid;
import mohak.mvpandroid.data.DataManager.network.TvDbService;
import mohak.mvpandroid.di.modules.ApplicationModule;
import mohak.mvpandroid.di.modules.NetworkModule;
import mohak.mvpandroid.di.scopes.ApplicationScope;

/**
 * Created by mohak on 19/5/17.
 */

@ApplicationScope
@Component(modules = {ApplicationModule.class , NetworkModule.class})
public interface ApplicationComponent {

    void inject(MvpAndroid app);

    TvDbService getMovieDb();
}

