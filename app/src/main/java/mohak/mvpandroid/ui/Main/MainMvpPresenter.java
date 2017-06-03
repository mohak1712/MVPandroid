package mohak.mvpandroid.ui.Main;

import mohak.mvpandroid.ui.Base.BaseMvpPresenter;

/**
 * Created by mohak on 13/5/17.
 */



public interface MainMvpPresenter<V extends MainMvpView> extends BaseMvpPresenter<V> {

    void fragmentAdded();


}
