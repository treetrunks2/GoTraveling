package com.example.rentdotcom.ar;

import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 위치기반 어플리케이션 : 사용자의 위치를 활용한 어플리케이션
        // 폰에서 위치정보를 얻는 방법
        // 1. GPS - 위성에서 정보를 받아 삼각측량으로 위치를 계산,
        //           정확하다, 건물 안에서는 안된다
        // 2. 3G망 - 인접된 전화기지국에서오는 전파의 시간 차이로 위치를 계산,
        //          실내에서도 가능
        // 3. WiFi 의 AP

        // ■ 위치정보를 사용하려면, 권한 설정을 해야함 AndroidManifest.xml
        //           android.permission.ACCESS_FINE_LOCATION

        TextView tv = (TextView)findViewById(R.id.textView2);

        LocationManager lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        // 위치관리자 객체를 얻어온다

//        lm.getBestProvider(criteria, enabledOnly)
        List<String> list = lm.getAllProviders(); // 위치제공자 모두 가져오기

        String str = ""; // 출력할 문자열
        for (int i = 0; i < list.size(); i++) {
            str += "위치제공자 : " + list.get(i) + ", 사용가능여부 -"
                    + lm.isProviderEnabled(list.get(i)) +"\n";
        }
        tv.setText(str);

        Button b = (Button)findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        getApplicationContext(), // 현재 화면의 제어권자
                        gpsinformation.class); // 다음 넘어갈 클래스 지정
                startActivity(intent); // 다음 화면으로 넘어간다
            }
        });

        Button b1 = (Button)findViewById(R.id.button1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        getApplicationContext(), // 현재 화면의 제어권자
                        alarm.class); // 다음 넘어갈 클래스 지정
                startActivity(intent); // 다음 화면으로 넘어간다
            }
        });




    } // end of onCreate
} // end of class
