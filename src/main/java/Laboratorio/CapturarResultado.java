package Laboratorio;

import Historia.JIFHistoriaClinica;
import com.genoma.plus.dao.impl.laboratorio.LaboratorioDAOImpl;
import com.genoma.plus.dto.laboratorio.TipoResultadoProtocoloDTO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:Laboratorio/CapturarResultado.class */
public class CapturarResultado extends JDialog {
    private DefaultTableModel modelo;
    private int edad;
    private Object[] fila;
    private ResultadoManual frmRM;
    private JIFResultadoxExamen xjifresultado;
    private JIFPlanillaTrabajo xjifplanilla;
    private JIFHistoriaClinica xjifhc;
    private String sexo;
    private String sql;
    private String frmllamador;
    private LaboratorioDAOImpl xImplLabotaorio;
    private JButton btnAceptar;
    private JTable grid;
    private JScrollPane jScrollPane1;
    private JTextField txtNumerico;

    public CapturarResultado(Frame parent, boolean modal, String protocolo, JInternalFrame frmRm) {
        super(parent, modal);
        this.edad = 0;
        this.sexo = "";
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setLocationRelativeTo(null);
        realizarcasting(frmRm);
        springStart();
        llenarGrid(protocolo);
    }

    private void springStart() {
        this.xImplLabotaorio = (LaboratorioDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("laboratorioDAOImpl");
    }

    private void crearGrid() {
        this.modelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Resultado", "Numerico", "Alterado", "Codigo Interfaz"}) { // from class: Laboratorio.CapturarResultado.1
            Class[] types = {String.class, String.class, Integer.class, Boolean.class, String.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.grid.setModel(this.modelo);
        this.grid.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.grid.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(2).setMinWidth(0);
        this.grid.getColumnModel().getColumn(2).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.grid.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(4).setMinWidth(0);
        this.grid.getColumnModel().getColumn(4).setMaxWidth(0);
    }

    private void llenarGrid(String protocolo) {
        List<TipoResultadoProtocoloDTO> list;
        crearGrid();
        if (this.frmllamador.equals("PlanillaTrabajo")) {
            list = this.xImplLabotaorio.listTipoResultadoProtocolo(Long.valueOf(protocolo), 0);
        } else if (this.frmllamador.equals("jifhistoriaclinica")) {
            list = this.xImplLabotaorio.listTipoResultadoProtocolo(Long.valueOf(protocolo), 1);
        } else {
            list = this.xImplLabotaorio.listTipoResultadoProtocoloEdad(Long.valueOf(protocolo), Integer.valueOf(this.edad), this.sexo);
        }
        if (list.size() > 0) {
            for (int x = 0; x < list.size(); x++) {
                this.modelo.addRow(this.fila);
                this.modelo.setValueAt(list.get(x).getId(), x, 0);
                this.modelo.setValueAt(list.get(x).getNombre(), x, 1);
                this.modelo.setValueAt(list.get(x).getVandera(), x, 2);
                this.modelo.setValueAt(list.get(x).getVAlterado(), x, 3);
                this.modelo.setValueAt(list.get(x).getCodigo(), x, 4);
                if (list.get(x).getVandera().intValue() == 82) {
                    this.txtNumerico.setEnabled(true);
                    this.btnAceptar.setEnabled(true);
                    this.txtNumerico.requestFocus();
                    return;
                }
            }
        }
    }

    private void realizarcasting(JInternalFrame frm) {
        if (frm.getName().equals("ResultadoManual")) {
            this.frmRM = (ResultadoManual) frm;
            this.frmllamador = "ResultadoManual";
            this.edad = this.frmRM.frmPersona.getEdad();
            this.sexo = this.frmRM.frmPersona.getIdSexo();
            return;
        }
        if (frm.getName().equals("jifresultadoxexamen")) {
            this.xjifresultado = (JIFResultadoxExamen) frm;
            this.frmllamador = "ResultadoxExamen";
            this.edad = this.xjifresultado.xedad;
            this.sexo = this.xjifresultado.xsexo;
            return;
        }
        if (frm.getName().equals("xjifplanillatrabajo")) {
            this.xjifplanilla = (JIFPlanillaTrabajo) frm;
            this.frmllamador = "PlanillaTrabajo";
            this.edad = Integer.valueOf(this.xjifplanilla.xmodelo1.getValueAt(this.xjifplanilla.JTBDetalleAnalito.getSelectedRow(), 14).toString()).intValue();
            this.sexo = this.xjifplanilla.xmodelo1.getValueAt(this.xjifplanilla.JTBDetalleAnalito.getSelectedRow(), 15).toString();
            return;
        }
        if (frm.getName().equals("jifhistoriaclinica")) {
            this.xjifhc = (JIFHistoriaClinica) frm;
            this.frmllamador = "jifhistoriaclinica";
        } else {
            this.frmllamador = "";
        }
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jScrollPane1 = new JScrollPane();
        this.grid = new JTable();
        this.txtNumerico = new JTextField();
        this.btnAceptar = new JButton();
        setDefaultCloseOperation(2);
        setTitle("TIPO DE RESULTADO");
        setName("CapturarResultado");
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.grid.setFont(new Font("Arial", 1, 12));
        this.grid.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.grid.setToolTipText("Haga Doble Click sobre la fila para cargar el Resultado");
        this.grid.setRowHeight(25);
        this.grid.setSelectionBackground(new Color(255, 255, 255));
        this.grid.setSelectionForeground(new Color(255, 0, 0));
        this.grid.setSelectionMode(0);
        this.grid.addMouseListener(new MouseAdapter() { // from class: Laboratorio.CapturarResultado.2
            public void mouseClicked(MouseEvent evt) {
                CapturarResultado.this.gridMouseClicked(evt);
            }
        });
        this.grid.addKeyListener(new KeyAdapter() { // from class: Laboratorio.CapturarResultado.3
            public void keyPressed(KeyEvent evt) {
                CapturarResultado.this.gridKeyPressed(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.grid);
        this.txtNumerico.setFont(new Font("Arial", 1, 12));
        this.txtNumerico.setHorizontalAlignment(4);
        this.txtNumerico.setToolTipText("Valor númerico");
        this.txtNumerico.setEnabled(false);
        this.txtNumerico.addActionListener(new ActionListener() { // from class: Laboratorio.CapturarResultado.4
            public void actionPerformed(ActionEvent evt) {
                CapturarResultado.this.txtNumericoActionPerformed(evt);
            }
        });
        this.txtNumerico.addFocusListener(new FocusAdapter() { // from class: Laboratorio.CapturarResultado.5
            public void focusLost(FocusEvent evt) {
                CapturarResultado.this.txtNumericoFocusLost(evt);
            }
        });
        this.txtNumerico.addKeyListener(new KeyAdapter() { // from class: Laboratorio.CapturarResultado.6
            public void keyPressed(KeyEvent evt) {
                CapturarResultado.this.txtNumericoKeyPressed(evt);
            }
        });
        this.btnAceptar.setFont(new Font("Arial", 1, 12));
        this.btnAceptar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Bueno.png")));
        this.btnAceptar.setText("Aceptar");
        this.btnAceptar.setEnabled(false);
        this.btnAceptar.addActionListener(new ActionListener() { // from class: Laboratorio.CapturarResultado.7
            public void actionPerformed(ActionEvent evt) {
                CapturarResultado.this.btnAceptarActionPerformed(evt);
            }
        });
        this.btnAceptar.addKeyListener(new KeyAdapter() { // from class: Laboratorio.CapturarResultado.8
            public void keyPressed(KeyEvent evt) {
                CapturarResultado.this.btnAceptarKeyPressed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(layout.createSequentialGroup().addComponent(this.txtNumerico, -2, 202, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.btnAceptar, -1, -1, 32767)).addComponent(this.jScrollPane1, -2, 366, -2)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -2, 246, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtNumerico, -2, 45, -2).addComponent(this.btnAceptar, -2, 53, -2)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnAceptarActionPerformed(ActionEvent evt) {
        mAsignar(this.grid.getSelectedRow());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNumericoFocusLost(FocusEvent evt) {
        this.btnAceptar.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNumericoActionPerformed(ActionEvent evt) {
        transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNumericoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.btnAceptar.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnAceptarKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            mAsignar(this.grid.getSelectedRow());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridKeyPressed(KeyEvent evt) {
        if (this.grid.getSelectedRow() != -1) {
            if (evt.getKeyCode() == 10) {
                if (this.frmllamador.equals("PlanillaTrabajo")) {
                    dispose();
                    this.xjifplanilla.mAsignarResultado(this.modelo.getValueAt(this.grid.getSelectedRow(), 1).toString(), this.modelo.getValueAt(this.grid.getSelectedRow(), 0).toString(), Boolean.valueOf(this.modelo.getValueAt(this.grid.getSelectedRow(), 3).toString()).booleanValue(), this.modelo.getValueAt(this.grid.getSelectedRow(), 4).toString());
                    return;
                }
                return;
            }
            if (evt.getKeyCode() == 27) {
                dispose();
                return;
            }
            return;
        }
        if (evt.getKeyCode() == 27) {
            dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridMouseClicked(MouseEvent evt) {
        if (this.grid.getSelectedRow() != -1) {
            if (this.modelo.getValueAt(this.grid.getSelectedRow(), 2).toString().equals("0")) {
                this.txtNumerico.setEnabled(true);
                this.btnAceptar.setEnabled(true);
                this.txtNumerico.requestFocus();
                return;
            }
            this.txtNumerico.setEnabled(false);
            this.btnAceptar.setEnabled(false);
            if (this.frmllamador.equals("ResultadoManual")) {
                dispose();
                this.frmRM.asignarResultado(this.modelo.getValueAt(this.grid.getSelectedRow(), 1).toString(), this.modelo.getValueAt(this.grid.getSelectedRow(), 0).toString(), this.modelo.getValueAt(this.grid.getSelectedRow(), 0).toString());
                return;
            }
            if (this.frmllamador.equals("jifresultadoxexamen")) {
                dispose();
                this.xjifresultado.mAsignarResultado(this.modelo.getValueAt(this.grid.getSelectedRow(), 1).toString(), this.modelo.getValueAt(this.grid.getSelectedRow(), 0).toString(), this.modelo.getValueAt(this.grid.getSelectedRow(), 0).toString());
                this.xjifresultado.mCalcularDato();
            } else if (this.frmllamador.equals("PlanillaTrabajo")) {
                dispose();
                System.err.println(this.modelo.getValueAt(this.grid.getSelectedRow(), 0).toString());
                this.xjifplanilla.mAsignarResultado(this.modelo.getValueAt(this.grid.getSelectedRow(), 1).toString(), this.modelo.getValueAt(this.grid.getSelectedRow(), 0).toString(), Boolean.valueOf(this.modelo.getValueAt(this.grid.getSelectedRow(), 3).toString()).booleanValue(), this.modelo.getValueAt(this.grid.getSelectedRow(), 4).toString());
            } else if (this.frmllamador.equals("jifhistoriaclinica")) {
                dispose();
                this.xjifhc.xjifpyprevisionexamenes.JTFFResultado.setText(this.modelo.getValueAt(this.grid.getSelectedRow(), 1).toString());
            }
        }
    }

    private void mAsignar(int nfila) {
        if (this.frmllamador.equals("ResultadoManual")) {
            dispose();
            this.frmRM.asignarResultado(this.modelo.getValueAt(nfila, 1).toString(), this.modelo.getValueAt(nfila, 0).toString(), this.txtNumerico.getText());
        } else if (this.frmllamador.equals("ResultadoxExamen")) {
            dispose();
            this.xjifresultado.mAsignarResultado(this.modelo.getValueAt(nfila, 1).toString(), this.modelo.getValueAt(nfila, 0).toString(), this.txtNumerico.getText());
            this.xjifresultado.mCalcularDato();
        }
    }
}
