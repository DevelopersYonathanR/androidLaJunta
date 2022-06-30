package com.example.lajunta_v_1.api;

import com.example.lajunta_v_1.models.Alimento;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiAlimento {

    @GET("alimentoApi.php")
    Call<List<Alimento>> listaAlimentos();

    @FormUrlEncoded
    @POST("alimentoApi.php")
    Call<String> crearAlimento(
            @Field("nombre") String nombre,
            @Field("Cantidad") int cantidad,
            @Field("medida") String medida
    );


}
