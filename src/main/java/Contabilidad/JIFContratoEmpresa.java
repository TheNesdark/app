package Contabilidad;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFContratoEmpresa.class */
public class JIFContratoEmpresa extends JInternalFrame {
    private File xfile;
    private File directorio;
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private JButton JBVisualizar;
    private JCheckBox JCHEstado;
    public JDateChooser JDFFechaF;
    public JDateChooser JDFFechaI;
    private JPanel JPIDatosC;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPObservacion;
    private JTextPane JTAObservacion;
    private JTable JTDetalle;
    private JFormattedTextField JTFFValor;
    private JTextField JTFNombreC;
    private JTextField JTFRuta;
    private ConsultasMySQL xconsultas = new ConsultasMySQL();
    private Metodos xmetodo = new Metodos();
    private int xestado = 1;
    private boolean xestadog = false;

    public JIFContratoEmpresa() {
        initComponents();
        mNuevo();
        mCargarDatos();
    }

    /* JADX WARN: Type inference failed for: r3v44, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatosC = new JPanel();
        this.JTFNombreC = new JTextField();
        this.JDFFechaI = new JDateChooser();
        this.JDFFechaF = new JDateChooser();
        this.JTFFValor = new JFormattedTextField();
        this.JTFRuta = new JTextField();
        this.JSPObservacion = new JScrollPane();
        this.JTAObservacion = new JTextPane();
        this.JCHEstado = new JCheckBox();
        this.JBVisualizar = new JButton();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONTRATO POR EMPRESA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifcontratoempresac");
        this.JPIDatosC.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFNombreC.setFont(new Font("Arial", 0, 13));
        this.JTFNombreC.setHorizontalAlignment(2);
        this.JTFNombreC.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaI.setFont(new Font("Arial", 0, 13));
        this.JDFFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaF.setFont(new Font("Arial", 0, 13));
        this.JTFFValor.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValor.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFValor.setHorizontalAlignment(4);
        this.JTFFValor.setFont(new Font("Arial", 1, 13));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFContratoEmpresa.1
            public void mouseClicked(MouseEvent evt) {
                JIFContratoEmpresa.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacion.setFont(new Font("Arial", 0, 13));
        this.JSPObservacion.setViewportView(this.JTAObservacion);
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: Contabilidad.JIFContratoEmpresa.2
            public void actionPerformed(ActionEvent evt) {
                JIFContratoEmpresa.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JBVisualizar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/lupa.png")));
        this.JBVisualizar.addActionListener(new ActionListener() { // from class: Contabilidad.JIFContratoEmpresa.3
            public void actionPerformed(ActionEvent evt) {
                JIFContratoEmpresa.this.JBVisualizarActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosCLayout = new GroupLayout(this.JPIDatosC);
        this.JPIDatosC.setLayout(JPIDatosCLayout);
        JPIDatosCLayout.setHorizontalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPObservacion, GroupLayout.Alignment.LEADING, -1, 791, 32767).addGroup(GroupLayout.Alignment.LEADING, JPIDatosCLayout.createSequentialGroup().addComponent(this.JTFNombreC, -2, 394, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFFechaI, -2, 121, -2).addGap(18, 18, 18).addComponent(this.JDFFechaF, -2, 121, -2).addGap(18, 18, 18).addComponent(this.JTFFValor, -2, 112, -2)).addGroup(JPIDatosCLayout.createSequentialGroup().addComponent(this.JTFRuta, -2, 641, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBVisualizar, -1, 77, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEstado))).addContainerGap()));
        JPIDatosCLayout.setVerticalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTFFValor, GroupLayout.Alignment.LEADING).addComponent(this.JDFFechaF, GroupLayout.Alignment.LEADING, -1, 45, 32767)).addComponent(this.JTFNombreC, -2, -1, -2).addComponent(this.JDFFechaI, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPObservacion, -2, 61, -2).addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIDatosCLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JCHEstado))).addGroup(JPIDatosCLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBVisualizar, -1, -1, 32767))).addContainerGap()));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFContratoEmpresa.4
            public void mouseClicked(MouseEvent evt) {
                JIFContratoEmpresa.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPDetalle).addComponent(this.JPIDatosC, -1, -1, 32767)).addContainerGap(14, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosC, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -1, 205, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser("S:\\Contratos\\");
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(this.xfile.getAbsolutePath());
                this.JTFRuta.setText(this.xmetodo.mTraerUrlBD(this.xfile.getAbsolutePath()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            this.JTFNombreC.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JDFFechaI.setDate(this.xmetodo.getPasarTextoAFecha(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()));
            this.JDFFechaF.setDate(this.xmetodo.getPasarTextoAFecha(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()));
            this.JTFFValor.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()));
            this.JTAObservacion.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString());
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString()).booleanValue());
            if (this.JCHEstado.isSelected()) {
                this.xestado = 1;
            } else {
                this.xestado = 0;
            }
            this.xestadog = true;
            if (evt.getClickCount() == 2) {
                this.xmetodo.mostrarPdf(this.directorio + "\\" + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString());
            }
        }
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
    public void JBVisualizarActionPerformed(ActionEvent evt) {
        if (!this.JTFRuta.getText().isEmpty()) {
            this.xmetodo.mostrarPdf(this.JTFRuta.getText());
        }
    }

    public void mNuevo() {
        this.directorio = new File(this.xmetodo.mRutaSoporte("JIFContratoEmpresa"));
        this.JTFNombreC.setText("");
        this.JDFFechaI.setDate(this.xmetodo.getFechaActual());
        this.JDFFechaF.setDate(this.xmetodo.getFechaActual());
        this.JTFFValor.setValue(new Double(0.0d));
        this.JTAObservacion.setText("");
        this.JTFRuta.setText("");
        this.JCHEstado.setSelected(true);
        this.xestado = 1;
        this.JTFNombreC.requestFocus();
        this.xestadog = false;
    }

    public void mGrabar() {
        if (!this.JTFNombreC.getText().isEmpty()) {
            if (!this.JTFRuta.getText().isEmpty()) {
                int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    if (!this.xestadog) {
                        File directorio = new File(this.xmetodo.mRutaSoporte("JIFContratoEmpresa"));
                        String sql = "insert into cc_contratoxempresa(Id_Empresa, NbreC, FechaI, FechaF, Valor, Observacion, Estado, Fecha, UsuarioS)  values ('" + Principal.txtNo.getText() + "','" + this.JTFNombreC.getText().toUpperCase() + "','" + this.xmetodo.formatoAMD.format(this.JDFFechaI.getDate()) + "','" + this.xmetodo.formatoAMD.format(this.JDFFechaF.getDate()) + "','" + this.JTFFValor.getValue() + "','" + this.JTAObservacion.getText() + "','" + this.xestado + "','" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        String xidDoc = this.xconsultas.ejecutarSQLId(sql);
                        String adjunto = Principal.txtNo.getText() + "_" + xidDoc + "_" + this.JTFNombreC.getText() + ".pdf";
                        String sql2 = "UPDATE cc_contratoxempresa set Url='" + this.xmetodo.mTraerUrlBD(adjunto) + "' WHERE Id='" + xidDoc + "'";
                        this.xconsultas.ejecutarSQL(sql2);
                        this.xconsultas.cerrarConexionBd();
                        File f1 = new File(this.JTFRuta.getText());
                        File f2 = new File(adjunto);
                        f1.renameTo(f2);
                        f2.renameTo(new File(directorio, f2.getName()));
                    } else {
                        String sql3 = "update cc_contratoxempresa set NbreC='" + this.JTFNombreC.getText().toUpperCase() + "',FechaI='" + this.xmetodo.formatoAMD.format(this.JDFFechaI.getDate()) + "',FechaF='" + this.xmetodo.formatoAMD.format(this.JDFFechaF.getDate()) + "',Valor='" + this.JTFFValor.getValue() + "',Observacion='" + this.JTAObservacion.getText() + "',Estado='" + this.xestado + "',Fecha='" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "',UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' where Id='" + this.xmodelo.getValueAt(0, this.JTDetalle.getSelectedRow()) + "'";
                        this.xconsultas.ejecutarSQL(sql3);
                        this.xconsultas.cerrarConexionBd();
                    }
                }
                mNuevo();
                mCargarDatos();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "La Ruta de guardado no puede estar vacia", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFRuta.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El nombre no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFNombreC.requestFocus();
    }

    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Nombre", "FechaI", "FechaF", "Valor", "Observación", "Url", "Estado"}) { // from class: Contabilidad.JIFContratoEmpresa.5
            Class[] types = {Long.class, String.class, String.class, String.class, Double.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(40);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(30);
    }

    private void mCargarDatos() {
        String sql = "SELECT Id, NbreC, Date_Format(FechaI,'%d-%m-%Y') as FechaI, Date_Format(FechaF,'%d-%m-%Y') as FechaF, Valor, Observacion, Url, Estado FROM cc_contratoxempresa WHERE (Id_Empresa ='" + Principal.txtNo.getText() + "') ORDER BY Id DESC ";
        mCrearTabla();
        ResultSet rs = this.xconsultas.traerRs(sql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo.setValueAt(rs.getString(3), x, 2);
                    this.xmodelo.setValueAt(rs.getString(4), x, 3);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(5)), x, 4);
                    this.xmodelo.setValueAt(rs.getString(6), x, 5);
                    this.xmodelo.setValueAt(this.xmetodo.mTraerUrlBD(rs.getString(7)), x, 6);
                    this.xmodelo.setValueAt(Boolean.valueOf(rs.getBoolean(8)), x, 7);
                    x++;
                }
            }
            rs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xconsultas.mostrarErrorSQL(ex);
        }
    }
}
