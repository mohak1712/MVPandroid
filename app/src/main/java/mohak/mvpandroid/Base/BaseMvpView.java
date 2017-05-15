package mohak.mvpandroid.Base;

/**
 * Created by mohak on 13/5/17.
 */


/**
 * Base interface that any class that wants to act as a View in the MVP (Model View Presenter)
 * pattern must implement. Generally this interface will be extended by a more specific interface
 * that then usually will be implemented by an Activity or Fragment.
 */
public interface BaseMvpView {

    void showLoading();

    void hideLoading();

}
