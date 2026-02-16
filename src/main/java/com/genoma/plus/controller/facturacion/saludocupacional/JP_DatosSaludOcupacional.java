package com.genoma.plus.controller.facturacion.saludocupacional;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/saludocupacional/JP_DatosSaludOcupacional.class */
public class JP_DatosSaludOcupacional extends JPanel {
    private JComboBox JCBTipoExamen;
    public JComboBox cboEmpresa;

    public JP_DatosSaludOcupacional() {
        initComponents();
    }

    private void initComponents() {
        this.JCBTipoExamen = new JComboBox();
        this.cboEmpresa = new JComboBox();
        this.JCBTipoExamen.setFont(new Font("Arial", 1, 12));
        this.JCBTipoExamen.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Exámen", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.cboEmpresa.setFont(new Font("Arial", 1, 12));
        this.cboEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Convenio a Facturar", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.cboEmpresa.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.facturacion.saludocupacional.JP_DatosSaludOcupacional.1
            public void itemStateChanged(ItemEvent evt) {
                JP_DatosSaludOcupacional.this.cboEmpresaItemStateChanged(evt);
            }
        });
        this.cboEmpresa.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.facturacion.saludocupacional.JP_DatosSaludOcupacional.2
            public void mouseClicked(MouseEvent evt) {
                JP_DatosSaludOcupacional.this.cboEmpresaMouseClicked(evt);
            }
        });
        this.cboEmpresa.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.saludocupacional.JP_DatosSaludOcupacional.3
            public void actionPerformed(ActionEvent evt) {
                JP_DatosSaludOcupacional.this.cboEmpresaActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.cboEmpresa, -2, 350, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipoExamen, -2, 212, -2).addContainerGap(426, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(14, 14, 14).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.cboEmpresa, -2, -1, -2).addComponent(this.JCBTipoExamen, -2, 50, -2)).addContainerGap(86, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboEmpresaItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboEmpresaMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboEmpresaActionPerformed(ActionEvent evt) {
    }
}
