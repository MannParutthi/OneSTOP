package com.appsplanet.onestop.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.appsplanet.onestop.DrawerMainScreenActivity;
import com.appsplanet.onestop.a1stop.R;

public class ThankyouscreenFromcontactusFragment extends Fragment implements View.OnClickListener{

    private Button mbtnHome;
    private TextView mtxtThankyouMsg;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_thankyouscreen_fromcontactus_tab, container, false);

        mbtnHome = (Button) view.findViewById(R.id.btn_home);
        mtxtThankyouMsg = (TextView) view.findViewById(R.id.txt_thankyouMsg);

        if(getArguments().getString("data1") != null){
            mtxtThankyouMsg.setText(getArguments().getString("data1"));
        }

        mbtnHome.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_home){
            DashboardFragment dashboardFragment = new DashboardFragment();
            //go toHome
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            fragmentTransaction.replace(R.id.content_frame, dashboardFragment).commit();

            ((DrawerMainScreenActivity) getActivity()).setMtxtTabTitle("LETS CONNECT");
        }
    }
}

