package com.example.bank;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Collection;

public class money_transfer extends AppCompatActivity {
    private Button btnTransfer;
    private TextView name;
    private EditText money;
    private Spinner spinner;
    DatabaseHelper mDatabaseHelper;
    private static final String TAG = "MoneyTransferActivity";

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money_transfer);

        btnTransfer = findViewById(R.id.transfer);
        name = findViewById(R.id.name);
        money = findViewById(R.id.money);
        spinner = findViewById(R.id.spinner);
        mDatabaseHelper = new DatabaseHelper(this);

        populateListView();

        String bal = (String) getIntent().getExtras().get("bln");
        name.setText((String) getIntent().getExtras().get("nm"));

    }

    private  void populateListView(){
        Log.d(TAG, "populateListView: Display data in the ListView.");

        String str2;
        Cursor data = mDatabaseHelper.getData();
        ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext()){
            str2 = data.getString(1);
            if (str2.equals((String) getIntent().getExtras().get("nm"))){
                continue;
            }else{
                listData.add(str2);
            }
        }
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        spinner.setAdapter((SpinnerAdapter) adapter);

    }
}