package com.example.managecall;
import android.Manifest;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class CallActivity extends AppCompatActivity {
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        TextView number = findViewById(R.id.number);
        outState.putString("number", number.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        TextView number = findViewById(R.id.number);
        number.setText(savedInstanceState.getString("number"));

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_call);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageView call = findViewById(R.id.call);
        TextView number = findViewById(R.id.number);
        number.setText(variablepublic.prefix);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(android.net.Uri.parse("tel:" + number.getText()));
                startActivity(intent);
            }
        });
        ImageView back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (variablepublic.flag == 0) {
                    Intent intent = new Intent(CallActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
        ImageView prefix = findViewById(R.id.prefix);
        prefix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                variablepublic.flag = 2;
                Intent intent = new Intent(CallActivity.this, PreActivity.class);
                startActivity(intent);
            }
        });
        Button callnow = findViewById(R.id.callnow);
        callnow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(CallActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(CallActivity.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL_PERMISSION);
                } else {
                    makePhoneCall();
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CALL_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makePhoneCall();
            } else {
                Toast.makeText(this, "Permission DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void makePhoneCall() {
        TextView number = findViewById(R.id.number);
        String phoneNumber = number.getText().toString();
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        startActivity(intent);
    }

    private static final int REQUEST_CALL_PERMISSION = 1;
}


