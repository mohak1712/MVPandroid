package mohak.mvpandroid.ui.Detail;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import mohak.mvpandroid.R;
import mohak.mvpandroid.Utils.Constants;
import mohak.mvpandroid.data.Model.TvShowDetail;
import mohak.mvpandroid.ui.Base.BaseActivity;

/**
 * Created by mohak on 7/6/17.
 */


public class DetailActivity extends BaseActivity implements DetailMvpView, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.swipeRefresh)
    SwipeRefreshLayout swipeRefreshLayout;

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.about_icon)
    ImageView about;

    @BindView(R.id.show_name)
    TextView showName;

    @BindView(R.id.show_image)
    ImageView showImage;

    @BindView(R.id.rating)
    TextView rating;

    @BindView(R.id.description)
    TextView description;

    @Inject
    DetailMvpPresenter<DetailMvpView> detailMvpPresenter;

    int tv_id;

    String imgLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_show);

        tv_id = getIntent().getIntExtra(Constants.SHOW_ID, -1);
        imgLink = getIntent().getStringExtra(Constants.SHOW_IMG);

        getActivityComponent().injectDetailActivity(this);
        ButterKnife.bind(this);
        setUpActivity();

    }


    @Override
    public void setUpActivity() {

        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setTitle("Overview");

        swipeRefreshLayout.setRefreshing(false);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary, R.color.colorAccent, R.color.colorPrimaryDark);
        swipeRefreshLayout.setOnRefreshListener(this);

        Picasso.with(this).load(Constants.ImgUrl + imgLink).into(showImage);
        detailMvpPresenter.onAttach(this);
        detailMvpPresenter.getTvShowDetail(tv_id);

    }

    @Override
    public void showLoading(boolean bottomProgress) {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading(boolean bottomProgress) {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void TvShowDetails(TvShowDetail detail) {

        rating.setText(" " + detail.getRating());
        showName.setText(detail.getShowName());
        description.setText(detail.getSynopsis());

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        detailMvpPresenter.onDetach();
    }

    @Override
    public void onRefresh() {
        detailMvpPresenter.getTvShowDetail(tv_id);
        swipeRefreshLayout.setRefreshing(false);

    }
}
