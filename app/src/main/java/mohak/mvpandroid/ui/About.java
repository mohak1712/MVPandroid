package mohak.mvpandroid.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import mohak.mvpandroid.R;
import mohak.mvpandroid.ui.Base.BaseActivity;

public class About extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.about_icon)
    ImageView about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ButterKnife.bind(this);
        setUpActivity();

    }

    @Override
    public void setUpActivity() {

        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle("About");
        }

        about.setVisibility(View.GONE);
    }

    @Override
    public void showLoading(boolean bottomProgress) {

    }

    @Override
    public void hideLoading(boolean bottomProgress) {

    }
}
