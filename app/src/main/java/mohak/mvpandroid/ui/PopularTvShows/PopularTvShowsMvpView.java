package mohak.mvpandroid.ui.PopularTvShows;

import mohak.mvpandroid.data.Model.TvModelResult;
import mohak.mvpandroid.ui.Base.BaseMvpView;

/**
 * Created by mohak on 4/6/17.
 */

public interface PopularTvShowsMvpView extends BaseMvpView {

     void fetchedList(TvModelResult result);
}
