package com.example.quran_app_39;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class SurahActivity extends AppCompatActivity {
    ListView ayatList;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.surah);
        DBHelper db = new DBHelper(SurahActivity.this);
        intent = getIntent();
        String translation = intent.getStringExtra("Translation");
        int surahId = intent.getIntExtra("SurahId",1);
        List<String> surah = db.getSurahById(surahId);
        ayatList = (ListView)findViewById(R.id.surah);
        AyatAdapter ayatAdapter = new AyatAdapter(SurahActivity.this, surah, surahId, translation);
        ayatList.setAdapter(ayatAdapter);
    }
}
