package com.appsplanet.onestop;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;

import com.appsplanet.onestop.a1stop.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class SubcategoryDivorcedActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mbuttonSubmit;
    private ImageButton mimgbtnBack;
    private TextView mtxtDivorcedSinceWhen;
    String DivorceDate;
    Calendar myCalendar;
    DatePickerDialog.OnDateSetListener date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subcategory_divorced);

        mbuttonSubmit = (Button) findViewById(R.id.btn_submitDivorced);
        mimgbtnBack = (ImageButton) findViewById(R.id.imgBtn_goBack);
        mtxtDivorcedSinceWhen = (TextView) findViewById(R.id.edtxt_divorcedSinceWhen);

        DivorceDate = mtxtDivorcedSinceWhen.getText().toString();

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

                mtxtDivorcedSinceWhen.setText(sdf.format(myCalendar.getTime()));
            }

        };

        mimgbtnBack.setOnClickListener(this);
        mbuttonSubmit.setOnClickListener(this);
        mtxtDivorcedSinceWhen.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.imgBtn_goBack){
            onBackPressed();
        }
        else if(view.getId() == R.id.edtxt_divorcedSinceWhen){
            new DatePickerDialog(SubcategoryDivorcedActivity.this, date, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                    myCalendar.get(Calendar.DAY_OF_MONTH)).show();
        }
        else if(view.getId() == R.id.btn_submitDivorced){
            onBackPressed();
            //save data to database





        }
    }
}
