package Facturacion;

import Acceso.Principal;
import General.Anular;
import General.Persona;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
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
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Facturacion/JIFAutorizacion_Servicios.class */
public class JIFAutorizacion_Servicios extends JInternalFrame {
    public Persona xjppersona;
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private DefaultTableModel xmodelo2;
    private Object[] xdato;
    private String xnombre;
    private String xsql;
    private String[] xid_tercero;
    private String[] xidconvenio;
    private JButton JBT_Adicionar;
    private JComboBox JCBConvenio;
    private JComboBox JCBTercero;
    private JPanel JPIDOrden;
    private JPanel JPIDatosOrden;
    private JPanel JPIFDatosUsuario;
    private JPanel JPI_DatosProc;
    private JPanel JPI_Historico;
    private JPanel JPI_OrdenesHC;
    private JScrollPane JSPDetalleDoc;
    private JScrollPane JSPObservacion;
    private JSpinner JSP_Cantidad;
    private JScrollPane JSP_Historico;
    private JScrollPane JSP_HistoricoHc;
    private JTextArea JTAObservacion;
    private JTable JTBDetalle;
    private JTable JTB_Historico;
    private JTable JTB_HistoricoHc;
    public JTextField JTF_Codigo;
    public JTextField JTF_NProcedimiento;
    private JTabbedPane JTPDetalleO;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private int xnfila = 0;
    private long xId_orden = 0;

    public JIFAutorizacion_Servicios() {
        initComponents();
        mCargasPanelUsuario();
        mNuevo();
    }

    public JIFAutorizacion_Servicios(long xIdIngreso, int modulo, String nombreFormulario, String idOrden, String idProcedimientos) {
        initComponents();
        setName(nombreFormulario);
        mCargasPanelUsuario();
        mNuevo();
        if (xIdIngreso != 0) {
            mCargarDatoIngreso(Long.valueOf(xIdIngreso));
        }
    }

