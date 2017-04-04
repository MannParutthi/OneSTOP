package com.appsplanet.onestop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.appsplanet.onestop.a1stop.R;

public class ForgotPasswordActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText medtxtEmail;
    private Button mbtnSubmit;
    private TextView mtxtResendPswd;
    private String Email;
    private ImageButton mimgbtnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        medtxtEmail = (EditText) findViewById(R.id.edtxt_email);
        mbtnSubmit = (Button) findViewById(R.id.btn_submit);
        mtxtResendPswd = (TextView) findViewById(R.id.txt_resendPswd);
        mimgbtnBack = (ImageButton) findViewById(R.id.imgBtn_goBack);

        Email = medtxtEmail.getText().toString();

        mimgbtnBack.setOnClickListener(this);
        mbtnSubmit.setOnClickListener(this);
        mtxtResendPswd.setOnClickListener(this);
    }

    public void sendRandomPswdtoEmail(String email){





    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_submit){
            //sendRandomPswdtoEmail(Email);



        }
        else if(view.getId() == R.id.txt_resendPswd){
            sendRandomPswdtoEmail(Email);
        }
        else if(view.getId() == R.id.imgBtn_goBack){
            onBackPressed();
        }
    }
}
