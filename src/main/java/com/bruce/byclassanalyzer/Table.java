package com.bruce.byclassanalyzer;

import java.util.List;

/**
 * Created by bruceyuan on 17-9-16.
 */
public class Table<T> extends ClassElement{
    //private UBase count;
    private List<T> items;

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
