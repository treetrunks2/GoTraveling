package gotravel.gotravaling;

import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.os.Bundle;

/**
 * Created by sookmyung on 2017-10-01.
 */

public class Join extends AppCompatActivity {

    EditText et_id, et_pw, et_pw_chk;
    String sId, sPw, sPw_chk;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join);

        et_id = (EditText) findViewById(R.id.idInput);
        et_pw = (EditText) findViewById(R.id.passwordInput);
        et_pw_chk = (EditText) findViewById(R.id.passwordConfirm);

        sId = et_id.getText().toString();
        sPw = et_pw.getText().toString();
        sPw_chk = et_pw_chk.getText().toString();

    }
}
