package com.genoma.plus.controller.salud_ocupacional;

import Historia.clasesHistoriaCE;
import Utilidades.CustomPopupMenuListener;
import Utilidades.Metodos;
import com.genoma.plus.dao.impl.salud_ocupacional.RevisionExamenSoDAOImpl;
import com.genoma.plus.dao.salud_ocupacional.RevisionExamenSoDAO;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.salud_ocupacional.RevisionExamenSoDTO;
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
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/salud_ocupacional/JPRevisonExamenSo.class */
public class JPRevisonExamenSo extends JPanel {
    private DefaultTableModel xmodelo;
    private Object[] xDato;
    private Metodos xmt = new Metodos();
    private RevisionExamenSoDAO xRevisionExamenSoDAO;
    private clasesHistoriaCE xclase;
    private String[] xidresultado;
    private JButton JBGuardarInter;
    private JComboBox JCBResultado;
    private JScrollPane JSPHistorico;
    private JScrollPane JSPInterpretacion;
    private JTextArea JTAInterpretacion;
    private JTable JTHistorico;

    public JPRevisonExamenSo(clasesHistoriaCE xclase) {
        initComponents();
        springStart();
        this.xclase = xclase;
        mNuevo();
    }

    private void springStart() {
        this.xRevisionExamenSoDAO = (RevisionExamenSoDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("revisionExamenSoDAO");
    }

    public void mNuevo() {
        this.JCBResultado.removeAllItems();
        this.JTAInterpretacion.setText("");
        mCargarDatosTabla();
    }

    public void mGrabar() {
        if (this.JTHistorico.getSelectedRow() != -1) {
            if (this.JCBResultado.getSelectedIndex() != -1) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    RevisionExamenSoDTO e = new RevisionExamenSoDTO();
                    e.setResultadoTexto(this.JCBResultado.getSelectedItem().toString());
                    e.setObservacion(this.JTAInterpretacion.getText());
                    e.setIdOrdenes(Long.valueOf(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 0).toString()));
                    e.setIdProcedimiento(Long.valueOf(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 1).toString()));
                    this.xRevisionExamenSoDAO.updateRevisionExamen(e);
                    this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
                }
                mNuevo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un resultado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            this.JCBResultado.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un examen a revisar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
    }

    private void mLLenaCombo() {
        this.JCBResultado.removeAllItems();
        List<GCGenericoDTO> list2 = this.xRevisionExamenSoDAO.listaResultados(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 1).toString());
        this.xidresultado = new String[list2.size()];
        for (int x = 0; x < list2.size(); x++) {
            this.xidresultado[x] = String.valueOf(list2.get(x).getId());
            this.JCBResultado.addItem(list2.get(x).getNombre());
            System.out.println("Consulta " + list2.get(x).getId());
            System.out.println("" + list2.get(x).getNombre());
        }
        this.JCBResultado.addPopupMenuListener(new CustomPopupMenuListener(true, false));
        this.JCBResultado.setSelectedIndex(-1);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"IdOrdenes", "IdProcedimiento", "Procedimiento", "Resultado", "Observacion"}) { // from class: com.genoma.plus.controller.salud_ocupacional.JPRevisonExamenSo.1
            Class[] types = {Long.class, Long.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTHistorico;
        JTable jTable2 = this.JTHistorico;
        jTable.setAutoResizeMode(0);
        this.JTHistorico.doLayout();
        this.JTHistorico.setModel(this.xmodelo);
        this.JTHistorico.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTHistorico.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTHistorico.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTHistorico.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTHistorico.getColumnModel().getColumn(1).setMinWidth(0);
        this.JTHistorico.getColumnModel().getColumn(1).setMaxWidth(0);
        this.JTHistorico.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTHistorico.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTHistorico.getColumnModel().getColumn(4).setPreferredWidth(400);
    }

    private void mCargarDatosTabla() {
        List<RevisionExamenSoDTO> list = this.xRevisionExamenSoDAO.listRevisionExamen(String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso()));
        mCrearTabla();
        this.xmt.mEstablecerTextEditor(this.JTHistorico, 4);
        if (!list.isEmpty()) {
            for (int x = 0; x < list.size(); x++) {
                this.xmodelo.addRow(this.xDato);
                this.xmodelo.setValueAt(list.get(x).getIdOrdenes(), x, 0);
                this.xmodelo.setValueAt(list.get(x).getIdProcedimiento(), x, 1);
                this.xmodelo.setValueAt(list.get(x).getNProcedimiento(), x, 2);
                this.xmodelo.setValueAt(list.get(x).getResultadoTexto(), x, 3);
                this.xmodelo.setValueAt(list.get(x).getObservacion(), x, 4);
            }
            this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
        }
    }

    /* JADX WARN: Type inference failed for: r3v12, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JCBResultado = new JComboBox();
        this.JBGuardarInter = new JButton();
        this.JSPInterpretacion = new JScrollPane();
        this.JTAInterpretacion = new JTextArea();
        this.JSPHistorico = new JScrollPane();
        this.JTHistorico = new JTable();
        setName("jprevisionexamenso");
        this.JCBResultado.setFont(new Font("Arial", 1, 12));
        this.JCBResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "Resultado", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBGuardarInter.setFont(new Font("Arial", 1, 12));
        this.JBGuardarInter.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBGuardarInter.setText("Guardar");
        this.JBGuardarInter.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.salud_ocupacional.JPRevisonExamenSo.2
            public void actionPerformed(ActionEvent evt) {
                JPRevisonExamenSo.this.JBGuardarInterActionPerformed(evt);
            }
        });
        this.JTAInterpretacion.setColumns(1);
        this.JTAInterpretacion.setFont(new Font("Arial", 1, 12));
        this.JTAInterpretacion.setLineWrap(true);
        this.JTAInterpretacion.setRows(1);
        this.JTAInterpretacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPInterpretacion.setViewportView(this.JTAInterpretacion);
        this.JSPHistorico.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTHistorico.setFont(new Font("Arial", 1, 12));
        this.JTHistorico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTHistorico.setSelectionBackground(Color.white);
        this.JTHistorico.setSelectionForeground(Color.red);
        this.JTHistorico.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.salud_ocupacional.JPRevisonExamenSo.3
            public void mouseClicked(MouseEvent evt) {
                JPRevisonExamenSo.this.JTHistoricoMouseClicked(evt);
            }
        });
        this.JSPHistorico.setViewportView(this.JTHistorico);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBResultado, 0, -1, 32767).addComponent(this.JBGuardarInter, -1, 241, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPInterpretacion, -2, 480, -2)).addComponent(this.JSPHistorico)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistorico, -2, 316, -2).addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JCBResultado, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBGuardarInter, -2, 67, -2)).addComponent(this.JSPInterpretacion, -2, 117, -2)).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGuardarInterActionPerformed(ActionEvent evt) {
        mGrabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistoricoMouseClicked(MouseEvent evt) {
        if (this.JTHistorico.getSelectedRow() != -1) {
            mLLenaCombo();
            this.JCBResultado.setSelectedItem(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 3).toString());
            this.JTAInterpretacion.setText(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 4).toString());
        }
    }
}
