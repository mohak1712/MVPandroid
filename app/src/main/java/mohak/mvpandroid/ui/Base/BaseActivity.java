package mohak.mvpandroid.ui.Base;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import mohak.mvpandroid.MvpAndroid;
import mohak.mvpandroid.R;
import mohak.mvpandroid.di.components.ActivityComponent;
import mohak.mvpandroid.di.components.DaggerActivityComponent;
import mohak.mvpandroid.di.modules.ActivityModule;


/**
 * Created by mohak on 13/5/17.
 */

public abstract class BaseActivity extends AppCompatActivity implements BaseMvpView {

    private ActivityComponent mActivityComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivityComponent = DaggerActivityComponent.builder()
                .applicationComponent(((MvpAndroid) getApplication()).getApplicationComponent())
                .activityModule(new ActivityModule(this))
                .build();



    }

    public ActivityComponent getActivityComponent() {
        return mActivityComponent;
    }

    @Override
    public boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override
    public void showError(@StringRes int error_message) {
        Snackbar.make(findViewById(android.R.id.content), getString(error_message), Snackbar.LENGTH_SHORT).show();
    }


    public abstract void setUpActivity();

}
