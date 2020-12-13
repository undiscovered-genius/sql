package com.example.bank;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class money_transfer extends AppCompatActivity {
    private Button btnTransfer;
    private TextView name;
    private EditText money;
    private Spinner spinner;
    DatabaseHelper mDatabaseHelper;
    private static final String TAG = "MoneyTransferActivity";
    private String str2;

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

        btnTransfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int trn_mny, crn_bln;
                trn_mny = Integer.parseInt(money.getText().toString());
                crn_bln = Integer.parseInt(bal);
                if (trn_mny > crn_bln){
                    Toast.makeText(money_transfer.this,"AVAILABLE Balance is LOW",Toast.LENGTH_SHORT).show();
                }else if (trn_mny == crn_bln){
                    Toast.makeText(money_transfer.this,"ACCOUNT Balance cannot be 0",Toast.LENGTH_SHORT).show();
                }else{
                    String baln = String.valueOf(crn_bln-trn_mny);
                    String nm = ((String) getIntent().getExtras().get("nm"));
                    String nm2 = spinner.getSelectedItem().toString();
                    if (nm2.equals("Select the Person")){
                        Toast.makeText(money_transfer.this,"Please Select a Receiver",Toast.LENGTH_SHORT).show();
                    }else{
                        String trn = transferAccount(nm2);
                        int crn_bln2 = Integer.parseInt(trn);
                        String baln2 = String.valueOf(trn_mny + crn_bln2);
                        mDatabaseHelper.updateContact(new databaseHandler(nm,baln));
                        mDatabaseHelper.updateContact(new databaseHandler(nm2,baln2));
                        Toast.makeText(money_transfer.this,"TRANSFER Successful",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(money_transfer.this,MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
            }
        });
    }

    private String transferAccount(String name) {
        Log.d(TAG, "TransferAccountDetail: Display Account Balance in String");

        Cursor data = mDatabaseHelper.getData();
        //String str2 = "";

        while (data.moveToNext()) {
            String comp = data.getString(1);
            if (comp.equals(name)) {
                str2 = data.getString(3);
            }
        }

        String s = String.valueOf(str2);
        Log.d(TAG, "                        " + String.valueOf(s));
        return s;
    }

    private  void populateListView(){
        Log.d(TAG, "populateListView: Display data in the ListView.");

        String str2;
        Cursor data = mDatabaseHelper.getData();
        ArrayList<String> listData = new ArrayList<>();
        listData.add("Select the Person");
        while(data.moveToNext()){
            str2 = data.getString(1);
            if (str2.equals((String) getIntent().getExtras().get("nm"))){
                continue;
            }else{
                listData.add(str2);
            }
        }
        ListAdapter adapter = new ArrayAdapter<>(this, R.layout.color_spinner_layout, listData);
//        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(this,listData ,R.layout.color_spinner_layout);
//        arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_layout);
//        spinner.setAdapter(arrayAdapter);
        spinner.setAdapter((SpinnerAdapter) adapter);


    }
}