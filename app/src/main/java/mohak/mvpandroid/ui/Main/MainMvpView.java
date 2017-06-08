package mohak.mvpandroid.ui.Main;

import mohak.mvpandroid.ui.Base.BaseMvpView;

/**
 * Created by mohak on 13/5/17.
 */


public interface MainMvpView extends BaseMvpView{

    void setUserDetails(String currentUserEmail);

    void closeNavDrawer();

    void showPopularFrag();

    void showTopRatedFrag();

    void openLoginActivity();
}
