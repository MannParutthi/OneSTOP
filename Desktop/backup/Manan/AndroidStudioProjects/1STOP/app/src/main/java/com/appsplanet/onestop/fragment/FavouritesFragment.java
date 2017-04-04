package com.appsplanet.onestop.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;

import com.appsplanet.onestop.a1stop.R;
import com.appsplanet.onestop.adapter.MyListViewAdapter;

public class FavouritesFragment extends Fragment implements View.OnClickListener{

    ListView mlistViewFavourites;
    MyListViewAdapter myListViewAdapter;
    SearchView msearchView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favourites, container, false);

        mlistViewFavourites = (ListView) view.findViewById(R.id.listview_favourites);
        msearchView = (SearchView) view.findViewById(R.id.searchView);

        //listview Favourites
        myListViewAdapter = new MyListViewAdapter(getContext());
        mlistViewFavourites.setAdapter(myListViewAdapter);

        mlistViewFavourites.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {

            }
        });

        int searchSrcTextId = getResources().getIdentifier("android:id/search_src_text", null, null);
        EditText searchEditText = (EditText) msearchView.findViewById(searchSrcTextId);
        searchEditText.setTextColor(getResources().getColor(R.color.white));
        searchEditText.setHintTextColor(getResources().getColor(R.color.white));

        msearchView.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.searchView){
            msearchView.onActionViewExpanded();
        }
    }
}

