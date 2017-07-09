/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package belajardatabase.mobil;

import belajardatabase.model.MobilTableModel;
import belajardatabase.utilities.Pagination;
import belajardatabase.utilities.PaginationGUIComponent;
import java.awt.event.ItemEvent;
import java.sql.ResultSet;
import javax.swing.table.TableColumn;

/**
 *
 * @author ASEP
 */
public class view2 extends javax.swing.JPanel {
MobilTableModel model = null;
    Pagination      pagination = null;

    /**
     * Creates new form view
     */
    public view2() {
        initComponents();
        initModel();
        initPagination();
        initTable();
    }
    
    public void initModel() {
        model = new MobilTableModel();
        
        String sign = "USER OPTION";
        
        model.sql.select.whereSegmentStart(sign);
        model.sql.select.where("hargaSewa12Jam", ">=", 0);
        model.sql.select.andWhere("hargaSewa24Jam", ">=", 0);
        model.sql.select.andWhere("status", "=", MobilTableModel.STATUS_TERSEDIA);
        model.sql.select.whereSegmentEnd(sign);
        
        model.sql.select.limit(model.dataPerPage);
        model.sql.select.offset(0);
        
        ResultSet rs = model.sql.select.execute();
        model.save(rs);
    }
    
    
    public void initPagination() {
        pagination = new Pagination();
        pagination.setModel(model);
        pagination.setPageLength(model.dataPerPage);
        pagination.GUIComponent.setLabel(positionPaginationLabel);
        pagination.GUIComponent.setComboBox(paginationComboBox);
        pagination.init();
    }
    
