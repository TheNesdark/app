package Laboratorio;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Laboratorio/JIFImportacionQuimica.class */
public class JIFImportacionQuimica extends JInternalFrame {
    private Object[] dato;
    private String sql;
    public DefaultTableModel xmodelo;
    private claseLab xclaselab;
    private File xfile;
    private String[] xlistaBact;
    private ButtonGroup JBGFiltro;
    private ButtonGroup JBGFiltroNp;
    private JButton JBTEscuchar;
    private JButton JBTGrabar;
    private JScrollPane JSPDatos;
    private JTable JTBDatosImp;
    private Metodos metodos = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();
    public boolean xestado = false;

    public JIFImportacionQuimica(claseLab xclaselab) {
        initComponents();
        this.xclaselab = xclaselab;
        mCrearTabla();
    }

    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGFiltro = new ButtonGroup();
        this.JBGFiltroNp = new ButtonGroup();
        this.JSPDatos = new JScrollPane();
        this.JTBDatosImp = new JTable();
        this.JBTEscuchar = new JButton();
        this.JBTGrabar = new JButton();
        setClosable(true);
        setTitle("IMPORTACIÓN RESULTADOS DE QUÍMICA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("ImportacionQuimica");
        setPreferredSize(new Dimension(790, 509));
        this.JSPDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS A IMPORTAR", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JSPDatos.setHorizontalScrollBarPolicy(31);
        this.JSPDatos.setVerticalScrollBarPolicy(21);
        this.JTBDatosImp.setFont(new Font("Arial", 1, 12));
        this.JTBDatosImp.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDatosImp.setAutoResizeMode(4);
        this.JTBDatosImp.setRowHeight(25);
        this.JTBDatosImp.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDatosImp.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDatosImp.setSelectionMode(0);
        this.JSPDatos.setViewportView(this.JTBDatosImp);
        this.JBTEscuchar.setFont(new Font("Arial", 1, 12));
        this.JBTEscuchar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/contrato.png")));
        this.JBTEscuchar.setText("Cargar Archivo");
        this.JBTEscuchar.addActionListener(new ActionListener() { // from class: Laboratorio.JIFImportacionQuimica.1
            public void actionPerformed(ActionEvent evt) {
                JIFImportacionQuimica.this.JBTEscucharActionPerformed(evt);
            }
        });
        this.JBTGrabar.setFont(new Font("Arial", 1, 12));
        this.JBTGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGrabar.setText("Grabar");
        this.JBTGrabar.addActionListener(new ActionListener() { // from class: Laboratorio.JIFImportacionQuimica.2
            public void actionPerformed(ActionEvent evt) {
                JIFImportacionQuimica.this.JBTGrabarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDatos, -1, 754, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JBTEscuchar, -2, 360, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBTGrabar, -2, 360, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDatos, -2, 370, -2).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTEscuchar, -1, 57, 32767).addComponent(this.JBTGrabar, -1, -1, 32767)).addGap(24, 24, 24)));
        getAccessibleContext().setAccessibleName("");
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTEscucharActionPerformed(ActionEvent evt) {
        mCargarArchivos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGrabarActionPerformed(ActionEvent evt) {
        mGrabar();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Abreviatura", "N° Orden", "Valor", "Alterado?", "Validar?"}) { // from class: Laboratorio.JIFImportacionQuimica.3
            Class[] types = {String.class, String.class, String.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {true, true, false, true, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDatosImp.setModel(this.xmodelo);
        this.JTBDatosImp.getColumnModel().getColumn(0).setPreferredWidth(40);
        this.JTBDatosImp.getColumnModel().getColumn(1).setPreferredWidth(40);
        this.JTBDatosImp.getColumnModel().getColumn(2).setPreferredWidth(40);
        this.JTBDatosImp.getColumnModel().getColumn(3).setPreferredWidth(40);
        this.JTBDatosImp.getColumnModel().getColumn(4).setPreferredWidth(40);
    }

    private void mCargarArchivos() {
        JFileChooser xfilec = new JFileChooser("S:\\laboratoriofpz\\ResulQuimica\\");
        int xv = xfilec.showOpenDialog(this);
        if (xv == 0) {
            try {
                mCrearTabla();
                this.xfile = xfilec.getSelectedFile();
                String xnombre = xfilec.getSelectedFile().getName();
                System.out.println(xnombre);
                BufferedReader bf = new BufferedReader(new FileReader(this.xfile.getAbsolutePath()));
                Vector xvector = new Vector();
                for (String linea = bf.readLine(); linea != null; linea = bf.readLine()) {
                    System.out.println("Linea : " + linea);
                    xvector.add(linea + "\n");
                }
                int xfila = 0;
                for (int x = 6; x < xvector.size(); x++) {
                    this.xmodelo.addRow(this.dato);
                    mSepararCadena(xvector.get(x).toString(), xnombre, xfila);
                    xfila++;
                    this.xestado = false;
                }
                bf.close();
            } catch (IOException ex) {
                Logger.getLogger(JIFImportacionQuimica.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    private String mQuitarEspaciosBlanco(String xtexto) {
        String xnuevacadena = "";
        StringTokenizer stTexto = new StringTokenizer(xtexto);
        while (stTexto.hasMoreElements()) {
            xnuevacadena = xnuevacadena + stTexto.nextElement();
        }
        return xnuevacadena;
    }

    private void mSepararCadena(String xtexto, String xabreviatura, int xnf) {
        String[] xdato1 = xtexto.split("\t");
        for (int i = 0; i < xdato1.length; i++) {
            this.xmodelo.setValueAt(xabreviatura.substring(0, xabreviatura.length() - 4), xnf, 0);
            this.xmodelo.setValueAt(mQuitarEspaciosBlanco(xdato1[5]), xnf, 1);
            this.xmodelo.setValueAt(mQuitarEspaciosBlanco(xdato1[0]), xnf, 2);
            this.xmodelo.setValueAt(false, xnf, 3);
            this.xmodelo.setValueAt(true, xnf, 4);
        }
    }

    private void mGrabar() {
        String xv1;
        String xv2;
        int xmestado;
        int xvalidado;
        if (!this.xestado) {
            for (int x = 0; x < this.JTBDatosImp.getRowCount(); x++) {
                try {
                    String xidusuario = "0";
                    String xsexo = "0";
                    this.sql = "SELECT `persona`.`IdSexo`, `l_recepcion`.`Id_Paciente` FROM `l_recepcion` INNER JOIN  `persona`  ON (`l_recepcion`.`Id_Paciente` = `persona`.`Id_persona`) WHERE (`l_recepcion`.`Id` ='" + this.xmodelo.getValueAt(x, 1).toString() + "') ";
                    ResultSet xrs1 = this.consultas.traerRs(this.sql);
                    if (xrs1.next()) {
                        xrs1.first();
                        xsexo = xrs1.getString(1);
                        xidusuario = xrs1.getString(2);
                    }
                    xrs1.close();
                    this.consultas.cerrarConexionBd();
                    this.sql = "INSERT INTO l_resultados(Id_Recepcion, FechaResult, Observacion, Id_Profesional, Id_Especialidad, fecha, UsuarioS) VALUES('" + this.xmodelo.getValueAt(x, 1).toString() + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    String noResult = this.consultas.ejecutarSQLId(this.sql);
                    this.consultas.cerrarConexionBd();
                    String xsql = "SELECT l_protocoloxprocedimiento.Id, l_protocoloxprocedimiento.Id_Procedim, `l_protocolos`.`VrMinM`, `l_protocolos`.`VrMaxM`, `l_protocolos`.`VrMinF`, `l_protocolos`.`VrMaxF, l_protocoloxprocedimiento.CExamen FROM l_protocoloxprocedimiento INNER JOIN l_protocolos  ON (l_protocoloxprocedimiento.Id_Protocolo = l_protocolos.Id) WHERE (l_protocolos.Abreviatura ='" + this.xmodelo.getValueAt(x, 0).toString() + "') ";
                    ResultSet xrs = this.consultas.traerRs(xsql);
                    if (xrs.next()) {
                        if (xsexo.equals("M")) {
                            xv1 = xrs.getString(3);
                            xv2 = xrs.getString(4);
                        } else {
                            xv1 = xrs.getString(5);
                            xv2 = xrs.getString(6);
                        }
                        ConsultasMySQL xct = new ConsultasMySQL();
                        if (this.xmodelo.getValueAt(x, 3).toString().equals("true")) {
                            xmestado = 1;
                        } else {
                            xmestado = 0;
                        }
                        if (this.xmodelo.getValueAt(x, 4).toString().equals("true")) {
                            xvalidado = 1;
                        } else {
                            xvalidado = 0;
                        }
                        this.sql = "INSERT INTO l_detalleresultado(Id_Resultado, Fecha, Bacteriologo, Id_Especialidad, Id_ProtocolProcedim,Id_Procedimiento, Resultado, VrNumerico,Alterado, VReferencia1, VReferencia2)  VALUES('" + noResult + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + xrs.getInt(1) + "','" + xrs.getLong(2) + "','82','" + this.xmodelo.getValueAt(x, 2).toString() + "','" + xmestado + "','','" + xv1 + "','" + xv2 + "')";
                        System.out.println(this.xmodelo.getValueAt(x, 2).toString());
                        xct.ejecutarSQL(this.sql);
                        xct.cerrarConexionBd();
                        mCambiarEstadoExamen(this.xmodelo.getValueAt(x, 1).toString(), xrs.getString(2), xmestado, xvalidado);
                        if (xrs.getInt(7) != 0) {
                            this.xclaselab.mGrabarHistorico(this.xmodelo.getValueAt(x, 1).toString(), xidusuario, xrs.getString(1), xrs.getInt(7));
                        }
                    }
                    xrs.close();
                    this.consultas.cerrarConexionBd();
                    this.xestado = true;
                } catch (SQLException ex) {
                    Logger.getLogger(JIFImportacionQuimica.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                }
            }
        }
    }

    private void mCambiarEstadoExamen(String xidrecepcion, String xidprocedimiento, int xestado, int xvalidado) {
        ConsultasMySQL xct = new ConsultasMySQL();
        String xsql = "update l_detallerecepcion set Alterado='" + xestado + "', ValidadoLab='" + xvalidado + "' where Id_Recepcion='" + xidrecepcion + "' and Id_Procedim='" + xidprocedimiento + "'";
        xct.ejecutarSQL(xsql);
        xct.cerrarConexionBd();
    }
}
