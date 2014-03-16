
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

 
public class DBConnection {

    Connection con;
    Statement state;
    String b;
    
    public DBConnection(boolean b) throws ClassNotFoundException, SQLException
    {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connString2 = "jdbc:sqlserver://ee2c6044-5cce-484d-bb44-a2e900d2777e.sqlserver.sequelizer.com;Database=dbee2c60445cce484dbb44a2e900d2777e;username=revsywseiehozyte;Password=3AZgCZArnYxy7szYsbGCRhYRBSm6mSgYVgQQ2owXRGEhDtmbSAq2ysCUKiLSNCfC;";
        String connString ="jdbc:sqlserver://INSTANCE-PC\\MSSQLSERVER;databaseName=inventory_db;username=sa;password=admin";
        con = DriverManager.getConnection(connString2);
        if(b)
        {
        state = con.createStatement();
        }
        else
        {
        state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY); 
        }
        
    }
    
   
    
    public Statement createStatement()
        {
                return state;
        }
    
    
}