    public void initTable() {
        viewTable.setModel(model);
        
        // leave only 4 column in table
        for (int i = 4; i < 8; i++) {
            TableColumn col = viewTable.getColumnModel().getColumn(4);
            viewTable.getColumnModel().removeColumn(col);
        }
        
        updateTable();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        opsiPanel = new javax.swing.JPanel();
        tableOptionPane = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        option_sewa12JamComboBox = new javax.swing.JComboBox();
        option_sewa12JamField = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        option_sewa24JamComboBox = new javax.swing.JComboBox();
        option_sewa24JamField = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        option_statusComboBox = new javax.swing.JComboBox();
        emptyComboBox = new javax.swing.JComboBox();
        resetButton = new javax.swing.JButton();
        TerapkanButton = new javax.swing.JButton();
        pencarianField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tambahButton = new javax.swing.JButton();
        sewakanButton = new javax.swing.JButton();
        viewScrollPane = new javax.swing.JScrollPane();
        viewTable = new javax.swing.JTable();
        lastPaginationButton = new javax.swing.JButton();
        nextPaginationButton = new javax.swing.JButton();
        paginationComboBox = new javax.swing.JComboBox();
        previousPaginationButton = new javax.swing.JButton();
        firstPaginationButton = new javax.swing.JButton();
        positionPaginationLabel = new javax.swing.JLabel();
        dataDetailPanel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        noPolisiField = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        hargaSewa12JamField = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        merkField = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        hargaSewa24JamField = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        warnaField = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        dendaPerJamField = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        tahunField = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        statusField = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        ubahButton = new javax.swing.JButton();
        hapusButton = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(626, 666));
        setMinimumSize(new java.awt.Dimension(626, 666));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(626, 666));

        opsiPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Opsi"));

        tableOptionPane.setLayout(new java.awt.GridLayout(3, 1, 0, 10));

        jPanel5.setLayout(new java.awt.GridLayout(1, 3, 15, 0));

        jLabel4.setText("Harga Sewa 12 Jam");
        jPanel5.add(jLabel4);

        option_sewa12JamComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ">=", "<=", ">", "<" }));
        jPanel5.add(option_sewa12JamComboBox);

        option_sewa12JamField.setText("0");
        jPanel5.add(option_sewa12JamField);

        tableOptionPane.add(jPanel5);

        jPanel6.setLayout(new java.awt.GridLayout(1, 3, 15, 0));

        jLabel5.setText("Harga Sewa 24 Jam");
        jPanel6.add(jLabel5);

        option_sewa24JamComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ">=", "<=", ">", "<" }));
        jPanel6.add(option_sewa24JamComboBox);

        option_sewa24JamField.setText("0");
        jPanel6.add(option_sewa24JamField);

        tableOptionPane.add(jPanel6);

        jPanel7.setLayout(new java.awt.GridLayout(1, 3, 15, 0));

        jLabel6.setText("Status");
        jPanel7.add(jLabel6);

        option_statusComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tersedia", "Tidak Tersedia" }));
        jPanel7.add(option_statusComboBox);

        emptyComboBox.setVisible(false);
        emptyComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel7.add(emptyComboBox);

        tableOptionPane.add(jPanel7);

        resetButton.setText("Reset");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        TerapkanButton.setText("Terapkan");
        TerapkanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TerapkanButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout opsiPanelLayout = new javax.swing.GroupLayout(opsiPanel);
        opsiPanel.setLayout(opsiPanelLayout);
        opsiPanelLayout.setHorizontalGroup(
            opsiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(opsiPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TerapkanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, opsiPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tableOptionPane, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(224, 224, 224))
        );
        opsiPanelLayout.setVerticalGroup(
            opsiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(opsiPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tableOptionPane, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(opsiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resetButton)
                    .addComponent(TerapkanButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pencarianField.setToolTipText("Kotak Pencarian");
        pencarianField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.lightGray), javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 5), javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 16, new javax.swing.ImageIcon("C:\\Users\\ASEP\\Downloads\\1498141047_icon-111-search.png"))))); // NOI18N
        pencarianField.setMargin(new java.awt.Insets(0, 0, 0, 0));
        pencarianField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pencarianFieldActionPerformed(evt);
            }
        });

        jLabel2.setText("Pencarian :");

        tambahButton.setText("Tambah");

        sewakanButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASEP\\Downloads\\1498309121_system-config-root.png")); // NOI18N
        sewakanButton.setText("Sewakan");
        sewakanButton.setEnabled(false);

        viewTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        viewTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewTableMouseClicked(evt);
            }
        });
        viewScrollPane.setViewportView(viewTable);

        lastPaginationButton.setText(">>");
        lastPaginationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastPaginationButtonActionPerformed(evt);
            }
        });

        nextPaginationButton.setText(">");
        nextPaginationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextPaginationButtonActionPerformed(evt);
            }
        });

        paginationComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                paginationComboBoxItemStateChanged(evt);
            }
        });

        previousPaginationButton.setText("<");
        previousPaginationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousPaginationButtonActionPerformed(evt);
            }
        });

        firstPaginationButton.setText("<<");
        firstPaginationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstPaginationButtonActionPerformed(evt);
            }
        });

        positionPaginationLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        positionPaginationLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        positionPaginationLabel.setText("Halaman 1 dari 200");
        positionPaginationLabel.setAlignmentX(0.5F);

        dataDetailPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Informasi secara Detail"));
        dataDetailPanel.setLayout(new java.awt.GridLayout(5, 2, 40, 10));

        jPanel4.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        jLabel8.setText("No. Polisi");
        jPanel4.add(jLabel8);

        noPolisiField.setEditable(false);
        noPolisiField.setText("Pilih baris data");
        jPanel4.add(noPolisiField);

        dataDetailPanel.add(jPanel4);

        jPanel3.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        jLabel9.setText("Harga Sewa 12 Jam");
        jPanel3.add(jLabel9);

        hargaSewa12JamField.setEditable(false);
        hargaSewa12JamField.setText("Pilih baris data");
        jPanel3.add(hargaSewa12JamField);

        dataDetailPanel.add(jPanel3);

        jPanel2.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        jLabel10.setText("Merk");
        jPanel2.add(jLabel10);

        merkField.setEditable(false);
        merkField.setText("Pilih baris data");
        jPanel2.add(merkField);

        dataDetailPanel.add(jPanel2);

        jPanel11.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        jLabel11.setText("Harga Sewa 24 Jam");
        jPanel11.add(jLabel11);

        hargaSewa24JamField.setEditable(false);
        hargaSewa24JamField.setText("Pilih baris data");
        jPanel11.add(hargaSewa24JamField);

        dataDetailPanel.add(jPanel11);

        jPanel8.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        jLabel12.setText("Warna");
        jPanel8.add(jLabel12);

        warnaField.setEditable(false);
        warnaField.setText("Pilih baris data");
        jPanel8.add(warnaField);

        dataDetailPanel.add(jPanel8);

        jPanel9.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        jLabel13.setText("Denda per Jam");
        jPanel9.add(jLabel13);

        dendaPerJamField.setEditable(false);
        dendaPerJamField.setText("Pilih baris data");
        jPanel9.add(dendaPerJamField);

        dataDetailPanel.add(jPanel9);

        jPanel10.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        jLabel14.setText("Tahun");
        jPanel10.add(jLabel14);

        tahunField.setEditable(false);
        tahunField.setText("Pilih baris data");
        jPanel10.add(tahunField);

        dataDetailPanel.add(jPanel10);

        jPanel12.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        jLabel15.setText("Status");
        jPanel12.add(jLabel15);

        statusField.setEditable(false);
        statusField.setText("Pilih baris data");
        jPanel12.add(statusField);

        dataDetailPanel.add(jPanel12);

        jPanel13.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        ubahButton.setText("Ubah");
        ubahButton.setEnabled(false);
        jPanel13.add(ubahButton);

        hapusButton.setText("Hapus");
        hapusButton.setEnabled(false);
        jPanel13.add(hapusButton);

        dataDetailPanel.add(jPanel13);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pencarianField, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tambahButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sewakanButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(firstPaginationButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(previousPaginationButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(paginationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nextPaginationButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lastPaginationButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(positionPaginationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dataDetailPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(viewScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
                    .addComponent(opsiPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 608, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(opsiPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(pencarianField, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(tambahButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sewakanButton, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(viewScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(previousPaginationButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(firstPaginationButton)
                    .addComponent(paginationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nextPaginationButton)
                    .addComponent(lastPaginationButton)
                    .addComponent(positionPaginationLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dataDetailPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        option_sewa12JamComboBox.setSelectedItem(">=");
        option_sewa12JamField.setText("0");
        option_sewa24JamComboBox.setSelectedItem(">=");
        option_sewa24JamField.setText("0");
        option_statusComboBox.setSelectedItem("Tersedia");
        TerapkanButtonActionPerformed(null);
    }//GEN-LAST:event_resetButtonActionPerformed

    private void TerapkanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TerapkanButtonActionPerformed
        // grab the user option value
        String sewa12JamOperator = option_sewa12JamComboBox
        .getSelectedItem().toString();
        String sewa24JamOperator = option_sewa24JamComboBox
        .getSelectedItem().toString();
        String sewa12Jam = option_sewa12JamField.getText();
        String sewa24Jam = option_sewa24JamField.getText();
        int status = option_statusComboBox.getSelectedItem().toString()
        .equals("Tersedia") ?
        MobilTableModel.STATUS_TERSEDIA :
        MobilTableModel.STATUS_TIDAK_TERSEDIA;;

        // reset
        String sign = "USER OPTION";
        model.sql.select.removeWhereBySegmentSign(sign);

        model.sql.select.whereSegmentStart(sign);
        model.sql.select.where("hargaSewa12Jam", sewa12JamOperator, sewa12Jam);
        model.sql.select.andWhere("hargaSewa24Jam", sewa24JamOperator, sewa24Jam);
        model.sql.select.andWhere("status", "=", status);
        model.sql.select.whereSegmentEnd(sign);

        int newOffset = pagination.isSQLChanged.updatePagination();
        pagination.isSQLChanged.GUIComponent.reinitComboBox();
        pagination.GUIComponent.update();

        model.sql.select.offset(newOffset);
        ResultSet rs = model.sql.select.execute();
        model.save(rs);

        updateTable();
    }//GEN-LAST:event_TerapkanButtonActionPerformed

    private void pencarianFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pencarianFieldActionPerformed
        String searchText = pencarianField.getText();

        // reset where clause
        String sign = "USER SEARCH";
        model.sql.select.removeWhereBySegmentSign(sign);

        model.sql.select.whereSegmentStart(sign);
        model.sql.select.where("noPolisi", "LIKE", "%" + searchText + "%");
        model.sql.select.orWhere("merk", "LIKE", "%" + searchText + "%");
        model.sql.select.whereSegmentEnd(sign);

        int newOffset = pagination.isSQLChanged.updatePagination();
        pagination.isSQLChanged.GUIComponent.reinitComboBox();
        pagination.GUIComponent.update();

        model.sql.select.offset(newOffset);
        ResultSet rs = model.sql.select.execute();
        model.save(rs);

        updateTable();
    }//GEN-LAST:event_pencarianFieldActionPerformed

    private void viewTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewTableMouseClicked
        int row = viewTable.getSelectedRow();

        if (row != -1) {
            String noPolisi = model.getValueAt(row, 0).toString();
            String merk = model.getValueAt(row, 1).toString();
            String warna = model.getValueAt(row, 4).toString();
            String tahun = model.getValueAt(row, 5).toString();
            String hargaSewa12Jam = model.getValueAt(row, 2).toString();
            String hargaSewa24Jam = model.getValueAt(row, 3).toString();
            String dendaPerJam = model.getValueAt(row, 6).toString();
            String status = model.getValueAt(row, 7).toString();

            noPolisiField.setText(noPolisi);
            merkField.setText(merk);
            warnaField.setText(warna);
            tahunField.setText(tahun);
            hargaSewa12JamField.setText(hargaSewa12Jam);
            hargaSewa24JamField.setText(hargaSewa24Jam);
            dendaPerJamField.setText(dendaPerJam);
            statusField.setText(
                Integer.valueOf(status) == MobilTableModel.STATUS_TERSEDIA
                ? "Tersedia" : "Tidak Tersedia"
            );

            sewakanButton.setEnabled(true);
            ubahButton.setEnabled(true);
            hapusButton.setEnabled(true);
        }
    }//GEN-LAST:event_viewTableMouseClicked

    private void lastPaginationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastPaginationButtonActionPerformed
        int newOffset = pagination.jumpToLast();
        pagination.GUIComponent.update();

        model.sql.select.offset(newOffset);
        ResultSet rs = model.sql.select.execute();
        model.save(rs);

        updateTable();
    }//GEN-LAST:event_lastPaginationButtonActionPerformed

    private void nextPaginationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextPaginationButtonActionPerformed
        int newOffset = pagination.moveNext();
        pagination.GUIComponent.update();

        model.sql.select.offset(newOffset);
        ResultSet rs = model.sql.select.execute();
        model.save(rs);

        updateTable();
    }//GEN-LAST:event_nextPaginationButtonActionPerformed

    private void paginationComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_paginationComboBoxItemStateChanged
        if (evt.getStateChange() == ItemEvent.DESELECTED &&
            pagination.GUIComponent.getComboBoxStatus() ==
            PaginationGUIComponent.COMBOBOX_ACCEPT_ANY_ACTION)
        {
            System.out.println("Posisi " + "paginationComboBox");

            int selectedPage = Integer.valueOf(paginationComboBox
                .getSelectedItem()
                .toString());

            int newOffset = pagination.jumpTo(selectedPage);
            pagination.GUIComponent.update();

            model.sql.select.offset(newOffset);
            ResultSet rs = model.sql.select.execute();
            model.save(rs);

            updateTable();

            resetDataDetail();
        }
    }//GEN-LAST:event_paginationComboBoxItemStateChanged

    private void previousPaginationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousPaginationButtonActionPerformed
        int newOffset = pagination.movePrevious();
        pagination.GUIComponent.update();

        model.sql.select.offset(newOffset);
        ResultSet rs = model.sql.select.execute();
        model.save(rs);

        updateTable();
    }//GEN-LAST:event_previousPaginationButtonActionPerformed

    private void firstPaginationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstPaginationButtonActionPerformed
        int newOffset = pagination.jumpToFirst();
        pagination.GUIComponent.update();

        model.sql.select.offset(newOffset);
        ResultSet rs = model.sql.select.execute();
        model.save(rs);

        updateTable();
    }//GEN-LAST:event_firstPaginationButtonActionPerformed

    public void updateTable() {
        model.fireTableDataChanged();
    }
    
    public void resetDataDetail() {
        noPolisiField.setText("Pilih baris data");
        merkField.setText("Pilih baris data");
        warnaField.setText("Pilih baris data");
        tahunField.setText("Pilih baris data");
        hargaSewa12JamField.setText("Pilih baris data");
        hargaSewa24JamField.setText("Pilih baris data");
        dendaPerJamField.setText("Pilih baris data");
        statusField.setText("Pilih baris data");
        ubahButton.setEnabled(false);
        hapusButton.setEnabled(false);
        sewakanButton.setEnabled(false); // buruk, tidak sesuai dengan method
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton TerapkanButton;
    private javax.swing.JPanel dataDetailPanel;
    private javax.swing.JTextField dendaPerJamField;
    private javax.swing.JComboBox emptyComboBox;
    private javax.swing.JButton firstPaginationButton;
    private javax.swing.JButton hapusButton;
    private javax.swing.JTextField hargaSewa12JamField;
    private javax.swing.JTextField hargaSewa24JamField;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JButton lastPaginationButton;
    private javax.swing.JTextField merkField;
    private javax.swing.JButton nextPaginationButton;
    private javax.swing.JTextField noPolisiField;
    private javax.swing.JPanel opsiPanel;
    private javax.swing.JComboBox option_sewa12JamComboBox;
    private javax.swing.JTextField option_sewa12JamField;
    private javax.swing.JComboBox option_sewa24JamComboBox;
    private javax.swing.JTextField option_sewa24JamField;
    private javax.swing.JComboBox option_statusComboBox;
    private javax.swing.JComboBox paginationComboBox;
    private javax.swing.JTextField pencarianField;
    private javax.swing.JLabel positionPaginationLabel;
    private javax.swing.JButton previousPaginationButton;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton sewakanButton;
    private javax.swing.JTextField statusField;
    private javax.swing.JPanel tableOptionPane;
    private javax.swing.JTextField tahunField;
    private javax.swing.JButton tambahButton;
    private javax.swing.JButton ubahButton;
    private javax.swing.JScrollPane viewScrollPane;
    private javax.swing.JTable viewTable;
    private javax.swing.JTextField warnaField;
    // End of variables declaration//GEN-END:variables
}
