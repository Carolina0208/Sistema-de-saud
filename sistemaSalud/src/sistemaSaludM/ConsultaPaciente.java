
package sistemaSaludM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultaPaciente extends Conect{
    
    public boolean registrar(pacientes paciente){
        
        PreparedStatement p = null;
        Connection con = getConect();
        String mysql= "INSERT INTO paciente (codigo, apellidos, nombres, sexo, direccion, centroServicio, motivoConsulta, medico, fecha) VALUES(?,?,?,?,?,?,?,?,?)";
        
        try{
            p = con.prepareStatement(mysql);
            p.setInt(1, paciente.getCodigo());
            p.setString(2, paciente.getApellidos());
            p.setString(3, paciente.getNombres());
            p.setString(5, paciente.getDireccion());
            p.setString(6, paciente.getCentroServicio());
            p.setString(7, paciente.getMotivoConsulta());
            p.setString(8, paciente.getMedico());
            p.setString(9, paciente.getFecha());
            p.execute();
            return true;
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }
    }
    
    public boolean eliminar (pacientes paciente){
        
        PreparedStatement ps = null;
        Connection con = getConect();
        String mysql= "DELETE FROM sitemaSalud WHERE id=?";
        
        try{
            ps = con.prepareStatement(mysql);
            ps.setInt(1, paciente.getId());
            
            ps.execute();
            return true;
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }
    }
    public boolean buscar (pacientes paciente){
        
        PreparedStatement p = null;
        ResultSet r =null;
        Connection con = getConect();
        String mysql= "SELECT * FROM sitemaSalud WHERE nombres=?, medico=?, centroServicio=?";
        
        try{
            p = con.prepareStatement(mysql);
            
            p.setString(3, paciente.getNombres());
            p.setString(8, paciente.getMedico());
            p.setString(6, paciente.getCentroServicio());
            
            r= p.executeQuery();
            
            if(r.next()){
                paciente.setId(Integer.parseInt(r.getString("Id paciente")));
                paciente.setCodigo(Integer.parseInt(r.getString("Codigo")));
                paciente.setApellidos(r.getString("Apellidos"));
                paciente.setNombres(r.getString("Nombres"));
                paciente.setDireccion(r.getString("Direccion"));
                paciente.setCentroServicio(r.getString("Centro de servicio"));
                paciente.setMotivoConsulta(r.getString("Motivo de consulta"));
                paciente.setMedico(r.getString("Medico"));
                paciente.setFecha(r.getString("Fecha"));
                
            }
            return true;
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }
    }
}
