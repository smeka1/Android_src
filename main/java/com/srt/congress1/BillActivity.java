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


/**
 * Created by sriram on 11/24/16.
 */

public class BillActivity extends Activity {


    public Bills global;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.billsdet);

        Intent intent = getIntent();

        Bundle b = intent.getExtras();

        Bills posts = (Bills) b.getSerializable("namesss"); this.global = posts;
        try {

        }
        catch (Exception e)
        {
            Log.e("fsfsf",  e.toString());
        }

        //posts.stdate);Log.e("arra",posts.etdate);
            ///Log.e("arra",""+posts.prog + "   "+ posts.etdate+ "  "+  posts.stdate + posts.bday);
            global = display(posts);


    }

    Bills display(final Bills pos)
    {
        final Bills pos1 = pos;
        //custadap2 adap = new custadap2(this,pos);

        // LayoutInflater li = getLayoutInflater();

        //  View vv = li.inflate(R.layout.viewdettable,null);

        ImageView but = (ImageView) findViewById(R.id.button);

        //TextView tv23 = (TextView) findViewById(R.id.textView23);
        //tv23.setText(pos.pn);
        TextView t2 = (TextView) findViewById(R.id.textView2);
        t2.setText(pos.bill_id.toUpperCase());
        TextView t4 = (TextView) findViewById(R.id.textView4);
        if(pos.short_title==null)
        t4.setText(pos.official_title);
        else
            t4.setText(pos.short_title.toString());

        TextView t6 = (TextView) findViewById(R.id.textView6);
        if(pos.bill_type!=null)
        t6.setText(pos.bill_type.toUpperCase());
        else
        t6.setText("N.A");
        TextView t8 = (TextView) findViewById(R.id.textView8);
        t8.setText(pos.spname);

        TextView t10 = (TextView) findViewById(R.id.textView10);
        if(pos.chamber==null)
            t10.setText("N.A");
        else
            t10.setText(pos.chamber.substring(0,1).toUpperCase() + pos.chamber.substring(1));

        TextView t12 = (TextView) findViewById(R.id.textView12);
        t12.setText(pos.status);

        TextView t16 = (TextView) findViewById(R.id.textView16);
        if (pos.urls.congress == null)
        t16.setText("None");
        else
            t16.setText(pos.urls.congress);

        TextView t18 = (TextView) findViewById(R.id.textView18);
        if(pos.last_version.version_name == null)
            t18.setText("N.A");
        else
        t18.setText(pos.last_version.version_name);

        TextView t20 = (TextView) findViewById(R.id.textView20);
        if (pos.last_version.urls.pdf  != null)
            t20.setText(pos.last_version.urls.pdf);
        else
            t20.setText("N.A");

        TextView t22 = (TextView) findViewById(R.id.textView22);
        t22.setText(pos.intro);

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