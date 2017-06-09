package mohak.mvpandroid.ui.SignUp;

import mohak.mvpandroid.ui.Base.BaseMvpPresenter;

/**
 * Created by mohak on 26/5/17.
 */

public interface SignUpMvpPresenter<V extends SignUpMvpView> extends BaseMvpPresenter<V>{

    void signUpCheck(String email , String password);

    void alreadySignedUpCheck();
}
