package mohak.mvpandroid.Base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by mohak on 13/5/17.
 */

public abstract class BaseActivity extends AppCompatActivity implements BaseMvpView{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }



}
