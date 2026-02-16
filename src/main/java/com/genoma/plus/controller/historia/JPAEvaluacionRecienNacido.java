package com.genoma.plus.controller.historia;

import Utilidades.Metodos;
import com.genoma.plus.dao.historia.EvaluacionRecienNacidoDAO;
import com.genoma.plus.dao.impl.historia.EvaluacionRecienNacidoDAOImpl;
import com.genoma.plus.dto.historia.EvaluacionRecienNacidoDTO;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/JPAEvaluacionRecienNacido.class */
public class JPAEvaluacionRecienNacido extends JPanel {
    private Metodos xmt = new Metodos();
    EvaluacionRecienNacidoDAO evaluacionRecienNacidoDAO;
    private String idAtencion;
    private long idUsuario;
    private JButton JBGrabar;
    private JTextArea JTAEvaluacion;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;

    public JPAEvaluacionRecienNacido(long idUsuario, String idAtencion) {
        initComponents();
        this.idAtencion = idAtencion;
        this.idUsuario = idUsuario;
        springStart();
        cargarDatos();
    }

    private void springStart() {
        this.evaluacionRecienNacidoDAO = (EvaluacionRecienNacidoDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("evaluacionRecienNacidoDAO");
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.JTAEvaluacion = new JTextArea();
        this.JBGrabar = new JButton();
        setName("JPAEvaluacionRecienNacido");
        this.JTAEvaluacion.setColumns(20);
        this.JTAEvaluacion.setFont(new Font("Arial", 1, 12));
        this.JTAEvaluacion.setRows(5);
        this.JTAEvaluacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Evaluacion Recien Nacido", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane1.setViewportView(this.JTAEvaluacion);
        this.JBGrabar.setText("Guardar");
        this.JBGrabar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPAEvaluacionRecienNacido.1
            public void actionPerformed(ActionEvent evt) {
                JPAEvaluacionRecienNacido.this.JBGrabarActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBGrabar, -1, -1, 32767).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jScrollPane1, -2, 787, -2).addGap(0, 0, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap(28, 32767).addComponent(this.jScrollPane1, -2, 392, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBGrabar, -2, 50, -2).addContainerGap()));
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, -2).addContainerGap(18, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, -2).addContainerGap(24, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGrabarActionPerformed(ActionEvent evt) {
        mGrabar();
    }

    public void mGrabar() {
        List<EvaluacionRecienNacidoDTO> lista = this.evaluacionRecienNacidoDAO.listaEvaluacionRecienNacido(this.idAtencion);
        EvaluacionRecienNacidoDTO evaluacion = EvaluacionRecienNacidoDTO.builder().idAtencion(this.idAtencion).observacion(this.JTAEvaluacion.getText()).idUsuario(this.idUsuario).build();
        if (0 == lista.size()) {
            this.evaluacionRecienNacidoDAO.create(evaluacion);
        } else {
            evaluacion.setId(lista.get(0).getId());
            this.evaluacionRecienNacidoDAO.update(evaluacion);
        }
        this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
    }

    public void cargarDatos() {
        List<EvaluacionRecienNacidoDTO> lista = this.evaluacionRecienNacidoDAO.listaEvaluacionRecienNacido(this.idAtencion);
        if (lista.size() > 0) {
            this.JTAEvaluacion.setText(lista.get(0).getObservacion());
            this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
        }
    }
}
