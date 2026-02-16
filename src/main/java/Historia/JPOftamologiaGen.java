package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPOftamologiaGen.class */
public class JPOftamologiaGen extends JPanel {
    private JPOft_OjoExa1 xJPOft_OjoExaDer1;
    private JPOft_OjoExa1 xJPOft_OjoExaIzq1;
    private JPOft_OjoExa2 xJPOft_OjoExaDer2;
    private JPOft_OjoExa2 xJPOft_OjoExaIzq2;
    private JPOft_OjoExa3 xJPOft_OjoExaDer3;
    private JPOft_OjoExa3 xJPOft_OjoExaIzq3;
    private JPOft_Evolucion xJPOft_EvoDer;
    private JPOft_Evolucion xJPOft_EvoIzq;
    private Metodos xmt = new Metodos();
    private String xOftamologia = null;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodeloEvo;
    private Object[] xdatos;
    private JButton JBGuardaEvo;
    private JButton JBNuevoEvol;
    private JButton JBNuevoEvol1;
    private JButton JBT_Nota;
    private JPanel JPOjoDer1;
    private JPanel JPOjoDer2;
    private JPanel JPOjoDer3;
    private JPanel JPOjoDer4;
    private JPanel JPOjoIzq1;
    private JPanel JPOjoIzq2;
    private JPanel JPOjoIzq3;
    private JPanel JPOjoIzq4;
    private JTextArea JTAEvolucion;
    private JTable JTEvolucion;
    private JTable JTHistorico;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JTabbedPane jTabbedPane1;

    public JPOftamologiaGen() {
        initComponents();
        mCargarPanel();
        mBuscaHistorico();
        mVerifica();
        if (this.xOftamologia != null) {
            mCargaControlesDer(this.xOftamologia);
            mCargaControlesIzq(this.xOftamologia);
        }
        mBuscaEvoluciones();
    }

