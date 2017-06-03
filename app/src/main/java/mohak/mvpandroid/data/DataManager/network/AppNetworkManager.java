package mohak.mvpandroid.data.DataManager.network;

import javax.inject.Inject;

import mohak.mvpandroid.di.scopes.ApplicationScope;

/**
 * Created by mohak on 26/5/17.
 */

@ApplicationScope
public class AppNetworkManager implements NetworkHelper {

    @Inject
    public AppNetworkManager() {
    }

    @Override
    public void getTvPopularList() {

    }
}
