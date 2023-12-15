package com.ibookshop.data;

import java.io.Serializable;

public class BookHome  {

    private boolean shouldbeRemove=false;
    private int idBookHome;
    private String TenSach;
    private String TenTacGia;
    private String urlImage;
    private String Gia;
    private String SoTrang;
    private String ngayPhatHanh;
    private String ngonNgu;
    private String theLoai;
    private String moTa;
    private String readUrl;
    private String phanTramDoc;
    public BookHome() {
    }

    public BookHome(int idBookHome, String tenSach, String tenTacGia, String urlImage, String gia, String soTrang, String ngayPhatHanh, String readUrl, String phanTramDoc) {
        this.idBookHome = idBookHome;
        TenSach = tenSach;
        TenTacGia = tenTacGia;
        this.urlImage = urlImage;
        SoTrang = soTrang;
        this.ngayPhatHanh = ngayPhatHanh;
        this.readUrl = readUrl;
        this.phanTramDoc = phanTramDoc;
        this.Gia = gia;
    }

    public BookHome(String tenSach, String tenTacGia, String urlImage) {
        TenSach = tenSach;
        TenTacGia = tenTacGia;
        this.urlImage = urlImage;
    }

    public BookHome(int id, String tenSach, String tenTacGia, String urlImage, String gia) {
        this.idBookHome = id;
        this.TenSach = tenSach;
        this.TenTacGia = tenTacGia;
        this.urlImage = urlImage;
        this.Gia = gia;
    }

    public BookHome(String tenSach, String tenTacGia, String urlImage, String gia, String soTrang, String ngayPhatHanh, String ngonNgu, String theLoai, String moTa) {
        TenSach = tenSach;
        TenTacGia = tenTacGia;
        this.urlImage = urlImage;
        Gia = gia;
        SoTrang = soTrang;
        this.ngayPhatHanh = ngayPhatHanh;
        this.ngonNgu = ngonNgu;
        this.theLoai = theLoai;
        this.moTa = moTa;
    }

    public void setReadUrl(String readUrl) {
        this.readUrl = readUrl;
    }

    public void setPhanTramDoc(String phanTramDoc) {
        this.phanTramDoc = phanTramDoc;
    }

    public String getReadUrl() {
        return readUrl;
    }

    public String getPhanTramDoc() {
        return phanTramDoc;
    }

    public boolean isShouldbeRemove() {
        return shouldbeRemove;
    }

    public void setShouldbeRemove(boolean shouldbeRemove) {
        this.shouldbeRemove = shouldbeRemove;
    }

    public int getIdBookHome() {
        return idBookHome;
    }

    public void setIdBookHome(int idBookHome) {
        this.idBookHome = idBookHome;
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

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getGia() {
        return Gia;
    }

    public void setGia(String gia) {
        Gia = gia;
    }

    public String getSoTrang() {
        return SoTrang;
    }

    public void setSoTrang(String soTrang) {
        SoTrang = soTrang;
    }

    public String getNgayPhatHanh() {
        return ngayPhatHanh;
    }

    public void setNgayPhatHanh(String ngayPhatHanh) {
        this.ngayPhatHanh = ngayPhatHanh;
    }

    public String getNgonNgu() {
        return ngonNgu;
    }

    public void setNgonNgu(String ngonNgu) {
        this.ngonNgu = ngonNgu;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}
