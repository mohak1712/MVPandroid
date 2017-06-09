package mohak.mvpandroid.data.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mohak on 25/5/17.
 */

public class TvModel implements Parcelable{

    @SerializedName("poster_path")
    private String imgLink;

    @SerializedName("id")
    private int tv_id;


    protected TvModel(Parcel in) {
        imgLink = in.readString();
        tv_id = in.readInt();
    }

    public static final Creator<TvModel> CREATOR = new Creator<TvModel>() {
        @Override
        public TvModel createFromParcel(Parcel in) {
            return new TvModel(in);
        }

        @Override
        public TvModel[] newArray(int size) {
            return new TvModel[size];
        }
    };

    public String getImgLink() {
        return imgLink;
    }

    public int getTvId() {
        return tv_id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(imgLink);
        parcel.writeInt(tv_id);
    }
}
