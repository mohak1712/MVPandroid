package mohak.mvpandroid.ui.Detail;


import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import mohak.mvpandroid.R;
import mohak.mvpandroid.data.DataManager.DataManager;
import mohak.mvpandroid.data.Model.TvModelResult;
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
    public DetailPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

    @Override
    public void getTvShowDetail(int tv_id) {

        if (!getMvpView().isNetworkAvailable()) {
            getMvpView().showError(R.string.error_message_internet_unavailable);
            return;
        }


        getMvpView().showLoading(false);

        Disposable disposable = getDataManager().getTvShowDetails(tv_id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<Response<TvShowDetail>>() {
                    @Override
                    public void onNext(@NonNull Response<TvShowDetail> tvModelResultResponse) {

                        switch (tvModelResultResponse.code()) {

                            case 200:
                                getMvpView().hideLoading(false);
                                getMvpView().TvShowDetails(tvModelResultResponse.body());
                                break;

                            case 401:
                                getMvpView().showError(R.string.missing_key);
                                getMvpView().hideLoading(false);
                                break;
                        }


                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                        getMvpView().hideLoading(false);
                        getMvpView().showError(R.string.error_message);

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        getCompositeDisposable().add(disposable);
    }
}
