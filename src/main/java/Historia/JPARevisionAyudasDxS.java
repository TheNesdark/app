package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.dao.impl.laboratorio.ImpresionReportesDAOImpl;
import com.toedter.calendar.JYearChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPARevisionAyudasDxS.class */
public class JPARevisionAyudasDxS extends JPanel {
    private String xnombre;
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private Object[] xdato;
    private clasesHistoriaCE xclase;
    public boolean revisionAyudasDxS;
    private JButton JBTGuardarTemporal;
    private JCheckBox JCHFiltro;
    private JCheckBox JCHSeleccionarTodo;
    private JPanel JPIDRevisionExa;
    private JPanel JPIRevisionExa;
    private JScrollPane JSPInterpretacion;
    private JScrollPane JSPRevisionExa;
    private JScrollPane JSPRevisionExa1;
    private JScrollPane JSPRevisionExa2;
    private JTable JTBRevisionExa;
    private JTable JTBRevisionExa1;
    private JTable JTBRevisionExa2;
    private JTextField JTFNombre;
    private JTabbedPane JTPDatos;
    private JTextPane JTPInterpretacion;
    private JYearChooser JYAno;
    private ConsultasMySQL xconsultasbd = new ConsultasMySQL();
    private Metodos xmetodo = new Metodos();
    private int xestado = 0;

