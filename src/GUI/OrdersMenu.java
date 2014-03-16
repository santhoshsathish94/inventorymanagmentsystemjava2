package GUI;

import BLL.Orders;
import DB.DBConnection;
import CTRL.OrderCTRL;
import com.alee.laf.WebLookAndFeel;
import com.alee.laf.optionpane.WebOptionPane;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.awt.Point;
import static java.awt.image.ImageObserver.WIDTH;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.table.DefaultTableModel;
 
public class OrdersMenu extends javax.swing.JFrame {

    protected EntityManager em; 
     
    public OrdersMenu() throws ClassNotFoundException, SQLException {
        initComponents();
        displayTableData();
        myInitCompoments();
        displayCurrentOrdersData();
    }

     public void displayTableData() throws ClassNotFoundException, SQLException
    {
        DBConnection dbCon = new DBConnection(true);
        Statement state =  dbCon.createStatement();
        
        ResultSet rs = state.executeQuery("Select * from Orders");
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
        
        ordersTable.setModel(dtm);
    }
     
     public void displayCurrentOrdersData() throws ClassNotFoundException, SQLException
    {
        DBConnection dbCon = new DBConnection(true);
        Statement state =  dbCon.createStatement();
        
        ResultSet rs = state.executeQuery("Select * from Orders where status = 'pending'");
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
        
        currentOrdersTable.setModel(dtm);
    }
    
    
    
    public void myInitCompoments() throws SQLException, ClassNotFoundException
    {
        WebLookAndFeel.install();
        setLocationRelativeTo(null);
        hiddenStuffOrders.setVisible(false);
        ordersHistory();
    }
    
    public void ordersHistory() throws SQLException, ClassNotFoundException{
        
        DBConnection dbCon = new DBConnection(false);
        Statement statement =  dbCon.createStatement();
        
        ResultSet totalOrdersQuery = statement.executeQuery("SELECT * FROM Orders");
        totalOrdersQuery .last();
        int tOrders = totalOrdersQuery .getRow();
        totalOrdersQuery .beforeFirst();
        
        ResultSet totalSalesQuery = statement.executeQuery("SELECT * FROM Orders WHERE status = 'sold'; ");
        totalSalesQuery.last();
        int tSales = totalSalesQuery.getRow();
        totalSalesQuery.beforeFirst();
        
        ResultSet totalCancelledOrdersQuery = statement.executeQuery("SELECT * FROM Orders WHERE status = 'canceled'; ");
        totalCancelledOrdersQuery.last();
        int tCancelledOrders = totalCancelledOrdersQuery.getRow();
        totalCancelledOrdersQuery.beforeFirst();
        
        ResultSet totalOrdersPendingQuery = statement.executeQuery("SELECT * FROM Orders WHERE status = 'pending'; ");
        totalOrdersPendingQuery.last();
        int tOrdersPending = totalOrdersPendingQuery.getRow();
        totalOrdersPendingQuery.beforeFirst();
        
        
        String totalOrders = Integer.toString(tOrders);
        String totalSales = Integer.toString(tSales);
        String totalCancelledOrders = Integer.toString(tCancelledOrders);
        String totalOrdersPending = Integer.toString(tOrdersPending);
        
        totalOrdersLabel.setText(totalOrders);
        totalSalesLabel.setText(totalSales);
        canceledOrdersTotalLabel.setText(totalCancelledOrders);
        totalOrdersPendingLabel.setText(totalOrdersPending);
        
    }

