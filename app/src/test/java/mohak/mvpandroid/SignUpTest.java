package mohak.mvpandroid;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import io.reactivex.disposables.CompositeDisposable;
import mohak.mvpandroid.data.DataManager.AppDataManager;
import mohak.mvpandroid.data.DataManager.DataManager;
import mohak.mvpandroid.ui.SignUp.SignUpMvpPresenter;
import mohak.mvpandroid.ui.SignUp.SignUpMvpView;
import mohak.mvpandroid.ui.SignUp.SignUpPresenter;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by mohak on 9/6/17.
 */

@RunWith(MockitoJUnitRunner.class)
public class SignUpTest {

    String email = "abc1712gmail.com";
    String pass = "fdgte%$";

    @Mock
    SignUpMvpView mMockLoginMvpView;

    @Mock
    DataManager mMockDataManager;

    @Mock
    CompositeDisposable compositeDisposable;

    SignUpMvpPresenter<SignUpMvpView> mvpPresenter;

    @Before
    public void setUp() throws Exception {
        mvpPresenter = new SignUpPresenter<>(mMockDataManager,compositeDisposable);
        mvpPresenter.onAttach(mMockLoginMvpView);
    }

    @Test
    public void signUpTest(){

        when(mMockLoginMvpView.isNetworkAvailable()).thenReturn(true);
        mvpPresenter.signUpCheck(email,pass);
        verify(mMockLoginMvpView).showError(R.string.invalid_email_error);
    }

    @After
    public void terminate() throws Exception {
        mvpPresenter.onDetach();
    }
}
