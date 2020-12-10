package com.example.bank;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

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

        String str1, str2;
        Cursor data = mDatabaseHelper.getData();
        ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext()){
            str1 = data.getString(0);
            str2 = data.getString(1);
            listData.add(str1+ ".  " + str2);
        }
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        mListView.setAdapter(adapter);
    }

    private  void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }


}
