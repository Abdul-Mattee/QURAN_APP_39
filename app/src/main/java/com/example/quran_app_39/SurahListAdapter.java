package com.example.quran_app_39;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class SurahListAdapter extends BaseAdapter {

    Context c;
    List<String> allSurahs;
    LayoutInflater inflater;
    public SurahListAdapter(Context context, List<String> surahs){
        c = context;
        allSurahs = surahs;
        inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return allSurahs.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        DBHelper db = new DBHelper(c);
         view= inflater.inflate(R.layout.activity_surah_list_view, null);
        TextView surahName = view.findViewById(R.id.surahNameView);
        TextView ayatCountView = view.findViewById(R.id.ayatConuter);
        surahName.setText(allSurahs.get(i));
        int ayatCount = db.getSurahAyatCount(i+1);
        ayatCountView.setText("آيات : " + String.valueOf(ayatCount));
//        Toast.makeText(c, ayatCount, Toast.LENGTH_SHORT);
//        ayatCount.setText(String.valueOf(db.getSurahAyatCount(i-1)));
        return view;
    }
}