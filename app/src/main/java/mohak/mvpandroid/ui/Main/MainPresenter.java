package mohak.mvpandroid.ui.Main;

/**
 * Created by mohak on 13/5/17.
 */

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import mohak.mvpandroid.R;
import mohak.mvpandroid.data.DataManager.DataManager;
import mohak.mvpandroid.ui.Base.BasePresenter;

public class MainPresenter<V extends MainMvpView> extends BasePresenter<V> implements MainMvpPresenter<V> {

    @Inject
    public MainPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

    @Override
    public void getUserDetail() {
        getMvpView().setUserDetails(getDataManager().getCurrentUserEmail());
    }

    @Override
    public void showPopularShowsFrag() {

        getMvpView().closeNavDrawer();
        if (!getMvpView().isNetworkAvailable()) {
            getMvpView().showError(R.string.error_message_internet_unavailable);
            return;
        }

        getMvpView().showPopularFrag();

    }

    @Override
    public void showTopRatedFrag() {

        getMvpView().closeNavDrawer();
        if (!getMvpView().isNetworkAvailable()) {
            getMvpView().showError(R.string.error_message_internet_unavailable);
            return;
        }

        getMvpView().showTopRatedFrag();

    }

    @Override
    public void logoutUser() {
        getDataManager().deleteCredentials();
        getMvpView().openLoginActivity();
    }

    @Override
    public void openAboutAct() {
        getMvpView().openAboutActivity();
    }
}
