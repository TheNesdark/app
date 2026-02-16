package Utilidades;

import Acceso.Principal;
import java.awt.Component;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.jdnc.incubator.jxcombobox.ComboBoxTable;
import org.jdesktop.jdnc.incubator.jxcombobox.IncompatibleLookAndFeelException;
import org.jdesktop.jdnc.incubator.jxcombobox.JTableComboBox;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/ConsultasMySQL.class */
public class ConsultasMySQL {
    private String sql;
    private Connection conexion;
    Errores er = new Errores();

    public void cerrarConexionBd() {
    }

    public Connection establecerConexionBd() {
        this.conexion = ConnectionManager.iniciarConexionBaseDatos();
        return this.conexion;
    }

    public void deshacerSQL(SQLException e) {
        try {
            this.sql = "Ocurrió un error al Grabar o Modificar los datos.\nDebido a esto, no se realizó el guardado y el proceso será revertido.\nLocalización : " + e.getLocalizedMessage() + "\nMensaje : " + e.getMessage() + "\nEstado : " + e.getSQLState() + "\nCódigo : " + e.getErrorCode();
            mostrarMensaje(this.sql);
            this.conexion.rollback();
        } catch (SQLException e2) {
            mostrarMensaje("Ocurrió un error al tratar de deshacer los cambios en la Base de Datos");
        }
    }

