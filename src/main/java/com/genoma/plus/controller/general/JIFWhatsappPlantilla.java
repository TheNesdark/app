package com.genoma.plus.controller.general;

import Utilidades.Metodos;
import Utilidades.PanelRenderer;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/JIFWhatsappPlantilla.class */
public class JIFWhatsappPlantilla extends JInternalFrame {
    JList<JPanel> jListRespuestaRapida;
    JList<JPanel> jLAcciones;
    private JButton JBAdicionarBoton;
    private JComboBox<String> JCBTipoBoton;
    private JComboBox<String> JCBTipoEncabezado;
    private JPanel JPBotones;
    private JPanel JPContenido;
    private JScrollPane JSPAcciones;
    private JScrollPane JSPRespuestaRapida;
    private JTextField JTFPiePagina;
    private JTextField JTFTipoEncabezado;
    private JEditorPane jEditorPane1;
    private JScrollPane jScrollPane3;
    private JTextField jTextField1;
    DefaultListModel<JPanel> modelRespuestaRapida = new DefaultListModel<>();
    DefaultListModel<JPanel> modelAcciones = new DefaultListModel<>();
    int contweb = 0;
    int contllamada = 0;
    Metodos metodos = new Metodos();

    public JIFWhatsappPlantilla() {
        initComponents();
    }

