package com.example.pccuong.orderfood.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.pccuong.orderfood.DTO.NhanVienDTO;
import com.example.pccuong.orderfood.Database.DatabaseSQLite;

/**
 * Created by PCCuong on 10/28/2016.
 */

public class NhanVienDAO {
    SQLiteDatabase database;
    public  NhanVienDAO(Context context){
        DatabaseSQLite sqLite = new DatabaseSQLite(context);
        database= sqLite.open();

    }
    public  long insertNhanVien(NhanVienDTO nhanVienDTO){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseSQLite.TB_NHANVIEN_TENNV, nhanVienDTO.getTenNV());
        contentValues.put(DatabaseSQLite.TB_NHANVIEN_MATKHAU, nhanVienDTO.getMatKhau());
        contentValues.put(DatabaseSQLite.TB_NHANVIEN_GIOITINH, nhanVienDTO.getGioiTinh());
        contentValues.put(DatabaseSQLite.TB_NHANVIEN_NGAYSINH, nhanVienDTO.getNgaySinh());
        contentValues.put(DatabaseSQLite.TB_NHANVIEN_SOCMND, nhanVienDTO.getcMND());
        long themNhanVien = database.insert(DatabaseSQLite.TB_NHANVIEN, null,contentValues);
        return themNhanVien;
    }
    public boolean kiemTraLogin(){
String kiemTra = " SELECT * FROM " + DatabaseSQLite.TB_NHANVIEN;
        // Cursor là 1 biến con trỏ
        // Nó giúp trỏ đến các row trong bảng csdl
        Cursor cursor =database.rawQuery(kiemTra,null);
        if(cursor.getCount() != 0) {
            return  true;

        }
        else  return false;
    }
public  boolean logGin(String tenDangNhap, String matKhau){
    String truyVan = "SELECT * FROM " + DatabaseSQLite.TB_NHANVIEN + " WHERE " + DatabaseSQLite.TB_NHANVIEN_TENNV + " = '" + tenDangNhap +
            "' AND " + DatabaseSQLite.TB_NHANVIEN_MATKHAU + " = '" + matKhau + "'";
    Cursor c = database.rawQuery(truyVan,null);
    if(c.getCount() != 0) {
        return  true;

    }
    else  return false;
}

}
