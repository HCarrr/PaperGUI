/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package paper.GUI;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import paper.model.Stok;

public class StokGUI extends javax.swing.JPanel {
    // private java.util.List<Stok> daftarStok = paper.model.Stok.DATA_SAMPLE;
    // Ganti dengan akses langsung ke Stok.getStokList()
    private DefaultTableModel tableModel;

    public StokGUI() {
        initComponents();
        tableModel = new DefaultTableModel(
            new Object[]{"ID", "Jumlah", "Lokasi"}, 0
        );
        jTable1.setModel(tableModel);
        refreshTable();

        ids.setEditable(false); // Pastikan field ID tidak bisa diisi user
        ids.setText(""); // Selalu kosongkan field ID saat tambah data baru

        jsubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                // String id = ids.getText().trim(); // Tidak perlu ambil ID dari input
                String jumlahStr = jumlahs.getText().trim();
                String lokasi = lokasis.getText().trim();

                if (jumlahStr.isEmpty() || lokasi.isEmpty()) {
                    JOptionPane.showMessageDialog(StokGUI.this, "Jumlah dan lokasi wajib diisi!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int jumlah = 0;
                boolean jumlahValid = true;
                try {
                    jumlah = Integer.parseInt(jumlahStr);
                    if (jumlah < 0) {
                        JOptionPane.showMessageDialog(StokGUI.this, "Jumlah tidak boleh negatif!", "Input Jumlah Tidak Valid", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                } catch (NumberFormatException e) {
                    jumlahValid = false;
                }

                if (!jumlahValid) {
                    JOptionPane.showMessageDialog(StokGUI.this, "Jumlah harus berupa angka bulat.\nContoh: 10 atau 25", "Format Jumlah Salah", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // Tidak perlu cek duplikasi ID karena ID auto-generated

                paper.model.Stok.addStok(new Stok(jumlah, lokasi));
                refreshTable();
                ids.setText(""); // Kosongkan field ID setelah tambah
                jumlahs.setText("");
                lokasis.setText("");
            }
        });

        jedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int selectedRow = jTable1.getSelectedRow();
                if (selectedRow < 0) {
                    JOptionPane.showMessageDialog(StokGUI.this, "Pilih baris yang ingin diedit di tabel!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                // String id = ids.getText().trim(); // ID tidak boleh diedit
                String jumlahStr = jumlahs.getText().trim();
                String lokasi = lokasis.getText().trim();

                if (jumlahStr.isEmpty() || lokasi.isEmpty()) {
                    JOptionPane.showMessageDialog(StokGUI.this, "Jumlah dan lokasi wajib diisi!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int jumlah = 0;
                boolean jumlahValid = true;
                try {
                    jumlah = Integer.parseInt(jumlahStr);
                    if (jumlah < 0) {
                        JOptionPane.showMessageDialog(StokGUI.this, "Jumlah tidak boleh negatif!", "Input Jumlah Tidak Valid", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                } catch (NumberFormatException e) {
                    jumlahValid = false;
                }

                if (!jumlahValid) {
                    JOptionPane.showMessageDialog(StokGUI.this, "Jumlah harus berupa angka bulat.\nContoh: 10 atau 25", "Format Jumlah Salah", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // Tidak perlu cek duplikasi ID

                Stok stok = paper.model.Stok.getStokList().get(selectedRow);
                stok.setJumlah(jumlah);
                stok.setLokasi(lokasi);
                refreshTable();
                ids.setText(""); // Kosongkan field ID setelah edit/hapus
                jumlahs.setText("");
                lokasis.setText("");
                jTable1.clearSelection();
            }
        });

        jdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int selectedRow = jTable1.getSelectedRow();
                if (selectedRow < 0) {
                    JOptionPane.showMessageDialog(StokGUI.this, "Pilih baris yang ingin dihapus di tabel!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                int confirm = JOptionPane.showConfirmDialog(
                    StokGUI.this,
                    "Yakin ingin menghapus data ini?",
                    "Konfirmasi Hapus",
                    JOptionPane.YES_NO_OPTION
                );
                if (confirm == JOptionPane.YES_OPTION) {
                    Stok stok = paper.model.Stok.getStokList().get(selectedRow);
                    paper.model.Stok.removeStok(stok);
                    refreshTable();
                    ids.setText(""); // Kosongkan field ID setelah edit/hapus
                    jumlahs.setText("");
                    lokasis.setText("");
                    jTable1.clearSelection();
                }
            }
        });

        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int selectedRow = jTable1.getSelectedRow();
                if (selectedRow >= 0) {
                    Stok stok = paper.model.Stok.getStokList().get(selectedRow);
                    ids.setText(stok.getIdStok());
                    jumlahs.setText(String.valueOf(stok.getJumlah()));
                    lokasis.setText(stok.getLokasi());
                }
            }
        });
    }

    private void refreshTable() {
        tableModel.setRowCount(0);
        for (Stok s : paper.model.Stok.getStokList()) {
            tableModel.addRow(new Object[]{
                s.getIdStok(), s.getJumlah(), s.getLokasi()
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ids = new javax.swing.JTextField();
        jumlahs = new javax.swing.JTextField();
        lokasis = new javax.swing.JTextField();
        jdelete = new javax.swing.JButton();
        jedit = new javax.swing.JButton();
        jsubmit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jLabel1.setText("STOK");

        jLabel2.setText("ID");

        jLabel3.setText("JUMLAH");

        jLabel4.setText("LOKASI");

        ids.setEditable(false);

        jdelete.setText("delete");

        jedit.setText("edit");

        jsubmit.setText("submit");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jdelete)
                                .addGap(18, 18, 18)
                                .addComponent(jedit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jsubmit))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(122, 122, 122)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lokasis, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jumlahs, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ids, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(84, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ids, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jumlahs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lokasis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jdelete)
                    .addComponent(jedit)
                    .addComponent(jsubmit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            javax.swing.JFrame frame = new javax.swing.JFrame("Manajemen Stok");
            frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(new StokGUI());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }
    });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ids;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jdelete;
    private javax.swing.JButton jedit;
    private javax.swing.JButton jsubmit;
    private javax.swing.JTextField jumlahs;
    private javax.swing.JTextField lokasis;
    // End of variables declaration//GEN-END:variables
}