package mohak.mvpandroid.ui;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mohak.mvpandroid.R;
import mohak.mvpandroid.Utils.Constants;
import mohak.mvpandroid.data.Model.TvModel;

/**
 * Created by mohak on 5/6/17.
 */

public class CommonFragmentViewHolder {

    @BindView(R.id.poster)
    ImageView imageView;

    public CommonFragmentViewHolder(View view) {
        ButterKnife.bind(this, view);
    }

    public void setUp(Context context, TvModel model) {

        Picasso.with(context).load(Constants.ImgUrl + model.getImgLink()).into(imageView);

    }
}
