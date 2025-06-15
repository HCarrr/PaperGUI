package paper.model;

import java.util.ArrayList;
import java.util.List;

public class Mitra {
    private String idMitra;
    private String nama;
    private String alamat;
    private String kontak;

    // Satu-satunya sumber data sample mitra
    public static final List<Mitra> DATA_SAMPLE = new ArrayList<>();

    static {
        // Data contoh awal
        DATA_SAMPLE.add(new Mitra("M001", "Mitra Satu", "Jl. Mawar 1", "08123456789"));
        DATA_SAMPLE.add(new Mitra("M002", "Mitra Dua", "Jl. Melati 2", "08234567890"));
        DATA_SAMPLE.add(new Mitra("M003", "Mitra Tiga", "Jl. Kenanga 3", "08345678901"));
    }

    public Mitra(String idMitra, String nama, String alamat, String kontak) {
        this.idMitra = idMitra;
        this.nama = nama;
        this.alamat = alamat;
        this.kontak = kontak;
    }

    public String getIdMitra() {
        return idMitra;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getKontak() {
        return kontak;
    }

    public String getDetailMitra() {
        return "ID: " + idMitra + ", Nama: " + nama + ", Alamat: " + alamat + ", Kontak: " + kontak;
    }
}
}
