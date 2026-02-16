package com.genoma.plus.controller.historia;

import Acceso.Principal;
import Historia.clasesHistoriaCE;
import Utilidades.CustomPopupMenuListener;
import com.genoma.plus.dao.historia.AntecedentesFisicoPsiquiatricosDAO;
import com.genoma.plus.dao.impl.historia.AntecedentesFisicoPsiquiatricosDAOImpl;
import com.genoma.plus.dto.general.TipoAntecedentesPsiquiatricosDTO;
import com.genoma.plus.dto.historia.AntecedentesFisicoPsiaquiatricosDTO;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/JPAntecedentesFisicosPsiquiatricos.class */
public class JPAntecedentesFisicosPsiquiatricos extends JPanel {
    private final AntecedentesFisicoPsiaquiatricosDTO antecedentesFisicoPsiaquiatricosDTO = new AntecedentesFisicoPsiaquiatricosDTO();
    private AntecedentesFisicoPsiquiatricosDAO antecedentesFisicoPsiquiatricosDAO;
    private clasesHistoriaCE claseHC;
    private Object[] dato;
    private DefaultTableModel modelo;
    private String[] idTipoAntecedente;
    private JButton JBTGuardar;
    private JButton JBTNuevo;
    private JComboBox<String> cbxTipoExamenPsiquiatrico;
    private JScrollPane jspDescripcion;
    private JScrollPane jspHistorico;
    private JTable jtHistorico;
    private JLabel lblId;
    private JPanel paneDatos;
    private JTextPane textPaneDescripcion;

    public JPAntecedentesFisicosPsiquiatricos() {
        initComponents();
        springStart();
        nuevo();
    }

