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
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class OrderPenjualan extends DokumenTransaksi {
    public static final List<OrderPenjualan> dataOrderPenjualan = new ArrayList<>();
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
        sb.append("Pelanggan: ").append(pelanggan != null ? pelanggan.getNama() : "-").append("\n");
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

    static {
        // Contoh data awal dengan id random
        Mitra pelanggan1 = new Mitra("M001", "Mitra Satu", "Jl. Mawar 1", "08123456789");
        Mitra pelanggan2 = new Mitra("M002", "Mitra Dua", "Jl. Melati 2", "08234567890");
        Mitra pelanggan3 = new Mitra("M003", "Mitra Tiga", "Jl. Kenanga 3", "08345678901");

        OrderPenjualan op1 = new OrderPenjualan(UUID.randomUUID().toString(), new java.util.Date(), 0, pelanggan1);
        op1.tambahProduk(new Produk("P001", "Kertas HVS A4", 50000, 40000, "Kertas HVS ukuran A4 70gsm"), 2);

        OrderPenjualan op2 = new OrderPenjualan(UUID.randomUUID().toString(), new java.util.Date(), 0, pelanggan2);
        op2.tambahProduk(new Produk("P002", "Pulpen Biru", 3500, 2000, "Pulpen tinta biru"), 10);

        OrderPenjualan op3 = new OrderPenjualan(UUID.randomUUID().toString(), new java.util.Date(), 0, pelanggan3);
        op3.tambahProduk(new Produk("P003", "Map Plastik", 2000, 1000, "Map plastik warna-warni"), 5);

        dataOrderPenjualan.clear();
        dataOrderPenjualan.add(op1);
        dataOrderPenjualan.add(op2);
        dataOrderPenjualan.add(op3);
    }
}