/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import remotec.Usuario;

/**
 *
 * @author marcos
 */
public class UserDaoHibernate implements UserDao {
  private final SessionFactory sessionFactory;
  
  public UserDaoHibernate (SessionFactory sessionFactory){
  this.sessionFactory = sessionFactory;}

  @Override
  public Usuario validarUser(String nombre, String clave ) {
    String string ="FROM Usuario U WHERE U.email='"+nombre+"'AND U.password='"+clave+"'";
    Session session;
    session = sessionFactory.openSession();        
    //Query query = session.createQuery(string); 
    //System.out.print(query.getQueryString());
    Usuario user = (Usuario)session.createQuery(string).uniqueResult();
    //Object resultado = query.uniqueResult();
    
    if(user != null){
      System.out.println("Usuario logueado con exito");
      //return user.getEmail();
      return user;
    }
    return user;
    

    
  }
  
}
