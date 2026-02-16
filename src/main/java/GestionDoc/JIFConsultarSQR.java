package GestionDoc;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/* JADX INFO: loaded from: GenomaP.jar:GestionDoc/JIFConsultarSQR.class */
public class JIFConsultarSQR extends JInternalFrame {
    private Object[] dato;
    private clasesGestionDoc xclase;
    private Object[] xdato;
    private JButton JBTCerrar;
    private JLabel JLBTitulo;
    private JScrollPane JSPDetalleConsulta;
    private JTable JTBDetalle;
    private DefaultTableModel xmodeloproc = new DefaultTableModel();
    private TableColumn column = null;
    private int xestado = 0;
    private ConsultasMySQL xconsultasbd = new ConsultasMySQL();
    private Metodos xmetodo = new Metodos();

    public JIFConsultarSQR(clasesGestionDoc xclase) {
        initComponents();
        setLocation((this.xmetodo.getAnchoPantalla() / 2) / 2, (this.xmetodo.getAltoPantalla() / 2) / 2);
        this.xclase = xclase;
        mCargarDatos();
    }

    private void initComponents() {
        this.JSPDetalleConsulta = new JScrollPane();
        this.JTBDetalle = new JTable();
        this.JLBTitulo = new JLabel();
        this.JBTCerrar = new JButton();
        setClosable(true);
        setTitle("CONSULTA DE QRS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        this.JSPDetalleConsulta.setBorder(BorderFactory.createEtchedBorder());
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setRowHeight(25);
        this.JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDetalle.setSelectionMode(0);
        this.JTBDetalle.addMouseListener(new MouseAdapter() { // from class: GestionDoc.JIFConsultarSQR.1
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarSQR.this.JTBDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalleConsulta.setViewportView(this.JTBDetalle);
        this.JLBTitulo.setBackground(new Color(0, 0, 153));
        this.JLBTitulo.setFont(new Font("Arial", 1, 18));
        this.JLBTitulo.setForeground(new Color(204, 255, 255));
        this.JLBTitulo.setHorizontalAlignment(0);
        this.JLBTitulo.setText("RESULTADO DE BUSQUEDA DE QRS");
        this.JLBTitulo.setBorder(BorderFactory.createEtchedBorder());
        this.JLBTitulo.setOpaque(true);
        this.JBTCerrar.setFont(new Font("Arial", 1, 12));
        this.JBTCerrar.setForeground(new Color(0, 0, 153));
        this.JBTCerrar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBTCerrar.setText("Cerrar");
        this.JBTCerrar.addActionListener(new ActionListener() { // from class: GestionDoc.JIFConsultarSQR.2
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarSQR.this.JBTCerrarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(371, 371, 371).addComponent(this.JBTCerrar)).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalleConsulta, -1, 942, 32767).addComponent(this.JLBTitulo, -1, 942, 32767)))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JLBTitulo, -2, 28, -2).addGap(18, 18, 18).addComponent(this.JSPDetalleConsulta, -1, 331, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTCerrar).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleMouseClicked(MouseEvent evt) {
        try {
            if (this.JTBDetalle.getSelectedRow() != -1) {
                this.xclase.xjiregistroqrsr.mBuscar(this.xmodeloproc.getValueAt(this.JTBDetalle.getSelectedRow(), 0).toString());
            }
            this.xclase.xjiregistroqrsr.setSelected(true);
            dispose();
        } catch (PropertyVetoException e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCerrarActionPerformed(ActionEvent evt) {
        dispose();
    }

    private void mCrearTablaDetalle() {
        this.xmodeloproc = new DefaultTableModel();
        this.xmodeloproc.addColumn("N°");
        this.xmodeloproc.addColumn("Fecha");
        this.xmodeloproc.addColumn("Tipo");
        this.xmodeloproc.addColumn("Tipo Empresa");
        this.xmodeloproc.addColumn("Medio");
        this.xmodeloproc.addColumn("Area");
        this.xmodeloproc.addColumn("Descripción");
        this.JTBDetalle.setModel(this.xmodeloproc);
        this.column = this.JTBDetalle.getColumnModel().getColumn(0);
        this.column.setPreferredWidth(5);
        this.column = this.JTBDetalle.getColumnModel().getColumn(1);
        this.column.setPreferredWidth(40);
        this.column = this.JTBDetalle.getColumnModel().getColumn(2);
        this.column.setPreferredWidth(80);
        this.column = this.JTBDetalle.getColumnModel().getColumn(3);
        this.column.setPreferredWidth(50);
        this.column = this.JTBDetalle.getColumnModel().getColumn(4);
        this.column.setPreferredWidth(40);
        this.column = this.JTBDetalle.getColumnModel().getColumn(5);
        this.column.setPreferredWidth(90);
        this.column = this.JTBDetalle.getColumnModel().getColumn(6);
        this.column.setPreferredWidth(320);
    }

    private void mCargarDatos() {
        mCrearTablaDetalle();
        ResultSet xrs = this.xconsultasbd.traerRs("SELECT t_registroqrs.Id, DATE_FORMAT(t_registroqrs.FechaQRS, '%d-%m-%Y') as fecha, t_tiporegistro.Nbre, g_tipoempresa.Nbre, g_mediorecepcion.Nbre, t_sitioocurrencia.Nbre, t_registroqrs.Descripcion, t_registroqrs.Causas    FROM baseserver.t_registroqrs INNER JOIN baseserver.t_tiporegistro  ON (t_registroqrs.Id_TipoR = t_tiporegistro.Id) INNER JOIN baseserver.g_tipoempresa  ON (t_registroqrs.Id_TipoEmpresa = g_tipoempresa.Id) INNER JOIN baseserver.g_mediorecepcion  ON (t_registroqrs.Id_MRecepcion = g_mediorecepcion.Id)  INNER JOIN baseserver.t_sitioocurrencia  ON (t_registroqrs.Id_Area = t_sitioocurrencia.Id) INNER JOIN baseserver.g_tipoafiliado  ON (t_registroqrs.Id_TipoUsuario = g_tipoafiliado.Id) INNER JOIN baseserver.t_clasificacionqrs  ON (t_registroqrs.Id_Clasificacion = t_clasificacionqrs.Id)  ORDER BY t_registroqrs.FechaQRS ASC ");
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int i = 0;
                while (xrs.next()) {
                    this.xmodeloproc.addRow(this.dato);
                    this.xmodeloproc.setValueAt(Long.valueOf(xrs.getLong(1)), i, 0);
                    this.xmodeloproc.setValueAt(xrs.getString(2), i, 1);
                    this.xmodeloproc.setValueAt(xrs.getString(3), i, 2);
                    this.xmodeloproc.setValueAt(xrs.getString(4), i, 3);
                    this.xmodeloproc.setValueAt(xrs.getString(5), i, 4);
                    this.xmodeloproc.setValueAt(xrs.getString(6), i, 5);
                    this.xmodeloproc.setValueAt(xrs.getString(7), i, 6);
                    i++;
                }
            }
            xrs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException e) {
        }
    }
}
