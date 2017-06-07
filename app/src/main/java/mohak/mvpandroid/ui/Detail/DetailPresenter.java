package mohak.mvpandroid.ui.Detail;


import javax.inject.Inject;

import mohak.mvpandroid.R;
import mohak.mvpandroid.data.DataManager.DataManager;
import mohak.mvpandroid.data.Model.TvShowDetail;
import mohak.mvpandroid.ui.Base.BasePresenter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by mohak on 7/6/17.
 */


public class DetailPresenter<V extends DetailMvpView> extends BasePresenter<V> implements DetailMvpPresenter<V> {

    @Inject
    DetailPresenter(DataManager dataManager) {
        super(dataManager);

    }

    @Override
    public void getTvShowDetail(int tv_id) {

        getMvpView().showLoading(false);

        getDataManager().getTvShowDetails(tv_id).enqueue(new Callback<TvShowDetail>() {
            @Override
            public void onResponse(Call<TvShowDetail> call, Response<TvShowDetail> response) {

                getMvpView().hideLoading(false);
                getMvpView().TvShowDetails(response.body());
            }

            @Override
            public void onFailure(Call<TvShowDetail> call, Throwable t) {

                getMvpView().hideLoading(false);
                getMvpView().showError(R.string.error_message);
            }
        });
    }
}
