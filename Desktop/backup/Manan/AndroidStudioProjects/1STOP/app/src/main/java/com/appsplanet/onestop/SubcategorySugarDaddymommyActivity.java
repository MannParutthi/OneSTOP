package com.appsplanet.onestop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import com.appsplanet.onestop.a1stop.R;

public class SubcategorySugarDaddymommyActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton mimgbtnBack;
    private Button mbtnSubmit;
    private CheckBox mchkboxPlatonic, mchkboxNoStringsAttached, mchkboxCompanionship, mchkboxChemistry, mchkboxArrangement,
            mchkboxShortTerm, mchkboxLongTerm, mchkboxExclusives, mchkboxLiveins;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subcategory_sugar_daddymommy);

        mimgbtnBack = (ImageButton) findViewById(R.id.imgBtn_goBack);
        mbtnSubmit = (Button) findViewById(R.id.btn_submitSugarDaddyMommy);
        mchkboxPlatonic = (CheckBox) findViewById(R.id.chkbox_Platonic);
        mchkboxNoStringsAttached = (CheckBox) findViewById(R.id.chkbox_NoStringsAttached);
        mchkboxCompanionship = (CheckBox) findViewById(R.id.chkbox_Companionship);
        mchkboxChemistry = (CheckBox) findViewById(R.id.chkbox_Chemistry);
        mchkboxArrangement = (CheckBox) findViewById(R.id.chkbox_Arrangement);
        mchkboxShortTerm = (CheckBox) findViewById(R.id.chkbox_ShortTerm);
        mchkboxLongTerm = (CheckBox) findViewById(R.id.chkbox_LongTerm);
        mchkboxExclusives = (CheckBox) findViewById(R.id.chkbox_Exclusives);
        mchkboxLiveins = (CheckBox) findViewById(R.id.chkbox_Liveins);

        mimgbtnBack.setOnClickListener(this);
        mbtnSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.imgBtn_goBack){
            onBackPressed();
        }
        else if(view.getId() == R.id.btn_submitSugarDaddyMommy){
            onBackPressed();
            //add data to database






        }

    }
}
