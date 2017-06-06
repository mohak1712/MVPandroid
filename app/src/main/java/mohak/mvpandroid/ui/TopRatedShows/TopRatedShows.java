package mohak.mvpandroid.ui.TopRatedShows;


import android.os.Bundle;
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


public class TopRatedShows extends BaseFragment implements PopularShowsMvpView {

    OnFragmentInteractionListener mListner;

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
    PopularShowsAdapter adapter;

    @BindView(R.id.grid_view)
    GridView gridView;

    @Inject
    PopularShowsMvpPresenter<PopularShowsMvpView> popularTvShowsMvpPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_popular_tv_shows, container, false);

        getActivityComponent().injectPopularTvShows(this);
        popularTvShowsMvpPresenter.onAttach(this);
        popularTvShowsMvpPresenter.fetchPopularTvListFromApi("1");

        setUnBinder(ButterKnife.bind(this,view));
        gridView.setAdapter(adapter);


        return view;
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListner = null;
    }


    @Override
    public void fetchedList(TvModelResult result) {

        TvModel[] model = result.getModels();

        ArrayList<TvModel> apiData = new ArrayList<>(Arrays.asList(model));
        adapter.updateList(apiData);

    }
}
