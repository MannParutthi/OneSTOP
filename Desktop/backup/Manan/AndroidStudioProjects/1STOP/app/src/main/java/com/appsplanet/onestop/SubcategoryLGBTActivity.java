package com.appsplanet.onestop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;

import com.appsplanet.onestop.a1stop.R;

public class SubcategoryLGBTActivity extends AppCompatActivity implements View.OnClickListener{

    Button mbtnSubmit;
    ImageButton mimgbtnBack;
    RadioButton mrdbLesbian, mrdbGay, mrdbBisexual, mrdbTrona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subcategory_lgbt);

        mbtnSubmit = (Button) findViewById(R.id.btn_submitLGBT);
        mimgbtnBack = (ImageButton) findViewById(R.id.imgBtn_goBack);
        mrdbLesbian = (RadioButton) findViewById(R.id.rdb_lesbian);
        mrdbGay = (RadioButton) findViewById(R.id.rdb_gay);
        mrdbBisexual = (RadioButton) findViewById(R.id.rdb_bisexual);
        mrdbTrona = (RadioButton) findViewById(R.id.rdb_trona);

        mimgbtnBack.setOnClickListener(this);
        mbtnSubmit.setOnClickListener(this);

        mrdbLesbian.setOnClickListener(this);
        mrdbGay.setOnClickListener(this);
        mrdbBisexual.setOnClickListener(this);
        mrdbTrona.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.imgBtn_goBack){
            onBackPressed();
        }
        else if(view.getId() == R.id.rdb_lesbian ){
            if(mrdbLesbian.isChecked()){
                Intent intent = new Intent(SubcategoryLGBTActivity.this, SubcategoryLGBT2Activity.class);
                startActivity(intent);
            }
        }
        else if(view.getId() == R.id.rdb_gay){
            if(mrdbGay.isChecked()){
                Intent intent = new Intent(SubcategoryLGBTActivity.this, SubcategoryLGBT2Activity.class);
                startActivity(intent);
            }
        }
        else if(view.getId() == R.id.rdb_bisexual ){
            if(mrdbBisexual.isChecked()){
                Intent intent = new Intent(SubcategoryLGBTActivity.this, SubcategoryLGBT2Activity.class);
                startActivity(intent);
            }
        }
        else if(view.getId() == R.id.rdb_trona ){
            if(mrdbTrona.isChecked()){
                Intent intent = new Intent(SubcategoryLGBTActivity.this, SubcategoryLGBT2Activity.class);
                startActivity(intent);
            }
        }

        else if(view.getId() == R.id.btn_submitLGBT){

            Intent intent = new Intent(SubcategoryLGBTActivity.this, SubcategoryLGBT2Activity.class);
            startActivity(intent);

            //save data to database





        }

    }
}
