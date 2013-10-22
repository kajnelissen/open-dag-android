package com.zuyd.fict.opendag;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.zuyd.fict.opendag.data.EntityManager;
import com.zuyd.fict.opendag.model.Photo;
import com.zuyd.fict.opendag.model.Question;
import com.zuyd.fict.opendag.model.ScheduleItem;
import com.zuyd.fict.opendag.model.Study;
import com.zuyd.fict.opendag.model.StudyInfo;
import com.zuyd.fict.opendag.model.TimeTable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class LoadActivity extends Activity {

    private boolean _isLoaded = false;

    private final String LOG_TAG = "LoadActivity";

    private final String API_URL_STUDIES = "http://opendagzuyd2013-001-site1.smarterasp.net/api/Study";
    private final String API_URL_SURVEY = "http://opendagzuyd2013-001-site1.smarterasp.net/api/Survey";
    private final String API_URL_SCHEDULE = "http://opendagzuyd2013-001-site1.smarterasp.net/api/TimeTable";
    private final String API_URL_NAVIGATION = "http://opendagzuyd2013-001-site1.smarterasp.net/api/NavigationRoutes/1";

    private final int FETCH_TOTAL = 4;
    private int _fetchCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);

        ImageView logo = (ImageView) findViewById(R.id.zuyd_logo);

        FetchStudiesTask fs = new FetchStudiesTask();
        fs.execute(API_URL_STUDIES);

        FetchQuestionsTask fq = new FetchQuestionsTask();
        fq.execute(API_URL_SURVEY);

        FetchScheduleItemsTask fsi = new FetchScheduleItemsTask();
        fsi.execute(API_URL_SCHEDULE);

        FetchPhotosTask fp = new FetchPhotosTask();
        fp.execute(API_URL_NAVIGATION);

        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( _isLoaded ) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.load, menu);
        return true;
    }

    private void doneFetching() {
        this._fetchCount++;
        if ( this._fetchCount == FETCH_TOTAL ) {
            this._isLoaded = true;
        }
    }

    private class FetchScheduleItemsTask extends AsyncTask<String, Void, ArrayList<ScheduleItem>> {
        protected ArrayList<ScheduleItem> doInBackground(String... urls) {
            Gson gson = new Gson();
            ArrayList<ScheduleItem> ret = new ArrayList<ScheduleItem>();

            try {
                String result = readJsonFromUrl(urls[0]);

                JsonParser parser = new JsonParser();
                JsonArray array = parser.parse(result).getAsJsonArray();

                JsonObject jsonTimeTable, jsonItem;
                JsonArray items;
                TimeTable tt;
                ScheduleItem si;

                jsonTimeTable = array.get(0).getAsJsonObject();
                items = jsonTimeTable.getAsJsonArray("TimeTableEntries");

                // loop through the fetched studies and process them one by one
                for ( int i = 0; i < items.size(); i++ ) {
                    jsonItem = items.get(i).getAsJsonObject();
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
            EntityManager em = EntityManager.getInstance();
            em.scheduleItems().add(result);
            doneFetching();
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

    private class FetchStudiesTask extends AsyncTask<String, Void, List<Study>> {
        protected List<Study> doInBackground(String... urls) {
            Gson gson = new Gson();
            ArrayList<Study> studies = new ArrayList<Study>();

            try {
                // fetch JSON string from API
                String result = readJsonFromUrl(urls[0]);

                // parse the JSON string
                // in this case, we have fetched an array of studies
                JsonParser parser = new JsonParser();
                JsonArray array = parser.parse(result).getAsJsonArray();

                // some declarations
                JsonObject study, obj;
                JsonArray info;
                StudyInfo si;
                Study s;

                // loop through the fetched studies and process them one by one
                for ( int i = 0; i < array.size(); i++ ) {

                    // look closely at the structure of the JSON string
                    // to find out how to parse the various elements
                    // and arrays in the correct order
                    study = array.get(i).getAsJsonObject();
                    info = study.get("Information").getAsJsonArray();
                    obj = info.get(0).getAsJsonObject();

                    // build our StudyInfo object from JsonObject
                    si = new StudyInfo(
                            obj.get("Id").getAsInt(),
                            obj.get("Title").getAsString(),
                            obj.get("Content").getAsString(),
                            obj.get("StudyId").getAsInt()
                    );

                    // build Study object
                    s = new Study(
                            study.get("Id").getAsInt(),
                            study.get("Name").getAsString(),
                            study.get("ShortName").getAsString(),
                            si
                    );

                    studies.add(s);

                }

            } catch ( IOException exc ) {
                Log.d(LOG_TAG, "Couldn't fetch the result.");
            }

            return studies;

        }

        protected void onPostExecute(List<Study> result) {
            EntityManager em = EntityManager.getInstance();
            em.studies().add(result);
            doneFetching();
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

    private class FetchQuestionsTask extends AsyncTask<String, Void, List<Question>> {
        protected List<Question> doInBackground(String... urls) {
            Gson gson = new Gson();
            ArrayList<Question> questions = new ArrayList<Question>();

            try {
                // fetch JSON string from API
                String result = readJsonFromUrl(urls[0]);

                JsonParser parser = new JsonParser();
                JsonArray array = parser.parse(result).getAsJsonArray();

                // some declarations
                JsonObject survey, obj;
                JsonArray qs;
                Question q;

                survey = array.get(0).getAsJsonObject();
                qs = survey.get("Questions").getAsJsonArray();

                for ( int i = 0; i < qs.size(); i++ ) {

                    // look closely at the structure of the JSON string
                    // to find out how to parse the various elements
                    // and arrays in the correct order
                    obj = qs.get(i).getAsJsonObject();

                    q = new Question(
                            obj.get("Id").getAsInt(),
                            obj.get("Text").getAsString()
                    );

                    questions.add(q);

                }

            } catch ( IOException exc ) {
                Log.d(LOG_TAG, "Couldn't fetch the result.");
            }

            return questions;
        }

        protected void onPostExecute(List<Question> result) {
            EntityManager em = EntityManager.getInstance();
            em.questions().add(result);
            doneFetching();
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

    private class FetchPhotosTask extends AsyncTask<String, Void, List<Photo>> {
        protected List<Photo> doInBackground(String... urls) {
            Gson gson = new Gson();
            ArrayList<Photo> photos = new ArrayList<Photo>();

            try {
// fetch JSON string from API
                String result = readJsonFromUrl(urls[0]);

// parse the JSON string
// in this case, we have fetched an array of studies
                JsonParser parser = new JsonParser();
//JsonArray array = parser.parse(result).getAsJsonArray();


// some declarations
                JsonObject navigationRoute, obj;
                JsonArray navigationTrack;
                Photo p;

                navigationRoute = parser.parse(result).getAsJsonObject();
                navigationTrack = navigationRoute.get("Tracks").getAsJsonArray();
                obj = navigationTrack.get(0).getAsJsonObject();

// loop through the fetched studies and process them one by one
                for ( int i = 0; i < navigationTrack.size(); i++ ) {

// look closely at the structure of the JSON string
// to find out how to parse the various elements
// and arrays in the correct order
                    obj = navigationTrack.get(i).getAsJsonObject();

// build our StudyInfo object from JsonObject
                    p = new Photo(
                            obj.get("Id").getAsInt(),
                            obj.get("Image").getAsString(),
                            obj.get("FileName").getAsString()
                    );

                    photos.add(p);
                }

// deze roept 'ie automatisch aan na afloop fetchen
//onPostExecute(photos);

            } catch ( IOException exc ) {
//Log.d(LOG_TAG, "Couldn't fetch the result.");
            }

            return photos;

        }

        protected void onPostExecute(List<Photo> result) {
            EntityManager em = EntityManager.getInstance();
            em.photos().add(result);
            doneFetching();
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
