/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remotec;
import basedatos.ConectarPostgreSQL;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author marcos
 */
public class Usuario {
    
    private int id;
    private String nombre;
    private String clave;
    private SessionFactory sessionFactory;

    public Usuario(){};
    public Usuario(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }
    
    //llamo al metodo conectar con un query de consulta a la base datos
    //averiguo si existe el usuario
    public  void loguear(String nombre,String clave)throws HibernateException{
        //boolean bandera=ConectarPostgreSQL.consulta("SELECT nombre, clave FROM usuarios WHERE nombre='"+nombre+"' AND clave='"+clave+"'");
     
        String string ="FROM Usuario U WHERE U.nombre='"+nombre+"'";
        Session session;
        session = sessionFactory.openSession();        
        Query query = session.createQuery(string); 
        System.out.print(query.getQueryString());
        /*try{
            Query query = session.createQuery(string);
        }catch(){}
        try{
        Object resultado=query.uniqueResult();
        System.out.println("usuario  logueado");
        }catch(HibernateException exp)
        {
            
            String message = exp.getMessage();
            System.out.println(message);
        }*/
        
        /*for (Iterator iterador =resultados.iterator(); iterador.hasNext(); )
            {Usuario usuario= (Usuario) iterador.next();
            System.out.println("id: "+usuario.getId());
            System.out.println("nombre: "+usuario.getNombre());
            System.out.println("clave: "+usuario.getClave());}
        //return boolean bandera=true;*/
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }
}
