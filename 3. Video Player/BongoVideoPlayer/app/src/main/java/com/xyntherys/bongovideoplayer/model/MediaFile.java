package com.xyntherys.bongovideoplayer.model;

//
// Created by Azmain Adel on 11/6/19.
// Copyright (c) 2019 Field Buzz. All rights reserved.
//

public class MediaFile {
    private String title;
    private String media_url;
    private String thumbnail;
    private String description;

    public MediaFile(String title, String media_url, String thumbnail, String description) {
        this.title = title;
        this.media_url = media_url;
        this.thumbnail = thumbnail;
        this.description = description;
    }

    public MediaFile(String title, String media_url) {
        this.title = title;
        this.media_url = media_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMedia_url() {
        return media_url;
    }

    public void setMedia_url(String media_url) {
        this.media_url = media_url;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
