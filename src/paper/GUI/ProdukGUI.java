/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package paper.GUI;

import java.util.ArrayList;
import paper.model.Produk;

public class ProdukGUI extends javax.swing.JPanel {
    private ArrayList<Produk> daftarProduk = new ArrayList<>();
    private javax.swing.table.DefaultTableModel tableModel;

    public ProdukGUI() {
        initComponents();
        tableModel = new javax.swing.table.DefaultTableModel(
            new Object[]{"ID", "Nama", "Harga Jual", "Harga Beli", "Deskripsi"}, 0
        );
        jTable1.setModel(tableModel);
        refreshTable();

        jsubmit.addActionListener((java.awt.event.ActionEvent evt) -> {
            // SUBMIT
            String id = jid.getText().trim();
            String nama = jnama.getText().trim();
            String hargaJualStr = jjual.getText().trim();
            String hargaBeliStr = jbeli.getText().trim();
            String deskripsi = jdesk.getText().trim();
            if (id.isEmpty() || nama.isEmpty() || hargaJualStr.isEmpty() || hargaBeliStr.isEmpty() || deskripsi.isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(ProdukGUI.this, "Semua field wajib diisi!", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                return;
            }
            double hargaJual = 0, hargaBeli = 0;
            boolean hargaJualValid = true, hargaBeliValid = true;

            try {
                hargaJual = Double.parseDouble(hargaJualStr);
                if (hargaJual < 0) {
                    javax.swing.JOptionPane.showMessageDialog(
                        ProdukGUI.this,
                        "Harga Jual tidak boleh negatif!\nSilakan masukkan angka 0 atau lebih.",
                        "Input Harga Jual Tidak Valid",
                        javax.swing.JOptionPane.WARNING_MESSAGE
                    );
                    return;
                }
            } catch (NumberFormatException e) {
                hargaJualValid = false;
            }

            try {
                hargaBeli = Double.parseDouble(hargaBeliStr);
                if (hargaBeli < 0) {
                    javax.swing.JOptionPane.showMessageDialog(
                        ProdukGUI.this,
                        "Harga Beli tidak boleh negatif!\nSilakan masukkan angka 0 atau lebih.",
                        "Input Harga Beli Tidak Valid",
                        javax.swing.JOptionPane.WARNING_MESSAGE
                    );
                    return;
                }
            } catch (NumberFormatException e) {
                hargaBeliValid = false;
            }

            // Alert jika salah satu atau kedua harga tidak valid
            if (!hargaJualValid && !hargaBeliValid) {
                javax.swing.JOptionPane.showMessageDialog(
                    ProdukGUI.this,
                    "Harga Jual dan Harga Beli harus berupa angka.\nContoh: 10000 atau 15000.50",
                    "Format Harga Salah",
                    javax.swing.JOptionPane.WARNING_MESSAGE
                );
                return;
            } else if (!hargaJualValid) {
                javax.swing.JOptionPane.showMessageDialog(
                    ProdukGUI.this,
                    "Harga Jual harus berupa angka.\nContoh: 10000 atau 15000.50",
                    "Format Harga Jual Salah",
                    javax.swing.JOptionPane.WARNING_MESSAGE
                );
                return;
            } else if (!hargaBeliValid) {
                javax.swing.JOptionPane.showMessageDialog(
                    ProdukGUI.this,
                    "Harga Beli harus berupa angka.\nContoh: 10000 atau 15000.50",
                    "Format Harga Beli Salah",
                    javax.swing.JOptionPane.WARNING_MESSAGE
                );
                return;
            }
            for (Produk p : daftarProduk) {
                if (p.getIdProduk().equals(id)) {
                    javax.swing.JOptionPane.showMessageDialog(ProdukGUI.this, "ID produk sudah ada!", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            daftarProduk.add(new Produk(id, nama, hargaJual, hargaBeli, deskripsi));
            refreshTable();
            jid.setText("");
            jnama.setText("");
            jjual.setText("");
            jbeli.setText("");
            jdesk.setText("");
        });

        jedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                // EDIT
                int selectedRow = jTable1.getSelectedRow();
                if (selectedRow < 0) {
                    javax.swing.JOptionPane.showMessageDialog(ProdukGUI.this, "Pilih baris yang ingin diedit di tabel!", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String id = jid.getText().trim();
                String nama = jnama.getText().trim();
                String hargaJualStr = jjual.getText().trim();
                String hargaBeliStr = jbeli.getText().trim();
                String deskripsi = jdesk.getText().trim();

                if (id.isEmpty() || nama.isEmpty() || hargaJualStr.isEmpty() || hargaBeliStr.isEmpty() || deskripsi.isEmpty()) {
                    javax.swing.JOptionPane.showMessageDialog(ProdukGUI.this, "Semua field wajib diisi!", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                    return;
                }

                double hargaJual = 0, hargaBeli = 0;
                boolean hargaJualValid = true, hargaBeliValid = true;

                try {
                    hargaJual = Double.parseDouble(hargaJualStr);
                    if (hargaJual < 0) {
                        javax.swing.JOptionPane.showMessageDialog(
                            ProdukGUI.this,
                            "Harga Jual tidak boleh negatif!\nSilakan masukkan angka 0 atau lebih.",
                            "Input Harga Jual Tidak Valid",
                            javax.swing.JOptionPane.WARNING_MESSAGE
                        );
                        return;
                    }
                } catch (NumberFormatException e) {
                    hargaJualValid = false;
                }

                try {
                    hargaBeli = Double.parseDouble(hargaBeliStr);
                    if (hargaBeli < 0) {
                        javax.swing.JOptionPane.showMessageDialog(
                            ProdukGUI.this,
                            "Harga Beli tidak boleh negatif!\nSilakan masukkan angka 0 atau lebih.",
                            "Input Harga Beli Tidak Valid",
                            javax.swing.JOptionPane.WARNING_MESSAGE
                        );
                        return;
                    }
                } catch (NumberFormatException e) {
                    hargaBeliValid = false;
                }

                // Alert jika salah satu atau kedua harga tidak valid
                if (!hargaJualValid && !hargaBeliValid) {
                    javax.swing.JOptionPane.showMessageDialog(
                        ProdukGUI.this,
                        "Harga Jual dan Harga Beli harus berupa angka.\nContoh: 10000 atau 15000.50",
                        "Format Harga Salah",
                        javax.swing.JOptionPane.WARNING_MESSAGE
                    );
                    return;
                } else if (!hargaJualValid) {
                    javax.swing.JOptionPane.showMessageDialog(
                        ProdukGUI.this,
                        "Harga Jual harus berupa angka.\nContoh: 10000 atau 15000.50",
                        "Format Harga Jual Salah",
                        javax.swing.JOptionPane.WARNING_MESSAGE
                    );
                    return;
                } else if (!hargaBeliValid) {
                    javax.swing.JOptionPane.showMessageDialog(
                        ProdukGUI.this,
                        "Harga Beli harus berupa angka.\nContoh: 10000 atau 15000.50",
                        "Format Harga Beli Salah",
                        javax.swing.JOptionPane.WARNING_MESSAGE
                    );
                    return;
                }

                for (int i = 0; i < daftarProduk.size(); i++) {
                    if (i != selectedRow && daftarProduk.get(i).getIdProduk().equals(id)) {
                        javax.swing.JOptionPane.showMessageDialog(ProdukGUI.this, "ID produk sudah ada di baris lain!", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                Produk produk = daftarProduk.get(selectedRow);
                produk.setIdProduk(id);
                produk.setNama(nama);
                produk.setHargaJual(hargaJual);
                produk.setHargaBeli(hargaBeli);
                produk.setDeskripsi(deskripsi);

                refreshTable();
                jid.setText("");
                jnama.setText("");
                jjual.setText("");
                jbeli.setText("");
                jdesk.setText("");
                jTable1.clearSelection();
            }
        });

        jdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                // DELETE
                int selectedRow = jTable1.getSelectedRow();
                if (selectedRow < 0) {
                    javax.swing.JOptionPane.showMessageDialog(ProdukGUI.this, "Pilih baris yang ingin dihapus di tabel!", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                    return;
                }
                int confirm = javax.swing.JOptionPane.showConfirmDialog(
                    ProdukGUI.this,
                    "Yakin ingin menghapus data ini?",
                    "Konfirmasi Hapus",
                    javax.swing.JOptionPane.YES_NO_OPTION
                );
                if (confirm == javax.swing.JOptionPane.YES_OPTION) {
                    daftarProduk.remove(selectedRow);
                    refreshTable();
                    jid.setText("");
                    jnama.setText("");
                    jjual.setText("");
                    jbeli.setText("");
                    jdesk.setText("");
                    jTable1.clearSelection();
                }
            }
        });

        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int selectedRow = jTable1.getSelectedRow();
                if (selectedRow >= 0) {
                    Produk produk = daftarProduk.get(selectedRow);
                    jid.setText(produk.getIdProduk());
                    jnama.setText(produk.getNama());
                    jjual.setText(String.valueOf(produk.getHargaJual()));
                    jbeli.setText(String.valueOf(produk.getHargaBeli()));
                    jdesk.setText(produk.getDeskripsi());
                }
            }
        });
    }

    private void refreshTable() {
        tableModel.setRowCount(0);
        for (Produk p : daftarProduk) {
            tableModel.addRow(new Object[]{
                p.getIdProduk(), p.getNama(), p.getHargaJual(), p.getHargaBeli(), p.getDeskripsi()
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
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jid = new javax.swing.JTextField();
        jnama = new javax.swing.JTextField();
        jjual = new javax.swing.JTextField();
        jbeli = new javax.swing.JTextField();
        jdesk = new javax.swing.JTextField();
        jsubmit = new javax.swing.JButton();
        jedit = new javax.swing.JButton();
        jdelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jLabel1.setText("PRODUK");
        jLabel2.setText("ID");
        jLabel3.setText("NAMA");
        jLabel4.setText("HARGA JUAL");
        jLabel5.setText("HARGA BELI");
        jLabel6.setText("DESKRIPSI");

        jid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                // Kosongkan jika tidak perlu aksi khusus
            }
        });

        jsubmit.setText("submit");
        jedit.setText("edit");
        jdelete.setText("delete");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "ID", "Nama", "Harga Jual", "Harga Beli", "Deskripsi"
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
                        .addGap(150, 150, 150)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jdelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jedit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jsubmit))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jid, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                                    .addComponent(jnama, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jjual, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jbeli, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jdesk, javax.swing.GroupLayout.Alignment.TRAILING))))))
                .addContainerGap(97, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jjual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jbeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jdesk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jsubmit)
                    .addComponent(jedit)
                    .addComponent(jdelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                javax.swing.JFrame frame = new javax.swing.JFrame("Manajemen Produk");
                frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(new ProdukGUI());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jbeli;
    private javax.swing.JButton jdelete;
    private javax.swing.JTextField jdesk;
    private javax.swing.JButton jedit;
    private javax.swing.JTextField jid;
    private javax.swing.JTextField jjual;
    private javax.swing.JTextField jnama;
    private javax.swing.JButton jsubmit;
    // End of variables declaration//GEN-END:variables
}
