package ImagenesDx;

import Acceso.Principal;
import General.ClaseImpresionInformes;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ImagenesDx/JD_FormularioLectura.class */
public class JD_FormularioLectura extends JDialog {
    private Metodos xmt;
    private ConsultasMySQL xct;
    private String[] xIdEspec;
    private String[] xIdProfesional;
    private long xIdRadadiologia;
    private boolean xlleno;
    private String xsql;
    private Object[] xDatos;
    private DefaultTableModel xModelo;
    private int xtipobusqueda;
    private JButton JBTGrabar;
    private JButton JBTImprimir;
    private JButton JBTSalir;
    private JButton JBT_Cargar;
    private JComboBox JCBEspecialidad;
    private JComboBox JCBProfesional;
    private JLabel JLB_NLectura;
    private JPanel JPIH_Filtro;
    private JPanel JPI_Lectura;
    private JPanel JPI_NotaPredefinidas;
    private JScrollPane JSDetalle;
    private JScrollPane JSP_PDetalle;
    private JTable JTB_PDetalle_NPredefinidas;
    private JTextField JTFBNombre;
    private JDateChooser JTFF_Fecha;
    private JTextPane JTPDetalle;
    private JTabbedPane JTP_Datos;

    public JD_FormularioLectura(Frame parent, boolean modal, Long xIdRadadiologia) {
        super(parent, modal);
        this.xmt = new Metodos();
        this.xct = new ConsultasMySQL();
        this.xIdRadadiologia = 0L;
        this.xtipobusqueda = 0;
        initComponents();
        this.xIdRadadiologia = xIdRadadiologia.longValue();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v66, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JTP_Datos = new JTabbedPane();
        this.JPI_Lectura = new JPanel();
        this.JCBEspecialidad = new JComboBox();
        this.JCBProfesional = new JComboBox();
        this.JSDetalle = new JScrollPane();
        this.JTPDetalle = new JTextPane();
        this.JBTGrabar = new JButton();
        this.JBTImprimir = new JButton();
        this.JBTSalir = new JButton();
        this.JLB_NLectura = new JLabel();
        this.JTFF_Fecha = new JDateChooser();
        this.JPI_NotaPredefinidas = new JPanel();
        this.JPIH_Filtro = new JPanel();
        this.JTFBNombre = new JTextField();
        this.JSP_PDetalle = new JScrollPane();
        this.JTB_PDetalle_NPredefinidas = new JTable();
        this.JBT_Cargar = new JButton();
        setDefaultCloseOperation(2);
        this.JTP_Datos.setForeground(new Color(0, 103, 0));
        this.JTP_Datos.setFont(new Font("Arial", 1, 14));
        this.JCBEspecialidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBEspecialidad.addItemListener(new ItemListener() { // from class: ImagenesDx.JD_FormularioLectura.1
            public void itemStateChanged(ItemEvent evt) {
                JD_FormularioLectura.this.JCBEspecialidadItemStateChanged(evt);
            }
        });
        this.JCBProfesional.setBorder(BorderFactory.createTitledBorder((Border) null, "Profesional", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JTPDetalle.setFont(new Font("Arial", 1, 12));
        this.JSDetalle.setViewportView(this.JTPDetalle);
        this.JBTGrabar.setFont(new Font("Arial", 1, 12));
        this.JBTGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBTGrabar.setText("Grabar");
        this.JBTGrabar.addActionListener(new ActionListener() { // from class: ImagenesDx.JD_FormularioLectura.2
            public void actionPerformed(ActionEvent evt) {
                JD_FormularioLectura.this.JBTGrabarActionPerformed(evt);
            }
        });
        this.JBTImprimir.setFont(new Font("Arial", 1, 12));
        this.JBTImprimir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Imprimir.png")));
        this.JBTImprimir.setText("Imprimir");
        this.JBTImprimir.addActionListener(new ActionListener() { // from class: ImagenesDx.JD_FormularioLectura.3
            public void actionPerformed(ActionEvent evt) {
                JD_FormularioLectura.this.JBTImprimirActionPerformed(evt);
            }
        });
        this.JBTSalir.setFont(new Font("Arial", 1, 12));
        this.JBTSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBTSalir.setText("Salir");
        this.JBTSalir.addActionListener(new ActionListener() { // from class: ImagenesDx.JD_FormularioLectura.4
            public void actionPerformed(ActionEvent evt) {
                JD_FormularioLectura.this.JBTSalirActionPerformed(evt);
            }
        });
        this.JLB_NLectura.setBackground(new Color(200, 200, 200));
        this.JLB_NLectura.setFont(new Font("Arial", 1, 14));
        this.JLB_NLectura.setHorizontalAlignment(0);
        this.JLB_NLectura.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Lectura", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFF_Fecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_Fecha.setDateFormatString("dd/MM/yyyy");
        this.JTFF_Fecha.setFont(new Font("Arial", 1, 12));
        GroupLayout JPI_LecturaLayout = new GroupLayout(this.JPI_Lectura);
        this.JPI_Lectura.setLayout(JPI_LecturaLayout);
        JPI_LecturaLayout.setHorizontalGroup(JPI_LecturaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_LecturaLayout.createSequentialGroup().addContainerGap().addGroup(JPI_LecturaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_LecturaLayout.createSequentialGroup().addComponent(this.JBTGrabar, -2, 150, -2).addGap(71, 71, 71).addComponent(this.JBTImprimir, -2, 150, -2).addGap(82, 82, 82).addComponent(this.JBTSalir, -2, 150, -2).addGap(18, 18, 18).addComponent(this.JLB_NLectura, -2, 128, -2).addGap(0, 38, 32767)).addGroup(JPI_LecturaLayout.createSequentialGroup().addComponent(this.JTFF_Fecha, -2, 114, -2).addGap(18, 18, 18).addComponent(this.JCBEspecialidad, -2, 232, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBProfesional, 0, -1, 32767))).addContainerGap()).addGroup(JPI_LecturaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_LecturaLayout.createSequentialGroup().addContainerGap().addComponent(this.JSDetalle, -1, 787, 32767).addContainerGap())));
        JPI_LecturaLayout.setVerticalGroup(JPI_LecturaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_LecturaLayout.createSequentialGroup().addContainerGap().addGroup(JPI_LecturaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFF_Fecha, -1, -1, 32767).addGroup(JPI_LecturaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBProfesional, -1, 50, 32767).addComponent(this.JCBEspecialidad, -2, 49, -2))).addGap(353, 353, 353).addGroup(JPI_LecturaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPI_LecturaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTGrabar, -2, 50, -2).addComponent(this.JBTImprimir, -2, 50, -2).addComponent(this.JBTSalir, -2, 50, -2)).addComponent(this.JLB_NLectura, -1, -1, 32767)).addContainerGap()).addGroup(JPI_LecturaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_LecturaLayout.createSequentialGroup().addGap(72, 72, 72).addComponent(this.JSDetalle, -2, 333, -2).addContainerGap(70, 32767))));
        this.JTP_Datos.addTab("LECTURA", this.JPI_Lectura);
        this.JPIH_Filtro.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFBNombre.setFont(new Font("Arial", 1, 12));
        this.JTFBNombre.setToolTipText("");
        this.JTFBNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFBNombre.addActionListener(new ActionListener() { // from class: ImagenesDx.JD_FormularioLectura.5
            public void actionPerformed(ActionEvent evt) {
                JD_FormularioLectura.this.JTFBNombreActionPerformed(evt);
            }
        });
        this.JTFBNombre.addKeyListener(new KeyAdapter() { // from class: ImagenesDx.JD_FormularioLectura.6
            public void keyTyped(KeyEvent evt) {
                JD_FormularioLectura.this.JTFBNombreKeyTyped(evt);
            }
        });
        GroupLayout JPIH_FiltroLayout = new GroupLayout(this.JPIH_Filtro);
        this.JPIH_Filtro.setLayout(JPIH_FiltroLayout);
        JPIH_FiltroLayout.setHorizontalGroup(JPIH_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIH_FiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFBNombre, -2, 744, -2).addContainerGap(14, 32767)));
        JPIH_FiltroLayout.setVerticalGroup(JPIH_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIH_FiltroLayout.createSequentialGroup().addComponent(this.JTFBNombre, -2, -1, -2).addGap(0, 11, 32767)));
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
        this.JBT_Cargar.addActionListener(new ActionListener() { // from class: ImagenesDx.JD_FormularioLectura.7
            public void actionPerformed(ActionEvent evt) {
                JD_FormularioLectura.this.JBT_CargarActionPerformed(evt);
            }
        });
        this.JBT_Cargar.addKeyListener(new KeyAdapter() { // from class: ImagenesDx.JD_FormularioLectura.8
            public void keyPressed(KeyEvent evt) {
                JD_FormularioLectura.this.JBT_CargarKeyPressed(evt);
            }
        });
        GroupLayout JPI_NotaPredefinidasLayout = new GroupLayout(this.JPI_NotaPredefinidas);
        this.JPI_NotaPredefinidas.setLayout(JPI_NotaPredefinidasLayout);
        JPI_NotaPredefinidasLayout.setHorizontalGroup(JPI_NotaPredefinidasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_NotaPredefinidasLayout.createSequentialGroup().addContainerGap().addGroup(JPI_NotaPredefinidasLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBT_Cargar, -1, -1, 32767).addComponent(this.JPIH_Filtro, -1, -1, 32767)).addContainerGap(17, 32767)).addGroup(JPI_NotaPredefinidasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_NotaPredefinidasLayout.createSequentialGroup().addContainerGap().addComponent(this.JSP_PDetalle, -2, 779, -2).addContainerGap(18, 32767))));
        JPI_NotaPredefinidasLayout.setVerticalGroup(JPI_NotaPredefinidasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_NotaPredefinidasLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIH_Filtro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 317, 32767).addComponent(this.JBT_Cargar, -2, 50, -2).addGap(19, 19, 19)).addGroup(JPI_NotaPredefinidasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_NotaPredefinidasLayout.createSequentialGroup().addGap(100, 100, 100).addComponent(this.JSP_PDetalle, -2, 292, -2).addContainerGap(83, 32767))));
        this.JTP_Datos.addTab("NOTAS PREDEFINIDAS", this.JPI_NotaPredefinidas);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTP_Datos, -2, 812, -2).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTP_Datos).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEspecialidadItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBEspecialidad.getSelectedIndex() != -1) {
            this.JCBProfesional.removeAllItems();
            this.xIdProfesional = this.xct.llenarCombo("SELECT `Id_Persona`, `NProfesional` FROM `profesional1` WHERE (`IdEspecialidad` ='" + this.xIdEspec[this.JCBEspecialidad.getSelectedIndex()] + "') ORDER BY `NProfesional` ASC", this.xIdProfesional, this.JCBProfesional);
            this.JCBProfesional.setSelectedIndex(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGrabarActionPerformed(ActionEvent evt) {
        if (this.JLB_NLectura.getText().isEmpty()) {
            if (this.JCBProfesional.getSelectedIndex() != -1) {
                if (!this.JTPDetalle.getText().isEmpty()) {
                    int x = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (x == 0) {
                        this.xsql = "insert into h_radiologia_lectura_encabezado(`Id_Radiologia` , `FechaL` , `Id_Especialidad` , `Id_Profesional`  , `Descripcion`,UsuarioS) value('" + this.xIdRadadiologia + "','" + this.xmt.formatoAMD.format(this.JTFF_Fecha.getDate()) + "','" + this.xIdEspec[this.JCBEspecialidad.getSelectedIndex()] + "','" + this.xIdProfesional[this.JCBProfesional.getSelectedIndex()] + "','" + this.JTPDetalle.getText() + "','" + Principal.usuarioSistemaDTO.getNombreUsuario() + "')";
                        this.JLB_NLectura.setText("" + this.xct.ejecutarSQLId(this.xsql));
                        this.xct.cerrarConexionBd();
                        return;
                    }
                    return;
                }
                JOptionPane.showMessageDialog(this, "Descripcion no puede estas en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTPDetalle.requestFocus();
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe seleccionar un profesional", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBProfesional.requestFocus();
            return;
        }
        int x2 = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (x2 == 0) {
            this.xsql = "update h_radiologia_lectura_encabezado set Descripcion='" + this.JTPDetalle.getText() + "',Id_Especialidad='" + this.xIdEspec[this.JCBEspecialidad.getSelectedIndex()] + "',Id_Profesional='" + this.xIdProfesional[this.JCBProfesional.getSelectedIndex()] + "' where Id='" + this.JLB_NLectura.getText() + "'";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTImprimirActionPerformed(ActionEvent evt) {
        if (!this.JLB_NLectura.getText().isEmpty()) {
            ClaseImpresionInformes xImpresion = new ClaseImpresionInformes();
            xImpresion.mImprimirLecturaRadiologia(this.xIdRadadiologia + "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTSalirActionPerformed(ActionEvent evt) {
        dispose();
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

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_CargarActionPerformed(ActionEvent evt) {
        mCargarDato();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_CargarKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            mCargarDato();
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
            this.JTPDetalle.setText(this.JTPDetalle.getText() + "\n" + xdato);
            this.JTP_Datos.setSelectedIndex(0);
            return;
        }
        JOptionPane.showMessageDialog(this, "No se ha selecionado nota para cargar", "VERIFICACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
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
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JD_FormularioLectura.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModelo() {
        this.xModelo = new DefaultTableModel(new Object[0], new String[]{"Nombre", "Descripcion", "Cargar?"}) { // from class: ImagenesDx.JD_FormularioLectura.9
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

    private void mNuevo() {
        this.xlleno = false;
        this.JTFF_Fecha.setDate(this.xmt.getFechaActual());
        this.JCBProfesional.removeAllItems();
        this.JCBEspecialidad.removeAllItems();
        this.xIdEspec = this.xct.llenarCombo("SELECT `IdEspecialidad`, `Especialidad` FROM  `profesional1` WHERE (`LecturaRx` =1) GROUP BY `IdEspecialidad` ORDER BY `Especialidad` ASC", this.xIdEspec, this.JCBEspecialidad);
        this.xct.cerrarConexionBd();
        this.JCBEspecialidad.setSelectedIndex(-1);
        this.JTPDetalle.setText("");
        this.xlleno = true;
        mCargarLectura();
        mCargarDatosTabla();
    }

    private void mCargarLectura() {
        try {
            this.xsql = "SELECT\n    `h_radiologia_lectura_encabezado`.`FechaL`\n    , `profesional1`.`Especialidad`\n    , `profesional1`.`NProfesional`\n    , `h_radiologia_lectura_encabezado`.`Descripcion`, h_radiologia_lectura_encabezado.Id\nFROM\n    `profesional1`\n    INNER JOIN `h_radiologia_lectura_encabezado` \n        ON (`profesional1`.`Id_Persona` = `h_radiologia_lectura_encabezado`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `h_radiologia_lectura_encabezado`.`Id_Especialidad`)\nWHERE (`h_radiologia_lectura_encabezado`.`Id_Radiologia` ='" + this.xIdRadadiologia + "'\n    AND `h_radiologia_lectura_encabezado`.`Estado` =1)";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                this.JTFF_Fecha.setDate(xrs.getDate("FechaL"));
                this.JCBEspecialidad.setSelectedItem(xrs.getString("Especialidad"));
                this.JCBProfesional.setSelectedItem(xrs.getString("NProfesional"));
                this.JTPDetalle.setText(xrs.getString("Descripcion"));
                this.JLB_NLectura.setText(xrs.getString("Id"));
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JD_FormularioLectura.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
