
package sistemasalud;

import sistemaSaludC.control;
import sistemaSaludM.ConsultaPaciente;
import sistemaSaludM.pacientes;
import sistemaSaludV.sistemaDsalud;

public class SistemaSalud {

    public static void main(String[] args) {
        sistemaDsalud frm=new sistemaDsalud();
        pacientes m=new pacientes();
        ConsultaPaciente mC=new ConsultaPaciente();
        control cont=new control(m, mC, frm);
        frm.setVisible(true);
    }
    
}
