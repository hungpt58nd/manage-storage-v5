/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uet;

import javax.swing.JPanel;

/**
 *
 * @author Storm Spirit
 */
public class ManageStore extends javax.swing.JFrame {

    /**
     * Creates new form ManageStore
     */
    public ManageStore() {
        initComponents();
        this.changeView(manageMenu);
    }

    private void changeView(JPanel panel){
        this.manageMenu.setVisible(false);
        this.importMenu.setVisible(false);
        this.exportMenu.setVisible(false);
        this.customerMenu.setVisible(false);
        this.providerMenu.setVisible(false);
        this.statisticMenu.setVisible(false);
        panel.setVisible(true);
        validate();
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        manageMenuBtn = new javax.swing.JButton();
        importMenuBtn = new javax.swing.JButton();
        exportMenuBtn = new javax.swing.JButton();
        customerMenuBtn = new javax.swing.JButton();
        providerMenuBtn = new javax.swing.JButton();
        statisticMenuBtn = new javax.swing.JButton();
        manageMenu = new javax.swing.JPanel();
        nameManageInput = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        codeManageInput = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        typeManageCb = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        providerManageCb = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        priceImportManageInput = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        priceExportManageInput = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        noteManageInput = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        addManageBtn = new javax.swing.JButton();
        editManageBtn = new javax.swing.JButton();
        deleteManageBtn = new javax.swing.JButton();
        manageScrollPane = new javax.swing.JScrollPane();
        manageTable = new javax.swing.JTable();
        importMenu = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        quantityImportInput = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        addImportBtn = new javax.swing.JButton();
        editImportBtn = new javax.swing.JButton();
        deleteImportBtn = new javax.swing.JButton();
        importScrollPane = new javax.swing.JScrollPane();
        importTable = new javax.swing.JTable();
        nameImportCb = new javax.swing.JComboBox<>();
        codeImportCb = new javax.swing.JComboBox<>();
        providerImportCb = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        exportMenu = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        quantityExportInput = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        addExportBtn = new javax.swing.JButton();
        editExportBtn = new javax.swing.JButton();
        deleteExportBtn = new javax.swing.JButton();
        exportScrollPane = new javax.swing.JScrollPane();
        importTable1 = new javax.swing.JTable();
        nameExportCb1 = new javax.swing.JComboBox<>();
        codeExportCb = new javax.swing.JComboBox<>();
        providerExportCb = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        customerMenu = new javax.swing.JPanel();
        nameCustomerInput = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        addressCustomerInput = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        phoneCustomerInput = new javax.swing.JTextField();
        noteCustomerInput = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        addCustomerBtn = new javax.swing.JButton();
        editCustomerBtn = new javax.swing.JButton();
        deleteCustomerBtn = new javax.swing.JButton();
        customerScrollPane = new javax.swing.JScrollPane();
        customerTable = new javax.swing.JTable();
        providerMenu = new javax.swing.JPanel();
        nameProviderInput = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        addressProviderInput = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        phoneProviderInput = new javax.swing.JTextField();
        noteCustomerInput1 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        addCustomerBtn1 = new javax.swing.JButton();
        editProviderBtn = new javax.swing.JButton();
        deleteProviderBtn = new javax.swing.JButton();
        providerScrollPane = new javax.swing.JScrollPane();
        providerTable = new javax.swing.JTable();
        statisticMenu = new javax.swing.JPanel();
        exportStatisticBtn = new javax.swing.JButton();
        importStatisticBtn = new javax.swing.JButton();
        statisticScrollPane = new javax.swing.JScrollPane();
        statisticTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        manageMenuBtn.setText("Quản lí vật tư");
        manageMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageMenuBtnAction(evt);
            }
        });

        importMenuBtn.setText("Nhập kho");
        importMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importMenuBtnAction(evt);
            }
        });

        exportMenuBtn.setText("Xuất kho");
        exportMenuBtn.setToolTipText("");
        exportMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportMenuBtnAction(evt);
            }
        });

        customerMenuBtn.setText("Khách hàng");
        customerMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerMenuBtnAction(evt);
            }
        });

        providerMenuBtn.setText("Nhà cung cấp");
        providerMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                providerMenuBtnAction(evt);
            }
        });

        statisticMenuBtn.setText("Thống kê");
        statisticMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statisticMenuBtnAction(evt);
            }
        });

        nameManageInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameManageInputActionPerformed(evt);
            }
        });

        jLabel1.setText("Tên sản phẩm");

        jLabel2.setText("Mã sản phẩm");

        typeManageCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Đơn vị");

        providerManageCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Nhà cung cấp");

        jLabel5.setText("Giá nhập");

        jLabel6.setText("Giá xuất");

        jLabel7.setText("Ghi chú");

        addManageBtn.setText("Thêm");

        editManageBtn.setText("Sửa");

        deleteManageBtn.setText("Xóa");

        manageTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Tên sản phẩm", "Mã sản phẩm", "Đơn vị", "Nhà cung cấp", "Số lượng", "Giá nhập", "Giá xuất", "Ghi chú"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        manageScrollPane.setViewportView(manageTable);
        if (manageTable.getColumnModel().getColumnCount() > 0) {
            manageTable.getColumnModel().getColumn(0).setPreferredWidth(1);
            manageTable.getColumnModel().getColumn(1).setPreferredWidth(100);
            manageTable.getColumnModel().getColumn(2).setPreferredWidth(80);
            manageTable.getColumnModel().getColumn(3).setPreferredWidth(40);
            manageTable.getColumnModel().getColumn(5).setPreferredWidth(10);
            manageTable.getColumnModel().getColumn(5).setHeaderValue("Tổng tiền");
            manageTable.getColumnModel().getColumn(6).setPreferredWidth(40);
            manageTable.getColumnModel().getColumn(6).setHeaderValue("Ghi chú");
            manageTable.getColumnModel().getColumn(7).setPreferredWidth(40);
            manageTable.getColumnModel().getColumn(8).setPreferredWidth(120);
        }

        javax.swing.GroupLayout manageMenuLayout = new javax.swing.GroupLayout(manageMenu);
        manageMenu.setLayout(manageMenuLayout);
        manageMenuLayout.setHorizontalGroup(
            manageMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageMenuLayout.createSequentialGroup()
                .addGroup(manageMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(nameManageInput, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(manageMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(codeManageInput, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(manageMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(typeManageCb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addComponent(addManageBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
                .addGroup(manageMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(manageMenuLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(manageMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(providerManageCb, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(manageMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(priceImportManageInput, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(manageMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(priceExportManageInput, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(manageMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(manageMenuLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addContainerGap())
                            .addComponent(noteManageInput)))
                    .addGroup(manageMenuLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(editManageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(deleteManageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addComponent(manageScrollPane)
        );
        manageMenuLayout.setVerticalGroup(
            manageMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageMenuLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(manageMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(manageMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameManageInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codeManageInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(typeManageCb, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(providerManageCb, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(priceImportManageInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(priceExportManageInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(noteManageInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(manageMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addManageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editManageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteManageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(manageScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE))
        );

        jLabel8.setText("Tên sản phẩm");

        jLabel9.setText("Mã sản phẩm");

        jLabel12.setText("Số lượng");

        addImportBtn.setText("Thêm");

        editImportBtn.setText("Sửa");

        deleteImportBtn.setText("Xóa");

        importTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Tên sản phẩm", "Mã sản phẩm", "Đơn vị", "Nhà cung cấp", "Số lượng", "Giá nhập", "Giá xuất", "Ghi chú"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        importScrollPane.setViewportView(importTable);
        if (importTable.getColumnModel().getColumnCount() > 0) {
            importTable.getColumnModel().getColumn(0).setPreferredWidth(1);
            importTable.getColumnModel().getColumn(1).setPreferredWidth(100);
            importTable.getColumnModel().getColumn(2).setPreferredWidth(80);
            importTable.getColumnModel().getColumn(3).setPreferredWidth(40);
            importTable.getColumnModel().getColumn(5).setPreferredWidth(10);
            importTable.getColumnModel().getColumn(6).setPreferredWidth(40);
            importTable.getColumnModel().getColumn(7).setPreferredWidth(40);
            importTable.getColumnModel().getColumn(8).setPreferredWidth(120);
        }

        nameImportCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        codeImportCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        providerImportCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel10.setText("Nhà cung cấp");

        javax.swing.GroupLayout importMenuLayout = new javax.swing.GroupLayout(importMenu);
        importMenu.setLayout(importMenuLayout);
        importMenuLayout.setHorizontalGroup(
            importMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(importScrollPane)
            .addGroup(importMenuLayout.createSequentialGroup()
                .addGroup(importMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(importMenuLayout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addGroup(importMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, importMenuLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(143, 143, 143))
                            .addComponent(nameImportCb, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(importMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(codeImportCb, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(importMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(quantityImportInput, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(25, 25, 25)
                        .addGroup(importMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(providerImportCb, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addGroup(importMenuLayout.createSequentialGroup()
                        .addGap(308, 308, 308)
                        .addComponent(addImportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(editImportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(deleteImportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 168, Short.MAX_VALUE))
        );
        importMenuLayout.setVerticalGroup(
            importMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(importMenuLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(importMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel12)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(importMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quantityImportInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameImportCb, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codeImportCb, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(providerImportCb, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(importMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addImportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editImportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteImportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(importScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE))
        );

        jLabel11.setText("Tên sản phẩm");

        jLabel13.setText("Mã sản phẩm");

        jLabel14.setText("Số lượng");

        addExportBtn.setText("Thêm");

        editExportBtn.setText("Sửa");

        deleteExportBtn.setText("Xóa");

        importTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Tên sản phẩm", "Mã sản phẩm", "Đơn vị", "Nhà cung cấp", "Số lượng", "Giá nhập", "Giá xuất", "Ghi chú"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        exportScrollPane.setViewportView(importTable1);
        if (importTable1.getColumnModel().getColumnCount() > 0) {
            importTable1.getColumnModel().getColumn(0).setPreferredWidth(1);
            importTable1.getColumnModel().getColumn(1).setPreferredWidth(100);
            importTable1.getColumnModel().getColumn(2).setPreferredWidth(80);
            importTable1.getColumnModel().getColumn(3).setPreferredWidth(40);
            importTable1.getColumnModel().getColumn(5).setPreferredWidth(10);
            importTable1.getColumnModel().getColumn(6).setPreferredWidth(40);
            importTable1.getColumnModel().getColumn(7).setPreferredWidth(40);
            importTable1.getColumnModel().getColumn(8).setPreferredWidth(120);
        }

        nameExportCb1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        codeExportCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        providerExportCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel15.setText("Nhà cung cấp");

        javax.swing.GroupLayout exportMenuLayout = new javax.swing.GroupLayout(exportMenu);
        exportMenu.setLayout(exportMenuLayout);
        exportMenuLayout.setHorizontalGroup(
            exportMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exportScrollPane)
            .addGroup(exportMenuLayout.createSequentialGroup()
                .addGroup(exportMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(exportMenuLayout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addGroup(exportMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, exportMenuLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(143, 143, 143))
                            .addComponent(nameExportCb1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(exportMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(codeExportCb, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(exportMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(quantityExportInput, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(25, 25, 25)
                        .addGroup(exportMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(providerExportCb, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)))
                    .addGroup(exportMenuLayout.createSequentialGroup()
                        .addGap(308, 308, 308)
                        .addComponent(addExportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(editExportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(deleteExportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 164, Short.MAX_VALUE))
        );
        exportMenuLayout.setVerticalGroup(
            exportMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(exportMenuLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(exportMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(exportMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quantityExportInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameExportCb1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codeExportCb, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(providerExportCb, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(exportMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addExportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editExportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteExportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(exportScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE))
        );

        jLabel16.setText("Tên khách hàng");

        jLabel17.setText("Địa chỉ");

        jLabel18.setText("Điện thoại");

        jLabel22.setText("Ghi chú");

        addCustomerBtn.setText("Thêm");

        editCustomerBtn.setText("Sửa");

        deleteCustomerBtn.setText("Xóa");

        customerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Tên khách hàng", "Địa chỉ", "Số điện thoại", "Ngày tạo", "Tổng tiền", "Ghi chú"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        customerScrollPane.setViewportView(customerTable);
        if (customerTable.getColumnModel().getColumnCount() > 0) {
            customerTable.getColumnModel().getColumn(0).setPreferredWidth(1);
            customerTable.getColumnModel().getColumn(1).setPreferredWidth(100);
            customerTable.getColumnModel().getColumn(2).setPreferredWidth(80);
            customerTable.getColumnModel().getColumn(3).setPreferredWidth(40);
            customerTable.getColumnModel().getColumn(5).setPreferredWidth(10);
            customerTable.getColumnModel().getColumn(5).setHeaderValue("Tổng tiền");
            customerTable.getColumnModel().getColumn(6).setPreferredWidth(40);
            customerTable.getColumnModel().getColumn(6).setHeaderValue("Ghi chú");
        }

        javax.swing.GroupLayout customerMenuLayout = new javax.swing.GroupLayout(customerMenu);
        customerMenu.setLayout(customerMenuLayout);
        customerMenuLayout.setHorizontalGroup(
            customerMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerMenuLayout.createSequentialGroup()
                .addGap(305, 305, 305)
                .addComponent(addCustomerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(editCustomerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(deleteCustomerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(customerScrollPane)
            .addGroup(customerMenuLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(customerMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(nameCustomerInput, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(customerMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(customerMenuLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(190, 190, 190))
                    .addComponent(addressCustomerInput, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(customerMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(phoneCustomerInput, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(customerMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(noteCustomerInput, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67))
        );
        customerMenuLayout.setVerticalGroup(
            customerMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerMenuLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(customerMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(customerMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameCustomerInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addressCustomerInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phoneCustomerInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(noteCustomerInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(customerMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addCustomerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editCustomerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteCustomerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(customerScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE))
        );

        jLabel19.setText("Tên nhà cung cấp");

        jLabel20.setText("Địa chỉ");

        jLabel21.setText("Điện thoại");

        jLabel23.setText("Ghi chú");

        addCustomerBtn1.setText("Thêm");

        editProviderBtn.setText("Sửa");

        deleteProviderBtn.setText("Xóa");

        providerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Tên nhà cung cấp", "Địa chỉ", "Số điện thoại", "Ngày tạo", "Tổng tiền", "Ghi chú"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        providerScrollPane.setViewportView(providerTable);
        if (providerTable.getColumnModel().getColumnCount() > 0) {
            providerTable.getColumnModel().getColumn(0).setPreferredWidth(1);
            providerTable.getColumnModel().getColumn(1).setPreferredWidth(100);
            providerTable.getColumnModel().getColumn(2).setPreferredWidth(80);
            providerTable.getColumnModel().getColumn(3).setPreferredWidth(40);
            providerTable.getColumnModel().getColumn(5).setPreferredWidth(10);
            providerTable.getColumnModel().getColumn(5).setHeaderValue("Tổng tiền");
            providerTable.getColumnModel().getColumn(6).setPreferredWidth(40);
            providerTable.getColumnModel().getColumn(6).setHeaderValue("Ghi chú");
        }

        javax.swing.GroupLayout providerMenuLayout = new javax.swing.GroupLayout(providerMenu);
        providerMenu.setLayout(providerMenuLayout);
        providerMenuLayout.setHorizontalGroup(
            providerMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(providerMenuLayout.createSequentialGroup()
                .addGap(305, 305, 305)
                .addComponent(addCustomerBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(editProviderBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(deleteProviderBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(providerScrollPane)
            .addGroup(providerMenuLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(providerMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(nameProviderInput, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(providerMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel20)
                    .addComponent(addressProviderInput, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(providerMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(phoneProviderInput, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(providerMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(noteCustomerInput1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67))
        );
        providerMenuLayout.setVerticalGroup(
            providerMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(providerMenuLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(providerMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(providerMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameProviderInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addressProviderInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phoneProviderInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(noteCustomerInput1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(providerMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addCustomerBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editProviderBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteProviderBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(providerScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE))
        );

        exportStatisticBtn.setText("Thống kê xuất hàng");
        exportStatisticBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportStatisticBtnActionPerformed(evt);
            }
        });

        importStatisticBtn.setText("Thống kê nhập hàng");

        statisticTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Tên", "Mã hàng", "Số lượng", "Tổng tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        statisticScrollPane.setViewportView(statisticTable);
        if (statisticTable.getColumnModel().getColumnCount() > 0) {
            statisticTable.getColumnModel().getColumn(0).setPreferredWidth(1);
            statisticTable.getColumnModel().getColumn(1).setPreferredWidth(100);
            statisticTable.getColumnModel().getColumn(2).setPreferredWidth(80);
            statisticTable.getColumnModel().getColumn(3).setPreferredWidth(40);
        }

        javax.swing.GroupLayout statisticMenuLayout = new javax.swing.GroupLayout(statisticMenu);
        statisticMenu.setLayout(statisticMenuLayout);
        statisticMenuLayout.setHorizontalGroup(
            statisticMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statisticScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
            .addGroup(statisticMenuLayout.createSequentialGroup()
                .addGap(287, 287, 287)
                .addComponent(exportStatisticBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83)
                .addComponent(importStatisticBtn)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        statisticMenuLayout.setVerticalGroup(
            statisticMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statisticMenuLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(statisticMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exportStatisticBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(importStatisticBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addComponent(statisticScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(manageMenuBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(importMenuBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(exportMenuBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(customerMenuBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(providerMenuBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(statisticMenuBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(manageMenu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(importMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(exportMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(14, 14, 14)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(customerMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(providerMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(statisticMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(manageMenuBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(importMenuBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(exportMenuBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(customerMenuBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(providerMenuBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(statisticMenuBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(manageMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(71, 71, 71)
                    .addComponent(importMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(exportMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(74, 74, 74)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(69, 69, 69)
                    .addComponent(customerMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(21, 21, 21)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(79, 79, 79)
                    .addComponent(providerMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(69, 69, 69)
                    .addComponent(statisticMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(21, 21, 21)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void manageMenuBtnAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageMenuBtnAction
        this.changeView(manageMenu);
    }//GEN-LAST:event_manageMenuBtnAction

    private void importMenuBtnAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importMenuBtnAction
        this.changeView(importMenu);
    }//GEN-LAST:event_importMenuBtnAction

    private void exportMenuBtnAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportMenuBtnAction
        this.changeView(exportMenu);
    }//GEN-LAST:event_exportMenuBtnAction

    private void customerMenuBtnAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerMenuBtnAction
        this.changeView(customerMenu);
    }//GEN-LAST:event_customerMenuBtnAction

    private void providerMenuBtnAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_providerMenuBtnAction
        this.changeView(providerMenu);
    }//GEN-LAST:event_providerMenuBtnAction

    private void statisticMenuBtnAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statisticMenuBtnAction
        this.changeView(statisticMenu);
    }//GEN-LAST:event_statisticMenuBtnAction

    private void nameManageInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameManageInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameManageInputActionPerformed

    private void exportStatisticBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportStatisticBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_exportStatisticBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManageStore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageStore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageStore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageStore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageStore().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCustomerBtn;
    private javax.swing.JButton addCustomerBtn1;
    private javax.swing.JButton addExportBtn;
    private javax.swing.JButton addImportBtn;
    private javax.swing.JButton addManageBtn;
    private javax.swing.JTextField addressCustomerInput;
    private javax.swing.JTextField addressProviderInput;
    private javax.swing.JComboBox<String> codeExportCb;
    private javax.swing.JComboBox<String> codeImportCb;
    private javax.swing.JTextField codeManageInput;
    private javax.swing.JPanel customerMenu;
    private javax.swing.JButton customerMenuBtn;
    private javax.swing.JScrollPane customerScrollPane;
    private javax.swing.JTable customerTable;
    private javax.swing.JButton deleteCustomerBtn;
    private javax.swing.JButton deleteExportBtn;
    private javax.swing.JButton deleteImportBtn;
    private javax.swing.JButton deleteManageBtn;
    private javax.swing.JButton deleteProviderBtn;
    private javax.swing.JButton editCustomerBtn;
    private javax.swing.JButton editExportBtn;
    private javax.swing.JButton editImportBtn;
    private javax.swing.JButton editManageBtn;
    private javax.swing.JButton editProviderBtn;
    private javax.swing.JPanel exportMenu;
    private javax.swing.JButton exportMenuBtn;
    private javax.swing.JScrollPane exportScrollPane;
    private javax.swing.JButton exportStatisticBtn;
    private javax.swing.JPanel importMenu;
    private javax.swing.JButton importMenuBtn;
    private javax.swing.JScrollPane importScrollPane;
    private javax.swing.JButton importStatisticBtn;
    private javax.swing.JTable importTable;
    private javax.swing.JTable importTable1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel manageMenu;
    private javax.swing.JButton manageMenuBtn;
    private javax.swing.JScrollPane manageScrollPane;
    private javax.swing.JTable manageTable;
    private javax.swing.JTextField nameCustomerInput;
    private javax.swing.JComboBox<String> nameExportCb1;
    private javax.swing.JComboBox<String> nameImportCb;
    private javax.swing.JTextField nameManageInput;
    private javax.swing.JTextField nameProviderInput;
    private javax.swing.JTextField noteCustomerInput;
    private javax.swing.JTextField noteCustomerInput1;
    private javax.swing.JTextField noteManageInput;
    private javax.swing.JTextField phoneCustomerInput;
    private javax.swing.JTextField phoneProviderInput;
    private javax.swing.JTextField priceExportManageInput;
    private javax.swing.JTextField priceImportManageInput;
    private javax.swing.JComboBox<String> providerExportCb;
    private javax.swing.JComboBox<String> providerImportCb;
    private javax.swing.JComboBox<String> providerManageCb;
    private javax.swing.JPanel providerMenu;
    private javax.swing.JButton providerMenuBtn;
    private javax.swing.JScrollPane providerScrollPane;
    private javax.swing.JTable providerTable;
    private javax.swing.JTextField quantityExportInput;
    private javax.swing.JTextField quantityImportInput;
    private javax.swing.JPanel statisticMenu;
    private javax.swing.JButton statisticMenuBtn;
    private javax.swing.JScrollPane statisticScrollPane;
    private javax.swing.JTable statisticTable;
    private javax.swing.JComboBox<String> typeManageCb;
    // End of variables declaration//GEN-END:variables
}
