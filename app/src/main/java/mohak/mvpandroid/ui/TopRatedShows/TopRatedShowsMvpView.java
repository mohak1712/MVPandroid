package mohak.mvpandroid.ui.TopRatedShows;

import mohak.mvpandroid.data.Model.TvModelResult;
import mohak.mvpandroid.ui.Base.BaseMvpView;

/**
 * Created by mohak on 4/6/17.
 */

public interface TopRatedShowsMvpView extends BaseMvpView {

     void fetchedList(TvModelResult result);
}
