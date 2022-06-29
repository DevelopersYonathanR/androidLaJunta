package com.example.lajunta_v_1.api;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiUsuario {

   @GET("loginApi.php")
    Call<String> loginUsuario(@Query("username") String user, @Query("password") String pass );

 /*@GET("usuarioApi.php")
 Call<String> loginUsuario(@Query("username") String user, @Query("password") String pass );

  */
}

