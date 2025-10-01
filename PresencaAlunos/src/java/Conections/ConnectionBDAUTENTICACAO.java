package Conections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionBDAUTENTICACAO {

    // Adjust to your setup
    private static final String URL  = "jdbc:postgresql://localhost:5432/master_data";
    private static final String USER = "root";           // not "root" on Postgres
    private static final String PASS = "root";       // your real password

    public static Connection conectarBDAUTENTICACAO() {
        try {
            // Load driver (optional on modern JDBC, harmless if present)
            Class.forName("org.postgresql.Driver");

            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conexão com o banco BD_AUTENTICACAO ok!");
            return conn;

        } catch (SQLException | ClassNotFoundException e) {
            // NEVER println(null) on GlassFish logging
            System.out.println("Erro na Conexão:");
            System.out.println(e.getMessage());  // safe
            e.printStackTrace();                 // full context in server log
            // Don't return null; make failure explicit:
            throw new IllegalStateException("Falha ao conectar no PostgreSQL: " + URL, e);
        }
    }

    public static void main(String[] args){
        try (Connection conn = conectarBDAUTENTICACAO()) {
            System.out.println("Conn = " + (conn != null));
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionBDAUTENTICACAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

