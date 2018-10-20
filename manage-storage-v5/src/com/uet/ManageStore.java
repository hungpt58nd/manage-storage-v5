/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uet;

import com.uet.dao.DataLoader;
import com.uet.model.ItemEntity;
import com.uet.model.PersonEntity;
import com.uet.model.StorageEntity;
import com.uet.service.ItemService;
import com.uet.service.PersonService;
import com.uet.service.StorageService;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Storm Spirit
 */
public class ManageStore extends javax.swing.JFrame {

    private DataLoader dataLoader = new DataLoader();
    private StorageService importService = new StorageService(dataLoader, "IMPORT");
    private StorageService exportService = new StorageService(dataLoader, "EXPORT");
    private PersonService customerService = new PersonService(dataLoader, "CUSTOMER");
    private PersonService providerService = new PersonService(dataLoader,"PROVIDER");
    private ItemService itemService = new ItemService(dataLoader);

    private List<PersonEntity> customers = new ArrayList<>();
    private List<PersonEntity> providers = new ArrayList<>();
    private List<StorageEntity> imports = new ArrayList<StorageEntity>();
    private List<StorageEntity> exports = new ArrayList<StorageEntity>();
    private List<ItemEntity> items = new ArrayList<>();
    private List<StorageEntity> statistics = new ArrayList<>();
    
    private Object[][] storageObj;
    private Object[][] personObj;
    private Object[][] itemObj;
    private Object[][] statisticObj;

    private boolean flagImport = false;
    private boolean flagExport = false;

    private int selectedIndex = -1;

    public ManageStore() {
        initComponents();
        initData();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }   
    
