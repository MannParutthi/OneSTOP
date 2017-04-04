package com.appsplanet.onestop;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.appsplanet.onestop.a1stop.R;
import com.appsplanet.onestop.adapter.MyNavigationDrawerAdapter;
import com.appsplanet.onestop.fragment.DashboardFragment;

public class DrawerMainScreenActivity extends AppCompatActivity {

    private DrawerLayout mdrawerLayout;
    private ListView mlistView;
    private ImageButton mimgBtnNavigationDrawer;
    private MyNavigationDrawerAdapter myNavigationDrawerAdapter;
    private LinearLayout mlinearLayout_drawer;

    private TextView mtxtTabTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_main_screen);

        //set dashboard as homepage yby default
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content_frame, new DashboardFragment()).commit();

        mdrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mlistView = (ListView) findViewById(R.id.right_drawer_list);
        mimgBtnNavigationDrawer = (ImageButton) findViewById(R.id.imgBtn_navigationDrawer);
        mlinearLayout_drawer = (LinearLayout) findViewById(R.id.drawer_linear);

        mtxtTabTitle = (TextView) findViewById(R.id.txt_tabsTitle);

        //sliding navigation drawer
        myNavigationDrawerAdapter = new MyNavigationDrawerAdapter(this);
        mlistView.setAdapter(myNavigationDrawerAdapter);

        mimgBtnNavigationDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(mdrawerLayout.isDrawerOpen(mlinearLayout_drawer)){
                    mdrawerLayout.closeDrawer(mlinearLayout_drawer);
                }
                else {
                    mdrawerLayout.openDrawer(mlinearLayout_drawer);
                }

            }
        });

        mlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
                mdrawerLayout.closeDrawers();

                String listitem = mlistView.getItemAtPosition(pos).toString();
                if(listitem.equalsIgnoreCase("Home")){
                    mtxtTabTitle.setText("LETS CONNECT");
                }
                else if(listitem.equalsIgnoreCase("Location (CAN WE MAPPING)")){
                    mtxtTabTitle.setText("MAPPING");
                }
                else {
                    mtxtTabTitle.setText(listitem);
                }

                //open fragment
                if(listitem.equalsIgnoreCase("Edit Profile")){
                    Intent intent = new Intent(DrawerMainScreenActivity.this, RegisterActivity.class);
                    startActivity(intent);
                }
                else {
                    Fragment gotofragment = myNavigationDrawerAdapter.goToSelectedFragment(listitem);
                    if (gotofragment != null) {
                        if (gotofragment instanceof DashboardFragment) {
                            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                            getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                            ft.replace(R.id.content_frame, gotofragment);
                            ft.commit();

                        } else {
                            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                            ft.add(R.id.content_frame, gotofragment);
                            ft.replace(R.id.content_frame, gotofragment);
                            ft.addToBackStack(null);
                            ft.commit();
                        }
                    }
                }
            }

        });

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void setMtxtTabTitle(String title){
        mtxtTabTitle.setText(title);
    }
}
