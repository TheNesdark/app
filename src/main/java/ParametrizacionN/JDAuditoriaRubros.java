package ParametrizacionN;

import Utilidades.ConsultasMySQL;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JDAuditoriaRubros.class */
public class JDAuditoriaRubros extends JDialog {
    public DefaultTableModel xmodeloROrganizar;
    private ConsultasMySQL xct;
    public Object[] xdatos;
    private JIFFRubrosN xJIFFRubrosN;
    private JTable JTDetalleRubrosOrganizar;
    private JButton jButton1;
    private JScrollPane jScrollPane1;

    public JDAuditoriaRubros(Frame parent, boolean modal, JIFFRubrosN xJIFFRubrosN) {
        super(parent, modal);
        this.xct = new ConsultasMySQL();
        initComponents();
        setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setTitle("AUDITORIA DE RUBRO");
        this.xJIFFRubrosN = xJIFFRubrosN;
        mCreaModeloRubros();
        mAuditarRubros();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModeloRubros() {
        this.xmodeloROrganizar = new DefaultTableModel(new Object[0], new String[]{"Rubro", "RubroPadre Asignado", "RubroPadre Encontrado"}) { // from class: ParametrizacionN.JDAuditoriaRubros.1
            Class[] types = {String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleRubrosOrganizar.setModel(this.xmodeloROrganizar);
        this.JTDetalleRubrosOrganizar.getColumnModel().getColumn(0).setPreferredWidth(150);
        this.JTDetalleRubrosOrganizar.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalleRubrosOrganizar.getColumnModel().getColumn(2).setPreferredWidth(150);
    }

    private void mAuditarRubros() {
        int fila = 0;
        if (this.xJIFFRubrosN.JTDetalleR.getRowCount() > 0) {
            int rowCount = this.xJIFFRubrosN.JTDetalleR.getRowCount();
            for (int i = 0; i < rowCount; i++) {
                String rpadre = this.xJIFFRubrosN.xmodeloR.getValueAt(i, 8).toString();
                if (!rpadre.equals("-1")) {
                    int tamanio = this.xJIFFRubrosN.xmodeloR.getValueAt(i, 0).toString().trim().length();
                    int cont = 1;
                    int j = 0;
                    while (true) {
                        if (j < rowCount) {
                            int tamanioRubroPadre = this.xJIFFRubrosN.xmodeloR.getValueAt(j, 0).toString().trim().length();
                            if (j == rowCount - 1) {
                                cont++;
                                j = 0;
                            }
                            if (tamanioRubroPadre < tamanio) {
                                System.out.println("rubro padre-->" + this.xJIFFRubrosN.xmodeloR.getValueAt(j, 0).toString().trim() + " rubro hijo-->" + this.xJIFFRubrosN.xmodeloR.getValueAt(i, 0).toString().trim().substring(0, tamanio - cont));
                                if (this.xJIFFRubrosN.xmodeloR.getValueAt(j, 0).toString().trim().equals(this.xJIFFRubrosN.xmodeloR.getValueAt(i, 0).toString().trim().substring(0, tamanio - cont))) {
                                    if (!rpadre.equals(this.xJIFFRubrosN.xmodeloR.getValueAt(j, 0).toString().trim())) {
                                        this.xmodeloROrganizar.addRow(this.xdatos);
                                        this.xmodeloROrganizar.setValueAt(this.xJIFFRubrosN.xmodeloR.getValueAt(i, 0).toString(), fila, 0);
                                        this.xmodeloROrganizar.setValueAt(rpadre, fila, 1);
                                        this.xmodeloROrganizar.setValueAt(this.xJIFFRubrosN.xmodeloR.getValueAt(j, 0).toString().trim(), fila, 2);
                                        fila++;
                                    }
                                }
                            }
                            j++;
                        }
                    }
                }
            }
        }
    }

    private static boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalleRubrosOrganizar = new JTable();
        this.jButton1 = new JButton();
        setDefaultCloseOperation(2);
        this.JTDetalleRubrosOrganizar.setFont(new Font("Tahoma", 1, 12));
        this.JTDetalleRubrosOrganizar.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleRubrosOrganizar.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleRubrosOrganizar.setSelectionForeground(Color.red);
        this.jScrollPane1.setViewportView(this.JTDetalleRubrosOrganizar);
        this.jButton1.setFont(new Font("Arial", 1, 12));
        this.jButton1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.jButton1.setText("Aplicar corrección");
        this.jButton1.addActionListener(new ActionListener() { // from class: ParametrizacionN.JDAuditoriaRubros.2
            public void actionPerformed(ActionEvent evt) {
                JDAuditoriaRubros.this.jButton1ActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -1, 502, 32767).addComponent(this.jButton1, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -2, 199, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jButton1).addGap(22, 22, 22)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        if (this.JTDetalleRubrosOrganizar.getRowCount() > 0) {
            mGuardaCorreccion();
        } else {
            JOptionPane.showMessageDialog(this, "No se puede guardar, no hay datos en la tabla", "VERIFICAR", 1);
        }
    }

    private void mGuardaCorreccion() {
        int n = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "Verificar", 0, 3);
        if (n == 0) {
            for (int i = 0; i < this.JTDetalleRubrosOrganizar.getRowCount(); i++) {
                String sql = "UPDATE  pp_rubros\nSET  IdPadre='" + this.xmodeloROrganizar.getValueAt(i, 2).toString() + "' WHERE Id='" + this.xmodeloROrganizar.getValueAt(i, 0).toString() + "' AND idEncabezadoRubro='" + this.xJIFFRubrosN.xIdMaestro[this.xJIFFRubrosN.JCMaestro.getSelectedIndex()] + "';";
                this.xct.ejecutarSQL(sql);
                this.xct.cerrarConexionBd();
            }
            this.xJIFFRubrosN.mBuscarRubros();
            dispose();
        }
    }
}
