package com.genoma.plus.controller.parametrizacion;

import Utilidades.Metodos;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.genoma.plus.controller.laboratorio.dto.CustomPresenter;
import com.genoma.plus.domains.models.domains.general.RecursosMicroserviciosDomain;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/parametrizacion/JDProcedimientoCntCode.class */
public class JDProcedimientoCntCode extends JDialog {
    private final Metodos metodos;
    private DefaultTableModel modeloDato;
    private List<ProcedimientoCntCodeDto> listCntCodeDto;
    private List<ProcedimientoCntCodeDto> cntCodeDto;
    private ProcedimientoCntCodeDto procedimientoCntCodeDto;
    private List<ProcedimientoCntDTO> listProcedimientoInterfaz;
    private int xestado;
    private Date fecha;
    private Long id;
    private JTextField CodigoCnt;
    private JButton JBGuardar;
    private JButton JBSalir;
    private JButton JBT_NUevo;
    private JCheckBox JCHBEstado;
    private JTable JTableHistorico;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JTextField procedimiento;

    public JDProcedimientoCntCode(Frame parent, boolean modal, String idProcedimiento) {
        super(parent, modal);
        this.xestado = 0;
        initComponents();
        this.metodos = new Metodos();
        this.procedimiento.setText(idProcedimiento);
        cargarTabla();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
    }

