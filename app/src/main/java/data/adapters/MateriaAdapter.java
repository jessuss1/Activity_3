package data.adapters;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import com.example.act3.R;
import data.models.Materia;

public class MateriaAdapter extends RecyclerView.Adapter<MateriaAdapter.MateriaViewHolder> {

    private List<Materia> materias;

    public MateriaAdapter(List<Materia> materias) {
        this.materias = materias;
    }

    @NonNull
    @Override
    public MateriaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_materia, parent, false);
        return new MateriaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MateriaViewHolder holder, int position) {
        Materia materia = materias.get(position);
        holder.tvClave.setText(materia.getClave());
        holder.tvNombre.setText(materia.getNombre());
        holder.tvCalificacion.setText(String.valueOf(materia.getCalificacion()));
        holder.tvTipo.setText(materia.getTipo());
        holder.tvFolio.setText(materia.getFolio());
    }

    @Override
    public int getItemCount() {
        return materias.size();
    }

    static class MateriaViewHolder extends RecyclerView.ViewHolder {
        TextView tvClave, tvNombre, tvCalificacion, tvTipo, tvFolio;

        MateriaViewHolder(@NonNull View itemView) {
            super(itemView);
            tvClave = itemView.findViewById(R.id.tvCVE);
            tvNombre = itemView.findViewById(R.id.tvMateria);
            tvCalificacion = itemView.findViewById(R.id.tvCalif);
            tvTipo = itemView.findViewById(R.id.tvTipo);
            tvFolio = itemView.findViewById(R.id.tvFolio);
        }
    }
}

