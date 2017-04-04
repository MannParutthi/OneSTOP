package com.appsplanet.onestop.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.appsplanet.onestop.DrawerMainScreenActivity;
import com.appsplanet.onestop.a1stop.R;

public class ContactUsFragment extends Fragment implements View.OnClickListener{

    private Button mbtnSubmit;
    private EditText medtxtDatatobeMailed, medtxtSubject;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_contact_us_tab, container, false);

        ((DrawerMainScreenActivity) getActivity()).setMtxtTabTitle("CONTACT US");

        mbtnSubmit = (Button) view.findViewById(R.id.btn_submitContactUs);
        medtxtSubject = (EditText) view.findViewById(R.id.edtxt_subject);
        medtxtDatatobeMailed = (EditText) view.findViewById(R.id.edtxt_datatobeMailed);

        mbtnSubmit.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_submitContactUs){
            ThankyouscreenFromcontactusFragment thankyouscreenFromcontactusFragment = new ThankyouscreenFromcontactusFragment();
            //go to ThankyouscreenFromcontactusFragment
            Bundle data1 = new Bundle();
            if(getArguments()!= null){
                data1.putString("data1",getArguments().getString("data"));
            }
            else {
                data1.putString("data1", "Thanks for your mail (Name), admin will get back to you as soon as possible");
            }
            thankyouscreenFromcontactusFragment.setArguments(data1);
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, thankyouscreenFromcontactusFragment).addToBackStack(null).commit();
        }
    }
}

