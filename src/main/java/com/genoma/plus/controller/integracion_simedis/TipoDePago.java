package com.genoma.plus.controller.integracion_simedis;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.jpa.projection.ICargarCombo;
import com.genoma.plus.jpa.service.ICargarComboMedioPagoDAO;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/integracion_simedis/TipoDePago.class */
public class TipoDePago extends JDialog {
    private List<ICargarCombo> medioDePago;
    private final ICargarComboMedioPagoDAO xICargarComboMedioPagoDAO;
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private String[] xFormaPago;
    private String[] xMedioPago;
    private ConsultasMySQL xcsmysql;
    List<Object[]> listaDetalleProcedimientoEditar;
    private Metodos metodos;
    private JButton JBGrabar;
    private JComboBox<String> JCFormaPago;
    private JComboBox<String> JCMedioDePago;
    private JLabel jLabel1;
    private JLabel jLabel2;

    public TipoDePago(Frame parent, boolean modal) {
        super(parent, modal);
        this.xICargarComboMedioPagoDAO = (ICargarComboMedioPagoDAO) Principal.contexto.getBean(ICargarComboMedioPagoDAO.class);
        this.xmodelo = new DefaultTableModel();
        this.xcsmysql = new ConsultasMySQL();
        this.listaDetalleProcedimientoEditar = null;
        this.metodos = new Metodos();
        initComponents();
        this.xFormaPago = this.xcsmysql.llenarCombo("select kf.Id ,Nbre  from k_formapago kf ", this.xFormaPago, this.JCFormaPago);
        this.xMedioPago = this.xcsmysql.llenarCombo("SELECT id AS Id, nombre AS Nombre, cuentaDebito codigo FROM medio_pago where estado=1;", this.xMedioPago, this.JCMedioDePago);
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/integracion_simedis/TipoDePago$MiRender.class */
    public class MiRender extends DefaultTableCellRenderer {
        public MiRender() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            return cell;
        }
    }

    private void listarEmpresasBienEstar(String busqueda) {
    }

    private void initComponents() {
        this.JBGrabar = new JButton();
        this.jLabel1 = new JLabel();
        this.JCFormaPago = new JComboBox<>();
        this.jLabel2 = new JLabel();
        this.JCMedioDePago = new JComboBox<>();
        setDefaultCloseOperation(2);
        this.JBGrabar.setFont(new Font("Arial", 1, 12));
        this.JBGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBGrabar.setText("VALIDAR");
        this.JBGrabar.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.integracion_simedis.TipoDePago.1
            public void mouseClicked(MouseEvent evt) {
                TipoDePago.this.JBGrabarMouseClicked(evt);
            }
        });
        this.JBGrabar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.integracion_simedis.TipoDePago.2
            public void actionPerformed(ActionEvent evt) {
                TipoDePago.this.JBGrabarActionPerformed(evt);
            }
        });
        this.jLabel1.setFont(new Font("Segoe UI", 1, 16));
        this.jLabel1.setForeground(new Color(0, 102, 255));
        this.jLabel1.setText("FORMA DE PAGO");
        this.JCFormaPago.setBorder(BorderFactory.createTitledBorder((Border) null, "-", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCFormaPago.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.integracion_simedis.TipoDePago.3
            public void actionPerformed(ActionEvent evt) {
                TipoDePago.this.JCFormaPagoActionPerformed(evt);
            }
        });
        this.jLabel2.setFont(new Font("Segoe UI", 1, 16));
        this.jLabel2.setForeground(new Color(0, 102, 255));
        this.jLabel2.setText("MEDIO DE PAGO");
        this.JCMedioDePago.setBorder(BorderFactory.createTitledBorder((Border) null, "-", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCMedioDePago.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.integracion_simedis.TipoDePago.4
            public void actionPerformed(ActionEvent evt) {
                TipoDePago.this.JCMedioDePagoActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(layout.createSequentialGroup().addGap(90, 90, 90).addComponent(this.jLabel1)).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JBGrabar, -1, 282, 32767)).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JCFormaPago, 0, -1, 32767))).addContainerGap(-1, 32767)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.jLabel2).addGap(77, 77, 77)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JCMedioDePago, 0, -1, 32767).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCFormaPago, -2, 41, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCMedioDePago, -2, -1, -2).addGap(18, 18, 32767).addComponent(this.JBGrabar, -2, 36, -2).addGap(18, 18, 18)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGrabarActionPerformed(ActionEvent evt) {
        JIF_AgendaSimedisBienestar.formaDePagoLiquidacion = Integer.valueOf(this.xFormaPago[this.JCFormaPago.getSelectedIndex()]).intValue();
        System.out.println("FORMA DE PAGO   >>>>>>>>>>>>>>>>>>>>>>>>>   " + JIF_AgendaSimedisBienestar.formaDePagoLiquidacion);
        JIF_AgendaSimedisBienestar.medioDePagoLiquidacion = Integer.valueOf(this.xMedioPago[this.JCMedioDePago.getSelectedIndex()]).intValue();
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGrabarMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCFormaPagoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCMedioDePagoActionPerformed(ActionEvent evt) {
    }
}
