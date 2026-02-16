package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JD_NotasPredefinidas.class */
public class JD_NotasPredefinidas extends JDialog {
    private Metodos xmt;
    private ConsultasMySQL xct;
    private String xsql;
    private Object[] xDatos;
    private DefaultTableModel xModelo;
    private JTextPane xjpanel1;
    private JTextPane xjpanel2;
    private JTextArea xjpanel1_A;
    private JTextArea xjpanel2_A;
    private JTable tabla;
    private int xtipo;
    private int xtipobusqueda;
    private int numeroColumna;
    private ButtonGroup JBG_Utiliza;
    private JButton JBT_Cargar;
    private JButton JBT_Salir;
    private JPanel JPIH_Filtro;
    private JPanel JPI_FUtilizar;
    private JRadioButton JRB_Conclusion;
    private JRadioButton JRB_Recomendaicones;
    private JScrollPane JSP_PDetalle;
    private JTable JTB_PDetalle_NPredefinidas;
    private JTextField JTFBNombre;

    public JD_NotasPredefinidas(Frame parent, boolean modal, JTextPane xjpanel1, JTextPane xjpanel2, int xtipo) {
        super(parent, modal);
        this.xmt = new Metodos();
        this.xct = new ConsultasMySQL();
        this.xtipo = 0;
        this.xtipobusqueda = 0;
        this.numeroColumna = 0;
        initComponents();
        this.xtipo = xtipo;
        this.xjpanel1 = xjpanel1;
        this.xjpanel2 = xjpanel2;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        mCargarDatosTabla();
    }

