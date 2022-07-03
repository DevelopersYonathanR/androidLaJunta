package com.example.lajunta_v_1.fragments;

import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lajunta_v_1.R;
import com.example.lajunta_v_1.adapter.RVAlimento;
import com.example.lajunta_v_1.adapter.RVHabitacion;
import com.example.lajunta_v_1.api.ApiAdapter;
import com.example.lajunta_v_1.api.ApiAlimento;
import com.example.lajunta_v_1.models.Alimento;
import com.example.lajunta_v_1.models.Habitacion;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaHabitacionesFragment extends Fragment {

    private RecyclerView recyclerViewHabitaciones;
    private RVAlimento rvAlimento;
    private List<Alimento> alimentoList;
    ApiAlimento apiAlimento;

    private AlertDialog.Builder dialogBulder;
    private AlertDialog dialog;
    private Button btnIrAgrgar;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    private EditText txtNombreA, txtCantidaA, txtMedidaA;
    private Button btnAdd, btnCancelar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.habitaciones_fragment, container, false);
        recyclerViewHabitaciones = view.findViewById(R.id.recyclerViewHabitaciones);
        btnIrAgrgar = view.findViewById(R.id.btnIrAgregar);


        Call<List<Habitacion>> listaHabitacion = ApiAdapter.getHabitacionApi().listaHabitacion();
        listaHabitacion.enqueue(new Callback<List<Habitacion>>() {
            @Override
            public void onResponse(Call<List<Habitacion>> call, Response<List<Habitacion>> response) {
                if (response.isSuccessful()) {

                    RVHabitacion adapter = new RVHabitacion(getContext(), response.body());

                    recyclerViewHabitaciones.setAdapter(adapter);
                    recyclerViewHabitaciones.setLayoutManager(new LinearLayoutManager(getContext()));
                    recyclerViewHabitaciones.setHasFixedSize(true);
                }
            }

            @Override
            public void onFailure(Call<List<Habitacion>> call, Throwable t) {
                Log.e("Retrofit Error!!", t.getMessage());
            }
        });

        btnIrAgrgar.setOnClickListener(v -> {
            dialogBulder = new AlertDialog.Builder(getContext());
            final View viewA = getLayoutInflater().inflate(R.layout.alimento_add_fragment, null);

            txtNombreA = viewA.findViewById(R.id.txtNombreA);
            txtCantidaA = viewA.findViewById(R.id.txtCantidadA);
            txtMedidaA = viewA.findViewById(R.id.txtMedidaA);
            btnAdd = viewA.findViewById(R.id.btnAdd);
            btnCancelar = viewA.findViewById(R.id.btnCancelar);

            dialogBulder.setView(viewA);
            dialog = dialogBulder.create();
            dialog.show();

            btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String nombre = txtNombreA.getText().toString().trim();
                    int cantidad = Integer.parseInt(txtCantidaA.getText().toString().trim());
                    String medida = txtMedidaA.getText().toString().trim();

                    Call<String> call = ApiAdapter.getAlimentoApi().crearAlimento(nombre, cantidad, medida);
                    call.enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {
                        String result =  response.body();
                        if (result == "OK"){
                            Toast.makeText(getContext(), "registro", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(getContext(), "no Registro", Toast.LENGTH_SHORT).show();

                        }

                         dialog.dismiss();

                          /*  fragmentManager = getFragmentManager();
                            fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.replace(R.id.container, new ListaAlimentosFragment());
                            fragmentTransaction.commit();*/


                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {
                            Toast.makeText(getContext(), "Fallo Conexion", Toast.LENGTH_SHORT).show();

                        }
                    });


                }
            });


        });


        return view;
    }
}
