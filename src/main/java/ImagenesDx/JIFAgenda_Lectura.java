package ImagenesDx;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ImagenesDx/JIFAgenda_Lectura.class */
public class JIFAgenda_Lectura extends JInternalFrame {
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    public DefaultTableModel xmodelo;
    public DefaultTableModel xmodelo1;
    private Object[] xdatos;
    private String xsql;
    private JCheckBox JCHFiltro;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPIDatosFiltro;
    private JScrollPane JSPDEstudios;
    private JScrollPane JSPDUsuarios;
    public JTable JTDEstudios;
    public JTable JTDUsuarios;

    public JIFAgenda_Lectura() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v27, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v34, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatosFiltro = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCHFiltro = new JCheckBox();
        this.JSPDUsuarios = new JScrollPane();
        this.JTDUsuarios = new JTable();
        this.JSPDEstudios = new JScrollPane();
        this.JTDEstudios = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("AGENDA - LECTURA DE IMAGENES DIAGNÓTICAS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifagendalecturarx");
        this.JPIDatosFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS FILTRO", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 13));
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 13));
        this.JCHFiltro.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro.setSelected(true);
        this.JCHFiltro.setText("Por Lectura");
        this.JCHFiltro.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFAgenda_Lectura.1
            public void actionPerformed(ActionEvent evt) {
                JIFAgenda_Lectura.this.JCHFiltroActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosFiltroLayout = new GroupLayout(this.JPIDatosFiltro);
        this.JPIDatosFiltro.setLayout(JPIDatosFiltroLayout);
        JPIDatosFiltroLayout.setHorizontalGroup(JPIDatosFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosFiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaI, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFechaF, -2, 120, -2).addGap(43, 43, 43).addComponent(this.JCHFiltro).addContainerGap(-1, 32767)));
        JPIDatosFiltroLayout.setVerticalGroup(JPIDatosFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosFiltroLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosFiltroLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCHFiltro).addGroup(JPIDatosFiltroLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JDFechaF, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JDFechaI, GroupLayout.Alignment.LEADING, -2, 45, -2))).addContainerGap(-1, 32767)));
        this.JSPDUsuarios.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE USUARIOS", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTDUsuarios.setFont(new Font("Arial", 1, 12));
        this.JTDUsuarios.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDUsuarios.setRowHeight(25);
        this.JTDUsuarios.setSelectionBackground(new Color(255, 255, 255));
        this.JTDUsuarios.setSelectionForeground(new Color(255, 0, 0));
        this.JTDUsuarios.addMouseListener(new MouseAdapter() { // from class: ImagenesDx.JIFAgenda_Lectura.2
            public void mouseClicked(MouseEvent evt) {
                JIFAgenda_Lectura.this.JTDUsuariosMouseClicked(evt);
            }
        });
        this.JSPDUsuarios.setViewportView(this.JTDUsuarios);
        this.JSPDEstudios.setBorder(BorderFactory.createTitledBorder((Border) null, "ESTUDIOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDEstudios.setFont(new Font("Arial", 1, 12));
        this.JTDEstudios.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDEstudios.setRowHeight(25);
        this.JTDEstudios.setSelectionBackground(new Color(255, 255, 255));
        this.JTDEstudios.setSelectionForeground(new Color(255, 0, 0));
        this.JTDEstudios.addMouseListener(new MouseAdapter() { // from class: ImagenesDx.JIFAgenda_Lectura.3
            public void mouseClicked(MouseEvent evt) {
                JIFAgenda_Lectura.this.JTDEstudiosMouseClicked(evt);
            }
        });
        this.JSPDEstudios.setViewportView(this.JTDEstudios);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatosFiltro, -1, -1, 32767).addComponent(this.JSPDUsuarios, -1, 797, 32767).addComponent(this.JSPDEstudios, -1, 797, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosFiltro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDUsuarios, -2, 197, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDEstudios, -2, 197, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDUsuariosMouseClicked(MouseEvent evt) {
        if (this.JTDUsuarios.getSelectedRow() != -1) {
            Object[] botones = {"Imagen DICOM", "Estudios para lectura", "Cerrar"};
            int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer?", "CARGAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
            if (n == 0) {
                mAbrirArchivo();
            } else if (n == 1) {
                mCargarDatosTablaEstudios();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDEstudiosMouseClicked(MouseEvent evt) {
        if (this.JTDEstudios.getSelectedRow() != -1) {
            Object[] botones = {"Texto", "OIT", "Cerrar"};
            int y = JOptionPane.showInternalOptionDialog(this, "Que formato desea utilizar?", "SELECCIONAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
            if (y != 0 && y == 1) {
                Principal.claseimagendx.cargarPantalla("Formato_Oit", this.xmodelo.getValueAt(this.JTDUsuarios.getSelectedRow(), 2).toString(), this.xmodelo1.getValueAt(this.JTDEstudios.getSelectedRow(), 0).toString());
            }
        }
    }

    public void mBuscar() {
        mCargarDatosTablaDU();
    }

    public void mNuevo() {
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        mCrearModeloDU();
        mCrearModeloEstudios();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDU() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "N° Historia", "Usuario", "Sexo", "Edad", "Lectura?", "UrlEstudio"}) { // from class: ImagenesDx.JIFAgenda_Lectura.4
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, Boolean.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDUsuarios.setModel(this.xmodelo);
        this.JTDUsuarios.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDUsuarios.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDUsuarios.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDUsuarios.getColumnModel().getColumn(1).setPreferredWidth(5);
        this.JTDUsuarios.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTDUsuarios.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTDUsuarios.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTDUsuarios.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTDUsuarios.getColumnModel().getColumn(6).setPreferredWidth(10);
        this.JTDUsuarios.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTDUsuarios.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTDUsuarios.getColumnModel().getColumn(7).setMaxWidth(0);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloEstudios() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"Id", "IdRadiologia", "Estudio", "Obervación Tecnico", "Id_Lectura"}) { // from class: ImagenesDx.JIFAgenda_Lectura.5
            Class[] types = {Long.class, Long.class, String.class, String.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDEstudios.setModel(this.xmodelo1);
        this.JTDEstudios.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDEstudios.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDEstudios.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDEstudios.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTDEstudios.getColumnModel().getColumn(1).setMinWidth(0);
        this.JTDEstudios.getColumnModel().getColumn(1).setMaxWidth(0);
        this.JTDEstudios.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDEstudios.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTDEstudios.getColumnModel().getColumn(4).setPreferredWidth(10);
    }

    public void mCargarDatosTablaDU() {
        try {
            mCrearModeloDU();
            if (this.JCHFiltro.isSelected()) {
                this.xsql = "SELECT `h_radiologia`.`Id`, DATE_FORMAT(`h_radiologia`.`Fecha_Rec`,'%d-%m-%Y') AS `Fecha`, `persona`.`NoHistoria`, `persona`.`NUsuario`, `persona`.`IdSexo`, CONCAT(`persona`.`Edad`,' ', `persona`.`NTipoEdad`,'(s)') AS `Edad`, `h_radiologia`.`CLectura`, `h_radiologia`.Url_Estudio FROM  `h_radiologia` INNER JOIN `f_ordenes`  ON (`h_radiologia`.`Id_OrdenFac` = `f_ordenes`.`Id`) INNER JOIN `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `persona`  ON (`persona`.`Id_persona` = `ingreso`.`Id_Usuario`) WHERE (`h_radiologia`.CLectura=0 and DATE_FORMAT(`h_radiologia`.`Fecha_Rec`,'%Y/%m/%d') >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND DATE_FORMAT(`h_radiologia`.`Fecha_Rec`,'%Y/%m/%d') <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `h_radiologia`.`Estado` =1 AND `h_radiologia`.`Id_Profesional`='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' AND `h_radiologia`.`Id_Especialidad`='" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "' ) ORDER BY `persona`.`NUsuario` ASC ";
            } else {
                this.xsql = "SELECT `h_radiologia`.`Id`, DATE_FORMAT(`h_radiologia`.`Fecha_Rec`,'%d-%m-%Y') AS `Fecha`, `persona`.`NoHistoria`, `persona`.`NUsuario`, `persona`.`IdSexo`, CONCAT(`persona`.`Edad`,' ', `persona`.`NTipoEdad`,'(s)') AS `Edad`, `h_radiologia`.`CLectura`, `h_radiologia`.Url_Estudio FROM  `h_radiologia` INNER JOIN `f_ordenes`  ON (`h_radiologia`.`Id_OrdenFac` = `f_ordenes`.`Id`) INNER JOIN `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `persona`  ON (`persona`.`Id_persona` = `ingreso`.`Id_Usuario`) WHERE (`h_radiologia`.CLectura=1 and DATE_FORMAT(`h_radiologia`.`Fecha_Rec`,'%Y/%m/%d') >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND DATE_FORMAT(`h_radiologia`.`Fecha_Rec`,'%Y/%m/%d') <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `h_radiologia`.`Estado` =1 AND `h_radiologia`.`Id_Profesional`='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' AND `h_radiologia`.`Id_Especialidad`='" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "' ) ORDER BY `persona`.`NUsuario` ASC ";
            }
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelo.setValueAt(xrs.getString(8), n, 7);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(7)), n, 6);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFAgenda_Lectura.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mCargarDatosTablaEstudios() {
        try {
            mCrearModeloEstudios();
            this.xsql = "SELECT `h_radiologia_detalle`.`Id`, `h_radiologia_detalle`.`Id_radiologia`, `g_procedimiento`.`Nbre`, if(`h_radiologia_detalle`.`Observacion` is null, '',`h_radiologia_detalle`.`Observacion`) as Observacion , `h_radiologia_detalle`.`Id_RLectura` FROM `h_radiologia_detalle` INNER JOIN  `g_procedimiento`  ON (`h_radiologia_detalle`.`Id_Procedimiento` = `g_procedimiento`.`Id`) WHERE (`h_radiologia_detalle`.`Id_radiologia` ='" + this.xmodelo.getValueAt(this.JTDUsuarios.getSelectedRow(), 0) + "') ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                this.xmt.mEstablecerTextEditor(this.JTDEstudios, 2);
                this.xmt.mEstablecerTextEditor(this.JTDEstudios, 3);
                while (xrs.next()) {
                    this.xmodelo1.addRow(this.xdatos);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(2)), n, 1);
                    this.xmodelo1.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo1.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(5)), n, 4);
                    this.JTDEstudios.setDefaultRenderer(Object.class, new MiRender10());
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFAgenda_Lectura.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:ImagenesDx/JIFAgenda_Lectura$MiRender10.class */
    public static class MiRender10 extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (Long.valueOf(table.getValueAt(row, 4).toString()).longValue() == 0) {
                cell.setBackground(new Color(177, 251, 177));
            } else {
                cell.setBackground(Color.WHITE);
            }
            return cell;
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:ImagenesDx/JIFAgenda_Lectura$MiRender11.class */
    public static class MiRender11 extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (Long.valueOf(table.getValueAt(row, 4).toString()).longValue() == 0) {
                cell.setBackground(new Color(177, 251, 177));
            } else {
                cell.setBackground(Color.WHITE);
            }
            return cell;
        }
    }

    private void mAbrirArchivo() {
        try {
            Runtime.getRuntime().exec("C:\\Genoma\\Visor\\mDicom.exe  " + this.xmt.mTraerUrlBD(this.xmodelo.getValueAt(this.JTDUsuarios.getSelectedRow(), 7).toString()));
        } catch (IOException ex) {
            Logger.getLogger(JIFAgenda_Lectura.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
