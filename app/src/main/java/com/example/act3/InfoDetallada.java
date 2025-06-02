package com.example.act3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

import data.models.Alumno;
import data.models.Semestre;

public class InfoDetallada extends AppCompatActivity {

    TextView tvNombreEnDetalle, tvNoCuentaEnDetalle, tvPeriodoEnDetalle, tvCarreraEnDetalle,tvVerbo, tvPromedio;
    Button btnMostrarKardex;
    List<Semestre> semestres;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_info_detallada);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Alumno alumno = getIntent().getParcelableExtra("alumno");

        tvVerbo = findViewById(R.id.tvVerbo);
        tvNombreEnDetalle = findViewById(R.id.tvNombreEnDetalle);
        tvCarreraEnDetalle = findViewById(R.id.tvCarreraEnDetalle);
        tvPeriodoEnDetalle = findViewById(R.id.tvPeriodoEnDetalle);
        tvNoCuentaEnDetalle = findViewById(R.id.tvNoCuentaEnDetalle);

        tvNombreEnDetalle.setText("Alumno: " + alumno.getNombre());
        tvCarreraEnDetalle.setText("Carrera: " + alumno.getCarrera());
        tvPeriodoEnDetalle.setText("Fase: " + alumno.getFase());
        tvNoCuentaEnDetalle.setText("No. de cuenta: " + alumno.getNumeroCuenta());
        tvVerbo.setText(
            "El que suscribe, M.C. OSCAR MANUEL PEÑA BAÑUELOS, Director de la 4800-FACULTAD DE " +
            "INFORMÁTICA MAZATLÁN, con clave U.A. 4800, de la Universidad Autónoma de Sinaloa, por " +
            "medio de la presente hace constar que el (la) C. " + alumno.getNombre() + " con No. de " +
            "cuenta: "+alumno.getNumeroCuenta()+"; es alumno(a) de esta institución, en el periodo 8 " +
            "de la carrera: 4 LICENCIATURA EN INGENIERÍA EN SISTEMAS DE INFORMACIÓN"
        );
//
    }
}