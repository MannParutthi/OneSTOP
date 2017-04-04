package com.appsplanet.onestop.fragment;

import android.support.v4.app.Fragment;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appsplanet.onestop.DrawerMainScreenActivity;
import com.appsplanet.onestop.a1stop.R;
import com.appsplanet.onestop.adapter.legalsPagerAdapter;

public class LegalsFragment extends Fragment {

    private TabLayout mtabLayout;
    private ViewPager mviewPager;
    legalsPagerAdapter pagerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_legals_tab, container, false);

        ((DrawerMainScreenActivity) getActivity()).setMtxtTabTitle("LEGALS");

        mtabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        mviewPager = (ViewPager) view.findViewById(R.id.vpager);

        //tabs
        mtabLayout.addTab(mtabLayout.newTab().setText("Privacy"));
        mtabLayout.addTab(mtabLayout.newTab().setText("Terms of use"));
        mtabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        pagerAdapter = new legalsPagerAdapter(getChildFragmentManager());
        mviewPager.setAdapter(pagerAdapter);

        mviewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mtabLayout));

        mtabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener()
        {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mviewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            mtabLayout.setSelectedTabIndicatorColor(getContext().getColor(R.color.lightBlue));
            mtabLayout.setTabTextColors(getContext().getColor(R.color.lightGray), getContext().getColor(R.color.lightBlue));
        }

        return view;
    }
}
