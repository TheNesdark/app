package Historia;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import Utilidades.corrector.jortho.FileUserDictionary;
import Utilidades.corrector.jortho.SpellChecker;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPARevisionSistemas.class */
public class JPARevisionSistemas extends JPanel {
    private String xnombrehallazgo;
    private clasesHistoriaCE xclase;
    private int xgr;
    private ButtonGroup JBGEstado;
    private JButton JBTGuardar;
    private JPanel JPHRevisionSistemas;
    private JPanel JPIREstado;
    public JRadioButton JRBEstadoAnormal;
    private JRadioButton JRBEstadoNormal;
    private JScrollPane JSPObservacionRevisionSistemas;
    private JTextPane JTPHObservacionRevisionSistemas;
    private Metodos xmetodo = new Metodos();
    private int xestado = 0;

    public JPARevisionSistemas(String nombre, clasesHistoriaCE xclase) {
        this.xgr = 0;
        initComponents();
        SpellChecker.setUserDictionaryProvider(new FileUserDictionary());
        SpellChecker.registerDictionaries(null, null);
        SpellChecker.register(this.JTPHObservacionRevisionSistemas);
        this.xclase = xclase;
        this.xnombrehallazgo = nombre;
        this.xgr = 0;
        mBuscarDatosBd();
        mGrabarBd();
        this.xgr = 1;
    }

