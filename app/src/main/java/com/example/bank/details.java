package com.example.bank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class details extends AppCompatActivity {
    private  static  final  String TAG = "MainActivity";

    DatabaseHelper mDatabaseHelper;
    private Button btnAdd;
    private EditText editText, emailid, balance;
    String newEntry = "";
    String nemEmail = "";
    String bal = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        mDatabaseHelper=new DatabaseHelper(this);

        btnAdd = findViewById(R.id.mainhome);
        editText = findViewById(R.id.name);
        emailid = findViewById(R.id.email);
        balance = findViewById(R.id.money);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newEntry = editText.getText().toString();
                nemEmail = emailid.getText().toString();
                bal = balance.getText().toString();
                if (editText.length() != 0){
                    Log.d(TAG, "Entry : " + newEntry + ", " + nemEmail + ", " + bal);
                    mDatabaseHelper.addData(new databaseHandler(1,newEntry,nemEmail,bal));
                    editText.setText("");
                    emailid.setText("");
                    balance.setText("");
                    Toast.makeText(details.this,"Account Created Successfully!",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(details.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    toastMessage("Empty Field!");
                }
            }
        });

    }

    /* public void AddData(String newEntry){

         boolean insertData = mDatabaseHelper.addData(newEntry);
         Log.i(TAG,""+insertData);

         if(insertData){
             toastMessage("Data Inserted Successfully");
         }else{
             toastMessage("Something went wrong");
         }
     }*/
    private void toastMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}