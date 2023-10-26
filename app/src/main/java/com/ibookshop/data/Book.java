package com.ibookshop.data;

public class Book {
    private String TenSach;
    private String TenTacGia;
    private int Hinh;

    public Book(String tenSach, String tenTacGia, int hinh) {
        TenSach = tenSach;
        TenTacGia = tenTacGia;
        Hinh = hinh;
    }

    public String getTenSach() {
        return TenSach;
    }

    public void setTenSach(String tenSach) {
        TenSach = tenSach;
    }

    public String getTenTacGia() {
        return TenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        TenTacGia = tenTacGia;
    }

    public int getHinh() {
        return Hinh;
    }

    public void setHinh(int hinh) {
        Hinh = hinh;
    }
}
