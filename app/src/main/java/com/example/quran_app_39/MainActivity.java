package com.example.quran_app_39;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView allSurahsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        allSurahsList = findViewById(R.id.allSurahsList);
        DBHelper db = new DBHelper(MainActivity.this);
        db.CreateDatabase();
        List<String> allSurahs = db.getAllSurahs();
        SurahListAdapter surahAdapter = new SurahListAdapter(getApplicationContext(), allSurahs);
//        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(MainActivity.this,
//                android.R.layout.simple_list_item_1,
//                allSurahs);
        allSurahsList.setAdapter(surahAdapter);
    }
}