package mohak.mvpandroid.Main;

/**
 * Created by mohak on 13/5/17.
 */


import mohak.mvpandroid.Base.BaseMvpPresenter;

/**
 * Base class that implements the Presenter interface and provides a base implementation for
 * onAttach() and onDetach(). It also handles keeping a reference to the mvpView that
 * can be accessed from the children classes by calling getMvpView().
 */
public class MainPresenter<V> implements BaseMvpPresenter<V> {

    @Override
    public void onAttach(V mvpView) {

    }

    @Override
    public void onDetach() {

    }
}
