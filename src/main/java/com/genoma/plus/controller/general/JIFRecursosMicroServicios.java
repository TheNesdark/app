package com.genoma.plus.controller.general;

import Utilidades.Metodos;
import Utilidades.MetodosGenericos;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.genoma.plus.controller.general.dto.ModuleDTO;
import com.genoma.plus.controller.general.dto.RecursosMicroserviciosDTO;
import com.genoma.plus.controller.laboratorio.dto.CustomPresenter;
import com.genoma.plus.domains.models.domains.general.RecursosMicroserviciosDomain;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/JIFRecursosMicroServicios.class */
public class JIFRecursosMicroServicios extends JInternalFrame {
    private Metodos metodos;
    private List<ModuleDTO> listModule;
    private RecursosMicroserviciosDTO microserviciosDTO;
    private JComboBox<String> JCB_Modulo;
    private JCheckBox JCH_Estado;
    private JPanel JPI_Datos;
    private JPanel JPI_Historico;
    private JTable JTB_Historico;
    private JTextField JTF_Formulario;
    private JTextField JTF_Identificador;
    private JTextField JTF_UrlRecurso;
    private JTabbedPane JTPInformacion;
    private JScrollPane jScrollPane1;

    public JIFRecursosMicroServicios() {
        initComponents();
        this.metodos = new Metodos();
        nuevo();
    }

