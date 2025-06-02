package data.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.List;

public class Alumno implements Parcelable {
    private String nombre;
    private String numero_cuenta;
    private String periodo;
    private String carrera;
    private String plan;
    private List<Semestre> semestres;

    protected Alumno(Parcel in) {
        nombre = in.readString();
        numero_cuenta = in.readString();
        periodo = in.readString();
        carrera = in.readString();
        plan = in.readString();
        semestres = in.createTypedArrayList(Semestre.CREATOR);
    }

    public static final Creator<Alumno> CREATOR = new Creator<Alumno>() {
        @Override
        public Alumno createFromParcel(Parcel in) {
            return new Alumno(in);
        }

        @Override
        public Alumno[] newArray(int size) {
            return new Alumno[size];
        }
    };

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero_cuenta() {
        return numero_cuenta;
    }

    public void setNumero_cuenta(String numero_cuenta) {
        this.numero_cuenta = numero_cuenta;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public List<Semestre> getSemestres() {
        return semestres;
    }

    public void setSemestres(List<Semestre> semestres) {
        this.semestres = semestres;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(nombre);
        parcel.writeString(numero_cuenta);
        parcel.writeString(periodo);
        parcel.writeString(carrera);
        parcel.writeString(plan);
        parcel.writeTypedList(semestres);
    }
}
