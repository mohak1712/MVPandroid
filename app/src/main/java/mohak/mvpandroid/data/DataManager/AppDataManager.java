package mohak.mvpandroid.data.DataManager;

import android.content.Context;

import javax.inject.Inject;

import mohak.mvpandroid.data.DataManager.network.NetworkHelper;
import mohak.mvpandroid.di.qualifiers.ApplicationContext;

/**
 * Created by mohak on 26/5/17.
 */

public class AppDataManager implements DataManager {

    @Inject
    public AppDataManager(@ApplicationContext  Context context, NetworkHelper networkHelper) {


    }
}
