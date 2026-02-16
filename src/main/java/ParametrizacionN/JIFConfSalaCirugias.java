package ParametrizacionN;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
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
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFConfSalaCirugias.class */
public class JIFConfSalaCirugias extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String xnombre;
    private String[] xsalacirugia;
    public JDateChooser CBOFechaConf;
    private JComboBox JCBSalaCirugia;
    private JCheckBox JCHEstado;
    private JFormattedTextField JFTHfinal;
    private JFormattedTextField JFTHinicial;
    private JPanel JPAgenda;
    private JPanel JPInformacion;
    private JRadioButton JREspecial;
    private JRadioButton JRMantenimiento;
    private JScrollPane JSDetalle;
    private JTable JTDetalle;
    private ButtonGroup RadioGroup;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 1;
    private int xagenda = 2;
    private boolean xestadog = false;
    private int Index = 1;

    public JIFConfSalaCirugias(String xnombre, String xtitulo) {
        initComponents();
        setTitle(xtitulo.toUpperCase());
        setName(xnombre);
        this.xnombre = xnombre;
        mIniciarComponentes();
        this.CBOFechaConf.setDate(this.xmetodos.getFechaActual());
        this.JFTHinicial.setValue(this.xmetodos.getFechaActual());
        this.JFTHfinal.setValue(this.xmetodos.getFechaActual());
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v55, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.RadioGroup = new ButtonGroup();
        this.JPAgenda = new JPanel();
        this.JREspecial = new JRadioButton();
        this.JRMantenimiento = new JRadioButton();
        this.JPInformacion = new JPanel();
        this.JFTHinicial = new JFormattedTextField();
        this.CBOFechaConf = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
        this.JFTHfinal = new JFormattedTextField();
        this.JCBSalaCirugia = new JComboBox();
        this.JCHEstado = new JCheckBox();
        this.JSDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONFIGURACIÓN AGENDA QUIRÓFANO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        this.JPAgenda.setBorder(BorderFactory.createTitledBorder((Border) null, "AGENDA", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.RadioGroup.add(this.JREspecial);
        this.JREspecial.setSelected(true);
        this.JREspecial.setText("Especial");
        this.JREspecial.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFConfSalaCirugias.1
            public void actionPerformed(ActionEvent evt) {
                JIFConfSalaCirugias.this.JREspecialActionPerformed(evt);
            }
        });
        this.RadioGroup.add(this.JRMantenimiento);
        this.JRMantenimiento.setText("Mantenimiento");
        this.JRMantenimiento.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFConfSalaCirugias.2
            public void actionPerformed(ActionEvent evt) {
                JIFConfSalaCirugias.this.JRMantenimientoActionPerformed(evt);
            }
        });
        GroupLayout JPAgendaLayout = new GroupLayout(this.JPAgenda);
        this.JPAgenda.setLayout(JPAgendaLayout);
        JPAgendaLayout.setHorizontalGroup(JPAgendaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPAgendaLayout.createSequentialGroup().addContainerGap().addGroup(JPAgendaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JREspecial).addComponent(this.JRMantenimiento)).addContainerGap(14, 32767)));
        JPAgendaLayout.setVerticalGroup(JPAgendaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPAgendaLayout.createSequentialGroup().addGap(8, 8, 8).addComponent(this.JREspecial).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 11, 32767).addComponent(this.JRMantenimiento).addContainerGap()));
        this.JPInformacion.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACION", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JFTHinicial.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora Inicia", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 204)));
        this.JFTHinicial.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("HH:mm"))));
        this.JFTHinicial.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFConfSalaCirugias.3
            public void actionPerformed(ActionEvent evt) {
                JIFConfSalaCirugias.this.JFTHinicialActionPerformed(evt);
            }
        });
        this.CBOFechaConf.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.CBOFechaConf.setDateFormatString("dd/MM/yyyy");
        this.CBOFechaConf.setName("txtFecha");
        this.CBOFechaConf.addFocusListener(new FocusAdapter() { // from class: ParametrizacionN.JIFConfSalaCirugias.4
            public void focusGained(FocusEvent evt) {
                JIFConfSalaCirugias.this.CBOFechaConfFocusGained(evt);
            }
        });
        this.CBOFechaConf.addPropertyChangeListener(new PropertyChangeListener() { // from class: ParametrizacionN.JIFConfSalaCirugias.5
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFConfSalaCirugias.this.CBOFechaConfPropertyChange(evt);
            }
        });
        this.JFTHfinal.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora Final", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 204)));
        this.JFTHfinal.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("HH:mm"))));
        this.JFTHfinal.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFConfSalaCirugias.6
            public void actionPerformed(ActionEvent evt) {
                JIFConfSalaCirugias.this.JFTHfinalActionPerformed(evt);
            }
        });
        this.JCBSalaCirugia.setFont(new Font("Arial", 1, 12));
        this.JCBSalaCirugia.setBorder(BorderFactory.createTitledBorder((Border) null, "Sala de Cirugia", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBSalaCirugia.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFConfSalaCirugias.7
            public void actionPerformed(ActionEvent evt) {
                JIFConfSalaCirugias.this.JCBSalaCirugiaActionPerformed(evt);
            }
        });
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setForeground(Color.blue);
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado", 0, 0, new Font("Tahoma", 0, 11), new Color(0, 51, 255)));
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFConfSalaCirugias.8
            public void actionPerformed(ActionEvent evt) {
                JIFConfSalaCirugias.this.JCHEstadoActionPerformed(evt);
            }
        });
        GroupLayout JPInformacionLayout = new GroupLayout(this.JPInformacion);
        this.JPInformacion.setLayout(JPInformacionLayout);
        JPInformacionLayout.setHorizontalGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPInformacionLayout.createSequentialGroup().addComponent(this.JCBSalaCirugia, 0, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.CBOFechaConf, -2, 120, -2).addGap(18, 18, 18).addComponent(this.JFTHinicial, -2, 100, -2).addGap(2, 2, 2).addComponent(this.JFTHfinal, -2, 100, -2).addGap(40, 40, 40).addComponent(this.JCHEstado, -2, 75, -2).addContainerGap()));
        JPInformacionLayout.setVerticalGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformacionLayout.createSequentialGroup().addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCHEstado).addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JFTHinicial, -2, -1, -2).addComponent(this.JFTHfinal, -2, -1, -2)).addComponent(this.JCBSalaCirugia, -2, -1, -2).addComponent(this.CBOFechaConf, -2, -1, -2))).addContainerGap(34, 32767)));
        this.JSDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORIAL", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JSDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFConfSalaCirugias.9
            public void mouseClicked(MouseEvent evt) {
                JIFConfSalaCirugias.this.JSDetalleMouseClicked(evt);
            }
        });
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFConfSalaCirugias.10
            public void mouseClicked(MouseEvent evt) {
                JIFConfSalaCirugias.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSDetalle, -1, 782, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JPInformacion, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPAgenda, -2, -1, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPAgenda, -2, -1, -2).addComponent(this.JPInformacion, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSDetalle, -1, 319, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CBOFechaConfFocusGained(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CBOFechaConfPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JFTHinicialActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JFTHfinalActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBSalaCirugiaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JCBSalaCirugia.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            SimpleDateFormat form_fecha = new SimpleDateFormat("dd/MM/yyyy");
            try {
                this.CBOFechaConf.setDate(form_fecha.parse(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()));
            } catch (ParseException ex) {
                Logger.getLogger(JIFConfSalaCirugias.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
            SimpleDateFormat xhora = new SimpleDateFormat("HH:mm");
            try {
                this.JFTHinicial.setValue(xhora.parse(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()));
            } catch (ParseException ex2) {
                Logger.getLogger(JIFConfSalaCirugias.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
            }
            try {
                this.JFTHfinal.setValue(xhora.parse(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()));
            } catch (ParseException ex3) {
                Logger.getLogger(JIFConfSalaCirugias.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex3);
            }
            if (2 == Integer.parseInt(String.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString()))) {
                this.xagenda = 2;
                this.JREspecial.setSelected(true);
            } else if (3 == Integer.parseInt(String.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString()))) {
                this.xagenda = 3;
                this.JRMantenimiento.setSelected(true);
            }
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString()).booleanValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSDetalleMouseClicked(MouseEvent evt) {
    }

    public void mNuevo() {
        Principal.txtNo.setText("");
        this.JCBSalaCirugia.setSelectedIndex(-1);
        this.CBOFechaConf.setDate(this.xmetodos.getFechaActual());
        this.JFTHinicial.setValue(this.xmetodos.getFechaActual());
        this.JFTHfinal.setValue(this.xmetodos.getFechaActual());
        this.JCHEstado.setSelected(true);
        this.JREspecial.setSelected(false);
        this.JRMantenimiento.setSelected(false);
        this.xestado = 1;
        this.xagenda = 2;
    }

    private boolean mValidarFecha(String Fecha) {
        boolean sw;
        String sql = "SELECT FechaFestivo FROM g_diafestivo Where Estado=1 and FechaFestivo=('" + Fecha + "')";
        String dato = this.xconsulta.traerDato(sql);
        if (dato.equals("")) {
            sw = false;
        } else {
            sw = true;
        }
        return sw;
    }

    private int mValidarCampos() {
        int retorno = 0;
        if (this.JCBSalaCirugia.getSelectedIndex() < 0) {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una sala de cirugia", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBSalaCirugia.requestFocus();
        } else if (this.JFTHinicial.getText().isEmpty()) {
            JOptionPane.showInternalMessageDialog(this, "La hora inicial no puede ser nula", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JFTHinicial.requestFocus();
        } else if (this.JFTHfinal.getText().isEmpty()) {
            JOptionPane.showInternalMessageDialog(this, "La hora Final no puede ser nula", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JFTHfinal.requestFocus();
        } else if (mValidarFecha(this.xmetodos.formatoAMD.format(this.CBOFechaConf.getDate()))) {
            int j = JOptionPane.showInternalConfirmDialog(this, "Esta Seguro de Configurar Quirofanos en un día Festivo?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            retorno = j == 0 ? 1 : 0;
        } else {
            retorno = 1;
        }
        return retorno;
    }

    public void mGrabar() {
        String sql;
        System.out.println(mValidarFecha(this.xmetodos.formatoAMD.format(this.CBOFechaConf.getDate())));
        if (mValidarCampos() == 1) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                if (Principal.txtNo.getText().isEmpty()) {
                    sql = " Insert into q_confsalacirugias(Id_SalaCirugia, Fecha_Conf, HoraInicial, HoraFinal, TipoAgenda, DiaSemana, Estado,Fecha, UsuarioS)  values ('" + this.xsalacirugia[this.JCBSalaCirugia.getSelectedIndex()] + "','" + this.xmetodos.formatoAMD.format(this.CBOFechaConf.getDate()) + "','" + this.xmetodos.formatoH24.format(this.JFTHinicial.getValue()) + "','" + this.xmetodos.formatoH24.format(this.JFTHfinal.getValue()) + "','" + this.xagenda + "','" + this.Index + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                } else {
                    sql = " update q_confsalacirugias set Id_SalaCirugia='" + this.xsalacirugia[this.JCBSalaCirugia.getSelectedIndex()] + "',Fecha_Conf='" + this.xmetodos.formatoAMD.format(this.CBOFechaConf.getDate()) + "',HoraInicial='" + this.xmetodos.formatoH24.format(this.JFTHinicial.getValue()) + "', HoraFinal='" + this.xmetodos.formatoH24.format(this.JFTHfinal.getValue()) + "',TipoAgenda='" + this.xagenda + "', DiaSemana='" + this.Index + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                }
                this.xconsulta.ejecutarSQL(sql);
                this.xconsulta.cerrarConexionBd();
                mCargarDatosTabla();
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Sala de Cirugias", "Fecha Configurada", "Hora Inicial", "Hora Final", "Tipo Agenda", "Id_TipoAgenda", "Estado"}) { // from class: ParametrizacionN.JIFConfSalaCirugias.11
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(10);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            ResultSet xrs = this.xconsulta.traerRs("SELECT `q_confsalacirugias`.`Id`, `q_salacirugias`.`Nbre` AS `Salacirugias`, DATE_FORMAT(q_confsalacirugias.Fecha_Conf,'%d/%m/%Y') as Fecha, `q_confsalacirugias`.`HoraInicial`\n , `q_confsalacirugias`.`HoraFinal`,IF(TipoAgenda=2,'Especial','Mantenimiento') AS tipo, `q_confsalacirugias`.`TipoAgenda`,  `q_confsalacirugias`.`Estado`\nFROM `q_salacirugias` INNER JOIN `q_confsalacirugias` ON (`q_salacirugias`.`Id` = `q_confsalacirugias`.`Id_SalaCirugia`)\nORDER BY  Fecha_Conf ASC, `Salacirugias` ASC;");
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelo.setValueAt(xrs.getString(7), n, 6);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(8)), n, 7);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConfSalaCirugias.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mIniciarComponentes() {
        this.xsalacirugia = this.xconsulta.llenarCombo("SELECT `Id`,`Nbre` FROM `q_salacirugias` ORDER BY Nbre ASC;", this.xsalacirugia, this.JCBSalaCirugia);
        this.JCBSalaCirugia.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
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
    public void JREspecialActionPerformed(ActionEvent evt) {
        this.xagenda = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRMantenimientoActionPerformed(ActionEvent evt) {
        this.xagenda = 3;
    }
}
