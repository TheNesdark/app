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
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFFPPTipoDocumento.class */
public class JIFFPPTipoDocumento extends JInternalFrame {
    private int xReqFirmaAprob = 0;
    private int xReqConsecutivo = 0;
    private int xEstado = 1;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private DefaultTableModel xModelo;
    private Object[] xDatos;
    private String[] xClaseDoc;
    private JComboBox JCBClaseDocumento;
    private JCheckBox JCHEstado;
    private JCheckBox JCHReqConsecutivo;
    private JCheckBox JCHReqFirmaAprob;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFNoConsecutivo;
    private JTextField JTFNombre;
    private JTextField JTFPrefijo;

    public JIFFPPTipoDocumento() {
        initComponents();
        mCargarDatosTabla();
        mCargarCombo();
        mNuevo();
    }

    public void mNuevo() {
        Principal.txtNo.setText("");
        this.JTFNombre.setText("");
        this.JTFNoConsecutivo.setText("0");
        this.JTFPrefijo.setText("");
        this.JCBClaseDocumento.setSelectedIndex(-1);
        this.JCHEstado.setSelected(true);
        this.JCHReqConsecutivo.setSelected(false);
        this.JCHReqFirmaAprob.setSelected(false);
        this.xEstado = 1;
        this.xReqConsecutivo = 0;
        this.xReqFirmaAprob = 0;
    }

    private void mCargarCombo() {
        this.xClaseDoc = this.xct.llenarCombo("SELECT  Id ,  Nbre FROM pp_clase_documento WHERE ( Estado  =1)ORDER BY  Nbre  ASC", this.xClaseDoc, this.JCBClaseDocumento);
        this.JCBClaseDocumento.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
    }

