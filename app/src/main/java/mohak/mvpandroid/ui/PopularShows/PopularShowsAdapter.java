package mohak.mvpandroid.ui.PopularShows;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

import mohak.mvpandroid.R;
import mohak.mvpandroid.data.Model.TvModel;

/**
 * Created by mohak on 4/6/17.
 */

public class PopularShowsAdapter extends BaseAdapter {

    private List<TvModel> apiData;

    @Inject
    public PopularShowsAdapter(ArrayList<TvModel> apiData) {
        this.apiData = apiData;
    }

    void updateList(ArrayList<TvModel> newData) {

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

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        PopularShowsViewHolder holder;

        LayoutInflater inflater = (LayoutInflater)viewGroup.getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (view != null) {
            holder = (PopularShowsViewHolder) view.getTag();
        } else {
            view = inflater.inflate(R.layout.single_getmovies, viewGroup, false);
            holder = new PopularShowsViewHolder(view);
            view.setTag(holder);
        }

        holder.setUp(viewGroup.getContext(),apiData.get(i));
        return view;
    }
}
