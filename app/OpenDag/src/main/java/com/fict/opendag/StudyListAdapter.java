package com.fict.opendag;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.fict.opendag.model.Study;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Kaj on 22-10-13.
 */
public class StudyListAdapter extends BaseAdapter {

    /**
     * Layout inflater for this listitem.
     */
    private LayoutInflater _inflater;

    /**
     * Items contained in listview.
     */
    private ArrayList<Study> _items;

    /**
     *
     * @param context application context
     * @param items list of devices
     */
    public StudyListAdapter(Context context, Map<Integer, Study> items) {
        this._inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this._items = new ArrayList<Study>();
        for ( Map.Entry<Integer, Study> entry : items.entrySet() ) {
            this._items.add(entry.getValue());
        }
    }

    /**
     * Gets amount of item in adapter.
     * @return item count
     */
    @Override
    public int getCount() {
        return this._items.size();
    }

    /**
     * Gets item at specified index.
     * @param position index
     * @return item at index {@position}
     */
    @Override
    public Study getItem(int position) {
        return this._items.get(position);
    }

    /**
     * Gets ID of item at specified index.
     * @param position index
     * @return id of item at index {@position}
     */
    @Override
    public long getItemId(int position) {
        return this._items.get(position).getId();
//        return position;
    }

    /**
     * View holder for door list items.
     */
    static class StudyListItemViewHolder {
        public TextView name;
    }

    /**
     * Fills list item view with information about a door. Data is
     * passed by using the viewholder pattern.
     * @param position index of item to display in list item
     * @param convertView
     * @param parent
     * @return list item view filled with data of item at index {@position}
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        StudyListItemViewHolder holder;

        if ( convertView == null ) {
            convertView = this._inflater.inflate(R.layout.study_list_item, parent, false);
            holder = new StudyListItemViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.txt_study_list_item);
            convertView.setTag(holder);
        } else {
            holder = (StudyListItemViewHolder) convertView.getTag();
        }

        Study item = this.getItem(position);
        holder.name.setText(item.getName());

        return convertView;
    }

}
