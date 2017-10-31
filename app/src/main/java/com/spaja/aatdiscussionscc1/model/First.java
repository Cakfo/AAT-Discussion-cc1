package com.spaja.aatdiscussionscc1.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Spaja on 31-Oct-17.
 */

class First {

    @SerializedName ("obj2")
    private ArrayList<Second> seconds;

    @SerializedName ("obj2")
    @Expose (serialize = false)
    private Second second;

    public Second getSecond() {
        return second;
    }

    public void setSecond(Second second) {
        this.second = second;
    }

    public ArrayList<Second> getSeconds() {
        return seconds;
    }

    public void setSeconds(ArrayList<Second> seconds) {
        this.seconds = seconds;
    }

}
