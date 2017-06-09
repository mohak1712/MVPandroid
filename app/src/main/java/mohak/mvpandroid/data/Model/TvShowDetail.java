package mohak.mvpandroid.data.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mohak on 25/5/17.
 */

public class TvShowDetail implements Parcelable {

    @SerializedName("original_name")
    private String showName;
    @SerializedName("overview")
    private String synopsis;
    @SerializedName("vote_average")
    private float rating;
    @SerializedName("first_air_date")
    private String airDate;

    protected TvShowDetail(Parcel in) {
        showName = in.readString();
        synopsis = in.readString();
        rating = in.readFloat();
        airDate = in.readString();
    }

    public static final Creator<TvShowDetail> CREATOR = new Creator<TvShowDetail>() {
        @Override
        public TvShowDetail createFromParcel(Parcel in) {
            return new TvShowDetail(in);
        }

        @Override
        public TvShowDetail[] newArray(int size) {
            return new TvShowDetail[size];
        }
    };

    public String getAirDate() {
        return airDate;
    }

    public String getShowName() {
        return showName;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public float getRating() {
        return rating;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(showName);
        parcel.writeString(synopsis);
        parcel.writeFloat(rating);
        parcel.writeString(airDate);
    }
}
