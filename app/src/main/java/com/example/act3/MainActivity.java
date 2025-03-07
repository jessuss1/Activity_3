package com.example.act3;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView logTextView;
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        logTextView = findViewById(R.id.logTextView);
        scrollView = findViewById(R.id.scrollView2);

        String message = "Metodo onCreate";

        Log.d("Cycle", message);
        appendLog(message);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        String message = "Metodo onStart";
        Log.d("Cycle", message);
        appendLog(message);
    }

    @Override
    protected void onResume() {
        super.onResume();

        String message = "Metodo onResume";
        Log.d("msg", message);
        appendLog(message);
    }

    @Override
    protected void onPause() {
        super.onPause();

        String message = "Metodo onPause";
        Log.d("msg", message);
        appendLog(message);
    }

    @Override
    protected void onStop() {
        super.onStop();

        String message = "Metodo onStop";
        Log.d("msg", message);
        appendLog(message);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("msg", "Metodo onDestroy");
    }

    private void appendLog(String message) {

        // Time with seconds
        //String timeStamp = new SimpleDateFormat("hh:mm:ss", Locale.getDefault()).format(new Date());

        // Format the message with timestamp
        String logMessage = message;

        // Append the log message to the TextView
        logTextView.append(logMessage + "\n");

        // Scrolls to the bottom automatically
        scrollView.post(() -> scrollView.fullScroll(ScrollView.FOCUS_DOWN));

    }
}
