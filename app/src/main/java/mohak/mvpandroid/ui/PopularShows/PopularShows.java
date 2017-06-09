package mohak.mvpandroid.ui.PopularShows;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import javax.inject.Inject;

import mohak.mvpandroid.R;
import mohak.mvpandroid.Utils.Constants;
import mohak.mvpandroid.data.Model.TvModel;
import mohak.mvpandroid.data.Model.TvModelResult;
import mohak.mvpandroid.ui.Base.BaseFragment;
import mohak.mvpandroid.ui.CommonFragmentAdapter;
import mohak.mvpandroid.ui.Detail.DetailActivity;

/**
 * Created by mohak on 4/6/17.
 */

public class PopularShows extends BaseFragment implements PopularShowsMvpView {


    public PopularShows() {
        // Required empty public constructor
    }


    public static PopularShows newInstance() {
        PopularShows fragment = new PopularShows();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Inject
    CommonFragmentAdapter adapter;

    @Inject
    PopularShowsMvpPresenter<PopularShowsMvpView> popularTvShowsMvpPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = super.onCreateView(inflater, container, savedInstanceState);

        getActivityComponent().injectPopularTvShows(this);
        popularTvShowsMvpPresenter.onAttach(this);
        popularTvShowsMvpPresenter.fetchPopularTvListFromApi("1");

        adapter.setImageClickListener(this);
        gridView.setAdapter(adapter);

        return view;
    }

    @Override
    public void update(int scroll) {
        popularTvShowsMvpPresenter.fetchPopularTvListFromApi("" + scroll);
    }


    @Override
    public void fetchedList(TvModelResult result) {

        TvModel[] model = result.getModels();
        ArrayList<TvModel> apiData = new ArrayList<>(Arrays.asList(model));
        adapter.updateList(apiData);

    }

    @Override
    public void onRefresh() {
        popularTvShowsMvpPresenter.fetchPopularTvListFromApi("1");
        swipeRefreshLayout.setRefreshing(false);
    }


}
