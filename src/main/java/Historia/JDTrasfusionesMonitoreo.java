package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.JTextFieldValidator;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JDTrasfusionesMonitoreo.class */
public class JDTrasfusionesMonitoreo extends JDialog {
    private JPTransfuciones xJPTransfuciones;
    private String xIdBolsa;
    private String xIdBolsaNo;
    private ConsultasMySQL xct;
    private Metodos xmt;
    private JButton JBGrabaSeg;
    private JComboBox JCBMomento;
    private JComboBox JCBPRAdversa;
    private JTextArea JTAObservacion;
    public JTextFieldValidator JTFFSPulso;
    public JTextFieldValidator JTFFSTension;
    private JButton jButton1;
    private JScrollPane jScrollPane2;
    public JFormattedTextField txtHoraMonitoreo;

    public JDTrasfusionesMonitoreo(Frame parent, boolean modal, JPTransfuciones xJPTransfuciones, String xIdBolsa, String xIdBolsaNo) {
        super(parent, modal);
        this.xct = new ConsultasMySQL();
        this.xmt = new Metodos();
        initComponents();
        setTitle("MONITOREO UNIDAD DE SANGRE");
        setLocationRelativeTo(null);
        this.txtHoraMonitoreo.setValue(this.xmt.getFechaActual());
        this.xJPTransfuciones = xJPTransfuciones;
        this.xIdBolsa = xIdBolsa;
        this.xIdBolsaNo = xIdBolsaNo;
    }

