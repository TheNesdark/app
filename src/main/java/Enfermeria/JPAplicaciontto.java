package Enfermeria;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.controller.historia.dto.OrdenamientoMedico;
import com.genoma.plus.dao.enfermeria.AplicacionTratamientoDAO;
import com.genoma.plus.dao.impl.enfermeria.AplicacionTratamientoDAOImpl;
import com.genoma.plus.jpa.entities.LiquidacionEntity;
import com.genoma.plus.jpa.service.ILiquidacionService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:Enfermeria/JPAplicaciontto.class */
public class JPAplicaciontto extends JPanel {
    private String xsql;
    private String xidAtencion;
    private String idIngreso;
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private Object[] xdato;
    private int xId_Tipo;
    private String[] xidcentrocosto;
    private String[] xidservicio;
    private AplicacionTratamientoDAO aplicacionTratamientoDAO;
    private OrdenamientoMedico ordenamientoMedico;
    public JButton JBTAdicionarI;
    public JButton JBTSolicitar_SF;
    private JComboBox JCBCentroCosto;
    private JComboBox JCBTipoServicio;
    private JCheckBox JCHCerrarU;
    private JCheckBox JCH_Cerrado;
    private JCheckBox JCH_Solicitado;
    private JDateChooser JDCFecha;
    private JPanel JPIAplicacion;
    private JPanel JPIDARegistro;
    private JPanel JPIOrdenes;
    private JScrollPane JSPDAObservacionG;
    private JScrollPane JSPDARehistro;
    private JScrollPane JSPDOrdenes;
    private JTextArea JTADAObservacionG;
    private JTable JTDARehistro;
    private JTable JTDOrdenes;
    private JTextField JTFDANRegistro;
    private JFormattedTextField JTFFHora;
    private JTabbedPane JTPDAplicacion;
    private JTabbedPane JTPDatos;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private final ILiquidacionService liquidacionService = (ILiquidacionService) Principal.contexto.getBean(ILiquidacionService.class);

