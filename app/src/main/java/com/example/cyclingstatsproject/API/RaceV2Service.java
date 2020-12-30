package com.example.cyclingstatsproject.API;

import com.example.cyclingstatsproject.Models.OneDayRace;
import com.example.cyclingstatsproject.Models.OneDayRaceResult;
import com.example.cyclingstatsproject.Models.Race;
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

public interface RaceV2Service {
    @GET("{lang}/seasons.json")
    Call<TournamentList> getSeasons(@Path("lang") String lang, @Query("api_key") String api_key);
    @GET("{lang}/sport_events/{stage_id}/schedule.json")
    Call<Race> getRaces(@Path("lang") String lang,@Path("stage_id") String stage_id,@Query("api_key") String api_key);
    @GET("{lang}/sport_events/{stage_id}/summary.json")
    Call<OneDayRaceResult> getMsResult(@Path("lang") String lang, @Path("stage_id") String stage_id, @Query("api_key") String api_key);
    @GET("{lang}/competitors/{competitor_id}/profile.json")
    Call<Rider> getRider(@Path("lang") String lang,@Path("competitor_id") String competitor_id,@Query("api_key") String api_key);
}
