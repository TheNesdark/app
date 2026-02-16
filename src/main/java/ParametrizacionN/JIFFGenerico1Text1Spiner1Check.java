package ParametrizacionN;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFFGenerico1Text1Spiner1Check.class */
public class JIFFGenerico1Text1Spiner1Check extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String xnombre;
    private JCheckBox JCHEstado;
    private JSpinner JSPUno;
    private JTextField JTFNombre;
    private JTable JTHistorico;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private int xEstado = 1;
    private Metodos xmetodos = new Metodos();
    private ConsultasMySQL xconsulta = new ConsultasMySQL();

    public JIFFGenerico1Text1Spiner1Check(String xNombre, String xTitulo) {
        initComponents();
        setTitle(xTitulo.toUpperCase());
        setName(xNombre);
        this.xnombre = xNombre;
        System.out.println(xNombre);
        mCargarDatosTabla();
        mIniciarComponentes();
        mNuevo();
    }

    private void mIniciarComponentes() {
        if (this.xnombre.equals("Tipo Prioridad")) {
            this.JSPUno.setBorder(BorderFactory.createTitledBorder((Border) null, "Orden", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.JSPUno.setToolTipText("Orden");
        }
        if (this.xnombre.equals("Nombre Encuesta")) {
            this.JSPUno.setBorder(BorderFactory.createTitledBorder((Border) null, "AplicaR", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.JSPUno.setToolTipText("Aplica Resolucion Nº256");
        }
    }

    /* JADX WARN: Type inference failed for: r3v29, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JTFNombre = new JTextField();
        this.JSPUno = new JSpinner();
        this.JCHEstado = new JCheckBox();
        this.jScrollPane1 = new JScrollPane();
        this.JTHistorico = new JTable();
        setClosable(true);
        setIconifiable(true);
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setToolTipText("Digite el nombre del municipio");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPUno.setFont(new Font("Arial", 1, 12));
        this.JSPUno.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSPUno.setBorder(BorderFactory.createTitledBorder((Border) null, "Orden", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFGenerico1Text1Spiner1Check.1
            public void actionPerformed(ActionEvent evt) {
                JIFFGenerico1Text1Spiner1Check.this.JCHEstadoActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFNombre).addGap(10, 10, 10).addComponent(this.JSPUno, -2, 105, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEstado).addGap(10, 10, 10)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGap(10, 10, 10).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombre, -2, -1, -2).addComponent(this.JSPUno, -2, -1, -2).addComponent(this.JCHEstado)).addGap(10, 10, 10)));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTHistorico.setFont(new Font("Arial", 1, 12));
        this.JTHistorico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTHistorico.setSelectionForeground(new Color(255, 0, 0));
        this.JTHistorico.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFFGenerico1Text1Spiner1Check.2
            public void mouseClicked(MouseEvent evt) {
                JIFFGenerico1Text1Spiner1Check.this.JTHistoricoMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTHistorico);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -1, 751, 32767).addComponent(this.jPanel1, -1, -1, 32767)).addGap(10, 10, 10)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane1, -1, 289, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.xEstado = 1;
        } else {
            this.xEstado = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistoricoMouseClicked(MouseEvent evt) {
        if (this.JTHistorico.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 0).toString());
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 1).toString());
            this.JSPUno.setValue(Integer.valueOf(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 2).toString()));
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 3).toString()).booleanValue());
        }
    }

    public void mGrabar() {
        String sql = null;
        if (!this.JTFNombre.getText().isEmpty()) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                if (Principal.txtNo.getText().isEmpty()) {
                    if (this.xnombre.equals("Tipo Prioridad")) {
                        sql = " Insert into  g_tipoprioridad(Nbre, NDias,Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.JSPUno.getValue() + "','" + this.xEstado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else if (this.xnombre.equals("Nombre Encuesta")) {
                        sql = " Insert into t_encuestas(Nbre, AplicaR, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.JSPUno.getValue() + "','" + this.xEstado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    }
                    this.xconsulta.ejecutarSQL(sql);
                    this.xconsulta.cerrarConexionBd();
                } else {
                    if (this.xnombre.equals("Tipo Prioridad")) {
                        sql = "update g_tipoprioridad set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xEstado + "',NDias='" + this.JSPUno.getValue() + "',Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "',UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' where Id='" + Principal.txtNo.getText() + "'";
                    } else if (this.xnombre.equals("Nombre Encuesta")) {
                        sql = " update t_encuestas set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',AplicaR='" + this.JSPUno.getValue() + "',Estado='" + this.xEstado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                    }
                    this.xconsulta.ejecutarSQL(sql);
                    this.xconsulta.cerrarConexionBd();
                }
                mCargarDatosTabla();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El nombre no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFNombre.requestFocus();
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JTFNombre.setText("");
        this.JSPUno.setValue(new Integer(0));
        this.JCHEstado.setSelected(true);
        this.xEstado = 1;
    }

    private void mCargarDatosTabla() {
        try {
            String sql = null;
            String[] xencabezado = null;
            if (this.xnombre.equals("Tipo Prioridad")) {
                xencabezado = new String[]{"Id", "Nombre", "No Dias", "Estado"};
                sql = "SELECT Id, Nbre, NDias, Estado FROM g_tipoprioridad ORDER BY Nbre ASC ";
            }
            if (this.xnombre.equals("Nombre Encuesta")) {
                xencabezado = new String[]{"Id", "Nombre", "AplicaR", "Estado"};
                sql = "SELECT Id, Nbre, AplicaR, Estado FROM t_encuestas ORDER BY Nbre ASC";
            }
            mCrearModeloDatos(xencabezado);
            ResultSet xrs = this.xconsulta.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(3)), n, 2);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(4)), n, 3);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGenericoCh.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos(String[] xcabecera) {
        this.xmodelo = new DefaultTableModel(new Object[0], xcabecera) { // from class: ParametrizacionN.JIFFGenerico1Text1Spiner1Check.3
            Class[] types = {Long.class, String.class, Long.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistorico.setModel(this.xmodelo);
        this.JTHistorico.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTHistorico.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTHistorico.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTHistorico.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTHistorico.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTHistorico.getColumnModel().getColumn(3).setPreferredWidth(30);
    }
}
