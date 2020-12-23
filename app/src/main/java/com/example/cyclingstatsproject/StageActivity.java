package com.example.cyclingstatsproject;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class StageActivity extends Activity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage);

        mTextView = (TextView) findViewById(R.id.text);

    }
}