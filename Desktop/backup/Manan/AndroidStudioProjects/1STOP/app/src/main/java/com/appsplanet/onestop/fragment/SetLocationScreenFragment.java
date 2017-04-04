package com.appsplanet.onestop.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;

import com.appsplanet.onestop.DrawerMainScreenActivity;
import com.appsplanet.onestop.a1stop.R;

public class SetLocationScreenFragment extends Fragment implements View.OnClickListener{

    private Switch mswitchSetLocation, mswitchMyLocation;
    private RadioButton mrdb10kmorless, mrdbShortDistance, mrdbLongDistance, mrdbAlloftheabove;
    private Button mbtnSubmit;
    private RadioGroup mrdgrpSelectDistance;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_set_location_screen_tab, container, false);

        mswitchSetLocation = (Switch) view.findViewById(R.id.switch_setLocation);
        mswitchMyLocation = (Switch) view.findViewById(R.id.switch_myLocation);
        mrdgrpSelectDistance = (RadioGroup) view.findViewById(R.id.rdg_selectDistance);
        mrdb10kmorless = (RadioButton) view.findViewById(R.id.rdb_10kmorless);
        mrdbShortDistance = (RadioButton) view.findViewById(R.id.rdb_shortDistance);
        mrdbLongDistance = (RadioButton) view.findViewById(R.id.rdb_longDistance);
        mrdbAlloftheabove = (RadioButton) view.findViewById(R.id.rdb_alloftheabove);
        mbtnSubmit = (Button) view.findViewById(R.id.btn_submitSetLocation);

        mswitchMyLocation.setOnClickListener(this);
        mswitchSetLocation.setOnClickListener(this);
        mbtnSubmit.setOnClickListener(this);

        ((DrawerMainScreenActivity) getActivity()).setMtxtTabTitle("SET LOCATION");

        return view;
    }


    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.switch_myLocation){
            if(mswitchSetLocation.isChecked() && mswitchMyLocation.isChecked()){
                mrdgrpSelectDistance.setVisibility(View.VISIBLE);
                mbtnSubmit.setVisibility(View.VISIBLE);
            }
            else {
                mrdgrpSelectDistance.setVisibility(View.INVISIBLE);
                mbtnSubmit.setVisibility(View.INVISIBLE);
            }
        }
        else if(view.getId() == R.id.switch_setLocation){
            if(mswitchSetLocation.isChecked() && mswitchMyLocation.isChecked()){
                mrdgrpSelectDistance.setVisibility(View.VISIBLE);
                mbtnSubmit.setVisibility(View.VISIBLE);
            }
            else {
                mrdgrpSelectDistance.setVisibility(View.INVISIBLE);
                mbtnSubmit.setVisibility(View.INVISIBLE);
            }
        }
        else if(view.getId() == R.id.btn_submitSetLocation){
            getActivity().onBackPressed();
        }
    }
}

