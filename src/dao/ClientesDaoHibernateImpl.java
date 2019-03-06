/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.util.List;
import remotec.Cliente;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author marcos
 */
public class ClientesDaoHibernateImpl implements ClientesDao {
  private final SessionFactory sessionFactory;
  
  public ClientesDaoHibernateImpl(SessionFactory sessionFactory){
    this.sessionFactory = sessionFactory;
  }

  @Override
  public List<Cliente> obtenerTodos() {
    Session session = sessionFactory.openSession();
    List<Cliente> retorno = session.createQuery("from Cliente").list();
    session.close();
    
    return retorno;
    
  }
  
  
}
