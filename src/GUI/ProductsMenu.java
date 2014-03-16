package GUI;

import BLL.Product;
import BLL.Vendor;
import CTRL.ProductCTRL;
import java.awt.Point;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.table.DefaultTableModel;
import DB.DBConnection;
import com.alee.laf.WebLookAndFeel;
import com.alee.laf.optionpane.WebOptionPane;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import static java.awt.image.ImageObserver.WIDTH;
import java.math.BigDecimal;
import javax.persistence.PersistenceException;

public class ProductsMenu extends javax.swing.JFrame {

   
    public ProductsMenu() throws ClassNotFoundException, SQLException {
        initComponents();
        displayTableData();
        myInitCompoments();
    }
    
     public void displayTableData() throws ClassNotFoundException, SQLException
    {
        DBConnection dbCon = new DBConnection(true);
        Statement state =  dbCon.createStatement();
        
        ResultSet rs = state.executeQuery("Select * from Product");
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
        
        productsTable.setModel(dtm);
    }

      protected void myInitCompoments()
    {
        WebLookAndFeel.install();
        setLocationRelativeTo(null);
        hiddeStuffProducts.setVisible(false);
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        refreshTableButton = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        productsTable = new javax.swing.JTable();
        refreshProductsTable = new javax.swing.JButton();
        DeleteProductButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        orderByComboBox = new javax.swing.JComboBox();
        orderButton = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        hiddeStuffProducts = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        productNoField = new javax.swing.JTextField();
        categoryField = new javax.swing.JTextField();
        vendorField = new javax.swing.JTextField();
        nameField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        sizeField = new javax.swing.JTextField();
        weightField = new javax.swing.JTextField();
        priceField = new javax.swing.JTextField();
        addProductButton = new javax.swing.JButton();
        clearFieldsButton = new javax.swing.JButton();
        quantityField = new javax.swing.JSpinner();
        jButton10 = new javax.swing.JButton();
        countryField = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        updateProductField = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        selectedAttributeToUpdateComboBox = new javax.swing.JComboBox();
        updateTextField = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        productsSearchTable = new javax.swing.JTable();
        updateButton = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Products");
        setResizable(false);

        productsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        productsTable.getTableHeader().setResizingAllowed(false);
        productsTable.getTableHeader().setReorderingAllowed(false);
        productsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productsTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(productsTable);

        refreshProductsTable.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        refreshProductsTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/refresh_icon.png"))); // NOI18N
        refreshProductsTable.setText("Refresh");
        refreshProductsTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshProductsTableActionPerformed(evt);
            }
        });

        DeleteProductButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        DeleteProductButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/delete_icon.png"))); // NOI18N
        DeleteProductButton.setText("Delete ");
        DeleteProductButton.setToolTipText("To delete product select the products id from the table");
        DeleteProductButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteProductButtonActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/products_icon.png"))); // NOI18N

        orderByComboBox.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        orderByComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Order by :", "category", "name", "size" }));

        orderButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        orderButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/order_icon.png"))); // NOI18N
        orderButton.setText("Order");
        orderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderButtonActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/back_icon.png"))); // NOI18N
        jButton9.setText("Main Menu");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        hiddeStuffProducts.setText("HIDDENSTUFF");

        javax.swing.GroupLayout refreshTableButtonLayout = new javax.swing.GroupLayout(refreshTableButton);
        refreshTableButton.setLayout(refreshTableButtonLayout);
        refreshTableButtonLayout.setHorizontalGroup(
            refreshTableButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(refreshTableButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(refreshTableButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, refreshTableButtonLayout.createSequentialGroup()
                        .addComponent(refreshProductsTable)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DeleteProductButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(orderButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(orderByComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(hiddeStuffProducts)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 344, Short.MAX_VALUE)
                        .addComponent(jButton9))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, refreshTableButtonLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addContainerGap())
        );
        refreshTableButtonLayout.setVerticalGroup(
            refreshTableButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(refreshTableButtonLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(refreshTableButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(refreshProductsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteProductButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(orderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(orderByComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hiddeStuffProducts)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Products", refreshTableButton);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/products_icon.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Name");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Category");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Product No.");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Vendor ID");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Quantity");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Size");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Weight");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Price");

        addProductButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        addProductButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/add_icon.png"))); // NOI18N
        addProductButton.setText("Add");
        addProductButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProductButtonActionPerformed(evt);
            }
        });

        clearFieldsButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        clearFieldsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/clear_icon.png"))); // NOI18N
        clearFieldsButton.setText("Clear");
        clearFieldsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearFieldsButtonActionPerformed(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/back_icon.png"))); // NOI18N
        jButton10.setText("Main Menu");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Country");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(42, 42, 42)
                        .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(22, 22, 22)
                        .addComponent(categoryField, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel15))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(addProductButton, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(clearFieldsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(countryField, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(vendorField, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(productNoField, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(39, 39, 39)
                        .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(27, 27, 27)
                        .addComponent(weightField, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(44, 44, 44)
                        .addComponent(sizeField, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(quantityField, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(219, 378, Short.MAX_VALUE)
                .addComponent(jLabel2))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton10)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel9))
                    .addComponent(jLabel2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(quantityField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sizeField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(categoryField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(weightField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(productNoField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(vendorField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(countryField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addProductButton)
                    .addComponent(clearFieldsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        jTabbedPane1.addTab("Add New Product", jPanel2);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/products_icon.png"))); // NOI18N

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/find_icon.png"))); // NOI18N
        jButton7.setText("Find");
        jButton7.setPreferredSize(new java.awt.Dimension(75, 31));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Search Product by ID");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Update");

        selectedAttributeToUpdateComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select atribute to update", "name", "category", "country", "vendorId", "quantity", "size1", "weight", "price" }));

        productsSearchTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "product_id", "category", "name", "product_int_no", "country", "vendor_id", "quantity", "size1", "weight", "price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        productsSearchTable.getTableHeader().setResizingAllowed(false);
        productsSearchTable.getTableHeader().setReorderingAllowed(false);
        productsSearchTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productsSearchTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(productsSearchTable);
        if (productsSearchTable.getColumnModel().getColumnCount() > 0) {
            productsSearchTable.getColumnModel().getColumn(0).setResizable(false);
            productsSearchTable.getColumnModel().getColumn(1).setResizable(false);
            productsSearchTable.getColumnModel().getColumn(2).setResizable(false);
            productsSearchTable.getColumnModel().getColumn(3).setResizable(false);
            productsSearchTable.getColumnModel().getColumn(4).setResizable(false);
            productsSearchTable.getColumnModel().getColumn(5).setResizable(false);
            productsSearchTable.getColumnModel().getColumn(6).setResizable(false);
            productsSearchTable.getColumnModel().getColumn(7).setResizable(false);
            productsSearchTable.getColumnModel().getColumn(8).setResizable(false);
            productsSearchTable.getColumnModel().getColumn(9).setResizable(false);
        }

        updateButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/update_icon.png"))); // NOI18N
        updateButton.setText("Update");
        updateButton.setToolTipText("To update product attribute select product's id form the table then select attribute to update and then type the new input");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        jButton11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/back_icon.png"))); // NOI18N
        jButton11.setText("Main Menu");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

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
                        .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jButton11)
                                .addContainerGap())))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 977, Short.MAX_VALUE)
                        .addGap(10, 10, 10))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(updateProductField, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(selectedAttributeToUpdateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(updateProductField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(selectedAttributeToUpdateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(updateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Update Product", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void refreshProductsTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshProductsTableActionPerformed
        try {
            displayTableData();
        } catch (ClassNotFoundException ex) {
            WebOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error", WIDTH, null);
        } catch (SQLException ex) {
            WebOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error", WIDTH, null);
        }
    }//GEN-LAST:event_refreshProductsTableActionPerformed

    private void DeleteProductButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteProductButtonActionPerformed
        try {
        int product_id = Integer.parseInt(hiddeStuffProducts.getText());
        
        if(product_id == 0) 
        {
          WebOptionPane.showMessageDialog(rootPane, "Select the product id from the table", "Error", WIDTH, null);  
        }
        
        else{
            
        int dialog = WebOptionPane.showConfirmDialog(rootPane, "Are you sure that you want to delete this product", "Confirm", WIDTH);
        if(dialog==WebOptionPane.NO_OPTION || dialog==WebOptionPane.CANCEL_OPTION) 
        {
            
        }   
        else { 
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StockManagmentSystemPU");
        EntityManager em = emf.createEntityManager();
        ProductCTRL productCTRL = new ProductCTRL(em);
        em.getTransaction().begin();
        Product product = productCTRL.removeCustomer(product_id);
        em.getTransaction().commit();
        System.out.println("Persisted " + product);
        em.close();
        emf.close();
        WebOptionPane.showMessageDialog(rootPane, "The product was deleted", "Confirmation", WIDTH, null);
        }}}
        catch(Exception e) {
             WebOptionPane.showMessageDialog(rootPane, "Select the product id from the table", "Error", WIDTH, null);
        }
            try {
                displayTableData();
            } catch (ClassNotFoundException ex) {
                WebOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error", WIDTH, null);
            } catch (SQLException ex) {
                WebOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error", WIDTH, null);
            }
    }//GEN-LAST:event_DeleteProductButtonActionPerformed

    private void addProductButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProductButtonActionPerformed
        try {
            String name = nameField.getText();
            if(name.equals("") || name.equals(null))
              {
               WebOptionPane.showMessageDialog(rootPane, "Please type name", "Missing field", WIDTH, null);
              }
        else { 
            String category = categoryField.getText();
            if(category.equals("") || category.equals(null))
              {
               WebOptionPane.showMessageDialog(rootPane, "Please type category", "Missing field", WIDTH, null);
              }
        else { 
            int productIntNo = Integer.parseInt(productNoField.getText());
            if(productIntNo==0)
              {
               WebOptionPane.showMessageDialog(rootPane, "Please type category", "Missing field", WIDTH, null);
              }
        else { 
            String venId =  vendorField.getText();
            int vid = Integer.parseInt(venId);
            Vendor vendorId = new Vendor(vid);
            if(vendorId.equals(null)|| vendorId==null)
              {
               WebOptionPane.showMessageDialog(rootPane, "Please type vendor Id", "Missing field", WIDTH, null);
              }
        else { 
            String size1 = sizeField.getText();
            if(size1.equals(null)|| size1==null)
              {
               WebOptionPane.showMessageDialog(rootPane, "Please type size", "Missing field", WIDTH, null);
              }
        else { 
            String weight =  weightField.getText();
            if(weight.equals(null)|| weight==null)
              {
               WebOptionPane.showMessageDialog(rootPane, "Please type weight", "Missing field", WIDTH, null);
              }
        else { 
            String country = countryField.getText();
            if(country.equals(null)|| country==null)
              {
               WebOptionPane.showMessageDialog(rootPane, "Please type country", "Missing field", WIDTH, null);
              }
        else { 
            
            int quantity = (Integer)quantityField.getValue();
            if(quantity==0)
              {
               WebOptionPane.showMessageDialog(rootPane, "Please type quantity", "Missing field", WIDTH, null);
              }
        else { 
            String pr = priceField.getText();
            double p = Double.valueOf(pr);
            BigDecimal price = BigDecimal.valueOf(p);
            if(price==null || price.equals(null))
              {
               WebOptionPane.showMessageDialog(rootPane, "Please type price", "Missing field", WIDTH, null);
              }
        else { 
               
            
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("StockManagmentSystemPU");
            EntityManager em = emf.createEntityManager();
            
            ProductCTRL productCTRL = new ProductCTRL(em);
            em.getTransaction().begin();
            Product product = productCTRL.createProduct(category, name, productIntNo, country, quantity, weight, price, size1,vendorId);
            em.getTransaction().commit();
            System.out.println("Persisted " + product);
            em.close();
            emf.close();
            clearFieldsButtonActionPerformed(evt);
            displayTableData();
            WebOptionPane.showMessageDialog(rootPane, "The product was inserted", "Successfull insert", WIDTH, null);
        }}}}}}}}}}
        catch(PersistenceException ex)
        {
            WebOptionPane.showMessageDialog(rootPane, "Please type existing vendor ID", "Error", WIDTH, null);
        } 
        catch (SQLException ex) 
        {
            WebOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error", WIDTH, null);
        } 
        catch (ClassNotFoundException ex)
        {
            Logger.getLogger(ProductsMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(NumberFormatException ne) 
        {
        WebOptionPane.showMessageDialog(rootPane, "Please type correct data", "Missing field", WIDTH, null);
        }
        
        catch (Exception e)
        {
         WebOptionPane.showMessageDialog(rootPane, e.getMessage(), "Missing field", WIDTH, null);
           
        }
        
    }//GEN-LAST:event_addProductButtonActionPerformed

    private void clearFieldsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearFieldsButtonActionPerformed
         nameField.setText(null);
         categoryField.setText(null);
         productNoField.setText(null);
         vendorField.setText(null);
         sizeField.setText(null);
         weightField.setText(null);
         priceField.setText(null);
         countryField.setText(null);
    }//GEN-LAST:event_clearFieldsButtonActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        setVisible(false);
        AdminMenu adminMenu = new AdminMenu();
        adminMenu.setVisible(true);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        jButton9ActionPerformed(null);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        jButton9ActionPerformed(null);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void productsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productsTableMouseClicked
        Point point = evt.getPoint();
        int row,column;
        row = productsTable.rowAtPoint(point);
        column = productsTable.columnAtPoint(point);
        String value = (String) productsTable.getValueAt(row,column);
        hiddeStuffProducts.setText(value);
    }//GEN-LAST:event_productsTableMouseClicked

    private void orderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderButtonActionPerformed
            try {
            String selectedItem = orderByComboBox.getSelectedItem().toString();
            
            if(selectedItem == "name")
            {
                try {
                    orderByName();
                } catch (SQLException ex) {
                    WebOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error", WIDTH, null);
                }
            }
            else if (selectedItem == "size")
            {
                try {
                    orderBySize();
                } catch (SQLException ex) {
                    WebOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error", WIDTH, null);
                }
            }
            else if (selectedItem == "category")
            {
                try {
                    orderByCategory();
                } catch (SQLException ex) {
                    WebOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error", WIDTH, null);
                }
            }
            }
            catch(Exception e) 
            {
                 WebOptionPane.showMessageDialog(rootPane, e.getMessage(), "Error", WIDTH, null);
            }
            
    }//GEN-LAST:event_orderButtonActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        try {
            DBConnection dbCon = new DBConnection(true);
            Statement state =  dbCon.createStatement();
            
            String product_id = updateProductField.getText();
            
            ResultSet rs = state.executeQuery("Select * from Product where product_id = "+product_id);
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
            
            productsSearchTable.setModel(dtm);
            rs.close();
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
    }//GEN-LAST:event_jButton7ActionPerformed

    private void productsSearchTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productsSearchTableMouseClicked
        Point point = evt.getPoint();
        int row,column;
        row = productsSearchTable.rowAtPoint(point);
        column = productsSearchTable.columnAtPoint(point);
        String value = (String) productsSearchTable.getValueAt(row,column);
        hiddeStuffProducts.setText(value);
    }//GEN-LAST:event_productsSearchTableMouseClicked

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        try {
            String name = null;
            String country = null;
            String category = null;
            int quantity = 0;
            String weight = null;
            Vendor vendorId = null;
            BigDecimal price = null;
            String size1 = null;
            String empty =updateTextField.getText();
        
         if(empty.equals("") || empty=="")
        {
            WebOptionPane.showMessageDialog(rootPane, "     Type some input !", "Error", WIDTH, null);
        }
        else {
            
            
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("StockManagmentSystemPU");
            EntityManager em = emf.createEntityManager();
            ProductCTRL productCTRL = new ProductCTRL(em);
            
            String selectedItem = selectedAttributeToUpdateComboBox.getSelectedItem().toString();
            
            if(selectedItem.equals("Select atribute to update")) 
            {
                WebOptionPane.showMessageDialog(rootPane, "     Select atribute to update !", "Error", WIDTH, null);
            }
            else {
            
            em.getTransaction().begin();
            
            if (selectedItem == "name")
            {
                name = updateTextField.getText();
            }
            
            else if (selectedItem == "country")
            {
                country = updateTextField.getText();
            }
            
            else if (selectedItem == "category")
            {
                category = updateTextField.getText();
            }
            
            else if (selectedItem == "quantity")
            {
                quantity = Integer.parseInt(updateTextField.getText());
            }
            
            else if (selectedItem == "weight")
            {
                weight = updateTextField.getText();
            }
            
            else if (selectedItem == "vendorId")
            {
                 String venId =  updateTextField.getText();
                 int vid = Integer.parseInt(venId);
                 vendorId = new Vendor(vid);
            }
            
            else if (selectedItem == "price")
            {
                String pr = updateTextField.getText();
                double p = Double.valueOf(pr);
                price = BigDecimal.valueOf(p);
            }
            
            else if (selectedItem == "size1")
            {
                size1 = updateTextField.getText();
            }
            
            
            int product_id = Integer.parseInt(hiddeStuffProducts.getText());
            
            Product product = productCTRL.updateProduct(product_id, category, name, country, quantity, weight, price, size1,vendorId);
            em.getTransaction().commit();
            System.out.println("Persisted " + product_id);
            em.close();
            emf.close();
            displayTableData();
            WebOptionPane.showMessageDialog(rootPane, "The product was successfully updated", "Successfull insert", WIDTH, null);
        }}}
         catch (PersistenceException ex) 
        {
             WebOptionPane.showMessageDialog(rootPane, "Too long input", "Error", WIDTH, null);
        }
        catch (Exception ex)
        {
            WebOptionPane.showMessageDialog(rootPane, "Select the product id from the table", "Error", WIDTH, null);
        }
        
    }                                            

    private void vendorSearchTableMouseClicked(java.awt.event.MouseEvent evt) {                                               
        Point point = evt.getPoint();
        int row,column;
        row = productsSearchTable.rowAtPoint(point);
        column = productsSearchTable.columnAtPoint(point);
        String value = (String) productsSearchTable.getValueAt(row,column);
        hiddeStuffProducts.setText(value);
        
        
    }//GEN-LAST:event_updateButtonActionPerformed

    protected void orderByName() throws SQLException
    {
        try {
            DBConnection dbCon = new DBConnection(true);
            Statement state =  dbCon.createStatement();
            
            ResultSet rs = state.executeQuery("select * from product order by name");
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
            
            productsTable.setModel(dtm);
        } catch (ClassNotFoundException ex) {
            WebOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error", WIDTH, null);
        }
    }
    
    protected void orderBySize() throws SQLException
    {
        try {
            DBConnection dbCon = new DBConnection(true);
            Statement state =  dbCon.createStatement();
            
            ResultSet rs = state.executeQuery("select * from product order by size1 desc");
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
            
            productsTable.setModel(dtm);
        } catch (ClassNotFoundException ex) {
           WebOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error", WIDTH, null);
        }
    }
    
    protected void orderByCategory() throws SQLException
    {
        try {
            DBConnection dbCon = new DBConnection(true);
            Statement state =  dbCon.createStatement();
            
            ResultSet rs = state.executeQuery("select * from product order by category");
            ResultSetMetaData rsmetadata = rs.getMetaData();
            
            int columns = rsmetadata.getColumnCount();
            
            DefaultTableModel dtm = new DefaultTableModel();
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
            
            productsTable.setModel(dtm);
        } catch (ClassNotFoundException ex) {
            WebOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error", WIDTH, null);
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeleteProductButton;
    private javax.swing.JButton addProductButton;
    private javax.swing.JTextField categoryField;
    private javax.swing.JButton clearFieldsButton;
    private javax.swing.JTextField countryField;
    private javax.swing.JLabel hiddeStuffProducts;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField nameField;
    private javax.swing.JButton orderButton;
    private javax.swing.JComboBox orderByComboBox;
    private javax.swing.JTextField priceField;
    private javax.swing.JTextField productNoField;
    private javax.swing.JTable productsSearchTable;
    private javax.swing.JTable productsTable;
    private javax.swing.JSpinner quantityField;
    private javax.swing.JButton refreshProductsTable;
    private javax.swing.JPanel refreshTableButton;
    private javax.swing.JComboBox selectedAttributeToUpdateComboBox;
    private javax.swing.JTextField sizeField;
    private javax.swing.JButton updateButton;
    private javax.swing.JTextField updateProductField;
    private javax.swing.JTextField updateTextField;
    private javax.swing.JTextField vendorField;
    private javax.swing.JTextField weightField;
    // End of variables declaration//GEN-END:variables

   
}
