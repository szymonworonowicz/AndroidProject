package com.example.cyclingstatsproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SumaryActivity extends AppCompatActivity {

    Button Competitor_ProfileButton;
    Button Team_ProfileButton;

    String competitor_id;
    String team_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sumary);
        competitor_id = (String) getIntent().getSerializableExtra("COMPETITOR_ID");
        team_id = (String) getIntent().getSerializableExtra("TEAM_ID");


        Competitor_ProfileButton = (Button) findViewById(R.id.competitor_profile);
        Team_ProfileButton = (Button) findViewById(R.id.team_profile);

        if(team_id == null) {
            Team_ProfileButton.setVisibility(View.INVISIBLE);
        } else {
            Team_ProfileButton.setVisibility(View.VISIBLE);
        }
        Competitor_ProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SumaryActivity.this,CompetitorProfileActivity.class);
                intent.putExtra("COMPETITOR_ID",competitor_id);
                startActivity(intent);
            }
        });

        Team_ProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SumaryActivity.this,TeamProfileActivity.class);
                intent.putExtra("TEAM_ID",team_id);
                startActivity(intent);
            }
        });

    }
}