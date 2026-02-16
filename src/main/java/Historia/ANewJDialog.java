package Historia;

import Utilidades.Metodos;
import com.genoma.plus.controller.historia.JPEAD_PuntuacionGrafica1;
import java.awt.Dimension;
import java.awt.Frame;
import javax.swing.GroupLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;

/* JADX INFO: loaded from: GenomaP.jar:Historia/ANewJDialog.class */
public class ANewJDialog extends JDialog {
    private JPEAD_PuntuacionGrafica1 xJPEAD_PuntuacionGrafica;
    int rango;
    int[] arr;
    Metodos metodos;
    private JPanel jPanel1;

    public ANewJDialog(Frame parent, boolean modal, int rango, int[] arr) {
        super(parent, modal);
        this.metodos = new Metodos();
        setLocationRelativeTo(null);
        this.rango = rango;
        this.arr = arr;
        initComponents();
        init_Components();
    }

    private void init_Components() {
        if (this.xJPEAD_PuntuacionGrafica == null) {
            this.xJPEAD_PuntuacionGrafica = new JPEAD_PuntuacionGrafica1(this.rango, this.arr);
        }
        this.xJPEAD_PuntuacionGrafica.setVisible(true);
        this.xJPEAD_PuntuacionGrafica.setBounds(3, 10, 1335, 100);
        this.jPanel1.add(this.xJPEAD_PuntuacionGrafica);
    }

    public void GenerarFoto(int id) {
        this.xJPEAD_PuntuacionGrafica.repaint();
        this.xJPEAD_PuntuacionGrafica.validate();
        this.xJPEAD_PuntuacionGrafica.revalidate();
        this.xJPEAD_PuntuacionGrafica.GenerarFoto(id);
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        setDefaultCloseOperation(2);
        setPreferredSize(new Dimension(1587, 292));
        this.jPanel1.setPreferredSize(new Dimension(1563, 234));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 1563, 32767));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 119, 32767));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, 32767).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, 119, -2).addContainerGap(-1, 32767)));
        pack();
    }
}
