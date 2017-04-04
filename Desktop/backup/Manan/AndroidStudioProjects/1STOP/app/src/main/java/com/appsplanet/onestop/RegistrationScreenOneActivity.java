package com.appsplanet.onestop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.appsplanet.onestop.a1stop.R;

import java.util.ArrayList;
import java.util.List;

public class RegistrationScreenOneActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton mimgBtnGoBack;
    private EditText medtxtEducation, medtxtOccupation, medtxtNetWorth, medtxtAnnualIncome, medtxtHeight, medtxtEthinicity;
    private Spinner mspinnerLanguage;
    private Button mbtnNext;
    private TextView mtxtSelectedLanguage;
    String Education, Occupation, NetWorth, AnnualIncome, Height, Ethinicity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_screen_one);

        medtxtEducation = (EditText) findViewById(R.id.edtxt_education);
        medtxtOccupation = (EditText) findViewById(R.id.edtxt_occupation);
        medtxtNetWorth = (EditText) findViewById(R.id.edtxt_netWorth);
        medtxtAnnualIncome = (EditText) findViewById(R.id.edtxt_annualIncome);
        medtxtHeight = (EditText) findViewById(R.id.edtxt_height);
        medtxtEthinicity = (EditText) findViewById(R.id.edtxt_ethinicity);
        mtxtSelectedLanguage = (TextView) findViewById(R.id.txt_selectedLanguage);

        mimgBtnGoBack = (ImageButton) findViewById(R.id.imgBtn_goBack);

        mspinnerLanguage = (Spinner) findViewById(R.id.spinner_language);

        mbtnNext = (Button) findViewById(R.id.btn_NEXT);

        Education = medtxtEducation.getText().toString();
        Occupation = medtxtOccupation.getText().toString();
        NetWorth = medtxtNetWorth.getText().toString();
        AnnualIncome = medtxtAnnualIncome.getText().toString();
        Height = medtxtHeight.getText().toString();
        Ethinicity = medtxtEthinicity.getText().toString();

        List<String> language = new ArrayList<String>();
        language.add("(Please select)");
        language.add("English");
        language.add("French");
        ArrayAdapter<String> dataAdapt= new ArrayAdapter<String>(getBaseContext(), R.layout.spinner_custom, language);
        dataAdapt.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        mspinnerLanguage.setAdapter(dataAdapt);

        mimgBtnGoBack.setOnClickListener(this);
        mbtnNext.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_NEXT){
            //add the data to database





            //redirect to registration screen 2
            Intent intent = new Intent(RegistrationScreenOneActivity.this, RegistrationScreenTwoActivity.class);
            finish();
            startActivity(intent);
        }

        else if(view.getId() == R.id.imgBtn_goBack){
            onBackPressed();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(RegistrationScreenOneActivity.this, SignInActivity.class);
        startActivity(intent);
    }
}
