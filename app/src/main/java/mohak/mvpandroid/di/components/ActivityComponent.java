package mohak.mvpandroid.di.components;

import dagger.Component;
import mohak.mvpandroid.di.modules.ActivityModule;
import mohak.mvpandroid.ui.Main.MainActivity;
import mohak.mvpandroid.di.scopes.ActivityScope;

/**
 * Created by mohak on 19/5/17.
 */

@Component(modules = {ActivityModule.class}, dependencies = {ApplicationComponent.class})
@ActivityScope
public interface ActivityComponent {

    void injectMainActivity(MainActivity mainActivity);

}
