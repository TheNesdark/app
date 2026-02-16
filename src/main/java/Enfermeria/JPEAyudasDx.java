package Enfermeria;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.controller.historia.dto.OrdenamientoMedico;
import com.genoma.plus.jpa.entities.LiquidacionEntity;
import com.genoma.plus.jpa.service.ILiquidacionService;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
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
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Enfermeria/JPEAyudasDx.class */
public class JPEAyudasDx extends JPanel {
    private String sql;
    private String xsql;
    private String xidAtencion;
    private String idIngreso;
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private Object[] xdato;
    private int xMetodoFact;
    private int xTipoPlan;
    private String[] xidcentrocosto;
    private OrdenamientoMedico ordenamientoMedico;
    private JButton JBTDevolverCambios;
    private JButton JBTGeneracionAutorizacion;
    public JComboBox JCBCentroCosto;
    private JCheckBox JCH_CCerrada;
    private JCheckBox JCH_CCerrada1;
    private JCheckBox JCH_CCerradaP;
    private JPanel JPI_Convenciones;
    private JPanel JPI_DatosGeneral;
    private JPanel JPI_Utilidades;
    private JScrollPane JSPDAObservacionG;
    private JScrollPane JSPDOrdenes;
    private JScrollPane JSPDetalleOrdenes;
    private JTextArea JTADAObservacionG;
    private JTable JTDOrdenes;
    private JTable JTDetalleOrdenes;
    private JTabbedPane JTP_Datos;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private ConsultasMySQL xcon = new ConsultasMySQL();
    private boolean xestadog = false;
    private final ILiquidacionService liquidacionService = (ILiquidacionService) Principal.contexto.getBean(ILiquidacionService.class);

