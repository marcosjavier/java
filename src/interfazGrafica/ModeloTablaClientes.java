/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazGrafica;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.hibernate.SessionFactory;
import remotec.Cliente;

/**
 *
 * @author marcos
 */
public class ModeloTablaClientes extends AbstractTableModel{
    
    
    
    /*public ModeloTablaClientes(SessionFactory sessionFactory){
        
    }*/
    
    
    
    String[] columnNames = {"id", "nombre", "apellidos", "Razon Social", "Telefono", "Direccion"};
    
    List clientes = new List();
    clientes= cliente.listarClientes();
    
    
    
    public int getRowCount(){};
    @Override
    public int getColumnCount(){return columnNames.length;};
    public Object getValueAt(int row, int column);
}
