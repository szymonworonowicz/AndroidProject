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

import com.example.cyclingstatsproject.API.RaceV2Service;
import com.example.cyclingstatsproject.API.RetrofitV2Instance;
import com.example.cyclingstatsproject.Models.MsRaceCompetitor;
import com.example.cyclingstatsproject.Models.OneDayRace;
import com.example.cyclingstatsproject.Models.RaceResult;
import com.example.cyclingstatsproject.R;

import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OneDayRaceFragment extends Fragment {

    private final String stage_id;
    private RecyclerView recyclerView;
    private TextView race_descriptionTextView;
    private TextView race_depatruceCity;
    private TextView race_arrival_city;
    private TextView race_distance_textView;

    public OneDayRaceFragment(String stage_id) {
        this.stage_id = stage_id;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.one_day_race, container, false);

        race_descriptionTextView = view.findViewById(R.id.race_description);
        race_depatruceCity = view.findViewById(R.id.race_departure_City);
        race_arrival_city = view.findViewById(R.id.race_arrival_city);
        race_distance_textView = view.findViewById(R.id.race_distance);

        recyclerView = view.findViewById(R.id.one_day_race_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        fetchStageResultData();

        return view;
    }

    private void fetchStageResultData() {
        RaceV2Service service = RetrofitV2Instance.getRetrofitInstance().create(RaceV2Service.class);

        Locale location = getContext().getResources().getConfiguration().getLocales().get(0);
        String locationCode = location.getLanguage();
        String api_key = getResources().getString(R.string.api_key);

        Call<OneDayRace> resultCall = service.getMsResult(locationCode, stage_id, api_key);

        resultCall.enqueue(new Callback<OneDayRace>() {
            @Override
            public void onResponse(Call<OneDayRace> call, Response<OneDayRace> response) {
                setupResultListView(response.body());
            }

            @Override
            public void onFailure(Call<OneDayRace> call, Throwable t) {
                Log.e("FAILURE", "nie mozna wczytac danych");
            }
        });
    }

    private void setupResultListView(OneDayRace body) {
        race_descriptionTextView.setText(body.getDescription());
        race_distance_textView.setText(body.getDistance());
        race_depatruceCity.setText(body.getDeparture_city());
        race_arrival_city.setText(body.getArrival_city());

        final ResultAdapter Adapter = new ResultAdapter(body.getCompetitors());

        recyclerView.setAdapter(Adapter);
    }

    private class ResultHolder extends RecyclerView.ViewHolder {
        private MsRaceCompetitor result;

        private TextView placeTextView;
        private TextView nameTextView;
        public ResultHolder(LayoutInflater inflater ,ViewGroup parent) {
            super(inflater.inflate(R.layout.fragment_results,parent,false));
            placeTextView = itemView.findViewById(R.id.competitor_place);
            nameTextView = itemView.findViewById(R.id.competitor_name);
        }

        public void bind(MsRaceCompetitor result) {
            this.result = result;
            placeTextView.setText(String.valueOf(result.getResult().getTime_ranking()));
            nameTextView.setText(result.getResult().getTime());
        }
    }

    private class ResultAdapter extends RecyclerView.Adapter<ResultHolder> {

        private final List<MsRaceCompetitor> competitors;

        public ResultAdapter(List<MsRaceCompetitor> competitors) {this.competitors = competitors;}
        @NonNull
        @Override
        public ResultHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            return  new ResultHolder(layoutInflater,parent);
        }

        @Override
        public void onBindViewHolder(@NonNull ResultHolder holder, int position) {
            MsRaceCompetitor result = competitors.get(position);
            holder.bind(result);
        }

        @Override
        public int getItemCount() {
            return competitors.size();
        }
    }
}
