package com.genoma.plus.controller.historia;

import Utilidades.Metodos;
import com.genoma.plus.dao.historia.AntecedentesPatologicosPersonalesDAO;
import com.genoma.plus.dao.impl.historia.AntecedentesPatologicosPersonalesDAOImpl;
import com.genoma.plus.dto.historia.AntecedentesPatologicosPersonalesDTO;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/JPA_AntecedentesPersonalesTabla.class */
public class JPA_AntecedentesPersonalesTabla extends JPanel {
    private AntecedentesPatologicosPersonalesDAO xAntecedentesPatologicosPersonalesDato;
    private DefaultTableModel xmodelo;
    private Object[] xDato;
    private final Metodos xmetodo = new Metodos();
    private final String xIdAtencion;
    private final String xIdPaciente;
    private final String xidTipoHistoria;
    private final String idSexo;
    private final String fechaAtencion;
    private final String fechaNacimiento;
    private JButton JBTGuardar;
    private JCheckBox JCH_ValorporDefecto;
    private JPanel JPI_DAntecedentes;
    private JScrollPane JSP_Antecedentes;
    private JTable JTB_Antecedentes;
    private JTabbedPane JTB_Datos;

    public JPA_AntecedentesPersonalesTabla(String xIdAtencion, String xIdPaciente, String xidTipoHistoria, String idSexo, String fechaAtencion, String fechaNacimiento) {
        initComponents();
        springStart();
        this.xIdAtencion = xIdAtencion;
        this.xIdPaciente = xIdPaciente;
        this.xidTipoHistoria = xidTipoHistoria;
        this.idSexo = idSexo;
        this.fechaAtencion = fechaAtencion;
        this.fechaNacimiento = fechaNacimiento;
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JTB_Datos = new JTabbedPane();
        this.JPI_DAntecedentes = new JPanel();
        this.JSP_Antecedentes = new JScrollPane();
        this.JTB_Antecedentes = new JTable();
        this.JCH_ValorporDefecto = new JCheckBox();
        this.JBTGuardar = new JButton();
        setName("jpantecedentesppersonalest");
        addAncestorListener(new AncestorListener() { // from class: com.genoma.plus.controller.historia.JPA_AntecedentesPersonalesTabla.1
            public void ancestorMoved(AncestorEvent evt) {
            }

            public void ancestorAdded(AncestorEvent evt) {
            }

            public void ancestorRemoved(AncestorEvent evt) {
                JPA_AntecedentesPersonalesTabla.this.formAncestorRemoved(evt);
            }
        });
        this.JTB_Datos.setForeground(new Color(0, 103, 0));
        this.JTB_Datos.setFont(new Font("Arial", 1, 14));
        this.JTB_Datos.addAncestorListener(new AncestorListener() { // from class: com.genoma.plus.controller.historia.JPA_AntecedentesPersonalesTabla.2
            public void ancestorMoved(AncestorEvent evt) {
            }

            public void ancestorAdded(AncestorEvent evt) {
            }

            public void ancestorRemoved(AncestorEvent evt) {
                JPA_AntecedentesPersonalesTabla.this.JTB_DatosAncestorRemoved(evt);
            }
        });
        this.JTB_Antecedentes.setFont(new Font("Arial", 1, 12));
        this.JTB_Antecedentes.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_Antecedentes.setRowHeight(50);
        this.JTB_Antecedentes.setSelectionBackground(Color.white);
        this.JTB_Antecedentes.setSelectionForeground(Color.red);
        this.JTB_Antecedentes.setSelectionMode(0);
        this.JSP_Antecedentes.setViewportView(this.JTB_Antecedentes);
        this.JCH_ValorporDefecto.setFont(new Font("Arial", 1, 12));
        this.JCH_ValorporDefecto.setForeground(Color.red);
        this.JCH_ValorporDefecto.setText("Utilizar valor por defecto?");
        this.JCH_ValorporDefecto.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPA_AntecedentesPersonalesTabla.3
            public void actionPerformed(ActionEvent evt) {
                JPA_AntecedentesPersonalesTabla.this.JCH_ValorporDefectoActionPerformed(evt);
            }
        });
        this.JBTGuardar.setFont(new Font("Arial", 1, 14));
        this.JBTGuardar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGuardar.setText("Guardar");
        this.JBTGuardar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPA_AntecedentesPersonalesTabla.4
            public void actionPerformed(ActionEvent evt) {
                JPA_AntecedentesPersonalesTabla.this.JBTGuardarActionPerformed(evt);
            }
        });
        GroupLayout JPI_DAntecedentesLayout = new GroupLayout(this.JPI_DAntecedentes);
        this.JPI_DAntecedentes.setLayout(JPI_DAntecedentesLayout);
        JPI_DAntecedentesLayout.setHorizontalGroup(JPI_DAntecedentesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DAntecedentesLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DAntecedentesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTGuardar, -1, -1, 32767).addComponent(this.JSP_Antecedentes, -1, 781, 32767).addGroup(JPI_DAntecedentesLayout.createSequentialGroup().addComponent(this.JCH_ValorporDefecto).addGap(0, 0, 32767))).addContainerGap()));
        JPI_DAntecedentesLayout.setVerticalGroup(JPI_DAntecedentesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_DAntecedentesLayout.createSequentialGroup().addContainerGap().addComponent(this.JCH_ValorporDefecto).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSP_Antecedentes, -2, 432, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTGuardar, -1, 50, 32767).addContainerGap()));
        this.JTB_Datos.addTab("ANTECEDENTES", this.JPI_DAntecedentes);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(15, 15, 15).addComponent(this.JTB_Datos).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTB_Datos).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formAncestorRemoved(AncestorEvent evt) {
        mGrabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_ValorporDefectoActionPerformed(ActionEvent evt) {
        if (this.JCH_ValorporDefecto.isSelected()) {
            for (int i = 0; i < this.JTB_Antecedentes.getRowCount(); i++) {
                if (Long.valueOf(this.xmodelo.getValueAt(i, 3).toString()).longValue() == 0 && this.xmodelo.getValueAt(i, 2).toString().equals("")) {
                    this.xmodelo.setValueAt(this.xmodelo.getValueAt(i, 4).toString(), i, 2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_DatosAncestorRemoved(AncestorEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGuardarActionPerformed(ActionEvent evt) {
        mGrabar();
    }

    private void springStart() {
        this.xAntecedentesPatologicosPersonalesDato = (AntecedentesPatologicosPersonalesDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("antecedentesPatologicosPesonalesDAO");
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"IdTipoAtencedente", "Antecedente", "Observacion", "Id", "VDefecto"}) { // from class: com.genoma.plus.controller.historia.JPA_AntecedentesPersonalesTabla.5
            Class[] types = {Long.class, String.class, String.class, Long.class, Long.class};
            boolean[] canEdit = {false, false, true, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTB_Antecedentes.setModel(this.xmodelo);
        this.JTB_Antecedentes.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTB_Antecedentes.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTB_Antecedentes.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTB_Antecedentes.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTB_Antecedentes.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTB_Antecedentes.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTB_Antecedentes.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTB_Antecedentes.getColumnModel().getColumn(3).setMaxWidth(0);
        this.JTB_Antecedentes.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTB_Antecedentes.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTB_Antecedentes.getColumnModel().getColumn(4).setMaxWidth(0);
    }

    private void mCargarDatosTabla() {
        List<AntecedentesPatologicosPersonalesDTO> list = this.xAntecedentesPatologicosPersonalesDato.listaAntecedentesAtencion(this.xIdAtencion, this.xIdPaciente, this.xidTipoHistoria, this.idSexo, this.fechaAtencion, this.fechaNacimiento);
        mModelo();
        this.xmetodo.mEstablecerTextEditor(this.JTB_Antecedentes, 1);
        this.xmetodo.mEstablecerTextEditor(this.JTB_Antecedentes, 2);
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo.addRow(this.xDato);
            this.xmodelo.setValueAt(list.get(x).getIdTipoAntecedente(), x, 0);
            this.xmodelo.setValueAt(list.get(x).getNombreAntecedente(), x, 1);
            this.xmodelo.setValueAt(list.get(x).getObservacion(), x, 2);
            this.xmodelo.setValueAt(list.get(x).getId(), x, 3);
            this.xmodelo.setValueAt(list.get(x).getValorDefecto(), x, 4);
        }
    }

    public void mGrabar() {
        if (this.JTB_Antecedentes.isEditing()) {
            this.JTB_Antecedentes.getCellEditor().stopCellEditing();
        }
        if (!this.xmetodo.mVerificarDatosLLeno(this.JTB_Antecedentes, 2)) {
            for (int x = 0; x < this.JTB_Antecedentes.getRowCount(); x++) {
                AntecedentesPatologicosPersonalesDTO e = new AntecedentesPatologicosPersonalesDTO();
                e.setIdAtencion(Long.valueOf(this.xIdAtencion));
                e.setIdUsuario(Long.valueOf(this.xIdPaciente));
                e.setIdTipoAntecedente(Long.valueOf(this.xmodelo.getValueAt(x, 0).toString()));
                e.setObservacion(this.JTB_Antecedentes.getValueAt(x, 2).toString());
                e.setId(Long.valueOf(this.xmodelo.getValueAt(x, 3).toString()));
                if (Long.valueOf(this.xmodelo.getValueAt(x, 3).toString()).longValue() == 0) {
                    this.xAntecedentesPatologicosPersonalesDato.mCreate(e);
                } else {
                    this.xAntecedentesPatologicosPersonalesDato.mUpdate(e);
                }
            }
            mCargarDatosTabla();
        }
    }
}
