package com.example.managecall;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pre);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        if(variablepublic.preflag == 1)
        {
            RadioButton it= findViewById(R.id.it);
            it.setChecked(true);
        }
        else if(variablepublic.preflag == 2)
        {
            RadioButton us= findViewById(R.id.uk);
            us.setChecked(true);
        }
        else if(variablepublic.preflag == 3)
        {
            RadioButton fr= findViewById(R.id.fr);
            fr.setChecked(true);
        }
        else if(variablepublic.preflag == 4)
        {
            RadioButton es= findViewById(R.id.es);
            es.setChecked(true);
        }
        ImageView back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(variablepublic.flag == 0)
                {
                    Intent intent = new Intent(PreActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                else if(variablepublic.flag == 1)
                {
                    variablepublic.flag = 0;
                    Intent intent = new Intent(PreActivity.this, SmsActivity.class);
                    startActivity(intent);
                }
                else if(variablepublic.flag == 2)
                {
                    variablepublic.flag = 0;
                    Intent intent = new Intent(PreActivity.this, CallActivity.class);
                    startActivity(intent);
                }
            }
        });
        RadioButton it= findViewById(R.id.it);
        it.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                variablepublic.prefix = "+39";
                variablepublic.preflag = 1;
            }
        });
        RadioButton us= findViewById(R.id.uk);
        us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                variablepublic.prefix = "+44";
                variablepublic.preflag = 2;
            }
        });
        RadioButton fr= findViewById(R.id.fr);
        fr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                variablepublic.prefix = "+33";
                variablepublic.preflag = 3;
            }
        });
        RadioButton es= findViewById(R.id.es);
        es.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                variablepublic.prefix = "+34";
                variablepublic.preflag = 4;
            }
        });
    }
}