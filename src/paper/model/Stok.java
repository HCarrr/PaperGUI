// Stok.java
package paper.model;

public class Stok {
    private String idStok;
    private int jumlah;
    private String lokasi;

    private static int COUNTER = 1; // Untuk auto-generate ID

    private static String generateId() {
        // Generate random alphanumeric ID, length 6
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();
        java.util.Random rand = new java.util.Random();
        for (int i = 0; i < 6; i++) {
            sb.append(chars.charAt(rand.nextInt(chars.length())));
        }
        return sb.toString();
    }

    public Stok(int jumlah, String lokasi) {
        this.idStok = generateId();
        this.jumlah = jumlah;
        this.lokasi = lokasi;
    }

    // Konstruktor lama (dengan id manual) tetap ada untuk kebutuhan data sample, tapi sebaiknya tidak dipakai di GUI
    public Stok(String idStok, int jumlah, String lokasi) {
        this.idStok = idStok;
        this.jumlah = jumlah;
        this.lokasi = lokasi;
    }

    public String getIdStok() {
        return idStok;
    }

    public int getJumlah() {
        return jumlah;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setIdStok(String idStok) {
        this.idStok = idStok;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public void tambahStok(int jumlah) {
        this.jumlah += jumlah;
        System.out.println("[Stok] Stok " + idStok + " bertambah menjadi: " + this.jumlah + " di " + this.lokasi);
    }

    public void kurangStok(int jumlah) {
        if (this.jumlah >= jumlah) {
            this.jumlah -= jumlah;
            System.out.println("[Stok] Stok " + idStok + " berkurang menjadi: " + this.jumlah + " di " + this.lokasi);
        } else {
            System.out.println("[Stok] Gagal mengurangi stok " + idStok + ": Jumlah tidak cukup (" + this.jumlah + " tersedia).");
        }
    }

    // Data statis untuk kebutuhan GUI (berbagi data stok)
    public static final java.util.List<Stok> DATA_SAMPLE = new java.util.ArrayList<>();

    public static java.util.List<Stok> getStokList() {
        return DATA_SAMPLE;
    }

    public static void addStok(Stok stok) {
        DATA_SAMPLE.add(stok);
    }

    public static void removeStok(Stok stok) {
        DATA_SAMPLE.remove(stok);
    }

    static {
        // Contoh data awal dengan ID acak
        DATA_SAMPLE.add(new Stok(generateId(), 100, "Gudang A"));
        DATA_SAMPLE.add(new Stok(generateId(), 50, "Gudang B"));
        DATA_SAMPLE.add(new Stok(generateId(), 200, "Gudang C"));
    }
}