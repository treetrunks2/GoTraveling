package com.example.rentdotcom.ar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by sookmyung on 2017-10-01.
 */

public class Join extends AppCompatActivity {

    EditText et_id, et_pw, et_pw_chk;
    String sId, sPw, sPw_chk;
    Button buttonFInd,buttonCancel;

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
    }

    void clickFindButton() {
        buttonFInd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FindKidsInJoinOfParent.class);
                startActivity(intent);
            }
        });
    }

    void clickCancelButton() {
        buttonFInd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });
    }

}

