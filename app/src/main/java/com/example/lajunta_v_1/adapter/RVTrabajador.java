package com.example.lajunta_v_1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lajunta_v_1.R;
import com.example.lajunta_v_1.models.Registro;
import com.example.lajunta_v_1.models.Trabajador;

import java.util.List;

public class RVTrabajador extends RecyclerView.Adapter<RVTrabajador.ListaViewHolder>{
    private final Context context;
    private List<Trabajador> trabajadorList;

    public RVTrabajador(Context context, List<Trabajador> traRegistroList) {
        this.context = context;
        this.trabajadorList = traRegistroList;
    }

    public static class ListaViewHolder extends RecyclerView.ViewHolder {
        TextView txtRut;
        TextView txtIdUsuario;
        TextView txtNombre;
        TextView txtAepellido;


      ;


        public ListaViewHolder(@NonNull View view) {
            super(view);
            txtRut = view.findViewById(R.id.txtRut);
            txtIdUsuario = view.findViewById(R.id.txtIdUsuario);
            txtNombre = view.findViewById(R.id.txtNombre);
            txtAepellido = view.findViewById(R.id.txtApellido);


        }

    }

    @NonNull
    @Override
    public ListaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rv_lista_trabajador, parent, false);
        return new ListaViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ListaViewHolder holder, int position) {
        Trabajador trabajador = trabajadorList.get(position);
        holder.txtRut.setText(String.valueOf(trabajador.getRut()));
        holder.txtIdUsuario.setText(String.valueOf(trabajador.getId_usuario()));
        holder.txtNombre.setText(String.valueOf(trabajador.getNombre()));
        holder.txtAepellido.setText(String.valueOf(trabajador.getApellido()));




    }

    @Override
    public int getItemCount() {
        return trabajadorList.size();
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

