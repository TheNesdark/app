package Historia;

import Acceso.Principal;
import General.JIFBuscarPatologia;
import Odontologia.JIFHistoriaOdontologica;
import Odontologia.claseOdonto;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPAAntecentesFamiliares.class */
public class JPAAntecentesFamiliares extends JPanel {
    private Metodos xmetodo;
    private ConsultasMySQL xconsultasbd;
    private clasesHistoriaCE xclase;
    private JIFHistoriaOdontologica xjifcho;
    private claseOdonto xclaseo2;
    private Object[] xdato;
    private String[] xidparentesco;
    private int xvive;
    private int xmod;
    private DefaultTableModel xmodelo;
    public long xidusuario;
    private String xidatencion;
    private ButtonGroup JBGVive;
    private JButton JBTAdicionarAntCli;
    public JComboBox JCBTipoParentesco;
    private JPanel JPIAntecendesClinicos;
    private JPanel JPIVive;
    private JRadioButton JRBVNo;
    private JRadioButton JRBVSi;
    private JScrollPane JSPHistorial;
    private JScrollPane JSPObservacionesAntecedentes;
    public JTextField JTFFCodigoPat;
    public JTextField JTFFNombrePat;
    private JTable JTHistorial;
    private JTextPane JTPObservacionesAntecedentes;

    public JPAAntecentesFamiliares(clasesHistoriaCE xclase, int xmod) {
        this.xmetodo = new Metodos();
        this.xconsultasbd = new ConsultasMySQL();
        this.xvive = 1;
        this.xmod = -1;
        initComponents();
        this.xmod = xmod;
        this.xclase = xclase;
        mNuevo();
    }

    public JPAAntecentesFamiliares(JIFHistoriaOdontologica xjifcho, int xmod) {
        this.xmetodo = new Metodos();
        this.xconsultasbd = new ConsultasMySQL();
        this.xvive = 1;
        this.xmod = -1;
        this.xmod = xmod;
        this.xjifcho = xjifcho;
        initComponents();
        mNuevo();
    }

