package com.example.lajunta_v_1.api;


import com.example.lajunta_v_1.models.Trabajador;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiTrabajador {

    @GET("trabajadorApi.php")
    Call<List<Trabajador>> getListaTrabajador();

}
