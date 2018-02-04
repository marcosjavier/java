/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remotec;
import org.hibernate.SessionFactory;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


/**
 *
 * @author marcos
 */

public class Main {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       // SessionFactory sessionFactory;
        ServiceRegistry serviceRegistry;
       
        
       Configuration configuration = new Configuration();
       configuration.configure();
       serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
       final SessionFactory sessionFactory= configuration.buildSessionFactory(serviceRegistry);
     
    new Remotec(sessionFactory).run();
    }
}
    

