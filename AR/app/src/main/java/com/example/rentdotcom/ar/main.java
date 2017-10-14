package com.example.rentdotcom.ar;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.DialogInterface;



import com.google.firebase.messaging.FirebaseMessaging;

/**
 * Created by sookmyung on 2017-10-14.
 */

public class main extends AppCompatActivity {
    Button buttonLocation, buttonDestination, buttonLogin, buttonJoin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        initializeVariable();
        clickLocationButton();
        clickDestinationButton();
        clickLoginButton();
        clickJoinButton();

    }

    void initializeVariable() {
        buttonLocation = (Button)findViewById(R.id.checkLocationOfKidButton);
        buttonDestination = (Button)findViewById(R.id.CheckDesticationOfKidButton);
        buttonLogin = (Button)findViewById(R.id.buttonLogin);
        buttonJoin = (Button)findViewById(R.id.buttonJoin);

    }

    void clickLocationButton() {
        buttonLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Intent intent = new Intent(getApplicationContext(), DialogTest.class);
               // startActivity(intent);

                Dialog dialog = new Dialog(main.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog);

                TextView dialogTextInJava;
                dialogTextInJava = (TextView)dialog.findViewById(R.id.dialogText);
                Typeface typeFace = Typeface.createFromAsset(getAssets(), "fonts/Guardians.ttf");
                dialogTextInJava.setTypeface(typeFace);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
    }

    void clickDestinationButton() {
        buttonDestination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(main.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_destination);

                TextView dialogTextInJava;
                dialogTextInJava = (TextView)dialog.findViewById(R.id.dialogText02);
                Typeface typeFace = Typeface.createFromAsset(getAssets(), "fonts/Guardians.ttf");
                dialogTextInJava.setTypeface(typeFace);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });
    }

    void clickLoginButton() {
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);

            }
        });
    }

    void clickJoinButton() {
        buttonJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Join.class);
                startActivity(intent);

            }
        });
    }

}
