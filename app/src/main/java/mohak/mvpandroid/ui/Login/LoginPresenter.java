package mohak.mvpandroid.ui.Login;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import mohak.mvpandroid.MvpAndroid;
import mohak.mvpandroid.R;
import mohak.mvpandroid.Utils.CommonUtils;
import mohak.mvpandroid.data.DataManager.DataManager;
import mohak.mvpandroid.ui.Base.BaseMvpView;
import mohak.mvpandroid.ui.Base.BasePresenter;

/**
 * Created by mohak on 26/5/17.
 */

public class LoginPresenter<V extends LoginMvpView> extends BasePresenter<V> implements LoginMvpPresenter<V> {


    @Inject
    LoginPresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void loginCheck(String email, String password) {

        if (email == null || email.isEmpty()) {
            getMvpView().showError(R.string.empty_email_error);
            return;
        }

        if (!CommonUtils.isEmailValid(email)) {
            getMvpView().showError(R.string.invalid_email_error);
            return;
        }

        if (password == null || password.isEmpty()) {
            getMvpView().showError(R.string.empty_password_error);
            return;
        }

        getMvpView().showLoading();
        getDataManager().addCurrentUserEmail(email);

    }


}