    public JPARevisionAyudasDxS(clasesHistoriaCE xclase, String xnombre) {
        this.revisionAyudasDxS = false;
        initComponents();
        this.xclase = xclase;
        this.xnombre = xnombre;
        System.out.println("nombreeee -> " + xnombre);
        this.JPIDRevisionExa.setBorder(BorderFactory.createTitledBorder((Border) null, "EXÁMENES DE " + xnombre.toUpperCase(), 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        mCrearTablaExamen();
        mCrearTablaExamenEsp();
        mCargarExamenes();
        mCargarExamenes1();
        if (this.JTBRevisionExa.getRowCount() > 0) {
            int i = 0;
            while (true) {
                if (i < this.JTBRevisionExa.getRowCount()) {
                    Object valorCelda = this.JTBRevisionExa.getValueAt(i, 7);
                    if (valorCelda == null || valorCelda.toString().isEmpty()) {
                        i++;
                    } else {
                        this.revisionAyudasDxS = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        } else {
            this.revisionAyudasDxS = true;
        }
        if (!Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
            this.JCHSeleccionarTodo.setVisible(false);
        }
    }

    /* JADX WARN: Type inference failed for: r3v15, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v21, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIRevisionExa = new JPanel();
        this.JPIDRevisionExa = new JPanel();
        this.JTFNombre = new JTextField();
        this.JCHFiltro = new JCheckBox();
        this.JTPDatos = new JTabbedPane();
        this.JSPRevisionExa = new JScrollPane();
        this.JTBRevisionExa = new JTable();
        this.JSPRevisionExa1 = new JScrollPane();
        this.JTBRevisionExa1 = new JTable();
        this.JSPRevisionExa2 = new JScrollPane();
        this.JTBRevisionExa2 = new JTable();
        this.JCHSeleccionarTodo = new JCheckBox();
        this.JBTGuardarTemporal = new JButton();
        this.JSPInterpretacion = new JScrollPane();
        this.JTPInterpretacion = new JTextPane();
        this.JYAno = new JYearChooser();
        setMaximumSize(null);
        setName("jpayudasdxs");
        setRequestFocusEnabled(false);
        this.JPIDRevisionExa.setBorder(BorderFactory.createTitledBorder((Border) null, "EXÁMENES", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombre.addKeyListener(new KeyAdapter() { // from class: Historia.JPARevisionAyudasDxS.1
            public void keyPressed(KeyEvent evt) {
                JPARevisionAyudasDxS.this.JTFNombreKeyPressed(evt);
            }

            public void keyTyped(KeyEvent evt) {
                JPARevisionAyudasDxS.this.JTFNombreKeyTyped(evt);
            }
        });
        this.JCHFiltro.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro.setForeground(Color.blue);
        this.JCHFiltro.setText("Filtro");
        this.JCHFiltro.addActionListener(new ActionListener() { // from class: Historia.JPARevisionAyudasDxS.2
            public void actionPerformed(ActionEvent evt) {
                JPARevisionAyudasDxS.this.JCHFiltroActionPerformed(evt);
            }
        });
        this.JTPDatos.setForeground(Color.red);
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JTBRevisionExa.setFont(new Font("Arial", 1, 12));
        this.JTBRevisionExa.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBRevisionExa.setRowHeight(25);
        this.JTBRevisionExa.setSelectionBackground(new Color(255, 255, 255));
        this.JTBRevisionExa.setSelectionForeground(new Color(255, 0, 0));
        this.JTBRevisionExa.setSelectionMode(0);
        this.JTBRevisionExa.addMouseListener(new MouseAdapter() { // from class: Historia.JPARevisionAyudasDxS.3
            public void mouseClicked(MouseEvent evt) {
                JPARevisionAyudasDxS.this.JTBRevisionExaMouseClicked(evt);
            }
        });
        this.JSPRevisionExa.setViewportView(this.JTBRevisionExa);
        this.JTPDatos.addTab("SISTEMATIZADOS", this.JSPRevisionExa);
        this.JTBRevisionExa1.setFont(new Font("Arial", 1, 12));
        this.JTBRevisionExa1.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBRevisionExa1.setRowHeight(25);
        this.JTBRevisionExa1.setSelectionBackground(new Color(255, 255, 255));
        this.JTBRevisionExa1.setSelectionForeground(new Color(255, 0, 0));
        this.JTBRevisionExa1.setSelectionMode(0);
        this.JTBRevisionExa1.addMouseListener(new MouseAdapter() { // from class: Historia.JPARevisionAyudasDxS.4
            public void mouseClicked(MouseEvent evt) {
                JPARevisionAyudasDxS.this.JTBRevisionExa1MouseClicked(evt);
            }
        });
        this.JSPRevisionExa1.setViewportView(this.JTBRevisionExa1);
        this.JTPDatos.addTab("ESPECIALIZADOS", this.JSPRevisionExa1);
        this.JTBRevisionExa2.setFont(new Font("Arial", 1, 12));
        this.JTBRevisionExa2.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBRevisionExa2.setRowHeight(25);
        this.JTBRevisionExa2.setSelectionBackground(new Color(255, 255, 255));
        this.JTBRevisionExa2.setSelectionForeground(new Color(255, 0, 0));
        this.JTBRevisionExa2.setSelectionMode(0);
        this.JTBRevisionExa2.addMouseListener(new MouseAdapter() { // from class: Historia.JPARevisionAyudasDxS.5
            public void mouseClicked(MouseEvent evt) {
                JPARevisionAyudasDxS.this.JTBRevisionExa2MouseClicked(evt);
            }
        });
        this.JSPRevisionExa2.setViewportView(this.JTBRevisionExa2);
        this.JTPDatos.addTab("DIGITALIZADOS", this.JSPRevisionExa2);
        this.JCHSeleccionarTodo.setFont(new Font("Arial", 1, 12));
        this.JCHSeleccionarTodo.setForeground(Color.blue);
        this.JCHSeleccionarTodo.setText("Seleccionar todo");
        this.JCHSeleccionarTodo.addActionListener(new ActionListener() { // from class: Historia.JPARevisionAyudasDxS.6
            public void actionPerformed(ActionEvent evt) {
                JPARevisionAyudasDxS.this.JCHSeleccionarTodoActionPerformed(evt);
            }
        });
        GroupLayout JPIDRevisionExaLayout = new GroupLayout(this.JPIDRevisionExa);
        this.JPIDRevisionExa.setLayout(JPIDRevisionExaLayout);
        JPIDRevisionExaLayout.setHorizontalGroup(JPIDRevisionExaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDRevisionExaLayout.createSequentialGroup().addContainerGap().addGroup(JPIDRevisionExaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPDatos, -1, 768, 32767).addGroup(JPIDRevisionExaLayout.createSequentialGroup().addComponent(this.JTFNombre, -1, 693, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHFiltro).addContainerGap()))).addGroup(GroupLayout.Alignment.TRAILING, JPIDRevisionExaLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JCHSeleccionarTodo).addContainerGap()));
        JPIDRevisionExaLayout.setVerticalGroup(JPIDRevisionExaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDRevisionExaLayout.createSequentialGroup().addGroup(JPIDRevisionExaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombre, -1, 50, 32767).addComponent(this.JCHFiltro)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHSeleccionarTodo).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPDatos, -2, 165, -2).addContainerGap()));
        this.JBTGuardarTemporal.setFont(new Font("Arial", 1, 14));
        this.JBTGuardarTemporal.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBTGuardarTemporal.setText("Guardar");
        this.JBTGuardarTemporal.setEnabled(false);
        this.JBTGuardarTemporal.addActionListener(new ActionListener() { // from class: Historia.JPARevisionAyudasDxS.7
            public void actionPerformed(ActionEvent evt) {
                JPARevisionAyudasDxS.this.JBTGuardarTemporalActionPerformed(evt);
            }
        });
        this.JBTGuardarTemporal.addKeyListener(new KeyAdapter() { // from class: Historia.JPARevisionAyudasDxS.8
            public void keyPressed(KeyEvent evt) {
                JPARevisionAyudasDxS.this.JBTGuardarTemporalKeyPressed(evt);
            }
        });
        this.JSPInterpretacion.setBorder(BorderFactory.createTitledBorder((Border) null, "INTERPRETACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTPInterpretacion.setEditable(false);
        this.JTPInterpretacion.setFont(new Font("Arial", 1, 12));
        this.JTPInterpretacion.addKeyListener(new KeyAdapter() { // from class: Historia.JPARevisionAyudasDxS.9
            public void keyPressed(KeyEvent evt) {
                JPARevisionAyudasDxS.this.JTPInterpretacionKeyPressed(evt);
            }
        });
        this.JSPInterpretacion.setViewportView(this.JTPInterpretacion);
        this.JYAno.setBorder(BorderFactory.createTitledBorder((Border) null, "Año", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JYAno.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPARevisionAyudasDxS.10
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPARevisionAyudasDxS.this.JYAnoPropertyChange(evt);
            }
        });
        GroupLayout JPIRevisionExaLayout = new GroupLayout(this.JPIRevisionExa);
        this.JPIRevisionExa.setLayout(JPIRevisionExaLayout);
        JPIRevisionExaLayout.setHorizontalGroup(JPIRevisionExaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIRevisionExaLayout.createSequentialGroup().addContainerGap().addGroup(JPIRevisionExaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPInterpretacion, -1, 784, 32767).addComponent(this.JPIDRevisionExa, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, JPIRevisionExaLayout.createSequentialGroup().addComponent(this.JYAno, -2, 82, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTGuardarTemporal, -2, 691, -2))).addContainerGap()));
        JPIRevisionExaLayout.setVerticalGroup(JPIRevisionExaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIRevisionExaLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDRevisionExa, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPInterpretacion, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIRevisionExaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTGuardarTemporal, -1, 57, 32767).addComponent(this.JYAno, -1, 57, 32767)).addContainerGap()));
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(14, 32767).addComponent(this.JPIRevisionExa, -2, -1, -2).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIRevisionExa, -2, -1, -2).addContainerGap(-1, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPInterpretacionKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9) {
            this.JTPInterpretacion.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBRevisionExaMouseClicked(MouseEvent evt) {
        int columnaClic = this.JTBRevisionExa.columnAtPoint(evt.getPoint());
        if (columnaClic != 14 && this.JTBRevisionExa.getSelectedRow() != -1) {
            int filaSeleccionada = this.JTBRevisionExa.getSelectedRow();
            if (this.xmodelo.getValueAt(this.JTBRevisionExa.getSelectedRow(), 6).toString().equals("false") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                this.JTPInterpretacion.setText((String) null);
                this.JTPInterpretacion.setEditable(true);
                this.JBTGuardarTemporal.setEnabled(true);
            } else {
                this.JTPInterpretacion.setText(this.xmodelo.getValueAt(this.JTBRevisionExa.getSelectedRow(), 7).toString());
                this.JTPInterpretacion.setEditable(true);
                this.JBTGuardarTemporal.setEnabled(true);
            }
            if (Integer.valueOf(this.xmodelo.getValueAt(filaSeleccionada, 12).toString()).intValue() == 0) {
                ImpresionReportesDAOImpl impresion = new ImpresionReportesDAOImpl();
                if (this.xmodelo.getValueAt(this.JTBRevisionExa.getSelectedRow(), 0).toString().equals("898001")) {
                    if (Principal.informacionIps.getNombreIps().equals("E.S.E CAMU BUENAVISTA")) {
                        impresion.mImprimirResultado(this.xmodelo.getValueAt(filaSeleccionada, 9).toString(), this.xmodelo.getValueAt(filaSeleccionada, 0).toString(), this.xmetodo.getSO() + this.xmetodo.getBarra() + "Reportes" + this.xmetodo.getBarra(), this.xmetodo.getSO() + this.xmetodo.getBarra() + "Firmas" + this.xmetodo.getBarra(), true, String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido()), true);
                        return;
                    }
                    String[][] parametros = new String[3][2];
                    parametros[0][0] = "Id";
                    parametros[0][1] = this.xmodelo.getValueAt(this.JTBRevisionExa.getSelectedRow(), 9).toString();
                    parametros[1][0] = "SUBREPORT_DIR";
                    parametros[1][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Reportes" + this.xmetodo.getBarra();
                    parametros[2][0] = "SUBREPORTFIRMA_DIR";
                    parametros[2][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Firmas" + this.xmetodo.getBarra();
                    this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "P_EnvioCitologiaN_1_1_03", parametros);
                    return;
                }
                Object[] botones = {"Por orden de recepción", "Por tipo resultado", "Cerrar"};
                int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "IMPRIMIR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
                if (n == 0) {
                    impresion.mImprimirResultado(this.xmodelo.getValueAt(filaSeleccionada, 9).toString(), "", this.xmetodo.getSO() + this.xmetodo.getBarra() + "Reportes" + this.xmetodo.getBarra(), this.xmetodo.getSO() + this.xmetodo.getBarra() + "Firmas" + this.xmetodo.getBarra(), true, String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido()), true);
                    return;
                } else {
                    if (n == 1) {
                        impresion.mImprimirResultado(this.xmodelo.getValueAt(filaSeleccionada, 9).toString(), this.xmodelo.getValueAt(filaSeleccionada, 0).toString(), this.xmetodo.getSO() + this.xmetodo.getBarra() + "Reportes" + this.xmetodo.getBarra(), this.xmetodo.getSO() + this.xmetodo.getBarra() + "Firmas" + this.xmetodo.getBarra(), true, String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido()), true);
                        return;
                    }
                    return;
                }
            }
            this.xmetodo.mostrarPdf(this.xmodelo.getValueAt(this.JTBRevisionExa.getSelectedRow(), 11).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGuardarTemporalActionPerformed(ActionEvent evt) {
        mGrabarBd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGuardarTemporalKeyPressed(KeyEvent evt) {
        mGrabarBd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreKeyPressed(KeyEvent evt) {
        if (!this.JTFNombre.getText().isEmpty()) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreKeyTyped(KeyEvent evt) {
        if (!this.JTFNombre.getText().isEmpty()) {
            mCargarExamenes();
            mCargarExamenes();
        } else {
            mCrearTablaExamen();
            mCrearTablaExamenEsp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroActionPerformed(ActionEvent evt) {
        if (this.JCHFiltro.isSelected()) {
            if (!this.JTFNombre.getText().isEmpty()) {
                mCargarExamenes();
                mCargarExamenes1();
                return;
            } else {
                mCrearTablaExamen();
                mCrearTablaExamenEsp();
                return;
            }
        }
        if (!this.JTFNombre.getText().isEmpty()) {
            mCargarExamenes();
            mCargarExamenes1();
        } else {
            mCrearTablaExamen();
            mCrearTablaExamenEsp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JYAnoPropertyChange(PropertyChangeEvent evt) {
        mCargarExamenes();
        mCargarExamenes1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBRevisionExa1MouseClicked(MouseEvent evt) {
        if (this.JTBRevisionExa1.getSelectedRow() != -1) {
            if (this.xmodelo1.getValueAt(this.JTBRevisionExa1.getSelectedRow(), 6).toString().equals("false")) {
                this.JTPInterpretacion.setText((String) null);
                this.JTPInterpretacion.setEditable(true);
                this.JBTGuardarTemporal.setEnabled(true);
            } else {
                this.JTPInterpretacion.setText(this.xmodelo1.getValueAt(this.JTBRevisionExa1.getSelectedRow(), 7).toString());
                this.JTPInterpretacion.setEditable(false);
                this.JBTGuardarTemporal.setEnabled(false);
            }
            int ver = JOptionPane.showInternalConfirmDialog(this, "Desea ver presentación preliminar del exámen?", "VISTA PRELIMINAR", 0);
            if (ver == 0) {
                if (this.xmodelo1.getValueAt(this.JTBRevisionExa1.getSelectedRow(), 13) != null) {
                    this.xmetodo.AbrirArchivosblob(this.xmodelo1.getValueAt(this.JTBRevisionExa1.getSelectedRow(), 13), "soporte", "pdf", true);
                } else {
                    this.xmetodo.mostrarPdf(this.xmodelo1.getValueAt(this.JTBRevisionExa1.getSelectedRow(), 11).toString());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBRevisionExa2MouseClicked(MouseEvent evt) {
        if (this.JTBRevisionExa.getSelectedRow() != -1) {
            if (this.xmodelo.getValueAt(this.JTBRevisionExa.getSelectedRow(), 4).toString().equals("No Revisado")) {
                this.JTPInterpretacion.setText((String) null);
                this.JTPInterpretacion.setEditable(true);
                this.JBTGuardarTemporal.setEnabled(true);
            } else {
                this.JTPInterpretacion.setText(this.xmodelo.getValueAt(this.JTBRevisionExa.getSelectedRow(), 3).toString());
                this.JTPInterpretacion.setEditable(false);
                this.JBTGuardarTemporal.setEnabled(false);
            }
            int ver = JOptionPane.showInternalConfirmDialog(this, "Desea ver presentacion preliminar del examen", "VISTA PRELIMINAR", 0);
            if (ver == 0) {
                this.xmetodo.mostrarPdf(this.xmodelo.getValueAt(this.JTBRevisionExa.getSelectedRow(), 5).toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHSeleccionarTodoActionPerformed(ActionEvent evt) {
        if (this.xmodelo.getRowCount() > 0) {
            if (this.JCHSeleccionarTodo.isSelected()) {
                for (int i = 0; this.xmodelo.getRowCount() > i; i++) {
                    this.xmodelo.setValueAt(true, i, 14);
                }
                this.JTPInterpretacion.setEditable(true);
                this.JBTGuardarTemporal.setEnabled(true);
                return;
            }
            for (int i2 = 0; this.xmodelo.getRowCount() > i2; i2++) {
                this.xmodelo.setValueAt(false, i2, 14);
            }
        }
    }

    private void mCrearVistaAjustes(String xsql) {
        this.xconsultasbd.ejecutarSQL("DROP VIEW IF EXISTS l_v_tmp_planilla  ");
        this.xconsultasbd.cerrarConexionBd();
        String sqlw = "CREATE VIEW l_v_tmp_planilla AS " + xsql;
        this.xconsultasbd.ejecutarSQL(sqlw);
        this.xconsultasbd.cerrarConexionBd();
    }

    public void mGrabarBd() {
        if (!this.JTPInterpretacion.getText().isEmpty()) {
            String sql = null;
            if (this.JTPDatos.getSelectedIndex() == 0) {
                if (this.JTBRevisionExa.getSelectedRow() != -1 || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                    if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                        for (int i = 0; i < this.xmodelo.getRowCount(); i++) {
                            if (Boolean.valueOf(this.xmodelo.getValueAt(i, 14).toString()).booleanValue()) {
                                sql = "update l_detallerecepcion set Id_Atencion='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "', Interpretacion='" + this.JTPInterpretacion.getText() + "', I_Fecha='" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "', I_Profesional='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "', I_Especialidad='" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "' where Id_Recepcion='" + this.xmodelo.getValueAt(i, 9).toString() + "' and Id_Procedim='" + this.JTBRevisionExa.getValueAt(i, 0).toString() + "'";
                                this.xconsultasbd.ejecutarSQL(sql);
                            }
                        }
                    } else {
                        sql = "update l_detallerecepcion set Id_Atencion='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "', Interpretacion='" + this.JTPInterpretacion.getText() + "', I_Fecha='" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "', I_Profesional='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "', I_Especialidad='" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "' where Id_Recepcion='" + this.xmodelo.getValueAt(this.JTBRevisionExa.getSelectedRow(), 9).toString() + "' and Id_Procedim='" + this.xmodelo.getValueAt(this.JTBRevisionExa.getSelectedRow(), 0).toString() + "'";
                        this.xconsultasbd.ejecutarSQL(sql);
                    }
                    System.out.println("Actualizar interpretacion -> " + sql);
                    this.xconsultasbd.cerrarConexionBd();
                    mCargarExamenes();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un examen a revisar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTBRevisionExa.requestFocus();
                return;
            }
            if (this.JTPDatos.getSelectedIndex() == 1) {
                if (this.JTBRevisionExa1.getSelectedRow() != -1) {
                    String sql2 = "update l_detallerecepcion set Id_Atencion='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "', Interpretacion='" + this.JTPInterpretacion.getText() + "', I_Fecha='" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "', I_Profesional='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "', I_Especialidad='" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "' where Id_Recepcion='" + this.xmodelo1.getValueAt(this.JTBRevisionExa1.getSelectedRow(), 9).toString() + "' and Id_Procedim='" + this.xmodelo1.getValueAt(this.JTBRevisionExa1.getSelectedRow(), 0).toString() + "'";
                    this.xconsultasbd.ejecutarSQL(sql2);
                    this.xconsultasbd.cerrarConexionBd();
                    mCargarExamenes1();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un examen a revisar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTBRevisionExa.requestFocus();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "La interpretacion no puede ser nula", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTBRevisionExa.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaExamen() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"", "Fecha", "Procedimiento", "Profesional", "Especialidad", "Alterado", "Revisado", "Interpretación", "", "", "", "", "xtipo", "xtipo", "Seleccionar"}) { // from class: Historia.JPARevisionAyudasDxS.11
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, Boolean.class, Boolean.class, String.class, Long.class, Long.class, Integer.class, String.class, Long.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBRevisionExa.setModel(this.xmodelo);
        this.JTBRevisionExa.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTBRevisionExa.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTBRevisionExa.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTBRevisionExa.getColumnModel().getColumn(1).setPreferredWidth(30);
        this.JTBRevisionExa.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTBRevisionExa.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTBRevisionExa.getColumnModel().getColumn(4).setPreferredWidth(40);
        this.JTBRevisionExa.getColumnModel().getColumn(5).setPreferredWidth(20);
        this.JTBRevisionExa.getColumnModel().getColumn(6).setPreferredWidth(20);
        this.JTBRevisionExa.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTBRevisionExa.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTBRevisionExa.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTBRevisionExa.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTBRevisionExa.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTBRevisionExa.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTBRevisionExa.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTBRevisionExa.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTBRevisionExa.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTBRevisionExa.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTBRevisionExa.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTBRevisionExa.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTBRevisionExa.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTBRevisionExa.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTBRevisionExa.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTBRevisionExa.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTBRevisionExa.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTBRevisionExa.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTBRevisionExa.getColumnModel().getColumn(13).setMaxWidth(0);
        if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
            this.JTBRevisionExa.getColumnModel().getColumn(14).setPreferredWidth(30);
            return;
        }
        this.JTBRevisionExa.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTBRevisionExa.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTBRevisionExa.getColumnModel().getColumn(14).setMaxWidth(0);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaExamenEsp() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"", "Fecha", "Procedimiento", "Profesional", "Especialidad", "Alterado", "Revisado", "Interpretación", "", "", "", "", "xtipo", "Archivo Externo"}) { // from class: Historia.JPARevisionAyudasDxS.12
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, Boolean.class, Boolean.class, String.class, Long.class, Long.class, Integer.class, String.class, Long.class, Byte.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBRevisionExa1.setModel(this.xmodelo1);
        this.JTBRevisionExa1.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTBRevisionExa1.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTBRevisionExa1.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTBRevisionExa1.getColumnModel().getColumn(1).setPreferredWidth(30);
        this.JTBRevisionExa1.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTBRevisionExa1.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTBRevisionExa1.getColumnModel().getColumn(4).setPreferredWidth(40);
        this.JTBRevisionExa1.getColumnModel().getColumn(5).setPreferredWidth(20);
        this.JTBRevisionExa1.getColumnModel().getColumn(6).setPreferredWidth(20);
        this.JTBRevisionExa1.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTBRevisionExa1.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTBRevisionExa1.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTBRevisionExa1.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTBRevisionExa1.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTBRevisionExa1.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTBRevisionExa1.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTBRevisionExa1.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTBRevisionExa1.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTBRevisionExa1.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTBRevisionExa1.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTBRevisionExa1.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTBRevisionExa1.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTBRevisionExa1.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTBRevisionExa1.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTBRevisionExa1.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTBRevisionExa1.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTBRevisionExa1.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTBRevisionExa1.getColumnModel().getColumn(13).setMaxWidth(0);
    }

    private void mCargarExamenes() {
        String sql;
        mCrearTablaExamen();
        int m = 0;
        ConsultasMySQL xct = new ConsultasMySQL();
        if (this.JCHFiltro.isSelected()) {
            sql = "SELECT g_procedimiento.Id, DATE_FORMAT(l_resultados.FechaResult,'%d-%m-%Y') AS fecha, g_procedimiento.Nbre\n,  CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`)  NProfesional\n, `g_especialidad`.`Nbre` Especialidad\n, l_detallerecepcion.Alterado   , IF(l_detallerecepcion.Id_Atencion=0,0,1) AS revisado, l_detallerecepcion.Interpretacion , l_resultados.Id , l_resultados.Id_Recepcion, l_resultados.Soporte, l_resultados.Url, g_procedimiento.EsRemitido \nFROM\n     `l_detalleresultado`\n    INNER JOIN  `l_resultados` \n        ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\n    INNER JOIN  `l_detallerecepcion` \n        ON (`l_detallerecepcion`.`Id_Recepcion` = `l_resultados`.`Id_Recepcion`) AND (`l_detallerecepcion`.`Id_Procedim` = `l_detalleresultado`.`Id_Procedimiento`)\n    INNER JOIN  `l_recepcion` \n        ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN  `g_procedimiento` \n        ON (`l_detallerecepcion`.`Id_Procedim` = `g_procedimiento`.`Id`)\n    INNER JOIN  `g_profesional` \n        ON (`g_profesional`.`Id_Persona` = `l_recepcion`.`Id_Profesional`)\n    INNER JOIN  `g_especialidad` \n        ON (`l_recepcion`.`Id_Especialidad` = `g_especialidad`.`Id`)\n    INNER JOIN  `g_persona` \n        ON (`g_persona`.`Id` = `g_profesional`.`Id_Persona`)\nWHERE (DATE_FORMAT(l_resultados.FechaResult,'%Y') ='" + this.JYAno.getValue() + "'\n    AND `l_recepcion`.`Id_Paciente` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "'\n    and g_procedimiento.Nbre like'" + this.JTFNombre.getText() + "%' AND `l_detallerecepcion`.`ValidadoLab` =1\n    AND `l_recepcion`.`Estado` =0\n    AND `l_detalleresultado`.`Estado` =1)\nGROUP BY g_procedimiento.Id, l_resultados.Id_Recepcion \n   ORDER BY l_resultados.FechaResult DESC \n  ";
        } else {
            sql = "SELECT g_procedimiento.Id, DATE_FORMAT(l_resultados.FechaResult,'%d-%m-%Y') AS fecha, g_procedimiento.Nbre\n,  CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`)  NProfesional\n, `g_especialidad`.`Nbre` Especialidad\n, l_detallerecepcion.Alterado   , IF(l_detallerecepcion.Id_Atencion=0,0,1) AS revisado, l_detallerecepcion.Interpretacion , l_resultados.Id , l_resultados.Id_Recepcion, l_resultados.Soporte, l_resultados.Url, g_procedimiento.EsRemitido \nFROM\n     `l_detalleresultado`\n    INNER JOIN  `l_resultados` \n        ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\n    INNER JOIN  `l_detallerecepcion` \n        ON (`l_detallerecepcion`.`Id_Recepcion` = `l_resultados`.`Id_Recepcion`) AND (`l_detallerecepcion`.`Id_Procedim` = `l_detalleresultado`.`Id_Procedimiento`)\n    INNER JOIN  `l_recepcion` \n        ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN  `g_procedimiento` \n        ON (`l_detallerecepcion`.`Id_Procedim` = `g_procedimiento`.`Id`)\n    INNER JOIN  `g_profesional` \n        ON (`g_profesional`.`Id_Persona` = `l_recepcion`.`Id_Profesional`)\n    INNER JOIN  `g_especialidad` \n        ON (`l_recepcion`.`Id_Especialidad` = `g_especialidad`.`Id`)\n    INNER JOIN  `g_persona` \n        ON (`g_persona`.`Id` = `g_profesional`.`Id_Persona`)\nWHERE (DATE_FORMAT(l_resultados.FechaResult,'%Y') ='" + this.JYAno.getValue() + "'\n    AND `l_recepcion`.`Id_Paciente` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "'\n    AND `l_detallerecepcion`.`ValidadoLab` =1\n    AND `l_recepcion`.`Estado` =0\n    AND `l_detalleresultado`.`Estado` =1)\nGROUP BY g_procedimiento.Id, l_resultados.Id_Recepcion \n   ORDER BY l_resultados.FechaResult DESC \n  ";
        }
        ResultSet rs = xct.traerRs(sql);
        System.out.println(" Uno : " + sql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.JTBRevisionExa.setValueAt(Long.valueOf(rs.getLong(1)), m, 0);
                    this.JTBRevisionExa.setValueAt(rs.getString(2), m, 1);
                    this.JTBRevisionExa.setValueAt(rs.getString(3), m, 2);
                    this.JTBRevisionExa.setValueAt(rs.getString(4), m, 3);
                    this.JTBRevisionExa.setValueAt(rs.getString(5), m, 4);
                    this.JTBRevisionExa.setValueAt(Boolean.valueOf(rs.getBoolean(6)), m, 5);
                    this.JTBRevisionExa.setValueAt(Boolean.valueOf(rs.getBoolean(7)), m, 6);
                    this.JTBRevisionExa.setValueAt(rs.getString(8), m, 7);
                    this.JTBRevisionExa.setValueAt(Long.valueOf(rs.getLong(9)), m, 8);
                    this.JTBRevisionExa.setValueAt(Long.valueOf(rs.getLong(10)), m, 9);
                    this.JTBRevisionExa.setDefaultRenderer(Object.class, new MiRender());
                    this.JTBRevisionExa.setValueAt(Integer.valueOf(rs.getInt(11)), m, 10);
                    this.JTBRevisionExa.setValueAt(rs.getString(12), m, 11);
                    this.JTBRevisionExa.setValueAt(0, m, 12);
                    this.JTBRevisionExa.setValueAt(Boolean.valueOf(rs.getBoolean(13)), m, 13);
                    this.JTBRevisionExa.setValueAt(false, m, 14);
                    m++;
                }
            }
            rs.close();
            xct.cerrarConexionBd();
        } catch (SQLException e) {
        }
        this.JCHSeleccionarTodo.setSelected(false);
    }

    private void mCargarExamenes1() {
        String sql1;
        mCrearTablaExamenEsp();
        int m = 0;
        if (this.JCHFiltro.isSelected()) {
            sql1 = "SELECT g_procedimiento.Id, DATE_FORMAT(l_recepcion.`FechaRecep`,'%d-%m-%Y') AS fecha, g_procedimiento.Nbre, profesional1.NProfesional, profesional1.Especialidad, l_detallerecepcion.Alterado   , IF(l_detallerecepcion.Id_Atencion=0,0,1) AS revisado,  l_detallerecepcion.Interpretacion , 0 , l_detallerecepcion.Id_Recepcion , 0,l_detallerecepcion.NArchivo, l_detallerecepcion.ArchivoResultadoExterno FROM l_detallerecepcion  INNER JOIN l_recepcion  ON (l_detallerecepcion.Id_Recepcion = l_recepcion.Id)  INNER JOIN g_procedimiento  ON (l_detallerecepcion.Id_Procedim = g_procedimiento.Id)  INNER JOIN profesional1  ON (l_recepcion.Id_Profesional = profesional1.Id_Persona) AND (l_recepcion.Id_Especialidad = profesional1.IdEspecialidad)  WHERE (l_recepcion.Id_Paciente ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "'  and g_procedimiento.Nbre like'" + this.JTFNombre.getText() + "%' and l_recepcion.Estado=0  and date_format(l_detallerecepcion.FechaResultado,'%Y')='" + this.JYAno.getValue() + "' and l_detallerecepcion.ValidadoLab=1)  and (l_detallerecepcion.NArchivo<>'' OR l_detallerecepcion.ArchivoResultadoExterno IS NOT NULL) GROUP BY l_recepcion.id, g_procedimiento.Id ORDER BY l_detallerecepcion.FechaResultado DESC ";
        } else {
            sql1 = "SELECT g_procedimiento.Id, DATE_FORMAT(l_recepcion.`FechaRecep`,'%d-%m-%Y') AS fecha, g_procedimiento.Nbre, profesional1.NProfesional, profesional1.Especialidad, l_detallerecepcion.Alterado   , IF(l_detallerecepcion.Id_Atencion=0,0,1) AS revisado,  l_detallerecepcion.Interpretacion , 0 , l_detallerecepcion.Id_Recepcion , 0,l_detallerecepcion.NArchivo, l_detallerecepcion.ArchivoResultadoExterno FROM l_detallerecepcion  INNER JOIN l_recepcion  ON (l_detallerecepcion.Id_Recepcion = l_recepcion.Id)  INNER JOIN g_procedimiento  ON (l_detallerecepcion.Id_Procedim = g_procedimiento.Id)  INNER JOIN profesional1  ON (l_recepcion.Id_Profesional = profesional1.Id_Persona) AND (l_recepcion.Id_Especialidad = profesional1.IdEspecialidad)  WHERE (l_recepcion.Id_Paciente ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "'   and l_recepcion.Estado=0  and date_format(l_detallerecepcion.FechaResultado,'%Y')='" + this.JYAno.getValue() + "' and l_detallerecepcion.ValidadoLab=1)  and (l_detallerecepcion.NArchivo<>'' OR l_detallerecepcion.ArchivoResultadoExterno IS NOT NULL) GROUP BY l_recepcion.id, g_procedimiento.Id ORDER BY l_detallerecepcion.FechaResultado DESC ";
        }
        try {
            ResultSet rs = this.xconsultasbd.traerRs(sql1);
            if (rs.next()) {
                rs.beforeFirst();
                while (rs.next()) {
                    this.xmodelo1.addRow(this.xdato);
                    this.JTBRevisionExa1.setValueAt(Long.valueOf(rs.getLong(1)), m, 0);
                    this.JTBRevisionExa1.setValueAt(rs.getString(2), m, 1);
                    this.JTBRevisionExa1.setValueAt(rs.getString(3), m, 2);
                    this.JTBRevisionExa1.setValueAt(rs.getString(4), m, 3);
                    this.JTBRevisionExa1.setValueAt(rs.getString(5), m, 4);
                    this.JTBRevisionExa1.setValueAt(Boolean.valueOf(rs.getBoolean(6)), m, 5);
                    this.JTBRevisionExa1.setValueAt(Boolean.valueOf(rs.getBoolean(7)), m, 6);
                    this.JTBRevisionExa1.setValueAt(rs.getString(8), m, 7);
                    this.JTBRevisionExa1.setValueAt(Long.valueOf(rs.getLong(9)), m, 8);
                    this.JTBRevisionExa1.setValueAt(Long.valueOf(rs.getLong(10)), m, 9);
                    this.JTBRevisionExa1.setDefaultRenderer(Object.class, new MiRender());
                    this.JTBRevisionExa1.setValueAt(Integer.valueOf(rs.getInt(11)), m, 10);
                    this.JTBRevisionExa1.setValueAt(rs.getString(12), m, 11);
                    this.JTBRevisionExa1.setValueAt(1, m, 12);
                    this.JTBRevisionExa1.setValueAt(rs.getBytes("ArchivoResultadoExterno"), m, 13);
                    m++;
                }
            }
            rs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException e) {
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Historia/JPARevisionAyudasDxS$MiRender.class */
    public class MiRender extends DefaultTableCellRenderer {
        public MiRender() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (table.getValueAt(row, 5).toString().equals("true")) {
                cell.setBackground(new Color(103, 0, 103));
                cell.setForeground(Color.WHITE);
            } else {
                cell.setBackground(Color.WHITE);
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }
}
