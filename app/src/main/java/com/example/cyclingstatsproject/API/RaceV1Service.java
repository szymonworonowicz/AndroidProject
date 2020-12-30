package com.example.cyclingstatsproject.API;

import com.example.cyclingstatsproject.Models.Rider;
import com.example.cyclingstatsproject.Models.StageResultList;
import com.example.cyclingstatsproject.Models.TeamProfile;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RaceV1Service {
    @GET("{lang}/stages/{stage_id}/summary.json")
    Call<StageResultList> getResults(@Path("lang") String lang, @Path("stage_id") String stage_id , @Query("api_key") String api_key);
    @GET("{lang}/riders/{rider_id}/profile.json")
    Call<Rider> getRider(@Path("lang") String lang,@Path("rider_id") String rider_id, @Query("api_key") String api_key);
    @GET("{lang}/teams/{team_id}/profile.json")
    Call<TeamProfile> getTeam(@Path("lang") String lang,@Path("team_id") String team_id, @Query("api_key") String api_key);
}
