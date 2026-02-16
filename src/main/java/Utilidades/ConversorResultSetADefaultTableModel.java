package Utilidades;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/ConversorResultSetADefaultTableModel.class */
public class ConversorResultSetADefaultTableModel {
    public static void rellena(ResultSet rs, DefaultTableModel modelo) {
        configuraColumnas(rs, modelo);
        vaciaFilasModelo(modelo);
        anhadeFilasDeDatos(rs, modelo);
    }

    private static void anhadeFilasDeDatos(ResultSet rs, DefaultTableModel modelo) {
        int numeroFila = 0;
        while (rs.next()) {
            try {
                Object[] datosFila = new Object[modelo.getColumnCount()];
                for (int i = 0; i < modelo.getColumnCount(); i++) {
                    datosFila[i] = rs.getObject(i + 1);
                }
                modelo.addRow(datosFila);
                numeroFila++;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        rs.close();
    }

    private static void vaciaFilasModelo(DefaultTableModel modelo) {
        while (modelo.getRowCount() > 0) {
            try {
                modelo.removeRow(0);
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
    }

    public static void configuraColumnas(ResultSet rs, DefaultTableModel modelo) {
        try {
            ResultSetMetaData metaDatos = rs.getMetaData();
            int numeroColumnas = metaDatos.getColumnCount();
            Object[] etiquetas = new Object[numeroColumnas];
            for (int i = 0; i < numeroColumnas; i++) {
                etiquetas[i] = metaDatos.getColumnLabel(i + 1);
            }
            modelo.setColumnIdentifiers(etiquetas);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
