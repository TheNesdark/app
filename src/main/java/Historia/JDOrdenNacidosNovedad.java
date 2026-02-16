package Historia;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
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
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JDOrdenNacidosNovedad.class */
public class JDOrdenNacidosNovedad extends JDialog {
    private Metodos xmt;
    private ConsultasMySQL xct;
    private JDOrdenNacidos xJDOrdenNacidos;
    public JDateChooser JDCFechaNac;
    private JLabel JLCod;
    private JRadioButton JR1;
    private JRadioButton JR2;
    private JTextField JTFAPGar;
    public JTextField JTFDx;
    public JTextField JTFPatologia;
    private ButtonGroup buttonGroup1;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JPanel jPanel1;
    private JPanel jPanel2;
    public JFormattedTextField txtHora;

    public JDOrdenNacidosNovedad(Frame parent, boolean modal, String xCodigo, JDOrdenNacidos xJDOrdenNacidos) {
        super(parent, modal);
        this.xmt = new Metodos();
        this.xct = new ConsultasMySQL();
        initComponents();
        mComp();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.JDCFechaNac.setDate(this.xmt.getFechaActual());
        this.txtHora.setValue(this.xmt.getFechaActual());
        this.JLCod.setText(xCodigo);
        this.xJDOrdenNacidos = xJDOrdenNacidos;
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.jPanel1 = new JPanel();
        this.JTFAPGar = new JTextField();
        this.jPanel2 = new JPanel();
        this.JDCFechaNac = new JDateChooser();
        this.txtHora = new JFormattedTextField();
        this.JTFDx = new JTextField();
        this.JTFPatologia = new JTextField();
        this.jButton1 = new JButton();
        this.jButton2 = new JButton();
        this.jButton3 = new JButton();
        this.JR1 = new JRadioButton();
        this.JR2 = new JRadioButton();
        this.JLCod = new JLabel();
        setDefaultCloseOperation(2);
        setTitle("NOVEDAD RECIÉN NACIDO");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFAPGar.setFont(new Font("Arial", 1, 12));
        this.JTFAPGar.setBorder(BorderFactory.createTitledBorder(BorderFactory.createTitledBorder((Border) null, "APGAR", 0, 0, new Font("Arial", 1, 12), Color.blue), "APGAR", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFAPGar, -2, 82, -2).addContainerGap(87, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGap(8, 8, 8).addComponent(this.JTFAPGar, -2, -1, -2).addGap(8, 8, 8)));
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JDCFechaNac.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Nac", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaNac.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaNac.setFont(new Font("Arial", 1, 12));
        this.JDCFechaNac.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JDOrdenNacidosNovedad.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JDOrdenNacidosNovedad.this.JDCFechaNacPropertyChange(evt);
            }
        });
        this.txtHora.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtHora.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("hh:mm:ss a"))));
        this.txtHora.setFont(new Font("Tahoma", 1, 12));
        this.txtHora.addKeyListener(new KeyAdapter() { // from class: Historia.JDOrdenNacidosNovedad.2
            public void keyPressed(KeyEvent evt) {
                JDOrdenNacidosNovedad.this.txtHoraKeyPressed(evt);
            }
        });
        this.JTFDx.setFont(new Font("Arial", 1, 12));
        this.JTFDx.setHorizontalAlignment(0);
        this.JTFDx.setBorder(BorderFactory.createTitledBorder((Border) null, "CIE10", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFDx.addFocusListener(new FocusAdapter() { // from class: Historia.JDOrdenNacidosNovedad.3
            public void focusLost(FocusEvent evt) {
                JDOrdenNacidosNovedad.this.JTFDxFocusLost(evt);
            }
        });
        this.JTFDx.addKeyListener(new KeyAdapter() { // from class: Historia.JDOrdenNacidosNovedad.4
            public void keyPressed(KeyEvent evt) {
                JDOrdenNacidosNovedad.this.JTFDxKeyPressed(evt);
            }
        });
        this.JTFPatologia.setEditable(false);
        this.JTFPatologia.setFont(new Font("Arial", 1, 12));
        this.JTFPatologia.setHorizontalAlignment(0);
        this.JTFPatologia.setBorder(BorderFactory.createTitledBorder((Border) null, "Patología", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jButton1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/lupa.png")));
        this.jButton1.setToolTipText("Busca Patología");
        this.jButton1.setName("xBtbNacido");
        this.jButton1.addActionListener(new ActionListener() { // from class: Historia.JDOrdenNacidosNovedad.5
            public void actionPerformed(ActionEvent evt) {
                JDOrdenNacidosNovedad.this.jButton1ActionPerformed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JDCFechaNac, -2, 117, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtHora, -2, 110, -2).addGap(0, 0, 32767)).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFDx, -2, 83, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFPatologia, -2, 342, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jButton1).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JDCFechaNac, -1, 45, 32767).addComponent(this.txtHora)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jButton1, GroupLayout.Alignment.TRAILING).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFDx, -2, -1, -2).addComponent(this.JTFPatologia))).addGap(5, 5, 5)));
        this.jButton2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ok29x27.png")));
        this.jButton2.setText("Guardar");
        this.jButton2.setToolTipText("Guardar");
        this.jButton2.setName("xBtbNacido");
        this.jButton2.addActionListener(new ActionListener() { // from class: Historia.JDOrdenNacidosNovedad.6
            public void actionPerformed(ActionEvent evt) {
                JDOrdenNacidosNovedad.this.jButton2ActionPerformed(evt);
            }
        });
        this.jButton3.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Cancelar30x30.png")));
        this.jButton3.setText("Cancelar");
        this.jButton3.setToolTipText("Guardar");
        this.jButton3.setName("xBtbNacido");
        this.jButton3.addActionListener(new ActionListener() { // from class: Historia.JDOrdenNacidosNovedad.7
            public void actionPerformed(ActionEvent evt) {
                JDOrdenNacidosNovedad.this.jButton3ActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.JR1);
        this.JR1.setFont(new Font("Arial", 1, 12));
        this.JR1.setForeground(new Color(0, 102, 0));
        this.JR1.setText("APGAR (5 Minutos despues)");
        this.JR1.addActionListener(new ActionListener() { // from class: Historia.JDOrdenNacidosNovedad.8
            public void actionPerformed(ActionEvent evt) {
                JDOrdenNacidosNovedad.this.JR1ActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.JR2);
        this.JR2.setFont(new Font("Arial", 1, 12));
        this.JR2.setForeground(new Color(0, 102, 0));
        this.JR2.setText("Muerte de Recien Nacido");
        this.JR2.addActionListener(new ActionListener() { // from class: Historia.JDOrdenNacidosNovedad.9
            public void actionPerformed(ActionEvent evt) {
                JDOrdenNacidosNovedad.this.JR2ActionPerformed(evt);
            }
        });
        this.JLCod.setFont(new Font("Arial", 1, 18));
        this.JLCod.setForeground(Color.red);
        this.JLCod.setHorizontalAlignment(0);
        this.JLCod.setToolTipText("Codigo Recien Nacido");
        this.JLCod.setBorder(BorderFactory.createTitledBorder((Border) null, "Código R.N.", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.jPanel1, -2, -1, -2).addGap(18, 18, 18).addComponent(this.jPanel2, -2, -1, -2).addGap(0, 0, 32767)).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jButton2, -2, 368, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton3, -1, -1, 32767)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JR1).addGap(18, 18, 18).addComponent(this.JR2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JLCod, -2, 100, -2))).addGap(5, 18, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JLCod, -2, 45, -2).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JR1).addComponent(this.JR2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -2, -1, -2).addComponent(this.jPanel2, -2, -1, -2)).addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jButton2, -1, -1, 32767).addComponent(this.jButton3, -1, 43, 32767)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaNacPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtHoraKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.txtHora.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFDxFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFDxKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            buscarPatologias(this.JTFDx, this.JTFPatologia, 0);
            this.JTFDx.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        JDPatologia x = new JDPatologia(null, true, this);
        x.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton2ActionPerformed(ActionEvent evt) {
        int n = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            if (this.JR2.isSelected()) {
                String sql = "UPDATE `h_orden_qx_nacido_detalle` SET `FechaMuerte`='" + this.xmt.formatoAMD.format(this.JDCFechaNac.getDate()) + "', `HoraMuerte`='" + this.xmt.formatoH24.format(this.txtHora.getValue()) + "' ,`DXMuerte`='" + this.JTFDx.getText() + "' WHERE `Id`='" + this.JLCod.getText() + "'";
                this.xct.ejecutarSQL(sql);
                this.xct.cerrarConexionBd();
            } else if (this.JR1.isSelected()) {
                String sql2 = "UPDATE `h_orden_qx_nacido_detalle` SET `Apgar_c`='" + this.JTFAPGar.getText() + "' WHERE `Id`='" + this.JLCod.getText() + "'";
                this.xct.ejecutarSQL(sql2);
                this.xct.cerrarConexionBd();
            }
            this.xJDOrdenNacidos.mBuscaInformacion(this.xJDOrdenNacidos.xOrdenQx);
            dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton3ActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JR1ActionPerformed(ActionEvent evt) {
        this.jPanel1.setEnabled(true);
        this.JTFAPGar.setEnabled(true);
        this.JDCFechaNac.setEnabled(false);
        this.txtHora.setEnabled(false);
        this.JTFDx.setEnabled(false);
        this.jButton1.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JR2ActionPerformed(ActionEvent evt) {
        this.jPanel1.setEnabled(false);
        this.JTFAPGar.setEnabled(false);
        this.JDCFechaNac.setEnabled(true);
        this.txtHora.setEnabled(true);
        this.JTFDx.setEnabled(true);
        this.jButton1.setEnabled(true);
    }

    private void buscarPatologias(JTextField codigo, JTextField nombrep, int n) {
        if (!codigo.getText().isEmpty()) {
            try {
                String sql = "SELECT Id, Nbre FROM g_patologia where Id='" + codigo.getText().toUpperCase() + "'";
                ResultSet res = this.xct.traerRs(sql);
                res.next();
                if (res.getRow() != 0) {
                    nombrep.setText(res.getString(2));
                    codigo.setText(codigo.getText().toUpperCase());
                } else {
                    JOptionPane.showMessageDialog(this, "Codigo no existe", "BUSCAR PATOLOGÍA", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    nombrep.setText((String) null);
                    codigo.setText((String) null);
                    codigo.requestFocus();
                }
                res.close();
                this.xct.cerrarConexionBd();
            } catch (SQLException e) {
            }
        }
    }

    private void mComp() {
        this.jPanel1.setEnabled(false);
        this.JTFAPGar.setEnabled(false);
        this.JDCFechaNac.setEnabled(false);
        this.txtHora.setEnabled(false);
        this.JTFDx.setEnabled(false);
        this.jButton1.setEnabled(false);
    }
}
