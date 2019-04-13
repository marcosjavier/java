/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remotec;
import dao.ClientesDao;
import dao.ClientesDaoHibernateImpl;
import dao.UserDao;
import dao.UserDaoHibernate;

import org.hibernate.SessionFactory;
import interfazGrafica.FormularioIngreso;
import interfazGrafica.FormularioMenuPrincipal;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author marcos
 */
public class GestorRemotec {
    //private SessionFactory sessionFactory;
  UserDao user; 
  ClientesDao cliente;  
  FormularioIngreso logueo;
  FormularioMenuPrincipal menuPrincipal;
    
  public GestorRemotec(SessionFactory sessionFactory){
    //this.sessionFactory=sessionFactory;
    this.user = new UserDaoHibernate(sessionFactory);
    this.cliente = new ClientesDaoHibernateImpl(sessionFactory);

  }
    
  public void run(){

      logueo = new FormularioIngreso(this);
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
    
  public void validarUsuario(String nombre, String pass){
    Usuario usuarioLogueado = user.validarUser(nombre, pass);
    if (usuarioLogueado == null){
      JOptionPane.showMessageDialog(logueo,"Usuario y/o clave no son correctos,"
	  + " vuelva a ingresarlos","Error",JOptionPane.ERROR_MESSAGE);
    }else{      
      String nom = usuarioLogueado.getEmail();
      JOptionPane.showMessageDialog(logueo, "el usuario "+nom
	  +" se logueo con exito", "information",JOptionPane.INFORMATION_MESSAGE);
      logueo.setVisible(false);
      menuPrincipal=new FormularioMenuPrincipal(this);
      menuPrincipal.setVisible(true);
    }

  }
  
  public List<Cliente> listaDeClientes(){
  return cliente.obtenerTodos();};
  
  public void guardarClienteNuevo(Cliente nuevoCliente){
    this.cliente.nuevoCliente(nuevoCliente);
  }
            
}
