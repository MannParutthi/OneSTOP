package com.appsplanet.onestop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.appsplanet.onestop.fragment.ChangePasswordFragment;
import com.appsplanet.onestop.fragment.ContactUsFragment;
import com.appsplanet.onestop.fragment.DashboardFragment;
import com.appsplanet.onestop.fragment.LegalsFragment;
import com.appsplanet.onestop.fragment.LogOutFragment;
import com.appsplanet.onestop.fragment.MappingScreenFragment;
import com.appsplanet.onestop.fragment.ProfileScreenFragment;
import com.appsplanet.onestop.fragment.UnsubscribeScreen1Fragment;
import com.appsplanet.onestop.a1stop.R;

/**
 * Created by manan on 14/3/17.
 */

public class MyNavigationDrawerAdapter extends BaseAdapter {

    Context context;
    String[] drawerlist = {"HOME", "EDIT PROFILE", "CHANGE PASSWORD", "LOCATION (CAN WE MAPPING)", "CONTACT US", "LEGAL", "HOW TO USE",
            "LOG OUT", "UNSUBSCRIBE"};

    public MyNavigationDrawerAdapter(Context context1) {
        this.context = context1;
    }

    @Override
    public int getCount() {
        return drawerlist.length;
    }

    @Override
    public Object getItem(int pos) {
        return drawerlist[pos];
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }

    @Override
    public View getView(int pos, View view, ViewGroup parent) {

        View row;
        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.custom_navigationdrawer_row, parent, false);
        } else {
            row = view;
        }
        TextView title = (TextView) row.findViewById(R.id.txtViewList);

        title.setText(drawerlist[pos]);

        return row;
    }

    public android.support.v4.app.Fragment goToSelectedFragment (String item){
        String fragName = item;

        if(fragName.equalsIgnoreCase("Home")){
           DashboardFragment dashboardFragment = new DashboardFragment();
            return dashboardFragment;
        }
        else if(fragName.equalsIgnoreCase("Edit Profile")){
            //edit profile fragment

            ProfileScreenFragment profileScreenFragment = new ProfileScreenFragment();
            return profileScreenFragment;

        }
        else if(fragName.equalsIgnoreCase("Change Password")){
            ChangePasswordFragment changePasswordTab = new ChangePasswordFragment();
            return changePasswordTab;
        }
        else if(fragName.equalsIgnoreCase("Location (CAN WE MAPPING)")){
            MappingScreenFragment mappingScreenFragment = new MappingScreenFragment();
            return mappingScreenFragment;
        }
        else if(fragName.equalsIgnoreCase("Contact Us")){
            ContactUsFragment contactUsTab =new ContactUsFragment();
            return contactUsTab;
        }
        else if(fragName.equalsIgnoreCase("Legal")){
            LegalsFragment legalsFragment = new LegalsFragment();
            return legalsFragment;
        }
        else if(fragName.equalsIgnoreCase("How to use")){
            //how to use fragment


        }
        else if(fragName.equalsIgnoreCase("Log Out")){
            LogOutFragment logOutFragment = new LogOutFragment();
            return logOutFragment;
        }
        else if(fragName.equalsIgnoreCase("Unsubscribe")){
            UnsubscribeScreen1Fragment unsubscribeScreen1Fragment = new UnsubscribeScreen1Fragment();
            return unsubscribeScreen1Fragment;
        }
        return null;
    }
}
