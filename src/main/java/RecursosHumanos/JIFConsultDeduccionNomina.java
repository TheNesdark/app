package RecursosHumanos;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JYearChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:RecursosHumanos/JIFConsultDeduccionNomina.class */
public class JIFConsultDeduccionNomina extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String[] xidnomina;
    private String[] xidconceptonomina;
    private String xsql;
    private ButtonGroup JBG_TIpo;
    private JButton JBTExportar;
    private JComboBox JCBConceptoNomina;
    private JComboBox JCBNomina;
    private JPanel JPFiltroPro;
    private JRadioButton JRB_Deducido;
    private JRadioButton JRB_Devengado;
    private JScrollPane JSDetalle;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    private JYearChooser JYC_FAno;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private boolean xllenoc = false;
    private String xencabezado = "Valor Deducido";

    public JIFConsultDeduccionNomina() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG_TIpo = new ButtonGroup();
        this.JSDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPFiltroPro = new JPanel();
        this.JYC_FAno = new JYearChooser();
        this.JCBNomina = new JComboBox();
        this.JCBConceptoNomina = new JComboBox();
        this.JRB_Deducido = new JRadioButton();
        this.JRB_Devengado = new JRadioButton();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONSULTAR CONCEPTOS NOMINA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjif_conolidado_concepto");
        this.JSDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: RecursosHumanos.JIFConsultDeduccionNomina.1
            public void mouseClicked(MouseEvent evt) {
                JIFConsultDeduccionNomina.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSDetalle.setViewportView(this.JTDetalle);
        this.JPFiltroPro.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACION", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JYC_FAno.setBorder(BorderFactory.createTitledBorder((Border) null, "AÑO", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JYC_FAno.addPropertyChangeListener(new PropertyChangeListener() { // from class: RecursosHumanos.JIFConsultDeduccionNomina.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFConsultDeduccionNomina.this.JYC_FAnoPropertyChange(evt);
            }
        });
        this.JCBNomina.setFont(new Font("Arial", 1, 12));
        this.JCBNomina.setBorder(BorderFactory.createTitledBorder((Border) null, "N°", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBNomina.addItemListener(new ItemListener() { // from class: RecursosHumanos.JIFConsultDeduccionNomina.3
            public void itemStateChanged(ItemEvent evt) {
                JIFConsultDeduccionNomina.this.JCBNominaItemStateChanged(evt);
            }
        });
        this.JCBConceptoNomina.setFont(new Font("Arial", 1, 12));
        this.JCBConceptoNomina.setBorder(BorderFactory.createTitledBorder((Border) null, "N°", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBG_TIpo.add(this.JRB_Deducido);
        this.JRB_Deducido.setFont(new Font("Arial", 1, 12));
        this.JRB_Deducido.setSelected(true);
        this.JRB_Deducido.setText("Deducido");
        this.JRB_Deducido.addActionListener(new ActionListener() { // from class: RecursosHumanos.JIFConsultDeduccionNomina.4
            public void actionPerformed(ActionEvent evt) {
                JIFConsultDeduccionNomina.this.JRB_DeducidoActionPerformed(evt);
            }
        });
        this.JBG_TIpo.add(this.JRB_Devengado);
        this.JRB_Devengado.setFont(new Font("Arial", 1, 12));
        this.JRB_Devengado.setText("Devengado");
        this.JRB_Devengado.addActionListener(new ActionListener() { // from class: RecursosHumanos.JIFConsultDeduccionNomina.5
            public void actionPerformed(ActionEvent evt) {
                JIFConsultDeduccionNomina.this.JRB_DevengadoActionPerformed(evt);
            }
        });
        GroupLayout JPFiltroProLayout = new GroupLayout(this.JPFiltroPro);
        this.JPFiltroPro.setLayout(JPFiltroProLayout);
        JPFiltroProLayout.setHorizontalGroup(JPFiltroProLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPFiltroProLayout.createSequentialGroup().addContainerGap().addComponent(this.JYC_FAno, -2, 93, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBNomina, -2, 128, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBConceptoNomina, -2, 506, -2).addGap(18, 18, 18).addComponent(this.JRB_Deducido).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 12, 32767).addComponent(this.JRB_Devengado).addContainerGap()));
        JPFiltroProLayout.setVerticalGroup(JPFiltroProLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPFiltroProLayout.createSequentialGroup().addGroup(JPFiltroProLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JYC_FAno, -2, 50, -2).addGroup(JPFiltroProLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBNomina, -2, 50, -2).addComponent(this.JCBConceptoNomina, -2, 50, -2).addComponent(this.JRB_Deducido).addComponent(this.JRB_Devengado))).addContainerGap()));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: RecursosHumanos.JIFConsultDeduccionNomina.6
            public void mouseClicked(MouseEvent evt) {
                JIFConsultDeduccionNomina.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: RecursosHumanos.JIFConsultDeduccionNomina.7
            public void actionPerformed(ActionEvent evt) {
                JIFConsultDeduccionNomina.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPFiltroPro, -1, -1, 32767).addComponent(this.JSDetalle).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 407, -2).addGap(30, 30, 30).addComponent(this.JBTExportar, -2, 178, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JPFiltroPro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSDetalle, -1, 338, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JBTExportar, -2, 50, -2)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JYC_FAnoPropertyChange(PropertyChangeEvent evt) {
        if (this.xllenoc) {
            mLLenarNomina();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBNominaItemStateChanged(ItemEvent evt) {
        if (this.JCBNomina.getSelectedIndex() != -1 && this.xllenoc) {
            mLLenarConceptoNomina();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_DeducidoActionPerformed(ActionEvent evt) {
        mLLenarConceptoNomina();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_DevengadoActionPerformed(ActionEvent evt) {
        mLLenarConceptoNomina();
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
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (!this.JTFRuta.getText().isEmpty()) {
            if (this.JTDetalle.getRowCount() > -1) {
                int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFRuta.requestFocus();
    }

    public void mNuevo() {
        mLLenarNomina();
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.JRB_Deducido.setSelected(true);
        this.xencabezado = "Valor Deducido";
        mCrearModeloTabla();
    }

    public void mImprimir() {
        if (this.JTDetalle.getRowCount() != -1) {
            String[][] mparametros = new String[4][2];
            mparametros[0][0] = "Id_Liquidacion";
            mparametros[0][1] = this.JCBNomina.getSelectedItem().toString();
            mparametros[1][0] = "Id_Concepto";
            mparametros[1][1] = this.xidconceptonomina[this.JCBConceptoNomina.getSelectedIndex()];
            mparametros[2][0] = "SUBREPORT_DIR";
            mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            mparametros[3][0] = "SUBREPORTFIRMA_DIR";
            mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "N_Liqudiacion_Concepto", mparametros);
        }
    }

    private void mLLenarNomina() {
        this.xllenoc = false;
        this.JCBConceptoNomina.removeAllItems();
        this.JCBNomina.removeAllItems();
        String sql = "SELECT `rh_nomina_liquidacion`.`Id`, `rh_nomina_liquidacion`.`Id` as Id_Nomina FROM`rh_nomina_liquidacion_detalle`INNER JOIN  `rh_nomina_liquidacion` ON (`rh_nomina_liquidacion_detalle`.`Id_Liquidacion` = `rh_nomina_liquidacion`.`Id`)INNER JOIN  `rh_tipo_persona_cargon` ON (`rh_nomina_liquidacion_detalle`.`Id_PersonaC` = `rh_tipo_persona_cargon`.`Id`)INNER JOIN  `rh_nomina_concepto_unidadf` ON (`rh_nomina_liquidacion_detalle`.`Id_ConceptoCN` = `rh_nomina_concepto_unidadf`.`Id`)INNER JOIN  `rh_nomina_persona_unidadf` ON (`rh_nomina_persona_unidadf`.`Id_personaCargo` = `rh_tipo_persona_cargon`.`Id`) AND (rh_nomina_persona_unidadf.Estado=1)INNER JOIN  `rh_nomina_conceptos` ON (`rh_nomina_concepto_unidadf`.`Id_ConceptosN` = `rh_nomina_conceptos`.`Id`)INNER JOIN  `rh_tipo_clasificacion_conceptonomina` ON (`rh_nomina_conceptos`.`Id_Clasificacion` = `rh_tipo_clasificacion_conceptonomina`.`Id`)INNER JOIN  `cc_terceros` ON (`cc_terceros`.`Id` = `rh_nomina_liquidacion_detalle`.`Id_Tercero`)INNER JOIN  `rh_unidadf_cargo` ON (`rh_tipo_persona_cargon`.`Id_unidadf_cargo` = `rh_unidadf_cargo`.`Id`)INNER JOIN  `rh_tipo_cargo` ON (`rh_unidadf_cargo`.`Id_Cargo` = `rh_tipo_cargo`.`Id`)INNER JOIN  `g_persona` ON (`rh_tipo_persona_cargon`.`Id_Persona` = `g_persona`.`Id`)INNER JOIN  `rh_nomina_periodo`ON (`rh_nomina_periodo`.`Id` = `rh_nomina_liquidacion`.`Id_Periodo`)WHERE (rh_nomina_liquidacion.`Ano`='" + this.JYC_FAno.getValue() + "' AND rh_nomina_liquidacion.`Estado`=1) GROUP BY `rh_nomina_liquidacion`.`Id`;";
        this.xidnomina = this.xct.llenarCombo(sql, this.xidnomina, this.JCBNomina);
        this.JCBNomina.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.xllenoc = true;
    }

    private void mLLenarConceptoNomina() {
        this.JCBConceptoNomina.removeAllItems();
        if (this.JRB_Deducido.isSelected()) {
            this.xsql = "SELECT `rh_nomina_conceptos`.`Id`  ,`rh_nomina_conceptos`.`Nbre` AS `NConcepto`FROM`rh_nomina_liquidacion_detalle`INNER JOIN  `rh_nomina_liquidacion` ON (`rh_nomina_liquidacion_detalle`.`Id_Liquidacion` = `rh_nomina_liquidacion`.`Id`)INNER JOIN  `rh_tipo_persona_cargon` ON (`rh_nomina_liquidacion_detalle`.`Id_PersonaC` = `rh_tipo_persona_cargon`.`Id`)INNER JOIN  `rh_nomina_concepto_unidadf` ON (`rh_nomina_liquidacion_detalle`.`Id_ConceptoCN` = `rh_nomina_concepto_unidadf`.`Id`)INNER JOIN  `rh_nomina_persona_unidadf` ON (`rh_nomina_persona_unidadf`.`Id_personaCargo` = `rh_tipo_persona_cargon`.`Id`) AND (rh_nomina_persona_unidadf.Estado=1)INNER JOIN  `rh_nomina_conceptos` ON (`rh_nomina_concepto_unidadf`.`Id_ConceptosN` = `rh_nomina_conceptos`.`Id`)INNER JOIN  `rh_tipo_clasificacion_conceptonomina` ON (`rh_nomina_conceptos`.`Id_Clasificacion` = `rh_tipo_clasificacion_conceptonomina`.`Id`)INNER JOIN  `cc_terceros` ON (`cc_terceros`.`Id` = `rh_nomina_liquidacion_detalle`.`Id_Tercero`)INNER JOIN  `rh_unidadf_cargo` ON (`rh_tipo_persona_cargon`.`Id_unidadf_cargo` = `rh_unidadf_cargo`.`Id`)INNER JOIN  `rh_tipo_cargo` ON (`rh_unidadf_cargo`.`Id_Cargo` = `rh_tipo_cargo`.`Id`)INNER JOIN  `g_persona` ON (`rh_tipo_persona_cargon`.`Id_Persona` = `g_persona`.`Id`)INNER JOIN  `rh_nomina_periodo`ON (`rh_nomina_periodo`.`Id` = `rh_nomina_liquidacion`.`Id_Periodo`)WHERE (`rh_nomina_liquidacion_detalle`.`VDeducido`<>0 and  `rh_nomina_liquidacion`.`Id` ='" + this.xidnomina[this.JCBNomina.getSelectedIndex()] + "')GROUP BY `rh_nomina_conceptos`.`Id`  ORDER BY `NConcepto` ASC;";
        } else {
            this.xsql = "SELECT `rh_nomina_conceptos`.`Id`  ,`rh_nomina_conceptos`.`Nbre` AS `NConcepto`FROM`rh_nomina_liquidacion_detalle`INNER JOIN  `rh_nomina_liquidacion` ON (`rh_nomina_liquidacion_detalle`.`Id_Liquidacion` = `rh_nomina_liquidacion`.`Id`)INNER JOIN  `rh_tipo_persona_cargon` ON (`rh_nomina_liquidacion_detalle`.`Id_PersonaC` = `rh_tipo_persona_cargon`.`Id`)INNER JOIN  `rh_nomina_concepto_unidadf` ON (`rh_nomina_liquidacion_detalle`.`Id_ConceptoCN` = `rh_nomina_concepto_unidadf`.`Id`)INNER JOIN  `rh_nomina_persona_unidadf` ON (`rh_nomina_persona_unidadf`.`Id_personaCargo` = `rh_tipo_persona_cargon`.`Id`) AND (rh_nomina_persona_unidadf.Estado=1)INNER JOIN  `rh_nomina_conceptos` ON (`rh_nomina_concepto_unidadf`.`Id_ConceptosN` = `rh_nomina_conceptos`.`Id`)INNER JOIN  `rh_tipo_clasificacion_conceptonomina` ON (`rh_nomina_conceptos`.`Id_Clasificacion` = `rh_tipo_clasificacion_conceptonomina`.`Id`)INNER JOIN  `cc_terceros` ON (`cc_terceros`.`Id` = `rh_nomina_liquidacion_detalle`.`Id_Tercero`)INNER JOIN  `rh_unidadf_cargo` ON (`rh_tipo_persona_cargon`.`Id_unidadf_cargo` = `rh_unidadf_cargo`.`Id`)INNER JOIN  `rh_tipo_cargo` ON (`rh_unidadf_cargo`.`Id_Cargo` = `rh_tipo_cargo`.`Id`)INNER JOIN  `g_persona` ON (`rh_tipo_persona_cargon`.`Id_Persona` = `g_persona`.`Id`)INNER JOIN  `rh_nomina_periodo`ON (`rh_nomina_periodo`.`Id` = `rh_nomina_liquidacion`.`Id_Periodo`)WHERE (`rh_nomina_liquidacion_detalle`.`VDevengado`<>0 and  `rh_nomina_liquidacion`.`Id` ='" + this.xidnomina[this.JCBNomina.getSelectedIndex()] + "')GROUP BY `rh_nomina_conceptos`.`Id`  ORDER BY `NConcepto` ASC;";
        }
        this.xidconceptonomina = this.xct.llenarCombo(this.xsql, this.xidconceptonomina, this.JCBConceptoNomina);
        this.JCBConceptoNomina.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
    }

    public void mBuscar() {
        if (this.JCBNomina.getSelectedIndex() != -1) {
            if (this.JCBConceptoNomina.getSelectedIndex() != -1) {
                if (this.JRB_Deducido.isSelected()) {
                    this.xencabezado = "Valor Deducido";
                } else {
                    this.xencabezado = "Valor Devengado";
                }
                mCargarDatosTabla();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un Concepto de Nomina", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBConceptoNomina.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una Nomina", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBNomina.requestFocus();
    }

    private void mCrearModeloTabla() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Periodo", "Clasificacion", "Concepto", "Documento", "Empleado", "Cargo", this.xencabezado}) { // from class: RecursosHumanos.JIFConsultDeduccionNomina.8
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(60);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
    }

    public void mCargarDatosTabla() {
        String xsql;
        try {
            mCrearModeloTabla();
            if (this.JRB_Deducido.isSelected()) {
                xsql = "SELECT CONCAT(rh_nomina_periodo.Nbre, '-', rh_nomina_liquidacion.`Ano`) AS Periodo, `rh_tipo_clasificacion_conceptonomina`.`Nbre` AS `NClasificacion`, `rh_nomina_conceptos`.`Nbre` AS `NConcepto`, g_persona.`NoDocumento` AS NDocumento , CONCAT(`g_persona`.`Apellido1`, ' ', `g_persona`.`Apellido2`, ' ', `g_persona`.`Nombre1`, ' ', `g_persona`.`Nombre2`)  AS `NEmpleado` , `rh_tipo_cargo`.`Nbre` AS `NCargo`, `rh_nomina_liquidacion_detalle`.`VDeducido` FROM `d_ips`,  `rh_nomina_liquidacion_detalle`INNER JOIN  `rh_nomina_liquidacion` ON (`rh_nomina_liquidacion_detalle`.`Id_Liquidacion` = `rh_nomina_liquidacion`.`Id`)INNER JOIN  `rh_tipo_persona_cargon` ON (`rh_nomina_liquidacion_detalle`.`Id_PersonaC` = `rh_tipo_persona_cargon`.`Id`)INNER JOIN  `rh_nomina_concepto_unidadf` ON (`rh_nomina_liquidacion_detalle`.`Id_ConceptoCN` = `rh_nomina_concepto_unidadf`.`Id`)INNER JOIN  `rh_nomina_persona_unidadf` ON (`rh_nomina_persona_unidadf`.`Id_personaCargo` = `rh_tipo_persona_cargon`.`Id`) AND (rh_nomina_persona_unidadf.Estado=1)INNER JOIN  `rh_nomina_conceptos` ON (`rh_nomina_concepto_unidadf`.`Id_ConceptosN` = `rh_nomina_conceptos`.`Id`)INNER JOIN  `rh_tipo_clasificacion_conceptonomina` ON (`rh_nomina_conceptos`.`Id_Clasificacion` = `rh_tipo_clasificacion_conceptonomina`.`Id`)INNER JOIN  `cc_terceros` ON (`cc_terceros`.`Id` = `rh_nomina_liquidacion_detalle`.`Id_Tercero`)INNER JOIN  `rh_unidadf_cargo` ON (`rh_tipo_persona_cargon`.`Id_unidadf_cargo` = `rh_unidadf_cargo`.`Id`)INNER JOIN  `rh_tipo_cargo` ON (`rh_unidadf_cargo`.`Id_Cargo` = `rh_tipo_cargo`.`Id`)INNER JOIN  `g_persona` ON (`rh_tipo_persona_cargon`.`Id_Persona` = `g_persona`.`Id`)INNER JOIN  `rh_nomina_periodo`ON (`rh_nomina_periodo`.`Id` = `rh_nomina_liquidacion`.`Id_Periodo`)WHERE (`rh_nomina_liquidacion`.`Id` ='" + this.xidnomina[this.JCBNomina.getSelectedIndex()] + "'  AND `rh_nomina_conceptos`.`Id` ='" + this.xidconceptonomina[this.JCBConceptoNomina.getSelectedIndex()] + "')ORDER BY `NConcepto` ASC, `NEmpleado` ASC;";
            } else {
                xsql = "SELECT CONCAT(rh_nomina_periodo.Nbre, '-', rh_nomina_liquidacion.`Ano`) AS Periodo, `rh_tipo_clasificacion_conceptonomina`.`Nbre` AS `NClasificacion`, `rh_nomina_conceptos`.`Nbre` AS `NConcepto`, g_persona.`NoDocumento` AS NDocumento , CONCAT(`g_persona`.`Apellido1`, ' ', `g_persona`.`Apellido2`, ' ', `g_persona`.`Nombre1`, ' ', `g_persona`.`Nombre2`)  AS `NEmpleado` , `rh_tipo_cargo`.`Nbre` AS `NCargo`, `rh_nomina_liquidacion_detalle`.`VDevengado` FROM `d_ips`,  `rh_nomina_liquidacion_detalle`INNER JOIN  `rh_nomina_liquidacion` ON (`rh_nomina_liquidacion_detalle`.`Id_Liquidacion` = `rh_nomina_liquidacion`.`Id`)INNER JOIN  `rh_tipo_persona_cargon` ON (`rh_nomina_liquidacion_detalle`.`Id_PersonaC` = `rh_tipo_persona_cargon`.`Id`)INNER JOIN  `rh_nomina_concepto_unidadf` ON (`rh_nomina_liquidacion_detalle`.`Id_ConceptoCN` = `rh_nomina_concepto_unidadf`.`Id`)INNER JOIN  `rh_nomina_persona_unidadf` ON (`rh_nomina_persona_unidadf`.`Id_personaCargo` = `rh_tipo_persona_cargon`.`Id`) AND (rh_nomina_persona_unidadf.Estado=1)INNER JOIN  `rh_nomina_conceptos` ON (`rh_nomina_concepto_unidadf`.`Id_ConceptosN` = `rh_nomina_conceptos`.`Id`)INNER JOIN  `rh_tipo_clasificacion_conceptonomina` ON (`rh_nomina_conceptos`.`Id_Clasificacion` = `rh_tipo_clasificacion_conceptonomina`.`Id`)INNER JOIN  `cc_terceros` ON (`cc_terceros`.`Id` = `rh_nomina_liquidacion_detalle`.`Id_Tercero`)INNER JOIN  `rh_unidadf_cargo` ON (`rh_tipo_persona_cargon`.`Id_unidadf_cargo` = `rh_unidadf_cargo`.`Id`)INNER JOIN  `rh_tipo_cargo` ON (`rh_unidadf_cargo`.`Id_Cargo` = `rh_tipo_cargo`.`Id`)INNER JOIN  `g_persona` ON (`rh_tipo_persona_cargon`.`Id_Persona` = `g_persona`.`Id`)INNER JOIN  `rh_nomina_periodo`ON (`rh_nomina_periodo`.`Id` = `rh_nomina_liquidacion`.`Id_Periodo`)WHERE (`rh_nomina_liquidacion`.`Id` ='" + this.xidnomina[this.JCBNomina.getSelectedIndex()] + "'  AND `rh_nomina_conceptos`.`Id` ='" + this.xidconceptonomina[this.JCBConceptoNomina.getSelectedIndex()] + "')ORDER BY `NConcepto` ASC, `NEmpleado` ASC;";
            }
            ResultSet xrs = this.xct.traerRs(xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(7)), n, 6);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultDeduccionNomina.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
