package com.genoma.plus.controller.sgc;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.dao.impl.sgc.SC_ClasificacionEventoDAOImpl;
import com.genoma.plus.dao.sgc.SC_ClasificacionEventoDAO;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.sgc.SC_ClasificacionEventoDTO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/sgc/JDClasificacionEventAdv.class */
public class JDClasificacionEventAdv extends JDialog {
    private Metodos xmt;
    private SC_ClasificacionEventoDAO xSC_ClasificacionEventoDAO;
    private int xEsPrevenible;
    private int xEstado;
    private int xidEvento;
    private int xgrabar;
    private String[] xidClasificacion;
    private boolean xLleno;
    private JButton JBT_Grabar;
    private JButton JBT_NUevo;
    private JButton JBT_Salir1;
    private JComboBox JCBTipoClasificacion;
    private JCheckBox JCHEsPrevenible;
    private JCheckBox JCHEstado;
    public JDateChooser JDFFechaC;
    private JScrollPane JSPDescripcion1;
    private JTextPane JTPJustificacion;

    public JDClasificacionEventAdv(Frame parent, boolean modal, int xidEvento) {
        super(parent, modal);
        this.xmt = new Metodos();
        this.xEsPrevenible = 0;
        this.xEstado = 1;
        this.xidEvento = 0;
        this.xgrabar = 0;
        initComponents();
        springStart();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setTitle("CLASIFACIÒN DE EVENTO ADVERSO");
        this.xidEvento = xidEvento;
        mNuevo();
    }

