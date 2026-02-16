package com.genoma.plus.controller.historia;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.dao.historia.DetalleRevisionSistemasDAO;
import com.genoma.plus.dao.historia.RevisionSistemasDAO;
import com.genoma.plus.dao.impl.historia.DetalleRevisionSistemasDAOImpl;
import com.genoma.plus.dao.impl.historia.RevisionSistemasDAOImpl;
import com.genoma.plus.dto.historia.DetalleRevisionSistemasDTO;
import com.genoma.plus.dto.historia.RevisionSistemasDTO;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/JPA_RevisionSistemasTabla.class */
public class JPA_RevisionSistemasTabla extends JPanel {
    private RevisionSistemasDAO xRevisionSitemasDao;
    private DetalleRevisionSistemasDAO revisionSistemasDAO;
    private DefaultTableModel xmodelo;
    private Object[] xDato;
    private Metodos xmetodo = new Metodos();
    private String xIdAtencion;
    private String xIdTipoHistoria;
    private long idRevision;
    private ButtonGroup JBG_Datos;
    private JButton JBTGuardar;
    private JCheckBox JCH_ValorporDefecto;
    private JCheckBox JCH_ValorporDefecto1;
    private JPanel JPI_DRevisionSistemas;
    private JScrollPane JSP_RSistemas;
    private JTextArea JTAObservacion;
    private JTabbedPane JTB_Datos;
    private JTable JTB_RSistemas;
    private JScrollPane jScrollPane1;

    public JPA_RevisionSistemasTabla(String xIdAtencion, String xIdTipoHistoria) {
        initComponents();
        springStart();
        this.xIdAtencion = xIdAtencion;
        this.xIdTipoHistoria = xIdTipoHistoria;
        mCrear();
    }

