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
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFSBodegas.class */
public class JIFSBodegas extends JInternalFrame {
    private int xcontabilizada;
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private JButton JBTMovimientoxBodega;
    private JButton JBTTipMedicionxBod;
    private JCheckBox JCHContabilizada;
    private JCheckBox JCHEsPrincipal;
    private JCheckBox JCHEsUrgencias;
    private JCheckBox JCHEstado;
    private JCheckBox JCHMControlTemp;
    private JCheckBox JCHMResiduosPeligrosos;
    private JCheckBox JCHMostrarInventario;
    private JCheckBox JCHReposicion;
    private JCheckBox JCHUnidaEmpaque;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JSpinner JSPPoliticaCompras;
    private JSpinner JSPTiempoR;
    private JTable JTDetalle;
    private JTextField JTFNombre;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 0;
    private int xesprincipal = 0;
    private int xmanejaunidadempaque = 0;
    private int xmostrarinventario = 0;
    private int xreposicion = 0;
    private int xmresiduop = 0;
    private int xmctrltemp = 0;
    private int xesurgencia = 0;

    public JIFSBodegas() {
        initComponents();
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v60, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JTFNombre = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JCHEsPrincipal = new JCheckBox();
        this.JCHUnidaEmpaque = new JCheckBox();
        this.JCHMostrarInventario = new JCheckBox();
        this.JCHReposicion = new JCheckBox();
        this.JCHContabilizada = new JCheckBox();
        this.JCHMResiduosPeligrosos = new JCheckBox();
        this.JCHMControlTemp = new JCheckBox();
        this.JCHEsUrgencias = new JCheckBox();
        this.JSPTiempoR = new JSpinner();
        this.JSPPoliticaCompras = new JSpinner();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JBTMovimientoxBodega = new JButton();
        this.JBTTipMedicionxBod = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("BODEGA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifbodega");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: ParametrizacionN.JIFSBodegas.1
            public void internalFrameOpened(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFSBodegas.this.formInternalFrameClosing(evt);
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }
        });
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setToolTipText("Digite el nombre del municipio");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFSBodegas.2
            public void actionPerformed(ActionEvent evt) {
                JIFSBodegas.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JCHEsPrincipal.setFont(new Font("Arial", 1, 12));
        this.JCHEsPrincipal.setText("Es Principal?");
        this.JCHEsPrincipal.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFSBodegas.3
            public void actionPerformed(ActionEvent evt) {
                JIFSBodegas.this.JCHEsPrincipalActionPerformed(evt);
            }
        });
        this.JCHUnidaEmpaque.setFont(new Font("Arial", 1, 12));
        this.JCHUnidaEmpaque.setText("Maneja U/E?");
        this.JCHUnidaEmpaque.setToolTipText("Maneja unidad de empaque");
        this.JCHUnidaEmpaque.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFSBodegas.4
            public void actionPerformed(ActionEvent evt) {
                JIFSBodegas.this.JCHUnidaEmpaqueActionPerformed(evt);
            }
        });
        this.JCHMostrarInventario.setFont(new Font("Arial", 1, 12));
        this.JCHMostrarInventario.setText("Mostrar Inventario en HC?");
        this.JCHMostrarInventario.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFSBodegas.5
            public void actionPerformed(ActionEvent evt) {
                JIFSBodegas.this.JCHMostrarInventarioActionPerformed(evt);
            }
        });
        this.JCHReposicion.setFont(new Font("Arial", 1, 12));
        this.JCHReposicion.setText("Reposición Automatica?");
        this.JCHReposicion.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFSBodegas.6
            public void actionPerformed(ActionEvent evt) {
                JIFSBodegas.this.JCHReposicionActionPerformed(evt);
            }
        });
        this.JCHContabilizada.setFont(new Font("Arial", 1, 12));
        this.JCHContabilizada.setText("Contabilizada?");
        this.JCHContabilizada.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFSBodegas.7
            public void actionPerformed(ActionEvent evt) {
                JIFSBodegas.this.JCHContabilizadaActionPerformed(evt);
            }
        });
        this.JCHMResiduosPeligrosos.setFont(new Font("Arial", 1, 12));
        this.JCHMResiduosPeligrosos.setText("Maneja Residuos Hospitalarios");
        this.JCHMResiduosPeligrosos.setToolTipText("Maneja residuos hospitalarios");
        this.JCHMResiduosPeligrosos.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFSBodegas.8
            public void actionPerformed(ActionEvent evt) {
                JIFSBodegas.this.JCHMResiduosPeligrososActionPerformed(evt);
            }
        });
        this.JCHMControlTemp.setFont(new Font("Arial", 1, 12));
        this.JCHMControlTemp.setText("Control Temperatura?");
        this.JCHMControlTemp.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFSBodegas.9
            public void actionPerformed(ActionEvent evt) {
                JIFSBodegas.this.JCHMControlTempActionPerformed(evt);
            }
        });
        this.JCHEsUrgencias.setFont(new Font("Arial", 1, 12));
        this.JCHEsUrgencias.setText("Es Urgencia?");
        this.JCHEsUrgencias.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFSBodegas.10
            public void actionPerformed(ActionEvent evt) {
                JIFSBodegas.this.JCHEsUrgenciasActionPerformed(evt);
            }
        });
        this.JSPTiempoR.setFont(new Font("Arial", 1, 12));
        this.JSPTiempoR.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSPTiempoR.setBorder(BorderFactory.createTitledBorder((Border) null, "Tiempo de Reposición", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPPoliticaCompras.setFont(new Font("Arial", 1, 12));
        this.JSPPoliticaCompras.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSPPoliticaCompras.setBorder(BorderFactory.createTitledBorder((Border) null, "Politica de Compras", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHEsPrincipal).addComponent(this.JCHUnidaEmpaque)).addGap(18, 18, 18).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHMostrarInventario).addComponent(this.JCHReposicion)).addGap(18, 18, 18).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCHMResiduosPeligrosos).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEsUrgencias)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCHContabilizada, -2, 118, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHMControlTemp, -2, 160, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEstado))).addGap(0, 0, 32767)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JTFNombre, -2, 382, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPTiempoR, -2, 144, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPPoliticaCompras, -2, 137, -2))).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTFNombre, -2, -1, -2).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JSPTiempoR, -2, -1, -2).addComponent(this.JSPPoliticaCompras, -2, -1, -2))).addGap(18, 18, 18).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHEsPrincipal).addComponent(this.JCHMostrarInventario).addComponent(this.JCHContabilizada).addComponent(this.JCHMControlTemp).addComponent(this.JCHEstado)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHUnidaEmpaque).addComponent(this.JCHReposicion).addComponent(this.JCHMResiduosPeligrosos).addComponent(this.JCHEsUrgencias)).addGap(10, 10, 10)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFSBodegas.11
            public void mouseClicked(MouseEvent evt) {
                JIFSBodegas.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JBTMovimientoxBodega.setFont(new Font("Arial", 1, 12));
        this.JBTMovimientoxBodega.setIcon(new ImageIcon(getClass().getResource("/Imagenes/centro de costo.png")));
        this.JBTMovimientoxBodega.setText("Movimiento por Bodega");
        this.JBTMovimientoxBodega.setEnabled(false);
        this.JBTMovimientoxBodega.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFSBodegas.12
            public void actionPerformed(ActionEvent evt) {
                JIFSBodegas.this.JBTMovimientoxBodegaActionPerformed(evt);
            }
        });
        this.JBTTipMedicionxBod.setFont(new Font("Arial", 1, 12));
        this.JBTTipMedicionxBod.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Contrato2.png")));
        this.JBTTipMedicionxBod.setText("Tipo de Medición");
        this.JBTTipMedicionxBod.setEnabled(false);
        this.JBTTipMedicionxBod.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFSBodegas.13
            public void actionPerformed(ActionEvent evt) {
                JIFSBodegas.this.JBTTipMedicionxBodActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatos, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JBTMovimientoxBodega, -2, 232, -2).addGap(186, 186, 186).addComponent(this.JBTTipMedicionxBod, -2, 257, -2).addGap(0, 0, 32767)).addComponent(this.JSPDetalle)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -1, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -2, 236, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTMovimientoxBodega, -2, 54, -2).addComponent(this.JBTTipMedicionxBod)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        mIniciarCheck();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JCHEsPrincipal.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()).booleanValue());
            this.JCHUnidaEmpaque.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()).booleanValue());
            this.JCHMostrarInventario.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()).booleanValue());
            this.JCHReposicion.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString()).booleanValue());
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString()).booleanValue());
            this.JCHContabilizada.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString()).booleanValue());
            this.JCHMResiduosPeligrosos.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 8).toString()).booleanValue());
            this.JCHMControlTemp.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 9).toString()).booleanValue());
            this.JCHEsUrgencias.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 10).toString()).booleanValue());
            this.JSPTiempoR.setValue(Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 11).toString()));
            this.JSPPoliticaCompras.setValue(Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 12).toString()));
            mIniciarCheck();
            this.JBTMovimientoxBodega.setEnabled(true);
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 9).toString()).booleanValue()) {
                this.JBTTipMedicionxBod.setEnabled(true);
                return;
            } else {
                this.JBTTipMedicionxBod.setEnabled(false);
                return;
            }
        }
        this.JBTMovimientoxBodega.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEsPrincipalActionPerformed(ActionEvent evt) {
        mIniciarCheck();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHUnidaEmpaqueActionPerformed(ActionEvent evt) {
        mIniciarCheck();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHMostrarInventarioActionPerformed(ActionEvent evt) {
        mIniciarCheck();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHReposicionActionPerformed(ActionEvent evt) {
        mIniciarCheck();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTMovimientoxBodegaActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty()) {
            Principal.claseparametrizacionn.cargarPantalla("Movimiento x Bodega");
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una Fila de la Tabla", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHContabilizadaActionPerformed(ActionEvent evt) {
        mIniciarCheck();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHMResiduosPeligrososActionPerformed(ActionEvent evt) {
        mIniciarCheck();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTTipMedicionxBodActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty()) {
            Principal.claseparametrizacionn.cargarPantalla("Tipo Medición x Bodega");
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una Fila de la Tabla", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHMControlTempActionPerformed(ActionEvent evt) {
        mIniciarCheck();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEsUrgenciasActionPerformed(ActionEvent evt) {
        mIniciarCheck();
    }

    public void mNuevo() {
        Principal.txtNo.setText("");
        this.JTFNombre.setText("");
        this.JCHEsPrincipal.setSelected(false);
        this.JCHMostrarInventario.setSelected(false);
        this.JCHReposicion.setSelected(false);
        this.JCHUnidaEmpaque.setSelected(false);
        this.JCHEstado.setSelected(true);
        this.JCHEsUrgencias.setSelected(false);
        this.JSPTiempoR.setValue(0);
        this.JSPPoliticaCompras.setValue(0);
        mCargarDatosTabla();
        mIniciarCheck();
        this.JTFNombre.requestFocus();
    }

    public void mGrabar() {
        String sql;
        if (!this.JTFNombre.getText().isEmpty()) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                if (Principal.txtNo.getText().isEmpty()) {
                    sql = " Insert into i_bodegas(Nbre, Principal, UnidadEmpaque, MostrarInventario, PReposicion, Contabilidad, REntidad, ControlTemp, EsUrg, tiempoReposicion, politicaCompras, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xesprincipal + "','" + this.xmanejaunidadempaque + "','" + this.xmostrarinventario + "','" + this.xreposicion + "','" + this.xcontabilizada + "','" + this.xmresiduop + "','" + this.xmctrltemp + "','" + this.xesurgencia + "','" + this.JSPTiempoR.getValue() + "','" + this.JSPPoliticaCompras.getValue() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                } else {
                    sql = " update i_bodegas set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Principal='" + this.xesprincipal + "',UnidadEmpaque='" + this.xmanejaunidadempaque + "', MostrarInventario='" + this.xmostrarinventario + "',PReposicion='" + this.xreposicion + "',Contabilidad='" + this.xcontabilizada + "',ControlTemp='" + this.xmctrltemp + "',Estado='" + this.xestado + "', REntidad='" + this.xmresiduop + "', EsUrg='" + this.xesurgencia + "', tiempoReposicion='" + this.JSPTiempoR.getValue() + "', politicaCompras='" + this.JSPPoliticaCompras.getValue() + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                }
                this.xconsulta.ejecutarSQL(sql);
                this.xconsulta.cerrarConexionBd();
                mCargarDatosTabla();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El campo nombre no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFNombre.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Pricipal?", "Maneja U/E", "Mostrar Inventario", "reposición Aut", "Estado", "Contabilizada", "MResiduos", "CT°", "EsUrg", "Tiempo Reposicion", "Politica Compras"}) { // from class: ParametrizacionN.JIFSBodegas.14
            Class[] types = {Long.class, String.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class, Integer.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(135);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(50);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            ResultSet xrs = this.xconsulta.traerRs("SELECT Id, Nbre, Principal, UnidadEmpaque, MostrarInventario, PReposicion, Estado, Contabilidad, REntidad,ControlTemp, EsUrg, tiempoReposicion, politicaCompras FROM i_bodegas ORDER BY Nbre ASC");
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(3)), n, 2);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(4)), n, 3);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(5)), n, 4);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(6)), n, 5);
                    this.xmodelo.setValueAt(Boolean.valueOf(!xrs.getBoolean(7)), n, 6);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(8)), n, 7);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(9)), n, 8);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(10)), n, 9);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(11)), n, 10);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt("tiempoReposicion")), n, 11);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt("politicaCompras")), n, 12);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFSPresentacionFarmaceuta.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mIniciarCheck() {
        if (this.JCHEsPrincipal.isSelected()) {
            this.xesprincipal = 1;
        } else {
            this.xesprincipal = 0;
        }
        if (this.JCHUnidaEmpaque.isSelected()) {
            this.xmanejaunidadempaque = 1;
        } else {
            this.xmanejaunidadempaque = 0;
        }
        if (this.JCHMostrarInventario.isSelected()) {
            this.xmostrarinventario = 1;
        } else {
            this.xmostrarinventario = 0;
        }
        if (this.JCHReposicion.isSelected()) {
            this.xreposicion = 1;
        } else {
            this.xreposicion = 0;
        }
        if (this.JCHEstado.isSelected()) {
            this.xestado = 0;
        } else {
            this.xestado = 1;
        }
        if (this.JCHContabilizada.isSelected()) {
            this.xcontabilizada = 1;
        } else {
            this.xcontabilizada = 0;
        }
        if (this.JCHMResiduosPeligrosos.isSelected()) {
            this.xmresiduop = 1;
        } else {
            this.xmresiduop = 0;
        }
        if (this.JCHMControlTemp.isSelected()) {
            this.xmctrltemp = 1;
        } else {
            this.xmctrltemp = 0;
        }
        if (this.JCHEsUrgencias.isSelected()) {
            this.xesurgencia = 1;
        } else {
            this.xesurgencia = 0;
        }
    }
}
