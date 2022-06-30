package com.example.lajunta_v_1.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiAdapter {
    private static ApiUsuario USUARIO_API;
    private static ApiRegistro REGISTRO_API;
    private static ApiTrabajador TRABAJADOR_API;
    private static ApiAlimento ALIMENTO_API;
    private static final String Url_User = "http://192.168.43.63/testing/";
    // private  static  final  String Url_User="http://192.168.43.63/ApiLaJunta/api/";
    private static final String Url_Registro = "http://192.168.43.63/testing/";
    private static final String Url_TRABAJADOR = "http://192.168.43.63/testing/";
   // private static final String Url_Alimento = "http://192.168.43.63/api/";
    private static final String Url_Alimento = "http://192.168.43.63/ApiLaJunta/api/";
    private static Retrofit retrofit;


    public static ApiUsuario getUsuarioApi() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        if (USUARIO_API == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Url_User)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

            USUARIO_API = retrofit.create(ApiUsuario.class);
        }

        return USUARIO_API;
    }

    public static ApiRegistro getLista() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        if (REGISTRO_API == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Url_Registro)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

            REGISTRO_API = retrofit.create(ApiRegistro.class);
        }

        return REGISTRO_API;
    }

    public static ApiTrabajador geTrabajadorList() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        if (TRABAJADOR_API == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Url_TRABAJADOR)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

            TRABAJADOR_API = retrofit.create(ApiTrabajador.class);
        }

        return TRABAJADOR_API;
    }

    public static ApiAlimento getAlimentoApi() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        if (ALIMENTO_API == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Url_Alimento)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

            ALIMENTO_API = retrofit.create(ApiAlimento.class);
        }

        return ALIMENTO_API;
    }



}
