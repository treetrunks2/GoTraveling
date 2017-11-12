package gotravel.gotravaling;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by sookmyung on 2017-11-03.
 */

public class Main_NoDialog extends AppCompatActivity {
    Button buttonLocation, buttonDialogCancel, buttonDialogConfirm, buttonCall;
    private Handler mHandler;
    private Runnable mRunnable;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);

        initializeVariable();
        clickStartButton();
        clickCallButton();

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    void initializeVariable() {
        buttonLocation = (Button) findViewById(R.id.StartButton);
        buttonCall = (Button)findViewById(R.id.callButton);
    }

    void clickStartButton() {
        buttonLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), /*수정*/UserMainActivity.class);
                startActivity(intent);
            }
        });
    }


    void clickCallButton() {
        buttonCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonCall = (Button)findViewById(R.id.callButton);
                buttonCall.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Uri uri = Uri.parse("tel:010-2333-0856");
                        Intent it = new Intent(Intent.ACTION_DIAL,uri);
                        startActivity(it);
                    }
                });
            }
        });
    }
}

