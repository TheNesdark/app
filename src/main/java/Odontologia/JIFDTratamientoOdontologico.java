package Odontologia;

import General.Persona;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;

/* JADX INFO: loaded from: GenomaP.jar:Odontologia/JIFDTratamientoOdontologico.class */
public class JIFDTratamientoOdontologico extends JInternalFrame {
    public Persona xjppersona;
    private JPDatosTratamiento xjiddtto;
    private JPanel JPIDTratamiento;
    private JPanel JPIFDatosUsuario;

    public JIFDTratamientoOdontologico(String xidnhc) {
        initComponents();
        mCargasPanelUsuario();
        mCargasPanelDTratamiento();
        this.xjppersona.txtHistoria.setText(xidnhc);
        this.xjppersona.buscar(2);
    }

    private void mCargasPanelUsuario() {
        this.xjppersona = new Persona(this);
        this.xjppersona.setVisible(true);
        this.JPIFDatosUsuario.setVisible(false);
        this.xjppersona.setBounds(10, 15, 950, 160);
        this.JPIFDatosUsuario.add(this.xjppersona);
        this.JPIFDatosUsuario.setVisible(true);
    }

    private void mCargasPanelDTratamiento() {
        this.xjiddtto = new JPDatosTratamiento();
        this.xjiddtto.setVisible(true);
        this.JPIDTratamiento.setVisible(false);
        this.xjiddtto.setBounds(10, 15, 950, 378);
        this.JPIDTratamiento.add(this.xjiddtto);
        this.JPIDTratamiento.setVisible(true);
    }

    private void initComponents() {
        this.JPIFDatosUsuario = new JPanel();
        this.JPIDTratamiento = new JPanel();
        setClosable(true);
        setTitle("PLAN DE TRATAMIENTO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjiftratamientoodontologico");
        this.JPIFDatosUsuario.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN DE USUARIO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        GroupLayout JPIFDatosUsuarioLayout = new GroupLayout(this.JPIFDatosUsuario);
        this.JPIFDatosUsuario.setLayout(JPIFDatosUsuarioLayout);
        JPIFDatosUsuarioLayout.setHorizontalGroup(JPIFDatosUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 957, 32767));
        JPIFDatosUsuarioLayout.setVerticalGroup(JPIFDatosUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 168, 32767));
        this.JPIDTratamiento.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE TRATAMIENTO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        GroupLayout JPIDTratamientoLayout = new GroupLayout(this.JPIDTratamiento);
        this.JPIDTratamiento.setLayout(JPIDTratamientoLayout);
        JPIDTratamientoLayout.setHorizontalGroup(JPIDTratamientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 957, 32767));
        JPIDTratamientoLayout.setVerticalGroup(JPIDTratamientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 387, 32767));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIFDatosUsuario, -2, -1, -2).addComponent(this.JPIDTratamiento, -2, -1, -2)).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIFDatosUsuario, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIDTratamiento, -1, -1, 32767).addContainerGap()));
        pack();
    }
}
