package com.example.lajunta_v_1.fragments;

import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lajunta_v_1.R;
import com.example.lajunta_v_1.adapter.RVRegistro;
import com.example.lajunta_v_1.api.ApiAdapter;
import com.example.lajunta_v_1.models.Registro;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaRegistroFragment extends Fragment {

    RVRegistro rvRegistro;
    RecyclerView recyclerViewRegistro;
    ArrayList<Registro> listaRegistros;
    private AlertDialog.Builder dialogBulder;
    private AlertDialog dialog;
    private Button btnAgregar;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.registro_fragment, container, false);
        recyclerViewRegistro = view.findViewById(R.id.recyclerViewRegistro);
        btnAgregar = view.findViewById(R.id.btnAgregar);

        Call<List<Registro>> listaRegistro = ApiAdapter.getLista().getListaRegistro();
        listaRegistro.enqueue(new Callback<List<Registro>>() {
            @Override
            public void onResponse(Call<List<Registro>> call, Response<List<Registro>> response) {
                if (response.isSuccessful()) {

                    RVRegistro adapter = new RVRegistro(getContext(), response.body());

                    recyclerViewRegistro.setAdapter(adapter);
                    recyclerViewRegistro.setLayoutManager(new LinearLayoutManager(getContext()));
                    recyclerViewRegistro.setHasFixedSize(true);
                }
            }

            @Override
            public void onFailure(Call<List<Registro>> call, Throwable t) {
                Log.e("Retrofit Error!!", t.getMessage());
            }
        });

        //boton a agrgagr un regstro
        btnAgregar.setOnClickListener(v -> {
            dialogBulder = new AlertDialog.Builder(getContext());
            final View viewRegistro = getLayoutInflater().inflate(R.layout.registro_add_fragment, null);
            dialogBulder.setView(viewRegistro);
            dialog = dialogBulder.create();
            dialog.show();

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