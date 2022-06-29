package com.example.lajunta_v_1;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.lajunta_v_1.api.ApiAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    EditText txtUsuarioLogin;
    EditText txtPassword;
    Button btnLogin, btnSinClave;



    //  private static ApiUsuario API_SERVICE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtUsuarioLogin = findViewById(R.id.txtUsuarioLogin);
        txtPassword = findViewById(R.id.txtPassword);
        btnLogin = findViewById(R.id.btnLogin);
       // btnSinClave = findViewById(R.id.btnSinClave);

       /* btnSinClave.setOnClickListener(V->{
            Intent intent2 = new Intent(getApplicationContext(),ActivityPrincipal.class);

            startActivity(intent2);
        });*/

        btnLogin.setOnClickListener(v->{

            Call<String> listaUsuario = ApiAdapter.getUsuarioApi().loginUsuario(txtUsuarioLogin.getText().toString(), txtPassword.getText().toString());

            listaUsuario.enqueue(new Callback<String>() {

                @Override
                public void onResponse(Call<String> call, Response<String> response) {

                    if(response.body().equals("permitido")){
                        Intent intent = new Intent(getApplicationContext(),ActivityPrincipal.class);

                        Toast.makeText(getApplicationContext(), "Conexion exitosa", Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                    }else{
                        Toast.makeText(getApplicationContext(), "No se encontró el usuario", Toast.LENGTH_SHORT).show();
                    }

                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {

                }
            });





        });


    }


}