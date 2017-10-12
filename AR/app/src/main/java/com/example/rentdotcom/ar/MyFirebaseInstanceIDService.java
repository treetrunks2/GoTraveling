package com.example.rentdotcom.ar;



/**
 * Created by Administrator on 2017-10-10.
 */

/*이 클래스는 Push 알림을 쏠 때 필요한 토큰 정보를 생성하고, 서버에 저장시키는 역할을 합니다.

빨간 네모 처진 onTokenRefresh()함수가 토큰을 생성하고, sendRegistrationToServer ()함수를 통해서 서버에 전달을 합니다.

        일반적으로 서버에서 ID와 Token 정보를 DB에 저장해서 사용하니, sendRegistrationToServer 내부에 그 소스를 넣으면 되겠죠.

*/
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;


public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {

    private static final String TAG = "MyFirebaseIIDService";

    @Override
    public void onTokenRefresh() {

        // Get updated InstanceID token.

        String token = FirebaseInstanceId.getInstance().getToken();


        /*String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token: " + refreshedToken);

        sendRegistrationToServer(refreshedToken);*/
    }

   /* private void sendRegistrationToServer(String token) {
        Log.d(TAG, "send Server");
    }*/
}
