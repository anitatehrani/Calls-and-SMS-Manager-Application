package com.example.managecall;



import android.content.Intent;

import android.os.Bundle;
import android.view.View;

import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SmsActivity extends AppCompatActivity {
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        TextView number = findViewById(R.id.number);
        TextView msg = findViewById(R.id.message);
        outState.putString("number", number.getText().toString());
        outState.putString("msg", msg.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        TextView number = findViewById(R.id.number);
        TextView msg = findViewById(R.id.message);
        number.setText(savedInstanceState.getString("number"));
        msg.setText(savedInstanceState.getString("msg"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sms);
        View root = findViewById(R.id.main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageView back = findViewById(R.id.back);
        back.setOnClickListener(v -> {
            if (variablepublic.flag == 0) {
                Intent intent = new Intent(SmsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        ImageView send = findViewById(R.id.msg);
        TextView number = findViewById(R.id.number);
        TextView msg = findViewById(R.id.message);
        number.setText(variablepublic.prefix);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setData(android.net.Uri.parse("smsto:" + number.getText()));
                    intent.putExtra("sms_body", msg.getText().toString());
                    startActivity(intent);

            }
        });
        ImageView prefix = findViewById(R.id.prefix);
        prefix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                variablepublic.flag = 1;
                Intent intent = new Intent(SmsActivity.this, PreActivity.class);
                startActivity(intent);
            }
        });

    }

}


