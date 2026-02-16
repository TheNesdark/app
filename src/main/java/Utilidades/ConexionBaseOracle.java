package Utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/ConexionBaseOracle.class */
public class ConexionBaseOracle {
    public String driver;
    public String url;
    public String ip;
    public String bd;
    public String usr;
    public String pass;
    public Connection conexion;

    public ConexionBaseOracle() {
        try {
            this.driver = "oracle.jdbc.driver.OracleDriver";
            this.bd = "pajonadb";
            this.usr = "CPAJONAL";
            this.pass = "PAJONAL123";
            this.ip = "192.168.1.116";
            this.url = "jdbc:oracle:thin:@" + this.ip + ":1521:" + this.bd;
            Class.forName(this.driver).newInstance();
            this.conexion = DriverManager.getConnection(this.url, this.usr, this.pass);
            System.out.println("Conexion a Base de Datos " + this.bd + " Ok");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al tratar de abrir la base de Datos" + this.bd + " : " + ex);
        } catch (IllegalAccessException ex2) {
            Logger.getLogger(ConexionBaseOracle.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
        } catch (InstantiationException ex3) {
            Logger.getLogger(ConexionBaseOracle.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex3);
        } catch (SQLException ex4) {
            Logger.getLogger(ConexionBaseOracle.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex4);
        }
    }

    public Connection getConexion() {
        return this.conexion;
    }

    public Connection CerrarConexion() throws SQLException {
        this.conexion.close();
        this.conexion = null;
        return this.conexion;
    }

    public ResultSet traerRs(String sql) {
        ResultSet rs = null;
        try {
            Statement s = getConexion().createStatement(1005, 1007);
            rs = s.executeQuery(sql);
        } catch (SQLException e) {
        }
        return rs;
    }

    public void ejecutarSQL(String sql) {
        try {
            Statement s = getConexion().createStatement();
            s.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBaseOracle.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public boolean ejecutar(String sql) {
        try {
            Statement sentencia = getConexion().createStatement(1003, 1007);
            sentencia.executeUpdate(sql);
            getConexion().commit();
            sentencia.close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}
