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

public class customadapter3 extends ArrayAdapter {

    Activity context;
    List<Committees> bb;
    String ss[];
    //    LayoutInflater inflater= getContext().
    LayoutInflater inflaterr1 = LayoutInflater.from(getContext());

    //Log.e("In constr","");

    public customadapter3 (Context context, String b[], List<Committees> bb) {
        super(context, R.layout.commitem, b );
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
            convertView = inflaterr1.inflate(R.layout.commitem, parent, false);
        }

        View viewrow = inflaterr1.inflate(R.layout.commitem, parent, false);
        TextView txt1 = (TextView) viewrow.findViewById(R.id.commtext1);
        TextView txt2= (TextView) viewrow.findViewById(R.id.commtext2);
        //Log.e("text",names[position]);
        Log.e("text", ""+txt1.getText() );
        //StringBuilder str1 = new StringBuilder(names[position]+"\n"+lines[position]);
        //final SpannableStringBuilder str = new SpannableStringBuilder(str1);
        //str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, names[position].length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        //Log.e("BillID", bb.get(position).bill_id.toUpperCase()+  bb.get(position).intro);
        txt2.setText(bb.get(position).committee_id.toUpperCase()+"\n");
        txt1.setText("\n"+bb.get(position).name + "\n\n" + bb.get(position).chamber.substring(0,1).toUpperCase()+ bb.get(position).chamber.substring(1));
        //Log.e("text", ""+txt1.getText() );
        //imv.setImageResource(R.drawable.compose);
        //imv.setImageResource(R.drawable.);
        return viewrow;

    }
}