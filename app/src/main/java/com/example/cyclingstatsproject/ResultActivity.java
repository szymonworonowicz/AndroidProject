package com.example.cyclingstatsproject;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.cyclingstatsproject.Fragments.ResultFragment;
import com.example.cyclingstatsproject.Fragments.TournamentListFragment;

public class ResultActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        if(savedInstanceState == null) {
            String stage_id = (String)getIntent().getSerializableExtra("STAGES_ID");
            Fragment newFragment = new ResultFragment(stage_id);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.result_fragment_container,newFragment).commit();
        }

    }
}