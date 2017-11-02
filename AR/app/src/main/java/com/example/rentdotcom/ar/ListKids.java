package com.example.rentdotcom.ar;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by sookmyung on 2017-11-01.
 */

public class ListKids extends AppCompatActivity {
    private SearchView searchView;
    private ListView listView;
    private ArrayAdapter adapter;
    private ArrayList<String> kid_names;
    private ArrayList<String> kid_id;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parentofjoininkidsfind);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), Join.class); // 전 화면으로 이동하게 만드는 것
                //intent.putExtra("NAME", kid_names.get(position).getLongitude());
                //intent.putExtra("EMAIL", kid_id.get(position).getLatitude());
                startActivity(intent);
            }
        });
    }
}
