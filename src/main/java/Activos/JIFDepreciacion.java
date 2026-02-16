package Activos;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.RhActivos;
import com.genoma.plus.jpa.service.IRhActivosService;
import com.toedter.calendar.JYearChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Activos/JIFDepreciacion.class */
public class JIFDepreciacion extends JInternalFrame {
    private String[][] xid;
    private Object[] xdato;
    private String[] xidnivel;
    private String[] xidtercero;
    private String xsql;
    private String[] xidempresa;
    private String[] xidnfactura;
    private String[][] xidtipodoccontable;
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private DefaultTableModel xmodelo2;
    private RhActivos rhActivos;
    private JButton JBTCarguesA1;
    private JComboBox JCBPeriodo;
    private JComboBox JCBTercero;
    private JComboBox JCBTipoC;
    private JCheckBox JCHActivo;
    private JCheckBox JCHDepreciacion;
    private JCheckBox JCHSeleccion;
    private JPanel JPICDepreaciacion;
    private JPanel JPIDatosConsulta;
    private JPanel JPIDatosD;
    private JPanel JPIHistorico;
    private JScrollPane JSPConceptC;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPDetalleC;
    private JScrollPane JSPHistoricoD;
    private JTextPane JTAConceptoC;
    private JTable JTDetalle;
    private JTable JTDetalleC;
    private JFormattedTextField JTFFTotal;
    private JFormattedTextField JTFFTotalH;
    private JTextField JTFRuta;
    private JTable JTHistoricoD;
    private JTabbedPane JTPDatos;
    private JYearChooser JYCAno;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private int xtipo = 0;
    private final IRhActivosService iRhActivosService = (IRhActivosService) Principal.contexto.getBean(IRhActivosService.class);

