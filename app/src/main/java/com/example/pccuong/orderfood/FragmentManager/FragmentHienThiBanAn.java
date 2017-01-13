package com.example.pccuong.orderfood.FragmentManager;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.pccuong.orderfood.R;

/**
 * Created by PCCuong on 11/1/2016.
 */

public class FragmentHienThiBanAn extends android.support.v4.app.Fragment {
    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // hiện thị giao diện nguoi dung
        View view = inflater.inflate(R.layout.layout_hienthibanan_fragment,container , false);
        // để gọi hàm menu
        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        // ad 1 cai item
        MenuItem item = menu.add(1,R.id.itThemBanAn,1,"Thêm Bàn Ăn");
        item.setIcon(R.drawable.thembanan);
        // // xác đinh cái item còn trống
        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
