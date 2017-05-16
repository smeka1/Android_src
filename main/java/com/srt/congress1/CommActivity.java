package com.srt.congress1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Objects;

/**
 * Created by sriram on 11/27/16.
 */

public class CommActivity extends Activity{

    public Committees global;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.commdet);

        Intent intent = getIntent();
        //String jsonArray = intent.getStringExtra("namesss");
        Bundle b = intent.getExtras();
        //String Array1=b.getString("namesss");
        //Gson gson = new GsonBuilder().create();
        Committees posts = (Committees) b.getSerializable("namesss");
        Log.e("arra",""+posts.phone + "   "+ posts.name);
        this.global = posts;
        try {

        }
        catch (Exception e)
        {
            Log.e("fsfsf",  e.toString());
        }

        //posts.stdate);Log.e("arra",posts.etdate);

        global = display(posts);


    }

    Committees display(final Committees pos)
    {
        final Committees pos1 = pos;
        Log.e("view" , "" + this.findViewById(android.R.id.content).isHardwareAccelerated());
        ImageView but = (ImageView) findViewById(R.id.button);

        //TextView tv23 = (TextView) findViewById(R.id.textView23);
        //tv23.setText(pos.pn);
        TextView t2 = (TextView) findViewById(R.id.textView2);
        t2.setText(pos.committee_id.toUpperCase());
        TextView t4 = (TextView) findViewById(R.id.textView4);

        t4.setText(pos.name);

        TextView t6 = (TextView) findViewById(R.id.textView6);
        if(pos.chamber==null)
        t6.setText("N.A");
        else
        t6.setText(pos.chamber.substring(0,1).toUpperCase() + pos.chamber.substring(1));

        ImageView img = (ImageView) findViewById(R.id.img2);
        if (pos.chamber.equals("house"))
        Picasso.with(this).load(R.drawable.h).resize(60,60).placeholder(R.drawable.compose).into(img);
        else
            Picasso.with(this).load(R.drawable.s).resize(60,60).placeholder(R.drawable.compose).into(img);

        TextView t8 = (TextView) findViewById(R.id.textView8);
        if (pos.parent_committee_id == null)
            t8.setText("None");
        else
            t8.setText(pos.parent_committee_id);

        TextView t10 = (TextView) findViewById(R.id.textView10);
        if (pos.phone== null)
            t10.setText("None");
        else
            t10.setText(pos.phone);

        TextView t12 = (TextView) findViewById(R.id.textView12);
        if (pos.office  != null)
            t12.setText(pos.office);
        else
            t12.setText("N.A");

        final ImageView imgfav = (ImageView) findViewById(R.id.img3);

        //i.setData(Uri.parse(url));
        //startActivity(i);

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
        //Log.e("favvv", pos.fav + " " + pos1.fav);
        but.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();      //v.getId() will give you the image id
            }
        });

        return  pos;
    }


}