    public JPEAyudasDx(String xidAtencion, String idIngreso) {
        initComponents();
        this.xidAtencion = xidAtencion;
        this.idIngreso = idIngreso;
        this.ordenamientoMedico = OrdenamientoMedico.builder().build();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v11, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JSPDOrdenes = new JScrollPane();
        this.JTDOrdenes = new JTable();
        this.JSPDetalleOrdenes = new JScrollPane();
        this.JTDetalleOrdenes = new JTable();
        this.JTP_Datos = new JTabbedPane();
        this.JPI_DatosGeneral = new JPanel();
        this.JPI_Convenciones = new JPanel();
        this.JCH_CCerrada = new JCheckBox();
        this.JCH_CCerradaP = new JCheckBox();
        this.JCH_CCerrada1 = new JCheckBox();
        this.JSPDAObservacionG = new JScrollPane();
        this.JTADAObservacionG = new JTextArea();
        this.JCBCentroCosto = new JComboBox();
        this.JPI_Utilidades = new JPanel();
        this.JBTGeneracionAutorizacion = new JButton();
        this.JBTDevolverCambios = new JButton();
        setBorder(BorderFactory.createTitledBorder((Border) null, "AYUDAS DIAGNÓSTICA Y TERAPÉUTICAS", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        setName("xjpeayudasdx");
        this.JSPDOrdenes.setBorder(BorderFactory.createTitledBorder((Border) null, "ORDENES", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDOrdenes.setFont(new Font("Arial", 1, 12));
        this.JTDOrdenes.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDOrdenes.setRowHeight(25);
        this.JTDOrdenes.setSelectionBackground(new Color(255, 255, 255));
        this.JTDOrdenes.setSelectionForeground(new Color(255, 0, 0));
        this.JTDOrdenes.setSelectionMode(0);
        this.JTDOrdenes.addMouseListener(new MouseAdapter() { // from class: Enfermeria.JPEAyudasDx.1
            public void mouseClicked(MouseEvent evt) {
                JPEAyudasDx.this.JTDOrdenesMouseClicked(evt);
            }
        });
        this.JSPDOrdenes.setViewportView(this.JTDOrdenes);
        this.JSPDetalleOrdenes.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE PROCEDIMIENTOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalleOrdenes.setFont(new Font("Arial", 1, 12));
        this.JTDetalleOrdenes.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleOrdenes.setRowHeight(50);
        this.JTDetalleOrdenes.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleOrdenes.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalleOrdenes.setSelectionMode(0);
        this.JTDetalleOrdenes.addMouseListener(new MouseAdapter() { // from class: Enfermeria.JPEAyudasDx.2
            public void mouseClicked(MouseEvent evt) {
                JPEAyudasDx.this.JTDetalleOrdenesMouseClicked(evt);
            }
        });
        this.JSPDetalleOrdenes.setViewportView(this.JTDetalleOrdenes);
        this.JTP_Datos.setForeground(Color.red);
        this.JTP_Datos.setFont(new Font("Arial", 1, 14));
        this.JPI_Convenciones.setBorder(BorderFactory.createTitledBorder((Border) null, "Convenciones", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCH_CCerrada.setBackground(new Color(177, 251, 177));
        this.JCH_CCerrada.setFont(new Font("Arial", 1, 12));
        this.JCH_CCerrada.setText("Cerrada");
        this.JCH_CCerradaP.setBackground(new Color(255, 204, 204));
        this.JCH_CCerradaP.setFont(new Font("Arial", 1, 12));
        this.JCH_CCerradaP.setText("Parcialmente");
        this.JCH_CCerrada1.setBackground(new Color(255, 255, 255));
        this.JCH_CCerrada1.setFont(new Font("Arial", 1, 12));
        this.JCH_CCerrada1.setText("Por Cerrar");
        GroupLayout JPI_ConvencionesLayout = new GroupLayout(this.JPI_Convenciones);
        this.JPI_Convenciones.setLayout(JPI_ConvencionesLayout);
        JPI_ConvencionesLayout.setHorizontalGroup(JPI_ConvencionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_ConvencionesLayout.createSequentialGroup().addContainerGap().addComponent(this.JCH_CCerrada1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 14, 32767).addComponent(this.JCH_CCerrada, -2, 89, -2)).addGroup(GroupLayout.Alignment.TRAILING, JPI_ConvencionesLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JCH_CCerradaP).addGap(42, 42, 42)));
        JPI_ConvencionesLayout.setVerticalGroup(JPI_ConvencionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_ConvencionesLayout.createSequentialGroup().addGroup(JPI_ConvencionesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH_CCerrada).addComponent(this.JCH_CCerrada1)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCH_CCerradaP)));
        this.JSPDAObservacionG.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación General", 1, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTADAObservacionG.setColumns(20);
        this.JTADAObservacionG.setFont(new Font("Arial", 1, 14));
        this.JTADAObservacionG.setLineWrap(true);
        this.JTADAObservacionG.setRows(1);
        this.JTADAObservacionG.setTabSize(1);
        this.JTADAObservacionG.setBorder((Border) null);
        this.JSPDAObservacionG.setViewportView(this.JTADAObservacionG);
        this.JCBCentroCosto.setFont(new Font("Arial", 1, 12));
        this.JCBCentroCosto.setBorder(BorderFactory.createTitledBorder((Border) null, "Centro de Costo", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        GroupLayout JPI_DatosGeneralLayout = new GroupLayout(this.JPI_DatosGeneral);
        this.JPI_DatosGeneral.setLayout(JPI_DatosGeneralLayout);
        JPI_DatosGeneralLayout.setHorizontalGroup(JPI_DatosGeneralLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_DatosGeneralLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JCBCentroCosto, -2, 231, -2).addGap(18, 18, 18).addComponent(this.JSPDAObservacionG, -2, 315, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPI_Convenciones, -2, -1, -2).addContainerGap()));
        JPI_DatosGeneralLayout.setVerticalGroup(JPI_DatosGeneralLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosGeneralLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DatosGeneralLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosGeneralLayout.createSequentialGroup().addComponent(this.JSPDAObservacionG, -2, 74, -2).addContainerGap(-1, 32767)).addGroup(JPI_DatosGeneralLayout.createSequentialGroup().addComponent(this.JPI_Convenciones, -1, -1, 32767).addGap(20, 20, 20)))).addGroup(JPI_DatosGeneralLayout.createSequentialGroup().addGap(15, 15, 15).addComponent(this.JCBCentroCosto, -2, 50, -2).addGap(0, 0, 32767)));
        this.JTP_Datos.addTab("DATOS GENERALES", this.JPI_DatosGeneral);
        this.JBTGeneracionAutorizacion.setFont(new Font("Arial", 1, 12));
        this.JBTGeneracionAutorizacion.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Autorizacion.png")));
        this.JBTGeneracionAutorizacion.setText("Generar Autorización");
        this.JBTGeneracionAutorizacion.addActionListener(new ActionListener() { // from class: Enfermeria.JPEAyudasDx.3
            public void actionPerformed(ActionEvent evt) {
                JPEAyudasDx.this.JBTGeneracionAutorizacionActionPerformed(evt);
            }
        });
        this.JBTDevolverCambios.setFont(new Font("Arial", 1, 12));
        this.JBTDevolverCambios.setIcon(new ImageIcon(getClass().getResource("/Imagenes/devolver.png")));
        this.JBTDevolverCambios.setText("Devolver Cambios");
        this.JBTDevolverCambios.addActionListener(new ActionListener() { // from class: Enfermeria.JPEAyudasDx.4
            public void actionPerformed(ActionEvent evt) {
                JPEAyudasDx.this.JBTDevolverCambiosActionPerformed(evt);
            }
        });
        GroupLayout JPI_UtilidadesLayout = new GroupLayout(this.JPI_Utilidades);
        this.JPI_Utilidades.setLayout(JPI_UtilidadesLayout);
        JPI_UtilidadesLayout.setHorizontalGroup(JPI_UtilidadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_UtilidadesLayout.createSequentialGroup().addGap(19, 19, 19).addComponent(this.JBTGeneracionAutorizacion, -2, 225, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTDevolverCambios, -2, 225, -2).addContainerGap(330, 32767)));
        JPI_UtilidadesLayout.setVerticalGroup(JPI_UtilidadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_UtilidadesLayout.createSequentialGroup().addGap(27, 27, 27).addGroup(JPI_UtilidadesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTGeneracionAutorizacion, -2, 48, -2).addComponent(this.JBTDevolverCambios, -2, 48, -2)).addContainerGap(42, 32767)));
        this.JTP_Datos.addTab("UTILIDADES", this.JPI_Utilidades);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTP_Datos).addComponent(this.JSPDOrdenes).addComponent(this.JSPDetalleOrdenes, GroupLayout.Alignment.TRAILING)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JSPDOrdenes, -2, 175, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalleOrdenes, -2, 151, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTP_Datos, -2, 148, -2).addGap(19, 19, 19)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDOrdenesMouseClicked(MouseEvent evt) {
        if (this.JTDOrdenes.getSelectedRow() != -1) {
            Object[] botones = {"Cargar Detalle", "Visualizar", "Cerrar"};
            int x = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "SELECCIONAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
            if (x == 0) {
                if (Integer.parseInt(this.xmodelo.getValueAt(this.JTDOrdenes.getSelectedRow(), 6).toString()) == 1) {
                    this.xestadog = true;
                    mCargarDatosDetalleOrden();
                } else {
                    this.xestadog = false;
                    mCargarDatosDetalleOrden();
                }
                this.ordenamientoMedico = this.xmt.getFindByOrdanimientoMedicoIdAtencionIdOrdenHc(Long.valueOf(this.xidAtencion), Long.valueOf(this.JTDOrdenes.getValueAt(this.JTDOrdenes.getSelectedRow(), 0).toString()));
                return;
            }
            if (x == 1) {
                mImprimir();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGeneracionAutorizacionActionPerformed(ActionEvent evt) {
        if (this.JTDOrdenes.getSelectedRow() != -1 && this.xmt.mVerificarDatosTablaTrue(this.JTDetalleOrdenes, 4)) {
            String idCodigoProcedimiento = null;
            for (int x = 0; x < this.JTDetalleOrdenes.getRowCount(); x++) {
                if (Boolean.valueOf(this.xmodelo1.getValueAt(x, 4).toString()).booleanValue()) {
                    idCodigoProcedimiento = idCodigoProcedimiento + "," + this.xmodelo1.getValueAt(x, 11).toString();
                }
            }
            Principal.claseenfer.cargarPantalla("Generador de Autorizacion de Servicios", this.JTDOrdenes.getValueAt(this.JTDOrdenes.getSelectedRow(), 0).toString(), idCodigoProcedimiento.substring(1, idCodigoProcedimiento.length()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTDevolverCambiosActionPerformed(ActionEvent evt) {
        if (this.JTDOrdenes.getSelectedRow() != -1) {
            int x = JOptionPane.showConfirmDialog(this, "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>Desea devolver los cambios de las ordenes que no fueron facturadas?.</p>", "ADVERTENCIA", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                if (this.JTDetalleOrdenes.getRowCount() > 0) {
                    for (int i = 0; i < this.JTDetalleOrdenes.getRowCount(); i++) {
                        if (Boolean.valueOf(this.xmodelo1.getValueAt(i, 4).toString()).booleanValue() && !this.xmodelo1.getValueAt(i, 5).toString().isEmpty() && Long.valueOf(this.xmodelo1.getValueAt(i, 7).toString()).longValue() == 0) {
                            this.xsql = "update `h_ordenes` set `Finalizada`= 0 where Id='" + this.xmodelo.getValueAt(this.JTDOrdenes.getSelectedRow(), 0) + "'";
                            this.xct.ejecutarSQL(this.xsql);
                            this.xct.cerrarConexionBd();
                            this.xsql = "update `h_itemordenesproced` set `Ejecutado`=0 ,`Fecha_E`= (NULL) WHERE (`Id_HOrdenes`= '" + this.xmodelo.getValueAt(this.JTDOrdenes.getSelectedRow(), 0) + "' and  `Id_Procedimiento`='" + this.xmodelo1.getValueAt(i, 0) + "')";
                            this.xct.ejecutarSQL(this.xsql);
                            this.xct.cerrarConexionBd();
                        }
                    }
                }
                mNuevo();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleOrdenesMouseClicked(MouseEvent evt) {
        if (this.JTDetalleOrdenes.getSelectedRow() != -1 && this.JTDetalleOrdenes.getSelectedColumn() == 4 && Boolean.parseBoolean(this.JTDetalleOrdenes.getValueAt(this.JTDetalleOrdenes.getSelectedRow(), 10).toString()) && Integer.parseInt(this.JTDetalleOrdenes.getValueAt(this.JTDetalleOrdenes.getSelectedRow(), 12).toString()) <= 2) {
            JOptionPane.showInternalMessageDialog(this, "<html><p style='text-align:center; font-family:Arial; color:red; font-size:14px;'><b>Procedimiento solicitado necesita registro de autorización.</b></p><p style='text-align:center; font-family:Arial; color:red; font-size:14px;'>No se puede solicitar aun.</p></html>", "VERIFICACIÓN", 2, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
            this.JTDetalleOrdenes.setValueAt(false, this.JTDetalleOrdenes.getSelectedRow(), 4);
        }
    }

    public void mImprimir() {
        String[][] mparametros = new String[4][2];
        mparametros[0][0] = "id";
        mparametros[0][1] = this.xmodelo.getValueAt(this.JTDOrdenes.getSelectedRow(), 0).toString();
        mparametros[1][0] = "nusuarios";
        mparametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
        mparametros[2][0] = "SUBREPORT_DIR";
        mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        mparametros[3][0] = "SUBREPORTFIRMA_DIR";
        mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "RProcedimientos_UH", mparametros);
    }

    public void mNuevo() {
        this.JTADAObservacionG.setText("");
        this.xsql = "SELECT Id, Nbre as Centro_Costo FROM f_centrocosto WHERE (Estado =0) ORDER BY Nbre ASC";
        this.xidcentrocosto = this.xct.llenarCombo(this.xsql, this.xidcentrocosto, this.JCBCentroCosto);
        if (this.xidcentrocosto.length > 1) {
            this.JCBCentroCosto.setSelectedIndex(-1);
        }
        this.xct.cerrarConexionBd();
        mCargarDatosOrdenADx();
        mCrearTablaDetallePro();
    }

    public void mGrabar() {
        LiquidacionEntity liquidacionEntity = this.liquidacionService.liquidacionPorIdIngresoEstado(Long.valueOf(this.idIngreso));
        if (liquidacionEntity == null) {
            if (this.JCBCentroCosto.getSelectedIndex() != -1) {
                if (this.xmt.mVerificarDatosTablaTrue(this.JTDetalleOrdenes, 4)) {
                    if (!this.xestadog) {
                        int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (x == 0) {
                            Boolean finalizarOrden = true;
                            for (int y = 0; y < this.JTDetalleOrdenes.getRowCount(); y++) {
                                if (!Boolean.valueOf(this.xmodelo1.getValueAt(y, 4).toString()).booleanValue()) {
                                    finalizarOrden = false;
                                }
                                if (Boolean.valueOf(this.xmodelo1.getValueAt(y, 4).toString()).booleanValue() && this.xmodelo1.getValueAt(y, 5).toString().equals("")) {
                                    this.xsql = "update  `h_itemordenesproced` set `Ejecutado`=1 , `Fecha_E`='" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "' , `Observacion`='" + this.xmodelo1.getValueAt(y, 6) + "' where (`Id_HOrdenes`= '" + this.xmodelo.getValueAt(this.JTDOrdenes.getSelectedRow(), 0) + "' and  `Id_Procedimiento`='" + this.xmodelo1.getValueAt(y, 0) + "')";
                                    this.xct.ejecutarSQL(this.xsql);
                                    this.xct.cerrarConexionBd();
                                    String codigoTabla = this.JTDetalleOrdenes.getValueAt(y, 0).toString();
                                    if (this.ordenamientoMedico != null) {
                                        this.ordenamientoMedico.getDetalleOrden().forEach(detalleOrden -> {
                                            if (detalleOrden.getCodigo().equals(codigoTabla)) {
                                                detalleOrden.setEjecutado(true);
                                            }
                                        });
                                    }
                                }
                            }
                            if (finalizarOrden.booleanValue()) {
                                this.xsql = "update `h_ordenes` set `Finalizada`=" + mVerificarEstado() + " , `OBservacionGE`='" + this.JTADAObservacionG.getText() + "' where Id='" + this.xmodelo.getValueAt(this.JTDOrdenes.getSelectedRow(), 0) + "'";
                                this.xct.ejecutarSQL(this.xsql);
                                this.xct.cerrarConexionBd();
                            }
                            if (this.ordenamientoMedico != null) {
                                this.ordenamientoMedico.setCerrada(this.xmt.getVerificarEstadoCerrado(this.JTDetalleOrdenes, 4));
                                this.xmt.getGrabarOrdenamientoMedico(this.ordenamientoMedico);
                            }
                            mGrabar_Facturacion();
                            mNuevo();
                            return;
                        }
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Orden ya cerrada", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "No existe registro seleccionado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un centro de costo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTP_Datos.setSelectedIndex(0);
            this.JCBCentroCosto.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>Ingreso ya cerrado por facturación ;</p><font face='Arial' color='red' size=4>No se pueden realizar más registro de cargo.", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private int mVerificarEstado() {
        int xEstado = 0;
        int y = 0;
        while (true) {
            if (y < this.JTDetalleOrdenes.getRowCount()) {
                if (Boolean.valueOf(this.xmodelo1.getValueAt(y, 4).toString()).booleanValue()) {
                    xEstado = 1;
                    y++;
                } else {
                    xEstado = 2;
                    break;
                }
            } else {
                break;
            }
        }
        return xEstado;
    }

    private String mConsultarIdProcedimiento() {
        String xIdProcedimiento = "";
        for (int y = 0; y < this.JTDetalleOrdenes.getRowCount(); y++) {
            if (Boolean.valueOf(this.xmodelo1.getValueAt(y, 4).toString()).booleanValue() && this.xmodelo1.getValueAt(y, 5).toString().equals("")) {
                xIdProcedimiento = xIdProcedimiento + "," + this.xmodelo1.getValueAt(y, 0).toString();
            }
        }
        return xIdProcedimiento.substring(1, xIdProcedimiento.length());
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaOrdenADx() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Servicio", "Especialidad", "Profesional", "Observación", "Estado"}) { // from class: Enfermeria.JPEAyudasDx.5
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDOrdenes.setModel(this.xmodelo);
        this.JTDOrdenes.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDOrdenes.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTDOrdenes.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTDOrdenes.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDOrdenes.getColumnModel().getColumn(4).setPreferredWidth(150);
        this.JTDOrdenes.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTDOrdenes.getColumnModel().getColumn(6).setPreferredWidth(10);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaDetallePro() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"IdProc", "Procedimiento", "Cant", "Observación", "Realizado", "Fecha", "Observación", "idOrdenFactura", "Icono", "NumeroAutorizacion", "Autorización", "IdDetalle", "Cantidad", "NombreSeguimiento"}) { // from class: Enfermeria.JPEAyudasDx.6
            Class[] types = {Long.class, String.class, Long.class, String.class, Boolean.class, String.class, String.class, Long.class, ImageIcon.class, String.class, Boolean.class, Long.class, Integer.class, String.class};
            boolean[] canEdit = {false, false, false, false, true, true, true, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleOrdenes.setModel(this.xmodelo1);
        this.JTDetalleOrdenes.setAutoResizeMode(0);
        this.JTDetalleOrdenes.setRowHeight(30);
        ajustarAnchoColumna(0, 0, 0, 0);
        ajustarAnchoColumna(1, 400, 400, 400);
        ajustarAnchoColumna(2, 100, 100, 100);
        ajustarAnchoColumna(3, 100, 100, 100);
        ajustarAnchoColumna(4, 100, 100, 100);
        ajustarAnchoColumna(5, 100, 100, 100);
        ajustarAnchoColumna(6, 100, 100, 100);
        ajustarAnchoColumna(7, 0, 0, 0);
        ajustarAnchoColumna(8, 100, 100, 100);
        ajustarAnchoColumna(9, 0, 0, 0);
        ajustarAnchoColumna(10, 0, 0, 0);
        ajustarAnchoColumna(11, 0, 0, 0);
        ajustarAnchoColumna(12, 0, 0, 0);
        ajustarAnchoColumna(13, 0, 0, 0);
    }

    private void ajustarAnchoColumna(int indice, int min, int pref, int max) {
        this.JTDetalleOrdenes.getColumnModel().getColumn(indice).setMinWidth(min);
        this.JTDetalleOrdenes.getColumnModel().getColumn(indice).setPreferredWidth(pref);
        this.JTDetalleOrdenes.getColumnModel().getColumn(indice).setMaxWidth(max);
    }

    private void mCargarDatosOrdenADx() {
        try {
            mCrearTablaOrdenADx();
            this.xsql = "SELECT `h_ordenes`.`Id` , DATE_FORMAT(`h_ordenes`.`FechaOrden`,'%d-%m-%Y')  AS Fecga, `f_tiposervicio`.`Nbre` AS `NTipoServicio` , `profesional1`.`Especialidad` , `profesional1`.`NProfesional` ,  `h_ordenes`.`NotaHc`, `h_ordenes`.`Finalizada` FROM `h_ordenes` INNER JOIN  `f_tiposervicio`  ON (`h_ordenes`.`Id_TipoServicio` = `f_tiposervicio`.`Id`)  INNER JOIN  `profesional1`  ON (`profesional1`.`Id_Persona` = `h_ordenes`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `h_ordenes`.`Id_Especialidad`) WHERE (`h_ordenes`.`Id_Atencion` ='" + this.xidAtencion + "'  AND `h_ordenes`.`Estado` =0 and `h_ordenes`.Id_TipoA<>1) ORDER BY `NTipoServicio` ASC, `h_ordenes`.`FechaOrden` DESC ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            Throwable th = null;
            try {
                if (xrs.next()) {
                    int xfila = 0;
                    xrs.beforeFirst();
                    this.xmt.mEstablecerTextEditor(this.JTDOrdenes, 5);
                    while (xrs.next()) {
                        this.xmodelo.addRow(this.xdato);
                        this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), xfila, 0);
                        this.xmodelo.setValueAt(xrs.getString(2), xfila, 1);
                        this.xmodelo.setValueAt(xrs.getString(3), xfila, 2);
                        this.xmodelo.setValueAt(xrs.getString(4), xfila, 3);
                        this.xmodelo.setValueAt(xrs.getString(5), xfila, 4);
                        this.xmodelo.setValueAt(xrs.getString(6), xfila, 5);
                        this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(7)), xfila, 6);
                        this.JTDOrdenes.setDefaultRenderer(Object.class, new MiRender());
                        xfila++;
                    }
                }
                if (xrs != null) {
                    if (0 != 0) {
                        try {
                            xrs.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    } else {
                        xrs.close();
                    }
                }
                this.xct.cerrarConexionBd();
            } finally {
            }
        } catch (SQLException ex) {
            Logger.getLogger(JPEAyudasDx.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosDetalleOrden() {
        try {
            mCrearTablaDetallePro();
            String idOrden = this.xmodelo.getValueAt(this.JTDOrdenes.getSelectedRow(), 0).toString();
            String xsql = construirQuery(idOrden);
            System.out.println(xsql);
            ResultSet xrs = this.xct.traerRs(xsql);
            Throwable th = null;
            try {
                try {
                    if (xrs.isBeforeFirst()) {
                        int xfila = 0;
                        this.xmt.mEstablecerTextEditor(this.JTDetalleOrdenes, 1);
                        this.xmt.mEstablecerTextEditor(this.JTDetalleOrdenes, 3);
                        this.xmt.mEstablecerTextEditor(this.JTDetalleOrdenes, 6);
                        ImageIcon iconoAutorizado = new ImageIcon(getClass().getResource("/Imagenes/autorizado.png"));
                        ImageIcon iconoBloquedado = new ImageIcon(getClass().getResource("/Imagenes/bloqueado.png"));
                        while (xrs.next()) {
                            ImageIcon icono = iconoAutorizado;
                            xrs.getBoolean("autorizacion");
                            if (xrs.getBoolean("autorizacion") && xrs.getInt("cantidad") <= 2) {
                                icono = iconoBloquedado;
                            }
                            this.xmodelo1.addRow(new Object[]{Long.valueOf(xrs.getLong("Id_Procedimiento")), xrs.getString("Nbre"), Long.valueOf(xrs.getLong("Cantidad")), xrs.getString("Descripcion"), Boolean.valueOf(xrs.getBoolean("Ejecutado")), xrs.getString("FE"), xrs.getString("Observacion"), Long.valueOf(xrs.getLong("Id_Orden_Fac")), icono, xrs.getString("numeroAutorizacion"), Boolean.valueOf(xrs.getBoolean("autorizacion")), Long.valueOf(xrs.getLong("idDetalle")), Integer.valueOf(xrs.getInt("cantidad")), xrs.getString("nombreSeguimiento")});
                            xfila++;
                        }
                        this.JTDetalleOrdenes.getColumnModel().getColumn(8).setCellRenderer(new ImageRendererIco());
                        if (xrs != null) {
                            if (0 != 0) {
                                try {
                                    xrs.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                            } else {
                                xrs.close();
                            }
                        }
                        this.xct.cerrarConexionBd();
                        return;
                    }
                    if (xrs != null) {
                        if (0 != 0) {
                            try {
                                xrs.close();
                                return;
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                                return;
                            }
                        }
                        xrs.close();
                        return;
                    }
                    return;
                } finally {
                }
            } catch (Throwable th4) {
                th = th4;
                throw th4;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JPEAyudasDx.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        Logger.getLogger(JPEAyudasDx.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
    }

    /* JADX INFO: loaded from: GenomaP.jar:Enfermeria/JPEAyudasDx$ImageRendererIco.class */
    public class ImageRendererIco extends DefaultTableCellRenderer {
        public ImageRendererIco() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (value instanceof ImageIcon) {
                ImageIcon icon = (ImageIcon) value;
                Image img = icon.getImage().getScaledInstance(30, 30, 4);
                setIcon(new ImageIcon(img));
                setText("");
            } else {
                setIcon(null);
            }
            setHorizontalAlignment(0);
            return this;
        }
    }

    /* JADX WARN: Not initialized variable reg: 8, insn: 0x05f5: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r8 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('xrs' java.sql.ResultSet)]) A[TRY_LEAVE], block:B:57:0x05f5 */
    /* JADX WARN: Not initialized variable reg: 9, insn: 0x05f9: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r9 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:59:0x05f9 */
    private void mGrabar_Facturacion() {
        double subTotal;
        try {
            try {
                ConsultasMySQL xct2 = new ConsultasMySQL();
                this.xsql = "SELECT\n    `f_liquidacion`.`Id`  \nFROM\n    `ingreso`\n    INNER JOIN `f_liquidacion` \n        ON (`ingreso`.`Id` = `f_liquidacion`.`Id_Ingreso`)\n    INNER JOIN `h_atencion` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\nWHERE (`f_liquidacion`.`Estado` =0\n    AND `h_atencion`.`Id` ='" + this.xidAtencion + "')";
                ResultSet xrs = xct2.traerRs(this.xsql);
                Throwable th = null;
                if (!xrs.next()) {
                    String Id_h_ordenes = this.xmodelo.getValueAt(this.JTDOrdenes.getSelectedRow(), 0).toString();
                    int idIngreso = 0;
                    int idTipoServicio = 0;
                    int idProfesional = 0;
                    int idEspecialidad = 0;
                    int idCentroCosto = 0;
                    double totalOrden = 0.0d;
                    double totalEPS = 0.0d;
                    double totalPaciente = 0.0d;
                    try {
                        this.xsql = "SELECT\nf.id, \nf.MetodoFact,\nf.Id_TipoPlan  \nFROM  h_ordenes h\nINNER JOIN h_atencion  ON (h.Id_Atencion = h_atencion.Id) \nINNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) \nINNER JOIN f_empresacontxconvenio f ON (ingreso.Id_EmpresaContxConv = f.Id)  \nWHERE  h.Id='" + Id_h_ordenes + "'";
                        ResultSet rs = this.xct.traerRs(this.xsql);
                        while (rs.next()) {
                            this.xMetodoFact = rs.getInt("MetodoFact");
                            this.xTipoPlan = rs.getInt("Id_TipoPlan");
                        }
                        rs.close();
                        this.xct.cerrarConexionBd();
                        switch (this.xMetodoFact) {
                            case 0:
                                this.xsql = "SELECT ingreso.Id,h.Id_TipoServicio,i.Id_HOrdenes,i.Id_Procedimiento,t.Id_TipoPlan , i.idtipofinProc as Id_TipoFinProced,\n'" + this.xidcentrocosto[this.JCBCentroCosto.getSelectedIndex()] + "' AS Id_CentroCosto,\ni.Cantidad,\nIF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,IF(f.CualValor=0, t.VrMinimo,t.VrMaximo),f_procedempresaconvenio.Valor) AS ValorUnitario, h.Id_Profesional , h.Id_Especialidad, g_procedimiento.porcentajeImpuesto, (((SELECT ValorUnitario) * g_procedimiento.porcentajeImpuesto)/100) AS valorImpuesto\n, i.idModalidadAtencion, i.idServicioRips \nFROM h_itemordenesproced i\nINNER JOIN h_ordenes h ON i.Id_HOrdenes= h.id\nINNER JOIN h_atencion  ON h.Id_Atencion = h_atencion.Id \nINNER JOIN ingreso  ON h_atencion.Id_Ingreso = ingreso.Id\nINNER JOIN f_tarifaprocedimiento t ON i.Id_Procedimiento=t.Id_Procedimiento\nINNER JOIN f_manual ON t.Id_Manual = f_manual.Id \nINNER JOIN f_empresacontxconvenio  f ON ingreso.Id_EmpresaContxConv=f.id AND f.Id_Manual=t.Id_Manual\nINNER JOIN g_procedimiento ON (t.Id_Procedimiento = g_procedimiento.Id)\n            LEFT JOIN f_procedempresaconvenio ON (f_procedempresaconvenio.Id_Procedimiento = g_procedimiento.Id) \n            AND (f_procedempresaconvenio.Id_EmpresacontxConv = f.Id) and (f_procedempresaconvenio.Estado=0) \nINNER JOIN f_tipoplan ON (t.Id_TipoPlan = f_tipoplan.Id)\nWHERE i.Id_Procedimiento in(" + mConsultarIdProcedimiento() + ") and i.Ejecutado=1 AND i.Id_HOrdenes='" + Id_h_ordenes + "'  group by i.Id_HOrdenes, i.Id_Procedimiento";
                                break;
                            case 1:
                                this.xsql = "SELECT ingreso.Id,h.Id_TipoServicio,i.Id_HOrdenes,i.Id_Procedimiento,t.Id_TipoPlan ,i.idtipofinProc as Id_TipoFinProced,\n'" + this.xidcentrocosto[this.JCBCentroCosto.getSelectedIndex()] + "' AS Id_CentroCosto,\ni.Cantidad,\nIF(f.CualValor=0, \n\t\tCASE (f.Redondeo)\n\t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t\n\t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor)\n\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor)\n\t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor)\n\t\tEND,\n\t\tCASE (f.Redondeo)\n\t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t\n\t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor)\n\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor)\n\t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor)\n\t\tEND) AS ValorUnitario, h.Id_Profesional , h.Id_Especialidad, g_procedimiento.porcentajeImpuesto, (((SELECT ValorUnitario) * g_procedimiento.porcentajeImpuesto)/100) AS valorImpuesto\n, i.idModalidadAtencion, i.idServicioRips \nFROM h_itemordenesproced i\nINNER JOIN h_ordenes h ON i.Id_HOrdenes= h.id\nINNER JOIN h_atencion  ON (h.Id_Atencion = h_atencion.Id) \nINNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id)\nINNER JOIN f_tarifaprocedimiento t ON i.Id_Procedimiento=t.Id_Procedimiento\nINNER JOIN f_manual ON t.Id_Manual = f_manual.Id \nINNER JOIN f_empresacontxconvenio  f ON ingreso.Id_EmpresaContxConv=f.id AND f.Id_Manual=t.Id_Manual\nINNER JOIN g_procedimiento ON (t.Id_Procedimiento = g_procedimiento.Id)\n            LEFT JOIN f_procedempresaconvenio ON (f_procedempresaconvenio.Id_Procedimiento = g_procedimiento.Id) \n            AND (f_procedempresaconvenio.Id_EmpresacontxConv = f.Id) and (f_procedempresaconvenio.Estado=0) \nINNER JOIN f_tipoplan ON (t.Id_TipoPlan = f_tipoplan.Id)\nINNER JOIN f_tipoprocedimiento ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id) \nINNER JOIN f_tiposervtipoproced ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id)\nINNER JOIN f_servicioempresaconv ON (f_servicioempresaconv.Id_EmpresaConvenio=f.Id) \n             AND (f_tiposervtipoproced.Idtiposervicio= f_servicioempresaconv.Id_TipoServicio)\nWHERE i.Id_Procedimiento in(" + mConsultarIdProcedimiento() + ") and i.Ejecutado=1  AND i.Id_HOrdenes='" + Id_h_ordenes + "'  group by i.Id_HOrdenes, i.Id_Procedimiento";
                                break;
                            default:
                                this.xsql = "SELECT ingreso.Id,h.Id_TipoServicio,i.Id_HOrdenes,i.Id_Procedimiento,t.Id_TipoPlan ,i.idtipofinProc as Id_TipoFinProced,\n'" + this.xidcentrocosto[this.JCBCentroCosto.getSelectedIndex()] + "' AS Id_CentroCosto,\ni.Cantidad,\n            IF(f.CualValor=0, \n\t\tCASE (f_manual.AplicaFactor)\n\t\t   WHEN 0 THEN\n\t\t\tCASE (f.Redondeo)\n\t\t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t\n\t\t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor)\n\t\t\tEND\n\t\t   WHEN 1 THEN\n\t\t\tIF(f_servicioempresaconv.AplicaFactor=0,\n\t\t\t     CASE (f.Redondeo)\n\t\t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t\n\t\t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor)\n\t\t\t     END,\t\n\t\t\t     CASE (f.Redondeo)\n\t\t\t\tWHEN 0 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(ROUND((t.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((t.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN 2 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((ROUND((t.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((t.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100)))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -1 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((ROUND((t.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((t.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-1),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -2 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((ROUND((t.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((t.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-2),f_procedempresaconvenio.Valor)\n\t\t\t     END)\t\n\t\tEND,\n\t\tCASE (f_manual.AplicaFactor)\n\t\t   WHEN 0 THEN\n\t\t\tCASE (f.Redondeo)\n\t\t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t\n\t\t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor)\n\t\t\tEND\n\t\t   WHEN 1 THEN\n\t\t\tIF(f_servicioempresaconv.AplicaFactor=0,\n\t\t\t     CASE (f.Redondeo)\n\t\t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t\n\t\t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor)\n\t\t\t     END,\t\n\t\t\t     CASE (f.Redondeo)\n\t\t\t\tWHEN 0 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(ROUND((t.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((t.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN 2 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((ROUND((t.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((t.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100)))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -1 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((ROUND((t.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((t.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-1),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -2 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((ROUND((t.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((t.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-2),f_procedempresaconvenio.Valor)\n\t\t\t     END)\t\n\t\tEND\n\t\t) AS ValorUnitario, h.Id_Profesional , h.Id_Especialidad, g_procedimiento.porcentajeImpuesto, (((SELECT ValorUnitario) * g_procedimiento.porcentajeImpuesto)/100) AS valorImpuesto\n, i.idModalidadAtencion, i.idServicioRips \n\t\t \n\t    FROM h_itemordenesproced i\n\t    INNER JOIN h_ordenes h ON i.Id_HOrdenes= h.id\n\t    INNER JOIN h_atencion  ON (h.Id_Atencion = h_atencion.Id) \n\t    INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id)\n\t    INNER JOIN f_empresacontxconvenio f  ON ingreso.Id_EmpresaContxConv=f.id\n\t    INNER JOIN f_servicioempresaconv   ON (f_servicioempresaconv.Id_EmpresaConvenio = f.Id) \n\t    INNER JOIN f_manual ON f_servicioempresaconv.Id_Manual_n=f_manual.Id\n\t    INNER JOIN f_tarifaprocedimiento t ON i.Id_Procedimiento=t.Id_Procedimiento AND t.Id_Manual=f_manual.Id\n\t    INNER JOIN g_procedimiento ON (t.Id_Procedimiento = g_procedimiento.Id)\n            LEFT JOIN f_procedempresaconvenio ON (f_procedempresaconvenio.Id_Procedimiento = g_procedimiento.Id) \n            AND (f_procedempresaconvenio.Id_EmpresacontxConv = f.Id) and (f_procedempresaconvenio.Estado=0) \n            INNER JOIN f_tipoplan ON (t.Id_TipoPlan = f_tipoplan.Id)\n            INNER JOIN f_tipoprocedimiento ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id)\n\t    INNER JOIN f_tipofinprocedimiento  ON (g_procedimiento.Id_TipoFinProced = f_tipofinprocedimiento.Id)  \n\t    INNER JOIN f_tiposervtipoproced ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id) \n\t\t\t\tAND (f_servicioempresaconv.Id_TipoServicio = f_tiposervtipoproced.Idtiposervicio)\n\t    LEFT JOIN g_historico_salario_minimo ON (f_servicioempresaconv.Anno = g_historico_salario_minimo.Ano)\n\t    WHERE  i.Id_Procedimiento in(" + mConsultarIdProcedimiento() + ") and i.Ejecutado=1  AND i.Id_HOrdenes='" + Id_h_ordenes + "'  group by i.Id_HOrdenes, i.Id_Procedimiento";
                                break;
                        }
                        ResultSet rs2 = this.xct.traerRs(this.xsql);
                        while (rs2.next()) {
                            idIngreso = rs2.getInt("Id");
                            idTipoServicio = rs2.getInt("Id_TipoServicio");
                            idProfesional = rs2.getInt("Id_Profesional");
                            idEspecialidad = rs2.getInt("Id_Especialidad");
                            idCentroCosto = rs2.getInt("Id_CentroCosto");
                            rs2.afterLast();
                        }
                        this.sql = "INSERT IGNORE INTO `f_ordenes`( `Id_Ingreso` , `Id_TipoServicio` , `FechaOrden` , `HoraOrden` , `Id_Profesional` , `Id_Especialidad` , `Id_CentroCosto` , `TotalOrdenes` , `TotalEPS` , `TotalDescuento` , `TotalPaciente` , `Estado` , `LProcesamiento` , `Fecha` , `UsuarioS`) VALUES('" + idIngreso + "','" + idTipoServicio + "',DATE(NOW()),TIME(NOW()),'" + idProfesional + "','" + idEspecialidad + "','" + idCentroCosto + "',0,0,0,0,0,0,NOW(),'" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        String xN_Orden = this.xcon.ejecutarSQLId(this.sql);
                        rs2.beforeFirst();
                        while (rs2.next()) {
                            if (Principal.informacionIps.getFiltroSeguimientoFactura().booleanValue()) {
                                subTotal = (((double) rs2.getInt("Cantidad")) * rs2.getDouble("ValorUnitario")) + rs2.getDouble("valorImpuesto");
                            } else {
                                subTotal = ((double) rs2.getInt("Cantidad")) * rs2.getDouble("ValorUnitario");
                            }
                            totalOrden += subTotal;
                            if (this.xTipoPlan == rs2.getInt("Id_TipoPlan")) {
                                totalEPS += subTotal;
                            } else {
                                totalPaciente += subTotal;
                            }
                            if (Principal.informacionIps.getFiltroSeguimientoFactura().booleanValue()) {
                                this.sql = "INSERT INTO `f_itemordenesproced`( `Id_Ordenes` , `Id_Procedimiento` , `Id_TipofinProc` , `Cantidad` , `ValorUnitario`, porcentajeImpuesto , valorImpuesto , `Id_CentroCosto` ,Plan, `Fecha`, idModalidadAtencion, idServicioRips, `UsuarioS`) VALUES ( " + xN_Orden + "," + rs2.getInt("Id_Procedimiento") + "," + rs2.getString("Id_TipoFinProced") + "," + rs2.getInt("Cantidad") + "," + rs2.getDouble("ValorUnitario") + "," + rs2.getDouble("porcentajeImpuesto") + "," + rs2.getDouble("valorImpuesto") + "," + rs2.getInt("Id_CentroCosto") + "," + rs2.getInt("Id_TipoPlan") + ",NOW()," + rs2.getInt("idModalidadAtencion") + "," + rs2.getInt("idServicioRips") + ",'" + Principal.usuarioSistemaDTO.getLogin() + "')";
                            } else {
                                this.sql = "INSERT INTO `f_itemordenesproced`( `Id_Ordenes` , `Id_Procedimiento` , `Id_TipofinProc` , `Cantidad` , `ValorUnitario`, porcentajeImpuesto , valorImpuesto , `Id_CentroCosto` ,Plan, `Fecha`, idModalidadAtencion, idServicioRips, `UsuarioS`) VALUES ( " + xN_Orden + "," + rs2.getInt("Id_Procedimiento") + "," + rs2.getString("Id_TipoFinProced") + "," + rs2.getInt("Cantidad") + "," + rs2.getDouble("ValorUnitario") + "," + Double.valueOf(0.0d) + "," + Double.valueOf(0.0d) + "," + rs2.getInt("Id_CentroCosto") + "," + rs2.getInt("Id_TipoPlan") + ",NOW()," + rs2.getInt("idModalidadAtencion") + "," + rs2.getInt("idServicioRips") + ",'" + Principal.usuarioSistemaDTO.getLogin() + "')";
                            }
                            this.xcon.ejecutarSQL(this.sql);
                            this.xcon.cerrarConexionBd();
                        }
                        rs2.close();
                        this.xct.cerrarConexionBd();
                        this.sql = "UPDATE f_ordenes SET TotalOrdenes=" + totalOrden + ",TotalEPS=" + totalEPS + ",TotalPaciente=" + totalPaciente + " WHERE  Id=" + xN_Orden;
                        this.xcon.ejecutarSQL(this.sql);
                        this.xcon.cerrarConexionBd();
                        for (int y = 0; y < this.JTDetalleOrdenes.getRowCount(); y++) {
                            if (Boolean.parseBoolean(this.xmodelo1.getValueAt(y, 4).toString())) {
                                this.xsql = "update  `h_itemordenesproced` set `Id_Orden_Fac`='" + xN_Orden + "' where (`Id_HOrdenes`= '" + this.xmodelo.getValueAt(this.JTDOrdenes.getSelectedRow(), 0) + "' and  `Id_Procedimiento` in(" + mConsultarIdProcedimiento() + "))";
                                this.xct.ejecutarSQL(this.xsql);
                                this.xct.cerrarConexionBd();
                            }
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(JPEAyudasDx.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                    }
                }
                if (xrs != null) {
                    if (0 != 0) {
                        try {
                            xrs.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    } else {
                        xrs.close();
                    }
                }
                xct2.cerrarConexionBd();
            } catch (SQLException ex2) {
                Logger.getLogger(JPEAyudasDx.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
            }
        } finally {
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Enfermeria/JPEAyudasDx$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            switch (Integer.parseInt(table.getValueAt(row, 6).toString())) {
                case 1:
                    cell.setBackground(new Color(177, 251, 177));
                    cell.setForeground(Color.BLACK);
                    break;
                case 2:
                    cell.setBackground(new Color(255, 204, 204));
                    cell.setForeground(Color.BLACK);
                    break;
                default:
                    cell.setBackground(Color.WHITE);
                    cell.setForeground(Color.BLACK);
                    break;
            }
            return cell;
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Enfermeria/JPEAyudasDx$MiRender2.class */
    public static class MiRender2 extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (Boolean.parseBoolean(table.getValueAt(row, 4).toString()) && !table.getValueAt(row, 5).toString().isEmpty() && Long.parseLong(table.getValueAt(row, 7).toString()) != 0) {
                cell.setBackground(new Color(177, 251, 177));
                cell.setForeground(Color.BLACK);
            } else if (Boolean.parseBoolean(table.getValueAt(row, 4).toString()) && !table.getValueAt(row, 5).toString().isEmpty() && Long.parseLong(table.getValueAt(row, 7).toString()) == 0) {
                cell.setBackground(new Color(190, 30, 46));
                cell.setForeground(Color.BLACK);
            } else {
                cell.setBackground(Color.WHITE);
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }

    private String construirQuery(String idOrden) {
        return "WITH maestra AS (     SELECT h_itemordenesproced.Id_Procedimiento, g_procedimiento.Nbre, h_itemordenesproced.Cantidad,            h_itemordenesproced.Descripcion, h_itemordenesproced.Ejecutado,            IFNULL(DATE_FORMAT(h_itemordenesproced.Fecha_E, '%d-%m-%Y'), '') AS FE,            IFNULL(h_itemordenesproced.Observacion, '') AS Observacion,            h_itemordenesproced.Id_Orden_Fac, h_itemordenesproced.numeroAutorizacion,            IF(fp.Id_Procedimiento IS NOT NULL, 1, 0) AS autorizacion, h_itemordenesproced.Id AS idDetalle     FROM h_itemordenesproced     INNER JOIN g_procedimiento ON h_itemordenesproced.Id_Procedimiento = g_procedimiento.Id     INNER JOIN h_ordenes ON h_itemordenesproced.Id_HOrdenes = h_ordenes.Id     LEFT JOIN f_procedempresaconvenio fp ON fp.Id_Procedimiento = g_procedimiento.Id AND fp.Estado = 0     WHERE h_itemordenesproced.Id_HOrdenes = '" + idOrden + "' AND h_ordenes.Estado = 0     GROUP BY h_itemordenesproced.Id_Procedimiento     ORDER BY g_procedimiento.Nbre ASC ), seguimientoAutorizado AS (     SELECT COUNT(h_itemordenesproced_seguimiento.id) AS cantidad,            h_itemordenesproced_seguimiento.idItemsProcedimiento,            GROUP_CONCAT(DISTINCT h_tiipo_seguimiento_items.nombre ORDER BY h_tiipo_seguimiento_items.nombre SEPARATOR '\\n') AS nombreSeguimiento     FROM h_itemordenesproced_seguimiento     INNER JOIN h_tiipo_seguimiento_items ON h_tiipo_seguimiento_items.id = h_itemordenesproced_seguimiento.idTipoSeguimiento     WHERE h_itemordenesproced_seguimiento.estado = 1     GROUP BY h_itemordenesproced_seguimiento.idItemsProcedimiento ) SELECT m.*, IFNULL(s.cantidad, 0) AS cantidad, IFNULL(s.nombreSeguimiento, '') AS nombreSeguimiento FROM maestra m LEFT JOIN seguimientoAutorizado s ON m.idDetalle = s.idItemsProcedimiento;";
    }
}
