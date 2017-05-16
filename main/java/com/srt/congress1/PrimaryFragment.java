package com.srt.congress1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import android.content.Intent;
import android.graphics.Color;
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
import org.json.JSONObject;

public class PrimaryFragment extends Fragment implements OnClickListener{

    public static final String TAG = "legisActivity";
    public List<legis.ResultsB> posts;

    JsonArray res;


    String[] fruits = {"Android ListView Example","ListVIew Android","Simple Android ListView","HListView in Android",
            "JAndroid ListView Example","PListVIew Android","ESimple Android ListView","hhhListView in Android",
            "UYYAndroid ListView Example","vvListVIew Android","sssSimple Android ListView","7ListView in Android"};
    Map<String, Integer> mapIndex;
    ListView fruitList;

    @Nullable
    @Override
    public void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //legisFetcher fetcher = new legisFetcher();
        //fetcher.execute();

    }

        /*ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.listview_row, listArray);
        ListView mlistView = (ListView)findViewById(R.id.list);
        mlistView.setAdapter(adapter);  */
       /* Arrays.asList(fruits);

        fruitList = (ListView) findViewById(R.id.list_fruits);
        fruitList.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, fruits));

        getIndexList(fruits);

        displayIndex();   */

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.primary_layout,null);
        fruitList = (ListView) rootView.findViewById(R.id.list_fruits);
        new legisFetcher(getActivity(),fruitList).execute("");
         //  fruitList.setAdapter(new ArrayAdapter<String>(getActivity(),
          //  android.R.layout.simple_list_item_1, fruits ));

        return rootView;        //inflater.inflate(R.layout.primary_layout,null);
    }

    public void getIndexList(String[] fruits) {
        mapIndex = new LinkedHashMap<String, Integer>();
        for (int i = 0; i < fruits.length; i++) {
            String fruit = fruits[i].toString();
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
        inflater.inflate(R.menu.menu_main, menu);
        super.onCreateOptionsMenu(menu,inflater);
        //return true;
    }



    private void failedLoadingPosts() {
      /*  runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, "Failed to load Posts. Have a look at LogCat.", Toast.LENGTH_SHORT).show();
            }
        });  */
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
        public static final String SERVER_URL = "http://php1.ikcpvqh2ya.us-west-2.elasticbeanstalk.com/?url1=http://104.198.0.197:8080/legislators?&per_page=all";
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
                        //posts = new ArrayList<legis.ResultsB>();
                        posts = Arrays.asList(gson.fromJson(res, legis.ResultsB[].class));
                        for (int i = 0; i < posts.size(); i++) {
                            posts.get(i).fav = false;
                            posts.get(i).name = (posts.get(i).last_name + ", ").concat(posts.get(i).first_name);
                            posts.get(i).imageurl = "https://theunitedstates.io/images/congress/original/" + posts.get(i).bioguide_id + ".jpg";
                            //int dist = Integer.parseInt(posts.get(i).district);
                            if( posts.get(i).district > 0)
                            posts.get(i).line2 = "("+posts.get(i).party + ")" + posts.get(i).state_name + " - District "+posts.get(i).district;
                            else
                            posts.get(i).line2 = "("+posts.get(i).party + ")" + posts.get(i).state_name + " - District N.A";
                            posts.get(i).fav=false;
                           // Log.e("Posts[0]", " Line2 is " + posts.get(i).line2 + "  " + i);
                        }

                          // house.set(0,posts.get(2));
                         // Log.e ("house", house.get(0).toString());
                            //  house.set(1,posts.get(7));

                    } catch (Exception ex) {
                        Log.e(TAG, "Failed to parse JSON due to: " + ex);
                        failedLoadingPosts();
                    }
                } else {
                    Log.e(TAG, "Server responded with status code: " + statusLine.getStatusCode());
                    failedLoadingPosts();
                }
            } catch (Exception ex) {
                Log.e(TAG, "Failed to send HTTP POST request due to: " + ex);
                failedLoadingPosts();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {

            Collections.sort(posts, new Comparator<legis.ResultsB>(){
                public int compare(legis.ResultsB emp1, legis.ResultsB emp2) {
                    // ## Ascending order
                    return emp1.name.compareToIgnoreCase(emp2.name);
                    // return Integer.valueOf(emp1.getId()).compareTo(emp2.getId()); // To compare integer value
                    // ## Descending order
                    // return emp2.getFirstName().compareToIgnoreCase(emp1.getFirstName()); // To compare string values
                }
            });
            Collections.sort(posts, new Comparator<legis.ResultsB>(){
                public int compare(legis.ResultsB emp1, legis.ResultsB emp2) {
                    // ## Ascending order
                    return emp1.state_name.compareToIgnoreCase(emp2.state_name);
                }
            });

            ArrayList<String> liness= new ArrayList<String>();
            final ArrayList<String> names= new ArrayList<String>();
            ArrayList<String> urls= new ArrayList<String>();
            ArrayList<String> statesa= new ArrayList<String>();

            for(int i=0;i<posts.size();i++) {
                liness.add(i, "" + posts.get(i).line2);
                names.add(i,posts.get(i).name);
                urls.add(i,posts.get(i).imageurl);
                statesa.add(i,posts.get(i).state_name);
            }
            String[] linesa = liness.toArray( new String[liness.size()]);
            String[] namesa = names.toArray( new String[names.size()]);
            String[] urlsa = urls.toArray( new String[urls.size()]);
            String[] states = statesa.toArray( new String[urls.size()]);

            getIndexList(states);
            displayIndex(getView());
            //List<legis.ResultsB> pp= new List<legis.ResultsB> ;

            customadapter1 adapter = new customadapter1(getActivity(),namesa,linesa,urlsa);
        if(posts.size() >0)
        {
            ListView lv= (ListView)mGridView.findViewById(com.srt.congress1.R.id.list_fruits);
            lv.setAdapter(adapter);
            //lv.setBackgroundColor(Color.rgb(228, 228, 228));


            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent myIntent = new Intent(getActivity(), gdLActivity.class);
                    //Bundle bundle = new Bundle();
                    //bundle.putSerializable("value", posts);
                 try {

                     Bundle b = new Bundle();
                     b.putSerializable("namesss",posts.get(position) );

                     myIntent.putExtras(b);
                     startActivity(myIntent);

                } catch (Exception e)
                 { Log.e("inten", e.toString()); }
            }
        //mGridView.setAdapter(adapter);
        });



    }

}

    }  }
