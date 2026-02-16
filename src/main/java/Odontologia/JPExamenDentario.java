package Odontologia;

import Acceso.Principal;
import Historia.clasesHistoriaCE;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Odontologia/JPExamenDentario.class */
public class JPExamenDentario extends JPanel {
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo2;
    private Object[] xdato;
    private ButtonGroup JBGMedida;
    private JButton JBGuardar;
    private JPanel JPEncabezado;
    private JPanel JPMayoral;
    private JRadioButton JRBMacro;
    private JRadioButton JRBMicro;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPDetalleCro;
    private JTable JTDetalle;
    private JTable JTDetalleCro;
    private JFormattedTextField JTFF35;
    private JFormattedTextField JTFF42;
    private JFormattedTextField JTFF47;
    private JFormattedTextField JTFFBogue;
    Metodos xmt = new Metodos();
    private long xmicro = 0;
    ConsultasMySQL xconsulta = new ConsultasMySQL();
    private String xexamen = "";

    public JPExamenDentario() {
        initComponents();
        mNuevo();
        mBuscarExamen();
    }

    private void mNuevo() {
        this.JTFFBogue.setValue(0);
        this.JTFF35.setValue(0);
        this.JTFF42.setValue(0);
        this.JTFF47.setValue(0);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Concepto", "Aplica?", "Observación"}) { // from class: Odontologia.JPExamenDentario.1
            Class[] types = {Integer.class, String.class, Boolean.class, String.class};
            boolean[] canEdit = {false, false, true, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(2);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(8);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(300);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearCronologia() {
        this.xmodelo2 = new DefaultTableModel(new Object[0], new String[]{"Id", "Concepto", "Aplica?", "Observación"}) { // from class: Odontologia.JPExamenDentario.2
            Class[] types = {Integer.class, String.class, Boolean.class, String.class};
            boolean[] canEdit = {false, false, true, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleCro.setModel(this.xmodelo2);
        this.JTDetalleCro.getColumnModel().getColumn(0).setPreferredWidth(2);
        this.JTDetalleCro.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalleCro.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalleCro.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalleCro.getColumnModel().getColumn(2).setPreferredWidth(8);
        this.JTDetalleCro.getColumnModel().getColumn(3).setPreferredWidth(300);
    }

    public void mGuardar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            String sql = "INSERT INTO o_examen_dentario (IdTratamiento, `Bogue` , `Mayo35` , `Mayo42` , `Mayo47` , `Micro` , `UsuarioS`) VALUES ('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "','" + this.JTFFBogue.getValue() + "','" + this.JTFF35.getValue() + "','" + this.JTFF42.getValue() + "','" + this.JTFF47.getValue() + "','" + this.xmicro + "', '" + Principal.usuarioSistemaDTO.getLogin() + "')";
            this.xexamen = this.xconsulta.ejecutarSQLId(sql);
            this.xconsulta.cerrarConexionBd();
            for (int y = 0; y < this.JTDetalle.getRowCount(); y++) {
                if (Boolean.valueOf(this.xmodelo.getValueAt(y, 2).toString()).booleanValue()) {
                    String sql2 = "INSERT INTO o_examen_dentario_detalle(`IdExamen`  , `IdConceptos` , `Observacion` , `UsuarioS`) VALUES ('" + this.xexamen + "','" + this.xmodelo.getValueAt(y, 0) + "','" + this.xmodelo.getValueAt(y, 3) + "','" + Principal.usuarioSistemaDTO.getLogin() + "') ";
                    this.xconsulta.ejecutarSQL(sql2);
                    this.xconsulta.cerrarConexionBd();
                }
            }
            for (int y2 = 0; y2 < this.JTDetalleCro.getRowCount(); y2++) {
                if (Boolean.valueOf(this.xmodelo2.getValueAt(y2, 2).toString()).booleanValue()) {
                    String sql3 = "INSERT INTO o_examen_dentario_detalle(`IdExamen`  , `IdConceptos` , `Observacion` , `UsuarioS`) VALUES ('" + this.xexamen + "','" + this.xmodelo2.getValueAt(y2, 0) + "','" + this.xmodelo2.getValueAt(y2, 3) + "','" + Principal.usuarioSistemaDTO.getLogin() + "') ";
                    this.xconsulta.ejecutarSQL(sql3);
                    this.xconsulta.cerrarConexionBd();
                }
            }
            this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
            this.JBGuardar.setEnabled(false);
        }
    }

    private void mBuscarExamen() {
        String sql2;
        String sql3;
        mCrearCronologia();
        mCrearModelo();
        String sql = "SELECT `Id` , `IdTratamiento` , `Bogue`  , `Mayo35` , `Mayo42` , `Mayo47` , `Micro` FROM `o_examen_dentario` WHERE (`IdTratamiento` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "');";
        ResultSet xrs = this.xconsulta.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                this.xexamen = xrs.getString("Id");
                this.JTFFBogue.setValue(Double.valueOf(xrs.getDouble("Bogue")));
                this.JTFF35.setValue(Double.valueOf(xrs.getDouble("Mayo35")));
                this.JTFF42.setValue(Double.valueOf(xrs.getDouble("Mayo42")));
                this.JTFF47.setValue(Double.valueOf(xrs.getDouble("Mayo47")));
                if (xrs.getLong("Micro") == 0) {
                    this.JRBMicro.setSelected(true);
                } else {
                    this.JRBMacro.setSelected(true);
                }
                this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
                this.JBGuardar.setEnabled(false);
            }
            if (this.xexamen.equals("")) {
                sql2 = "SELECT `Id` , `Nbre` FROM `o_examen_dentario_conceptos` WHERE (`Estado` =1 AND Grupo=1) ORDER BY Nbre ASC";
            } else {
                sql2 = "SELECT  `o_examen_dentario_detalle`.`IdConceptos` ,`o_examen_dentario_conceptos`.`Nbre`  , `o_examen_dentario_detalle`.`Observacion`  FROM `o_examen_dentario_detalle` INNER JOIN  `o_examen_dentario_conceptos`  ON (`o_examen_dentario_detalle`.`IdConceptos` = `o_examen_dentario_conceptos`.`Id`)  WHERE (`o_examen_dentario_detalle`.`IdExamen` ='" + xrs.getInt("Id") + "'  AND `o_examen_dentario_conceptos`.`Grupo` =1)";
            }
            ResultSet xrs2 = this.xconsulta.traerRs(sql2);
            if (xrs2.next()) {
                int n = 0;
                xrs2.beforeFirst();
                while (xrs2.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs2.getInt(1)), n, 0);
                    this.xmodelo.setValueAt(xrs2.getString(2), n, 1);
                    if (!this.xexamen.equals("")) {
                        this.xmodelo.setValueAt(true, n, 2);
                        this.xmodelo.setValueAt(xrs2.getString(3), n, 3);
                    } else {
                        this.xmodelo.setValueAt(false, n, 2);
                        this.xmodelo.setValueAt("", n, 3);
                    }
                    n++;
                }
            }
            xrs2.close();
            if (this.xexamen.equals("")) {
                sql3 = "SELECT `Id` , `Nbre` FROM `o_examen_dentario_conceptos` WHERE (`Estado` =1 AND Grupo=2) ORDER BY Nbre ASC";
            } else {
                sql3 = "SELECT  `o_examen_dentario_detalle`.`IdConceptos` ,`o_examen_dentario_conceptos`.`Nbre`  , `o_examen_dentario_detalle`.`Observacion`  FROM `o_examen_dentario_detalle` INNER JOIN  `o_examen_dentario_conceptos`  ON (`o_examen_dentario_detalle`.`IdConceptos` = `o_examen_dentario_conceptos`.`Id`)  WHERE (`o_examen_dentario_detalle`.`IdExamen` ='" + xrs.getInt("Id") + "'  AND `o_examen_dentario_conceptos`.`Grupo` =2)";
            }
            ResultSet xrs3 = this.xconsulta.traerRs(sql3);
            if (xrs3.next()) {
                int n2 = 0;
                xrs3.beforeFirst();
                while (xrs3.next()) {
                    this.xmodelo2.addRow(this.xdato);
                    this.xmodelo2.setValueAt(Integer.valueOf(xrs3.getInt(1)), n2, 0);
                    this.xmodelo2.setValueAt(xrs3.getString(2), n2, 1);
                    if (!this.xexamen.equals("")) {
                        this.xmodelo2.setValueAt(true, n2, 2);
                        this.xmodelo2.setValueAt(xrs3.getString(3), n2, 3);
                    } else {
                        this.xmodelo2.setValueAt(false, n2, 2);
                        this.xmodelo2.setValueAt("", n2, 3);
                    }
                    n2++;
                }
            }
            xrs3.close();
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPExamenDentario.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v64, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGMedida = new ButtonGroup();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPEncabezado = new JPanel();
        this.JTFFBogue = new JFormattedTextField();
        this.JPMayoral = new JPanel();
        this.JTFF35 = new JFormattedTextField();
        this.JTFF42 = new JFormattedTextField();
        this.JTFF47 = new JFormattedTextField();
        this.JRBMicro = new JRadioButton();
        this.JRBMacro = new JRadioButton();
        this.JBGuardar = new JButton();
        this.JSPDetalleCro = new JScrollPane();
        this.JTDetalleCro = new JTable();
        setName("jpexamendentario");
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JPEncabezado.setBorder(BorderFactory.createTitledBorder((Border) null, "MEDIDA TRANSVERSAL", 2, 0, new Font("Arial", 1, 14), new Color(0, 107, 0)));
        this.JTFFBogue.setBorder(BorderFactory.createTitledBorder((Border) null, "Bogue", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFBogue.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFBogue.setHorizontalAlignment(4);
        this.JTFFBogue.setFont(new Font("Arial", 1, 12));
        this.JPMayoral.setBorder(BorderFactory.createTitledBorder((Border) null, "Mayoral", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFF35.setBorder(BorderFactory.createTitledBorder((Border) null, "35mm", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFF35.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFF35.setHorizontalAlignment(4);
        this.JTFF35.setFont(new Font("Arial", 1, 12));
        this.JTFF42.setBorder(BorderFactory.createTitledBorder((Border) null, "42mm", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFF42.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFF42.setHorizontalAlignment(4);
        this.JTFF42.setFont(new Font("Arial", 1, 12));
        this.JTFF47.setBorder(BorderFactory.createTitledBorder((Border) null, "47mm", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFF47.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFF47.setHorizontalAlignment(4);
        this.JTFF47.setFont(new Font("Arial", 1, 12));
        GroupLayout JPMayoralLayout = new GroupLayout(this.JPMayoral);
        this.JPMayoral.setLayout(JPMayoralLayout);
        JPMayoralLayout.setHorizontalGroup(JPMayoralLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPMayoralLayout.createSequentialGroup().addComponent(this.JTFF35, -2, 88, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFF42, -2, 88, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFF47, -2, 88, -2).addGap(3, 3, 3)));
        JPMayoralLayout.setVerticalGroup(JPMayoralLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPMayoralLayout.createSequentialGroup().addGroup(JPMayoralLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFF35, -2, 50, -2).addComponent(this.JTFF42, -2, 50, -2).addComponent(this.JTFF47, -2, 50, -2)).addGap(3, 3, 3)));
        this.JBGMedida.add(this.JRBMicro);
        this.JRBMicro.setFont(new Font("Arial", 1, 12));
        this.JRBMicro.setSelected(true);
        this.JRBMicro.setText("Micrognatismo");
        this.JRBMicro.addActionListener(new ActionListener() { // from class: Odontologia.JPExamenDentario.3
            public void actionPerformed(ActionEvent evt) {
                JPExamenDentario.this.JRBMicroActionPerformed(evt);
            }
        });
        this.JBGMedida.add(this.JRBMacro);
        this.JRBMacro.setFont(new Font("Arial", 1, 12));
        this.JRBMacro.setText("Macrognatismo");
        this.JRBMacro.addActionListener(new ActionListener() { // from class: Odontologia.JPExamenDentario.4
            public void actionPerformed(ActionEvent evt) {
                JPExamenDentario.this.JRBMacroActionPerformed(evt);
            }
        });
        GroupLayout JPEncabezadoLayout = new GroupLayout(this.JPEncabezado);
        this.JPEncabezado.setLayout(JPEncabezadoLayout);
        JPEncabezadoLayout.setHorizontalGroup(JPEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPEncabezadoLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFFBogue, -2, 88, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPMayoral, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBMicro).addGap(18, 18, 18).addComponent(this.JRBMacro).addGap(157, 157, 157)));
        JPEncabezadoLayout.setVerticalGroup(JPEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPEncabezadoLayout.createSequentialGroup().addGroup(JPEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPEncabezadoLayout.createSequentialGroup().addGap(6, 6, 6).addComponent(this.JPMayoral, -2, -1, -2).addGap(5, 5, 5)).addGroup(JPEncabezadoLayout.createSequentialGroup().addGap(36, 36, 36).addGroup(JPEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBMicro).addComponent(this.JRBMacro)).addGap(23, 23, 23))).addGroup(JPEncabezadoLayout.createSequentialGroup().addGap(23, 23, 23).addComponent(this.JTFFBogue, -2, 50, -2))).addContainerGap(9, 32767)));
        this.JBGuardar.setFont(new Font("Arial", 1, 12));
        this.JBGuardar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBGuardar.setText("Guardar");
        this.JBGuardar.addActionListener(new ActionListener() { // from class: Odontologia.JPExamenDentario.5
            public void actionPerformed(ActionEvent evt) {
                JPExamenDentario.this.JBGuardarActionPerformed(evt);
            }
        });
        this.JSPDetalleCro.setBorder(BorderFactory.createTitledBorder((Border) null, "CRONOLOGÍA DE LA ERUPCIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTDetalleCro.setFont(new Font("Arial", 1, 12));
        this.JTDetalleCro.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleCro.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleCro.setSelectionForeground(new Color(255, 0, 0));
        this.JSPDetalleCro.setViewportView(this.JTDetalleCro);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle).addComponent(this.JPEncabezado, -1, -1, 32767).addComponent(this.JBGuardar, -1, -1, 32767).addComponent(this.JSPDetalleCro, GroupLayout.Alignment.TRAILING)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(11, 11, 11).addComponent(this.JPEncabezado, -2, -1, -2).addGap(7, 7, 7).addComponent(this.JSPDetalle, -2, 248, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalleCro, -2, 148, -2).addGap(10, 10, 10).addComponent(this.JBGuardar, -2, 34, -2).addContainerGap(-1, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBMicroActionPerformed(ActionEvent evt) {
        this.xmicro = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBMacroActionPerformed(ActionEvent evt) {
        this.xmicro = 1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGuardarActionPerformed(ActionEvent evt) {
        mGuardar();
    }
}
