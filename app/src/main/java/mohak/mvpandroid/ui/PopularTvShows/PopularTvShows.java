package mohak.mvpandroid.ui.PopularTvShows;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import mohak.mvpandroid.R;
import mohak.mvpandroid.data.Model.TvModelResult;
import mohak.mvpandroid.ui.Base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PopularTvShows.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PopularTvShows#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PopularTvShows extends BaseFragment implements PopularTvShowsMvp{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    OnFragmentInteractionListener mListner;

    public PopularTvShows() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PopularTvShows.
     */
    // TODO: Rename and change types and number of parameters
    public static PopularTvShows newInstance(String param1, String param2) {
        PopularTvShows fragment = new PopularTvShows();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_popular_tv_shows, container, false);

        setUnBinder(ButterKnife.bind(this,view));

        return view;
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListner = null;
    }


    @Override
    public void fetchedList(TvModelResult result) {


    }
}
