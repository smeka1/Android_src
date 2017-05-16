package com.srt.congress1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import  java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by sriram on 11/24/16.
 */

public class gdLActivity extends Activity {

    //public static final String TAG = "legisActivity";
    //public Collection<legis.ResultsB> posts;
    public  legis.ResultsB global;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewdettable);
        Log.e("view" , "" + this.findViewById(android.R.id.content).isHardwareAccelerated());
        Intent intent = getIntent();
        //String jsonArray = intent.getStringExtra("namesss");
        Bundle b = intent.getExtras();
        //String Array1=b.getString("namesss");
        //Gson gson = new GsonBuilder().create();
        legis.ResultsB posts = (legis.ResultsB) b.getSerializable("namesss");

        this.global = posts;
       try{
           posts.fname = posts.title +". "+ posts.name;

        if(posts.party.equals("R"))
        {
            posts.pim = "R.drawable.rr";
            posts.pn = "Republican";
        }
        else if(posts.party.equals("D"))
        {
            posts.pim = "R.drawable.d";
            posts.pn = "Democrat";
        }
        else       {
            posts.pim = "com.srt.congress1.R.drawable.i";
            posts.pn = "Independant";
        }

        //oc_email              oc_email

        if (posts.chamber == "house")
            posts.chm = "House";
        else
            posts.chm = "Senate";
          // Log.e("arra",posts.chm);
        //phone         phone
        int sty = Integer.parseInt( posts.term_start.substring(0,4));
        int ety = Integer.parseInt( posts.term_end.substring(0,4));
        int stm = Integer.parseInt( posts.term_start.substring(5,7));
        int etm = Integer.parseInt( posts.term_end.substring(5,7));
        int std = Integer.parseInt( posts.term_start.substring(8,10));
        int etd = Integer.parseInt( posts.term_end.substring(8,10));
        int bdd = Integer.parseInt( posts.birthday.substring(8,10));
        int bdm = Integer.parseInt( posts.birthday.substring(5,7));
        int bdy = Integer.parseInt( posts.birthday.substring(0,4));
         //  Log.e("arra",""+stm);
        posts.stdate = new DateFormatSymbols().getShortMonths()[stm-1] + " "+std+","+sty;
        posts.etdate = new DateFormatSymbols().getShortMonths()[etm-1]+ " "+etd+","+ety;
        posts.bday = new DateFormatSymbols().getShortMonths()[bdm-1]+ " "+bdd+","+bdy;
           SimpleDateFormat formatt = new SimpleDateFormat("yyyy-MM-dd");
           Date d1 = formatt.parse(posts.term_start);
           Date d2 = formatt.parse(posts.term_end);
           String requiredDate = formatt.format(new Date()).toString();
           Date d = formatt.parse(requiredDate);
           posts.prog = (int)( ((d.getTime()-d1.getTime()) * 100.00) / (d2.getTime() - d1.getTime()) ) ;


        Log.e("arra",""+posts.prog + "   "+ posts.etdate+ "  "+  posts.stdate + posts.bday);
         global = display(posts);

       }
        catch (Exception e)
        {
            Log.e("exce", e.toString());
        }

}

    legis.ResultsB display(final legis.ResultsB pos)
    {
        final legis.ResultsB pos1 = pos;
        Log.e("view" , "" + this.findViewById(android.R.id.content).isHardwareAccelerated());
        ImageView but = (ImageView) findViewById(R.id.button);
        TextView tv23 = (TextView) findViewById(R.id.textView23);
        tv23.setText(pos.pn);
        TextView t2 = (TextView) findViewById(R.id.textView2);
        t2.setText(pos.fname);
        TextView t4 = (TextView) findViewById(R.id.textView4);
        if (pos.oc_email != null)
        t4.setText(pos.oc_email.toString());
        else
            t4.setText("N.A");

        TextView t6 = (TextView) findViewById(R.id.textView6);
        t6.setText(pos.chm);
        TextView t8 = (TextView) findViewById(R.id.textView8);
        if (pos.phone != null)
            t8.setText(pos.phone.toString());
        else
            t8.setText("N.A");

        TextView t10 = (TextView) findViewById(R.id.textView10);
        t10.setText(pos.stdate);
        TextView t12 = (TextView) findViewById(R.id.textView12);
        t12.setText(pos.etdate);
        ProgressBar pg = (ProgressBar) findViewById(R.id.progressBar);
        pg.setProgress(pos.prog);
        TextView t16 = (TextView) findViewById(R.id.textView16);
        if (pos.office != null)
        t16.setText(pos.office);
        else
            t16.setText("N.A");
        TextView t18 = (TextView) findViewById(R.id.textView18);
        t18.setText(pos.state);
        TextView t20 = (TextView) findViewById(R.id.textView20);
        if (pos.fax != null)
            t20.setText(pos.fax.toString());
        else
            t20.setText("N.A");
        TextView t22 = (TextView) findViewById(R.id.textView22);
        if (pos.bday != null)
        t22.setText(pos.bday);
        else
        t22.setText("N.A");

        ImageView imgg = (ImageView) findViewById(R.id.img1);
        ImageView imgp = (ImageView) findViewById(R.id.img2);
        String fb=null;
        String tw =null;
        String wb = null;
        if(pos.facebook_id!=null)
         fb = "https://www.facebook.com/"+pos.facebook_id;
        else
          fb = null;
        if(pos.twitter_id!=null)
        tw = "https://twitter.com/"+pos.twitter_id;
        else tw = null;
        if(pos.website!=null)
            wb = pos.website.toString();
        else wb = null;

        final ImageView imgfav = (ImageView) findViewById(R.id.img3);
        ImageView imgf = (ImageView) findViewById(R.id.img4);
        ImageView imgt = (ImageView) findViewById(R.id.img5);
        ImageView imgw = (ImageView) findViewById(R.id.img6);


        Picasso.with(this)
                .load(pos.imageurl)
                .resize(68, 66)
                .placeholder(com.srt.congress1.R.drawable.compose)
                .into(imgg);


        if(pos.party.equals("R"))
        Picasso.with(this).load(R.drawable.rr).resize(60,60).placeholder(R.drawable.compose).into(imgp);
        else if(pos.party.equals("D"))
        Picasso.with(this).load(R.drawable.dd).resize(60,60).placeholder(R.drawable.compose).into(imgp);
        else
        Picasso.with(this).load(R.drawable.i).resize(60,60).placeholder(R.drawable.compose).into(imgp);

        if(pos.fav == true)
            imgfav.setImageResource(R.drawable.fa_favon);
        else
            imgfav.setImageResource(R.drawable.fa_fav);

        imgfav.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if(pos1.fav == false)
                {
                    pos1.fav=true;
                imgfav.setImageResource(R.drawable.fa_favon); }
                else {
                    pos1.fav=false;
                    imgfav.setImageResource(R.drawable.fa_fav);
                }
                //v.getId() will give you the image id
           //return pos1;
            }
        });
        pos.fav = pos1.fav;
        Log.e("favvv", pos.fav + " " + pos1.fav);
        but.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
          finish();      //v.getId() will give you the image id
            }
        });

        final String finalFb = fb;
        imgf.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(finalFb ==null)
                    Toast.makeText(getApplicationContext(),"No related information present",Toast.LENGTH_SHORT).show();
                else {
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(finalFb));
                    startActivity(i);
                }
                //v.getId() will give you the image id
            }
        });


        final String finalTw = tw;
        imgt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(finalTw ==null)
                    Toast.makeText(getApplicationContext(),"No related information present",Toast.LENGTH_SHORT).show();
                else {
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(finalTw));
                    startActivity(i);
                }
                //v.getId() will give you the image id
            }
        });
        final String finalWb = wb;

        imgw.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(finalWb ==null)
                    Toast.makeText(getApplicationContext(),"No related information present",Toast.LENGTH_SHORT).show();
                else {
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(finalWb));
                    startActivity(i);
                }
                //v.getId() will give you the image id
            }
        });

        return  pos;
    }


}