    private void initComponents() {
        this.JCBMomento = new JComboBox();
        this.txtHoraMonitoreo = new JFormattedTextField();
        this.JTFFSTension = new JTextFieldValidator();
        this.JTFFSPulso = new JTextFieldValidator();
        this.JCBPRAdversa = new JComboBox();
        this.jScrollPane2 = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.JBGrabaSeg = new JButton();
        this.jButton1 = new JButton();
        setDefaultCloseOperation(2);
        this.JCBMomento.setFont(new Font("Arial", 1, 12));
        this.JCBMomento.setModel(new DefaultComboBoxModel(new String[]{" ", "INICIO", "DURANTE", "FINAL"}));
        this.JCBMomento.setBorder(BorderFactory.createTitledBorder((Border) null, "MOMENTO", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtHoraMonitoreo.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtHoraMonitoreo.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("hh:mm:ss a"))));
        this.txtHoraMonitoreo.setFont(new Font("Tahoma", 1, 12));
        this.txtHoraMonitoreo.addKeyListener(new KeyAdapter() { // from class: Historia.JDTrasfusionesMonitoreo.1
            public void keyPressed(KeyEvent evt) {
                JDTrasfusionesMonitoreo.this.txtHoraMonitoreoKeyPressed(evt);
            }
        });
        this.JTFFSTension.setBorder(BorderFactory.createTitledBorder((Border) null, "T/A", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSTension.setHorizontalAlignment(0);
        this.JTFFSTension.setText("0");
        this.JTFFSTension.setToolTipText("Tensión Arterial");
        this.JTFFSTension.setExprecionRegular("^[0-9]*$");
        this.JTFFSTension.setFocusAccelerator('C');
        this.JTFFSTension.setFont(new Font("Arial", 1, 12));
        this.JTFFSTension.addFocusListener(new FocusAdapter() { // from class: Historia.JDTrasfusionesMonitoreo.2
            public void focusGained(FocusEvent evt) {
                JDTrasfusionesMonitoreo.this.JTFFSTensionFocusGained(evt);
            }
        });
        this.JTFFSPulso.setBorder(BorderFactory.createTitledBorder((Border) null, "Pulso", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSPulso.setHorizontalAlignment(0);
        this.JTFFSPulso.setText("0");
        this.JTFFSPulso.setToolTipText("Pulso");
        this.JTFFSPulso.setExprecionRegular("^[0-9]*$");
        this.JTFFSPulso.setFocusAccelerator('C');
        this.JTFFSPulso.setFont(new Font("Arial", 1, 12));
        this.JTFFSPulso.addFocusListener(new FocusAdapter() { // from class: Historia.JDTrasfusionesMonitoreo.3
            public void focusGained(FocusEvent evt) {
                JDTrasfusionesMonitoreo.this.JTFFSPulsoFocusGained(evt);
            }
        });
        this.JCBPRAdversa.setFont(new Font("Arial", 1, 12));
        this.JCBPRAdversa.setModel(new DefaultComboBoxModel(new String[]{" ", "SI", "NO"}));
        this.JCBPRAdversa.setBorder(BorderFactory.createTitledBorder((Border) null, "Reacción Adversa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacion.setColumns(1);
        this.JTAObservacion.setFont(new Font("Arial", 0, 13));
        this.JTAObservacion.setLineWrap(true);
        this.JTAObservacion.setRows(1);
        this.JTAObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane2.setViewportView(this.JTAObservacion);
        this.JBGrabaSeg.setFont(new Font("Arial", 1, 12));
        this.JBGrabaSeg.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBGrabaSeg.setText("Grabar");
        this.JBGrabaSeg.addActionListener(new ActionListener() { // from class: Historia.JDTrasfusionesMonitoreo.4
            public void actionPerformed(ActionEvent evt) {
                JDTrasfusionesMonitoreo.this.JBGrabaSegActionPerformed(evt);
            }
        });
        this.jButton1.setFont(new Font("Arial", 1, 12));
        this.jButton1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.jButton1.setText("SALIR");
        this.jButton1.addActionListener(new ActionListener() { // from class: Historia.JDTrasfusionesMonitoreo.5
            public void actionPerformed(ActionEvent evt) {
                JDTrasfusionesMonitoreo.this.jButton1ActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JCBPRAdversa, -2, 121, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane2)).addGroup(layout.createSequentialGroup().addComponent(this.JCBMomento, -2, 106, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtHoraMonitoreo, -2, 89, -2).addGap(3, 3, 3).addComponent(this.JTFFSTension, -2, 76, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFSPulso, -2, 76, -2).addGap(0, 0, 32767)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jButton1, -2, 174, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBGrabaSeg, -2, 163, -2))).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBMomento, -2, 51, -2).addComponent(this.txtHoraMonitoreo, -2, 50, -2).addComponent(this.JTFFSTension, -2, 50, -2).addComponent(this.JTFFSPulso, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCBPRAdversa, -2, 50, -2).addComponent(this.jScrollPane2, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBGrabaSeg, -1, -1, 32767).addComponent(this.jButton1, -1, 51, 32767)).addGap(10, 10, 10)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtHoraMonitoreoKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSTensionFocusGained(FocusEvent evt) {
        this.JTFFSTension.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSPulsoFocusGained(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGrabaSegActionPerformed(ActionEvent evt) {
        if (!mVerifica()) {
            if (this.JCBMomento.getSelectedIndex() != 0) {
                if (!this.JTFFSTension.getText().equals("0")) {
                    if (!this.JTFFSPulso.getText().equals("0")) {
                        if (this.JCBPRAdversa.getSelectedIndex() != 0) {
                            int n = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                            if (n == 0) {
                                String sql = "INSERT INTO  `h_ordenes_transfusiones_monitoreo` (`IdBolsa`, `FechaR`, `Momento`, `Hora`, `T_A`, `Pulso`, `Observacion`, `RAdversa`, `IdProfesional`,  `IdEspecialidad`, `UsuarioS`) VALUES ('" + this.xIdBolsa + "', '" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "', '" + this.JCBMomento.getSelectedItem() + "', '" + this.xmt.formatoH24.format(this.txtHoraMonitoreo.getValue()) + "', '" + this.JTFFSTension.getText() + "', '" + this.JTFFSPulso.getText() + "', '" + this.JTAObservacion.getText() + "', '" + this.JCBPRAdversa.getSelectedItem() + "', '" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "', '" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "', '" + Principal.usuarioSistemaDTO.getLogin() + "') ";
                                this.xct.ejecutarSQL(sql);
                                this.xct.cerrarConexionBd();
                                this.xJPTransfuciones.mBuscaMonitoreo();
                                dispose();
                                return;
                            }
                            return;
                        }
                        JOptionPane.showMessageDialog(this, "Debe decir si tuvo alguna reacción adversa", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                        this.JCBPRAdversa.requestFocus();
                        return;
                    }
                    JOptionPane.showMessageDialog(this, "El Pulso debe ser diferente de Cero", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                    this.JTFFSPulso.requestFocus();
                    return;
                }
                JOptionPane.showMessageDialog(this, "La Tensión debe ser diferente de Cero", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                this.JTFFSTension.requestFocus();
                return;
            }
            JOptionPane.showMessageDialog(this, "Seleccione un momento", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            this.JCBMomento.requestFocus();
            return;
        }
        JOptionPane.showMessageDialog(this, "la Bolsa No. " + this.xIdBolsaNo + " ya tiene el momento " + this.JCBMomento.getSelectedItem() + " registrado", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
        this.JCBMomento.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        dispose();
    }

    private boolean mVerifica() {
        boolean xExiste = false;
        int i = 0;
        while (true) {
            if (i < this.xJPTransfuciones.xmodeloMon.getRowCount()) {
                if (!this.xJPTransfuciones.xmodeloMon.getValueAt(i, 0).toString().equals(this.xIdBolsaNo) || !this.xJPTransfuciones.xmodeloMon.getValueAt(i, 1).toString().equals(this.JCBMomento.getSelectedItem())) {
                    i++;
                } else {
                    xExiste = true;
                    break;
                }
            } else {
                break;
            }
        }
        return xExiste;
    }
}
