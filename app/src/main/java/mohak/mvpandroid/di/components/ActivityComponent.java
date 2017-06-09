package mohak.mvpandroid.di.components;

import dagger.Component;
import mohak.mvpandroid.di.modules.ActivityModule;
import mohak.mvpandroid.ui.Detail.DetailActivity;
import mohak.mvpandroid.ui.SignUp.SignUpActivity;
import mohak.mvpandroid.ui.Main.MainActivity;
import mohak.mvpandroid.di.scopes.ActivityScope;
import mohak.mvpandroid.ui.PopularShows.PopularShows;
import mohak.mvpandroid.ui.TopRatedShows.TopRatedShows;

/**
 * Created by mohak on 19/5/17.
 */

@ActivityScope
@Component(modules = {ActivityModule.class}, dependencies = {ApplicationComponent.class})
public interface ActivityComponent {

    void injectMainActivity(MainActivity mainActivity);

    void injectLoginActivity(SignUpActivity mainActivity);

    void injectPopularTvShows(PopularShows popularTvShows);

    void injectTopRatedTvShows(TopRatedShows topRatedShows);

    void injectDetailActivity(DetailActivity detailActivity);
}
