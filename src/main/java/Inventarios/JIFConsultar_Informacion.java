package Inventarios;

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
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;

/* JADX INFO: loaded from: GenomaP.jar:Inventarios/JIFConsultar_Informacion.class */
public class JIFConsultar_Informacion extends JInternalFrame {
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private Object[] xdato;
    private String[] xidbodega;
    private String[] xidperiodo;
    private String xsql;
    private JButton JBTExportar;
    private JComboBox JCBBodega;
    private JComboBox JCBPeriodo;
    private JCheckBox JCHActivo;
    private JPanel JPIDatos;
    private JTextField JTFRuta;

    public JIFConsultar_Informacion() {
        initComponents();
        mNuevo();
    }

    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JCBPeriodo = new JComboBox();
        this.JCHActivo = new JCheckBox();
        this.JCBBodega = new JComboBox();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONSULTAR INFORMACIÓN");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjif_consultar_inf");
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 1, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBPeriodo.setFont(new Font("Arial", 1, 12));
        this.JCBPeriodo.setBorder(BorderFactory.createTitledBorder((Border) null, "Periodo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHActivo.setFont(new Font("Arial", 1, 12));
        this.JCHActivo.setSelected(true);
        this.JCHActivo.setText("Activo");
        this.JCHActivo.addActionListener(new ActionListener() { // from class: Inventarios.JIFConsultar_Informacion.1
            public void actionPerformed(ActionEvent evt) {
                JIFConsultar_Informacion.this.JCHActivoActionPerformed(evt);
            }
        });
        this.JCBBodega.setFont(new Font("Arial", 1, 12));
        this.JCBBodega.setBorder(BorderFactory.createTitledBorder((Border) null, "Periodo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBBodega, 0, -1, 32767).addGap(18, 18, 18).addComponent(this.JCBPeriodo, -2, 226, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHActivo).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBPeriodo, -2, 50, -2).addComponent(this.JCHActivo).addComponent(this.JCBBodega, -2, 50, -2)).addContainerGap(12, 32767)));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Inventarios.JIFConsultar_Informacion.2
            public void mouseClicked(MouseEvent evt) {
                JIFConsultar_Informacion.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Inventarios.JIFConsultar_Informacion.3
            public void actionPerformed(ActionEvent evt) {
                JIFConsultar_Informacion.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatos, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 437, -2).addGap(18, 18, 18).addComponent(this.JBTExportar, -2, 180, -2).addGap(0, 15, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addGap(26, 26, 26).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JBTExportar, -2, 50, -2)).addContainerGap(23, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHActivoActionPerformed(ActionEvent evt) {
        mLLenarPeriodo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                File xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(xfile.getAbsolutePath() + this.xmt.getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (this.JTFRuta.getText().isEmpty()) {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFRuta.requestFocus();
        }
    }

    private void mLLenarPeriodo() {
        this.JCBPeriodo.removeAllItems();
        if (this.JCHActivo.isSelected()) {
            this.xsql = "SELECT Id, IF(Nbre IS NULL || Nbre='',DevuelveMes(FechaI),Nbre)  AS Mes FROM i_periodo where Activo =1 and Estado=1 order by FechaF desc";
        } else {
            this.xsql = "SELECT Id, IF(Nbre IS NULL || Nbre='',DevuelveMes(FechaI),Nbre)  AS Mes FROM i_periodo  where Activo =0 and Estado=1 order by FechaF desc";
        }
        this.xidperiodo = this.xct.llenarCombo(this.xsql, this.xidperiodo, this.JCBPeriodo);
        this.JCBPeriodo.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
    }

    public void mNuevo() {
        mLLenarPeriodo();
        this.JCBBodega.removeAll();
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.xsql = "SELECT `i_bodegas`.`Id`, `i_bodegas`.`Nbre` FROM `i_suministroxbodega` INNER JOIN  `i_bodegas`  ON (`i_suministroxbodega`.`IdBodega` = `i_bodegas`.`Id`) WHERE (`i_bodegas`.`Estado` =0 ) GROUP BY `i_bodegas`.`Id` ORDER BY `i_bodegas`.`Nbre` ASC";
        this.xidbodega = this.xct.llenarCombo(this.xsql, this.xidbodega, this.JCBBodega);
        this.JCBBodega.setSelectedIndex(-1);
    }

    public void mBuscar() {
        if (this.JCBBodega.getSelectedIndex() != -1) {
            if (this.JCBPeriodo.getSelectedIndex() != -1) {
                Principal.xClaseInventario.mActualizarValores_Inventario(this.xidbodega[this.JCBBodega.getSelectedIndex()], this.xidperiodo[this.JCBPeriodo.getSelectedIndex()]);
                String[][] parametros = new String[5][2];
                parametros[0][0] = "IdBodega";
                parametros[0][1] = this.xidbodega[this.JCBBodega.getSelectedIndex()];
                parametros[1][0] = "ruta";
                parametros[1][1] = this.xmt.getRutaRep();
                parametros[2][0] = "Periodo";
                parametros[2][1] = this.JCBPeriodo.getSelectedItem().toString();
                parametros[3][0] = "SUBREPORT_DIR";
                parametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
                parametros[4][0] = "SUBREPORTFIRMA_DIR";
                parametros[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "I_InventarioGeneralxArea_1", parametros);
                this.xct.cerrarConexionBd();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un periodo ", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            this.JCBPeriodo.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una bodega ", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
        this.JCBBodega.requestFocus();
    }
}
