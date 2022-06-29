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

import java.util.List;

public class RVRegistro extends RecyclerView.Adapter<RVRegistro.ListaViewHolder>{
    private final Context context;
    private List<Registro> registroList;

    public RVRegistro(Context context, List<Registro> registroList) {
        this.context = context;
        this.registroList = registroList;
    }

    public static class ListaViewHolder extends RecyclerView.ViewHolder {
        TextView txtId;
        TextView txtNombre;
        TextView txtAepellido;
        TextView txtIdHabitacion;
        TextView txtFechachaI;
        TextView txtFechachaT;
        TextView txtCorreo;
        TextView txtTel1;
        TextView txtTel2;
        TextView txtCostoDiario;
        TextView txtCostoTotal;

      ;


        public ListaViewHolder(@NonNull View view) {
            super(view);
            txtId = view.findViewById(R.id.txtId);
            txtNombre = view.findViewById(R.id.txtNombre);
            txtAepellido = view.findViewById(R.id.txtApellido);
            txtIdHabitacion = view.findViewById(R.id.txtIdHabitacion);
            txtFechachaI = view.findViewById(R.id.txtFechachaI);
            txtFechachaT = view.findViewById(R.id.txtFechachaT);
            txtCorreo = view.findViewById(R.id.txtCorreo);
            txtTel1 = view.findViewById(R.id.txtTel1);
            txtTel2 = view.findViewById(R.id.txtTel2);
            txtCostoDiario = view.findViewById(R.id.txtCostoDiario);
            txtCostoTotal = view.findViewById(R.id.txtCostoTotal);


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
        holder.txtIdHabitacion.setText(String.valueOf(registro.getId_habitacion()));
        holder.txtFechachaI.setText(String.valueOf(registro.getFecha_inicio()));
        holder.txtFechachaT.setText(String.valueOf(registro.getFecha_termino()));
        holder.txtCorreo.setText(String.valueOf(registro.getCorreo()));
        holder.txtTel1.setText(String.valueOf(registro.getTelefono()));
        holder.txtTel2.setText(String.valueOf(registro.getTelefono_2()));
        holder.txtCostoDiario.setText(String.valueOf(registro.getCosto_diario()));
        holder.txtCostoTotal.setText(String.valueOf(registro.getCosto_total()));



    }

    @Override
    public int getItemCount() {
        return registroList.size();
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