    public void mGrabar() {
        String sql;
        if (!this.JTFNombre.getText().isEmpty()) {
            if (this.JCBClaseDocumento.getSelectedIndex() != -1) {
                if (!this.JTFNoConsecutivo.getText().isEmpty()) {
                    int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        if (Principal.txtNo.getText().isEmpty()) {
                            sql = " INSERT INTO  pp_tipo_documentos(Nbre, Id_ClaseDoc, Req_Consec, Prefijo, No_Consecutivo, Req_Aprob, Estado, UsuarioS ) VALUES ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xClaseDoc[this.JCBClaseDocumento.getSelectedIndex()] + "','" + this.xReqConsecutivo + "','" + this.JTFPrefijo.getText() + "','" + this.JTFNoConsecutivo.getText() + "','" + this.xReqFirmaAprob + "','" + this.xEstado + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        } else {
                            sql = " UPDATE  pp_tipo_documentos  SET  Nbre  = '" + this.JTFNombre.getText().toUpperCase() + "', Id_ClaseDoc  = '" + this.xClaseDoc[this.JCBClaseDocumento.getSelectedIndex()] + "', Req_Consec  = '" + this.xReqConsecutivo + "', Prefijo  = '" + this.JTFPrefijo.getText() + "', No_Consecutivo  = '" + this.JTFNoConsecutivo.getText() + "', Req_Aprob  = '" + this.xReqFirmaAprob + "', Estado  = '" + this.xEstado + "', UsuarioS  = '" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE  Id  = '" + Principal.txtNo.getText() + "'";
                        }
                        this.xct.ejecutarSQL(sql);
                        this.xct.cerrarConexionBd();
                        mCargarDatosTabla();
                        mNuevo();
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe ingresar un Número de Consecutivo, Digite cero cuando no requiera", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFNoConsecutivo.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una clase de documento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBClaseDocumento.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Ingrese un Nombre de Documento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFNombre.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xModelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Clase Documento", "Req Consec", "Prefijo", "No Consecutivo", "Req FirmaAprob", "Estado"}) { // from class: ParametrizacionN.JIFFPPTipoDocumento.1
            Class[] types = {Long.class, String.class, String.class, Boolean.class, String.class, String.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(30);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            ResultSet xrs = this.xct.traerRs("SELECT `pp_tipo_documentos`.`Id`, `pp_tipo_documentos`.`Nbre`, `pp_clase_documento`.`Nbre` AS `ClaseDoc`, `pp_tipo_documentos`.`Req_Consec`, `pp_tipo_documentos`.`Prefijo`     , `pp_tipo_documentos`.`No_Consecutivo`, `pp_tipo_documentos`.`Req_Aprob`, `pp_tipo_documentos`.`Estado`FROM `pp_tipo_documentos`     INNER JOIN  `pp_clase_documento` ON (`pp_tipo_documentos`.`Id_ClaseDoc` = `pp_clase_documento`.`Id`) ORDER BY pp_tipo_documentos.Nbre ASC");
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xModelo.addRow(this.xDatos);
                    this.xModelo.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    this.xModelo.setValueAt(xrs.getString(2), n, 1);
                    this.xModelo.setValueAt(xrs.getString(3), n, 2);
                    this.xModelo.setValueAt(Boolean.valueOf(xrs.getBoolean(4)), n, 3);
                    this.xModelo.setValueAt(xrs.getString(5), n, 4);
                    this.xModelo.setValueAt(xrs.getString(6), n, 5);
                    this.xModelo.setValueAt(Boolean.valueOf(xrs.getBoolean(7)), n, 6);
                    this.xModelo.setValueAt(Boolean.valueOf(xrs.getBoolean(8)), n, 7);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGBarrio.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r3v37, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JTFNombre = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JCBClaseDocumento = new JComboBox();
        this.JCHReqConsecutivo = new JCheckBox();
        this.JTFPrefijo = new JTextField();
        this.JTFNoConsecutivo = new JTextField();
        this.JCHReqFirmaAprob = new JCheckBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("TIPO DOCUMENTO PRESUPUESTO");
        setName("Tipo Documento Presupuesto");
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setToolTipText("");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFPPTipoDocumento.2
            public void actionPerformed(ActionEvent evt) {
                JIFFPPTipoDocumento.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JCBClaseDocumento.setFont(new Font("Arial", 1, 12));
        this.JCBClaseDocumento.setToolTipText("");
        this.JCBClaseDocumento.setBorder(BorderFactory.createTitledBorder((Border) null, "Clase Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHReqConsecutivo.setFont(new Font("Arial", 1, 12));
        this.JCHReqConsecutivo.setText("Requiere Consecutivo");
        this.JCHReqConsecutivo.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFPPTipoDocumento.3
            public void actionPerformed(ActionEvent evt) {
                JIFFPPTipoDocumento.this.JCHReqConsecutivoActionPerformed(evt);
            }
        });
        this.JTFPrefijo.setFont(new Font("Arial", 1, 12));
        this.JTFPrefijo.setToolTipText("");
        this.JTFPrefijo.setBorder(BorderFactory.createTitledBorder((Border) null, "Prefijo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNoConsecutivo.setFont(new Font("Arial", 1, 12));
        this.JTFNoConsecutivo.setToolTipText("");
        this.JTFNoConsecutivo.setBorder(BorderFactory.createTitledBorder((Border) null, "No Consecutivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHReqFirmaAprob.setFont(new Font("Arial", 1, 12));
        this.JCHReqFirmaAprob.setText("Requiere Firma Aprobación");
        this.JCHReqFirmaAprob.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFPPTipoDocumento.4
            public void actionPerformed(ActionEvent evt) {
                JIFFPPTipoDocumento.this.JCHReqFirmaAprobActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGap(5, 5, 5).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JTFPrefijo, -2, 210, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNoConsecutivo, -2, 210, -2)).addComponent(this.JTFNombre)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCHReqFirmaAprob).addContainerGap(-1, 32767)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCBClaseDocumento, -2, 367, -2).addGap(0, 5, 32767)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCHReqConsecutivo).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHEstado).addGap(49, 49, 49)))));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombre, -2, 50, -2).addComponent(this.JCBClaseDocumento, -2, 50, -2)).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHReqConsecutivo).addComponent(this.JCHEstado)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHReqFirmaAprob)).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFPrefijo, -2, 50, -2).addComponent(this.JTFNoConsecutivo, -2, 50, -2)))).addContainerGap()));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFFPPTipoDocumento.5
            public void mouseClicked(MouseEvent evt) {
                JIFFPPTipoDocumento.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatos, -1, -1, 32767).addComponent(this.JSPDetalle)).addGap(10, 10, 10)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -1, 324, 32767).addGap(12, 12, 12)));
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
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTFNombre.setText(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JCBClaseDocumento.setSelectedItem(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JCHReqConsecutivo.setSelected(Boolean.valueOf(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()).booleanValue());
            if (this.JCHReqConsecutivo.isSelected()) {
                this.xReqConsecutivo = 1;
            } else {
                this.xReqConsecutivo = 0;
            }
            this.JTFPrefijo.setText(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString());
            this.JTFNoConsecutivo.setText(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString());
            this.JCHReqFirmaAprob.setSelected(Boolean.valueOf(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString()).booleanValue());
            if (this.JCHReqFirmaAprob.isSelected()) {
                this.xReqFirmaAprob = 1;
            } else {
                this.xReqFirmaAprob = 0;
            }
            this.JCHEstado.setSelected(Boolean.valueOf(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString()).booleanValue());
            if (this.JCHEstado.isSelected()) {
                this.xEstado = 1;
            } else {
                this.xEstado = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHReqConsecutivoActionPerformed(ActionEvent evt) {
        if (this.JCHReqConsecutivo.isSelected()) {
            this.xReqConsecutivo = 1;
        } else {
            this.xReqConsecutivo = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHReqFirmaAprobActionPerformed(ActionEvent evt) {
        if (this.JCHReqFirmaAprob.isSelected()) {
            this.xReqFirmaAprob = 1;
        } else {
            this.xReqFirmaAprob = 0;
        }
    }
}
