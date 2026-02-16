package com.genoma.plus.controller.tipoDocumentoEmpresa;

import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/tipoDocumentoEmpresa/JD_TipoDocumentoEmpresa.class */
public class JD_TipoDocumentoEmpresa extends JDialog {
    private Integer modulo;
    private Metodos metodos;
    public JButton JBTCargar;
    private JButton JBT_Salir;
    public JComboBox JCB_TipoDocumento;
    public JDateChooser JDCFechaDoc;
    private JLabel JLB_Titulo;
    private JPanel JPI_Filtro;
    private JScrollPane JSP_Detalle;
    public JTable JTB_Detalle;
    public JTextField JTFDiasVenc;
    public JTextField JTFRuta;
    public JTextArea JTxtObservacion;
    private JScrollPane jScrollPane;
    public JLabel lblEmpresa;
    public JLabel lblUsuario;

    public JD_TipoDocumentoEmpresa(Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
    }

    /* JADX WARN: Type inference failed for: r3v55, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBT_Salir = new JButton();
        this.JLB_Titulo = new JLabel();
        this.JPI_Filtro = new JPanel();
        this.JCB_TipoDocumento = new JComboBox();
        this.JDCFechaDoc = new JDateChooser();
        this.JTFDiasVenc = new JTextField();
        this.JBTCargar = new JButton();
        this.JTFRuta = new JTextField();
        this.jScrollPane = new JScrollPane();
        this.JTxtObservacion = new JTextArea();
        this.lblEmpresa = new JLabel();
        this.lblUsuario = new JLabel();
        this.JSP_Detalle = new JScrollPane();
        this.JTB_Detalle = new JTable();
        setDefaultCloseOperation(2);
        setTitle("CARGUE DE DOCUMENTOS POR EMPRESA");
        this.JBT_Salir.setFont(new Font("Arial", 1, 12));
        this.JBT_Salir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBT_Salir.setText("Salir");
        this.JBT_Salir.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.tipoDocumentoEmpresa.JD_TipoDocumentoEmpresa.1
            public void actionPerformed(ActionEvent evt) {
                JD_TipoDocumentoEmpresa.this.JBT_SalirActionPerformed(evt);
            }
        });
        this.JLB_Titulo.setBackground(new Color(0, 51, 153));
        this.JLB_Titulo.setFont(new Font("Arial", 1, 14));
        this.JLB_Titulo.setForeground(new Color(204, 255, 204));
        this.JLB_Titulo.setHorizontalAlignment(0);
        this.JLB_Titulo.setText("CARGUE DE DOCUMENTOS POR EMPRESA");
        this.JLB_Titulo.setBorder(BorderFactory.createBevelBorder(0));
        this.JLB_Titulo.setOpaque(true);
        this.JPI_Filtro.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN PARA CARGUE DE DOCUMENTO", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JCB_TipoDocumento.setFont(new Font("Arial", 1, 12));
        this.JCB_TipoDocumento.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaDoc.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Documento", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaDoc.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaDoc.setFont(new Font("Arial", 1, 12));
        this.JTFDiasVenc.setFont(new Font("Arial", 1, 12));
        this.JTFDiasVenc.setBorder(BorderFactory.createTitledBorder((Border) null, "Dias Vencimiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBTCargar.setFont(new Font("Arial", 1, 12));
        this.JBTCargar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTCargar.setText("Cargar");
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\\\Genoma\\\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.setEnabled(false);
        this.JTxtObservacion.setColumns(20);
        this.JTxtObservacion.setFont(new Font("Arial", 1, 12));
        this.JTxtObservacion.setRows(5);
        this.JTxtObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observacion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane.setViewportView(this.JTxtObservacion);
        GroupLayout JPI_FiltroLayout = new GroupLayout(this.JPI_Filtro);
        this.JPI_Filtro.setLayout(JPI_FiltroLayout);
        JPI_FiltroLayout.setHorizontalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addComponent(this.JTFRuta).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTCargar, -2, 189, -2)).addComponent(this.jScrollPane).addGroup(JPI_FiltroLayout.createSequentialGroup().addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addGap(131, 131, 131).addComponent(this.JCB_TipoDocumento, -2, 312, -2)).addGroup(JPI_FiltroLayout.createSequentialGroup().addComponent(this.JDCFechaDoc, -2, 125, -2).addGap(324, 324, 324).addComponent(this.JTFDiasVenc, -2, 118, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.lblEmpresa).addComponent(this.lblUsuario)).addGap(0, 0, 32767)));
        JPI_FiltroLayout.setVerticalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFDiasVenc).addComponent(this.JDCFechaDoc, -2, 0, 32767).addComponent(this.JCB_TipoDocumento, -1, 50, 32767).addGroup(JPI_FiltroLayout.createSequentialGroup().addComponent(this.lblEmpresa).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.lblUsuario))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane, -2, 79, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTCargar, -2, 50, -2).addComponent(this.JTFRuta, -2, 50, -2))));
        this.JSP_Detalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTB_Detalle.setFont(new Font("Arial", 1, 12));
        this.JTB_Detalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_Detalle.setRowHeight(25);
        this.JSP_Detalle.setViewportView(this.JTB_Detalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(558, 558, 558).addComponent(this.JBT_Salir, -2, 200, -2).addContainerGap(-1, 32767)).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSP_Detalle).addGroup(layout.createSequentialGroup().addComponent(this.JLB_Titulo, -2, 1008, -2).addGap(0, 0, 32767)).addComponent(this.JPI_Filtro, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(7, 7, 7).addComponent(this.JLB_Titulo, -2, 30, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPI_Filtro, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSP_Detalle, -2, 261, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBT_Salir, -2, 50, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_SalirActionPerformed(ActionEvent evt) {
        dispose();
    }
}