    private void refreshCustomerTableButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                           
                try {
                    displayTableData();
                } catch (ClassNotFoundException ex) {
                    WebOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error", WIDTH, null);
                } catch (SQLException ex) {
                    WebOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error", WIDTH, null);
                }
    }                   
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ordersTable = new javax.swing.JTable();
        refreshOrdersTable = new javax.swing.JButton();
        deleteOrderButton = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        hiddenStuffOrders = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        totalOrdersLabel = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        totalSalesLabel = new javax.swing.JLabel();
        label32 = new javax.swing.JLabel();
        canceledOrdersTotalLabel = new javax.swing.JLabel();
        refreshInTotal = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel21 = new javax.swing.JLabel();
        totalOrdersByDateLabel = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        totalSalesByDateLabel = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        totalCancelledOrdersByDateLabel = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        displayInTableRadioButton = new javax.swing.JRadioButton();
        showByDateButton = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        ordersHistoryTable = new javax.swing.JTable();
        jButton14 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        totalOrdersPendingLabel = new javax.swing.JLabel();
        statusChangeComboBox = new javax.swing.JComboBox();
        changeStatusToButton = new javax.swing.JButton();
        refreshCurrentOrdersButton = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        currentOrdersTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        orderIdTexField = new javax.swing.JTextField();
        findOrderByID = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jButton16 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        orderDetailsTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        ordersTable.setModel(new javax.swing.table.DefaultTableModel(
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
                {},
                {}
            },
            new String [] {

            }
        ));
        ordersTable.getTableHeader().setResizingAllowed(false);
        ordersTable.getTableHeader().setReorderingAllowed(false);
        ordersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ordersTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ordersTable);

        refreshOrdersTable.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        refreshOrdersTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/refresh_icon.png"))); // NOI18N
        refreshOrdersTable.setText("Refresh");
        refreshOrdersTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshOrdersTableActionPerformed(evt);
            }
        });

        deleteOrderButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        deleteOrderButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/delete_icon.png"))); // NOI18N
        deleteOrderButton.setText("Delete ");
        deleteOrderButton.setToolTipText("To delete order select the orders id from the table");
        deleteOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteOrderButtonActionPerformed(evt);
            }
        });

        jButton12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/back_icon.png"))); // NOI18N
        jButton12.setText("Main Menu");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/orders_icon.png"))); // NOI18N

        hiddenStuffOrders.setText("HIDDEN STUFF");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(refreshOrdersTable)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteOrderButton)
                        .addGap(36, 36, 36)
                        .addComponent(hiddenStuffOrders)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton12))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 895, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel8))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(refreshOrdersTable, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deleteOrderButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(hiddenStuffOrders))
                        .addContainerGap(52, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton12)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("Orders", jPanel3);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Total Orders :");

        totalOrdersLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        totalOrdersLabel.setText("n/a");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Total Sales :");

        totalSalesLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        totalSalesLabel.setText("n/a");

        label32.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        label32.setText("Cancelled Orders :");

        canceledOrdersTotalLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        canceledOrdersTotalLabel.setText("n/a");

        refreshInTotal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        refreshInTotal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/refresh_icon.png"))); // NOI18N
        refreshInTotal.setText("Refresh");
        refreshInTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshInTotalActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel20.setText("In total:");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("Total Orders :");

        totalOrdersByDateLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        totalOrdersByDateLabel.setText("n/a");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setText("Total Sales :");

        totalSalesByDateLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        totalSalesByDateLabel.setText("n/a");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setText("Cancelled Orders :");

        totalCancelledOrdersByDateLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        totalCancelledOrdersByDateLabel.setText("n/a");

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel27.setText("By date:");

        displayInTableRadioButton.setText("Display in the table");

        showByDateButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/show_icon.png"))); // NOI18N
        showByDateButton.setText("Show");
        showByDateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showByDateButtonActionPerformed(evt);
            }
        });

        ordersHistoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "order_id", "customer", "order_date", "delivery_date", "status", "price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ordersHistoryTable.getTableHeader().setResizingAllowed(false);
        ordersHistoryTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(ordersHistoryTable);
        if (ordersHistoryTable.getColumnModel().getColumnCount() > 0) {
            ordersHistoryTable.getColumnModel().getColumn(0).setResizable(false);
            ordersHistoryTable.getColumnModel().getColumn(0).setHeaderValue("order_id");
            ordersHistoryTable.getColumnModel().getColumn(1).setResizable(false);
            ordersHistoryTable.getColumnModel().getColumn(1).setHeaderValue("customer");
            ordersHistoryTable.getColumnModel().getColumn(2).setResizable(false);
            ordersHistoryTable.getColumnModel().getColumn(2).setHeaderValue("order_date");
            ordersHistoryTable.getColumnModel().getColumn(3).setResizable(false);
            ordersHistoryTable.getColumnModel().getColumn(3).setHeaderValue("delivery_date");
            ordersHistoryTable.getColumnModel().getColumn(4).setResizable(false);
            ordersHistoryTable.getColumnModel().getColumn(4).setHeaderValue("status");
            ordersHistoryTable.getColumnModel().getColumn(5).setResizable(false);
            ordersHistoryTable.getColumnModel().getColumn(5).setHeaderValue("price");
        }

        jButton14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/back_icon.png"))); // NOI18N
        jButton14.setText("Main Menu");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/orders_icon.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(label32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(canceledOrdersTotalLabel))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalSalesLabel))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalOrdersLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel27)
                    .addComponent(refreshInTotal)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalSalesByDateLabel))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalOrdersByDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(displayInTableRadioButton)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(totalCancelledOrdersByDateLabel))
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addComponent(showByDateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton14))
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addGap(2, 2, 2))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14)
                                    .addComponent(totalOrdersLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16)
                                    .addComponent(totalSalesLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(label32)
                                    .addComponent(canceledOrdersTotalLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(showByDateButton)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(displayInTableRadioButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel21)
                                    .addComponent(totalOrdersByDateLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel23)
                                    .addComponent(totalSalesByDateLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel25)
                                    .addComponent(totalCancelledOrdersByDateLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(refreshInTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jButton14)))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Order History", jPanel5);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Total orders pending :");

        totalOrdersPendingLabel.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        totalOrdersPendingLabel.setText("n/a");

        statusChangeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "Pending", "Confirmed", "Delivered" }));

        changeStatusToButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/change_icon.png"))); // NOI18N
        changeStatusToButton.setText("Change order status to");
        changeStatusToButton.setToolTipText("To change order status select the order id from the table and then select the new type");
        changeStatusToButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeStatusToButtonActionPerformed(evt);
            }
        });

        refreshCurrentOrdersButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/refresh_icon.png"))); // NOI18N
        refreshCurrentOrdersButton.setText("Refresh");
        refreshCurrentOrdersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshCurrentOrdersButtonActionPerformed(evt);
            }
        });

        jButton13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/back_icon.png"))); // NOI18N
        jButton13.setText("Main Menu");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/orders_icon.png"))); // NOI18N

        currentOrdersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        currentOrdersTable.getTableHeader().setResizingAllowed(false);
        currentOrdersTable.getTableHeader().setReorderingAllowed(false);
        currentOrdersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                currentOrdersTableMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(currentOrdersTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(refreshCurrentOrdersButton)
                        .addGap(18, 18, 18)
                        .addComponent(changeStatusToButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(statusChangeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton13)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalOrdersPendingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 945, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(totalOrdersPendingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel11))
                .addGap(3, 3, 3)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refreshCurrentOrdersButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(changeStatusToButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statusChangeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54))
        );

        jTabbedPane1.addTab("Current Orders", jPanel1);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Type Order ID");

        findOrderByID.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        findOrderByID.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/find_icon.png"))); // NOI18N
        findOrderByID.setText("Find");
        findOrderByID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findOrderByIDActionPerformed(evt);
            }
        });

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/orders_icon.png"))); // NOI18N

        jButton16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/back_icon.png"))); // NOI18N
        jButton16.setText("Main Menu");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        orderDetailsTable.setModel(new javax.swing.table.DefaultTableModel(
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
                {},
                {}
            },
            new String [] {

            }
        ));
        orderDetailsTable.getTableHeader().setResizingAllowed(false);
        orderDetailsTable.getTableHeader().setReorderingAllowed(false);
        orderDetailsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                orderDetailsTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(orderDetailsTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(orderIdTexField, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(findOrderByID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton16))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 935, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(findOrderByID, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(orderIdTexField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Order Details", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        jButton12ActionPerformed(null);
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        jButton12ActionPerformed(null);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        jButton12ActionPerformed(null);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void refreshInTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshInTotalActionPerformed
        try {
            ordersHistory();
        } catch (SQLException ex) {
            WebOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error", WIDTH, null);
        } catch (ClassNotFoundException ex) {
            WebOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error", WIDTH, null);
        }
    }//GEN-LAST:event_refreshInTotalActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        setVisible(false);
        AdminMenu adminMenu = new AdminMenu();
        adminMenu.setVisible(true);//
    }//GEN-LAST:event_jButton12ActionPerformed

    private void deleteOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteOrderButtonActionPerformed
        try{
        

        int order_id = Integer.parseInt(hiddenStuffOrders.getText());
        
        if(order_id == 0) 
        {
          WebOptionPane.showMessageDialog(rootPane, "Select the customer id from the table", "Error", WIDTH, null);  
        }
        
        else{
            
        int dialog = WebOptionPane.showConfirmDialog(rootPane, "Are you sure that you want to delete this order", "Confirm", WIDTH);
        if(dialog==WebOptionPane.NO_OPTION || dialog==WebOptionPane.CANCEL_OPTION) 
        {
            
        }   
         else {  
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StockManagmentSystemPU");
        EntityManager em = emf.createEntityManager();
        OrderCTRL orderCTRL = new OrderCTRL(em);
        em.getTransaction().begin();
        Orders order = orderCTRL.removeOrder(order_id);
        em.getTransaction().commit();
        System.out.println("Persisted " + order);
        em.close();
        emf.close();
        WebOptionPane.showMessageDialog(rootPane, "The customer was deleted", "Confirmation", WIDTH, null);
        }}}
        catch(Exception e) {
             WebOptionPane.showMessageDialog(rootPane, "Select the order id from the table", "Error", WIDTH, null);
        }
        try {
            displayTableData();
        } catch (ClassNotFoundException ex) {
            WebOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error", WIDTH, null);
        } catch (SQLException ex) {
            WebOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error", WIDTH, null);
        }
    }//GEN-LAST:event_deleteOrderButtonActionPerformed

    private void refreshOrdersTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshOrdersTableActionPerformed
        try {
            displayTableData();
        } catch (ClassNotFoundException ex) {
            WebOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error", WIDTH, null);
        } catch (SQLException ex) {
            WebOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error", WIDTH, null);
        }
    }//GEN-LAST:event_refreshOrdersTableActionPerformed

    private void ordersTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ordersTableMouseClicked
        Point point = evt.getPoint();
        int row,column;
        row = ordersTable.rowAtPoint(point);
        column = ordersTable.columnAtPoint(point);
        String value = (String) ordersTable.getValueAt(row,column);
        hiddenStuffOrders.setText(value);
    }//GEN-LAST:event_ordersTableMouseClicked

    private void showByDateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showByDateButtonActionPerformed
        try {
            DBConnection dbCon = new DBConnection(false);
            Statement statement =  dbCon.createStatement();
            
            String date = new SimpleDateFormat("YYY-MM-dd").format(jDateChooser1.getDate());
            
            ResultSet totalOrdersByDateQuery = statement.executeQuery("SELECT * FROM Orders where order_date =" +"'"+date+"'" );
            totalOrdersByDateQuery.last();
            int tOrdersByDate = totalOrdersByDateQuery .getRow();
            totalOrdersByDateQuery .beforeFirst();
            
            ResultSet totalSalesByDateQuery = statement.executeQuery("SELECT * FROM Orders WHERE status = 'sold' and order_date = "+"'"+date+"'");
            totalSalesByDateQuery.last();
            int tSalesByDate = totalSalesByDateQuery.getRow();
            totalSalesByDateQuery.beforeFirst();
            
            ResultSet totalCancelledOrdersByDateQuery = statement.executeQuery("SELECT * FROM Orders WHERE status = 'cancelled' and order_date = "+"'"+date+"'");
            totalCancelledOrdersByDateQuery .last();
            int tCancelledOrdersByDate = totalCancelledOrdersByDateQuery .getRow();
            totalCancelledOrdersByDateQuery .beforeFirst();
            
            String totalOrdersByDate = Integer.toString(tOrdersByDate);
            String totalSalesByDate = Integer.toString(tSalesByDate);
            String totalCancelledOrdersByDate = Integer.toString(tCancelledOrdersByDate);
            
            totalOrdersByDateLabel.setText(totalOrdersByDate);
            totalSalesByDateLabel.setText(totalOrdersByDate);
            totalCancelledOrdersByDateLabel.setText(totalOrdersByDate);
            
            if(displayInTableRadioButton.isSelected())
            {
                
        DBConnection dbCon2 = new DBConnection(false);
        Statement state =  dbCon.createStatement();
        
        ResultSet rs = state.executeQuery("Select * from Orders where order_date ="+"'"+date+"'");
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
        
        ordersHistoryTable.setModel(dtm);
                
            }
            
        } catch (NullPointerException ex) {
            WebOptionPane.showMessageDialog(rootPane, "Please type correct input", "Error", WIDTH, null);   
        } 
         catch (SQLServerException ex) 
            {
                WebOptionPane.showMessageDialog(rootPane, "Please type correct date", "Error", WIDTH, null);
            }
        catch (SQLException ex) {
            WebOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error", WIDTH, null);
        } catch (ClassNotFoundException ex) {
            WebOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error", WIDTH, null);
        }
    }//GEN-LAST:event_showByDateButtonActionPerformed

    private void currentOrdersTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_currentOrdersTableMouseClicked
        Point point = evt.getPoint();
        int row,column;
        row = currentOrdersTable.rowAtPoint(point);
        column = currentOrdersTable.columnAtPoint(point);
        String value = (String) currentOrdersTable.getValueAt(row,column);
        hiddenStuffOrders.setText(value);
    }//GEN-LAST:event_currentOrdersTableMouseClicked

    private void changeStatusToButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeStatusToButtonActionPerformed
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("StockManagmentSystemPU");
            EntityManager em = emf.createEntityManager();
            OrderCTRL orderCTRL = new OrderCTRL(em);
            
            String selectedItem = statusChangeComboBox.getSelectedItem().toString();
            
            if(selectedItem.equals("Select")) 
            {
                WebOptionPane.showMessageDialog(rootPane, "     Select the new status !", "Error", WIDTH, null);
            }
            else {
            
            int order_id = Integer.parseInt(hiddenStuffOrders.getText());
            em.getTransaction().begin();
            
            Orders order = orderCTRL.updateOrderStatus(order_id, selectedItem);
            em.getTransaction().commit();
            System.out.println("Persisted " + order);
            em.close();
            emf.close();
            displayTableData();
            WebOptionPane.showMessageDialog(rootPane, "The order status was updated", "Successfull insert", WIDTH, null);
        }}
        catch (ClassNotFoundException ex) {
            WebOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error", WIDTH, null);
        } catch (SQLException ex) {
            WebOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error", WIDTH, null);
        }
        catch (Exception e) {
            WebOptionPane.showMessageDialog(rootPane, "Select the order id from the table", "Error", WIDTH, null);
        }
    }//GEN-LAST:event_changeStatusToButtonActionPerformed

    private void refreshCurrentOrdersButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshCurrentOrdersButtonActionPerformed
        try {
            displayCurrentOrdersData();
        } catch (ClassNotFoundException ex) {
            WebOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error", WIDTH, null);
        } catch (SQLException ex) {
            WebOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error", WIDTH, null);
        }
    }//GEN-LAST:event_refreshCurrentOrdersButtonActionPerformed

    private void orderDetailsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_orderDetailsTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_orderDetailsTableMouseClicked

    private void findOrderByIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findOrderByIDActionPerformed
        try {
            DBConnection dbCon = new DBConnection(true);
            Statement state =  dbCon.createStatement();
            
            String order_id = orderIdTexField.getText();
            
            ResultSet rs = state.executeQuery("Select * from Orders where order_id = "+order_id);
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
            
            orderDetailsTable.setModel(dtm);
        } catch (NullPointerException ex) {
            WebOptionPane.showMessageDialog(rootPane, "Please type correct input", "Error", WIDTH, null);   
        } 
        catch (SQLServerException ex) 
            {
                WebOptionPane.showMessageDialog(rootPane, "Please type correct input", "Error", WIDTH, null);
            }
        catch (SQLException ex) {
            WebOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error", WIDTH, null);
        } catch (ClassNotFoundException ex) {
            WebOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error", WIDTH, null);
        }
    }//GEN-LAST:event_findOrderByIDActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel canceledOrdersTotalLabel;
    private javax.swing.JButton changeStatusToButton;
    private javax.swing.JTable currentOrdersTable;
    private javax.swing.JButton deleteOrderButton;
    private javax.swing.JRadioButton displayInTableRadioButton;
    private javax.swing.JButton findOrderByID;
    private javax.swing.JLabel hiddenStuffOrders;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton16;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel label32;
    private javax.swing.JTable orderDetailsTable;
    private javax.swing.JTextField orderIdTexField;
    private javax.swing.JTable ordersHistoryTable;
    private javax.swing.JTable ordersTable;
    private javax.swing.JButton refreshCurrentOrdersButton;
    private javax.swing.JButton refreshInTotal;
    private javax.swing.JButton refreshOrdersTable;
    private javax.swing.JButton showByDateButton;
    private javax.swing.JComboBox statusChangeComboBox;
    private javax.swing.JLabel totalCancelledOrdersByDateLabel;
    private javax.swing.JLabel totalOrdersByDateLabel;
    private javax.swing.JLabel totalOrdersLabel;
    private javax.swing.JLabel totalOrdersPendingLabel;
    private javax.swing.JLabel totalSalesByDateLabel;
    private javax.swing.JLabel totalSalesLabel;
    // End of variables declaration//GEN-END:variables
}
