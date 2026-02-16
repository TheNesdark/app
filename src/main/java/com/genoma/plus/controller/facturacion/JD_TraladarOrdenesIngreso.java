package com.genoma.plus.controller.facturacion;

import Facturacion.JPProcedimientos;
import com.genoma.plus.dao.facturacion.LiquidacionOrdenesServicioDAO;
import com.genoma.plus.dao.impl.facturacion.LiquidacionOrdenesServiciosDAOImpl;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/JD_TraladarOrdenesIngreso.class */
public class JD_TraladarOrdenesIngreso extends JDialog {
    private LiquidacionOrdenesServicioDAO liquidacionOrdenesServiciosDAO;
    private final JPProcedimientos jPProcedimientos;
    private String[] idIngreso;
    private ButtonGroup JBG_Filtro;
    private JButton JBT_Ok;
    private JButton JBT_Salir;
    private JComboBox<String> JCB_Ingresos;
    private JLabel jLabel1;

    public JD_TraladarOrdenesIngreso(Frame parent, boolean modal, JPProcedimientos jPProcedimientos) {
        super(parent, modal);
        initComponents();
        this.jPProcedimientos = jPProcedimientos;
        springStart();
        nuevo();
    }

    private void initComponents() {
        this.JBG_Filtro = new ButtonGroup();
        this.jLabel1 = new JLabel();
        this.JCB_Ingresos = new JComboBox<>();
        this.JBT_Ok = new JButton();
        this.JBT_Salir = new JButton();
        setDefaultCloseOperation(2);
        this.jLabel1.setFont(new Font("Arial", 1, 14));
        this.jLabel1.setForeground(Color.red);
        this.jLabel1.setHorizontalAlignment(0);
        this.jLabel1.setText("INGRESO DESTINO");
        this.jLabel1.setBorder(BorderFactory.createBevelBorder(0));
        this.JCB_Ingresos.setFont(new Font("Arial", 1, 12));
        this.JCB_Ingresos.setBorder(BorderFactory.createTitledBorder((Border) null, "Información Ingreso", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBT_Ok.setFont(new Font("Arial", 1, 12));
        this.JBT_Ok.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBT_Ok.setText("Grabar");
        this.JBT_Ok.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JD_TraladarOrdenesIngreso.1
            public void actionPerformed(ActionEvent evt) {
                JD_TraladarOrdenesIngreso.this.JBT_OkActionPerformed(evt);
            }
        });
        this.JBT_Salir.setFont(new Font("Arial", 1, 12));
        this.JBT_Salir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBT_Salir.setText("Salir");
        this.JBT_Salir.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JD_TraladarOrdenesIngreso.2
            public void actionPerformed(ActionEvent evt) {
                JD_TraladarOrdenesIngreso.this.JBT_SalirActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel1, -2, 437, -2).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addComponent(this.JBT_Ok, -2, 200, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBT_Salir, -2, 200, -2)).addComponent(this.JCB_Ingresos, GroupLayout.Alignment.LEADING, -2, 435, -2))).addContainerGap(14, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(17, 17, 17).addComponent(this.jLabel1).addGap(18, 18, 18).addComponent(this.JCB_Ingresos, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBT_Ok, -2, 50, -2).addComponent(this.JBT_Salir, -2, 50, -2)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_OkActionPerformed(ActionEvent evt) {
        if (this.JCB_Ingresos.getSelectedIndex() != -1) {
            this.jPProcedimientos.trasladarOrdenIngreso(Long.valueOf(this.idIngreso[this.JCB_Ingresos.getSelectedIndex()]));
            dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_SalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    private void springStart() {
        this.liquidacionOrdenesServiciosDAO = (LiquidacionOrdenesServiciosDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("liquidacionOrdenesServiciosDAOImpl");
    }

    private void nuevo() {
        List<Object[]> listadoIngresos = this.liquidacionOrdenesServiciosDAO.listadoIngresoDestino(Long.valueOf(this.jPProcedimientos.getXidingreso()), Long.valueOf(this.jPProcedimientos.xjifliq.xjppersona.getIdPersona()));
        this.idIngreso = new String[listadoIngresos.size()];
        this.JCB_Ingresos.removeAllItems();
        for (int z = 0; z < listadoIngresos.size(); z++) {
            this.JCB_Ingresos.addItem(listadoIngresos.get(z)[1].toString());
            this.idIngreso[z] = listadoIngresos.get(z)[0].toString();
        }
    }
}
