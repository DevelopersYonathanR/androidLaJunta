package com.example.lajunta_v_1.api;

import com.example.lajunta_v_1.models.Alimento;
import com.example.lajunta_v_1.models.Habitacion;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiHabitacion {

    @GET("habitacionApi.php")
    Call<List<Habitacion>> listaHabitacion();
}
