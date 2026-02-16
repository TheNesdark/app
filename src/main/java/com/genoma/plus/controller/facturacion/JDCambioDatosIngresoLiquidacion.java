package com.genoma.plus.controller.facturacion;

import Acceso.Principal;
import com.genoma.plus.jpa.entities.EmpresaContConvenioEntity;
import com.genoma.plus.jpa.entities.GContratos;
import com.genoma.plus.jpa.entities.GEmpresa;
import com.genoma.plus.jpa.entities.SubgrupoEmpresaEntity;
import com.genoma.plus.jpa.service.IEmpresaContConvenioService;
import com.genoma.plus.jpa.service.IGContratosService;
import com.genoma.plus.jpa.service.ILiquidacionService;
import com.genoma.plus.jpa.service.ISubgrupoEmpresaService;
import com.genoma.plus.jpa.service.IngresoService;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/JDCambioDatosIngresoLiquidacion.class */
public class JDCambioDatosIngresoLiquidacion extends JDialog {
    private final IEmpresaContConvenioService iEmpresaContConvenioService;
    private final ISubgrupoEmpresaService iSubgrupoEmpresaService;
    private final IGContratosService iGContratosService;
    private final IngresoService ingresoService;
    private final ILiquidacionService iLiquidacionService;
    private GEmpresa idEmpresa;
    private EmpresaContConvenioEntity empresaContConvenioEntitys;
    private List<EmpresaContConvenioEntity> empresaContConvenioEntity;
    private List<GContratos> contratos;
    private List<SubgrupoEmpresaEntity> subgruposervicioEntity;
    private Boolean estado;
    private List<Long> idIngreso;
    private List<Long> idLiquidacion;
    private JButton JBT_Actualizar;
    private JButton JBT_Salir;
    private JComboBox JCBContrato;
    private JComboBox JCBConvenio;
    private JComboBox JCBSubGrupo;
    private JPanel jPanel1;

