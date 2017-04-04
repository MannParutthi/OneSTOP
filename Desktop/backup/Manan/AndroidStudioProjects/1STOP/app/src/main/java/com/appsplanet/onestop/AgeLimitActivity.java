package com.appsplanet.onestop;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.appsplanet.onestop.a1stop.R;

public class AgeLimitActivity extends AppCompatActivity implements View.OnClickListener {

    private RadioGroup mRdgAgeLimit;
    private RadioButton mrdbYes, mrdbNo;
    private Button mBtnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age_limit);

        mRdgAgeLimit = (RadioGroup) findViewById(R.id.rdg_selectDistance);
        mrdbYes = (RadioButton) findViewById(R.id.rdb_yes);
        mrdbNo = (RadioButton) findViewById(R.id.rdb_no);
        mBtnNext = (Button) findViewById(R.id.btn_next);

        mBtnNext.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if (mrdbYes.isChecked()) {//check box for yes
            Intent intent1 = new Intent(AgeLimitActivity.this, TermsAndConditionsActivity.class);
            finish();
            startActivity(intent1);
        } else if (mrdbNo.isChecked()) {//check box for no
            showAlertDailog();
        }
    }

    private void showAlertDailog() {

        final AlertDialog.Builder alertdialog = new AlertDialog.Builder(AgeLimitActivity.this);
        alertdialog.setTitle("This application is only for 18+ people");

        alertdialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        alertdialog.show();
    }
}
