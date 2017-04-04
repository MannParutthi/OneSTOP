package com.appsplanet.onestop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.appsplanet.onestop.a1stop.R;

import java.util.ArrayList;
import java.util.List;

public class SubcategorySingleparentActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton mimgbtnBack;
    private Button mbuttonSubmit;
    private Spinner mspinnerNoOfKids, mspinnerAgeofKid;
    String NoofKids;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subcategory_singleparent);

        mimgbtnBack = (ImageButton) findViewById(R.id.imgBtn_goBack);
        mbuttonSubmit = (Button) findViewById(R.id.btn_submitSingleParent);
        mspinnerNoOfKids = (Spinner) findViewById(R.id.spinner_NoOfKids);
        mspinnerAgeofKid = (Spinner) findViewById(R.id.spinner_AgeOfKid);

        List<String> noofkids = new ArrayList<String>();
        noofkids.add("(Please select)");
        noofkids.add("1");
        noofkids.add("2");
        noofkids.add("3");
        noofkids.add("4");
        noofkids.add("5");
        ArrayAdapter<String> dataAdapt= new ArrayAdapter<String>(getBaseContext(), R.layout.spinner_custom, noofkids);
        dataAdapt.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        mspinnerNoOfKids.setAdapter(dataAdapt);

        List<String> ageofkids = new ArrayList<String>();
        ageofkids.add("(Please select)");
        ageofkids.add("1");
        ageofkids.add("2");
        ageofkids.add("3");
        ageofkids.add("4");
        ageofkids.add("5");
        ArrayAdapter<String> dataAdapter= new ArrayAdapter<String>(getBaseContext(), R.layout.spinner_custom, ageofkids);
        dataAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        mspinnerAgeofKid.setAdapter(dataAdapter);

        NoofKids = mspinnerNoOfKids.getSelectedItem().toString();

        if(NoofKids.equalsIgnoreCase("2")){

        }

        mimgbtnBack.setOnClickListener(this);
        mbuttonSubmit.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.imgBtn_goBack){
            onBackPressed();
        }
        else if(view.getId() == R.id.btn_submitSingleParent){
            onBackPressed();
            //save data to database





        }
    }
}
