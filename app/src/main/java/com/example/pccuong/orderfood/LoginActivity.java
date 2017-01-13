package com.example.pccuong.orderfood;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pccuong.orderfood.DAO.NhanVienDAO;

/**
 * Created by PCCuong on 10/29/2016.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    Button mLogin, mDangKy;
    EditText mTenDangNhap, mPassWord;
    NhanVienDAO  nhanVienDAO;
    @Override
    public void onCreate(Bundle savedInstanceStatete) {
        super.onCreate(savedInstanceStatete);
        setContentView(R.layout.layout_dangnhap);
       mLogin = (Button) findViewById(R.id.idLogin);
        mDangKy = (Button) findViewById(R.id.idDangKy);
        mTenDangNhap = (EditText) findViewById(R.id.edtLogin);
        mPassWord = (EditText) findViewById(R.id.edtPassWord);
        // làm ẩn. nút đăng ký
        mDangKy.setVisibility(View.GONE);
        nhanVienDAO = new NhanVienDAO(this);
       kiemTraLoginvsDangKy();
        mLogin.setOnClickListener(this);
        mDangKy.setOnClickListener(this);

    }
    private void dangNhap(){
        String tenDangNhap = mTenDangNhap.getText().toString();
        String matKhau = mPassWord.getText().toString();
        boolean kiemTra = nhanVienDAO.logGin(tenDangNhap,matKhau);
        if(kiemTra){
            Intent iTrangChu = new Intent(LoginActivity.this, TrangChuActivi.class);
            // truyền dữ liệu từ tên đăng nhập quá..sang trang chu
            iTrangChu.putExtra("tenDangNhap",mTenDangNhap.getText().toString());
            startActivity(iTrangChu);

        } else  {
            Toast.makeText(LoginActivity.this, "Đăng Nhập Không Thành Công " ,Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        kiemTraLoginvsDangKy();
    }

    private void kiemTraLoginvsDangKy(){
        boolean kiemTra =  nhanVienDAO.kiemTraLogin();
        if(kiemTra) {
            mDangKy.setVisibility(View.GONE);
            mLogin.setVisibility(View.VISIBLE);
        }else{
            mDangKy.setVisibility(View.VISIBLE);
            mLogin.setVisibility(View.GONE);
        }
    }
    private  void dangKy(){
        Intent intent= new Intent(LoginActivity.this,MainDangKy.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.idLogin:
                dangNhap();
                break;
            case R.id.idDangKy:
                dangKy();
                break;
        }
    }
}
