package RecursosHumanos;

import Acceso.Principal;
import com.genoma.plus.jpa.entities.EmpleadosNomina;
import com.genoma.plus.jpa.service.IEmpleadoNominaService;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:RecursosHumanos/JIDPrestamos_Buscador1.class */
public class JIDPrestamos_Buscador1 extends JDialog {
    private final IEmpleadoNominaService personaService;
    private EmpleadosNomina empleadosNomina;
    private List<EmpleadosNomina> empleadoNominaList;
    private DefaultTableModel model;
    private JIFPrestamos jIFPrestamos;
    private JIFNovedadesNomina jIFNovedadesNomina;
    private JTable JTDetalle;
    private JTextField JTFNombre;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;

    public JIDPrestamos_Buscador1(Frame parent, boolean modal, JIFPrestamos jIFPrestamos) {
        super(parent, modal);
        this.personaService = (IEmpleadoNominaService) Principal.contexto.getBean(IEmpleadoNominaService.class);
        this.empleadosNomina = new EmpleadosNomina();
        this.empleadoNominaList = new ArrayList();
        initComponents();
        crearModeloTabla();
        this.jIFPrestamos = jIFPrestamos;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
    }

    public JIDPrestamos_Buscador1(Frame parent, boolean modal, JIFNovedadesNomina jIFNovedadesNomina) {
        super(parent, modal);
        this.personaService = (IEmpleadoNominaService) Principal.contexto.getBean(IEmpleadoNominaService.class);
        this.empleadosNomina = new EmpleadosNomina();
        this.empleadoNominaList = new ArrayList();
        initComponents();
        crearModeloTabla();
        this.jIFNovedadesNomina = jIFNovedadesNomina;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
    }

    private void crearModeloTabla() {
        this.model = new DefaultTableModel() { // from class: RecursosHumanos.JIDPrestamos_Buscador1.1
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        this.model.addColumn("Id");
        this.model.addColumn("N.Documento");
        this.model.addColumn("Nombre");
        this.model.addColumn("Edad");
        this.model.addColumn("Sexo");
    }

    /* JADX WARN: Type inference failed for: r3v15, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JTFNombre = new JTextField();
        this.jPanel2 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        setDefaultCloseOperation(2);
        setTitle("FILTRO DE PERSONA NOMINA");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombre.addKeyListener(new KeyAdapter() { // from class: RecursosHumanos.JIDPrestamos_Buscador1.2
            public void keyPressed(KeyEvent evt) {
                JIDPrestamos_Buscador1.this.JTFNombreKeyPressed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JTFNombre, -2, 657, -2).addGap(299, 299, 299)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFNombre, -2, -1, -2).addContainerGap(-1, 32767)));
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "RESULTADO\n", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: RecursosHumanos.JIDPrestamos_Buscador1.3
            public void mouseClicked(MouseEvent evt) {
                JIDPrestamos_Buscador1.this.JTDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTDetalle);
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -2, 211, -2));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jPanel2, -1, -1, 32767).addComponent(this.jPanel1, -2, 690, -2)).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addGap(18, 18, 18).addComponent(this.jPanel2, -2, -1, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            if (!this.JTFNombre.getText().isEmpty()) {
                this.empleadoNominaList = this.personaService.buscarEmpleadoPorNombre(this.JTFNombre.getText());
                for (EmpleadosNomina empleadosNomina1 : this.empleadoNominaList) {
                    Object[] o = {empleadosNomina1.getIdPersona().id, empleadosNomina1.getIdPersona().noDocumento, empleadosNomina1.getIdPersona().nombre1 + " " + empleadosNomina1.getIdPersona().nombre2 + " " + empleadosNomina1.getIdPersona().apellido1 + " " + empleadosNomina1.getIdPersona().apellido2, empleadosNomina1.getIdPersona().getEdad(), empleadosNomina1.getIdPersona().getIdSexo().getId()};
                    this.model.addRow(o);
                    this.JTDetalle.setModel(this.model);
                }
                return;
            }
            JOptionPane.showMessageDialog(this, "El campo Nombre esta vacio", "Alert", 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        this.model = this.JTDetalle.getModel();
        int selectedRowIndex = this.JTDetalle.getSelectedRow();
        if (selectedRowIndex != -1) {
            this.jIFNovedadesNomina.fillTextFieldWithPersona(this.empleadoNominaList.get(selectedRowIndex));
            dispose();
        }
    }
}
