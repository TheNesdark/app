package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPARevisionAyudasDx.class */
public class JPARevisionAyudasDx extends JPanel {
    private String xnombre;
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private ConsultasMySQL xconsultasbd = new ConsultasMySQL();
    private Metodos xmetodo = new Metodos();
    private clasesHistoriaCE xclase;
    private JButton JBTGuardarTemporal;
    private JPanel JPIRevisionExa;
    private JScrollPane JSPInterpretacion;
    private JScrollPane JSPRevisionExa;
    private JTable JTBRevisionExa;
    private JTextPane JTPInterpretacion;

    public JPARevisionAyudasDx(clasesHistoriaCE xclase, String xnombre) {
        initComponents();
        this.xclase = xclase;
        this.xnombre = xnombre;
        this.JSPRevisionExa.setBorder(BorderFactory.createTitledBorder((Border) null, "REVISIÓN DE " + xnombre.toUpperCase(), 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        mCrearTablaExamen();
        mCargarExamenes();
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIRevisionExa = new JPanel();
        this.JSPRevisionExa = new JScrollPane();
        this.JTBRevisionExa = new JTable();
        this.JBTGuardarTemporal = new JButton();
        this.JSPInterpretacion = new JScrollPane();
        this.JTPInterpretacion = new JTextPane();
        setName("jpayudasdx");
        setPreferredSize(new Dimension(801, 469));
        this.JSPRevisionExa.setBorder(BorderFactory.createTitledBorder((Border) null, "EXÁMEN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTBRevisionExa.setFont(new Font("Arial", 1, 12));
        this.JTBRevisionExa.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBRevisionExa.setRowHeight(25);
        this.JTBRevisionExa.setSelectionBackground(new Color(255, 255, 255));
        this.JTBRevisionExa.setSelectionForeground(new Color(255, 0, 0));
        this.JTBRevisionExa.setSelectionMode(0);
        this.JTBRevisionExa.addMouseListener(new MouseAdapter() { // from class: Historia.JPARevisionAyudasDx.1
            public void mouseClicked(MouseEvent evt) {
                JPARevisionAyudasDx.this.JTBRevisionExaMouseClicked(evt);
            }
        });
        this.JSPRevisionExa.setViewportView(this.JTBRevisionExa);
        this.JBTGuardarTemporal.setFont(new Font("Arial", 1, 14));
        this.JBTGuardarTemporal.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBTGuardarTemporal.setText("Guardar");
        this.JBTGuardarTemporal.setEnabled(false);
        this.JBTGuardarTemporal.addActionListener(new ActionListener() { // from class: Historia.JPARevisionAyudasDx.2
            public void actionPerformed(ActionEvent evt) {
                JPARevisionAyudasDx.this.JBTGuardarTemporalActionPerformed(evt);
            }
        });
        this.JBTGuardarTemporal.addKeyListener(new KeyAdapter() { // from class: Historia.JPARevisionAyudasDx.3
            public void keyPressed(KeyEvent evt) {
                JPARevisionAyudasDx.this.JBTGuardarTemporalKeyPressed(evt);
            }
        });
        this.JSPInterpretacion.setBorder(BorderFactory.createTitledBorder((Border) null, "INTERPRETACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTPInterpretacion.setEditable(false);
        this.JTPInterpretacion.setFont(new Font("Arial", 1, 12));
        this.JTPInterpretacion.addKeyListener(new KeyAdapter() { // from class: Historia.JPARevisionAyudasDx.4
            public void keyPressed(KeyEvent evt) {
                JPARevisionAyudasDx.this.JTPInterpretacionKeyPressed(evt);
            }
        });
        this.JSPInterpretacion.setViewportView(this.JTPInterpretacion);
        GroupLayout JPIRevisionExaLayout = new GroupLayout(this.JPIRevisionExa);
        this.JPIRevisionExa.setLayout(JPIRevisionExaLayout);
        JPIRevisionExaLayout.setHorizontalGroup(JPIRevisionExaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIRevisionExaLayout.createSequentialGroup().addContainerGap().addGroup(JPIRevisionExaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPRevisionExa, GroupLayout.Alignment.TRAILING, -1, 761, 32767).addComponent(this.JBTGuardarTemporal, GroupLayout.Alignment.TRAILING, -1, 761, 32767).addComponent(this.JSPInterpretacion, -1, 761, 32767)).addContainerGap()));
        JPIRevisionExaLayout.setVerticalGroup(JPIRevisionExaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIRevisionExaLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPRevisionExa, -2, 202, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPInterpretacion, -1, 127, 32767).addGap(24, 24, 24).addComponent(this.JBTGuardarTemporal, -2, 57, -2).addGap(21, 21, 21)));
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIRevisionExa, -2, -1, -2).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIRevisionExa, -1, -1, 32767).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPInterpretacionKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9) {
            this.JTPInterpretacion.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBRevisionExaMouseClicked(MouseEvent evt) {
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
                if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                    this.xmetodo.mostrarPdf(this.xmodelo.getValueAt(this.JTBRevisionExa.getSelectedRow(), 5).toString());
                } else {
                    this.xmetodo.mostrarPdf(this.xmetodo.mRutaSoporte("JPEscaneoDocumentosEnf") + "\\" + this.xmodelo.getValueAt(this.JTBRevisionExa.getSelectedRow(), 5).toString());
                }
            }
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

