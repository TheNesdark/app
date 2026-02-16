package com.genoma.plus.controller.historia;

import Acceso.Principal;
import com.genoma.plus.controller.general.JDConfiguracionItemsxTipoHistoria;
import com.genoma.plus.controller.general.JDReportesXTipoHC;
import com.genoma.plus.dao.historia.TipoHistoriaDAO;
import com.genoma.plus.dao.impl.historia.TipoHistoriaDAOImpl;
import com.genoma.plus.dto.historia.TipoHistoriaDTO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/JIFTipoHistoria.class */
public class JIFTipoHistoria extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private TipoHistoriaDAO xTipoHistoriaDAO;
    private Object[] xdatos;
    private JButton JBAntecedentesPatologicos;
    private JButton JBReportesHistoria;
    private JButton JBTDatosA;
    private JButton JBTExaFisico;
    private JButton JBTipoHistoriaxConfiguracionItem;
    private JCheckBox JCHAgendaNueva;
    private JCheckBox JCHAplica;
    private JCheckBox JCHEstado;
    private JCheckBox JCHExpandir;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFNombre;
    private JTextField JTFReporte;

    public JIFTipoHistoria() {
        initComponents();
        springStart();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v30, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JTFReporte = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JCHAplica = new JCheckBox();
        this.JCHExpandir = new JCheckBox();
        this.JTFNombre = new JTextField();
        this.JCHAgendaNueva = new JCheckBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JBTDatosA = new JButton();
        this.JBTExaFisico = new JButton();
        this.JBAntecedentesPatologicos = new JButton();
        this.JBTipoHistoriaxConfiguracionItem = new JButton();
        this.JBReportesHistoria = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("TIPO HISTORIA CLINICA");
        setFont(new Font("Arial", 1, 12));
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("JIFTipoHistoria");
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTFReporte.setFont(new Font("Arial", 1, 13));
        this.JTFReporte.setToolTipText("");
        this.JTFReporte.setBorder(BorderFactory.createTitledBorder((Border) null, "Reporte", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHAplica.setFont(new Font("Arial", 1, 12));
        this.JCHAplica.setSelected(true);
        this.JCHAplica.setText("Aplica");
        this.JCHExpandir.setFont(new Font("Arial", 1, 12));
        this.JCHExpandir.setSelected(true);
        this.JCHExpandir.setText("Expandir");
        this.JTFNombre.setFont(new Font("Arial", 1, 13));
        this.JTFNombre.setToolTipText("");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHAgendaNueva.setFont(new Font("Arial", 1, 12));
        this.JCHAgendaNueva.setText("Maneja Agenda Nueva?");
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFReporte, -1, 372, 32767).addComponent(this.JTFNombre)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHAgendaNueva, -1, -1, 32767).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCHAplica, -2, 76, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHExpandir)).addComponent(this.JCHEstado, -2, 92, -2)).addGap(0, 0, 32767))).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addGap(0, 2, 32767).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHAplica).addComponent(this.JCHExpandir)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHEstado)).addComponent(this.JTFNombre, -2, 50, -2)).addGap(10, 10, 10).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFReporte, -2, 50, -2).addComponent(this.JCHAgendaNueva)).addGap(6, 6, 6)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.historia.JIFTipoHistoria.1
            public void mouseClicked(MouseEvent evt) {
                JIFTipoHistoria.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JBTDatosA.setFont(new Font("Arial", 1, 13));
        this.JBTDatosA.setText("Detalle de Contenido HC");
        this.JBTDatosA.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JIFTipoHistoria.2
            public void actionPerformed(ActionEvent evt) {
                JIFTipoHistoria.this.JBTDatosAActionPerformed(evt);
            }
        });
        this.JBTExaFisico.setFont(new Font("Arial", 1, 13));
        this.JBTExaFisico.setText("Detalle Examen Físico");
        this.JBTExaFisico.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JIFTipoHistoria.3
            public void actionPerformed(ActionEvent evt) {
                JIFTipoHistoria.this.JBTExaFisicoActionPerformed(evt);
            }
        });
        this.JBAntecedentesPatologicos.setFont(new Font("Arial", 1, 13));
        this.JBAntecedentesPatologicos.setText("Antecendentes Patologicos");
        this.JBAntecedentesPatologicos.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JIFTipoHistoria.4
            public void actionPerformed(ActionEvent evt) {
                JIFTipoHistoria.this.JBAntecedentesPatologicosActionPerformed(evt);
            }
        });
        this.JBTipoHistoriaxConfiguracionItem.setFont(new Font("Arial", 1, 13));
        this.JBTipoHistoriaxConfiguracionItem.setText("Configuracion de Items de Agenda Nueva");
        this.JBTipoHistoriaxConfiguracionItem.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JIFTipoHistoria.5
            public void actionPerformed(ActionEvent evt) {
                JIFTipoHistoria.this.JBTipoHistoriaxConfiguracionItemActionPerformed(evt);
            }
        });
        this.JBReportesHistoria.setFont(new Font("Arial", 1, 13));
        this.JBReportesHistoria.setText("Reportes por Tipo de HC");
        this.JBReportesHistoria.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JIFTipoHistoria.6
            public void actionPerformed(ActionEvent evt) {
                JIFTipoHistoria.this.JBReportesHistoriaActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBReportesHistoria, -2, 576, -2).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBAntecedentesPatologicos, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JBTDatosA, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBTExaFisico, -1, -1, 32767).addComponent(this.JBTipoHistoriaxConfiguracionItem, -1, -1, 32767))).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle, -2, 576, -2).addComponent(this.JPIDatos, -2, -1, -2)).addGap(0, 0, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addGap(10, 10, 10).addComponent(this.JSPDetalle, -2, 209, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTDatosA, -2, 48, -2).addComponent(this.JBTExaFisico, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBAntecedentesPatologicos, -2, 50, -2).addComponent(this.JBTipoHistoriaxConfiguracionItem, -2, 48, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBReportesHistoria, -2, 50, -2).addContainerGap()));
        pack();
    }

    private void springStart() {
        this.xTipoHistoriaDAO = (TipoHistoriaDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("TipoHistoriaDAO");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
        this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
        this.JCHAplica.setSelected(((Boolean) this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2)).booleanValue());
        this.JCHEstado.setSelected(((Boolean) this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3)).booleanValue());
        this.JCHExpandir.setSelected(((Boolean) this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4)).booleanValue());
        this.JTFReporte.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString());
        this.JCHAgendaNueva.setSelected(((Boolean) this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6)).booleanValue());
        if (this.JCHAgendaNueva.isSelected()) {
            this.JBTipoHistoriaxConfiguracionItem.setEnabled(true);
        } else {
            this.JBTipoHistoriaxConfiguracionItem.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTDatosAActionPerformed(ActionEvent evt) {
        Principal.claseparametrizacionn.cargarPantalla("Contenido x Detalle HC");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExaFisicoActionPerformed(ActionEvent evt) {
        Principal.claseparametrizacionn.cargarPantalla("Detalle Examen Físico");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBAntecedentesPatologicosActionPerformed(ActionEvent evt) {
        Principal.claseparametrizacionn.cargarPantalla("Antecedentes Patológicos", Integer.parseInt(Principal.txtNo.getText()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTipoHistoriaxConfiguracionItemActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty()) {
            JDConfiguracionItemsxTipoHistoria detalle = new JDConfiguracionItemsxTipoHistoria(null, true);
            detalle.setLocationRelativeTo(this);
            detalle.setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBReportesHistoriaActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty()) {
            JDReportesXTipoHC detalle = new JDReportesXTipoHC(null, true);
            detalle.setLocationRelativeTo(this);
            detalle.setVisible(true);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nbre", "Aplica", "Estado", "Expandir", "Reportes", "Agenda Nueva?"}) { // from class: com.genoma.plus.controller.historia.JIFTipoHistoria.7
            Class[] types = {Integer.class, String.class, Boolean.class, Boolean.class, Boolean.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(170);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(60);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(50);
    }

    private void mCargarDatos() {
        mCrearModelo();
        List<Object[]> list = this.xTipoHistoriaDAO.listaTHistoria();
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo.addRow(this.xdatos);
            for (int j = 0; j < 7; j++) {
                this.xmodelo.setValueAt(list.get(x)[j], x, j);
                if (j == 3) {
                    this.xmodelo.setValueAt(Boolean.valueOf(!((Boolean) list.get(x)[j]).booleanValue()), x, j);
                }
            }
        }
    }

    public void mNuevo() {
        this.JTFReporte.setText("");
        this.JTFNombre.setText("");
        this.JCHAplica.setSelected(true);
        this.JCHEstado.setSelected(true);
        this.JCHExpandir.setSelected(true);
        this.JCHAgendaNueva.setSelected(false);
        this.JBTipoHistoriaxConfiguracionItem.setEnabled(false);
        mCargarDatos();
        Principal.mLimpiarDatosP();
    }

    public void mGuardar() {
        if (!this.JTFNombre.getText().isEmpty()) {
            if (!this.JTFReporte.getText().isEmpty()) {
                TipoHistoriaDTO tipoHist = new TipoHistoriaDTO();
                tipoHist.setNombre(this.JTFNombre.getText());
                tipoHist.setAplica(this.JCHAplica.isSelected());
                tipoHist.setEstado(!this.JCHEstado.isSelected());
                tipoHist.setExpandir(this.JCHExpandir.isSelected());
                tipoHist.setReporte(this.JTFReporte.getText());
                tipoHist.setUsuario(Principal.usuarioSistemaDTO.getLogin());
                tipoHist.setForma(this.JCHAgendaNueva.isSelected());
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    if (Principal.txtNo.getText().isEmpty()) {
                        this.xTipoHistoriaDAO.mCreate(tipoHist);
                    } else {
                        tipoHist.setId(Integer.parseInt(Principal.txtNo.getText()));
                        this.xTipoHistoriaDAO.mUpdate(tipoHist);
                    }
                    mNuevo();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "El reporte relacionado con la historia clinica no puede estar vacio", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El nombre del tipo de historia clinica no puede estar vacio", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }
}
