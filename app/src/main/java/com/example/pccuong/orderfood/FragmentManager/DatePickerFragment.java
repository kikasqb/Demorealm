package com.example.pccuong.orderfood.FragmentManager;

import android.app.DatePickerDialog;
import android.app.Dialog;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.pccuong.orderfood.R;

import java.util.Calendar;
/**
 * Created by PCCuong on 10/28/2016.
 */
// Custom DatePicker
public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar calendar = Calendar.getInstance();
        int mNan = calendar.get(Calendar.YEAR);
        int mThang = calendar.get(Calendar.MONTH);
        int mNgay = calendar.get(Calendar.DAY_OF_MONTH);
// làm hiển thị gày tháng năm    }

        return new DatePickerDialog(getActivity(), this, mNgay, mThang, mNan);

    }
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        // truy xuất sang bên MainDangKy để lấy EditText
        EditText edNgaySinh = (EditText) getActivity().findViewById(R.id.ngaySinh);
        String sNgaySinh = dayOfMonth + "/" + month + 1  + "/" + year;
        edNgaySinh.setText(sNgaySinh);

    }
}
