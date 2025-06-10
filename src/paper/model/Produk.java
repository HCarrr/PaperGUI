// Produk.java
package paper.model;

import java.util.List;
import java.util.ArrayList;

public class Produk {
    private String idProduk;
    private String nama;
    private double hargaJual;
    private double hargaBeli;
    private String deskripsi;

    public Produk(String idProduk, String nama, double hargaJual, double hargaBeli, String deskripsi) {
        this.idProduk = idProduk;
        this.nama = nama;
        this.hargaJual = hargaJual;
        this.hargaBeli = hargaBeli;
        this.deskripsi = deskripsi;
    }

    public String getIdProduk() {
        return idProduk;
    }

    public String getNama() {
        return nama;
    }

    public double getHargaJual() {
        return hargaJual;
    }

    public double getHargaBeli() {
        return hargaBeli;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getDetailProduk() {
        return "ID: " + idProduk + ", Nama: " + nama + ", Harga Jual: " + String.format("%.2f", hargaJual) + ", Harga Beli: " + String.format("%.2f", hargaBeli);
    }

    public void setIdProduk(String idProduk) {
        this.idProduk = idProduk;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setHargaJual(double hargaJual) {
        this.hargaJual = hargaJual;
    }

    public void setHargaBeli(double hargaBeli) {
        this.hargaBeli = hargaBeli;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    // Data statis untuk kebutuhan GUI
    public static final List<Produk> DATA_SAMPLE = new ArrayList<>();

    static {
        DATA_SAMPLE.add(new Produk("P001", "Kertas HVS A4", 50000, 40000, "Kertas HVS ukuran A4 70gsm"));
        DATA_SAMPLE.add(new Produk("P002", "Pulpen Biru", 3500, 2000, "Pulpen tinta biru"));
        DATA_SAMPLE.add(new Produk("P003", "Map Plastik", 2000, 1000, "Map plastik warna-warni"));
    }
}