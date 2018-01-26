package com.os.youtubeandroidapi;

/**
 * Created by MacOS on 24/01/2018.
 */

public class VideoYoutube {
    private String title;
    private String thumbnail;
    private String idvide;

    public VideoYoutube(String title, String thumbnail, String idvide) {
        this.title = title;
        this.thumbnail = thumbnail;
        this.idvide = idvide;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getIdvide() {
        return idvide;
    }

    public void setIdvide(String idvide) {
        this.idvide = idvide;
    }
}
