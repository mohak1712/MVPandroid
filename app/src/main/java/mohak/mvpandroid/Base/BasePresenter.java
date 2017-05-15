package mohak.mvpandroid.Base;

/**
 * Created by mohak on 13/5/17.
 */


/**
 * Base class that implements the Presenter interface and provides a base implementation for
 * onAttach() and onDetach(). It also handles keeping a reference to the mvpView that
 * can be accessed from the children classes by calling getMvpView().
 */
public class BasePresenter<V extends BaseMvpView> implements BaseMvpPresenter<V> {

    private V mvpView;

    @Override
    public void onAttach(V mvpView) {

        this.mvpView = mvpView;
    }

    @Override
    public void onDetach() {

        mvpView = null;
    }
}
