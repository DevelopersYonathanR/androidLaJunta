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
import com.example.lajunta_v_1.adapter.RVAlimento;
import com.example.lajunta_v_1.adapter.RVTrabajador;
import com.example.lajunta_v_1.api.ApiAdapter;
import com.example.lajunta_v_1.api.ApiAlimento;
import com.example.lajunta_v_1.models.Alimento;
import com.example.lajunta_v_1.models.Trabajador;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaAlimentosFragment extends Fragment {

    private RecyclerView recyclerViewAlimentos;
    private RVAlimento rvAlimento;
    private List<Alimento> alimentoList;
    ApiAlimento apiAlimento;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.alimentos_fragment, container,false);
        recyclerViewAlimentos = view.findViewById(R.id.recyclerViewAlimentos);





        Call<List<Alimento>> listaAlimentos = ApiAdapter.getAlimentoApi().listaAlimentos();
        listaAlimentos.enqueue(new Callback<List<Alimento>>() {
            @Override
            public void onResponse(Call<List<Alimento>> call, Response<List<Alimento>> response) {
                if (response.isSuccessful()) {

                    RVAlimento adapter = new RVAlimento(getContext(), response.body());

                    recyclerViewAlimentos.setAdapter(adapter);
                    recyclerViewAlimentos.setLayoutManager(new LinearLayoutManager(getContext()));
                    recyclerViewAlimentos.setHasFixedSize(true);
                }
            }

            @Override
            public void onFailure(Call<List<Alimento>> call, Throwable t) {
                Log.e("Retrofit Error!!", t.getMessage());
            }
        });

        return view;
    }
}
