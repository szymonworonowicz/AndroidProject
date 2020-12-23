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

import com.example.cyclingstatsproject.API.RaceService;
import com.example.cyclingstatsproject.API.RetrofitInstance;
import com.example.cyclingstatsproject.Models.Tournament;
import com.example.cyclingstatsproject.Models.TournamentList;
import com.example.cyclingstatsproject.R;

import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RaceListFragment extends Fragment {

    RecyclerView recyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tournament_list, container, false);

        recyclerView = view.findViewById(R.id.fragment_tournament_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        fetchTournamentData();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    public void fetchTournamentData() {
        RaceService service = RetrofitInstance.getRetrofitInstance().create(RaceService.class);

        Locale location = getContext().getResources().getConfiguration().getLocales().get(0);
        String locationCode = location.getLanguage();
        String api_key = getString(R.string.api_key);
        Call<TournamentList> TournamentapiCall = service.getTournamentList(locationCode,api_key);


        TournamentapiCall.enqueue(new Callback<TournamentList>() {
            @Override
            public void onResponse(Call<TournamentList> call, Response<TournamentList> response) {
                setupTournamentListView(response.body().getTournaments());
            }

            @Override
            public void onFailure(Call<TournamentList> call, Throwable t) {
                Log.println(Log.ERROR,"FAILURE","z brania danych");
            }
        });
    }

    private void setupTournamentListView(List<Tournament> tournamentList) {
        final TournamentAdapter Adapter = new TournamentAdapter(tournamentList);

        recyclerView.setAdapter(Adapter);

    }

    private class TournamentHolder extends RecyclerView.ViewHolder {

        TextView nameTextView;
        TextView scheduledTextView;
        TextView scheduled_endTextView;
        TextView categoryTextView;

        Tournament tournament;

        public TournamentHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.fragment_tournament, parent, false));

            nameTextView = itemView.findViewById(R.id.tournament_name);
            scheduledTextView = itemView.findViewById(R.id.scheduled);
            scheduled_endTextView = itemView.findViewById(R.id.scheduled_end);
            categoryTextView = itemView.findViewById(R.id.category);
        }

        public void bind(Tournament tournament) {
            this.tournament = tournament;
            nameTextView.setText(tournament.getName());
            scheduledTextView.setText(tournament.getScheduled().toString());
            scheduled_endTextView.setText(tournament.getScheduled_end().toString());
            categoryTextView.setText(tournament.getCategory().getName());
        }

    }

    private class TournamentAdapter extends RecyclerView.Adapter<TournamentHolder> {

        private List<Tournament> tournaments;
        public TournamentAdapter(List<Tournament> tournaments)
        {
            this.tournaments = tournaments;
        }
        @NonNull
        @Override
        public TournamentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new TournamentHolder(layoutInflater,parent);
        }

        @Override
        public void onBindViewHolder(@NonNull TournamentHolder holder, int position) {
            Tournament tournament = tournaments.get(position);
            holder.bind(tournament);
        }

        @Override
        public int getItemCount() {
            return tournaments.size();
        }
    }
}
