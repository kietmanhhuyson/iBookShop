package com.ibookshop.data;

public class MyBook {
    private String TenSach;
    private String TenTacGia;
    private String surl;
    private String readUrl;
    private int soTrang;
    private String ngayPhatHanh;
    private int phanTramDoc;
    private String User;

    public MyBook() {
    }

    public MyBook(String tenSach, String tenTacGia, String surl, String readUrl, int soTrang, String ngayPhatHanh, int phanTramDoc) {
        TenSach = tenSach;
        TenTacGia = tenTacGia;
        this.surl = surl;
        this.readUrl = readUrl;
        this.soTrang = soTrang;
        this.ngayPhatHanh = ngayPhatHanh;
        this.phanTramDoc = phanTramDoc;
    }

    public MyBook(String tenSach, String tenTacGia, String surl, int soTrang, String ngayPhatHanh, int phanTramDoc) {
        TenSach = tenSach;
        TenTacGia = tenTacGia;
        this.surl = surl;
        this.soTrang = soTrang;
        this.ngayPhatHanh = ngayPhatHanh;
        this.phanTramDoc = phanTramDoc;
    }

    public void setUser(String user) {
        User = user;
    }

    public String getUser() {
        return User;
    }

    public String getReadUrl() {
        return readUrl;
    }

    public void setReadUrl(String readUrl) {
        this.readUrl = readUrl;
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

    public String getSurl() {
        return surl;
    }

    public void setSurl(String surl) {
        this.surl = surl;
    }

    public int getSoTrang() {
        return soTrang;
    }

    public void setSoTrang(int soTrang) {
        this.soTrang = soTrang;
    }

    public String getNgayPhatHanh() {
        return ngayPhatHanh;
    }

    public void setNgayPhatHanh(String ngayPhatHanh) {
        this.ngayPhatHanh = ngayPhatHanh;
    }

    public int getPhanTramDoc() {
        return phanTramDoc;
    }

    public void setPhanTramDoc(int phanTramDoc) {
        this.phanTramDoc = phanTramDoc;
    }
}
