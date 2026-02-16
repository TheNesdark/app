package com.genoma.plus.controller.parametrizacion;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.ConsultasSqlServer;
import Utilidades.Metodos;
import com.genoma.plus.controller.facturacion.saludocupacional.JIF_FacturacionAgil;
import com.genoma.plus.jpa.entities.EmpresaContConvenioEntity;
import com.genoma.plus.jpa.entities.FEmpresacontxconvenioMision;
import com.genoma.plus.jpa.service.f_empresacontxconvenio_misionService;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/parametrizacion/JDEmpresaMisionBienestar.class */
public class JDEmpresaMisionBienestar extends JDialog {
    private DefaultTableModel xmodelo;
    private ConsultasMySQL xct;
    private Object[] xdato;
    private Integer idConvenioE;
    private Metodos xmt;
    Principal xjp;
    private final f_empresacontxconvenio_misionService service;
    private JInternalFrame formularioLlamador;
    private String guidEmpresaBS1;
    private JButton JBGrabar10;
    private JButton JBGrabar11;
    private JButton JBGrabar9;
    private JPanel JPI_Exportacion6;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JFormattedTextField JTFDocumento;
    private JFormattedTextField JTFNombre;
    private JPanel jPanel1;

    public JDEmpresaMisionBienestar(Frame parent, boolean modal, Object xllamador, Integer idConvenioe, JInternalFrame formularioLlamador) {
        super(parent, modal);
        this.xct = new ConsultasMySQL();
        this.xmt = new Metodos();
        this.service = (f_empresacontxconvenio_misionService) Principal.contexto.getBean(f_empresacontxconvenio_misionService.class);
        initComponents();
        this.formularioLlamador = formularioLlamador;
        this.idConvenioE = idConvenioe;
        mCargarDatosTabla();
    }

