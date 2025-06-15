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

public abstract class DokumenTransaksi {
    protected String idTransaksi;
    protected Date tanggalTransaksi;
    protected double total;
    protected String status;

    public DokumenTransaksi(String idTransaksi, Date tanggalTransaksi, double total, String status) {
        this.idTransaksi = idTransaksi;
        this.tanggalTransaksi = tanggalTransaksi;
        this.total = total;
        this.status = status;
    }

    public String getIdTransaksi() {
        return idTransaksi;
    }

    public Date getTanggalTransaksi() {
        return tanggalTransaksi;
    }

    public double getTotal() {
        return total;
    }

    public String getStatus() {
        return status;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public abstract void cetakDokumen();
    public abstract String getDetailTransaksi();
}