    private void springStart() {
        this.xSC_ClasificacionEventoDAO = (SC_ClasificacionEventoDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("sCClasificacionEventoDAO");
    }

    private void mLLenaCombo() {
        this.xLleno = false;
        this.JCBTipoClasificacion.removeAllItems();
        List<GCGenericoDTO> list1 = this.xSC_ClasificacionEventoDAO.listaClasificacion();
        this.xidClasificacion = new String[list1.size()];
        for (int x = 0; x < list1.size(); x++) {
            this.xidClasificacion[x] = String.valueOf(list1.get(x).getId());
            this.JCBTipoClasificacion.addItem(list1.get(x).getNombre());
        }
        this.JCBTipoClasificacion.setSelectedIndex(-1);
        this.xLleno = true;
    }

    public void mNuevo() {
        this.JDFFechaC.setDate(this.xmt.getFechaActual());
        this.JCBTipoClasificacion.setSelectedIndex(-1);
        this.JTPJustificacion.setText("");
        this.JCHEsPrevenible.setSelected(false);
        this.xEsPrevenible = 0;
        this.JCHEstado.setSelected(true);
        this.xEstado = 1;
        mLLenaCombo();
        mCargarDatos(String.valueOf(this.xidEvento));
    }

    public void mGrabar() {
        if (this.JCBTipoClasificacion.getSelectedIndex() != -1) {
            if (!this.JTPJustificacion.getText().isEmpty()) {
                int n = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    if (this.xgrabar == 0) {
                        SC_ClasificacionEventoDTO e = new SC_ClasificacionEventoDTO();
                        e.setFechaC(this.xmt.formatoAMD.format(this.JDFFechaC.getDate()));
                        e.setIdClasificacion(this.xidClasificacion[this.JCBTipoClasificacion.getSelectedIndex()]);
                        e.setEsPrevenible(this.xEsPrevenible);
                        e.setJustificacion(this.JTPJustificacion.getText());
                        e.setEstado(this.xEstado);
                        e.setIdEvento(this.xidEvento);
                        this.xSC_ClasificacionEventoDAO.create(e);
                    } else {
                        SC_ClasificacionEventoDTO e2 = new SC_ClasificacionEventoDTO();
                        e2.setFechaC(this.xmt.formatoAMD.format(this.JDFFechaC.getDate()));
                        e2.setIdClasificacion(this.xidClasificacion[this.JCBTipoClasificacion.getSelectedIndex()]);
                        e2.setEsPrevenible(this.xEsPrevenible);
                        e2.setJustificacion(this.JTPJustificacion.getText());
                        e2.setEstado(this.xEstado);
                        e2.setIdEvento(this.xidEvento);
                        this.xSC_ClasificacionEventoDAO.update(e2);
                    }
                    mNuevo();
                    return;
                }
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe digitar una justificaciòn", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            this.JTPJustificacion.requestFocus();
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe seleccionar una clasificaciòn", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JCBTipoClasificacion.requestFocus();
    }

    public void mAnular(String xid, String xdetalle) {
        SC_ClasificacionEventoDTO e = new SC_ClasificacionEventoDTO();
        e.setIdAnulado(Integer.valueOf(xid).intValue());
        e.setMotivoAnulacion(xdetalle);
        e.setFechaAnulacion(this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()));
        e.setUsuarioAnulacion(Principal.usuarioSistemaDTO.getNombreUsuario());
        e.setIdEvento(this.xidEvento);
        this.xSC_ClasificacionEventoDAO.delete(e);
        mNuevo();
    }

    private void initComponents() {
        this.JCBTipoClasificacion = new JComboBox();
        this.JCHEsPrevenible = new JCheckBox();
        this.JSPDescripcion1 = new JScrollPane();
        this.JTPJustificacion = new JTextPane();
        this.JCHEstado = new JCheckBox();
        this.JDFFechaC = new JDateChooser();
        this.JBT_NUevo = new JButton();
        this.JBT_Grabar = new JButton();
        this.JBT_Salir1 = new JButton();
        setDefaultCloseOperation(2);
        this.JCBTipoClasificacion.setFont(new Font("Arial", 1, 12));
        this.JCBTipoClasificacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Clasificaciòn", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoClasificacion.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.sgc.JDClasificacionEventAdv.1
            public void itemStateChanged(ItemEvent evt) {
                JDClasificacionEventAdv.this.JCBTipoClasificacionItemStateChanged(evt);
            }
        });
        this.JCHEsPrevenible.setFont(new Font("Arial", 1, 12));
        this.JCHEsPrevenible.setText("Es Prevenible?");
        this.JCHEsPrevenible.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JDClasificacionEventAdv.2
            public void actionPerformed(ActionEvent evt) {
                JDClasificacionEventAdv.this.JCHEsPrevenibleActionPerformed(evt);
            }
        });
        this.JTPJustificacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Justificaciòn:", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPJustificacion.setFont(new Font("Arial", 1, 12));
        this.JSPDescripcion1.setViewportView(this.JTPJustificacion);
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JDClasificacionEventAdv.3
            public void actionPerformed(ActionEvent evt) {
                JDClasificacionEventAdv.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JDFFechaC.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Clasificaciòn", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaC.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaC.setFont(new Font("Arial", 1, 12));
        this.JBT_NUevo.setFont(new Font("Arial", 1, 12));
        this.JBT_NUevo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Nuevo29x25.png")));
        this.JBT_NUevo.setText("Nuevo");
        this.JBT_NUevo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JDClasificacionEventAdv.4
            public void actionPerformed(ActionEvent evt) {
                JDClasificacionEventAdv.this.JBT_NUevoActionPerformed(evt);
            }
        });
        this.JBT_Grabar.setFont(new Font("Arial", 1, 12));
        this.JBT_Grabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBT_Grabar.setText("Grabar");
        this.JBT_Grabar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JDClasificacionEventAdv.5
            public void actionPerformed(ActionEvent evt) {
                JDClasificacionEventAdv.this.JBT_GrabarActionPerformed(evt);
            }
        });
        this.JBT_Salir1.setFont(new Font("Arial", 1, 12));
        this.JBT_Salir1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBT_Salir1.setText("Salir");
        this.JBT_Salir1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JDClasificacionEventAdv.6
            public void actionPerformed(ActionEvent evt) {
                JDClasificacionEventAdv.this.JBT_Salir1ActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JCHEsPrevenible).addGap(15, 15, 15).addComponent(this.JCHEstado)).addComponent(this.JSPDescripcion1).addGroup(layout.createSequentialGroup().addComponent(this.JDFFechaC, -2, 129, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBTipoClasificacion, 0, -1, 32767)).addGroup(layout.createSequentialGroup().addComponent(this.JBT_NUevo, -2, 138, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBT_Grabar, -1, 124, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBT_Salir1, -2, 138, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JDFFechaC, -1, 45, 32767).addComponent(this.JCBTipoClasificacion)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDescripcion1, -2, 125, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHEsPrevenible).addComponent(this.JCHEstado)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBT_Grabar, -2, 50, -2).addComponent(this.JBT_NUevo, -2, 50, -2).addComponent(this.JBT_Salir1, -2, 50, -2)).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoClasificacionItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEsPrevenibleActionPerformed(ActionEvent evt) {
        if (this.JCHEsPrevenible.isSelected()) {
            this.xEsPrevenible = 1;
        } else {
            this.xEsPrevenible = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.xEstado = 1;
        } else {
            this.xEstado = 0;
        }
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
    public void JBT_Salir1ActionPerformed(ActionEvent evt) {
        Principal.xclasesgc.xJIFF_SC_EventoAdversoAnalisis.mCargarDatosTabla(0, null, null);
        dispose();
    }

    private void mCargarDatos(String xidEvento) {
        List<SC_ClasificacionEventoDTO> list = this.xSC_ClasificacionEventoDAO.list(xidEvento);
        if (list.size() != 0) {
            this.JDFFechaC.setDate(Date.valueOf(list.get(0).getFechaC()));
            this.JCBTipoClasificacion.setSelectedItem(list.get(0).getIdClasificacion());
            if (list.get(0).getEsPrevenible() == 1) {
                this.JCHEsPrevenible.setSelected(true);
                this.xEsPrevenible = 1;
            } else {
                this.JCHEsPrevenible.setSelected(false);
                this.xEsPrevenible = 0;
            }
            this.JTPJustificacion.setText(list.get(0).getJustificacion());
            if (list.get(0).getEstado() == 1) {
                this.JCHEstado.setSelected(true);
                this.xEstado = 1;
            } else {
                this.JCHEstado.setSelected(true);
                this.xEstado = 0;
            }
            this.xgrabar = 1;
            return;
        }
        this.xgrabar = 0;
    }
}
