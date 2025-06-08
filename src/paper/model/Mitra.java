package paper.model;

import java.util.List;
import java.util.ArrayList;

public class Mitra {
    private String idMitra;
    private String namaMitra;
    private String jenisMitra;    
    private String alamat;
    private String telepon;
    private String email;
    private String kontakPersonUtama;

    // Data statis untuk kebutuhan GUI
    public static final List<Mitra> DATA_SAMPLE = new ArrayList<>();

    static {
        DATA_SAMPLE.add(new Mitra("M001", "Toko Sukses", "Toko", "Jl. Merdeka No.1", "08123456789", "sukses@toko.com", "Budi"));
        DATA_SAMPLE.add(new Mitra("M002", "Mitra Jaya", "Distributor", "Jl. Jaya No.2", "08234567890", "jaya@mitra.com", "Siti"));
        DATA_SAMPLE.add(new Mitra("M003", "CV Lancar", "CV", "Jl. Lancar No.3", "08345678901", "lancar@cv.com", "Andi"));
    }

    public Mitra(String idMitra, String namaMitra, String jenisMitra, String alamat, String telepon, String email, String kontakPersonUtama) {
        this.idMitra = idMitra;
        this.namaMitra = namaMitra;
        this.jenisMitra = jenisMitra;
        this.alamat = alamat;
        this.telepon = telepon;
        this.email = email;
        this.kontakPersonUtama = kontakPersonUtama;
    }

    public String getIdMitra() {
        return idMitra;
    }

    public String getNamaMitra() {
        return namaMitra;
    }

    public String getJenisMitra() {
        return jenisMitra;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getTelepon() {
        return telepon;
    }

    public String getEmail() {
        return email;
    }

    public String getKontakPersonUtama() {
        return kontakPersonUtama;
    }
}