package com.example.rentdotcom.ar;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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
    Button button_assign;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join);

        et_id = (EditText) findViewById(R.id.idInput);
        et_pw = (EditText) findViewById(R.id.passwordInput);
        et_pw_chk = (EditText) findViewById(R.id.passwordConfirm);
        button_assign = (Button) findViewById(R.id.buttonAssign);
        button_assign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.sendEmptyMessageDelayed(0, 1000);
            }
        });
        sId = et_id.getText().toString();
        sPw = et_pw.getText().toString();
        sPw_chk = et_pw_chk.getText().toString();

    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            overridePendingTransition(0, 0);
            Toast.makeText(getApplicationContext(),"회원가입 완료",Toast.LENGTH_LONG).show();
            finish();
        }
    };
}
