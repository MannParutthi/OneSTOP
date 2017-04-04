package com.appsplanet.onestop.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.appsplanet.onestop.fragment.PrivacyFragment;
import com.appsplanet.onestop.fragment.TermsofuseFragment;

/**
 * Created by manan on 16/3/17.
 */

public class legalsPagerAdapter extends FragmentStatePagerAdapter {

    public legalsPagerAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                PrivacyFragment privacyFragment = new PrivacyFragment();
                return privacyFragment;
            case 1:
                TermsofuseFragment termsofuseFragment = new TermsofuseFragment();
                return termsofuseFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}