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
    private int id;
    private String nombres;
    private String apellidos;
    private String razon_social;
    private String telefono;
    private String domicilio;
    private SessionFactory sessionFactory;
    
    public Cliente(){};
    public Cliente(SessionFactory sessionFactory){
       this.sessionFactory=sessionFactory;
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
     * @return the nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * @param nombres the nombres to set
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the razon_social
     */
    public String getRazon_social() {
        return razon_social;
    }

    /**
     * @param razon_social the razon_social to set
     */
    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the domicilio
     */
    public String getDomicilio() {
        return domicilio;
    }

    /**
     * @param domicilio the domicilio to set
     */
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
    
    public void listarClientes(){
        Session session= sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx=session.beginTransaction();
            List clientes=session.createQuery("FROM Cliente").list();
            if (!clientes.isEmpty()){
                System.out.println("LISTA DE CLIENTES");
                for(Iterator iterador = clientes.iterator(); iterador.hasNext();){
                Cliente cliente= (Cliente)iterador.next();                
                System.out.println("id: "+cliente.getId());
                System.out.println("nombres: "+cliente.getNombres());
                System.out.println("apellidos: "+cliente.getApellidos());
                System.out.println("razon_social: "+cliente.getRazon_social());
                System.out.println("telefono: "+cliente.getTelefono());
                System.out.println("domicilio: "+cliente.getDomicilio());
                
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
        }
    }
    
    
    

