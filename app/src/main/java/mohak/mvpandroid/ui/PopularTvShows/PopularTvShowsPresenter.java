package mohak.mvpandroid.ui.PopularTvShows;

import javax.inject.Inject;

import mohak.mvpandroid.R;
import mohak.mvpandroid.data.DataManager.DataManager;
import mohak.mvpandroid.data.Model.TvModelResult;
import mohak.mvpandroid.ui.Base.BasePresenter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by mohak on 4/6/17.
 */

public class PopularTvShowsPresenter<V extends PopularTvShowsMvp> extends BasePresenter<V> implements PopularTvShowsMvpPresenter<V> {

    @Inject
    public PopularTvShowsPresenter(DataManager dataManager) {
        super(dataManager);
    }

    void fetchDataFromApi(String pgNo){

        if (!getMvpView().isNetworkAvailable()){

            getMvpView().showError(R.string.error_message_internet_unavailable);
            return;
        }

        getMvpView().showLoading(R.id.progress_bar);
        getDataManager().getTvPopularList(pgNo).enqueue(new Callback<TvModelResult>() {
            @Override
            public void onResponse(Call<TvModelResult> call, Response<TvModelResult> response) {

                getMvpView().fetchedList(response.body());
            }

            @Override
            public void onFailure(Call<TvModelResult> call, Throwable t) {

                getMvpView().showError(R.string.something_wrong);
            }
        });
    }

}
