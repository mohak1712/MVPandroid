package mohak.mvpandroid.ui.Main;

import android.os.Bundle;
import mohak.mvpandroid.ui.Base.BaseActivity;
import mohak.mvpandroid.R;

public class MainActivity extends BaseActivity implements MainMvpView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

}
