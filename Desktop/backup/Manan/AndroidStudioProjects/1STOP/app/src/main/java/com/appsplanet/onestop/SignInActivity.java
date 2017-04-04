package com.appsplanet.onestop;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.applozic.mobicomkit.Applozic;
import com.applozic.mobicomkit.api.account.register.RegistrationResponse;
import com.applozic.mobicomkit.api.account.user.MobiComUserPreference;
import com.applozic.mobicomkit.api.account.user.PushNotificationTask;
import com.applozic.mobicomkit.api.account.user.User;
import com.applozic.mobicomkit.api.account.user.UserLoginTask;
import com.appsplanet.onestop.a1stop.R;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView mtxtForgotPassword, mtxtRegisterNow;
    private Button mbtnsignIn;
    private ImageButton mimgbtnFacebooklogin, mimgbtnGooglePluslogin, mimgbtnLinkedinlogin;
    private EditText medtxtUserId, medtxtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        mbtnsignIn = (Button) findViewById(R.id.btn_SignIn);
        mimgbtnFacebooklogin = (ImageButton) findViewById(R.id.imgBtn_facebook);
        mimgbtnGooglePluslogin = (ImageButton) findViewById(R.id.imgBtn_googlePlus);
        mimgbtnLinkedinlogin = (ImageButton) findViewById(R.id.imgBtn_linkedIn);
        mtxtForgotPassword = (TextView) findViewById(R.id.txt_forgotPassword);
        mtxtRegisterNow = (TextView) findViewById(R.id.txt_registerNow);

        medtxtUserId = (EditText) findViewById(R.id.edtxt_username);
        medtxtPassword = (EditText) findViewById(R.id.edtxt_password);


        mbtnsignIn.setOnClickListener(this);
        mtxtForgotPassword.setOnClickListener(this);
        mtxtRegisterNow.setOnClickListener(this);
        mimgbtnFacebooklogin.setOnClickListener(this);
        mimgbtnGooglePluslogin.setOnClickListener(this);
        mimgbtnLinkedinlogin.setOnClickListener(this);

        chat();
    }

    private void chat() {
        String userId = medtxtUserId.getText().toString();
        UserLoginTask.TaskListener listener = new UserLoginTask.TaskListener() {

            @Override
            public void onSuccess(RegistrationResponse registrationResponse, Context context) {
                //After successful registration with Applozic server the callback will come here
                if(MobiComUserPreference.getInstance(context).isRegistered()) {

                    PushNotificationTask pushNotificationTask = null;
                    PushNotificationTask.TaskListener listener = new PushNotificationTask.TaskListener() {
                        @Override
                        public void onSuccess(RegistrationResponse registrationResponse) {

                        }
                        @Override
                        public void onFailure(RegistrationResponse registrationResponse, Exception exception) {

                        }

                    };

                    pushNotificationTask = new PushNotificationTask(Applozic.getInstance(context).getDeviceRegistrationId(),listener,context);
                    pushNotificationTask.execute((Void) null);
                }
            }

            @Override
            public void onFailure(RegistrationResponse registrationResponse, Exception exception) {
                //If any failure in registration the callback  will come here
            }
        };

        User user = new User();
        user.setUserId(userId); //userId it can be any unique user identifier
        user.setDisplayName(userId); //displayName is the name of the user which will be shown in chat messages
        //user.setEmail(email); //optional
        user.setAuthenticationTypeId(User.AuthenticationType.APPLOZIC.getValue());  //User.AuthenticationType.APPLOZIC.getValue() for password verification from Applozic server and User.AuthenticationType.CLIENT.getValue() for access Token verification from your server set access token as password
        user.setPassword(""); //optional, leave it blank for testing purpose, read this if you want to add additional security by verifying password from your server https://www.applozic.com/docs/configuration.html#access-token-url
        user.setImageLink("");//optional,pass your image link

        new UserLoginTask(user, listener, this).execute((Void) null);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.txt_forgotPassword){
            Intent intent = new Intent(SignInActivity.this, ForgotPasswordActivity.class);
            startActivity(intent);
        }
        else if(view.getId() == R.id.txt_registerNow){
            Intent intent = new Intent(SignInActivity.this, RegisterActivity.class);
            finish();
            startActivity(intent);
        }
        else  if(view.getId() == R.id.imgBtn_facebook){

        }
        else  if(view.getId() == R.id.imgBtn_googlePlus){

        }
        else  if(view.getId() == R.id.imgBtn_linkedIn){

        }
        else  if(view.getId() == R.id.btn_SignIn){
            Intent intent = new Intent(SignInActivity.this, DrawerMainScreenActivity.class);
            finish();
            startActivity(intent);
        }
    }
}