    private void initComponents() {
        this.jTextField1 = new JTextField();
        this.JPBotones = new JPanel();
        this.JCBTipoBoton = new JComboBox<>();
        this.JBAdicionarBoton = new JButton();
        this.JSPRespuestaRapida = new JScrollPane();
        this.JSPAcciones = new JScrollPane();
        this.JPContenido = new JPanel();
        this.jScrollPane3 = new JScrollPane();
        this.jEditorPane1 = new JEditorPane();
        this.JCBTipoEncabezado = new JComboBox<>();
        this.JTFTipoEncabezado = new JTextField();
        this.JTFPiePagina = new JTextField();
        setClosable(true);
        setIconifiable(true);
        setTitle("PLANTILLAS DE WHATSAPP");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        this.jTextField1.setFont(new Font("Arial", 1, 12));
        this.jTextField1.setBorder(BorderFactory.createTitledBorder((Border) null, "Asigna un nombre a la plantilla", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPBotones.setBorder(BorderFactory.createTitledBorder((Border) null, "BOTONES", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JCBTipoBoton.setFont(new Font("Arial", 1, 12));
        this.JCBTipoBoton.setModel(new DefaultComboBoxModel(new String[]{"Personalizado", "Ir al sitio web (Maximo 2 Botones)", "Llamar al número del telefono (Maximo 1 Boton)"}));
        this.JCBTipoBoton.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Boton", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBAdicionarBoton.setFont(new Font("Arial", 1, 12));
        this.JBAdicionarBoton.setText("Adicionar");
        this.JBAdicionarBoton.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIFWhatsappPlantilla.1
            public void actionPerformed(ActionEvent evt) {
                JIFWhatsappPlantilla.this.JBAdicionarBotonActionPerformed(evt);
            }
        });
        this.JSPRespuestaRapida.setBorder(BorderFactory.createTitledBorder((Border) null, "Respuesta Rapida", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPAcciones.setBorder(BorderFactory.createTitledBorder((Border) null, "Respuesta Rapida", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPBotonesLayout = new GroupLayout(this.JPBotones);
        this.JPBotones.setLayout(JPBotonesLayout);
        JPBotonesLayout.setHorizontalGroup(JPBotonesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPBotonesLayout.createSequentialGroup().addContainerGap().addGroup(JPBotonesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPRespuestaRapida).addGroup(JPBotonesLayout.createSequentialGroup().addComponent(this.JCBTipoBoton, -2, 513, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBAdicionarBoton)).addComponent(this.JSPAcciones, GroupLayout.Alignment.TRAILING)).addContainerGap()));
        JPBotonesLayout.setVerticalGroup(JPBotonesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPBotonesLayout.createSequentialGroup().addGroup(JPBotonesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipoBoton, -2, 50, -2).addComponent(this.JBAdicionarBoton, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPRespuestaRapida, -2, 123, -2).addGap(8, 8, 8).addComponent(this.JSPAcciones, -2, 123, -2)));
        this.JPContenido.setBorder(BorderFactory.createTitledBorder((Border) null, "CONTENIDO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.jEditorPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "Cuerpo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jEditorPane1.setFont(new Font("Arial", 1, 12));
        this.jScrollPane3.setViewportView(this.jEditorPane1);
        this.JCBTipoEncabezado.setFont(new Font("Arial", 1, 12));
        this.JCBTipoEncabezado.setModel(new DefaultComboBoxModel(new String[]{"Ninguno", "Mensaje de Texto", "Imagen", "Video", "Documento"}));
        this.JCBTipoEncabezado.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Encabezado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoEncabezado.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.general.JIFWhatsappPlantilla.2
            public void itemStateChanged(ItemEvent evt) {
                JIFWhatsappPlantilla.this.JCBTipoEncabezadoItemStateChanged(evt);
            }
        });
        this.JCBTipoEncabezado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIFWhatsappPlantilla.3
            public void actionPerformed(ActionEvent evt) {
                JIFWhatsappPlantilla.this.JCBTipoEncabezadoActionPerformed(evt);
            }
        });
        this.JTFTipoEncabezado.setFont(new Font("Arial", 1, 12));
        this.JTFPiePagina.setFont(new Font("Arial", 1, 12));
        this.JTFPiePagina.setBorder(BorderFactory.createTitledBorder((Border) null, "Pie de página", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPContenidoLayout = new GroupLayout(this.JPContenido);
        this.JPContenido.setLayout(JPContenidoLayout);
        JPContenidoLayout.setHorizontalGroup(JPContenidoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPContenidoLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPContenidoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPContenidoLayout.createSequentialGroup().addComponent(this.JCBTipoEncabezado, -2, 603, -2).addContainerGap()).addGroup(JPContenidoLayout.createSequentialGroup().addComponent(this.jScrollPane3).addContainerGap()).addGroup(JPContenidoLayout.createSequentialGroup().addGroup(JPContenidoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFPiePagina, GroupLayout.Alignment.TRAILING, -2, 603, -2).addComponent(this.JTFTipoEncabezado, -2, 603, -2)).addGap(10, 10, 10)))));
        JPContenidoLayout.setVerticalGroup(JPContenidoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPContenidoLayout.createSequentialGroup().addComponent(this.JCBTipoEncabezado, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFTipoEncabezado, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane3, -2, 125, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFPiePagina, -2, 50, -2).addGap(10, 10, 10)));
        this.JTFTipoEncabezado.setVisible(false);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jTextField1, -2, 612, -2).addComponent(this.JPContenido, -1, -1, 32767).addComponent(this.JPBotones, -2, -1, -2)).addGap(10, 10, 10)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(17, 17, 17).addComponent(this.jTextField1, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPContenido, -1, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPBotones, -2, -1, -2).addGap(6, 6, 6)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBAdicionarBotonActionPerformed(ActionEvent evt) {
        adicionarBotones(Integer.valueOf(this.JCBTipoBoton.getSelectedIndex()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoEncabezadoItemStateChanged(ItemEvent evt) {
        switch (this.JCBTipoEncabezado.getSelectedIndex()) {
            case 0:
                this.JTFTipoEncabezado.setVisible(false);
                break;
            case 1:
                this.JTFTipoEncabezado.setFont(new Font("Arial", 1, 12));
                this.JTFTipoEncabezado.setBorder(BorderFactory.createTitledBorder((Border) null, "Titulo de Encabezado", 0, 0, new Font("Arial", 1, 12), Color.blue));
                this.JTFTipoEncabezado.setVisible(true);
                break;
            default:
                this.JTFTipoEncabezado.setFont(new Font("Arial", 1, 12));
                this.JTFTipoEncabezado.setBorder(BorderFactory.createTitledBorder((Border) null, "Cargar " + this.JCBTipoEncabezado.getSelectedItem(), 0, 0, new Font("Arial", 1, 12), Color.blue));
                this.JTFTipoEncabezado.setVisible(true);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoEncabezadoActionPerformed(ActionEvent evt) {
    }

    private void adicionarBotones(Integer posicion) {
        Integer total = Integer.valueOf(this.modelRespuestaRapida.getSize() + this.modelAcciones.getSize());
        if (total.intValue() < 10) {
            System.out.println("ENTRO EN 1");
            JPanel panel = new JPanel(new FlowLayout());
            if (posicion.intValue() == 0) {
                JTextField textField = new JTextField(40);
                textField.setFont(new Font("Arial", 1, 12));
                textField.setBorder(BorderFactory.createTitledBorder((Border) null, "Texto del botón", 0, 0, new Font("Arial", 1, 12), Color.blue));
                textField.setEditable(true);
                panel.add(textField);
                JButton button = new JButton("Eliminar");
                panel.add(button);
                this.modelRespuestaRapida.addElement(panel);
                this.jListRespuestaRapida = new JList<>(this.modelRespuestaRapida);
                this.jListRespuestaRapida.setFocusable(false);
                this.jListRespuestaRapida.setCellRenderer(new PanelRenderer());
                this.JSPRespuestaRapida.setViewportView(this.jListRespuestaRapida);
                this.JSPRespuestaRapida.revalidate();
                this.JSPRespuestaRapida.repaint();
                return;
            }
            if (posicion.intValue() == 1) {
                if (this.contweb < 2) {
                    JTextField textField2 = new JTextField(23);
                    textField2.setFont(new Font("Arial", 1, 12));
                    textField2.setBorder(BorderFactory.createTitledBorder((Border) null, "Texto del botón", 0, 0, new Font("Arial", 1, 12), Color.blue));
                    panel.add(textField2);
                    JTextField jTFUrl = new JTextField(20);
                    jTFUrl.setFont(new Font("Arial", 1, 12));
                    jTFUrl.setBorder(BorderFactory.createTitledBorder((Border) null, "URL del sitio web", 0, 0, new Font("Arial", 1, 12), Color.blue));
                    panel.add(jTFUrl);
                    JButton button2 = new JButton("Eliminar");
                    panel.add(button2);
                    this.modelAcciones.addElement(panel);
                    this.jLAcciones = new JList<>(this.modelAcciones);
                    this.jLAcciones.setFocusable(false);
                    this.jLAcciones.setCellRenderer(new PanelRenderer());
                    this.JSPAcciones.setViewportView(this.jLAcciones);
                    this.JSPAcciones.revalidate();
                    this.JSPAcciones.repaint();
                    this.contweb++;
                    return;
                }
                this.metodos.mostrarMensajeError("Haz alcanzado el limite de usos para Sitio Web");
                return;
            }
            if (posicion.intValue() == 2) {
                if (this.contllamada < 1) {
                    JTextField textField3 = new JTextField(23);
                    textField3.setFont(new Font("Arial", 1, 12));
                    textField3.setBorder(BorderFactory.createTitledBorder((Border) null, "Texto del botón", 0, 0, new Font("Arial", 1, 12), Color.blue));
                    panel.add(textField3);
                    JComboBox jComboBox = new JComboBox();
                    jComboBox.setFont(new Font("Arial", 1, 12));
                    jComboBox.setModel(new DefaultComboBoxModel(new String[]{"Ninguno", "Mensaje de Texto", "Imagen", "Video", "Documento"}));
                    jComboBox.setBorder(BorderFactory.createTitledBorder((Border) null, "Pais", 0, 0, new Font("Arial", 1, 12), Color.blue));
                    panel.add(jComboBox);
                    JTextField textField1 = new JTextField(12);
                    textField1.setFont(new Font("Arial", 1, 12));
                    textField1.setBorder(BorderFactory.createTitledBorder((Border) null, "Numero de Teléfono", 0, 0, new Font("Arial", 1, 12), Color.blue));
                    panel.add(textField1);
                    JButton button3 = new JButton("Eliminar");
                    panel.add(button3);
                    this.modelAcciones.addElement(panel);
                    this.jLAcciones = new JList<>(this.modelAcciones);
                    this.jLAcciones.setFocusable(false);
                    this.jLAcciones.setCellRenderer(new PanelRenderer());
                    this.JSPAcciones.setViewportView(this.jLAcciones);
                    this.JSPAcciones.revalidate();
                    this.JSPAcciones.repaint();
                    this.contllamada++;
                    return;
                }
                this.metodos.mostrarMensajeError("Haz alcanzado el limite de usos para Numero de Telefono");
                return;
            }
            return;
        }
        this.metodos.mostrarMensajeError("Haz alcanzado el limite de usos para todas la opciones");
    }
}
