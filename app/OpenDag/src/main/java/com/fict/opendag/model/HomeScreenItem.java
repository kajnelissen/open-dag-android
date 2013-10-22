package com.fict.opendag.model;

/**
 * Created by Kaj on 19-9-13.
 */
public class HomeScreenItem {

    private HomeScreenItemType _item;

    private String _title;

    public HomeScreenItem(HomeScreenItemType item, String title) {
        this._item = item;
        this._title = title;
    }

    public HomeScreenItemType getItem() {
        return this._item;
    }

    public String getTitle() {
        return this._title;
    }

}