    public void mGrabarBd() {
        if (this.JTBRevisionExa.getSelectedRow() != -1) {
            if (!this.JTPInterpretacion.getText().isEmpty()) {
                String sql = "update h_resultadoayudasdx set IdAtencion='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "', Interpretacion='" + this.JTPInterpretacion.getText() + "', Estado=1 where Id='" + this.xmodelo.getValueAt(this.JTBRevisionExa.getSelectedRow(), 0).toString() + "'";
                this.xconsultasbd.ejecutarSQL(sql);
                this.xconsultasbd.cerrarConexionBd();
                mCrearTablaExamen();
                mCargarExamenes();
                this.xmetodo.cambiarEstadoValidadoItemHC(getName(), 1, true);
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "La interpretacion no puede ser nula", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTBRevisionExa.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un examen a revisar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTBRevisionExa.requestFocus();
    }

    private void mCrearTablaExamen() {
        this.xmodelo = new DefaultTableModel();
        this.xmodelo.addColumn("Id");
        this.xmodelo.addColumn("Fecha");
        this.xmodelo.addColumn("Profesional");
        this.xmodelo.addColumn("Interpretación");
        this.xmodelo.addColumn("Estado");
        this.xmodelo.addColumn("");
        this.JTBRevisionExa.setModel(this.xmodelo);
        this.JTBRevisionExa.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTBRevisionExa.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTBRevisionExa.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTBRevisionExa.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTBRevisionExa.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.JTBRevisionExa.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTBRevisionExa.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTBRevisionExa.getColumnModel().getColumn(5).setMaxWidth(0);
    }

    private void mCargarExamenes() {
        String sql = "SELECT h_resultadoayudasdx.Id, h_resultadoayudasdx.Fecha_Examen, profesional.NProfesional, h_resultadoayudasdx.Estado, h_resultadoayudasdx.interpretacion, h_resultadoayudasdx.Url FROM h_resultadoayudasdx INNER JOIN h_tipoayudadx ON (h_resultadoayudasdx.Id_TipoAyudaDX = h_tipoayudadx.Id) INNER JOIN profesional  ON (profesional.Id_Persona = h_resultadoayudasdx.Id_Profesional)  where h_resultadoayudasdx.Id_Usuario='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' and h_resultadoayudasdx.Anulado=0 and  h_tipoayudadx.Nbre= '" + this.xnombre + "' ORDER BY h_resultadoayudasdx.Fecha_Examen DESC ";
        ResultSet rs = this.xconsultasbd.traerRs(sql);
        try {
            rs.next();
            if (rs.getRow() != 0) {
                rs.beforeFirst();
                int m = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.JTBRevisionExa.setValueAt(rs.getString(1), m, 0);
                    this.JTBRevisionExa.setValueAt(this.xmetodo.formatoDMA.format((Date) rs.getDate(2)), m, 1);
                    this.JTBRevisionExa.setValueAt(rs.getString(3).toUpperCase(), m, 2);
                    if (rs.getInt(4) == 1) {
                        this.JTBRevisionExa.setValueAt("Revisado", m, 4);
                    } else {
                        this.JTBRevisionExa.setValueAt("No Revisado", m, 4);
                    }
                    this.JTBRevisionExa.setValueAt(rs.getString(5), m, 3);
                    this.JTBRevisionExa.setValueAt(rs.getString(6), m, 5);
                    m++;
                }
                this.xmetodo.cambiarEstadoValidadoItemHC(getName(), 1, true);
            }
            rs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException e) {
        }
    }
}
