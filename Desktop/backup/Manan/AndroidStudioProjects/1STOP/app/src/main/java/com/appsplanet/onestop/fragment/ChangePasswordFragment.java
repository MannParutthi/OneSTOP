package com.appsplanet.onestop.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
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

public class ChangePasswordFragment extends Fragment implements View.OnClickListener{

    private EditText medtxtCurrentPassword, medtxtNewPassword, medtxtConfirmPassword;
    private Button mbtnChangePassword, mbtnCancel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_change_password, container, false);

        ((DrawerMainScreenActivity) getActivity()).setMtxtTabTitle("CHANGE PASSWORD");

        medtxtCurrentPassword = (EditText) view.findViewById(R.id.edtxt_currentPassword);
        medtxtNewPassword = (EditText) view.findViewById(R.id.edtxt_newPassword);
        medtxtConfirmPassword = (EditText) view.findViewById(R.id.edtxt_confirmPassword);
        mbtnChangePassword = (Button) view.findViewById(R.id.btn_changePassword);
        mbtnCancel = (Button) view.findViewById(R.id.btn_Cancel);

        mbtnChangePassword.setOnClickListener(this);
        mbtnCancel.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_changePassword){
            DashboardFragment dashboardFragment = new DashboardFragment();
            //go to AcceptanceScreen
            FragmentManager fragmentManager =getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, dashboardFragment).addToBackStack(null).commit();


            final AlertDialog.Builder alertdialog = new AlertDialog.Builder(getContext());
            alertdialog.setTitle("Password has been changed");

            alertdialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            alertdialog.show();
        }
        else if(view.getId() == R.id.btn_Cancel){
                getActivity().onBackPressed();
        }
    }
}
