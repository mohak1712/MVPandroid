package mohak.mvpandroid.ui.SignUp;

import android.os.Handler;

import javax.inject.Inject;

import mohak.mvpandroid.R;
import mohak.mvpandroid.Utils.CommonUtils;
import mohak.mvpandroid.data.DataManager.DataManager;
import mohak.mvpandroid.ui.Base.BasePresenter;

/**
 * Created by mohak on 26/5/17.
 */

public class SignUpPresenter<V extends SignUpMvpView> extends BasePresenter<V> implements SignUpMvpPresenter<V> {

    @Inject
    public SignUpPresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void alreadySignedUpCheck() {

        if (getDataManager().getCurrentUserEmail()!=null)
            getMvpView().openMainActivity();
    }

    @Override
    public void signUpCheck(String email, String password) {

        if (!getMvpView().isNetworkAvailable()) {
            getMvpView().showError(R.string.error_message_internet_unavailable);
            return;
        }

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

        getMvpView().showLoading(false);
        getDataManager().addCurrentUserEmail(email);

        /*5 second delay just to show the progress bar. This is not required otherwise.*/
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getMvpView().hideLoading(false);
                getMvpView().openMainActivity();
            }
        }, 3000);


    }


}