    public JDCambioDatosIngresoLiquidacion(Frame parent, boolean modal, GEmpresa idEmpresa, List<Long> idIngreso, List<Long> idLiquidacion, EmpresaContConvenioEntity idEmpresaCont) {
        super(parent, modal);
        this.iEmpresaContConvenioService = (IEmpresaContConvenioService) Principal.contexto.getBean(IEmpresaContConvenioService.class);
        this.iSubgrupoEmpresaService = (ISubgrupoEmpresaService) Principal.contexto.getBean(ISubgrupoEmpresaService.class);
        this.iGContratosService = (IGContratosService) Principal.contexto.getBean(IGContratosService.class);
        this.ingresoService = (IngresoService) Principal.contexto.getBean(IngresoService.class);
        this.iLiquidacionService = (ILiquidacionService) Principal.contexto.getBean(ILiquidacionService.class);
        initComponents();
        this.empresaContConvenioEntitys = new EmpresaContConvenioEntity();
        this.empresaContConvenioEntitys = idEmpresaCont;
        this.idEmpresa = new GEmpresa();
        this.idEmpresa = idEmpresa;
        this.idIngreso = idIngreso;
        this.idLiquidacion = idLiquidacion;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        nuevo();
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JCBConvenio = new JComboBox();
        this.JCBContrato = new JComboBox();
        this.JCBSubGrupo = new JComboBox();
        this.JBT_Salir = new JButton();
        this.JBT_Actualizar = new JButton();
        setDefaultCloseOperation(2);
        setTitle("ACTUALIZACIÓN INFORMACIÓN DE INGRESO Y LIQUIDACIÓN");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN NUEVA", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBConvenio.setFont(new Font("Arial", 1, 12));
        this.JCBConvenio.setBorder(BorderFactory.createTitledBorder((Border) null, "Convenio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBConvenio.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.facturacion.JDCambioDatosIngresoLiquidacion.1
            public void itemStateChanged(ItemEvent evt) {
                JDCambioDatosIngresoLiquidacion.this.JCBConvenioItemStateChanged(evt);
            }
        });
        this.JCBContrato.setFont(new Font("Arial", 1, 12));
        this.JCBContrato.setBorder(BorderFactory.createTitledBorder((Border) null, "Contrato", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBSubGrupo.setFont(new Font("Arial", 1, 12));
        this.JCBSubGrupo.setBorder(BorderFactory.createTitledBorder((Border) null, "SubGrupo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBSubGrupo, 0, -1, 32767).addComponent(this.JCBConvenio, 0, -1, 32767).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JCBContrato, -2, 295, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767))).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JCBConvenio, -2, 50, -2).addGap(18, 18, 18).addComponent(this.JCBContrato).addGap(18, 18, 18).addComponent(this.JCBSubGrupo, -1, 50, 32767).addGap(33, 33, 33)));
        this.JBT_Salir.setFont(new Font("Arial", 1, 12));
        this.JBT_Salir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBT_Salir.setText("Salir");
        this.JBT_Salir.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JDCambioDatosIngresoLiquidacion.2
            public void actionPerformed(ActionEvent evt) {
                JDCambioDatosIngresoLiquidacion.this.JBT_SalirActionPerformed(evt);
            }
        });
        this.JBT_Actualizar.setFont(new Font("Arial", 1, 12));
        this.JBT_Actualizar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBT_Actualizar.setText("Guardar");
        this.JBT_Actualizar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JDCambioDatosIngresoLiquidacion.3
            public void actionPerformed(ActionEvent evt) {
                JDCambioDatosIngresoLiquidacion.this.JBT_ActualizarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JBT_Actualizar, -2, 318, -2).addGap(18, 18, 18).addComponent(this.JBT_Salir, -2, 318, -2).addGap(0, 0, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBT_Salir, -1, 50, 32767).addComponent(this.JBT_Actualizar, -1, 50, 32767)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBConvenioItemStateChanged(ItemEvent evt) {
        this.JCBContrato.setSelectedIndex(-1);
        cargarComboSubgrupo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_SalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_ActualizarActionPerformed(ActionEvent evt) {
        System.out.println("liquidacion -> " + this.idLiquidacion);
        System.out.println("ingreso -> " + this.idIngreso);
        if (this.JCBContrato.getSelectedIndex() != -1) {
            if (this.JCBSubGrupo.getSelectedIndex() != -1) {
                this.ingresoService.actualizarIformacionConvenio(this.idIngreso, this.empresaContConvenioEntity.get(this.JCBConvenio.getSelectedIndex()).getId(), this.contratos.get(this.JCBContrato.getSelectedIndex()).getId());
                this.iLiquidacionService.actualizarInformacionSubgrupo(this.idLiquidacion, this.empresaContConvenioEntity.get(this.JCBConvenio.getSelectedIndex()).getId(), this.subgruposervicioEntity.get(this.JCBSubGrupo.getSelectedIndex()).getId());
                dispose();
                return;
            } else {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un subgrupo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBSubGrupo.requestFocus();
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Debe seleccionar un contrato", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBContrato.requestFocus();
    }

    private void nuevo() {
        this.estado = false;
        this.empresaContConvenioEntity = new ArrayList();
        this.empresaContConvenioEntity = this.iEmpresaContConvenioService.listaConveniosPorIdEmpresa(this.idEmpresa, false);
        this.JCBConvenio.removeAllItems();
        this.empresaContConvenioEntity.forEach(item -> {
            this.JCBConvenio.addItem(item.getNbre());
            System.out.println("item.getId() -> " + item.getId());
        });
        if (this.empresaContConvenioEntity.size() > 1) {
            this.JCBConvenio.setSelectedIndex(-1);
        }
        System.out.println("empresaContConvenioEntitys -> " + this.empresaContConvenioEntitys);
        this.contratos = new ArrayList();
        this.contratos = this.iGContratosService.listaContratosPorConvenio(this.empresaContConvenioEntitys);
        this.JCBContrato.removeAllItems();
        this.contratos.forEach(item2 -> {
            this.JCBContrato.addItem(item2.getNbreContrato());
        });
        this.JCBContrato.setSelectedIndex(-1);
        this.estado = true;
    }

    private void cargarComboSubgrupo() {
        if (this.JCBConvenio.getSelectedIndex() != -1 && this.estado.booleanValue()) {
            this.subgruposervicioEntity = new ArrayList();
            this.subgruposervicioEntity = this.iSubgrupoEmpresaService.listaSubgrupoEmpresaPorIdConvenioOrdenadoPorNombre(this.empresaContConvenioEntity.get(this.JCBConvenio.getSelectedIndex()), true);
            System.out.println("tamaño subgrupo" + this.subgruposervicioEntity.size());
            this.subgruposervicioEntity.forEach(item -> {
                this.JCBSubGrupo.addItem(item.getSubgruposervicioEntity().getIdGrupoServicio().getNbre() + " - " + item.getSubgruposervicioEntity().getNbre());
            });
            if (this.subgruposervicioEntity.size() > 1) {
                this.JCBSubGrupo.setSelectedIndex(-1);
            }
        }
    }
}
