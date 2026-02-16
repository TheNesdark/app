package GestionDoc;

import General.BuscarPersona;
import General.Persona;
import Laboratorio.RecepcionAuto;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:GestionDoc/JIFGenerarExamenUsuario.class */
public class JIFGenerarExamenUsuario extends JInternalFrame {
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    public Persona xjppersona;
    private ButtonGroup JBGOpciones;
    private JButton JBTGenerar;
    private JCheckBox JCHSeleccionar;
    private JPanel JPIDUsuario;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;

    public JIFGenerarExamenUsuario() {
        initComponents();
        mCargarPanelUsuario();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGOpciones = new ButtonGroup();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPIDUsuario = new JPanel();
        this.JCHSeleccionar = new JCheckBox();
        this.JBTGenerar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("GENERACIÓN DE REPORTE DE RESULTADO POR USUARIO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifgenerarreportexusuario");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JPIDUsuario.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DE USUARIO", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        GroupLayout JPIDUsuarioLayout = new GroupLayout(this.JPIDUsuario);
        this.JPIDUsuario.setLayout(JPIDUsuarioLayout);
        JPIDUsuarioLayout.setHorizontalGroup(JPIDUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 1031, 32767));
        JPIDUsuarioLayout.setVerticalGroup(JPIDUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 160, 32767));
        this.JCHSeleccionar.setFont(new Font("Arial", 1, 12));
        this.JCHSeleccionar.setSelected(true);
        this.JCHSeleccionar.setText("Seleccionar Todo");
        this.JCHSeleccionar.addActionListener(new ActionListener() { // from class: GestionDoc.JIFGenerarExamenUsuario.1
            public void actionPerformed(ActionEvent evt) {
                JIFGenerarExamenUsuario.this.JCHSeleccionarActionPerformed(evt);
            }
        });
        this.JBTGenerar.setFont(new Font("Arial", 1, 12));
        this.JBTGenerar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.JBTGenerar.setText("Generar");
        this.JBTGenerar.addActionListener(new ActionListener() { // from class: GestionDoc.JIFGenerarExamenUsuario.2
            public void actionPerformed(ActionEvent evt) {
                JIFGenerarExamenUsuario.this.JBTGenerarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JCHSeleccionar).addGap(30, 30, 30).addComponent(this.JBTGenerar, -1, 892, 32767)).addComponent(this.JSPDetalle, -1, 1047, 32767).addComponent(this.JPIDUsuario, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDUsuario, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -2, 313, -2).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHSeleccionar).addComponent(this.JBTGenerar, -2, 46, -2)).addContainerGap(19, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHSeleccionarActionPerformed(ActionEvent evt) {
        mSeleccionar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGenerarActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getRowCount() != -1) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Desea exportar los exámenes?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                mCrearArchivos();
            }
        }
    }

    public void mBuscar() {
        BuscarPersona frmBuscar = new BuscarPersona(null, true, this.xjppersona);
        frmBuscar.setVisible(true);
    }

    public void mNuevo() {
        this.xjppersona.nuevo();
        mCrearModeloDatos();
        this.JCHSeleccionar.setSelected(true);
        this.xjppersona.txtHistoria.requestFocus();
    }

    private void mSeleccionar() {
        if (this.JTDetalle.getRowCount() != -1) {
            for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
                if (this.JCHSeleccionar.isSelected()) {
                    this.xmodelo.setValueAt(true, x, 4);
                } else {
                    this.xmodelo.setValueAt(false, x, 4);
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha Recepción", "Especialidad", "Profesional", "Generar?"}) { // from class: GestionDoc.JIFGenerarExamenUsuario.3
            Class[] types = {Long.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(20);
    }

    private boolean mVerificarDatosTabla() {
        boolean estado = false;
        if (this.JTDetalle.getRowCount() > 1) {
            int i = 0;
            while (true) {
                if (i > this.JTDetalle.getRowCount()) {
                    break;
                }
                if (!this.JTDetalle.getValueAt(i, 4).toString().equals("true")) {
                    i++;
                } else {
                    estado = true;
                    break;
                }
            }
        }
        return estado;
    }

    public void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            String sql = "SELECT l_resultados.Id_Recepcion, DATE_FORMAT(l_recepcion.FechaRecep, '%d-%m-%Y') AS FechaR,profesional1.Especialidad, profesional1.NProfesional FROM baseserver.l_resultados INNER JOIN baseserver.l_recepcion  ON (l_resultados.Id_Recepcion = l_recepcion.Id)  INNER JOIN baseserver.profesional1  ON (profesional1.Id_Persona = l_recepcion.Id_Profesional) AND (profesional1.IdEspecialidad = l_recepcion.Id_Especialidad)  INNER JOIN baseserver.persona  ON (persona.Id_persona = l_recepcion.Id_Paciente) WHERE (l_resultados.Estado =0 AND persona.Id_persona='" + this.xjppersona.getIdPersona() + "') GROUP BY l_resultados.Id_Recepcion ORDER BY l_recepcion.FechaRecep DESC ";
            ResultSet xrs = this.xconsulta.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(true, n, 4);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGenerarExamenUsuario.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mGenerarResultadosPDF() {
        if (mVerificarDatosTabla()) {
            Object[] botones = {"Imprimir Resultado", "Generar Archivo", "Cerrar"};
            int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "BUSCAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
            if (n == 0) {
                for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
                    if (this.xmodelo.getValueAt(x, 8).equals(true)) {
                        String[][] parametros = new String[4][2];
                        parametros[0][0] = "id";
                        parametros[0][1] = this.xmodelo.getValueAt(x, 0).toString();
                        parametros[1][0] = "profesional";
                        parametros[2][0] = "SUBREPORT_DIR";
                        parametros[2][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra();
                        parametros[3][0] = "SUBREPORTFIRMA_DIR";
                        parametros[3][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra();
                        this.xmetodos.PresentacionImpresora(this.xmetodos.getRutaRep() + "L_Resultados.jasper", parametros);
                    }
                }
                return;
            }
            if (n == 1) {
                mCrearArchivos();
            }
        }
    }

    private void mCrearArchivos() {
        new File("C:/Genoma/reportes/L_Resultados.pdf");
        String x = this.xjppersona.getHistoria();
        File directorio = new File("c:\\Genoma\\" + x.replaceAll("/", "-"));
        if (directorio.mkdir()) {
        }
        for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
            if (this.xmodelo.getValueAt(i, 4).toString().equals("true")) {
                String[][] parametros = new String[3][2];
                parametros[0][0] = "id";
                parametros[0][1] = this.xmodelo.getValueAt(i, 0).toString();
                parametros[1][0] = "SUBREPORT_DIR";
                parametros[1][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra();
                parametros[2][0] = "SUBREPORTFIRMA_DIR";
                parametros[2][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra();
                this.xmetodos.CrearPDF(this.xmetodos.getRutaRep() + "L_Resultados", parametros);
                String adjunto = "C:/Genoma/reportes/" + this.xmodelo.getValueAt(i, 0).toString() + "_" + this.xmodelo.getValueAt(i, 1).toString() + "_" + this.xmodelo.getValueAt(i, 2).toString() + "_" + this.xmodelo.getValueAt(i, 3).toString() + ".pdf";
                File f1 = new File("C:/Genoma/reportes/L_Resultados.pdf");
                File f2 = new File(adjunto);
                f1.renameTo(f2);
                f2.renameTo(new File(directorio, f2.getName()));
            }
        }
    }

    public void mAbrirArchivo() {
        try {
            Runtime.getRuntime().exec("C:\\Archivos de Programa\\Windows NT\\Accesorios\\wordpad.exe c:\\Genoma\\Reportes\\RTF_Salida.rtf");
        } catch (IOException ex) {
            Logger.getLogger(RecepcionAuto.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarPanelUsuario() {
        this.xjppersona = new Persona(this);
        this.xjppersona.setVisible(true);
        this.JPIDUsuario.setVisible(false);
        this.xjppersona.setBounds(6, 15, 980, 160);
        this.JPIDUsuario.add(this.xjppersona);
        this.JPIDUsuario.setVisible(true);
    }
}
