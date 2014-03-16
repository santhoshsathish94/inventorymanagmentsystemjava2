package GUI;

import BLL.Vendor;
import CTRL.VendorCTRL;
import DB.DBConnection;
import com.alee.laf.WebLookAndFeel;
import com.alee.laf.optionpane.WebOptionPane;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.awt.Point;
import static java.awt.image.ImageObserver.WIDTH;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.swing.table.DefaultTableModel;

public class VendorsMenu extends javax.swing.JFrame {

  
    public VendorsMenu() throws SQLException, ClassNotFoundException {
        initComponents();
        displayTableData();
        myInitCompoments();
    }

    public void displayTableData() throws ClassNotFoundException, SQLException
    {
        DBConnection dbCon = new DBConnection(true);
        Statement state =  dbCon.createStatement();
        
        ResultSet rs = state.executeQuery("Select * from Vendor");
        ResultSetMetaData rsmetadata = rs.getMetaData();
        
        int columns = rsmetadata.getColumnCount();
        
         DefaultTableModel dtm = new DefaultTableModel() {
         @Override
         public boolean isCellEditable(int row, int column) 
         {return false;}};
        
        
        Vector columnsName = new Vector();
        Vector dataRows = new Vector();
        
        
        for (int i = 1; i <= columns; i++) 
        {
            columnsName.addElement( rsmetadata.getColumnName(i));
        }       
        
        dtm.setColumnIdentifiers(columnsName);
        
        while(rs.next())
        {
            dataRows = new Vector();
            
            for(int j = 1; j <= columns; j++)
            {
              dataRows.add(rs.getString(j));
            }
            dtm.addRow(dataRows);
        }
        
        vendorTable.setModel(dtm);
    }
    
