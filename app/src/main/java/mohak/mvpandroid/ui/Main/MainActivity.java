package mohak.mvpandroid.ui.Main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mohak.mvpandroid.di.components.ActivityComponent;
import mohak.mvpandroid.ui.About;
import mohak.mvpandroid.ui.Base.BaseActivity;
import mohak.mvpandroid.R;
import mohak.mvpandroid.ui.Base.BaseFragment;
import mohak.mvpandroid.ui.SignUp.SignUpActivity;
import mohak.mvpandroid.ui.PopularShows.PopularShows;
import mohak.mvpandroid.ui.TopRatedShows.TopRatedShows;

/**
 * Created by mohak on 13/5/17.
 */


public class MainActivity extends BaseActivity implements MainMvpView, BaseFragment.OnFragmentInteractionListener,
        NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    @Inject
    MainMvpPresenter<MainMvpView> mainMvpPresenter;

    @BindView(R.id.nav_view)
    NavigationView navigationView;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.about_icon)
    ImageView about;

    ImageView logout;

    TextView userName;

    TextView userEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActivityComponent().injectMainActivity(this);
        ButterKnife.bind(this);

        /*crashing with ButterKnife update later*/
        userName = (TextView) navigationView.getHeaderView(0).findViewById(R.id.user_name);
        userEmail = (TextView) navigationView.getHeaderView(0).findViewById(R.id.user_email);
        logout = (ImageView) navigationView.getHeaderView(0).findViewById(R.id.log_out);

        logout.setOnClickListener(this);

        setUpActivity();

    }

    @Override
    public void setUpActivity() {

        mainMvpPresenter.onAttach(this);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle("Tv Shows");
        about.setVisibility(View.VISIBLE);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

        };

        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        mainMvpPresenter.showPopularShowsFrag();
        mainMvpPresenter.getUserDetail();

    }


    /*callback method for communication with fragments*/

    @Override
    public void showErrorCallback(@StringRes int error_message) {
        showError(error_message);
    }

    @Override
    public boolean isNetworkAvailableCallback() {
        return isNetworkAvailable();
    }

    @Override
    public ActivityComponent getActivityComponentCallback() {
        return getActivityComponent();
    }

    /*fragment callback ends*/


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.popular) {
            mainMvpPresenter.showPopularShowsFrag();

        } else if (id == R.id.top_rated) {
            mainMvpPresenter.showTopRatedFrag();

        }

        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainMvpPresenter.onDetach();
    }

    @Override
    public void setUserDetails(String currentUserEmail) {

        userEmail.setText(currentUserEmail);
        userName.setText(currentUserEmail.split("@")[0]);
    }

    @Override
    public void closeNavDrawer() {
        drawer.closeDrawer(GravityCompat.START);
    }

    @Override
    public void showPopularFrag() {

        PopularShows popularShows = (PopularShows) getSupportFragmentManager().findFragmentByTag(PopularShows.class.getSimpleName());

        /*check if the click fragment is not the current fragment that is visible to the user*/
        if (popularShows == null || !popularShows.isVisible()) {

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content_main, PopularShows.newInstance(), PopularShows.class.getSimpleName()).commit();
        }
    }

    @Override
    public void showTopRatedFrag() {

        TopRatedShows topRated = (TopRatedShows) getSupportFragmentManager().findFragmentByTag(TopRatedShows.class.getSimpleName());

        /*check if the click fragment is not the current fragment that is visible to the user*/
        if (topRated == null || !topRated.isVisible()) {

            getSupportFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
                    .replace(R.id.content_main, TopRatedShows.newInstance(), TopRatedShows.class.getSimpleName()).commit();
        }

    }

    @Override
    public void openLoginActivity() {
        startActivity(new Intent(this, SignUpActivity.class));
        finish();
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.log_out)
            mainMvpPresenter.logoutUser();
    }

    @OnClick(R.id.about_icon)
    void aboutClick(){
        mainMvpPresenter.openAboutAct();
    }

    public void openAboutActivity() {
        startActivity(new Intent(this, About.class));
    }

    @Override
    public void showLoading(boolean bottomProgress) {

    }

    @Override
    public void hideLoading(boolean bottomProgress) {

    }

}
