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

import com.example.cyclingstatsproject.API.RaceV1Service;
import com.example.cyclingstatsproject.API.RetrofitV1Instance;
import com.example.cyclingstatsproject.Models.StageResult;
import com.example.cyclingstatsproject.Models.StageResultList;
import com.example.cyclingstatsproject.R;
import com.example.cyclingstatsproject.SumaryActivity;

import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResultFragment extends Fragment {

    private final String stage_id;
    private RecyclerView recyclerView;

    public ResultFragment(String stage_id) {
        this.stage_id = stage_id;
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

        fetchStageResultData();
        return view;
    }

    private void fetchStageResultData() {
        RaceV1Service service = RetrofitV1Instance.getRetrofitInstance().create(RaceV1Service.class);

        Locale location = getContext().getResources().getConfiguration().getLocales().get(0);
        String locationCode = location.getLanguage();
        String api_key = getResources().getString(R.string.api_key);

        Call<StageResultList> ResultCall = service.getResults(locationCode, stage_id, api_key);

        ResultCall.enqueue(new Callback<StageResultList>() {
            @Override
            public void onResponse(Call<StageResultList> call, Response<StageResultList> response) {
                setupResultListView(response.body().getResults());
            }

            @Override
            public void onFailure(Call<StageResultList> call, Throwable t) {
                Log.e("FAILURE", "nie mozna wczytac danych");
            }
        });
    }

    private void setupResultListView(List<StageResult> results) {
        final ResultAdapter Adapter = new ResultAdapter(results);

        recyclerView.setAdapter(Adapter);
    }

    private class ResultHolder extends RecyclerView.ViewHolder {

        private final TextView nameTextView;
        private final TextView timeTextView;
        private final TextView nationalityTextView;
        private final TextView teamTextView;
        private final TextView placeTextView;

        private StageResult result;

        public ResultHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.fragment_results, parent, false));

            nameTextView = itemView.findViewById(R.id.competitor_name);
            timeTextView = itemView.findViewById(R.id.competitor_time);
            nationalityTextView = itemView.findViewById(R.id.competitor_nationality);
            teamTextView = itemView.findViewById(R.id.competitor_team);
            placeTextView = itemView.findViewById(R.id.competitor_place);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(), SumaryActivity.class);
                    intent.putExtra("COMPETITOR_ID",result.getCompetitor().getId());
                    intent.putExtra("TEAM_ID",result.getCompetitor().getTeam().getId());
                    startActivity(intent);
                }
            });
        }

        public void bind(StageResult result) {
            this.result = result;

            nameTextView.setText(result.getCompetitor().getName());
            timeTextView.setText(result.getTime());
            nationalityTextView.setText(result.getCompetitor().getCountry_code());
            if(result.getCompetitor().getTeam()!=null) {
                teamTextView.setText(result.getCompetitor().getTeam().getName());
            }
            placeTextView.setText(String.valueOf(result.getTime_ranking()));
        }
    }

    private class ResultAdapter extends RecyclerView.Adapter<ResultHolder> {
        private List<StageResult> results;

        public ResultAdapter(List<StageResult> results) {
            this.results = results;
        }


        @NonNull
        @Override
        public ResultHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new ResultHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(@NonNull ResultHolder holder, int position) {
            StageResult stage = results.get(position);
            holder.bind(stage);
        }

        @Override
        public int getItemCount() {
            return results.size();
        }
    }
}
