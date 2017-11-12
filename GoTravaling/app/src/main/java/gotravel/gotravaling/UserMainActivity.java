package gotravel.gotravaling;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.location.Location;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.support.v7.widget.SearchView;

import com.skp.Tmap.TMapData;
import com.skp.Tmap.TMapPOIItem;
import com.skp.Tmap.TMapTapi;

import java.util.ArrayList;
import java.util.List;

public class UserMainActivity extends AppCompatActivity {

    private SearchView searchView;
    private TMapTapi tmaptapi;
    private TMapData tmapdata;
    private ListView listView;
    private ArrayAdapter adapter;
    private ArrayList<Location> locs;
    private ArrayList<String> loc_names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main);

        //getSupportActionBar().setBackgroundDrawable(new ColorDrawable());
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        tmaptapi = new TMapTapi(this);
        tmaptapi.setSKPMapAuthentication ("df216313-6d2c-32a6-aa05-ad4d7ac44879");
        tmapdata = new TMapData();
        listView = (ListView) findViewById(R.id.listview);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), CameraActivity.class);
                intent.putExtra("DEST_LON_KEY", locs.get(position).getLongitude());
                intent.putExtra("DEST_LAT_KEY", locs.get(position).getLatitude());
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_searchbar, menu);
        searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setQueryHint("Search View");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                tmapdata.findTitlePOI(query, new TMapData.FindTitlePOIListenerCallback() {
                    @Override
                    public void onFindTitlePOI(ArrayList<TMapPOIItem> arrayList) {
                        String TAG = "---TMAP POI";
                        if (arrayList != null) {
                            Log.e(TAG, "arTMapPOIItem_1.size() = " + arrayList.size());
                            Message msg = handler.obtainMessage();
                            locs = new ArrayList<Location>();
                            loc_names = new ArrayList<String>();
                            for (int i = 0; i < arrayList.size(); i++) {
                                Location loc = new Location("provider");
                                loc.setLatitude(Double.parseDouble(arrayList.get(i).frontLat));
                                loc.setLongitude(Double.parseDouble(arrayList.get(i).frontLon));
                                locs.add(loc);
                                loc_names.add(arrayList.get(i).name);
                            }
                            handler.sendMessage(msg);
                        } else {
                            Log.e(TAG, "arTMapPOIItem_1 null");
                            Toast.makeText(getApplicationContext(),"not found",Toast.LENGTH_SHORT);
                        }
                    }
                });
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }

        });
        return true;
    }


    final Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            adapter = new ArrayAdapter(getApplicationContext(), R.layout.list_item, loc_names);
            listView.setAdapter(adapter);
        }
    };

}
