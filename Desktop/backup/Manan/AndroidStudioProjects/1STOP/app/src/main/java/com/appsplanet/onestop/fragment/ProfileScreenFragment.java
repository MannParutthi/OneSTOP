package com.appsplanet.onestop.fragment;

import android.support.v4.app.Fragment;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.TextView;

import com.appsplanet.onestop.a1stop.R;

public class ProfileScreenFragment extends Fragment implements View.OnClickListener{


    private TabLayout mtabLayout;
    private ViewPager mviewPager;

    private TextView mtxtName, mtxtAge, mtxtCountry;
    private Button mbtnLikes, mbtnFavs, mbtnMatches;
    private SearchView msearchView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_screen, container, false);

        mtabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        mviewPager = (ViewPager) view.findViewById(R.id.vpager);

        mtxtName = (TextView) view.findViewById(R.id.txt_name);
        mtxtAge = (TextView) view.findViewById(R.id.txt_age);
        mtxtCountry = (TextView) view.findViewById(R.id.txt_country);
        mbtnLikes = (Button) view.findViewById(R.id.btn_likes);
        mbtnFavs = (Button) view.findViewById(R.id.btn_favs);
        mbtnMatches = (Button) view.findViewById(R.id.btn_matches);
        msearchView = (SearchView) view.findViewById(R.id.searchView);

        mbtnLikes.setOnClickListener(this);
        mbtnFavs.setOnClickListener(this);
        mbtnMatches.setOnClickListener(this);

        int searchSrcTextId = getResources().getIdentifier("android:id/search_src_text", null, null);
        EditText searchEditText = (EditText) msearchView.findViewById(searchSrcTextId);
        searchEditText.setTextColor(getResources().getColor(R.color.white));
        searchEditText.setHintTextColor(getResources().getColor(R.color.white));

        msearchView.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_likes){
            LikesFragment likesFragment = new LikesFragment();
            //go to LikesFragment
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, likesFragment).addToBackStack(null).commit();
        }
        else if(view.getId() == R.id.btn_favs){
            FavouritesFragment favouritesFragment = new FavouritesFragment();
            //go to FavsTab
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, favouritesFragment).addToBackStack(null).commit();
        }
        else if(view.getId() == R.id.btn_matches){
            MatchFragment matchFragment = new MatchFragment();
            //go to MatchFragment
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, matchFragment).addToBackStack(null).commit();
        }
        else if(view.getId() == R.id.searchView){
            msearchView.onActionViewExpanded();
        }
    }
}

