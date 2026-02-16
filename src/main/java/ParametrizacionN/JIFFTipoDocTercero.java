package ParametrizacionN;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
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

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFFTipoDocTercero.class */
public class JIFFTipoDocTercero extends JInternalFrame {
    private String[] xIdTipoDoc;
    private String[] xIdUnidadFuncional;
    private String[] xIdTerceroCargo;
    private DefaultTableModel xModelo;
    private Object[] xDatos;
    private JComboBox JCBTerceroCargo;
    private JComboBox JCBTipoDocumento;
    private JComboBox JCBUnidadFuncional;
    private JPanel JPIDatos;
    private JSpinner JSOrden;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFCodigo;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Boolean xLleno = false;

    public JIFFTipoDocTercero() {
        initComponents();
        mCargarDatosTabla();
        mNuevo();
    }

    public void mNuevo() {
        Principal.txtNo.setText("");
        this.JTFCodigo.setText("");
        this.JCBTipoDocumento.setSelectedIndex(-1);
        this.JCBTerceroCargo.setSelectedIndex(-1);
        this.JCBUnidadFuncional.setSelectedIndex(-1);
        this.xLleno = false;
        mCargarCombo();
    }

    private void mCargarCombo() {
        this.JCBTipoDocumento.removeAllItems();
        this.xIdTipoDoc = this.xct.llenarCombo("SELECT  Id ,  Nbre FROM pp_tipo_documentos WHERE ( Estado  =1) ORDER BY Nbre ASC", this.xIdTipoDoc, this.JCBTipoDocumento);
        this.JCBTipoDocumento.setSelectedIndex(-1);
        this.xIdUnidadFuncional = this.xct.llenarCombo("SELECT `Id`, `Nbre`FROM`rh_unidad_funcional`WHERE (`Estado` =1) ORDER BY Nbre ASC", this.xIdUnidadFuncional, this.JCBUnidadFuncional);
        this.JCBUnidadFuncional.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.xLleno = true;
    }

