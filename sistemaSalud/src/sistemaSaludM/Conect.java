
package sistemaSaludM;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conect {
    
    private final String base = "sistemaSalud";
    private final String usuario = "root";
    private final String contraseña = "caro522003";
    private final String url = "jdbc:mysql://localhost:3306"+base;
    
    private Connection con = null;
    
    public Connection getConect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(this.url, this.usuario, this.contraseña);
        }catch (SQLException e){
            System.err.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}
