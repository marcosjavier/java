/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import remotec.Usuario;

/**
 *
 * @author marcos
 */
public interface UserDao {
  public Usuario validarUser(String nombre, String clave);
  
}
