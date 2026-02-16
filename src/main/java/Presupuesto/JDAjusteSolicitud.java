package Presupuesto;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.dto.presupuesto.SolicitudDetalleDTO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Presupuesto/JDAjusteSolicitud.class */
public class JDAjusteSolicitud extends JDialog {
    private DefaultTableModel xmodelo;
    private Metodos xmt;
    private JIFFSolicitudPTO_v2 xJIFFSolicitudPTO_v2;
    private Object[] xdatos;
    public JTable JTDetalle;
    private JButton jButton1;
    private JScrollPane jScrollPane2;

    public JDAjusteSolicitud(Frame parent, boolean modal, JIFFSolicitudPTO_v2 xJIFFSolicitudPTO_v2) {
        super(parent, modal);
        this.xmt = new Metodos();
        initComponents();
        setTitle("AJUSTE SOLICITUD PRESUPUESTO");
        setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.xJIFFSolicitudPTO_v2 = xJIFFSolicitudPTO_v2;
        mLlenaTabla();
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jScrollPane2 = new JScrollPane();
        this.JTDetalle = new JTable();
        this.jButton1 = new JButton();
        setDefaultCloseOperation(2);
        this.jScrollPane2.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.jScrollPane2.setViewportView(this.JTDetalle);
        this.jButton1.setFont(new Font("Arial", 1, 12));
        this.jButton1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.jButton1.setText("Guardar");
        this.jButton1.addActionListener(new ActionListener() { // from class: Presupuesto.JDAjusteSolicitud.1
            public void actionPerformed(ActionEvent evt) {
                JDAjusteSolicitud.this.jButton1ActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane2, -1, 688, 32767).addGroup(layout.createSequentialGroup().addComponent(this.jButton1, -2, 213, -2).addGap(0, 0, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane2, -2, 137, -2).addGap(10, 10, 10).addComponent(this.jButton1, -2, 46, -2).addGap(10, 10, 10)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        int x = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (x == 0) {
            double total = 0.0d;
            for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
                total = total + Double.valueOf(this.xmodelo.getValueAt(i, 4).toString()).doubleValue() + Double.valueOf(this.xmodelo.getValueAt(i, 3).toString()).doubleValue();
                if (Double.valueOf(this.xmodelo.getValueAt(i, 4).toString()).doubleValue() != 0.0d) {
                    double valorTotal = Double.valueOf(this.xmodelo.getValueAt(i, 4).toString()).doubleValue() + Double.valueOf(this.xmodelo.getValueAt(i, 3).toString()).doubleValue();
                    System.out.println("total-->" + valorTotal);
                    System.out.println("saldo-->" + Double.valueOf(this.xmodelo.getValueAt(i, 5).toString()));
                    if (valorTotal <= Double.valueOf(this.xmodelo.getValueAt(i, 5).toString()).doubleValue()) {
                        SolicitudDetalleDTO sd = new SolicitudDetalleDTO();
                        sd.setValor(valorTotal);
                        sd.setId(Integer.valueOf(this.xmodelo.getValueAt(i, 0).toString()).intValue());
                        this.xJIFFSolicitudPTO_v2.presupuestoDAO.actualizaAjusteSolicitudRubro(sd);
                        this.xJIFFSolicitudPTO_v2.mBuscaRubrosSolicitud(Integer.valueOf(Principal.txtNo.getText()).intValue());
                    }
                }
            }
            this.xJIFFSolicitudPTO_v2.presupuestoDAO.actualizaAjusteEncabezado(Integer.valueOf(Principal.txtNo.getText()).intValue(), total, this.xJIFFSolicitudPTO_v2.JTAObservacionG.getText(), this.xJIFFSolicitudPTO_v2.xidunidadfuncional[this.xJIFFSolicitudPTO_v2.JCBUnidadF.getSelectedIndex()][0]);
            JOptionPane.showMessageDialog(this, "Se actualizaron los valores correctamente", "EXITO", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            dispose();
        }
    }

    private void mLlenaTabla() {
        mCrearModeloDatosSol();
        for (int i = 0; i < this.xJIFFSolicitudPTO_v2.JTDetalle.getRowCount(); i++) {
            this.xmodelo.addRow(this.xdatos);
            this.xmodelo.setValueAt(this.xJIFFSolicitudPTO_v2.xmodelo.getValueAt(i, 0), i, 0);
            this.xmodelo.setValueAt(this.xJIFFSolicitudPTO_v2.xmodelo.getValueAt(i, 1), i, 1);
            this.xmodelo.setValueAt(this.xJIFFSolicitudPTO_v2.xmodelo.getValueAt(i, 2), i, 2);
            this.xmodelo.setValueAt(this.xJIFFSolicitudPTO_v2.xmodelo.getValueAt(i, 3), i, 3);
            this.xmodelo.setValueAt(0, i, 4);
            this.xmodelo.setValueAt(Double.valueOf(this.xJIFFSolicitudPTO_v2.mSaldoRubro(this.xmodelo.getValueAt(i, 1).toString())), i, 5);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosSol() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "CodRubro", "Nombre", "Valor", "Ajuste", "Saldo"}) { // from class: Presupuesto.JDAjusteSolicitud.2
            Class[] types = {Long.class, String.class, String.class, Double.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false, true, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(80);
    }
}
