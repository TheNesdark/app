package Historia;

import Acceso.Principal;
import com.genoma.plus.controller.referencia.JD_RegistoCierre;
import com.genoma.plus.jpa.projection.ConductorProjection;
import com.genoma.plus.jpa.projection.IInstitucionQueRecibeDTO;
import com.genoma.plus.jpa.projection.ProfesionalProjection;
import com.genoma.plus.jpa.service.IInstirucionQueRecibeDAO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JDEmpresaQueRecibe.class */
public class JDEmpresaQueRecibe extends JDialog {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private IInstirucionQueRecibeDAO xIInstirucionQueRecibeDAO;
    private JPORemisiones remitido;
    private JD_RegistoCierre remision2;
    private String nombre;
    private JTable JTDetalle;
    private JTextField JTFEmpresa;
    private JButton jButton1;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;

    public JDEmpresaQueRecibe(Frame parent, boolean modal, JPORemisiones remision, String nombre) {
        super(parent, modal);
        this.xIInstirucionQueRecibeDAO = (IInstirucionQueRecibeDAO) Principal.contexto.getBean(IInstirucionQueRecibeDAO.class);
        initComponents();
        setLocationRelativeTo(null);
        this.remitido = remision;
        this.nombre = nombre;
        System.out.println("aca llega el nombre " + this.nombre);
        switch (this.nombre) {
            case "JTFConductor":
                this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "NOMBRE DEL CONDUCTOR ", 2, 0, new Font("Dialog", 1, 12), new Color(0, 102, 0)));
                mCrearModeloConductor();
                break;
            case "JTFProfesional":
                this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "NOMBRE DEL PROFESIONAL ", 2, 0, new Font("Dialog", 1, 12), new Color(0, 102, 0)));
                mCrearModeloProfesional();
                break;
            default:
                mCrearModelo();
                break;
        }
    }

    public JDEmpresaQueRecibe(Frame parent, boolean modal, JD_RegistoCierre remision2, String nombre) {
        super(parent, modal);
        this.xIInstirucionQueRecibeDAO = (IInstirucionQueRecibeDAO) Principal.contexto.getBean(IInstirucionQueRecibeDAO.class);
        initComponents();
        setLocationRelativeTo(null);
        mCrearModelo();
        this.remision2 = remision2;
        this.nombre = nombre;
        switch (this.nombre) {
            case "JTFConductor":
                this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "NOMBRE DEL CONDUCTOR ", 2, 0, new Font("Dialog", 1, 12), new Color(0, 102, 0)));
                mCrearModeloConductor();
                break;
            case "JTFProfesional":
            case "JTFEnfermeria":
                this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "NOMBRE DEL PROFESIONAL ", 2, 0, new Font("Dialog", 1, 12), new Color(0, 102, 0)));
                mCrearModeloProfesional();
                break;
            default:
                mCrearModelo();
                break;
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloConductor() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"idPersona", "idTipoDoc", "NoDocumento", "Nombre1", "Nombre2", "Apellido1", "Apellido2"}) { // from class: Historia.JDEmpresaQueRecibe.1
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Documento", "Nombre", "Codigo Habilitación"}) { // from class: Historia.JDEmpresaQueRecibe.2
            Class[] types = {String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloProfesional() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Identificacion", "profesional", "Especialidad"}) { // from class: Historia.JDEmpresaQueRecibe.3
            Class[] types = {String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
    }

    private void cargarDatos() {
        int tipo;
        switch (this.nombre) {
            case "JTFConductor":
                mCrearModeloConductor();
                List<ConductorProjection> lista = this.xIInstirucionQueRecibeDAO.buscarConductor(this.JTFEmpresa.getText());
                for (int i = 0; i < lista.size(); i++) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(lista.get(i).getIdPersona(), i, 0);
                    this.xmodelo.setValueAt(lista.get(i).getIdTipoDoc(), i, 1);
                    this.xmodelo.setValueAt(lista.get(i).getNoDocumento(), i, 2);
                    this.xmodelo.setValueAt(lista.get(i).getNombre1(), i, 3);
                    this.xmodelo.setValueAt(lista.get(i).getNombre2(), i, 4);
                    this.xmodelo.setValueAt(lista.get(i).getApellido1(), i, 5);
                    this.xmodelo.setValueAt(lista.get(i).getApellido2(), i, 6);
                }
                break;
            case "JTFProfesional":
                List<Integer> idEspecialidad = new ArrayList<>();
                idEspecialidad.add(382);
                List<ProfesionalProjection> lista2 = this.xIInstirucionQueRecibeDAO.buscarProfesionalEspecialidad(this.JTFEmpresa.getText(), idEspecialidad);
                for (int i2 = 0; i2 < lista2.size(); i2++) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(lista2.get(i2).getIdPersona(), i2, 0);
                    this.xmodelo.setValueAt(lista2.get(i2).getNoDocumento(), i2, 1);
                    this.xmodelo.setValueAt(lista2.get(i2).getNProfesional(), i2, 2);
                    this.xmodelo.setValueAt(lista2.get(i2).getEspecialidad(), i2, 3);
                }
                break;
            case "JTFEnfermeria":
                mCrearModeloProfesional();
                List<Integer> idEspecialidad2 = new ArrayList<>();
                idEspecialidad2.add(3);
                idEspecialidad2.add(1025);
                List<ProfesionalProjection> lista3 = this.xIInstirucionQueRecibeDAO.buscarProfesionalEspecialidad(this.JTFEmpresa.getText(), idEspecialidad2);
                for (int i3 = 0; i3 < lista3.size(); i3++) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(lista3.get(i3).getIdPersona(), i3, 0);
                    this.xmodelo.setValueAt(lista3.get(i3).getNoDocumento(), i3, 1);
                    this.xmodelo.setValueAt(lista3.get(i3).getNProfesional(), i3, 2);
                    this.xmodelo.setValueAt(lista3.get(i3).getEspecialidad(), i3, 3);
                }
                break;
            default:
                mCrearModelo();
                if (Principal.informacionIps.getNombreIps().equals("PABLO DURAN CASTRO")) {
                    tipo = 0;
                } else {
                    tipo = 1;
                }
                List<IInstitucionQueRecibeDTO> lista4 = this.xIInstirucionQueRecibeDAO.buscar(this.JTFEmpresa.getText(), Integer.valueOf(tipo));
                for (int i4 = 0; i4 < lista4.size(); i4++) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(lista4.get(i4).getNo_identificacion(), i4, 0);
                    this.xmodelo.setValueAt(lista4.get(i4).getNombre(), i4, 1);
                    this.xmodelo.setValueAt(lista4.get(i4).getCodigoHanilitacion(), i4, 2);
                }
                break;
        }
    }

    private void initComponents() {
        this.jButton1 = new JButton();
        this.jPanel1 = new JPanel();
        this.JTFEmpresa = new JTextField();
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        setDefaultCloseOperation(2);
        this.jButton1.setFont(new Font("Arial", 1, 12));
        this.jButton1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.jButton1.setText("SALIR");
        this.jButton1.addActionListener(new ActionListener() { // from class: Historia.JDEmpresaQueRecibe.4
            public void actionPerformed(ActionEvent evt) {
                JDEmpresaQueRecibe.this.jButton1ActionPerformed(evt);
            }
        });
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "INSTITUCIÓN QUE RECIBE ", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFEmpresa.setFont(new Font("Arial", 1, 12));
        this.JTFEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtro (Nit/Nombre)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFEmpresa.addKeyListener(new KeyAdapter() { // from class: Historia.JDEmpresaQueRecibe.5
            public void keyPressed(KeyEvent evt) {
                JDEmpresaQueRecibe.this.JTFEmpresaKeyPressed(evt);
            }
        });
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Historia.JDEmpresaQueRecibe.6
            public void mouseClicked(MouseEvent evt) {
                JDEmpresaQueRecibe.this.JTDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTDetalle);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jScrollPane1, -1, 752, 32767).addComponent(this.JTFEmpresa)).addContainerGap(-1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFEmpresa, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 310, -2).addContainerGap(17, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jButton1, -1, -1, 32767)).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(27, 27, 27).addComponent(this.jPanel1, -2, -1, -2).addGap(18, 18, 18).addComponent(this.jButton1, -2, 38, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFEmpresaKeyPressed(KeyEvent evt) {
        cargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            if (!this.nombre.equals("buscarEmpresaCierre")) {
                if (this.nombre.equals("JTFConductor")) {
                    this.remitido.JTFConductor.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString().concat(" ").concat(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()).concat(" ").concat(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString()).concat(" ").concat(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString()));
                    dispose();
                }
                if (!this.nombre.equals("JTFProfesional")) {
                    this.remitido.JTFInstirucionRecibe.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
                    this.remitido.JTFCHabitacion.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
                    dispose();
                    return;
                }
                return;
            }
            return;
        }
        switch (this.nombre) {
            case "JTFConductor":
                this.remision2.JTFConductor.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString().concat(" ").concat(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()).concat(" ").concat(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString()).concat(" ").concat(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString()));
                this.remision2.JTFConductorCedula.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString().concat("_").concat(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()));
                break;
            case "JTFProfesional":
                this.remision2.JTFMedicoAmbulancia.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
                this.remision2.JTFMedicoAmbulanciaCedula.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
                break;
            case "JTFEnfermeria":
                this.remision2.JTFEnfermeraAmbulancia.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
                this.remision2.JTFEnfermeraAmbulanciaCedula.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
                break;
            case "buscarEmpresaCierre":
                this.remision2.JTFInstirucionRecibe.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
                this.remision2.JTFCHabitacion.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
                break;
            case "buscarEmpresa":
                this.remision2.JTFInstirucionRecibe.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
                this.remision2.JTFCHabitacion.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
                break;
        }
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        dispose();
    }
}
