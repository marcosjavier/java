/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basedatos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.sql.rowset.CachedRowSet;
import com.sun.rowset.CachedRowSetImpl;

/**
 *
 * @author marcos
 */
public class ConectarPostgreSQL {
    public static boolean bandera= false;
    public static boolean consulta(String sql)
    { 
             
            try
            {
                
                Class.forName("org.postgresql.Driver");
                String url = "jdbc:postgresql://127.0.0.1:5432/java1";
                Connection con = DriverManager.getConnection(url, "postgres","postgres");
                Statement s = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rs=s.executeQuery(sql);
                
                if(rs.first()){                    
                    System.out.println("Datos encontrados");
                    bandera =true;
                    String nombre = rs.getString("nombre");
                    String clave = rs.getString("clave");
                    System.out.println("NOMBRE="+ nombre);
                    System.out.println("CLAVE="+ clave);
                    System.out.println();
                    }               
    
                con.close();
                s.close();
                rs.close();
            }catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
            }
         return bandera;   
    }        

    public CachedRowSet Function(String sql)
    {
            try
            {
                   System.out.println(sql);
                    Class.forName("org.postgresql.Driver");
 
                    String url = "jdbc:postgresql://127.0.0.1:5432/java1";
                    Connection con = DriverManager.getConnection(url, "postgres","ninguna");
                    
                    Statement s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                                      ResultSet.CONCUR_READ_ONLY);
 
                    ResultSet rs= s.executeQuery(sql);
 
                    CachedRowSetImpl crs = new CachedRowSetImpl();
                    
                    while (crs.next()){
                        String nombre=crs.getString(1);
                        String clave=crs.getString(2);
                        System.out.println(nombre + "  " + clave + "  ");
                    }
                    crs.populate(rs);
 
                    rs.close();
                    s.close();
                    con.close();
 
                    return crs;
 
            }
            catch(Exception e)
            {
                   System.out.println(e.getMessage());
            }
 
            return null;
    }
 
    public void StoreProcedure(String sql)
    {
 
            try
            {
                    Class.forName("org.postgresql.Driver");
 
                    String url = "jdbc:postgresql://127.0.0.1:5432/postgres";
                    Connection con = DriverManager.getConnection(url, "usuario","contraseña");
                    Statement s = con.createStatement();
 
                    s.execute(sql);
 
                    s.close();
                    con.close();
 
            }
            catch(Exception e)
            {
                   System.out.println(e.getMessage());
            }
    }
}
