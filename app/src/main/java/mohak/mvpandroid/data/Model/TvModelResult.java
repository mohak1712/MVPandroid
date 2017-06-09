package mohak.mvpandroid.data.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mohak on 4/6/17.
 */

public class TvModelResult implements Parcelable{

    @SerializedName("results")
    private TvModel[] models;

    protected TvModelResult(Parcel in) {
        models = in.createTypedArray(TvModel.CREATOR);
    }

    public static final Creator<TvModelResult> CREATOR = new Creator<TvModelResult>() {
        @Override
        public TvModelResult createFromParcel(Parcel in) {
            return new TvModelResult(in);
        }

        @Override
        public TvModelResult[] newArray(int size) {
            return new TvModelResult[size];
        }
    };

    public TvModel[] getModels() {
        return models;
    }

    public void setModels(TvModel[] models) {
        this.models = models;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(models, i);
    }
}
