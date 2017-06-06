package mohak.mvpandroid.ui.Base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.Unbinder;
import mohak.mvpandroid.di.components.ActivityComponent;

/**
 * A simple {@link Fragment} subclass.
 **/


public abstract class BaseFragment extends Fragment implements BaseMvpView {


    private OnFragmentInteractionListener mListener;

    /* refer to ButterKnife docs */
    private Unbinder unbinder;

    public BaseFragment() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }




    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public void setUnBinder(Unbinder unbinder) {
        this.unbinder = unbinder;
    }

    @Override
    public void onDestroy() {
        if (unbinder != null) {
            unbinder.unbind();
        }
        super.onDestroy();
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {

        void showErrorCallback(@StringRes int error_message);

        boolean isNetworkAvailableCallback();

        ActivityComponent getActivityComponentCallback();

    }


    @Override
    public void showError(@StringRes int error_message) {
        mListener.showErrorCallback(error_message);
    }

    @Override
    public boolean isNetworkAvailable() {
        return mListener.isNetworkAvailableCallback();
    }

    public ActivityComponent getActivityComponent() {
        return mListener.getActivityComponentCallback();
    }
}
