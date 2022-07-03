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
import com.example.lajunta_v_1.adapter.RVInsumo;
import com.example.lajunta_v_1.api.ApiAdapter;
import com.example.lajunta_v_1.api.ApiAlimento;
import com.example.lajunta_v_1.api.ApiInsumo;
import com.example.lajunta_v_1.models.Alimento;
import com.example.lajunta_v_1.models.Insumo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaInsumosFragment extends Fragment {

    private RecyclerView recyclerViewInsumo;
    private RVInsumo rvInsumo;
    private List<Insumo> insumoList;
    ApiInsumo apiInsumo;

   /* private AlertDialog.Builder dialogBulder;
    private AlertDialog dialog;
    private Button btnIrAgrgar;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    private EditText txtNombreA, txtCantidaA, txtMedidaA;
    private Button btnAdd, btnCancelar;*/

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.insumos_fragment, container, false);
        recyclerViewInsumo = view.findViewById(R.id.recyclerViewInsumo);
       // btnIrAgrgar = view.findViewById(R.id.btnIrAgregar);


        Call<List<Insumo>> listaInsumos = ApiAdapter.getInsumoApi().listaInsumos();
        listaInsumos.enqueue(new Callback<List<Insumo>>() {

            @Override
            public void onResponse(Call<List<Insumo>> call, Response<List<Insumo>> response) {

                if (response.isSuccessful()) {

                    RVInsumo adapter = new RVInsumo(getContext(), response.body());
                    recyclerViewInsumo.setAdapter(adapter);
                    recyclerViewInsumo.setLayoutManager(new LinearLayoutManager(getContext()));
                    recyclerViewInsumo.setHasFixedSize(true);
                }

            }

            @Override
            public void onFailure(Call<List<Insumo>> call, Throwable t) {

            }

        });


        return view;
    }
}