    public void cargarTabla() {
        try {
            RecursosMicroserviciosDomain microserviciosDomain = this.metodos.getParametrosEncriptados("26", "findAllProcedimientoCnt");
            String fullUrl = microserviciosDomain.getUrlRecurso();
            Response response = this.metodos.getResteasyClient().target(fullUrl).request().get();
            Throwable th = null;
            try {
                System.out.println("microservicio" + response);
                crearModeloTabla();
                int statusCode = response.getStatus();
                if (statusCode == 200) {
                    CustomPresenter presenter = (CustomPresenter) this.metodos.getMapper().readValue((String) response.readEntity(String.class), CustomPresenter.class);
                    this.listCntCodeDto = (List) this.metodos.getMapper().readValue(this.metodos.getMapper().writeValueAsString(presenter.getData()), new TypeReference<List<ProcedimientoCntCodeDto>>() { // from class: com.genoma.plus.controller.parametrizacion.JDProcedimientoCntCode.1
                    });
                    this.listCntCodeDto.forEach(e -> {
                        Object[] dato = new Object[4];
                        this.modeloDato.addRow(dato);
                        this.modeloDato.setValueAt(e.getId(), this.JTableHistorico.getRowCount() - 1, 0);
                        this.modeloDato.setValueAt(e.getIdprocedimiento(), this.JTableHistorico.getRowCount() - 1, 1);
                        this.modeloDato.setValueAt(e.getCodigoCnt(), this.JTableHistorico.getRowCount() - 1, 2);
                        this.modeloDato.setValueAt(Boolean.valueOf(e.getEstado().booleanValue()), this.JTableHistorico.getRowCount() - 1, 3);
                    });
                }
                if (response != null) {
                    if (0 != 0) {
                        try {
                            response.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    } else {
                        response.close();
                    }
                }
                this.metodos.getResteasyClient().close();
            } finally {
            }
        } catch (JsonProcessingException e2) {
            Logger.getLogger(JDProcedimientoCntCode.class.getName()).log(Level.SEVERE, "Error al procesar JSON", e2);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    public void crearModeloTabla() {
        this.modeloDato = new DefaultTableModel(new Object[0], new String[]{"Id", "IdProcedimientos", "CodigoCnt", "Estado"}) { // from class: com.genoma.plus.controller.parametrizacion.JDProcedimientoCntCode.2
            Class[] types = {String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTableHistorico.setAutoResizeMode(4);
        this.JTableHistorico.doLayout();
        this.JTableHistorico.setModel(this.modeloDato);
        this.JTableHistorico.getColumnModel().getColumn(0).setPreferredWidth(120);
        this.JTableHistorico.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTableHistorico.getColumnModel().getColumn(2).setPreferredWidth(140);
        this.JTableHistorico.getColumnModel().getColumn(3).setPreferredWidth(120);
    }

    public void grabarProcedimientoCnt() {
        RecursosMicroserviciosDomain microserviciosDomain = this.metodos.getParametrosEncriptados("", "");
        if (this.procedimiento.getText() != null) {
            if (this.CodigoCnt.getText() != null) {
                JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                try {
                    this.procedimientoCntCodeDto = ProcedimientoCntCodeDto.builder().id(this.id).idprocedimiento(Long.valueOf(this.procedimiento.getText())).codigoCnt(this.CodigoCnt.getText()).estado(Boolean.valueOf(this.JCHBEstado.isSelected())).fecha(this.fecha).usuario(null).build();
                    System.out.println("Lo que se graba" + this.procedimientoCntCodeDto);
                    Response response = this.metodos.getResteasyClient().target(microserviciosDomain.getUrlRecurso()).request().post(Entity.json(this.metodos.getMapper().writeValueAsString(this.procedimientoCntCodeDto)));
                    response.close();
                    this.metodos.getResteasyClient().close();
                } catch (JsonProcessingException e) {
                    Logger.getLogger(JDProcedimientoCntCode.class.getName()).log(Level.SEVERE, (String) null, e);
                }
                nuevo();
                cargarTabla();
                return;
            }
            JOptionPane.showMessageDialog(this, "Debes escribir el Codigo Cnt", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.CodigoCnt.requestFocus();
            return;
        }
        JOptionPane.showMessageDialog(this, "Verifica el Id Procedimiento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.procedimiento.requestFocus();
    }

    public void nuevo() {
        this.procedimiento.setText("");
        this.CodigoCnt.setText("");
        this.xestado = 1;
        cargarTabla();
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jScrollPane1 = new JScrollPane();
        this.JTableHistorico = new JTable();
        this.jPanel1 = new JPanel();
        this.JCHBEstado = new JCheckBox();
        this.procedimiento = new JTextField();
        this.CodigoCnt = new JTextField();
        this.JBGuardar = new JButton();
        this.JBSalir = new JButton();
        this.JBT_NUevo = new JButton();
        setTitle("PROCEDIMIENTO CODGIO INTERFAZ");
        setIconImage(null);
        setName("JDCntCode");
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTableHistorico.setFont(new Font("Arial", 1, 12));
        this.JTableHistorico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTableHistorico.setToolTipText("");
        this.JTableHistorico.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.parametrizacion.JDProcedimientoCntCode.3
            public void mouseClicked(MouseEvent evt) {
                JDProcedimientoCntCode.this.JTableHistoricoMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTableHistorico);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 105, 0)));
        this.JCHBEstado.setFont(new Font("Arial", 1, 12));
        this.JCHBEstado.setSelected(true);
        this.JCHBEstado.setText("Estado");
        this.JCHBEstado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.parametrizacion.JDProcedimientoCntCode.4
            public void actionPerformed(ActionEvent evt) {
                JDProcedimientoCntCode.this.JCHBEstadoActionPerformed(evt);
            }
        });
        this.procedimiento.setFont(new Font("Arial", 1, 12));
        this.procedimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Procedimiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.procedimiento.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.parametrizacion.JDProcedimientoCntCode.5
            public void actionPerformed(ActionEvent evt) {
                JDProcedimientoCntCode.this.procedimientoActionPerformed(evt);
            }
        });
        this.CodigoCnt.setFont(new Font("Arial", 1, 12));
        this.CodigoCnt.setBorder(BorderFactory.createTitledBorder((Border) null, "Codigo Interfaz", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.procedimiento, -2, 160, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.CodigoCnt, -2, 160, -2).addGap(27, 27, 27).addComponent(this.JCHBEstado).addGap(14, 14, 14)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(16, 16, 16).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.CodigoCnt, -2, 50, -2).addComponent(this.procedimiento, -2, 50, -2).addComponent(this.JCHBEstado, -2, 38, -2)).addContainerGap(18, 32767)));
        this.JBGuardar.setFont(new Font("Arial", 1, 12));
        this.JBGuardar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBGuardar.setText("Guardar");
        this.JBGuardar.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.parametrizacion.JDProcedimientoCntCode.6
            public void mouseClicked(MouseEvent evt) {
                JDProcedimientoCntCode.this.JBGuardarMouseClicked(evt);
            }
        });
        this.JBGuardar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.parametrizacion.JDProcedimientoCntCode.7
            public void actionPerformed(ActionEvent evt) {
                JDProcedimientoCntCode.this.JBGuardarActionPerformed(evt);
            }
        });
        this.JBSalir.setFont(new Font("Arial", 1, 12));
        this.JBSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBSalir.setText("Salir");
        this.JBSalir.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.parametrizacion.JDProcedimientoCntCode.8
            public void actionPerformed(ActionEvent evt) {
                JDProcedimientoCntCode.this.JBSalirActionPerformed(evt);
            }
        });
        this.JBT_NUevo.setFont(new Font("Arial", 1, 12));
        this.JBT_NUevo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Nuevo29x25.png")));
        this.JBT_NUevo.setText("Nuevo");
        this.JBT_NUevo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.parametrizacion.JDProcedimientoCntCode.9
            public void actionPerformed(ActionEvent evt) {
                JDProcedimientoCntCode.this.JBT_NUevoActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -1, 531, 32767).addComponent(this.jPanel1, -1, -1, 32767).addGroup(layout.createSequentialGroup().addGap(35, 35, 35).addComponent(this.JBGuardar, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBT_NUevo, -2, 120, -2).addGap(58, 58, 58).addComponent(this.JBSalir, -2, 119, -2).addGap(12, 12, 12))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(14, 14, 14).addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 238, -2).addGap(21, 21, 21).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBGuardar, -2, 50, -2).addComponent(this.JBT_NUevo, -2, 50, -2).addComponent(this.JBSalir, -2, 50, -2)).addContainerGap(17, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBSalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGuardarMouseClicked(MouseEvent evt) {
        grabarProcedimientoCnt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHBEstado.isSelected()) {
            this.xestado = 1;
        } else {
            this.xestado = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_NUevoActionPerformed(ActionEvent evt) {
        nuevo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTableHistoricoMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && this.JTableHistorico.getSelectedRow() != -1) {
            this.id = Long.valueOf(this.JTableHistorico.getValueAt(this.JTableHistorico.getSelectedRow(), 0).toString());
            this.procedimiento.setText(this.JTableHistorico.getValueAt(this.JTableHistorico.getSelectedRow(), 1).toString());
            this.CodigoCnt.setText(this.JTableHistorico.getValueAt(this.JTableHistorico.getSelectedRow(), 2).toString());
            this.JCHBEstado.setSelected(Boolean.valueOf(this.modeloDato.getValueAt(this.JTableHistorico.getSelectedRow(), 3).toString()).booleanValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGuardarActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void procedimientoActionPerformed(ActionEvent evt) {
    }
}
