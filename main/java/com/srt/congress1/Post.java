package com.srt.congress1;

/**
 * Created by sriram on 11/22/16.
 */

//Post.java
import java.util.Date;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Post {

    @SerializedName("id")
    public long ID;
    public String title;
    public String author;
    public String url;
    @SerializedName("date")
    public Date dateCreated;
    public String body;

    public List<Tag> tags;

    public Post() {

    }
}