package com.example.quran_app_39;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView allSurahsList;
    NavigationView navbar;
    ActionBarDrawerToggle navbarToggler;
    DrawerLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar)findViewById(R.id.navigationToolbar);
        setSupportActionBar(toolbar);

        navbar = (NavigationView)findViewById(R.id.navHeader);
        drawer = (DrawerLayout)findViewById(R.id.drawer);

        navbarToggler = new ActionBarDrawerToggle(this, drawer, toolbar,R.string.open, R.string.close);
        drawer.addDrawerListener(navbarToggler);
        navbarToggler.syncState();
        navbar.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.englishTranslation:
                        Toast.makeText(MainActivity.this, "English Translation", Toast.LENGTH_SHORT).show();
                        drawer.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.urduTranslation:
                        Toast.makeText(MainActivity.this, "Urdu Translation", Toast.LENGTH_SHORT).show();
                        drawer.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.noTranslation:
                        Toast.makeText(MainActivity.this, "No Translation", Toast.LENGTH_SHORT).show();
                        drawer.closeDrawer(GravityCompat.START);
                        break;
                }
                return false;
            }
        });
        allSurahsList = findViewById(R.id.allSurahsList);
        DBHelper db = new DBHelper(MainActivity.this);
        db.CreateDatabase();
        List<String> allSurahs = db.getAllSurahs();
        SurahListAdapter surahAdapter = new SurahListAdapter(getApplicationContext(), allSurahs);
        allSurahsList.setAdapter(surahAdapter);
    }
}