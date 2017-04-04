package com.appsplanet.onestop;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.appsplanet.onestop.a1stop.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText medtxtFirstName, medtxtLastName, medtxtUsername, medtxtPassword, medtxtConfirmPassword, medtxtEmailId, medtxtPhoneNo,
            medtxtCity, medtxtCountry, medtxtAddress, medtxtPostalZipCode ,medtxtHowDidUHearAboutUS;
    private ImageButton mimgBtnGoBack, mimgBtnCalender;
    private Spinner mspinnerGender, mspinnerAmbassador;
    private Button mbtnSubmit;
    private TextView mtxtSelectedGender, mtxtSelectedAmbassador , medtxtDOB;
    String FirstName, LastName, UserName, Password, ConfirmPassword, EmailId, PhoneNumber, City, Country, Address,
            PostalZipCode, DOB, HowDidUHearAboutUS, Gender, Ambassador;
    Calendar myCalendar;
    DatePickerDialog.OnDateSetListener date;

    LinearLayout linearLayoutCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        medtxtFirstName = (EditText) findViewById(R.id.edtxt_firstName);
        medtxtLastName = (EditText) findViewById(R.id.edtxt_lastName);
        medtxtUsername = (EditText) findViewById(R.id.edtxt_userName);
        medtxtPassword = (EditText) findViewById(R.id.edtxt_password);
        medtxtConfirmPassword = (EditText) findViewById(R.id.edtxt_confirmPassword);
        medtxtEmailId = (EditText) findViewById(R.id.edtxt_emailId);
        medtxtPhoneNo = (EditText) findViewById(R.id.edtxt_phoneNumber);
        medtxtCity = (EditText) findViewById(R.id.edtxt_city);
        medtxtCountry = (EditText) findViewById(R.id.edtxt_Country);
        medtxtAddress = (EditText) findViewById(R.id.edtxt_address);
        medtxtPostalZipCode = (EditText) findViewById(R.id.edtxt_postalzipCode);
        medtxtDOB = (TextView) findViewById(R.id.edtxt_dob);
        medtxtHowDidUHearAboutUS = (EditText) findViewById(R.id.edtxt_howDidUHearAboutUs);
        mtxtSelectedGender =(TextView) findViewById(R.id.txt_selectedGender);
        mtxtSelectedAmbassador = (TextView) findViewById(R.id.txt_selectedAmbassador);

        mimgBtnGoBack = (ImageButton) findViewById(R.id.imgBtn_goBack);
        mimgBtnCalender = (ImageButton) findViewById(R.id.imgBtn_calender);

        mspinnerGender = (Spinner) findViewById(R.id.spinner_gender);
        mspinnerAmbassador= (Spinner) findViewById(R.id.spinner_ambassador);

        mbtnSubmit = (Button) findViewById(R.id.btn_SubmitRegisterNow);

        linearLayoutCalendar = (LinearLayout) findViewById(R.id.ll_calendar);

        FirstName = medtxtFirstName.getText().toString();
        LastName = medtxtLastName.getText().toString();
        UserName = medtxtUsername.getText().toString();
        Password = medtxtPassword.getText().toString();
        ConfirmPassword = medtxtConfirmPassword.getText().toString();
        EmailId = medtxtEmailId.getText().toString();
        PhoneNumber = medtxtPhoneNo.getText().toString();
        City = medtxtCity.getText().toString();
        Country = medtxtCountry.getText().toString();
        Address = medtxtAddress.getText().toString();
        PostalZipCode = medtxtPostalZipCode.getText().toString();

        HowDidUHearAboutUS = medtxtHowDidUHearAboutUS.getText().toString();

        List<String> gender = new ArrayList<String>();
        gender.add("(Please select)");
        gender.add("Male");
        gender.add("Female");
        ArrayAdapter<String> dataAdapt= new ArrayAdapter<String>(getBaseContext(), R.layout.spinner_custom, gender);
        dataAdapt.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        mspinnerGender.setAdapter(dataAdapt);
        mspinnerGender.setPrompt("<font color='#FFFFFF'>Gender </font> <font color ='#D3D3D3'>(Please Select)</font>");

        List<String> ambassador = new ArrayList<String>();
        ambassador.add("(Please select)");
        ambassador.add("Name 1");
        ambassador.add("Name 2");
        ambassador.add("Name 3");
        ArrayAdapter<String> dataAdapterA= new ArrayAdapter<String>(getBaseContext(), R.layout.spinner_custom, ambassador);
        dataAdapterA.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        mspinnerAmbassador.setAdapter(dataAdapterA);


        myCalendar = Calendar.getInstance();

        date = new DatePickerDialog.OnDateSetListener()
        {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)
            {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

            private void updateLabel()
            {
                String myFormat = "dd/MM/yyyy";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                medtxtDOB.setText(sdf.format(myCalendar.getTime()));
            }

        };


        mimgBtnGoBack.setOnClickListener(this);
        mimgBtnCalender.setOnClickListener(this);
        mbtnSubmit.setOnClickListener(this);

        linearLayoutCalendar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_SubmitRegisterNow){
            //add the data to database




            //after verifying the email address and loging in for the first time
            Intent intent = new Intent(RegisterActivity.this, RegistrationScreenOneActivity.class);
            finish();
            startActivity(intent);
        }
        else if(view.getId() == R.id.imgBtn_calender){
            new DatePickerDialog(RegisterActivity.this, date, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                    myCalendar.get(Calendar.DAY_OF_MONTH)).show();
        }
        else if(view.getId() == R.id.ll_calendar){
            new DatePickerDialog(RegisterActivity.this, date, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                    myCalendar.get(Calendar.DAY_OF_MONTH)).show();
        }
        else if(view.getId() == R.id.imgBtn_goBack){
            onBackPressed();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(RegisterActivity.this, SignInActivity.class);
        startActivity(intent);
    }
}