    protected void myInitCompoments()
    {
        WebLookAndFeel.install();
        setLocationRelativeTo(null);
        hiddenStuffVendor.setVisible(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        vendorTable = new javax.swing.JTable();
        refreshVendorsTable = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        vendorSearchTable = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        vendorIdTextField = new javax.swing.JTextField();
        findVendorByID = new javax.swing.JButton();
        attributeToUpdateComboBox = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        updateTextField = new javax.swing.JTextField();
        updateVendor = new javax.swing.JButton();
        deactivateVendor = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();
        hiddenStuffVendor = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        postalCodeField = new javax.swing.JTextField();
        countryField = new javax.swing.JTextField();
        phoneField = new javax.swing.JTextField();
        addressField = new javax.swing.JTextField();
        cvrField = new javax.swing.JTextField();
        nameField = new javax.swing.JTextField();
        clearFieldsButton = new javax.swing.JButton();
        addVendorButton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        vendorTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        vendorTable.getTableHeader().setResizingAllowed(false);
        vendorTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(vendorTable);

        refreshVendorsTable.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        refreshVendorsTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/refresh_icon.png"))); // NOI18N
        refreshVendorsTable.setText("Refresh");
        refreshVendorsTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshVendorsTableActionPerformed(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/vendor_icon.png"))); // NOI18N

        jButton12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/back_icon.png"))); // NOI18N
        jButton12.setText("Main Menu");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(refreshVendorsTable)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton12))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 826, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addGap(2, 2, 2))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(refreshVendorsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton12))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Vendors", jPanel1);

        vendorSearchTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "vendor_id", "name", "cvr", "address", "postal_code", "phone", "active"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        vendorSearchTable.getTableHeader().setResizingAllowed(false);
        vendorSearchTable.getTableHeader().setReorderingAllowed(false);
        vendorSearchTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vendorSearchTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(vendorSearchTable);
        if (vendorSearchTable.getColumnModel().getColumnCount() > 0) {
            vendorSearchTable.getColumnModel().getColumn(0).setResizable(false);
            vendorSearchTable.getColumnModel().getColumn(1).setResizable(false);
            vendorSearchTable.getColumnModel().getColumn(2).setResizable(false);
            vendorSearchTable.getColumnModel().getColumn(3).setResizable(false);
            vendorSearchTable.getColumnModel().getColumn(4).setResizable(false);
            vendorSearchTable.getColumnModel().getColumn(5).setResizable(false);
            vendorSearchTable.getColumnModel().getColumn(6).setResizable(false);
        }

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Search Vendor ID");

        findVendorByID.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        findVendorByID.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/find_icon.png"))); // NOI18N
        findVendorByID.setText("Find");
        findVendorByID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findVendorByIDActionPerformed(evt);
            }
        });

        attributeToUpdateComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select atribute to update", "name", "cvr", "phone", "country", "address", "postalCode", "" }));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Update");

        updateVendor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/update_icon.png"))); // NOI18N
        updateVendor.setText("Update");
        updateVendor.setToolTipText("To update vendor attribute select vendor's id form the table then select attribute to update and then type the new input");
        updateVendor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateVendorActionPerformed(evt);
            }
        });

        deactivateVendor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/deactivate_icon.png"))); // NOI18N
        deactivateVendor.setText("Deactivate Vendor");
        deactivateVendor.setToolTipText("To deactivate vendor first select the vendor from the table ");
        deactivateVendor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deactivateVendorActionPerformed(evt);
            }
        });

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/vendor_icon.png"))); // NOI18N

        jButton14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/back_icon.png"))); // NOI18N
        jButton14.setText("Main Menu");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        hiddenStuffVendor.setText("HIDDENSTUFF");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(updateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(updateVendor, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deactivateVendor)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(attributeToUpdateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(hiddenStuffVendor)
                        .addGap(128, 128, 128))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(vendorIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(findVendorByID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 336, Short.MAX_VALUE)
                .addComponent(jLabel11))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton14)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(findVendorByID, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(vendorIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(attributeToUpdateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(hiddenStuffVendor))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(updateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(updateVendor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(deactivateVendor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Update Vendor", jPanel3);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Name");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("CVR");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Address");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Country");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Postal Code");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Phone");

        clearFieldsButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        clearFieldsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/clear_icon.png"))); // NOI18N
        clearFieldsButton.setText("Clear");
        clearFieldsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearFieldsButtonActionPerformed(evt);
            }
        });

        addVendorButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        addVendorButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/add_icon.png"))); // NOI18N
        addVendorButton.setText("Add");
        addVendorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addVendorButtonActionPerformed(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/vendor_icon.png"))); // NOI18N

        jButton13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/back_icon.png"))); // NOI18N
        jButton13.setText("Main Menu");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(30, 30, 30)
                        .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(31, 31, 31)
                        .addComponent(countryField, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(10, 10, 10)
                        .addComponent(postalCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(41, 41, 41)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(addVendorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(clearFieldsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(45, 45, 45)
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(54, 54, 54)
                            .addComponent(cvrField, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(607, 607, 607))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton13)
                        .addContainerGap())
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel2))
                    .addComponent(cvrField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel3))
                    .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(countryField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(postalCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addVendorButton)
                    .addComponent(clearFieldsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addComponent(jButton13)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Add New Vendor", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void refreshVendorsTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshVendorsTableActionPerformed
        try {
            displayTableData();
        } catch (ClassNotFoundException ex) {
            WebOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error", WIDTH, null);
        } catch (SQLException ex) {
            WebOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error", WIDTH, null);
        }
    }//GEN-LAST:event_refreshVendorsTableActionPerformed

    private void clearFieldsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearFieldsButtonActionPerformed
        nameField.setText(null);
        cvrField.setText(null);
        addressField.setText(null);
        countryField.setText(null);
        postalCodeField.setText(null);
        phoneField.setText(null);
    }//GEN-LAST:event_clearFieldsButtonActionPerformed

    private void addVendorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addVendorButtonActionPerformed
        try {
        String name = nameField.getText();
        if(name.equals("") || name.equals(null))
              {
               WebOptionPane.showMessageDialog(rootPane, "Please type name", "Missing field", WIDTH, null);
              }
        else { 
        String cvr = cvrField.getText();
        if(cvr.equals("") || cvr.equals(null))
              {
               WebOptionPane.showMessageDialog(rootPane, "Please type cvr", "Missing field", WIDTH, null);
              }
        else { 
        String address = addressField.getText();
         if(address.equals("") || address.equals(null))
              {
               WebOptionPane.showMessageDialog(rootPane, "Please type address", "Missing field", WIDTH, null);
              }
        else { 
        String country = countryField.getText();
        if(country.equals("") || country.equals(null))
              {
               WebOptionPane.showMessageDialog(rootPane, "Please type country", "Missing field", WIDTH, null);
              }
        else { 
        String pc = postalCodeField.getText();
        int postal_code = Integer.parseInt(pc);
        if(postal_code==0)
              {
               WebOptionPane.showMessageDialog(rootPane, "Please type postal code", "Missing field", WIDTH, null);
              }
        else {
        String phone = phoneField.getText();
        if(phone.equals("") || phone.equals(null))
              {
               WebOptionPane.showMessageDialog(rootPane, "Please type phone", "Missing field", WIDTH, null);
              }
        else { 
        short active = 1;

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StockManagmentSystemPU");
        EntityManager em = emf.createEntityManager();
        VendorCTRL vendorCTRL = new VendorCTRL(em);

        em.getTransaction().begin();
        Vendor vendor = vendorCTRL.createVendor(name, cvr, address, postal_code, phone, active);
        em.getTransaction().commit();
        System.out.println("Persisted " + vendor);
        em.close();
        emf.close();
        clearFieldsButtonActionPerformed(evt);
        refreshVendorsTableActionPerformed(evt);
        }}}}}}}
        catch(PersistenceException ex)
        {
            WebOptionPane.showMessageDialog(rootPane, "Please type correct data", "Error", WIDTH, null);
        } 
        catch(NumberFormatException ne) 
        {
        WebOptionPane.showMessageDialog(rootPane, "Please type correct data", "Missing field", WIDTH, null);
        }
        
        catch (Exception e)
        {
         WebOptionPane.showMessageDialog(rootPane, e.getMessage(), "Missing field", WIDTH, null);
           
        }
    }//GEN-LAST:event_addVendorButtonActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        setVisible(false);
        AdminMenu adminMenu = new AdminMenu();
        adminMenu.setVisible(true);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        jButton12ActionPerformed(null);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        jButton12ActionPerformed(null);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void findVendorByIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findVendorByIDActionPerformed
         try {
            DBConnection dbCon = new DBConnection(true);
            Statement state =  dbCon.createStatement();
            
            String vendor_id = vendorIdTextField.getText();
            
            ResultSet rs = state.executeQuery("Select * from Vendor where vendor_id = "+vendor_id);
            ResultSetMetaData rsmetadata = rs.getMetaData();
            
            int columns = rsmetadata.getColumnCount();
            
            DefaultTableModel dtm = new DefaultTableModel() {
             @Override
             public boolean isCellEditable(int row, int column) 
            {return false;}};
            
            
            Vector columnsName = new Vector();
            Vector dataRows = new Vector();
            
            
            for (int i = 1; i <= columns; i++)
            {
                columnsName.addElement( rsmetadata.getColumnName(i));
            }

            dtm.setColumnIdentifiers(columnsName);
            
            while(rs.next())
            {
                dataRows = new Vector();
                
                for(int j = 1; j <= columns; j++)
                {
                    dataRows.add(rs.getString(j));
                }
                dtm.addRow(dataRows);
            }
            
            vendorSearchTable.setModel(dtm);
        } 
         catch (NullPointerException ex) {
            WebOptionPane.showMessageDialog(rootPane, "Please type correct input", "Error", WIDTH, null);   
            } 
         
         catch (SQLServerException ex) 
            {
                WebOptionPane.showMessageDialog(rootPane, "Please type correct input", "Error", WIDTH, null);
            }  
         
         catch (ClassNotFoundException ex) {
            WebOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error", WIDTH, null);
        } catch (SQLException ex) {
            WebOptionPane.showMessageDialog(rootPane, "Connenction error, please try again", "Connection error", WIDTH, null);
        }
    }//GEN-LAST:event_findVendorByIDActionPerformed

    private void updateVendorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateVendorActionPerformed
        try{
        String name = null;
        String cvr = null;
        String address = null;
        int postalCode = 0;
        String phone = null;
        String empty =updateTextField.getText();
        
         if(empty.equals("") || empty=="")
        {
            WebOptionPane.showMessageDialog(rootPane, "     Type some input !", "Error", WIDTH, null);
        }
        else {
        
        
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StockManagmentSystemPU");
        EntityManager em = emf.createEntityManager();
        VendorCTRL vendorCTRL = new VendorCTRL(em);
        
        String selectedItem = attributeToUpdateComboBox.getSelectedItem().toString();
        if(selectedItem.equals("Select atribute to update")) 
            {
                WebOptionPane.showMessageDialog(rootPane, "     Select atribute to update !", "Error", WIDTH, null);
            }
            else {
        
        em.getTransaction().begin();
        
        if (selectedItem == "postalCode") 
        {
          postalCode = Integer.parseInt(updateTextField.getText());
        }
        
        else if (selectedItem == "address") 
        {
           address = updateTextField.getText();
        }
        
        else if (selectedItem == "phone") 
        {
           phone = updateTextField.getText();
        }
        
        else if (selectedItem == "cvr") 
        {
           cvr = updateTextField.getText();
        }
        
        else if (selectedItem == "name") 
        {
           name = updateTextField.getText();
        }
        
        int vendorId = Integer.parseInt(hiddenStuffVendor.getText());
        
        Vendor vendor = vendorCTRL.updateVendor(vendorId, name, cvr, address, postalCode, phone);
        em.getTransaction().commit();
        System.out.println("Persisted " + vendorId);
        em.close();
        emf.close();
        refreshVendorsTableActionPerformed(evt);
         WebOptionPane.showMessageDialog(rootPane, "The vendor was updated successfully", "Confirmation", WIDTH, null);
        }}}
        catch(NumberFormatException ne) 
        {
        WebOptionPane.showMessageDialog(rootPane, "Please type correct data", "Missing field", WIDTH, null);
        }
        
        catch (PersistenceException ex) 
        {
             WebOptionPane.showMessageDialog(rootPane, "Too long input", "Error", WIDTH, null);
        }
        catch (Exception ex)
        {
            WebOptionPane.showMessageDialog(rootPane, "Select the vendor id from the table", "Error", WIDTH, null);
        }
    }//GEN-LAST:event_updateVendorActionPerformed

    private void vendorSearchTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vendorSearchTableMouseClicked
        Point point = evt.getPoint();
        int row,column;
        row = vendorSearchTable.rowAtPoint(point);
        column = vendorSearchTable.columnAtPoint(point);
        String value = (String) vendorSearchTable.getValueAt(row,column);
        hiddenStuffVendor.setText(value);
    }//GEN-LAST:event_vendorSearchTableMouseClicked

    private void deactivateVendorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deactivateVendorActionPerformed
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("StockManagmentSystemPU");
            EntityManager em = emf.createEntityManager();
            VendorCTRL vendorCTRL = new VendorCTRL(em);
            
          
            int vendorId = Integer.parseInt(hiddenStuffVendor.getText());
            short active = 0;
            
            em.getTransaction().begin();
            
            Vendor vendor = vendorCTRL.updateVendorStatus(vendorId, active);
            em.getTransaction().commit();
            System.out.println("Persisted " + vendor);
            em.close();
            emf.close();
            displayTableData();
            WebOptionPane.showMessageDialog(rootPane, "The vendor was successfully deactivated", "Confirmation", WIDTH, null);
        } catch (ClassNotFoundException ex) {
            WebOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error", WIDTH, null);
        } catch (SQLException ex) {
            WebOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error", WIDTH, null);
        }
        catch(Exception e) {
             WebOptionPane.showMessageDialog(rootPane, "Select the product id from the table", "Error", WIDTH, null);
        }
    }//GEN-LAST:event_deactivateVendorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addVendorButton;
    private javax.swing.JTextField addressField;
    private javax.swing.JComboBox attributeToUpdateComboBox;
    private javax.swing.JButton clearFieldsButton;
    private javax.swing.JTextField countryField;
    private javax.swing.JTextField cvrField;
    private javax.swing.JButton deactivateVendor;
    private javax.swing.JButton findVendorByID;
    private javax.swing.JLabel hiddenStuffVendor;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField phoneField;
    private javax.swing.JTextField postalCodeField;
    private javax.swing.JButton refreshVendorsTable;
    private javax.swing.JTextField updateTextField;
    private javax.swing.JButton updateVendor;
    private javax.swing.JTextField vendorIdTextField;
    private javax.swing.JTable vendorSearchTable;
    private javax.swing.JTable vendorTable;
    // End of variables declaration//GEN-END:variables
}
