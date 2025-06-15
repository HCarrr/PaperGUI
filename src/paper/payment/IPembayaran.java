// IPembayaran.java
package paper.payment;


public interface IPembayaran {
    double hitungTotal();
    boolean prosesPembayaran();
    void generateKuitansi();
}