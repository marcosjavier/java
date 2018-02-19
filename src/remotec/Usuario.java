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
import org.hibernate.Transaction;

/**
 *
 * @author marcos
 */
public class Usuario {
    
    private int id;
    private String nombre;
    private String clave;
    private SessionFactory sessionFactory;
    private boolean login;

    public Usuario(){};
    public Usuario(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }
    
    //llamo al metodo conectar con un query de consulta a la base datos
    //averiguo si existe el usuario
    public  void loguearUser(String nombre,String clave){
        
        
        //boolean bandera=ConectarPostgreSQL.consulta("SELECT nombre, clave FROM usuarios WHERE nombre='"+nombre+"' AND clave='"+clave+"'");
     
        String string ="FROM Usuario U WHERE U.nombre='"+nombre+"'AND U.clave='"+clave+"'";
        Session session;
        session = sessionFactory.openSession();        
        Query query = session.createQuery(string); 
        System.out.print(query.getQueryString());
        Object resultado=query.uniqueResult();
        if(resultado != null){
            this.setLogin(true);
            System.out.println("usuario  logueado con exito ");
        }
    }
        
        /*for (Iterator iterador =resultados.iterator(); iterador.hasNext(); )
            {Usuario usuario= (Usuario) iterador.next();
            System.out.println("id: "+usuario.getId());
            System.out.println("nombre: "+usuario.getNombre());
            System.out.println("clave: "+usuario.getClave());}
        //return boolean bandera=true;*/
    
    public void listarUsuarios(){
        Session session= sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx=session.beginTransaction();
            List usuarios=session.createQuery("FROM Usuario").list();
            for(Iterator iterador = usuarios.iterator(); iterador.hasNext();){
                Usuario usuario= (Usuario)iterador.next();
                System.out.println("id: "+usuario.getId());
                System.out.println("nombre: "+usuario.getNombre());
                System.out.println("clave: "+usuario.getClave());
            }
            tx.commit();
            }catch(HibernateException e){
                if (tx!= null)tx.rollback();
                e.printStackTrace();
            }
            finally {
            session.close();}
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

    /**
     * @return the login
     */
    public boolean isLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(boolean login) {
        this.login = login;
    }
}
