package com.example.lajunta_v_1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lajunta_v_1.R;

import com.example.lajunta_v_1.models.Habitacion;

import java.util.List;

public class RVHabitacion extends RecyclerView.Adapter<RVHabitacion.ListaViewHolder>{
    private final Context context;
    private List<Habitacion> habitacionList;

    public RVHabitacion(Context context, List<Habitacion> habitacionList) {
        this.context = context;
        this.habitacionList = habitacionList;
    }


    public static class ListaViewHolder extends RecyclerView.ViewHolder {
        TextView txtIdHab;
        TextView txtNoHAB;
        TextView txtNumP;
        TextView txtCostop;


      ;


        public ListaViewHolder(@NonNull View view) {
            super(view);
            txtIdHab = view.findViewById(R.id.txtIdHab);
            txtNoHAB = view.findViewById(R.id.txtNombreHabitacion);
            txtNumP = view.findViewById(R.id.txtNumPersonas);
            txtCostop = view.findViewById(R.id.txtCostoPersonas);


        }

    }

    @NonNull
    @Override
    public ListaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rv_lista_habitaciones, parent, false);
        return new ListaViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ListaViewHolder holder, int position) {
        Habitacion habitacion = habitacionList.get(position);
        holder.txtIdHab.setText(String.valueOf(habitacion.getId()));
        holder.txtNoHAB.setText(String.valueOf(habitacion.getNombre()));
        holder.txtNumP.setText(String.valueOf(habitacion.getNum_personas()));
        holder.txtCostop.setText(String.valueOf(habitacion.getNum_personas()));




    }

    @Override
    public int getItemCount() {
        return habitacionList.size();
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

