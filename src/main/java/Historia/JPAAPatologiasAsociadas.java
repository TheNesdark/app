package Historia;

import Acceso.Principal;
import General.JIFBuscarPatologia;
import Odontologia.JIFHistoriaOdontologica;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPAAPatologiasAsociadas.class */
public class JPAAPatologiasAsociadas extends JPanel {
    private Metodos xmetodo;
    private ConsultasMySQL xconsultasbd;
    private clasesHistoriaCE xclase;
    private Object[] xdato;
    private DefaultTableModel xmodelo;
    private int xmod;
    public long xidusuario;
    private String xidatencion;
    private JIFHistoriaOdontologica xjifcho;
    private JButton JBTAdicionarPat;
    private JPanel JPIAntecendesClinicos;
    private JScrollPane JSPHistorial;
    public JTextField JTFFCodigoPat;
    public JTextField JTFFNombrePat;
    private JTable JTHistorial;

    public JPAAPatologiasAsociadas(clasesHistoriaCE xclase, int xmod) {
        this.xmetodo = new Metodos();
        this.xconsultasbd = new ConsultasMySQL();
        this.xmod = -1;
        initComponents();
        this.xmod = xmod;
        this.xclase = xclase;
        mNuevo();
    }

    public JPAAPatologiasAsociadas(JIFHistoriaOdontologica xjifcho, int xmod) {
        this.xmetodo = new Metodos();
        this.xconsultasbd = new ConsultasMySQL();
        this.xmod = -1;
        initComponents();
        this.xmod = xmod;
        this.xjifcho = xjifcho;
        mNuevo();
    }

