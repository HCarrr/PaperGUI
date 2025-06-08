/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paper.model;

import java.util.Date;
import paper.transaction.DokumenTransaksi;

/**
 *
 * @author hudac
 */
public class InvoicePenjualan extends DokumenTransaksi{
    private String idOrder;
    private Date jatuhTempo;

    public InvoicePenjualan(String idTransaksi, Date tanggalTransaksi, double total, String status, String idOrder, Date jatuhTempo) {
        super(idTransaksi, tanggalTransaksi, total, status); 
        this.idOrder = idOrder;
        this.jatuhTempo = jatuhTempo;
    }

    public String getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
    }

    public Date getJatuhTempo() {
        return jatuhTempo;
    }

    public void setJatuhTempo(Date jatuhTempo) {
        this.jatuhTempo = jatuhTempo;
    }

    @Override
    public String getDetailTransaksi() {
        return "Invoice Pembelian:\n" +
               "Order: " + idOrder + "\n" +
               "Jatuh Tempo: " + jatuhTempo + "\n" +
               "Total: " + total + "\n" +
               "Status: " + status;
    }

    @Override
    public void cetakDokumen() {
        System.out.println("===== INVOICE PEMBELIAN =====");
        System.out.println("ID Transaksi   : " + idTransaksi);
        System.out.println("Tanggal        : " + tanggalTransaksi);
        System.out.println("Order          : " + idOrder);
        System.out.println("Jatuh Tempo    : " + jatuhTempo);
        System.out.println("Total          : " + total);
        System.out.println("Status         : " + status);
    }
}
