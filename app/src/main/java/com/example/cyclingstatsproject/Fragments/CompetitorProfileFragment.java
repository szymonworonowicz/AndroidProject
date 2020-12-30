package com.example.cyclingstatsproject.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cyclingstatsproject.API.RaceV1Service;
import com.example.cyclingstatsproject.API.RaceV2Service;
import com.example.cyclingstatsproject.API.RetrofitV1Instance;
import com.example.cyclingstatsproject.API.RetrofitV2Instance;
import com.example.cyclingstatsproject.Models.Rider;
import com.example.cyclingstatsproject.Models.Team;
import com.example.cyclingstatsproject.R;

import org.w3c.dom.Text;

import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CompetitorProfileFragment  extends Fragment {

    private final String competitor_id;
    private RecyclerView recyclerView;
    private TextView competitor_nameTextView;
    private TextView competitor_countryCodeTextView;
    private TextView competitor_nationalityTextView;

    public CompetitorProfileFragment(String competitor_id)
    {
        this.competitor_id = competitor_id;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_competitor_list,container,false);

        competitor_nameTextView = view.findViewById(R.id.profile_competitor_name);
        competitor_countryCodeTextView = view.findViewById(R.id.profile_competitor_country_code);
        competitor_nationalityTextView = view.findViewById(R.id.profile_competitor_nationality);

        recyclerView = view.findViewById(R.id.fragment_competitor_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        fetchData();
        return view;
    }

    private void fetchData() {
        if(competitor_id.contains("rider")) {
            RaceV1Service service = RetrofitV1Instance.getRetrofitInstance().create(RaceV1Service.class);

            Locale location = getResources().getConfiguration().getLocales().get(0);
            String locationCode = location.getLanguage();
            String api_key = getResources().getString(R.string.api_key);

            Call<Rider> RiderInfo = service.getRider(locationCode, competitor_id, api_key);
            RiderInfo.enqueue(new Callback<Rider>() {
                @Override
                public void onResponse(Call<Rider> call, Response<Rider> response) {
                    updateAdapter(response.body());
                    Log.println(Log.ASSERT, "Callback", "pobrano");

                }

                @Override
                public void onFailure(Call<Rider> call, Throwable t) {
                    Log.e("FAILURE", "blad pobrania danych");
                }
            });
        } else if(competitor_id.contains("competitor"))
        {
            RaceV2Service service = RetrofitV2Instance.getRetrofitInstance().create(RaceV2Service.class);

            Locale location = getResources().getConfiguration().getLocales().get(0);
            String locationCode = location.getLanguage();
            String api_key = getResources().getString(R.string.api_key);

            Call<Rider> RiderInfo = service.getRider(locationCode, competitor_id, api_key);
            RiderInfo.enqueue(new Callback<Rider>() {
                @Override
                public void onResponse(Call<Rider> call, Response<Rider> response) {
                    updateAdapter(response.body());
                    Log.println(Log.ASSERT, "Callback", "pobrano");

                }

                @Override
                public void onFailure(Call<Rider> call, Throwable t) {
                    Log.e("FAILURE", "blad pobrania danych");
                }
            });
        }


    }

    private void updateAdapter(Rider rider) {

        competitor_nameTextView.setText(rider.getCompetitor().getName());
        competitor_countryCodeTextView.setText(rider.getCompetitor().getCountry_code());
        competitor_nationalityTextView.setText(rider.getCompetitor().getNationality());

        final TeamAdapter Adapter = new TeamAdapter(rider.getTeams());

        recyclerView.setAdapter(Adapter);
    }

    private class TeamHolder extends RecyclerView.ViewHolder {

        TextView teamNameTextView;
        TextView countryCodeTextView;
        TextView nationalityTextView;

        Team team;
        public TeamHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.fragment_team,parent,false));

            teamNameTextView = itemView.findViewById(R.id.team_name);
            countryCodeTextView = itemView.findViewById(R.id.competitor_nationality);
            nationalityTextView = itemView.findViewById(R.id.competitor_team);
        }
        public void bind(Team team) {
            this.team = team;
            teamNameTextView.setText(team.getName());
            countryCodeTextView.setText(team.getCountry_code());
            nationalityTextView.setText(team.getNationality());
        }
    }

    private class TeamAdapter extends  RecyclerView.Adapter<TeamHolder> {

        private final List<Team> teams;

        public TeamAdapter(List<Team> teams) {
            this.teams = teams;
        }

        @NonNull
        @Override
        public TeamHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            return new TeamHolder(layoutInflater,parent);
        }

        @Override
        public void onBindViewHolder(@NonNull TeamHolder holder, int position) {
            Team team = teams.get(position);

            holder.bind(team);
        }

        @Override
        public int getItemCount() {
            if(teams == null) {
                return  0;
            }
            return teams.size();
        }
    }
}
