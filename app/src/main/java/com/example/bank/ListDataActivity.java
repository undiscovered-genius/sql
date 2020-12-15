package com.example.bank;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import static android.widget.AdapterView.*;

public class ListDataActivity extends AppCompatActivity {

    private static final String TAG = "ListDataActivity";
    DatabaseHelper mDatabaseHelper;
    private ListView mListView;
    private static final String TABLE_NAME = "people_table";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);
        mListView = (ListView) findViewById(R.id.listView);
        mDatabaseHelper = new DatabaseHelper(this);

        populateListView();

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object itemClickListener =  parent.getItemAtPosition(position);

                Intent intent = new Intent(ListDataActivity.this,transfer.class);
                String str1, str2, str3, str4;
                Cursor data = mDatabaseHelper.getData();
                ArrayList<String> listData = new ArrayList<>();
                data.moveToPosition(position);
                    str1 = data.getString(0);
                    str2 = data.getString(1);
                    str3 = data.getString(2);
                    str4 = data.getString(3);

                intent.putExtra("str1",str1);
                intent.putExtra("str2",str2);
                intent.putExtra("str3",str3);
                intent.putExtra("str4",str4);
                startActivity(intent);
                finish();
            }
        });
    }
//    private  void populateListView(){
//        Log.d(TAG, "populateListView: Display data in the ListView.");
//
//        mDatabaseHelper.getAllContacts();
//        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,  mDatabaseHelper.getAllContacts());
//        mListView.setAdapter(adapter);
//    }

    private  void populateListView(){
        Log.d(TAG, "populateListView: Display data in the ListView.");

        String str1, str2, str3, str4;
        Cursor data = mDatabaseHelper.getData();
        ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext()){
            str1 = data.getString(0);
            str2 = data.getString(1);
            str3 = data.getString(2);
            str4 = data.getString(3);
            listData.add(str1 + " | " + str2 + " | " + str3 + " | " + str4);
        }
        ListAdapter adapter = new ArrayAdapter<>(this, R.layout.color_lsit_layout, listData);
        mListView.setAdapter(adapter);
    }

    private  void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }


}
