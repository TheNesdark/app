package Historia;

import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JDTrasfusiones.class */
public class JDTrasfusiones extends JDialog {
    private JPTransfuciones xJPTransfuciones;
    private Metodos xmt;
    private JComboBox JCBPCruzada;
    private JLabel JLCUP;
    private JLabel JLProc;
    private JTextField JTFBolsa;
    private JTextField JTFCodigo;
    private JTextField JTFSCalidad;
    private JButton jButton1;
    private JButton jButton2;
    public JFormattedTextField txtHora;

    public JDTrasfusiones(Frame parent, boolean modal, JPTransfuciones xJPTransfuciones) {
        super(parent, modal);
        this.xmt = new Metodos();
        initComponents();
        this.xJPTransfuciones = xJPTransfuciones;
        this.txtHora.setValue(this.xmt.getFechaActual());
        setTitle("INFORMACIÓN UNIDAD DE SANGRE");
        setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        mTraeDatos();
        this.txtHora.setValue(this.xmt.getFechaActual());
    }

    private void initComponents() {
        this.jButton1 = new JButton();
        this.JLCUP = new JLabel();
        this.JLProc = new JLabel();
        this.JTFCodigo = new JTextField();
        this.JTFBolsa = new JTextField();
        this.JCBPCruzada = new JComboBox();
        this.JTFSCalidad = new JTextField();
        this.txtHora = new JFormattedTextField();
        this.jButton2 = new JButton();
        setDefaultCloseOperation(2);
        this.jButton1.setFont(new Font("Arial", 1, 12));
        this.jButton1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.jButton1.setText("SALIR");
        this.jButton1.addActionListener(new ActionListener() { // from class: Historia.JDTrasfusiones.1
            public void actionPerformed(ActionEvent evt) {
                JDTrasfusiones.this.jButton1ActionPerformed(evt);
            }
        });
        this.JLCUP.setFont(new Font("Arial", 1, 12));
        this.JLCUP.setBorder(BorderFactory.createTitledBorder((Border) null, "CUP", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLProc.setFont(new Font("Arial", 1, 12));
        this.JLProc.setBorder(BorderFactory.createTitledBorder((Border) null, "Procedimiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCodigo.setFont(new Font("Arial", 1, 12));
        this.JTFCodigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Código", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFBolsa.setFont(new Font("Arial", 1, 12));
        this.JTFBolsa.setBorder(BorderFactory.createTitledBorder((Border) null, "No.Bolsa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBPCruzada.setFont(new Font("Arial", 1, 12));
        this.JCBPCruzada.setModel(new DefaultComboBoxModel(new String[]{"SI", "NO"}));
        this.JCBPCruzada.setBorder(BorderFactory.createTitledBorder((Border) null, "Prueba Cruzada", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFSCalidad.setFont(new Font("Arial", 1, 12));
        this.JTFSCalidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Sello Calidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtHora.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtHora.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("hh:mm:ss a"))));
        this.txtHora.setFont(new Font("Tahoma", 1, 12));
        this.jButton2.setFont(new Font("Arial", 1, 12));
        this.jButton2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.jButton2.setText("AGREGAR");
        this.jButton2.addActionListener(new ActionListener() { // from class: Historia.JDTrasfusiones.2
            public void actionPerformed(ActionEvent evt) {
                JDTrasfusiones.this.jButton2ActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(5, 5, 5).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLCUP, -2, 72, -2).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JLProc, -2, 421, -2).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.txtHora, -2, 85, -2).addGap(3, 3, 3).addComponent(this.JTFCodigo, -2, 88, -2).addGap(3, 3, 3).addComponent(this.JTFBolsa, -2, 99, -2)).addComponent(this.jButton2, -2, 229, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(layout.createSequentialGroup().addComponent(this.JTFSCalidad, -2, 104, -2).addGap(3, 3, 3).addComponent(this.JCBPCruzada, -2, 111, -2)).addComponent(this.jButton1, -1, -1, 32767))))).addGap(5, 5, 5)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLCUP, -2, 39, -2).addComponent(this.JLProc, -2, 39, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBPCruzada, -2, 50, -2).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFCodigo, GroupLayout.Alignment.TRAILING, -2, 50, -2).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFSCalidad, -2, 50, -2).addComponent(this.txtHora, -2, 50, -2).addComponent(this.JTFBolsa, -2, 50, -2)))).addGap(5, 5, 5).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jButton1, -1, 50, 32767).addComponent(this.jButton2, -1, -1, 32767)).addGap(5, 5, 5)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        dispose();
    }

    private void mTraeDatos() {
        this.JLCUP.setText(this.xJPTransfuciones.xmodeloPro.getValueAt(this.xJPTransfuciones.JTProc.getSelectedRow(), 2).toString());
        this.JLProc.setText(this.xJPTransfuciones.xmodeloPro.getValueAt(this.xJPTransfuciones.JTProc.getSelectedRow(), 3).toString());
        this.txtHora.setText(this.xJPTransfuciones.xmodeloPro.getValueAt(this.xJPTransfuciones.JTProc.getSelectedRow(), 8).toString());
        this.JTFCodigo.setText(this.xJPTransfuciones.xmodeloPro.getValueAt(this.xJPTransfuciones.JTProc.getSelectedRow(), 1).toString());
        this.JTFBolsa.setText(this.xJPTransfuciones.xmodeloPro.getValueAt(this.xJPTransfuciones.JTProc.getSelectedRow(), 5).toString());
        this.JTFSCalidad.setText(this.xJPTransfuciones.xmodeloPro.getValueAt(this.xJPTransfuciones.JTProc.getSelectedRow(), 6).toString());
        this.JCBPCruzada.setSelectedItem(this.xJPTransfuciones.xmodeloPro.getValueAt(this.xJPTransfuciones.JTProc.getSelectedRow(), 7).toString());
    }

    private void mEnviaDatos() {
        this.xJPTransfuciones.xmodeloPro.setValueAt(this.txtHora.getText(), this.xJPTransfuciones.JTProc.getSelectedRow(), 8);
        this.xJPTransfuciones.xmodeloPro.setValueAt(this.JTFCodigo.getText(), this.xJPTransfuciones.JTProc.getSelectedRow(), 1);
        this.xJPTransfuciones.xmodeloPro.setValueAt(this.JTFBolsa.getText(), this.xJPTransfuciones.JTProc.getSelectedRow(), 5);
        this.xJPTransfuciones.xmodeloPro.setValueAt(this.JTFSCalidad.getText(), this.xJPTransfuciones.JTProc.getSelectedRow(), 6);
        this.xJPTransfuciones.xmodeloPro.setValueAt(this.JCBPCruzada.getSelectedItem(), this.xJPTransfuciones.JTProc.getSelectedRow(), 7);
        this.xJPTransfuciones.xmodeloPro.setValueAt(true, this.xJPTransfuciones.JTProc.getSelectedRow(), 9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton2ActionPerformed(ActionEvent evt) {
        if (!this.JTFCodigo.getText().isEmpty()) {
            if (!this.JTFBolsa.getText().isEmpty()) {
                if (!this.JTFSCalidad.getText().isEmpty()) {
                    mEnviaDatos();
                    dispose();
                    return;
                } else {
                    JOptionPane.showMessageDialog(this, "Digite el Sello de calidad", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                    this.JTFSCalidad.requestFocus();
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Digite el No. de Bolsa", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            this.JTFBolsa.requestFocus();
            return;
        }
        JOptionPane.showMessageDialog(this, "Digite el Código", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
        this.JTFCodigo.requestFocus();
    }
}
