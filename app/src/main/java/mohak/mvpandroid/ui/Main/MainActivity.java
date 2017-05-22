package mohak.mvpandroid.ui.Main;

import android.os.Bundle;

import javax.inject.Inject;

import mohak.mvpandroid.ui.Base.BaseActivity;
import mohak.mvpandroid.R;
import retrofit2.Retrofit;

public class MainActivity extends BaseActivity implements MainMvpView{

    @Inject
    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getActivityComponent().injectMainActivity(this);

        if (isNetworkAvailable()){



        }
    }



}
