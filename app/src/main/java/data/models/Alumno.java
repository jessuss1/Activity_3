package data.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.List;

public class Alumno implements Parcelable {
    private String carrera;
    private String correo;
    private String direccion;
    private String fase;
    private String foto;
    private String nombre;
    private String numero_cuenta;
    private String telefono;
    private int id;

    // Constructor
    public Alumno(String carrera, String correo, String direccion, String fase,
                  String foto, String nombre, String numero_cuenta, String telefono, int id) {
        this.carrera = carrera;
        this.correo = correo;
        this.direccion = direccion;
        this.fase = fase;
        this.foto = foto;
        this.nombre = nombre;
        this.numero_cuenta = numero_cuenta;
        this.telefono = telefono;
        this.id = id;
    }

    // Constructor para Parcelable
    protected Alumno(Parcel in) {
        carrera = in.readString();
        correo = in.readString();
        direccion = in.readString();
        fase = in.readString();
        foto = in.readString();
        nombre = in.readString();
        numero_cuenta = in.readString();
        telefono = in.readString();
        id = in.readInt();
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(carrera);
        dest.writeString(correo);
        dest.writeString(direccion);
        dest.writeString(fase);
        dest.writeString(foto);
        dest.writeString(nombre);
        dest.writeString(numero_cuenta);
        dest.writeString(telefono);
        dest.writeInt(id);
    }

    // Getters y setters (opcional)
    public String getCarrera() { return carrera; }
    public void setCarrera(String carrera) { this.carrera = carrera; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getFase() { return fase; }
    public void setFase(String fase) { this.fase = fase; }

    public String getFoto() { return foto; }
    public void setFoto(String foto) { this.foto = foto; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getNumeroCuenta() { return numero_cuenta; }
    public void setNumeroCuenta(String numero_cuenta) { this.numero_cuenta = numero_cuenta; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
}