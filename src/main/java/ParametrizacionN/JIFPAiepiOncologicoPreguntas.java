package ParametrizacionN;

import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFPAiepiOncologicoPreguntas.class */
public class JIFPAiepiOncologicoPreguntas extends JInternalFrame {
    private JCheckBox JCHEstado;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JTable JTable;
    private ButtonGroup buttonGroup2;
    private JPanel jPanel1;
    private TextArea textArea1;

    public JIFPAiepiOncologicoPreguntas() {
        initComponents();
    }

    /* JADX WARN: Type inference failed for: r3v23, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup2 = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JCHEstado = new JCheckBox();
        this.jPanel1 = new JPanel();
        this.textArea1 = new TextArea();
        this.JSPDetalle = new JScrollPane();
        this.JTable = new JTable();
        setClosable(true);
        setTitle("CLASIFICACION AIEPI ONCOLOGICO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jiftecnologiaSalud");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPIDatos.setName("jiftecnologiasalud");
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFPAiepiOncologicoPreguntas.1
            public void actionPerformed(ActionEvent evt) {
                JIFPAiepiOncologicoPreguntas.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "Clasificación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.textArea1, -1, 540, 32767).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.textArea1, GroupLayout.Alignment.TRAILING, -1, 112, 32767));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -2, -1, -2).addComponent(this.JCHEstado)).addGap(0, 0, 32767)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHEstado)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTable.setFont(new Font("Arial", 1, 12));
        this.JTable.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTable.setRowHeight(25);
        this.JTable.setSelectionBackground(new Color(255, 255, 255));
        this.JTable.setSelectionForeground(new Color(255, 0, 0));
        this.JTable.setSelectionMode(0);
        this.JTable.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFPAiepiOncologicoPreguntas.2
            public void mouseClicked(MouseEvent evt) {
                JIFPAiepiOncologicoPreguntas.this.JTableMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTable);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle, -1, 577, 32767).addComponent(this.JPIDatos, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -1, 274, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTableMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
    }
}
