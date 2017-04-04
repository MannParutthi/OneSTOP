package com.appsplanet.onestop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;

import com.appsplanet.onestop.a1stop.R;

public class SubcategoryLGBT2Activity extends AppCompatActivity implements View.OnClickListener{

    ImageButton mimgbtnBack;
    Button mbtnSubmit;
    RadioButton mrdbMale, mrdbFemale, mrdbTop, mrdbBottom, mrdbAlpha, mrdbDominant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subcategory_lgbt2);

        mimgbtnBack = (ImageButton) findViewById(R.id.imgBtn_goBack);
        mbtnSubmit = (Button) findViewById(R.id.btn_submitLGBT2);
        mrdbMale = (RadioButton) findViewById(R.id.rdb_MaleLGBT2);
        mrdbFemale = (RadioButton) findViewById(R.id.rdb_FemaleLGBT2);
        mrdbTop = (RadioButton) findViewById(R.id.rdb_top);
        mrdbBottom = (RadioButton) findViewById(R.id.rdb_bottom);
        mrdbAlpha = (RadioButton) findViewById(R.id.rdb_alpha);
        mrdbDominant = (RadioButton) findViewById(R.id.rdb_dominant);

        mimgbtnBack.setOnClickListener(this);
        mbtnSubmit.setOnClickListener(this);

        mrdbMale.setOnClickListener(this);
        mrdbFemale.setOnClickListener(this);
        mrdbTop.setOnClickListener(this);
        mrdbBottom.setOnClickListener(this);
        mrdbAlpha.setOnClickListener(this);
        mrdbDominant.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.imgBtn_goBack){
            onBackPressed();
        }

        else if(view.getId() == R.id.rdb_MaleLGBT2){
            Intent intent = new Intent(SubcategoryLGBT2Activity.this, SubcategoriesofLgbtActivity.class);
            startActivity(intent);
        }
        else if(view.getId() == R.id.rdb_FemaleLGBT2){
            Intent intent = new Intent(SubcategoryLGBT2Activity.this, SubcategoriesofLgbtActivity.class);
            startActivity(intent);
        }
        else if(view.getId() == R.id.rdb_top){
            Intent intent = new Intent(SubcategoryLGBT2Activity.this, SubcategoriesofLgbtActivity.class);
            startActivity(intent);
        }
        else if(view.getId() == R.id.rdb_bottom){
            Intent intent = new Intent(SubcategoryLGBT2Activity.this, SubcategoriesofLgbtActivity.class);
            startActivity(intent);
        }
        else if(view.getId() == R.id.rdb_alpha){
            Intent intent = new Intent(SubcategoryLGBT2Activity.this, SubcategoriesofLgbtActivity.class);
            startActivity(intent);
        }
        else if(view.getId() == R.id.rdb_dominant){
            Intent intent = new Intent(SubcategoryLGBT2Activity.this, SubcategoriesofLgbtActivity.class);
            startActivity(intent);
        }

        else if(view.getId() == R.id.btn_submitLGBT2){

            onBackPressed();

            //save data to database





        }

    }
}
