
package sistemaSaludC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import sistemaSaludM.ConsultaPaciente;
import sistemaSaludM.pacientes;
import sistemaSaludV.sistemaDsalud;

public class control implements ActionListener{
    
    private pacientes m;
    private ConsultaPaciente mC;
    private sistemaDsalud frm;
    
    public control (pacientes m, ConsultaPaciente mC, sistemaDsalud frm ){
        this.m = m;
        this.mC = mC;
        this.frm = frm;
        this.frm.btnGuardar.addActionListener(this);
        this.frm.btnEliminar.addActionListener(this);
        this.frm.btnBuscar.addActionListener(this);
    }

    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==frm.btnGuardar){
            m.setCodigo(Integer.parseInt(frm.txtCodigo.getText()));
            m.setApellidos(frm.txtApellidos.getText());
            m.setNombres(frm.txtNombres.getText());
            m.setDireccion(frm.txtDireccion.getText());
            m.setCentroServicio(frm.txtCentroServicio.getText());
            m.setMotivoConsulta(frm.txtMotivo.getText());
            m.setMedico(frm.txtMedico.getText());
            m.setFecha(frm.txtFecha.getText());
            if(mC.registrar(m)){
                JOptionPane.showConfirmDialog(null,"Paciente guardado correctamente");
            } else {
                JOptionPane.showConfirmDialog(null,"El paciente no se guadó correctamente en la base de datos");
            }
        }
        
        if(e.getSource()==frm.btnEliminar){
            m.setId(Integer.parseInt(frm.jTextField1.getText()));
            if(mC.eliminar(m)){
                JOptionPane.showConfirmDialog(null, "Paciente eliminado");
            }else{
                
            }
        }
        
        if(e.getSource()==frm.btnBuscar){
            m.setNombres(frm.txtNombres.getText());
            m.setMedico(frm.txtMedico.getText());
            m.setCentroServicio(frm.txtCentroServicio.getText());
            if(mC.buscar(m)){
                frm.jTextField1.setText(String.valueOf(m.getId()));
                frm.txtCodigo.setText(String.valueOf(m.getCodigo()));
                frm.txtApellidos.setText(m.getApellidos());
                frm.txtNombres.setText(m.getNombres());
                frm.txtDireccion.setText(m.getDireccion());
                frm.txtCentroServicio.setText(m.getCentroServicio());
                frm.txtMotivo.setText(m.getMotivoConsulta());
                frm.txtMedico.setText(m.getMedico());
                frm.txtFecha.setText(m.getFecha());
            }else{
                JOptionPane.showConfirmDialog(null, "El paciente no se encuentra registrado");
            }
        }
        
    }
    
}
