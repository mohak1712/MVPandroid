package mohak.mvpandroid.ui.PopularShows;

import android.util.Log;

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
import mohak.mvpandroid.ui.Base.BasePresenter;
import retrofit2.Response;

/**
 * Created by mohak on 4/6/17.
 */

public class PopularShowsPresenter<V extends PopularShowsMvpView> extends BasePresenter<V> implements PopularShowsMvpPresenter<V> {

    private boolean bottomProgress = false;

    @Inject
    public PopularShowsPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

    @Override
    public void fetchPopularTvListFromApi(String pgNo) {

        if (!getMvpView().isNetworkAvailable()) {
            getMvpView().showError(R.string.error_message_internet_unavailable);
            return;
        }

        if (!pgNo.equals("1"))
            bottomProgress = true;

        getMvpView().showLoading(bottomProgress);

        Disposable disposable = getDataManager().getTvPopularList(pgNo)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<Response<TvModelResult>>() {
                    @Override
                    public void onNext(@NonNull Response<TvModelResult> tvModelResultResponse) {

                        switch (tvModelResultResponse.code()){

                            case 200:
                                getMvpView().fetchedList(tvModelResultResponse.body());
                                getMvpView().hideLoading(bottomProgress);
                                break;

                            case 401:
                                getMvpView().showError(R.string.missing_key);
                                getMvpView().hideLoading(bottomProgress);
                                break;
                        }


                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                        getMvpView().showError(R.string.something_wrong);
                        getMvpView().hideLoading(bottomProgress);

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        getCompositeDisposable().add(disposable);
    }
}
