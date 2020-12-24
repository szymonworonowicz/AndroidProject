package com.example.cyclingstatsproject.Fragments;

import android.content.Intent;
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

import com.example.cyclingstatsproject.API.RaceV2Service;
import com.example.cyclingstatsproject.API.RetrofitV2Instance;
import com.example.cyclingstatsproject.Models.Race;
import com.example.cyclingstatsproject.R;
import com.example.cyclingstatsproject.ResultActivity;
import com.example.cyclingstatsproject.StageActivity;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RaceFragment extends Fragment {

    private final String race_id;
    private RecyclerView recyclerView;

    public RaceFragment(String race_id) {
        this.race_id = race_id;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        recyclerView = view.findViewById(R.id.fragment_tournament_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        fetchStageData();
        return view;
    }

    private void fetchStageData() {

        RaceV2Service service = RetrofitV2Instance.getRetrofitInstance().create(RaceV2Service.class);

        Locale location = getContext().getResources().getConfiguration().getLocales().get(0);
        String locationCode = location.getLanguage();
        String api_key = getResources().getString(R.string.api_key);;

        Call<Race> RaceList = service.getRaces(locationCode, race_id, api_key);

        RaceList.enqueue(new Callback<Race>() {
            @Override
            public void onResponse(Call<Race> call, Response<Race> response) {
                setupRaceList(response.body().getStages());
            }

            @Override
            public void onFailure(Call<Race> call, Throwable t) {
                Log.e("FAILURE", "blad pobrania danych");
            }
        });
    }

    private void setupRaceList(List<Race> stages) {
        final StageAdapter Adapter = new StageAdapter(stages);

        recyclerView.setAdapter(Adapter);
    }

    private class StageHolder extends RecyclerView.ViewHolder {

        TextView descriptionTextView;
        TextView scheduledTextView;
        TextView scheduled_endTextView;

        Race race;

        public StageHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.fragment_race, parent, false));
            descriptionTextView = itemView.findViewById(R.id.race_name);
            scheduledTextView = itemView.findViewById(R.id.race_scheduled);
            scheduled_endTextView = itemView.findViewById(R.id.race_scheduled_end);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (race.getType().equals("stage")) {
                        Intent intent = new Intent(getActivity(), ResultActivity.class);
                        intent.putExtra("STAGES_ID", race.getId());
                        startActivity(intent);
                    } else if (race.isSingle_event() == false && race.getType() != "stage") {
                        Intent intent = new Intent(getActivity(), StageActivity.class);
                        intent.putExtra("STAGES_ID", race.getId());
                        startActivity(intent);
                    }
                }
            });
        }

        public void bind(Race race) {
            this.race = race;
            descriptionTextView.setText(race.getName());
            SimpleDateFormat dateFormater = new SimpleDateFormat("dd/MM/yyyy");
            scheduledTextView.setText(dateFormater.format(race.getScheduled()));
            scheduled_endTextView.setText(dateFormater.format(race.getScheduled_end()));

        }
    }

    private class StageAdapter extends RecyclerView.Adapter<StageHolder> {
        private List<Race> races;

        public StageAdapter(List<Race> races) {
            this.races = races;
        }

        @NonNull
        @Override
        public StageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            return new StageHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(@NonNull StageHolder holder, int position) {
            Race race = races.get(position);

            holder.bind(race);
        }

        @Override
        public int getItemCount() {
            return this.races.size();
        }
    }
}
