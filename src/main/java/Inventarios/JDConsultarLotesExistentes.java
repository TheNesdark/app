package Inventarios;

import Utilidades.Metodos;
import com.genoma.plus.jpa.projection.IInformacionInventario;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Inventarios/JDConsultarLotesExistentes.class */
public class JDConsultarLotesExistentes extends JDialog {
    private Entradas xentrada;
    DefaultTableModel xmodelo;
    private Metodos xmt;
    private JScrollPane JSPDetalle;
    private JTable JTResultado;

    public JDConsultarLotesExistentes(Frame parent, boolean modal, Entradas xentrada) {
        super(parent, modal);
        this.xmt = new Metodos();
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.xentrada = xentrada;
        mCargarDatos();
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JSPDetalle = new JScrollPane();
        this.JTResultado = new JTable();
        setDefaultCloseOperation(2);
        setTitle("Consultar Lotes x Producto");
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "Resultado", 2, 0, new Font("Arial", 1, 14), Color.blue));
        this.JTResultado.setFont(new Font("Arial", 1, 12));
        this.JTResultado.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTResultado.setRowHeight(25);
        this.JTResultado.setSelectionBackground(new Color(255, 255, 255));
        this.JTResultado.setSelectionForeground(new Color(255, 0, 0));
        this.JTResultado.setSelectionMode(0);
        this.JTResultado.addMouseListener(new MouseAdapter() { // from class: Inventarios.JDConsultarLotesExistentes.1
            public void mouseClicked(MouseEvent evt) {
                JDConsultarLotesExistentes.this.JTResultadoMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTResultado);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle, -1, 380, 32767).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(22, 22, 22).addComponent(this.JSPDetalle, -2, 259, -2).addContainerGap(19, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTResultadoMouseClicked(MouseEvent evt) {
        if (this.JTResultado.getSelectedRow() != -1) {
            this.xentrada.txtLote.setText(this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 0).toString());
            this.xentrada.txtVencimiento.setDate(this.xmt.getPasarTextoaFecha(this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 1).toString()));
            dispose();
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Lote", "Fecha Vencimiento", "Existencia"}) { // from class: Inventarios.JDConsultarLotesExistentes.2
            Class[] types = {String.class, String.class, Integer.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTResultado.setModel(this.xmodelo);
        this.JTResultado.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(1).setPreferredWidth(70);
        this.JTResultado.getColumnModel().getColumn(2).setPreferredWidth(30);
    }

    private void mCargarDatos() {
        mCrearModeloDatos();
        if (!this.xentrada.informacionInventarios.isEmpty()) {
            for (int n = 0; n < this.xentrada.informacionInventarios.size(); n++) {
                IInformacionInventario get = this.xentrada.informacionInventarios.get(n);
                if (get.getFechaVencimiento().after(new Date())) {
                    this.xmodelo.addRow((Object[]) null);
                    this.xmodelo.setValueAt(get.getLote(), this.JTResultado.getRowCount() - 1, 0);
                    this.xmodelo.setValueAt(get.getFechaVencimiento(), this.JTResultado.getRowCount() - 1, 1);
                    this.xmodelo.setValueAt(get.getTotalInventario(), this.JTResultado.getRowCount() - 1, 2);
                }
            }
        }
    }
}
