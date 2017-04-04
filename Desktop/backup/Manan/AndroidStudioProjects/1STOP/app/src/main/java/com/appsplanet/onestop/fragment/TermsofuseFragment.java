package com.appsplanet.onestop.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.appsplanet.onestop.a1stop.R;

public class TermsofuseFragment extends Fragment implements View.OnClickListener{

    private Button mbtnClose;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_termsofuse_tab, container, false);

        mbtnClose = (Button) view.findViewById(R.id.btn_closeTermsofuseTab);

        mbtnClose.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_closeTermsofuseTab){
            DashboardFragment dashboardFragment = new DashboardFragment();
            //go toHome
            FragmentTransaction fragmentTransaction = getParentFragment().getFragmentManager().beginTransaction();
            getParentFragment().getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            fragmentTransaction.replace(R.id.content_frame, dashboardFragment).commit();
        }
    }
}