    /* JADX WARN: Type inference failed for: r3v115, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v69, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jTabbedPane1 = new JTabbedPane();
        this.jPanel1 = new JPanel();
        this.JPOjoIzq1 = new JPanel();
        this.JPOjoDer1 = new JPanel();
        this.jPanel2 = new JPanel();
        this.JPOjoIzq2 = new JPanel();
        this.JPOjoDer2 = new JPanel();
        this.jPanel3 = new JPanel();
        this.JPOjoDer3 = new JPanel();
        this.JPOjoIzq3 = new JPanel();
        this.jPanel4 = new JPanel();
        this.JPOjoDer4 = new JPanel();
        this.JPOjoIzq4 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.JTAEvolucion = new JTextArea();
        this.JBGuardaEvo = new JButton();
        this.jScrollPane3 = new JScrollPane();
        this.JTEvolucion = new JTable();
        this.JBNuevoEvol = new JButton();
        this.JBNuevoEvol1 = new JButton();
        this.JBT_Nota = new JButton();
        this.jPanel5 = new JPanel();
        this.jScrollPane2 = new JScrollPane();
        this.JTHistorico = new JTable();
        setName("xjpOftamologia");
        this.jTabbedPane1.setForeground(new Color(0, 102, 0));
        this.jTabbedPane1.setFont(new Font("Arial", 1, 14));
        this.JPOjoIzq1.setMaximumSize(new Dimension(387, 630));
        this.JPOjoIzq1.setMinimumSize(new Dimension(387, 630));
        this.JPOjoIzq1.setPreferredSize(new Dimension(387, 630));
        GroupLayout JPOjoIzq1Layout = new GroupLayout(this.JPOjoIzq1);
        this.JPOjoIzq1.setLayout(JPOjoIzq1Layout);
        JPOjoIzq1Layout.setHorizontalGroup(JPOjoIzq1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 387, 32767));
        JPOjoIzq1Layout.setVerticalGroup(JPOjoIzq1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767));
        this.JPOjoDer1.setMaximumSize(new Dimension(387, 630));
        this.JPOjoDer1.setMinimumSize(new Dimension(387, 630));
        this.JPOjoDer1.setPreferredSize(new Dimension(387, 630));
        GroupLayout JPOjoDer1Layout = new GroupLayout(this.JPOjoDer1);
        this.JPOjoDer1.setLayout(JPOjoDer1Layout);
        JPOjoDer1Layout.setHorizontalGroup(JPOjoDer1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 387, 32767));
        JPOjoDer1Layout.setVerticalGroup(JPOjoDer1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.JPOjoDer1, -2, -1, -2).addGap(3, 3, 3).addComponent(this.JPOjoIzq1, -2, -1, -2)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPOjoDer1, -1, 690, 32767).addComponent(this.JPOjoIzq1, -1, 690, 32767)).addGap(0, 0, 0)));
        this.jTabbedPane1.addTab("EXAMEN OFTAMOLÓGICO", this.jPanel1);
        this.JPOjoIzq2.setMaximumSize(new Dimension(387, 630));
        this.JPOjoIzq2.setMinimumSize(new Dimension(387, 630));
        GroupLayout JPOjoIzq2Layout = new GroupLayout(this.JPOjoIzq2);
        this.JPOjoIzq2.setLayout(JPOjoIzq2Layout);
        JPOjoIzq2Layout.setHorizontalGroup(JPOjoIzq2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 387, 32767));
        JPOjoIzq2Layout.setVerticalGroup(JPOjoIzq2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 693, 32767));
        this.JPOjoDer2.setMaximumSize(new Dimension(387, 630));
        this.JPOjoDer2.setMinimumSize(new Dimension(387, 630));
        GroupLayout JPOjoDer2Layout = new GroupLayout(this.JPOjoDer2);
        this.JPOjoDer2.setLayout(JPOjoDer2Layout);
        JPOjoDer2Layout.setHorizontalGroup(JPOjoDer2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 387, 32767));
        JPOjoDer2Layout.setVerticalGroup(JPOjoDer2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767));
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addComponent(this.JPOjoDer2, -2, -1, -2).addGap(6, 6, 6).addComponent(this.JPOjoIzq2, -2, -1, -2).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPOjoIzq2, -1, -1, 32767).addComponent(this.JPOjoDer2, -1, -1, 32767));
        this.jTabbedPane1.addTab("EXAMEN OFTAMOLÓGICO", this.jPanel2);
        this.JPOjoDer3.setMaximumSize(new Dimension(387, 630));
        this.JPOjoDer3.setMinimumSize(new Dimension(387, 630));
        GroupLayout JPOjoDer3Layout = new GroupLayout(this.JPOjoDer3);
        this.JPOjoDer3.setLayout(JPOjoDer3Layout);
        JPOjoDer3Layout.setHorizontalGroup(JPOjoDer3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 387, 32767));
        JPOjoDer3Layout.setVerticalGroup(JPOjoDer3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 693, 32767));
        this.JPOjoIzq3.setMaximumSize(new Dimension(387, 630));
        this.JPOjoIzq3.setMinimumSize(new Dimension(387, 630));
        GroupLayout JPOjoIzq3Layout = new GroupLayout(this.JPOjoIzq3);
        this.JPOjoIzq3.setLayout(JPOjoIzq3Layout);
        JPOjoIzq3Layout.setHorizontalGroup(JPOjoIzq3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 387, 32767));
        JPOjoIzq3Layout.setVerticalGroup(JPOjoIzq3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767));
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.JPOjoDer3, -2, -1, -2).addGap(6, 6, 6).addComponent(this.JPOjoIzq3, -2, -1, -2).addGap(0, 0, 32767)));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPOjoDer3, -1, -1, 32767).addComponent(this.JPOjoIzq3, -1, -1, 32767));
        this.jTabbedPane1.addTab("FONDO DE OJO", this.jPanel3);
        GroupLayout JPOjoDer4Layout = new GroupLayout(this.JPOjoDer4);
        this.JPOjoDer4.setLayout(JPOjoDer4Layout);
        JPOjoDer4Layout.setHorizontalGroup(JPOjoDer4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 362, 32767));
        JPOjoDer4Layout.setVerticalGroup(JPOjoDer4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 238, 32767));
        GroupLayout JPOjoIzq4Layout = new GroupLayout(this.JPOjoIzq4);
        this.JPOjoIzq4.setLayout(JPOjoIzq4Layout);
        JPOjoIzq4Layout.setHorizontalGroup(JPOjoIzq4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 362, 32767));
        JPOjoIzq4Layout.setVerticalGroup(JPOjoIzq4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "DESCRIPCIÓN DE LA EVOLUCIÓN", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAEvolucion.setColumns(1);
        this.JTAEvolucion.setFont(new Font("Arial", 1, 12));
        this.JTAEvolucion.setRows(1);
        this.JTAEvolucion.setBorder((Border) null);
        this.jScrollPane1.setViewportView(this.JTAEvolucion);
        this.JBGuardaEvo.setFont(new Font("Arial", 1, 12));
        this.JBGuardaEvo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBGuardaEvo.setText("Guadar");
        this.JBGuardaEvo.addActionListener(new ActionListener() { // from class: Historia.JPOftamologiaGen.1
            public void actionPerformed(ActionEvent evt) {
                JPOftamologiaGen.this.JBGuardaEvoActionPerformed(evt);
            }
        });
        this.jScrollPane3.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTEvolucion.setFont(new Font("Arial", 1, 12));
        this.JTEvolucion.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTEvolucion.setSelectionBackground(new Color(255, 255, 255));
        this.JTEvolucion.setSelectionForeground(Color.red);
        this.JTEvolucion.addMouseListener(new MouseAdapter() { // from class: Historia.JPOftamologiaGen.2
            public void mouseClicked(MouseEvent evt) {
                JPOftamologiaGen.this.JTEvolucionMouseClicked(evt);
            }
        });
        this.jScrollPane3.setViewportView(this.JTEvolucion);
        this.JBNuevoEvol.setFont(new Font("Arial", 1, 12));
        this.JBNuevoEvol.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Limpiar.png")));
        this.JBNuevoEvol.setText("Nueva");
        this.JBNuevoEvol.addActionListener(new ActionListener() { // from class: Historia.JPOftamologiaGen.3
            public void actionPerformed(ActionEvent evt) {
                JPOftamologiaGen.this.JBNuevoEvolActionPerformed(evt);
            }
        });
        this.JBNuevoEvol1.setFont(new Font("Arial", 1, 12));
        this.JBNuevoEvol1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.JBNuevoEvol1.setText("Editar");
        this.JBNuevoEvol1.addActionListener(new ActionListener() { // from class: Historia.JPOftamologiaGen.4
            public void actionPerformed(ActionEvent evt) {
                JPOftamologiaGen.this.JBNuevoEvol1ActionPerformed(evt);
            }
        });
        this.JBT_Nota.setFont(new Font("Arial", 1, 12));
        this.JBT_Nota.setIcon(new ImageIcon(getClass().getResource("/Imagenes/HojaLapiz29x27.png")));
        this.JBT_Nota.setText("Nota Predefinida");
        this.JBT_Nota.addActionListener(new ActionListener() { // from class: Historia.JPOftamologiaGen.5
            public void actionPerformed(ActionEvent evt) {
                JPOftamologiaGen.this.JBT_NotaActionPerformed(evt);
            }
        });
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1).addComponent(this.jScrollPane3).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.JBGuardaEvo, -2, 180, -2).addGap(18, 18, 18).addComponent(this.JBNuevoEvol, -2, 180, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBNuevoEvol1, -2, 180, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBT_Nota, -1, -1, 32767)).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.JPOjoDer4, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 46, 32767).addComponent(this.JPOjoIzq4, -2, -1, -2))).addContainerGap()));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPOjoDer4, -1, -1, 32767).addComponent(this.JPOjoIzq4, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 145, -2).addGap(3, 3, 3).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBGuardaEvo, -2, 41, -2).addComponent(this.JBNuevoEvol, -1, -1, 32767).addComponent(this.JBNuevoEvol1, -1, -1, 32767).addComponent(this.JBT_Nota)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane3, -2, 185, -2).addGap(0, 69, 32767)));
        this.jTabbedPane1.addTab("EVOLUCIONES", this.jPanel4);
        this.jScrollPane2.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.jScrollPane2.setFont(new Font("Arial", 1, 12));
        this.JTHistorico.setFont(new Font("Arial", 1, 12));
        this.JTHistorico.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTHistorico.setSelectionForeground(Color.red);
        this.jScrollPane2.setViewportView(this.JTHistorico);
        GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
        this.jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane2, -1, 770, 32767).addContainerGap()));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane2, -2, 578, -2).addContainerGap(104, 32767)));
        this.jTabbedPane1.addTab("HISTÓRICO", this.jPanel5);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jTabbedPane1).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.jTabbedPane1).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGuardaEvoActionPerformed(ActionEvent evt) {
        if (this.xOftamologia != null) {
            if (!this.JTAEvolucion.getText().isEmpty()) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    String sql = "INSERT INTO  `h_oftamologia_evolucion`             (`IdOfta`,`IdAtencion`,`FechaR`,`SC`,`CC`,`Esfera`,`Cilindro`,`Eje`,`K1`,`K2`,`LIO`,`LA`,              `Balance`,`MEO`,`Observacion`,`SCIz`,`CCIz`,`EsferaIz`,`CilindroIz`,`EjeIz`,`K1Iz`,`K2Iz`,              `LIOIz`,`LAIz`,`BalanceIz`,`MEOIz`,IdProfesional, IdEspecialidad, UsuarioS)               VALUES ('" + this.xOftamologia + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "','" + this.xJPOft_EvoDer.JLSC.getText() + "','" + this.xJPOft_EvoDer.JLCC.getText() + "','" + this.xJPOft_EvoDer.JLEsfera.getText() + "','" + this.xJPOft_EvoDer.JLCilindro.getText() + "','" + this.xJPOft_EvoDer.JLEje.getText() + "','" + this.xJPOft_EvoDer.JLK1.getText() + "','" + this.xJPOft_EvoDer.JLK2.getText() + "','" + this.xJPOft_EvoDer.JLLIO.getText() + "','" + this.xJPOft_EvoDer.JLLA.getText() + "',         '" + this.xJPOft_EvoDer.JLBalance.getText() + "','" + this.xJPOft_EvoDer.JLMEO.getText() + "','" + this.JTAEvolucion.getText() + "','" + this.xJPOft_EvoIzq.JLSC.getText() + "','" + this.xJPOft_EvoIzq.JLCC.getText() + "','" + this.xJPOft_EvoIzq.JLEsfera.getText() + "','" + this.xJPOft_EvoIzq.JLCilindro.getText() + "','" + this.xJPOft_EvoIzq.JLEje.getText() + "','" + this.xJPOft_EvoIzq.JLK1.getText() + "','" + this.xJPOft_EvoIzq.JLK2.getText() + "','" + this.xJPOft_EvoIzq.JLLIO.getText() + "',         '" + this.xJPOft_EvoIzq.JLLA.getText() + "','" + this.xJPOft_EvoIzq.JLBalance.getText() + "','" + this.xJPOft_EvoIzq.JLMEO.getText() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + Principal.usuarioSistemaDTO.getLogin() + "');";
                    this.xct.ejecutarSQL(sql);
                    this.xct.cerrarConexionBd();
                    mBuscaEvoluciones();
                    mNuevo();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe digitar la Descripción de la evolución ", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTAEvolucion.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe cargar una História", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTEvolucionMouseClicked(MouseEvent evt) {
        if (this.JTEvolucion.getSelectedRow() > -1) {
            this.JTAEvolucion.setText(this.xmodeloEvo.getValueAt(this.JTEvolucion.getSelectedRow(), 2).toString());
            this.xJPOft_EvoDer.JLSC.setText(this.xmodeloEvo.getValueAt(this.JTEvolucion.getSelectedRow(), 5).toString());
            this.xJPOft_EvoDer.JLCC.setText(this.xmodeloEvo.getValueAt(this.JTEvolucion.getSelectedRow(), 6).toString());
            this.xJPOft_EvoDer.JLEsfera.setText(this.xmodeloEvo.getValueAt(this.JTEvolucion.getSelectedRow(), 7).toString());
            this.xJPOft_EvoDer.JLCilindro.setText(this.xmodeloEvo.getValueAt(this.JTEvolucion.getSelectedRow(), 8).toString());
            this.xJPOft_EvoDer.JLEje.setText(this.xmodeloEvo.getValueAt(this.JTEvolucion.getSelectedRow(), 9).toString());
            this.xJPOft_EvoDer.JLK1.setText(this.xmodeloEvo.getValueAt(this.JTEvolucion.getSelectedRow(), 10).toString());
            this.xJPOft_EvoDer.JLK2.setText(this.xmodeloEvo.getValueAt(this.JTEvolucion.getSelectedRow(), 11).toString());
            this.xJPOft_EvoDer.JLLIO.setText(this.xmodeloEvo.getValueAt(this.JTEvolucion.getSelectedRow(), 12).toString());
            this.xJPOft_EvoDer.JLLA.setText(this.xmodeloEvo.getValueAt(this.JTEvolucion.getSelectedRow(), 13).toString());
            this.xJPOft_EvoDer.JLBalance.setText(this.xmodeloEvo.getValueAt(this.JTEvolucion.getSelectedRow(), 14).toString());
            this.xJPOft_EvoDer.JLMEO.setText(this.xmodeloEvo.getValueAt(this.JTEvolucion.getSelectedRow(), 15).toString());
            this.xJPOft_EvoIzq.JLSC.setText(this.xmodeloEvo.getValueAt(this.JTEvolucion.getSelectedRow(), 16).toString());
            this.xJPOft_EvoIzq.JLCC.setText(this.xmodeloEvo.getValueAt(this.JTEvolucion.getSelectedRow(), 17).toString());
            this.xJPOft_EvoIzq.JLEsfera.setText(this.xmodeloEvo.getValueAt(this.JTEvolucion.getSelectedRow(), 18).toString());
            this.xJPOft_EvoIzq.JLCilindro.setText(this.xmodeloEvo.getValueAt(this.JTEvolucion.getSelectedRow(), 19).toString());
            this.xJPOft_EvoIzq.JLEje.setText(this.xmodeloEvo.getValueAt(this.JTEvolucion.getSelectedRow(), 20).toString());
            this.xJPOft_EvoIzq.JLK1.setText(this.xmodeloEvo.getValueAt(this.JTEvolucion.getSelectedRow(), 21).toString());
            this.xJPOft_EvoIzq.JLK2.setText(this.xmodeloEvo.getValueAt(this.JTEvolucion.getSelectedRow(), 22).toString());
            this.xJPOft_EvoIzq.JLLIO.setText(this.xmodeloEvo.getValueAt(this.JTEvolucion.getSelectedRow(), 23).toString());
            this.xJPOft_EvoIzq.JLLA.setText(this.xmodeloEvo.getValueAt(this.JTEvolucion.getSelectedRow(), 24).toString());
            this.xJPOft_EvoIzq.JLBalance.setText(this.xmodeloEvo.getValueAt(this.JTEvolucion.getSelectedRow(), 25).toString());
            this.xJPOft_EvoIzq.JLMEO.setText(this.xmodeloEvo.getValueAt(this.JTEvolucion.getSelectedRow(), 26).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBNuevoEvolActionPerformed(ActionEvent evt) {
        mNuevo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBNuevoEvol1ActionPerformed(ActionEvent evt) {
        if (this.JTEvolucion.getSelectedRow() != -1) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta actualizar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String sql = "UPDATE `h_oftamologia_evolucion`  SET `Observacion`= '" + this.JTAEvolucion.getText() + "' WHERE Id='" + this.xmodeloEvo.getValueAt(this.JTEvolucion.getSelectedRow(), 0) + "'";
                this.xct.ejecutarSQL(sql);
                this.xct.cerrarConexionBd();
                mBuscaEvoluciones();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_NotaActionPerformed(ActionEvent evt) {
        JD_NotasPredefinidas dialog = new JD_NotasPredefinidas((Frame) null, true, this.JTAEvolucion, this.JTAEvolucion, 1);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    private void mNuevo() {
        this.JTAEvolucion.setText("");
        this.xJPOft_EvoDer.JLSC.setText("");
        this.xJPOft_EvoDer.JLCC.setText("");
        this.xJPOft_EvoDer.JLEsfera.setText("");
        this.xJPOft_EvoDer.JLCilindro.setText("");
        this.xJPOft_EvoDer.JLEje.setText("");
        this.xJPOft_EvoDer.JLK1.setText("");
        this.xJPOft_EvoDer.JLK2.setText("");
        this.xJPOft_EvoDer.JLLIO.setText("");
        this.xJPOft_EvoDer.JLLA.setText("");
        this.xJPOft_EvoDer.JLBalance.setText("");
        this.xJPOft_EvoDer.JLMEO.setText("");
        this.xJPOft_EvoIzq.JLSC.setText("");
        this.xJPOft_EvoIzq.JLCC.setText("");
        this.xJPOft_EvoIzq.JLEsfera.setText("");
        this.xJPOft_EvoIzq.JLCilindro.setText("");
        this.xJPOft_EvoIzq.JLEje.setText("");
        this.xJPOft_EvoIzq.JLK1.setText("");
        this.xJPOft_EvoIzq.JLK2.setText("");
        this.xJPOft_EvoIzq.JLLIO.setText("");
        this.xJPOft_EvoIzq.JLLA.setText("");
        this.xJPOft_EvoIzq.JLBalance.setText("");
        this.xJPOft_EvoIzq.JLMEO.setText("");
    }

    private void mBuscaEvoluciones() {
        String sql = "SELECT  Id, `FechaR`,`Observacion`,profesional1.`NProfesional`, profesional1.`Especialidad`, `SC`,`CC`,`Esfera`,`Cilindro`,`Eje`,`K1`,`K2`,`LIO`,`LA`,`Balance`,`MEO`,   `SCIz`,`CCIz`,`EsferaIz`,`CilindroIz`,`EjeIz`,`K1Iz`,`K2Iz`,`LIOIz`,`LAIz`,   `BalanceIz`,`MEOIz` FROM  `h_oftamologia_evolucion` INNER JOIN  `profesional1`     ON (`h_oftamologia_evolucion`.`IdProfesional` = `profesional1`.`Id_Persona`) AND (`h_oftamologia_evolucion`.`IdEspecialidad` = `profesional1`.`IdEspecialidad`) WHERE (h_oftamologia_evolucion.Estado=1 AND IdAtencion='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "') ORDER BY FechaR DESC";
        try {
            mCrearModeloEvolucion();
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloEvo.addRow(this.xdatos);
                    this.xmodeloEvo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodeloEvo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodeloEvo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodeloEvo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodeloEvo.setValueAt(xrs.getString(5), n, 4);
                    this.xmodeloEvo.setValueAt(xrs.getString(6), n, 5);
                    this.xmodeloEvo.setValueAt(xrs.getString(7), n, 6);
                    this.xmodeloEvo.setValueAt(xrs.getString(8), n, 7);
                    this.xmodeloEvo.setValueAt(xrs.getString(9), n, 8);
                    this.xmodeloEvo.setValueAt(xrs.getString(10), n, 9);
                    this.xmodeloEvo.setValueAt(xrs.getString(11), n, 10);
                    this.xmodeloEvo.setValueAt(xrs.getString(12), n, 11);
                    this.xmodeloEvo.setValueAt(xrs.getString(13), n, 12);
                    this.xmodeloEvo.setValueAt(xrs.getString(14), n, 13);
                    this.xmodeloEvo.setValueAt(xrs.getString(15), n, 14);
                    this.xmodeloEvo.setValueAt(xrs.getString(16), n, 15);
                    this.xmodeloEvo.setValueAt(xrs.getString(17), n, 16);
                    this.xmodeloEvo.setValueAt(xrs.getString(18), n, 17);
                    this.xmodeloEvo.setValueAt(xrs.getString(19), n, 18);
                    this.xmodeloEvo.setValueAt(xrs.getString(20), n, 19);
                    this.xmodeloEvo.setValueAt(xrs.getString(21), n, 20);
                    this.xmodeloEvo.setValueAt(xrs.getString(22), n, 21);
                    this.xmodeloEvo.setValueAt(xrs.getString(23), n, 22);
                    this.xmodeloEvo.setValueAt(xrs.getString(24), n, 23);
                    this.xmodeloEvo.setValueAt(xrs.getString(25), n, 24);
                    this.xmodeloEvo.setValueAt(xrs.getString(26), n, 25);
                    this.xmodeloEvo.setValueAt(xrs.getString(27), n, 26);
                    n++;
                }
                this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPOftamologiaGen.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloEvolucion() {
        this.xmodeloEvo = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Observacion", "Profesional", "Especialidad", "SC", "CC", "Esfera", "Cilindro", "Eje", "K1", "K2", "LIO", "LA", "Balance", "MEO", "SCIz", "CCIz", "EsferaIz", "CilindroIz", "EjeIz", "K1Iz", "K2Iz", "LIOIz", "LAIz", "BalanceIz", "MEOIz"}) { // from class: Historia.JPOftamologiaGen.6
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTEvolucion.setModel(this.xmodeloEvo);
        this.JTEvolucion.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(1).setPreferredWidth(15);
        this.JTEvolucion.getColumnModel().getColumn(2).setPreferredWidth(15);
        this.JTEvolucion.getColumnModel().getColumn(3).setPreferredWidth(15);
        this.JTEvolucion.getColumnModel().getColumn(4).setPreferredWidth(15);
        this.JTEvolucion.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(15).setMaxWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(16).setMinWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(16).setMaxWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(17).setPreferredWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(17).setMinWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(17).setMaxWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(18).setPreferredWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(18).setMinWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(18).setMaxWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(19).setPreferredWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(19).setMinWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(19).setMaxWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(20).setPreferredWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(20).setMinWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(20).setMaxWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(21).setPreferredWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(21).setMinWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(21).setMaxWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(22).setPreferredWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(22).setMinWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(22).setMaxWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(23).setPreferredWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(23).setMinWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(23).setMaxWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(24).setPreferredWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(24).setMinWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(24).setMaxWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(25).setPreferredWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(25).setMinWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(25).setMaxWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(26).setPreferredWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(26).setMinWidth(0);
        this.JTEvolucion.getColumnModel().getColumn(26).setMaxWidth(0);
    }

    private void mCargarPanel() {
        this.xJPOft_OjoExaDer1 = new JPOft_OjoExa1("OJO DERECHO");
        this.xJPOft_OjoExaDer1.setVisible(true);
        this.xJPOft_OjoExaDer1.setBounds(0, 0, 387, 721);
        this.JPOjoDer1.add(this.xJPOft_OjoExaDer1);
        setVisible(true);
        this.xJPOft_OjoExaIzq1 = new JPOft_OjoExa1("OJO IZQUIERDO");
        this.xJPOft_OjoExaIzq1.setVisible(true);
        this.xJPOft_OjoExaIzq1.setBounds(0, 0, 387, 721);
        this.JPOjoIzq1.add(this.xJPOft_OjoExaIzq1);
        setVisible(true);
        this.xJPOft_OjoExaDer2 = new JPOft_OjoExa2("OJO DERECHO");
        this.xJPOft_OjoExaDer2.setVisible(true);
        this.xJPOft_OjoExaDer2.setBounds(0, 0, 387, 721);
        this.JPOjoDer2.add(this.xJPOft_OjoExaDer2);
        setVisible(true);
        this.xJPOft_OjoExaIzq2 = new JPOft_OjoExa2("OJO IZQUIERDO");
        this.xJPOft_OjoExaIzq2.setVisible(true);
        this.xJPOft_OjoExaIzq2.setBounds(0, 0, 387, 721);
        this.JPOjoIzq2.add(this.xJPOft_OjoExaIzq2);
        setVisible(true);
        this.xJPOft_OjoExaDer3 = new JPOft_OjoExa3("OJO DERECHO");
        this.xJPOft_OjoExaDer3.setVisible(true);
        this.xJPOft_OjoExaDer3.setBounds(0, 0, 387, 721);
        this.JPOjoDer3.add(this.xJPOft_OjoExaDer3);
        setVisible(true);
        this.xJPOft_OjoExaIzq3 = new JPOft_OjoExa3("OJO IZQUIERDO");
        this.xJPOft_OjoExaIzq3.setVisible(true);
        this.xJPOft_OjoExaIzq3.setBounds(0, 0, 387, 721);
        this.JPOjoIzq3.add(this.xJPOft_OjoExaIzq3);
        setVisible(true);
        this.xJPOft_EvoDer = new JPOft_Evolucion("OJO DERECHO");
        this.xJPOft_EvoDer.setVisible(true);
        this.xJPOft_EvoDer.setBounds(0, 0, 387, 630);
        this.JPOjoDer4.add(this.xJPOft_EvoDer);
        setVisible(true);
        this.xJPOft_EvoIzq = new JPOft_Evolucion("OJO IZQUIERDO");
        this.xJPOft_EvoIzq.setVisible(true);
        this.xJPOft_EvoIzq.setBounds(0, 0, 387, 630);
        this.JPOjoIzq4.add(this.xJPOft_EvoIzq);
        setVisible(true);
    }

    public void mGuardar() {
        if (!mVerifica2()) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String sql = " INSERT INTO  `h_oftamologia`   ( `IdAtencion`,`IdUsuario`,`IdProfesional`,`IdEspecialidad`,`FechaR`, `UsuarioS`)  VALUES ( '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                this.xOftamologia = this.xct.ejecutarSQLId(sql);
                this.xct.cerrarConexionBd();
                String sqlDer = "INSERT INTO  `h_oftamologia_ojo_der`            (`IdOfta`,`SC`,`CC`,`Esfera`,`Cilindro`,`Eje`,`K1`,`K2`,`LIO`,`LA`,`Balance`,`MEO`,`AspNormal`,`Ectropion`,             `Entropion`,`Superior`,`Inferior`,`PTosis`,`Blefaro`,`Dermato`,             `PestNormal`,`Triquiasis`,`Distriquiasis`,`OtrosParpa`,`Normocronica`,`Placa`,`Hiperemia`,`EspNasal`,             `EspTemporal`,`HemNasal`,`HemTemporal`,`HemGeneralizada`,`RxPapilar`,`RxFolicular`,`Quemosis`,`Secrecion`,             `OtrosConjuntiva`,`CornTrasp`,`Pliegues`,`InflamLocal`,`SubEpiteliales`,`EdemaCentral`,`EdePeriferico`,`EdeGeneralizada`,             `Microquistico`,`Estronal`,`GCarnero`,`Pigmentados`,`UlceraCentral`,`UlceraPeriferico`,`CECentral`,CEPeriferico, `CESuperficial`,             `CEProfundo`,`CETipo`,`OtrosCornea`,`Camara`,`Cristalino`,`Negra`,Numero,`Discordia`,`Ang1`,`Ang2`,`Ang3`,`Ang4`,             `OtrosAngulo`,`Capsula`,`CamaraAnt`,`Saco`,`Sulcus`,`Atrapado`,`PIO`,`CristTrasparente`,`CristBlanco`,`OCapsular`,             `EscNuclear`,`OpaCueniforme`,`OpaSutural`,`OpaNucCongenita`,`PolarPost`,`OtrosLentesIntr`,`VClaro`,`VTurbio`,`DepVirregente`,             `TyInflam`,`TyHemor`,`Papilas`,`Excavacion`,`Vasos`,`PoloPost`,`Epiretinal`,`Disforme`,`MacSana`,             `CamPigmentacion`,`Neovascular`,`Cicatriz`,`FocoCoro`,`Periferia`,ObservacionVit,`UsuarioS`)  VALUES ('" + this.xOftamologia + "','" + this.xJPOft_OjoExaDer1.JLSC.getText() + "','" + this.xJPOft_OjoExaDer1.JLCC.getText() + "','" + this.xJPOft_OjoExaDer1.JLEsfera.getText() + "','" + this.xJPOft_OjoExaDer1.JLCilindro.getText() + "','" + this.xJPOft_OjoExaDer1.JLEje.getText() + "','" + this.xJPOft_OjoExaDer1.JLK1.getText() + "','" + this.xJPOft_OjoExaDer1.JLK2.getText() + "','" + this.xJPOft_OjoExaDer1.JLLIO.getText() + "','" + this.xJPOft_OjoExaDer1.JLLA.getText() + "','" + this.xJPOft_OjoExaDer1.JLBalance.getText() + "','" + this.xJPOft_OjoExaDer1.JLMEO.getText() + "','" + CastingBoolean(this.xJPOft_OjoExaDer1.JCHAspectoNormal.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaDer1.JCHEctropion.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaDer1.JCHEntropion.isSelected()) + "',        '" + OptionButton(this.xJPOft_OjoExaDer1.Superior) + "','" + OptionButton(this.xJPOft_OjoExaDer1.Inferior) + "','" + CastingBoolean(this.xJPOft_OjoExaDer1.JCHPTosis.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaDer1.JCHBlefaro.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaDer1.JCHDermato.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaDer1.JCHNormal.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaDer1.JCHTrisq.isSelected()) + "',        '" + CastingBoolean(this.xJPOft_OjoExaDer1.JCHDistriq.isSelected()) + "','" + this.xJPOft_OjoExaDer1.JTFOtros.getText() + "','" + CastingBoolean(this.xJPOft_OjoExaDer1.JCHNormocro.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaDer1.JCHPlaca.isSelected()) + "','" + OptionButton(this.xJPOft_OjoExaDer1.Hiperemia) + "','" + OptionButton(this.xJPOft_OjoExaDer1.Nasal) + "','" + OptionButton(this.xJPOft_OjoExaDer1.Temporal) + "','" + CastingBoolean(this.xJPOft_OjoExaDer1.JCHNasal.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaDer1.JCHTemp.isSelected()) + "',        '" + CastingBoolean(this.xJPOft_OjoExaDer1.JCHGeneral.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaDer1.JCHRPapilar.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaDer1.JCHRFTarsal.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaDer1.JCHQuemosis.isSelected()) + "','" + OptionButton(this.xJPOft_OjoExaDer1.Secrecion) + "','" + this.xJPOft_OjoExaDer1.JTFOtrosConj.getText() + "','" + CastingBoolean(this.xJPOft_OjoExaDer2.JCHTrasparente.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaDer2.JCHPliegues.isSelected()) + "',        '" + CastingBoolean(this.xJPOft_OjoExaDer2.JCHInflamacion.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaDer2.JCHDepSube.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaDer2.JCHCentral.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaDer2.JCHPeriferico.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaDer2.JCHGeneralizada.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaDer2.JCHMicroq.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaDer2.JCHEstronal.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaDer2.JCHGCarnero.isSelected()) + "',        '" + CastingBoolean(this.xJPOft_OjoExaDer2.JCHPigmentados.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaDer2.JCHUlCentral.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaDer2.JCHUlPeriferico.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaDer2.JCHCECentral.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaDer2.JCHCEPeriferico.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaDer2.JCHCESuperficial.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaDer2.JCHCEProfundo.isSelected()) + "','" + OptionButton(this.xJPOft_OjoExaDer2.CuerpoExtranio) + "','" + this.xJPOft_OjoExaDer2.JTFOtros.getText() + "',        '" + this.xJPOft_OjoExaDer2.JCBCamara.getSelectedItem() + "','" + this.xJPOft_OjoExaDer2.JCBCristalino.getSelectedItem() + "','" + CastingBoolean(this.xJPOft_OjoExaDer2.JCHNegraCentral.isSelected()) + "','" + this.xJPOft_OjoExaDer2.JCBNegra.getSelectedItem() + "','" + CastingBoolean(this.xJPOft_OjoExaDer2.JCHDiscordia.isSelected()) + "','" + this.xJPOft_OjoExaDer2.JTFAng1.getText() + "','" + this.xJPOft_OjoExaDer2.JTFAng2.getText() + "','" + this.xJPOft_OjoExaDer2.JTFAng3.getText() + "','" + this.xJPOft_OjoExaDer2.JTFAng4.getText() + "','" + this.xJPOft_OjoExaDer2.JTFOtrosCornea.getText() + "','" + OptionButton(this.xJPOft_OjoExaDer2.Capsula) + "','" + CastingBoolean(this.xJPOft_OjoExaDer2.JCHCamAnt.isSelected()) + "',        '" + CastingBoolean(this.xJPOft_OjoExaDer2.JCHSaco.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaDer2.JCHSulcus.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaDer2.JCHAtrapado.isSelected()) + "','" + this.xJPOft_OjoExaDer2.JTFPIO.getText() + "','" + CastingBoolean(this.xJPOft_OjoExaDer2.JCHCrisTrasparente.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaDer2.JCHCrisBlanco.isSelected()) + "','" + OptionButton(this.xJPOft_OjoExaDer2.Opacidad) + "','" + OptionButton(this.xJPOft_OjoExaDer2.Esclerosis) + "','" + CastingBoolean(this.xJPOft_OjoExaDer2.JCHOpaCueiforme.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaDer2.JCHOpaSutural.isSelected()) + "',        '" + CastingBoolean(this.xJPOft_OjoExaDer2.JCHOpaNuclear.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaDer2.JCHPolarPost.isSelected()) + "','" + this.xJPOft_OjoExaDer2.JTFOtrosCristalino.getText() + "','" + CastingBoolean(this.xJPOft_OjoExaDer3.JCHClaro.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaDer3.JCHTurbio.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaDer3.JCHDeposito.isSelected()) + "','" + OptionButton(this.xJPOft_OjoExaDer3.TInflamatorio) + "','" + OptionButton(this.xJPOft_OjoExaDer3.THemorragico) + "','" + this.xJPOft_OjoExaDer3.JTFPapilas.getText() + "',        '" + OptionButton(this.xJPOft_OjoExaDer3.Excavacion) + "','" + OptionButton(this.xJPOft_OjoExaDer3.Vasos) + "','" + OptionButton(this.xJPOft_OjoExaDer3.Retina) + "','" + CastingBoolean(this.xJPOft_OjoExaDer3.JCHMemEpi.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaDer3.JCHDisforme.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaDer3.JCHSana.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaDer3.JCHPigmetacion.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaDer3.JCHNeovascular.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaDer3.JCHCicatriz.isSelected()) + "',        '" + CastingBoolean(this.xJPOft_OjoExaDer3.JCHFoco.isSelected()) + "','" + this.xJPOft_OjoExaDer3.JTAPeriferia.getText() + "','" + this.xJPOft_OjoExaDer3.JTAObservaciones.getText() + "','" + Principal.usuarioSistemaDTO.getLogin() + "');";
                this.xct.ejecutarSQL(sqlDer);
                this.xct.cerrarConexionBd();
                String sqlIzq = "INSERT INTO  `h_oftamologia_ojo_izq`            (`IdOfta`,`SC`,`CC`,`Esfera`,`Cilindro`,`Eje`,`K1`,`K2`,`LIO`,`LA`,`Balance`,`MEO`,`AspNormal`,`Ectropion`,             `Entropion`,`Superior`,`Inferior`,`PTosis`,`Blefaro`,`Dermato`,             `PestNormal`,`Triquiasis`,`Distriquiasis`,`OtrosParpa`,`Normocronica`,`Placa`,`Hiperemia`,`EspNasal`,             `EspTemporal`,`HemNasal`,`HemTemporal`,`HemGeneralizada`,`RxPapilar`,`RxFolicular`,`Quemosis`,`Secrecion`,             `OtrosConjuntiva`,`CornTrasp`,`Pliegues`,`InflamLocal`,`SubEpiteliales`,`EdemaCentral`,`EdePeriferico`,`EdeGeneralizada`,             `Microquistico`,`Estronal`,`GCarnero`,`Pigmentados`,`UlceraCentral`,`UlceraPeriferico`,`CECentral`,CEPeriferico, `CESuperficial`,             `CEProfundo`,`CETipo`,`OtrosCornea`,`Camara`,`Cristalino`,`Negra`,Numero,`Discordia`,`Ang1`,`Ang2`,`Ang3`,`Ang4`,             `OtrosAngulo`,`Capsula`,`CamaraAnt`,`Saco`,`Sulcus`,`Atrapado`,`PIO`,`CristTrasparente`,`CristBlanco`,`OCapsular`,             `EscNuclear`,`OpaCueniforme`,`OpaSutural`,`OpaNucCongenita`,`PolarPost`,`OtrosLentesIntr`,`VClaro`,`VTurbio`,`DepVirregente`,             `TyInflam`,`TyHemor`,`Papilas`,`Excavacion`,`Vasos`,`PoloPost`,`Epiretinal`,`Disforme`,`MacSana`,             `CamPigmentacion`,`Neovascular`,`Cicatriz`,`FocoCoro`,`Periferia`,ObservacionVit,`UsuarioS`)  VALUES ('" + this.xOftamologia + "','" + this.xJPOft_OjoExaIzq1.JLSC.getText() + "','" + this.xJPOft_OjoExaIzq1.JLCC.getText() + "','" + this.xJPOft_OjoExaIzq1.JLEsfera.getText() + "','" + this.xJPOft_OjoExaIzq1.JLCilindro.getText() + "','" + this.xJPOft_OjoExaIzq1.JLEje.getText() + "','" + this.xJPOft_OjoExaIzq1.JLK1.getText() + "','" + this.xJPOft_OjoExaIzq1.JLK2.getText() + "','" + this.xJPOft_OjoExaIzq1.JLLIO.getText() + "','" + this.xJPOft_OjoExaIzq1.JLLA.getText() + "','" + this.xJPOft_OjoExaIzq1.JLBalance.getText() + "','" + this.xJPOft_OjoExaIzq1.JLMEO.getText() + "','" + CastingBoolean(this.xJPOft_OjoExaIzq1.JCHAspectoNormal.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaIzq1.JCHEctropion.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaIzq1.JCHEntropion.isSelected()) + "',        '" + OptionButton(this.xJPOft_OjoExaIzq1.Superior) + "','" + OptionButton(this.xJPOft_OjoExaIzq1.Inferior) + "','" + CastingBoolean(this.xJPOft_OjoExaIzq1.JCHPTosis.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaIzq1.JCHBlefaro.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaIzq1.JCHDermato.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaIzq1.JCHNormal.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaIzq1.JCHTrisq.isSelected()) + "',        '" + CastingBoolean(this.xJPOft_OjoExaIzq1.JCHDistriq.isSelected()) + "','" + this.xJPOft_OjoExaIzq1.JTFOtros.getText() + "','" + CastingBoolean(this.xJPOft_OjoExaIzq1.JCHNormocro.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaIzq1.JCHPlaca.isSelected()) + "','" + OptionButton(this.xJPOft_OjoExaIzq1.Hiperemia) + "','" + OptionButton(this.xJPOft_OjoExaIzq1.Nasal) + "','" + OptionButton(this.xJPOft_OjoExaIzq1.Temporal) + "','" + CastingBoolean(this.xJPOft_OjoExaIzq1.JCHNasal.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaIzq1.JCHTemp.isSelected()) + "',        '" + CastingBoolean(this.xJPOft_OjoExaIzq1.JCHGeneral.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaIzq1.JCHRPapilar.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaIzq1.JCHRFTarsal.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaIzq1.JCHQuemosis.isSelected()) + "','" + OptionButton(this.xJPOft_OjoExaIzq1.Secrecion) + "','" + this.xJPOft_OjoExaIzq1.JTFOtrosConj.getText() + "','" + CastingBoolean(this.xJPOft_OjoExaIzq2.JCHTrasparente.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaIzq2.JCHPliegues.isSelected()) + "',        '" + CastingBoolean(this.xJPOft_OjoExaIzq2.JCHInflamacion.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaIzq2.JCHDepSube.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaIzq2.JCHCentral.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaIzq2.JCHPeriferico.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaIzq2.JCHGeneralizada.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaIzq2.JCHMicroq.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaIzq2.JCHEstronal.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaIzq2.JCHGCarnero.isSelected()) + "',        '" + CastingBoolean(this.xJPOft_OjoExaIzq2.JCHPigmentados.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaIzq2.JCHUlCentral.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaIzq2.JCHUlPeriferico.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaIzq2.JCHCECentral.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaIzq2.JCHCEPeriferico.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaIzq2.JCHCESuperficial.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaIzq2.JCHCEProfundo.isSelected()) + "','" + OptionButton(this.xJPOft_OjoExaIzq2.CuerpoExtranio) + "','" + this.xJPOft_OjoExaIzq2.JTFOtros.getText() + "',        '" + this.xJPOft_OjoExaIzq2.JCBCamara.getSelectedItem() + "','" + this.xJPOft_OjoExaIzq2.JCBCristalino.getSelectedItem() + "','" + CastingBoolean(this.xJPOft_OjoExaIzq2.JCHNegraCentral.isSelected()) + "','" + this.xJPOft_OjoExaIzq2.JCBNegra.getSelectedItem() + "','" + CastingBoolean(this.xJPOft_OjoExaIzq2.JCHDiscordia.isSelected()) + "','" + this.xJPOft_OjoExaIzq2.JTFAng1.getText() + "','" + this.xJPOft_OjoExaIzq2.JTFAng2.getText() + "','" + this.xJPOft_OjoExaIzq2.JTFAng3.getText() + "','" + this.xJPOft_OjoExaIzq2.JTFAng4.getText() + "','" + this.xJPOft_OjoExaIzq2.JTFOtrosCornea.getText() + "','" + OptionButton(this.xJPOft_OjoExaIzq2.Capsula) + "','" + CastingBoolean(this.xJPOft_OjoExaIzq2.JCHCamAnt.isSelected()) + "',        '" + CastingBoolean(this.xJPOft_OjoExaIzq2.JCHSaco.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaIzq2.JCHSulcus.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaIzq2.JCHAtrapado.isSelected()) + "','" + this.xJPOft_OjoExaIzq2.JTFPIO.getText() + "','" + CastingBoolean(this.xJPOft_OjoExaIzq2.JCHCrisTrasparente.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaIzq2.JCHCrisBlanco.isSelected()) + "','" + OptionButton(this.xJPOft_OjoExaIzq2.Opacidad) + "','" + OptionButton(this.xJPOft_OjoExaIzq2.Esclerosis) + "','" + CastingBoolean(this.xJPOft_OjoExaIzq2.JCHOpaCueiforme.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaIzq2.JCHOpaSutural.isSelected()) + "',        '" + CastingBoolean(this.xJPOft_OjoExaIzq2.JCHOpaNuclear.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaIzq2.JCHPolarPost.isSelected()) + "','" + this.xJPOft_OjoExaIzq2.JTFOtrosCristalino.getText() + "','" + CastingBoolean(this.xJPOft_OjoExaIzq3.JCHClaro.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaIzq3.JCHTurbio.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaIzq3.JCHDeposito.isSelected()) + "','" + OptionButton(this.xJPOft_OjoExaIzq3.TInflamatorio) + "','" + OptionButton(this.xJPOft_OjoExaIzq3.THemorragico) + "','" + this.xJPOft_OjoExaIzq3.JTFPapilas.getText() + "',        '" + OptionButton(this.xJPOft_OjoExaIzq3.Excavacion) + "','" + OptionButton(this.xJPOft_OjoExaIzq3.Vasos) + "','" + OptionButton(this.xJPOft_OjoExaIzq3.Retina) + "','" + CastingBoolean(this.xJPOft_OjoExaIzq3.JCHMemEpi.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaIzq3.JCHDisforme.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaIzq3.JCHSana.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaIzq3.JCHPigmetacion.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaIzq3.JCHNeovascular.isSelected()) + "','" + CastingBoolean(this.xJPOft_OjoExaIzq3.JCHCicatriz.isSelected()) + "',        '" + CastingBoolean(this.xJPOft_OjoExaIzq3.JCHFoco.isSelected()) + "','" + this.xJPOft_OjoExaIzq3.JTAPeriferia.getText() + "','" + this.xJPOft_OjoExaIzq3.JTAObservaciones.getText() + "','" + Principal.usuarioSistemaDTO.getLogin() + "');";
                this.xct.ejecutarSQL(sqlIzq);
                this.xct.cerrarConexionBd();
                mBuscaHistorico();
                this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
                return;
            }
            return;
        }
        int n2 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de Actualizar la Información?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n2 == 0) {
            String sqlDer2 = "UPDATE `h_oftamologia_ojo_der`SET `SC` = '" + this.xJPOft_OjoExaDer1.JLSC.getText() + "',`CC` = '" + this.xJPOft_OjoExaDer1.JLCC.getText() + "',`Esfera` = '" + this.xJPOft_OjoExaDer1.JLEsfera.getText() + "',`Cilindro` = '" + this.xJPOft_OjoExaDer1.JLCilindro.getText() + "',`Eje` = '" + this.xJPOft_OjoExaDer1.JLEje.getText() + "',`K1` = '" + this.xJPOft_OjoExaDer1.JLK1.getText() + "',  `K2` = '" + this.xJPOft_OjoExaDer1.JLK2.getText() + "',`LIO` = '" + this.xJPOft_OjoExaDer1.JLLIO.getText() + "',`LA` = '" + this.xJPOft_OjoExaDer1.JLLA.getText() + "',`Balance` = '" + this.xJPOft_OjoExaDer1.JLBalance.getText() + "',`MEO` = '" + this.xJPOft_OjoExaDer1.JLMEO.getText() + "',`AspNormal` = '" + CastingBoolean(this.xJPOft_OjoExaDer1.JCHAspectoNormal.isSelected()) + "',  `Ectropion` = '" + CastingBoolean(this.xJPOft_OjoExaDer1.JCHEctropion.isSelected()) + "',`Entropion` = '" + CastingBoolean(this.xJPOft_OjoExaDer1.JCHEntropion.isSelected()) + "',`Superior` = '" + OptionButton(this.xJPOft_OjoExaDer1.Superior) + "',`Inferior` = '" + OptionButton(this.xJPOft_OjoExaDer1.Inferior) + "',`PTosis` = '" + CastingBoolean(this.xJPOft_OjoExaDer1.JCHPTosis.isSelected()) + "',  `Blefaro` = '" + CastingBoolean(this.xJPOft_OjoExaDer1.JCHBlefaro.isSelected()) + "',`Dermato` = '" + CastingBoolean(this.xJPOft_OjoExaDer1.JCHDermato.isSelected()) + "',`PestNormal` = '" + CastingBoolean(this.xJPOft_OjoExaDer1.JCHNormal.isSelected()) + "',`Triquiasis` = '" + CastingBoolean(this.xJPOft_OjoExaDer1.JCHTrisq.isSelected()) + "',`Distriquiasis` = '" + CastingBoolean(this.xJPOft_OjoExaDer1.JCHDistriq.isSelected()) + "',  `OtrosParpa` = '" + this.xJPOft_OjoExaDer1.JTFOtros.getText() + "',`Normocronica` = '" + CastingBoolean(this.xJPOft_OjoExaDer1.JCHNormocro.isSelected()) + "',`Placa` = '" + CastingBoolean(this.xJPOft_OjoExaDer1.JCHPlaca.isSelected()) + "',`Hiperemia` = '" + OptionButton(this.xJPOft_OjoExaDer1.Hiperemia) + "',`EspNasal` = '" + OptionButton(this.xJPOft_OjoExaDer1.Nasal) + "',  `EspTemporal` = '" + OptionButton(this.xJPOft_OjoExaDer1.Temporal) + "',`HemNasal` = '" + CastingBoolean(this.xJPOft_OjoExaDer1.JCHNasal.isSelected()) + "',`HemTemporal` = '" + CastingBoolean(this.xJPOft_OjoExaDer1.JCHTemp.isSelected()) + "',`HemGeneralizada` = '" + CastingBoolean(this.xJPOft_OjoExaDer1.JCHGeneral.isSelected()) + "',  `RxPapilar` = '" + CastingBoolean(this.xJPOft_OjoExaDer1.JCHRPapilar.isSelected()) + "',`RxFolicular` = '" + CastingBoolean(this.xJPOft_OjoExaDer1.JCHRFTarsal.isSelected()) + "',`Quemosis` = '" + CastingBoolean(this.xJPOft_OjoExaDer1.JCHQuemosis.isSelected()) + "',`Secrecion` = '" + OptionButton(this.xJPOft_OjoExaDer1.Secrecion) + "',  `OtrosConjuntiva` = '" + this.xJPOft_OjoExaDer1.JTFOtrosConj.getText() + "',`CornTrasp` = '" + CastingBoolean(this.xJPOft_OjoExaDer2.JCHTrasparente.isSelected()) + "',`Pliegues` = '" + CastingBoolean(this.xJPOft_OjoExaDer2.JCHPliegues.isSelected()) + "',`InflamLocal` = '" + CastingBoolean(this.xJPOft_OjoExaDer2.JCHInflamacion.isSelected()) + "',  `SubEpiteliales` = '" + CastingBoolean(this.xJPOft_OjoExaDer2.JCHDepSube.isSelected()) + "',`EdemaCentral` = '" + CastingBoolean(this.xJPOft_OjoExaDer2.JCHCentral.isSelected()) + "',`EdePeriferico` = '" + CastingBoolean(this.xJPOft_OjoExaDer2.JCHPeriferico.isSelected()) + "',`EdeGeneralizada` = '" + CastingBoolean(this.xJPOft_OjoExaDer2.JCHGeneralizada.isSelected()) + "',  `Microquistico` = '" + CastingBoolean(this.xJPOft_OjoExaDer2.JCHMicroq.isSelected()) + "',`Estronal` = '" + CastingBoolean(this.xJPOft_OjoExaDer2.JCHEstronal.isSelected()) + "',`GCarnero` = '" + CastingBoolean(this.xJPOft_OjoExaDer2.JCHGCarnero.isSelected()) + "',`Pigmentados` = '" + CastingBoolean(this.xJPOft_OjoExaDer2.JCHPigmentados.isSelected()) + "',`UlceraCentral` = '" + CastingBoolean(this.xJPOft_OjoExaDer2.JCHUlCentral.isSelected()) + "',  `UlceraPeriferico` = '" + CastingBoolean(this.xJPOft_OjoExaDer2.JCHUlPeriferico.isSelected()) + "',`CECentral` = '" + CastingBoolean(this.xJPOft_OjoExaDer2.JCHCECentral.isSelected()) + "',`CEPeriferico` = '" + CastingBoolean(this.xJPOft_OjoExaDer2.JCHCEPeriferico.isSelected()) + "',`CESuperficial` = '" + CastingBoolean(this.xJPOft_OjoExaDer2.JCHCESuperficial.isSelected()) + "',  `CEProfundo` = '" + CastingBoolean(this.xJPOft_OjoExaDer2.JCHCEProfundo.isSelected()) + "',`CETipo` = '" + OptionButton(this.xJPOft_OjoExaDer2.CuerpoExtranio) + "',`OtrosCornea` = '" + this.xJPOft_OjoExaDer2.JTFOtros.getText() + "',`Camara` = '" + this.xJPOft_OjoExaDer2.JCBCamara.getSelectedItem() + "',`Cristalino` = '" + this.xJPOft_OjoExaDer2.JCBCristalino.getSelectedItem() + "',  `Negra` = '" + CastingBoolean(this.xJPOft_OjoExaDer2.JCHNegraCentral.isSelected()) + "',`Numero` = '" + this.xJPOft_OjoExaDer2.JCBNegra.getSelectedItem() + "',`Discordia` = '" + CastingBoolean(this.xJPOft_OjoExaDer2.JCHDiscordia.isSelected()) + "',`Ang1` = '" + this.xJPOft_OjoExaDer2.JTFAng1.getText() + "',`Ang2` = '" + this.xJPOft_OjoExaDer2.JTFAng2.getText() + "',`Ang3` = '" + this.xJPOft_OjoExaDer2.JTFAng3.getText() + "',  `Ang4` = '" + this.xJPOft_OjoExaDer2.JTFAng4.getText() + "',`OtrosAngulo` = '" + this.xJPOft_OjoExaDer2.JTFOtrosCornea.getText() + "',`Capsula` = '" + OptionButton(this.xJPOft_OjoExaDer2.Capsula) + "',`CamaraAnt` = '" + CastingBoolean(this.xJPOft_OjoExaDer2.JCHCamAnt.isSelected()) + "',`Saco` = '" + CastingBoolean(this.xJPOft_OjoExaDer2.JCHSaco.isSelected()) + "',  `Sulcus` = '" + CastingBoolean(this.xJPOft_OjoExaDer2.JCHSulcus.isSelected()) + "',`Atrapado` = '" + CastingBoolean(this.xJPOft_OjoExaDer2.JCHAtrapado.isSelected()) + "',`PIO` = '" + this.xJPOft_OjoExaDer2.JTFPIO.getText() + "',`CristTrasparente` = '" + CastingBoolean(this.xJPOft_OjoExaDer2.JCHCrisTrasparente.isSelected()) + "',`CristBlanco` = '" + CastingBoolean(this.xJPOft_OjoExaDer2.JCHCrisBlanco.isSelected()) + "',  `OCapsular` = '" + OptionButton(this.xJPOft_OjoExaDer2.Opacidad) + "',`EscNuclear` = '" + OptionButton(this.xJPOft_OjoExaDer2.Esclerosis) + "',`OpaCueniforme` = '" + CastingBoolean(this.xJPOft_OjoExaDer2.JCHOpaCueiforme.isSelected()) + "',`OpaSutural` = '" + CastingBoolean(this.xJPOft_OjoExaDer2.JCHOpaSutural.isSelected()) + "',`OpaNucCongenita` = '" + CastingBoolean(this.xJPOft_OjoExaDer2.JCHOpaNuclear.isSelected()) + "',  `PolarPost` = '" + CastingBoolean(this.xJPOft_OjoExaDer2.JCHPolarPost.isSelected()) + "',`OtrosLentesIntr` = '" + this.xJPOft_OjoExaDer2.JTFOtrosCristalino.getText() + "',`VClaro` = '" + CastingBoolean(this.xJPOft_OjoExaDer3.JCHClaro.isSelected()) + "',`VTurbio` = '" + CastingBoolean(this.xJPOft_OjoExaDer3.JCHTurbio.isSelected()) + "',`DepVirregente` = '" + CastingBoolean(this.xJPOft_OjoExaDer3.JCHDeposito.isSelected()) + "',  `TyInflam` = '" + OptionButton(this.xJPOft_OjoExaDer3.TInflamatorio) + "',`TyHemor` = '" + OptionButton(this.xJPOft_OjoExaDer3.THemorragico) + "',`Papilas` = '" + this.xJPOft_OjoExaDer3.JTFPapilas.getText() + "',`Excavacion` = '" + OptionButton(this.xJPOft_OjoExaDer3.Excavacion) + "',`Vasos` = '" + OptionButton(this.xJPOft_OjoExaDer3.Vasos) + "',`PoloPost` = '" + OptionButton(this.xJPOft_OjoExaDer3.Retina) + "',  `Epiretinal` = '" + CastingBoolean(this.xJPOft_OjoExaDer3.JCHMemEpi.isSelected()) + "',`Disforme` = '" + CastingBoolean(this.xJPOft_OjoExaDer3.JCHDisforme.isSelected()) + "',`MacSana` = '" + CastingBoolean(this.xJPOft_OjoExaDer3.JCHSana.isSelected()) + "',`CamPigmentacion` = '" + CastingBoolean(this.xJPOft_OjoExaDer3.JCHPigmetacion.isSelected()) + "',`Neovascular` = '" + CastingBoolean(this.xJPOft_OjoExaDer3.JCHNeovascular.isSelected()) + "',  `Cicatriz` = '" + CastingBoolean(this.xJPOft_OjoExaDer3.JCHCicatriz.isSelected()) + "',`FocoCoro` = '" + CastingBoolean(this.xJPOft_OjoExaDer3.JCHFoco.isSelected()) + "',`Periferia` = '" + this.xJPOft_OjoExaDer3.JTAPeriferia.getText() + "',`ObservacionVit` = '" + this.xJPOft_OjoExaDer3.JTAObservaciones.getText() + "',`UsuarioS` = '" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE `IdOfta` = '" + this.xOftamologia + "'";
            this.xct.ejecutarSQL(sqlDer2);
            this.xct.cerrarConexionBd();
            String sqlIzq2 = "UPDATE  .`h_oftamologia_ojo_izq`SET `SC` = '" + this.xJPOft_OjoExaIzq1.JLSC.getText() + "',`CC` = '" + this.xJPOft_OjoExaIzq1.JLCC.getText() + "',`Esfera` = '" + this.xJPOft_OjoExaIzq1.JLEsfera.getText() + "',`Cilindro` = '" + this.xJPOft_OjoExaIzq1.JLCilindro.getText() + "',`Eje` = '" + this.xJPOft_OjoExaIzq1.JLEje.getText() + "',`K1` = '" + this.xJPOft_OjoExaIzq1.JLK1.getText() + "',  `K2` = '" + this.xJPOft_OjoExaIzq1.JLK2.getText() + "',`LIO` = '" + this.xJPOft_OjoExaIzq1.JLLIO.getText() + "',`LA` = '" + this.xJPOft_OjoExaIzq1.JLLA.getText() + "',`Balance` = '" + this.xJPOft_OjoExaIzq1.JLBalance.getText() + "',`MEO` = '" + this.xJPOft_OjoExaIzq1.JLMEO.getText() + "',`AspNormal` = '" + CastingBoolean(this.xJPOft_OjoExaIzq1.JCHAspectoNormal.isSelected()) + "',  `Ectropion` = '" + CastingBoolean(this.xJPOft_OjoExaIzq1.JCHEctropion.isSelected()) + "',`Entropion` = '" + CastingBoolean(this.xJPOft_OjoExaIzq1.JCHEntropion.isSelected()) + "',`Superior` = '" + OptionButton(this.xJPOft_OjoExaIzq1.Superior) + "',`Inferior` = '" + OptionButton(this.xJPOft_OjoExaIzq1.Inferior) + "',`PTosis` = '" + CastingBoolean(this.xJPOft_OjoExaIzq1.JCHPTosis.isSelected()) + "',  `Blefaro` = '" + CastingBoolean(this.xJPOft_OjoExaIzq1.JCHBlefaro.isSelected()) + "',`Dermato` = '" + CastingBoolean(this.xJPOft_OjoExaIzq1.JCHDermato.isSelected()) + "',`PestNormal` = '" + CastingBoolean(this.xJPOft_OjoExaIzq1.JCHNormal.isSelected()) + "',`Triquiasis` = '" + CastingBoolean(this.xJPOft_OjoExaIzq1.JCHTrisq.isSelected()) + "',`Distriquiasis` = '" + CastingBoolean(this.xJPOft_OjoExaIzq1.JCHDistriq.isSelected()) + "',  `OtrosParpa` = '" + this.xJPOft_OjoExaIzq1.JTFOtros.getText() + "',`Normocronica` = '" + CastingBoolean(this.xJPOft_OjoExaIzq1.JCHNormocro.isSelected()) + "',`Placa` = '" + CastingBoolean(this.xJPOft_OjoExaIzq1.JCHPlaca.isSelected()) + "',`Hiperemia` = '" + OptionButton(this.xJPOft_OjoExaIzq1.Hiperemia) + "',`EspNasal` = '" + OptionButton(this.xJPOft_OjoExaIzq1.Nasal) + "',  `EspTemporal` = '" + OptionButton(this.xJPOft_OjoExaIzq1.Temporal) + "',`HemNasal` = '" + CastingBoolean(this.xJPOft_OjoExaIzq1.JCHNasal.isSelected()) + "',`HemTemporal` = '" + CastingBoolean(this.xJPOft_OjoExaIzq1.JCHTemp.isSelected()) + "',`HemGeneralizada` = '" + CastingBoolean(this.xJPOft_OjoExaIzq1.JCHGeneral.isSelected()) + "',  `RxPapilar` = '" + CastingBoolean(this.xJPOft_OjoExaIzq1.JCHRPapilar.isSelected()) + "',`RxFolicular` = '" + CastingBoolean(this.xJPOft_OjoExaIzq1.JCHRFTarsal.isSelected()) + "',`Quemosis` = '" + CastingBoolean(this.xJPOft_OjoExaIzq1.JCHQuemosis.isSelected()) + "',`Secrecion` = '" + OptionButton(this.xJPOft_OjoExaIzq1.Secrecion) + "',  `OtrosConjuntiva` = '" + this.xJPOft_OjoExaIzq1.JTFOtrosConj.getText() + "',`CornTrasp` = '" + CastingBoolean(this.xJPOft_OjoExaIzq2.JCHTrasparente.isSelected()) + "',`Pliegues` = '" + CastingBoolean(this.xJPOft_OjoExaIzq2.JCHPliegues.isSelected()) + "',`InflamLocal` = '" + CastingBoolean(this.xJPOft_OjoExaIzq2.JCHInflamacion.isSelected()) + "',  `SubEpiteliales` = '" + CastingBoolean(this.xJPOft_OjoExaIzq2.JCHDepSube.isSelected()) + "',`EdemaCentral` = '" + CastingBoolean(this.xJPOft_OjoExaIzq2.JCHCentral.isSelected()) + "',`EdePeriferico` = '" + CastingBoolean(this.xJPOft_OjoExaIzq2.JCHPeriferico.isSelected()) + "',`EdeGeneralizada` = '" + CastingBoolean(this.xJPOft_OjoExaIzq2.JCHGeneralizada.isSelected()) + "',  `Microquistico` = '" + CastingBoolean(this.xJPOft_OjoExaIzq2.JCHMicroq.isSelected()) + "',`Estronal` = '" + CastingBoolean(this.xJPOft_OjoExaIzq2.JCHEstronal.isSelected()) + "',`GCarnero` = '" + CastingBoolean(this.xJPOft_OjoExaIzq2.JCHGCarnero.isSelected()) + "',`Pigmentados` = '" + CastingBoolean(this.xJPOft_OjoExaIzq2.JCHPigmentados.isSelected()) + "',`UlceraCentral` = '" + CastingBoolean(this.xJPOft_OjoExaIzq2.JCHUlCentral.isSelected()) + "',  `UlceraPeriferico` = '" + CastingBoolean(this.xJPOft_OjoExaIzq2.JCHUlPeriferico.isSelected()) + "',`CECentral` = '" + CastingBoolean(this.xJPOft_OjoExaIzq2.JCHCECentral.isSelected()) + "',`CEPeriferico` = '" + CastingBoolean(this.xJPOft_OjoExaIzq2.JCHCEPeriferico.isSelected()) + "',`CESuperficial` = '" + CastingBoolean(this.xJPOft_OjoExaIzq2.JCHCESuperficial.isSelected()) + "',  `CEProfundo` = '" + CastingBoolean(this.xJPOft_OjoExaIzq2.JCHCEProfundo.isSelected()) + "',`CETipo` = '" + OptionButton(this.xJPOft_OjoExaIzq2.CuerpoExtranio) + "',`OtrosCornea` = '" + this.xJPOft_OjoExaIzq2.JTFOtros.getText() + "',`Camara` = '" + this.xJPOft_OjoExaIzq2.JCBCamara.getSelectedItem() + "',`Cristalino` = '" + this.xJPOft_OjoExaIzq2.JCBCristalino.getSelectedItem() + "',  `Negra` = '" + CastingBoolean(this.xJPOft_OjoExaIzq2.JCHNegraCentral.isSelected()) + "',`Numero` = '" + this.xJPOft_OjoExaIzq2.JCBNegra.getSelectedItem() + "',`Discordia` = '" + CastingBoolean(this.xJPOft_OjoExaIzq2.JCHDiscordia.isSelected()) + "',`Ang1` = '" + this.xJPOft_OjoExaIzq2.JTFAng1.getText() + "',`Ang2` = '" + this.xJPOft_OjoExaIzq2.JTFAng2.getText() + "',`Ang3` = '" + this.xJPOft_OjoExaIzq2.JTFAng3.getText() + "',  `Ang4` = '" + this.xJPOft_OjoExaIzq2.JTFAng4.getText() + "',`OtrosAngulo` = '" + this.xJPOft_OjoExaIzq2.JTFOtrosCornea.getText() + "',`Capsula` = '" + OptionButton(this.xJPOft_OjoExaIzq2.Capsula) + "',`CamaraAnt` = '" + CastingBoolean(this.xJPOft_OjoExaIzq2.JCHCamAnt.isSelected()) + "',`Saco` = '" + CastingBoolean(this.xJPOft_OjoExaIzq2.JCHSaco.isSelected()) + "',  `Sulcus` = '" + CastingBoolean(this.xJPOft_OjoExaIzq2.JCHSulcus.isSelected()) + "',`Atrapado` = '" + CastingBoolean(this.xJPOft_OjoExaIzq2.JCHAtrapado.isSelected()) + "',`PIO` = '" + this.xJPOft_OjoExaIzq2.JTFPIO.getText() + "',`CristTrasparente` = '" + CastingBoolean(this.xJPOft_OjoExaIzq2.JCHCrisTrasparente.isSelected()) + "',`CristBlanco` = '" + CastingBoolean(this.xJPOft_OjoExaIzq2.JCHCrisBlanco.isSelected()) + "',  `OCapsular` = '" + OptionButton(this.xJPOft_OjoExaIzq2.Opacidad) + "',`EscNuclear` = '" + OptionButton(this.xJPOft_OjoExaIzq2.Esclerosis) + "',`OpaCueniforme` = '" + CastingBoolean(this.xJPOft_OjoExaIzq2.JCHOpaCueiforme.isSelected()) + "',`OpaSutural` = '" + CastingBoolean(this.xJPOft_OjoExaIzq2.JCHOpaSutural.isSelected()) + "',`OpaNucCongenita` = '" + CastingBoolean(this.xJPOft_OjoExaIzq2.JCHOpaNuclear.isSelected()) + "',  `PolarPost` = '" + CastingBoolean(this.xJPOft_OjoExaIzq2.JCHPolarPost.isSelected()) + "',`OtrosLentesIntr` = '" + this.xJPOft_OjoExaIzq2.JTFOtrosCristalino.getText() + "',`VClaro` = '" + CastingBoolean(this.xJPOft_OjoExaIzq3.JCHClaro.isSelected()) + "',`VTurbio` = '" + CastingBoolean(this.xJPOft_OjoExaIzq3.JCHTurbio.isSelected()) + "',`DepVirregente` = '" + CastingBoolean(this.xJPOft_OjoExaIzq3.JCHDeposito.isSelected()) + "',  `TyInflam` = '" + OptionButton(this.xJPOft_OjoExaIzq3.TInflamatorio) + "',`TyHemor` = '" + OptionButton(this.xJPOft_OjoExaIzq3.THemorragico) + "',`Papilas` = '" + this.xJPOft_OjoExaIzq3.JTFPapilas.getText() + "',`Excavacion` = '" + OptionButton(this.xJPOft_OjoExaIzq3.Excavacion) + "',`Vasos` = '" + OptionButton(this.xJPOft_OjoExaIzq3.Vasos) + "',`PoloPost` = '" + OptionButton(this.xJPOft_OjoExaIzq3.Retina) + "',  `Epiretinal` = '" + CastingBoolean(this.xJPOft_OjoExaIzq3.JCHMemEpi.isSelected()) + "',`Disforme` = '" + CastingBoolean(this.xJPOft_OjoExaIzq3.JCHDisforme.isSelected()) + "',`MacSana` = '" + CastingBoolean(this.xJPOft_OjoExaIzq3.JCHSana.isSelected()) + "',`CamPigmentacion` = '" + CastingBoolean(this.xJPOft_OjoExaIzq3.JCHPigmetacion.isSelected()) + "',`Neovascular` = '" + CastingBoolean(this.xJPOft_OjoExaIzq3.JCHNeovascular.isSelected()) + "',  `Cicatriz` = '" + CastingBoolean(this.xJPOft_OjoExaIzq3.JCHCicatriz.isSelected()) + "',`FocoCoro` = '" + CastingBoolean(this.xJPOft_OjoExaIzq3.JCHFoco.isSelected()) + "',`Periferia` = '" + this.xJPOft_OjoExaIzq3.JTAPeriferia.getText() + "',`ObservacionVit` = '" + this.xJPOft_OjoExaIzq3.JTAObservaciones.getText() + "',`UsuarioS` = '" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE `IdOfta` = '" + this.xOftamologia + "'";
            this.xct.ejecutarSQL(sqlIzq2);
            this.xct.cerrarConexionBd();
            this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
        }
    }

    private boolean mVerifica() {
        boolean xExiste = false;
        String sql = "SELECT `Id`, MAX(FechaR) ,`IdAtencion` FROM  `h_oftamologia` WHERE (`IdUsuario` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "'  AND `Estado` =1);";
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                xExiste = true;
                this.xOftamologia = xrs.getString("Id");
                this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPOftamologiaGen.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xExiste;
    }

    private boolean mVerifica2() {
        boolean xExiste = false;
        String sql = "SELECT `Id`, `IdAtencion` FROM  `h_oftamologia` WHERE (`IdUsuario` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "'  AND `Estado` =1 AND IdAtencion='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "');";
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                xExiste = true;
                this.xOftamologia = xrs.getString("Id");
                this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPOftamologiaGen.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xExiste;
    }

    private int CastingBoolean(boolean x) {
        return x ? 1 : 0;
    }

    private String OptionButton(ButtonGroup buttonGroup1) {
        String xValor = "0";
        Enumeration e = buttonGroup1.getElements();
        while (e.hasMoreElements()) {
            JRadioButton r = (JRadioButton) e.nextElement();
            if (r.isSelected()) {
                xValor = r.getName();
            }
        }
        return xValor;
    }

    private void selectCheck(String xValor, JCheckBox xCheck) {
        if (xValor.equals("0")) {
            xCheck.setSelected(false);
        } else {
            xCheck.setSelected(true);
        }
    }

    private void selectButton(String xValor, ButtonGroup buttonGroup1) {
        Enumeration e = buttonGroup1.getElements();
        while (e.hasMoreElements()) {
            JRadioButton r = (JRadioButton) e.nextElement();
            if (r.getName().equals(xValor)) {
                r.setSelected(true);
                return;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Profesional", "Especialidad"}) { // from class: Historia.JPOftamologiaGen.7
            Class[] types = {String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistorico.setModel(this.xmodelo);
        this.JTHistorico.getColumnModel().getColumn(0).setPreferredWidth(15);
        this.JTHistorico.getColumnModel().getColumn(1).setPreferredWidth(15);
        this.JTHistorico.getColumnModel().getColumn(2).setPreferredWidth(15);
        this.JTHistorico.getColumnModel().getColumn(3).setPreferredWidth(15);
    }

    private void mBuscaHistorico() {
        String sql = "SELECT `h_oftamologia`.`Id`, `h_oftamologia`.`FechaR`, `profesional1`.`NProfesional`, `profesional1`.`Especialidad`   FROM `h_oftamologia`INNER JOIN `profesional1` ON (`h_oftamologia`.`IdProfesional` = `profesional1`.`Id_Persona`) AND (`h_oftamologia`.`IdEspecialidad` = `profesional1`.`IdEspecialidad`)   WHERE (`h_oftamologia`.`IdUsuario` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' AND `h_oftamologia`.`Estado` =1) ORDER BY `h_oftamologia`.`FechaR` DESC";
        try {
            mCrearModeloDatos();
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPOftamologiaGen.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargaControlesDer(String xOft) {
        String sql = "SELECT `SC`,`CC`,`Esfera`,`Cilindro`,`Eje`,`K1`,`K2`,`LIO`,`LA`,`Balance`,`MEO`,`AspNormal`,`Ectropion`,`Entropion`,    `Superior`,`Inferior`,`PTosis`,`Blefaro`,`Dermato`,`PestNormal`,`Triquiasis`,`Distriquiasis`,`OtrosParpa`,`Normocronica`,`Placa`,    `Hiperemia`,`EspNasal`,`EspTemporal`,`HemNasal`,`HemTemporal`,`HemGeneralizada`,`RxPapilar`,`RxFolicular`,`Quemosis`,`Secrecion`,    `OtrosConjuntiva`,`CornTrasp`,`Pliegues`,`InflamLocal`,`SubEpiteliales`,`EdemaCentral`,`EdePeriferico`,`EdeGeneralizada`,`Microquistico`,    `Estronal`,`GCarnero`,`Pigmentados`,`UlceraCentral`,`UlceraPeriferico`,`CECentral`,`CEPeriferico`,`CESuperficial`,`CEProfundo`,`CETipo`,    `OtrosCornea`,`Camara`,`Cristalino`,`Negra`,`Numero`,`Discordia`,`Ang1`,`Ang2`,`Ang3`,`Ang4`,`OtrosAngulo`,`Capsula`,`CamaraAnt`,    `Saco`,`Sulcus`,`Atrapado`,`PIO`,`CristTrasparente`,`CristBlanco`,`OCapsular`,`EscNuclear`,`OpaCueniforme`,`OpaSutural`,`OpaNucCongenita`,`PolarPost`,    `OtrosLentesIntr`,`VClaro`,`VTurbio`,`DepVirregente`,`TyInflam`,`TyHemor`,`Papilas`,`Excavacion`,`Vasos`,`PoloPost`,`Epiretinal`,    `Disforme`,`MacSana`,`CamPigmentacion`,`Neovascular`,`Cicatriz`,`FocoCoro`,`Periferia`, ObservacionVit   FROM `h_oftamologia_ojo_der` WHERE IdOfta= '" + xOft + "'";
        try {
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.first();
                this.xJPOft_OjoExaDer1.JLSC.setText(xrs.getString("SC"));
                this.xJPOft_OjoExaDer1.JLCC.setText(xrs.getString("CC"));
                this.xJPOft_OjoExaDer1.JLEsfera.setText(xrs.getString("Esfera"));
                this.xJPOft_OjoExaDer1.JLCilindro.setText(xrs.getString("Cilindro"));
                this.xJPOft_OjoExaDer1.JLEje.setText(xrs.getString("Eje"));
                this.xJPOft_OjoExaDer1.JLK1.setText(xrs.getString("K1"));
                this.xJPOft_OjoExaDer1.JLK2.setText(xrs.getString("K2"));
                this.xJPOft_OjoExaDer1.JLLIO.setText(xrs.getString("LIO"));
                this.xJPOft_OjoExaDer1.JLLA.setText(xrs.getString("LA"));
                this.xJPOft_OjoExaDer1.JLBalance.setText(xrs.getString("Balance"));
                this.xJPOft_OjoExaDer1.JLMEO.setText(xrs.getString("MEO"));
                selectCheck(xrs.getString("AspNormal"), this.xJPOft_OjoExaDer1.JCHAspectoNormal);
                selectCheck(xrs.getString("Ectropion"), this.xJPOft_OjoExaDer1.JCHEctropion);
                selectCheck(xrs.getString("Entropion"), this.xJPOft_OjoExaDer1.JCHEntropion);
                selectButton(xrs.getString("Superior"), this.xJPOft_OjoExaDer1.Superior);
                selectButton(xrs.getString("Inferior"), this.xJPOft_OjoExaDer1.Inferior);
                selectCheck(xrs.getString("PTosis"), this.xJPOft_OjoExaDer1.JCHPTosis);
                selectCheck(xrs.getString("Blefaro"), this.xJPOft_OjoExaDer1.JCHBlefaro);
                selectCheck(xrs.getString("Dermato"), this.xJPOft_OjoExaDer1.JCHDermato);
                selectCheck(xrs.getString("PestNormal"), this.xJPOft_OjoExaDer1.JCHNormal);
                selectCheck(xrs.getString("Triquiasis"), this.xJPOft_OjoExaDer1.JCHTrisq);
                selectCheck(xrs.getString("Distriquiasis"), this.xJPOft_OjoExaDer1.JCHDistriq);
                this.xJPOft_OjoExaDer1.JTFOtros.setText(xrs.getString("OtrosParpa"));
                selectCheck(xrs.getString("Normocronica"), this.xJPOft_OjoExaDer1.JCHNormocro);
                selectCheck(xrs.getString("Placa"), this.xJPOft_OjoExaDer1.JCHPlaca);
                selectButton(xrs.getString("Hiperemia"), this.xJPOft_OjoExaDer1.Hiperemia);
                selectButton(xrs.getString("EspNasal"), this.xJPOft_OjoExaDer1.Nasal);
                selectButton(xrs.getString("EspTemporal"), this.xJPOft_OjoExaDer1.Temporal);
                selectCheck(xrs.getString("HemNasal"), this.xJPOft_OjoExaDer1.JCHNasal);
                selectCheck(xrs.getString("HemTemporal"), this.xJPOft_OjoExaDer1.JCHTemp);
                selectCheck(xrs.getString("HemGeneralizada"), this.xJPOft_OjoExaDer1.JCHGeneral);
                selectCheck(xrs.getString("RxPapilar"), this.xJPOft_OjoExaDer1.JCHRPapilar);
                selectCheck(xrs.getString("RxFolicular"), this.xJPOft_OjoExaDer1.JCHRFTarsal);
                selectCheck(xrs.getString("Quemosis"), this.xJPOft_OjoExaDer1.JCHQuemosis);
                selectButton(xrs.getString("Secrecion"), this.xJPOft_OjoExaDer1.Secrecion);
                this.xJPOft_OjoExaDer1.JTFOtrosConj.setText(xrs.getString("OtrosConjuntiva"));
                selectCheck(xrs.getString("CornTrasp"), this.xJPOft_OjoExaDer2.JCHTrasparente);
                selectCheck(xrs.getString("Pliegues"), this.xJPOft_OjoExaDer2.JCHPliegues);
                selectCheck(xrs.getString("InflamLocal"), this.xJPOft_OjoExaDer2.JCHInflamacion);
                selectCheck(xrs.getString("SubEpiteliales"), this.xJPOft_OjoExaDer2.JCHDepSube);
                selectCheck(xrs.getString("EdemaCentral"), this.xJPOft_OjoExaDer2.JCHCentral);
                selectCheck(xrs.getString("EdePeriferico"), this.xJPOft_OjoExaDer2.JCHPeriferico);
                selectCheck(xrs.getString("EdeGeneralizada"), this.xJPOft_OjoExaDer2.JCHGeneralizada);
                selectCheck(xrs.getString("Microquistico"), this.xJPOft_OjoExaDer2.JCHMicroq);
                selectCheck(xrs.getString("Estronal"), this.xJPOft_OjoExaDer2.JCHEstronal);
                selectCheck(xrs.getString("GCarnero"), this.xJPOft_OjoExaDer2.JCHGCarnero);
                selectCheck(xrs.getString("Pigmentados"), this.xJPOft_OjoExaDer2.JCHPigmentados);
                selectCheck(xrs.getString("UlceraCentral"), this.xJPOft_OjoExaDer2.JCHUlCentral);
                selectCheck(xrs.getString("UlceraPeriferico"), this.xJPOft_OjoExaDer2.JCHUlPeriferico);
                selectCheck(xrs.getString("CECentral"), this.xJPOft_OjoExaDer2.JCHCECentral);
                selectCheck(xrs.getString("CEPeriferico"), this.xJPOft_OjoExaDer2.JCHCEPeriferico);
                selectCheck(xrs.getString("CESuperficial"), this.xJPOft_OjoExaDer2.JCHCESuperficial);
                selectCheck(xrs.getString("CEProfundo"), this.xJPOft_OjoExaDer2.JCHCEProfundo);
                selectButton(xrs.getString("CETipo"), this.xJPOft_OjoExaDer2.CuerpoExtranio);
                this.xJPOft_OjoExaDer2.JTFOtros.setText(xrs.getString("OtrosCornea"));
                this.xJPOft_OjoExaDer2.JCBCamara.setSelectedItem(xrs.getString("Camara"));
                this.xJPOft_OjoExaDer2.JCBCristalino.setSelectedItem(xrs.getString("Cristalino"));
                selectCheck(xrs.getString("Negra"), this.xJPOft_OjoExaDer2.JCHNegraCentral);
                this.xJPOft_OjoExaDer2.JCBNegra.setSelectedItem(xrs.getString("Numero"));
                selectCheck(xrs.getString("Discordia"), this.xJPOft_OjoExaDer2.JCHDiscordia);
                this.xJPOft_OjoExaDer2.JTFAng1.setText(xrs.getString("Ang1"));
                this.xJPOft_OjoExaDer2.JTFAng2.setText(xrs.getString("Ang2"));
                this.xJPOft_OjoExaDer2.JTFAng3.setText(xrs.getString("Ang3"));
                this.xJPOft_OjoExaDer2.JTFAng4.setText(xrs.getString("Ang4"));
                this.xJPOft_OjoExaDer2.JTFOtrosCornea.setText(xrs.getString("OtrosAngulo"));
                selectButton(xrs.getString("Capsula"), this.xJPOft_OjoExaDer2.Capsula);
                selectCheck(xrs.getString("CamaraAnt"), this.xJPOft_OjoExaDer2.JCHCamAnt);
                selectCheck(xrs.getString("Saco"), this.xJPOft_OjoExaDer2.JCHSaco);
                selectCheck(xrs.getString("Sulcus"), this.xJPOft_OjoExaDer2.JCHSulcus);
                selectCheck(xrs.getString("Atrapado"), this.xJPOft_OjoExaDer2.JCHAtrapado);
                this.xJPOft_OjoExaDer2.JTFPIO.setText(xrs.getString("PIO"));
                selectCheck(xrs.getString("CristTrasparente"), this.xJPOft_OjoExaDer2.JCHCrisTrasparente);
                selectCheck(xrs.getString("CristBlanco"), this.xJPOft_OjoExaDer2.JCHCrisBlanco);
                selectButton(xrs.getString("OCapsular"), this.xJPOft_OjoExaDer2.Opacidad);
                selectButton(xrs.getString("EscNuclear"), this.xJPOft_OjoExaDer2.Esclerosis);
                selectCheck(xrs.getString("OpaCueniforme"), this.xJPOft_OjoExaDer2.JCHOpaCueiforme);
                selectCheck(xrs.getString("OpaSutural"), this.xJPOft_OjoExaDer2.JCHOpaSutural);
                selectCheck(xrs.getString("OpaNucCongenita"), this.xJPOft_OjoExaDer2.JCHOpaNuclear);
                selectCheck(xrs.getString("PolarPost"), this.xJPOft_OjoExaDer2.JCHPolarPost);
                this.xJPOft_OjoExaDer2.JTFOtrosCristalino.setText(xrs.getString("OtrosLentesIntr"));
                selectCheck(xrs.getString("VClaro"), this.xJPOft_OjoExaDer3.JCHClaro);
                selectCheck(xrs.getString("VTurbio"), this.xJPOft_OjoExaDer3.JCHTurbio);
                selectCheck(xrs.getString("DepVirregente"), this.xJPOft_OjoExaDer3.JCHDeposito);
                selectButton(xrs.getString("TyInflam"), this.xJPOft_OjoExaDer3.TInflamatorio);
                selectButton(xrs.getString("TyHemor"), this.xJPOft_OjoExaDer3.THemorragico);
                this.xJPOft_OjoExaDer3.JTFPapilas.setText(xrs.getString("Papilas"));
                selectButton(xrs.getString("Excavacion"), this.xJPOft_OjoExaDer3.Excavacion);
                selectButton(xrs.getString("Vasos"), this.xJPOft_OjoExaDer3.Vasos);
                selectButton(xrs.getString("PoloPost"), this.xJPOft_OjoExaDer3.Retina);
                selectCheck(xrs.getString("Epiretinal"), this.xJPOft_OjoExaDer3.JCHMemEpi);
                selectCheck(xrs.getString("Disforme"), this.xJPOft_OjoExaDer3.JCHDisforme);
                selectCheck(xrs.getString("MacSana"), this.xJPOft_OjoExaDer3.JCHSana);
                selectCheck(xrs.getString("CamPigmentacion"), this.xJPOft_OjoExaDer3.JCHPigmetacion);
                selectCheck(xrs.getString("Neovascular"), this.xJPOft_OjoExaDer3.JCHNeovascular);
                selectCheck(xrs.getString("Cicatriz"), this.xJPOft_OjoExaDer3.JCHCicatriz);
                selectCheck(xrs.getString("FocoCoro"), this.xJPOft_OjoExaDer3.JCHFoco);
                this.xJPOft_OjoExaDer3.JTAPeriferia.setText(xrs.getString("Periferia"));
                this.xJPOft_OjoExaDer3.JTAObservaciones.setText(xrs.getString("ObservacionVit"));
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPOftamologiaGen.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargaControlesIzq(String xOft) {
        String sql = "SELECT `SC`,`CC`,`Esfera`,`Cilindro`,`Eje`,`K1`,`K2`,`LIO`,`LA`,`Balance`,`MEO`,`AspNormal`,`Ectropion`,`Entropion`,    `Superior`,`Inferior`,`PTosis`,`Blefaro`,`Dermato`,`PestNormal`,`Triquiasis`,`Distriquiasis`,`OtrosParpa`,`Normocronica`,`Placa`,    `Hiperemia`,`EspNasal`,`EspTemporal`,`HemNasal`,`HemTemporal`,`HemGeneralizada`,`RxPapilar`,`RxFolicular`,`Quemosis`,`Secrecion`,    `OtrosConjuntiva`,`CornTrasp`,`Pliegues`,`InflamLocal`,`SubEpiteliales`,`EdemaCentral`,`EdePeriferico`,`EdeGeneralizada`,`Microquistico`,    `Estronal`,`GCarnero`,`Pigmentados`,`UlceraCentral`,`UlceraPeriferico`,`CECentral`,`CEPeriferico`,`CESuperficial`,`CEProfundo`,`CETipo`,    `OtrosCornea`,`Camara`,`Cristalino`,`Negra`,`Numero`,`Discordia`,`Ang1`,`Ang2`,`Ang3`,`Ang4`,`OtrosAngulo`,`Capsula`,`CamaraAnt`,    `Saco`,`Sulcus`,`Atrapado`,`PIO`,`CristTrasparente`,`CristBlanco`,`OCapsular`,`EscNuclear`,`OpaCueniforme`,`OpaSutural`,`OpaNucCongenita`,`PolarPost`,    `OtrosLentesIntr`,`VClaro`,`VTurbio`,`DepVirregente`,`TyInflam`,`TyHemor`,`Papilas`,`Excavacion`,`Vasos`,`PoloPost`,`Epiretinal`,    `Disforme`,`MacSana`,`CamPigmentacion`,`Neovascular`,`Cicatriz`,`FocoCoro`,`Periferia`,ObservacionVit   FROM `h_oftamologia_ojo_izq` WHERE IdOfta= '" + xOft + "'";
        try {
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.first();
                this.xJPOft_OjoExaIzq1.JLSC.setText(xrs.getString("SC"));
                this.xJPOft_OjoExaIzq1.JLCC.setText(xrs.getString("CC"));
                this.xJPOft_OjoExaIzq1.JLEsfera.setText(xrs.getString("Esfera"));
                this.xJPOft_OjoExaIzq1.JLCilindro.setText(xrs.getString("Cilindro"));
                this.xJPOft_OjoExaIzq1.JLEje.setText(xrs.getString("Eje"));
                this.xJPOft_OjoExaIzq1.JLK1.setText(xrs.getString("K1"));
                this.xJPOft_OjoExaIzq1.JLK2.setText(xrs.getString("K2"));
                this.xJPOft_OjoExaIzq1.JLLIO.setText(xrs.getString("LIO"));
                this.xJPOft_OjoExaIzq1.JLLA.setText(xrs.getString("LA"));
                this.xJPOft_OjoExaIzq1.JLBalance.setText(xrs.getString("Balance"));
                this.xJPOft_OjoExaIzq1.JLMEO.setText(xrs.getString("MEO"));
                selectCheck(xrs.getString("AspNormal"), this.xJPOft_OjoExaIzq1.JCHAspectoNormal);
                selectCheck(xrs.getString("Ectropion"), this.xJPOft_OjoExaIzq1.JCHEctropion);
                selectCheck(xrs.getString("Entropion"), this.xJPOft_OjoExaIzq1.JCHEntropion);
                selectButton(xrs.getString("Superior"), this.xJPOft_OjoExaIzq1.Superior);
                selectButton(xrs.getString("Inferior"), this.xJPOft_OjoExaIzq1.Inferior);
                selectCheck(xrs.getString("PTosis"), this.xJPOft_OjoExaIzq1.JCHPTosis);
                selectCheck(xrs.getString("Blefaro"), this.xJPOft_OjoExaIzq1.JCHBlefaro);
                selectCheck(xrs.getString("Dermato"), this.xJPOft_OjoExaIzq1.JCHDermato);
                selectCheck(xrs.getString("PestNormal"), this.xJPOft_OjoExaIzq1.JCHNormal);
                selectCheck(xrs.getString("Triquiasis"), this.xJPOft_OjoExaIzq1.JCHTrisq);
                selectCheck(xrs.getString("Distriquiasis"), this.xJPOft_OjoExaIzq1.JCHDistriq);
                this.xJPOft_OjoExaIzq1.JTFOtros.setText(xrs.getString("OtrosParpa"));
                selectCheck(xrs.getString("Normocronica"), this.xJPOft_OjoExaIzq1.JCHNormocro);
                selectCheck(xrs.getString("Placa"), this.xJPOft_OjoExaIzq1.JCHPlaca);
                selectButton(xrs.getString("Hiperemia"), this.xJPOft_OjoExaIzq1.Hiperemia);
                selectButton(xrs.getString("EspNasal"), this.xJPOft_OjoExaIzq1.Nasal);
                selectButton(xrs.getString("EspTemporal"), this.xJPOft_OjoExaIzq1.Temporal);
                selectCheck(xrs.getString("HemNasal"), this.xJPOft_OjoExaIzq1.JCHNasal);
                selectCheck(xrs.getString("HemTemporal"), this.xJPOft_OjoExaIzq1.JCHTemp);
                selectCheck(xrs.getString("HemGeneralizada"), this.xJPOft_OjoExaIzq1.JCHGeneral);
                selectCheck(xrs.getString("RxPapilar"), this.xJPOft_OjoExaIzq1.JCHRPapilar);
                selectCheck(xrs.getString("RxFolicular"), this.xJPOft_OjoExaIzq1.JCHRFTarsal);
                selectCheck(xrs.getString("Quemosis"), this.xJPOft_OjoExaIzq1.JCHQuemosis);
                selectButton(xrs.getString("Secrecion"), this.xJPOft_OjoExaIzq1.Secrecion);
                this.xJPOft_OjoExaIzq1.JTFOtrosConj.setText(xrs.getString("OtrosConjuntiva"));
                selectCheck(xrs.getString("CornTrasp"), this.xJPOft_OjoExaIzq2.JCHTrasparente);
                selectCheck(xrs.getString("Pliegues"), this.xJPOft_OjoExaIzq2.JCHPliegues);
                selectCheck(xrs.getString("InflamLocal"), this.xJPOft_OjoExaIzq2.JCHInflamacion);
                selectCheck(xrs.getString("SubEpiteliales"), this.xJPOft_OjoExaIzq2.JCHDepSube);
                selectCheck(xrs.getString("EdemaCentral"), this.xJPOft_OjoExaIzq2.JCHCentral);
                selectCheck(xrs.getString("EdePeriferico"), this.xJPOft_OjoExaIzq2.JCHPeriferico);
                selectCheck(xrs.getString("EdeGeneralizada"), this.xJPOft_OjoExaIzq2.JCHGeneralizada);
                selectCheck(xrs.getString("Microquistico"), this.xJPOft_OjoExaIzq2.JCHMicroq);
                selectCheck(xrs.getString("Estronal"), this.xJPOft_OjoExaIzq2.JCHEstronal);
                selectCheck(xrs.getString("GCarnero"), this.xJPOft_OjoExaIzq2.JCHGCarnero);
                selectCheck(xrs.getString("Pigmentados"), this.xJPOft_OjoExaIzq2.JCHPigmentados);
                selectCheck(xrs.getString("UlceraCentral"), this.xJPOft_OjoExaIzq2.JCHUlCentral);
                selectCheck(xrs.getString("UlceraPeriferico"), this.xJPOft_OjoExaIzq2.JCHUlPeriferico);
                selectCheck(xrs.getString("CECentral"), this.xJPOft_OjoExaIzq2.JCHCECentral);
                selectCheck(xrs.getString("CEPeriferico"), this.xJPOft_OjoExaIzq2.JCHCEPeriferico);
                selectCheck(xrs.getString("CESuperficial"), this.xJPOft_OjoExaIzq2.JCHCESuperficial);
                selectCheck(xrs.getString("CEProfundo"), this.xJPOft_OjoExaIzq2.JCHCEProfundo);
                selectButton(xrs.getString("CETipo"), this.xJPOft_OjoExaIzq2.CuerpoExtranio);
                this.xJPOft_OjoExaIzq2.JTFOtros.setText(xrs.getString("OtrosCornea"));
                this.xJPOft_OjoExaIzq2.JCBCamara.setSelectedItem(xrs.getString("Camara"));
                this.xJPOft_OjoExaIzq2.JCBCristalino.setSelectedItem(xrs.getString("Cristalino"));
                selectCheck(xrs.getString("Negra"), this.xJPOft_OjoExaIzq2.JCHNegraCentral);
                this.xJPOft_OjoExaIzq2.JCBNegra.setSelectedItem(xrs.getString("Numero"));
                selectCheck(xrs.getString("Discordia"), this.xJPOft_OjoExaIzq2.JCHDiscordia);
                this.xJPOft_OjoExaIzq2.JTFAng1.setText(xrs.getString("Ang1"));
                this.xJPOft_OjoExaIzq2.JTFAng2.setText(xrs.getString("Ang2"));
                this.xJPOft_OjoExaIzq2.JTFAng3.setText(xrs.getString("Ang3"));
                this.xJPOft_OjoExaIzq2.JTFAng4.setText(xrs.getString("Ang4"));
                this.xJPOft_OjoExaIzq2.JTFOtrosCornea.setText(xrs.getString("OtrosAngulo"));
                selectButton(xrs.getString("Capsula"), this.xJPOft_OjoExaIzq2.Capsula);
                selectCheck(xrs.getString("CamaraAnt"), this.xJPOft_OjoExaIzq2.JCHCamAnt);
                selectCheck(xrs.getString("Saco"), this.xJPOft_OjoExaIzq2.JCHSaco);
                selectCheck(xrs.getString("Sulcus"), this.xJPOft_OjoExaIzq2.JCHSulcus);
                selectCheck(xrs.getString("Atrapado"), this.xJPOft_OjoExaIzq2.JCHAtrapado);
                this.xJPOft_OjoExaIzq2.JTFPIO.setText(xrs.getString("PIO"));
                selectCheck(xrs.getString("CristTrasparente"), this.xJPOft_OjoExaIzq2.JCHCrisTrasparente);
                selectCheck(xrs.getString("CristBlanco"), this.xJPOft_OjoExaIzq2.JCHCrisBlanco);
                selectButton(xrs.getString("OCapsular"), this.xJPOft_OjoExaIzq2.Opacidad);
                selectButton(xrs.getString("EscNuclear"), this.xJPOft_OjoExaIzq2.Esclerosis);
                selectCheck(xrs.getString("OpaCueniforme"), this.xJPOft_OjoExaIzq2.JCHOpaCueiforme);
                selectCheck(xrs.getString("OpaSutural"), this.xJPOft_OjoExaIzq2.JCHOpaSutural);
                selectCheck(xrs.getString("OpaNucCongenita"), this.xJPOft_OjoExaIzq2.JCHOpaNuclear);
                selectCheck(xrs.getString("PolarPost"), this.xJPOft_OjoExaIzq2.JCHPolarPost);
                this.xJPOft_OjoExaIzq2.JTFOtrosCristalino.setText(xrs.getString("OtrosLentesIntr"));
                selectCheck(xrs.getString("VClaro"), this.xJPOft_OjoExaIzq3.JCHClaro);
                selectCheck(xrs.getString("VTurbio"), this.xJPOft_OjoExaIzq3.JCHTurbio);
                selectCheck(xrs.getString("DepVirregente"), this.xJPOft_OjoExaIzq3.JCHDeposito);
                selectButton(xrs.getString("TyInflam"), this.xJPOft_OjoExaIzq3.TInflamatorio);
                selectButton(xrs.getString("TyHemor"), this.xJPOft_OjoExaIzq3.THemorragico);
                this.xJPOft_OjoExaIzq3.JTFPapilas.setText(xrs.getString("Papilas"));
                selectButton(xrs.getString("Excavacion"), this.xJPOft_OjoExaIzq3.Excavacion);
                selectButton(xrs.getString("Vasos"), this.xJPOft_OjoExaIzq3.Vasos);
                selectButton(xrs.getString("PoloPost"), this.xJPOft_OjoExaIzq3.Retina);
                selectCheck(xrs.getString("Epiretinal"), this.xJPOft_OjoExaIzq3.JCHMemEpi);
                selectCheck(xrs.getString("Disforme"), this.xJPOft_OjoExaIzq3.JCHDisforme);
                selectCheck(xrs.getString("MacSana"), this.xJPOft_OjoExaIzq3.JCHSana);
                selectCheck(xrs.getString("CamPigmentacion"), this.xJPOft_OjoExaIzq3.JCHPigmetacion);
                selectCheck(xrs.getString("Neovascular"), this.xJPOft_OjoExaIzq3.JCHNeovascular);
                selectCheck(xrs.getString("Cicatriz"), this.xJPOft_OjoExaIzq3.JCHCicatriz);
                selectCheck(xrs.getString("FocoCoro"), this.xJPOft_OjoExaIzq3.JCHFoco);
                this.xJPOft_OjoExaIzq3.JTAPeriferia.setText(xrs.getString("Periferia"));
                this.xJPOft_OjoExaIzq3.JTAObservaciones.setText(xrs.getString("ObservacionVit"));
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPOftamologiaGen.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
