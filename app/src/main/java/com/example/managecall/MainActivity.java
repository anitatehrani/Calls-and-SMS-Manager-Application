package com.example.managecall;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ImageView phone = findViewById(R.id.phone);
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                variablepublic.flag = 0;
                Intent intent = new Intent(MainActivity.this, CallActivity.class);
                startActivity(intent);
            }
        });
        ImageView sms = findViewById(R.id.sms);
        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                variablepublic.flag = 0;
                Intent intent = new Intent(MainActivity.this, SmsActivity.class);
                startActivity(intent);
            }
        });
        ImageView pre = findViewById(R.id.prefix);
        pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                variablepublic.flag = 0;
                Intent intent = new Intent(MainActivity.this, PreActivity.class);
                startActivity(intent);
            }
        });
    }
}