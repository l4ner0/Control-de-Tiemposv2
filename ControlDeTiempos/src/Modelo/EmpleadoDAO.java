

package Modelo;

import util.Conexion;
import java.io.File;
import java.io.FileInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;


public class EmpleadoDAO {
    Conexion conexion;
    
    public EmpleadoDAO(){
        conexion=new Conexion();
    }
    
    public boolean InsertarEmpleado(String idEmpleado,String fotoEmpleado,
        String nombres,String apellidoPaterno,String apellidoMaterno,String sexo,
        String DNI,String fechaNacimiento,String DistritoResidencia,
        String direccion,String telefono,String correoElectronico,
        String asignacionFamiliar,int idArea,int idPuesto,
        int idRetencion ){
        
        boolean registro=false;
        try
        {
           Connection accesoDB=conexion.getConexion();
           CallableStatement cs = accesoDB.prepareCall("{call usp_graba_empleado("
                   + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
           
           cs.setString(1,idEmpleado);
           cs.setString(2,fotoEmpleado);
           cs.setString(3,nombres);
           cs.setString(4,apellidoPaterno);
           cs.setString(5,apellidoMaterno);
           cs.setString(6,sexo);
           cs.setString(7,DNI);
           cs.setString(8,fechaNacimiento);
           cs.setString(9,DistritoResidencia);
           cs.setString(10,direccion);
           cs.setString(11,telefono);
           cs.setString(12,correoElectronico);
           cs.setString(13,asignacionFamiliar);
           cs.setInt(14,idArea);
           cs.setInt(15,idPuesto);
           cs.setInt(16,idRetencion);
           
           
           int filasAfect=cs.executeUpdate();
           if(filasAfect>0)
           {
               registro=true;
           }
        }catch(Exception e)
        {
            System.out.println(e);
        }
        return registro;
    }
    
    public int ContarRegistros(){
        int numRegistros = 0 ;
        try
        {
         Connection accesoDB=conexion.getConexion();
         CallableStatement cs = accesoDB.prepareCall("{call usp_mostrar_empleados}");
         ResultSet rs=cs.executeQuery();
         while(rs.next())
         {
             numRegistros++;
         
         }
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
        return numRegistros;
    }
    
    //Eliminar una vez que se cree AreasEmpresaDAO y PuestoDAO
    public String getArea(String nombreArea){
        String area="";
        try
        {
            Connection accesoDB=conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("");
            ResultSet rs=cs.executeQuery();
            area=rs.getString(1);
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
        return area;
    }
    
    public String getPuesto(String nombrePuesto){
        String puesto="";
        try
        {
            Connection accesoDB=conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("");
            ResultSet rs=cs.executeQuery();
            puesto=rs.getString(1);
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
        return puesto;
    }
    
}
