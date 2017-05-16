package com.srt.congress1;

import android.app.Activity;
import android.content.Context;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import java.util.List;


/**
 * Created by sriram on 11/23/16.
 */

public class customadapter2 extends ArrayAdapter {

    Activity context;
    List<Bills> bb;
    String ss[];
    //    LayoutInflater inflater= getContext().
    LayoutInflater inflaterr1 = LayoutInflater.from(getContext());

    //Log.e("In constr","");

    public customadapter2 (Context context, String b[], List<Bills> bb) {
        super(context, R.layout.billsitem, b );
        //this.context = context;
    Log.e("In constr","");
        this.ss = b;
        this.bb=bb;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // default -  return super.getView(position, convertView, parent);
        // add the layout

        if (convertView == null) {
            convertView = inflaterr1.inflate(R.layout.billsitem, parent, false);
        }

        View viewrow = inflaterr1.inflate(R.layout.billsitem, parent, false);
        TextView txt1 = (TextView) viewrow.findViewById(R.id.billtext1);
        TextView txt2= (TextView) viewrow.findViewById(R.id.billtext2);
        //Log.e("text",names[position]);
        Log.e("text", ""+txt1.getText() );

        txt2.setText(bb.get(position).bill_id.toUpperCase());
        if(bb.get(position).short_title==null)
        txt1.setText(bb.get(position).official_title + "\n\n" + bb.get(position).intro);
        else
        txt1.setText(bb.get(position).short_title + "\n\n" + bb.get(position).intro);
        Log.e("text", ""+txt1.getText() );
        //imv.setImageResource(R.drawable.compose);
        //imv.setImageResource(R.drawable.);
        return viewrow;

    }
}