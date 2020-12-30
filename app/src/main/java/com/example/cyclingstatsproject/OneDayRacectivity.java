package com.example.cyclingstatsproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.cyclingstatsproject.Fragments.OneDayRaceFragment;
import com.example.cyclingstatsproject.Fragments.ResultFragment;

public class OneDayRacectivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_day_racectivity);

        if(savedInstanceState == null) {
            String stage_id = (String)getIntent().getSerializableExtra("STAGES_ID");
            Fragment newFragment = new OneDayRaceFragment(stage_id);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.one_day_race_container,newFragment).commit();
        }
    }
}