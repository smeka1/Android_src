package com.srt.congress1;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by sriram on 11/28/16.
 */

public class AboutActivity extends Activity {
    //public static final String TAG = "legisActivity";
    //public Collection<legis.ResultsB> posts;
    //public Bills global;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aboutme);

        ImageView but = (ImageView) findViewById(R.id.button);
        Log.e("button", but.toString());
        but.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();      //v.getId() will give you the image id
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {

        return super.onCreateView(name, context, attrs);

    }
}

