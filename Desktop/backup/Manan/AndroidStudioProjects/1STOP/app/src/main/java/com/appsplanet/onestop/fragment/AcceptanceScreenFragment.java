package com.appsplanet.onestop.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

import com.applozic.mobicomkit.uiwidgets.conversation.activity.ConversationActivity;
import com.appsplanet.onestop.a1stop.R;

public class AcceptanceScreenFragment extends Fragment {


    private Button mbtnChat, mbtnVideoCall;
    private ImageButton mimgbtnBack;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_acceptance_screen_tab, container, false);


        mbtnChat = (Button) view.findViewById(R.id.btn_chat);
        mbtnVideoCall = (Button) view.findViewById(R.id.btn_videocall);
        mimgbtnBack = (ImageButton) view.findViewById(R.id.imgbtn_back);

        mbtnChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(getContext(), ConversationActivity.class);
                startActivity(intent);


//                final Dialog customDialog = new Dialog(getContext());
//                customDialog.setContentView(R.layout.custom_dialog_chat);
//                customDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
//                customDialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
//                customDialog.show();
//
//                ImageButton imageButtonClose;
//                Button buttonCancel, buttonPaynow;
//
//                imageButtonClose = (ImageButton)customDialog.findViewById(R.id.imgbtn_close);
//                buttonCancel = (Button) customDialog.findViewById(R.id.btn_Cancel);
//                buttonPaynow = (Button) customDialog.findViewById(R.id.btn_PayNow);
//
//                imageButtonClose.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        customDialog.dismiss();
//                    }
//                });
//                buttonCancel.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        customDialog.dismiss();
//                    }
//                });
//                buttonPaynow.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        customDialog.dismiss();
//
//                    }
//                });


            }
        });

        mbtnVideoCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Dialog customDialog = new Dialog(getContext());
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

        return view;
    }
}

