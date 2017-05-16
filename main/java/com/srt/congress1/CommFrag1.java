package com.srt.congress1;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class CommFrag1 extends Fragment implements OnClickListener
{

    public static final String TAG = "commsActivity";
    public List<Committees> comms;

    JsonArray res;

    ListView fruitList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // getActivity().getActionBar().setTitle("Home");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //return inflater.inflate(com.srt.congress1.R.layout.sent_layout,null);

        View rootView = inflater.inflate(R.layout.commlayout,null);

        fruitList = (ListView) rootView.findViewById(R.id.listcomm);
        new commsFetcher(getActivity(),fruitList).execute("");
        return rootView;
    }


    public void onClick(View view) {
        //    TextView selectedIndex = (TextView) view;
        // fruitList.setSelection(mapIndex.get(selectedIndex.getText()));
    }


    class commsFetcher extends AsyncTask<String, String, String>
    {

        Activity mContex;
        ListView mGridView;

        public  commsFetcher (Activity contex,ListView gview)
        {
            this.mGridView=gview;
            this.mContex=contex;
        }


        private static final String TAG = "PostFetcher";
        public static final String SERVER_URL = "http://php1.ikcpvqh2ya.us-west-2.elasticbeanstalk.com/?url1=http://104.198.0.197:8080/committees?&per_page=all&chamber=house&order=name__asc";
        //http://php1.ikcpvqh2ya.us-west-2.elasticbeanstalk.com/?url1=http://104.198.0.197:8080/legislators?&per_page=20
        @Override
        protected String doInBackground(String... params) {
            try {
                //Create an HTTP client
                HttpClient client = new DefaultHttpClient();
                HttpGet post = new HttpGet(SERVER_URL);

                //Perform the request and check the status code
                HttpResponse response = client.execute(post);
                StatusLine statusLine = response.getStatusLine();
                if (statusLine.getStatusCode() == 200) {
                    String server_response = EntityUtils.toString(response.getEntity());

                    //int beg = server_response.indexOf('{');
                    //int beg1 = server_response.lastIndexOf('}') + 1;

                    try {

                        GsonBuilder gsonBuilder = new GsonBuilder();
                        //gsonBuilder.setDateFormat("yyyy-MM-dd");
                        Gson gson = gsonBuilder.create();
                        JsonObject jsonObject = (new JsonParser()).parse(server_response).getAsJsonObject();
                        res = jsonObject.getAsJsonArray("results"); //res.get(0).getAsString("");  //res.get
                        //Log.e("jjj", " " + res);
                        //comms = new ArrayList<legis.ResultsB>();
                        comms = Arrays.asList(gson.fromJson(res, Committees[].class));
                        for (int i = 0; i < comms.size(); i++) {
                            comms.get(i).fav = false;

                            //Log.e("comms[0]", " Intro on is " + comms.get(i).introduced_on + "  " + i);
                        }

                        // comms.set(0,comms.get(2));
                        // Log.e ("comms", comms.get(0).toString());
                        //  comms.set(1,comms.get(7));

                    } catch (Exception ex) {
                        Log.e(TAG, "Failed to parse JSON due to: " + ex);
                        //failedLoadingcomms();
                    }
                } else {
                    Log.e(TAG, "Server responded with status code: " + statusLine.getStatusCode());
                    // failedLoadingcomms();
                }
            } catch (Exception ex) {
                Log.e(TAG, "Failed to send HTTP POST request due to: " + ex);
                //failedLoadingcomms();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {

            String st[]= new String[comms.size()];

            for(int i=0;i<comms.size();i++) {
                st[i] = comms.get(i).name;

            }
            customadapter3 adapter = new customadapter3(getActivity(), st, comms);

            if(comms.size() >0)
            {
                ListView lv= (ListView)mGridView.findViewById(R.id.listcomm);
                lv.setAdapter(adapter);
                //Log.e("LV", lv.toString());
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Intent myIntent = new Intent(getActivity(), CommActivity.class);
                        //Bundle bundle = new Bundle();
                        //bundle.putSerializable("value", comms);
                        try {

                            Bundle b = new Bundle();
                            b.putSerializable("namesss",comms.get(position) );
                            myIntent.putExtras(b);
                            startActivity(myIntent);

                        } catch (Exception e)
                        { Log.e("inten", e.toString()); }
                    }

                });
                // mGridView.setAdapter(adapter);
            }

        }

    }


}


