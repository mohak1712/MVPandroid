package mohak.mvpandroid.ui.Base;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import mohak.mvpandroid.MvpAndroid;
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
                .activityModule(new ActivityModule(this))
                .applicationComponent(((MvpAndroid)getApplication()).getApplicationComponent())
                .build();
    }

    public ActivityComponent getActivityComponent() {
        return mActivityComponent;
    }

    public boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
