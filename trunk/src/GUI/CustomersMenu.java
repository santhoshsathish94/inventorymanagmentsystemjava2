package GUI;

import BLL.Customer;
import CTRL.CustomerCTRL;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.swing.table.DefaultTableModel;

public class CustomersMenu extends javax.swing.JFrame {
    
        protected EntityManager em;
        CustomerCTRL cctrl = new CustomerCTRL(em);
    
    public CustomersMenu() throws ClassNotFoundException, SQLException 
    {
        initComponents();
        displayTableData();
        myInitCompoments();
    }
    
    public void displayTableData() throws ClassNotFoundException, SQLException
    {
        try{
        DBConnection dbCon = new DBConnection(true);
        Statement state =  dbCon.createStatement();
        
        ResultSet rs = state.executeQuery("Select * from Customer");
        ResultSetMetaData rsmetadata = rs.getMetaData();
        
        int columns = rsmetadata.getColumnCount();
        
        DefaultTableModel dtm = new DefaultTableModel() {
        @Override
         public boolean isCellEditable(int row, int column) 
         {
        return false;
         }};
        
        
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
        
        customersTable.setModel(dtm);
        } catch(SQLException sql) {
            WebOptionPane.showMessageDialog(rootPane, "Connection error, please try again", "Connection error", WIDTH, null);
        }
    }
    
    protected void myInitCompoments()
    {
        WebLookAndFeel.install();
        setLocationRelativeTo(null);
        hiddenstuff.setVisible(false);
    }
    
  
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        refreshCustomerTableButton = new javax.swing.JButton();
        deleteCustomerButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        customersTable = new javax.swing.JTable();
        hiddenstuff = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        usernameText = new javax.swing.JTextField();
        lnameText = new javax.swing.JTextField();
        fnameText = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        postalcodeText = new javax.swing.JTextField();
        countryText = new javax.swing.JTextField();
        phoneText = new javax.swing.JTextField();
        CreateCustomerButton = new javax.swing.JButton();
        ClearButton = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        passwordText = new javax.swing.JPasswordField();
        addressText = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        findCustomerButton = new javax.swing.JButton();
        searchCustomerField = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        selectedAttributeToUpdate = new javax.swing.JComboBox();
        updateTextField = new javax.swing.JTextField();
        updateCustomerButton = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        searchCustomerTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Customers");
        setResizable(false);

        refreshCustomerTableButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        refreshCustomerTableButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/refresh_icon.png"))); // NOI18N
        refreshCustomerTableButton.setText("Refresh");
        refreshCustomerTableButton.setPreferredSize(new java.awt.Dimension(109, 41));
        refreshCustomerTableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshCustomerTableButtonActionPerformed(evt);
            }
        });

        deleteCustomerButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        deleteCustomerButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/delete_icon.png"))); // NOI18N
        deleteCustomerButton.setText("Delete ");
        deleteCustomerButton.setToolTipText("To delete customer select the customers id from the table");
        deleteCustomerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCustomerButtonActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/customers_icon.png"))); // NOI18N

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/back_icon.png"))); // NOI18N
        jButton9.setText("Main Menu");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        customersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        customersTable.getTableHeader().setResizingAllowed(false);
        customersTable.getTableHeader().setReorderingAllowed(false);
        customersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customersTableMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                customersTableMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(customersTable);

        hiddenstuff.setText("HIDDEN STUFF");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(refreshCustomerTableButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deleteCustomerButton)
                        .addGap(104, 104, 104)
                        .addComponent(hiddenstuff)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 400, Short.MAX_VALUE)
                        .addComponent(jButton9))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(1, 1, 1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(refreshCustomerTableButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(deleteCustomerButton)
                        .addComponent(hiddenstuff))
                    .addComponent(jButton9))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Customers", jPanel1);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/customers_icon.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("First Name");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Last Name");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Username");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Password");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Address");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Postal Code");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Country");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Phone");

        phoneText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneTextActionPerformed(evt);
            }
        });

        CreateCustomerButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        CreateCustomerButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/add_icon.png"))); // NOI18N
        CreateCustomerButton.setText("Add");
        CreateCustomerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateCustomerButtonActionPerformed(evt);
            }
        });

        ClearButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ClearButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/clear_icon.png"))); // NOI18N
        ClearButton.setText("Clear");
        ClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearButtonActionPerformed(evt);
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

        addressText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressTextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(CreateCustomerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ClearButton))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addGap(10, 10, 10))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addGap(14, 14, 14)))
                            .addGap(13, 13, 13)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(usernameText, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(passwordText, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(jLabel5))
                            .addGap(21, 21, 21)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(fnameText, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lnameText, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(phoneText, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(countryText, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(postalcodeText, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addressText, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 323, Short.MAX_VALUE)
                .addComponent(jLabel2))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton10)
                .addGap(51, 51, 51))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(fnameText, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(addressText, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lnameText, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(postalcodeText, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usernameText, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(countryText, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(phoneText, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(passwordText, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CreateCustomerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
                .addComponent(jButton10)
                .addGap(40, 40, 40))
        );

        jTabbedPane1.addTab("Add New Customer", jPanel2);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/customers_icon.png"))); // NOI18N

        findCustomerButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        findCustomerButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/find_icon.png"))); // NOI18N
        findCustomerButton.setText("Find");
        findCustomerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findCustomerButtonActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Search Customer by last name");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Update");

        selectedAttributeToUpdate.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select atribute to update", "f_name", "l_name", "username", "password", "country", "postal_code", "address", "phone", "orders" }));

        updateCustomerButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/update_icon.png"))); // NOI18N
        updateCustomerButton.setText("Update");
        updateCustomerButton.setToolTipText("To update customers attribute select customer's id form the table then select attribute to update and then type the new input");
        updateCustomerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateCustomerButtonActionPerformed(evt);
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

        searchCustomerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "customer_id", "f_name", "l_name", "username", "password", "country", "postal_code", "address", "phone", "orders"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
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
        searchCustomerTable.getTableHeader().setResizingAllowed(false);
        searchCustomerTable.getTableHeader().setReorderingAllowed(false);
        searchCustomerTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchCustomerTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(searchCustomerTable);
        if (searchCustomerTable.getColumnModel().getColumnCount() > 0) {
            searchCustomerTable.getColumnModel().getColumn(0).setResizable(false);
            searchCustomerTable.getColumnModel().getColumn(1).setResizable(false);
            searchCustomerTable.getColumnModel().getColumn(2).setResizable(false);
            searchCustomerTable.getColumnModel().getColumn(3).setResizable(false);
            searchCustomerTable.getColumnModel().getColumn(4).setResizable(false);
            searchCustomerTable.getColumnModel().getColumn(5).setResizable(false);
            searchCustomerTable.getColumnModel().getColumn(6).setResizable(false);
            searchCustomerTable.getColumnModel().getColumn(7).setResizable(false);
            searchCustomerTable.getColumnModel().getColumn(8).setResizable(false);
            searchCustomerTable.getColumnModel().getColumn(9).setResizable(false);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton11)
                        .addContainerGap())))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(4, 4, 4)
                        .addComponent(searchCustomerField, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(findCustomerButton)
                        .addContainerGap(514, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(18, 18, 18)
                                .addComponent(updateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(updateCustomerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(selectedAttributeToUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 907, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 39, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(searchCustomerField, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                            .addComponent(findCustomerButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(9, 9, 9)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(selectedAttributeToUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(updateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(updateCustomerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
                .addComponent(jButton11)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Update Customer", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1001, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void refreshCustomerTableButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshCustomerTableButtonActionPerformed
                try {
                    displayTableData();
                } catch (ClassNotFoundException ex) {
                    WebOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error", WIDTH, null);
                } catch (SQLException ex) {
                    WebOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error", WIDTH, null);
                }
    }//GEN-LAST:event_refreshCustomerTableButtonActionPerformed

    private void deleteCustomerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteCustomerButtonActionPerformed
        try{
       
       
        int customer_id = Integer.parseInt(hiddenstuff.getText());
        
        if(customer_id == 0) 
        {
          WebOptionPane.showMessageDialog(rootPane, "Select the customer id from the table", "Error", WIDTH, null);  
        }
        else{
            
        int dialog = WebOptionPane.showConfirmDialog(rootPane, "Are you sure that you want to delete this customer", "Confirm", WIDTH);
        if(dialog==WebOptionPane.NO_OPTION || dialog==WebOptionPane.CANCEL_OPTION) 
        {
            
        }    
        else {    
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StockManagmentSystemPU");
        EntityManager em = emf.createEntityManager();
        CustomerCTRL cusCTRL = new CustomerCTRL(em);
        em.getTransaction().begin();
        Customer customer = cusCTRL.removeCustomer(customer_id);
        em.getTransaction().commit();
        System.out.println("Persisted " + customer);
        em.close();
        emf.close();
        WebOptionPane.showMessageDialog(rootPane, "The customer was deleted", "Confirmation", WIDTH, null);
        }}}
        catch(Exception e) {
             WebOptionPane.showMessageDialog(rootPane, "Select the customer id from the table", "Error", WIDTH, null);
        }
            try {
                displayTableData();
            } catch (ClassNotFoundException ex) {
                 WebOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error", WIDTH, null);
            } catch (SQLException ex) {
                 WebOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error", WIDTH, null);
            }
        
    }//GEN-LAST:event_deleteCustomerButtonActionPerformed

    private void CreateCustomerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateCustomerButtonActionPerformed
        try {
        String fname = fnameText.getText();
        if(fname.equals("") || fname.equals(null))
              {
               WebOptionPane.showMessageDialog(rootPane, "Please type first name", "Missing field", WIDTH, null);
              }
        else { 
        String lname = lnameText.getText();
        if(lnameText.equals("") || lnameText.equals(null))
        {
           WebOptionPane.showMessageDialog(rootPane, "Please type last name", "Missing field", WIDTH, null);
        }
        else { 
        String username = usernameText.getText();
        if(username.equals("") || username.equals(null))
        {
           WebOptionPane.showMessageDialog(rootPane, "Please type username", "Missing field", WIDTH, null);
        }
        else {
        String password = passwordText.getText();
        if(password.equals("") || password.equals(null))
        {
           WebOptionPane.showMessageDialog(rootPane, "Please type password", "Missing field", WIDTH, null);
        }
        else {
        String address = addressText.getText();
         if(address.equals("") || address.equals(null))
        {
           WebOptionPane.showMessageDialog(rootPane, "Please type address", "Missing field", WIDTH, null);
        }
        else {
        String country = countryText.getText();
        if(country.equals("") || country.equals(null))
        {
           WebOptionPane.showMessageDialog(rootPane, "Please type country", "Missing field", WIDTH, null);
        }
        else {
        String pc = postalcodeText.getText();
        int postal_code = Integer.parseInt(pc);
        if(postal_code==0)
        {
           WebOptionPane.showMessageDialog(rootPane, "Please type postal code", "Missing field", WIDTH, null);
        }
        else {
        String phone = phoneText.getText();
        if(phone.equals("") || phone.equals(null))
        {
           WebOptionPane.showMessageDialog(rootPane, "Please type phone", "Missing field", WIDTH, null);
        }
        else{

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StockManagmentSystemPU");
        EntityManager em = emf.createEntityManager();
        CustomerCTRL cusCTRL = new CustomerCTRL(em);

        em.getTransaction().begin();
        Customer customer = cusCTRL.createCustomer(address, country, fname, lname, password, phone, postal_code, username);
        em.getTransaction().commit();
        System.out.println("Persisted " + customer);
        em.close();
        emf.close();
        ClearButtonActionPerformed(evt);
        refreshCustomerTableButtonActionPerformed(evt);
        WebOptionPane.showMessageDialog(rootPane, "You have inserted a customer  !", "Successfull insert", WIDTH, null);
        }}}}}}}}
        
        }
        catch(PersistenceException ex)
        {
            WebOptionPane.showMessageDialog(rootPane, "Too long input", "Error", WIDTH, null);
        }
        
        catch(NumberFormatException ne) 
        {
        WebOptionPane.showMessageDialog(rootPane, "Please type correct postal code", "Missing field", WIDTH, null);
        }
        
        catch (Exception e)
        {
         WebOptionPane.showMessageDialog(rootPane, e.getMessage(), "Missing field", WIDTH, null);
           
        }
    }//GEN-LAST:event_CreateCustomerButtonActionPerformed

    private void ClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearButtonActionPerformed
        fnameText.setText(null);
        lnameText.setText(null);
        usernameText.setText(null);
        passwordText.setText(null);
        addressText.setText(null);
        phoneText.setText(null);
        postalcodeText.setText(null);
        countryText.setText(null);
    }//GEN-LAST:event_ClearButtonActionPerformed

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

    private void customersTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customersTableMousePressed
        
        
        
    }//GEN-LAST:event_customersTableMousePressed

    private void customersTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customersTableMouseClicked

        Point point = evt.getPoint();
        int row,column;
        row = customersTable.rowAtPoint(point);
        column = customersTable.columnAtPoint(point);
        String value = (String) customersTable.getValueAt(row,column);
        hiddenstuff.setText(value);
    }//GEN-LAST:event_customersTableMouseClicked

    private void findCustomerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findCustomerButtonActionPerformed
            try {
                DBConnection dbCon = new DBConnection(true);
                Statement state =  dbCon.createStatement();
                
                
                String lastName = searchCustomerField.getText();
                ResultSet rs = state.executeQuery("Select * from Customer Where l_name = " +"'"+lastName+"'");
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
                searchCustomerTable.setModel(dtm);
            } 
            
            catch (NullPointerException ex) {
            WebOptionPane.showMessageDialog(rootPane, "Please type correct input", "Error", WIDTH, null);   
            } 
            
            catch (SQLServerException ex) 
            {
                WebOptionPane.showMessageDialog(rootPane, "Please type correct input", "Error", WIDTH, null);
            } catch (SQLException ex) {
                WebOptionPane.showMessageDialog(rootPane, "Connenction error, please try again", "Connection error", WIDTH, null);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CustomersMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
  
    }//GEN-LAST:event_findCustomerButtonActionPerformed

    private void searchCustomerTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchCustomerTableMouseClicked
        
        Point point = evt.getPoint();
        int row,column;
        row = searchCustomerTable.rowAtPoint(point);
        column = searchCustomerTable.columnAtPoint(point);
        String value = (String) searchCustomerTable.getValueAt(row,column);
        hiddenstuff.setText(value);
        
    }//GEN-LAST:event_searchCustomerTableMouseClicked

    private void updateCustomerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateCustomerButtonActionPerformed
        try {
        String f_name = null ;
        String l_name  = null;
        String username = null ;
        String password = null;
        String address = null ;
        String country = null ;
        int postal_code = 0;
        String phone = null;
        String empty =updateTextField.getText();
        
        if(empty.equals("") || empty=="")
        {
            WebOptionPane.showMessageDialog(rootPane, "     Type some input !", "Error", WIDTH, null);
        }
        else {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StockManagmentSystemPU");
        EntityManager em = emf.createEntityManager();
        CustomerCTRL cusCTRL = new CustomerCTRL(em);

        String selectedItem = selectedAttributeToUpdate.getSelectedItem().toString();
        
        if(selectedItem.equals("Select atribute to update")) 
            {
                WebOptionPane.showMessageDialog(rootPane, "     Select atribute to update !", "Error", WIDTH, null);
            }
            else {
        
        em.getTransaction().begin();
        
        
        if (selectedItem == "postal_code") 
        {
          postal_code = Integer.parseInt(updateTextField.getText());
        }
        
        else if (selectedItem == "address") 
        {
           address = updateTextField.getText();
        }
        
        else if (selectedItem == "country") 
        {
           country = updateTextField.getText();
        }
        
        else if (selectedItem == "phone") 
        {
           phone = updateTextField.getText();
        }
        
        else if (selectedItem == "f_name") 
        {
           f_name = updateTextField.getText();
        }
        
        else if (selectedItem == "l_name") 
        {
           l_name = updateTextField.getText();
        }
        
        else if (selectedItem == "username") 
        {
           username = updateTextField.getText();
        }
        
        else if (selectedItem == "password") 
        {
           password = updateTextField.getText();
        }
        
        
        int customer_id = Integer.parseInt(hiddenstuff.getText());
        
        Customer customer = cusCTRL.updateCustomer(customer_id,address,country,f_name,l_name,password,phone,postal_code,username);
        em.getTransaction().commit();
        System.out.println("Persisted " + customer);
        em.close();
        emf.close();
        refreshCustomerTableButtonActionPerformed(evt);
        WebOptionPane.showMessageDialog(rootPane, "The customer was successfully updated", "Successfull insert", WIDTH, null);
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
            WebOptionPane.showMessageDialog(rootPane, "Select the customer id from the table", "Error", WIDTH, null);
        }
    }//GEN-LAST:event_updateCustomerButtonActionPerformed

    private void addressTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressTextActionPerformed

    private void phoneTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneTextActionPerformed

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton ClearButton;
    private javax.swing.JButton CreateCustomerButton;
    private javax.swing.JTextField addressText;
    private javax.swing.JTextField countryText;
    private javax.swing.JTable customersTable;
    private javax.swing.JButton deleteCustomerButton;
    private javax.swing.JButton findCustomerButton;
    private javax.swing.JTextField fnameText;
    private static javax.swing.JLabel hiddenstuff;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField lnameText;
    private javax.swing.JPasswordField passwordText;
    private javax.swing.JTextField phoneText;
    private javax.swing.JTextField postalcodeText;
    protected javax.swing.JButton refreshCustomerTableButton;
    private javax.swing.JTextField searchCustomerField;
    private javax.swing.JTable searchCustomerTable;
    private javax.swing.JComboBox selectedAttributeToUpdate;
    private javax.swing.JButton updateCustomerButton;
    private javax.swing.JTextField updateTextField;
    private javax.swing.JTextField usernameText;
    // End of variables declaration//GEN-END:variables
}
