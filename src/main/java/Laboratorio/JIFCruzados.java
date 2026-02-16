package Laboratorio;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/* JADX INFO: loaded from: GenomaP.jar:Laboratorio/JIFCruzados.class */
public class JIFCruzados extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Object[] xdatos;
    private String sql;
    private String xllamador;
    private ResultSet rs;
    private Object textFiel;
    private final Metodos metodos;
    private JButton jBbuscar;
    private JButton jBeliminar;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JTable jTable1;

    public JIFCruzados() {
        initComponents();
        this.metodos = new Metodos();
    }

    /* JADX WARN: Type inference failed for: r3v17, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jBeliminar = new JButton();
        this.jBbuscar = new JButton();
        this.jPanel1 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.jTable1 = new JTable();
        setClosable(true);
        setTitle("RECEPCIONES DUPLICADAS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("Cruzados");
        this.jBeliminar.setFont(new Font("Arial", 1, 14));
        this.jBeliminar.setForeground(new Color(0, 0, 0));
        this.jBeliminar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/equiz rojo.png")));
        this.jBeliminar.setText("Eliminar Duplicados");
        this.jBeliminar.addActionListener(new ActionListener() { // from class: Laboratorio.JIFCruzados.1
            public void actionPerformed(ActionEvent evt) {
                JIFCruzados.this.jBeliminarActionPerformed(evt);
            }
        });
        this.jBbuscar.setFont(new Font("Arial", 1, 14));
        this.jBbuscar.setForeground(new Color(0, 0, 0));
        this.jBbuscar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Buscar.png")));
        this.jBbuscar.setText("Buscar Duplicados");
        this.jBbuscar.addActionListener(new ActionListener() { // from class: Laboratorio.JIFCruzados.2
            public void actionPerformed(ActionEvent evt) {
                JIFCruzados.this.jBbuscarActionPerformed(evt);
            }
        });
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORICO", 2, 2, new Font("Segoe UI", 1, 14), new Color(0, 102, 0)));
        this.jTable1.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.jTable1.addMouseListener(new MouseAdapter() { // from class: Laboratorio.JIFCruzados.3
            public void mouseClicked(MouseEvent evt) {
                JIFCruzados.this.jTable1MouseClicked(evt);
            }
        });
        this.jTable1.addKeyListener(new KeyAdapter() { // from class: Laboratorio.JIFCruzados.4
            public void keyPressed(KeyEvent evt) {
                JIFCruzados.this.jTable1KeyPressed(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.jTable1);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -1, 539, 32767));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -2, 216, -2).addContainerGap(-1, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jBbuscar, -1, -1, 32767).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jBeliminar, GroupLayout.Alignment.LEADING, -1, 549, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(17, 17, 17).addComponent(this.jPanel1, -2, -1, -2).addGap(18, 18, 18).addComponent(this.jBbuscar, -2, 55, -2).addGap(18, 18, 18).addComponent(this.jBeliminar, -2, 55, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jBbuscarActionPerformed(ActionEvent evt) {
        mCargarDatosTabla();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jBeliminarActionPerformed(ActionEvent evt) {
        int filaSeleccionada = this.jTable1.getSelectedRow();
        if (filaSeleccionada != -1) {
            int idDelete = ((Integer) this.jTable1.getValueAt(filaSeleccionada, 0)).intValue();
            eliminarregistro(idDelete);
            mCargarDatosTabla();
            JOptionPane.showMessageDialog(this, "Recepción Duplicada Eliminada. Por favor, volver a Recepcionar.");
            Principal.clasefacturacion.cargarPantalla("AgendaSimedis");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jTable1KeyPressed(KeyEvent evt) {
        if (this.jTable1.getSelectedRow() == -1 || evt.getKeyCode() == 10) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jTable1MouseClicked(MouseEvent evt) {
        int filaSeleccionada = this.jTable1.getSelectedRow();
        if (filaSeleccionada != -1) {
            this.jTable1.setRowSelectionInterval(filaSeleccionada, filaSeleccionada);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Idelete", "Id", "NoAutorizacion", "idRecepcion", "idResultado1", "idResultado2"}) { // from class: Laboratorio.JIFCruzados.5
            Class[] types = {Integer.class, Integer.class, String.class, Integer.class, Integer.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.jTable1.setDefaultRenderer(JButton.class, new TableCellRenderer() { // from class: Laboratorio.JIFCruzados.6
            public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) {
                return (Component) objeto;
            }
        });
        JTable jTable = this.jTable1;
        JTable jTable2 = this.jTable1;
        jTable.setAutoResizeMode(0);
        this.jTable1.doLayout();
        this.jTable1.setFont(new Font("Arial", 1, 12));
        this.jTable1.setSelectionBackground(Color.WHITE);
        this.jTable1.setSelectionForeground(Color.RED);
        JTable jTable3 = this.jTable1;
        JTable jTable4 = this.jTable1;
        jTable3.setAutoResizeMode(0);
        this.jTable1.doLayout();
        this.jTable1.setModel(this.xmodelo);
        this.jTable1.getColumnModel().getColumn(0).setPreferredWidth(90);
        this.jTable1.getColumnModel().getColumn(1).setPreferredWidth(90);
        this.jTable1.getColumnModel().getColumn(2).setPreferredWidth(105);
        this.jTable1.getColumnModel().getColumn(3).setPreferredWidth(110);
        this.jTable1.getColumnModel().getColumn(4).setPreferredWidth(90);
        this.jTable1.getColumnModel().getColumn(5).setPreferredWidth(90);
        this.jScrollPane1.getViewport().add(this.jTable1);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            ResultSet xrs = this.xct.traerRs("SELECT\n    `ingreso`.`Id` AS Idelete\n    , `f_ordenes`.`Id`\n    , `ingreso`.`NoAutorizacion`    \n    , `l_recepcion`.`Id` AS idRecepcion\n    , `l_resultados`.`Id` AS idResultado1\n   , `l_resultados`.`Id` AS idResultado2\nFROM\n    `baseserver`.`f_ordenes`\n    INNER JOIN `baseserver`.`ingreso` \n        ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `baseserver`.`l_recepcion` \n        ON (`l_recepcion`.`Id_OrdenFacturac` = `f_ordenes`.`Id`)\n    LEFT JOIN `baseserver`.`l_resultados`\n    ON(`l_resultados`.`Id_Recepcion`=`l_recepcion`.`Id`)\n        WHERE `NoAutorizacion`<>'' AND  SUBSTRING(`ingreso`.`NoAutorizacion`,3)<>`l_recepcion`.`Id`");
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt("Idelete")), n, 0);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt("Id")), n, 1);
                    this.xmodelo.setValueAt(xrs.getString("NoAutorizacion"), n, 2);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt("idRecepcion")), n, 3);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt("idResultado1")), n, 4);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt("idResultado2")), n, 5);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFCruzados.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void eliminarregistro(int idDelete) {
        try {
            String sql = "CALL eliminar_ingreso_laboratorio (" + idDelete + ")";
            System.out.println("mostrar consulta" + sql);
            this.xct.ejecutarSQL(sql);
            this.xct.cerrarConexionBd();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
