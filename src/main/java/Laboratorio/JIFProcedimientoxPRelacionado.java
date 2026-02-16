package Laboratorio;

import Acceso.Principal;
import ParametrizacionN.JIFGenericoCh;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import Utilidades.TextAreaEditor;
import Utilidades.TextAreaRenderer;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/* JADX INFO: loaded from: GenomaP.jar:Laboratorio/JIFProcedimientoxPRelacionado.class */
public class JIFProcedimientoxPRelacionado extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String[] xidpprincipal;
    private String[] xidprelacionado;
    private String xnombre;
    private JComboBox JCBPPrincipal;
    private JComboBox JCBPRelacionado;
    private JCheckBox JCHEstado;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFCupP;
    private JTextField JTFCupR;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 1;
    private boolean xestadog = false;
    private boolean xlleno = false;

    public JIFProcedimientoxPRelacionado(String xnombre, String xtitulo) {
        initComponents();
        this.xnombre = xnombre;
        setTitle(xtitulo.toUpperCase());
        mIniciarComponentes();
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v38, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JCBPPrincipal = new JComboBox();
        this.JCBPRelacionado = new JComboBox();
        this.JCHEstado = new JCheckBox();
        this.JTFCupR = new JTextField();
        this.JTFCupP = new JTextField();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("PROCEDIMIENTO RELACIONADO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifprocedimientor");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: Laboratorio.JIFProcedimientoxPRelacionado.1
            public void internalFrameOpened(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
                JIFProcedimientoxPRelacionado.this.formInternalFrameClosed(evt);
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
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JCBPPrincipal.setFont(new Font("Arial", 1, 12));
        this.JCBPPrincipal.setBorder(BorderFactory.createTitledBorder((Border) null, "Procedimiento Principal", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBPPrincipal.addItemListener(new ItemListener() { // from class: Laboratorio.JIFProcedimientoxPRelacionado.2
            public void itemStateChanged(ItemEvent evt) {
                JIFProcedimientoxPRelacionado.this.JCBPPrincipalItemStateChanged(evt);
            }
        });
        this.JCBPRelacionado.setFont(new Font("Arial", 1, 12));
        this.JCBPRelacionado.setBorder(BorderFactory.createTitledBorder((Border) null, "Procedimiento Relacionado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBPRelacionado.addItemListener(new ItemListener() { // from class: Laboratorio.JIFProcedimientoxPRelacionado.3
            public void itemStateChanged(ItemEvent evt) {
                JIFProcedimientoxPRelacionado.this.JCBPRelacionadoItemStateChanged(evt);
            }
        });
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: Laboratorio.JIFProcedimientoxPRelacionado.4
            public void actionPerformed(ActionEvent evt) {
                JIFProcedimientoxPRelacionado.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JTFCupR.setFont(new Font("Arial", 1, 12));
        this.JTFCupR.setBorder(BorderFactory.createTitledBorder((Border) null, "CUP", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCupR.addFocusListener(new FocusAdapter() { // from class: Laboratorio.JIFProcedimientoxPRelacionado.5
            public void focusLost(FocusEvent evt) {
                JIFProcedimientoxPRelacionado.this.JTFCupRFocusLost(evt);
            }
        });
        this.JTFCupR.addKeyListener(new KeyAdapter() { // from class: Laboratorio.JIFProcedimientoxPRelacionado.6
            public void keyPressed(KeyEvent evt) {
                JIFProcedimientoxPRelacionado.this.JTFCupRKeyPressed(evt);
            }
        });
        this.JTFCupP.setFont(new Font("Arial", 1, 12));
        this.JTFCupP.setBorder(BorderFactory.createTitledBorder((Border) null, "CUP", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCupP.addFocusListener(new FocusAdapter() { // from class: Laboratorio.JIFProcedimientoxPRelacionado.7
            public void focusLost(FocusEvent evt) {
                JIFProcedimientoxPRelacionado.this.JTFCupPFocusLost(evt);
            }
        });
        this.JTFCupP.addKeyListener(new KeyAdapter() { // from class: Laboratorio.JIFProcedimientoxPRelacionado.8
            public void keyPressed(KeyEvent evt) {
                JIFProcedimientoxPRelacionado.this.JTFCupPKeyPressed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFCupP, -2, 118, -2).addComponent(this.JTFCupR, -2, 118, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JCBPPrincipal, -2, 725, -2).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCBPRelacionado, -2, 645, -2).addGap(18, 18, 18).addComponent(this.JCHEstado))).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBPPrincipal, -2, 50, -2).addComponent(this.JTFCupP, -2, 50, -2)).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEstado).addGap(39, 39, 39)).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBPRelacionado, -2, 52, -2).addComponent(this.JTFCupR, -2, 50, -2)).addContainerGap()))));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Laboratorio.JIFProcedimientoxPRelacionado.9
            public void mouseClicked(MouseEvent evt) {
                JIFProcedimientoxPRelacionado.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPIDatos, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addGap(41, 41, 41).addComponent(this.JSPDetalle, -1, 310, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            this.JCBPPrincipal.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JCBPRelacionado.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()).booleanValue());
            this.xestadog = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosed(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.xestado = 1;
        } else {
            this.xestado = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCupPFocusLost(FocusEvent evt) {
        if (this.xlleno && !this.JTFCupP.getText().isEmpty()) {
            verificarCodProcSum(this.JTFCupP, this.JCBPPrincipal, this.xidpprincipal);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCupRFocusLost(FocusEvent evt) {
        if (this.xlleno && !this.JTFCupR.getText().isEmpty()) {
            verificarCodProcSum(this.JTFCupR, this.JCBPRelacionado, this.xidprelacionado);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCupPKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10 && this.xlleno) {
            this.JCBPPrincipal.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCupRKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10 && this.xlleno) {
            this.JCBPRelacionado.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBPPrincipalItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBPPrincipal.getSelectedIndex() != -1) {
            this.JTFCupP.setText(this.xidpprincipal[this.JCBPPrincipal.getSelectedIndex()]);
            mCargarDatosTabla();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBPRelacionadoItemStateChanged(ItemEvent evt) {
        if (this.xlleno) {
            this.JTFCupR.setText(this.xidprelacionado[this.JCBPRelacionado.getSelectedIndex()]);
        }
    }

    public void mNuevo() {
        this.xlleno = false;
        this.xestadog = false;
        this.JTFCupP.setText("");
        this.JCBPPrincipal.setSelectedIndex(-1);
        this.JTFCupR.setText("");
        this.JCBPRelacionado.setSelectedIndex(-1);
        this.JCHEstado.setSelected(true);
        this.xestado = 1;
        this.JCBPPrincipal.requestFocus();
        mCargarDatosTabla();
        this.xlleno = true;
    }

    public void mGrabar() {
        if (this.JCBPPrincipal.getSelectedIndex() != -1) {
            if (this.JCBPRelacionado.getSelectedIndex() != -1) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    String sql = null;
                    if (!this.xestadog) {
                        if (this.xnombre.equals("jifprocedimientorelacionado")) {
                            sql = " Insert ignore into h_procedimientoxprelacionado(Id_Procedimiento, Id_ProcedimientoR, Estado, Fecha, UsuarioS)  values ('" + this.xidpprincipal[this.JCBPPrincipal.getSelectedIndex()] + "','" + this.xidprelacionado[this.JCBPRelacionado.getSelectedIndex()] + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        } else if (this.xnombre.equals("jifprocedimientounificado")) {
                            sql = " Insert ignore into l_codigoprouni(`Id_CodProcedUnif`,`Id_Procedimiento` , `Estado`, `Fecha`, `UsuarioS`)  values ('" + this.xidprelacionado[this.JCBPRelacionado.getSelectedIndex()] + "','" + this.xidpprincipal[this.JCBPPrincipal.getSelectedIndex()] + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        }
                    } else if (this.xnombre.equals("jifprocedimientorelacionado")) {
                        sql = "update h_procedimientoxprelacionado set  Estado='" + this.xestado + "', Fecha= '" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' where Id_Procedimiento='" + this.xidpprincipal[this.JCBPPrincipal.getSelectedIndex()] + "' and Id_ProcedimientoR='" + this.xidprelacionado[this.JCBPRelacionado.getSelectedIndex()] + "'";
                    } else if (this.xnombre.equals("jifprocedimientounificado")) {
                        sql = "update l_codigoprouni set  Estado='" + this.xestado + "', Fecha= '" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' where Id_CodProcedUnif='" + this.xidprelacionado[this.JCBPRelacionado.getSelectedIndex()] + "' and Id_Procedimiento='" + this.xidpprincipal[this.JCBPPrincipal.getSelectedIndex()] + "'";
                    }
                    this.xconsulta.ejecutarSQL(sql);
                    this.xconsulta.cerrarConexionBd();
                    mCargarDatosTabla();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar el item del combo 2", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBPRelacionado.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar el item del combo 1", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBPPrincipal.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos(String[] xcabecera) {
        this.xmodelo = new DefaultTableModel(new Object[0], xcabecera) { // from class: Laboratorio.JIFProcedimientoxPRelacionado.10
            Class[] types = {String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(5);
    }

    private void mCargarDatosTabla() {
        try {
            String sql = null;
            String[] xencabezado = null;
            if (this.xnombre.equals("jifprocedimientorelacionado")) {
                xencabezado = new String[]{"Procedimiento Principal", "Procedimiento Relacionado", "Estado"};
                if (this.JCBPPrincipal.getSelectedIndex() != -1) {
                    sql = "SELECT g_procedimiento.Nbre, v_procedimiento.Nbre, h_procedimientoxprelacionado.Estado FROM h_procedimientoxprelacionado \nINNER JOIN g_procedimiento ON (h_procedimientoxprelacionado.Id_Procedimiento = g_procedimiento.Id) INNER JOIN v_procedimiento  \nON (v_procedimiento.Id = h_procedimientoxprelacionado.Id_ProcedimientoR) \nWHERE g_procedimiento.Id=" + this.xidpprincipal[this.JCBPPrincipal.getSelectedIndex()] + "\nORDER BY g_procedimiento.Nbre ASC, v_procedimiento.Nbre ASC ";
                } else {
                    sql = "SELECT g_procedimiento.Nbre, v_procedimiento.Nbre, h_procedimientoxprelacionado.Estado FROM h_procedimientoxprelacionado \nINNER JOIN g_procedimiento ON (h_procedimientoxprelacionado.Id_Procedimiento = g_procedimiento.Id) INNER JOIN v_procedimiento  \nON (v_procedimiento.Id = h_procedimientoxprelacionado.Id_ProcedimientoR) ORDER BY g_procedimiento.Nbre ASC, v_procedimiento.Nbre ASC";
                }
            } else if (this.xnombre.equals("jifprocedimientounificado")) {
                xencabezado = new String[]{"Procedimiento Facturado", "Procedimiento a Visualizar", "Estado"};
                if (this.JCBPPrincipal.getSelectedIndex() != -1) {
                    sql = "SELECT\n\t`v_procedimiento`.`Nbre`,\n\t`g_procedimiento`.`Nbre`,\n\tl_codigoprouni.`Estado`\nFROM\n\t`l_codigoprouni`\nINNER JOIN `g_procedimiento` ON\n\t(`l_codigoprouni`.`Id_CodProcedUnif` = `g_procedimiento`.`Id`)\nINNER JOIN `v_procedimiento` ON\n\t(`l_codigoprouni`.`Id_Procedimiento` = `v_procedimiento`.`Id`)\nWHERE\n\tv_procedimiento.Id = " + this.xidpprincipal[this.JCBPPrincipal.getSelectedIndex()] + "\nORDER BY\n\t`g_procedimiento`.`Nbre` ASC";
                } else {
                    sql = "SELECT\n\t`v_procedimiento`.`Nbre`,\n\t`g_procedimiento`.`Nbre`,\n\tl_codigoprouni.`Estado`\nFROM\n\t`l_codigoprouni`\nINNER JOIN `g_procedimiento` ON\n\t(`l_codigoprouni`.`Id_CodProcedUnif` = `g_procedimiento`.`Id`)\nINNER JOIN `v_procedimiento` ON\n\t(`l_codigoprouni`.`Id_Procedimiento` = `v_procedimiento`.`Id`)\nORDER BY\n\t`g_procedimiento`.`Nbre` ASC";
                }
            }
            mCrearModeloDatos(xencabezado);
            ResultSet xrs = this.xconsulta.traerRs(sql);
            TableColumnModel cmodel = this.JTDetalle.getColumnModel();
            TextAreaRenderer textAreaRenderer = new TextAreaRenderer();
            cmodel.getColumn(0).setCellRenderer(textAreaRenderer);
            cmodel.getColumn(1).setCellRenderer(textAreaRenderer);
            TextAreaEditor textEditor = new TextAreaEditor();
            cmodel.getColumn(0).setCellEditor(textEditor);
            cmodel.getColumn(1).setCellEditor(textEditor);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(3)), n, 2);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGenericoCh.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mIniciarComponentes() {
        this.xlleno = false;
        this.JCBPPrincipal.removeAllItems();
        this.JCBPRelacionado.removeAllItems();
        if (this.xnombre.equals("jifprocedimientorelacionado")) {
            this.xidpprincipal = this.xconsulta.llenarCombo("SELECT Id, Nbre, Id_tipoprocedimiento FROM g_procedimiento WHERE (Id_tipoprocedimiento =6 AND Estado =0) ORDER BY Nbre ASC", this.xidpprincipal, this.JCBPPrincipal);
            this.JCBPPrincipal.setSelectedIndex(-1);
            this.xconsulta.cerrarConexionBd();
            this.xidprelacionado = this.xconsulta.llenarCombo("SELECT Id, Nbre, Id_tipoprocedimiento FROM g_procedimiento WHERE (Id_tipoprocedimiento =6 AND Estado =0) ORDER BY Nbre ASC", this.xidprelacionado, this.JCBPRelacionado);
            this.JCBPRelacionado.setSelectedIndex(-1);
            this.xconsulta.cerrarConexionBd();
        } else {
            this.JCBPPrincipal.setBorder(BorderFactory.createTitledBorder((Border) null, "Procedimiento Facturado", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.xidpprincipal = this.xconsulta.llenarCombo("SELECT `Id` , `Nbre` FROM `g_procedimiento` WHERE (`Estado` =0) ORDER BY Nbre", this.xidpprincipal, this.JCBPPrincipal);
            this.JCBPPrincipal.setSelectedIndex(-1);
            this.xconsulta.cerrarConexionBd();
            this.JCBPRelacionado.setBorder(BorderFactory.createTitledBorder((Border) null, "Procedimiento A Visualizar", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.xidprelacionado = this.xconsulta.llenarCombo("SELECT `Id` , `Nbre` FROM `g_procedimiento` WHERE (`Estado` =0) ORDER BY Nbre;", this.xidprelacionado, this.JCBPRelacionado);
            this.JCBPRelacionado.setSelectedIndex(-1);
            this.xconsulta.cerrarConexionBd();
        }
        this.xlleno = true;
    }

    public void verificarCodProcSum(JTextField CUP, JComboBox JCBProcedimiento, String[] idProcedimiento) {
        String Procedimiento = getTraerCodigo(CUP.getText());
        if (Procedimiento.equals("")) {
            this.xmetodos.mostrarMensaje("Codigo Incorrecto:\n1.El Codigo No Se Encuentra Relacionado A Este Servicio\n2.El Codigo No Existe\n3.El Codigo De Este Procedimiento Se Encuentre Desactivado");
            JCBProcedimiento.setSelectedIndex(-1);
            JCBProcedimiento.requestFocus();
            CUP.setText("");
            return;
        }
        JCBProcedimiento.setSelectedItem(Procedimiento);
    }

    private String getTraerCodigo(String id) {
        String procedimiento = "";
        if (!id.isEmpty()) {
            String sql = "SELECT Nbre FROM g_procedimiento WHERE (Id_tipoprocedimiento =6 AND Estado =0 AND Id=" + id + ") ORDER BY Nbre ASC";
            procedimiento = this.xconsulta.traerDato(sql);
            this.xconsulta.cerrarConexionBd();
        }
        return procedimiento;
    }
}
