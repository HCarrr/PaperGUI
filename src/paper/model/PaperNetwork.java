// PaperNetwork.java
package paper.model;

import java.util.ArrayList;
import java.util.List;

public class PaperNetwork {
    private String idPaper;
    private String jenisPaper;
    private boolean statusValidasi;

    public static final List<PaperNetwork> dataPaperNetwork = new ArrayList<>();

    static {
        // Data contoh awal
        dataPaperNetwork.add(new PaperNetwork("PN001", "Jenis A", true));
        dataPaperNetwork.add(new PaperNetwork("PN002", "Jenis B", false));
        dataPaperNetwork.add(new PaperNetwork("PN003", "Jenis C", true));
    }

    public PaperNetwork(String idPaper, String jenisPaper, boolean statusValidasi) {
        this.idPaper = idPaper;
        this.jenisPaper = jenisPaper;
        this.statusValidasi = statusValidasi;
    }

    public String getIdPaper() {
        return idPaper;
    }

    public String getJenisPaper() {
        return jenisPaper;
    }

    public boolean isStatusValidasi() {
        return statusValidasi;
    }

    public void validasiPaper() {
        if (!this.statusValidasi) {
            this.statusValidasi = true;
            System.out.println("[PaperNetwork] Paper '" + idPaper + "' (" + jenisPaper + ") berhasil divalidasi.");
        } else {
            System.out.println("[PaperNetwork] Paper '" + idPaper + "' sudah divalidasi sebelumnya.");
        }
    }
}