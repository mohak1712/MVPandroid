package mohak.mvpandroid.ui.TopRatedShows;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import mohak.mvpandroid.R;
import mohak.mvpandroid.Utils.Constants;
import mohak.mvpandroid.data.Model.TvModel;

/**
 * Created by mohak on 5/6/17.
 */

public class TopRatedShowsViewHolder {

    @BindView(R.id.poster)
    ImageView imageView;

    public TopRatedShowsViewHolder(View view) {
        ButterKnife.bind(this, view);
    }

    public void setUp(Context context, TvModel model) {

        Picasso.with(context).load(Constants.ImgUrl + model.getImgLink()).into(imageView, new Callback() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError() {

            }
        });

    }
}
