package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPRuffier.class */
public class JPRuffier extends JPanel {
    public DefaultTableModel xmodelo;
    private Object[] xdatos;
    private long xEstadoHC;
    private JButton JBCalcular;
    private JLabel JLResultado;
    private JLabel JLValoracion;
    private JFormattedTextField JP0;
    private JFormattedTextField JP1;
    private JFormattedTextField JP2;
    private JScrollPane JSPDetalle;
    private JTable JTBDetalle;
    private JPanel jPanel1;
    ConsultasMySQL xct = new ConsultasMySQL();
    Metodos xmt = new Metodos();
    private boolean xexiste = false;

    public JPRuffier() {
        initComponents();
        mIniciaComponentes();
        mBuscaHistorico();
        mVerifica();
    }

    private void mIniciaComponentes() {
        this.JP0.setValue(0);
        this.JP1.setValue(0);
        this.JP2.setValue(0);
    }

    /* JADX WARN: Type inference failed for: r3v45, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JP0 = new JFormattedTextField();
        this.JP1 = new JFormattedTextField();
        this.JP2 = new JFormattedTextField();
        this.JLResultado = new JLabel();
        this.JLValoracion = new JLabel();
        this.JBCalcular = new JButton();
        this.JSPDetalle = new JScrollPane();
        this.JTBDetalle = new JTable();
        setName("jpRuffier");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JP0.setBorder(BorderFactory.createTitledBorder((Border) null, "P0", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JP0.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("###0"))));
        this.JP0.setHorizontalAlignment(0);
        this.JP0.setFont(new Font("Arial", 1, 12));
        this.JP1.setBorder(BorderFactory.createTitledBorder((Border) null, "P1", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JP1.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("###0"))));
        this.JP1.setHorizontalAlignment(0);
        this.JP1.setFont(new Font("Arial", 1, 12));
        this.JP2.setBorder(BorderFactory.createTitledBorder((Border) null, "P2", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JP2.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("###0"))));
        this.JP2.setHorizontalAlignment(0);
        this.JP2.setFont(new Font("Arial", 1, 12));
        this.JLResultado.setFont(new Font("Arial", 1, 12));
        this.JLResultado.setHorizontalAlignment(0);
        this.JLResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "Resultado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLValoracion.setFont(new Font("Arial", 1, 12));
        this.JLValoracion.setHorizontalAlignment(0);
        this.JLValoracion.setBorder(BorderFactory.createTitledBorder((Border) null, "Valoración", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBCalcular.setFont(new Font("Arial", 1, 12));
        this.JBCalcular.setText("Calcular");
        this.JBCalcular.addActionListener(new ActionListener() { // from class: Historia.JPRuffier.1
            public void actionPerformed(ActionEvent evt) {
                JPRuffier.this.JBCalcularActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.JP0, -2, 79, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JP1, -2, 79, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JP2, -2, 79, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLResultado, -2, 89, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLValoracion, -2, 221, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBCalcular).addContainerGap(23, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JLResultado, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JP0, -2, -1, -2).addComponent(this.JP1, -2, 39, -2).addComponent(this.JP2, -2, 39, -2)).addComponent(this.JLValoracion, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JBCalcular, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addGap(5, 5, 5)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDetalle.setRowHeight(25);
        this.JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDetalle.addMouseListener(new MouseAdapter() { // from class: Historia.JPRuffier.2
            public void mouseClicked(MouseEvent evt) {
                JPRuffier.this.JTBDetalleMouseClicked(evt);
            }
        });
        this.JTBDetalle.addKeyListener(new KeyAdapter() { // from class: Historia.JPRuffier.3
            public void keyPressed(KeyEvent evt) {
                JPRuffier.this.JTBDetalleKeyPressed(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTBDetalle);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.JSPDetalle)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JSPDetalle, -2, 280, -2).addContainerGap(134, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBCalcularActionPerformed(ActionEvent evt) {
        mCalcular();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleMouseClicked(MouseEvent evt) {
    }

    private void mCalcular() {
        double resultado = (((Integer.valueOf(this.JP0.getValue().toString()).intValue() + Integer.valueOf(this.JP1.getValue().toString()).intValue()) + Integer.valueOf(this.JP2.getValue().toString()).intValue()) - 200) / 10;
        this.JLResultado.setText("" + resultado);
        if (resultado <= 0.0d) {
            this.JLValoracion.setText("EXCELENTE");
            return;
        }
        if (resultado >= 1.0d && resultado <= 5.0d) {
            this.JLValoracion.setText("MUY BUENA");
            return;
        }
        if (resultado >= 6.0d && resultado <= 10.0d) {
            this.JLValoracion.setText("BUENA");
            return;
        }
        if (resultado >= 11.0d && resultado <= 15.0d) {
            this.JLValoracion.setText("SUFICIENTE");
        } else if (resultado >= 16.0d) {
            this.JLValoracion.setText("MALA");
        }
    }

    private void mBuscaHistorico() {
        mCrearModelo();
        try {
            String sql = "SELECT `id`, `fechaR`, `p0`, `p1`, `p2`, `resultado`, `valoracion` FROM `h_ruffier` WHERE  h_ruffier.`idUsuario`='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' AND h_ruffier.`Estado`=1 ORDER BY fechaR DESC";
            ResultSet xrs = this.xct.traerRs(sql);
            int x = 0;
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(1)), x, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), x, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), x, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), x, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), x, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), x, 5);
                    this.xmodelo.setValueAt(xrs.getString(7), x, 6);
                    x++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPFramingham.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "P0", "P1", "P2", "Resultado", "Valoración"}) { // from class: Historia.JPRuffier.4
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalle.setModel(this.xmodelo);
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(8);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(6).setPreferredWidth(50);
    }

    public void mGrabar() {
        String sql;
        if (!this.xmt.esIPSMineros()) {
            if (!this.xexiste) {
                if (!this.JLValoracion.getText().isEmpty()) {
                    int y = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (y == 0) {
                        String sql2 = " INSERT INTO `h_ruffier`\n            (`fechaR`,\n             `idAtencion`,\n             `idUsuario`,\n             `p0`,\n             `p1`,\n             `p2`,\n             `resultado`,\n             `valoracion`, UsuarioS)\n VALUES ('" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "',\n        '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "',\n        '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "',\n        '" + this.JP0.getValue() + "',\n        '" + this.JP1.getValue() + "',\n        '" + this.JP2.getValue() + "',\n        '" + this.JLResultado.getText() + "',\n        '" + this.JLValoracion.getText() + "',        '" + Principal.usuarioSistemaDTO.getLogin() + "');";
                        this.xct.ejecutarSQL(sql2);
                        this.xct.cerrarConexionBd();
                        mBuscaHistorico();
                        this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
                        this.xexiste = true;
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe realizar el cálculo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Este test ya fué diligenciado en la atención", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.xEstadoHC == 0) {
            if (!this.JLValoracion.getText().isEmpty()) {
                int y2 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (y2 == 0) {
                    if (!this.xexiste) {
                        sql = " INSERT INTO `h_ruffier`\n            (`fechaR`,\n             `idAtencion`,\n             `idUsuario`,\n             `p0`,\n             `p1`,\n             `p2`,\n             `resultado`,\n             `valoracion`, UsuarioS)\n VALUES ('" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "',\n        '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "',\n        '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "',\n        '" + this.JP0.getValue() + "',\n        '" + this.JP1.getValue() + "',\n        '" + this.JP2.getValue() + "',\n        '" + this.JLResultado.getText() + "',\n        '" + this.JLValoracion.getText() + "',        '" + Principal.usuarioSistemaDTO.getLogin() + "');";
                    } else {
                        sql = " UPDATE `h_ruffier` SET `p0`='" + this.JP0.getValue() + "',`p1`='" + this.JP1.getValue() + "',`p2`='" + this.JP2.getValue() + "',`resultado`='" + this.JLResultado.getText() + "',`valoracion`='" + this.JLValoracion.getText() + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE `idAtencion`='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "'";
                    }
                    this.xct.ejecutarSQL(sql);
                    this.xct.cerrarConexionBd();
                    mBuscaHistorico();
                    this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
                    this.xexiste = true;
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe realizar el cálculo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Esta historia clinica ya se encuentra cerrada", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private void mVerifica() {
        String sql = "SELECT\n\th_ruffier.`id`,\n\th_ruffier.`fechaR`,\n\th_ruffier.`p0`,\n\th_ruffier.`p1`,\n\th_ruffier.`p2`,\n\th_ruffier.`resultado`,\n\th_ruffier.`valoracion`,\n\t`h_atencion`.`TipoGuardado`\nFROM\n\t`h_ruffier`\nINNER JOIN `h_atencion` ON\n\t(h_ruffier.`idAtencion` = `h_atencion`.`Id`)\nWHERE\n\t(h_ruffier.`idAtencion` = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "'\n\tAND h_ruffier.`Estado` = 1)";
        try {
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.first();
                this.JP0.setText(xrs.getString("p0"));
                this.JP1.setText(xrs.getString("p1"));
                this.JP2.setText(xrs.getString("p2"));
                this.JLResultado.setText(xrs.getString("resultado"));
                this.JLValoracion.setText(xrs.getString("valoracion"));
                this.xEstadoHC = Long.parseLong(xrs.getString("TipoGuardado"));
                this.xexiste = true;
                this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPFramingham.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
