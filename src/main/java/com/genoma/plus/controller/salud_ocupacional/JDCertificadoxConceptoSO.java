package com.genoma.plus.controller.salud_ocupacional;

import Acceso.Principal;
import Utilidades.CustomPopupMenuListener;
import Utilidades.Metodos;
import com.genoma.plus.dao.impl.salud_ocupacional.CertificadoSoDAOImpl;
import com.genoma.plus.dao.salud_ocupacional.CertificadoSoDAO;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.salud_ocupacional.ConceptoxCertificadoSoDTO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/salud_ocupacional/JDCertificadoxConceptoSO.class */
public class JDCertificadoxConceptoSO extends JDialog {
    private DefaultTableModel xmodelo;
    private Object[] xDato;
    private Metodos xmt;
    private CertificadoSoDAO xCertificadoSoDAO;
    private int xestado;
    private String[] xidConcepto;
    private JButton JBT_Grabar;
    private JButton JBT_NUevo;
    private JButton JBT_Salir;
    private JComboBox<String> JCBConcepto;
    private JPanel JPInformacion;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;

    public JDCertificadoxConceptoSO(Frame parent, boolean modal) {
        super(parent, modal);
        this.xmt = new Metodos();
        this.xestado = 1;
        initComponents();
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xCertificadoSoDAO = (CertificadoSoDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("certificadoSoDAO");
    }

    public void mNuevo() {
        this.JCBConcepto.removeAllItems();
        List<GCGenericoDTO> list1 = this.xCertificadoSoDAO.listaComboConceptoxCertificado();
        this.xidConcepto = new String[list1.size()];
        for (int x = 0; x < list1.size(); x++) {
            this.xidConcepto[x] = String.valueOf(list1.get(x).getId());
            this.JCBConcepto.addItem(list1.get(x).getNombre());
            System.out.println("Consulta " + list1.get(x).getId());
            System.out.println("" + list1.get(x).getNombre());
        }
        this.JCBConcepto.addPopupMenuListener(new CustomPopupMenuListener(true, false));
        this.JCBConcepto.setSelectedIndex(-1);
        mCargarDatosTabla();
    }

    public void mGrabar() {
        if (this.JCBConcepto.getSelectedIndex() != -1) {
            int n = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                ConceptoxCertificadoSoDTO e = new ConceptoxCertificadoSoDTO();
                e.setIdCertificado(Integer.valueOf(Principal.txtNo.getText()).intValue());
                e.setIdTipoConcepto(this.xidConcepto[this.JCBConcepto.getSelectedIndex()]);
                this.xCertificadoSoDAO.createConceptoxCertificado(e);
            }
            mNuevo();
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe seleccionar un concepto", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JCBConcepto.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Concepto"}) { // from class: com.genoma.plus.controller.salud_ocupacional.JDCertificadoxConceptoSO.1
            Class[] types = {String.class};
            boolean[] canEdit = {false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(200);
    }

    private void mCargarDatosTabla() {
        List<ConceptoxCertificadoSoDTO> list = this.xCertificadoSoDAO.listConceptoxCertificado(Principal.txtNo.getText());
        mCrearTabla();
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo.addRow(this.xDato);
            this.xmodelo.setValueAt(list.get(x).getIdTipoConcepto(), x, 0);
        }
    }

    /* JADX WARN: Type inference failed for: r3v11, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPInformacion = new JPanel();
        this.JCBConcepto = new JComboBox<>();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JBT_NUevo = new JButton();
        this.JBT_Grabar = new JButton();
        this.JBT_Salir = new JButton();
        setDefaultCloseOperation(2);
        this.JPInformacion.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACION", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBConcepto.setFont(new Font("Arial", 1, 12));
        this.JCBConcepto.setBorder(BorderFactory.createTitledBorder((Border) null, "Concepto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPInformacionLayout = new GroupLayout(this.JPInformacion);
        this.JPInformacion.setLayout(JPInformacionLayout);
        JPInformacionLayout.setHorizontalGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformacionLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBConcepto, 0, -1, 32767).addContainerGap()));
        JPInformacionLayout.setVerticalGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformacionLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBConcepto, -2, 50, -2).addContainerGap(-1, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JBT_NUevo.setFont(new Font("Arial", 1, 12));
        this.JBT_NUevo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Nuevo29x25.png")));
        this.JBT_NUevo.setText("Nuevo");
        this.JBT_NUevo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.salud_ocupacional.JDCertificadoxConceptoSO.2
            public void actionPerformed(ActionEvent evt) {
                JDCertificadoxConceptoSO.this.JBT_NUevoActionPerformed(evt);
            }
        });
        this.JBT_Grabar.setFont(new Font("Arial", 1, 12));
        this.JBT_Grabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBT_Grabar.setText("Grabar");
        this.JBT_Grabar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.salud_ocupacional.JDCertificadoxConceptoSO.3
            public void actionPerformed(ActionEvent evt) {
                JDCertificadoxConceptoSO.this.JBT_GrabarActionPerformed(evt);
            }
        });
        this.JBT_Salir.setFont(new Font("Arial", 1, 12));
        this.JBT_Salir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBT_Salir.setText("Salir");
        this.JBT_Salir.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.salud_ocupacional.JDCertificadoxConceptoSO.4
            public void actionPerformed(ActionEvent evt) {
                JDCertificadoxConceptoSO.this.JBT_SalirActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JBT_NUevo, -2, 148, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBT_Grabar, -2, 172, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBT_Salir, -2, 150, -2)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JPInformacion, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING, -1, 486, 32767))).addGap(10, 10, 10)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPInformacion, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 283, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBT_NUevo, -2, 50, -2).addComponent(this.JBT_Grabar, -2, 50, -2).addComponent(this.JBT_Salir, -2, 50, -2)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_NUevoActionPerformed(ActionEvent evt) {
        mNuevo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_GrabarActionPerformed(ActionEvent evt) {
        mGrabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_SalirActionPerformed(ActionEvent evt) {
        dispose();
    }
}
