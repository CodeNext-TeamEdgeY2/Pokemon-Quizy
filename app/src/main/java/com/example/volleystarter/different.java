package com.example.volleystarter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class different extends AppCompatActivity {
    TextView pt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_different);
        pt = findViewById(R.id.hapoints);

        Bundle newBundle = getIntent().getExtras();
        int newPointData = newBundle.getInt("Points");
        pt.setText(String.valueOf(newPointData));
    }

    public void back(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void back2(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
}