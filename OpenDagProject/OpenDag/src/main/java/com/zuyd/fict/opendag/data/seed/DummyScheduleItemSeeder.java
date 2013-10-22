package com.zuyd.fict.opendag.data.seed;

import com.zuyd.fict.opendag.data.seed.IScheduleItemSeeder;
import com.zuyd.fict.opendag.model.ScheduleItem;

import java.util.ArrayList;

/**
 * Created by Kaj on 18-9-13.
 */
public class DummyScheduleItemSeeder implements IScheduleItemSeeder {

    public ArrayList<ScheduleItem> seed() {
        ArrayList<ScheduleItem> items = new ArrayList<ScheduleItem>();
        items.add(new ScheduleItem(1, "10.00", "11.00", "Welkomstpraatje", "B3.204", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc ornare, massa auctor suscipit laoreet, erat urna laoreet enim, a ullamcorper diam nisl vel nisi. Duis eu elementum sapien. Cras venenatis urna placerat augue rutrum, nec venenatis dolor gravida. Ut scelerisque scelerisque dui sed fermentum. Aliquam gravida mollis tellus vel dictum.", "Marcel Schmitz", true));
        items.add(new ScheduleItem(2, "11.00", "11.30", "Presentatie", "B3.206", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc ornare, massa auctor suscipit laoreet, erat urna laoreet enim, a ullamcorper diam nisl vel nisi. Duis eu elementum sapien. Cras venenatis urna placerat augue rutrum, nec venenatis dolor gravida. Ut scelerisque scelerisque dui sed fermentum. Aliquam gravida mollis tellus vel dictum.", "Chris Kockelkoren", true));
        items.add(new ScheduleItem(3, "11.30", "12.00", "Meet & Greet", "B3.206", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc ornare, massa auctor suscipit laoreet, erat urna laoreet enim, a ullamcorper diam nisl vel nisi. Duis eu elementum sapien. Cras venenatis urna placerat augue rutrum, nec venenatis dolor gravida. Ut scelerisque scelerisque dui sed fermentum. Aliquam gravida mollis tellus vel dictum.", "Chris Kockelkoren", false));
        items.add(new ScheduleItem(4, "12.00", "12.30", "Presentatie", "B3.206", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc ornare, massa auctor suscipit laoreet, erat urna laoreet enim, a ullamcorper diam nisl vel nisi. Duis eu elementum sapien. Cras venenatis urna placerat augue rutrum, nec venenatis dolor gravida. Ut scelerisque scelerisque dui sed fermentum. Aliquam gravida mollis tellus vel dictum.", "Chris Kockelkoren", true));
        items.add(new ScheduleItem(5, "12.30", "13.00", "Meet & Greet", "B3.206", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc ornare, massa auctor suscipit laoreet, erat urna laoreet enim, a ullamcorper diam nisl vel nisi. Duis eu elementum sapien. Cras venenatis urna placerat augue rutrum, nec venenatis dolor gravida. Ut scelerisque scelerisque dui sed fermentum. Aliquam gravida mollis tellus vel dictum.", "Chris Kockelkoren", false));
        items.add(new ScheduleItem(6, "13.00", "13.30", "Presentatie", "B3.206", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc ornare, massa auctor suscipit laoreet, erat urna laoreet enim, a ullamcorper diam nisl vel nisi. Duis eu elementum sapien. Cras venenatis urna placerat augue rutrum, nec venenatis dolor gravida. Ut scelerisque scelerisque dui sed fermentum. Aliquam gravida mollis tellus vel dictum.", "Chris Kockelkoren", false));
        items.add(new ScheduleItem(7, "13.30", "14.00", "Meet & Greet", "B3.206", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc ornare, massa auctor suscipit laoreet, erat urna laoreet enim, a ullamcorper diam nisl vel nisi. Duis eu elementum sapien. Cras venenatis urna placerat augue rutrum, nec venenatis dolor gravida. Ut scelerisque scelerisque dui sed fermentum. Aliquam gravida mollis tellus vel dictum.", "Chris Kockelkoren", true));

        return items;
    }

}
