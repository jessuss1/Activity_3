package com.example.act3;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import data.adapters.AlumnoAdapter;
import data.api.AlumnoApi;
import data.api.RetrofitClient;
import data.models.Alumno;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaKardex extends AppCompatActivity {

    private RecyclerView rvAlumnos;
    private AlumnoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lista_kardex);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        rvAlumnos = findViewById(R.id.rvAlumnos);
        rvAlumnos.setLayoutManager(new LinearLayoutManager(this));
        AlumnoApi api = RetrofitClient.getRetrofitInstance().create(AlumnoApi.class);

        //Obtener todos los alumnos
        api.getAlumnos().enqueue(new Callback<List<Alumno>>() {
            @Override
            public void onResponse(Call<List<Alumno>> call, Response<List<Alumno>> response) {
                if (response.isSuccessful()) {
                    Log.d("API_RESPONSE", response.body().toString());
                    List<Alumno> lista = response.body();
                    // Se cargan los datos al adapter
                    adapter = new AlumnoAdapter(ListaKardex.this, lista);
                    rvAlumnos.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Alumno>> call, Throwable t) {
                Log.d("vailo","No esta funcionando");
                t.printStackTrace();
            }
        });
    }
}