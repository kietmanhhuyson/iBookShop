package com.ibookshop.data;

public class Book {
    private int idBook;
    private String TenSach;
    private String TenTacGia;
    private String urlImage;
    private int Hinh;
    private int SoTrang;
    private String ngayPhatHanh;
    private int phantramDoc;


    public Book(int id, String tenSach, String tenTacGia, String urlImage) {
        this.idBook = id;
        TenSach = tenSach;
        TenTacGia = tenTacGia;
        this.urlImage = urlImage;
    }
    public Book(String tenSach, String tenTacGia, String urlImage) {
        TenSach = tenSach;
        TenTacGia = tenTacGia;
        this.urlImage = urlImage;
    }

    public Book(String tenSach, String tenTacGia) {
        TenSach = tenSach;
        TenTacGia = tenTacGia;
    }

    public Book(String tenSach, String tenTacGia, int hinh) {
        TenSach = tenSach;
        TenTacGia = tenTacGia;
        Hinh = hinh;
    }
    public Book(String tenSach, String tenTacGia, int hinh, int soTrang, String ngayPhatHanh, int phantramDoc) {
        TenSach = tenSach;
        TenTacGia = tenTacGia;
        Hinh = hinh;
        SoTrang = soTrang;
        this.ngayPhatHanh = ngayPhatHanh;
        this.phantramDoc = phantramDoc;
    }
    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }
    public int getSoTrang() {
        return SoTrang;
    }

    public void setSoTrang(int soTrang) {
        SoTrang = soTrang;
    }

    public String getNgayPhatHanh() {
        return ngayPhatHanh;
    }

    public void setNgayPhatHanh(String ngayPhatHanh) {
        this.ngayPhatHanh = ngayPhatHanh;
    }

    public int getPhantramDoc() {
        return phantramDoc;
    }

    public void setPhantramDoc(int phantramDoc) {
        this.phantramDoc = phantramDoc;
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

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
