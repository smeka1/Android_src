package com.srt.congress1;

import android.app.Activity;
import android.content.Context;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;


/**
 * Created by sriram on 11/23/16.
 */

public class customadapter1 extends ArrayAdapter {

    Activity context;
    String[] names;
    String[] lines;
    String[] urls;

//    LayoutInflater inflater= getContext().
            LayoutInflater inflaterr = LayoutInflater.from(getContext());;

    public customadapter1(Context context, String[]names, String[] lines, String[] urls) {
        super(context, R.layout.legisitem, names);
        //this.context = context;
        this.names = names;
        this.lines= lines;
        this.urls = urls;
    }


    @Override
        public View getView(int position, View convertView, ViewGroup parent) {


        if (convertView == null) {
            convertView = inflaterr.inflate(R.layout.legisitem, parent, false);
        }

        View viewrow = inflaterr.inflate(R.layout.legisitem, parent, false);
        ImageView imv = (ImageView) viewrow.findViewById(R.id.imageView1);
        TextView txtv1= (TextView) viewrow.findViewById(R.id.legistext1);
        //Log.e("text",names[position]);
        StringBuilder str1 = new StringBuilder(names[position]+"\n"+lines[position]);
        final SpannableStringBuilder str = new SpannableStringBuilder(str1);
        str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, names[position].length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        txtv1.setText(str);
        //.setBackground(R.drawable.listbb);
        Picasso.with(getContext())
                .load(urls[position])
                .resize(66,64)
                .placeholder(R.drawable.compose)
                .into(imv);

        return viewrow;

    }
}