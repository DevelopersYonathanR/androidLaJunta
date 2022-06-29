package com.example.lajunta_v_1.api;

import com.example.lajunta_v_1.models.Alimento;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiAlimento {

    @GET("alimentoApi.php")
    Call<List<Alimento>>listaAlimentos();


}
