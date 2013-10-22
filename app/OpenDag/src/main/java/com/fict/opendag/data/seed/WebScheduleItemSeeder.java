package com.fict.opendag.data.seed;

import android.os.AsyncTask;
import android.util.Log;

import com.fict.opendag.data.EntityManager;
import com.fict.opendag.model.ScheduleItem;

import java.io.IOException;
import java.io.InputStream;
//import java.io.UnsupportedEncodingException;
//import java.net.MalformedURLException;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
//import com.squareup.okhttp.*;

//import org.apache.http.HttpEntity;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.impl.client.DefaultHttpClient;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.List;

import com.fict.opendag.model.TimeTable;
import com.google.gson.*;

//import net.minidev.json.JSONObject;
//import net.minidev.json.JSONValue;

/**
 * Created by Kaj on 23-9-13.
 */
public class WebScheduleItemSeeder implements IScheduleItemSeeder {

//    private OkHttpClient _client;

    private final String _apiUrl = "http://opendagzuyd2013-001-site1.smarterasp.net/api/TimeTable";

    private final String LOG_TAG = "WebScheduleItemSeeder";

    private final String TAG_TIMETABLE = "TIMETABLE_SEEDER";

    private ArrayList<ScheduleItem> _items = null;

    public WebScheduleItemSeeder() {
//        this._client = new OkHttpClient();
    }

    public ArrayList<ScheduleItem> seed() {
        //ArrayList<ScheduleItem> items = new ArrayList<ScheduleItem>();

        FetchItemsTask fetcher = new FetchItemsTask();
        fetcher.execute(this._apiUrl);

        // Blocking wait.
        // Very dirty!
        // Do not try this stuff at home!
        while ( this._items == null ) {
            // wait with seeding until the items are
            // actually fetched from server and processed
        }

        return this._items;
    }

    private void doneFetching(ArrayList<ScheduleItem> items) {
        //this._studies = studies;
        this._items = items;
//        EntityManager em = EntityManager.getInstance();
//        em.seedScheduleItems(this);
    }

    private class FetchItemsTask extends AsyncTask<String, Void, ArrayList<ScheduleItem>> {
        protected ArrayList<ScheduleItem> doInBackground(String... urls) {
            Gson gson = new Gson();
            ArrayList<ScheduleItem> ret = new ArrayList<ScheduleItem>();

            try {
                // fetch JSON string from API
                String result = readJsonFromUrl(urls[0]);

                // parse the JSON string
                // in this case, we have fetched an array of studies
                JsonParser parser = new JsonParser();
                JsonArray array = parser.parse(result).getAsJsonArray();

                // some declarations
                JsonObject jsonTimeTable, jsonItem;
                JsonArray items;
                TimeTable tt;
                ScheduleItem si;

                jsonTimeTable = array.get(0).getAsJsonObject();
                items = jsonTimeTable.getAsJsonArray("TimeTableEntries");

                // loop through the fetched studies and process them one by one
                for ( int i = 0; i < items.size(); i++ ) {

                    // look closely at the structure of the JSON string
                    // to find out how to parse the various elements
                    // and arrays in the correct order
                    //jsonTimeTable = array.get(i).getAsJsonObject();
                    //items = jsonTimeTable.get("Information").getAsJsonArray();
                    jsonItem = items.get(i).getAsJsonObject();

                    // build our StudyInfo object from JsonObject
                    si = new ScheduleItem(
                            jsonItem.get("Id").getAsInt(),
                            jsonItem.get("StartTime").getAsString(),
                            jsonItem.get("EndTime").getAsString(),
                            jsonItem.get("Title").getAsString(),
                            jsonItem.get("Location").getAsString(),
                            jsonItem.get("Description").getAsString(),
                            "",
                            jsonItem.get("WholeDay").getAsBoolean()
                    );

                    ret.add(si);

                }

            } catch ( IOException exc ) {
                Log.d(LOG_TAG, "Couldn't fetch the result.");
            }

            return ret;

        }

        protected void onPostExecute(ArrayList<ScheduleItem> result) {
            doneFetching(result);
//            _studies = result;
        }

        private String readAll(Reader rd) throws IOException {
            StringBuilder sb = new StringBuilder();
            int cp;
            while ((cp = rd.read()) != -1) {
                sb.append((char) cp);
            }
            return sb.toString();
        }

        public String readJsonFromUrl(String url) throws IOException {
            InputStream is = new URL(url).openStream();
            try {
                BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
                String jsonText = readAll(rd);
                return jsonText;
            } finally {
                is.close();
            }
        }
    }

}
