package com.example.bank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class transfer extends AppCompatActivity {

    private Button btnHome, btnTransfer;
    private TextView name, emailid, balance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);

        btnHome = findViewById(R.id.mainhome);
        btnTransfer = findViewById(R.id.transfer);
        name = findViewById(R.id.name);
        emailid = findViewById(R.id.email);
        balance = findViewById(R.id.crn_bln);

        name.setText((String) getIntent().getExtras().get("str2"));
        emailid.setText((String) getIntent().getExtras().get("str3"));
        balance.setText((String) getIntent().getExtras().get("str4"));

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(transfer.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnTransfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(transfer.this, "Coming Soon!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}