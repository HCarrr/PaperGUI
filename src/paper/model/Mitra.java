package paper.model;

public class Mitra {
    private String idMitra;
    private String namaMitra;
    private String jenisMitra;    
    private String alamat;
    private String telepon;
    private String email;
    private String kontakPersonUtama;

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