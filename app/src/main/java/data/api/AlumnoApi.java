package data.api;

import java.util.List;

import data.models.Alumno;
import retrofit2.Call;
import retrofit2.http.GET;

public interface AlumnoApi {
    @GET("/kardex")
    Call<List<Alumno>> getAlumnos();
}
