// IPembayaran.java
package paper.payment;

import paper.transaction.Kuitansi; // Import Kuitansi dari paket transaction
import paper.transaction.Kuitansi;

public interface IPembayaran {
    double hitungTotal();
    boolean prosesPembayaran();
    Kuitansi generateKuitansi();
}