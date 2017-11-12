package gotravel.gotravaling;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by sookmyung on 2017-11-03.
 */

public class Authentication extends AppCompatActivity {
    Button buttonCancel,button_assign;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.authen);

        initializeVariable();
        clickCancelButton();

        TextView textInJava;
        textInJava = (TextView) findViewById(R.id.text01);
        Typeface typeFace = Typeface.createFromAsset(getAssets(), "fonts/KoPubDotumBold.ttf");
        textInJava.setTypeface(typeFace);

        button_assign = (Button) findViewById(R.id.buttonAssign);
        button_assign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.sendEmptyMessageDelayed(0, 1000);
            }
        });
    }

    void initializeVariable() {
        buttonCancel = (Button) findViewById(R.id.buttonCancel);
    }

    void clickCancelButton() {
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Main_NoDialog.class);
                startActivity(intent);
            }
        });
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            overridePendingTransition(0, 0);
            Toast.makeText(getApplicationContext(),"인증 완료",Toast.LENGTH_LONG).show();
            //finish();
            Intent intent = new Intent(getApplicationContext(), Main_NoDialog.class);
            startActivity(intent);
        }
    };
}
