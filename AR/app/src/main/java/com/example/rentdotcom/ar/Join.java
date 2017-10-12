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
    Button buttonFInd;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        et_id = (EditText) findViewById(R.id.idInput);
        et_pw = (EditText) findViewById(R.id.passwordInput);
        et_pw_chk = (EditText) findViewById(R.id.passwordConfirm);

        sId = et_id.getText().toString();
        sPw = et_pw.getText().toString();
        sPw_chk = et_pw_chk.getText().toString();
    }


    void initializeVariable() {
        buttonFInd = (Button) findViewById(R.id.findMyKid);
    }

    void clickLoginButton() {
        buttonFInd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FindKidsInJoinOfParent.class);
                startActivity(intent);
            }
        });
    }
}