    public JPAplicaciontto(int xId_Tipo, String xidAtencion, String idIngreso) {
        initComponents();
        this.xId_Tipo = xId_Tipo;
        this.xidAtencion = xidAtencion;
        this.idIngreso = idIngreso;
        this.ordenamientoMedico = OrdenamientoMedico.builder().build();
        springStart();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v54, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JTPDatos = new JTabbedPane();
        this.JPIAplicacion = new JPanel();
        this.JTPDAplicacion = new JTabbedPane();
        this.JPIDARegistro = new JPanel();
        this.JSPDARehistro = new JScrollPane();
        this.JTDARehistro = new JTable();
        this.JSPDAObservacionG = new JScrollPane();
        this.JTADAObservacionG = new JTextArea();
        this.JTFDANRegistro = new JTextField();
        this.JDCFecha = new JDateChooser();
        this.JTFFHora = new JFormattedTextField();
        this.JCHCerrarU = new JCheckBox();
        this.JCBTipoServicio = new JComboBox();
        this.JCBCentroCosto = new JComboBox();
        this.JPIOrdenes = new JPanel();
        this.JSPDOrdenes = new JScrollPane();
        this.JTDOrdenes = new JTable();
        this.JBTAdicionarI = new JButton();
        this.JBTSolicitar_SF = new JButton();
        this.JCH_Cerrado = new JCheckBox();
        this.JCH_Solicitado = new JCheckBox();
        setBorder(BorderFactory.createTitledBorder((Border) null, "ADMINISTRACIÓN DE TRATAMIENTO", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        setMaximumSize(new Dimension(846, 499));
        setMinimumSize(new Dimension(846, 499));
        setName("xjpaplicaciontto");
        this.JTPDatos.setForeground(new Color(0, 103, 0));
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JTPDAplicacion.setForeground(new Color(255, 0, 0));
        this.JTPDAplicacion.setFont(new Font("Arial", 1, 14));
        this.JTDARehistro.setFont(new Font("Arial", 1, 12));
        this.JTDARehistro.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDARehistro.setRowHeight(25);
        this.JTDARehistro.setSelectionBackground(new Color(255, 255, 255));
        this.JTDARehistro.setSelectionForeground(new Color(255, 0, 0));
        this.JTDARehistro.setSelectionMode(0);
        this.JSPDARehistro.setViewportView(this.JTDARehistro);
        this.JSPDAObservacionG.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación General", 1, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTADAObservacionG.setColumns(20);
        this.JTADAObservacionG.setFont(new Font("Arial", 1, 14));
        this.JTADAObservacionG.setLineWrap(true);
        this.JTADAObservacionG.setRows(1);
        this.JTADAObservacionG.setTabSize(1);
        this.JTADAObservacionG.setBorder((Border) null);
        this.JSPDAObservacionG.setViewportView(this.JTADAObservacionG);
        this.JTFDANRegistro.setEditable(false);
        this.JTFDANRegistro.setBackground(new Color(255, 255, 255));
        this.JTFDANRegistro.setFont(new Font("Arial", 1, 24));
        this.JTFDANRegistro.setHorizontalAlignment(0);
        this.JTFDANRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "N°", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFDANRegistro.setFocusable(false);
        this.JDCFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFecha.setDateFormatString("dd/MM/yyyy");
        this.JDCFecha.setFont(new Font("Arial", 1, 12));
        this.JTFFHora.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora", 0, 0, new Font("Arial", 1, 12), Color.blue));
        try {
            this.JTFFHora.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##:##:##")));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        this.JTFFHora.setHorizontalAlignment(4);
        this.JTFFHora.setToolTipText("Formato 24 horas (HH:mm:ss)");
        this.JTFFHora.setFont(new Font("Arial", 1, 12));
        this.JCHCerrarU.setFont(new Font("Arial", 1, 12));
        this.JCHCerrarU.setForeground(new Color(255, 0, 0));
        this.JCHCerrarU.setText("Cerrar Unidosis?");
        this.JCHCerrarU.addActionListener(new ActionListener() { // from class: Enfermeria.JPAplicaciontto.1
            public void actionPerformed(ActionEvent evt) {
                JPAplicaciontto.this.JCHCerrarUActionPerformed(evt);
            }
        });
        this.JCBTipoServicio.setFont(new Font("Arial", 1, 12));
        this.JCBTipoServicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Servicio", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBCentroCosto.setFont(new Font("Arial", 1, 12));
        this.JCBCentroCosto.setBorder(BorderFactory.createTitledBorder((Border) null, "Centro de Costo", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        GroupLayout JPIDARegistroLayout = new GroupLayout(this.JPIDARegistro);
        this.JPIDARegistro.setLayout(JPIDARegistroLayout);
        JPIDARegistroLayout.setHorizontalGroup(JPIDARegistroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDARegistroLayout.createSequentialGroup().addContainerGap().addGroup(JPIDARegistroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDARehistro).addGroup(JPIDARegistroLayout.createSequentialGroup().addGroup(JPIDARegistroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDARegistroLayout.createSequentialGroup().addComponent(this.JSPDAObservacionG, -2, 442, -2).addGap(18, 18, 18).addComponent(this.JTFDANRegistro, -2, 155, -2).addGap(27, 27, 27).addComponent(this.JCHCerrarU)).addGroup(JPIDARegistroLayout.createSequentialGroup().addComponent(this.JDCFecha, -2, 128, -2).addGap(18, 18, 18).addComponent(this.JTFFHora, -2, 128, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBTipoServicio, -2, 184, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBCentroCosto, -2, 281, -2))).addGap(0, 0, 32767))).addContainerGap()));
        JPIDARegistroLayout.setVerticalGroup(JPIDARegistroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDARegistroLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDARehistro, -2, 222, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDARegistroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDCFecha, -2, 50, -2).addGroup(JPIDARegistroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFHora, -2, 50, -2).addComponent(this.JCBTipoServicio, -2, 50, -2).addComponent(this.JCBCentroCosto, -2, 50, -2))).addGap(18, 18, 18).addGroup(JPIDARegistroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDARegistroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFDANRegistro, -2, 50, -2).addComponent(this.JCHCerrarU)).addComponent(this.JSPDAObservacionG, -2, 50, -2)).addContainerGap(14, 32767)));
        this.JTPDAplicacion.addTab("DETALLE", this.JPIDARegistro);
        GroupLayout JPIAplicacionLayout = new GroupLayout(this.JPIAplicacion);
        this.JPIAplicacion.setLayout(JPIAplicacionLayout);
        JPIAplicacionLayout.setHorizontalGroup(JPIAplicacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAplicacionLayout.createSequentialGroup().addContainerGap().addComponent(this.JTPDAplicacion).addContainerGap()));
        JPIAplicacionLayout.setVerticalGroup(JPIAplicacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIAplicacionLayout.createSequentialGroup().addComponent(this.JTPDAplicacion).addContainerGap()));
        this.JTPDatos.addTab("APLICACIÓN", this.JPIAplicacion);
        this.JSPDOrdenes.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTDOrdenes.setFont(new Font("Arial", 1, 12));
        this.JTDOrdenes.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDOrdenes.setRowHeight(25);
        this.JTDOrdenes.setSelectionBackground(new Color(255, 255, 255));
        this.JTDOrdenes.setSelectionForeground(new Color(255, 0, 0));
        this.JTDOrdenes.setSelectionMode(0);
        this.JTDOrdenes.addMouseListener(new MouseAdapter() { // from class: Enfermeria.JPAplicaciontto.2
            public void mouseClicked(MouseEvent evt) {
                JPAplicaciontto.this.JTDOrdenesMouseClicked(evt);
            }
        });
        this.JSPDOrdenes.setViewportView(this.JTDOrdenes);
        this.JBTAdicionarI.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionarI.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.JBTAdicionarI.setText("Adicionar Insumo /Dispositvo Médico");
        this.JBTAdicionarI.addActionListener(new ActionListener() { // from class: Enfermeria.JPAplicaciontto.3
            public void actionPerformed(ActionEvent evt) {
                JPAplicaciontto.this.JBTAdicionarIActionPerformed(evt);
            }
        });
        this.JBTSolicitar_SF.setFont(new Font("Arial", 1, 12));
        this.JBTSolicitar_SF.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTSolicitar_SF.setText("Solicitar Servicio Farmacéutico");
        this.JBTSolicitar_SF.addActionListener(new ActionListener() { // from class: Enfermeria.JPAplicaciontto.4
            public void actionPerformed(ActionEvent evt) {
                JPAplicaciontto.this.JBTSolicitar_SFActionPerformed(evt);
            }
        });
        this.JCH_Cerrado.setBackground(new Color(177, 251, 177));
        this.JCH_Cerrado.setFont(new Font("Arial", 1, 12));
        this.JCH_Cerrado.setText("Cerrado");
        this.JCH_Solicitado.setBackground(Color.red);
        this.JCH_Solicitado.setFont(new Font("Arial", 1, 12));
        this.JCH_Solicitado.setText("Solicitado");
        GroupLayout JPIOrdenesLayout = new GroupLayout(this.JPIOrdenes);
        this.JPIOrdenes.setLayout(JPIOrdenesLayout);
        JPIOrdenesLayout.setHorizontalGroup(JPIOrdenesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIOrdenesLayout.createSequentialGroup().addContainerGap().addComponent(this.JCH_Cerrado).addGap(18, 18, 18).addComponent(this.JCH_Solicitado).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 72, 32767).addComponent(this.JBTAdicionarI, -2, 285, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTSolicitar_SF, -2, 256, -2).addContainerGap()).addGroup(JPIOrdenesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIOrdenesLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDOrdenes, -1, 789, 32767).addContainerGap())));
        JPIOrdenesLayout.setVerticalGroup(JPIOrdenesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIOrdenesLayout.createSequentialGroup().addContainerGap(365, 32767).addGroup(JPIOrdenesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTAdicionarI, -2, 44, -2).addComponent(this.JBTSolicitar_SF, -2, 44, -2).addComponent(this.JCH_Cerrado).addComponent(this.JCH_Solicitado)).addContainerGap()).addGroup(JPIOrdenesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIOrdenesLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDOrdenes, -1, 340, 32767).addGap(69, 69, 69))));
        this.JTPDatos.addTab("ORDENES", this.JPIOrdenes);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDOrdenesMouseClicked(MouseEvent evt) {
        if (this.JTDOrdenes.getSelectedRow() != -1) {
            Object[] botones = {"Cargar Detalle", "Visualizar", "Abrir Unidosis", "Cerrar Unidosis", "Cerrar"};
            int y = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "SELECCIONAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
            switch (y) {
                case 0:
                    if (!Boolean.parseBoolean(this.xmodelo.getValueAt(this.JTDOrdenes.getSelectedRow(), 5).toString())) {
                        cargarDetalleAplicacionTratamiento();
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Unidosis ya cerrada", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    }
                    break;
                case 1:
                    mImprimir();
                    break;
                case 2:
                    cerrarUnidosis(0);
                    break;
                case 3:
                    cerrarUnidosis(1);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarIActionPerformed(ActionEvent evt) {
        if (this.JTDOrdenes.getSelectedRow() != -1) {
            JDBuscarInsumo xjdbinsumo = new JDBuscarInsumo(Principal.claseenfer.xjp, true, this.JTDOrdenes.getValueAt(this.JTDOrdenes.getSelectedRow(), 0).toString());
            xjdbinsumo.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
            xjdbinsumo.setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTSolicitar_SFActionPerformed(ActionEvent evt) {
        if (this.JTDOrdenes.getSelectedRow() != -1 && Long.parseLong(this.xmodelo.getValueAt(this.JTDOrdenes.getSelectedRow(), 4).toString()) == 0) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de solicitar unidosis?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.xsql = "update h_ordenes_unidosis set Solicitado=1, Fecha_S='" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "' where Id='" + this.xmodelo.getValueAt(this.JTDOrdenes.getSelectedRow(), 0) + "' and Solicitado=0";
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHCerrarUActionPerformed(ActionEvent evt) {
        for (int i = 0; i < this.JTDARehistro.getRowCount(); i++) {
            this.xmodelo1.setValueAt(Boolean.valueOf(this.JCHCerrarU.isSelected()), i, 6);
        }
    }

    private void springStart() {
        this.aplicacionTratamientoDAO = (AplicacionTratamientoDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("aplicacionTratamientoDAOImpl");
    }

    public void mNuevo() {
        this.JDCFecha.setDate(this.xmt.getFechaActual());
        this.JTFFHora.setText(this.xmt.formatoH24.format(this.xmt.getFechaActual()));
        this.JTFDANRegistro.setText("");
        this.JTADAObservacionG.setText("");
        this.xsql = "SELECT\n    `f_tiposervicio`.`Id`\n    , `f_tiposervicio`.`Nbre`\nFROM\n    `f_tiposervtipoproced`\n    INNER JOIN `f_tiposervicio` \n        ON (`f_tiposervtipoproced`.`Idtiposervicio` = `f_tiposervicio`.`Id`)\n    INNER JOIN `f_tipoprocedimiento` \n        ON (`f_tiposervtipoproced`.`Idtipoprocedimiento` = `f_tipoprocedimiento`.`Id`)\n    INNER JOIN `f_tipoclaseproc` \n        ON (`f_tipoprocedimiento`.`Id_tipoclaseproc` = `f_tipoclaseproc`.`Id`)\nWHERE (`f_tipoclaseproc`.`Id` =3)\nORDER BY `f_tiposervicio`.`Nbre` ASC";
        this.xidservicio = this.xct.llenarCombo(this.xsql, this.xidservicio, this.JCBTipoServicio);
        if (this.xidservicio.length > 1) {
            this.JCBTipoServicio.setSelectedIndex(-1);
        }
        this.xct.cerrarConexionBd();
        this.xsql = "SELECT Id, Nbre as Centro_Costo FROM f_centrocosto WHERE (Estado =0) ORDER BY Nbre ASC";
        this.xidcentrocosto = this.xct.llenarCombo(this.xsql, this.xidcentrocosto, this.JCBCentroCosto);
        if (this.xidcentrocosto.length > 1) {
            this.JCBCentroCosto.setSelectedIndex(-1);
        }
        this.xct.cerrarConexionBd();
        cargarOrdenUnidosis();
        mCrearTablaATto();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaOrdenTto() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha y Hora", "Especialidad", "Profesional", "NSalida", "Estado", "Tipo Atención", "Solicitado"}) { // from class: Enfermeria.JPAplicaciontto.5
            Class[] types = {Long.class, String.class, String.class, String.class, Long.class, Boolean.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDOrdenes;
        JTable jTable2 = this.JTDOrdenes;
        jTable.setAutoResizeMode(0);
        this.JTDOrdenes.doLayout();
        this.JTDOrdenes.setModel(this.xmodelo);
        this.JTDOrdenes.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDOrdenes.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDOrdenes.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDOrdenes.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTDOrdenes.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTDOrdenes.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTDOrdenes.getColumnModel().getColumn(6).setPreferredWidth(200);
        this.JTDOrdenes.getColumnModel().getColumn(7).setPreferredWidth(50);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaATto() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"Id", "Medicamento/Dispositivo Medico", "Forma Aplicación", "Cant.", "Observación", "Aplicado?", "Cerrar?", "Id_Detalle", "Duración"}) { // from class: Enfermeria.JPAplicaciontto.6
            Class[] types = {Long.class, String.class, String.class, Double.class, String.class, Boolean.class, Boolean.class, Long.class, Integer.class};
            boolean[] canEdit = {false, false, false, true, true, true, true, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDARehistro.setModel(this.xmodelo1);
        this.JTDARehistro.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDARehistro.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDARehistro.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDARehistro.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDARehistro.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDARehistro.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTDARehistro.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDARehistro.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTDARehistro.getColumnModel().getColumn(6).setPreferredWidth(10);
        this.JTDARehistro.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTDARehistro.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTDARehistro.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTDARehistro.getColumnModel().getColumn(8).setPreferredWidth(10);
    }

    /* JADX WARN: Finally extract failed */
    public void mCargarDatosOrdenTto() {
        try {
            mCrearTablaOrdenTto();
            this.xsql = "SELECT `h_ordenes_unidosis`.`Id` \n, `h_ordenes_unidosis`.`Fecha` \n, ge.Nbre  `Especialidad` \n, concat(gp.Apellido1,' ', gp.Apellido2,' ', gp.Nombre1,' ', gp.Nombre2) `NProfesional` ,\n`h_ordenes_unidosis_detalle`.`Id_Salida`\n, `h_ordenes_unidosis`.`Finalizado`,\ngt.Nbre AS `TATencion`,\nh_ordenes_unidosis.Solicitado \nFROM h_ordenes_unidosis \nINNER JOIN `h_ordenes_unidosis_detalle`  ON (`h_ordenes_unidosis_detalle`.`Id_Ordenes` = `h_ordenes_unidosis`.`Id`) \ninner join g_especialidad ge on (ge.Id=h_ordenes_unidosis.Id_Especialidad)\ninner join g_persona gp on (gp.Id=h_ordenes_unidosis.Id_Profesional)\ninner join g_tipoatencion gt on (gt.Id=h_ordenes_unidosis.Tipo)\nWHERE ( `h_ordenes_unidosis`.`Estado` =1 \nAND `h_ordenes_unidosis`.`Id_Atencion` =" + this.xidAtencion + ") \nGROUP BY `h_ordenes_unidosis`.`Id` ORDER BY `h_ordenes_unidosis`.`Fecha` DESC ";
            System.out.println(this.xsql);
            ResultSet xrs = this.xct.traerRs(this.xsql);
            Throwable th = null;
            try {
                if (xrs.next()) {
                    int xfila = 0;
                    xrs.beforeFirst();
                    while (xrs.next()) {
                        this.xmodelo.addRow(this.xdato);
                        this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), xfila, 0);
                        this.xmodelo.setValueAt(xrs.getString(2), xfila, 1);
                        this.xmodelo.setValueAt(xrs.getString(3), xfila, 2);
                        this.xmodelo.setValueAt(xrs.getString(4), xfila, 3);
                        this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(5)), xfila, 4);
                        this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(6)), xfila, 5);
                        this.xmodelo.setValueAt(xrs.getString(7), xfila, 6);
                        this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean("Solicitado")), xfila, 7);
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
            } catch (Throwable th3) {
                if (xrs != null) {
                    if (0 != 0) {
                        try {
                            xrs.close();
                        } catch (Throwable th4) {
                            th.addSuppressed(th4);
                        }
                    } else {
                        xrs.close();
                    }
                }
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JPAplicaciontto.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void cargarOrdenUnidosis() {
        mCrearTablaOrdenTto();
        List<Object[]> detalleOrdenUnidosis = this.aplicacionTratamientoDAO.ordenUnidosisPacienteIdAtencion(this.xidAtencion);
        if (!detalleOrdenUnidosis.isEmpty()) {
            for (int i = 0; i < detalleOrdenUnidosis.size(); i++) {
                this.xmodelo.addRow(this.xdato);
                this.xmodelo.setValueAt(detalleOrdenUnidosis.get(i)[0], i, 0);
                this.xmodelo.setValueAt(detalleOrdenUnidosis.get(i)[1], i, 1);
                this.xmodelo.setValueAt(detalleOrdenUnidosis.get(i)[2], i, 2);
                this.xmodelo.setValueAt(detalleOrdenUnidosis.get(i)[3], i, 3);
                this.xmodelo.setValueAt(detalleOrdenUnidosis.get(i)[4], i, 4);
                this.xmodelo.setValueAt(detalleOrdenUnidosis.get(i)[5], i, 5);
                this.xmodelo.setValueAt(detalleOrdenUnidosis.get(i)[6], i, 6);
                this.xmodelo.setValueAt(detalleOrdenUnidosis.get(i)[7], i, 7);
                this.JTDOrdenes.setDefaultRenderer(Object.class, new MiRender());
            }
        }
    }

    private void cargarDetalleAplicacionTratamiento() {
        mCrearTablaATto();
        List<Object[]> detalleUnidosis = this.aplicacionTratamientoDAO.detalleUnidosisAplicar(this.xmodelo.getValueAt(this.JTDOrdenes.getSelectedRow(), 0).toString());
        if (!detalleUnidosis.isEmpty()) {
            this.xmt.mEstablecerTextEditor(this.JTDARehistro, 1);
            this.xmt.mEstablecerTextEditor(this.JTDARehistro, 2);
            this.xmt.mEstablecerTextEditor(this.JTDARehistro, 4);
            for (int i = 0; i < detalleUnidosis.size(); i++) {
                this.xmodelo1.addRow(this.xdato);
                this.xmodelo1.setValueAt(detalleUnidosis.get(i)[0], i, 0);
                this.xmodelo1.setValueAt(detalleUnidosis.get(i)[1], i, 1);
                this.xmodelo1.setValueAt(detalleUnidosis.get(i)[2], i, 2);
                this.xmodelo1.setValueAt(detalleUnidosis.get(i)[3], i, 3);
                this.xmodelo1.setValueAt(detalleUnidosis.get(i)[6], i, 4);
                this.xmodelo1.setValueAt(false, i, 5);
                this.xmodelo1.setValueAt(false, i, 6);
                this.xmodelo1.setValueAt(detalleUnidosis.get(i)[5], i, 7);
                this.xmodelo1.setValueAt(detalleUnidosis.get(i)[7], i, 8);
                detalleUnidosis.get(i);
            }
            if (!Principal.informacionIps.getIdentificacion().equals("812005644")) {
                this.ordenamientoMedico = this.xmt.getFindByOrdanimientoMedicoIdAtencionIdOrdenHc(Long.valueOf(this.xidAtencion), Long.valueOf(this.JTDOrdenes.getValueAt(this.JTDOrdenes.getSelectedRow(), 0).toString()));
            }
            this.JTPDatos.setSelectedIndex(0);
        }
    }

    /* JADX WARN: Finally extract failed */
    public void mCargarDatosAplicacionTto() {
        try {
            mCrearTablaATto();
            this.xsql = "SELECT `i_suministro`.`Id` , CONCAT(`i_suministro`.`Nbre`,' ', `i_presentacionfarmaceutica`.`Nbre`) AS `NSuministro` \n   , CONCAT(`h_ordenes_unidosis_detalle`.`Dosis` ,' ', `h_ordenes_unidosis_detalle`.`Frecuencia`, ' ',`h_ordenes_unidosis_detalle`.`Observacion`) AS `FAplicacion`\n   ,     `h_ordenes_unidosis_detalle`.Cantidad,`h_ordenes_unidosis`.`Id` AS id_unidosis\n   , (`h_ordenes_unidosis_detalle`.Cantidad- IFNULL(d.SCantidad,0)) AS Ct\n,  `h_ordenes_unidosis_detalle`.Id AS Id_Detalle, IF(`i_presentacionfarmaceutica`.Facturable=0, `i_presentacionfarmaceutica`.Dosis, '') AS Dosis, h_ordenes_unidosis_detalle.DuracionD \nFROM\n     `h_ordenes_unidosis_detalle`\n    INNER JOIN  `h_ordenes_unidosis` \n        ON (`h_ordenes_unidosis_detalle`.`Id_Ordenes` = `h_ordenes_unidosis`.`Id`)\n    INNER JOIN  `i_suministro` \n        ON (`h_ordenes_unidosis_detalle`.`Id_Suministro` = `i_suministro`.`Id`)\n    INNER JOIN  `i_presentacionfarmaceutica` \n        ON (`i_suministro`.`IdPresentacionFarmaceutica` = `i_presentacionfarmaceutica`.`Id`)\n    INNER JOIN  `i_tipoproducto` \n        ON (`i_suministro`.`IdTipoProducto` = `i_tipoproducto`.`Id`)\n    LEFT JOIN (SELECT\n    `h_ordenes_unidosis_aplicacion`.`Id_Unidosis`\n    , `h_ordenes_unidosis_aplicacion_detalle`.`Id_Suministro`\n    , SUM(`h_ordenes_unidosis_aplicacion_detalle`.`Cantidad`) AS `SCantidad`\n    \nFROM\n     `h_ordenes_unidosis_aplicacion_detalle`\n    INNER JOIN  `h_ordenes_unidosis_aplicacion` \n        ON (`h_ordenes_unidosis_aplicacion_detalle`.`Id_Ordenes_Aplicacion` = `h_ordenes_unidosis_aplicacion`.`Id`)\nWHERE (`h_ordenes_unidosis_aplicacion`.`Estado` =1\n    AND `h_ordenes_unidosis_aplicacion_detalle`.`Estado` =1)\nGROUP BY `h_ordenes_unidosis_aplicacion`.`Id_Unidosis`, `h_ordenes_unidosis_aplicacion_detalle`.`Id_Suministro`) d ON (d.Id_Unidosis=h_ordenes_unidosis.`Id`) AND (d.Id_Suministro=i_suministro.`Id`)    \nWHERE (`h_ordenes_unidosis`.`Id` ='" + this.xmodelo.getValueAt(this.JTDOrdenes.getSelectedRow(), 0) + "'\n    AND `h_ordenes_unidosis_detalle`.`Cerrada` =0\n    AND `h_ordenes_unidosis`.`Estado` =1)\n     ORDER BY `i_tipoproducto`.`Nbre` ASC, `NSuministro` ASC";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            Throwable th = null;
            try {
                if (xrs.next()) {
                    int xfila = 0;
                    xrs.beforeFirst();
                    this.xmt.mEstablecerTextEditor(this.JTDARehistro, 1);
                    this.xmt.mEstablecerTextEditor(this.JTDARehistro, 2);
                    this.xmt.mEstablecerTextEditor(this.JTDARehistro, 4);
                    while (xrs.next()) {
                        this.xmodelo1.addRow(this.xdato);
                        this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(1)), xfila, 0);
                        this.xmodelo1.setValueAt(xrs.getString(2), xfila, 1);
                        this.xmodelo1.setValueAt(xrs.getString(3), xfila, 2);
                        this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong("Ct")), xfila, 3);
                        this.xmodelo1.setValueAt(xrs.getString("Dosis"), xfila, 4);
                        this.xmodelo1.setValueAt(false, xfila, 5);
                        this.xmodelo1.setValueAt(false, xfila, 6);
                        this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong("Id_Detalle")), xfila, 7);
                        this.xmodelo1.setValueAt(Integer.valueOf(xrs.getInt("DuracionD")), xfila, 8);
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
            } catch (Throwable th3) {
                if (xrs != null) {
                    if (0 != 0) {
                        try {
                            xrs.close();
                        } catch (Throwable th4) {
                            th.addSuppressed(th4);
                        }
                    } else {
                        xrs.close();
                    }
                }
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JPAplicaciontto.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Enfermeria/JPAplicaciontto$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (Boolean.parseBoolean(table.getValueAt(row, 5).toString())) {
                cell.setBackground(new Color(177, 251, 177));
                cell.setForeground(Color.BLACK);
            } else if (Boolean.parseBoolean(table.getValueAt(row, 7).toString())) {
                cell.setBackground(Color.RED);
                cell.setForeground(Color.BLACK);
            } else {
                cell.setBackground(Color.WHITE);
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }

    public boolean mVerificar_CantidadMCero() {
        boolean estado = false;
        if (this.JTDARehistro.getRowCount() > 0) {
            int i = 0;
            while (true) {
                if (i < this.JTDARehistro.getRowCount()) {
                    if (!this.JTDARehistro.getValueAt(i, 3).toString().equals("0") || !Boolean.valueOf(this.xmodelo1.getValueAt(i, 5).toString()).booleanValue()) {
                        i++;
                    } else {
                        estado = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return estado;
    }

    public void mGrabar() {
        if (this.JTPDatos.getSelectedIndex() == 0) {
            LiquidacionEntity liquidacionEntity = this.liquidacionService.liquidacionPorIdIngresoEstado(Long.valueOf(this.idIngreso));
            if (liquidacionEntity == null) {
                if (this.JTFDANRegistro.getText().isEmpty()) {
                    if (this.xmt.mVerificarDatosTablaTrue(this.JTDARehistro, 5)) {
                        if (!mVerificar_CantidadMCero()) {
                            if (this.JCBTipoServicio.getSelectedIndex() != -1) {
                                if (this.JCBCentroCosto.getSelectedIndex() != -1) {
                                    if (this.JCHCerrarU.isSelected()) {
                                        if (this.xmt.mVerificarDatosTablaTrue(this.JTDARehistro, 5)) {
                                            mGrabar_Bd();
                                            return;
                                        } else {
                                            JOptionPane.showInternalMessageDialog(this, "Debe aplicar por lo menos un medicamento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                            return;
                                        }
                                    }
                                    mGrabar_Bd();
                                    return;
                                }
                                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un centro de costo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                this.JCBCentroCosto.requestFocus();
                                return;
                            }
                            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un servicio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            this.JCBTipoServicio.requestFocus();
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "No se puede grabar cantida en cero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "No existe registro seleccionado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Registro ya grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFDANRegistro.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>Ingreso ya cerrado por facturación ;</p><font face='Arial' color='red' size=4>No se pueden realizar más registro de cargo.", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    private void mGrabar_Bd() {
        int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (x == 0) {
            this.xsql = "insert into `h_ordenes_unidosis_aplicacion`(`Id_Unidosis` , `Fecha_A` , `Hora` , `Id_Profesional` , `Id_Especialidad` , Id_CCosto, `Observacion` , `UsuarioS` ) values('" + this.xmodelo.getValueAt(this.JTDOrdenes.getSelectedRow(), 0) + "','" + this.xmt.formatoAMD.format(this.JDCFecha.getDate()) + "','" + this.JTFFHora.getText() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + this.xidcentrocosto[this.JCBCentroCosto.getSelectedIndex()] + "','" + this.JTADAObservacionG.getText() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            this.JTFDANRegistro.setText(this.xct.ejecutarSQLId(this.xsql));
            this.xct.cerrarConexionBd();
            for (int y = 0; y < this.JTDARehistro.getRowCount(); y++) {
                if (Boolean.parseBoolean(this.xmodelo1.getValueAt(y, 5).toString())) {
                    this.xsql = "insert into `h_ordenes_unidosis_aplicacion_detalle`(`Id_Ordenes_Aplicacion` , `Id_Suministro` , `Cantidad` , `Observacion` , `UsuarioS` ) values ('" + this.JTFDANRegistro.getText() + "','" + this.xmodelo1.getValueAt(y, 0) + "','" + this.xmodelo1.getValueAt(y, 3) + "','" + this.xmodelo1.getValueAt(y, 4) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                    String codigoTabla = this.JTDARehistro.getValueAt(y, 0).toString();
                    if (!Principal.informacionIps.getIdentificacion().equals("812005644") && this.ordenamientoMedico != null) {
                        System.err.println("this.ordenamientoMedico.getDetalleOrden()" + this.ordenamientoMedico.getDetalleOrden().get(x));
                        this.ordenamientoMedico.getDetalleOrden().forEach(detalleOrden -> {
                            if (detalleOrden.getCodigo().equals(codigoTabla)) {
                                detalleOrden.setEjecutado(true);
                            }
                        });
                    }
                }
                if (Boolean.parseBoolean(this.xmodelo1.getValueAt(y, 6).toString())) {
                    this.xsql = "update  h_ordenes_unidosis_detalle SET Cerrada=1 where `Id` ='" + this.xmodelo1.getValueAt(y, 7) + "'";
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                }
            }
            if (this.JCHCerrarU.isSelected()) {
                cerrarUnidosis(1);
            }
            if ((!Principal.informacionIps.getIdentificacion().equals("812005644") || !Principal.informacionIps.getIdentificacion().equals("812004304")) && this.ordenamientoMedico != null) {
                this.ordenamientoMedico.setCerrada(this.xmt.getVerificarEstadoCerrado(this.JTDARehistro, 6));
                this.xmt.getGrabarOrdenamientoMedico(this.ordenamientoMedico);
            }
            mGrabar_Facturacion(this.JTFDANRegistro.getText());
            cargarOrdenUnidosis();
        }
    }

    public void cerrarUnidosis(int estado) {
        this.xsql = "update  h_ordenes_unidosis_detalle SET Cerrada='" + estado + "' where `Id_Ordenes` ='" + this.xmodelo.getValueAt(this.JTDOrdenes.getSelectedRow(), 0) + "'";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "update h_ordenes_unidosis set Finalizado='" + estado + "' where Id='" + this.xmodelo.getValueAt(this.JTDOrdenes.getSelectedRow(), 0) + "'";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
    }

    public void mImprimir() {
        String[][] mparametros;
        mparametros = new String[5][2];
        mparametros[0][0] = "id";
        mparametros[0][1] = this.xmodelo.getValueAt(this.JTDOrdenes.getSelectedRow(), 0).toString();
        mparametros[1][0] = "nusuarios";
        mparametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
        mparametros[2][0] = "SUBREPORT_DIR";
        mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        mparametros[3][0] = "SUBREPORTFIRMA_DIR";
        mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        mparametros[4][0] = "nbreUsuario";
        mparametros[4][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
        switch (Principal.informacionIps.getNombreIps()) {
            case "CLINICA PAJONAL S.A.S":
            case "E.S.E. HOSPITAL SAN JUAN DE DIOS":
            case "E.S.E. HOSPITAL SAN JORGE DE AYAPEL":
            case "EMPRESA SOCIAL DEL ESTADO CAMU CHIMA":
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "Pajonal_H_ordene_unidosis", mparametros);
                break;
            case "EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO":
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_ordene_unidosis_1", mparametros);
                break;
            default:
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_ordene_unidosis", mparametros);
                break;
        }
    }

    public void imprimirInsumo() {
        Metodos metodos = new Metodos();
        String[][] parametros = new String[5][2];
        parametros[0][0] = "idAtencion";
        parametros[0][1] = this.xidAtencion;
        parametros[1][0] = "nbreUsuario";
        parametros[1][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
        parametros[2][0] = "SUBREPORT_DIR";
        parametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        parametros[3][0] = "SUBREPORTFIRMA_DIR";
        parametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        parametros[4][0] = "nbreUsuario";
        parametros[4][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
        metodos.GenerarPDF(metodos.getRutaRep() + "Pajonal_Hoja_Tratamiento_Insumo", parametros);
    }

    public void mImprimirAplicacionTto() {
        String[][] mparametros = new String[3][2];
        mparametros[0][0] = "idatencion1";
        mparametros[0][1] = this.xidAtencion;
        mparametros[1][0] = "SUBREPORT_DIR";
        mparametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        mparametros[2][0] = "SUBREPORTFIRMA_DIR";
        mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "Pajonal_Hoja_Tratamiento", mparametros);
    }

    private void mGrabar_Facturacion(String xId) {
        System.err.println("entro al tema facturacion");
        try {
            ConsultasMySQL xct2 = new ConsultasMySQL();
            this.xsql = "SELECT\n    `f_liquidacion`.`Id`  \nFROM\n    `ingreso`\n    INNER JOIN `f_liquidacion` \n        ON (`ingreso`.`Id` = `f_liquidacion`.`Id_Ingreso`)\n    INNER JOIN `h_atencion` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\nWHERE (`f_liquidacion`.`Estado` =0\n    AND `h_atencion`.`Id` ='" + this.xidAtencion + "')";
            System.out.println("" + this.xsql);
            ResultSet xrs = xct2.traerRs(this.xsql);
            Throwable th = null;
            try {
                try {
                    if (!xrs.next()) {
                        String sql = "SELECT   `ingreso`.`Id` \nFROM `h_ordenes_unidosis_aplicacion_detalle` \nINNER JOIN  `h_ordenes_unidosis_aplicacion`  ON (`h_ordenes_unidosis_aplicacion_detalle`.`Id_Ordenes_Aplicacion` = `h_ordenes_unidosis_aplicacion`.`Id`) \nINNER JOIN  `h_ordenes_unidosis`  ON (`h_ordenes_unidosis_aplicacion`.`Id_Unidosis` = `h_ordenes_unidosis`.`Id`) \nINNER JOIN  `i_suministro`  ON (`h_ordenes_unidosis_aplicacion_detalle`.`Id_Suministro` = `i_suministro`.`Id`) \nINNER JOIN `i_presentacionfarmaceutica`  ON (`i_suministro`.`IdPresentacionFarmaceutica` = `i_presentacionfarmaceutica`.`Id`) \nINNER JOIN  `ingreso`  ON (`h_ordenes_unidosis`.`Id_Ingreso` = `ingreso`.`Id`) \nINNER JOIN  `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) \nINNER JOIN  `f_tarifasuministro`  ON (`f_empresacontxconvenio`.`Id_Manual` = `f_tarifasuministro`.`Id_manual`) \nAND (`f_tarifasuministro`.`Id_suministro` = `i_suministro`.`Id`) \nWHERE ( `i_suministro`.`Escobrable`= 1 AND `h_ordenes_unidosis_aplicacion`.`Id` ='" + xId + "'  \nAND `i_presentacionfarmaceutica`.`Facturable` =1) GROUP BY `h_ordenes_unidosis_aplicacion`.`Id` ";
                        System.out.println("" + sql);
                        ResultSet rs = xct2.traerRs(sql);
                        if (rs.next()) {
                            ConsultasMySQL xct1 = new ConsultasMySQL();
                            this.xsql = "INSERT INTO `f_ordenes`( `Id_Ingreso` , `Id_TipoServicio` , `FechaOrden` , `HoraOrden` , `Id_Profesional` , `Id_Especialidad` , `Id_CentroCosto` , `TotalOrdenes` , `TotalEPS` ,  `TotalPaciente` , `Fecha` , `UsuarioS`)    SELECT   `ingreso`.`Id` , '" + this.xidservicio[this.JCBTipoServicio.getSelectedIndex()] + "' AS `Id_Servicio` , `h_ordenes_unidosis_aplicacion`.`Fecha_A` , `h_ordenes_unidosis_aplicacion`.`Hora` , `h_ordenes_unidosis`.`Id_Profesional` , `h_ordenes_unidosis`.`Id_Especialidad` ,'" + this.xidcentrocosto[this.JCBCentroCosto.getSelectedIndex()] + "' AS `Id_CCosto` , round(SUM(((`f_tarifasuministro`.`Valor`*`h_ordenes_unidosis_aplicacion_detalle`.`Cantidad`)))) AS `VOrden` , round(SUM(IF(`f_empresacontxconvenio`.`Id_TipoPlan`=`f_tarifasuministro`.`Id_TipoPlan`,((`f_tarifasuministro`.`Valor`*`h_ordenes_unidosis_aplicacion_detalle`.`Cantidad`)),0))) AS `VEps` , round(IF(`f_empresacontxconvenio`.`Id_TipoPlan`<>`f_tarifasuministro`.`Id_TipoPlan`,((`f_tarifasuministro`.`Valor`*`h_ordenes_unidosis_aplicacion_detalle`.`Cantidad`)),0)) AS `VUsurio`, now(),'" + Principal.usuarioSistemaDTO.getLogin() + "' FROM `h_ordenes_unidosis_aplicacion_detalle` INNER JOIN  `h_ordenes_unidosis_aplicacion`  ON (`h_ordenes_unidosis_aplicacion_detalle`.`Id_Ordenes_Aplicacion` = `h_ordenes_unidosis_aplicacion`.`Id`) INNER JOIN  `h_ordenes_unidosis`  ON (`h_ordenes_unidosis_aplicacion`.`Id_Unidosis` = `h_ordenes_unidosis`.`Id`) INNER JOIN  `i_suministro`  ON (`h_ordenes_unidosis_aplicacion_detalle`.`Id_Suministro` = `i_suministro`.`Id`) INNER JOIN `i_presentacionfarmaceutica`  ON (`i_suministro`.`IdPresentacionFarmaceutica` = `i_presentacionfarmaceutica`.`Id`) INNER JOIN  `ingreso`  ON (`h_ordenes_unidosis`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN  `f_tarifasuministro`  ON (`f_empresacontxconvenio`.`Id_Manual` = `f_tarifasuministro`.`Id_manual`) AND (`f_tarifasuministro`.`Id_suministro` = `i_suministro`.`Id`) WHERE ( `i_suministro`.`Escobrable`= 1 and `h_ordenes_unidosis_aplicacion`.`Id` ='" + xId + "' AND `i_presentacionfarmaceutica`.`Facturable` =1) GROUP BY `h_ordenes_unidosis_aplicacion`.`Id`     ";
                            System.out.println(this.xsql);
                            String xN_Orden = xct1.ejecutarSQLId(this.xsql);
                            xct1.cerrarConexionBd();
                            this.xsql = "INSERT INTO `f_itemordenessum`( `Id_Ordenes`  , `Id_Suministro` , `Cantidad` , `ValorUnit` , `EsCobrable` , `Plan`, porcentajeImpuesto, valorImpuesto , `Fecha` , `UsuarioS`, idModalidadAtencion, idServicioRips) SELECT '" + xN_Orden + "',`h_ordenes_unidosis_aplicacion_detalle`.`Id_Suministro` , sum(`h_ordenes_unidosis_aplicacion_detalle`.`Cantidad`) , round(`f_tarifasuministro`.`Valor`)  , `i_suministro`.`Escobrable`  , `f_tarifasuministro`.`Id_TipoPlan`,0 ,0 AS ValorImpuesto, NOW() AS `FEcha`,'" + Principal.usuarioSistemaDTO.getLogin() + "' ,houd.idModalidadAtencion , houd.idServicioRips FROM `h_ordenes_unidosis_aplicacion_detalle` INNER JOIN `h_ordenes_unidosis_aplicacion`   ON (`h_ordenes_unidosis_aplicacion_detalle`.`Id_Ordenes_Aplicacion` = `h_ordenes_unidosis_aplicacion`.`Id`) INNER JOIN `h_ordenes_unidosis`  ON (`h_ordenes_unidosis_aplicacion`.`Id_Unidosis` = `h_ordenes_unidosis`.`Id`) inner join h_ordenes_unidosis_detalle houd on (houd.Id_Ordenes=h_ordenes_unidosis.Id) and (houd.Id_Suministro=h_ordenes_unidosis_aplicacion_detalle.Id_Suministro) INNER JOIN `i_suministro`  ON (`h_ordenes_unidosis_aplicacion_detalle`.`Id_Suministro` = `i_suministro`.`Id`)  INNER JOIN `i_presentacionfarmaceutica`  ON (`i_suministro`.`IdPresentacionFarmaceutica` = `i_presentacionfarmaceutica`.`Id`) INNER JOIN `ingreso`  ON (`h_ordenes_unidosis`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `f_tarifasuministro`  ON (`f_empresacontxconvenio`.`Id_Manual` = `f_tarifasuministro`.`Id_manual`) AND (`f_tarifasuministro`.`Id_suministro` = `i_suministro`.`Id`) WHERE (`h_ordenes_unidosis_aplicacion`.`Id` ='" + xId + "' AND `i_presentacionfarmaceutica`.`Facturable` =1 ) GROUP BY `h_ordenes_unidosis_aplicacion_detalle`.`Id_Suministro`";
                            System.out.println(this.xsql);
                            xct1.ejecutarSQL(this.xsql);
                            xct1.cerrarConexionBd();
                            this.xsql = "update h_ordenes_unidosis_aplicacion set Id_OrdenF='" + xN_Orden + "' Where Id='" + xId + "'";
                            xct1.ejecutarSQL(this.xsql);
                            xct1.cerrarConexionBd();
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
                } finally {
                }
            } catch (Throwable th3) {
                th = th3;
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JPAplicaciontto.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
