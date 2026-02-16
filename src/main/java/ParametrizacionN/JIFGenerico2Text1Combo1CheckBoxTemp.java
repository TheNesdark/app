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
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFGenerico2Text1Combo1CheckBoxTemp.class */
public class JIFGenerico2Text1Combo1CheckBoxTemp extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String xnombre;
    private String xsql;
    private String[] xidgenerico;
    private String[] xidgenerico2;
    private JComboBox JCBGenerico;
    private JComboBox JCBGenerico2;
    private JCheckBox JCHEstado;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JSpinner JSPUno;
    private JTable JTDetalle;
    private JFormattedTextField JTFFHoraMaxima;
    private JFormattedTextField JTFFHoraMinima;
    private JFormattedTextField JTFFVMaximo;
    private JFormattedTextField JTFFVMinimo;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 1;
    private boolean xestadog = false;
    private boolean grabado = false;
    private String idTipo = "";

    public JIFGenerico2Text1Combo1CheckBoxTemp(String xnombre, String xnombref) {
        initComponents();
        setName(xnombref);
        setTitle(xnombre.toUpperCase());
        this.xnombre = xnombre;
        mIniciarComponentes();
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v72, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JCHEstado = new JCheckBox();
        this.jPanel1 = new JPanel();
        this.JTFFVMinimo = new JFormattedTextField();
        this.JTFFVMaximo = new JFormattedTextField();
        this.jPanel2 = new JPanel();
        this.JTFFHoraMinima = new JFormattedTextField();
        this.JTFFHoraMaxima = new JFormattedTextField();
        this.JCBGenerico2 = new JComboBox();
        this.JSPUno = new JSpinner();
        this.JCBGenerico = new JComboBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("GENERICO3");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifgenerico3");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: ParametrizacionN.JIFGenerico2Text1Combo1CheckBoxTemp.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFGenerico2Text1Combo1CheckBoxTemp.this.formInternalFrameClosing(evt);
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameOpened(InternalFrameEvent evt) {
            }
        });
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGenerico2Text1Combo1CheckBoxTemp.2
            public void actionPerformed(ActionEvent evt) {
                JIFGenerico2Text1Combo1CheckBoxTemp.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "Temperaturas", 2, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFVMinimo.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Mínimo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFVMinimo.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.00"))));
        this.JTFFVMinimo.setHorizontalAlignment(4);
        this.JTFFVMinimo.setFont(new Font("Arial", 1, 12));
        this.JTFFVMaximo.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Máximo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFVMaximo.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.00"))));
        this.JTFFVMaximo.setHorizontalAlignment(4);
        this.JTFFVMaximo.setFont(new Font("Arial", 1, 12));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFFVMinimo, -2, 100, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JTFFVMaximo, -2, 100, -2).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFVMinimo, -2, -1, -2).addComponent(this.JTFFVMaximo))));
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "Horario HH:MM:SS", 2, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFHoraMinima.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora Mínima", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFHoraMinima.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("HH:mm:ss"))));
        this.JTFFHoraMinima.setHorizontalAlignment(4);
        this.JTFFHoraMinima.setFont(new Font("Arial", 1, 12));
        this.JTFFHoraMaxima.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora Máxima", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFHoraMaxima.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("HH:mm:ss"))));
        this.JTFFHoraMaxima.setHorizontalAlignment(4);
        this.JTFFHoraMaxima.setFont(new Font("Arial", 1, 12));
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFFHoraMinima, -2, 100, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 42, 32767).addComponent(this.JTFFHoraMaxima, -2, 100, -2).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFHoraMinima, -2, -1, -2).addComponent(this.JTFFHoraMaxima))));
        this.JCBGenerico2.setFont(new Font("Arial", 1, 12));
        this.JCBGenerico2.setBorder(BorderFactory.createTitledBorder((Border) null, "Municipio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPUno.setFont(new Font("Arial", 1, 12));
        this.JSPUno.setBorder(BorderFactory.createTitledBorder((Border) null, "Orden", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBGenerico.setFont(new Font("Arial", 1, 12));
        this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "Municipio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBGenerico, 0, -1, 32767).addComponent(this.jPanel1, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jPanel2, -1, -1, 32767).addComponent(this.JCBGenerico2, 0, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHEstado).addComponent(this.JSPUno, -2, 106, -2)).addGap(170, 170, 170)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBGenerico2, -2, -1, -2).addComponent(this.JCHEstado).addComponent(this.JCBGenerico, -2, -1, -2)).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGap(35, 35, 35).addComponent(this.JSPUno, -2, 49, -2).addGap(0, 0, 32767)).addGroup(JPIDatosLayout.createSequentialGroup().addGap(17, 17, 17).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jPanel2, -1, -1, 32767).addComponent(this.jPanel1, -1, -1, 32767)).addContainerGap(22, 32767)))));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFGenerico2Text1Combo1CheckBoxTemp.3
            public void mouseClicked(MouseEvent evt) {
                JIFGenerico2Text1Combo1CheckBoxTemp.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatos, -2, 726, 32767).addComponent(this.JSPDetalle)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JSPDetalle, -2, 192, -2).addContainerGap(23, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.xestado = 1;
        } else {
            this.xestado = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            this.JCBGenerico2.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JTFFHoraMinima.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JTFFHoraMaxima.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            this.JCBGenerico.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString());
            this.JTFFVMinimo.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString()));
            this.JTFFVMaximo.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString()));
            this.JSPUno.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString()));
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 8).toString()).booleanValue());
            if (this.JCHEstado.isSelected()) {
                this.xestado = 1;
            } else {
                this.xestado = 0;
            }
            this.xestadog = true;
            this.grabado = true;
            this.idTipo = this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    public void mNuevo() {
        this.JCBGenerico.setSelectedIndex(-1);
        this.JCBGenerico2.setSelectedIndex(-1);
        this.JCHEstado.setSelected(true);
        this.JTFFVMinimo.setValue(new Integer(0));
        this.JTFFVMaximo.setValue(new Integer(0));
        this.JTFFHoraMinima.setText("");
        this.JTFFHoraMaxima.setText("");
        this.JSPUno.setValue(1);
        this.xestado = 1;
        this.xestadog = false;
    }

    public void mGrabar() {
        String sql;
        if (this.JCBGenerico.getSelectedIndex() != -1) {
            if (this.JCBGenerico2.getSelectedIndex() != -1) {
                if (!this.JTFFVMinimo.getText().isEmpty()) {
                    if (!this.JTFFVMaximo.getText().isEmpty()) {
                        if (!this.JTFFHoraMinima.getText().isEmpty()) {
                            if (this.JTFFHoraMaxima.getText().isEmpty()) {
                                JOptionPane.showInternalMessageDialog(this, "Debe digitar la Hora máxima", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                this.JTFFHoraMaxima.requestFocus();
                                return;
                            }
                            if (Double.parseDouble(this.JTFFVMaximo.getValue().toString()) > Double.parseDouble(this.JTFFVMinimo.getValue().toString())) {
                                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                if (n == 0) {
                                    if (this.grabado) {
                                        sql = " update i_bodegaxhorariomed set Id_bodega='" + Principal.txtNo.getText() + "',Id_tipomedicion='" + this.xidgenerico[this.JCBGenerico.getSelectedIndex()] + "',Id_JornadaMed='" + this.xidgenerico2[this.JCBGenerico2.getSelectedIndex()] + "',HoraMimina='" + this.JTFFHoraMinima.getText() + "',HoraMaxima='" + this.JTFFHoraMaxima.getText() + "',TempMinima='" + this.JTFFVMinimo.getValue() + "',TempMaxima='" + this.JTFFVMaximo.getValue() + "',Orden='" + this.JSPUno.getValue() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString() + "'";
                                        this.grabado = false;
                                    } else {
                                        sql = " Insert ignore into i_bodegaxhorariomed(`Id_bodega` , `Id_tipomedicion`, `Id_JornadaMed`, `HoraMimina` , `HoraMaxima`, `TempMinima`, `TempMaxima`, `Orden`, `Estado`, `Fecha`, `UsuarioS`)  values ('" + Principal.txtNo.getText() + "','" + this.xidgenerico[this.JCBGenerico.getSelectedIndex()] + "','" + this.xidgenerico2[this.JCBGenerico2.getSelectedIndex()] + "','" + this.JTFFHoraMinima.getText() + "','" + this.JTFFHoraMaxima.getText() + "','" + this.JTFFVMinimo.getValue() + "','" + this.JTFFVMaximo.getValue() + "','" + this.JSPUno.getValue() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                    }
                                    System.out.println("Consulta -> " + sql);
                                    this.xconsulta.ejecutarSQL(sql);
                                    this.xconsulta.cerrarConexionBd();
                                    mCargarDatosTabla();
                                    mNuevo();
                                    return;
                                }
                                return;
                            }
                            JOptionPane.showInternalMessageDialog(this, "El valor de la Temperatura maxima debe ser Mayor al Minimo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            this.JTFFVMaximo.requestFocus();
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "Debe digitar la Hora Minima", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JTFFHoraMinima.requestFocus();
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Debe digitar el valor máximo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTFFVMaximo.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe digitar el valor minimo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFFVMinimo.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una Jornada", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBGenerico2.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un Tipo de Medición", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBGenerico.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Jornada Medición", "Hora Min", "Hora Max", "Tipo Medición", "Temp Minima", "Temp Máxima", "Orden", "Estado"}) { // from class: ParametrizacionN.JIFGenerico2Text1Combo1CheckBoxTemp.4
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, Double.class, Double.class, Long.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(7);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(7);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(15);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            String sql = "SELECT `i_bodegaxhorariomed`.`Id`, `i_jornadamedicion`.`Nbre` , `i_bodegaxhorariomed`.`HoraMimina` , `i_bodegaxhorariomed`.`HoraMaxima`, CONCAT(`i_tipo_medicion`.`Nbre`,' (', `i_unidadmedida`.`Nbre`,')') AS medida , `i_bodegaxhorariomed`.`TempMinima`, `i_bodegaxhorariomed`.`TempMaxima`, `i_bodegaxhorariomed`.`Orden`, `i_bodegaxhorariomed`.`Estado`FROM `i_bodegaxhorariomed` INNER JOIN `baseserver`.`i_jornadamedicion` ON (`i_bodegaxhorariomed`.`Id_JornadaMed` = `i_jornadamedicion`.`Id`)INNER JOIN `i_tipo_medicion` ON (`i_bodegaxhorariomed`.`Id_tipomedicion` = `i_tipo_medicion`.`Id`) INNER JOIN `i_unidadmedida`  ON (`i_tipo_medicion`.`Id_UMedida` = `i_unidadmedida`.`Id`) WHERE (`i_bodegaxhorariomed`.`Id_bodega` ='" + Principal.txtNo.getText() + "')";
            ResultSet xrs = this.xconsulta.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(6)), n, 5);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(7)), n, 6);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(8)), n, 7);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(9)), n, 8);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGenerico2Text1Combo1CheckBoxTemp.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mIniciarComponentes() {
        this.JCBGenerico.removeAllItems();
        this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Medición", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.xidgenerico = this.xconsulta.llenarCombo("SELECT  `i_tipo_medicion`.`Id`, CONCAT(`i_tipo_medicion`.`Nbre`,' (', `i_unidadmedida`.`Nbre`,')') AS medida FROM `i_tipo_medicion` INNER JOIN `i_unidadmedida`  ON (`i_tipo_medicion`.`Id_UMedida` = `i_unidadmedida`.`Id`) WHERE (`i_tipo_medicion`.`Estado` =1) ORDER BY `i_tipo_medicion`.`Nbre`;", this.xidgenerico, this.JCBGenerico);
        this.JCBGenerico.setSelectedIndex(-1);
        this.JCBGenerico2.removeAllItems();
        this.JCBGenerico2.setBorder(BorderFactory.createTitledBorder((Border) null, "Jornada de Medición", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.xidgenerico2 = this.xconsulta.llenarCombo("SELECT `Id`, `Nbre` FROM `i_jornadamedicion` WHERE (`Estado` =1)", this.xidgenerico2, this.JCBGenerico2);
        this.JCBGenerico2.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
    }
}