    /* JADX WARN: Type inference failed for: r3v37, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JTPInformacion = new JTabbedPane();
        this.JPI_Datos = new JPanel();
        this.JCB_Modulo = new JComboBox<>();
        this.JTF_Formulario = new JTextField();
        this.JTF_UrlRecurso = new JTextField();
        this.JTF_Identificador = new JTextField();
        this.JCH_Estado = new JCheckBox();
        this.JPI_Historico = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.JTB_Historico = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("RECURSOS MICROSERVICIO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifRecursosMicroservicios");
        this.JTPInformacion.setForeground(new Color(0, 103, 0));
        this.JTPInformacion.setFont(new Font("Arial", 1, 14));
        this.JCB_Modulo.setFont(new Font("Arial", 1, 12));
        this.JCB_Modulo.setBorder(BorderFactory.createTitledBorder((Border) null, "Módulo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCB_Modulo.setName("");
        this.JCB_Modulo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIFRecursosMicroServicios.1
            public void actionPerformed(ActionEvent evt) {
                JIFRecursosMicroServicios.this.JCB_ModuloActionPerformed(evt);
            }
        });
        this.JTF_Formulario.setFont(new Font("Arial", 1, 12));
        this.JTF_Formulario.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre Formulario", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_UrlRecurso.setFont(new Font("Arial", 1, 12));
        this.JTF_UrlRecurso.setBorder(BorderFactory.createTitledBorder((Border) null, "Url", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_Identificador.setFont(new Font("Arial", 1, 12));
        this.JTF_Identificador.setBorder(BorderFactory.createTitledBorder((Border) null, "Identificador", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCH_Estado.setFont(new Font("Arial", 1, 12));
        this.JCH_Estado.setSelected(true);
        this.JCH_Estado.setText("Estado");
        GroupLayout JPI_DatosLayout = new GroupLayout(this.JPI_Datos);
        this.JPI_Datos.setLayout(JPI_DatosLayout);
        JPI_DatosLayout.setHorizontalGroup(JPI_DatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosLayout.createSequentialGroup().addGap(15, 15, 15).addGroup(JPI_DatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTF_UrlRecurso).addGroup(JPI_DatosLayout.createSequentialGroup().addComponent(this.JCB_Modulo, -2, 306, -2).addGap(18, 18, 18).addComponent(this.JTF_Formulario)).addGroup(JPI_DatosLayout.createSequentialGroup().addComponent(this.JTF_Identificador, -2, 422, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 174, 32767).addComponent(this.JCH_Estado))).addContainerGap()));
        JPI_DatosLayout.setVerticalGroup(JPI_DatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosLayout.createSequentialGroup().addGap(14, 14, 14).addGroup(JPI_DatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTF_Formulario, -2, 50, -2).addComponent(this.JCB_Modulo, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTF_UrlRecurso, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPI_DatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTF_Identificador, -2, 50, -2).addComponent(this.JCH_Estado)).addContainerGap(107, 32767)));
        this.JTPInformacion.addTab("DATOS", this.JPI_Datos);
        this.JTB_Historico.setFont(new Font("Arial", 1, 12));
        this.JTB_Historico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_Historico.setRowHeight(25);
        this.JTB_Historico.setSelectionMode(0);
        this.jScrollPane1.setViewportView(this.JTB_Historico);
        GroupLayout JPI_HistoricoLayout = new GroupLayout(this.JPI_Historico);
        this.JPI_Historico.setLayout(JPI_HistoricoLayout);
        JPI_HistoricoLayout.setHorizontalGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_HistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -1, 668, 32767).addContainerGap()));
        JPI_HistoricoLayout.setVerticalGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_HistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -2, 278, -2).addContainerGap(-1, 32767)));
        this.JTPInformacion.addTab("HISTORICO", this.JPI_Historico);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPInformacion).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(16, 16, 16).addComponent(this.JTPInformacion).addGap(14, 14, 14)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCB_ModuloActionPerformed(ActionEvent evt) {
    }

    private void llenarComboModule() {
        RecursosMicroserviciosDomain microserviciosDomain = this.metodos.getParametrosEncriptados("13", "jifRecursosMicroservicios");
        new MetodosGenericos();
        Response response = this.metodos.getResteasyClient().target(microserviciosDomain.getUrlRecurso()).request().get();
        int statusCode = response.getStatus();
        if (statusCode == 200) {
            try {
                new CustomPresenter();
                CustomPresenter presenter = (CustomPresenter) this.metodos.getMapper().readValue((String) response.readEntity(String.class), CustomPresenter.class);
                List<ModuleDTO> listModuleLocal = (List) this.metodos.getMapper().readValue(this.metodos.getMapper().writeValueAsString(presenter.getData()), new TypeReference<List<ModuleDTO>>() { // from class: com.genoma.plus.controller.general.JIFRecursosMicroServicios.2
                });
                System.out.println("mapper" + this.metodos.getMapper().writeValueAsString(this.listModule));
                this.listModule = (List) listModuleLocal.stream().filter(e -> {
                    return !e.getState().booleanValue();
                }).sorted((p1, p2) -> {
                    return p1.getName().compareTo(p2.getName());
                }).collect(Collectors.toList());
                this.listModule.forEach(d -> {
                    this.JCB_Modulo.addItem(d.getName());
                });
            } catch (JsonProcessingException e2) {
                Logger.getLogger(JIFRecursosMicroServicios.class.getName()).log(Level.SEVERE, (String) null, e2);
            }
        }
        response.close();
        this.metodos.getResteasyClient().close();
    }

    public void nuevo() {
        this.JCB_Modulo.removeAllItems();
        this.listModule = new ArrayList();
        llenarComboModule();
        this.JTF_Identificador.setText("");
        this.JTF_UrlRecurso.setText("");
        this.JTF_Formulario.setText("");
        this.JCB_Modulo.setSelectedIndex(-1);
        this.microserviciosDTO = RecursosMicroserviciosDTO.builder().build();
    }

    public void grabar() {
        if (this.JCB_Modulo.getSelectedIndex() != -1) {
            if (!this.JTF_Formulario.getText().isEmpty()) {
                if (!this.JTF_UrlRecurso.getText().isEmpty()) {
                    int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (x == 0) {
                        try {
                            System.out.println("" + this.listModule.size());
                            RecursosMicroserviciosDomain microserviciosDomain = this.metodos.getParametrosEncriptados("13", "jifRecursosMicroservicios-save");
                            System.out.println("" + microserviciosDomain.getUrlRecurso());
                            this.microserviciosDTO = RecursosMicroserviciosDTO.builder().nombreFormulario(this.JTF_Formulario.getText()).nombreIdentificador(this.JTF_Identificador.getText()).idModulo(this.listModule.get(this.JCB_Modulo.getSelectedIndex()).getId()).state(Boolean.valueOf(this.JCH_Estado.isSelected())).urlRecurso(this.JTF_UrlRecurso.getText()).build();
                            System.out.println("DAta " + this.microserviciosDTO);
                            Response response = this.metodos.getResteasyClient().target(microserviciosDomain.getUrlRecurso()).request().post(Entity.json(this.metodos.getMapper().writeValueAsString(this.microserviciosDTO)));
                            response.close();
                            this.metodos.getResteasyClient().close();
                        } catch (JsonProcessingException e) {
                            Logger.getLogger(JIFRecursosMicroServicios.class.getName()).log(Level.SEVERE, (String) null, e);
                        }
                        nuevo();
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe llenar el campo url", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTF_UrlRecurso.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe llenar el campo nombre formulario", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTF_Formulario.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar el módulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCB_Modulo.requestFocus();
    }
}
