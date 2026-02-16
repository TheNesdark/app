package Facturacion;

import ParametrizacionN.JIFSSuministroxBodega;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JYearChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Facturacion/JIFFServicioEmpresaConvenio.class */
public class JIFFServicioEmpresaConvenio extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private int xAnio;
    private JCheckBox JCHSeleccion;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JYearChooser JYCAnioDestino;
    private JYearChooser JYCAnioOrigen;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private Calendar xFecha = Calendar.getInstance();

    public JIFFServicioEmpresaConvenio() {
        initComponents();
        mIniciarComponente();
        mCargarDatosTabla();
    }

    private void mIniciarComponente() {
        JYearChooser jYearChooser = this.JYCAnioOrigen;
        int i = this.xFecha.get(1);
        this.xAnio = i;
        jYearChooser.setValue(i);
        JYearChooser jYearChooser2 = this.JYCAnioDestino;
        int i2 = this.xFecha.get(1);
        this.xAnio = i2;
        jYearChooser2.setValue(i2);
    }

    public void mGrabar() {
        mActualizarAnio();
    }

    public void mBuscar() {
        this.JCHSeleccion.setSelected(false);
        this.JCHSeleccion.setText("Seleccionar Todo");
        mCargarDatosTabla();
    }

    private void mActualizarAnio() {
        if (this.xmetodos.mVerificarDatosTablaTrue(this.JTDetalle, 6)) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de actualizar año de servicio?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
                    if (Boolean.valueOf(this.xmodelo.getValueAt(x, 6).toString()).booleanValue()) {
                        String sql = "UPDATE `f_servicioempresaconv`SET `Anno` = '" + this.JYCAnioDestino.getValue() + "' WHERE Anno='" + this.JYCAnioOrigen.getValue() + "' AND `f_servicioempresaconv`.`Id_TipoServicio` = '" + this.xmodelo.getValueAt(x, 2).toString() + "'AND `f_servicioempresaconv`.`Id_EmpresaConvenio` = '" + this.xmodelo.getValueAt(x, 0).toString() + "' ";
                        this.xconsulta.ejecutarSQL(sql);
                    }
                }
                this.xconsulta.cerrarConexionBd();
                mCargarDatosTabla();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "No hay registro seleccionado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTDetalle.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id_EmpConvenio", "Empresa Convenio", "Id_TipoServicio", "Servicio", "Año", "Aplica Factor", "Selección"}) { // from class: Facturacion.JIFFServicioEmpresaConvenio.1
            Class[] types = {Integer.class, String.class, Integer.class, String.class, Integer.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(60);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(50);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            String sql = "SELECT `f_servicioempresaconv`.`Id_EmpresaConvenio`, `f_empresacontxconvenio`.`Nbre`, `f_tiposervicio`.`Id`, `f_tiposervicio`.`Nbre`, `f_servicioempresaconv`.`Anno`, `f_servicioempresaconv`.`AplicaFactor`,0 FROM `f_servicioempresaconv`INNER JOIN  `f_empresacontxconvenio` ON (`f_servicioempresaconv`.`Id_EmpresaConvenio` = `f_empresacontxconvenio`.`Id`) INNER JOIN  `f_tiposervicio` ON (`f_servicioempresaconv`.`Id_TipoServicio` = `f_tiposervicio`.`Id`) WHERE (`f_servicioempresaconv`.`Estado` =0 AND `f_servicioempresaconv`.`Anno`='" + this.JYCAnioOrigen.getValue() + "')ORDER BY `f_empresacontxconvenio`.`Nbre` ASC, `f_tiposervicio`.`Nbre` ASC";
            ResultSet xrs = this.xconsulta.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(3)), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(5)), n, 4);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(6)), n, 5);
                    this.xmodelo.setValueAt(false, n, 6);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFSSuministroxBodega.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r3v26, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JYCAnioOrigen = new JYearChooser();
        this.JYCAnioDestino = new JYearChooser();
        this.JCHSeleccion = new JCheckBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("SERVICIOS POR EMPRESA CONVENIO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xJIFFServicioEmpresaConvenio");
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JYCAnioOrigen.setBorder(BorderFactory.createTitledBorder((Border) null, "Año Origen", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JYCAnioOrigen.setToolTipText("Año Actual del Servicio");
        this.JYCAnioOrigen.setFont(new Font("Arial", 1, 12));
        this.JYCAnioOrigen.setYear(2013);
        this.JYCAnioDestino.setBorder(BorderFactory.createTitledBorder((Border) null, "Año Destino", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JYCAnioDestino.setToolTipText("Año Nuevo que se actualizará el Servicio");
        this.JYCAnioDestino.setFont(new Font("Arial", 1, 12));
        this.JYCAnioDestino.setYear(2013);
        this.JCHSeleccion.setFont(new Font("Arial", 1, 12));
        this.JCHSeleccion.setText("Seleccionar Todo");
        this.JCHSeleccion.addActionListener(new ActionListener() { // from class: Facturacion.JIFFServicioEmpresaConvenio.2
            public void actionPerformed(ActionEvent evt) {
                JIFFServicioEmpresaConvenio.this.JCHSeleccionActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JYCAnioOrigen, -2, 119, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JYCAnioDestino, -2, 119, -2).addGap(123, 123, 123).addComponent(this.JCHSeleccion).addContainerGap(-1, 32767)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JYCAnioOrigen, -2, 50, -2).addComponent(this.JYCAnioDestino, -2, 50, -2)).addGap(10, 10, 10)).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addComponent(this.JCHSeleccion).addGap(21, 21, 21)))));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatos, -1, -1, 32767).addComponent(this.JSPDetalle, -1, 680, 32767)).addGap(10, 10, 10)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.JPIDatos, -2, -1, -2).addGap(14, 14, 14).addComponent(this.JSPDetalle, -1, 340, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHSeleccionActionPerformed(ActionEvent evt) {
        if (this.JCHSeleccion.isSelected()) {
            this.JCHSeleccion.setText("Quitar Selección");
            mRecorrerTabla();
        } else {
            this.JCHSeleccion.setText("Seleccionar Todo");
            mRecorrerTabla();
        }
    }

    private void mRecorrerTabla() {
        if (this.JTDetalle.getRowCount() > 0) {
            for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
                if (this.JCHSeleccion.isSelected()) {
                    this.xmodelo.setValueAt(true, i, 6);
                } else {
                    this.xmodelo.setValueAt(false, i, 6);
                }
            }
        }
    }
}
