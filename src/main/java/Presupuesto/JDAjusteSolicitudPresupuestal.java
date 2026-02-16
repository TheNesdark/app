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

/* JADX INFO: loaded from: GenomaP.jar:Presupuesto/JDAjusteSolicitudPresupuestal.class */
public class JDAjusteSolicitudPresupuestal extends JDialog {
    private DefaultTableModel modeloSolicitud;
    private Metodos metodos;
    private JIFFSolicitudPresupuestal jifsolicitudPresupuesto;
    private Object[] datos;
    private Long idSolicitud;
    private JButton JBTGuardar;
    private JScrollPane JSPDetalle;
    public JTable JTDetalle;

    public JDAjusteSolicitudPresupuestal(Frame parent, boolean modal, JIFFSolicitudPresupuestal JIFSolicitudPresupeusto, Long idSolicitudDetalle) {
        super(parent, modal);
        this.metodos = new Metodos();
        initComponents();
        setTitle("AJUSTE SOLICITUD PRESUPUESTO");
        setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.jifsolicitudPresupuesto = JIFSolicitudPresupeusto;
        this.idSolicitud = idSolicitudDetalle;
        cargarDatos();
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JBTGuardar = new JButton();
        setDefaultCloseOperation(2);
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JBTGuardar.setFont(new Font("Arial", 1, 12));
        this.JBTGuardar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBTGuardar.setText("Guardar");
        this.JBTGuardar.addActionListener(new ActionListener() { // from class: Presupuesto.JDAjusteSolicitudPresupuestal.1
            public void actionPerformed(ActionEvent evt) {
                JDAjusteSolicitudPresupuestal.this.JBTGuardarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle, -1, 688, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JBTGuardar, -2, 213, -2).addGap(0, 0, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle, -2, 137, -2).addGap(10, 10, 10).addComponent(this.JBTGuardar, -2, 46, -2).addGap(10, 10, 10)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGuardarActionPerformed(ActionEvent evt) {
        for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
            double valorTotal = Double.parseDouble(this.modeloSolicitud.getValueAt(i, 3).toString()) + Double.parseDouble(this.modeloSolicitud.getValueAt(i, 2).toString());
            if (valorTotal <= Double.parseDouble(this.modeloSolicitud.getValueAt(i, 4).toString())) {
                SolicitudDetalleDTO detalleSolicitud = new SolicitudDetalleDTO();
                detalleSolicitud.setValor(valorTotal);
                detalleSolicitud.setId(Integer.parseInt(this.idSolicitud + ""));
                detalleSolicitud.setId(this.idSolicitud.intValue());
                this.jifsolicitudPresupuesto.presupuestoDAO.actualizaAjusteSolicitudRubro(detalleSolicitud);
                this.jifsolicitudPresupuesto.buscarSolicitudes(Integer.valueOf(Principal.txtNo.getText()).intValue());
                this.jifsolicitudPresupuesto.presupuestoDAO.actualizaAjusteEncabezado(Integer.valueOf(Principal.txtNo.getText()).intValue(), valorTotal, this.jifsolicitudPresupuesto.JTAObservacionG.getText(), this.jifsolicitudPresupuesto.ccUnidadFuncional.getId().toString());
            } else {
                JOptionPane.showMessageDialog(this, "La suma entre el valor y el ajuste no puede ser superior al saldo", "VERIFICAR VALOR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
        }
    }

    private void cargarDatos() {
        crearModeloAjuste();
        for (int i = 0; i < this.jifsolicitudPresupuesto.JTDetalle.getRowCount(); i++) {
            this.modeloSolicitud.addRow(this.datos);
            this.modeloSolicitud.setValueAt(this.jifsolicitudPresupuesto.modeloSolicitud.getValueAt(i, 1), i, 0);
            this.modeloSolicitud.setValueAt(this.jifsolicitudPresupuesto.modeloSolicitud.getValueAt(i, 2), i, 1);
            this.modeloSolicitud.setValueAt(this.jifsolicitudPresupuesto.modeloSolicitud.getValueAt(i, 8), i, 2);
            this.modeloSolicitud.setValueAt(0, i, 3);
            this.modeloSolicitud.setValueAt(Double.valueOf(this.jifsolicitudPresupuesto.saldoRubro(this.jifsolicitudPresupuesto.modeloSolicitud.getValueAt(i, 0).toString())), i, 4);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloAjuste() {
        this.modeloSolicitud = new DefaultTableModel(new Object[0], new String[]{"codigo rubro", "nombre", "valor", "valor a ajustar", "saldo"}) { // from class: Presupuesto.JDAjusteSolicitudPresupuestal.2
            Class[] types = {String.class, String.class, Double.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, true, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.modeloSolicitud);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(80);
    }
}
