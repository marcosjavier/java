/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remotec;
import util.HibernateUtil;
import org.hibernate.SessionFactory;
/**
 *
 * @author marcos
 */

public class Main {
    
    private final static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
    //sessionFactory = HibernateUtil.getSessionFactory();
    new GestorRemotec(sessionFactory).run();
    }
}
    

