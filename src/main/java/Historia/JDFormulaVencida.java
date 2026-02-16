package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import Utilidades.convertirNumerosLetras;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JDFormulaVencida.class */
public class JDFormulaVencida extends JDialog {
    private ConsultasMySQL xconsulta;
    private Metodos xmetodos;
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private JPOOrdenSuministroH xordensum;
    private String xpersona;
    private JButton JBTCerrar;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;

    public JDFormulaVencida(Frame parent, boolean modal, String xidpersona) {
        super(parent, modal);
        this.xconsulta = new ConsultasMySQL();
        this.xmetodos = new Metodos();
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.xpersona = xidpersona;
        setLocationRelativeTo(null);
        mCargarDatos();
    }

    /* JADX WARN: Type inference failed for: r3v8, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBTCerrar = new JButton();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setDefaultCloseOperation(2);
        setTitle("FÓRMULAS VENCIDAS");
        setIconImage(null);
        setName("jifformulavencida");
        this.JBTCerrar.setFont(new Font("Arial", 1, 12));
        this.JBTCerrar.setForeground(Color.blue);
        this.JBTCerrar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/salir16x16.png")));
        this.JBTCerrar.setText("Salir");
        this.JBTCerrar.addActionListener(new ActionListener() { // from class: Historia.JDFormulaVencida.1
            public void actionPerformed(ActionEvent evt) {
                JDFormulaVencida.this.JBTCerrarActionPerformed(evt);
            }
        });
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(51, 102, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Historia.JDFormulaVencida.2
            public void mouseClicked(MouseEvent evt) {
                JDFormulaVencida.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(379, 32767).addComponent(this.JBTCerrar, -2, 117, -2).addGap(361, 361, 361)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle, -1, 837, 32767).addContainerGap())));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(258, 258, 258).addComponent(this.JBTCerrar, -2, 51, -2).addContainerGap(-1, 32767)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle, -2, 242, -2).addContainerGap(67, 32767))));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCerrarActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            mImprimir(Long.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString()).longValue(), 1);
        }
    }

    private void mImprimir(long idorden, int n) {
        try {
            SimpleDateFormat xfechar = new SimpleDateFormat("dd/MM/yyyy");
            String xnotasad = null;
            String tipo = "Farmacia";
            new convertirNumerosLetras();
            String sql = "SELECT Id_Atencion, Id, FechaOrden FROM baseserver.h_ordenes where Id='" + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0) + "'";
            new Metodos();
            ResultSet rsm = this.xconsulta.traerRs(sql);
            rsm.first();
            if (rsm.getRow() != 0) {
                new Metodos();
                String sql2 = "SELECT Id_Atencion, Id, FechaOrden FROM  baseserver.h_ordenes where  Id_Atencion='" + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5) + "' and Id>'" + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0) + "' order by Id";
                ResultSet xrsm = this.xconsulta.traerRs(sql2);
                xrsm.next();
                if (xrsm.getRow() != 0) {
                    xnotasad = "Orden N° : " + xrsm.getInt(2) + "  - - - Fecha Proxima Entrega : " + xfechar.format((Date) xrsm.getDate(3));
                }
                xrsm.close();
                this.xconsulta.cerrarConexionBd();
            }
            String[][] mparametros = new String[8][2];
            String usuario = Principal.usuarioSistemaDTO.getLogin();
            for (int j = 0; j < n; j++) {
                mparametros[0][0] = "ndescuento";
                mparametros[0][1] = "";
                mparametros[1][0] = "valorLetras";
                mparametros[1][1] = "";
                mparametros[2][0] = "norden";
                mparametros[2][1] = String.valueOf(idorden);
                mparametros[3][0] = "xp2";
                mparametros[3][1] = tipo;
                mparametros[4][0] = "ip";
                mparametros[4][1] = xnotasad;
                mparametros[5][0] = "nusuarios";
                mparametros[5][1] = usuario;
                mparametros[6][0] = "SUBREPORT_DIR";
                mparametros[6][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra();
                mparametros[7][0] = "SUBREPORTFIRMA_DIR";
                mparametros[7][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra();
                this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "RFormulaGeneralMP", mparametros);
                tipo = "Usuario";
            }
            rsm.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException e) {
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id Orden", "Tipo Fórmula", "Profesional", "Estado", "Usuario", "Fecha Orden", "URL Soporte"}) { // from class: Historia.JDFormulaVencida.3
            Class[] types = {Integer.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(190);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(190);
    }

    private void mCargarDatos() {
        try {
            mCrearModelo();
            String sql = "SELECT  `h_ordenes`.`Id`  , `h_tipoformula`.`Nbre`, `profesional`.`NProfesional`, IF(`h_ordenes`.`EstaEntregada`=0,'No Entregada', IF(`h_ordenes`.`EstaEntregada`=1,'Entregada',IF(`h_ordenes`.`EstaEntregada`=3,'Empacada','Ok')))AS estado, `persona`.`NUsuario`, `h_ordenes`.`FechaOrden`, `h_ordenes`.`UrlSoporte` FROM `h_ordenes` INNER JOIN `h_atencion`  ON (`h_ordenes`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN `h_tipoformula`  ON (`h_ordenes`.`IdTipoFormula` = `h_tipoformula`.`Id`)INNER JOIN `profesional`  ON (`h_ordenes`.`Id_Profesional` = `profesional`.`Id_Persona`)INNER JOIN `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)INNER JOIN `persona`  ON (`ingreso`.`Id_Usuario` = `persona`.`Id_persona`)WHERE (`persona`.`Id_persona` ='" + this.xpersona + "' AND `h_ordenes`.`FechaOrden`<= NOW() AND `h_ordenes`.`EstaEntregada`=0 AND `h_ordenes`.`Estado`=0)";
            ResultSet xrs = this.xconsulta.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelo.setValueAt(xrs.getString(7), n, 6);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDFormulaVencida.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
