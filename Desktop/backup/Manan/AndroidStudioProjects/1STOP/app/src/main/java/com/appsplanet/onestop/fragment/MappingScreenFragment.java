package com.appsplanet.onestop.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.appsplanet.onestop.DrawerMainScreenActivity;
import com.appsplanet.onestop.a1stop.R;

public class MappingScreenFragment extends Fragment implements View.OnClickListener{


    private Switch mswitchMapping;
    private ImageButton mimgbtnMap;
    private TextView mtxtMappedCity, mtxtMappedCountry;
    private Button mbtnSubmit;
    private RelativeLayout mrelativeLayoutHide;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_mapping_screen_tab, container, false);

        ((DrawerMainScreenActivity) getActivity()).setMtxtTabTitle("MAPPING");

        mswitchMapping = (Switch) view.findViewById(R.id.switch_mapping);
        mimgbtnMap = (ImageButton) view.findViewById(R.id.imgbtn_mapping);
        mtxtMappedCity = (TextView) view.findViewById(R.id.txt_mappedCity);
        mtxtMappedCountry = (TextView) view.findViewById(R.id.txt_mappedCountry);
        mbtnSubmit = (Button) view.findViewById(R.id.btn_submitMapping);
        mrelativeLayoutHide = (RelativeLayout) view.findViewById(R.id.layouthide);

        mbtnSubmit.setOnClickListener(this);
        mswitchMapping.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_submitMapping){
            SetLocationScreenFragment setLocationScreenFragment = new SetLocationScreenFragment();
            //go to setLocationScreen
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, setLocationScreenFragment).addToBackStack(null).commit();
        }
        else if(view.getId() == R.id.switch_mapping){
            if(mswitchMapping.isChecked()){
                mrelativeLayoutHide.setVisibility(View.VISIBLE);
            }
            else {
                mrelativeLayoutHide.setVisibility(View.INVISIBLE);
            }
        }
    }
}








