package com.example.cyclingstatsproject.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cyclingstatsproject.API.RaceV1Service;
import com.example.cyclingstatsproject.API.RetrofitV1Instance;
import com.example.cyclingstatsproject.Models.Competitor;
import com.example.cyclingstatsproject.Models.Result;
import com.example.cyclingstatsproject.Models.TeamProfile;
import com.example.cyclingstatsproject.R;

import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeamFragment extends Fragment {
    private final String team_id;
    private RecyclerView recyclerView;
    private TextView TeamNameTextView;
    private TextView TeamCodeTextView;
    private TextView TeamNationalityTextView;

    public TeamFragment(String team_id) {this.team_id = team_id;}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.team_layout, container, false);

        TeamNameTextView = view.findViewById(R.id.Team_team_name);
//        TeamCodeTextView = view.findViewById(R.id.team_country_code);
//        TeamNationalityTextView = view.findViewById(R.id.team_nationality);

        recyclerView = view.findViewById(R.id.team_competitors_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        fetchData();
        return view;
    }

    private void fetchData() {
        RaceV1Service service = RetrofitV1Instance.getRetrofitInstance().create(RaceV1Service.class);

        Locale location = getContext().getResources().getConfiguration().getLocales().get(0);
        String locationCode = location.getLanguage();
        String api_key =  getResources().getString(R.string.api_key);
        Call<TeamProfile> ResultCall = service.getTeam(locationCode,team_id,api_key);

        ResultCall.enqueue(new Callback<TeamProfile>() {
            @Override
            public void onResponse(Call<TeamProfile> call, Response<TeamProfile> response) {
                setupResultView(response.body());
            }

            @Override
            public void onFailure(Call<TeamProfile> call, Throwable t) {

            }
        });
    }

    private void setupResultView(TeamProfile body) {
        TeamNameTextView.setText(body.getTeam().getName());
//        TeamCodeTextView.setText(body.getTeam().getCountry_code());
//        TeamNationalityTextView.setText(body.getTeam().getNationality());

        final CompetitorAdapter Adapter = new CompetitorAdapter(body.getCompetitors());
        recyclerView.setAdapter(Adapter);
    }

    private class CompetitorHolder extends RecyclerView.ViewHolder {
        private final TextView nameTextView;
        private final TextView nationalityTextView;
        public CompetitorHolder(LayoutInflater inflater, ViewGroup container) {
            super(inflater.inflate(R.layout.fragment_results,container,false));

            nameTextView = itemView.findViewById(R.id.competitor_name);;
            nationalityTextView = itemView.findViewById(R.id.competitor_nationality);
            LinearLayout time= itemView.findViewById(R.id.time_Layout);
            time.setVisibility(View.GONE);
        }

        public void bind(Competitor competitor) {
            nameTextView.setText(competitor.getName());
            nationalityTextView.setText(competitor.getNationality());

        }
    }

    private class CompetitorAdapter extends RecyclerView.Adapter<CompetitorHolder> {

        private final List<Competitor> competitors;

        public CompetitorAdapter(List<Competitor> competitors) {
            this.competitors = competitors;
        }
        @NonNull
        @Override
        public CompetitorHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new CompetitorHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(@NonNull CompetitorHolder holder, int position) {
            Competitor competitor = competitors.get(position);
            holder.bind(competitor);

        }

        @Override
        public int getItemCount() {
            if(competitors == null) return 0;
            return competitors.size();
        }
    }
}
