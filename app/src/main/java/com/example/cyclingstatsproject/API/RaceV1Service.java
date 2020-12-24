package com.example.cyclingstatsproject.API;

import com.example.cyclingstatsproject.Models.StageResultList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RaceV1Service {
    @GET("{lang}/stages/{stage_id}/summary.json")
    Call<StageResultList> getResults(@Path("lang") String lang, @Path("stage_id") String stage_id , @Query("api_key") String api_key);
}
