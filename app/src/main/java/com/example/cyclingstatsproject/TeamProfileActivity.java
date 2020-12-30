package com.example.cyclingstatsproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.cyclingstatsproject.Fragments.RaceFragment;
import com.example.cyclingstatsproject.Fragments.TeamFragment;

public class TeamProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_profile);

        if(savedInstanceState ==null) {
            String team_id = (String)getIntent().getSerializableExtra("TEAM_ID");
            Fragment newFragment = new TeamFragment(team_id);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.team_fragment_container,newFragment).commit();
        }
    }
}