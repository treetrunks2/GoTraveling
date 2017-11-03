package gotravel.gotravaling;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by sookmyung on 2017-10-01.
 */

public class Join extends AppCompatActivity {

    Button  buttonCancel,button_assign;
    EditText inputPhoneNumber;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join);

        initializeVariable();
        clickCancelButton();

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
        inputPhoneNumber = (EditText) findViewById(R.id.PhoneNumber);
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

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            overridePendingTransition(0, 0);
            Toast.makeText(getApplicationContext(),"회원가입 완료",Toast.LENGTH_LONG).show();
            //finish();
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
        }
    };
}
