package com.appsplanet.onestop;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.appsplanet.onestop.a1stop.R;

import java.util.ArrayList;
import java.util.List;

public class SubcategoryWorkoutBuddyActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton mimgbtnBack;
    private Button mbtnSubmit;
    private EditText medtxtHowManyTimesaWeek, medtxtVacinity;
    private Spinner mspinnerOpenToOtherGyms, mspinnerWorkoutLive;
    private TextView mtxtSelectedOpenToOtherGyms, mtxtSelectedWorkoutLive;
    String workoutWeeks,vacinity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subcategory_workout_buddy);

        mimgbtnBack = (ImageButton) findViewById(R.id.imgBtn_goBack);
        mbtnSubmit = (Button) findViewById(R.id.btn_SubmitWorkoutBuddy);
        medtxtHowManyTimesaWeek = (EditText) findViewById(R.id.edtxt_howManyTimesaWeek);
        medtxtVacinity = (EditText) findViewById(R.id.edtxt_vacinity);
        mtxtSelectedOpenToOtherGyms = (TextView) findViewById(R.id.txt_selectedOpenToOtherGyms);
        mtxtSelectedWorkoutLive = (TextView) findViewById(R.id.txt_selectedWorkoutLive);
        mspinnerOpenToOtherGyms = (Spinner) findViewById(R.id.spinner_openToOtherGyms);
        mspinnerWorkoutLive = (Spinner) findViewById(R.id.spinner_workoutLive);


        List<String> openToOtherGyms = new ArrayList<String>();
        openToOtherGyms.add("(Please select)");
        openToOtherGyms.add("Yes");
        openToOtherGyms.add("No");
        ArrayAdapter<String> dataAdapter= new ArrayAdapter<String>(getBaseContext(), R.layout.spinner_custom, openToOtherGyms);
        dataAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        mspinnerOpenToOtherGyms.setAdapter(dataAdapter);

        List<String> workoutLive = new ArrayList<String>();
        workoutLive.add("(Please select)");
        workoutLive.add("Yes");
        workoutLive.add("No");
        ArrayAdapter<String> dataAdapterW= new ArrayAdapter<String>(getBaseContext(), R.layout.spinner_custom, workoutLive);
        dataAdapterW.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        mspinnerWorkoutLive.setAdapter(dataAdapterW);


        workoutWeeks = medtxtHowManyTimesaWeek.getText().toString();
        vacinity = medtxtVacinity.getText().toString();

        mimgbtnBack.setOnClickListener(this);
        mbtnSubmit.setOnClickListener(this);

        mtxtSelectedOpenToOtherGyms.setOnClickListener(this);
        mtxtSelectedWorkoutLive.setOnClickListener(this);

    }

    public void openPopup(){
        final Dialog customDialog = new Dialog(SubcategoryWorkoutBuddyActivity.this);
        customDialog.setContentView(R.layout.custom_dialog_videocall);
        customDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        customDialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        customDialog.show();

        ImageButton imageButtonClose;
        Button buttonCancel, buttonPaynow;

        imageButtonClose = (ImageButton)customDialog.findViewById(R.id.imgbtn_close);
        buttonCancel = (Button) customDialog.findViewById(R.id.btn_Cancel);
        buttonPaynow = (Button) customDialog.findViewById(R.id.btn_PayNow);

        imageButtonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customDialog.dismiss();
            }
        });
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customDialog.dismiss();
            }
        });
        buttonPaynow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customDialog.dismiss();
                onBackPressed();
            }
        });

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.imgBtn_goBack) {
            onBackPressed();
        }
        else if(view.getId() == R.id.txt_selectedOpenToOtherGyms){
            if(mspinnerOpenToOtherGyms.getSelectedItem().toString().equalsIgnoreCase("Yes")){
                openPopup();
            }
        }
        else if(view.getId() == R.id.txt_selectedWorkoutLive){
            if(mspinnerWorkoutLive.getSelectedItem().toString().equalsIgnoreCase("Yes")){
                openPopup();
            }
        }
        else if(view.getId() == R.id.btn_SubmitWorkoutBuddy) {
            onBackPressed();
            //add data to database




        }
    }
}
