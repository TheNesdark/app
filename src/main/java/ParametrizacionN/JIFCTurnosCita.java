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

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFCTurnosCita.class */
public class JIFCTurnosCita extends JInternalFrame {
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 0;
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private JCheckBox JCHEstado;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JFormattedTextField JTFFHoraFin;
    private JFormattedTextField JTFFHoraInicio;
    private JTextField JTFNombre;

    public JIFCTurnosCita() {
        initComponents();
        mCargarDatosTabla();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v28, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JTFNombre = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JTFFHoraInicio = new JFormattedTextField();
        this.JTFFHoraFin = new JFormattedTextField();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("TURNOS CITAS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifturnoscitas");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setToolTipText("");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFCTurnosCita.1
            public void actionPerformed(ActionEvent evt) {
                JIFCTurnosCita.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JTFFHoraInicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFHoraInicio.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("HH:mm:ss a"))));
        this.JTFFHoraInicio.setHorizontalAlignment(4);
        this.JTFFHoraInicio.setFont(new Font("Arial", 1, 12));
        this.JTFFHoraFin.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFHoraFin.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("HH:mm:ss a"))));
        this.JTFFHoraFin.setHorizontalAlignment(4);
        this.JTFFHoraFin.setFont(new Font("Arial", 1, 12));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JTFFHoraInicio, -2, 125, -2).addGap(18, 18, 18).addComponent(this.JTFFHoraFin, -2, 125, -2).addGap(18, 18, 18).addComponent(this.JCHEstado)).addComponent(this.JTFNombre, -1, 460, 32767)).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JTFNombre, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFHoraInicio, -2, -1, -2).addComponent(this.JTFFHoraFin, -2, -1, -2).addComponent(this.JCHEstado)).addGap(77, 77, 77)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFCTurnosCita.2
            public void mouseClicked(MouseEvent evt) {
                JIFCTurnosCita.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING, 0, 0, 32767).addComponent(this.JPIDatos, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, 163, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -1, 247, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.xestado = 0;
        } else {
            this.xestado = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            try {
                Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
                this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
                SimpleDateFormat xhora = new SimpleDateFormat("HH:mm:ss a");
                this.JTFFHoraInicio.setValue(xhora.parse(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()));
                this.JTFFHoraFin.setValue(xhora.parse(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()));
                this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()).booleanValue());
                if (this.JCHEstado.isSelected()) {
                    this.xestado = 0;
                } else {
                    this.xestado = 1;
                }
            } catch (ParseException ex) {
                Logger.getLogger(JIFCTurnosCita.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    public void mNuevo() {
        Principal.txtNo.setText("");
        this.JTFNombre.setText("");
        this.JTFFHoraInicio.setValue(this.xmetodos.getFechaActual());
        this.JTFFHoraFin.setValue(this.xmetodos.getFechaActual());
        this.JCHEstado.setSelected(true);
        this.xestado = 0;
        this.JTFNombre.requestFocus();
    }

    public void mGrabar() {
        String sql;
        if (!this.JTFNombre.getText().isEmpty()) {
            if (!this.JTFFHoraInicio.getText().isEmpty()) {
                if (!this.JTFFHoraInicio.getText().isEmpty()) {
                    int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        if (Principal.txtNo.getText().isEmpty()) {
                            sql = " Insert into c_turnos(Nbre, HoraI, HoraF, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText() + "','" + this.xmetodos.formatoH24.format(this.JTFFHoraInicio.getValue()) + "','" + this.xmetodos.formatoH24.format(this.JTFFHoraFin.getValue()) + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        } else {
                            sql = " update c_turnos set Nbre='" + this.JTFNombre.getText() + "',HoraI='" + this.xmetodos.formatoH24.format(this.JTFFHoraInicio.getValue()) + "',HoraF='" + this.xmetodos.formatoH24.format(this.JTFFHoraFin.getValue()) + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                        }
                        this.xconsulta.ejecutarSQL(sql);
                        this.xconsulta.cerrarConexionBd();
                        mCargarDatosTabla();
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "La hora final no puede ser nula", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFFHoraFin.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "La hora de inicio no puede ser nula", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFHoraInicio.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El campo código no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFNombre.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Hora Inicio", "Hora Fin", "Estado"}) { // from class: ParametrizacionN.JIFCTurnosCita.3
            Class[] types = {Long.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(30);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            ResultSet xrs = this.xconsulta.traerRs("SELECT Id, Nbre, DATE_FORMAT(HoraI,'%H:%m:%s %p') AS HoraI, DATE_FORMAT(HoraF,'%H:%m:%s %p') AS HoraF, Estado FROM c_turnos ORDER BY Nbre ASC");
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(Boolean.valueOf(!xrs.getBoolean(5)), n, 4);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFCTurnosCita.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
