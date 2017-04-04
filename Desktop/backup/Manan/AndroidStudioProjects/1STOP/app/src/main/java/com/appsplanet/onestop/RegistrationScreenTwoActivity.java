package com.appsplanet.onestop;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.appsplanet.onestop.a1stop.R;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;

public class RegistrationScreenTwoActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton mimgBtnGoBack;

    private CircleImageView mimgBtnMainProfilePic, mimgBtnPic1, mimgBtnPic2,  mimgBtnPic3, mimgBtnPic4,
            mimgBtnPic5, mimgBtnPic6;

    private Button mbtnNext;
    String imagepath;
    CircleImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_screen_two);

        mimgBtnGoBack = (ImageButton) findViewById(R.id.imgBtn_goBack);
        mimgBtnMainProfilePic = (CircleImageView) findViewById(R.id.imgBtn_mainProfilePic);
        mimgBtnPic1 = (CircleImageView) findViewById(R.id.imgBtn_picOne);
        mimgBtnPic2 = (CircleImageView) findViewById(R.id.imgBtn_picTwo);
        mimgBtnPic3 = (CircleImageView) findViewById(R.id.imgBtn_picThree);
        mimgBtnPic4 = (CircleImageView) findViewById(R.id.imgBtn_picFour);
        mimgBtnPic5 = (CircleImageView) findViewById(R.id.imgBtn_picFive);
        mimgBtnPic6 = (CircleImageView) findViewById(R.id.imgBtn_picSix);
        mbtnNext = (Button) findViewById(R.id.btn_NEXTProfilePic);


        mimgBtnGoBack.setOnClickListener(this);
        mimgBtnMainProfilePic.setOnClickListener(this);
        mimgBtnPic1.setOnClickListener(this);
        mimgBtnPic2.setOnClickListener(this);
        mimgBtnPic3.setOnClickListener(this);
        mimgBtnPic4.setOnClickListener(this);
        mimgBtnPic5.setOnClickListener(this);
        mimgBtnPic6.setOnClickListener(this);
        mbtnNext.setOnClickListener(this);

    }

    public void selectImage(CircleImageView imageButton) {
        this.imageView = imageButton;
        final String[] items = {"Take Photo", "Choose from Library", "Cancel"};

        final AlertDialog.Builder alertdialog = new AlertDialog.Builder(RegistrationScreenTwoActivity.this);
        alertdialog.setTitle("Add Photo");

        alertdialog.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                if (items[i].equals("Take Photo")) {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    intent.putExtra("imagepath", imagepath);
                    startActivityForResult(intent, 1);
                } else if (items[i].equals("Choose from Library")) {
                    Intent intent = new Intent();
                    intent.setType("image/*");
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    intent.putExtra("imagepath", imagepath);
                    startActivityForResult(Intent.createChooser(intent, "Select File"), 2);
                } else if (items[i].equals("Cancel")) {
                    dialogInterface.dismiss();
                }

            }
        });
        alertdialog.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            if (requestCode == 1) {
                Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                thumbnail.compress(Bitmap.CompressFormat.JPEG, 90, bytes);
                File destination = new File(Environment.getExternalStorageDirectory(), System.currentTimeMillis() + ".jpg");
                FileOutputStream fo;
                try {
                    destination.createNewFile();
                    fo = new FileOutputStream(destination);
                    fo.write(bytes.toByteArray());
                    fo.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                imageView.setImageBitmap(thumbnail);
                imagepath = destination.getAbsolutePath();
            } else if (requestCode == 2) {
                Bitmap bm = null;
                if (data != null) {
                    try {
                        bm = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), data.getData());
                        Log.d("bm", String.valueOf(bm));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                imageView.setImageBitmap(bm);

                Uri i = data.getData();
                imagepath = i.toString();
                Log.d("imagepath", imagepath);
            }
        }
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.imgBtn_goBack){
            onBackPressed();
        }
        else if(view.getId() == R.id.imgBtn_mainProfilePic){
            selectImage(mimgBtnMainProfilePic);
        }
        else if(view.getId() == R.id.imgBtn_picOne){
            selectImage(mimgBtnPic1);
        }
        else if(view.getId() == R.id.imgBtn_picTwo){
            selectImage(mimgBtnPic2);
        }
        else if(view.getId() == R.id.imgBtn_picThree){
            selectImage(mimgBtnPic3);
        }
        else if(view.getId() == R.id.imgBtn_picFour){
            selectImage(mimgBtnPic4);
        }
        else if(view.getId() == R.id.imgBtn_picFive){
            selectImage(mimgBtnPic5);
        }
        else if(view.getId() == R.id.imgBtn_picSix){
            selectImage(mimgBtnPic6);
        }
        else if(view.getId() == R.id.btn_NEXTProfilePic){
            //save pics to database




            Intent intent = new Intent(RegistrationScreenTwoActivity.this, CategoryScreenActivity.class);
            finish();
            startActivity(intent);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(RegistrationScreenTwoActivity.this, SignInActivity.class);
        startActivity(intent);
    }
}
