package Presupuesto;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Presupuesto/JDBuscaDocumentosMovManual.class */
public class JDBuscaDocumentosMovManual extends JDialog {
    private ConsultasMySQL xct;
    private String xClaseDoc;
    DefaultTableModel xmodelo;
    private Object[] xdatos;
    private Metodos xmt;
    private JIFMovManual xJIFMovManual;
    private String[] xIdTipDoc;
    private boolean xLleno;
    private JComboBox JCTipoDoc;
    private JSpinner JSAnio;
    private JTable JTDetalle;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;

    public JDBuscaDocumentosMovManual(Frame parent, boolean modal, String xIdPadre, JIFMovManual xJIFMovManual) {
        super(parent, modal);
        this.xct = new ConsultasMySQL();
        this.xmt = new Metodos();
        this.xLleno = false;
        initComponents();
        System.out.println("xIdPadre-->" + xIdPadre);
        this.xJIFMovManual = xJIFMovManual;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setLocationRelativeTo(null);
        this.JSAnio.setValue(Integer.valueOf(this.xmt.formatoANO.format(this.xmt.getFechaActual())));
        this.xClaseDoc = xIdPadre;
        String sql = null;
        if (xIdPadre.equals("4")) {
            sql = "SELECT Id, Nbre FROM `pp_tipo_documentos` WHERE Id_ClaseDoc=4 ORDER BY Nbre ASC";
        } else if (xIdPadre.equals("5")) {
            sql = "SELECT Id, Nbre FROM `pp_tipo_documentos` WHERE Id_ClaseDoc=5 ORDER BY Nbre ASC";
        }
        this.xIdTipDoc = this.xct.llenarCombo(sql, this.xIdTipDoc, this.JCTipoDoc);
        this.JCTipoDoc.setSelectedIndex(-1);
        this.xLleno = true;
        this.xct.cerrarConexionBd();
        mBuscaMovimientos();
    }

    /* JADX WARN: Type inference failed for: r3v30, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JSAnio = new JSpinner();
        this.JCTipoDoc = new JComboBox();
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        setDefaultCloseOperation(2);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTROS", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JSAnio.setFont(new Font("Arial", 1, 14));
        this.JSAnio.setModel(new SpinnerNumberModel(2014, 2014, (Comparable) null, 1));
        this.JSAnio.setBorder(BorderFactory.createTitledBorder((Border) null, "Año", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JCTipoDoc.setFont(new Font("Arial", 1, 12));
        this.JCTipoDoc.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCTipoDoc.addItemListener(new ItemListener() { // from class: Presupuesto.JDBuscaDocumentosMovManual.1
            public void itemStateChanged(ItemEvent evt) {
                JDBuscaDocumentosMovManual.this.JCTipoDocItemStateChanged(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JSAnio, -2, 91, -2).addContainerGap(-1, 32767)).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(204, 204, 204).addComponent(this.JCTipoDoc, -2, 321, -2).addContainerGap(204, 32767))));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.JSAnio, -1, 44, 32767).addGap(5, 5, 5)).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(4, 4, 4).addComponent(this.JCTipoDoc).addGap(5, 5, 5))));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 10)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Presupuesto.JDBuscaDocumentosMovManual.2
            public void mouseClicked(MouseEvent evt) {
                JDBuscaDocumentosMovManual.this.JTDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jScrollPane1, -1, 741, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -1, 334, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() > -1 && evt.getClickCount() == 2) {
            this.xJIFMovManual.xidMovimiento = this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString();
            this.xJIFMovManual.JLCodigoDoc.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.xJIFMovManual.JLCodigoDoc.setBorder(BorderFactory.createTitledBorder((Border) null, this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString(), 0, 0, new Font("Arial", 1, 11), Color.blue));
            this.xJIFMovManual.mBuscaRubroMovimiento();
            dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCTipoDocItemStateChanged(ItemEvent evt) {
        if (this.xLleno && this.JCTipoDoc.getSelectedIndex() > -1) {
            mBuscaMovimientos();
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModeloMovimiento() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"id", "Cod.", "Fecha", "Periodo", "TipoDocumento"}) { // from class: Presupuesto.JDBuscaDocumentosMovManual.3
            Class[] types = {String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(60);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(200);
    }

    private void mBuscaMovimientos() {
        String sql;
        mCreaModeloMovimiento();
        if (this.JCTipoDoc.getSelectedIndex() > -1) {
            sql = "SELECT\n    `pp_movimiento`.`Id`\n    , `pp_movimiento`.`NoConcecutivo`\n    , `pp_movimiento`.`FechaD`\n    , `pp_periodo`.`Nbre` AS Periodo\n    , `pp_tipo_documentos`.`Nbre` AS TipoDoc\nFROM\n    `pp_movimiento`\n    INNER JOIN `pp_tipo_documentos` \n        ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\n    INNER JOIN `pp_periodo` \n        ON (`pp_movimiento`.`Id_Periodo` = `pp_periodo`.`Id`)\nWHERE (DATE_FORMAT(`pp_movimiento`.`FechaD`,'%Y') ='" + this.JSAnio.getValue().toString() + "'\n    AND `pp_movimiento`.`Id_MotivoAnulacion` =1 AND pp_tipo_documentos.Id_ClaseDoc='" + this.xClaseDoc + "' AND pp_movimiento.Id_TipoDoc='" + this.xIdTipDoc[this.JCTipoDoc.getSelectedIndex()] + "') ORDER BY `pp_tipo_documentos`.`Nbre` ASC, `pp_movimiento`.`NoConcecutivo` ASC,`pp_movimiento`.`FechaD` DESC;";
        } else {
            sql = "SELECT\n    `pp_movimiento`.`Id`\n    , `pp_movimiento`.`NoConcecutivo`\n    , `pp_movimiento`.`FechaD`\n    , `pp_periodo`.`Nbre` AS Periodo\n    , `pp_tipo_documentos`.`Nbre` AS TipoDoc\nFROM\n    `pp_movimiento`\n    INNER JOIN `pp_tipo_documentos` \n        ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\n    INNER JOIN `pp_periodo` \n        ON (`pp_movimiento`.`Id_Periodo` = `pp_periodo`.`Id`)\nWHERE (DATE_FORMAT(`pp_movimiento`.`FechaD`,'%Y') ='" + this.JSAnio.getValue().toString() + "'\n    AND `pp_movimiento`.`Id_MotivoAnulacion` =1 AND pp_tipo_documentos.Id_ClaseDoc='" + this.xClaseDoc + "') ORDER BY `pp_tipo_documentos`.`Nbre` ASC, `pp_movimiento`.`NoConcecutivo` ASC,`pp_movimiento`.`FechaD` DESC;";
        }
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int x = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString("Id"), x, 0);
                    this.xmodelo.setValueAt(xrs.getString("NoConcecutivo"), x, 1);
                    this.xmodelo.setValueAt(xrs.getString("FechaD"), x, 2);
                    this.xmodelo.setValueAt(xrs.getString("Periodo"), x, 3);
                    this.xmodelo.setValueAt(xrs.getString("TipoDoc"), x, 4);
                    x++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDBuscaDocumentosMovManual.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
