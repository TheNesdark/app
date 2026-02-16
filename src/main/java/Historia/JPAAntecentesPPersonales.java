package Historia;

import Acceso.Principal;
import Odontologia.JIFHistoriaOdontologica;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPAAntecentesPPersonales.class */
public class JPAAntecentesPPersonales extends JPanel {
    private String[] xidtipoPPersonales;
    private String[][] xidtipoPPersonales2;
    private DefaultTableModel xmodelo;
    private Metodos xmetodo;
    private ConsultasMySQL xconsultasbd;
    private clasesHistoriaCE xclase;
    private Object[] xdato;
    private int xmod;
    public long xidusuario;
    private String xidatencion;
    private JIFHistoriaOdontologica xjifcho;
    private ButtonGroup JBGVive;
    private JButton JBTAdicionarAntCli;
    public JComboBox JCBTipoPPersonales;
    private JPanel JPIAntecendesClinicos;
    private JScrollPane JSPHistorial;
    private JScrollPane JSPObservacionesAntecedentes;
    private JTable JTHistorial;
    private JTextPane JTPObservacionesAntecedentes;

    public JPAAntecentesPPersonales(clasesHistoriaCE xclase, int xmod) {
        this.xmetodo = new Metodos();
        this.xconsultasbd = new ConsultasMySQL();
        this.xmod = -1;
        initComponents();
        this.xmod = xmod;
        this.xclase = xclase;
        mNuevo();
    }

    public JPAAntecentesPPersonales(JIFHistoriaOdontologica xjifcho, int xmod) {
        this.xmetodo = new Metodos();
        this.xconsultasbd = new ConsultasMySQL();
        this.xmod = -1;
        initComponents();
        this.xmod = xmod;
        this.xjifcho = xjifcho;
        mNuevo();
    }

