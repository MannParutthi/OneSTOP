package com.appsplanet.onestop.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.appsplanet.onestop.DrawerMainScreenActivity;
import com.appsplanet.onestop.a1stop.R;

public class UnsubscribeScreen1Fragment extends Fragment implements View.OnClickListener{

    private RadioButton mrdb1month, mrdb3months, mrdb6months;
    private Button mbtnNext;
    private TextView mtxtSendEmailtoAdmin;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_unsubscribe_screen1, container, false);

        ((DrawerMainScreenActivity) getActivity()).setMtxtTabTitle("UNSUBSCRIBE");

        mrdb1month = (RadioButton) view.findViewById(R.id.rdb_1month);
        mrdb3months = (RadioButton) view.findViewById(R.id.rdb_3months);
        mrdb6months = (RadioButton) view.findViewById(R.id.rdb_6months);
        mbtnNext = (Button) view.findViewById(R.id.btn_nextunsubscribescreen);
        mtxtSendEmailtoAdmin = (TextView) view.findViewById(R.id.txt_sendmailtoadmintounsubscribe);

        mbtnNext.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_nextunsubscribescreen){

            UnsubscribeScreen2Fragment unsubscribeScreen2Fragment = new UnsubscribeScreen2Fragment();
            //go to UnsubscribeScreen2Fragment
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, unsubscribeScreen2Fragment).addToBackStack(null).commit();

            //save the unsubscribe duration of radiobutton



        }
        else if(view.getId() == R.id.txt_sendmailtoadmintounsubscribe){

            //send email to admin



        }

    }
}

