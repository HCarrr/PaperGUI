package paper.GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import paper.model.Mitra;

public class MitraFormPanel extends JPanel {
    private JTable TbMitra;
    private DefaultTableModel tableModel;

    public MitraFormPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        tableModel = new DefaultTableModel(
            new Object[]{"Id. Mitra", "Nama", "Alamat", "No. Telepon"}, 0
        );
        TbMitra = new JTable(tableModel);
        refreshTable();
        add(new JScrollPane(TbMitra));
        // Tambahkan komponen form/tombol sesuai kebutuhan
    }

    private void refreshTable() {
        tableModel.setRowCount(0);
        for (Mitra m : paper.model.Mitra.DATA_SAMPLE) {
            tableModel.addRow(new Object[]{
                m.getIdMitra(), m.getNama(), m.getAlamat(), m.getKontak()
            });
        }
    }
}
