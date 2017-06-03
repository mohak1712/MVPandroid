package mohak.mvpandroid.ui.Main;

/**
 * Created by mohak on 13/5/17.
 */


import javax.inject.Inject;

import mohak.mvpandroid.data.DataManager.DataManager;
import mohak.mvpandroid.ui.Base.BasePresenter;

public class MainPresenter<V extends MainMvpView> extends BasePresenter<V> implements MainMvpPresenter<V> {


    @Inject
    MainPresenter(DataManager dataManager) {
        super(dataManager);

    }

    @Override
    public void fragmentAdded() {

    }
}
