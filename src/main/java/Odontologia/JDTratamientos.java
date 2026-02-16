package Odontologia;

import Citas.CitaNP;
import Citas.CitasGral;
import Historia.JPASaludOcupacional;
import Utilidades.ConsultasMySQL;
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
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Odontologia/JDTratamientos.class */
public class JDTratamientos extends JDialog {
    public DefaultTableModel xmodelo;
    private ConsultasMySQL xct;
    private Object[] xdato;
    private JPASaludOcupacional xjifso;
    private CitasGral xcita;
    private CitaNP xCitaNP;
    private String frmllamador;
    private String xIdUsuario;
    private int estadoTratamiento;
    private JButton JBTCerrar;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JCheckBox jCheckBox1;

    public JDTratamientos(Frame parent, boolean modal, JInternalFrame nbreFrm) {
        super(parent, modal);
        this.xct = new ConsultasMySQL();
        this.xIdUsuario = "";
        this.estadoTratamiento = 1;
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        realizarcasting(nbreFrm);
        mCargarDetalle();
    }

    private void realizarcasting(JInternalFrame frm) {
        if (frm.getName().equals("Citas")) {
            System.out.println("Llamador-->" + frm.getName());
            this.xcita = (CitasGral) frm;
            this.frmllamador = "Citas";
            this.xIdUsuario = this.xcita.frmPersona.IdPersona;
            return;
        }
        if (frm.getName().equals("CitaNP")) {
            System.out.println("Llamador-->" + frm.getName());
            this.xCitaNP = (CitaNP) frm;
            this.frmllamador = "CitaNP";
            this.xIdUsuario = this.xCitaNP.frmPersona1.IdPersona;
        }
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JBTCerrar = new JButton();
        this.jCheckBox1 = new JCheckBox();
        setDefaultCloseOperation(2);
        setTitle("TRATAMIENTOS");
        setFont(new Font("Arial", 1, 14));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Odontologia.JDTratamientos.1
            public void mouseClicked(MouseEvent evt) {
                JDTratamientos.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JBTCerrar.setFont(new Font("Arial", 1, 12));
        this.JBTCerrar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBTCerrar.setText("Cerrar");
        this.JBTCerrar.addActionListener(new ActionListener() { // from class: Odontologia.JDTratamientos.2
            public void actionPerformed(ActionEvent evt) {
                JDTratamientos.this.JBTCerrarActionPerformed(evt);
            }
        });
        this.jCheckBox1.setFont(new Font("Arial", 1, 12));
        this.jCheckBox1.setText("Mostrar Tratamientos cerrados");
        this.jCheckBox1.addActionListener(new ActionListener() { // from class: Odontologia.JDTratamientos.3
            public void actionPerformed(ActionEvent evt) {
                JDTratamientos.this.jCheckBox1ActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle).addGroup(layout.createSequentialGroup().addComponent(this.JBTCerrar, -2, 639, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox1, -1, 239, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle, -1, 251, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTCerrar, -2, 46, -2).addComponent(this.jCheckBox1)).addGap(6, 6, 6)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1 && evt.getClickCount() == 2) {
            if (!this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString().equals("CERRADO")) {
                if (this.frmllamador.equals("Citas")) {
                    if (this.xcita.listaClaseCita[this.xcita.cboClaseCita.getSelectedIndex()][3].equals("1")) {
                        this.xcita.JTFTratamientoO.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
                        this.xcita.setIdTratamientoOdontologico(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
                        this.xcita.setIdIngreso(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 8).toString());
                    } else {
                        JOptionPane.showMessageDialog(this, "Clase se cita seleccionada es de primer vez;\nNo se puede asignar tratamiento seleccionado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.xcita.setIdTratamientoOdontologico("0");
                        this.xcita.setIdIngreso("0");
                        this.xcita.JTFTratamientoO.setText("0");
                    }
                } else if (this.frmllamador.equals("CitaNP")) {
                    this.xCitaNP.JTFTratamientoO.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
                }
                dispose();
                return;
            }
            JOptionPane.showMessageDialog(this, "NO PUEDE CARGAR UN TRATAMIENTO CERRADO");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCerrarActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox1ActionPerformed(ActionEvent evt) {
        this.estadoTratamiento = 0;
        mCargarDetalle();
    }

    private void mCrearTablaDetalle() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"IdTratamiento", "Fecha Inicio", "Fecha Fin", "Profesional", "Especialidad", "Estado", "CIE10", "Patología", "IdIngreso", "Fecha Ultimo Atencion"}) { // from class: Odontologia.JDTratamientos.4
            Class[] types = {Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTDetalle.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(150);
    }

    private void mCargarDetalle() {
        mCrearTablaDetalle();
        String sql = "with maestra AS (SELECT\n\to_hc_tratamiento.Id,\n\to_hc_tratamiento.FInicio ,\n\to_hc_tratamiento.FPFin ,\n\tCONCAT(g_persona.Apellido1, ' ', g_persona.Apellido2, ' ', g_persona.Nombre1, ' ', g_persona.Nombre2) AS NProfesional,\n\tg_especialidad.Nbre AS Especialidad,\n\tIF(o_hc_tratamiento.Estado = 0,\n\t'CERRADO',\n\t'ABIERTO') as Estado,\n\th_atencion.Codigo_Dxp,\n\tg_patologia.Nbre AS Patologia,\n\tingreso.Id AS idIngreso\nFROM\n\to_hc_tratamiento\nINNER JOIN baseserver.h_atencion   ON (o_hc_tratamiento.Id_Atencion = h_atencion.Id)\nINNER JOIN g_profesional           ON (o_hc_tratamiento.Id_Profesional = g_profesional.Id_Persona)\nINNER JOIN g_persona               ON (g_persona.Id = g_profesional.Id_Persona)\nINNER JOIN g_especialidad          ON (o_hc_tratamiento.Id_Especialidad = g_especialidad.Id)\nINNER JOIN ingreso                 ON (h_atencion.Id_Ingreso = ingreso.Id)\nLEFT JOIN g_patologia              ON (h_atencion.Codigo_Dxp = g_patologia.Id)\nWHERE\n\t(ingreso.Id_Usuario = '" + this.xIdUsuario + "'\n\t\tAND o_hc_tratamiento.Estado = '" + this.estadoTratamiento + "') \nORDER BY\n\to_hc_tratamiento.FInicio ASC),\nultima_cita AS (\nSELECT\n    Id_Usuario,\n    Id_TratamientoO,\n    cc.Fecha_Cita fechaUltimaCita,\n\tROW_NUMBER() OVER (PARTITION BY cc.Id_TratamientoO ORDER BY  cc.Id_TratamientoO, cc.Fecha_Cita desc) as consecutivo\nFROM\n\tc_citas cc\nINNER JOIN maestra ON (maestra.id = cc.Id_TratamientoO)\nORDER BY Fecha_Cita ASC)\n  SELECT \n    m.Id,\n\tm.FInicio ,\n\tm.FPFin ,\n\tm.NProfesional,\n\tm.Especialidad,\n\tm.Estado,\n\tm.Codigo_Dxp,\n\tm.Patologia,\n\tm.idIngreso, \n\tIFNULL(uc.fechaUltimaCita, '') fechaUltimaCita\n   FROM maestra m\nINNER JOIN ultima_cita uc ON (m.Id=uc.Id_TratamientoO) AND (consecutivo=1)";
        System.out.println(sql);
        ResultSet rs = this.xct.traerRs(sql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Integer.valueOf(rs.getInt(1)), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo.setValueAt(rs.getString(3), x, 2);
                    this.xmodelo.setValueAt(rs.getString(4), x, 3);
                    this.xmodelo.setValueAt(rs.getString(5), x, 4);
                    this.xmodelo.setValueAt(rs.getString(6), x, 5);
                    this.xmodelo.setValueAt(rs.getString(7), x, 6);
                    this.xmodelo.setValueAt(rs.getString(8), x, 7);
                    this.xmodelo.setValueAt(rs.getString(9), x, 8);
                    this.xmodelo.setValueAt(rs.getString(10), x, 9);
                    x++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }
}
