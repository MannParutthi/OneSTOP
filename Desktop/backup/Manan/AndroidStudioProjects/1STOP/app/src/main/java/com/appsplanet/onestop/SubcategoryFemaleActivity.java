package com.appsplanet.onestop;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.appsplanet.onestop.a1stop.R;

public class SubcategoryFemaleActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mbtnSubmit, mbtnCreateGroup;
    private ImageButton mimgbtnGoBack;
    private TextView mtxtCreateGroup, txtPaytoCreateNewGroup;
    private EditText medtxtGroupName;
    private CheckBox mchkboxRelationship, mchkboxNoStringsAttached, mchkboxBusinessProfessionals, mchkboxWorkoutBuddy,
            mchkboxSugarDadddy, mchkboxSugarMommy, mchkboxMoreShemaleEtc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subcategory_female);

        mchkboxRelationship = (CheckBox) findViewById(R.id.chkbox_relationship);
        mchkboxNoStringsAttached = (CheckBox) findViewById(R.id.chkbox_noStringsAttached);
        mchkboxBusinessProfessionals = (CheckBox) findViewById(R.id.chkbox_businessProfessionals);
        mchkboxWorkoutBuddy = (CheckBox) findViewById(R.id.chkbox_workoutBuddy);
        mchkboxSugarDadddy = (CheckBox) findViewById(R.id.chkbox_sugarDaddy);
        mchkboxSugarMommy = (CheckBox) findViewById(R.id.chkbox_sugarMommy);
        mchkboxMoreShemaleEtc = (CheckBox) findViewById(R.id.chkbox_MoreShemaleEtc);
        medtxtGroupName = (EditText) findViewById(R.id.edtxt_enterGroupName);
        mtxtCreateGroup = (TextView) findViewById(R.id.txt_createANewGroup);
        mbtnCreateGroup = (Button) findViewById(R.id.btn_createGroup);
        mbtnSubmit = (Button) findViewById(R.id.btn_SUBMIT);
        mimgbtnGoBack = (ImageButton) findViewById(R.id.imgBtn_goBack);
        txtPaytoCreateNewGroup = (TextView) findViewById(R.id.txt_payToCreateNewGroup);

        mtxtCreateGroup.setOnClickListener(this);
        mbtnCreateGroup.setOnClickListener(this);
        mbtnSubmit.setOnClickListener(this);
        mimgbtnGoBack.setOnClickListener(this);

        String groupName = medtxtGroupName.getText().toString();

        mchkboxBusinessProfessionals.setOnClickListener(this);
        mchkboxWorkoutBuddy.setOnClickListener(this);
        mchkboxSugarDadddy.setOnClickListener(this);
        mchkboxSugarMommy.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.txt_createANewGroup){
            medtxtGroupName.setVisibility(View.VISIBLE);
            mbtnCreateGroup.setVisibility(View.VISIBLE);

        }
        else if(view.getId() == R.id.btn_createGroup){
            final Dialog customDialog = new Dialog(SubcategoryFemaleActivity.this);
            customDialog.setContentView(R.layout.custom_dialog);
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
                    recreate();
                }
            });

        }

        else if(view.getId() == R.id.chkbox_businessProfessionals){
            if(mchkboxBusinessProfessionals.isChecked()){
                Intent intent = new Intent(SubcategoryFemaleActivity.this, SubcategoryBusinessProfessionalActivity.class);
                startActivity(intent);
            }
        }
        else if(view.getId() == R.id.chkbox_workoutBuddy){
            if(mchkboxWorkoutBuddy.isChecked()){
                Intent intent = new Intent(SubcategoryFemaleActivity.this, SubcategoryWorkoutBuddyActivity.class);
                startActivity(intent);
            }
        }
        else if(view.getId() == R.id.chkbox_sugarDaddy) {
            if(mchkboxSugarDadddy.isChecked()){
                Intent intent = new Intent(SubcategoryFemaleActivity.this, SubcategorySugarDaddymommyActivity.class);
                startActivity(intent);
            }
        }
        else if(view.getId() == R.id.chkbox_sugarMommy) {
            if(mchkboxSugarMommy.isChecked()){
                Intent intent = new Intent(SubcategoryFemaleActivity.this, SubcategorySugarDaddymommyActivity.class);
                startActivity(intent);
            }
        }


        else if(view.getId() == R.id.btn_SUBMIT){
            onBackPressed();
        }
        else if(view.getId() == R.id.imgBtn_goBack){
            onBackPressed();
        }
    }
}
