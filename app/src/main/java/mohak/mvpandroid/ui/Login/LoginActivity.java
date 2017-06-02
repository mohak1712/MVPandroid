package mohak.mvpandroid.ui.Login;


import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mohak.mvpandroid.R;
import mohak.mvpandroid.ui.Base.BaseActivity;
import mohak.mvpandroid.ui.Base.BasePresenter;
import mohak.mvpandroid.ui.Main.MainActivity;

public class LoginActivity extends BaseActivity implements LoginMvpView {

    @Inject
    LoginMvpPresenter<LoginMvpView> loginMvpPresenter;

    @BindView(R.id.email)
    EditText email;

    @BindView(R.id.password)
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getActivityComponent().injectLoginActivity(this);
        ButterKnife.bind(this);
        loginMvpPresenter.onAttach(this);
    }

    @OnClick(R.id.signup)
    void confirmSignUp() {
        loginMvpPresenter.loginCheck(email.getText().toString(), password.getText().toString());
    }

    @Override
    public void openMainActivity() {
        startActivity(new Intent(this, MainActivity.class));
    }

}
