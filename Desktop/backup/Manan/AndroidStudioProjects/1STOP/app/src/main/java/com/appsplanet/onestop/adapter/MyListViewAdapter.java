package com.appsplanet.onestop.adapter;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.appsplanet.onestop.DrawerMainScreenActivity;
import com.appsplanet.onestop.fragment.ProfileScreenFragment;
import com.appsplanet.onestop.a1stop.R;

/**
 * Created by manan on 15/3/17.
 */

public class MyListViewAdapter extends BaseAdapter {

    Context context;
    String[] LikeORFav = {"Mike liked your profile", "Tom liked your profile", "Jay liked your profile"};
    int[] LikeORfavPic = {R.drawable.facebook_logo, R.drawable.linkedin_logo, R.drawable.googleplus_logo};

    public MyListViewAdapter(Context context1){
        this.context = context1;
    }
    @Override
    public int getCount() {
        return LikeORFav.length;
    }

    @Override
    public Object getItem(int pos) {
        return LikeORFav[pos];
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }

    @Override
    public View getView(int pos, View view, ViewGroup parent) {

        View row;
        if(view == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.list_view, parent, false);
        }
        else{
            row = view;
        }
        TextView title = (TextView) row.findViewById(R.id.txt_likesORfav);
        ImageView logo = (ImageView) row.findViewById(R.id.imgview_likesORfav);

        title.setText(LikeORFav[pos]);
        logo.setImageResource(LikeORfavPic[pos]);

        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProfileScreenFragment profileScreenFragment = new ProfileScreenFragment();
                //go to ProfileScreen
                FragmentManager fragmentManager =((DrawerMainScreenActivity)context).getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, profileScreenFragment).addToBackStack(null).commit();
            }
        });

        return row;
    }

}
