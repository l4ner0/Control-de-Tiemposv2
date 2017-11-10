/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Principal;

import Controlador.ControladorCarnet;
import Controlador.ControladorUICT;
import util.Conexion;
import Modelo.EmpleadoDAO;
import Vista.IUControlTiempos;
import Vista.Ventanas.VtnNuevoTrabajador;
import javax.swing.JOptionPane;

/**
 *
 * @author diego
 */
public class ControlDeTiempos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {      
        
        IUControlTiempos controlTiempos = new IUControlTiempos();
        VtnNuevoTrabajador vtnNuevoTrabajador = new VtnNuevoTrabajador();
        ControladorUICT  control = new ControladorUICT(controlTiempos);
        controlTiempos.setVisible(true);
        
        /*ControladorCarnet carnet = new ControladorCarnet();
        carnet.generarCarnet("Nombre de la empresa", "E010177344583", 
                        "URBINA SANTE DIEGO", 
                        String.valueOf(1), String.valueOf(1),
                        "Vencimiento: 09/11/2017","C:\\Documents and Settings\\diego\\Mis documentos\\NetBeansProjects\\Control-de-Tiemposv2\\ControlDeTiempos\\FotoEmpleado\\FotoPrueba.png",
                        "C:\\Documents and Settings\\diego\\Mis documentos\\NetBeansProjects\\Control-de-Tiemposv2\\ControlDeTiempos\\CarnetEmpleado\\E010177344583.pdf");
*/
    }
}
