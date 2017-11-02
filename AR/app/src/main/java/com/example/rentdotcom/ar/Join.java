package com.example.rentdotcom.ar;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by sookmyung on 2017-10-01.
 */

public class Join extends AppCompatActivity {
    Button buttonFInd, buttonCancel, buttonDialogCancel, buttonDialogConfirm;
    EditText inputPhoneNumber;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join);

        initializeVariable();
        clickFindButton();
        clickCancelButton();
    }

    void initializeVariable() {
        buttonFInd = (Button) findViewById(R.id.findMyKid);
        buttonCancel = (Button) findViewById(R.id.buttonCancel);
        inputPhoneNumber = (EditText) findViewById(R.id.number);
    }

    void clickFindButton() {
        buttonFInd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(getApplicationContext(), FindKidsInJoinOfParent.class);
                //startActivity(intent);

                final Dialog dialog = new Dialog(Join.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.material_dialog_test);

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
            }
        });
    }

    void clickCancelButton() {
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });
    }
}

