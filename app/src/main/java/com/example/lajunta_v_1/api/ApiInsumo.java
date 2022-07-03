package com.example.lajunta_v_1.api;

import com.example.lajunta_v_1.models.Insumo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInsumo {

    @GET("insumoApi.php")
    Call<List<Insumo>> listaInsumos();

    @FormUrlEncoded
    @POST("insumoApi.php")
    Call<String> crearInsumo(
            @Field("nombre") String nombre,
            @Field("Cantidad") int cantidad,
            @Field("medida") String medida
    );

}