    public JD_NotasPredefinidas(Frame parent, boolean modal, JTextArea xjpanel1, JTextArea xjpanel2, int xtipo) {
        super(parent, modal);
        this.xmt = new Metodos();
        this.xct = new ConsultasMySQL();
        this.xtipo = 0;
        this.xtipobusqueda = 0;
        this.numeroColumna = 0;
        initComponents();
        this.xtipo = xtipo;
        this.xjpanel1_A = xjpanel1;
        this.xjpanel2_A = xjpanel2;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG_Utiliza = new ButtonGroup();
        this.JSP_PDetalle = new JScrollPane();
        this.JTB_PDetalle_NPredefinidas = new JTable();
        this.JBT_Cargar = new JButton();
        this.JBT_Salir = new JButton();
        this.JPI_FUtilizar = new JPanel();
        this.JRB_Conclusion = new JRadioButton();
        this.JRB_Recomendaicones = new JRadioButton();
        this.JPIH_Filtro = new JPanel();
        this.JTFBNombre = new JTextField();
        setDefaultCloseOperation(2);
        setTitle("NOTAS PREDEFINIDAS");
        this.JSP_PDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTB_PDetalle_NPredefinidas.setFont(new Font("Arial", 1, 12));
        this.JTB_PDetalle_NPredefinidas.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_PDetalle_NPredefinidas.setRowHeight(25);
        this.JTB_PDetalle_NPredefinidas.setSelectionBackground(new Color(255, 255, 255));
        this.JTB_PDetalle_NPredefinidas.setSelectionForeground(Color.red);
        this.JSP_PDetalle.setViewportView(this.JTB_PDetalle_NPredefinidas);
        this.JBT_Cargar.setFont(new Font("Arial", 1, 12));
        this.JBT_Cargar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.JBT_Cargar.setText("Cargar");
        this.JBT_Cargar.addActionListener(new ActionListener() { // from class: Historia.JD_NotasPredefinidas.1
            public void actionPerformed(ActionEvent evt) {
                JD_NotasPredefinidas.this.JBT_CargarActionPerformed(evt);
            }
        });
        this.JBT_Cargar.addKeyListener(new KeyAdapter() { // from class: Historia.JD_NotasPredefinidas.2
            public void keyPressed(KeyEvent evt) {
                JD_NotasPredefinidas.this.JBT_CargarKeyPressed(evt);
            }
        });
        this.JBT_Salir.setFont(new Font("Arial", 1, 12));
        this.JBT_Salir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBT_Salir.setText("Salir");
        this.JBT_Salir.addActionListener(new ActionListener() { // from class: Historia.JD_NotasPredefinidas.3
            public void actionPerformed(ActionEvent evt) {
                JD_NotasPredefinidas.this.JBT_SalirActionPerformed(evt);
            }
        });
        this.JBT_Salir.addKeyListener(new KeyAdapter() { // from class: Historia.JD_NotasPredefinidas.4
            public void keyPressed(KeyEvent evt) {
                JD_NotasPredefinidas.this.JBT_SalirKeyPressed(evt);
            }
        });
        this.JPI_FUtilizar.setBorder(BorderFactory.createTitledBorder((Border) null, "Utilizar como?", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JBG_Utiliza.add(this.JRB_Conclusion);
        this.JRB_Conclusion.setFont(new Font("Arial", 1, 12));
        this.JRB_Conclusion.setSelected(true);
        this.JRB_Conclusion.setText("Conclusión");
        this.JBG_Utiliza.add(this.JRB_Recomendaicones);
        this.JRB_Recomendaicones.setFont(new Font("Arial", 1, 12));
        this.JRB_Recomendaicones.setText("Recomendaciones");
        GroupLayout JPI_FUtilizarLayout = new GroupLayout(this.JPI_FUtilizar);
        this.JPI_FUtilizar.setLayout(JPI_FUtilizarLayout);
        JPI_FUtilizarLayout.setHorizontalGroup(JPI_FUtilizarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FUtilizarLayout.createSequentialGroup().addContainerGap().addComponent(this.JRB_Conclusion).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_Recomendaicones).addContainerGap(-1, 32767)));
        JPI_FUtilizarLayout.setVerticalGroup(JPI_FUtilizarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FUtilizarLayout.createSequentialGroup().addGroup(JPI_FUtilizarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_Conclusion).addComponent(this.JRB_Recomendaicones)).addGap(0, 0, 32767)));
        this.JPIH_Filtro.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFBNombre.setFont(new Font("Arial", 1, 12));
        this.JTFBNombre.setToolTipText("");
        this.JTFBNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFBNombre.addActionListener(new ActionListener() { // from class: Historia.JD_NotasPredefinidas.5
            public void actionPerformed(ActionEvent evt) {
                JD_NotasPredefinidas.this.JTFBNombreActionPerformed(evt);
            }
        });
        this.JTFBNombre.addKeyListener(new KeyAdapter() { // from class: Historia.JD_NotasPredefinidas.6
            public void keyTyped(KeyEvent evt) {
                JD_NotasPredefinidas.this.JTFBNombreKeyTyped(evt);
            }
        });
        GroupLayout JPIH_FiltroLayout = new GroupLayout(this.JPIH_Filtro);
        this.JPIH_Filtro.setLayout(JPIH_FiltroLayout);
        JPIH_FiltroLayout.setHorizontalGroup(JPIH_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIH_FiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFBNombre).addContainerGap()));
        JPIH_FiltroLayout.setVerticalGroup(JPIH_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIH_FiltroLayout.createSequentialGroup().addComponent(this.JTFBNombre, -2, -1, -2).addContainerGap(-1, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSP_PDetalle).addGroup(layout.createSequentialGroup().addComponent(this.JPI_FUtilizar, -1, -1, 32767).addGap(18, 18, 18).addComponent(this.JBT_Cargar, -2, 310, -2).addGap(18, 18, 18).addComponent(this.JBT_Salir, -2, 310, -2)).addComponent(this.JPIH_Filtro, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(12, 12, 12).addComponent(this.JPIH_Filtro, -2, 72, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSP_PDetalle, -2, 218, -2).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBT_Cargar, -2, 50, -2).addComponent(this.JBT_Salir, -2, 50, -2)).addComponent(this.JPI_FUtilizar, -1, -1, 32767)).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_CargarKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            mCargarDato();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_SalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_SalirKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_CargarActionPerformed(ActionEvent evt) {
        mCargarDato();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFBNombreActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFBNombreKeyTyped(KeyEvent evt) {
        if (!this.JTFBNombre.getText().isEmpty()) {
            this.xtipobusqueda = 1;
            mCargarDatosTabla();
        } else {
            this.xtipobusqueda = 0;
            mCargarDatosTabla();
        }
    }

    private void mCargarDato() {
        if (this.xmt.mVerificarDatosTablaTrue(this.JTB_PDetalle_NPredefinidas, 2)) {
            String xdato = "";
            for (int x = 0; x < this.JTB_PDetalle_NPredefinidas.getRowCount(); x++) {
                if (Boolean.valueOf(this.xModelo.getValueAt(x, 2).toString()).booleanValue()) {
                    xdato = xdato + this.xModelo.getValueAt(x, 1).toString() + "\n";
                }
            }
            if (this.JRB_Conclusion.isSelected()) {
                if (this.xtipo == 0) {
                    this.xjpanel1.setText(this.xjpanel1.getText() + "\n" + xdato);
                } else {
                    this.xjpanel1_A.setText(this.xjpanel1_A.getText() + "\n" + xdato);
                }
            } else if (this.xtipo == 0) {
                this.xjpanel2.setText(this.xjpanel2.getText() + "\n" + xdato);
            } else {
                this.xjpanel2_A.setText(this.xjpanel2_A.getText() + "\n" + xdato);
            }
            dispose();
            return;
        }
        JOptionPane.showMessageDialog(this, "No se ha selecionado nota para cargar", "VERIFICACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModelo() {
        this.xModelo = new DefaultTableModel(new Object[0], new String[]{"Nombre", "Descripcion", "Cargar?"}) { // from class: Historia.JD_NotasPredefinidas.7
            Class[] types = {String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTB_PDetalle_NPredefinidas.setModel(this.xModelo);
        this.JTB_PDetalle_NPredefinidas.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTB_PDetalle_NPredefinidas.getColumnModel().getColumn(1).setPreferredWidth(400);
        this.JTB_PDetalle_NPredefinidas.getColumnModel().getColumn(2).setPreferredWidth(20);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModelo();
            if (this.xtipobusqueda == 0) {
                this.xsql = "SELECT `h_tiponota_comentario`.`Nbre` AS `NNombreC` , `h_tiponota_comentario`.`Descripcion`     FROM `h_tiponota_comentario` INNER JOIN  `h_tiponota`  ON (`h_tiponota_comentario`.`Id_TipoNota` = `h_tiponota`.`Id`) INNER JOIN  `h_tiponota_especialidad`  ON (`h_tiponota_especialidad`.`Id_TipoNota` = `h_tiponota`.`Id`) WHERE (`h_tiponota_especialidad`.`Id_Especialidad` ='" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "' AND `h_tiponota_comentario`.`Estado` =1) ORDER BY `h_tiponota_comentario`.`NOrden` ASC ";
            } else {
                this.xsql = "SELECT `h_tiponota_comentario`.`Nbre` AS `NNombreC` , `h_tiponota_comentario`.`Descripcion`     FROM `h_tiponota_comentario` INNER JOIN  `h_tiponota`  ON (`h_tiponota_comentario`.`Id_TipoNota` = `h_tiponota`.`Id`) INNER JOIN  `h_tiponota_especialidad`  ON (`h_tiponota_especialidad`.`Id_TipoNota` = `h_tiponota`.`Id`) WHERE (`h_tiponota_comentario`.`Nbre` LIKE '" + this.JTFBNombre.getText() + "%' AND `h_tiponota_especialidad`.`Id_Especialidad` ='" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "' AND `h_tiponota_comentario`.`Estado` =1) ORDER BY `h_tiponota_comentario`.`NOrden` ASC ";
            }
            ResultSet xrs = this.xct.traerRs(this.xsql);
            Throwable th = null;
            try {
                if (xrs.next()) {
                    xrs.beforeFirst();
                    int x = 0;
                    this.xmt.mEstablecerTextEditor(this.JTB_PDetalle_NPredefinidas, 1);
                    while (xrs.next()) {
                        this.xModelo.addRow(this.xDatos);
                        this.xModelo.setValueAt(xrs.getString(1), x, 0);
                        this.xModelo.setValueAt(xrs.getString(2), x, 1);
                        this.xModelo.setValueAt(false, x, 2);
                        x++;
                    }
                } else {
                    mCrearModelo();
                }
                if (xrs != null) {
                    if (0 != 0) {
                        try {
                            xrs.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    } else {
                        xrs.close();
                    }
                }
                this.xct.cerrarConexionBd();
            } finally {
            }
        } catch (SQLException ex) {
            Logger.getLogger(JD_NotasPredefinidas.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
