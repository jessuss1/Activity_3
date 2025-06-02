package data.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.act3.InfoDetallada;
import com.example.act3.R;

import java.util.List;

import data.models.Alumno;

public class AlumnoAdapter extends RecyclerView.Adapter<AlumnoAdapter.AlumnoViewHolder> {
    private List<Alumno> listaAlumnos;
    private Context context;

    public AlumnoAdapter(Context context, List<Alumno> listaAlumnos) {
        this.context = context;
        this.listaAlumnos = listaAlumnos;
    }

    public static class AlumnoViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombre, tvCuenta, tvCarrera;

        public AlumnoViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvCuenta = itemView.findViewById(R.id.tvNoCuenta);
            tvCarrera = itemView.findViewById(R.id.tvCarrera);
        }
    }

    @NonNull
    @Override
    public AlumnoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(context).inflate(R.layout.item_alumno, parent, false);
        return new AlumnoViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull AlumnoAdapter.AlumnoViewHolder holder, int position) {
        Alumno alumno = listaAlumnos.get(position);
        holder.tvNombre.setText("Nombre: " + alumno.getNombre());
        holder.tvCuenta.setText("No. de cuenta:" + alumno.getNumero_cuenta());
        holder.tvCarrera.setText("Carrera: " + alumno.getCarrera());

        //Evento click para cada alumno
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, InfoDetallada.class);
            intent.putExtra("alumno", alumno);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return listaAlumnos.size();
    }
}