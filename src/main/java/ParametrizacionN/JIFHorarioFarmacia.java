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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFHorarioFarmacia.class */
public class JIFHorarioFarmacia extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private JCheckBox JCHEsLaboral;
    private JCheckBox JCHEstado;
    private JScrollPane JSDetalle;
    private JTable JTDetalle;
    public JFormattedTextField JTFFHoraFinal;
    public JFormattedTextField JTFFHoraInicial;
    private JTextField JTFNombre;
    private JPanel jPanel1;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 0;
    private int xeslaboral = 0;
    String sql = null;

    public JIFHorarioFarmacia() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v40, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JTFNombre = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JTFFHoraFinal = new JFormattedTextField();
        this.JTFFHoraInicial = new JFormattedTextField();
        this.JCHEsLaboral = new JCheckBox();
        this.JSDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("HORARIO DE FARMACIA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("Horario de Farmacia");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setToolTipText("Digite el nombre del municipio");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFHorarioFarmacia.1
            public void actionPerformed(ActionEvent evt) {
                JIFHorarioFarmacia.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JTFFHoraFinal.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFHoraFinal.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(DateFormat.getTimeInstance(2))));
        this.JTFFHoraFinal.setFont(new Font("Tahoma", 1, 12));
        this.JTFFHoraInicial.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFHoraInicial.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(DateFormat.getTimeInstance(2))));
        this.JTFFHoraInicial.setFont(new Font("Tahoma", 1, 12));
        this.JCHEsLaboral.setFont(new Font("Arial", 1, 12));
        this.JCHEsLaboral.setSelected(true);
        this.JCHEsLaboral.setText("Es Laboral?");
        this.JCHEsLaboral.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFHorarioFarmacia.2
            public void actionPerformed(ActionEvent evt) {
                JIFHorarioFarmacia.this.JCHEsLaboralActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JTFNombre, -2, 250, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFHoraInicial, -2, 90, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFHoraFinal, -2, 90, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEsLaboral).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEstado, -2, 75, -2).addContainerGap(-1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGap(2, 2, 2).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombre, -2, -1, -2).addComponent(this.JCHEstado).addComponent(this.JTFFHoraFinal).addComponent(this.JTFFHoraInicial).addComponent(this.JCHEsLaboral)).addGap(8, 8, 8)));
        this.JSDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFHorarioFarmacia.3
            public void mouseClicked(MouseEvent evt) {
                JIFHorarioFarmacia.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JSDetalle).addComponent(this.jPanel1, -1, -1, 32767)).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSDetalle, -2, 290, -2).addContainerGap(-1, 32767)));
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
    public void JCHEsLaboralActionPerformed(ActionEvent evt) {
        if (this.JCHEsLaboral.isSelected()) {
            this.xeslaboral = 0;
        } else {
            this.xeslaboral = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            SimpleDateFormat xhora = new SimpleDateFormat("HH:mm");
            try {
                this.JTFFHoraInicial.setValue(xhora.parse(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()));
            } catch (ParseException ex) {
                Logger.getLogger(JIFHorarioFarmacia.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
            try {
                this.JTFFHoraFinal.setValue(xhora.parse(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()));
            } catch (ParseException ex2) {
                Logger.getLogger(JIFHorarioFarmacia.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
            }
            this.JCHEsLaboral.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()).booleanValue());
            if (this.JCHEsLaboral.isSelected()) {
                this.xeslaboral = 0;
            } else {
                this.xeslaboral = 1;
            }
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString()).booleanValue());
            if (this.JCHEstado.isSelected()) {
                this.xestado = 1;
            } else {
                this.xestado = 0;
            }
        }
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JTFNombre.setText("");
        this.JTFFHoraInicial.setValue(this.xmetodos.getFechaActual());
        this.JTFFHoraFinal.setValue(this.xmetodos.getFechaActual());
        this.JCHEsLaboral.setSelected(true);
        this.JCHEstado.setSelected(true);
        this.xestado = 1;
        this.xeslaboral = 0;
        mCargarDatostabla();
    }

    public void mGrabar() {
        if (!this.JTFNombre.getText().isEmpty()) {
            if (!this.JTFFHoraInicial.getText().isEmpty()) {
                if (!this.JTFFHoraFinal.getText().isEmpty()) {
                    int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        this.sql = null;
                        if (Principal.txtNo.getText().isEmpty()) {
                            this.sql = "   INSERT INTO `g_horariofarmacia`(`NombreD`,`HoraInicial`, `HoraFinal`,`EsLaboral`,`Estado`,`Fecha`,`UsuarioS`)VALUES('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xmetodos.formatoH24.format(this.JTFFHoraInicial.getValue()) + "','" + this.xmetodos.formatoH24.format(this.JTFFHoraFinal.getValue()) + "','" + this.xeslaboral + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        } else {
                            this.sql = "UPDATE g_horariofarmacia SET `NombreD` = '" + this.JTFNombre.getText().toUpperCase() + "',`HoraInicial` = '" + this.xmetodos.formatoH24.format(this.JTFFHoraInicial.getValue()) + "',`HoraFinal` = '" + this.xmetodos.formatoH24.format(this.JTFFHoraFinal.getValue()) + "',`EsLaboral` = '" + this.xeslaboral + "',`Estado` = '" + this.xestado + "',`Fecha` = '" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "',`UsuarioS` = '" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE `Id` = '" + Principal.txtNo.getText() + "'";
                        }
                        this.xconsulta.ejecutarSQL(this.sql);
                        this.xconsulta.cerrarConexionBd();
                        mNuevo();
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "La hora final no puede ser nula", "VERFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFFHoraFinal.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "La hora inicial no puede ser nula", "VERFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFHoraInicial.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe digitar un nombre", "VERFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFNombre.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"ID", "Nombre", "Hora Inicial", "Hora Final", "Es Laboral?", "Estado"}) { // from class: ParametrizacionN.JIFHorarioFarmacia.4
            Class[] types = {Long.class, String.class, String.class, String.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
    }

    private void mCargarDatostabla() {
        try {
            mCrearModeloTabla();
            ResultSet xrs = this.xconsulta.traerRs("SELECT `Id`, `NombreD`, `HoraInicial`, `HoraFinal`, `EsLaboral`, `Estado` FROM `g_horariofarmacia`");
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                this.xmetodos.mEstablecerTextEditor(this.JTDetalle, 1);
                this.xmetodos.mEstablecerTextEditor(this.JTDetalle, 2);
                this.xmetodos.mEstablecerTextEditor(this.JTDetalle, 3);
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(Boolean.valueOf(!xrs.getBoolean(5)), n, 4);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(6)), n, 5);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFHorarioFarmacia.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
