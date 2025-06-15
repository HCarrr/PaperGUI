/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paper.model;

/**
 *
 * @author hudac
 */
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class OrderPenjualan extends DokumenTransaksi {
    private Map<Produk, Integer> daftarProdukDijual = new HashMap<>();
    private Mitra pelanggan;

    public OrderPenjualan(String idTransaksi, Date tanggalTransaksi, double total, Mitra pelanggan) {
        super(idTransaksi, tanggalTransaksi, total, "Menunggu");
        this.pelanggan = pelanggan;
    }

    public void tambahProduk(Produk produk, int jumlah) {
        daftarProdukDijual.put(produk, daftarProdukDijual.getOrDefault(produk, 0) + jumlah);
        recalculateTotal();
    }

    public void recalculateTotal() {
        double total = 0;
        for (Map.Entry<Produk, Integer> entry : daftarProdukDijual.entrySet()) {
            total += entry.getKey().getHargaJual() * entry.getValue();
        }
        setTotal(total);
    }

    public Map<Produk, Integer> getDaftarProdukDijual() {
        return daftarProdukDijual;
    }

    public Mitra getPelanggan() {
        return pelanggan;
    }

    @Override
    public void cetakDokumen() {
        System.out.println(getDetailTransaksi());
    }

    @Override
    public String getDetailTransaksi() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order ID: ").append(idTransaksi).append("\n");
        sb.append("Tanggal: ").append(tanggalTransaksi).append("\n");
        sb.append("Pelanggan: ").append(pelanggan.getNama()).append("\n");
        sb.append("Produk Dijual:\n");
        for (Map.Entry<Produk, Integer> entry : daftarProdukDijual.entrySet()) {
            sb.append("- ").append(entry.getKey().getNama())
              .append(" x ").append(entry.getValue())
              .append(" @ ").append(entry.getKey().getHargaJual()).append("\n");
        }
        sb.append("Total: ").append(total).append("\n");
        sb.append("Status: ").append(status);
        return sb.toString();
    }
}