    /* JADX WARN: Type inference failed for: r3v82, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v92, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIFDatosUsuario = new JPanel();
        this.JTPDetalleO = new JTabbedPane();
        this.JPIDOrden = new JPanel();
        this.JPIDatosOrden = new JPanel();
        this.JCBTercero = new JComboBox();
        this.JSPObservacion = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.JCBConvenio = new JComboBox();
        this.JSPDetalleDoc = new JScrollPane();
        this.JTBDetalle = new JTable();
        this.JPI_DatosProc = new JPanel();
        this.JTF_Codigo = new JTextField();
        this.JTF_NProcedimiento = new JTextField();
        this.JSP_Cantidad = new JSpinner();
        this.JBT_Adicionar = new JButton();
        this.JPI_Historico = new JPanel();
        this.JSP_Historico = new JScrollPane();
        this.JTB_Historico = new JTable();
        this.JPI_OrdenesHC = new JPanel();
        this.JSP_HistoricoHc = new JScrollPane();
        this.JTB_HistoricoHc = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("GENERADOR DE AUTORIZACIONES DE SERVICIOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifautorizacion_servicios");
        this.JPIFDatosUsuario.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN DE USUARIO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        GroupLayout JPIFDatosUsuarioLayout = new GroupLayout(this.JPIFDatosUsuario);
        this.JPIFDatosUsuario.setLayout(JPIFDatosUsuarioLayout);
        JPIFDatosUsuarioLayout.setHorizontalGroup(JPIFDatosUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767));
        JPIFDatosUsuarioLayout.setVerticalGroup(JPIFDatosUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 168, 32767));
        this.JTPDetalleO.setForeground(new Color(0, 103, 0));
        this.JTPDetalleO.setFont(new Font("Arial", 1, 14));
        this.JPIDatosOrden.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN GENERAL", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JCBTercero.setFont(new Font("Arial", 1, 12));
        this.JCBTercero.setBorder(BorderFactory.createTitledBorder((Border) null, "Tercero", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacion.setColumns(1);
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JTAObservacion.setRows(1);
        this.JSPObservacion.setViewportView(this.JTAObservacion);
        this.JCBConvenio.setFont(new Font("Arial", 1, 12));
        this.JCBConvenio.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa a Facturar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosOrdenLayout = new GroupLayout(this.JPIDatosOrden);
        this.JPIDatosOrden.setLayout(JPIDatosOrdenLayout);
        JPIDatosOrdenLayout.setHorizontalGroup(JPIDatosOrdenLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosOrdenLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosOrdenLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPObservacion, -1, 935, 32767).addGroup(JPIDatosOrdenLayout.createSequentialGroup().addComponent(this.JCBTercero, 0, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBConvenio, -2, 483, -2))).addContainerGap()));
        JPIDatosOrdenLayout.setVerticalGroup(JPIDatosOrdenLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosOrdenLayout.createSequentialGroup().addGroup(JPIDatosOrdenLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTercero, -2, 50, -2).addComponent(this.JCBConvenio, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPObservacion, -1, 55, 32767).addContainerGap()));
        this.JSPDetalleDoc.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setRowHeight(25);
        this.JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDetalle.addKeyListener(new KeyAdapter() { // from class: Facturacion.JIFAutorizacion_Servicios.1
            public void keyPressed(KeyEvent evt) {
                JIFAutorizacion_Servicios.this.JTBDetalleKeyPressed(evt);
            }
        });
        this.JSPDetalleDoc.setViewportView(this.JTBDetalle);
        this.JPI_DatosProc.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS SERVICIO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTF_Codigo.setFont(new Font("Arial", 1, 12));
        this.JTF_Codigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Código", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_Codigo.addFocusListener(new FocusAdapter() { // from class: Facturacion.JIFAutorizacion_Servicios.2
            public void focusLost(FocusEvent evt) {
                JIFAutorizacion_Servicios.this.JTF_CodigoFocusLost(evt);
            }
        });
        this.JTF_Codigo.addKeyListener(new KeyAdapter() { // from class: Facturacion.JIFAutorizacion_Servicios.3
            public void keyPressed(KeyEvent evt) {
                JIFAutorizacion_Servicios.this.JTF_CodigoKeyPressed(evt);
            }
        });
        this.JTF_NProcedimiento.setFont(new Font("Arial", 1, 12));
        this.JTF_NProcedimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Procedimiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_NProcedimiento.addMouseListener(new MouseAdapter() { // from class: Facturacion.JIFAutorizacion_Servicios.4
            public void mouseClicked(MouseEvent evt) {
                JIFAutorizacion_Servicios.this.JTF_NProcedimientoMouseClicked(evt);
            }
        });
        this.JSP_Cantidad.setFont(new Font("Arial", 1, 12));
        this.JSP_Cantidad.setModel(new SpinnerNumberModel(1, 1, (Comparable) null, 1));
        this.JSP_Cantidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Cant.", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSP_Cantidad.addKeyListener(new KeyAdapter() { // from class: Facturacion.JIFAutorizacion_Servicios.5
            public void keyPressed(KeyEvent evt) {
                JIFAutorizacion_Servicios.this.JSP_CantidadKeyPressed(evt);
            }
        });
        this.JBT_Adicionar.setFont(new Font("Arial", 1, 12));
        this.JBT_Adicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBT_Adicionar.setText("Adicionar");
        this.JBT_Adicionar.addActionListener(new ActionListener() { // from class: Facturacion.JIFAutorizacion_Servicios.6
            public void actionPerformed(ActionEvent evt) {
                JIFAutorizacion_Servicios.this.JBT_AdicionarActionPerformed(evt);
            }
        });
        this.JBT_Adicionar.addKeyListener(new KeyAdapter() { // from class: Facturacion.JIFAutorizacion_Servicios.7
            public void keyPressed(KeyEvent evt) {
                JIFAutorizacion_Servicios.this.JBT_AdicionarKeyPressed(evt);
            }
        });
        GroupLayout JPI_DatosProcLayout = new GroupLayout(this.JPI_DatosProc);
        this.JPI_DatosProc.setLayout(JPI_DatosProcLayout);
        JPI_DatosProcLayout.setHorizontalGroup(JPI_DatosProcLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosProcLayout.createSequentialGroup().addContainerGap().addComponent(this.JTF_Codigo, -2, 102, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTF_NProcedimiento, -2, 590, -2).addGap(18, 18, 18).addComponent(this.JSP_Cantidad, -2, 60, -2).addGap(18, 18, 18).addComponent(this.JBT_Adicionar, -1, 141, 32767).addContainerGap()));
        JPI_DatosProcLayout.setVerticalGroup(JPI_DatosProcLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_DatosProcLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPI_DatosProcLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JBT_Adicionar, -1, -1, 32767).addComponent(this.JSP_Cantidad).addGroup(GroupLayout.Alignment.LEADING, JPI_DatosProcLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTF_NProcedimiento, -2, 50, -2).addComponent(this.JTF_Codigo, -2, 50, -2))).addContainerGap()));
        GroupLayout JPIDOrdenLayout = new GroupLayout(this.JPIDOrden);
        this.JPIDOrden.setLayout(JPIDOrdenLayout);
        JPIDOrdenLayout.setHorizontalGroup(JPIDOrdenLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDOrdenLayout.createSequentialGroup().addContainerGap().addGroup(JPIDOrdenLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalleDoc).addComponent(this.JPI_DatosProc, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JPIDatosOrden, -1, -1, 32767)).addContainerGap()));
        JPIDOrdenLayout.setVerticalGroup(JPIDOrdenLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDOrdenLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosOrden, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPI_DatosProc, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalleDoc, -2, 196, -2).addContainerGap()));
        this.JTPDetalleO.addTab("AUTORIZACIÓN", this.JPIDOrden);
        this.JSP_Historico.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTB_Historico.setFont(new Font("Arial", 1, 12));
        this.JTB_Historico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_Historico.setRowHeight(25);
        this.JTB_Historico.setSelectionBackground(new Color(255, 255, 255));
        this.JTB_Historico.setSelectionForeground(Color.red);
        this.JTB_Historico.addMouseListener(new MouseAdapter() { // from class: Facturacion.JIFAutorizacion_Servicios.8
            public void mouseClicked(MouseEvent evt) {
                JIFAutorizacion_Servicios.this.JTB_HistoricoMouseClicked(evt);
            }
        });
        this.JSP_Historico.setViewportView(this.JTB_Historico);
        GroupLayout JPI_HistoricoLayout = new GroupLayout(this.JPI_Historico);
        this.JPI_Historico.setLayout(JPI_HistoricoLayout);
        JPI_HistoricoLayout.setHorizontalGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_HistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSP_Historico, -1, 967, 32767).addContainerGap()));
        JPI_HistoricoLayout.setVerticalGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_HistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSP_Historico, -1, 459, 32767).addContainerGap()));
        this.JTPDetalleO.addTab("HISTÓRICO", this.JPI_Historico);
        this.JSP_HistoricoHc.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTB_HistoricoHc.setFont(new Font("Arial", 1, 12));
        this.JTB_HistoricoHc.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_HistoricoHc.setRowHeight(25);
        this.JTB_HistoricoHc.setSelectionBackground(new Color(255, 255, 255));
        this.JTB_HistoricoHc.setSelectionForeground(Color.red);
        this.JTB_HistoricoHc.addMouseListener(new MouseAdapter() { // from class: Facturacion.JIFAutorizacion_Servicios.9
            public void mouseClicked(MouseEvent evt) {
                JIFAutorizacion_Servicios.this.JTB_HistoricoHcMouseClicked(evt);
            }
        });
        this.JSP_HistoricoHc.setViewportView(this.JTB_HistoricoHc);
        GroupLayout JPI_OrdenesHCLayout = new GroupLayout(this.JPI_OrdenesHC);
        this.JPI_OrdenesHC.setLayout(JPI_OrdenesHCLayout);
        JPI_OrdenesHCLayout.setHorizontalGroup(JPI_OrdenesHCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_OrdenesHCLayout.createSequentialGroup().addContainerGap().addComponent(this.JSP_HistoricoHc, -1, 967, 32767).addContainerGap()));
        JPI_OrdenesHCLayout.setVerticalGroup(JPI_OrdenesHCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_OrdenesHCLayout.createSequentialGroup().addContainerGap().addComponent(this.JSP_HistoricoHc, -1, 459, 32767).addContainerGap()));
        this.JTPDetalleO.addTab("ORDENES HISTORIA CLÍNICA", this.JPI_OrdenesHC);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIFDatosUsuario, -1, -1, 32767).addComponent(this.JTPDetalleO)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIFDatosUsuario, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JTPDetalleO).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_CodigoFocusLost(FocusEvent evt) {
        if (!this.JTF_Codigo.getText().isEmpty()) {
            mBuscarProc_Codigo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_CodigoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10 && !this.JTF_Codigo.getText().isEmpty()) {
            mBuscarProc_Codigo();
            this.JSP_Cantidad.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_AdicionarActionPerformed(ActionEvent evt) {
        mAdicionar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_HistoricoMouseClicked(MouseEvent evt) {
        if (this.JTB_Historico.getSelectedRow() != -1 && evt.getClickCount() == 2) {
            Principal.txtNo.setText(this.xmodelo1.getValueAt(this.JTB_Historico.getSelectedRow(), 0).toString());
            int x = JOptionPane.showConfirmDialog(this, "Desea visualizar el informe?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                mImprimir();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_NProcedimientoMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            BuscarProced frmBuscarProced = new BuscarProced((Frame) null, true, (JInternalFrame) this, "xjifautorizacion_servicios");
            frmBuscarProced.setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_HistoricoHcMouseClicked(MouseEvent evt) {
        if (!Principal.txtNo.getText().isEmpty() || this.JTB_HistoricoHc.getSelectedRow() == -1) {
            return;
        }
        if (Long.valueOf(this.xmodelo2.getValueAt(this.JTB_HistoricoHc.getSelectedRow(), 7).toString()).longValue() != 0) {
            this.xId_orden = Long.valueOf(this.xmodelo2.getValueAt(this.JTB_HistoricoHc.getSelectedRow(), 0).toString()).longValue();
            if (Long.valueOf(this.xmodelo2.getValueAt(this.JTB_HistoricoHc.getSelectedRow(), 4).toString()).longValue() == 0) {
                int x = JOptionPane.showInternalConfirmDialog(this, "Desea cargar la orden seleccionada para autorizar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    mCargado_DetalleOrdenHC(this.xmodelo2.getValueAt(this.JTB_HistoricoHc.getSelectedRow(), 0).toString());
                    this.JTPDetalleO.setSelectedIndex(0);
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Orden ya se cuentra autorizada", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTPDetalleO.setSelectedIndex(1);
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Orden sin facturar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127) {
            this.xmodelo.removeRow(this.JTBDetalle.getSelectedRow());
            this.xnfila--;
            this.JTF_Codigo.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_AdicionarKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            mAdicionar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSP_CantidadKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JBT_Adicionar.requestFocus();
        }
    }

    private void mAdicionar() {
        if (Principal.txtNo.getText().isEmpty()) {
            if (!this.JTF_Codigo.getText().isEmpty()) {
                if (!this.JTF_NProcedimiento.getText().isEmpty()) {
                    if (!this.xmt.mVerificarDatosDoblesTabla(this.JTBDetalle, 0, this.JTF_Codigo.getText())) {
                        this.xmodelo.addRow(this.xdato);
                        this.xmodelo.setValueAt(this.JTF_Codigo.getText(), this.xnfila, 0);
                        this.xmodelo.setValueAt(this.JTF_NProcedimiento.getText(), this.xnfila, 1);
                        this.xmodelo.setValueAt(this.JSP_Cantidad.getValue(), this.xnfila, 2);
                        this.xmodelo.setValueAt("", this.xnfila, 3);
                        this.JTF_Codigo.setText("");
                        this.JTF_NProcedimiento.setText("");
                        this.JSP_Cantidad.setValue(new Integer(1));
                        this.JTF_Codigo.requestFocus();
                        this.xnfila++;
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "El codigo ya se encuentra en la tabla", "VALIDAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTF_Codigo.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "El codigo no puede estar en blanco", "VALIDAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTF_Codigo.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "El codigo no puede estar en blanco", "VALIDAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTF_Codigo.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Autorizacion ya grabada", "VALIDAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private void mCargarDatoIngreso(Long xIdIngreso) {
        try {
            this.xsql = "SELECT\n    `g_procedimiento`.`Id` \n    , `g_procedimiento`.`Nbre`\n    , `f_itemordenesproced`.`Cantidad`\n    , `f_ordenes`.`Observacion`\n    , `ingreso`.`Id` IdIngreso\n    , `f_empresacontxconvenio`.`Nbre` NConvenio\n    , `g_usuario`.`NoHistoria`\nFROM\n     `f_ordenes`\n    INNER JOIN  `ingreso` \n        ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN  `f_itemordenesproced` \n        ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)\n    INNER JOIN  `g_procedimiento` \n        ON (`g_procedimiento`.`Id` = `f_itemordenesproced`.`Id_Procedimiento`)\n    INNER JOIN  `g_usuario` \n        ON (`g_usuario`.`Id_persona` = `ingreso`.`Id_Usuario`)\nWHERE (`ingreso`.`Id` ='" + xIdIngreso + "'\n    AND `f_ordenes`.`Estado` =0)\nORDER BY `g_procedimiento`.`Nbre` ASC";
            ConsultasMySQL xct1 = new ConsultasMySQL();
            ResultSet xrs = xct1.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                this.JCBConvenio.setSelectedItem(xrs.getString("NConvenio"));
                this.xjppersona.txtHistoria.setText(xrs.getString("NoHistoria"));
                this.xjppersona.buscar(2);
                xrs.beforeFirst();
                this.xnfila = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(xrs.getString("Id"), this.xnfila, 0);
                    this.xmodelo.setValueAt(xrs.getString("Nbre"), this.xnfila, 1);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong("Cantidad")), this.xnfila, 2);
                    this.xmodelo.setValueAt(xrs.getString("Observacion"), this.xnfila, 3);
                    this.xnfila++;
                }
            }
            xrs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFAutorizacion_Servicios.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargasPanelUsuario() {
        this.xjppersona = new Persona(this);
        this.xjppersona.setVisible(true);
        this.JPIFDatosUsuario.setVisible(false);
        this.xjppersona.setBounds(5, 15, 950, 160);
        this.JPIFDatosUsuario.add(this.xjppersona);
        this.JPIFDatosUsuario.setVisible(true);
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.xId_orden = 0L;
        this.xjppersona.nuevo();
        this.JCBTercero.removeAllItems();
        this.xid_tercero = this.xct.llenarCombo("SELECT  `Id`, `RazonSocialCompleta` FROM `cc_terceros` ORDER BY `RazonSocialCompleta` ASC", this.xid_tercero, this.JCBTercero);
        this.JCBTercero.setSelectedIndex(-1);
        this.JCBConvenio.removeAllItems();
        this.xidconvenio = this.xct.llenarCombo("SELECT `Id`, `Nbre` FROM `f_empresacontxconvenio` WHERE (`Estado` =0) ORDER BY `Nbre` ASC", this.xidconvenio, this.JCBConvenio);
        this.JCBConvenio.setSelectedIndex(-1);
        this.JTAObservacion.setText("");
        this.JTF_Codigo.setText("");
        this.JTF_NProcedimiento.setText("");
        this.JSP_Cantidad.setValue(new Integer(1));
        mCrearTabla();
        mCrearTabla_Historico();
        mCrearTabla_HC();
        this.xjppersona.txtHistoria.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Procedimiento", "Cant.", "Observación"}) { // from class: Facturacion.JIFAutorizacion_Servicios.10
            Class[] types = {Long.class, String.class, Long.class, String.class};
            boolean[] canEdit = {false, false, true, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalle.setModel(this.xmodelo);
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(350);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTBDetalle.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.xnfila = 0;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla_Historico() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Tercero", "Observación", "Autorizado por", "Auditado", "Estado"}) { // from class: Facturacion.JIFAutorizacion_Servicios.11
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTB_Historico.setModel(this.xmodelo1);
        this.JTB_Historico.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTB_Historico.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTB_Historico.getColumnModel().getColumn(2).setPreferredWidth(250);
        this.JTB_Historico.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTB_Historico.getColumnModel().getColumn(4).setPreferredWidth(120);
        this.JTB_Historico.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTB_Historico.getColumnModel().getColumn(6).setPreferredWidth(10);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla_HC() {
        this.xmodelo2 = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Servicio", "Profesional", "N° Autorización", "FechaA", "Convenio", "No. Orden Factura"}) { // from class: Facturacion.JIFAutorizacion_Servicios.12
            Class[] types = {Long.class, String.class, String.class, String.class, Long.class, String.class, String.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTB_HistoricoHc;
        JTable jTable2 = this.JTB_HistoricoHc;
        jTable.setAutoResizeMode(0);
        this.JTB_HistoricoHc.setModel(this.xmodelo2);
        this.JTB_HistoricoHc.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTB_HistoricoHc.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTB_HistoricoHc.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTB_HistoricoHc.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTB_HistoricoHc.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTB_HistoricoHc.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTB_HistoricoHc.getColumnModel().getColumn(6).setPreferredWidth(200);
        this.JTB_HistoricoHc.getColumnModel().getColumn(7).setPreferredWidth(80);
    }

    private void mBuscarProc_Codigo() {
        try {
            this.xsql = "SELECT  `Id` , `Nbre` FROM `g_procedimiento` WHERE (`Id` ='" + this.JTF_Codigo.getText() + "'  AND `Estado` =0)";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                this.JTF_Codigo.setText(xrs.getString(1));
                this.JTF_NProcedimiento.setText(xrs.getString(2));
            } else {
                this.JTF_Codigo.setText("");
                this.JTF_NProcedimiento.setText("");
                this.JTF_Codigo.requestFocus();
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFAutorizacion_Servicios.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mGrabar() {
        if (Principal.txtNo.getText().isEmpty() && this.xjppersona.validarDatos(1) == 1) {
            if (this.JCBTercero.getSelectedIndex() != -1) {
                if (this.JTBDetalle.getRowCount() > 0) {
                    int x = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (x == 0) {
                        this.xjppersona.grabar();
                        this.xsql = "INSERT INTO f_a_autorizacion_servicios( `FechaA` , `Id_Tercero`, Id_EmpresaConvenio, `Id_Persona` , `Observacion` , `UsuarioS` , `Id_UsuarioRh`)  values('" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "','" + this.xid_tercero[this.JCBTercero.getSelectedIndex()] + "','" + this.xidconvenio[this.JCBConvenio.getSelectedIndex()] + "','" + this.xjppersona.IdPersona + "','" + this.JTAObservacion.getText() + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "')";
                        Principal.txtNo.setText(this.xct.ejecutarSQLId(this.xsql));
                        this.xct.cerrarConexionBd();
                        for (int y = 0; y < this.JTBDetalle.getRowCount(); y++) {
                            this.xsql = "insert into f_a_autorizacion_servicios_detalle (`Id_Autorizacion` , `Id_Procedimiento`  , `Cantidad`  , `Observacion`) values ('" + Principal.txtNo.getText() + "','" + this.xmodelo.getValueAt(y, 0) + "','" + this.xmodelo.getValueAt(y, 2) + "','" + this.xmodelo.getValueAt(y, 3) + "')";
                            this.xct.ejecutarSQL(this.xsql);
                            this.xct.cerrarConexionBd();
                        }
                        if (this.xId_orden != 0) {
                            this.xsql = "update h_ordenes set Id_Autorizacion='" + Principal.txtNo.getText() + "' where Id='" + this.xId_orden + "'";
                            this.xct.ejecutarSQL(this.xsql);
                            this.xct.cerrarConexionBd();
                        }
                        mImprimir();
                        if (!Principal.informacionIps.getIdentificacion().equals("901420803")) {
                            mCargarDatosOrden_HC(this.xjppersona.IdPersona);
                            mCargarDatosT_Historico(this.xjppersona.IdPersona);
                            return;
                        }
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe adicionar un procedimiento", "VALIDAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTF_Codigo.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tercero", "VALIDAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBTercero.requestFocus();
        }
    }

    public void mImprimir() {
        if (!Principal.txtNo.getText().isEmpty()) {
            String[][] mparametros = new String[3][2];
            mparametros[0][0] = "Id";
            mparametros[0][1] = Principal.txtNo.getText();
            mparametros[1][0] = "SUBREPORT_DIR";
            mparametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            mparametros[2][0] = "SUBREPORTFIRMA_DIR";
            mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "F_Autorizacion_Servicios", mparametros);
        }
    }

    public void mCargarDatosT_Historico(String xid_persona) {
        try {
            mCrearTabla_Historico();
            this.xsql = "SELECT `f_a_autorizacion_servicios`.`Id` , date_format(`f_a_autorizacion_servicios`.`FechaA`,'%d-%m-%Y') as Fecha  , `cc_terceros`.`RazonSocialCompleta` , `f_a_autorizacion_servicios`.`Observacion` , CONCAT(`g_persona`.`Apellido1`,' ', `g_persona`.`Apellido2`,' ', `g_persona`.`Nombre1`,' ', `g_persona`.`Nombre2`) AS `Usuario` , `rh_tipo_cargo`.`Nbre` AS `Cargo` , `f_a_autorizacion_servicios`.`Auditado`,`f_a_autorizacion_servicios`.`Estado` FROM `f_a_autorizacion_servicios_detalle`  INNER JOIN  `f_a_autorizacion_servicios` ON (`f_a_autorizacion_servicios_detalle`.`Id_Autorizacion` = `f_a_autorizacion_servicios`.`Id`) INNER JOIN  `cc_terceros`  ON (`cc_terceros`.`Id` = `f_a_autorizacion_servicios`.`Id_Tercero`) INNER JOIN  `rh_tipo_persona_cargon`  ON (`f_a_autorizacion_servicios`.`Id_UsuarioRh` = `rh_tipo_persona_cargon`.`Id`) INNER JOIN  `rh_unidadf_cargo`  ON (`rh_tipo_persona_cargon`.`Id_unidadf_cargo` = `rh_unidadf_cargo`.`Id`) INNER JOIN  `g_persona`  ON (`rh_tipo_persona_cargon`.`Id_Persona` = `g_persona`.`Id`) INNER JOIN  `rh_tipo_cargo`  ON (`rh_unidadf_cargo`.`Id_Cargo` = `rh_tipo_cargo`.`Id`) WHERE (`f_a_autorizacion_servicios`.`Id_Persona` ='" + xid_persona + "' ) GROUP BY `f_a_autorizacion_servicios`.`Id` ORDER BY `f_a_autorizacion_servicios`.`FechaA` DESC ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                this.xmt.mEstablecerTextEditor(this.JTB_Historico, 3);
                this.xmt.mEstablecerTextEditor(this.JTB_Historico, 4);
                while (xrs.next()) {
                    this.xmodelo1.addRow(this.xdato);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo1.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo1.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo1.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo1.setValueAt(xrs.getString(5) + "\n" + xrs.getString(6), n, 4);
                    this.xmodelo1.setValueAt(Boolean.valueOf(xrs.getBoolean(7)), n, 5);
                    this.xmodelo1.setValueAt(Boolean.valueOf(xrs.getBoolean(8)), n, 6);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
            if (!Principal.informacionIps.getIdentificacion().equals("901420803")) {
                mCargarDatosOrden_HC(xid_persona);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFAutorizacion_Servicios.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosOrden_HC(String xid_persona) {
        try {
            mCrearTabla_HC();
            this.xsql = "SELECT  `h_ordenes`.`Id`  , DATE_FORMAT(`h_ordenes`.`FechaOrden`,'%d-%m-%Y') AS Fecha , `f_tiposervicio`.`Nbre` , `profesional1`.`NProfesional` , `profesional1`.`Especialidad`, IF(f_a_autorizacion_servicios.`Id` IS NULL,0,f_a_autorizacion_servicios.`Id` ) AS NAutorizacion , IF( f_a_autorizacion_servicios.`FechaA` IS NULL, '', DATE_FORMAT(f_a_autorizacion_servicios.`FechaA`,'%d-%m-%Y')) AS FechaA, f_empresacontxconvenio.`Nbre`, `h_itemordenesproced`.`Id_Orden_Fac` \nFROM `h_itemordenesproced`  INNER JOIN  `h_ordenes`   ON (`h_itemordenesproced`.`Id_HOrdenes` = `h_ordenes`.`Id`) INNER JOIN  `h_atencion`  ON (`h_ordenes`.`Id_Atencion` = `h_atencion`.`Id`)\nINNER JOIN  `f_tiposervicio`  ON (`h_ordenes`.`Id_TipoServicio` = `f_tiposervicio`.`Id`) INNER JOIN  `ingreso` ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) \nINNER JOIN  `profesional1`  ON (`profesional1`.`Id_Persona` = `h_ordenes`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `h_ordenes`.`Id_Especialidad`) \nLEFT JOIN  `f_a_autorizacion_servicios`  ON (`f_a_autorizacion_servicios`.`Id` = `h_ordenes`.`Id_Autorizacion`) INNER JOIN  `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) \nWHERE (`ingreso`.`Id_Usuario`  ='" + xid_persona + "' AND `h_ordenes`.`Estado` =0) GROUP BY `h_ordenes`.`Id` ORDER BY `f_tiposervicio`.`Nbre` ASC, `h_ordenes`.`FechaOrden` ASC ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                this.xmt.mEstablecerTextEditor(this.JTB_HistoricoHc, 3);
                while (xrs.next()) {
                    this.xmodelo2.addRow(this.xdato);
                    this.xmodelo2.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo2.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo2.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo2.setValueAt(xrs.getString(4) + "\n" + xrs.getString(5), n, 3);
                    this.xmodelo2.setValueAt(Long.valueOf(xrs.getLong(6)), n, 4);
                    this.xmodelo2.setValueAt(xrs.getString(7), n, 5);
                    this.xmodelo2.setValueAt(xrs.getString(8), n, 6);
                    this.xmodelo2.setValueAt(xrs.getString(9), n, 7);
                    this.JTB_HistoricoHc.setDefaultRenderer(Object.class, new MiRender2());
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFAutorizacion_Servicios.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mAnular() {
        if (!Principal.txtNo.getText().isEmpty()) {
            Anular frm = new Anular(null, true, "xjifautorizacion_servicios", 5);
            frm.setVisible(true);
        }
    }

    public void mAnular(String xid, String xMotivo, String xObservacion) {
        this.xsql = "update f_a_autorizacion_servicios set `Estado`=0, `Id_Anulado`='" + xid + "', `MotivoAnulacion`='" + xMotivo + "', `Observacion_Anulacion`='" + xObservacion + "', `UsuarioAnulacion`='" + Principal.usuarioSistemaDTO.getNombreUsuario() + "', `FechaAnulacion`='" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "' where Id='" + Principal.txtNo.getText() + "'";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "update h_ordenes set Id_Autorizacion=0 where Id_Autorizacion='" + Principal.txtNo.getText() + "'";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        mCargarDatosOrden_HC(this.xjppersona.IdPersona);
        mCargarDatosT_Historico(this.xjppersona.IdPersona);
        Principal.mLimpiarDatosP();
    }

    private void mCargado_DetalleOrdenHC(String xid_orden) {
        try {
            this.xsql = "SELECT  `g_procedimiento`.`Id` , `g_procedimiento`.`Nbre` , `h_itemordenesproced`.`Cantidad` , `h_itemordenesproced`.`Descripcion`, f_empresacontxconvenio.`Nbre` \nFROM `h_itemordenesproced`\nINNER JOIN  `h_ordenes`  ON (`h_itemordenesproced`.`Id_HOrdenes` = `h_ordenes`.`Id`)\nINNER JOIN  `g_procedimiento`  ON (`h_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`) \nINNER JOIN  `h_atencion`  ON (`h_atencion`.`Id` = `h_ordenes`.`Id_Atencion`) \nINNER JOIN  `ingreso`  ON (`ingreso`.`Id` = `h_atencion`.`Id_Ingreso`)\nINNER JOIN  `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) \nWHERE (`h_ordenes`.`Id` ='" + xid_orden + "') \nORDER BY `g_procedimiento`.`Nbre` ASC ";
            mCrearTabla();
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                this.JCBConvenio.setSelectedItem(xrs.getString(5));
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(3)), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFAutorizacion_Servicios.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Facturacion/JIFAutorizacion_Servicios$MiRender2.class */
    public class MiRender2 extends DefaultTableCellRenderer {
        public MiRender2() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            long cantidad = Long.parseLong(table.getValueAt(row, 4).toString());
            long IdOrdenFac = Long.parseLong(table.getValueAt(row, 7).toString());
            if (IdOrdenFac == 0) {
                cell.setBackground(Color.red);
                cell.setForeground(Color.BLACK);
            } else if (cantidad == 0) {
                cell.setBackground(Color.WHITE);
                cell.setForeground(Color.BLACK);
            } else {
                cell.setBackground(new Color(133, 218, 160));
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }
}
