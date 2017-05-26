package mohak.mvpandroid.data.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mohak on 25/5/17.
 */

public class TvModel {

    @SerializedName("poster_path")
    private String imgLink;

    @SerializedName("overview")
    private String overview;

    @SerializedName("name")
    private String name;


    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
