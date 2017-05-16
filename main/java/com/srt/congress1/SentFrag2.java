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


public class SentFrag2 extends Fragment implements OnClickListener
{

    public static final String TAG = "billsActivity";
    public List<Bills> bills;

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

        View rootView = inflater.inflate(R.layout.sent_layout,null);

        fruitList = (ListView) rootView.findViewById(R.id.listbills);
        new legisFetcher(getActivity(),fruitList).execute("");
        return rootView;
    }


    public void onClick(View view) {
        //    TextView selectedIndex = (TextView) view;
        // fruitList.setSelection(mapIndex.get(selectedIndex.getText()));
    }



    class legisFetcher extends AsyncTask<String, String, String>
    {

        Activity mContex;
        ListView mGridView;

        public  legisFetcher (Activity contex,ListView gview)
        {
            this.mGridView=gview;
            this.mContex=contex;
        }


        private static final String TAG = "PostFetcher";
        public static final String SERVER_URL = "http://php1.ikcpvqh2ya.us-west-2.elasticbeanstalk.com/?url1=http://104.198.0.197:8080/bills?&per_page=50&history.active=false&order=introduced_on__desc&last_version.urls.pdf__exists=true";
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
                        gsonBuilder.setDateFormat("yyyy-MM-dd");
                        Gson gson = gsonBuilder.create();
                        JsonObject jsonObject = (new JsonParser()).parse(server_response).getAsJsonObject();
                        res = jsonObject.getAsJsonArray("results"); //res.get(0).getAsString("");  //res.get
                        //Log.e("jjj", " " + res);
                        //bills.get(i).last_version.urls.pdf
                        //bills = new ArrayList<legis.ResultsB>();
                        bills = Arrays.asList(gson.fromJson(res, Bills[].class));
                        for (int i = 0; i < bills.size(); i++) {
                            bills.get(i).fav = false;
                            int mm = Integer.parseInt( bills.get(i).introduced_on.substring(5,7));
                            int dd = Integer.parseInt( bills.get(i).introduced_on.substring(8,10));
                            int yy = Integer.parseInt( bills.get(i).introduced_on.substring(0,4));
                            bills.get(i).intro = new DateFormatSymbols().getShortMonths()[mm-1]+ " "+dd+","+yy;

                            bills.get(i).spname = bills.get(i).sponsor.title +". "+bills.get(i).sponsor.last_name +"," + bills.get(i).sponsor.first_name;
                            bills.get(i).status = "New";
                            // urls.congresss    null check    urls.congresss    null check
                            //  last_version . version_name  b ills.get(i).last_version.version_name
                            // urls.pdf    bills.get(i).last_version.urls.pdf       null check    urls.congresss    null check
                            //Log.e("bills[0]", " Intro on is " + bills.get(i).introduced_on + "  " + i);
                        }

                        // bills.set(0,bills.get(2));
                        // Log.e ("bills", bills.get(0).toString());
                        //  bills.set(1,bills.get(7));

                    } catch (Exception ex) {
                        Log.e(TAG, "Failed to parse JSON due to: " + ex);
                        //failedLoadingbills();
                    }
                } else {
                    Log.e(TAG, "Server responded with status code: " + statusLine.getStatusCode());
                    // failedLoadingbills();
                }
            } catch (Exception ex) {
                Log.e(TAG, "Failed to send HTTP POST request due to: " + ex);
                //failedLoadingbills();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {

            String st[]= new String[bills.size()];

            for(int i=0;i<bills.size();i++) {
                st[i] = bills.get(i).history.active_at;
            }
            customadapter2 adapter = new customadapter2(getActivity(), st, bills);

            if(bills.size() >0)
            {
                ListView lv= (ListView)mGridView.findViewById(R.id.listbills);
                lv.setAdapter(adapter);
                Log.e("LV", lv.toString());
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Intent myIntent = new Intent(getActivity(), BillActivity.class);
                        // Bundle bundle = new Bundle();
                        // bundle.putSerializable("value", bills.get(position));
                        try {

                            Bundle b = new Bundle();
                            b.putSerializable("namesss",bills.get(position) );
                            myIntent.putExtras(b);
                            startActivity(myIntent);

                        } catch (Exception e)
                        {
                            String stackTrace = Log.getStackTraceString(e);
                            Log.e("java", e.toString());
                            Log.e("",stackTrace);
                        }
                    }

                });
                // mGridView.setAdapter(adapter);
            }

        }

    }


}


