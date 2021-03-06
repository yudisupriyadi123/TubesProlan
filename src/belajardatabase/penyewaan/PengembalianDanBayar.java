/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package belajardatabase.penyewaan;

import belajardatabase.model.MobilTableModel;
import belajardatabase.model.PenyewaanTableModel;
import java.sql.ResultSet;
import static belajardatabase.utilities.DateUtility.*;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 * Hanya akan dipanggil oleh pengembalian.java
 * @author ASEP
 */
public class PengembalianDanBayar extends javax.swing.JPanel {
    PenyewaanTableModel penyewaanModel = null;
    MobilTableModel mobilModel = null;
    
    javax.swing.JFrame frame = null;
    private int idSewa = -1;
    private String tanggalKembali = "";
    
    // akan terisi bila hitungBiaya() dipanggil dan digunakan oleh tuntasButton
    private int subtotal = -1;
    private int kenaDenda = -1;
    
    /**
     * Creates new form pengembalianDanBayar
     */
    public PengembalianDanBayar(
            javax.swing.JFrame frame,
            int idSewa,
            String tanggalKembali
    ) {
        this.frame = frame;
        this.idSewa = idSewa;
        this.tanggalKembali = tanggalKembali;
        
        initComponents();
        initModel();
        
        try {
            init(idSewa);
            hitungBiaya(tanggalKembali);
        } catch (Exception e) {
            System.out.println("Error inside `pengembalianDanBayar` : "
                    + e.getMessage());
        }
    }
    
    public void initModel() {
        penyewaanModel = new PenyewaanTableModel();
        mobilModel = new MobilTableModel();
    }
    
    public void init(int idSewa) throws Exception {
        // init penyewaan
        penyewaanModel.sql.select.where("idSewa", "=", idSewa);
        ResultSet rs = penyewaanModel.sql.select.execute();
        penyewaanModel.save(rs);
        penyewaanModel.sql.getConnection().close(rs);
        
        if (penyewaanModel.getRowCount() != 1) {
            throw new Exception("ERROR: sewa dengan id "
                    + idSewa + " tidak ditemukan");
        }
        
        // init mobil
        String noPolisi = penyewaanModel.getValueAt(0, 1).toString();
        mobilModel.sql.select.where("noPolisi", "=", noPolisi);
        rs = mobilModel.sql.select.execute();
        mobilModel.save(rs);
        mobilModel.sql.getConnection().close(rs);            
    }
    
    /**
     * Hitung biaya dan tampilkan ke form
     * 
     * @param tanggalKembali 
     */
    public void hitungBiaya(String tanggalKembali) {
        int hargaSewa24Jam = Integer.valueOf(mobilModel.getValueAt(0, 3).toString());
        int hargaDenda = Integer.valueOf(mobilModel.getValueAt(0, 6).toString());
        String tanggalSewa = penyewaanModel.getValueAt(0, 3).toString();
        String batasKembali = penyewaanModel.getValueAt(0, 4).toString();
        
        subtotal = hitungSubTotal(batasKembali, tanggalSewa, hargaSewa24Jam);
        kenaDenda = hitungDenda(batasKembali, tanggalKembali, hargaSewa24Jam, hargaDenda);
        int total = subtotal + kenaDenda;
        
        subTotalLabel.setText("Rp." + subtotal);
        dendaLabel.setText("Rp." + kenaDenda);
        totalBayarLabel.setText("Rp." + total);
    }
    
    /**
     * 
     * @param batasKembali
     * @param tanggalSewa
     * @param hargaSewa24Jam
     * @return 
     */
    public int hitungSubTotal(
            String batasKembali,
            String tanggalSewa,
            int hargaSewa24Jam
    ) {
        int lamaSewaNormal = getDifferenceBetweenTwoDate(batasKembali,
                tanggalSewa, "dd-MM-yyyy");
        System.out.println("sewaNormal = " + lamaSewaNormal);
        
        return lamaSewaNormal * hargaSewa24Jam;
    }
    
    /**
     * Perhitungan denda:
     *      1 hari telat maka: kenaDenda = 1 * denda
     *      2 hari telat maka: kenaDenda = 1 * denda + (1 * harga sewa normal)
     *      3 hari telat maka: kenaDenda = 1 * denda + (2 * harga sewa normal)
     *      4 hari telat maka: kenaDenda = 1 * denda + (3 * harga sewa normal)
     */
    public int hitungDenda(
            String batasKembali,
            String tanggalKembali,
            int hargaSewa24Jam,
            int denda
    ) {
        int kenaDenda = 0;
        // jumlah hari yang melebihi tanggal batas pengembalian
        int hari = getDifferenceBetweenTwoDate(tanggalKembali,
                batasKembali, "dd-MM-yyyy");
        
        if (hari > 0) {
            kenaDenda += denda;
            hari = hari - 1;
            
            if (hari > 0) kenaDenda += hari * hargaSewa24Jam;
        }
        
        return kenaDenda;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        subTotalLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dendaLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        totalBayarLabel = new javax.swing.JLabel();
        tuntasButton = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();

        setMaximumSize(new java.awt.Dimension(626, 666));
        setMinimumSize(new java.awt.Dimension(626, 666));

        jLabel1.setText("INFORMASI BIAYA");

        jPanel1.setLayout(new java.awt.GridLayout(2, 2, 20, 10));

        jLabel2.setText("Subtotal");
        jPanel1.add(jLabel2);

        subTotalLabel.setText("Rp.0");
        jPanel1.add(subTotalLabel);

        jLabel3.setText("Denda");
        jPanel1.add(jLabel3);

        dendaLabel.setText("Rp.0");
        jPanel1.add(dendaLabel);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("TOTAL BAYAR");

        totalBayarLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        totalBayarLabel.setForeground(new java.awt.Color(255, 51, 51));
        totalBayarLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalBayarLabel.setText("Rp.0000000");

        tuntasButton.setText("SEWA TUNTAS");
        tuntasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tuntasButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(totalBayarLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(264, Short.MAX_VALUE)
                .addComponent(tuntasButton)
                .addGap(259, 259, 259))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(30, 30, 30)
                .addComponent(totalBayarLabel)
                .addGap(34, 34, 34)
                .addComponent(tuntasButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(364, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tuntasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tuntasButtonActionPerformed
        String tglKembaliMysqlDate = convertToMysqlDate(
                tanggalKembali, "dd-MM-yyyy"
        );
        
        penyewaanModel.sql.update.where("idSewa", idSewa);
        penyewaanModel.sql.update.set("tanggalKembali", tglKembaliMysqlDate);
        penyewaanModel.sql.update.set("subTotal", subtotal);
        penyewaanModel.sql.update.set("denda", kenaDenda);
        boolean success1 = penyewaanModel.sql.update.execute();
        
        String noPolisi = mobilModel.getValueAt(0, 0).toString();
        mobilModel.sql.update.where("noPolisi", noPolisi);
        mobilModel.sql.update.set("status", MobilTableModel.STATUS_TERSEDIA);
        boolean success2 = mobilModel.sql.update.execute();
        
        if (success2 == false) System.out.println("Error: success2 gagal");
        
        String pesan = "Gagal menyimpan";
        if (success1) pesan = "Berhasil menyimpan";
        
        JOptionPane.showMessageDialog(frame, pesan);
        
        tuntasButton.setVisible(! success1);
    }//GEN-LAST:event_tuntasButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dendaLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel subTotalLabel;
    private javax.swing.JLabel totalBayarLabel;
    private javax.swing.JButton tuntasButton;
    // End of variables declaration//GEN-END:variables
}