    private void springStart() {
        this.antecedentesFisicoPsiquiatricosDAO = (AntecedentesFisicoPsiquiatricosDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("antecedentesPsiquiatricosDAO");
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModelo() {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Id_Atención", "Tipo Antecedente", "Descripción"}) { // from class: com.genoma.plus.controller.historia.JPAntecedentesFisicosPsiquiatricos.1
            Class[] types = {Long.class, Long.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.jtHistorico.setModel(this.modelo);
        this.jtHistorico.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.jtHistorico.getColumnModel().getColumn(0).setMinWidth(0);
        this.jtHistorico.getColumnModel().getColumn(0).setMaxWidth(0);
        this.jtHistorico.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.jtHistorico.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.jtHistorico.getColumnModel().getColumn(3).setPreferredWidth(500);
    }

    private void cargarDatosTabla() {
        List<AntecedentesFisicoPsiaquiatricosDTO> list = this.antecedentesFisicoPsiquiatricosDAO.listaAntecedentesPsiquiatricos(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido().longValue());
        crearModelo();
        if (!list.isEmpty()) {
            for (int x = 0; x < list.size(); x++) {
                this.modelo.addRow(this.dato);
                this.modelo.setValueAt(Integer.valueOf(list.get(x).getId()), x, 0);
                this.modelo.setValueAt(Long.valueOf(list.get(x).getIdAtencion()), x, 1);
                this.modelo.setValueAt(list.get(x).getIdTipoAntecedentePsiquiatrico(), x, 2);
                this.modelo.setValueAt(list.get(x).getDescripcion(), x, 3);
            }
        }
    }

    public void nuevo() {
        cargarDatosTabla();
        llenaCombo();
        this.lblId.setText("");
        this.textPaneDescripcion.setText("");
        this.cbxTipoExamenPsiquiatrico.setSelectedIndex(-1);
    }

    public void grabar() {
        if (validar()) {
            if (JOptionPane.showConfirmDialog((Component) null, "Seguro que desea grabar", "Grabar Información Antecedentes Psiquiátricos @GenomaPlus", 1, 3, new ImageIcon("src/Imagenes/Question2.png")) == 0) {
                this.antecedentesFisicoPsiaquiatricosDTO.setIdAtencion(Long.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion()).longValue());
                this.antecedentesFisicoPsiaquiatricosDTO.setIdUsuario(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido().longValue());
                this.antecedentesFisicoPsiaquiatricosDTO.setIdTipoAntecedentePsiquiatrico(this.idTipoAntecedente[this.cbxTipoExamenPsiquiatrico.getSelectedIndex()]);
                this.antecedentesFisicoPsiaquiatricosDTO.setDescripcion(this.textPaneDescripcion.getText().toUpperCase());
                this.antecedentesFisicoPsiaquiatricosDTO.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
                System.out.println(this.antecedentesFisicoPsiaquiatricosDTO.getDescripcion());
                if (this.lblId.getText().equals("")) {
                    String idAtencionPsiq = this.antecedentesFisicoPsiquiatricosDAO.create(this.antecedentesFisicoPsiaquiatricosDTO);
                    this.lblId.setText(idAtencionPsiq);
                } else {
                    this.antecedentesFisicoPsiaquiatricosDTO.setId(Integer.parseInt(this.lblId.getText()));
                    this.antecedentesFisicoPsiquiatricosDAO.update(this.antecedentesFisicoPsiaquiatricosDTO);
                }
            }
            cargarDatosTabla();
        }
    }

    public boolean validar() {
        boolean guardar = false;
        if (this.cbxTipoExamenPsiquiatrico.getSelectedIndex() > -1) {
            if (!this.textPaneDescripcion.getText().isEmpty()) {
                guardar = true;
            } else {
                JOptionPane.showMessageDialog((Component) null, "La descripción no debe estar en blanco", "@Guardar Antecedentes", 1, new ImageIcon("src/Imagenes/Information2.png"));
            }
        } else {
            JOptionPane.showMessageDialog((Component) null, "Debe Seleccionar un Tipo Antecedente", "@Guardar Antecedentes", 1, new ImageIcon("src/Imagenes/Information2.png"));
        }
        return guardar;
    }

    private void llenaCombo() {
        this.cbxTipoExamenPsiquiatrico.removeAllItems();
        List<TipoAntecedentesPsiquiatricosDTO> list = this.antecedentesFisicoPsiquiatricosDAO.listaTipoAntecedentesPsiquiatricos();
        this.idTipoAntecedente = new String[list.size()];
        for (int x = 0; x < list.size(); x++) {
            this.idTipoAntecedente[x] = String.valueOf(list.get(x).getId());
            this.cbxTipoExamenPsiquiatrico.addItem(list.get(x).getTipoAntecedente());
        }
        this.cbxTipoExamenPsiquiatrico.addPopupMenuListener(new CustomPopupMenuListener(true, false));
        this.cbxTipoExamenPsiquiatrico.setSelectedIndex(-1);
    }

    /* JADX WARN: Type inference failed for: r3v21, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.paneDatos = new JPanel();
        this.cbxTipoExamenPsiquiatrico = new JComboBox<>();
        this.jspDescripcion = new JScrollPane();
        this.textPaneDescripcion = new JTextPane();
        this.lblId = new JLabel();
        this.jspHistorico = new JScrollPane();
        this.jtHistorico = new JTable();
        this.JBTGuardar = new JButton();
        this.JBTNuevo = new JButton();
        setName("jpAntecedentesFisicoPsiquiatrico");
        setPreferredSize(new Dimension(941, 500));
        this.paneDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Dialog", 1, 14), new Color(0, 102, 0)));
        this.cbxTipoExamenPsiquiatrico.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Examen Físico Psiquiátrico", 0, 0, new Font("Dialog", 1, 12), Color.blue));
        this.textPaneDescripcion.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción del Antecedente", 0, 0, new Font("Dialog", 1, 12), Color.blue));
        this.jspDescripcion.setViewportView(this.textPaneDescripcion);
        this.lblId.setFont(new Font("Cantarell", 1, 14));
        this.lblId.setForeground(Color.red);
        this.lblId.setHorizontalAlignment(0);
        this.lblId.setBorder(BorderFactory.createTitledBorder((Border) null, "Id Antecedente", 0, 0, new Font("Dialog", 1, 12), Color.blue));
        GroupLayout paneDatosLayout = new GroupLayout(this.paneDatos);
        this.paneDatos.setLayout(paneDatosLayout);
        paneDatosLayout.setHorizontalGroup(paneDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(paneDatosLayout.createSequentialGroup().addContainerGap().addGroup(paneDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jspDescripcion, -2, 732, -2).addGroup(paneDatosLayout.createSequentialGroup().addComponent(this.cbxTipoExamenPsiquiatrico, -2, 550, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.lblId, -2, 174, -2))).addGap(3, 3, 3)));
        paneDatosLayout.setVerticalGroup(paneDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(paneDatosLayout.createSequentialGroup().addGroup(paneDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(paneDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.cbxTipoExamenPsiquiatrico, -2, 73, -2)).addGroup(paneDatosLayout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.lblId, -1, -1, 32767))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jspDescripcion, -2, 162, -2).addGap(10, 10, 10)));
        this.jspHistorico.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Dialog", 1, 14), Color.blue));
        this.jtHistorico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.jtHistorico.setAutoResizeMode(0);
        this.jtHistorico.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.historia.JPAntecedentesFisicosPsiquiatricos.2
            public void mouseClicked(MouseEvent evt) {
                JPAntecedentesFisicosPsiquiatricos.this.jtHistoricoMouseClicked(evt);
            }
        });
        this.jspHistorico.setViewportView(this.jtHistorico);
        this.JBTGuardar.setFont(new Font("Arial", 1, 12));
        this.JBTGuardar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Icono_Guardar_Antecedentes.png")));
        this.JBTGuardar.setRolloverIcon(new ImageIcon(getClass().getResource("/Imagenes/Icono_Guardar_Antecedentes_1.png")));
        this.JBTGuardar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPAntecedentesFisicosPsiquiatricos.3
            public void actionPerformed(ActionEvent evt) {
                JPAntecedentesFisicosPsiquiatricos.this.JBTGuardarActionPerformed(evt);
            }
        });
        this.JBTNuevo.setFont(new Font("Arial", 1, 12));
        this.JBTNuevo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Icono_LimpiarCampos_48_1.png")));
        this.JBTNuevo.setRolloverIcon(new ImageIcon(getClass().getResource("/Imagenes/Icono_LimpiarCampos_48.png")));
        this.JBTNuevo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPAntecedentesFisicosPsiquiatricos.4
            public void actionPerformed(ActionEvent evt) {
                JPAntecedentesFisicosPsiquiatricos.this.JBTNuevoActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.paneDatos, -2, -1, -2).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jspHistorico, GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addGap(12, 12, 12).addComponent(this.JBTNuevo, -2, 284, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTGuardar, -2, 445, -2)))).addGap(10, 10, 10)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.paneDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTNuevo, -2, 65, -2).addComponent(this.JBTGuardar, -2, 65, -2)).addGap(10, 10, 10).addComponent(this.jspHistorico, -2, 188, -2).addGap(10, 10, 10)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jtHistoricoMouseClicked(MouseEvent evt) {
        if (this.jtHistorico.getSelectedRow() != -1) {
            this.lblId.setText(this.modelo.getValueAt(this.jtHistorico.getSelectedRow(), 0).toString());
            this.cbxTipoExamenPsiquiatrico.setSelectedItem(this.modelo.getValueAt(this.jtHistorico.getSelectedRow(), 2).toString());
            this.textPaneDescripcion.setText(this.modelo.getValueAt(this.jtHistorico.getSelectedRow(), 3).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGuardarActionPerformed(ActionEvent evt) {
        grabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTNuevoActionPerformed(ActionEvent evt) {
        nuevo();
    }
}
