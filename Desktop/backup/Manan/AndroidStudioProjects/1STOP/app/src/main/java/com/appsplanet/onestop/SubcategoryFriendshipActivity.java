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

public class SubcategoryFriendshipActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mbtnSubmit, mbtnCreateGroup;
    private ImageButton mimgbtnGoBack;
    private TextView mtxtCreateGroup;
    private EditText medtxtGroupName;
    private CheckBox mchkboxBusinessProfessionals, mchkboxWorkoutBuddy, mchkboxNopreference ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subcategory_friendship);

        mchkboxBusinessProfessionals = (CheckBox) findViewById(R.id.chkbox_businessProfessionals);
        mchkboxWorkoutBuddy = (CheckBox) findViewById(R.id.chkbox_workoutBuddy);
        mchkboxNopreference = (CheckBox) findViewById(R.id.chkbox_noPreference);
        medtxtGroupName = (EditText) findViewById(R.id.edtxt_enterGroupName);
        mtxtCreateGroup = (TextView) findViewById(R.id.txt_createANewGroup);
        mbtnCreateGroup = (Button) findViewById(R.id.btn_createGroup);
        mbtnSubmit = (Button) findViewById(R.id.btn_SUBMIT);
        mimgbtnGoBack = (ImageButton) findViewById(R.id.imgBtn_goBack);

        mtxtCreateGroup.setOnClickListener(this);
        mbtnCreateGroup.setOnClickListener(this);
        mbtnSubmit.setOnClickListener(this);
        mimgbtnGoBack.setOnClickListener(this);

        String groupName = medtxtGroupName.getText().toString();

        mchkboxBusinessProfessionals.setOnClickListener(this);
        mchkboxWorkoutBuddy.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.txt_createANewGroup){
            medtxtGroupName.setVisibility(View.VISIBLE);
            mbtnCreateGroup.setVisibility(View.VISIBLE);

        }
        else if(view.getId() == R.id.btn_createGroup){
            final Dialog customDialog = new Dialog(SubcategoryFriendshipActivity.this);
            customDialog.setContentView(R.layout.custom_dialog);
            customDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
            customDialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
            customDialog.show();

            ImageButton imageButtonClose;
            Button buttonCancel;
            imageButtonClose = (ImageButton)customDialog.findViewById(R.id.imgbtn_close);
            buttonCancel = (Button) customDialog.findViewById(R.id.btn_Cancel);
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

        }

        else if(view.getId() == R.id.chkbox_businessProfessionals){
            if(mchkboxBusinessProfessionals.isChecked()){
                Intent intent = new Intent(SubcategoryFriendshipActivity.this, SubcategoryBusinessProfessionalActivity.class);
                startActivity(intent);
            }
        }
        else if(view.getId() == R.id.chkbox_workoutBuddy){
            if(mchkboxWorkoutBuddy.isChecked()){
                Intent intent = new Intent(SubcategoryFriendshipActivity.this, SubcategoryWorkoutBuddyActivity.class);
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
