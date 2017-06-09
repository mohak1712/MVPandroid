package mohak.mvpandroid.di.modules;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
import mohak.mvpandroid.data.DataManager.Preference.AppPreferenceManager;
import mohak.mvpandroid.data.DataManager.Preference.PreferenceHelper;
import mohak.mvpandroid.data.DataManager.network.AppNetworkManager;
import mohak.mvpandroid.data.DataManager.network.NetworkHelper;
import mohak.mvpandroid.data.Model.TvModel;
import mohak.mvpandroid.di.qualifiers.ActivityContext;
import mohak.mvpandroid.di.scopes.ActivityScope;
import mohak.mvpandroid.ui.Detail.DetailMvpPresenter;
import mohak.mvpandroid.ui.Detail.DetailMvpView;
import mohak.mvpandroid.ui.Detail.DetailPresenter;
import mohak.mvpandroid.ui.SignUp.SignUpMvpPresenter;
import mohak.mvpandroid.ui.SignUp.SignUpMvpView;
import mohak.mvpandroid.ui.SignUp.SignUpPresenter;
import mohak.mvpandroid.ui.Main.MainMvpPresenter;
import mohak.mvpandroid.ui.Main.MainMvpView;
import mohak.mvpandroid.ui.Main.MainPresenter;
import mohak.mvpandroid.ui.CommonFragmentAdapter;
import mohak.mvpandroid.ui.PopularShows.PopularShowsMvpView;
import mohak.mvpandroid.ui.PopularShows.PopularShowsMvpPresenter;
import mohak.mvpandroid.ui.PopularShows.PopularShowsPresenter;
import mohak.mvpandroid.ui.TopRatedShows.TopRatedShowsMvpPresenter;
import mohak.mvpandroid.ui.TopRatedShows.TopRatedShowsMvpView;
import mohak.mvpandroid.ui.TopRatedShows.TopRatedShowsPresenter;

/**
 * Created by mohak on 19/5/17.
 */

@Module
public class ActivityModule {

    private AppCompatActivity activity;

    public ActivityModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @ActivityContext
    @ActivityScope
    @Provides
    Context provideContext() {
        return activity;
    }

    @ActivityScope
    @Provides
    Activity provideActivity() {
        return activity;
    }


    @ActivityScope
    @Provides
    NetworkHelper provideNetworkHelper(AppNetworkManager networkManager) {
        return networkManager;
    }

    @ActivityScope
    @Provides
    PreferenceHelper providePreferenceHelper(AppPreferenceManager preferenceManager) {
        return preferenceManager;
    }

    @ActivityScope
    @Provides
    SignUpMvpPresenter<SignUpMvpView> provideLoginPresenter(SignUpPresenter<SignUpMvpView> signUpPresenter) {
        return signUpPresenter;
    }

    @ActivityScope
    @Provides
    MainMvpPresenter<MainMvpView> provideMainPresenter(MainPresenter<MainMvpView> mainPresenter) {
        return mainPresenter;
    }

    @ActivityScope
    @Provides
    DetailMvpPresenter<DetailMvpView> provideDetailPresenter(DetailPresenter<DetailMvpView> detailPresenter) {
        return detailPresenter;
    }

    @Provides
    CommonFragmentAdapter provideTvShowsAdapter() {
        return new CommonFragmentAdapter(new ArrayList<TvModel>());
    }

    @Provides
    PopularShowsMvpPresenter<PopularShowsMvpView> provideTvShowsPresenter(PopularShowsPresenter<PopularShowsMvpView> popularTvShowsPresenter) {
        return popularTvShowsPresenter;
    }

    @Provides
    TopRatedShowsMvpPresenter<TopRatedShowsMvpView> provideTopRatedPresenter(TopRatedShowsPresenter<TopRatedShowsMvpView> topRatedShowsPresenter) {
        return topRatedShowsPresenter;
    }
}
