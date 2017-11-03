package gotravel.gotravaling;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;


/**
 * Created by sookmyung on 2017-11-03.
 */

public class Main extends AppCompatActivity {
    Button buttonLocation, buttonDialogCancel, buttonDialogConfirm;
    TextView textView01;
    private Handler mHandler;
    private Runnable mRunnable;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        initializeVariable();
        clickStartButton();

        mRunnable = new Runnable() {
            @Override
            public void run() {
                dialogConfirm();
            }
        };
        mHandler = new Handler();
        mHandler.postDelayed(mRunnable, 3000);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    void initializeVariable() {
        buttonLocation = (Button) findViewById(R.id.StartButton);
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

    void dialogConfirm() {
        final Dialog dialog = new Dialog(Main.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_confirm);
        TextView dialogTextInJava;
        dialogTextInJava = (TextView) dialog.findViewById(R.id.dialogText02);
        Typeface typeFace = Typeface.createFromAsset(getAssets(), "fonts/TmonMonsori.ttf");
        dialogTextInJava.setTypeface(typeFace);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

        buttonDialogCancel = (Button) dialog.findViewById(R.id.dialogCancel);
        buttonDialogCancel.setOnClickListener(new View.OnClickListener() {
            // Perform button logic
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        buttonDialogConfirm = (Button) dialog.findViewById(R.id.dialogConfirm);
        buttonDialogConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Authentication.class);
                startActivity(intent);
                dialog.dismiss();
            }
        });
    }
}