    public JPAAntecentesPPersonales(String xid_persona, String xid_Atencion) {
        this.xmetodo = new Metodos();
        this.xconsultasbd = new ConsultasMySQL();
        this.xmod = -1;
        initComponents();
        this.xidusuario = Long.valueOf(xid_persona).longValue();
        this.xidatencion = xid_Atencion;
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v30, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGVive = new ButtonGroup();
        this.JPIAntecendesClinicos = new JPanel();
        this.JCBTipoPPersonales = new JComboBox();
        this.JSPObservacionesAntecedentes = new JScrollPane();
        this.JTPObservacionesAntecedentes = new JTextPane();
        this.JBTAdicionarAntCli = new JButton();
        this.JSPHistorial = new JScrollPane();
        this.JTHistorial = new JTable();
        setName("jpaantecedetesppersonales");
        setPreferredSize(new Dimension(835, 386));
        this.JPIAntecendesClinicos.setBorder(BorderFactory.createTitledBorder((Border) null, "PATOLÓGICOS PERSONALES", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBTipoPPersonales.setFont(new Font("Arial", 1, 12));
        this.JCBTipoPPersonales.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoPPersonales.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAntecentesPPersonales.1
            public void keyPressed(KeyEvent evt) {
                JPAAntecentesPPersonales.this.JCBTipoPPersonalesKeyPressed(evt);
            }
        });
        this.JSPObservacionesAntecedentes.setBorder(BorderFactory.createTitledBorder((Border) null, "Breve Descripción del Antecedente", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPObservacionesAntecedentes.setFont(new Font("Arial", 1, 12));
        this.JTPObservacionesAntecedentes.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAntecentesPPersonales.2
            public void keyPressed(KeyEvent evt) {
                JPAAntecentesPPersonales.this.JTPObservacionesAntecedentesKeyPressed(evt);
            }
        });
        this.JSPObservacionesAntecedentes.setViewportView(this.JTPObservacionesAntecedentes);
        this.JBTAdicionarAntCli.setFont(new Font("Arial", 1, 14));
        this.JBTAdicionarAntCli.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionarAntCli.addActionListener(new ActionListener() { // from class: Historia.JPAAntecentesPPersonales.3
            public void actionPerformed(ActionEvent evt) {
                JPAAntecentesPPersonales.this.JBTAdicionarAntCliActionPerformed(evt);
            }
        });
        this.JBTAdicionarAntCli.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAntecentesPPersonales.4
            public void keyPressed(KeyEvent evt) {
                JPAAntecentesPPersonales.this.JBTAdicionarAntCliKeyPressed(evt);
            }
        });
        GroupLayout JPIAntecendesClinicosLayout = new GroupLayout(this.JPIAntecendesClinicos);
        this.JPIAntecendesClinicos.setLayout(JPIAntecendesClinicosLayout);
        JPIAntecendesClinicosLayout.setHorizontalGroup(JPIAntecendesClinicosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIAntecendesClinicosLayout.createSequentialGroup().addContainerGap().addGroup(JPIAntecendesClinicosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBTAdicionarAntCli, -1, 783, 32767).addGroup(JPIAntecendesClinicosLayout.createSequentialGroup().addComponent(this.JCBTipoPPersonales, -2, 292, -2).addGap(18, 18, 18).addComponent(this.JSPObservacionesAntecedentes))).addContainerGap()));
        JPIAntecendesClinicosLayout.setVerticalGroup(JPIAntecendesClinicosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAntecendesClinicosLayout.createSequentialGroup().addGap(7, 7, 7).addGroup(JPIAntecendesClinicosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCBTipoPPersonales, -2, 50, -2).addComponent(this.JSPObservacionesAntecedentes, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTAdicionarAntCli, -2, 43, -2).addContainerGap()));
        this.JSPHistorial.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTHistorial.setFont(new Font("Arial", 1, 12));
        this.JTHistorial.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTHistorial.setRowHeight(25);
        this.JTHistorial.setSelectionBackground(new Color(255, 255, 255));
        this.JTHistorial.setSelectionForeground(new Color(255, 0, 0));
        this.JTHistorial.setSelectionMode(0);
        this.JTHistorial.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAntecentesPPersonales.5
            public void keyPressed(KeyEvent evt) {
                JPAAntecentesPPersonales.this.JTHistorialKeyPressed(evt);
            }
        });
        this.JSPHistorial.setViewportView(this.JTHistorial);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPHistorial, GroupLayout.Alignment.TRAILING, -1, 815, 32767).addComponent(this.JPIAntecendesClinicos, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIAntecendesClinicos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPHistorial, -2, 202, -2).addContainerGap(29, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarAntCliActionPerformed(ActionEvent evt) {
        mGrabarBd();
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
    public void JCBTipoPPersonalesKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JCBTipoPPersonales.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistorialKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127 && this.JTHistorial.getRowCount() != 0 && this.JTHistorial.getSelectedRow() != -1) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMACION", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                String sql = "update h_antecedentepatologico set Estado=0 where Id='" + this.xmodelo.getValueAt(this.JTHistorial.getSelectedRow(), 0).toString() + "' ";
                this.xconsultasbd.ejecutarSQL(sql);
                this.xconsultasbd.cerrarConexionBd();
                String sql2 = "update g_usuarioxtipoalerta set Estado=0 where Id_Antecedente='" + this.xmodelo.getValueAt(this.JTHistorial.getSelectedRow(), 0).toString() + "' ";
                this.xconsultasbd.ejecutarSQL(sql2);
                this.xconsultasbd.cerrarConexionBd();
                mNuevo();
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Tipo Antecedente", "Observación"}) { // from class: Historia.JPAAntecentesPPersonales.6
            Class[] types = {Integer.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false};

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
        this.JTHistorial.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTHistorial.getColumnModel().getColumn(2).setPreferredWidth(100);
    }

    private void mBuscarDatosBd() {
        try {
            String sql = "SELECT h_antecedentepatologico.Id, h_tipoantecpatologico.Nbre, h_antecedentepatologico.Observacion FROM h_antecedentepatologico INNER JOIN h_tipoantecpatologico  ON (h_antecedentepatologico.Id_tipoantecpatologico = h_tipoantecpatologico.Id)  where h_antecedentepatologico.Id_Usuario='" + this.xidusuario + "' AND h_antecedentepatologico.Estado=1 ORDER BY h_tipoantecpatologico.Nbre ASC";
            ResultSet rs = this.xconsultasbd.traerRs(sql);
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                this.xmetodo.mEstablecerTextEditor(this.JTHistorial, 2);
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(rs.getString(1), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo.setValueAt(rs.getString(3), x, 2);
                    x++;
                }
            }
            rs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAAntecentesFamiliares.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mGrabarBd() {
        if (this.JCBTipoPPersonales.getSelectedIndex() != -1) {
            if (!this.JTPObservacionesAntecedentes.getText().isEmpty()) {
                ConsultasMySQL xct1 = new ConsultasMySQL();
                String sql = "insert into h_antecedentepatologico(Id_Usuario, Id_tipoantecpatologico, Id_Atencion, Observacion, Fecha, UsuarioS) values( '" + this.xidusuario + "','" + this.xidtipoPPersonales2[this.JCBTipoPPersonales.getSelectedIndex()][0] + "','" + this.xidatencion + "','" + this.JTPObservacionesAntecedentes.getText() + "','" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                String xId_Antecedente = xct1.ejecutarSQLId(sql);
                if (this.xidtipoPPersonales2[this.JCBTipoPPersonales.getSelectedIndex()][1].equals("1")) {
                    int n = JOptionPane.showInternalConfirmDialog(this, "Desea Matricular la Alergia", "VERIFICAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        mMatricularAlergia(xId_Antecedente);
                    }
                }
                xct1.cerrarConexionBd();
                this.JCBTipoPPersonales.setSelectedIndex(-1);
                this.JTPObservacionesAntecedentes.setText((String) null);
                this.JCBTipoPPersonales.requestFocus();
                this.xconsultasbd.cerrarConexionBd();
                mNuevo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "La descripcion \n no puede estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTPObservacionesAntecedentes.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar \n un tipo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBTipoPPersonales.requestFocus();
    }

    private void mMatricularAlergia(String xIdAntecedente) {
        if (this.xidtipoPPersonales2[this.JCBTipoPPersonales.getSelectedIndex()][1].equals("1")) {
            try {
                String sql = "SELECT `Id_Usuario` , `Id_TipoAlerta` FROM `g_usuarioxtipoalerta` WHERE (Id_Usuario='" + this.xidusuario + "' AND Id_TipoAlerta='" + this.xidtipoPPersonales2[this.JCBTipoPPersonales.getSelectedIndex()][2] + "' and Estado=1)";
                ResultSet rs2 = this.xconsultasbd.traerRs(sql);
                ConsultasMySQL xct2 = new ConsultasMySQL();
                ConsultasMySQL xct3 = new ConsultasMySQL();
                if (!rs2.next()) {
                    String sql2 = "INSERT INTO g_usuarioxtipoalerta(`Id_Usuario`, `Id_TipoAlerta` , `Detalle`, `FechaFin`,`Fecha`,Id_Antecedente, `UsuarioS`)values( '" + this.xidusuario + "','" + this.xidtipoPPersonales2[this.JCBTipoPPersonales.getSelectedIndex()][2] + "','" + this.JTPObservacionesAntecedentes.getText() + "','" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "','" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "','" + xIdAntecedente + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    xct2.ejecutarSQL(sql2);
                    xct2.cerrarConexionBd();
                }
                rs2.close();
                xct3.ejecutarSQL(sql);
                xct3.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JPAAntecentesPPersonales.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    public void mNuevo() {
        if (this.xmod == 0) {
            this.xidusuario = clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido().longValue();
            this.xidatencion = clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion();
        } else if (this.xmod == 1) {
            if (!this.xjifcho.xjppersona.getIdPersona().equals("0")) {
                this.xidusuario = Long.valueOf(this.xjifcho.xjppersona.getIdPersona()).longValue();
            }
            this.xidatencion = "0";
        }
        this.JCBTipoPPersonales.removeAllItems();
        this.xidtipoPPersonales2 = this.xconsultasbd.llenarComboyLista("SELECT `Id` , `Nbre`, `Alerta`  , `Id_TipoAlerta` FROM `h_tipoantecpatologico` WHERE (`Estado` =0) ORDER BY Nbre ASC", this.xidtipoPPersonales2, this.JCBTipoPPersonales, 4);
        this.JCBTipoPPersonales.setSelectedIndex(-1);
        this.xconsultasbd.cerrarConexionBd();
        this.JTPObservacionesAntecedentes.setText("");
        mCrearTabla();
        mBuscarDatosBd();
        this.JCBTipoPPersonales.requestFocus();
    }
}
