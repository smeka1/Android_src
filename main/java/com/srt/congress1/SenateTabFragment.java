package com.srt.congress1;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import android.os.AsyncTask;

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


public class SenateTabFragment extends Fragment implements OnClickListener{


    public static final String TAG = "legisActivity";
    public List<legis.ResultsB> house;
    // public List<legis.ResultsB> house;
    JsonArray res;

    String[] fruits = {"Android ListView Example","ListVIew Android","Simple Android ListView","HListView in Android",
            "JAndroid ListView Example","PListVIew Android","ESimple Android ListView","hhhListView in Android",
            "UYYAndroid ListView Example","vvListVIew Android","sssSimple Android ListView","7ListView in Android"};
    Map<String, Integer> mapIndex;
    ListView fruitList;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.primary_layout,null);
        fruitList = (ListView) rootView.findViewById(R.id.list_fruits);
        new legisFetcher(getActivity(),fruitList).execute("");

        return rootView;
    }

    public void getIndexList(String[] fruits) {
        mapIndex = new LinkedHashMap<String, Integer>();
        for (int i = 0; i < fruits.length; i++) {
            String fruit = fruits[i];
            String index = fruit.substring(0, 1);

            if (mapIndex.get(index) == null)
                mapIndex.put(index, i);
        }
    }

    private void displayIndex(View v) {
        LinearLayout indexLayout = (LinearLayout) v.findViewById(R.id.side_index);

        TextView textView;
        List<String> indexList = new ArrayList<String>(mapIndex.keySet());
        for (String index : indexList) {
            textView = (TextView) getActivity().getLayoutInflater().inflate(
                    R.layout.side_index_item, null);
            textView.setText(index);
            textView.setOnClickListener(this);
            indexLayout.addView(textView);
        }
    }


    public void onClick(View view) {
        TextView selectedIndex = (TextView) view;
        fruitList.setSelection(mapIndex.get(selectedIndex.getText()));
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(com.srt.congress1.R.menu.menu_main, menu);
        super.onCreateOptionsMenu(menu,inflater);
        //return true;
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
        public static final String SERVER_URL = "http://104.198.0.197:8080/legislators?&per_page=all&chamber=senate";
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

                    int beg = server_response.indexOf('{');
                    int beg1 = server_response.lastIndexOf('}') + 1;

                    try {

                        GsonBuilder gsonBuilder = new GsonBuilder();
                        gsonBuilder.setDateFormat("yyyy-MM-dd");
                        Gson gson = gsonBuilder.create();
                        JsonObject jsonObject = (new JsonParser()).parse(server_response).getAsJsonObject();
                        res = jsonObject.getAsJsonArray("results"); //res.get(0).getAsString("");  //res.get
                        //Log.e("jjj", " " + res);
                        //house = new ArrayList<legis.ResultsB>();
                        house = Arrays.asList(gson.fromJson(res, legis.ResultsB[].class));
                        for (int i = 0; i < house.size(); i++) {
                            house.get(i).fav = false;
                            house.get(i).name = (house.get(i).last_name + ", ").concat(house.get(i).first_name);
                            house.get(i).imageurl = "https://theunitedstates.io/images/congress/original/" + house.get(i).bioguide_id + ".jpg";
                            //int dist = Integer.parseInt(house.get(i).district);
                            if( house.get(i).district > 0)
                                house.get(i).line2 = "("+house.get(i).party + ")" + house.get(i).state_name + " - District "+house.get(i).district;
                            else
                                house.get(i).line2 = "("+house.get(i).party + ")" + house.get(i).state_name + " - District N.A";
                            house.get(i).fav=false;
                            // Log.e("house[0]", " Line2 is " + house.get(i).line2 + "  " + i);
                        }

                        // house.set(0,house.get(2));
                        // Log.e ("house", house.get(0).toString());
                        //  house.set(1,house.get(7));

                    } catch (Exception ex) {
                        Log.e(TAG, "Failed to parse JSON due to: " + ex);
                        //failedLoadinghouse();
                    }
                } else {
                    Log.e(TAG, "Server responded with status code: " + statusLine.getStatusCode());
                    // failedLoadinghouse();
                }
            } catch (Exception ex) {
                Log.e(TAG, "Failed to send HTTP POST request due to: " + ex);
                // failedLoadingPosts();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {

            //JsonObject arr = new JsonObject((JsonObject)res);

            // Log.e("ress", res.get(6).toString());
            // Log.e("postsname", posts.get(7).name);
            //Log.e("postsname", posts.get(2).name);
            ArrayList<String> liness= new ArrayList<String>();
            final ArrayList<String> names= new ArrayList<String>();
            ArrayList<String> urls= new ArrayList<String>();



            Collections.sort(house, new Comparator<legis.ResultsB>(){
                public int compare(legis.ResultsB emp1, legis.ResultsB emp2) {
                    // ## Ascending order
                    return emp1.name.compareToIgnoreCase(emp2.name);
                    // return Integer.valueOf(emp1.getId()).compareTo(emp2.getId()); // To compare integer value
                    // ## Descending order
                    // return emp2.getFirstName().compareToIgnoreCase(emp1.getFirstName()); // To compare string values
                }
            });


            for(int i=0;i<house.size();i++) {
                liness.add(i, "" + house.get(i).line2);
                names.add(i,house.get(i).name);
                urls.add(i,house.get(i).imageurl);
            }
            String[] linesa = liness.toArray( new String[liness.size()]);
            String[] namesa = names.toArray( new String[names.size()]);
            String[] urlsa = urls.toArray( new String[urls.size()]);
            getIndexList(namesa);
            displayIndex(getView());

            customadapter1 adapter = new customadapter1(getActivity(),namesa,linesa,urlsa);
            if(house.size() >0)
            {
                ListView lv= (ListView)mGridView.findViewById(com.srt.congress1.R.id.list_fruits);
                lv.setAdapter(adapter);  // lv.setBackgroundResource(R.drawable.listbb);

                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Intent myIntent = new Intent(getActivity(), gdLActivity.class);
                        //Bundle bundle = new Bundle();
                        //bundle.putSerializable("value", house);
                        try {

                            Bundle b = new Bundle();
                            b.putSerializable("namesss",house.get(position) );
                            //myIntent.putExtra("namesss",res.get(position).toString());
                            //myIntent.putExtra("sendinghouse",house);
                            //getActivity().
                            myIntent.putExtras(b);
                            startActivity(myIntent);
                            // List<legis.ResultsB> tr = new List<legis.ResultsB>();
                            //house.get(5);

                        } catch (Exception e)
                        { Log.e("inten", e.toString()); }
                    }
                    //mGridView.setAdapter(adapter);
                });



            }

        }


    } }
