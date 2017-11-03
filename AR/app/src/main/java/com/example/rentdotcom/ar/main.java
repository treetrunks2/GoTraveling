package com.example.rentdotcom.ar;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.DialogInterface;



import com.google.firebase.messaging.FirebaseMessaging;

import static com.example.rentdotcom.ar.R.id.imageView;

/**
 * Created by sookmyung on 2017-10-14.
 */

public class main extends AppCompatActivity {
    Button buttonLocation, buttonDestination, buttonLogin, buttonJoin,
            buttonDialogCancel, buttonDialogConfirm, buttonDialogCall;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        initializeVariable();
        clickLocationButton();
        clickDestinationButton();
    }

    void initializeVariable() {
        buttonLocation = (Button)findViewById(R.id.checkLocationOfKidButton);
        buttonDestination = (Button)findViewById(R.id.CheckDesticationOfKidButton);

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setBackground(new ShapeDrawable(new OvalShape()));
        imageView.setClipToOutline(true);

    }

    void clickLocationButton() {
        buttonLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Intent intent = new Intent(getApplicationContext(), DialogTest.class);
               // startActivity(intent);

                final Dialog dialog = new Dialog(main.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog);


                TextView dialogTextInJava;
                dialogTextInJava = (TextView)dialog.findViewById(R.id.dialogText);
                Typeface typeFace = Typeface.createFromAsset(getAssets(), "fonts/TmonMonsori.ttf");
                dialogTextInJava.setTypeface(typeFace);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

                buttonDialogCancel = (Button)dialog.findViewById(R.id.dialogCancel);
                buttonDialogCancel.setOnClickListener(new View.OnClickListener() {
                    // Perform button logic
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "successfully.", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });


                buttonDialogConfirm = (Button)dialog.findViewById(R.id.dialogConfirm);
                buttonDialogConfirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "successfully.", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
                /*
                buttonDialogCall = (Button)dialog.findViewById(R.id.dialogCall);
                buttonDialogCall.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Uri uri = Uri.parse("tel:010-2333-0856");
                        Intent it = new Intent(Intent.ACTION_DIAL,uri);
                        startActivity(it);
                    }
                });
                */
            }
        });
    }

    void clickDestinationButton() {
        buttonDestination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(main.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_destination);

                TextView dialogTextInJava;
                dialogTextInJava = (TextView)dialog.findViewById(R.id.dialogText02);
                Typeface typeFace = Typeface.createFromAsset(getAssets(), "fonts/TmonMonsori.ttf");
                dialogTextInJava.setTypeface(typeFace);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

                buttonDialogCancel = (Button)dialog.findViewById(R.id.dialogCancel);
                buttonDialogCancel.setOnClickListener(new View.OnClickListener() {
                    // Perform button logic
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "successfully.", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });

                buttonDialogConfirm = (Button)dialog.findViewById(R.id.dialogConfirm);
                buttonDialogConfirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "successfully.", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });

            }
        });
    }

}
