package mohak.mvpandroid.di.components;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

import dagger.Component;
import mohak.mvpandroid.di.modules.ActivityModule;
import mohak.mvpandroid.di.modules.NetworkModule;
import mohak.mvpandroid.ui.Login.LoginActivity;
import mohak.mvpandroid.ui.Main.MainActivity;
import mohak.mvpandroid.di.scopes.ActivityScope;
import mohak.mvpandroid.ui.Main2Activity;

/**
 * Created by mohak on 19/5/17.
 */

@ActivityScope
@Component(modules = {ActivityModule.class}, dependencies = {ApplicationComponent.class})
public interface ActivityComponent {

    void injectMainActivity(MainActivity mainActivity);

    void injectLoginActivity(LoginActivity mainActivity);

    void injectMainActivity2(Main2Activity mainActivity);

}
