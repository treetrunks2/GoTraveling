package gotravel.gotravaling;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.TextureView;
import android.view.WindowManager;
import java.util.ArrayList;

public class CameraActivity extends AppCompatActivity {
    private static final int REQUEST_CAMERA = 1;
    private static final int REQUEST_FINE_LOCATION = 2;
    private static final int REQUEST_COARSE_LOCATION = 3;
    private TextureView mCameraTextureView;
    private Preview mPreview;
    private TmapClient tmapClient;
    private GpsDirectionInfo gpsDirectionInfo;
    private ArrayList<Location> pathPoints;
    private double dest_lon;
    private double dest_lat;
    DisplayMetrics dm;
    private ArrayList<Double> distancePerPoint;
    double totalDistance = 0;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        dm = getApplicationContext().getResources().getDisplayMetrics();
        mCameraTextureView = (TextureView) findViewById(R.id.cameraTextureView);
        //TODO: 카메라&위치권한 체크하는 코드 넣기
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CAMERA,
                            Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION},
                    0);
        }
        mPreview = new Preview(this, mCameraTextureView);

        Log.d("****Camera Actv","onCreate 실행");
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onResume() {
        super.onResume();
        mPreview.onResume();

        Intent intent = getIntent();
        dest_lon = intent.getExtras().getDouble("DEST_LON_KEY");
        dest_lat = intent.getExtras().getDouble("DEST_LAT_KEY");
        gpsDirectionInfo = new GpsDirectionInfo(this.getApplicationContext(), this);
        tmapClient = new TmapClient() {
            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                gpsDirectionInfo.setPathPoints(getPathPoints());

                getDistancePerPoint();
                gpsDirectionInfo.setDistancePerPoint(distancePerPoint);
                gpsDirectionInfo.setTotalDistance(getTotalDistance());
                gpsDirectionInfo.setTotalTime(getTotalTime());
                Log.i("****CameraAtiv", "onPostExecute");
            }
        };

        try {
            //tmapClient.execute(Double.toString(gpsDirectionInfo.lon),Double.toString(gpsDirectionInfo.lat),Double.toString(dest_lon),Double.toString(dest_lat)).get();
            tmapClient.execute(Double.toString(gpsDirectionInfo.lon),Double.toString(gpsDirectionInfo.lat),"126.964676", "37.545892").get();
        } catch (Exception e) {
            Log.e("****CameraActv error","tmapClient execute error");
            e.printStackTrace();
        }
        Log.d("****Camera Actv", "onResume 실행");
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onPause() {
        super.onPause();
        mPreview.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    public void getDistancePerPoint() {
        distancePerPoint = new ArrayList<Double>();
        for (int i = 0; i < tmapClient.getPathPoints().size() - 1; i++) {
            Location currentPoint = tmapClient.getPathPoints().get(i);
            Location nextPoint = tmapClient.getPathPoints().get(i + 1);
            double distance = gpsDirectionInfo.calculateDistance(currentPoint.getLatitude(), currentPoint.getLongitude(),
                    nextPoint.getLatitude(), nextPoint.getLongitude());
            totalDistance += distance;
            distancePerPoint.add(distance);
        }

    }


}