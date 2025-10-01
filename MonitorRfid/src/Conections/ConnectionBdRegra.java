/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author felipe
 */
public class ConnectionBdRegra {
        public static Connection conectarBdRegra(){
        Connection conn=null;
        try{
            if(conn == null){
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/BD_REGRA?"+"user=root&password=felipe@mota#");
                System.out.println("Conexao com o banco BD_REGRA ok!");
                return conn;
            }
        }catch(SQLException  | ClassNotFoundException exception){
            System.out.println("Erro na Conexão: ");
            System.out.println(exception.getCause());            
        }        
        return conn;
    }  
    public static void main(String args[]){
       Connection conn;       
       conn = ConnectionBDAUTENTICACAO.conectarBDAUTENTICACAO();
       System.out.println("Conn = "+conn);
    }        
}
