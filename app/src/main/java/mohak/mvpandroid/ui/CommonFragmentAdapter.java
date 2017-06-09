package mohak.mvpandroid.ui;


import android.app.ActivityOptions;
import android.content.Context;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import mohak.mvpandroid.R;
import mohak.mvpandroid.data.Model.TvModel;

/**
 * Created by mohak on 4/6/17.
 */

public class CommonFragmentAdapter extends BaseAdapter {

    private List<TvModel> apiData;
    private ImageClickListener listener;

    @Inject
    public CommonFragmentAdapter(ArrayList<TvModel> apiData) {
        this.apiData = apiData;
    }

    public void updateList(ArrayList<TvModel> newData) {

        apiData.addAll(newData);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return apiData.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public void setImageClickListener(ImageClickListener listener) {
        this.listener = listener;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        final CommonFragmentViewHolder holder;

        LayoutInflater inflater = (LayoutInflater) viewGroup.getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (view != null) {
            holder = (CommonFragmentViewHolder) view.getTag();
        } else {
            view = inflater.inflate(R.layout.single_getmovies, viewGroup, false);
            holder = new CommonFragmentViewHolder(view);
            view.setTag(holder);
        }


        holder.setUp(viewGroup.getContext(), apiData.get(i));
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                listener.imageClicked(apiData.get(i), holder.imageView);
            }
        });


        return view;
    }

    public interface ImageClickListener {

        void imageClicked(TvModel model, ImageView options);
    }
}
