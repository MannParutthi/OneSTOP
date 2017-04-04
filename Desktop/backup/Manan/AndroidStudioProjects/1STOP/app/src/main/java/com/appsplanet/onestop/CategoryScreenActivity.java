package com.appsplanet.onestop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RadioGroup;

import com.appsplanet.onestop.a1stop.R;

public class CategoryScreenActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton mimgBtnGoBack;
    private Button mbtnGoToNext;
    private RadioGroup mrdgrpSelectSex;
    private CheckBox mchkboxMale, mchkboxFemale, mchkboxLGBT, mchkboxFriendship, mchkboxCompanionship, mchkboxDinner, mchkboxHangout,
            mchkboxSingleParent, mchkboxDivorced, mchkboxWidowed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_screen);

        mimgBtnGoBack = (ImageButton) findViewById(R.id.imgBtn_goBack);
        mbtnGoToNext = (Button) findViewById(R.id.btn_gotoNext);
        mchkboxMale = (CheckBox) findViewById(R.id.chkbox_male);
        mchkboxFemale = (CheckBox) findViewById(R.id.chkbox_female);
        mchkboxLGBT = (CheckBox) findViewById(R.id.chkbox_lgbt);
        mchkboxFriendship = (CheckBox) findViewById(R.id.chkbox_friendship);
        mchkboxCompanionship = (CheckBox) findViewById(R.id.chkbox_companionship);
        mchkboxDinner = (CheckBox) findViewById(R.id.chkbox_dinner);
        mchkboxHangout = (CheckBox) findViewById(R.id.chkbox_hangout);
        mchkboxSingleParent = (CheckBox) findViewById(R.id.chkbox_singleParent);
        mchkboxDivorced = (CheckBox) findViewById(R.id.chkbox_divorced);
        mchkboxWidowed = (CheckBox) findViewById(R.id.chkbox_widowed);

        mimgBtnGoBack.setOnClickListener(this);
        mbtnGoToNext.setOnClickListener(this);
        mchkboxMale.setOnClickListener(this);
        mchkboxFemale.setOnClickListener(this);
        mchkboxLGBT.setOnClickListener(this);
        mchkboxFriendship.setOnClickListener(this);
        mchkboxSingleParent.setOnClickListener(this);
        mchkboxDivorced.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.imgBtn_goBack){
            onBackPressed();
        }
        else if(view.getId() == R.id.chkbox_male){
            if(mchkboxMale.isChecked()){
                Intent intent = new Intent(CategoryScreenActivity.this, SubCategoryMaleActivity.class);
                startActivity(intent);
            }
        }
        else if(view.getId() == R.id.chkbox_female){
            if(mchkboxFemale.isChecked()) {
                Intent intent = new Intent(CategoryScreenActivity.this, SubcategoryFemaleActivity.class);
                startActivity(intent);
            }
        }
        else if(view.getId() == R.id.chkbox_lgbt){
            if(mchkboxLGBT.isChecked()){
                Intent intent = new Intent(CategoryScreenActivity.this, SubcategoryLGBTActivity.class);
                startActivity(intent);
            }
        }
        else if(view.getId() == R.id.chkbox_friendship){
            if(mchkboxFriendship.isChecked()){
                Intent intent = new Intent(CategoryScreenActivity.this, SubcategoryFriendshipActivity.class);
                startActivity(intent);
            }
        }
        else if(view.getId() == R.id.chkbox_singleParent){
            if(mchkboxSingleParent.isChecked()){
                Intent intent = new Intent(CategoryScreenActivity.this, SubcategorySingleparentActivity.class);
                startActivity(intent);
            }
        }
        else if(view.getId() == R.id.chkbox_divorced){
            if(mchkboxDivorced.isChecked()){
                Intent intent = new Intent(CategoryScreenActivity.this, SubcategoryDivorcedActivity.class);
                startActivity(intent);
            }
        }
        else if(view.getId() == R.id.btn_gotoNext)
        {
            Intent intent = new Intent(CategoryScreenActivity.this, DrawerMainScreenActivity.class);
            finish();
            startActivity(intent);


            // save the data to database






        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(CategoryScreenActivity.this, SignInActivity.class);
        startActivity(intent);
    }
}
