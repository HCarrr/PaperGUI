package paper.model;

import java.util.ArrayList;
import java.util.List;

public class Kategori {
    private String idKategori;
    private String nama;
    private String deskripsi;

    public static final List<Kategori> DATA_SAMPLE = new ArrayList<>();

    private static String generateId() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();
        java.util.Random rand = new java.util.Random();
        for (int i = 0; i < 6; i++) {
            sb.append(chars.charAt(rand.nextInt(chars.length())));
        }
        return sb.toString();
    }

    public Kategori(String nama, String deskripsi) {
        this.idKategori = generateId();
        this.nama = nama;
        this.deskripsi = deskripsi;
    }

    public Kategori(String idKategori, String nama, String deskripsi) {
        this.idKategori = idKategori;
        this.nama = nama;
        this.deskripsi = deskripsi;
    }

    public String getIdKategori() {
        return idKategori;
    }

    public String getNama() {
        return nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    static {
        DATA_SAMPLE.add(new Kategori(generateId(), "Alat Tulis", "Kategori alat tulis kantor"));
        DATA_SAMPLE.add(new Kategori(generateId(), "Kertas", "Kategori kertas berbagai ukuran"));
        DATA_SAMPLE.add(new Kategori(generateId(), "Aksesoris", "Kategori aksesoris kantor"));
    }
}