    /* JADX WARN: Type inference failed for: r3v10, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG_Datos = new ButtonGroup();
        this.JTB_Datos = new JTabbedPane();
        this.JPI_DRevisionSistemas = new JPanel();
        this.JCH_ValorporDefecto = new JCheckBox();
        this.JCH_ValorporDefecto1 = new JCheckBox();
        this.JSP_RSistemas = new JScrollPane();
        this.JTB_RSistemas = new JTable();
        this.JBTGuardar = new JButton();
        this.jScrollPane1 = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        setName("jrevisionsistemas");
        addAncestorListener(new AncestorListener() { // from class: com.genoma.plus.controller.historia.JPA_RevisionSistemasTabla.1
            public void ancestorAdded(AncestorEvent evt) {
            }

            public void ancestorMoved(AncestorEvent evt) {
            }

            public void ancestorRemoved(AncestorEvent evt) {
                JPA_RevisionSistemasTabla.this.formAncestorRemoved(evt);
            }
        });
        this.JTB_Datos.setForeground(new Color(0, 103, 0));
        this.JTB_Datos.setFont(new Font("Arial", 1, 14));
        this.JTB_Datos.addAncestorListener(new AncestorListener() { // from class: com.genoma.plus.controller.historia.JPA_RevisionSistemasTabla.2
            public void ancestorAdded(AncestorEvent evt) {
            }

            public void ancestorMoved(AncestorEvent evt) {
            }

            public void ancestorRemoved(AncestorEvent evt) {
                JPA_RevisionSistemasTabla.this.JTB_DatosAncestorRemoved(evt);
            }
        });
        this.JBG_Datos.add(this.JCH_ValorporDefecto);
        this.JCH_ValorporDefecto.setFont(new Font("Arial", 1, 12));
        this.JCH_ValorporDefecto.setForeground(Color.red);
        this.JCH_ValorporDefecto.setText("No Refiere?");
        this.JCH_ValorporDefecto.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPA_RevisionSistemasTabla.3
            public void actionPerformed(ActionEvent evt) {
                JPA_RevisionSistemasTabla.this.JCH_ValorporDefectoActionPerformed(evt);
            }
        });
        this.JBG_Datos.add(this.JCH_ValorporDefecto1);
        this.JCH_ValorporDefecto1.setFont(new Font("Arial", 1, 12));
        this.JCH_ValorporDefecto1.setForeground(Color.red);
        this.JCH_ValorporDefecto1.setText("No evaluado por estado neurologico");
        this.JCH_ValorporDefecto1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPA_RevisionSistemasTabla.4
            public void actionPerformed(ActionEvent evt) {
                JPA_RevisionSistemasTabla.this.JCH_ValorporDefecto1ActionPerformed(evt);
            }
        });
        this.JTB_RSistemas.setFont(new Font("Arial", 1, 12));
        this.JTB_RSistemas.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_RSistemas.setRowHeight(50);
        this.JTB_RSistemas.setSelectionMode(0);
        this.JTB_RSistemas.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.historia.JPA_RevisionSistemasTabla.5
            public void mouseClicked(MouseEvent evt) {
                JPA_RevisionSistemasTabla.this.JTB_RSistemasMouseClicked(evt);
            }
        });
        this.JSP_RSistemas.setViewportView(this.JTB_RSistemas);
        this.JBTGuardar.setFont(new Font("Arial", 1, 14));
        this.JBTGuardar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGuardar.setText("Guardar");
        this.JBTGuardar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPA_RevisionSistemasTabla.6
            public void actionPerformed(ActionEvent evt) {
                JPA_RevisionSistemasTabla.this.JBTGuardarActionPerformed(evt);
            }
        });
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "Observacion", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacion.setColumns(20);
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JTAObservacion.setRows(5);
        this.jScrollPane1.setViewportView(this.JTAObservacion);
        GroupLayout JPI_DRevisionSistemasLayout = new GroupLayout(this.JPI_DRevisionSistemas);
        this.JPI_DRevisionSistemas.setLayout(JPI_DRevisionSistemasLayout);
        JPI_DRevisionSistemasLayout.setHorizontalGroup(JPI_DRevisionSistemasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DRevisionSistemasLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DRevisionSistemasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSP_RSistemas, -1, 781, 32767).addComponent(this.JBTGuardar, -1, -1, 32767).addGroup(JPI_DRevisionSistemasLayout.createSequentialGroup().addComponent(this.JCH_ValorporDefecto).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH_ValorporDefecto1).addGap(0, 0, 32767)).addComponent(this.jScrollPane1)).addContainerGap()));
        JPI_DRevisionSistemasLayout.setVerticalGroup(JPI_DRevisionSistemasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_DRevisionSistemasLayout.createSequentialGroup().addGap(19, 19, 19).addGroup(JPI_DRevisionSistemasLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH_ValorporDefecto).addComponent(this.JCH_ValorporDefecto1)).addGap(18, 18, 18).addComponent(this.JSP_RSistemas, -2, 250, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 122, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTGuardar, -1, 84, 32767).addGap(7, 7, 7)));
        this.JTB_Datos.addTab("REVISION POR SISTEMAS", this.JPI_DRevisionSistemas);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(15, 15, 15).addComponent(this.JTB_Datos).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTB_Datos).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_DatosAncestorRemoved(AncestorEvent evt) {
        mGrabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_ValorporDefectoActionPerformed(ActionEvent evt) {
        if (this.JCH_ValorporDefecto.isSelected()) {
            for (int i = 0; i < this.JTB_RSistemas.getRowCount(); i++) {
                if (this.xmodelo.getValueAt(i, 1).toString().equals("") || this.xmodelo.getValueAt(i, 1).toString().equals(this.JCH_ValorporDefecto1.getText().toUpperCase())) {
                    this.xmodelo.setValueAt(this.xmodelo.getValueAt(i, 4).toString(), i, 1);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGuardarActionPerformed(ActionEvent evt) {
        mGrabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_ValorporDefecto1ActionPerformed(ActionEvent evt) {
        if (this.JCH_ValorporDefecto1.isSelected()) {
            for (int i = 0; i < this.JTB_RSistemas.getRowCount(); i++) {
                if (this.xmodelo.getValueAt(i, 1).toString().equals("") || this.xmodelo.getValueAt(i, 1).toString().equals(this.xmodelo.getValueAt(i, 4).toString())) {
                    this.xmodelo.setValueAt(this.JCH_ValorporDefecto1.getText().toUpperCase(), i, 1);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formAncestorRemoved(AncestorEvent evt) {
        mGrabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_RSistemasMouseClicked(MouseEvent evt) {
        ValidarSelecion(((Boolean) this.JTB_RSistemas.getValueAt(this.JTB_RSistemas.getSelectedRow(), 5)).booleanValue(), ((Boolean) this.JTB_RSistemas.getValueAt(this.JTB_RSistemas.getSelectedRow(), 6)).booleanValue(), this.JTB_RSistemas.getSelectedRow(), this.JTB_RSistemas.getSelectedColumn());
    }

    private void ValidarSelecion(boolean refiere, boolean noRefiere, int pos, int column) {
        if (refiere && column == 6) {
            this.JTB_RSistemas.setValueAt(true, pos, 6);
            this.JTB_RSistemas.setValueAt(false, pos, 5);
            return;
        }
        if (noRefiere && column == 5) {
            this.JTB_RSistemas.setValueAt(true, pos, 5);
            this.JTB_RSistemas.setValueAt(false, pos, 6);
            return;
        }
        if (!refiere && !noRefiere && column == 6) {
            this.JTB_RSistemas.setValueAt(true, pos, 5);
            this.JTB_RSistemas.setValueAt(false, pos, 6);
        } else if (!refiere && !noRefiere && column == 5) {
            this.JTB_RSistemas.setValueAt(true, pos, 6);
            this.JTB_RSistemas.setValueAt(false, pos, 5);
        }
    }

    private void springStart() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"});
        this.xRevisionSitemasDao = (RevisionSistemasDAOImpl) classPathXmlApplicationContext.getBean("revisionSistemasDAO");
        this.revisionSistemasDAO = (DetalleRevisionSistemasDAOImpl) classPathXmlApplicationContext.getBean("detalleRevisionSitemasDAOImpl");
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Sistema", "Descripcion", "IdTiposistema", "IdRevisionSistma", "VDefecto", "Normal", " A Normal"}) { // from class: com.genoma.plus.controller.historia.JPA_RevisionSistemasTabla.7
            Class[] types = {String.class, String.class, Long.class, Long.class, String.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {false, true, false, false, false, true, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTB_RSistemas.setModel(this.xmodelo);
        this.JTB_RSistemas.getColumnModel().getColumn(0).setPreferredWidth(150);
        this.JTB_RSistemas.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTB_RSistemas.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.JTB_RSistemas.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTB_RSistemas.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTB_RSistemas.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTB_RSistemas.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTB_RSistemas.getColumnModel().getColumn(3).setMaxWidth(0);
        this.JTB_RSistemas.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTB_RSistemas.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTB_RSistemas.getColumnModel().getColumn(4).setMaxWidth(0);
    }

    private void mCargarDatosTabla() {
        List<Object[]> list = this.xRevisionSitemasDao.listRevisionSistemas(this.xIdAtencion);
        mModelo();
        this.xmetodo.mEstablecerTextEditor(this.JTB_RSistemas, 1);
        if (!list.isEmpty()) {
            for (int x = 0; x < list.size(); x++) {
                this.xmodelo.addRow(this.xDato);
                this.xmodelo.setValueAt(list.get(x)[0].toString(), x, 0);
                this.xmodelo.setValueAt(list.get(x)[1].toString(), x, 1);
                this.xmodelo.setValueAt(list.get(x)[2], x, 2);
                this.xmodelo.setValueAt(list.get(x)[3], x, 3);
                this.idRevision = Long.parseLong(list.get(x)[3].toString());
                this.xmodelo.setValueAt(list.get(x)[4], x, 4);
                if (!((Boolean) list.get(x)[5]).booleanValue()) {
                    this.xmodelo.setValueAt(true, x, 5);
                    this.xmodelo.setValueAt(false, x, 6);
                } else {
                    this.xmodelo.setValueAt(true, x, 6);
                    this.xmodelo.setValueAt(false, x, 5);
                }
                this.JTAObservacion.setText("" + list.get(x)[6].toString());
            }
        }
        if (!this.xmetodo.mVerificarDatosLLeno(this.JTB_RSistemas, 1)) {
            this.xmetodo.cambiarEstadoValidadoItemHC(getName(), 1, true);
        }
    }

    private void mCrear() {
        List<Object[]> listConf = this.xRevisionSitemasDao.listConfRevisionSistemas(this.xIdTipoHistoria, this.xIdAtencion);
        if (listConf.isEmpty()) {
            return;
        }
        if (Long.valueOf(listConf.get(0)[3].toString()).longValue() == 0) {
            RevisionSistemasDTO e = new RevisionSistemasDTO();
            e.setIdAtencion(Long.valueOf(this.xIdAtencion));
            e.setFecha(this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()));
            e.setNUsuario(Principal.usuarioSistemaDTO.getLogin());
            e.setObservacion("");
            Long idRevision = this.xRevisionSitemasDao.mCrear(e);
            this.idRevision = idRevision.longValue();
            for (int i = 0; i < listConf.size(); i++) {
                DetalleRevisionSistemasDTO d = new DetalleRevisionSistemasDTO();
                d.setIdRevisionSIstemas(idRevision);
                d.setValor(0);
                d.setIdTipoSistemas(Long.valueOf(listConf.get(i)[2].toString()));
                this.revisionSistemasDAO.mCrear(d);
            }
            mCargarDatosTabla();
            return;
        }
        mCargarDatosTabla();
    }

    public void mGrabar() {
        if (this.JTB_RSistemas.isEditing()) {
            this.JTB_RSistemas.getCellEditor().stopCellEditing();
        }
        for (int x = 0; x < this.JTB_RSistemas.getRowCount(); x++) {
            String[] eDato = new String[5];
            eDato[0] = this.JTB_RSistemas.getValueAt(x, 0).toString();
            eDato[1] = this.JTB_RSistemas.getValueAt(x, 1).toString();
            eDato[2] = this.JTB_RSistemas.getValueAt(x, 3).toString();
            eDato[3] = this.JTB_RSistemas.getValueAt(x, 2).toString();
            if (((Boolean) this.JTB_RSistemas.getValueAt(x, 5)).booleanValue()) {
                eDato[4] = "0";
            } else if (((Boolean) this.JTB_RSistemas.getValueAt(x, 6)).booleanValue()) {
                eDato[4] = "1";
            }
            this.xRevisionSitemasDao.mCrearObservacion(this.JTAObservacion.getText(), this.idRevision);
            this.xRevisionSitemasDao.mUpdate(eDato);
        }
        this.xmetodo.cambiarEstadoValidadoItemHC(getName(), 1, true);
    }

    private void grabar() {
        for (int x = 0; x < this.JTB_RSistemas.getRowCount(); x++) {
            String[] eDato = new String[5];
            eDato[0] = this.JTB_RSistemas.getValueAt(x, 0).toString();
            eDato[1] = this.JTB_RSistemas.getValueAt(x, 1).toString();
            eDato[2] = this.JTB_RSistemas.getValueAt(x, 3).toString();
            eDato[3] = this.JTB_RSistemas.getValueAt(x, 2).toString();
            if (((Boolean) this.JTB_RSistemas.getValueAt(x, 5)).booleanValue()) {
                eDato[4] = "0";
            } else if (((Boolean) this.JTB_RSistemas.getValueAt(x, 6)).booleanValue()) {
                eDato[4] = "1";
            }
            this.xRevisionSitemasDao.mCrearObservacion(this.JTAObservacion.getText(), this.idRevision);
            this.xRevisionSitemasDao.mUpdate(eDato);
        }
        this.xmetodo.cambiarEstadoValidadoItemHC(getName(), 1, true);
    }
}