    private void initComponents() {
        this.JBGEstado = new ButtonGroup();
        this.JPHRevisionSistemas = new JPanel();
        this.JSPObservacionRevisionSistemas = new JScrollPane();
        this.JTPHObservacionRevisionSistemas = new JTextPane();
        this.JPIREstado = new JPanel();
        this.JRBEstadoNormal = new JRadioButton();
        this.JRBEstadoAnormal = new JRadioButton();
        this.JBTGuardar = new JButton();
        setName("revisionxsistemas");
        setPreferredSize(new Dimension(834, 388));
        addMouseListener(new MouseAdapter() { // from class: Historia.JPARevisionSistemas.1
            public void mouseExited(MouseEvent evt) {
                JPARevisionSistemas.this.formMouseExited(evt);
            }
        });
        addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPARevisionSistemas.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPARevisionSistemas.this.formPropertyChange(evt);
            }
        });
        addAncestorListener(new AncestorListener() { // from class: Historia.JPARevisionSistemas.3
            public void ancestorMoved(AncestorEvent evt) {
            }

            public void ancestorAdded(AncestorEvent evt) {
            }

            public void ancestorRemoved(AncestorEvent evt) {
                JPARevisionSistemas.this.formAncestorRemoved(evt);
            }
        });
        this.JPHRevisionSistemas.setBorder(BorderFactory.createTitledBorder((Border) null, "HALLAZGO REVISIÓN POR SISTEMAS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPHRevisionSistemas.setPreferredSize(new Dimension(834, 388));
        this.JSPObservacionRevisionSistemas.setBorder(BorderFactory.createTitledBorder((Border) null, "DESCRIPCIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTPHObservacionRevisionSistemas.setFont(new Font("Arial", 1, 12));
        this.JTPHObservacionRevisionSistemas.addKeyListener(new KeyAdapter() { // from class: Historia.JPARevisionSistemas.4
            public void keyPressed(KeyEvent evt) {
                JPARevisionSistemas.this.JTPHObservacionRevisionSistemasKeyPressed(evt);
            }
        });
        this.JSPObservacionRevisionSistemas.setViewportView(this.JTPHObservacionRevisionSistemas);
        this.JPIREstado.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "TIPO", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JBGEstado.add(this.JRBEstadoNormal);
        this.JRBEstadoNormal.setFont(new Font("Arial", 1, 12));
        this.JRBEstadoNormal.setForeground(Color.blue);
        this.JRBEstadoNormal.setSelected(true);
        this.JRBEstadoNormal.setText("No Refiere");
        this.JRBEstadoNormal.addActionListener(new ActionListener() { // from class: Historia.JPARevisionSistemas.5
            public void actionPerformed(ActionEvent evt) {
                JPARevisionSistemas.this.JRBEstadoNormalActionPerformed(evt);
            }
        });
        this.JRBEstadoNormal.addKeyListener(new KeyAdapter() { // from class: Historia.JPARevisionSistemas.6
            public void keyPressed(KeyEvent evt) {
                JPARevisionSistemas.this.JRBEstadoNormalKeyPressed(evt);
            }
        });
        this.JBGEstado.add(this.JRBEstadoAnormal);
        this.JRBEstadoAnormal.setFont(new Font("Arial", 1, 12));
        this.JRBEstadoAnormal.setForeground(Color.blue);
        this.JRBEstadoAnormal.setText("Refiere");
        this.JRBEstadoAnormal.addActionListener(new ActionListener() { // from class: Historia.JPARevisionSistemas.7
            public void actionPerformed(ActionEvent evt) {
                JPARevisionSistemas.this.JRBEstadoAnormalActionPerformed(evt);
            }
        });
        this.JRBEstadoAnormal.addKeyListener(new KeyAdapter() { // from class: Historia.JPARevisionSistemas.8
            public void keyPressed(KeyEvent evt) {
                JPARevisionSistemas.this.JRBEstadoAnormalKeyPressed(evt);
            }
        });
        GroupLayout JPIREstadoLayout = new GroupLayout(this.JPIREstado);
        this.JPIREstado.setLayout(JPIREstadoLayout);
        JPIREstadoLayout.setHorizontalGroup(JPIREstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIREstadoLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBEstadoNormal).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBEstadoAnormal).addContainerGap(-1, 32767)));
        JPIREstadoLayout.setVerticalGroup(JPIREstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIREstadoLayout.createSequentialGroup().addGroup(JPIREstadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBEstadoNormal).addComponent(this.JRBEstadoAnormal)).addContainerGap(13, 32767)));
        this.JBTGuardar.setFont(new Font("Arial", 1, 14));
        this.JBTGuardar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGuardar.setText("Guardar");
        this.JBTGuardar.addActionListener(new ActionListener() { // from class: Historia.JPARevisionSistemas.9
            public void actionPerformed(ActionEvent evt) {
                JPARevisionSistemas.this.JBTGuardarActionPerformed(evt);
            }
        });
        this.JBTGuardar.addKeyListener(new KeyAdapter() { // from class: Historia.JPARevisionSistemas.10
            public void keyPressed(KeyEvent evt) {
                JPARevisionSistemas.this.JBTGuardarKeyPressed(evt);
            }
        });
        GroupLayout JPHRevisionSistemasLayout = new GroupLayout(this.JPHRevisionSistemas);
        this.JPHRevisionSistemas.setLayout(JPHRevisionSistemasLayout);
        JPHRevisionSistemasLayout.setHorizontalGroup(JPHRevisionSistemasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPHRevisionSistemasLayout.createSequentialGroup().addContainerGap().addGroup(JPHRevisionSistemasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPObservacionRevisionSistemas, -1, 765, 32767).addComponent(this.JPIREstado, -2, -1, -2).addComponent(this.JBTGuardar, -1, 768, 32767)).addGap(24, 24, 24)));
        JPHRevisionSistemasLayout.setVerticalGroup(JPHRevisionSistemasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPHRevisionSistemasLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIREstado, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JSPObservacionRevisionSistemas, -2, 208, -2).addGap(18, 18, 18).addComponent(this.JBTGuardar).addContainerGap(13, 32767)));
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPHRevisionSistemas, -1, 814, 32767).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPHRevisionSistemas, -2, -1, -2).addContainerGap(-1, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEstadoNormalActionPerformed(ActionEvent evt) {
        mBuscarDatosBd();
        if (this.JTPHObservacionRevisionSistemas.getText().equals("NO REFIERE")) {
            this.xestado = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEstadoAnormalActionPerformed(ActionEvent evt) {
        if (this.JTPHObservacionRevisionSistemas.getText().equals("NO REFIERE")) {
            this.xestado = 1;
            this.JTPHObservacionRevisionSistemas.setText((String) null);
            this.JTPHObservacionRevisionSistemas.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGuardarActionPerformed(ActionEvent evt) {
        mGrabarBd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEstadoNormalKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.xestado = 0;
            this.JRBEstadoNormal.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEstadoAnormalKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.xestado = 1;
            this.JRBEstadoAnormal.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPHObservacionRevisionSistemasKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9) {
            this.JTPHObservacionRevisionSistemas.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGuardarKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            mGrabarBd();
            this.JBTGuardar.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formAncestorRemoved(AncestorEvent evt) {
        mGrabarBd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formMouseExited(MouseEvent evt) {
        mGrabarBd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formPropertyChange(PropertyChangeEvent evt) {
        if (this.xgr == 1) {
            mGrabarBd();
        }
    }

    public void mGrabarBd() {
        if (this.JBTGuardar.isEnabled() && clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() != null) {
            try {
                String sql = "SELECT Id, Id_Atencion FROM h_revisionsistemas WHERE (Id_Atencion ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "')";
                ConsultasMySQL xmt1 = new ConsultasMySQL();
                ResultSet xrs = xmt1.traerRs(sql);
                if (xrs.next()) {
                    ConsultasMySQL xmt2 = new ConsultasMySQL();
                    String sql2 = "SELECT h_detallerevisionsistemas.Id_RevisionSistemas, h_tiposistemas.Nbre, h_atencion.TipoGuardado  FROM h_detallerevisionsistemas INNER JOIN h_tiposistemas  ON (h_detallerevisionsistemas.Id_TipoSistemas = h_tiposistemas.Id) INNER JOIN h_revisionsistemas  ON (h_detallerevisionsistemas.Id_RevisionSistemas = h_revisionsistemas.Id) INNER JOIN h_atencion  ON (h_revisionsistemas.Id_Atencion = h_atencion.Id) WHERE (h_detallerevisionsistemas.Id_RevisionSistemas ='" + xrs.getString(1) + "' AND h_tiposistemas.Nbre ='" + this.xnombrehallazgo + "') ";
                    ResultSet xrs1 = xmt2.traerRs(sql2);
                    if (xrs1.next()) {
                        ConsultasMySQL xmtc = new ConsultasMySQL();
                        String sql3 = "update h_detallerevisionsistemas set Valor='" + this.xestado + "', Descripcion='" + this.JTPHObservacionRevisionSistemas.getText() + "' WHERE (h_detallerevisionsistemas.Id_RevisionSistemas ='" + xrs.getString(1) + "' AND Id_TipoSistemas ='" + mDevorlverIdSistema() + "') ";
                        xmtc.ejecutarSQL(sql3);
                        xmtc.cerrarConexionBd();
                    } else {
                        ConsultasMySQL xmtc2 = new ConsultasMySQL();
                        String sql4 = "insert into h_detallerevisionsistemas (Id_RevisionSistemas, Id_TipoSistemas, Valor, Descripcion) values ('" + xrs.getString(1) + "','" + mDevorlverIdSistema() + "','" + this.xestado + "','" + this.JTPHObservacionRevisionSistemas.getText() + "')";
                        xmt1.ejecutarSQL(sql4);
                        xmtc2.cerrarConexionBd();
                    }
                    xrs1.close();
                    xmt2.cerrarConexionBd();
                    this.xmetodo.cambiarEstadoValidadoItemHC(getName(), 1, true);
                }
                xrs.close();
                xmt1.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JPARevisionSistemas.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    private String mDevorlverIdSistema() {
        ConsultasMySQL xm = new ConsultasMySQL();
        String xvalor = xm.traerDato("SELECT Id FROM h_tiposistemas WHERE Nbre='" + this.xnombrehallazgo + "'");
        xm.cerrarConexionBd();
        return xvalor;
    }

    private void mBuscarDatosBd() {
        if (clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() != null) {
            try {
                String sql = "SELECT h_detallerevisionsistemas.Valor, h_detallerevisionsistemas.Descripcion, h_tiposistemas.Nbre, h_atencion.TipoGuardado FROM h_detallerevisionsistemas INNER JOIN h_tiposistemas  ON (h_detallerevisionsistemas.Id_TipoSistemas = h_tiposistemas.Id) INNER JOIN h_revisionsistemas  ON (h_detallerevisionsistemas.Id_RevisionSistemas = h_revisionsistemas.Id) INNER JOIN h_atencion  ON (h_revisionsistemas.Id_Atencion = h_atencion.Id) WHERE (h_tiposistemas.Nbre ='" + this.xnombrehallazgo + "' AND h_atencion.Id ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "') ";
                ConsultasMySQL xmt1 = new ConsultasMySQL();
                ResultSet xrs = xmt1.traerRs(sql);
                if (xrs.next()) {
                    xrs.first();
                    this.JTPHObservacionRevisionSistemas.setText(xrs.getString(2));
                    this.xestado = xrs.getInt(1);
                    if (xrs.getInt(1) == 0) {
                        this.JRBEstadoNormal.setSelected(true);
                    } else {
                        this.JRBEstadoAnormal.setSelected(true);
                    }
                    if (xrs.getInt(4) == 0 || xrs.getInt(4) == 2) {
                        this.JTPHObservacionRevisionSistemas.setEditable(true);
                        this.JRBEstadoAnormal.setEnabled(true);
                        this.JRBEstadoNormal.setEnabled(true);
                    } else {
                        this.JTPHObservacionRevisionSistemas.setEditable(false);
                        this.JRBEstadoAnormal.setEnabled(false);
                        this.JRBEstadoNormal.setEnabled(false);
                        this.JBTGuardar.setEnabled(false);
                    }
                    this.xmetodo.cambiarEstadoValidadoItemHC(getName(), 1, true);
                }
                xrs.close();
                xmt1.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JPAAtencion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }
}
