package com.example.bank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.LogPrinter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private  static  final  String TAG = "MainActivity";

    DatabaseHelper mDatabaseHelper;
    private Button btnAdd, btnView;
    private EditText editText;
    String newEntry = "";
    //boolean insertData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDatabaseHelper=new DatabaseHelper(this);

        btnAdd = findViewById(R.id.button);
        btnView = findViewById(R.id.button2);
        editText = findViewById(R.id.name);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newEntry = editText.getText().toString();
                if (editText.length() != 0){
                    Log.d(TAG, "Entry : " + newEntry);
                    mDatabaseHelper.addData(new databaseHandler(1,newEntry));
                    editText.setText("");
                }else{
                    toastMessage("Empty Field!");
                }
            }
        });

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListDataActivity.class);
                startActivity(intent);
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