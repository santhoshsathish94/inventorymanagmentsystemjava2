package GUI;

import BLL.Users;
import CTRL.UsersCTRL;
import CTRL.PasswordCTRL;
import DB.DBConnection;
import com.alee.laf.WebLookAndFeel;
import com.alee.laf.optionpane.WebOptionPane;
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
 

public class AdminUsersMenu extends javax.swing.JFrame {

   
    public AdminUsersMenu() throws ClassNotFoundException, SQLException {
        initComponents();
        displayTableData();
        myInitCompoments();
    }

    public void displayTableData() throws ClassNotFoundException, SQLException
    {
        try{
        DBConnection dbCon = new DBConnection(true);
        Statement state =  dbCon.createStatement();
        
        ResultSet rs = state.executeQuery("Select * from Users");
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
       
        usersTable.setModel(dtm);
        }catch(SQLException sql) {
            WebOptionPane.showMessageDialog(rootPane, "Connection error, please try again", "Connection error", WIDTH, null);
        }
        
        
    }
    
    protected void myInitCompoments()
    {
        
        WebLookAndFeel.install();
        setLocationRelativeTo(null);
        hiddenStuffUsers.setVisible(false);
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        usersTable = new javax.swing.JTable();
        deleteUserButton = new javax.swing.JButton();
        refreshUsersTableButton = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        changeUserTypeButton = new javax.swing.JButton();
        selectTypeUserComboBox = new javax.swing.JComboBox();
        hiddenStuffUsers = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        fName = new javax.swing.JTextField();
        lName = new javax.swing.JTextField();
        username = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        addUserButton = new javax.swing.JButton();
        clearFieldsButton = new javax.swing.JButton();
        typeComboBox = new javax.swing.JComboBox();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Users [Admin Mode]");
        setAlwaysOnTop(true);
        setResizable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/users_icon.png"))); // NOI18N

        usersTable.setModel(new javax.swing.table.DefaultTableModel(
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
                {}
            },
            new String [] {

            }
        ));
        usersTable.setToolTipText("");
        usersTable.getTableHeader().setResizingAllowed(false);
        usersTable.getTableHeader().setReorderingAllowed(false);
        usersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usersTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(usersTable);

        deleteUserButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        deleteUserButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/delete_icon.png"))); // NOI18N
        deleteUserButton.setText("Delete");
        deleteUserButton.setToolTipText("To delete user select the user's id from the table");
        deleteUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteUserButtonActionPerformed(evt);
            }
        });

        refreshUsersTableButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        refreshUsersTableButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/refresh_icon.png"))); // NOI18N
        refreshUsersTableButton.setText("Refresh");
        refreshUsersTableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshUsersTableButtonActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/back_icon.png"))); // NOI18N
        jButton6.setText("Main Menu");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        changeUserTypeButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        changeUserTypeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/change_icon.png"))); // NOI18N
        changeUserTypeButton.setText("Change user type");
        changeUserTypeButton.setToolTipText("To change users type select the users id from the table and then select the new type");
        changeUserTypeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeUserTypeButtonActionPerformed(evt);
            }
        });

        selectTypeUserComboBox.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        selectTypeUserComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Type", "1", "2", "3", "4" }));
        selectTypeUserComboBox.setMinimumSize(new java.awt.Dimension(91, 41));
        selectTypeUserComboBox.setName(""); // NOI18N

        hiddenStuffUsers.setText("HIDDENSTUFF");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(refreshUsersTableButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deleteUserButton)
                        .addGap(18, 18, 18)
                        .addComponent(changeUserTypeButton)
                        .addGap(18, 18, 18)
                        .addComponent(selectTypeUserComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(hiddenStuffUsers)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(50, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(selectTypeUserComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(hiddenStuffUsers)
                        .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(deleteUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(refreshUsersTableButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(changeUserTypeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Users", jPanel1);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/users_icon.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("First Name");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Last Name");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Username");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Password");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Type");

        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });

        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });

        addUserButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        addUserButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/add_icon.png"))); // NOI18N
        addUserButton.setText("Add");
        addUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUserButtonActionPerformed(evt);
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

        typeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select type :", "Manager", "Analyzer", "Sales" }));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/back_icon.png"))); // NOI18N
        jButton5.setText("Main Menu");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(856, 856, 856)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5)
                        .addGap(4, 4, 4)
                        .addComponent(fName, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel6)
                        .addGap(5, 5, 5)
                        .addComponent(lName, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel7)
                        .addGap(4, 4, 4)
                        .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel8)
                        .addGap(10, 10, 10)
                        .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel9)
                        .addGap(36, 36, 36)
                        .addComponent(typeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(addUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(clearFieldsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jButton5)
                .addGap(42, 42, 42))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5))
                    .addComponent(fName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel6))
                    .addComponent(lName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel7))
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel8))
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel9))
                    .addComponent(typeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addUserButton)
                    .addComponent(clearFieldsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addComponent(jButton5))
        );

        jTabbedPane1.addTab("Add New User", jPanel2);

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

    private void clearFieldsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearFieldsButtonActionPerformed
        fName.setText(null);
        lName.setText(null);
        username.setText(null);
        password.setText(null);
        typeComboBox.setSelectedIndex(0);
    }//GEN-LAST:event_clearFieldsButtonActionPerformed

    private void addUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUserButtonActionPerformed
        try {
              String uname = username.getText();
              if(uname.equals("") || uname.equals(null))
              {
                  WebOptionPane.showMessageDialog(rootPane, "Please type username", "Missing field", WIDTH, null);
              }
              else {  
            if(typeComboBox.getSelectedItem() == "Select type :") 
            {
                WebOptionPane.showMessageDialog(rootPane, "Select the correct type", "Missing field", WIDTH, null);
            }
            else
            {
              String type = typeComboBox.getSelectedItem().toString();
              
              String fname = fName.getText();
              if(fname.equals("") || fname.equals(null))
              {
                  WebOptionPane.showMessageDialog(rootPane, "Please type first name", "Missing field", WIDTH, null);
              }
              else {
              String lname = lName.getText();
              if(lname.equals("") || lname.equals(null))
              {
                  WebOptionPane.showMessageDialog(rootPane, "Please type last name", "Missing field", WIDTH, null);
              }
              else {   
               
              String pass = password.getText();
              PasswordCTRL passwordCTRL = new PasswordCTRL();
              String hash = passwordCTRL.getSaltedHash(pass);
            
            
            
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("StockManagmentSystemPU");
            EntityManager em = emf.createEntityManager();
            UsersCTRL userCTRL = new UsersCTRL(em);
            
            em.getTransaction().begin();
            Users customer = userCTRL.createUser(uname, hash, type, fname, lname);
            em.getTransaction().commit();
            em.close();
            emf.close();
            clearFieldsButtonActionPerformed(evt);
            refreshUsersTableButtonActionPerformed(evt);
             }}}}
              WebOptionPane.showMessageDialog(rootPane, "You have inserted an user  !", "Successfull insert", WIDTH, null);
        } catch (PersistenceException ex) {
             WebOptionPane.showMessageDialog(rootPane, "Too long input", "Error", WIDTH, null);
        }
        catch(Exception e) 
        {
        WebOptionPane.showMessageDialog(rootPane, e.getMessage(), "Error", WIDTH, null);
        }
    }//GEN-LAST:event_addUserButtonActionPerformed

    private void deleteUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteUserButtonActionPerformed
        try {
            
        int user_id = Integer.parseInt(hiddenStuffUsers.getText());
        
        if(user_id == 0) 
        {
          WebOptionPane.showMessageDialog(rootPane, "Select the user id from the table", "Error", WIDTH, null);  
        }
        else {
            
        int dialog = WebOptionPane.showConfirmDialog(rootPane, "Are you sure that you want to delete this user", "Confirm", WIDTH);
        if(dialog==WebOptionPane.NO_OPTION || dialog==WebOptionPane.CANCEL_OPTION) 
        {
            
        }    
        else {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StockManagmentSystemPU");
        EntityManager em = emf.createEntityManager();
        UsersCTRL usersCTRL = new UsersCTRL(em);
       
        
        
        em.getTransaction().begin();
        Users user = usersCTRL.removeUser(user_id);
        em.getTransaction().commit();
        System.out.println("Persisted " + user);
        em.close();
        emf.close();
        WebOptionPane.showMessageDialog(rootPane, "The user was deleted", "Confirmation", WIDTH, null);
        }}
        }catch(Exception e) {
            WebOptionPane.showMessageDialog(rootPane, "Select the user id from the table", "Error", WIDTH, null);
        }
            try {
                displayTableData();
            } catch (ClassNotFoundException ex) {
                WebOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error", WIDTH, null);
            } catch (SQLException ex) {
                WebOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error", WIDTH, null);
            }
            
    }//GEN-LAST:event_deleteUserButtonActionPerformed
    
    private void refreshUsersTableButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshUsersTableButtonActionPerformed
        try {
            displayTableData();
        } 
        catch (Exception e) {
            WebOptionPane.showMessageDialog(rootPane, e.getMessage(), "Error", WIDTH, null);
        }
    }//GEN-LAST:event_refreshUsersTableButtonActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        setVisible(false);
        AdminMenu adminMenu = new AdminMenu();
        adminMenu.setVisible(true); 
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
          jButton6ActionPerformed(null);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void usersTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usersTableMouseClicked
        Point point = evt.getPoint();
        int row,column;
        row = usersTable.rowAtPoint(point);
        column = usersTable.columnAtPoint(point);
        String value = (String) usersTable.getValueAt(row,column);
        hiddenStuffUsers.setText(value);
    }//GEN-LAST:event_usersTableMouseClicked

    private void changeUserTypeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeUserTypeButtonActionPerformed
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("StockManagmentSystemPU");
            EntityManager em = emf.createEntityManager();
            UsersCTRL userCTRL = new UsersCTRL(em);
            
            String selectedItem = selectTypeUserComboBox.getSelectedItem().toString();
            
            if(selectedItem.equals("Select Type")) 
            {
                WebOptionPane.showMessageDialog(rootPane, "     Select type !", "Error", WIDTH, null);
            }
            else {
            
            
            int user_id = Integer.parseInt(hiddenStuffUsers.getText());
            
            em.getTransaction().begin();
            
            Users user = userCTRL.updateUserType(user_id, selectedItem);
            em.getTransaction().commit();
            System.out.println("Persisted " + user);
            em.close();
            emf.close();
            displayTableData();
            }
            WebOptionPane.showMessageDialog(rootPane, "The users type was successfully updated", "Successfull insert", WIDTH, null);
        } catch (ClassNotFoundException ex) {
            WebOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error", WIDTH, null);
        } catch (SQLException ex) {
            WebOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error", WIDTH, null);
        }
        catch (Exception e) {
            WebOptionPane.showMessageDialog(rootPane, "Select the user id from the table", "Error", WIDTH, null);
        }
    }//GEN-LAST:event_changeUserTypeButtonActionPerformed

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addUserButton;
    private javax.swing.JButton changeUserTypeButton;
    private javax.swing.JButton clearFieldsButton;
    private javax.swing.JButton deleteUserButton;
    private javax.swing.JTextField fName;
    private javax.swing.JLabel hiddenStuffUsers;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField lName;
    private javax.swing.JPasswordField password;
    private javax.swing.JButton refreshUsersTableButton;
    private javax.swing.JComboBox selectTypeUserComboBox;
    private javax.swing.JComboBox typeComboBox;
    private javax.swing.JTextField username;
    private javax.swing.JTable usersTable;
    // End of variables declaration//GEN-END:variables
}
