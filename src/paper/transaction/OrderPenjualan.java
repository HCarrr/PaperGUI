// OrderPenjualan.java
package paper.transaction;

import paper.model.Produk;
import paper.model.Mitra;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class OrderPenjualan extends DokumenTransaksi {
    private Map<Produk, Integer> daftarProdukDijual;
    private Mitra pelanggan;

    public OrderPenjualan(String idTransaksi, Date tanggalTransaksi, Mitra pelanggan) {
        super(idTransaksi, tanggalTransaksi, "Draft");
        this.pelanggan = pelanggan;
        this.daftarProdukDijual = new HashMap<>();
    }

    public Map<Produk, Integer> getDaftarProdukDijual() {
        return daftarProdukDijual;
    }

    public Mitra getPelanggan() {
        return pelanggan;
    }

    public void tambahProduk(Produk produk, int jumlah) {
        if (jumlah <= 0) {
            System.out.println("[Order Penjualan] Jumlah produk harus lebih dari 0.");
            return;
        }
        daftarProdukDijual.put(produk, daftarProdukDijual.getOrDefault(produk, 0) + jumlah);
        recalculateTotal();
        System.out.println("[Order Penjualan] Menambahkan " + jumlah + "x " + produk.getNama() + " ke Order " + idTransaksi);
    }

    private void recalculateTotal() {
        double currentTotal = 0;
        for (Map.Entry<Produk, Integer> entry : daftarProdukDijual.entrySet()) {
            currentTotal += entry.getKey().getHargaJual() * entry.getValue();
        }
        setTotal(currentTotal);
    }

    public double getTotalOrder() {
        return this.total;
    }

    @Override
    public void cetakDokumen() {
        System.out.println("\n--- Order Penjualan ID: " + idTransaksi + " ---");
        System.out.println("Tanggal: " + tanggalTransaksi);
        System.out.println("Pelanggan: " + pelanggan.getNamaMitra());
        System.out.println("Status: " + status);
        System.out.println("Daftar Produk:");
        if (daftarProdukDijual.isEmpty()) {
            System.out.println("  (Belum ada produk)");
        } else {
            daftarProdukDijual.forEach((produk, jumlah) ->
                System.out.println("  - " + produk.getNama() + " (x" + jumlah + ") @ " + String.format("%.2f", produk.getHargaJual()) + " = " + String.format("%.2f", produk.getHargaJual() * jumlah))
            );
        }
        System.out.println("Total Order: " + String.format("%.2f", total));
        System.out.println("-----------------------------------");
    }

    @Override
    public String getDetailTransaksi() {
        return "Order Penjualan ID: " + idTransaksi + ", Total: " + String.format("%.2f", total) + ", Status: " + status + ", Pelanggan: " + pelanggan.getNamaMitra();
    }

    // Data dummy statis
    public static final List<OrderPenjualan> DATA_SAMPLE = new ArrayList<>();

    static {
        // Ambil data mitra dan produk dari DATA_SAMPLE masing-masing
        Mitra mitra1 = paper.model.Mitra.DATA_SAMPLE.get(0);
        Mitra mitra2 = paper.model.Mitra.DATA_SAMPLE.get(1);

        Produk produk1 = paper.model.Produk.DATA_SAMPLE.get(0);
        Produk produk2 = paper.model.Produk.DATA_SAMPLE.get(1);

        // Order 1
        OrderPenjualan order1 = new OrderPenjualan("ORD001", new Date(), mitra1);
        order1.tambahProduk(produk1, 2);

        // Order 2
        OrderPenjualan order2 = new OrderPenjualan("ORD002", new Date(), mitra2);
        order2.tambahProduk(produk2, 3);

        DATA_SAMPLE.add(order1);
        DATA_SAMPLE.add(order2);
    }
}