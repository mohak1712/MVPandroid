package mohak.mvpandroid.ui.Base;

/**
 * Created by mohak on 13/5/17.
 */


import javax.inject.Inject;

import mohak.mvpandroid.data.DataManager.DataManager;

/**
 * Base class that implements the Presenter interface and provides a base implementation for
 * onAttach() and onDetach(). It also handles keeping a reference to the mvpView that
 * can be accessed from the children classes by calling getMvpView().
 */
public class BasePresenter<V extends BaseMvpView> implements BaseMvpPresenter<V> {

    private V mMvpView;

    private DataManager dataManager;

    @Inject
    public BasePresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void onAttach(V mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void onDetach() {
        mMvpView = null;
    }

    public boolean isViewAttached() {
        return mMvpView!=null;
    }


    public V getMvpView() {
        return mMvpView;
    }

    public DataManager getDataManager() {
        return dataManager;
    }


}
