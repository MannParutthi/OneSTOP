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
import com.appsplanet.onestop.adapter.MyMatchListAdapter;

public class MatchFragment extends Fragment implements View.OnClickListener{

    private ListView mlistViewMatch;
    MyMatchListAdapter myMatchListAdapter;
    private SearchView msearchView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_match_tab, container, false);

        mlistViewMatch = (ListView) view.findViewById(R.id.listview_match);
        msearchView = (SearchView) view.findViewById(R.id.searchView);

        //listview Matches
        myMatchListAdapter = new MyMatchListAdapter(getContext());
        mlistViewMatch.setAdapter(myMatchListAdapter);

        mlistViewMatch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
