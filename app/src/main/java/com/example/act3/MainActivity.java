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

        String message = "onCreate() was triggered!";

        Log.d("Cycle", message);
        appendLog(message);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button destroyButton = findViewById(R.id.destroyButton);

        // This button will trigger the onDestroy() method
        destroyButton.setOnClickListener(view -> finish());
    }

    @Override
    protected void onStart() {
        super.onStart();

        String message = "onStart() was triggered!";
        Log.d("Cycle", message);
        appendLog(message);
    }

    @Override
    protected void onResume() {
        super.onResume();

        String message = "onResume() was triggered!";
        Log.d("Cycle", message);
        appendLog(message);
    }

    @Override
    protected void onPause() {
        super.onPause();

        String message = "onPause() was triggered!";
        Log.d("Cycle", message);
        appendLog(message);
    }

    @Override
    protected void onStop() {
        super.onStop();

        String message = "onStop() was triggered!";
        Log.d("Cycle", message);
        appendLog(message);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Cycle", "onDestroy() was triggered!");
    }

    private void appendLog(String message) {
        // Get current time with seconds
        String timeStamp = new SimpleDateFormat("hh:mm:ss", Locale.getDefault()).format(new Date());

        // Format the message with timestamp
        String logMessage = "[" + timeStamp + "] " + message;

        // Append the log message to the TextView
        logTextView.append(logMessage + "\n");

        // Scrolls to the bottom automatically
        scrollView.post(() -> scrollView.fullScroll(ScrollView.FOCUS_DOWN));

        // Limit to 15 lines in the TextView and make it scrollable
        if (logTextView.getLineCount() > 15) {
            String text = logTextView.getText().toString();
            int start = text.indexOf("\n", text.indexOf("\n") + 1);
            logTextView.setText(text.substring(start));
        }
    }
}
