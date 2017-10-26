package com.spaja.aatdiscussionscc1;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Spaja on 26-Oct-17.
 */

public class Data extends RealmObject {

    private int flag;
    private String name;
    @PrimaryKey
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
