package com.ibookshop.data;

public class Book {
    private String TenSach;
    private String TenTacGia;
<<<<<<< HEAD
    private String urlImage;
=======
>>>>>>> d9258338d0c65c8d937aa1875528a4f9dd93031e
    private int Hinh;
    private int SoTrang;
    private String ngayPhatHanh;
    private int phantramDoc;

<<<<<<< HEAD
    public Book(String tenSach, String tenTacGia, String urlImage) {
        TenSach = tenSach;
        TenTacGia = tenTacGia;
        this.urlImage = urlImage;
    }

    public Book(String tenSach, String tenTacGia) {
        TenSach = tenSach;
        TenTacGia = tenTacGia;
    }

=======
>>>>>>> d9258338d0c65c8d937aa1875528a4f9dd93031e
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
<<<<<<< HEAD

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
=======
>>>>>>> d9258338d0c65c8d937aa1875528a4f9dd93031e
}
