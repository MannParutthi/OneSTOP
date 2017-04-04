package com.appsplanet.onestop.adapter;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.appsplanet.onestop.fragment.AcceptanceScreenFragment;
import com.appsplanet.onestop.DrawerMainScreenActivity;
import com.appsplanet.onestop.a1stop.R;

/**
 * Created by manan on 21/3/17.
 */

public class MyMatchListAdapter extends BaseAdapter {

    Context context;
    String[] Matches = {"Mike ", "Tom", "Jay"};

    public MyMatchListAdapter(Context context1){
        this.context = context1;
    }

    @Override
    public int getCount() {
        return Matches.length;
    }

    @Override
    public Object getItem(int pos) {
        return Matches[pos];
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
            row = layoutInflater.inflate(R.layout.match_list, parent, false);
        }
        else{
            row = view;
        }
        TextView title = (TextView) row.findViewById(R.id.txt_match);
        ImageButton imgbtnChat = (ImageButton) row.findViewById(R.id.imgbtn_chat);
        ImageButton imgbtnVideoCall = (ImageButton) row.findViewById(R.id.imgbtn_videocall);

        imgbtnChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Dialog customDialog = new Dialog(context);
                customDialog.setContentView(R.layout.custom_dialog_chat);
                customDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                customDialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                customDialog.show();

                ImageButton imageButtonClose;
                Button buttonCancel, buttonPaynow;

                imageButtonClose = (ImageButton)customDialog.findViewById(R.id.imgbtn_close);
                buttonCancel = (Button) customDialog.findViewById(R.id.btn_Cancel);
                buttonPaynow = (Button) customDialog.findViewById(R.id.btn_PayNow);

                imageButtonClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        customDialog.dismiss();
                    }
                });
                buttonCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        customDialog.dismiss();
                    }
                });
                buttonPaynow.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        customDialog.dismiss();

                    }
                });


            }
        });

        imgbtnVideoCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Dialog customDialog = new Dialog(context);
                customDialog.setContentView(R.layout.custom_dialog_videocall);
                customDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                customDialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                customDialog.show();

                ImageButton imageButtonClose;
                Button buttonCancel, buttonPaynow;

                imageButtonClose = (ImageButton)customDialog.findViewById(R.id.imgbtn_close);
                buttonCancel = (Button) customDialog.findViewById(R.id.btn_Cancel);
                buttonPaynow = (Button) customDialog.findViewById(R.id.btn_PayNow);

                imageButtonClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        customDialog.dismiss();
                    }
                });
                buttonCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        customDialog.dismiss();
                    }
                });
                buttonPaynow.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        customDialog.dismiss();
                    }
                });

            }
        });

        title.setText(Matches[pos]);

        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AcceptanceScreenFragment acceptanceScreenTab = new AcceptanceScreenFragment();
                //go to AcceptanceScreen
                FragmentManager fragmentManager =((DrawerMainScreenActivity)context).getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, acceptanceScreenTab).addToBackStack(null).commit();
            }
        });

        return row;
    }

}
