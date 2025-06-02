package data.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.act3.R;
import data.models.Semestre;

import java.util.List;

public class SemestreAdapter extends RecyclerView.Adapter<SemestreAdapter.SemestreViewHolder> {

    private List<Semestre> semestres;

    public SemestreAdapter(List<Semestre> semestres) {
        this.semestres = semestres;
    }

    @NonNull
    @Override
    public SemestreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_semestre, parent, false);
        return new SemestreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SemestreViewHolder holder, int position) {
        Semestre semestre = semestres.get(position);
        holder.tvSemestre.setText(semestre.getNombre());

        // Configurar RecyclerView interno
        holder.rvMaterias.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext()));
        holder.rvMaterias.setAdapter(new MateriaAdapter(semestre.getMaterias()));
        holder.rvMaterias.setNestedScrollingEnabled(false); // importante para scroll fluido
    }

    @Override
    public int getItemCount() {
        return semestres.size();
    }

    static class SemestreViewHolder extends RecyclerView.ViewHolder {
        TextView tvSemestre;
        RecyclerView rvMaterias;

        SemestreViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSemestre = itemView.findViewById(R.id.tvSemestre);
            rvMaterias = itemView.findViewById(R.id.rvMaterias);
        }
    }
}
