package com.example.rentdotcom.ar;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessaging;

/**
 * Created by sookmyung on 2017-10-14.
 */

public class main extends AppCompatActivity {
    Button buttonLogin, buttonSignUp;
    EditText editTextID, editTextPassword;
    TextView title,title2,title3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        // Set up the login form.
        initializeVariable();
        clickLoginButton();
        clickSignUpButton();

        Typeface typeFace = Typeface.createFromAsset(getAssets(), "fonts/Guardians.ttf");
        title.setTypeface(typeFace);
        title2.setTypeface(typeFace);
        title3.setTypeface(typeFace);
    }

    void initializeVariable() {
        buttonLogin = (Button)findViewById(R.id.loginButton);
        buttonSignUp = (Button)findViewById(R.id.signupButton);
        editTextID = (EditText)findViewById(R.id.emailInput);
        editTextPassword = (EditText)findViewById(R.id.passwordInput);
        title = (TextView)findViewById(R.id.titleText1);
        title2= (TextView)findViewById(R.id.titleText2);
        title3 = (TextView)findViewById(R.id.titleText3);

    }

    void clickLoginButton() {
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    void clickSignUpButton() {
        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Join.class);
                startActivity(intent);
            }
        });
    }

    /**
     * Represents an asynchronous login/registration task used to authenticate
     * the user.
     */

}
