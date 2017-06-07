package mohak.mvpandroid.ui.Detail;

import mohak.mvpandroid.data.Model.TvShowDetail;
import mohak.mvpandroid.ui.Base.BaseMvpView;
import retrofit2.Call;

/**
 * Created by mohak on 7/6/17.
 */

public interface DetailMvpView extends BaseMvpView{

    void TvShowDetails(TvShowDetail detail);

}