    public JPAAPatologiasAsociadas(String xid_persona, String xid_Atencion) {
        this.xmetodo = new Metodos();
        this.xconsultasbd = new ConsultasMySQL();
        this.xmod = -1;
        initComponents();
        this.xidusuario = Long.valueOf(xid_persona).longValue();
        this.xidatencion = xid_Atencion;
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v33, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIAntecendesClinicos = new JPanel();
        this.JBTAdicionarPat = new JButton();
        this.JTFFCodigoPat = new JTextField();
        this.JTFFNombrePat = new JTextField();
        this.JSPHistorial = new JScrollPane();
        this.JTHistorial = new JTable();
        setName("patologiasasociadas");
        setPreferredSize(new Dimension(835, 350));
        this.JPIAntecendesClinicos.setBorder(BorderFactory.createTitledBorder((Border) null, "PATOLOGÍAS ASOCIADAS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPIAntecendesClinicos.setFont(new Font("Arial", 1, 14));
        this.JBTAdicionarPat.setFont(new Font("Arial", 1, 14));
        this.JBTAdicionarPat.setForeground(Color.red);
        this.JBTAdicionarPat.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionarPat.addActionListener(new ActionListener() { // from class: Historia.JPAAPatologiasAsociadas.1
            public void actionPerformed(ActionEvent evt) {
                JPAAPatologiasAsociadas.this.JBTAdicionarPatActionPerformed(evt);
            }
        });
        this.JBTAdicionarPat.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAPatologiasAsociadas.2
            public void keyPressed(KeyEvent evt) {
                JPAAPatologiasAsociadas.this.JBTAdicionarPatKeyPressed(evt);
            }
        });
        this.JTFFCodigoPat.setFont(new Font("Arial", 1, 12));
        this.JTFFCodigoPat.setBorder(BorderFactory.createTitledBorder((Border) null, "Código", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFCodigoPat.addFocusListener(new FocusAdapter() { // from class: Historia.JPAAPatologiasAsociadas.3
            public void focusLost(FocusEvent evt) {
                JPAAPatologiasAsociadas.this.JTFFCodigoPatFocusLost(evt);
            }
        });
        this.JTFFCodigoPat.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAPatologiasAsociadas.4
            public void keyPressed(KeyEvent evt) {
                JPAAPatologiasAsociadas.this.JTFFCodigoPatKeyPressed(evt);
            }
        });
        this.JTFFNombrePat.setFont(new Font("Arial", 1, 12));
        this.JTFFNombrePat.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre Patología", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNombrePat.addMouseListener(new MouseAdapter() { // from class: Historia.JPAAPatologiasAsociadas.5
            public void mouseClicked(MouseEvent evt) {
                JPAAPatologiasAsociadas.this.JTFFNombrePatMouseClicked(evt);
            }
        });
        this.JTFFNombrePat.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAPatologiasAsociadas.6
            public void keyPressed(KeyEvent evt) {
                JPAAPatologiasAsociadas.this.JTFFNombrePatKeyPressed(evt);
            }
        });
        GroupLayout JPIAntecendesClinicosLayout = new GroupLayout(this.JPIAntecendesClinicos);
        this.JPIAntecendesClinicos.setLayout(JPIAntecendesClinicosLayout);
        JPIAntecendesClinicosLayout.setHorizontalGroup(JPIAntecendesClinicosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAntecendesClinicosLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFFCodigoPat, -2, 75, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFNombrePat, -1, 621, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTAdicionarPat, -2, 71, -2).addContainerGap()));
        JPIAntecendesClinicosLayout.setVerticalGroup(JPIAntecendesClinicosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIAntecendesClinicosLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPIAntecendesClinicosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBTAdicionarPat, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JTFFCodigoPat, GroupLayout.Alignment.LEADING).addComponent(this.JTFFNombrePat, -2, 48, -2)).addContainerGap()));
        this.JSPHistorial.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORIAL", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTHistorial.setFont(new Font("Arial", 1, 12));
        this.JTHistorial.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTHistorial.setRowHeight(25);
        this.JTHistorial.setSelectionBackground(new Color(255, 255, 255));
        this.JTHistorial.setSelectionForeground(new Color(255, 0, 0));
        this.JTHistorial.setSelectionMode(0);
        this.JTHistorial.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAPatologiasAsociadas.7
            public void keyPressed(KeyEvent evt) {
                JPAAPatologiasAsociadas.this.JTHistorialKeyPressed(evt);
            }
        });
        this.JSPHistorial.setViewportView(this.JTHistorial);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPHistorial, GroupLayout.Alignment.LEADING, -1, 815, 32767).addComponent(this.JPIAntecendesClinicos, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIAntecendesClinicos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPHistorial, -1, 226, 32767).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarPatActionPerformed(ActionEvent evt) {
        mGrabarBd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarPatKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            mGrabarBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFCodigoPatFocusLost(FocusEvent evt) {
        bpatologia();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFNombrePatMouseClicked(MouseEvent evt) {
        JIFBuscarPatologia pac = new JIFBuscarPatologia(null, true, this.JTFFCodigoPat, this.JTFFNombrePat, "patologiasasociadas", 0);
        pac.setVisible(true);
        pac.setLocationRelativeTo(this);
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
                String sql = "update h_patologiaasociadas set Estado=0 where Id_Patologia='" + this.xmodelo.getValueAt(this.JTHistorial.getSelectedRow(), 0).toString() + "' AND Id_Atencion='" + this.xidatencion + "'";
                this.xconsultasbd.ejecutarSQL(sql);
                this.xconsultasbd.cerrarConexionBd();
                mCrearTabla();
                mBuscarDatosBd();
            }
        }
    }

    private void bpatologia() {
        if (this.JTFFCodigoPat.getText().length() != 0) {
            try {
                String sql = "SELECT Id, Nbre FROM  g_patologia where Id='" + this.JTFFCodigoPat.getText().toUpperCase() + "'";
                ResultSet res = this.xconsultasbd.traerRs(sql);
                res.next();
                if (res.getRow() != 0) {
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

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Cie10", "Patologia"}) { // from class: Historia.JPAAPatologiasAsociadas.8
            Class[] types = {String.class, String.class};
            boolean[] canEdit = {false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistorial.setModel(this.xmodelo);
        this.JTHistorial.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTHistorial.getColumnModel().getColumn(1).setPreferredWidth(650);
    }

    private void mBuscarDatosBd() {
        try {
            String sql = "SELECT  g_patologia.Id, g_patologia.Nbre FROM h_patologiaasociadas INNER JOIN g_patologia  ON (h_patologiaasociadas.Id_Patologia = g_patologia.Id) where h_patologiaasociadas.Id_Usuario='" + this.xidusuario + "' AND h_patologiaasociadas.Estado=1";
            ResultSet rs = this.xconsultasbd.traerRs(sql);
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(rs.getString(1), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
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
        if (!this.JTFFCodigoPat.getText().isEmpty()) {
            if (!this.JTFFNombrePat.getText().isEmpty()) {
                String sql = "insert ignore into h_patologiaasociadas(Id_Usuario, Id_Patologia, Id_Atencion, Fecha, UsuarioS) values( '" + this.xidusuario + "','" + this.JTFFCodigoPat.getText() + "','" + this.xidatencion + "','" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                this.xconsultasbd.ejecutarSQL(sql);
                this.xconsultasbd.cerrarConexionBd();
                this.JTFFCodigoPat.setText((String) null);
                this.JTFFNombrePat.setText((String) null);
                this.JTFFCodigoPat.requestFocus();
                mCrearTabla();
                mBuscarDatosBd();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "El nombre de la patologia \n no puede estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFNombrePat.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El codigo  no puede \n estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFFCodigoPat.requestFocus();
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
        mCrearTabla();
        mBuscarDatosBd();
    }
}
