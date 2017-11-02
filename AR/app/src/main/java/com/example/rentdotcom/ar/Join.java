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
import android.app.AlertDialog;
import android.content.DialogInterface;
import me.drakeet.materialdialog.MaterialDialog;


/**
 * Created by sookmyung on 2017-10-01.
 */

public class Join extends AppCompatActivity {

    EditText et_id, et_pw, et_pw_chk;
    String sId, sPw, sPw_chk;
    Button buttonFInd,buttonCancel;
    EditText inputPhoneNumber;
    MaterialDialog mMaterialDialog;

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
       // mMaterialDialog = new MaterialDialog(this);


        Toast.makeText(getApplicationContext(), "Initializes successfully.",
                Toast.LENGTH_SHORT).show();

    }

    void clickFindButton() {
        buttonFInd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(getApplicationContext(), FindKidsInJoinOfParent.class);
                //startActivity(intent);

                Dialog dialog = new Dialog(Join.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.material_dialog_test);

                //inputPhoneNumber.setHintTextColor(Color.parseColor("#ff0000"));

                TextView dialogTextInJava;
                dialogTextInJava = (TextView)dialog.findViewById(R.id.dialogText);
                Typeface typeFace = Typeface.createFromAsset(getAssets(), "fonts/Guardians.ttf");
                dialogTextInJava.setTypeface(typeFace);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();



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

