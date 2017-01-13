package com.example.pccuong.orderfood;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.support.v4.app.FragmentTransaction;

import com.example.pccuong.orderfood.FragmentManager.FragmentHienThiBanAn;

/**
 * Created by PCCuong on 10/31/2016.
 */
// bắt sự kiên nvaigationView
public class TrangChuActivi extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView  navigationView;
    TextView textView;
    android.support.v4.app.FragmentManager fragmentManager;
    FragmentHienThiBanAn hienThiBanAn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_trangchu);


        drawerLayout= (DrawerLayout) findViewById(R.id.drawerLayout);
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        navigationView = (NavigationView)  findViewById(R.id.navigationLayout);
        // Tạo View gán trong layout_head_navigation
        //lây   view gán cho txtView
        //để khí đăng nhập vào hiển thi tên đăng nhập
        //  C1 : View view = LayoutInflater.from(this).inflate(R.layout.layout_head_navigation,null);
        //C2:
        View view = navigationView.inflateHeaderView(R.layout.layout_head_navigation);
        // gán view vào test
         textView = (TextView) view.findViewById(R.id.textView);

        // tạo tool bar
        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBarDrawerToggle  actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.mo,R.string.dong){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }


            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        // tạo sự kiến cho draverLayout chó actionBarDrawerToggle
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        // đồng bộ cho toolBar
       actionBarDrawerToggle.syncState();
        //set màu cho NavigationView.
        navigationView.setItemIconTintList(null);
       // truyền dữ liệu từ trang chủ sang
        Intent intent= getIntent();
        // bắt dữ liệu lấy tên đăng nhập
        String tenDN = intent.getStringExtra("tenDangNhap");
        Log.d("dulieu",tenDN);

        textView.setText(tenDN);
       fragmentManager =  getSupportFragmentManager();
        navigationView.setNavigationItemSelectedListener(this);
        // mặc định chạy trước
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        hienThiBanAn = new FragmentHienThiBanAn();
        fragmentTransaction.replace(R.id.content, hienThiBanAn);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id= item.getItemId();
        switch (id){
            case R.id.strangChu:
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                 hienThiBanAn = new FragmentHienThiBanAn();
                fragmentTransaction.replace(R.id.content, hienThiBanAn);
                fragmentTransaction.commit();
                item.setChecked(true);
                drawerLayout.closeDrawers();

                break;
            case R.id.sthucDon:
                break;
            case R.id.sthongKe:
                break;
            case R.id.scaiDat:
                break;
            case R.id.snhanVien:
                break;
        }
        return false;

    }
}
