package com.appsplanet.onestop.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.applozic.mobicomkit.api.account.user.UserClientService;
import com.appsplanet.onestop.DrawerMainScreenActivity;
import com.appsplanet.onestop.a1stop.R;

public class LogOutFragment extends Fragment implements View.OnClickListener{

    private Button mbtnOk, mbtnDecline;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_log_out, container, false);

        ((DrawerMainScreenActivity) getActivity()).setMtxtTabTitle("LOGOUT");

        mbtnOk = (Button) view.findViewById(R.id.btn_Ok);
        mbtnDecline = (Button) view.findViewById(R.id.btn_Decline);

        mbtnOk.setOnClickListener(this);
        mbtnDecline.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_Ok){
            new UserClientService(getContext()).logout();
            getActivity().finish();
        }
        else if(view.getId() == R.id.btn_Decline){
            getActivity().onBackPressed();
        }
    }
}


