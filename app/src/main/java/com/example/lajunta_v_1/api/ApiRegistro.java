package com.example.lajunta_v_1.api;

import com.example.lajunta_v_1.models.Registro;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiRegistro {
    @GET("registroApi.php")
    Call<List<Registro>>getListaRegistro();


    @GET("registroApi.php")
    Call<List<Registro>>getCrearRegistro();



}
