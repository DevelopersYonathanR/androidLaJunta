package com.example.lajunta_v_1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lajunta_v_1.R;
import com.example.lajunta_v_1.models.Alimento;

import java.util.List;

public class RVAlimento extends RecyclerView.Adapter<RVAlimento.ListaViewHolder>{
    private final Context context;
    private List<Alimento> alimentoList;

    public RVAlimento(Context context, List<Alimento> alimentoList) {
        this.context = context;
        this.alimentoList = alimentoList;
    }


    public static class ListaViewHolder extends RecyclerView.ViewHolder {
        TextView txtIda;
        TextView txtNoAl;
        TextView txtC;
        TextView txtm;


      ;


        public ListaViewHolder(@NonNull View view) {
            super(view);
            txtIda = view.findViewById(R.id.txtIdA);
            txtNoAl = view.findViewById(R.id.txtNombreAlimento);
            txtC = view.findViewById(R.id.txtCantidad);
            txtm = view.findViewById(R.id.txtMedida);


        }

    }

    @NonNull
    @Override
    public ListaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rv_lista_alimentos, parent, false);
        return new ListaViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ListaViewHolder holder, int position) {
        Alimento alimento = alimentoList.get(position);
        holder.txtIda.setText(String.valueOf(alimento.getId()));
        holder.txtNoAl.setText(String.valueOf(alimento.getNombre()));
        holder.txtC.setText(String.valueOf(alimento.getCantidad()));
        holder.txtm.setText(String.valueOf(alimento.getMedida()));




    }

    @Override
    public int getItemCount() {
        return alimentoList.size();
    }

}

/*

public class RVRegistro extends RecyclerView.Adapter<RVRegistro.ListaViewHolder>{
    private final Context context;
    private List<Registro> registroList;

    public RVRegistro(Context context, List<Registro> registroList) {
        this.context = context;
        this.registroList = registroList;
    }

    public static class ListaViewHolder extends RecyclerView.ViewHolder {

        TextView txtNombre;
        TextView txtAepellido;
        ;


        public ListaViewHolder(@NonNull View view) {
            super(view);
            txtNombre = view.findViewById(R.id.txtNombre);
            txtAepellido = view.findViewById(R.id.txtApellido);

        }

    }

    @NonNull
    @Override
    public ListaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rv_lista_registros, parent, false);
        return new ListaViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ListaViewHolder holder, int position) {
        Registro registro = registroList.get(position);
        holder.txtNombre.setText(String.valueOf(registro.getNombre()));
        holder.txtAepellido.setText(String.valueOf(registro.getApellido()));

    }

    @Override
    public int getItemCount() {
        return registroList.size();
    }

}*/ //copia de respaldo del recyclerwView de arriba

