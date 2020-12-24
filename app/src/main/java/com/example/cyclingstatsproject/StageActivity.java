package com.example.cyclingstatsproject;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.cyclingstatsproject.Fragments.RaceFragment;

public class StageActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage);

        if(savedInstanceState == null) {
            String stage_id = (String)getIntent().getSerializableExtra("STAGES_ID");
            Fragment newFragment = new RaceFragment(stage_id);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.stage_fragment_container,newFragment).commit();
        }

    }
}