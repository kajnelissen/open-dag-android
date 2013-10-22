package com.fict.opendag;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import android.widget.TextView;
import android.widget.BaseAdapter;

import com.fict.opendag.model.ScheduleItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Created by Kaj on 16-9-13.
 */
public class ScheduleListAdapter extends BaseAdapter {

    /**
     * Layout inflater for this listitem.
     */
    private LayoutInflater _inflater;

    /**
     * Items contained in listview.
     */
    private ArrayList<ScheduleItem> _items;

    /**
     *
     * @param context application context
     * @param items list of devices
     */
    public ScheduleListAdapter(Context context, Map<Integer, ScheduleItem> items) {
        this._inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this._items = new ArrayList<ScheduleItem>();
        for ( Entry<Integer, ScheduleItem> entry : items.entrySet() ) {
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
    public ScheduleItem getItem(int position) {
        return this._items.get(position);
    }

    /**
     * Gets ID of item at specified index.
     * @param position index
     * @return id of item at index {@position}
     */
    @Override
    public long getItemId(int position) {
        return position + 1;
//        return position;
    }

    /**
     * View holder for door list items.
     */
    static class ScheduleItemViewHolder {
        public TextView title;
        public TextView start;
        public TextView end;
        public TextView location;
        public TextView speaker;
        public TextView description;
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
        ScheduleItemViewHolder holder;

        if ( convertView == null ) {
            convertView = this._inflater.inflate(R.layout.activity_schedule_listitem, parent, false);
            holder = new ScheduleItemViewHolder();
            holder.title = (TextView) convertView.findViewById(R.id.schedule_listitem_title);
            holder.start = (TextView) convertView.findViewById(R.id.schedule_listitem_starttime);
            holder.location = (TextView) convertView.findViewById(R.id.schedule_listitem_location);
            convertView.setTag(holder);
        } else {
            holder = (ScheduleItemViewHolder) convertView.getTag();
        }

        ScheduleItem item = this.getItem(position);
        holder.start.setText(item.getStartTime());
        holder.title.setText(item.getTitle());
        holder.location.setText(item.getLocation());

        return convertView;
    }

}
