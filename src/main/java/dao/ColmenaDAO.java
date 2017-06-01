/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Labing
 */
public class ColmenaDAO {
    public int panalesAlimento(){
            int total = 0;
            try {
                String query = "select PanalesAlimento from Colmena where Id = 1";
                Connection connection = null;
                try {
                    connection = Conexion.getConnection();
                } catch (URISyntaxException ex) {
                    ex.printStackTrace();
                }
                
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()){
                    
                   total = rs.getInt("PanalesAlimento");
                   
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(ColmenaDAO.class.getName()).log(Level.SEVERE, null, ex);
            } 
             return total;
       }
    
    public ArrayList kilosPorColmena(){
            ArrayList total = null;
           int id = 0;
           double registro = 0;
            try {
                String query = "select Id, Kilos from Colmena";
                Connection connection = null;
                try {
                    connection = Conexion.getConnection();
                } catch (URISyntaxException ex) {
                    ex.printStackTrace();
                }
                
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()){
                    if(total == null){
	    		total = new ArrayList();
                    }
                   id = rs.getInt("Id");
                   registro = rs.getDouble("Kilos");
                   total.add(id);
                   total.add(registro);
                }
                
               
            } catch (SQLException ex) {
                Logger.getLogger(ColmenaDAO.class.getName()).log(Level.SEVERE, null, ex);
            } 
             return total;
       }
}
