/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paper.model;

import java.util.Date;

/**
 *
 * @author hudac
 */
public class KuitansiPembelian {
    private String totalInvoice, newIdKuitansi;

    public KuitansiPembelian(String totalInvoice, String newIdKuitansi) {
        this.totalInvoice = totalInvoice;
        this.newIdKuitansi = newIdKuitansi;
    }
    
    public void verifikasiPembayaran() {
        
    }
//    public String getDetailTransaksi() {
//        return "Kuitansi Pembelian ID: " + idTransaksi + ", Total: " + String.format("%.2f", total) + ", Metode: " + metodePembayaran + ", Tanggal Bayar: " + tanggalBayar;
//    }
}
