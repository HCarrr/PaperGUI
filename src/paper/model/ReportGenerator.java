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
import java.util.List;

public class ReportGenerator {
    private String reportId;
    private String reportType;

    public ReportGenerator(String reportId, String reportType) {
        this.reportId = reportId;
        this.reportType = reportType;
    }

    public String generateInventorySummary(List<Produk> products, List<Stok> stockList) {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Inventory Summary ===\n");
        for (Produk produk : products) {
            int totalStok = 0;
            sb.append("Produk: ").append(produk.getNama()).append(" (ID: ").append(produk.getIdProduk()).append(")\n");
            for (Stok stok : stockList) {
                // Asumsi: idProduk dan idStok tidak berelasi langsung, hanya contoh ringkasan stok per lokasi
                sb.append("  Lokasi: ").append(stok.getLokasi())
                  .append(", Jumlah: ").append(stok.getJumlah()).append("\n");
                totalStok += stok.getJumlah();
            }
            sb.append("  Total Stok (semua lokasi): ").append(totalStok).append("\n\n");
        }
        return sb.toString();
    }

    public String generateSalesReport(List<OrderPenjualan> orders) {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Sales Report ===\n");
        sb.append("Jumlah Order: ").append(orders.size()).append("\n");
        double totalPenjualan = 0;
        for (OrderPenjualan order : orders) {
            totalPenjualan += order.getTotal();
        }
        sb.append("Total Penjualan: ").append(totalPenjualan).append("\n\n");
        for (OrderPenjualan order : orders) {
            sb.append("Order ID: ").append(order.getIdTransaksi()).append(", Tanggal: ").append(order.getTanggalTransaksi()).append("\n");
            sb.append("  Pelanggan: ").append(order.getPelanggan() != null ? order.getPelanggan().getNama() : "-").append("\n");
            sb.append("  Produk:\n");
            for (var entry : order.getDaftarProdukDijual().entrySet()) {
                sb.append("    - ").append(entry.getKey().getNama())
                  .append(" x ").append(entry.getValue())
                  .append(" @ ").append(entry.getKey().getHargaJual()).append("\n");
            }
            sb.append("  Total: ").append(order.getTotal()).append("\n");
            sb.append("  Status: ").append(order.getStatus()).append("\n\n");
        }
        return sb.toString();
    }

    public String generatePurchaseReport(List<InvoicePembelian> invoices) {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Purchase Report ===\n");
        sb.append("Jumlah Invoice: ").append(invoices.size()).append("\n");
        double totalPembelian = 0;
        for (InvoicePembelian inv : invoices) {
            totalPembelian += inv.getTotal();
        }
        sb.append("Total Pembelian: ").append(totalPembelian).append("\n\n");
        for (InvoicePembelian inv : invoices) {
            sb.append("Invoice ID: ").append(inv.getIdTransaksi()).append(", Order: ").append(inv.getIdOrder()).append("\n");
            sb.append("  Tanggal: ").append(inv.getTanggalTransaksi()).append(", Jatuh Tempo: ").append(inv.getJatuhTempo()).append("\n");
            sb.append("  Total: ").append(inv.getTotal()).append(", Status: ").append(inv.getStatus()).append("\n\n");
        }
        return sb.toString();
    }

    public String generateTransactionSummary(List<DokumenTransaksi> orders, Date startDate, Date endDate) {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Transaction Summary ===\n");
        sb.append("Periode: ").append(startDate).append(" s/d ").append(endDate).append("\n");
        int count = 0;
        double total = 0;
        for (DokumenTransaksi doc : orders) {
            if (!doc.getTanggalTransaksi().before(startDate) && !doc.getTanggalTransaksi().after(endDate)) {
                count++;
                total += doc.getTotal();
                sb.append("- ID: ").append(doc.getIdTransaksi())
                  .append(", Tanggal: ").append(doc.getTanggalTransaksi())
                  .append(", Total: ").append(doc.getTotal())
                  .append(", Status: ").append(doc.getStatus()).append("\n");
            }
        }
        sb.append("Jumlah Transaksi: ").append(count).append("\n");
        sb.append("Total Nilai Transaksi: ").append(total).append("\n");
        return sb.toString();
    }
}

