package mohak.mvpandroid.ui.Main;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;

import javax.inject.Inject;

import butterknife.BindView;
import mohak.mvpandroid.data.DataManager.network.TvDbService;
import mohak.mvpandroid.ui.Base.BaseActivity;
import mohak.mvpandroid.R;
import mohak.mvpandroid.ui.Base.BaseFragment;


public class MainActivity extends BaseActivity implements MainMvpView, BaseFragment.OnFragmentInteractionListener, NavigationView.OnNavigationItemSelectedListener {

    @Inject
    TvDbService tvDbService;

    @Inject
    MainMvpPresenter<MainMvpView> mainMvpPresenter;

    @BindView(R.id.nav_view)
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getActivityComponent().injectMainActivity(this);
        mainMvpPresenter.onAttach(this);

        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void setUpActivity() {

    }


    @Override
    public void showLoadingCallback(@IdRes int progress_bar) {
        showLoading(progress_bar);
    }

    @Override
    public void hideLoadingCallback(@IdRes int progress_bar) {
        hideLoading(progress_bar);
    }

    @Override
    public void showErrorCallback(@StringRes int error_message) {
        showError(error_message);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.popular) {


        } else if (id == R.id.about) {


        } else if (id == R.id.top_rated) {


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
