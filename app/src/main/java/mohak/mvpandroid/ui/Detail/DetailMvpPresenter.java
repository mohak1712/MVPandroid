package mohak.mvpandroid.ui.Detail;

import mohak.mvpandroid.ui.Base.BaseMvpPresenter;

/**
 * Created by mohak on 7/6/17.
 */


public interface DetailMvpPresenter<V extends DetailMvpView> extends BaseMvpPresenter<V> {

    void getTvShowDetail(int tv_id);
}