    public void mGrabar() {
        String sql;
        if (!this.JTFCodigo.getText().isEmpty()) {
            if (this.JCBTipoDocumento.getSelectedIndex() != -1) {
                if (this.JCBTerceroCargo.getSelectedIndex() != -1) {
                    int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        if (Principal.txtNo.getText().isEmpty()) {
                            sql = " INSERT INTO pp_tipo_documento_tercero_firma  (Id, Id_TipoDoc, Id_Tercero_Cargo, Orden, UsuarioS) VALUES ('" + this.JTFCodigo.getText() + "','" + this.xIdTipoDoc[this.JCBTipoDocumento.getSelectedIndex()] + "','" + this.xIdTerceroCargo[this.JCBTerceroCargo.getSelectedIndex()] + "','" + this.JSOrden.getValue() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        } else {
                            sql = " UPDATE  pp_tipo_documento_tercero_firma  SET  Id  = '" + this.JTFCodigo.getText() + "', Id_TipoDoc  = '" + this.xIdTipoDoc[this.JCBTipoDocumento.getSelectedIndex()] + "', Id_Tercero_Cargo  = '" + this.xIdTerceroCargo[this.JCBTerceroCargo.getSelectedIndex()] + "', Orden  = '" + this.JSOrden.getValue() + "', UsuarioS  = '" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE  Id  = '" + Principal.txtNo.getText() + "'";
                        }
                        this.xct.ejecutarSQL(sql);
                        this.xct.cerrarConexionBd();
                        mCargarDatosTabla();
                        mNuevo();
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe Seleccionar un Tercero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBTerceroCargo.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de documento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBTipoDocumento.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Ingrese el Código", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFCodigo.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r3v33, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JTFCodigo = new JTextField();
        this.JCBTipoDocumento = new JComboBox();
        this.JCBTerceroCargo = new JComboBox();
        this.JSOrden = new JSpinner();
        this.JCBUnidadFuncional = new JComboBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("FIRMA DE TERCERO x DOCUMENTO");
        setToolTipText("");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("Documento Tercero Firma");
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFCodigo.setFont(new Font("Arial", 1, 12));
        this.JTFCodigo.setToolTipText("");
        this.JTFCodigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Código", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoDocumento.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDocumento.setToolTipText("");
        this.JCBTipoDocumento.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTerceroCargo.setFont(new Font("Arial", 1, 12));
        this.JCBTerceroCargo.setToolTipText("");
        this.JCBTerceroCargo.setBorder(BorderFactory.createTitledBorder((Border) null, "Tercero", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSOrden.setFont(new Font("Arial", 1, 12));
        this.JSOrden.setModel(new SpinnerNumberModel());
        this.JSOrden.setBorder(BorderFactory.createTitledBorder((Border) null, "Orden", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBUnidadFuncional.setFont(new Font("Arial", 1, 12));
        this.JCBUnidadFuncional.setToolTipText("");
        this.JCBUnidadFuncional.setBorder(BorderFactory.createTitledBorder((Border) null, "Unidad Funcional", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBUnidadFuncional.addItemListener(new ItemListener() { // from class: ParametrizacionN.JIFFTipoDocTercero.1
            public void itemStateChanged(ItemEvent evt) {
                JIFFTipoDocTercero.this.JCBUnidadFuncionalItemStateChanged(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JTFCodigo, -2, 192, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipoDocumento, -2, 432, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSOrden, -2, 119, -2)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCBUnidadFuncional, 0, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTerceroCargo, -2, 361, -2))).addGap(10, 10, 10)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipoDocumento, -2, 50, -2).addComponent(this.JSOrden, -2, 50, -2)).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addComponent(this.JTFCodigo, -2, 50, -2).addGap(7, 7, 7))).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBUnidadFuncional, -2, 50, -2).addComponent(this.JCBTerceroCargo, -2, 50, -2)).addGap(10, 10, 10)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFFTipoDocTercero.2
            public void mouseClicked(MouseEvent evt) {
                JIFFTipoDocTercero.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JSPDetalle).addComponent(this.JPIDatos, -1, -1, 32767)).addGap(10, 10, 10)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -1, 328, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTFCodigo.setText(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JCBTipoDocumento.setSelectedItem(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JCBUnidadFuncional.setSelectedItem(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            this.JCBTerceroCargo.setSelectedItem(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JSOrden.setValue(Integer.valueOf(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBUnidadFuncionalItemStateChanged(ItemEvent evt) {
        if (this.xLleno.booleanValue() && this.JCBUnidadFuncional.getSelectedIndex() != -1) {
            ConsultasMySQL xct = new ConsultasMySQL();
            this.JCBTerceroCargo.removeAllItems();
            this.xIdTerceroCargo = xct.llenarCombo("SELECT   rh_tipo_persona_cargon .Id,   persona.NUsuario  FROM  rh_tipo_persona_cargon  INNER JOIN    rh_unidadf_cargo ON (rh_tipo_persona_cargon.Id_unidadf_cargo = rh_unidadf_cargo.Id) INNER JOIN persona ON (persona.Id_persona = rh_tipo_persona_cargon.Id_Persona) WHERE (rh_unidadf_cargo.Id_UnidadF='" + this.xIdUnidadFuncional[this.JCBUnidadFuncional.getSelectedIndex()] + "')", this.xIdTerceroCargo, this.JCBTerceroCargo);
            this.JCBTerceroCargo.setSelectedIndex(-1);
            xct.cerrarConexionBd();
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xModelo = new DefaultTableModel(new Object[0], new String[]{"Código", "Tipo Documento", "Tercero", "Unidad F", "Orden"}) { // from class: ParametrizacionN.JIFFTipoDocTercero.3
            Class[] types = {Long.class, String.class, String.class, String.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(10);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            ResultSet xrs = this.xct.traerRs("SELECT `pp_tipo_documento_tercero_firma`.`Id`  , `pp_tipo_documentos`.`Nbre` , `persona`.`NUsuario`  , `rh_unidad_funcional`.`Nbre` AS UnidadF,  `pp_tipo_documento_tercero_firma`.`Orden`\nFROM `pp_tipo_documento_tercero_firma` INNER JOIN  `pp_tipo_documentos`   ON (`pp_tipo_documento_tercero_firma`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\n    INNER JOIN  `rh_tipo_persona_cargon`  ON (`pp_tipo_documento_tercero_firma`.`Id_Tercero_Cargo` = `rh_tipo_persona_cargon`.`Id`)\n    INNER JOIN  `persona`  ON (`rh_tipo_persona_cargon`.`Id_Persona` = `persona`.`Id_persona`)\n INNER JOIN `rh_unidadf_cargo`  ON (`rh_tipo_persona_cargon`.`Id_unidadf_cargo` = `rh_unidadf_cargo`.`Id`)\n INNER JOIN `rh_unidad_funcional`   ON (`rh_unidadf_cargo`.`Id_UnidadF` = `rh_unidad_funcional`.`Id`)  ORDER BY `pp_tipo_documentos`.`Nbre` ASC, `pp_tipo_documento_tercero_firma`.`Orden` ASC;");
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xModelo.addRow(this.xDatos);
                    this.xModelo.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    this.xModelo.setValueAt(xrs.getString(2), n, 1);
                    this.xModelo.setValueAt(xrs.getString(3), n, 2);
                    this.xModelo.setValueAt(xrs.getString(4), n, 3);
                    this.xModelo.setValueAt(Integer.valueOf(xrs.getInt(5)), n, 4);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGBarrio.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
