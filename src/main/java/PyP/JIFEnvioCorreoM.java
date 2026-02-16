package PyP;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:PyP/JIFEnvioCorreoM.class */
public class JIFEnvioCorreoM extends JInternalFrame {
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String xsql;
    private ButtonGroup JBGSeleccion;
    private JButton JBTEnviar;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField txtCorreo;

    public JIFEnvioCorreoM() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v28, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGSeleccion = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.txtCorreo = new JTextField();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JBTEnviar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("ENVIAR EMAIL");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setName("jifenviaremail");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: PyP.JIFEnvioCorreoM.1
            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFEnvioCorreoM.this.formInternalFrameClosing(evt);
            }

            public void internalFrameOpened(InternalFrameEvent evt) {
            }

            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }
        });
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.txtCorreo.setFont(new Font("Arial", 1, 12));
        this.txtCorreo.setText("laboratorio@fundacionpanzenu.org.co");
        this.txtCorreo.setBorder(BorderFactory.createTitledBorder((Border) null, "Email", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JDFechaI, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFechaF, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtCorreo, -1, 576, 32767).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.txtCorreo, 0, 0, 32767).addComponent(this.JDFechaF, GroupLayout.Alignment.LEADING, -1, 45, 32767).addComponent(this.JDFechaI, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JSPDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: PyP.JIFEnvioCorreoM.2
            public void mouseClicked(MouseEvent evt) {
                JIFEnvioCorreoM.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JBTEnviar.setFont(new Font("Arial", 1, 14));
        this.JBTEnviar.setForeground(Color.blue);
        this.JBTEnviar.setText("Generar PDF");
        this.JBTEnviar.addActionListener(new ActionListener() { // from class: PyP.JIFEnvioCorreoM.3
            public void actionPerformed(ActionEvent evt) {
                JIFEnvioCorreoM.this.JBTEnviarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING, -1, 858, 32767).addComponent(this.JBTEnviar, GroupLayout.Alignment.LEADING, -1, 858, 32767).addComponent(this.JPIDatos, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -1, 260, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTEnviar, -2, 43, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTEnviarActionPerformed(ActionEvent evt) {
        enviarCorreo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1 && this.JTDetalle.getSelectedColumn() == 0) {
            String[][] parametros = new String[3][2];
            parametros[0][0] = "Id";
            parametros[0][1] = this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString();
            parametros[1][0] = "SUBREPORT_DIR";
            parametros[1][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra();
            parametros[2][0] = "SUBREPORTFIRMA_DIR";
            parametros[2][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra();
            this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "P_EnvioCitologiaN", parametros);
        }
    }

    private int validarDatos() {
        int retorno = 0;
        if (this.txtCorreo.getText().isEmpty()) {
            this.xmetodos.mostrarMensaje("Por favor digite la Dirección de Correo donde se enviarán las tomas realizadas");
            this.txtCorreo.requestFocus();
        } else {
            int encontrado = 0;
            int f = 0;
            while (true) {
                if (f >= this.txtCorreo.getText().length()) {
                    break;
                }
                if (!this.txtCorreo.getText().substring(f, f + 1).equals("@")) {
                    f++;
                } else {
                    encontrado = 1;
                    break;
                }
            }
            if (encontrado == 0) {
                this.xmetodos.mostrarMensaje("Por favor coloque el simbolo de arroba @ a la dirección de Correo donde se enviarán las tomas realizadas");
                this.txtCorreo.requestFocus();
            } else {
                retorno = 1;
            }
        }
        return retorno;
    }

    private void enviarCorreo() {
        if (this.xmetodos.getPregunta("Esta seguro de generar los pdf?") == 0 && validarDatos() == 1) {
            mGenerarPDF();
        }
    }

    private void mGenerarPDF() {
        File directorio2 = new File("C:\\Genoma\\Citologias\\");
        if (directorio2.exists()) {
            Metodos.mBorrarDirectorio(directorio2);
            if (directorio2.delete()) {
                mCrearArchivosPDF(new File("C:\\Genoma\\Citologias\\"));
                return;
            } else {
                System.out.println("Se ocaciono un error al borrar el directorio :(");
                return;
            }
        }
        mCrearArchivosPDF(directorio2);
    }

    private void mCrearArchivosPDF(File xdirectorio) {
        if (xdirectorio.mkdirs()) {
            String xruta = xdirectorio.getPath();
            System.out.println("Se ha creado directorio");
            System.out.println(xruta);
            String[][] parametros = new String[2][2];
            for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
                if (Boolean.valueOf(this.xmodelo.getValueAt(x, 3).toString()).booleanValue()) {
                    String nbre = "" + this.xmodelo.getValueAt(x, 1).toString();
                    parametros[0][0] = "Id";
                    parametros[0][1] = this.xmodelo.getValueAt(x, 0).toString();
                    this.xmetodos.mGenerarPDF("P_EnvioCitologiaN", parametros, nbre, xruta);
                }
            }
            return;
        }
        System.out.println("No se ha podido crear el directorio");
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JDFechaI.setDate(this.xmetodos.getFechaActual());
        this.JDFechaF.setDate(this.xmetodos.getFechaActual());
        mCrearModeloDatos();
        this.JDFechaI.requestFocus();
    }

    public void mImprimir() {
        if (!Principal.txtNo.getText().isEmpty()) {
            String[][] mparametros = new String[5][2];
            mparametros[0][0] = "IdC";
            mparametros[0][1] = Principal.txtNo.getText();
            mparametros[1][0] = "UsuarioS";
            mparametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
            mparametros[2][0] = "TipoDoc";
            mparametros[2][1] = "";
            mparametros[3][0] = "SUBREPORT_DIR";
            mparametros[3][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra();
            mparametros[4][0] = "SUBREPORTFIRMA_DIR";
            mparametros[4][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra();
            this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "CC_OrdenCompra", mparametros);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"N° Orden", "N° HC", "Usuario", "Enviar?"}) { // from class: PyP.JIFEnvioCorreoM.4
            Class[] types = {Long.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(30);
    }

    public void mBuscar() {
        this.xsql = "SELECT p_citologia.Id, persona.NoHistoria, persona.NUsuario FROM baseserver.persona INNER JOIN baseserver.p_citologia  ON (persona.Id_persona = p_citologia.Id_Persona) WHERE (p_citologia.FechaToma >='" + this.xmetodos.formatoAMD.format(this.JDFechaI.getDate()) + "' AND p_citologia.FechaToma <='" + this.xmetodos.formatoAMD.format(this.JDFechaF.getDate()) + "' AND p_citologia.Estado =0) ";
        mCargarDatosTabla(this.xsql);
    }

    private void mCargarDatosTabla(String xsql) {
        try {
            mCrearModeloDatos();
            ResultSet xrs = this.xconsulta.traerRs(xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(true, n, 3);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFEnvioCorreoM.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
