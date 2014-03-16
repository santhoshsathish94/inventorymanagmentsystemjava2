package GUI;


import CTRL.PasswordCTRL;
import DB.DBConnection;
import com.alee.laf.WebLookAndFeel;
import com.alee.laf.optionpane.WebOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import org.omg.CORBA.NO_RESPONSE;

public class Login extends javax.swing.JFrame {
    
    private boolean login = false;

    
    public Login() {
        initComponents();
        myComponents();
        
    }

    public void myComponents()
    {   
        setLocationRelativeTo(null);
        JRootPane login = SwingUtilities.getRootPane(LoginButton); 
        rootPane.setDefaultButton(LoginButton);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textField_username = new javax.swing.JTextField();
        passwordField_password = new javax.swing.JPasswordField();
        LoginButton = new javax.swing.JButton();
        ExitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setAlwaysOnTop(true);
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Username");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Password");

        textField_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField_usernameActionPerformed(evt);
            }
        });

        LoginButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/login_icon.png"))); // NOI18N
        LoginButton.setText("Log In");
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });
        LoginButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                LoginButtonKeyPressed(evt);
            }
        });

        ExitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/exit_icon.png"))); // NOI18N
        ExitButton.setText("Exit");
        ExitButton.setPreferredSize(new java.awt.Dimension(57, 23));
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LoginButton)
                        .addGap(5, 5, 5)
                        .addComponent(ExitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(textField_username, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordField_password, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textField_username, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(passwordField_password, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LoginButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ExitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textField_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_usernameActionPerformed

    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
     
            System.exit(0);
    }//GEN-LAST:event_ExitButtonActionPerformed

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
        try {
            boolean loginCredentials = loginCheck();
            
            if(loginCredentials==true)
            {
                setVisible(false);
                AdminMenu adminMenu = new AdminMenu();
                adminMenu.setVisible(true);
            }
            else if(loginCredentials==false) 
            {
                
                WebOptionPane.showMessageDialog(rootPane, "Enter valid credentials", "Login failed", WIDTH, null);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }//GEN-LAST:event_LoginButtonActionPerformed

    private void LoginButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LoginButtonKeyPressed
        
    }//GEN-LAST:event_LoginButtonKeyPressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        
    }//GEN-LAST:event_formKeyPressed

    public boolean loginCheck() throws Exception 
    {
        try {
           
            EntityManager em = null;
            String dbUsername, dbPassword;
            
            DBConnection dbCon = new DBConnection(true);
            Statement state =  dbCon.createStatement();
            
            String username = textField_username.getText();
            String pass = passwordField_password.getText();
        
            state.executeQuery("SELECT username, passwordHash FROM users where username ='"+username+"'");
            ResultSet rs = state.getResultSet();
            PasswordCTRL passwordCTRL = new PasswordCTRL();
           
            
            
            while(rs.next()){
                dbUsername = rs.getString("username");
                dbPassword = rs.getString("passwordHash");
                boolean loginTest = passwordCTRL.check(pass,dbPassword);
                
                
                if(dbUsername.equals(username) && loginTest == true){
                    login = true;
                 }
                else if (!dbUsername.equals(username) && loginTest == false) 
                {
                    login = false;
                }
                 else if (dbUsername.equals(username) && loginTest == false) 
                {
                   login = false;
                }
                 else if (!dbUsername.equals(username) && loginTest == true) 
                {
                    login = false;
                }
                    
            
            }

            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return login;
        
        
    }
    public static void main(String args[]) {
        
        WebLookAndFeel.install();
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ExitButton;
    protected javax.swing.JButton LoginButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField passwordField_password;
    private javax.swing.JTextField textField_username;
    // End of variables declaration//GEN-END:variables
}
