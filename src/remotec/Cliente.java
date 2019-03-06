/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remotec;

import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


/**
 *
 * @author marcos
 */
public class Cliente {
    private long id;
    private String names;
    private String surname;
    private String tradename;
    private String phone;
    private String address;
    private SessionFactory sessionFactory;
    
    public Cliente(){};
    public Cliente(String nom, String ape, String raz, String dom,String tel){
        this.names=nom;
        this.surname=ape;
        this.tradename=raz;
        this.address=dom;
        this.phone=tel;
    }
    public Cliente(SessionFactory sessionFactory){
       this.sessionFactory=sessionFactory;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the nombres
     */
    public String getNames() {
        return names;
    }

    /**
     * @param names the nombres to set
     */
    public void setNames(String names) {
        this.names = names;
    }

    /**
     * @return the apellidos
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname the apellidos to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return the razon_social
     */
    public String getTradename() {
        return tradename;
    }

    /**
     * @param tradename the razon_social to set
     */
    public void setTradename(String tradename) {
        this.tradename = tradename;
    }

    /**
     * @return the telefono
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the telefono to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the domicilio
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the domicilio to set
     */
    public void setAddress(String address) {
        this.address = address;
    }
    
    public List listarClientes(){
        //Session session= sessionFactory.getCurrentSession();
        Session session= sessionFactory.openSession();
        List clientes = null;
        Transaction tx = null;
        try{
            tx=session.beginTransaction();
            clientes=session.createQuery("FROM Cliente").list();
            if (!clientes.isEmpty()){
                System.out.println("LISTA DE CLIENTES");
                for(Iterator iterador = clientes.iterator(); iterador.hasNext();){
                Cliente cliente= (Cliente)iterador.next();                
                System.out.println("id: "+cliente.getId());
                System.out.println("nombres: "+cliente.getNames());
                System.out.println("apellidos: "+cliente.getSurname());
                System.out.println("razon_social: "+cliente.getTradename());
                System.out.println("telefono: "+cliente.getPhone());
                System.out.println("domicilio: "+cliente.getAddress());
                
                }
                       
            tx.commit();
            }else{System.out.println("lista vacia");}
            
            }catch(HibernateException e){
                e.getMessage();
                if (tx!= null)tx.rollback();
                e.printStackTrace();
                
            }
            finally {           
            
            session.close();}
        return clientes;
        }
    public void guardarCliente(String nombres,String apellidos, String razon_social, String telefono,
    String domicilio){
        Session session= sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx=session.beginTransaction();
            Cliente cl = new Cliente(nombres, apellidos, razon_social, domicilio, telefono);
            session.save(cl);
            tx.commit();
            System.out.println("cliente guardado");
            
        }catch(HibernateException e){
            e.getMessage();
            if (tx!= null)tx.rollback();
                e.printStackTrace();                
            }
            finally {             
            session.close();}
    
    }
    }    
    
    

