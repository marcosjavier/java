/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import remotec.Cliente;

/**
 *
 * @author marcos
 */
public interface ClientesDao {
  public List<Cliente> obtenerTodos();
  public void nuevoCliente(Cliente datos);
    
}
