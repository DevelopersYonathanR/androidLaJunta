package com.example.lajunta_v_1.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lajunta_v_1.R;
import com.example.lajunta_v_1.adapter.RVRegistro;
import com.example.lajunta_v_1.adapter.RVTrabajador;
import com.example.lajunta_v_1.api.ApiAdapter;
import com.example.lajunta_v_1.models.Registro;
import com.example.lajunta_v_1.models.Trabajador;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaTrabajadorFragment extends Fragment {

    RVTrabajador rvTrabajador;
    RecyclerView  recyclerViewTrabajador;
    ArrayList<Trabajador> listaTrabajador;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.trabajador_fragment, container,false);
        recyclerViewTrabajador = view.findViewById(R.id.recyclerViewTrabaador);

        Call<List<Trabajador>> listaTrabajador = ApiAdapter.geTrabajadorList().getListaTrabajador();
        listaTrabajador.enqueue(new Callback<List<Trabajador>>() {
            @Override
            public void onResponse(Call<List<Trabajador>> call, Response<List<Trabajador>> response) {
                if (response.isSuccessful()) {

                    RVTrabajador adapter = new RVTrabajador(getContext(), response.body());

                    recyclerViewTrabajador.setAdapter(adapter);
                    recyclerViewTrabajador.setLayoutManager(new LinearLayoutManager(getContext()));
                    recyclerViewTrabajador.setHasFixedSize(true);
                }
            }

            @Override
            public void onFailure(Call<List<Trabajador>> call, Throwable t) {
                Log.e("Retrofit Error!!", t.getMessage());
            }
        });

        return view;

    }



}


/*
public class ListaRegistroFragment extends Fragment {

    RVRegistro rvRegistro;
    RecyclerView recyclerViewRegistro;
    ArrayList<Registro> listaRegistros;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.registro_fragment, container,false);
        recyclerViewRegistro = view.findViewById(R.id.recyclerViewRegistro);
        listaRegistros = new ArrayList<>();
        cargarLista();
        mostrarDatos();

        return view ;
    }

    public  void cargarLista(){
        listaRegistros.add(new Registro("JUAN", "RIOS"));
        listaRegistros.add(new Registro("Pedro", "Carcamos"));
        listaRegistros.add(new Registro("JUAN", "RIOS"));
        listaRegistros.add(new Registro("JUAN", "RIOS"));
        listaRegistros.add(new Registro("JUAN", "RIOS"));

    }

    public void mostrarDatos() {
        recyclerViewRegistro.setLayoutManager(new LinearLayoutManager(getContext()));
        rvRegistro = new  RVRegistro(getContext(),listaRegistros );
        recyclerViewRegistro.setAdapter(rvRegistro);

    }

}

* */  // respaldo de lo de arriba