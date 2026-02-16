package Historia;

import Laboratorio.JIFPlanillaTrabajo;
import Utilidades.ConsultasMySQL;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JDResultadoDescriptivoSO.class */
public class JDResultadoDescriptivoSO extends JDialog {
    private ConsultasMySQL xct;
    private JIFPlanillaTrabajo xjifplanilla;
    private String frmllamador;
    private String xsql;
    private String xidtiporesultado;
    private int xtipo;
    private int xpos;
    private JPASaludOcupacional xjifso;
    private JPAEcografiaGenerico xjifeco;
    private JButton JBTGrabar;
    private JButton JBTSalir;
    private JButton JBT_NotaP;
    private JScrollPane JSPDescripcionT;
    private JTextPane JTPDescripcion;

    public JDResultadoDescriptivoSO(Frame parent, boolean modal, String frmllamador, int xpos, JPanel panel) {
        super(parent, modal);
        this.xct = new ConsultasMySQL();
        this.xidtiporesultado = "0";
        this.xtipo = 0;
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setLocationRelativeTo(null);
        this.xtipo = this.xtipo;
        this.xpos = xpos;
        this.frmllamador = frmllamador;
        realizarcasting(panel);
    }

    private void initComponents() {
        this.JSPDescripcionT = new JScrollPane();
        this.JTPDescripcion = new JTextPane();
        this.JBTGrabar = new JButton();
        this.JBTSalir = new JButton();
        this.JBT_NotaP = new JButton();
        setDefaultCloseOperation(2);
        setTitle("TIPO DE RESULTADO");
        setName("CapturarResultado");
        addKeyListener(new KeyAdapter() { // from class: Historia.JDResultadoDescriptivoSO.1
            public void keyPressed(KeyEvent evt) {
                JDResultadoDescriptivoSO.this.formKeyPressed(evt);
            }
        });
        this.JSPDescripcionT.setBorder(BorderFactory.createTitledBorder((Border) null, "DESCRIPCIÓN RESULTADO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTPDescripcion.setFont(new Font("Arial", 1, 12));
        this.JTPDescripcion.addKeyListener(new KeyAdapter() { // from class: Historia.JDResultadoDescriptivoSO.2
            public void keyTyped(KeyEvent evt) {
                JDResultadoDescriptivoSO.this.JTPDescripcionKeyTyped(evt);
            }
        });
        this.JSPDescripcionT.setViewportView(this.JTPDescripcion);
        this.JBTGrabar.setFont(new Font("Arial", 1, 12));
        this.JBTGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGrabar.setText("Grabar");
        this.JBTGrabar.setEnabled(false);
        this.JBTGrabar.addActionListener(new ActionListener() { // from class: Historia.JDResultadoDescriptivoSO.3
            public void actionPerformed(ActionEvent evt) {
                JDResultadoDescriptivoSO.this.JBTGrabarActionPerformed(evt);
            }
        });
        this.JBTGrabar.addKeyListener(new KeyAdapter() { // from class: Historia.JDResultadoDescriptivoSO.4
            public void keyPressed(KeyEvent evt) {
                JDResultadoDescriptivoSO.this.JBTGrabarKeyPressed(evt);
            }
        });
        this.JBTSalir.setFont(new Font("Arial", 1, 12));
        this.JBTSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBTSalir.setText("Salir");
        this.JBTSalir.addActionListener(new ActionListener() { // from class: Historia.JDResultadoDescriptivoSO.5
            public void actionPerformed(ActionEvent evt) {
                JDResultadoDescriptivoSO.this.JBTSalirActionPerformed(evt);
            }
        });
        this.JBT_NotaP.setFont(new Font("Arial", 1, 12));
        this.JBT_NotaP.setIcon(new ImageIcon(getClass().getResource("/Imagenes/HojaLapiz29x27.png")));
        this.JBT_NotaP.setText("Notas Predefinidas");
        this.JBT_NotaP.addActionListener(new ActionListener() { // from class: Historia.JDResultadoDescriptivoSO.6
            public void actionPerformed(ActionEvent evt) {
                JDResultadoDescriptivoSO.this.JBT_NotaPActionPerformed(evt);
            }
        });
        this.JBT_NotaP.addKeyListener(new KeyAdapter() { // from class: Historia.JDResultadoDescriptivoSO.7
            public void keyPressed(KeyEvent evt) {
                JDResultadoDescriptivoSO.this.JBT_NotaPKeyPressed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(20, 20, 20).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JBTGrabar, -2, 180, -2).addGap(97, 97, 97).addComponent(this.JBT_NotaP, -2, 180, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBTSalir, -2, 180, -2)).addComponent(this.JSPDescripcionT, -1, 758, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JSPDescripcionT, -1, 366, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTGrabar, -2, 60, -2).addComponent(this.JBTSalir, -2, 60, -2).addComponent(this.JBT_NotaP, -2, 60, -2)).addGap(16, 16, 16)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGrabarActionPerformed(ActionEvent evt) {
        mAsignar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGrabarKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            mAsignar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTSalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPDescripcionKeyTyped(KeyEvent evt) {
        if (!this.JTPDescripcion.getText().isEmpty()) {
            this.JBTGrabar.setEnabled(true);
        } else {
            this.JBTGrabar.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 27) {
            dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_NotaPActionPerformed(ActionEvent evt) {
        mCargar_NotasP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_NotaPKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            mCargar_NotasP();
        }
    }

    private void mCargar_NotasP() {
        JD_NotasPredefinidas dialog = new JD_NotasPredefinidas((Frame) null, true, this.JTPDescripcion, this.JTPDescripcion, 0);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    private void mAsignar() {
        switch (this.frmllamador) {
            case "SaludOcupacional":
                this.xjifso.xmodelo.setValueAt(this.JTPDescripcion.getText(), this.xjifso.JTDetallePreguntasT.getSelectedRow(), this.xpos);
                break;
            case "EcografiaAbdominal":
                this.xjifeco.xmodelo.setValueAt(this.JTPDescripcion.getText(), this.xjifeco.JTDetalleEcografia.getSelectedRow(), this.xpos);
                break;
            case "Ecobiliarab":
                this.xjifeco.xmodelo.setValueAt(this.JTPDescripcion.getText(), this.xjifeco.JTDetalleEcografia.getSelectedRow(), this.xpos);
                break;
            case "Ecografía.":
                this.xjifeco.xmodelo.setValueAt(this.JTPDescripcion.getText(), this.xjifeco.JTDetalleEcografia.getSelectedRow(), this.xpos);
                break;
        }
        dispose();
    }

    private void realizarcasting(JPanel frm) {
        switch (frm.getName()) {
            case "jpsaludocupacional":
                this.xjifso = (JPASaludOcupacional) frm;
                this.frmllamador = "SaludOcupacional";
                break;
            case "jifecoabdominal":
                this.xjifeco = (JPAEcografiaGenerico) frm;
                this.frmllamador = "EcografiaAbdominal";
                break;
            case "jifecoecobiliarab":
                this.xjifeco = (JPAEcografiaGenerico) frm;
                this.frmllamador = "Ecobiliarab";
                break;
            case "xjifecografia":
                this.xjifeco = (JPAEcografiaGenerico) frm;
                this.frmllamador = "Ecografía.";
                break;
            default:
                this.frmllamador = "";
                break;
        }
    }
}
