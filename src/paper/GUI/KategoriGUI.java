package paper.GUI;

import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import paper.model.Kategori;

public class KategoriGUI extends javax.swing.JPanel {
    private List<Kategori> daftarKategori = Kategori.DATA_SAMPLE;
    private DefaultTableModel tableModel;

    public KategoriGUI() {
        initComponents();
        tableModel = new DefaultTableModel(
            new Object[]{"ID", "Nama", "Deskripsi"}, 0
        );
        jTable1.setModel(tableModel);
        refreshTable();

        txtId.setEditable(false);

        btnAdd.addActionListener(e -> {
            String nama = txtNama.getText().trim();
            String desk = txtDesk.getText().trim();
            if (nama.isEmpty() || desk.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nama dan Deskripsi wajib diisi!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            // Tambahkan kategori baru ke DATA_SAMPLE
            Kategori.DATA_SAMPLE.add(new Kategori(nama, desk));
            refreshTable();
            txtId.setText("");
            txtNama.setText("");
            txtDesk.setText("");
            jTable1.clearSelection();
        });

        btnEdit.addActionListener(e -> {
            int selectedRow = jTable1.getSelectedRow();
            if (selectedRow < 0) {
                JOptionPane.showMessageDialog(this, "Pilih baris yang ingin diedit!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String nama = txtNama.getText().trim();
            String desk = txtDesk.getText().trim();
            if (nama.isEmpty() || desk.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nama dan Deskripsi wajib diisi!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            // Edit data pada DATA_SAMPLE
            Kategori kat = Kategori.DATA_SAMPLE.get(selectedRow);
            kat.setNama(nama);
            kat.setDeskripsi(desk);
            refreshTable();
            txtId.setText("");
            txtNama.setText("");
            txtDesk.setText("");
            jTable1.clearSelection();
        });

        btnDelete.addActionListener(e -> {
            int selectedRow = jTable1.getSelectedRow();
            if (selectedRow < 0) {
                JOptionPane.showMessageDialog(this, "Pilih baris yang ingin dihapus!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int confirm = JOptionPane.showConfirmDialog(this, "Yakin ingin menghapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                // Hapus dari DATA_SAMPLE
                Kategori.DATA_SAMPLE.remove(selectedRow);
                refreshTable();
                txtId.setText("");
                txtNama.setText("");
                txtDesk.setText("");
                jTable1.clearSelection();
            }
        });

        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int selectedRow = jTable1.getSelectedRow();
                if (selectedRow >= 0) {
                    Kategori kat = Kategori.DATA_SAMPLE.get(selectedRow);
                    txtId.setText(kat.getIdKategori());
                    txtNama.setText(kat.getNama());
                    txtDesk.setText(kat.getDeskripsi());
                }
            }
        });
    }

    private void refreshTable() {
        tableModel.setRowCount(0);
        for (Kategori k : Kategori.DATA_SAMPLE) {
            tableModel.addRow(new Object[]{k.getIdKategori(), k.getNama(), k.getDeskripsi()});
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        txtDesk = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jLabel1.setText("KATEGORI");
        jLabel2.setText("ID");
        jLabel3.setText("NAMA");
        jLabel4.setText("DESKRIPSI");

        btnAdd.setText("Add");
        btnEdit.setText("Edit");
        btnDelete.setText("Delete");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] { "ID", "Nama", "Deskripsi" }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtId, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(txtNama)
                            .addComponent(txtDesk))))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd)
                    .addComponent(btnEdit)
                    .addComponent(btnDelete))
                .addContainerGap(30, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDesk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            javax.swing.JFrame frame = new javax.swing.JFrame("Manajemen Kategori");
            frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(new KategoriGUI());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    private javax.swing.JLabel jLabel1, jLabel2, jLabel3, jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtId, txtNama, txtDesk;
    private javax.swing.JButton btnAdd, btnEdit, btnDelete;
}
