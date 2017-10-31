package com.spaja.aatdiscussionscc1.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Spaja on 31-Oct-17.
 */

public class Response {

    @SerializedName ("obj")
    private First first;

    public First getFirst() {
        return first;
    }

    public void setFirst(First first) {
        this.first = first;
    }
}
