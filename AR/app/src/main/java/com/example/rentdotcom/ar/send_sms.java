package com.example.rentdotcom.ar;

/**
 * Created by rentdotcom on 2017. 7. 27..
 */


import android.Manifest;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import android.content.IntentFilter;
import android.location.Address;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class send_sms extends Activity {

    EditText addrTxt;
    EditText msgTxt;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send_sms);

        Button sendBtn = (Button) findViewById(R.id.sendSmsBtn);
        sendBtn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                addrTxt = (EditText) send_sms.this.findViewById(R.id.addrEditText);
                msgTxt = (EditText) send_sms.this.findViewById(R.id.msgEditText);

                ActivityCompat.requestPermissions(send_sms.this,new String[]{Manifest.permission.SEND_SMS},1);

                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //지연시키길 원하는 밀리초 뒤에 동작
                        sendSMS(addrTxt.getText().toString(), msgTxt.getText().toString());
                        Log.i("sms",addrTxt.getText().toString());
                        Toast.makeText(send_sms.this, "SMS 발송 완료", Toast.LENGTH_LONG).show();
                    }
                }, 7000 );

                try {
                    // 1
                    //sendSmsMessage(addrTxt.getText().toString(), msgTxt.getText().toString());

                    // 2
                    //sendSMS(addrTxt.getText().toString(), msgTxt.getText().toString());



                } catch (Exception e) {
                    Toast.makeText(send_sms.this, e.toString(), Toast.LENGTH_LONG).show();
                    Log.e("sms_error",e.toString());
                    e.printStackTrace();
                }
            }
        });
    }

    protected void sendSmsMessage(String address, String message) throws Exception {
        // TODO Auto-generated method stub
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(address, null, message, null, null);

    }

    private void sendSMS(String phoneNumber, String message) {
        String SENT = "SMS_SENT";
        String DELIVERED = "SMS_DELIVERED";

        PendingIntent sentPI = PendingIntent.getBroadcast(this, 0,
                new Intent(SENT), 0);

        PendingIntent deliveredPI = PendingIntent.getBroadcast(this, 0,
                new Intent(DELIVERED), 0);

        //---when the SMS has been sent---
        registerReceiver(new BroadcastReceiver() {
            public void onReceive(Context arg0, Intent arg1) {
                switch (getResultCode()) {
                    case Activity.RESULT_OK:
                        Toast.makeText(getBaseContext(), "SMS sent", Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                        Toast.makeText(getBaseContext(), "Generic failure", Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_NO_SERVICE:
                        Toast.makeText(getBaseContext(), "No service", Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_NULL_PDU:
                        Toast.makeText(getBaseContext(), "Null PDU", Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_RADIO_OFF:
                        Toast.makeText(getBaseContext(), "Radio off", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        }, new IntentFilter(SENT));

        //---when the SMS has been delivered---
        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context arg0, Intent arg1) {
                switch (getResultCode()) {
                    case Activity.RESULT_OK:
                        Toast.makeText(getBaseContext(), "SMS delivered",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case Activity.RESULT_CANCELED:
                        Toast.makeText(getBaseContext(), "SMS not delivered",
                                Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        }, new IntentFilter(DELIVERED));

        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNumber, null, message, sentPI, deliveredPI);
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
    }
}

