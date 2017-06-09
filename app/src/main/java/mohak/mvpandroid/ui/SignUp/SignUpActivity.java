package mohak.mvpandroid.ui.SignUp;


import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mohak.mvpandroid.R;
import mohak.mvpandroid.ui.Base.BaseActivity;
import mohak.mvpandroid.ui.Main.MainActivity;

import static android.R.color.holo_red_dark;

/**
 * Created by mohak on 26/5/17.
 */

public class SignUpActivity extends BaseActivity implements SignUpMvpView {

    @Inject
    SignUpMvpPresenter<SignUpMvpView> loginMvpPresenter;

    @BindView(R.id.email)
    EditText email;

    @BindView(R.id.password)
    EditText mPassword;

    @BindView(R.id.password_strength)
    TextView mPasswordStrength;

    @BindView(R.id.password_view)
    View mPasswordView;

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        getActivityComponent().injectLoginActivity(this);
        ButterKnife.bind(this);
        loginMvpPresenter.onAttach(this);
        setUpActivity();
        loginMvpPresenter.alreadySignedUpCheck();

    }

    @OnClick(R.id.signup)
    void confirmSignUp() {
        loginMvpPresenter.signUpCheck(email.getText().toString(), mPassword.getText().toString());
    }

    @Override
    public void openMainActivity() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }


    @Override
    public void setUpActivity() {

        mPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                ObjectAnimator animator1;

                if (editable.length() >= 4 && editable.length() <= 6) {

                    animator1 = ObjectAnimator.ofFloat(mPasswordStrength, "translationX", mPasswordView.getWidth() / 2 - mPasswordStrength.getWidth());
                    animator1.setDuration(1000);
                    animator1.start();
                    mPasswordStrength.setTextColor(getResources().getColor(R.color.black));

                } else if (editable.length() > 6) {

                    animator1 = ObjectAnimator.ofFloat(mPasswordStrength, "translationX", mPasswordView.getWidth()- mPasswordStrength.getWidth());
                    animator1.setDuration(1000);
                    animator1.start();
                    mPasswordStrength.setTextColor(getResources().getColor(R.color.green));

                } else {

                    animator1 = ObjectAnimator.ofFloat(mPasswordStrength, "translationX", 0);
                    animator1.setDuration(1000);
                    animator1.start();
                    mPasswordStrength.setTextColor(getResources().getColor(holo_red_dark));
                }
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginMvpPresenter.onDetach();
    }


    @Override
    public void showLoading(boolean bottomProgress) {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading(boolean bottomProgress) {
        progressBar.setVisibility(View.INVISIBLE);
    }
}
