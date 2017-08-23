package com.example.rentdotcom.ar;

/**
 * Created by rentdotcom on 2017. 8. 2..
 */


import java.util.*;

import android.os.Bundle;
import android.app.*;
import android.content.*;
import android.view.*;


public class alarm extends Activity {
    AlarmManager mAlarmMgr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 알람 관리자 핸들을 구한다
        mAlarmMgr = (AlarmManager)getSystemService(ALARM_SERVICE);
    }

    // 1회 알람 시작 - 시간 간격 지정
    public void onBtnAlarm1() {
        // 수행할 동작을 생성
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(alarm.this, 0, intent, 0);
        // 1회 알람 시작
        mAlarmMgr.set(AlarmManager.RTC, System.currentTimeMillis() + 5000, pIntent);
    }

    // 반복 알람 시작 - 특정 시간 지정
    public void onBtnAlarm2() {
        // 수행할 동작을 생성
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(alarm.this, 0, intent, 0);

        // 알람이 발생할 정확한 시간을 지정
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.add(Calendar.SECOND, 5);
        // 반복 알람 시작
        mAlarmMgr.setRepeating(AlarmManager.RTC, calendar.getTimeInMillis(), 5000, pIntent);
    }

    // 알람 중지
    public void onBtnStop() {
        // 수행할 동작을 생성
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(alarm.this, 0, intent, 0);
        // 알람 중지
        mAlarmMgr.cancel(pIntent);
    }

    public void onClick(View v) {
        switch( v.getId() ) {
            case R.id.btnAlarm1 :
                // 1회 알람 시작 - 시간 간격 지정
                onBtnAlarm1();
                break;
            case R.id.btnAlarm2 :
                // 반복 알람 시작 - 특정 시간 지정
                onBtnAlarm2();
                break;
            case R.id.btnStop :
                // 알람 중지
                onBtnStop();
                break;
        }
    }

}

