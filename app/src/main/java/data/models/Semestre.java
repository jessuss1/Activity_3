package data.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.List;

public class Semestre implements Parcelable {
    private String nombre;
    private List<Materia> materias;

    protected Semestre(Parcel in) {
        nombre = in.readString();
        materias = in.createTypedArrayList(Materia.CREATOR);
    }

    public static final Creator<Semestre> CREATOR = new Creator<Semestre>() {
        @Override
        public Semestre createFromParcel(Parcel in) {
            return new Semestre(in);
        }

        @Override
        public Semestre[] newArray(int size) {
            return new Semestre[size];
        }
    };

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(nombre);
        parcel.writeTypedList(materias);
    }
}
