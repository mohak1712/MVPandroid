package mohak.mvpandroid.data.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mohak on 15/10/16.
 */
public class TvShowDetail implements Parcelable {

    @SerializedName("original_title")
    private String movieName;
    @SerializedName("overview")
    private String synopsis;
    @SerializedName("vote_average")
    private float rating;
    @SerializedName("runtime")
    private int runtime;
    @SerializedName("release_date")
    String releaseDate;

    protected TvShowDetail(Parcel in) {
        movieName = in.readString();
        synopsis = in.readString();
        rating = in.readFloat();
        runtime = in.readInt();
        releaseDate = in.readString();
    }

    public static final Creator<movieDetail> CREATOR = new Creator<movieDetail>() {
        @Override
        public movieDetail createFromParcel(Parcel in) {
            return new movieDetail(in);
        }

        @Override
        public movieDetail[] newArray(int size) {
            return new movieDetail[size];
        }
    };

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public float getRating() {
        return rating;
    }

    public int getRuntime() {
        return runtime;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(movieName);
        parcel.writeString(synopsis);
        parcel.writeFloat(rating);
        parcel.writeInt(runtime);
        parcel.writeString(releaseDate);
    }
}
