package com.appsplanet.onestop.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import com.appsplanet.onestop.DrawerMainScreenActivity;
import com.appsplanet.onestop.a1stop.R;

public class UnsubscribeScreen2Fragment extends Fragment implements View.OnClickListener{

    private RadioButton mrdbTakeabreak, mrdbFoundsomeone, mrdbFoundElsewhere;
    private CheckBox mchkboxAknowledgement;
    private Button mbtnSubmit;
    private TextView mtxtSendEmailtoAdmin;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_unsubscribe_screen2, container, false);

        mrdbTakeabreak = (RadioButton) view.findViewById(R.id.rdb_takeabreak);
        mrdbFoundsomeone = (RadioButton) view.findViewById(R.id.rdb_foundSomeone);
        mrdbFoundElsewhere = (RadioButton) view.findViewById(R.id.rdb_foundElsewhere);
        mchkboxAknowledgement = (CheckBox) view.findViewById(R.id.chkbox_aknowledgement);
        mbtnSubmit = (Button) view.findViewById(R.id.btn_submitunsubscribsion);
        mtxtSendEmailtoAdmin = (TextView) view.findViewById(R.id.txt_sendmailtoadmintounsubscribe);

        mbtnSubmit.setOnClickListener(this);
        mtxtSendEmailtoAdmin.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_submitunsubscribsion){
            DashboardFragment dashboardFragment = new DashboardFragment();
            //go toHome
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, dashboardFragment).addToBackStack(null).commit();

            ((DrawerMainScreenActivity) getActivity()).setMtxtTabTitle("LETS CONNECT");
        }
        else if(view.getId() == R.id.txt_sendmailtoadmintounsubscribe){
            ContactUsFragment contactUsTab = new ContactUsFragment();
            //go to ContactUsFragment
            Bundle data = new Bundle();
            data.putString("data","Thanks for your mail (Name of the user), Unsubscribing takes 3-5 business days.");
            contactUsTab.setArguments(data);
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, contactUsTab).addToBackStack(null).commit();
        }
    }
}
