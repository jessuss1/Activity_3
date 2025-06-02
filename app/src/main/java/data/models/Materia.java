package data.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Materia implements Parcelable {
    private String tipo;
    private String clave;
    private String letra;
    private String folio;
    private String nombre;
    private int calificacion;

    protected Materia(Parcel in) {
        tipo = in.readString();
        clave = in.readString();
        letra = in.readString();
        folio = in.readString();
        nombre = in.readString();
        calificacion = in.readInt();
    }

    public static final Creator<Materia> CREATOR = new Creator<Materia>() {
        @Override
        public Materia createFromParcel(Parcel in) {
            return new Materia(in);
        }

        @Override
        public Materia[] newArray(int size) {
            return new Materia[size];
        }
    };

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(tipo);
        parcel.writeString(letra);
        parcel.writeString(clave);
        parcel.writeString(folio);
        parcel.writeString(nombre);
        parcel.writeInt(calificacion);
    }
}
