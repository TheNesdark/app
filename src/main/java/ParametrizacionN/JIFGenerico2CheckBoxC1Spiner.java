package ParametrizacionN;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
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
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFGenerico2CheckBoxC1Spiner.class */
public class JIFGenerico2CheckBoxC1Spiner extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String xnombre;
    private JCheckBox JCHEstado;
    private JCheckBox JCHEstado1;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JSpinner JSPUno;
    private JTable JTDetalle;
    private JTextField JTFNombre;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 1;
    private int xestado1 = 0;
    private int xestado2 = 0;
    private String xid = "";
    private boolean xestadog = false;

    public JIFGenerico2CheckBoxC1Spiner(String xnombref, String xnombre) {
        initComponents();
        setName(xnombref);
        setTitle(xnombre.toUpperCase());
        this.xnombre = xnombref;
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v30, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JTFNombre = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JCHEstado1 = new JCheckBox();
        this.JSPUno = new JSpinner();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("MUNICIPIO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifgenerico1chbox");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setToolTipText("");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGenerico2CheckBoxC1Spiner.1
            public void actionPerformed(ActionEvent evt) {
                JIFGenerico2CheckBoxC1Spiner.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JCHEstado1.setFont(new Font("Arial", 1, 12));
        this.JCHEstado1.setSelected(true);
        this.JCHEstado1.setText("Estado");
        this.JCHEstado1.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGenerico2CheckBoxC1Spiner.2
            public void actionPerformed(ActionEvent evt) {
                JIFGenerico2CheckBoxC1Spiner.this.JCHEstado1ActionPerformed(evt);
            }
        });
        this.JSPUno.setFont(new Font("Arial", 1, 12));
        this.JSPUno.setBorder(BorderFactory.createTitledBorder((Border) null, "Orden", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFNombre, -2, 500, -2).addGap(18, 18, 18).addComponent(this.JSPUno, -1, 84, 32767).addGap(18, 18, 18).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHEstado).addComponent(this.JCHEstado1)).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombre, -2, -1, -2).addComponent(this.JSPUno, -2, -1, -2)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCHEstado).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEstado1))).addContainerGap(-1, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFGenerico2CheckBoxC1Spiner.3
            public void mouseClicked(MouseEvent evt) {
                JIFGenerico2CheckBoxC1Spiner.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING, -1, 713, 32767).addComponent(this.JPIDatos, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -1, 336, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()).booleanValue());
            this.JSPUno.setValue(Long.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()));
            this.JCHEstado1.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()).booleanValue());
            mIniciarCheck();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstado1ActionPerformed(ActionEvent evt) {
        mIniciarCheck();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        mIniciarCheck();
    }

    private void mIniciarCheck() {
        if (this.xnombre.equals("xjiftipoexamenfisico") || this.xnombre.equals("Vacunas x Edad")) {
            if (this.JCHEstado1.isSelected()) {
                this.xestado1 = 0;
                return;
            } else {
                this.xestado1 = 1;
                return;
            }
        }
        if (this.xnombre.equals("xjifencabezadopreguntaso") || this.xnombre.equals("xjifencabezadorecomendacion")) {
            if (this.JCHEstado1.isSelected()) {
                this.xestado1 = 1;
            } else {
                this.xestado1 = 0;
            }
        }
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JTFNombre.setText("");
        this.JSPUno.setValue(new Integer(0));
        if (this.xnombre.equals("xjiftipoexamenfisico")) {
            this.JCHEstado.setText("Aplica Sexo?");
            this.JCHEstado1.setText("Estado");
            this.xestado = 0;
            this.xestado1 = 0;
            this.JCHEstado.setSelected(false);
            this.JCHEstado1.setSelected(false);
        } else if (this.xnombre.equals("xjifencabezadopreguntaso") || this.xnombre.equals("xjifencabezadorecomendacion")) {
            this.JCHEstado1.setText("Estado");
            this.xestado1 = 1;
            this.JCHEstado.setVisible(false);
            this.JCHEstado1.setSelected(true);
        } else if (this.xnombre.equals("Vacunas x Edad")) {
            this.JCHEstado1.setText("Estado");
            this.xestado1 = 0;
            this.JCHEstado1.setSelected(true);
            this.JCHEstado.setVisible(false);
            this.JSPUno.setBorder(BorderFactory.createTitledBorder((Border) null, "No Días", 0, 0, new Font("Arial", 1, 12), Color.blue));
        }
        this.JTFNombre.requestFocus();
        mCargarDatosTabla();
    }

    public void mGrabar() {
        if (!this.JTFNombre.getText().isEmpty()) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String sql = null;
                if (Principal.txtNo.getText().isEmpty()) {
                    if (this.xnombre.equals("xjiftipoexamenfisico")) {
                        sql = " Insert into h_grupoexamenfisico(Nbre, FiltroSexo, Orden, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.JSPUno.getValue() + "','" + this.xestado1 + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else if (this.xnombre.equals("xjifencabezadopreguntaso")) {
                        sql = " Insert into h_so_preguntas_encabezado(Nbre, Orden, Estado, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.JSPUno.getValue() + "','" + this.xestado1 + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else if (this.xnombre.equals("xjifencabezadorecomendacion")) {
                        sql = " Insert into so_recomendaciones_encabezado(Nbre, NOrder, Estado, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.JSPUno.getValue() + "','" + this.xestado1 + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else if (this.xnombre.equals("Vacunas x Edad")) {
                        if (this.JCHEstado1.isSelected()) {
                            this.xestado1 = 1;
                        }
                        sql = " Insert into p_vacunacion_edad(Nbre, NDias, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.JSPUno.getValue() + "','" + this.xestado1 + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    }
                } else if (this.xnombre.equals("xjiftipoexamenfisico")) {
                    sql = " update h_grupoexamenfisico set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',FiltroSexo='" + this.xestado + "',Orden='" + this.JSPUno.getValue() + "',Estado='" + this.xestado1 + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                } else if (this.xnombre.equals("xjifencabezadopreguntaso")) {
                    sql = " update h_so_preguntas_encabezado set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Orden='" + this.JSPUno.getValue() + "',Estado='" + this.xestado1 + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                } else if (this.xnombre.equals("xjifencabezadorecomendacion")) {
                    sql = " update so_recomendaciones_encabezado set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',NOrder='" + this.JSPUno.getValue() + "',Estado='" + this.xestado1 + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                } else if (this.xnombre.equals("Vacunas x Edad")) {
                    if (this.JCHEstado1.isSelected()) {
                        this.xestado1 = 0;
                    }
                    sql = " update p_vacunacion_edad set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',NDias='" + this.JSPUno.getValue() + "',Estado='" + this.xestado1 + "',Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "',UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                }
                this.xconsulta.ejecutarSQL(sql);
                this.xconsulta.cerrarConexionBd();
                mCargarDatosTabla();
                mNuevo();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El campo nombre no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFNombre.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos(String[] xcabecera) {
        this.xmodelo = new DefaultTableModel(new Object[0], xcabecera) { // from class: ParametrizacionN.JIFGenerico2CheckBoxC1Spiner.4
            Class[] types = {Long.class, String.class, Boolean.class, Long.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(250);
        if (this.xnombre.equals("Vacunas x Edad")) {
            this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(20);
            this.JTDetalle.getColumnModel().getColumn(2).setMinWidth(0);
            this.JTDetalle.getColumnModel().getColumn(2).setMaxWidth(0);
        } else {
            this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(20);
        }
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(20);
        if (this.xnombre.equals("xjiftipoexamenfisico") || this.xnombre.equals("Vacunas x Edad")) {
            this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(20);
        } else if (this.xnombre.equals("xjifencabezadopreguntaso") || this.xnombre.equals("xjifencabezadorecomendacion")) {
            this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(0);
            this.JTDetalle.getColumnModel().getColumn(4).setMinWidth(0);
            this.JTDetalle.getColumnModel().getColumn(4).setMaxWidth(0);
        }
    }

    private void mCargarDatosTabla() {
        try {
            String sql = null;
            String[] xencabezado = null;
            System.out.println(this.xnombre);
            if (this.xnombre.equals("xjiftipoexamenfisico")) {
                xencabezado = new String[]{"Id", "Nombre", "Aplica Sexo?", "Orden", "Estado"};
                sql = "SELECT Id, Nbre, FiltroSexo, Orden, Estado FROM h_grupoexamenfisico ORDER BY Orden ASC";
            } else if (this.xnombre.equals("xjifencabezadopreguntaso")) {
                xencabezado = new String[]{"Id", "Nombre", "Estado", "Orden", ""};
                sql = "SELECT Id, Nbre, Estado, Orden,0  FROM h_so_preguntas_encabezado ORDER BY Orden ASC";
            } else if (this.xnombre.equals("xjifencabezadorecomendacion")) {
                xencabezado = new String[]{"Id", "Nombre", "Estado", "Orden", ""};
                sql = "SELECT Id, Nbre, Estado, NOrder,0  FROM so_recomendaciones_encabezado ORDER BY NOrder ASC";
            } else if (this.xnombre.equals("Vacunas x Edad")) {
                xencabezado = new String[]{"Id", "Nombre", "", "No Dias", "Estado"};
                sql = "SELECT Id, Nbre, 0, NDias, Estado FROM p_vacunacion_edad ORDER BY Nbre ASC";
            }
            mCrearModeloDatos(xencabezado);
            ResultSet xrs = this.xconsulta.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    if (this.xnombre.equals("Vacunas x Edad")) {
                        this.xmodelo.setValueAt(Boolean.valueOf(!xrs.getBoolean(3)), n, 2);
                    } else {
                        this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(3)), n, 2);
                    }
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(4)), n, 3);
                    this.xmodelo.setValueAt(Boolean.valueOf(!xrs.getBoolean(5)), n, 4);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGenericoCh.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
