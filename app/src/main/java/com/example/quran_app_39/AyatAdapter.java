package com.example.quran_app_39;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AyatAdapter extends BaseAdapter {
    Context c;
    List<String> surah;
    LayoutInflater layoutInflater;
    String translation;
    int surahId;
    public AyatAdapter(Context context, List<String> _surah,int _surahId, String translate){
        c = context;
        surah = _surah;
        layoutInflater = LayoutInflater.from(context);
        translation = translate;
        surahId = _surahId;
    }
    @Override
    public int getCount() {
        return surah.size();
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
        view = layoutInflater.inflate(R.layout.activity_ayat, null);
        DBHelper db = new DBHelper(c);
        TextView ayat = view.findViewById(R.id.singleAyat);
        TextView ayatTranslation = view.findViewById(R.id.ayatTranslation);
        ayat.setText(surah.get(i));
        List<String> surahTranslation = null;
        if(!TextUtils.equals(translation, "none") && !TextUtils.isEmpty(translation)){
            surahTranslation = db.getSurahTranslation(surahId, translation);
            ayatTranslation.setText(surahTranslation.get(i));
        }else{
            ayatTranslation.setText("");
        }
        return view;
    }
}
