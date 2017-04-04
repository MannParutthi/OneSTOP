package com.appsplanet.onestop.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import com.appsplanet.onestop.DrawerMainScreenActivity;
import com.appsplanet.onestop.a1stop.R;

public class DashboardFragment extends Fragment implements View.OnClickListener{

    private TextView mtxtName, mtxtAge, mtxtCountry;
    private Button mbtnLikes, mbtnFavs, mbtnMatches;
    private ImageView mimgviewPic;
    String title;
    private SearchView msearchView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        ((DrawerMainScreenActivity) getActivity()).setMtxtTabTitle("LETS CONNECT");

        mtxtName = (TextView) view.findViewById(R.id.txt_myname);
        mtxtAge = (TextView) view.findViewById(R.id.txt_myage);
        mtxtCountry = (TextView) view.findViewById(R.id.txt_mycountry);
        mbtnLikes = (Button) view.findViewById(R.id.btn_likes);
        mbtnFavs = (Button) view.findViewById(R.id.btn_favs);
        mbtnMatches = (Button) view.findViewById(R.id.btn_matches);
        mimgviewPic = (ImageView) view.findViewById(R.id.imgviewPic);
        msearchView = (SearchView) view.findViewById(R.id.searchView);

        mbtnLikes.setOnClickListener(this);
        mbtnFavs.setOnClickListener(this);
        mbtnMatches.setOnClickListener(this);
        mimgviewPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProfileScreenFragment profileScreenFragment = new ProfileScreenFragment();
                //go to ProfileScreen
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, profileScreenFragment).addToBackStack(null).commit();
            }
        });


        int searchSrcTextId = getResources().getIdentifier("android:id/search_src_text", null, null);
        EditText searchEditText = (EditText) msearchView.findViewById(searchSrcTextId);
        searchEditText.setTextColor(getResources().getColor(R.color.white));
        searchEditText.setHintTextColor(getResources().getColor(R.color.white));


        msearchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                msearchView.onActionViewExpanded();

            }
        });

        return view;
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_likes){
            title = "YOUR LIKES";
            LikesFragment likesFragment = new LikesFragment();
            //go to LikesFragment
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, likesFragment).addToBackStack(null).commit();
        }
        else if(view.getId() == R.id.btn_favs){
            title = "YOUR FAVOURITES";
            FavouritesFragment favouritesFragment = new FavouritesFragment();
            //go to FavsTab
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, favouritesFragment).addToBackStack(null).commit();
        }
        else if(view.getId() == R.id.btn_matches){
            title = "YOUR MATCHES";
            MatchFragment matchFragment = new MatchFragment();
            //go to MatchFragment
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, matchFragment).addToBackStack(null).commit();
        }
        ((DrawerMainScreenActivity) getActivity()).setMtxtTabTitle(title);
    }

}