    public void ejecutarSQL(String sql) {
        try {
            Statement s = establecerConexionBd().createStatement();
            Throwable th = null;
            try {
                s.execute(sql);
                if (s != null) {
                    if (0 != 0) {
                        try {
                            s.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    } else {
                        s.close();
                    }
                }
            } finally {
            }
        } catch (SQLException ex) {
            mostrarErrorSQL(ex);
        }
    }

    public String ejecutarSQLId(String sql) {
        ResultSet rs;
        Throwable th;
        String id = "";
        try {
            rs = getResultSet(sql, 1);
            th = null;
        } catch (SQLException ex) {
            mostrarErrorSQL(ex);
        }
        try {
            try {
                rs.next();
                id = rs.getString(1);
                if (rs != null) {
                    if (0 != 0) {
                        try {
                            rs.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    } else {
                        rs.close();
                    }
                }
                return id;
            } finally {
            }
        } finally {
        }
    }

    public String ejecutarSQLIdNotError(String sql) {
        ResultSet rs;
        Throwable th;
        String id = "";
        try {
            rs = getResultSet(sql, 1);
            th = null;
        } catch (Exception ex) {
            System.out.println("Error:: " + ex.getMessage());
        }
        try {
            try {
                rs.next();
                id = rs.getString(1);
                if (rs != null) {
                    if (0 != 0) {
                        try {
                            rs.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    } else {
                        rs.close();
                    }
                }
                return id;
            } finally {
            }
        } finally {
        }
    }

    public void ejecutarSQLNotError(String sql) {
        try {
            Statement s = establecerConexionBd().createStatement();
            Throwable th = null;
            try {
                s.execute(sql);
                if (s != null) {
                    if (0 != 0) {
                        try {
                            s.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    } else {
                        s.close();
                    }
                }
            } finally {
            }
        } catch (SQLException ex) {
            System.out.println("Error:: " + ex.getMessage());
        }
    }

    public int ejecutaSQLUpdate(String xSql) {
        int resultado = 0;
        try {
            resultado = establecerConexionBd().createStatement().executeUpdate(xSql);
        } catch (SQLException ex) {
            mostrarErrorSQL(ex);
        }
        return resultado;
    }

    public void ejecutarAnuladas(String id, String nbre_Tabla, String Fecha, String UsuarioS) {
        this.sql = "INSERT INTO g_Anuladas (Id,Nbre_tabla,Fecha,UsuarioS) VALUES(" + id + ",'" + nbre_Tabla + "','" + Fecha + "','" + UsuarioS + "')";
        ejecutarSQL(this.sql);
        cerrarConexionBd();
    }

    public int getRestarFechas(String fechaF, String fechaI) {
        this.sql = "SELECT DATEDIFF('" + fechaF + "," + fechaI + "')";
        int dias = Integer.parseInt(ejecutarSQLId(this.sql));
        return dias;
    }

    public String getEsProfesional(String IdPersona) {
        this.sql = "SELECT Id_Profesional FROM g_profesionalespecial WHERE (Id_Profesional ='" + IdPersona + "')";
        String valor = traerDato(this.sql);
        cerrarConexionBd();
        if (valor.isEmpty() || valor == null) {
            valor = "0";
        }
        return valor;
    }

    public void iniciarSQL() {
        ejecutarSQL("START TRANSACTION");
    }

    public String[] llenarCombo(String sql, String[] lista, JComboBox combo) {
        try {
            ResultSet rs = getResultSet(sql);
            Throwable th = null;
            try {
                try {
                    rs.last();
                    lista = new String[rs.getRow()];
                    int i = 0;
                    rs.beforeFirst();
                    while (rs.next()) {
                        lista[i] = rs.getString(1);
                        combo.addItem(rs.getString(2));
                        i++;
                    }
                    combo.addPopupMenuListener(new CustomPopupMenuListener(true, false));
                    if (rs != null) {
                        if (0 != 0) {
                            try {
                                rs.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        } else {
                            rs.close();
                        }
                    }
                } finally {
                }
            } finally {
            }
        } catch (SQLException ex) {
            mostrarErrorSQL(ex);
        }
        return lista;
    }

    public String[][] llenarComboArregloBidiraccional(String sql, String[][] lista, JComboBox combo) {
        ResultSet rs;
        Throwable th;
        try {
            rs = getResultSet(sql);
            th = null;
        } catch (SQLException ex) {
            mostrarErrorSQL(ex);
        }
        try {
            try {
                rs.last();
                int rowCount = rs.getRow();
                lista = new String[rowCount][2];
                int i = 0;
                rs.beforeFirst();
                while (rs.next()) {
                    lista[i][0] = rs.getString(1);
                    lista[i][1] = rs.getString(2);
                    combo.addItem(rs.getString(2));
                    i++;
                }
                combo.addPopupMenuListener(new CustomPopupMenuListener(true, false));
                if (rs != null) {
                    if (0 != 0) {
                        try {
                            rs.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    } else {
                        rs.close();
                    }
                }
                return lista;
            } finally {
            }
        } finally {
        }
    }

    public String[][] llenarComboyLista(String sql, String[][] lista, JComboBox combo, int campos) {
        ResultSet rs;
        Throwable th;
        String[][] lista2 = (String[][]) null;
        combo.removeAllItems();
        try {
            rs = getResultSet(sql);
            th = null;
        } catch (SQLException ex) {
            mostrarErrorSQL(ex);
        }
        try {
            try {
                rs.last();
                lista2 = new String[rs.getRow()][campos - 1];
                int i = 0;
                rs.beforeFirst();
                while (rs.next()) {
                    lista2[i][0] = rs.getString(1);
                    combo.addItem(rs.getString(2));
                    for (int c = 1; c < campos - 1; c++) {
                        lista2[i][c] = rs.getString(c + 2);
                    }
                    i++;
                }
                combo.addPopupMenuListener(new CustomPopupMenuListener(true, false));
                if (rs != null) {
                    if (0 != 0) {
                        try {
                            rs.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    } else {
                        rs.close();
                    }
                }
                return lista2;
            } finally {
            }
        } finally {
        }
    }

    public void llenarComboTabla(String sql, JTableComboBox combo, DefaultTableModel modelo, int pos) {
        try {
            ResultSet rs = getResultSet(sql);
            Throwable th = null;
            try {
                try {
                    DefaultTableModel modelo2 = new DefaultTableModel();
                    ConversorResultSetADefaultTableModel.rellena(rs, modelo2);
                    tomaDatos(modelo2, combo, pos);
                    if (rs != null) {
                        if (0 != 0) {
                            try {
                                rs.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        } else {
                            rs.close();
                        }
                    }
                } catch (Throwable th3) {
                    if (rs != null) {
                        if (th != null) {
                            try {
                                rs.close();
                            } catch (Throwable th4) {
                                th.addSuppressed(th4);
                            }
                        } else {
                            rs.close();
                        }
                    }
                    throw th3;
                }
            } catch (Throwable th5) {
                th = th5;
                throw th5;
            }
        } catch (SQLException ex) {
            mostrarErrorSQL(ex);
        } catch (IncompatibleLookAndFeelException ex2) {
            mostrarErrorE(ex2);
        }
    }

    public void llenarTabla(String sql, JTable tabla, DefaultTableModel modelo) {
        if (modelo == null) {
            modelo = new DefaultTableModel() { // from class: Utilidades.ConsultasMySQL.1
                public boolean isCellEditable(int rowIndex, int colIndex) {
                    return false;
                }
            };
        }
        try {
            ResultSet rs = getResultSet(sql);
            Throwable th = null;
            try {
                try {
                    ConversorResultSetADefaultTableModel.rellena(rs, modelo);
                    tomaDatos(modelo, tabla);
                    if (rs != null) {
                        if (0 != 0) {
                            try {
                                rs.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        } else {
                            rs.close();
                        }
                    }
                } catch (Throwable th3) {
                    if (rs != null) {
                        if (th != null) {
                            try {
                                rs.close();
                            } catch (Throwable th4) {
                                th.addSuppressed(th4);
                            }
                        } else {
                            rs.close();
                        }
                    }
                    throw th3;
                }
            } catch (Throwable th5) {
                th = th5;
                throw th5;
            }
        } catch (SQLException ex) {
            mostrarErrorSQL(ex);
        } catch (IncompatibleLookAndFeelException ex2) {
            mostrarErrorE(ex2);
        }
    }

    public void llenarTabla(String sql, ComboBoxTable tabla, DefaultTableModel modelo) throws IncompatibleLookAndFeelException {
        try {
            ResultSet rs = getResultSet(sql);
            Throwable th = null;
            try {
                try {
                    ConversorResultSetADefaultTableModel.rellena(rs, modelo);
                    tomaDatos(modelo, tabla);
                    if (rs != null) {
                        if (0 != 0) {
                            try {
                                rs.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        } else {
                            rs.close();
                        }
                    }
                } finally {
                }
            } catch (Throwable th3) {
                th = th3;
                throw th3;
            }
        } catch (SQLException ex) {
            mostrarErrorSQL(ex);
        }
    }

    public ResultSet getResultSet(String sql) throws SQLException {
        return getResultSet(sql, -1);
    }

    public ResultSet getResultSet(String sql, int updateType) throws SQLException {
        ResultSet rs = null;
        try {
            try {
                Statement s = establecerConexionBd().createStatement(1005, 1007);
                Throwable th = null;
                if (-1 != updateType) {
                    s.execute(sql, updateType);
                    rs = s.getGeneratedKeys();
                } else {
                    rs = s.executeQuery(sql);
                }
                if (s != null) {
                    if (0 != 0) {
                        try {
                            s.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    } else {
                        s.close();
                    }
                }
            } finally {
            }
        } catch (SQLException ex) {
            mostrarErrorSQL(ex);
        }
        return rs;
    }

    public void mostrarErrorE(Exception error) {
        mostrarErrorGeneral(error);
    }

    public void mostrarErrorIO(IOException error) {
        mostrarErrorGeneral(error);
    }

    public void mostrarErrorSQL(SQLException error) {
        mostrarErrorGeneral(error);
    }

    public void mostrarErrorGeneral(Exception error) {
        this.sql = "Ocurrió el siguiente Error: ";
        if (error instanceof SQLException) {
            SQLException errorTemp = (SQLException) error;
            this.sql += errorTemp.getErrorCode();
        }
        this.sql += "\nMensaje : " + error.getMessage() + "\nLocalización : " + error.getLocalizedMessage() + "\nCausa : " + error.getCause() + "\nClase : " + error.getClass();
        mostrarMensaje(this.sql);
    }

    private void mostrarMensaje(String msg) {
        JOptionPane.showMessageDialog((Component) null, this.sql, Principal.getTitulo(), 1);
    }

    public void tomaDatos(DefaultTableModel modelo, JTableComboBox Combo, int pos) throws IncompatibleLookAndFeelException {
        if (Combo == null) {
            Combo = new JTableComboBox();
        }
        Combo.setModel(modelo, pos);
    }

    public void tomaDatos(DefaultTableModel modelo, JTable tabla) throws IncompatibleLookAndFeelException {
        if (tabla == null) {
            tabla = new JTable();
        }
        tabla.setModel(modelo);
    }

    public void tomaDatos(DefaultTableModel modelo, ComboBoxTable tabla) throws IncompatibleLookAndFeelException {
        if (tabla == null) {
            tabla = new ComboBoxTable();
        }
        tabla.setModel(modelo);
    }

    public String traerDato(String sql) {
        ResultSet rs;
        Throwable th;
        String retorno = "";
        try {
            rs = getResultSet(sql);
            th = null;
        } catch (SQLException ex) {
            mostrarErrorSQL(ex);
        }
        try {
            try {
                if (rs.next()) {
                    rs.first();
                    retorno = rs.getString(1);
                } else {
                    retorno = "";
                }
                if (rs != null) {
                    if (0 != 0) {
                        try {
                            rs.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    } else {
                        rs.close();
                    }
                }
                return retorno;
            } finally {
            }
        } finally {
        }
    }

    public ResultSet traerRs(String sql) {
        Statement s;
        Throwable th;
        ResultSet rs = null;
        try {
            s = establecerConexionBd().createStatement(1005, 1007);
            th = null;
        } catch (SQLException e) {
        }
        try {
            try {
                rs = s.executeQuery(sql);
                if (s != null) {
                    if (0 != 0) {
                        try {
                            s.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    } else {
                        s.close();
                    }
                }
                return rs;
            } finally {
            }
        } finally {
        }
    }

    public void mEjecutarProcedimientAlmacenadoUno(String xnparametro, int xvalorparametro) {
        try {
            CallableStatement cs = establecerConexionBd().prepareCall("{CALL actualizar(?)}");
            Throwable th = null;
            try {
                try {
                    cs.setInt(xnparametro, xvalorparametro);
                    cs.execute();
                    if (cs != null) {
                        if (0 != 0) {
                            try {
                                cs.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        } else {
                            cs.close();
                        }
                    }
                } finally {
                }
            } catch (Throwable th3) {
                th = th3;
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasMySQL.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void actualizacionEstadoProcedimientoLaboratorio(Long nRecepcion) {
        try {
            String sql1 = "\tupdate l_detallerecepcion, (\n\twith maestra as (\n\t\tselect ld.Id_Recepcion idRecepcion, ld.Id_Procedim idProcedimiento , count(lp.Id_Protocolo) cantidad \n\t\tfrom l_detallerecepcion ld \n\t\tinner join l_protocoloxprocedimiento lp on (lp.Id_Procedim=ld.Id_Procedim) and (lp.Estado=0)\n\t\twhere ld.Id_Recepcion =" + nRecepcion + " and lp.esObligatorio =1\n\t\tgroup by ld.Id_Recepcion , ld.Id_Procedim \n\t),\n\tresultado as (\n\t\tSELECT  ld.Id_Procedimiento idProcedimiento , count(lp.Id_Protocolo) numeroResultado\n\t\tfrom l_resultados lr \n\t\tinner join l_detalleresultado ld on (lr.Id=ld.Id_Resultado)\n\t\tinner join l_protocoloxprocedimiento lp on (lp.Id=ld.Id_ProtocolProcedim)\n\t\tinner join l_detallerecepcion ld2 on (ld2.Id_Recepcion=lr.Id_Recepcion) and (ld2.Id_Procedim=ld.Id_Procedimiento )\n\t\twhere lr.Id_Recepcion =" + nRecepcion + "   and lp.esObligatorio =1 and lr.Estado =0 and ld2.ValidadoLab =1\n\t\tgroup by lr.Id_Recepcion, ld.Id_Procedimiento \n\t)\n\tSELECT m.idRecepcion,  m.idProcedimiento, if(ifnull(r.numeroResultado, 0)=0,'PENDIENTE', if(m.cantidad=ifnull(r.numeroResultado, 0), 'COMPLETADO', 'PARCIALMENTE')) estado\n\tfrom maestra m\n\tleft join resultado r on (m.idProcedimiento=r.idProcedimiento)\n\t) d set l_detallerecepcion.validacionEstado =d.estado \n\twhere l_detallerecepcion.Id_Recepcion =d.idRecepcion and l_detallerecepcion.Id_Procedim =d.idProcedimiento";
            System.out.println("sql " + sql1);
            this.conexion.createStatement().execute(sql1);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasMySQL.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mELiminarAntGinecologicos(String xnparametro, int xvalorparametro) {
        try {
            CallableStatement cs = establecerConexionBd().prepareCall("{CALL EliminarAntGinecologicosM(?)}");
            Throwable th = null;
            try {
                try {
                    cs.setInt(xnparametro, xvalorparametro);
                    cs.execute();
                    cs.close();
                    if (cs != null) {
                        if (0 != 0) {
                            try {
                                cs.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        } else {
                            cs.close();
                        }
                    }
                } finally {
                }
            } catch (Throwable th3) {
                th = th3;
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasMySQL.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mRecargarCombo(JComboBox xcombo, String[] xlista, String xsql) {
        xcombo.removeAllItems();
        llenarCombo(xsql, xlista, xcombo);
        xcombo.setSelectedIndex(-1);
    }
}
