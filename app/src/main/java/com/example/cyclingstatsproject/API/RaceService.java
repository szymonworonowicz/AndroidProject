package com.example.cyclingstatsproject.API;

import com.example.cyclingstatsproject.Models.RaceSummary;
import com.example.cyclingstatsproject.Models.Rider;
import com.example.cyclingstatsproject.Models.StageSummary;
import com.example.cyclingstatsproject.Models.TeamProfile;
import com.example.cyclingstatsproject.Models.TournamentInfo;
import com.example.cyclingstatsproject.Models.TournamentList;
import com.example.cyclingstatsproject.Models.TournamentSchedule;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RaceService {
    @GET("{lang}/races/{race_id}/summary.json")
    Call<RaceSummary> getRaceSummary(@Path("lang") String lang, @Path("race_id") String race_id, @Query("api_key") String api_key);
    @GET("{lang}/riders/{rider_id}/profile.json")
    Call<Rider> getRiderProfile(@Path("lang") String lang,@Path("rider_id") String rider_id,@Query("api_key") String api_key);
    @GET("{lang}/stages/{stage_id}/summary.json")
    Call<StageSummary> getStageSummary(@Path("lang") String lang,@Path("stage_id") String stage_id,@Query("api_key") String api_key);
    @GET("{lang}/teams/{team_id}/profile.json")
    Call<TeamProfile> getTeamProfile(@Path("lang") String lang,@Path("team_id") String team_id,@Query("api_key") String api_key);
    @GET("{lang}/tournaments/{tournament_id}/info.json")
    Call<TournamentInfo> getTournamentInfo(@Path("lang") String lang,@Path("tournament_id") String tournament_id,@Query("api_key") String api_key);
    @GET("{lang}/tournaments.json")
    Call<TournamentList> getTournamentList(@Path("lang") String lang, @Query("api_key") String api_key);
    @GET("{lang}/tournaments/{tournament_id}/schedule.json")
    Call<TournamentSchedule> getTournamentSchedule(@Path("lang") String lang,@Path("tournament_id") String tournament_id,@Query("api_key") String api_key);
}
