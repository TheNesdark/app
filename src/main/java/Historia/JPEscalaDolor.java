package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPEscalaDolor.class */
public class JPEscalaDolor extends JPanel {
    private int xValor;
    private DefaultTableModel xModelo;
    private Object[] xdatos;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private String xClasificacion = "";
    private JRadioButton JRB0;
    private JRadioButton JRB1;
    private JRadioButton JRB10;
    private JRadioButton JRB2;
    private JRadioButton JRB3;
    private JRadioButton JRB4;
    private JRadioButton JRB5;
    private JRadioButton JRB6;
    private JRadioButton JRB7;
    private JRadioButton JRB8;
    private JRadioButton JRB9;
    private JTextArea JTAObservacion;
    private JTable JTDetalle;
    private ButtonGroup escala;
    private JLabel jLabel1;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;

    public JPEscalaDolor() {
        initComponents();
        this.xValor = -1;
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v28, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.escala = new ButtonGroup();
        this.jPanel1 = new JPanel();
        this.JRB0 = new JRadioButton();
        this.JRB10 = new JRadioButton();
        this.JRB9 = new JRadioButton();
        this.JRB8 = new JRadioButton();
        this.JRB7 = new JRadioButton();
        this.JRB6 = new JRadioButton();
        this.JRB5 = new JRadioButton();
        this.JRB4 = new JRadioButton();
        this.JRB3 = new JRadioButton();
        this.JRB2 = new JRadioButton();
        this.JRB1 = new JRadioButton();
        this.jLabel1 = new JLabel();
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        this.jScrollPane2 = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        setName("xjifEscalaDolor");
        this.jPanel1.setBorder(BorderFactory.createEtchedBorder());
        this.jPanel1.setLayout((LayoutManager) null);
        this.escala.add(this.JRB0);
        this.JRB0.setOpaque(false);
        this.JRB0.addActionListener(new ActionListener() { // from class: Historia.JPEscalaDolor.1
            public void actionPerformed(ActionEvent evt) {
                JPEscalaDolor.this.JRB0ActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.JRB0);
        this.JRB0.setBounds(1, 13, 20, 21);
        this.escala.add(this.JRB10);
        this.JRB10.setOpaque(false);
        this.JRB10.addActionListener(new ActionListener() { // from class: Historia.JPEscalaDolor.2
            public void actionPerformed(ActionEvent evt) {
                JPEscalaDolor.this.JRB10ActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.JRB10);
        this.JRB10.setBounds(728, 13, 20, 21);
        this.escala.add(this.JRB9);
        this.JRB9.setOpaque(false);
        this.JRB9.addActionListener(new ActionListener() { // from class: Historia.JPEscalaDolor.3
            public void actionPerformed(ActionEvent evt) {
                JPEscalaDolor.this.JRB9ActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.JRB9);
        this.JRB9.setBounds(656, 13, 20, 21);
        this.escala.add(this.JRB8);
        this.JRB8.setOpaque(false);
        this.JRB8.addActionListener(new ActionListener() { // from class: Historia.JPEscalaDolor.4
            public void actionPerformed(ActionEvent evt) {
                JPEscalaDolor.this.JRB8ActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.JRB8);
        this.JRB8.setBounds(582, 13, 20, 21);
        this.escala.add(this.JRB7);
        this.JRB7.setOpaque(false);
        this.JRB7.addActionListener(new ActionListener() { // from class: Historia.JPEscalaDolor.5
            public void actionPerformed(ActionEvent evt) {
                JPEscalaDolor.this.JRB7ActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.JRB7);
        this.JRB7.setBounds(510, 13, 20, 21);
        this.escala.add(this.JRB6);
        this.JRB6.setOpaque(false);
        this.JRB6.addActionListener(new ActionListener() { // from class: Historia.JPEscalaDolor.6
            public void actionPerformed(ActionEvent evt) {
                JPEscalaDolor.this.JRB6ActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.JRB6);
        this.JRB6.setBounds(438, 13, 20, 21);
        this.escala.add(this.JRB5);
        this.JRB5.setOpaque(false);
        this.JRB5.addActionListener(new ActionListener() { // from class: Historia.JPEscalaDolor.7
            public void actionPerformed(ActionEvent evt) {
                JPEscalaDolor.this.JRB5ActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.JRB5);
        this.JRB5.setBounds(365, 13, 20, 21);
        this.escala.add(this.JRB4);
        this.JRB4.setOpaque(false);
        this.JRB4.addActionListener(new ActionListener() { // from class: Historia.JPEscalaDolor.8
            public void actionPerformed(ActionEvent evt) {
                JPEscalaDolor.this.JRB4ActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.JRB4);
        this.JRB4.setBounds(292, 13, 20, 21);
        this.escala.add(this.JRB3);
        this.JRB3.setOpaque(false);
        this.JRB3.addActionListener(new ActionListener() { // from class: Historia.JPEscalaDolor.9
            public void actionPerformed(ActionEvent evt) {
                JPEscalaDolor.this.JRB3ActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.JRB3);
        this.JRB3.setBounds(220, 13, 20, 21);
        this.escala.add(this.JRB2);
        this.JRB2.setOpaque(false);
        this.JRB2.addActionListener(new ActionListener() { // from class: Historia.JPEscalaDolor.10
            public void actionPerformed(ActionEvent evt) {
                JPEscalaDolor.this.JRB2ActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.JRB2);
        this.JRB2.setBounds(148, 13, 20, 21);
        this.escala.add(this.JRB1);
        this.JRB1.setOpaque(false);
        this.JRB1.addActionListener(new ActionListener() { // from class: Historia.JPEscalaDolor.11
            public void actionPerformed(ActionEvent evt) {
                JPEscalaDolor.this.JRB1ActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.JRB1);
        this.JRB1.setBounds(73, 13, 20, 21);
        this.jLabel1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/escala_del_dolor_v1.PNG")));
        this.jPanel1.add(this.jLabel1);
        this.jLabel1.setBounds(2, 2, 750, 153);
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.jScrollPane1.setViewportView(this.JTDetalle);
        this.JTAObservacion.setColumns(20);
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JTAObservacion.setLineWrap(true);
        this.JTAObservacion.setRows(1);
        this.JTAObservacion.setTabSize(1);
        this.JTAObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane2.setViewportView(this.JTAObservacion);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jScrollPane2).addComponent(this.jScrollPane1, GroupLayout.Alignment.TRAILING, -1, 754, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, 157, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane2, -2, 79, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane1, -1, 223, 32767).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB0ActionPerformed(ActionEvent evt) {
        this.xValor = 0;
        this.xClasificacion = "Muy contento sin dolor";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB1ActionPerformed(ActionEvent evt) {
        this.xValor = 1;
        this.xClasificacion = "Muy contento sin dolor";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB2ActionPerformed(ActionEvent evt) {
        this.xValor = 2;
        this.xClasificacion = "Muy contento sin dolor";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB3ActionPerformed(ActionEvent evt) {
        this.xValor = 3;
        this.xClasificacion = "Siente solo un poco de dolor";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB4ActionPerformed(ActionEvent evt) {
        this.xValor = 4;
        this.xClasificacion = "Siente solo un poco de dolor";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB5ActionPerformed(ActionEvent evt) {
        this.xValor = 5;
        this.xClasificacion = "Siente aún más dolor";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB6ActionPerformed(ActionEvent evt) {
        this.xValor = 6;
        this.xClasificacion = "Siente aún más dolor";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB7ActionPerformed(ActionEvent evt) {
        this.xValor = 7;
        this.xClasificacion = "Siente mucho dolor";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB8ActionPerformed(ActionEvent evt) {
        this.xValor = 8;
        this.xClasificacion = "Siente mucho dolor";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB9ActionPerformed(ActionEvent evt) {
        this.xValor = 9;
        this.xClasificacion = "El dolor es peor de lo que puede imaginarse";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB10ActionPerformed(ActionEvent evt) {
        this.xValor = 10;
        this.xClasificacion = "El dolor es peor de lo que puede imaginarse";
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xModelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Valor", "Clasificación", "Observación"}) { // from class: Historia.JPEscalaDolor.12
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(150);
    }

    private void mCargarDatosTabla() {
        try {
            String sql = " SELECT  `id`, `fechaR`, `valor`, `clasificacion`,  observacion FROM `h_escala_dolor`\n WHERE estado=1 AND idAtencion='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' ORDER BY id DESC";
            mCrearModeloDatos();
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xModelo.addRow(this.xdatos);
                    this.xModelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xModelo.setValueAt(xrs.getString(2), n, 1);
                    this.xModelo.setValueAt(xrs.getString(3), n, 2);
                    this.xModelo.setValueAt(xrs.getString(4), n, 3);
                    this.xModelo.setValueAt(xrs.getString(5), n, 4);
                    n++;
                }
                this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPEscalaDolor.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mGuardar() {
        if (this.xValor >= 0) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                String xsql = " INSERT INTO `h_escala_dolor`\n            (`idAtencion`,\n             `idUsuario`,\n             `fechaR`,\n             `valor`,\n             `clasificacion`,\n             `idProfesional`,\n             `observacion`,\n             `usuarioS`)\n VALUES ('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "',\n        '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "',\n        '" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "',\n        '" + this.xValor + "',\n        '" + this.xClasificacion + "',\n        '" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "',\n        '" + this.JTAObservacion.getText() + "',\n        '" + Principal.usuarioSistemaDTO.getLogin() + "');";
                this.xct.ejecutarSQL(xsql);
                this.xct.cerrarConexionBd();
                mCargarDatosTabla();
                this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una opción de la escala", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }
}
