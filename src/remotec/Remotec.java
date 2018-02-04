/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remotec;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import interfazGrafica.FormularioIngreso;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author marcos
 */
public class Remotec {
    private SessionFactory sessionFactory;
    
    public Remotec(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }
    
    public void run(){
        FormularioIngreso logueo=new FormularioIngreso(sessionFactory);
        logueo.setVisible(true);
        
        /*Session session= sessionFactory.openSession();
        Query Query = session.createQuery("FROM Usuario");
        List resultados=Query.list();
        for (Iterator iterador =resultados.iterator(); iterador.hasNext(); )
            {Usuario usuario= (Usuario) iterador.next();
            System.out.println("id: "+usuario.getId());
            System.out.println("nombre: "+usuario.getNombre());
            System.out.println("clave: "+usuario.getClave());}
        */
        
        
              
    }
    
}
