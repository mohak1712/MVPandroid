package mohak.mvpandroid.ui.PopularShows;

import mohak.mvpandroid.ui.Base.BaseMvpPresenter;

/**
 * Created by mohak on 4/6/17.
 */

public interface PopularShowsMvpPresenter<V extends PopularShowsMvpView> extends BaseMvpPresenter<V> {

    void fetchPopularTvListFromApi(String pgNo);
}
