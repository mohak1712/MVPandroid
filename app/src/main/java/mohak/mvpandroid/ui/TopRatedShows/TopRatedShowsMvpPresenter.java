package mohak.mvpandroid.ui.TopRatedShows;

import mohak.mvpandroid.ui.Base.BaseMvpPresenter;

/**
 * Created by mohak on 4/6/17.
 */

public interface TopRatedShowsMvpPresenter<V extends TopRatedShowsMvpView> extends BaseMvpPresenter<V> {

    void fetchTopRatedTvListFromApi(String pgNo);
}