    public JPAAntecentesFamiliares(String xid_persona, String xid_Atencion) {
        this.xmetodo = new Metodos();
        this.xconsultasbd = new ConsultasMySQL();
        this.xvive = 1;
        this.xmod = -1;
        initComponents();
        this.xidusuario = Long.valueOf(xid_persona).longValue();
        this.xidatencion = xid_Atencion;
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v61, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGVive = new ButtonGroup();
        this.JPIAntecendesClinicos = new JPanel();
        this.JCBTipoParentesco = new JComboBox();
        this.JSPObservacionesAntecedentes = new JScrollPane();
        this.JTPObservacionesAntecedentes = new JTextPane();
        this.JBTAdicionarAntCli = new JButton();
        this.JTFFCodigoPat = new JTextField();
        this.JTFFNombrePat = new JTextField();
        this.JPIVive = new JPanel();
        this.JRBVSi = new JRadioButton();
        this.JRBVNo = new JRadioButton();
        this.JSPHistorial = new JScrollPane();
        this.JTHistorial = new JTable();
        setName("jifantecfamiliares");
        this.JPIAntecendesClinicos.setBorder(BorderFactory.createTitledBorder((Border) null, "ANTECEDENTES FAMILIARES", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBTipoParentesco.setFont(new Font("Arial", 1, 12));
        this.JCBTipoParentesco.setBorder(BorderFactory.createTitledBorder((Border) null, "Parentesco", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoParentesco.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAntecentesFamiliares.1
            public void keyPressed(KeyEvent evt) {
                JPAAntecentesFamiliares.this.JCBTipoParentescoKeyPressed(evt);
            }
        });
        this.JSPObservacionesAntecedentes.setBorder(BorderFactory.createTitledBorder((Border) null, "Breve Descripción del Antecedente", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPObservacionesAntecedentes.setFont(new Font("Arial", 1, 12));
        this.JTPObservacionesAntecedentes.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAntecentesFamiliares.2
            public void keyPressed(KeyEvent evt) {
                JPAAntecentesFamiliares.this.JTPObservacionesAntecedentesKeyPressed(evt);
            }
        });
        this.JSPObservacionesAntecedentes.setViewportView(this.JTPObservacionesAntecedentes);
        this.JBTAdicionarAntCli.setFont(new Font("Arial", 1, 14));
        this.JBTAdicionarAntCli.setForeground(Color.red);
        this.JBTAdicionarAntCli.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionarAntCli.addActionListener(new ActionListener() { // from class: Historia.JPAAntecentesFamiliares.3
            public void actionPerformed(ActionEvent evt) {
                JPAAntecentesFamiliares.this.JBTAdicionarAntCliActionPerformed(evt);
            }
        });
        this.JBTAdicionarAntCli.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAntecentesFamiliares.4
            public void keyPressed(KeyEvent evt) {
                JPAAntecentesFamiliares.this.JBTAdicionarAntCliKeyPressed(evt);
            }
        });
        this.JTFFCodigoPat.setFont(new Font("Arial", 1, 12));
        this.JTFFCodigoPat.setBorder(BorderFactory.createTitledBorder((Border) null, "CIE10", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFCodigoPat.addFocusListener(new FocusAdapter() { // from class: Historia.JPAAntecentesFamiliares.5
            public void focusLost(FocusEvent evt) {
                JPAAntecentesFamiliares.this.JTFFCodigoPatFocusLost(evt);
            }
        });
        this.JTFFCodigoPat.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAntecentesFamiliares.6
            public void keyPressed(KeyEvent evt) {
                JPAAntecentesFamiliares.this.JTFFCodigoPatKeyPressed(evt);
            }
        });
        this.JTFFNombrePat.setFont(new Font("Arial", 1, 12));
        this.JTFFNombrePat.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre Patología", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNombrePat.addMouseListener(new MouseAdapter() { // from class: Historia.JPAAntecentesFamiliares.7
            public void mouseClicked(MouseEvent evt) {
                JPAAntecentesFamiliares.this.JTFFNombrePatMouseClicked(evt);
            }
        });
        this.JTFFNombrePat.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAntecentesFamiliares.8
            public void keyPressed(KeyEvent evt) {
                JPAAntecentesFamiliares.this.JTFFNombrePatKeyPressed(evt);
            }
        });
        this.JPIVive.setBorder(BorderFactory.createTitledBorder((Border) null, "VIVE", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JBGVive.add(this.JRBVSi);
        this.JRBVSi.setFont(new Font("Arial", 1, 12));
        this.JRBVSi.setForeground(Color.blue);
        this.JRBVSi.setSelected(true);
        this.JRBVSi.setText("Si");
        this.JRBVSi.addActionListener(new ActionListener() { // from class: Historia.JPAAntecentesFamiliares.9
            public void actionPerformed(ActionEvent evt) {
                JPAAntecentesFamiliares.this.JRBVSiActionPerformed(evt);
            }
        });
        this.JRBVSi.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAntecentesFamiliares.10
            public void keyPressed(KeyEvent evt) {
                JPAAntecentesFamiliares.this.JRBVSiKeyPressed(evt);
            }
        });
        this.JBGVive.add(this.JRBVNo);
        this.JRBVNo.setFont(new Font("Arial", 1, 12));
        this.JRBVNo.setForeground(Color.blue);
        this.JRBVNo.setText("No");
        this.JRBVNo.addActionListener(new ActionListener() { // from class: Historia.JPAAntecentesFamiliares.11
            public void actionPerformed(ActionEvent evt) {
                JPAAntecentesFamiliares.this.JRBVNoActionPerformed(evt);
            }
        });
        this.JRBVNo.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAntecentesFamiliares.12
            public void keyPressed(KeyEvent evt) {
                JPAAntecentesFamiliares.this.JRBVNoKeyPressed(evt);
            }
        });
        GroupLayout JPIViveLayout = new GroupLayout(this.JPIVive);
        this.JPIVive.setLayout(JPIViveLayout);
        JPIViveLayout.setHorizontalGroup(JPIViveLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIViveLayout.createSequentialGroup().addGap(4, 4, 4).addComponent(this.JRBVSi).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBVNo).addContainerGap(16, 32767)));
        JPIViveLayout.setVerticalGroup(JPIViveLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIViveLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBVNo).addComponent(this.JRBVSi)));
        GroupLayout JPIAntecendesClinicosLayout = new GroupLayout(this.JPIAntecendesClinicos);
        this.JPIAntecendesClinicos.setLayout(JPIAntecendesClinicosLayout);
        JPIAntecendesClinicosLayout.setHorizontalGroup(JPIAntecendesClinicosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAntecendesClinicosLayout.createSequentialGroup().addContainerGap().addGroup(JPIAntecendesClinicosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAntecendesClinicosLayout.createSequentialGroup().addComponent(this.JCBTipoParentesco, -2, 292, -2).addGap(18, 18, 18).addComponent(this.JPIVive, -2, -1, -2).addGap(17, 17, 17).addComponent(this.JSPObservacionesAntecedentes, -1, 336, 32767)).addGroup(GroupLayout.Alignment.TRAILING, JPIAntecendesClinicosLayout.createSequentialGroup().addComponent(this.JTFFCodigoPat, -1, 78, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFNombrePat, -2, 695, -2)).addComponent(this.JBTAdicionarAntCli, -1, 779, 32767)).addContainerGap()));
        JPIAntecendesClinicosLayout.setVerticalGroup(JPIAntecendesClinicosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAntecendesClinicosLayout.createSequentialGroup().addGroup(JPIAntecendesClinicosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JSPObservacionesAntecedentes).addComponent(this.JPIVive, GroupLayout.Alignment.LEADING, 0, -1, 32767).addComponent(this.JCBTipoParentesco, GroupLayout.Alignment.LEADING)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIAntecendesClinicosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFCodigoPat, -2, 50, -2).addComponent(this.JTFFNombrePat, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTAdicionarAntCli, -2, 43, -2).addContainerGap()));
        this.JSPHistorial.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORIAL", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTHistorial.setFont(new Font("Arial", 1, 12));
        this.JTHistorial.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTHistorial.setRowHeight(25);
        this.JTHistorial.setSelectionBackground(new Color(255, 255, 255));
        this.JTHistorial.setSelectionForeground(new Color(255, 0, 0));
        this.JTHistorial.setSelectionMode(0);
        this.JTHistorial.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAntecentesFamiliares.13
            public void keyPressed(KeyEvent evt) {
                JPAAntecentesFamiliares.this.JTHistorialKeyPressed(evt);
            }
        });
        this.JSPHistorial.setViewportView(this.JTHistorial);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPHistorial, GroupLayout.Alignment.LEADING, -1, 815, 32767).addComponent(this.JPIAntecendesClinicos, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIAntecendesClinicos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPHistorial, -2, 137, -2).addContainerGap(16, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarAntCliActionPerformed(ActionEvent evt) {
        mGrabarBd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBVNoActionPerformed(ActionEvent evt) {
        this.xvive = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBVSiActionPerformed(ActionEvent evt) {
        this.xvive = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPObservacionesAntecedentesKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9) {
            this.JTPObservacionesAntecedentes.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarAntCliKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            mGrabarBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFNombrePatMouseClicked(MouseEvent evt) {
        JIFBuscarPatologia pac = new JIFBuscarPatologia(null, true, this.JTFFCodigoPat, this.JTFFNombrePat, "antecedentesFamiliares", 0);
        pac.setVisible(true);
        pac.setLocationRelativeTo(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFCodigoPatFocusLost(FocusEvent evt) {
        bpatologia();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoParentescoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JCBTipoParentesco.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBVSiKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JRBVSi.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBVNoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JRBVNo.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFCodigoPatKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            bpatologia();
            this.JTFFCodigoPat.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFNombrePatKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFFNombrePat.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistorialKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127 && this.JTHistorial.getRowCount() != 0 && this.JTHistorial.getSelectedRow() != -1) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMACION", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                String sql = "update `h_antecedentefamiliar` set `Estado` = '0' where `Id_Usuario` = '" + this.xidusuario + "' and `Id_TipoParAntec` = '" + this.xmodelo.getValueAt(this.JTHistorial.getSelectedRow(), 0).toString() + "' and `CIE10` = '" + this.xmodelo.getValueAt(this.JTHistorial.getSelectedRow(), 3).toString() + "'";
                this.xconsultasbd.ejecutarSQL(sql);
                this.xconsultasbd.cerrarConexionBd();
                mCrearTabla();
                mBuscarDatosBd();
            }
        }
    }

    private void bpatologia() {
        if (!this.JTFFCodigoPat.getText().isEmpty()) {
            try {
                String sql = "SELECT Id, Nbre FROM g_patologia where Id='" + this.JTFFCodigoPat.getText().toUpperCase() + "'";
                ResultSet res = this.xconsultasbd.traerRs(sql);
                if (res.next()) {
                    this.JTFFNombrePat.setText(res.getString(2));
                    this.JTFFCodigoPat.setText(this.JTFFCodigoPat.getText().toUpperCase());
                } else {
                    JOptionPane.showMessageDialog(this, "Codigo no existe", "BUSCAR PATOLOGIA", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTFFNombrePat.setText((String) null);
                    this.JTFFCodigoPat.setText((String) null);
                    this.JTFFCodigoPat.requestFocus();
                }
                res.close();
                this.xconsultasbd.cerrarConexionBd();
            } catch (SQLException e) {
            }
        }
    }

    public void mNuevo() {
        this.JCBTipoParentesco.removeAllItems();
        this.xidparentesco = this.xconsultasbd.llenarCombo("SELECT Id, Nbre FROM h_tipoparantec WHERE (Estado =0) ORDER BY Nbre ASC", this.xidparentesco, this.JCBTipoParentesco);
        this.JCBTipoParentesco.setSelectedIndex(-1);
        if (this.xmod == 0) {
            this.xidusuario = clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido().longValue();
            this.xidatencion = clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion();
        } else if (this.xmod == 1) {
            if (this.xjifcho.xjppersona.getIdPersona().equals("0")) {
                this.xidusuario = Long.valueOf(this.xjifcho.xjppersona.getIdPersona()).longValue();
            }
            this.xidatencion = "0";
        }
        mCrearTabla();
        mBuscarDatosBd();
        this.JCBTipoParentesco.requestFocus();
        this.xconsultasbd.cerrarConexionBd();
    }

    public void mGrabarBd() {
        if (this.JCBTipoParentesco.getSelectedIndex() != -1) {
            if (this.JTFFCodigoPat.getText().length() != 0) {
                if (this.JTFFNombrePat.getText().length() != 0) {
                    String sql = "Insert ignore into h_antecedentefamiliar(Id_Usuario, Id_Atencion, Id_TipoParAntec, Vive, CIE10, Descripcion, Fecha, UsuarioS) values ('" + this.xidusuario + "','" + this.xidatencion + "','" + this.xidparentesco[this.JCBTipoParentesco.getSelectedIndex()] + "','" + this.xvive + "','" + this.JTFFCodigoPat.getText() + "','" + this.JTPObservacionesAntecedentes.getText() + "','" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    this.xconsultasbd.ejecutarSQL(sql);
                    this.xconsultasbd.cerrarConexionBd();
                    this.JCBTipoParentesco.setSelectedIndex(-1);
                    this.JRBVSi.setSelected(true);
                    this.JTPObservacionesAntecedentes.setText((String) null);
                    this.JTFFCodigoPat.setText((String) null);
                    this.JTFFNombrePat.setText((String) null);
                    mCrearTabla();
                    mBuscarDatosBd();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "El nombre de la patologia \n no puede estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFFNombrePat.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "El codigo \n no puede estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFCodigoPat.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar \n un tipo parentesco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBTipoParentesco.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Parentesco", "Vive?", "Cie10", "Patologia", "Descripcion"}) { // from class: Historia.JPAAntecentesFamiliares.14
            Class[] types = {Integer.class, String.class, Boolean.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, true, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistorial.setModel(this.xmodelo);
        this.JTHistorial.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTHistorial.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTHistorial.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTHistorial.getColumnModel().getColumn(1).setPreferredWidth(30);
        this.JTHistorial.getColumnModel().getColumn(2).setPreferredWidth(10);
        TableColumn sportColumn = this.JTHistorial.getColumnModel().getColumn(2);
        JCheckBox jch = new JCheckBox();
        sportColumn.setCellEditor(new DefaultCellEditor(jch));
        this.JTHistorial.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTHistorial.getColumnModel().getColumn(4).setPreferredWidth(300);
        this.JTHistorial.getColumnModel().getColumn(5).setPreferredWidth(100);
    }

    private void mBuscarDatosBd() {
        try {
            String sql = "SELECT h_tipoparantec.Id, h_tipoparantec.Nbre, h_antecedentefamiliar.Vive, g_patologia.Id, g_patologia.Nbre, h_antecedentefamiliar.Descripcion FROM h_antecedentefamiliar INNER JOIN h_tipoparantec  ON (h_antecedentefamiliar.Id_TipoParAntec = h_tipoparantec.Id) INNER JOIN g_patologia  ON (h_antecedentefamiliar.CIE10 = g_patologia.Id) where h_antecedentefamiliar.Id_Usuario='" + this.xidusuario + "' AND h_antecedentefamiliar.`Estado`=1";
            ResultSet rs = this.xconsultasbd.traerRs(sql);
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(rs.getString(1), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    if (rs.getInt(3) == 0) {
                        this.xmodelo.setValueAt(false, x, 2);
                    } else {
                        this.xmodelo.setValueAt(true, x, 2);
                    }
                    this.xmodelo.setValueAt(rs.getString(4), x, 3);
                    this.xmodelo.setValueAt(rs.getString(5), x, 4);
                    this.xmodelo.setValueAt(rs.getString(6), x, 5);
                    x++;
                }
            }
            rs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAAntecentesFamiliares.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