    public JIFDepreciacion() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v101, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v44, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v52, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JTPDatos = new JTabbedPane();
        this.JPIDatosD = new JPanel();
        this.JPIDatosConsulta = new JPanel();
        this.JYCAno = new JYearChooser();
        this.JCBPeriodo = new JComboBox();
        this.JCHActivo = new JCheckBox();
        this.JTFRuta = new JTextField();
        this.JBTCarguesA1 = new JButton();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPICDepreaciacion = new JPanel();
        this.JSPDetalleC = new JScrollPane();
        this.JTDetalleC = new JTable();
        this.JCBTipoC = new JComboBox();
        this.JCBTercero = new JComboBox();
        this.JSPConceptC = new JScrollPane();
        this.JTAConceptoC = new JTextPane();
        this.JTFFTotal = new JFormattedTextField();
        this.JCHSeleccion = new JCheckBox();
        this.JCHDepreciacion = new JCheckBox();
        this.JPIHistorico = new JPanel();
        this.JSPHistoricoD = new JScrollPane();
        this.JTHistoricoD = new JTable();
        this.JTFFTotalH = new JFormattedTextField();
        setClosable(true);
        setIconifiable(true);
        setTitle("DEPRECIACIÓN DE ACTIVOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifdepreciacion");
        setPreferredSize(new Dimension(1070, 766));
        this.JTPDatos.setForeground(new Color(0, 103, 0));
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JPIDatosConsulta.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA CONSULTA", 0, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JPIDatosConsulta.setForeground(new Color(255, 0, 0));
        this.JYCAno.setBorder(BorderFactory.createTitledBorder((Border) null, "Año", 0, 0, new Font("Arial", 1, 13), Color.blue));
        this.JYCAno.addPropertyChangeListener(new PropertyChangeListener() { // from class: Activos.JIFDepreciacion.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFDepreciacion.this.JYCAnoPropertyChange(evt);
            }
        });
        this.JCBPeriodo.setFont(new Font("Arial", 1, 12));
        this.JCBPeriodo.setBorder(BorderFactory.createTitledBorder((Border) null, "Periodo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHActivo.setFont(new Font("Arial", 1, 13));
        this.JCHActivo.setSelected(true);
        this.JCHActivo.setText("Activo");
        this.JCHActivo.addActionListener(new ActionListener() { // from class: Activos.JIFDepreciacion.2
            public void actionPerformed(ActionEvent evt) {
                JIFDepreciacion.this.JCHActivoActionPerformed(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Activos.JIFDepreciacion.3
            public void mouseClicked(MouseEvent evt) {
                JIFDepreciacion.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTCarguesA1.setFont(new Font("Arial", 1, 12));
        this.JBTCarguesA1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTCarguesA1.setText("Exportar");
        this.JBTCarguesA1.addActionListener(new ActionListener() { // from class: Activos.JIFDepreciacion.4
            public void actionPerformed(ActionEvent evt) {
                JIFDepreciacion.this.JBTCarguesA1ActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosConsultaLayout = new GroupLayout(this.JPIDatosConsulta);
        this.JPIDatosConsulta.setLayout(JPIDatosConsultaLayout);
        JPIDatosConsultaLayout.setHorizontalGroup(JPIDatosConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosConsultaLayout.createSequentialGroup().addContainerGap().addComponent(this.JYCAno, -2, 95, -2).addGap(10, 10, 10).addComponent(this.JCBPeriodo, -2, 300, -2).addGap(18, 18, 18).addComponent(this.JCHActivo, -1, 149, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFRuta, -2, 262, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTCarguesA1, -2, 131, -2).addContainerGap()));
        JPIDatosConsultaLayout.setVerticalGroup(JPIDatosConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosConsultaLayout.createSequentialGroup().addGroup(JPIDatosConsultaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosConsultaLayout.createSequentialGroup().addGap(11, 11, 11).addComponent(this.JCBPeriodo, -2, 50, -2)).addComponent(this.JYCAno, GroupLayout.Alignment.TRAILING, -2, 50, -2)).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosConsultaLayout.createSequentialGroup().addContainerGap().addComponent(this.JCHActivo))).addGroup(JPIDatosConsultaLayout.createSequentialGroup().addGap(0, 0, 32767).addGroup(JPIDatosConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBTCarguesA1, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JTFRuta, GroupLayout.Alignment.TRAILING, -1, 50, 32767)))).addContainerGap(-1, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE ACTIVO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Activos.JIFDepreciacion.5
            public void mouseClicked(MouseEvent evt) {
                JIFDepreciacion.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JTDetalle.addPropertyChangeListener(new PropertyChangeListener() { // from class: Activos.JIFDepreciacion.6
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFDepreciacion.this.JTDetallePropertyChange(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JPICDepreaciacion.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS CONTABLES PARA DEPRECIACIÓN", 0, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JSPDetalleC.setBorder(BorderFactory.createTitledBorder((Border) null, "CONSOLIDADO POR CATERORÍA", 1, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalleC.setFont(new Font("Arial", 1, 12));
        this.JTDetalleC.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleC.setRowHeight(25);
        this.JTDetalleC.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleC.setSelectionForeground(Color.red);
        this.JSPDetalleC.setViewportView(this.JTDetalleC);
        this.JCBTipoC.setFont(new Font("Arial", 1, 12));
        this.JCBTipoC.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTercero.setFont(new Font("Arial", 1, 12));
        this.JCBTercero.setBorder(BorderFactory.createTitledBorder((Border) null, "Tercero", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPConceptC.setBorder(BorderFactory.createTitledBorder((Border) null, "Concepto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPConceptC.setViewportView(this.JTAConceptoC);
        this.JTFFTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "Total", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFTotal.setHorizontalAlignment(4);
        this.JTFFTotal.setFont(new Font("Arial", 1, 12));
        this.JCHSeleccion.setFont(new Font("Arial", 1, 12));
        this.JCHSeleccion.setText("Quitar Selección");
        this.JCHSeleccion.addActionListener(new ActionListener() { // from class: Activos.JIFDepreciacion.7
            public void actionPerformed(ActionEvent evt) {
                JIFDepreciacion.this.JCHSeleccionActionPerformed(evt);
            }
        });
        this.JCHDepreciacion.setFont(new Font("Arial", 1, 12));
        this.JCHDepreciacion.setSelected(true);
        this.JCHDepreciacion.setText("Depreciación");
        this.JCHDepreciacion.addActionListener(new ActionListener() { // from class: Activos.JIFDepreciacion.8
            public void actionPerformed(ActionEvent evt) {
                JIFDepreciacion.this.JCHDepreciacionActionPerformed(evt);
            }
        });
        GroupLayout JPICDepreaciacionLayout = new GroupLayout(this.JPICDepreaciacion);
        this.JPICDepreaciacion.setLayout(JPICDepreaciacionLayout);
        JPICDepreaciacionLayout.setHorizontalGroup(JPICDepreaciacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICDepreaciacionLayout.createSequentialGroup().addContainerGap().addGroup(JPICDepreaciacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICDepreaciacionLayout.createSequentialGroup().addComponent(this.JSPConceptC, -2, 453, -2).addGap(18, 18, 18).addComponent(this.JTFFTotal, -2, 140, -2).addGap(18, 18, 18).addComponent(this.JCHDepreciacion).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHSeleccion).addGap(0, 0, 32767)).addComponent(this.JSPDetalleC).addGroup(JPICDepreaciacionLayout.createSequentialGroup().addComponent(this.JCBTipoC, -2, 360, -2).addGap(18, 18, 18).addComponent(this.JCBTercero, 0, -1, 32767).addGap(111, 111, 111))).addContainerGap()));
        JPICDepreaciacionLayout.setVerticalGroup(JPICDepreaciacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICDepreaciacionLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalleC, -2, 128, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPICDepreaciacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFFTotal).addComponent(this.JSPConceptC, -1, 50, 32767).addGroup(GroupLayout.Alignment.TRAILING, JPICDepreaciacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHDepreciacion).addComponent(this.JCHSeleccion))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPICDepreaciacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipoC, -2, 50, -2).addComponent(this.JCBTercero, -2, 50, -2)).addContainerGap(-1, 32767)));
        GroupLayout JPIDatosDLayout = new GroupLayout(this.JPIDatosD);
        this.JPIDatosD.setLayout(JPIDatosDLayout);
        JPIDatosDLayout.setHorizontalGroup(JPIDatosDLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosDLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosDLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle).addComponent(this.JPICDepreaciacion, -1, -1, 32767).addComponent(this.JPIDatosConsulta, -1, -1, 32767)).addContainerGap()));
        JPIDatosDLayout.setVerticalGroup(JPIDatosDLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosDLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosConsulta, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JSPDetalle, -2, 246, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPICDepreaciacion, -2, -1, -2).addContainerGap(-1, 32767)));
        this.JTPDatos.addTab("INFORMACIÓN DE ACTIVOS", this.JPIDatosD);
        this.JSPHistoricoD.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTHistoricoD.setFont(new Font("Arial", 1, 12));
        this.JTHistoricoD.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTHistoricoD.setRowHeight(25);
        this.JTHistoricoD.setSelectionBackground(new Color(255, 255, 255));
        this.JTHistoricoD.setSelectionForeground(Color.red);
        this.JTHistoricoD.setSelectionMode(0);
        this.JTHistoricoD.addMouseListener(new MouseAdapter() { // from class: Activos.JIFDepreciacion.9
            public void mouseClicked(MouseEvent evt) {
                JIFDepreciacion.this.JTHistoricoDMouseClicked(evt);
            }
        });
        this.JSPHistoricoD.setViewportView(this.JTHistoricoD);
        this.JTFFTotalH.setBorder(BorderFactory.createTitledBorder((Border) null, "Total", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFTotalH.setHorizontalAlignment(4);
        this.JTFFTotalH.setFont(new Font("Arial", 1, 12));
        GroupLayout JPIHistoricoLayout = new GroupLayout(this.JPIHistorico);
        this.JPIHistorico.setLayout(JPIHistoricoLayout);
        JPIHistoricoLayout.setHorizontalGroup(JPIHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIHistoricoLayout.createSequentialGroup().addContainerGap().addGroup(JPIHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPHistoricoD, -1, 1009, 32767).addGroup(GroupLayout.Alignment.TRAILING, JPIHistoricoLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JTFFTotalH, -2, 140, -2))).addContainerGap()));
        JPIHistoricoLayout.setVerticalGroup(JPIHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistoricoD, -2, 303, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFTotalH, -2, 50, -2).addContainerGap(301, 32767)));
        this.JTPDatos.addTab("HISTÓRICO", this.JPIHistorico);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos, -2, 707, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JYCAnoPropertyChange(PropertyChangeEvent evt) {
        mCargarCombo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHActivoActionPerformed(ActionEvent evt) {
        mCargarCombo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetallePropertyChange(PropertyChangeEvent evt) {
        mCalcularDepreciacion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() == -1 || this.JTDetalle.getSelectedColumn() != 0) {
            if (this.JTDetalle.getSelectedRow() != -1 && this.JTDetalle.getSelectedColumn() == 2) {
                this.rhActivos = this.iRhActivosService.BuscarActivoPorId(Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString()));
                JDGestioActivoGrupo dialog = new JDGestioActivoGrupo(Principal.xclase.frmPrincipal, true, this.rhActivos);
                dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
                dialog.setVisible(true);
                return;
            }
            return;
        }
        Object[] botones = {"Informe en PDF", "Histórico", "Cerrar"};
        int y = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "SELECCIONAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
        if (y == 0) {
            mImprimir(Long.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString()).longValue());
        } else if (y == 1) {
            mCargarDatosHistorico();
            this.JTPDatos.setSelectedIndex(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistoricoDMouseClicked(MouseEvent evt) {
        if (this.JTHistoricoD.getSelectedRow() != -1) {
            String[][] mparametros = new String[4][2];
            mparametros[0][0] = "IdC";
            mparametros[0][1] = this.xmodelo2.getValueAt(this.JTHistoricoD.getSelectedRow(), 0).toString();
            mparametros[1][0] = "UsuarioS";
            mparametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
            mparametros[2][0] = "SUBREPORT_DIR";
            mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            mparametros[3][0] = "SUBREPORTFIRMA_DIR";
            mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + this.xmodelo2.getValueAt(this.JTHistoricoD.getSelectedRow(), 8) + "", mparametros);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                File xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(xfile.getAbsolutePath() + this.xmt.getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCarguesA1ActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getRowCount() != -1) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHSeleccionActionPerformed(ActionEvent evt) {
        if (this.JCHSeleccion.isSelected()) {
            this.JCHSeleccion.setText("Seleccionar Todo");
            mSeleccionar(true);
        } else {
            this.JCHSeleccion.setText("Quitar Selección");
            mSeleccionar(false);
        }
        mCalcularDepreciacion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHDepreciacionActionPerformed(ActionEvent evt) {
        if (this.JCHDepreciacion.isSelected()) {
            this.JCHDepreciacion.setText("Depreciación");
        } else {
            this.JCHDepreciacion.setText("Dar de baja");
        }
        mCalcularDepreciacion();
    }

    private void mSeleccionar(Boolean xestado) {
        for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
            this.xmodelo.setValueAt(xestado, x, 11);
        }
    }

    private void mCalcularDepreciacion() {
        if (this.JTDetalle.getRowCount() != -1) {
            double xvalor = 0.0d;
            for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
                if (Boolean.valueOf(this.xmodelo.getValueAt(x, 15).toString()).booleanValue() && Double.valueOf(this.xmodelo.getValueAt(x, 13).toString()).doubleValue() > 0.0d) {
                    if (this.JCHDepreciacion.isSelected()) {
                        xvalor += Double.valueOf(this.xmodelo.getValueAt(x, 9).toString()).doubleValue() * Long.valueOf(this.xmodelo.getValueAt(x, 10).toString()).longValue();
                        this.xmodelo.setValueAt(Double.valueOf(Double.valueOf(this.xmodelo.getValueAt(x, 9).toString()).doubleValue() * Long.valueOf(this.xmodelo.getValueAt(x, 10).toString()).longValue()), x, 11);
                    } else {
                        xvalor += Double.valueOf(this.xmodelo.getValueAt(x, 13).toString()).doubleValue();
                        this.xmodelo.setValueAt(Double.valueOf(this.xmodelo.getValueAt(x, 13).toString()), x, 11);
                    }
                }
            }
            this.JTFFTotal.setValue(Double.valueOf(xvalor));
            mCalcularTDepreciacion();
        }
    }

    private void mCalcularTDepreciacion() {
        if (this.JTDetalleC.getRowCount() != -1) {
            for (int x = 0; x < this.JTDetalleC.getRowCount(); x++) {
                double xvalor = 0.0d;
                for (int y = 0; y < this.JTDetalle.getRowCount(); y++) {
                    if (Double.valueOf(this.xmodelo.getValueAt(y, 11).toString()).doubleValue() > 0.0d && Boolean.valueOf(this.xmodelo.getValueAt(y, 15).toString()).booleanValue() && this.xmodelo.getValueAt(y, 16).toString().equals(this.xmodelo1.getValueAt(x, 4).toString())) {
                        if (this.JCHDepreciacion.isSelected()) {
                            xvalor += Double.valueOf(this.xmodelo.getValueAt(y, 9).toString()).doubleValue() * Long.valueOf(this.xmodelo.getValueAt(y, 10).toString()).longValue();
                        } else {
                            xvalor += Double.valueOf(this.xmodelo.getValueAt(y, 13).toString()).doubleValue();
                        }
                    }
                }
                if (xvalor == 0.0d) {
                    this.xmodelo1.setValueAt(false, x, 7);
                } else {
                    this.xmodelo1.setValueAt(true, x, 7);
                }
                this.xmodelo1.setValueAt(Double.valueOf(xvalor), x, 2);
            }
        }
    }

    private void mCargarCombo() {
        this.JCBPeriodo.removeAllItems();
        if (this.JCHActivo.isSelected()) {
            this.xsql = "SELECT Id, IF(Nbre IS NULL || Nbre='',DevuelveMes(FechaI),Nbre)  AS Mes, DATE_FORMAT(FechaI,'%d-%m-%Y') AS FechaI,FechaF AS FechaF,  Activo, Estado FROM cc_periodo_contable WHERE DATE_FORMAT(FechaI,'%Y')='" + this.JYCAno.getValue() + "' AND Activo=1 ORDER BY Id DESC; ";
        } else {
            this.xsql = "SELECT Id, IF(Nbre IS NULL || Nbre='',DevuelveMes(FechaI),Nbre)  AS Mes, DATE_FORMAT(FechaI,'%d-%m-%Y') AS FechaI,FechaF AS FechaF,  Activo, Estado FROM cc_periodo_contable WHERE DATE_FORMAT(FechaI,'%Y')='" + this.JYCAno.getValue() + "'  ORDER BY Id DESC; ";
        }
        this.xid = this.xct.llenarComboyLista(this.xsql, this.xid, this.JCBPeriodo, 6);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos_UF() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Unidad Funcional", "Ubicación", "Nombre Activo", "Politica", "V/Util", "FCompra", "FinDepreciación", "V/Compra", "V/DepreciacionDía", "Días", "V/Total", "DAcomulada", "Saldo", "Observación", "Incluir?", "Puc_D", "Puc_B", "Id_Activo", "Ref"}) { // from class: Activos.JIFDepreciacion.10
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, Long.class, String.class, String.class, Double.class, Double.class, Long.class, Double.class, Double.class, Double.class, String.class, Boolean.class, String.class, String.class, Long.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, true, true, true, false, false, false, true, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(100);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloConsolidado() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"Id", "Puc", "Valor", "VCreditoD", "VDebitoD", "VCreditoDB", "VDebitoDB", "Incluir?"}) { // from class: Activos.JIFDepreciacion.11
            Class[] types = {String.class, String.class, Double.class, String.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, true, true, true, true, true, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalleC;
        JTable jTable2 = this.JTDetalleC;
        jTable.setAutoResizeMode(0);
        this.JTDetalleC.doLayout();
        this.JTDetalleC.setModel(this.xmodelo1);
        this.JTDetalleC.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalleC.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTDetalleC.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTDetalleC.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalleC.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalleC.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalleC.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalleC.getColumnModel().getColumn(7).setPreferredWidth(100);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloHistorico() {
        this.xmodelo2 = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Documento", "Período", "NDías", "V/Dia", "V/Total", "Observación", "NReporte"}) { // from class: Activos.JIFDepreciacion.12
            Class[] types = {Long.class, String.class, String.class, String.class, Long.class, Double.class, Double.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistoricoD.setModel(this.xmodelo2);
        this.JTHistoricoD.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTHistoricoD.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTHistoricoD.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTHistoricoD.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.JTHistoricoD.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTHistoricoD.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTHistoricoD.getColumnModel().getColumn(6).setPreferredWidth(10);
        this.JTHistoricoD.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTHistoricoD.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTHistoricoD.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTHistoricoD.getColumnModel().getColumn(8).setMaxWidth(0);
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.JYCAno.setValue(Integer.valueOf(this.xmt.formatoANO.format(this.xmt.getFechaActual())).intValue());
        this.JCBTipoC.removeAllItems();
        this.xidtipodoccontable = this.xct.llenarComboyLista("SELECT Id, Nbre, NReporte FROM cc_tipo_documentoc WHERE (Estado =1) ORDER BY Nbre ASC", this.xidtipodoccontable, this.JCBTipoC, 3);
        this.JCBTipoC.setSelectedIndex(-1);
        this.JCBTercero.setSelectedIndex(-1);
        this.xidempresa = this.xct.llenarCombo("SELECT `Id`, `RazonSocialCompleta` FROM  `cc_terceros` WHERE (`RazonSocialCompleta` <>'') ORDER BY `RazonSocialCompleta` ASC", this.xidempresa, this.JCBTercero);
        this.JCBTercero.setSelectedIndex(-1);
        this.JTFFTotal.setValue(new Double(0.0d));
        this.JTFFTotalH.setValue(new Double(0.0d));
        this.xct.cerrarConexionBd();
        mCrearModeloDatos_UF();
        mCrearModeloConsolidado();
        mCrearModeloHistorico();
    }

    public void mBuscar() {
        if (this.JCBPeriodo.getSelectedIndex() != -1) {
            mCargarDatos();
            mCargarDatosC();
            mCalcularTDepreciacion();
        }
    }

    private void mCargarDatos() {
        this.xsql = "WITH SET_DATOS AS (\nSELECT\n  `rh_activo_contable`.`Id` AS `Id_Contable`,\n  `cc_unidad_funcional`.`Nbre` AS `Unidad_Funcional`,\n  `rh_tipo_ubicacion`.`Nbre` AS `NUbicacion`,\n  `rh_activo_contable`.`Nbre` AS `Nombre_Activo`,\n  `rh_tipo_politicas`.`Nbre` AS `Politica`,\n  `rh_activo_contable`.`VUtil`,\n  DATE_FORMAT( `rh_activo_contable`.`FechaC`, '%d-%m-%Y' ) AS `FCompra`,\n  DATE_FORMAT( ADDDATE(`rh_activo_contable`.`FechaC`, INTERVAL `rh_activo_contable`.`VUtil` YEAR ), '%d-%m-%Y' ) AS `FFin_Depreciacion`,\n  `rh_activo_contable`.`VCompra`,\n  ROUND( `rh_activo_contable`.`VDepreciacion`) AS `VDepreciacion`,\n  `rh_activo_contable`.`VInicialD`, \n  `rh_activo_contable`.`FechaC`, \n  IF(DATEDIFF('" + this.xid[this.JCBPeriodo.getSelectedIndex()][2] + "',`rh_activo_contable`.`FechaC`) > 30, 30, DATEDIFF( '" + this.xid[this.JCBPeriodo.getSelectedIndex()][2] + "',`rh_activo_contable`.`FechaC`)) AS `DD`,\n -- IF(( `rh_activo_contable`.`VCompra` - (`rh_activo_contable`.`VInicialD`   + v_rh_activo_smovimiento.`Valor`) ) <= 10, 0,\n  --  (ROUND(`rh_activo_contable`.`VDepreciacion`) * IF(DATEDIFF('2020-02-29',`rh_activo_contable`.`FechaC`) > 30,30,DATEDIFF('2020-02-29',`rh_activo_contable`.`FechaC`)))) AS `VCDepreciacion`,\n -- (`rh_activo_contable`.`VInicialD`   + v_rh_activo_smovimiento.`Valor`) AS `VDepreciacionA`,\n -- (`rh_activo_contable`.`VCompra` - (`rh_activo_contable`.`VInicialD`  + v_rh_activo_smovimiento.`Valor`)) AS Saldo,\n  `rh_activo_contable`.`CDDebito`,\n  `rh_activo_contable`.`CBDebito`,\n  IF(  0 = 0, `rh_tipo_categoria`.`Id`, `cc_unidad_funcional`.`Id`  ) estado,\n  rh_activos.Id AS IdActivo,\n  rh_activos.Referencia\n  , SUM(IFNULL(rh_activos_movimiento.`VTotal`,  0)) AS ValorMovimiento\nFROM\n  `rh_activo_contable`\n  INNER JOIN `rh_tipo_politicas`\n    ON (\n      `rh_activo_contable`.`Id_Rh_Politica` = `rh_tipo_politicas`.`Id`\n    )\n  INNER JOIN `rh_tipo_categoria`\n    ON (\n      `rh_activo_contable`.`Id_Categoria` = `rh_tipo_categoria`.`Id`\n    )\n  INNER JOIN `cc_unidad_funcional`\n    ON (\n      `rh_activo_contable`.`Id_Uf_Contable` = `cc_unidad_funcional`.`Id`\n    )\n  INNER JOIN `rh_tipo_ubicacion`\n    ON (\n      `rh_activo_contable`.`Id_Ubicacion` = `rh_tipo_ubicacion`.`Id`\n    )\n  INNER JOIN `rh_activos`\n    ON (\n      `rh_activos`.`Id_rh_tipoagrupacion` = `rh_activo_contable`.`Id`\n    )\n  LEFT JOIN rh_activos_movimiento\n    ON (\n      `rh_activos_movimiento`.`Id_Activo` = `rh_activo_contable`.`Id`\n    ) AND (rh_activos_movimiento.`Estado`=1)\nWHERE (\n    `rh_activo_contable`.`EsContable` = 1\n  )\n  GROUP BY `Id_Contable`\nORDER BY `rh_activo_contable`.`CDDebito` ASC,\n  `Nombre_Activo` ASC\n  )\n  \n  SELECT \n  `Id_Contable`,\n  `Unidad_Funcional`,\n  `NUbicacion`,\n `Nombre_Activo`,\n `Politica`,\n`VUtil`,\n `FCompra`,\n `FFin_Depreciacion`,\n `VCompra`,\n `VDepreciacion`,\n  `DD`,\n  IF(( `VCompra` - (`VInicialD`   + ValorMovimiento) ) <= 10, 0,(ROUND(`VDepreciacion`) * IF(DATEDIFF('" + this.xid[this.JCBPeriodo.getSelectedIndex()][2] + "',`FechaC`) > 30,30,DATEDIFF('" + this.xid[this.JCBPeriodo.getSelectedIndex()][2] + "',`FechaC`)))) AS `VCDepreciacion`,\n  (`VInicialD`   + ValorMovimiento) AS `VDepreciacionA`,\n  (`VCompra` - (`VInicialD`  + ValorMovimiento)) AS Saldo,\n  `CDDebito`,\n `CBDebito`,\n    estado,\n  IdActivo,\n  Referencia\n \n  \n  FROM SET_DATOS\n  HAVING Saldo>0";
        mCrearModeloDatos_UF();
        ResultSet rs = this.xct.traerRs(this.xsql);
        double xvalor = 0.0d;
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                this.xmt.mEstablecerTextEditor(this.JTDetalle, 1);
                this.xmt.mEstablecerTextEditor(this.JTDetalle, 2);
                this.xmt.mEstablecerTextEditor(this.JTDetalle, 3);
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo.setValueAt(rs.getString(3), x, 2);
                    this.xmodelo.setValueAt(rs.getString(4), x, 3);
                    this.xmodelo.setValueAt(rs.getString(5), x, 4);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(6)), x, 5);
                    this.xmodelo.setValueAt(rs.getString(7), x, 6);
                    this.xmodelo.setValueAt(rs.getString(8), x, 7);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(9)), x, 8);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(10)), x, 9);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(11)), x, 10);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(12)), x, 11);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(13)), x, 12);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(14)), x, 13);
                    this.xmodelo.setValueAt("", x, 14);
                    if (rs.getDouble(12) <= 0.0d) {
                        this.xmodelo.setValueAt(false, x, 15);
                    } else {
                        this.xmodelo.setValueAt(true, x, 15);
                    }
                    this.xmodelo.setValueAt(rs.getString(15), x, 16);
                    this.xmodelo.setValueAt(rs.getString(16), x, 17);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong("IdActivo")), x, 18);
                    this.xmodelo.setValueAt(rs.getString("Referencia"), x, 19);
                    xvalor += rs.getDouble(12);
                    x++;
                }
            }
            this.JTFFTotal.setValue(Double.valueOf(xvalor));
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }

    private void mCargarDatosC() {
        this.xsql = "SELECT  `cc_puc`.`Id` , `cc_puc`.`Nbre` , `rh_activo_contable`.`CDCredito` , `rh_activo_contable`.`CDDebito` , `rh_activo_contable`.`CBCredito` , `rh_activo_contable`.`CBDebito` FROM `rh_activo_contable` INNER JOIN `rh_tipo_politicas`  ON (`rh_activo_contable`.`Id_Rh_Politica` = `rh_tipo_politicas`.`Id`) INNER JOIN `rh_tipo_categoria`  ON (`rh_activo_contable`.`Id_Categoria` = `rh_tipo_categoria`.`Id`) INNER JOIN `cc_unidad_funcional`  ON (`rh_activo_contable`.`Id_Uf_Contable` = `cc_unidad_funcional`.`Id`) INNER JOIN `rh_tipo_ubicacion`  ON (`rh_activo_contable`.`Id_Ubicacion` = `rh_tipo_ubicacion`.`Id`) INNER JOIN `rh_activos`  ON (`rh_activos`.`Id_rh_tipoagrupacion` = `rh_activo_contable`.`Id`) LEFT JOIN `v_rh_activo_smovimiento`  ON (`v_rh_activo_smovimiento`.`Id_Activo` = `rh_activo_contable`.`Id`)  INNER JOIN `cc_puc`  ON (`cc_puc`.`Id` = `rh_activo_contable`.`CDDebito`) WHERE (`rh_activo_contable`.`EsContable` =1) GROUP BY `cc_puc`.`Id` ORDER BY `cc_unidad_funcional`.`Nbre` ASC, `cc_unidad_funcional`.`Nbre` ASC ";
        mCrearModeloConsolidado();
        ResultSet rs = this.xct.traerRs(this.xsql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo1.addRow(this.xdato);
                    this.xmodelo1.setValueAt(rs.getString(1), x, 0);
                    this.xmodelo1.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo1.setValueAt(0, x, 2);
                    this.xmodelo1.setValueAt(rs.getString(3), x, 3);
                    this.xmodelo1.setValueAt(rs.getString(4), x, 4);
                    this.xmodelo1.setValueAt(rs.getString(5), x, 5);
                    this.xmodelo1.setValueAt(rs.getString(6), x, 6);
                    this.xmodelo1.setValueAt(true, x, 7);
                    x++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
            mCalcularTDepreciacion();
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }

    private void mCargarDatosHistorico() {
        this.xsql = "SELECT `cc_documentoc`.`Id`, DATE_FORMAT(`cc_documentoc`.`FechaD`,'%d-%m-%Y') AS Fecha, `cc_tipo_documentoc`.`Nbre` AS `NDocumento`, `cc_periodo_contable`.`Nbre` AS `NPeriodo`, `rh_activos_movimiento`.`NDias`, `rh_activos_movimiento`.`Valor`, `rh_activos_movimiento`.`VTotal`, `rh_activos_movimiento`.`Observacion`,  `cc_tipo_documentoc`.`NReporte` FROM  `rh_activos_movimiento` INNER JOIN  `cc_documentoc`  ON (`rh_activos_movimiento`.`Id_DocumentoC` = `cc_documentoc`.`Id`) INNER JOIN `cc_tipo_documentoc`  ON (`cc_documentoc`.`Id_TipoComprobante` = `cc_tipo_documentoc`.`Id`) INNER JOIN  `cc_periodo_contable`  ON (`cc_documentoc`.`Id_PeriodoC` = `cc_periodo_contable`.`Id`) WHERE (`rh_activos_movimiento`.`Estado` =1 AND `rh_activos_movimiento`.`Id_Activo` ='" + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0) + "') ORDER BY `cc_documentoc`.`FechaD` DESC ";
        mCrearModeloHistorico();
        ResultSet rs = this.xct.traerRs(this.xsql);
        double xvalor = 0.0d;
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                this.xmt.mEstablecerTextEditor(this.JTHistoricoD, 7);
                while (rs.next()) {
                    this.xmodelo2.addRow(this.xdato);
                    this.xmodelo2.setValueAt(Long.valueOf(rs.getLong(1)), x, 0);
                    this.xmodelo2.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo2.setValueAt(rs.getString(3), x, 2);
                    this.xmodelo2.setValueAt(rs.getString(4), x, 3);
                    this.xmodelo2.setValueAt(Long.valueOf(rs.getLong(5)), x, 4);
                    this.xmodelo2.setValueAt(Double.valueOf(rs.getDouble(6)), x, 5);
                    this.xmodelo2.setValueAt(Double.valueOf(rs.getDouble(7)), x, 6);
                    this.xmodelo2.setValueAt(rs.getString(8), x, 7);
                    this.xmodelo2.setValueAt(rs.getString(9), x, 8);
                    xvalor += rs.getDouble(7);
                    x++;
                }
            }
            this.JTFFTotalH.setValue(Double.valueOf(xvalor));
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }

    public void mGrabar() {
        String cdebito;
        String ccredito;
        if (this.JCBPeriodo.getSelectedIndex() != -1) {
            if (this.xmt.mVerificarDatosTablaTrue(this.JTDetalle, 15)) {
                if (this.JCBTipoC.getSelectedIndex() != -1) {
                    if (this.JCBTercero.getSelectedIndex() != -1) {
                        int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (x == 0) {
                            String sql = "insert into cc_documentoc (FechaD, Id_TipoComprobante, Id_PeriodoC, Descripcion, Fecha, UsuarioS) Values ('" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "','" + this.xidtipodoccontable[this.JCBTipoC.getSelectedIndex()][0] + "','" + this.xid[this.JCBPeriodo.getSelectedIndex()][0] + "','" + this.JTAConceptoC.getText() + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                            Principal.txtNo.setText(this.xct.ejecutarSQLId(sql));
                            Principal.txtEstado.setText("ACTIVO");
                            this.xct.cerrarConexionBd();
                            for (int y = 0; y < this.JTDetalleC.getRowCount(); y++) {
                                if (Boolean.valueOf(this.xmodelo1.getValueAt(y, 7).toString()).booleanValue()) {
                                    ConsultasMySQL xct1 = new ConsultasMySQL();
                                    if (this.JCHDepreciacion.isSelected()) {
                                        cdebito = this.xmodelo1.getValueAt(y, 4).toString();
                                        ccredito = this.xmodelo1.getValueAt(y, 3).toString();
                                    } else {
                                        cdebito = this.xmodelo1.getValueAt(y, 6).toString();
                                        ccredito = this.xmodelo1.getValueAt(y, 5).toString();
                                    }
                                    String sql2 = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero, VDebito, VCredito, Concepto)  VALUES ('" + Principal.txtNo.getText() + "','" + cdebito + "','0','" + this.xidempresa[this.JCBTercero.getSelectedIndex()] + "','" + this.xmodelo1.getValueAt(y, 2) + "','0','" + this.JTAConceptoC.getText() + "' )";
                                    xct1.ejecutarSQL(sql2);
                                    xct1.cerrarConexionBd();
                                    String sql3 = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero, VDebito, VCredito, Concepto) Values ('" + Principal.txtNo.getText() + "','" + ccredito + "','1','" + this.xidempresa[this.JCBTercero.getSelectedIndex()] + "','0','" + this.xmodelo1.getValueAt(y, 2) + "','" + this.JTAConceptoC.getText() + "' )";
                                    xct1.ejecutarSQL(sql3);
                                    xct1.cerrarConexionBd();
                                }
                            }
                            mGrabarMovimiento();
                            return;
                        }
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tercero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JCBTercero.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de documento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBTipoC.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "No existen artículos seleccionados para realizar el movimiento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un período", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBPeriodo.requestFocus();
    }

    private void mGrabarMovimiento() {
        for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
            if (Boolean.valueOf(this.xmodelo.getValueAt(x, 15).toString()).booleanValue()) {
                this.xsql = "insert into rh_activos_movimiento(`Id_Activo`, `Id_DocumentoC`, `Tipo`, `NDias`, `Valor`, `VTotal`, `Observacion`, `UsuarioS`)  VALUES('" + this.xmodelo.getValueAt(x, 0) + "','" + Principal.txtNo.getText() + "','0','" + this.xmodelo.getValueAt(x, 10) + "','" + this.xmodelo.getValueAt(x, 9) + "','" + this.xmodelo.getValueAt(x, 11) + "','" + this.xmodelo.getValueAt(x, 14) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
                this.xsql = "UPDATE `rh_activo_contable` SET `rh_activo_contable`.`VSaldo`=`rh_activo_contable`.`VSaldo`-(" + this.xmodelo.getValueAt(x, 10) + ") WHERE Id='" + this.xmodelo.getValueAt(x, 12) + "' ";
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
                if (!this.JCHDepreciacion.isSelected()) {
                    this.xsql = "UPDATE `rh_activo_contable` SET EsContable=0, Id_Doc='" + Principal.txtNo.getText() + "' WHERE Id='" + this.xmodelo.getValueAt(x, 12) + "'";
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                }
            }
        }
    }

    public void mImprimir(long xid) {
        String[][] mparametros = new String[3][2];
        mparametros[0][0] = "Id";
        mparametros[0][1] = String.valueOf(xid);
        mparametros[1][0] = "SUBREPORT_DIR";
        mparametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        mparametros[2][0] = "SUBREPORTFIRMA_DIR";
        mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        if (xid == 0) {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "CC_Kardex_Activos_Fijos_UF", mparametros);
        }
    }
}
