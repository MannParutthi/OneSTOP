package com.appsplanet.onestop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.appsplanet.onestop.a1stop.R;

public class SubcategoryBusinessProfessionalActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton mimgbtnBack;
    private EditText medtxtSpeciality, medtxtCareer, medtxtOccupation, medtxtSkills, medtxtEducation;
    private Button mbtnSubmit;
    String Speciality, Career, Occupation, Skills, Education;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subcategory_business_professional);

        mimgbtnBack = (ImageButton) findViewById(R.id.imgBtn_goBack);
        mbtnSubmit = (Button) findViewById(R.id.btn_SubmitBusinessProfessionals);
        medtxtSpeciality = (EditText) findViewById(R.id.edtxt_Speciality);
        medtxtCareer = (EditText) findViewById(R.id.edtxt_Career);
        medtxtOccupation = (EditText) findViewById(R.id.edtxt_Occupation);
        medtxtSkills = (EditText) findViewById(R.id.edtxt_Skills);
        medtxtEducation = (EditText) findViewById(R.id.edtxt_Education);

        Speciality = medtxtSpeciality.getText().toString();
        Career = medtxtCareer.getText().toString();
        Occupation = medtxtOccupation.getText().toString();
        Skills = medtxtSkills.getText().toString();
        Education = medtxtEducation.getText().toString();

        mimgbtnBack.setOnClickListener(this);
        mbtnSubmit.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.imgBtn_goBack) {
         onBackPressed();
        }

        else if(view.getId() == R.id.btn_SubmitBusinessProfessionals) {
            onBackPressed();
            //add data to database


            

        }

    }
}
