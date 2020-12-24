package com.example.cyclingstatsproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.cyclingstatsproject.API.RaceV1Service;
import com.example.cyclingstatsproject.API.RetrofitV1Instance;
import com.example.cyclingstatsproject.Fragments.CompetitorProfileFragment;
import com.example.cyclingstatsproject.Models.Competitor;
import com.example.cyclingstatsproject.Models.Rider;
import com.example.cyclingstatsproject.Models.Team;

import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CompetitorProfileActivity extends AppCompatActivity {

    String Competitor_id;
    Rider rider;
    TextView competitor_nameTextView;
    TextView competitor_countryCodeTextView;
    TextView competitor_nationalityTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_competitor_profile);

        if (savedInstanceState == null) {
            Competitor_id = (String) getIntent().getSerializableExtra("COMPETITOR_ID");
            Fragment newFragment = new CompetitorProfileFragment(Competitor_id);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.competitor_profile_container, newFragment).commit();

        }
    }
}