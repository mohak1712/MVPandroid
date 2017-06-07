package mohak.mvpandroid.ui.TopRatedShows;


import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Arrays;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import mohak.mvpandroid.R;
import mohak.mvpandroid.data.Model.TvModel;
import mohak.mvpandroid.data.Model.TvModelResult;
import mohak.mvpandroid.ui.Base.BaseFragment;


public class TopRatedShows extends BaseFragment implements TopRatedShowsMvpView {


    public TopRatedShows() {
        // Required empty public constructor
    }


    public static TopRatedShows newInstance() {
        TopRatedShows fragment = new TopRatedShows();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Inject
    TopRatedShowsAdapter adapter;


    @Inject
    TopRatedShowsMvpPresenter<TopRatedShowsMvpView> topRatedShowsMvpPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = super.onCreateView(inflater, container, savedInstanceState);

        getActivityComponent().injectTopRatedTvShows(this);
        topRatedShowsMvpPresenter.onAttach(this);
        topRatedShowsMvpPresenter.fetchTopRatedTvListFromApi("1");

        gridView.setAdapter(adapter);


        return view;
    }

    @Override
    public void update(int scroll) {
        topRatedShowsMvpPresenter.fetchTopRatedTvListFromApi("" + scroll);
    }

    @Override
    public void fetchedTopRatedList(TvModelResult result) {

        TvModel[] model = result.getModels();
        ArrayList<TvModel> apiData = new ArrayList<>(Arrays.asList(model));
        adapter.updateList(apiData);

    }

    @Override
    public void onDestroyView() {
        topRatedShowsMvpPresenter.onDetach();
        super.onDestroyView();
    }

    @Override
    public void onRefresh() {
        topRatedShowsMvpPresenter.fetchTopRatedTvListFromApi("1");
        swipeRefreshLayout.setRefreshing(false);
    }
}