    private void initData(){
        this.changeView(manageMenu);

        try {
            imports = importService.convertData();
            exports = exportService.convertData();
            customers = customerService.convertData();
            providers = providerService.convertData();
            items = itemService.convertData();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        renderManageTable();
    }

    private void selectedCustomerRow(){
        customerTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                try{
                    selectedIndex = Integer.parseInt(customerTable.getValueAt(customerTable.getSelectedRow(), 0).toString());
                    nameCustomerInput.setText(customerTable.getValueAt(customerTable.getSelectedRow(), 1).toString());
                    addressCustomerInput.setText(customerTable.getValueAt(customerTable.getSelectedRow(), 2).toString());
                    phoneCustomerInput.setText(customerTable.getValueAt(customerTable.getSelectedRow(), 3).toString());
                    noteCustomerInput.setText(customerTable.getValueAt(customerTable.getSelectedRow(), 6).toString());
                } catch (Exception e){
                    selectedIndex = -1;
                }
            }
        });
    }

    private void selectedImportRow(){
        importTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                try{
                    selectedIndex = Integer.parseInt(importTable.getValueAt(importTable.getSelectedRow(), 0).toString());
                    nameImportCb.setSelectedItem(importTable.getValueAt(importTable.getSelectedRow(), 1).toString());
                    codeImportCb.setSelectedItem(importTable.getValueAt(importTable.getSelectedRow(), 2).toString());
                    quantityImportInput.setText(importTable.getValueAt(importTable.getSelectedRow(), 5).toString());
                    providerImportCb.setSelectedItem(importTable.getValueAt(importTable.getSelectedRow(), 4).toString());
                } catch (Exception e){
                    selectedIndex = -1;
                }
            }
        });
    }

    private void selectedExportRow(){
        importTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                try{
                    selectedIndex = Integer.parseInt(importTable1.getValueAt(importTable1.getSelectedRow(), 0).toString());
                    nameExportCb1.setSelectedItem(importTable1.getValueAt(importTable1.getSelectedRow(), 1).toString());
                    codeExportCb.setSelectedItem(importTable1.getValueAt(importTable1.getSelectedRow(), 2).toString());
                    quantityExportInput.setText(importTable1.getValueAt(importTable1.getSelectedRow(), 5).toString());
                    providerExportCb.setSelectedItem(importTable1.getValueAt(importTable1.getSelectedRow(), 4).toString());
                } catch (Exception e){
                    selectedIndex = -1;
                }
            }
        });
    }

    private void selectedProviderRow(){
        providerTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                try{
                    selectedIndex = Integer.parseInt(providerTable.getValueAt(providerTable.getSelectedRow(), 0).toString());
                    nameProviderInput.setText(providerTable.getValueAt(providerTable.getSelectedRow(), 1).toString());
                    addressProviderInput.setText(providerTable.getValueAt(providerTable.getSelectedRow(), 2).toString());
                    phoneProviderInput.setText(providerTable.getValueAt(providerTable.getSelectedRow(), 3).toString());
                    noteProviderInput.setText(providerTable.getValueAt(providerTable.getSelectedRow(), 6).toString());
                } catch (Exception e){
                    selectedIndex = -1;
                }
            }
        });
    }

    private void selectedItemRow(){
        manageTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                try{
                    selectedIndex = Integer.parseInt(manageTable.getValueAt(manageTable.getSelectedRow(), 0).toString());
                    nameManageInput.setText(manageTable.getValueAt(manageTable.getSelectedRow(), 1).toString());
                    codeManageInput.setText(manageTable.getValueAt(manageTable.getSelectedRow(), 2).toString());
                    typeManageCb.setSelectedItem(manageTable.getValueAt(manageTable.getSelectedRow(), 3).toString());
                    providerManageCb.setSelectedItem(manageTable.getValueAt(manageTable.getSelectedRow(), 4).toString());
                    priceImportManageInput.setText(manageTable.getValueAt(manageTable.getSelectedRow(), 6).toString());
                    priceExportManageInput.setText(manageTable.getValueAt(manageTable.getSelectedRow(), 7).toString());
                    noteManageInput.setText(manageTable.getValueAt(manageTable.getSelectedRow(), 8).toString());
                } catch (Exception e){
                    selectedIndex = -1;
                }
            }
        });
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
    
    private void renderImportTable(){
        flagImport = true;
        nameImportCb.removeAllItems();
        codeImportCb.removeAllItems();
        providerImportCb.removeAllItems();

        if(items.size() > 0){
            for(int i = 0; i < items.size(); i++){
                nameImportCb.addItem(items.get(i).name);
                codeImportCb.addItem(items.get(i).code);
            }

            nameImportCb.setSelectedItem(items.get(0).name);
            codeImportCb.setSelectedItem(items.get(0).code);
        }

        flagImport = false;

        if(providers.size() > 0){
            for(PersonEntity personEntity: providers){
                providerImportCb.addItem(personEntity.name);
            }
        }

        removeRowInTable(importTable);
        for(int i = 0; i < imports.size(); i++){
            ((DefaultTableModel)this.importTable.getModel()).addRow(storageObj[i]);
        }
        selectedImportRow();
    }

    private void renderExportTable(){
        flagExport = true;
        nameExportCb1.removeAllItems();
        codeExportCb.removeAllItems();
        providerExportCb.removeAllItems();

        if(items.size() > 0){
            for(int i = 0; i < items.size(); i++){
                nameExportCb1.addItem(items.get(i).name);
                codeExportCb.addItem(items.get(i).code);
            }

            nameExportCb1.setSelectedItem(items.get(0).name);
            codeExportCb.setSelectedItem(items.get(0).code);
        }

        flagExport = false;

        if(customers.size() > 0){
            for(PersonEntity personEntity: customers){
                providerExportCb.addItem(personEntity.name);
            }
        }

        removeRowInTable(importTable1);
        for(int i = 0; i < exports.size(); i++){
            ((DefaultTableModel)this.importTable1.getModel()).addRow(storageObj[i]);
        }
        selectedExportRow();
    }

    private void renderCustomerTable(){
        removeRowInTable(customerTable);
        for(int i = 0; i < customers.size(); i++){
            ((DefaultTableModel)this.customerTable.getModel()).addRow(personObj[i]);
        }

        selectedCustomerRow();
    }

    private void renderProviderTable(){
        removeRowInTable(providerTable);
        for(int i = 0; i < providers.size(); i++){
            ((DefaultTableModel)this.providerTable.getModel()).addRow(personObj[i]);
        }

        selectedProviderRow();
    }

    private void renderStatisticTable(List<StorageEntity> dataList){
        statistics = new ArrayList<>();
        List<String> codeList = dataList.stream().map(e -> e.code).distinct().collect(Collectors.toList());
        for(String code: codeList){
            StorageEntity storageEntity = new StorageEntity();
            storageEntity.code = code;

            List<StorageEntity> tmp = dataList.stream().filter(e -> e.code.equals(code)).collect(Collectors.toList());
            storageEntity.name = tmp.get(0).name;
            storageEntity.quantity = tmp.stream().mapToInt(e -> e.quantity).sum();
            storageEntity.total = tmp.stream().mapToInt(e -> e.total).sum();
            statistics.add(storageEntity);
        }

        removeRowInTable(statisticTable);
        statisticObj = new Object[statistics.size()][5];
        for(int i = 0; i < statistics.size(); i++){
            statisticObj[i][0] = i+1;
            statisticObj[i][1] = statistics.get(i).name;
            statisticObj[i][2] = statistics.get(i).code;
            statisticObj[i][3] = statistics.get(i).quantity;
            statisticObj[i][4] = statistics.get(i).total;
        }

        for(int i = 0; i < statistics.size(); i++){
            ((DefaultTableModel)this.statisticTable.getModel()).addRow(statisticObj[i]);
        }
    }

    private void renderManageTable(){
        providerManageCb.removeAllItems();
        if(providers.size() > 0){
            for(int i = 0; i < providers.size(); i++){
                providerManageCb.addItem(providers.get(0).name);
            }
        }

        removeRowInTable(manageTable);
        itemObj = itemService.generateItemObject(items);
        for(int i = 0; i < items.size(); i++){
            ((DefaultTableModel)this.manageTable.getModel()).addRow(itemObj[i]);
        }

        selectedItemRow();
    }

    private PersonEntity validateProviderMenu(){
        PersonEntity provider = new PersonEntity();
        if (selectedIndex >= 0)
            provider.id = providers.get(selectedIndex - 1).id;
        provider.name = nameProviderInput.getText();
        provider.address = addressProviderInput.getText();
        provider.phone = phoneProviderInput.getText();
        provider.note = noteProviderInput.getText();

        provider.createdAt = new SimpleDateFormat("yyyy/MM/dd").format(Calendar.getInstance().getTime());
        provider.total = 0; // toDo:

        if(provider.name.equals("") || provider.address.equals("") || provider.phone.equals("")){
            JOptionPane.showMessageDialog(null, "Please complete form");
            return null;
        } else {
            if (providers.stream().filter(e -> e.name.equals(provider.name)).collect(Collectors.toList()).size() > 0){
                JOptionPane.showMessageDialog(null, "Provider Name exists !");
                return null;
            } else
                return provider;
        }
    }

    private PersonEntity validateCustomerMenu(){
        PersonEntity customer = new PersonEntity();
        if (selectedIndex >= 0){
            customer.id = customers.get(selectedIndex - 1).id;
        }
        customer.name = nameCustomerInput.getText();
        customer.address = addressCustomerInput.getText();
        customer.phone = phoneCustomerInput.getText();
        customer.note = noteCustomerInput.getText();

        customer.createdAt = new SimpleDateFormat("yyyy/MM/dd").format(Calendar.getInstance().getTime());
        customer.total = 0;

        if(customer.name.equals("") || customer.address.equals("") || customer.phone.equals("")){
            JOptionPane.showMessageDialog(null, "Hoàn thành thông tin theo mẫu");
            return null;
        } else {
            if (customers.stream().filter(e -> e.name.equals(customer.name)).collect(Collectors.toList()).size() > 0){
                JOptionPane.showMessageDialog(null, "Customer Name exists !");
                return null;
            } else
                return customer;
        }
    }

    private StorageEntity validateImportMenu(){
        ItemEntity itemEntity = items.stream().filter(e -> e.code.equals(codeImportCb.getSelectedItem().toString())).collect(Collectors.toList()).get(0);

        StorageEntity storageEntity = new StorageEntity();
        if(selectedIndex >= 0)
            storageEntity.id = imports.get(selectedIndex - 1).id;
        storageEntity.createdAt = new SimpleDateFormat("yyyy/MM/dd").format(Calendar.getInstance().getTime());
        storageEntity.type = itemEntity.type;
        storageEntity.price = itemEntity.priceImport;

        try {
            storageEntity.name = nameImportCb.getSelectedItem().toString();
            storageEntity.code = codeImportCb.getSelectedItem().toString();
            storageEntity.person = providerImportCb.getSelectedItem().toString();
            storageEntity.quantity = Integer.parseInt(quantityImportInput.getText());
            storageEntity.total = storageEntity.quantity * storageEntity.price;

            return storageEntity;
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Thông tin trên mẫu thiếu");
        }

        return null;
    }

    private StorageEntity validateExportMenu(){
        ItemEntity itemEntity = items.stream().filter(e -> e.code.equals(codeExportCb.getSelectedItem().toString())).collect(Collectors.toList()).get(0);

        StorageEntity storageEntity = new StorageEntity();
        if(selectedIndex >= 0)
            storageEntity.id = exports.get(selectedIndex - 1).id;
        storageEntity.createdAt = new SimpleDateFormat("yyyy/MM/dd").format(Calendar.getInstance().getTime());
        storageEntity.type = itemEntity.type;
        storageEntity.price = itemEntity.priceImport;

        try {
            storageEntity.name = nameExportCb1.getSelectedItem().toString();
            storageEntity.code = codeExportCb.getSelectedItem().toString();
            storageEntity.person = providerExportCb.getSelectedItem().toString();
            storageEntity.quantity = Integer.parseInt(quantityExportInput.getText());
            if (storageEntity.quantity > itemEntity.quantity){
                JOptionPane.showMessageDialog(null, "Vượt quá số lượng cho phép");
            } else {
                storageEntity.total = storageEntity.quantity * storageEntity.price;
                return storageEntity;
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Thông tin trên mẫu thiếu");
        }

        return null;
    }

    private ItemEntity validateManageMenu(boolean isEdit){
        ItemEntity itemEntity = new ItemEntity();
        if (selectedIndex >= 0)
            itemEntity.id = items.get(selectedIndex - 1).id;
        itemEntity.name = nameManageInput.getText();
        itemEntity.code = codeManageInput.getText();
        itemEntity.note = priceExportManageInput.getText();
        itemEntity.quantity = 0;

        try {
            itemEntity.type = typeManageCb.getSelectedItem().toString();
            itemEntity.provider = providerManageCb.getSelectedItem().toString();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Please select a provider");
            return null;
        }

        try{
            itemEntity.priceImport = Integer.parseInt(priceImportManageInput.getText());
            itemEntity.priceExport = Integer.parseInt(priceExportManageInput.getText());

            if (itemEntity.name.equals("") || itemEntity.code.equals("") || itemEntity.provider == null){
                JOptionPane.showMessageDialog(null, "Please complete form");
                return null;
            } else {
                if (!isEdit && items.stream().filter(e -> e.code.equals(itemEntity.code)).collect(Collectors.toList()).size() > 0) {
                    JOptionPane.showMessageDialog(null, "Item code exists");
                    return null;
                } else {
                    return itemEntity;
                }
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Number is required for import price and export price");
        }

        return null;
    }

    private void removeRowInTable(JTable table){
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        int rows = model.getRowCount();
        for(int i = rows - 1; i >=0; i--) model.removeRow(i);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        manageTable = new javax.swing.JTable();
        importMenu = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        quantityImportInput = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        addImportBtn = new javax.swing.JButton();
        editImportBtn = new javax.swing.JButton();
        deleteImportBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
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
        deleteManageBtn2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
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
        noteProviderInput = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        addProviderBtn = new javax.swing.JButton();
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

        manageMenuBtn.setText("Manage Item");
        manageMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageMenuBtnAction(evt);
            }
        });

        importMenuBtn.setText("Import");
        importMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importMenuBtnAction(evt);
            }
        });

        exportMenuBtn.setText("Export");
        exportMenuBtn.setToolTipText("");
        exportMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportMenuBtnAction(evt);
            }
        });

        customerMenuBtn.setText("Customer");
        customerMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerMenuBtnAction(evt);
            }
        });

        providerMenuBtn.setText("Provider");
        providerMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                providerMenuBtnAction(evt);
            }
        });

        statisticMenuBtn.setText("Statistic");
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

        jLabel1.setText("Item Name");

        jLabel2.setText("Item Code");

        typeManageCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Pcs", "Set", "Kg"}));

        jLabel3.setText("Unit Type");

        providerManageCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));

        jLabel4.setText("Provider");

        jLabel5.setText("Import Price");

        jLabel6.setText("Export Price");

        jLabel7.setText("Note");

        addManageBtn.setText("Add");
        addManageBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addManageBtnActionPerformed(evt);
            }
        });

        editManageBtn.setText("Edit");
        editManageBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editManageBtnActionPerformed(evt);
            }
        });

        deleteManageBtn.setText("Delete");
        deleteManageBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteManageBtnActionPerformed(evt);
            }
        });

        manageTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Index", "Item Name", "Item Code", "Unit Type", "Provider", "Quantity", "Import price", "Export price", "Note"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(manageTable);
        if (manageTable.getColumnModel().getColumnCount() > 0) {
            manageTable.getColumnModel().getColumn(0).setPreferredWidth(1);
            manageTable.getColumnModel().getColumn(1).setPreferredWidth(100);
            manageTable.getColumnModel().getColumn(2).setPreferredWidth(80);
            manageTable.getColumnModel().getColumn(3).setPreferredWidth(40);
            manageTable.getColumnModel().getColumn(5).setPreferredWidth(10);
            manageTable.getColumnModel().getColumn(6).setPreferredWidth(40);
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
                                .addContainerGap(172, Short.MAX_VALUE))
                            .addComponent(noteManageInput)))
                    .addGroup(manageMenuLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(editManageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(deleteManageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addComponent(jScrollPane1)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE))
        );

        jLabel8.setText("Item Name");

        jLabel9.setText("Item Code");

        jLabel12.setText("Quantity");

        addImportBtn.setText("Add");
        addImportBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addImportBtnActionPerformed(evt);
            }
        });

        editImportBtn.setText("Edit");
        editImportBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editImportBtnActionPerformed(evt);
            }
        });

        deleteImportBtn.setText("Delete");
        deleteImportBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteImportBtnActionPerformed(evt);
            }
        });

        importTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Index", "Item Name", "Item Code", "Unit Type", "Provider", "Quantity", "Price", "Total", "Created Day"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(importTable);
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

        nameImportCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        nameImportCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameImportCbActionPerformed(evt);
            }
        });

        codeImportCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));
        codeImportCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codeImportCbActionPerformed(evt);
            }
        });

        providerImportCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));

        jLabel10.setText("Provider");

        javax.swing.GroupLayout importMenuLayout = new javax.swing.GroupLayout(importMenu);
        importMenu.setLayout(importMenuLayout);
        importMenuLayout.setHorizontalGroup(
            importMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
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
                .addGap(0, 150, Short.MAX_VALUE))
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE))
        );

        jLabel11.setText("Item Name");

        jLabel13.setText("Item Code");

        jLabel14.setText("Quantity");

        addExportBtn.setText("Add");
        addExportBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addExportBtnActionPerformed(evt);
            }
        });

        editExportBtn.setText("Edit");
        editExportBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editExportBtnActionPerformed(evt);
            }
        });

        deleteManageBtn2.setText("Delete");
        deleteManageBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteManageBtn2ActionPerformed(evt);
            }
        });

        importTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Index", "Item Name", "Item Code", "Unit Type", "Customer", "Quantity", "Import Price", "Export Price", "Note"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(importTable1);
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

        nameExportCb1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        nameExportCb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameExportCb1ActionPerformed(evt);
            }
        });

        codeExportCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));
        codeExportCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codeExportCbActionPerformed(evt);
            }
        });

        providerExportCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));

        jLabel15.setText("Customer");

        javax.swing.GroupLayout exportMenuLayout = new javax.swing.GroupLayout(exportMenu);
        exportMenu.setLayout(exportMenuLayout);
        exportMenuLayout.setHorizontalGroup(
            exportMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
            .addGroup(exportMenuLayout.createSequentialGroup()
                .addGroup(exportMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(exportMenuLayout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addGroup(exportMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameExportCb1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
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
                        .addComponent(deleteManageBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 150, Short.MAX_VALUE))
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
                    .addComponent(deleteManageBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE))
        );

        jLabel16.setText("Customer Name");

        jLabel17.setText("Address");

        jLabel18.setText("Phone");

        jLabel22.setText("Note");

        addCustomerBtn.setText("Add");
        addCustomerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCustomerBtnActionPerformed(evt);
            }
        });

        editCustomerBtn.setText("Edit");
        editCustomerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editCustomerBtnActionPerformed(evt);
            }
        });

        deleteCustomerBtn.setText("Delete");
        deleteCustomerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCustomerBtnActionPerformed(evt);
            }
        });

        customerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Index", "Customer Name", "Address", "Phone", "Created Day", "Total", "Note"
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
                    .addComponent(jLabel17)
                    .addComponent(addressCustomerInput, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(customerMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(phoneCustomerInput, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
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
                .addComponent(customerScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE))
        );

        jLabel19.setText("Provider Name");

        jLabel20.setText("Address");

        jLabel21.setText("Phone");

        jLabel23.setText("Note");

        addProviderBtn.setText("Add");
        addProviderBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProviderBtnActionPerformed(evt);
            }
        });

        editProviderBtn.setText("Edit");
        editProviderBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editProviderBtnActionPerformed(evt);
            }
        });

        deleteProviderBtn.setText("Delete");
        deleteProviderBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteProviderBtnActionPerformed(evt);
            }
        });

        providerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Index", "Provider Name", "Address", "Phone", "Created Day", "Total", "Note"
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

        javax.swing.GroupLayout providerMenuLayout = new javax.swing.GroupLayout(providerMenu);
        providerMenu.setLayout(providerMenuLayout);
        providerMenuLayout.setHorizontalGroup(
            providerMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(providerMenuLayout.createSequentialGroup()
                .addGap(305, 305, 305)
                .addComponent(addProviderBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(providerMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(phoneProviderInput, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(providerMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(noteProviderInput, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(noteProviderInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(providerMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addProviderBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editProviderBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteProviderBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(providerScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE))
        );

        exportStatisticBtn.setText("Export Statictis");
        exportStatisticBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportStatisticBtnActionPerformed(evt);
            }
        });

        importStatisticBtn.setText("Import Statictis");
        importStatisticBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importStatisticBtnActionPerformed(evt);
            }
        });

        statisticTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Index", "Item Name", "Item Code", "Quantity", "Total"
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

        javax.swing.GroupLayout statisticMenuLayout = new javax.swing.GroupLayout(statisticMenu);
        statisticMenu.setLayout(statisticMenuLayout);
        statisticMenuLayout.setHorizontalGroup(
            statisticMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statisticScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 997, Short.MAX_VALUE)
            .addGroup(statisticMenuLayout.createSequentialGroup()
                .addGap(287, 287, 287)
                .addComponent(exportStatisticBtn)
                .addGap(52, 52, 52)
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
                .addComponent(statisticScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE))
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
                    .addComponent(manageMenu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(importMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(exportMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                .addComponent(manageMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap(71, Short.MAX_VALUE)
                    .addComponent(importMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(70, Short.MAX_VALUE)
                    .addComponent(exportMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(66, 66, 66)
                    .addComponent(customerMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(65, 65, 65)
                    .addComponent(providerMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(71, 71, 71)
                    .addComponent(statisticMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void manageMenuBtnAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageMenuBtnAction
        this.changeView(manageMenu);
        renderManageTable();
    }//GEN-LAST:event_manageMenuBtnAction

    private void importMenuBtnAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importMenuBtnAction
        this.changeView(importMenu);
        storageObj = importService.generateStoreObject(imports);
        renderImportTable();
    }//GEN-LAST:event_importMenuBtnAction

    private void exportMenuBtnAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportMenuBtnAction
        this.changeView(exportMenu);
        storageObj = exportService.generateStoreObject(exports);
        renderExportTable();
    }//GEN-LAST:event_exportMenuBtnAction

    private void customerMenuBtnAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerMenuBtnAction
       this.changeView(customerMenu);
       personObj = customerService.generatePersonObject(customers);
       renderCustomerTable();
    }//GEN-LAST:event_customerMenuBtnAction

    private void providerMenuBtnAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_providerMenuBtnAction
        this.changeView(providerMenu);
        personObj = providerService.generatePersonObject(providers);
        renderProviderTable();
    }//GEN-LAST:event_providerMenuBtnAction

    private void statisticMenuBtnAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statisticMenuBtnAction
        this.changeView(this.statisticMenu);
    }//GEN-LAST:event_statisticMenuBtnAction

    private void nameManageInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameManageInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameManageInputActionPerformed

    private void exportStatisticBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportStatisticBtnActionPerformed
        renderStatisticTable(exports);
    }//GEN-LAST:event_exportStatisticBtnActionPerformed

    private void addCustomerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCustomerBtnActionPerformed
        PersonEntity customer = validateCustomerMenu();
        if(customer != null) {
            customers.add(customer);
            customerService.save(customer);

            ((DefaultTableModel)customerTable.getModel()).addRow(customerService.generatePersonObject(customers.size(), customer));
        }
    }//GEN-LAST:event_addCustomerBtnActionPerformed

    private void editCustomerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editCustomerBtnActionPerformed
        if (selectedIndex == -1){
            JOptionPane.showMessageDialog(null, "Hãy chọn một hàng trong bảng");
        } else {
            PersonEntity customer = validateCustomerMenu();
            if (customer != null){
                customers.set(selectedIndex - 1, customer);
                customerService.updatePerson(customer);

                personObj = customerService.generatePersonObject(customers);
                renderCustomerTable();
            }
            selectedIndex = -1;
        }
    }//GEN-LAST:event_editCustomerBtnActionPerformed

    private void deleteCustomerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteCustomerBtnActionPerformed
        if (selectedIndex == -1){
            JOptionPane.showMessageDialog(null, "Hãy chọn một hàng trong bảng");
        } else {
            customerService.deletePerson(customers.get(selectedIndex - 1));
            customers.remove(selectedIndex - 1);
            personObj = customerService.generatePersonObject(customers);
            renderCustomerTable();
            selectedIndex = -1;
        }
    }//GEN-LAST:event_deleteCustomerBtnActionPerformed

    private void addProviderBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProviderBtnActionPerformed
        PersonEntity provider = validateProviderMenu();
        if(provider != null) {
            providers.add(provider);
            providerService.save(provider);

            ((DefaultTableModel)providerTable.getModel()).addRow(providerService.generatePersonObject(providers.size(), provider));
        }
    }//GEN-LAST:event_addProviderBtnActionPerformed

    private void editProviderBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editProviderBtnActionPerformed
        if (selectedIndex == -1){
            JOptionPane.showMessageDialog(null, "Hãy chọn một hàng trong bảng");
        } else {
            PersonEntity provider = validateProviderMenu();
            if (provider != null){
                providers.set(selectedIndex - 1, provider);
                providerService.updatePerson(provider);

                personObj = providerService.generatePersonObject(providers);
                renderProviderTable();
            }
            selectedIndex = -1;
        }
    }//GEN-LAST:event_editProviderBtnActionPerformed

    private void deleteProviderBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteProviderBtnActionPerformed
        if (selectedIndex == -1){
            JOptionPane.showMessageDialog(null, "Hãy chọn một hàng trong bảng");
        } else {
            providerService.deletePerson(providers.get(selectedIndex - 1));
            providers.remove(selectedIndex - 1);
            personObj = providerService.generatePersonObject(providers);
            renderProviderTable();
            selectedIndex = -1;
        }
    }//GEN-LAST:event_deleteProviderBtnActionPerformed

    private void addManageBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addManageBtnActionPerformed
        ItemEntity itemEntity = validateManageMenu(false);
        if(itemEntity != null) {
            items.add(itemEntity);
            itemService.save(itemEntity);

            ((DefaultTableModel)manageTable.getModel()).addRow(itemService.generateItemObject(items.size(), itemEntity));
        }
    }//GEN-LAST:event_addManageBtnActionPerformed

    private void addImportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addImportBtnActionPerformed
        StorageEntity storageEntity = validateImportMenu();
        if(storageEntity != null) {
            imports.add(storageEntity);
            importService.save(storageEntity);

            PersonEntity personEntity = providers.stream().filter(e -> e.name.equals(storageEntity.person)).findFirst().get();
            int index = providers.indexOf(personEntity);
            personEntity.total += storageEntity.total;
            providers.set(index, personEntity);
            providerService.updatePerson(personEntity);

            ItemEntity itemEntity = items.stream().filter(e -> e.name.equals(storageEntity.name) && e.code.equals(storageEntity.code)).findFirst().get();
            index = items.indexOf(itemEntity);
            itemEntity.quantity += storageEntity.quantity;
            items.set(index, itemEntity);
            itemService.updateItem(itemEntity);

            ((DefaultTableModel)importTable.getModel()).addRow(importService.generateStoreObject(imports.size(), storageEntity));
        }
    }//GEN-LAST:event_addImportBtnActionPerformed

    private void editImportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editImportBtnActionPerformed
        if (selectedIndex == -1){
            JOptionPane.showMessageDialog(null, "Hãy chọn một hàng trong bảng");
        } else {
            StorageEntity storageEntity = validateImportMenu();
            if (storageEntity != null){
                imports.set(selectedIndex - 1, storageEntity);
                importService.updateStorage(storageEntity);

                storageObj = importService.generateStoreObject(imports);
                renderImportTable();
            }
            selectedIndex = -1;
        }
    }//GEN-LAST:event_editImportBtnActionPerformed

    private void deleteImportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteImportBtnActionPerformed
        if (selectedIndex == -1){
            JOptionPane.showMessageDialog(null, "Hãy chọn một hàng trong bảng");
        } else {
            importService.deleteStorage(imports.get(selectedIndex - 1));
            imports.remove(selectedIndex - 1);
            storageObj = importService.generateStoreObject(imports);
            renderImportTable();
            selectedIndex = -1;
        }
    }//GEN-LAST:event_deleteImportBtnActionPerformed

    private void addExportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addExportBtnActionPerformed
        StorageEntity storageEntity = validateExportMenu();
        if(storageEntity != null) {
            exports.add(storageEntity);
            exportService.save(storageEntity);

            PersonEntity personEntity = customers.stream().filter(e -> e.name.equals(storageEntity.person)).findFirst().get();
            int index = customers.indexOf(personEntity);
            personEntity.total += storageEntity.total;
            customers.set(index, personEntity);
            customerService.updatePerson(personEntity);

            ItemEntity itemEntity = items.stream().filter(e -> e.name.equals(storageEntity.name) && e.code.equals(storageEntity.code)).findFirst().get();
            index = items.indexOf(itemEntity);
            itemEntity.quantity -= storageEntity.quantity;
            items.set(index, itemEntity);
            itemService.updateItem(itemEntity);

            ((DefaultTableModel)importTable1.getModel()).addRow(exportService.generateStoreObject(exports.size(), storageEntity));
        }
    }//GEN-LAST:event_addExportBtnActionPerformed

    private void editExportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editExportBtnActionPerformed
        if (selectedIndex == -1){
            JOptionPane.showMessageDialog(null, "Hãy chọn một hàng trong bảng");
        } else {
            StorageEntity storageEntity = validateExportMenu();
            if (storageEntity != null){
                exports.set(selectedIndex - 1, storageEntity);
                exportService.updateStorage(storageEntity);

                storageObj = exportService.generateStoreObject(exports);
                renderExportTable();
            }
            selectedIndex = -1;
        }
    }//GEN-LAST:event_editExportBtnActionPerformed

    private void deleteManageBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteManageBtn2ActionPerformed
        if (selectedIndex == -1){
            JOptionPane.showMessageDialog(null, "Hãy chọn một hàng trong bảng");
        } else {
            exportService.deleteStorage(exports.get(selectedIndex - 1));
            exports.remove(selectedIndex - 1);
            storageObj = exportService.generateStoreObject(exports);
            renderExportTable();
            selectedIndex = -1;
        }
    }//GEN-LAST:event_deleteManageBtn2ActionPerformed

    private void importStatisticBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importStatisticBtnActionPerformed
        renderStatisticTable(imports);
    }//GEN-LAST:event_importStatisticBtnActionPerformed

    private void codeImportCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codeImportCbActionPerformed
        if (!flagImport){
            flagImport = true;
            List<ItemEntity> itemEntities = items.stream().filter(e -> e.code.equals(codeImportCb.getSelectedItem().toString())).collect(Collectors.toList());
            List<ItemEntity> itemEntities2 = items.stream().filter(e -> !e.code.equals(codeImportCb.getSelectedItem().toString())).collect(Collectors.toList());
            itemEntities2.stream().forEach(e -> itemEntities.add(e));
            nameImportCb.removeAllItems();
            for(ItemEntity itemEntity: itemEntities){
                nameImportCb.addItem(itemEntity.name);
            }
            flagImport = false;
        }
    }//GEN-LAST:event_codeImportCbActionPerformed

    private void nameImportCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameImportCbActionPerformed
        if(!flagImport){
            flagImport = true;
            List<ItemEntity> itemEntities = items.stream().filter(e -> e.name.equals(nameImportCb.getSelectedItem().toString())).collect(Collectors.toList());
            List<ItemEntity> itemEntities2 = items.stream().filter(e -> !e.name.equals(nameImportCb.getSelectedItem().toString())).collect(Collectors.toList());
            itemEntities2.stream().forEach(e -> itemEntities.add(e));
            codeImportCb.removeAllItems();
            for(ItemEntity itemEntity: itemEntities){
                codeImportCb.addItem(itemEntity.code);
            }
            flagImport = false;
        }
    }//GEN-LAST:event_nameImportCbActionPerformed

    private void nameExportCb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameExportCb1ActionPerformed
        if(!flagExport){
            flagExport = true;
            List<ItemEntity> itemEntities = items.stream().filter(e -> e.name.equals(nameExportCb1.getSelectedItem().toString())).collect(Collectors.toList());
            List<ItemEntity> itemEntities2 = items.stream().filter(e -> !e.name.equals(nameExportCb1.getSelectedItem().toString())).collect(Collectors.toList());
            itemEntities2.stream().forEach(e -> itemEntities.add(e));
            codeExportCb.removeAllItems();
            for(ItemEntity itemEntity: itemEntities){
                codeExportCb.addItem(itemEntity.code);
            }
            flagExport = false;
        }
    }//GEN-LAST:event_nameExportCb1ActionPerformed

    private void codeExportCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codeExportCbActionPerformed
        if (!flagExport){
            flagExport = true;
            List<ItemEntity> itemEntities = items.stream().filter(e -> e.code.equals(codeExportCb.getSelectedItem().toString())).collect(Collectors.toList());
            List<ItemEntity> itemEntities2 = items.stream().filter(e -> !e.code.equals(codeExportCb.getSelectedItem().toString())).collect(Collectors.toList());
            itemEntities2.stream().forEach(e -> itemEntities.add(e));
            nameExportCb1.removeAllItems();
            for(ItemEntity itemEntity: itemEntities){
                nameExportCb1.addItem(itemEntity.name);
            }
            flagExport = false;
        }
    }//GEN-LAST:event_codeExportCbActionPerformed

    private void editManageBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editManageBtnActionPerformed
        if (selectedIndex == -1){
            JOptionPane.showMessageDialog(null, "Hãy chọn một hàng trong bảng");
        } else {
            ItemEntity itemEntity = validateManageMenu(true);
            if (itemEntity != null){
                items.set(selectedIndex - 1, itemEntity);
                itemService.updateItem(itemEntity);

                itemObj = itemService.generateItemObject(items);
                renderManageTable();
            }
            selectedIndex = -1;
        }
    }//GEN-LAST:event_editManageBtnActionPerformed

    private void deleteManageBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteManageBtnActionPerformed
        if (selectedIndex == -1){
            JOptionPane.showMessageDialog(null, "Please select one row in table");
        } else {
            itemService.deleteItem(items.get(selectedIndex - 1));
            items.remove(selectedIndex - 1);
            itemObj = itemService.generateItemObject(items);
            renderManageTable();
            selectedIndex = -1;
        }
    }//GEN-LAST:event_deleteManageBtnActionPerformed

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
    private javax.swing.JButton addExportBtn;
    private javax.swing.JButton addImportBtn;
    private javax.swing.JButton addManageBtn;
    private javax.swing.JButton addProviderBtn;
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
    private javax.swing.JButton deleteImportBtn;
    private javax.swing.JButton deleteManageBtn;
    private javax.swing.JButton deleteManageBtn2;
    private javax.swing.JButton deleteProviderBtn;
    private javax.swing.JButton editCustomerBtn;
    private javax.swing.JButton editExportBtn;
    private javax.swing.JButton editImportBtn;
    private javax.swing.JButton editManageBtn;
    private javax.swing.JButton editProviderBtn;
    private javax.swing.JPanel exportMenu;
    private javax.swing.JButton exportMenuBtn;
    private javax.swing.JButton exportStatisticBtn;
    private javax.swing.JPanel importMenu;
    private javax.swing.JButton importMenuBtn;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel manageMenu;
    private javax.swing.JButton manageMenuBtn;
    private javax.swing.JTable manageTable;
    private javax.swing.JTextField nameCustomerInput;
    private javax.swing.JComboBox<String> nameExportCb1;
    private javax.swing.JComboBox<String> nameImportCb;
    private javax.swing.JTextField nameManageInput;
    private javax.swing.JTextField nameProviderInput;
    private javax.swing.JTextField noteCustomerInput;
    private javax.swing.JTextField noteManageInput;
    private javax.swing.JTextField noteProviderInput;
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
