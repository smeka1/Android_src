package com.srt.congress1;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by sriram on 11/25/16.
 */

    public class custadap2 extends ArrayAdapter {

        Activity context;
        legis.ResultsB obj;

        //    LayoutInflater inflater= getContext().
        LayoutInflater inflaterr = LayoutInflater.from(getContext());
        ;

        public custadap2(Context context, legis.ResultsB obj) {
            super(context, R.layout.viewdettable);
            //this.context = context;
            this.obj = obj;

        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // default -  return super.getView(position, convertView, parent);
            // add the layout

            if (convertView == null) {
                convertView = inflaterr.inflate(R.layout.viewdettable, parent, false);
            }

            View viewrow = inflaterr.inflate(R.layout.viewdettable, parent, false);
            ImageView imv = (ImageView) viewrow.findViewById(com.srt.congress1.R.id.img3);
            TextView txtv1 = (TextView) viewrow.findViewById(R.id.textView23);
            //Log.e("text",names[position]);
            txtv1.setText(obj.pn);
            //Log.e("text", ""+txtv1.getText() );
            Picasso.with(getContext())
                    .load("")
                    .resize(74, 74)
                    .placeholder(com.srt.congress1.R.drawable.compose)
                    .into(imv);
            //imv.setImageResource(R.drawable.compose);
            //imv.setImageResource(R.drawable.);
            return viewrow;

        }
    @Override
     public  int getCount()
    {
        return  1;
    }

    }

