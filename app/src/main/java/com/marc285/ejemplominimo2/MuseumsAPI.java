package com.marc285.ejemplominimo2;

import com.marc285.ejemplominimo2.models.Museums;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MuseumsAPI {

    //GET the list of Museums
    @GET("/dataset/museus/format/json/pag-ini/1/pag-fi/11")
    Call<Museums> getMuseums();

}
