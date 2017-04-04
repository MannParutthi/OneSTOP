package com.appsplanet.onestop;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.appsplanet.onestop.a1stop.R;

public class TermsAndConditionsActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mbtnAgree, mbtnDisagree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_and_conditions);

        mbtnAgree = (Button) findViewById(R.id.btn_Agree);
        mbtnDisagree = (Button) findViewById(R.id.btn_Disagree);

        mbtnAgree.setOnClickListener(this);
        mbtnDisagree.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_Agree){
            Intent intentA = new Intent(TermsAndConditionsActivity.this, SignInActivity.class);
            finish();
            startActivity(intentA);
        }
        else if(view.getId() == R.id.btn_Disagree){
            showAlertDialog();
        }
    }

    private void showAlertDialog() {
        final AlertDialog.Builder alertdialog = new AlertDialog.Builder(TermsAndConditionsActivity.this);
        alertdialog.setTitle("The 1 stop Application will be closed");

        alertdialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        alertdialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        alertdialog.show();
    }
}
