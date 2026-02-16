package RecursosHumanos;

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
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;

/* JADX INFO: loaded from: GenomaP.jar:RecursosHumanos/JDVisualizarNominaJSON.class */
public class JDVisualizarNominaJSON extends JDialog {
    private JButton JBTSalir;
    private JEditorPane JEP_Texto;
    private JScrollPane JSP_Dato;

    public JDVisualizarNominaJSON(Frame parent, boolean modal, String mapper) {
        super(parent, modal);
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.JEP_Texto.setText(mapper);
    }

    private void initComponents() {
        this.JSP_Dato = new JScrollPane();
        this.JEP_Texto = new JEditorPane();
        this.JBTSalir = new JButton();
        setDefaultCloseOperation(2);
        this.JSP_Dato.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE NÓMINA", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JSP_Dato.setViewportView(this.JEP_Texto);
        this.JBTSalir.setFont(new Font("Arial", 1, 13));
        this.JBTSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBTSalir.setText("Salir");
        this.JBTSalir.addActionListener(new ActionListener() { // from class: RecursosHumanos.JDVisualizarNominaJSON.1
            public void actionPerformed(ActionEvent evt) {
                JDVisualizarNominaJSON.this.JBTSalirActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSP_Dato, -1, 664, 32767).addComponent(this.JBTSalir, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JSP_Dato, -1, 374, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTSalir, -2, 45, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTSalirActionPerformed(ActionEvent evt) {
        dispose();
    }
}
