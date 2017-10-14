package com.example.rentdotcom.ar;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.Button;
import android.view.View;
import android.support.v7.app.AlertDialog;
import android.widget.TextView;
import android.widget.Toast;
import android.content.DialogInterface;
import android.app.Activity;

/**
 * Created by sookmyung on 2017-10-14.
 */

public class DialogTest extends AppCompatActivity {

    private static final int DIALOG_ID = 0;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog);

        TextView dialogTextInJava;
        dialogTextInJava = (TextView)dialog.findViewById(R.id.dialogText);
        Typeface typeFace = Typeface.createFromAsset(getAssets(), "fonts/Guardians.ttf");
        dialogTextInJava.setTypeface(typeFace);

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();


    }


}