    public JDEmpresaMisionBienestar(Frame parent, boolean modal, Object xllamador, Integer idConvenioe, JInternalFrame formularioLlamador, String uuidEmpresaBS1) {
        super(parent, modal);
        this.xct = new ConsultasMySQL();
        this.xmt = new Metodos();
        this.service = (f_empresacontxconvenio_misionService) Principal.contexto.getBean(f_empresacontxconvenio_misionService.class);
        initComponents();
        this.formularioLlamador = formularioLlamador;
        this.idConvenioE = idConvenioe;
        this.guidEmpresaBS1 = uuidEmpresaBS1;
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v23, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JTFDocumento = new JFormattedTextField();
        this.JTFNombre = new JFormattedTextField();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPI_Exportacion6 = new JPanel();
        this.JBGrabar9 = new JButton();
        this.JBGrabar10 = new JButton();
        this.JBGrabar11 = new JButton();
        setDefaultCloseOperation(2);
        setTitle("Empresa en Misión");
        setName("JDEmpresaMision");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 1, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFDocumento.setBorder(BorderFactory.createTitledBorder((Border) null, "Numero De Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFDocumento.setFont(new Font("Arial", 1, 12));
        this.JTFDocumento.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.parametrizacion.JDEmpresaMisionBienestar.1
            public void keyTyped(KeyEvent evt) {
                JDEmpresaMisionBienestar.this.JTFDocumentoKeyTyped(evt);
            }
        });
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.parametrizacion.JDEmpresaMisionBienestar.2
            public void keyTyped(KeyEvent evt) {
                JDEmpresaMisionBienestar.this.JTFNombreKeyTyped(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFDocumento, -2, 161, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFNombre).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(15, 15, 15).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFDocumento, -2, 50, -2).addComponent(this.JTFNombre, -2, 50, -2)).addContainerGap(19, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JBGrabar9.setFont(new Font("Arial", 1, 12));
        this.JBGrabar9.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBGrabar9.setText("Nuevo");
        this.JBGrabar9.setToolTipText("Grabar");
        this.JBGrabar9.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.parametrizacion.JDEmpresaMisionBienestar.3
            public void actionPerformed(ActionEvent evt) {
                JDEmpresaMisionBienestar.this.JBGrabar9ActionPerformed(evt);
            }
        });
        this.JBGrabar10.setFont(new Font("Arial", 1, 12));
        this.JBGrabar10.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBGrabar10.setText("Grabar");
        this.JBGrabar10.setToolTipText("Grabar");
        this.JBGrabar10.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.parametrizacion.JDEmpresaMisionBienestar.4
            public void actionPerformed(ActionEvent evt) {
                JDEmpresaMisionBienestar.this.JBGrabar10ActionPerformed(evt);
            }
        });
        this.JBGrabar11.setFont(new Font("Arial", 1, 12));
        this.JBGrabar11.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBGrabar11.setText("Salir");
        this.JBGrabar11.setToolTipText("Grabar");
        this.JBGrabar11.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.parametrizacion.JDEmpresaMisionBienestar.5
            public void actionPerformed(ActionEvent evt) {
                JDEmpresaMisionBienestar.this.JBGrabar11ActionPerformed(evt);
            }
        });
        GroupLayout JPI_Exportacion6Layout = new GroupLayout(this.JPI_Exportacion6);
        this.JPI_Exportacion6.setLayout(JPI_Exportacion6Layout);
        JPI_Exportacion6Layout.setHorizontalGroup(JPI_Exportacion6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Exportacion6Layout.createSequentialGroup().addGap(14, 14, 14).addComponent(this.JBGrabar10, -2, 161, -2).addGap(88, 88, 88).addComponent(this.JBGrabar9, -2, 161, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBGrabar11, -2, 139, -2).addGap(19, 19, 19)));
        JPI_Exportacion6Layout.setVerticalGroup(JPI_Exportacion6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_Exportacion6Layout.createSequentialGroup().addGap(0, 0, 32767).addGroup(JPI_Exportacion6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBGrabar9, -2, 50, -2).addComponent(this.JBGrabar11, -2, 50, -2).addComponent(this.JBGrabar10, -2, 50, -2)).addContainerGap()));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.JSPDetalle, GroupLayout.Alignment.TRAILING, -1, 699, 32767).addComponent(this.JPI_Exportacion6, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap(14, 32767).addComponent(this.jPanel1, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JSPDetalle, -2, 207, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPI_Exportacion6, -2, -1, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGrabar9ActionPerformed(ActionEvent evt) {
        this.JTFNombre.setText("");
        this.JTFDocumento.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGrabar10ActionPerformed(ActionEvent evt) {
        FEmpresacontxconvenioMision entity = new FEmpresacontxconvenioMision();
        if (this.JTFNombre.getText() != null && this.JTFDocumento.getText() != null) {
            int y = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (y == 0) {
                EmpresaContConvenioEntity convenioEntity = new EmpresaContConvenioEntity();
                convenioEntity.setId(this.idConvenioE);
                entity.setIdEmpresaConvenio(convenioEntity);
                entity.setNombre(this.JTFNombre.getText());
                entity.setEstado(true);
                entity.setFecha(this.xmt.getFechaActual());
                entity.setIdUsuarioRh(Principal.usuarioSistemaDTO.getIdPersonaCargo());
                entity.setDocumento(this.JTFDocumento.getText());
                this.service.grabar(entity);
                if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
                    grabarEmpresaAreaBS1(this.JTFNombre.getText(), this.guidEmpresaBS1);
                }
                mCargarDatosTabla();
            }
        }
    }

    private void grabarEmpresaAreaBS1(String areaNombre, String uuidEmpresaIdBS1) {
        ConsultasSqlServer Cs = new ConsultasSqlServer();
        UUID uuidAreaID = UUID.randomUUID();
        String query = "INSERT INTO Empresa_Area\n(Area_ID, Area_Nombre, zEmpr_ID)\nVALUES('" + String.valueOf(uuidAreaID) + "','" + areaNombre + "', '" + uuidEmpresaIdBS1 + "');";
        Cs.ejecutarSQL(query);
        Cs.cerrarConexionBd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGrabar11ActionPerformed(ActionEvent evt) {
        if (this.formularioLlamador != null && this.formularioLlamador.getName().equals("xJIFFacturacionAgil")) {
            JIF_FacturacionAgil agil = (JIF_FacturacionAgil) this.formularioLlamador;
            agil.llenarComboEmpresaMision();
        }
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFDocumentoKeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreKeyTyped(KeyEvent evt) {
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"IdEmpresa Convenio", "Nombre", "Fecha", "IdUsuarioRH", "Documento"}) { // from class: com.genoma.plus.controller.parametrizacion.JDEmpresaMisionBienestar.6
            Class[] types = {Integer.class, String.class, Date.class, Integer.class, String.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(150);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            String sql = "SELECT idEmpresaConvenio, nombre, fecha,idUsuarioRh, documento  FROM f_empresacontxconvenio_mision fem WHERE idEmpresaConvenio =" + this.idConvenioE + "";
            System.out.println(sql);
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt("idEmpresaConvenio")), n, 0);
                    this.xmodelo.setValueAt(xrs.getString("nombre"), n, 1);
                    this.xmodelo.setValueAt(xrs.getDate("fecha"), n, 2);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt("idUsuarioRh")), n, 3);
                    this.xmodelo.setValueAt(xrs.getString("documento"), n, 4);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDEmpresaMisionBienestar.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
