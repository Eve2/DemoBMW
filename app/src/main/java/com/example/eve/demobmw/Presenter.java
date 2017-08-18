package com.example.eve.demobmw;

import java.util.ArrayList;

/**
 * Created by Eve on 8/17/17.
 */

public class Presenter {

    private static Presenter mInstance;
    private ArrayList<LocationInfo> list = null;

    public static Presenter getInstance() {
        if(mInstance == null)
            mInstance = new Presenter();

        return mInstance;
    }

    private Presenter() {
        list = new ArrayList<LocationInfo>();
    }

    public ArrayList<LocationInfo> getArray() {
        return this.list;
    }

    public void addToArray(LocationInfo value) {
        list.add(value);
    }


}
