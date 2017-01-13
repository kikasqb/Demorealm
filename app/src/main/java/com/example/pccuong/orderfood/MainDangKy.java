package com.example.pccuong.orderfood;

import android.content.DialogInterface;
import android.content.pm.Signature;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.pccuong.orderfood.DAO.NhanVienDAO;
import com.example.pccuong.orderfood.DTO.NhanVienDTO;
import com.example.pccuong.orderfood.Database.DatabaseSQLite;
import com.example.pccuong.orderfood.FragmentManager.DatePickerFragment;

public class MainDangKy extends AppCompatActivity implements View.OnClickListener ,View.OnFocusChangeListener{
 EditText edDangKy,edMatKhau,edNgaySinh, edSoChungMinh;
    Button btnDangKy,btnThoat;
    RadioGroup rgGioiTinh;
    String sGioiTinh;
    NhanVienDTO nhanVienDTO;
    NhanVienDAO nhanVienDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dangky);
        edDangKy = (EditText) findViewById(R.id.tenDangKy);
        edMatKhau = (EditText) findViewById(R.id.matKhau);
        edNgaySinh = (EditText) findViewById(R.id.ngaySinh);
        edSoChungMinh = (EditText) findViewById(R.id.soChungMinh);
        btnDangKy = (Button) findViewById(R.id.btnDangKy);
        btnThoat = (Button) findViewById(R.id.btnThoat);
        rgGioiTinh = (RadioGroup) findViewById(R.id.rgGioiTinh);
        btnDangKy.setOnClickListener(this);
        btnThoat.setOnClickListener(this);
        edNgaySinh.setOnFocusChangeListener(this);
        nhanVienDAO = new NhanVienDAO(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btnDangKy :
                String tenDangNhap = edDangKy.getText().toString();
                String matKhau = edMatKhau.getText().toString();
                switch (rgGioiTinh.getCheckedRadioButtonId()){
                    case R.id.btnNam:
                        sGioiTinh ="Nam";
                        break;
                    case R.id.btnNU:
                        sGioiTinh ="Nữ";
                        break;
                }
                String ngaySinh = edNgaySinh.getText().toString();
                int soChungMinh = Integer.parseInt( edSoChungMinh.getText().toString());
                if(tenDangNhap == null && tenDangNhap.equals("")){
                    Toast.makeText(MainDangKy.this,getResources().getString(R.string.nhapTenDangNhap),Toast.LENGTH_LONG).show();
                } else if(matKhau == null && matKhau.equals("")){
                Toast.makeText(MainDangKy.this, getResources().getString(R.string.nhapMatKhau), Toast.LENGTH_LONG).show();
            } else {
                    nhanVienDTO = new NhanVienDTO();
                    nhanVienDTO.setTenNV(tenDangNhap);
                    nhanVienDTO.setMatKhau(matKhau);
                    nhanVienDTO.setGioiTinh(sGioiTinh);
                    nhanVienDTO.setNgaySinh(ngaySinh);
                    nhanVienDTO.setcMND(soChungMinh);
                    long kiemTra = nhanVienDAO.insertNhanVien(nhanVienDTO);
                    if(kiemTra != 0){
                        Toast.makeText(MainDangKy.this,getResources().getText(R.string.themThanhCong), Toast.LENGTH_LONG).show();

                    }else {
                        Toast.makeText(MainDangKy.this, getResources().getText(R.string.khongThanhCong), Toast.LENGTH_LONG).show();
                    }
                }
                break;
            case  R.id.btnThoat:
                finish();
                break;
        }
    }

    // đinh dang ngày sinh của minh
    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        int id = v.getId();
        switch (id){
            case R.id.ngaySinh:
                if(hasFocus){

                    DatePickerFragment datePickerFragment= new DatePickerFragment();
                    datePickerFragment.show(getSupportFragmentManager() ,"Ngay Sinh");
                }
                break;
        }

    }
}
