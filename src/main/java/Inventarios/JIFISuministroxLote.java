package Inventarios;

import Acceso.Principal;
import ParametrizacionN.JIFFSubGrupoFactur;
import ParametrizacionN.JIFGenerico1CheckBox;
import ParametrizacionN.JIFGenerico2Text1CheckBox1;
import ParametrizacionN.JIFSPresentacionFarmaceuta;
import ParametrizacionN.JIFSPrincipoActivo;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
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
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Inventarios/JIFISuministroxLote.class */
public class JIFISuministroxLote extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelosb;
    private Object[] xdatos;
    public String[] xidprincipioactivo;
    public String[] xidunidadmedida;
    public String[] xidpresentacionf;
    public String[] xidpresentacionc;
    public String[] xidviaadministracion;
    public String[] xidconcentracion;
    public String[] xidlaboratorio;
    public String[] xidcategoria;
    public String[] xidprioridad;
    public String[] xidcasificacion;
    public String[] xidtipoproducto;
    public JIFSPrincipoActivo xjifprincipioactivo;
    public JIFSPresentacionFarmaceuta xjifpresentaconfarmaceutica;
    public JIFGenerico1CheckBox xjifgenerico;
    private ButtonGroup JBGOpciones;
    private JCheckBox JCHComienza;
    private JCheckBox JCHContiene;
    private JDateChooser JDCFechaVencimiento;
    private JPanel JPIDatos;
    private JPanel JPIDatosBusqueda;
    private JSpinner JSPCPendiente;
    private JSpinner JSPCantidad;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPDetalleSB;
    private JTable JTDetalle;
    private JTable JTDetalleSB;
    private JTextField JTFCodigoBarra;
    private JTextField JTFLote;
    private JTextField JTFNombreBusqueda;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xcajacompleta = 0;
    private int xtipobusqueda = 0;
    private int xpos = 0;
    private int xactivo = 1;
    private int xactivohc = 0;
    private int xmaterial = 1;
    private int xcobrable = 0;
    private String xurl = "";

    public JIFISuministroxLote() {
        initComponents();
        mCargarDatosIniciales();
    }

    /* JADX WARN: Type inference failed for: r3v41, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v73, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGOpciones = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JTFLote = new JTextField();
        this.JDCFechaVencimiento = new JDateChooser();
        this.JSPCantidad = new JSpinner();
        this.JSPCPendiente = new JSpinner();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPIDatosBusqueda = new JPanel();
        this.JTFNombreBusqueda = new JTextField();
        this.JCHComienza = new JCheckBox();
        this.JCHContiene = new JCheckBox();
        this.JTFCodigoBarra = new JTextField();
        this.JSPDetalleSB = new JScrollPane();
        this.JTDetalleSB = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("SUMINISTRO POR LOTE");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setMinimumSize(null);
        setName("jifsuministrolote");
        setPreferredSize(new Dimension(1136, 644));
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: Inventarios.JIFISuministroxLote.1
            public void internalFrameOpened(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFISuministroxLote.this.formInternalFrameClosing(evt);
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }
        });
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFLote.setFont(new Font("Arial", 1, 12));
        this.JTFLote.setToolTipText("");
        this.JTFLote.setBorder(BorderFactory.createTitledBorder((Border) null, "Lote", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFLote.addActionListener(new ActionListener() { // from class: Inventarios.JIFISuministroxLote.2
            public void actionPerformed(ActionEvent evt) {
                JIFISuministroxLote.this.JTFLoteActionPerformed(evt);
            }
        });
        this.JTFLote.addFocusListener(new FocusAdapter() { // from class: Inventarios.JIFISuministroxLote.3
            public void focusLost(FocusEvent evt) {
                JIFISuministroxLote.this.JTFLoteFocusLost(evt);
            }
        });
        this.JDCFechaVencimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 1, 0, new Font("Tahoma", 1, 12), Color.blue));
        this.JDCFechaVencimiento.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaVencimiento.setFont(new Font("Arial", 1, 12));
        this.JSPCantidad.setFont(new Font("Arial", 1, 12));
        this.JSPCantidad.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSPCantidad.setToolTipText("");
        this.JSPCantidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Cantidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPCPendiente.setFont(new Font("Arial", 1, 12));
        this.JSPCPendiente.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSPCPendiente.setToolTipText("");
        this.JSPCPendiente.setBorder(BorderFactory.createTitledBorder((Border) null, "CPendiente", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFLote, -2, 248, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDCFechaVencimiento, -2, 143, -2).addGap(18, 18, 18).addComponent(this.JSPCantidad, -2, 95, -2).addGap(18, 18, 18).addComponent(this.JSPCPendiente, -2, 95, -2).addContainerGap(459, 32767)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JSPCantidad, -1, 55, 32767).addComponent(this.JSPCPendiente, -1, 52, 32767)).addComponent(this.JTFLote, GroupLayout.Alignment.TRAILING).addComponent(this.JDCFechaVencimiento, GroupLayout.Alignment.TRAILING, -1, 56, 32767)).addContainerGap(-1, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "SUMINISTRO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Inventarios.JIFISuministroxLote.4
            public void mouseClicked(MouseEvent evt) {
                JIFISuministroxLote.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JPIDatosBusqueda.setBorder(BorderFactory.createTitledBorder((Border) null, "BÚSQUEDA FILTRADA", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JTFNombreBusqueda.setFont(new Font("Arial", 1, 12));
        this.JTFNombreBusqueda.setToolTipText("");
        this.JTFNombreBusqueda.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombreBusqueda.addKeyListener(new KeyAdapter() { // from class: Inventarios.JIFISuministroxLote.5
            public void keyTyped(KeyEvent evt) {
                JIFISuministroxLote.this.JTFNombreBusquedaKeyTyped(evt);
            }

            public void keyPressed(KeyEvent evt) {
                JIFISuministroxLote.this.JTFNombreBusquedaKeyPressed(evt);
            }
        });
        this.JBGOpciones.add(this.JCHComienza);
        this.JCHComienza.setFont(new Font("Arial", 1, 12));
        this.JCHComienza.setSelected(true);
        this.JCHComienza.setText("Comienza");
        this.JBGOpciones.add(this.JCHContiene);
        this.JCHContiene.setFont(new Font("Arial", 1, 12));
        this.JCHContiene.setText("Contiene");
        this.JCHContiene.addActionListener(new ActionListener() { // from class: Inventarios.JIFISuministroxLote.6
            public void actionPerformed(ActionEvent evt) {
                JIFISuministroxLote.this.JCHContieneActionPerformed(evt);
            }
        });
        this.JTFCodigoBarra.setFont(new Font("Arial", 1, 12));
        this.JTFCodigoBarra.setToolTipText("");
        this.JTFCodigoBarra.setBorder(BorderFactory.createTitledBorder((Border) null, "Código Barra Unidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCodigoBarra.addFocusListener(new FocusAdapter() { // from class: Inventarios.JIFISuministroxLote.7
            public void focusLost(FocusEvent evt) {
                JIFISuministroxLote.this.JTFCodigoBarraFocusLost(evt);
            }
        });
        this.JTFCodigoBarra.addActionListener(new ActionListener() { // from class: Inventarios.JIFISuministroxLote.8
            public void actionPerformed(ActionEvent evt) {
                JIFISuministroxLote.this.JTFCodigoBarraActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosBusquedaLayout = new GroupLayout(this.JPIDatosBusqueda);
        this.JPIDatosBusqueda.setLayout(JPIDatosBusquedaLayout);
        JPIDatosBusquedaLayout.setHorizontalGroup(JPIDatosBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosBusquedaLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFCodigoBarra, -1, 177, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFNombreBusqueda, -2, 734, -2).addGap(18, 18, 18).addGroup(JPIDatosBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHComienza).addComponent(this.JCHContiene)).addGap(58, 58, 58)));
        JPIDatosBusquedaLayout.setVerticalGroup(JPIDatosBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosBusquedaLayout.createSequentialGroup().addGroup(JPIDatosBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosBusquedaLayout.createSequentialGroup().addComponent(this.JCHComienza).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHContiene)).addGroup(JPIDatosBusquedaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombreBusqueda, -2, 50, -2).addComponent(this.JTFCodigoBarra, -2, 50, -2))).addContainerGap(16, 32767)));
        this.JSPDetalleSB.setBorder(BorderFactory.createTitledBorder((Border) null, "SUMINISTRO POR LOTE POR BODEGA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalleSB.setFont(new Font("Arial", 1, 12));
        this.JTDetalleSB.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleSB.setRowHeight(25);
        this.JTDetalleSB.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleSB.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalleSB.setSelectionMode(0);
        this.JTDetalleSB.addMouseListener(new MouseAdapter() { // from class: Inventarios.JIFISuministroxLote.9
            public void mouseClicked(MouseEvent evt) {
                JIFISuministroxLote.this.JTDetalleSBMouseClicked(evt);
            }
        });
        this.JSPDetalleSB.setViewportView(this.JTDetalleSB);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatos, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JPIDatosBusqueda, -1, -1, 32767).addComponent(this.JSPDetalle, -1, 1106, 32767).addComponent(this.JSPDetalleSB, -1, 1106, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIDatosBusqueda, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 217, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalleSB, -2, 145, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            mCargarDatosTablaSB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHContieneActionPerformed(ActionEvent evt) {
        this.xtipobusqueda = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreBusquedaKeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleSBMouseClicked(MouseEvent evt) {
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Principal.txtNo.setText(this.xmodelosb.getValueAt(this.JTDetalleSB.getSelectedRow(), 0).toString());
            this.JTFLote.setText(this.xmodelosb.getValueAt(this.JTDetalleSB.getSelectedRow(), 1).toString());
            this.JDCFechaVencimiento.setDate(formatoDelTexto.parse(this.xmodelosb.getValueAt(this.JTDetalleSB.getSelectedRow(), 2).toString()));
            this.JSPCantidad.setValue(Integer.valueOf(this.xmodelosb.getValueAt(this.JTDetalleSB.getSelectedRow(), 3).toString()));
            this.JSPCPendiente.setValue(Integer.valueOf(this.xmodelosb.getValueAt(this.JTDetalleSB.getSelectedRow(), 4).toString()));
        } catch (ParseException ex) {
            Logger.getLogger(JIFISuministroxLote.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCodigoBarraActionPerformed(ActionEvent evt) {
        mCargarDatosxCodigoBarra();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCodigoBarraFocusLost(FocusEvent evt) {
        mCargarDatosxCodigoBarra();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFLoteActionPerformed(ActionEvent evt) {
        mCargarDatosxCodigoBarra();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFLoteFocusLost(FocusEvent evt) {
        mCargarDatosxCodigoBarra();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreBusquedaKeyPressed(KeyEvent evt) {
        String xsql;
        if (evt.getKeyCode() == 10) {
            if (!this.JTFNombreBusqueda.getText().isEmpty()) {
                if (this.xtipobusqueda == 0) {
                    xsql = "SELECT i_suministroxbodega.Id, i_suministro.CodBarraUnidad, i_suministro.CantidadUnidad, i_suministro.CodBarraEmbalaje, i_suministro.Nbre, i_suministro.CajaCompleta, i_principioactivo.Nbre, i_unidadmedida.Nbre\t , i_presentacionfarmaceutica.Nbre, i_viaadministracion.Nbre, i_presentacioncomercial.Nbre, i_concentracion.Nbre, i_clasificacion.Nbre, i_suministro.RegistroInvima, i_laboratorio.Nbre\t, i_tipoproducto.Nbre , i_categoria.Nbre, i_prioridades.Nbre, i_suministro.Pos, i_suministro.EstaActivo, i_suministro.ActivoHc, i_suministro.EsMaterial, i_suministro.Escobrable, i_suministro.Iva, i_suministro.Indicaciones, i_suministro.ContraIndicaciones , i_suministro.Interacciones, IF(i_suministro.CodigoCUM IS NULL, '',i_suministro.CodigoCUM)  AS CodigoCum, IF((i_suministro.DLogo IS NULL || i_suministro.DLogo=0 || i_suministro.DLogo=''), '',i_suministro.DLogo)  AS Logo, i_suministroxbodega.Id FROM i_suministro INNER JOIN i_principioactivo  ON (i_suministro.IdPrincipioActivo = i_principioactivo.Id) INNER JOIN i_unidadmedida  ON (i_suministro.IdUnidadMedida = i_unidadmedida.Id) INNER JOIN i_presentacionfarmaceutica  ON (i_suministro.IdPresentacionFarmaceutica = i_presentacionfarmaceutica.Id) INNER JOIN i_viaadministracion  ON (i_suministro.IdViaAdministracion = i_viaadministracion.Id) INNER JOIN i_presentacioncomercial  ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_concentracion  ON (i_suministro.IdConcentracion = i_concentracion.Id) INNER JOIN i_clasificacion  ON (i_suministro.IdClasificacion = i_clasificacion.Id) INNER JOIN i_laboratorio  ON (i_suministro.IdLaboratorio = i_laboratorio.Id) INNER JOIN i_tipoproducto  ON (i_suministro.IdTipoProducto = i_tipoproducto.Id) INNER JOIN i_categoria  ON (i_suministro.IdCategoria = i_categoria.Id) INNER JOIN i_prioridades  ON (i_suministro.IdPrioridad = i_prioridades.Id) INNER JOIN `i_suministroxbodega` ON (i_suministro.`Id`= i_suministroxbodega.`IdSuministro`) WHERE `i_suministroxbodega`.`IdBodega`= '" + Principal.xClaseInventario.getIdBodega() + "' and i_suministro.Nbre LIKE '" + this.JTFNombreBusqueda.getText() + "%' ORDER BY i_suministro.Nbre ASC, i_presentacionfarmaceutica.Nbre ASC ";
                } else {
                    xsql = "SELECT i_suministroxbodega.Id, i_suministro.CodBarraUnidad, i_suministro.CantidadUnidad, i_suministro.CodBarraEmbalaje, i_suministro.Nbre, i_suministro.CajaCompleta, i_principioactivo.Nbre, i_unidadmedida.Nbre\t , i_presentacionfarmaceutica.Nbre, i_viaadministracion.Nbre, i_presentacioncomercial.Nbre, i_concentracion.Nbre, i_clasificacion.Nbre, i_suministro.RegistroInvima, i_laboratorio.Nbre\t, i_tipoproducto.Nbre , i_categoria.Nbre, i_prioridades.Nbre, i_suministro.Pos, i_suministro.EstaActivo, i_suministro.ActivoHc, i_suministro.EsMaterial, i_suministro.Escobrable, i_suministro.Iva, i_suministro.Indicaciones, i_suministro.ContraIndicaciones , i_suministro.Interacciones, IF(i_suministro.CodigoCUM IS NULL, '',i_suministro.CodigoCUM)  AS CodigoCum, IF((i_suministro.DLogo IS NULL || i_suministro.DLogo=0 || i_suministro.DLogo=''), '',i_suministro.DLogo)  AS Logo , i_suministroxbodega.Id FROM i_suministro INNER JOIN i_principioactivo  ON (i_suministro.IdPrincipioActivo = i_principioactivo.Id) INNER JOIN i_unidadmedida  ON (i_suministro.IdUnidadMedida = i_unidadmedida.Id) INNER JOIN i_presentacionfarmaceutica  ON (i_suministro.IdPresentacionFarmaceutica = i_presentacionfarmaceutica.Id) INNER JOIN i_viaadministracion  ON (i_suministro.IdViaAdministracion = i_viaadministracion.Id) INNER JOIN i_presentacioncomercial  ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_concentracion  ON (i_suministro.IdConcentracion = i_concentracion.Id) INNER JOIN i_clasificacion  ON (i_suministro.IdClasificacion = i_clasificacion.Id) INNER JOIN i_laboratorio  ON (i_suministro.IdLaboratorio = i_laboratorio.Id) INNER JOIN i_tipoproducto  ON (i_suministro.IdTipoProducto = i_tipoproducto.Id) INNER JOIN i_categoria  ON (i_suministro.IdCategoria = i_categoria.Id) INNER JOIN i_prioridades  ON (i_suministro.IdPrioridad = i_prioridades.Id) INNER JOIN `i_suministroxbodega` ON (i_suministro.`Id`= i_suministroxbodega.`IdSuministro`) WHERE `i_suministroxbodega`.`IdBodega`= '" + Principal.xClaseInventario.getIdBodega() + "' and i_suministro.Nbre LIKE '%" + this.JTFNombreBusqueda.getText() + "%' ORDER BY i_suministro.Nbre ASC, i_presentacionfarmaceutica.Nbre ASC ";
                }
                mCargarDatosTabla(xsql);
                return;
            }
            mCrearModeloDatos();
            mCrearModeloDatosSB();
        }
    }

    public void mNuevo() {
        Principal.txtNo.setText("");
        this.JTFLote.setText("");
        this.JTFCodigoBarra.setText("");
        this.JTFNombreBusqueda.setText("");
        this.JDCFechaVencimiento.setDate(this.xmetodos.getFechaActual());
        this.JSPCantidad.setValue(new Integer(0));
        this.JSPCPendiente.setValue(new Integer(0));
    }

    public void mGrabar() {
        if (this.JTDetalle.getSelectedRow() != -1 && this.JTDetalleSB.getSelectedRow() != -1) {
            if (!Principal.txtNo.getText().isEmpty()) {
                if (!this.JTFLote.getText().isEmpty()) {
                    int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        String sql = " update i_suministroxlotexbodega set Lote='" + this.JTFLote.getText() + "',FechaVencimiento='" + this.xmetodos.formatoAMD.format(this.JDCFechaVencimiento.getDate()) + "',Cantidad='" + this.JSPCantidad.getValue() + "',CPendiente='" + this.JSPCPendiente.getValue() + "' Where Id='" + Principal.txtNo.getText() + "' and Lote='" + this.xmodelosb.getValueAt(this.JTDetalleSB.getSelectedRow(), 1) + "'";
                        this.xconsulta.ejecutarSQL(sql);
                        this.xconsulta.cerrarConexionBd();
                        mCargarDatosTablaSB();
                        mNuevo();
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "El lote no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFLote.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar lote", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFLote.requestFocus();
            return;
        }
        if (this.JTDetalle.getSelectedRow() != -1 && this.JTDetalleSB.getSelectedRow() == -1) {
            int n2 = JOptionPane.showInternalConfirmDialog(this, "Desea agregar lote?", "Verificar", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n2 == 0) {
                String sql2 = " insert IGNORE into  i_suministroxlotexbodega (Id, Lote, FechaVencimiento, Cantidad) values ('" + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0) + "','" + this.JTFLote.getText() + "','" + this.xmetodos.formatoAMD.format(this.JDCFechaVencimiento.getDate()) + "','" + this.JSPCantidad.getValue() + "')";
                this.xconsulta.ejecutarSQL(sql2);
                this.xconsulta.cerrarConexionBd();
                mCargarDatosTablaSB();
                mNuevo();
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Código Barra", "C/Unidad", "", "Suministro o Dispotivo Médicos", "", "Principio Activo", "", "", "", "", "", "", "", "Laboratorio", "", "", "", "", "Activo", "Activo HC", "", "", "", "", "", "", "", "", "S"}) { // from class: Inventarios.JIFISuministroxLote.10
            Class[] types = {Long.class, String.class, Long.class, String.class, String.class, Boolean.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class, Double.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(18).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(18).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(21).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(21).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(22).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(22).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(23).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(23).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(23).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(24).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(24).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(24).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(25).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(25).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(25).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(26).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(26).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(26).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(27).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(27).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(27).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(28).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(28).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(28).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(29).setPreferredWidth(5);
    }

    private void mCargarDatosTabla(String xsql) {
        try {
            mCrearModeloDatos();
            ResultSet xrs = this.xconsulta.traerRs(xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(3)), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(6)), n, 5);
                    this.xmodelo.setValueAt(xrs.getString(7), n, 6);
                    this.xmodelo.setValueAt(xrs.getString(8), n, 7);
                    this.xmodelo.setValueAt(xrs.getString(9), n, 8);
                    this.xmodelo.setValueAt(xrs.getString(10), n, 9);
                    this.xmodelo.setValueAt(xrs.getString(11), n, 10);
                    this.xmodelo.setValueAt(xrs.getString(12), n, 11);
                    this.xmodelo.setValueAt(xrs.getString(13), n, 12);
                    this.xmodelo.setValueAt(xrs.getString(14), n, 13);
                    this.xmodelo.setValueAt(xrs.getString(15), n, 14);
                    this.xmodelo.setValueAt(xrs.getString(16), n, 15);
                    this.xmodelo.setValueAt(xrs.getString(17), n, 16);
                    this.xmodelo.setValueAt(xrs.getString(18), n, 17);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(19)), n, 18);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(20)), n, 19);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(21)), n, 20);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(22)), n, 21);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(23)), n, 22);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(24)), n, 23);
                    this.xmodelo.setValueAt(xrs.getString(25), n, 24);
                    this.xmodelo.setValueAt(xrs.getString(26), n, 25);
                    this.xmodelo.setValueAt(xrs.getString(27), n, 26);
                    this.xmodelo.setValueAt(xrs.getString(28), n, 27);
                    this.xmodelo.setValueAt(xrs.getString(29), n, 28);
                    this.xmodelo.setValueAt(xrs.getString(30), n, 29);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFSubGrupoFactur.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosIniciales() {
        String xsql = "SELECT i_suministroxbodega.Id, i_suministro.CodBarraUnidad, i_suministro.CantidadUnidad, i_suministro.CodBarraEmbalaje, i_suministro.Nbre, i_suministro.CajaCompleta, i_principioactivo.Nbre, i_unidadmedida.Nbre\t , i_presentacionfarmaceutica.Nbre, i_viaadministracion.Nbre, i_presentacioncomercial.Nbre, i_concentracion.Nbre, i_clasificacion.Nbre, i_suministro.RegistroInvima, i_laboratorio.Nbre\t, i_tipoproducto.Nbre , i_categoria.Nbre, i_prioridades.Nbre, i_suministro.Pos, i_suministro.EstaActivo, i_suministro.ActivoHc, i_suministro.EsMaterial, i_suministro.Escobrable, i_suministro.Iva, i_suministro.Indicaciones, i_suministro.ContraIndicaciones , i_suministro.Interacciones, IF(i_suministro.CodigoCUM IS NULL, '',i_suministro.CodigoCUM)  AS CodigoCum, IF(i_suministro.DLogo IS NULL, '',i_suministro.DLogo)  AS Logo ,i_suministroxbodega.Id FROM i_suministro INNER JOIN i_principioactivo  ON (i_suministro.IdPrincipioActivo = i_principioactivo.Id) INNER JOIN i_unidadmedida  ON (i_suministro.IdUnidadMedida = i_unidadmedida.Id) INNER JOIN i_presentacionfarmaceutica  ON (i_suministro.IdPresentacionFarmaceutica = i_presentacionfarmaceutica.Id) INNER JOIN i_viaadministracion  ON (i_suministro.IdViaAdministracion = i_viaadministracion.Id) INNER JOIN i_presentacioncomercial  ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_concentracion  ON (i_suministro.IdConcentracion = i_concentracion.Id) INNER JOIN i_clasificacion  ON (i_suministro.IdClasificacion = i_clasificacion.Id) INNER JOIN i_laboratorio  ON (i_suministro.IdLaboratorio = i_laboratorio.Id) INNER JOIN i_tipoproducto  ON (i_suministro.IdTipoProducto = i_tipoproducto.Id) INNER JOIN i_categoria  ON (i_suministro.IdCategoria = i_categoria.Id) INNER JOIN i_prioridades   ON (i_suministro.IdPrioridad = i_prioridades.Id) INNER JOIN `i_suministroxbodega` ON (i_suministro.`Id`= i_suministroxbodega.`IdSuministro`) WHERE `i_suministroxbodega`.`IdBodega`= '" + Principal.xClaseInventario.getIdBodega() + "' ORDER BY i_suministro.Nbre ASC, i_presentacionfarmaceutica.Nbre ASC ";
        mCargarDatosTabla(xsql);
    }

    private void mCargarDatosxCodigoBarra() {
        if (!this.JTFCodigoBarra.getText().isEmpty()) {
            String xsql = "SELECT i_suministroxbodega.Id, i_suministro.CodBarraUnidad, i_suministro.CantidadUnidad, i_suministro.CodBarraEmbalaje, i_suministro.Nbre, i_suministro.CajaCompleta, i_principioactivo.Nbre, i_unidadmedida.Nbre\t , i_presentacionfarmaceutica.Nbre, i_viaadministracion.Nbre, i_presentacioncomercial.Nbre, i_concentracion.Nbre, i_clasificacion.Nbre, i_suministro.RegistroInvima, i_laboratorio.Nbre\t, i_tipoproducto.Nbre , i_categoria.Nbre, i_prioridades.Nbre, i_suministro.Pos, i_suministro.EstaActivo, i_suministro.ActivoHc, i_suministro.EsMaterial, i_suministro.Escobrable, i_suministro.Iva, i_suministro.Indicaciones, i_suministro.ContraIndicaciones , i_suministro.Interacciones, IF(i_suministro.CodigoCUM IS NULL, '',i_suministro.CodigoCUM)  AS CodigoCum, IF(i_suministro.DLogo IS NULL, '',i_suministro.DLogo)  AS Logo FROM i_suministro INNER JOIN i_principioactivo  ON (i_suministro.IdPrincipioActivo = i_principioactivo.Id) INNER JOIN i_unidadmedida  ON (i_suministro.IdUnidadMedida = i_unidadmedida.Id) INNER JOIN i_presentacionfarmaceutica  ON (i_suministro.IdPresentacionFarmaceutica = i_presentacionfarmaceutica.Id) INNER JOIN i_viaadministracion  ON (i_suministro.IdViaAdministracion = i_viaadministracion.Id) INNER JOIN i_presentacioncomercial  ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_concentracion  ON (i_suministro.IdConcentracion = i_concentracion.Id) INNER JOIN i_clasificacion  ON (i_suministro.IdClasificacion = i_clasificacion.Id) INNER JOIN i_laboratorio  ON (i_suministro.IdLaboratorio = i_laboratorio.Id) INNER JOIN i_tipoproducto  ON (i_suministro.IdTipoProducto = i_tipoproducto.Id) INNER JOIN i_categoria  ON (i_suministro.IdCategoria = i_categoria.Id) INNER JOIN i_prioridades  ON (i_suministro.IdPrioridad = i_prioridades.Id) INNER JOIN `i_suministroxbodega` ON (i_suministro.`Id`= i_suministroxbodega.`IdSuministro`) WHERE `i_suministroxbodega`.`IdBodega`= '" + Principal.xClaseInventario.getIdBodega() + "' and i_suministro.CodBarraUnidad= '" + this.JTFCodigoBarra.getText() + "' ORDER BY i_suministro.Nbre ASC, i_presentacionfarmaceutica.Nbre ASC ";
            mCargarDatosTabla(xsql);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosSB() {
        this.xmodelosb = new DefaultTableModel(new Object[0], new String[]{"Id", "Lote", "Fecha Vencimiento", "Cantidad", "CPendiente"}) { // from class: Inventarios.JIFISuministroxLote.11
            Class[] types = {Long.class, String.class, String.class, Long.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleSB.setModel(this.xmodelosb);
        this.JTDetalleSB.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalleSB.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalleSB.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTDetalleSB.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalleSB.getColumnModel().getColumn(4).setPreferredWidth(50);
    }

    private void mCargarDatosTablaSB() {
        try {
            mCrearModeloDatosSB();
            String sql = "SELECT i_suministroxlotexbodega.Id, i_suministroxlotexbodega.Lote, Date_Format(i_suministroxlotexbodega.FechaVencimiento,'%d/%m/%Y') as Fecha, i_suministroxlotexbodega.Cantidad, i_suministroxlotexbodega.CPendiente FROM i_suministroxlotexbodega INNER JOIN i_suministroxbodega  ON (i_suministroxlotexbodega.Id = i_suministroxbodega.Id) WHERE (i_suministroxlotexbodega.Id ='" + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString() + "') ORDER BY i_suministroxlotexbodega.Cantidad DESC, i_suministroxlotexbodega.FechaVencimiento DESC ";
            ResultSet xrs = this.xconsulta.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelosb.addRow(this.xdatos);
                    this.xmodelosb.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelosb.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelosb.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelosb.setValueAt(Long.valueOf(xrs.getLong(4)), n, 3);
                    this.xmodelosb.setValueAt(Long.valueOf(xrs.getLong(5)), n, 4);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGenerico2Text1CheckBox1.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
