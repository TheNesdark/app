package Presupuesto;

import Acceso.Principal;
import General.Anular;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import Utilidades.TextAreaEditor;
import Utilidades.TextAreaRenderer;
import com.toedter.calendar.JYearChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/* JADX INFO: loaded from: GenomaP.jar:Presupuesto/JIFAnularDocumento.class */
public class JIFAnularDocumento extends JInternalFrame {
    private String[][] xDocumento;
    private String[] xDocOperacion;
    public DefaultTableModel xmodeloDocumento;
    public DefaultTableModel xmodeloRubro;
    public DefaultTableModel xmodeloAjuste;
    public DefaultTableModel xmodeloMovRelacionado;
    private Object[] xdatos;
    private JComboBox<String> JCBDocumento;
    private JComboBox<String> JCBDocumentoOperacion;
    private JTable JTAjustes;
    private JTextField JTFNoDocumento;
    private JTable JTMovRelacionado;
    private JTable JTMovimiento;
    private JTable JTRubros;
    private JYearChooser JYCAno;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private boolean xLleno = false;
    private boolean xLlenoDoc = false;

    public JIFAnularDocumento() {
        initComponents();
        mIniciaComponentes();
    }

    private void mIniciaComponentes() {
        this.JCBDocumentoOperacion.setVisible(false);
        System.out.println("select pp_tipo_documentos.Id, pp_tipo_documentos.Nbre,pp_clase_documento.Id as IdClase,pp_clase_documento.idnext, pp_clase_documento.tipodocumento, pp_clase_documento.IdPadre\nfrom  pp_clase_documento \ninner join pp_tipo_documentos on (pp_clase_documento.Id=pp_tipo_documentos.Id_ClaseDoc)\nwhere pp_clase_documento.Es_Inicial<> 1 and pp_tipo_documentos.estado=1\norder by pp_clase_documento.tipodocumento asc, pp_clase_documento.orden asc");
        this.xDocumento = this.xct.llenarComboyLista("select pp_tipo_documentos.Id, pp_tipo_documentos.Nbre,pp_clase_documento.Id as IdClase,pp_clase_documento.idnext, pp_clase_documento.tipodocumento, pp_clase_documento.IdPadre\nfrom  pp_clase_documento \ninner join pp_tipo_documentos on (pp_clase_documento.Id=pp_tipo_documentos.Id_ClaseDoc)\nwhere pp_clase_documento.Es_Inicial<> 1 and pp_tipo_documentos.estado=1\norder by pp_clase_documento.tipodocumento asc, pp_clase_documento.orden asc", this.xDocumento, this.JCBDocumento, 6);
        this.JCBDocumento.setSelectedIndex(-1);
        this.xLleno = true;
        this.xct.cerrarConexionBd();
        this.JYCAno.setValue(Integer.valueOf(this.xmt.formatoANO.format(this.xmt.getFechaActual())).intValue());
    }

    public void mBuscaDocumento() {
        String xVarTipoDoc;
        if (this.JCBDocumento.getSelectedIndex() > -1) {
            if (!this.JTFNoDocumento.getText().isEmpty()) {
                if (!xValidaTipoOperacion()) {
                    mCrearModeloDatosMovimiento();
                    mCrearModeloRubros();
                    mCrearModeloAjustes();
                    mCrearModeloMovRelacionado();
                    if (Integer.valueOf(this.xDocumento[this.JCBDocumento.getSelectedIndex()][4]).intValue() != 1) {
                        if (Integer.valueOf(this.xDocumento[this.JCBDocumento.getSelectedIndex()][3]).intValue() == 1) {
                            System.out.println("entra a tipoDocu 1");
                            String sql = "select pp_movimiento.Id,pp_tipo_documentos.Nbre as tipoDocumento, pp_movimiento.NoConcecutivo, pp_movimiento.FechaD, \npp_periodo.Nbre as Periodo, pp_movimiento.Observacion \n-- ,pp_detalle_movimiento.Id_Rubro as rubro, pp_detalle_movimiento.Valor\nfrom pp_movimiento \ninner join pp_periodo on (pp_movimiento.Id_Periodo=pp_periodo.Id)\ninner join pp_tipo_documentos on (pp_movimiento.Id_TipoDoc=pp_tipo_documentos.Id)\n\n-- inner join pp_detalle_movimiento on (pp_movimiento.Id=pp_detalle_movimiento.Id_Movimiento)\nwhere pp_movimiento.NoConcecutivo='" + this.JTFNoDocumento.getText() + "'\nand date_format(FechaD,'%Y')='" + this.JYCAno.getValue() + "'\nand pp_movimiento.Id_TipoDoc='" + this.xDocumento[this.JCBDocumento.getSelectedIndex()][0] + "'";
                            ResultSet xrs = this.xct.traerRs(sql);
                            TableColumnModel cmodel = this.JTMovimiento.getColumnModel();
                            TextAreaRenderer textAreaRenderer = new TextAreaRenderer();
                            cmodel.getColumn(5).setCellRenderer(textAreaRenderer);
                            TextAreaEditor textEditor = new TextAreaEditor();
                            cmodel.getColumn(5).setCellEditor(textEditor);
                            System.out.println("sql-->" + sql);
                            int xFila = 0;
                            while (xrs.next()) {
                                try {
                                    this.xmodeloDocumento.addRow(this.xdatos);
                                    this.xmodeloDocumento.setValueAt(Integer.valueOf(xrs.getInt("Id")), xFila, 0);
                                    this.xmodeloDocumento.setValueAt(xrs.getString("tipoDocumento"), xFila, 1);
                                    this.xmodeloDocumento.setValueAt(xrs.getString("NoConcecutivo"), xFila, 2);
                                    this.xmodeloDocumento.setValueAt(xrs.getString("FechaD"), xFila, 3);
                                    this.xmodeloDocumento.setValueAt(xrs.getString("Periodo"), xFila, 4);
                                    this.xmodeloDocumento.setValueAt(xrs.getString("Observacion"), xFila, 5);
                                    xFila++;
                                } catch (SQLException ex) {
                                    Logger.getLogger(JIFAnularDocumento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                                    return;
                                }
                            }
                            xrs.close();
                            this.xct.cerrarConexionBd();
                            return;
                        }
                        System.out.println("entra a tipoDocu 2");
                        String sqlDocumento = "select pp_movimiento.Id as idMovimiento,pp_tipo_documentos.Nbre as tipoDocumento, pp_movimiento.NoConcecutivo, pp_movimiento.FechaD, \npp_periodo.Nbre as Periodo, pp_movimiento.Observacion \n-- ,pp_detalle_movimiento.Id_Rubro as rubro, pp_detalle_movimiento.Valor\nfrom pp_movimiento \ninner join pp_periodo on (pp_movimiento.Id_Periodo=pp_periodo.Id)\ninner join pp_tipo_documentos on (pp_movimiento.Id_TipoDoc=pp_tipo_documentos.Id)\n\n-- inner join pp_detalle_movimiento on (pp_movimiento.Id=pp_detalle_movimiento.Id_Movimiento)\nwhere pp_movimiento.NoConcecutivo='" + this.JTFNoDocumento.getText() + "'\nand date_format(FechaD,'%Y')='" + this.JYCAno.getValue() + "'\nand pp_movimiento.Id_TipoDoc='" + this.xDocOperacion[this.JCBDocumentoOperacion.getSelectedIndex()] + "'";
                        try {
                            ResultSet xrs2 = this.xct.traerRs(sqlDocumento);
                            System.out.println("sqlDocumentos-->" + sqlDocumento);
                            if (xrs2.next()) {
                                xrs2.first();
                                switch (this.xDocumento[this.JCBDocumento.getSelectedIndex()][4]) {
                                    case "9":
                                        xVarTipoDoc = "IdDisponibilidad";
                                        break;
                                    case "4":
                                        xVarTipoDoc = "IdCompromiso";
                                        break;
                                    case "5":
                                        xVarTipoDoc = "IdObligacion";
                                        break;
                                    default:
                                        xVarTipoDoc = "Id";
                                        System.out.println("Not in 10, 20 or 30");
                                        break;
                                }
                                String sqlAjustes = "select pp_movimiento.Id,pp_movimiento.NoConcecutivo,pp_tipo_documentos.Nbre as tipoDocumento,  pp_movimiento.FechaD, \npp_periodo.Nbre as Periodo, pp_movimiento.Observacion\n-- ,pp_detalle_movimiento.Id_Rubro as rubro, pp_detalle_movimiento.Valor\nfrom pp_movimiento \ninner join pp_periodo on (pp_movimiento.Id_Periodo=pp_periodo.Id)\ninner join pp_tipo_documentos on (pp_movimiento.Id_TipoDoc=pp_tipo_documentos.Id)\ninner join pp_clase_documento on (pp_tipo_documentos.Id_ClaseDoc=pp_clase_documento.Id)\n-- inner join pp_detalle_movimiento on (pp_movimiento.Id=pp_detalle_movimiento.Id_Movimiento)\nwhere pp_movimiento." + xVarTipoDoc + "='" + xrs2.getString("idMovimiento") + "' and pp_clase_documento.IdPadre='" + this.xDocumento[this.JCBDocumento.getSelectedIndex()][4] + "' and pp_clase_documento.tipodocumento=2  and pp_movimiento.id_MotivoAnulacion=1\norder by pp_clase_documento.Id asc, pp_movimiento.FechaD desc";
                                ResultSet xrsAjuste = this.xct.traerRs(sqlAjustes);
                                System.out.println("sqlAjustesDocumento-->" + sqlAjustes);
                                int xFila2 = 0;
                                while (xrsAjuste.next()) {
                                    this.xmodeloDocumento.addRow(this.xdatos);
                                    this.xmodeloDocumento.setValueAt(Integer.valueOf(xrsAjuste.getInt("Id")), xFila2, 0);
                                    this.xmodeloDocumento.setValueAt(xrsAjuste.getString("tipoDocumento"), xFila2, 1);
                                    this.xmodeloDocumento.setValueAt(xrsAjuste.getString("NoConcecutivo"), xFila2, 2);
                                    this.xmodeloDocumento.setValueAt(xrsAjuste.getString("FechaD"), xFila2, 3);
                                    this.xmodeloDocumento.setValueAt(xrsAjuste.getString("Periodo"), xFila2, 4);
                                    this.xmodeloDocumento.setValueAt(xrsAjuste.getString("Observacion"), xFila2, 5);
                                    xFila2++;
                                }
                                xrsAjuste.close();
                            }
                            xrs2.close();
                            this.xct.cerrarConexionBd();
                            return;
                        } catch (SQLException ex2) {
                            Logger.getLogger(JIFAnularDocumento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
                            return;
                        }
                    }
                    String sql2 = "select pp_movimiento.Id,pp_movimiento.NoConcecutivo,pp_tipo_documentos.Nbre as tipoDocumento,  pp_movimiento.FechaD, \n pp_periodo.Nbre as Periodo, pp_movimiento.Observacion\n -- ,pp_detalle_movimiento.Id_Rubro as rubro, pp_detalle_movimiento.Valor\n from pp_movimiento \n inner join pp_periodo on (pp_movimiento.Id_Periodo=pp_periodo.Id)\n inner join pp_tipo_documentos on (pp_movimiento.Id_TipoDoc=pp_tipo_documentos.Id)\n inner join pp_clase_documento on (pp_tipo_documentos.Id_ClaseDoc=pp_clase_documento.Id)\n inner join (select pp_movimiento.id from pp_movimiento \n inner join pp_tipo_documentos on (pp_movimiento.Id_TipoDoc=pp_tipo_documentos.Id)\n inner join pp_clase_documento on (pp_tipo_documentos.Id_ClaseDoc=pp_clase_documento.Id)\n where date_format(pp_movimiento.FechaD,'%Y')='" + this.JYCAno.getValue() + "' and pp_clase_documento.Es_Inicial=1 and pp_movimiento.id_MotivoAnulacion=1) PTOI\n on (PTOI.id=pp_movimiento.NoDocumentoPadre)\n where  pp_clase_documento.IdPadre=1 and pp_clase_documento.tipodocumento=2  \n and pp_movimiento.id_MotivoAnulacion=1 and pp_movimiento.Id_TipoDoc='" + this.xDocumento[this.JCBDocumento.getSelectedIndex()][0] + "'\n order by pp_clase_documento.Id asc, pp_movimiento.FechaD desc";
                    try {
                        ResultSet xrs3 = this.xct.traerRs(sql2);
                        System.out.println("sqlOperacionPTOInicial-->" + sql2);
                        if (xrs3.next()) {
                            xrs3.beforeFirst();
                            int xFila3 = 0;
                            while (xrs3.next()) {
                                this.xmodeloDocumento.addRow(this.xdatos);
                                this.xmodeloDocumento.setValueAt(Integer.valueOf(xrs3.getInt("Id")), xFila3, 0);
                                this.xmodeloDocumento.setValueAt(xrs3.getString("tipoDocumento"), xFila3, 1);
                                this.xmodeloDocumento.setValueAt(xrs3.getString("NoConcecutivo"), xFila3, 2);
                                this.xmodeloDocumento.setValueAt(xrs3.getString("FechaD"), xFila3, 3);
                                this.xmodeloDocumento.setValueAt(xrs3.getString("Periodo"), xFila3, 4);
                                this.xmodeloDocumento.setValueAt(xrs3.getString("Observacion"), xFila3, 5);
                                xFila3++;
                            }
                        }
                        xrs3.close();
                        this.xct.cerrarConexionBd();
                        return;
                    } catch (SQLException ex3) {
                        Logger.getLogger(JIFAnularDocumento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex3);
                        return;
                    }
                }
                JOptionPane.showMessageDialog(this, "Debe seleccionar un documento para la operación", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBDocumentoOperacion.requestFocus();
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe digitar un Código de Documento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFNoDocumento.requestFocus();
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe seleccionar el tipo de documento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBDocumento.requestFocus();
    }

    private boolean xValidaTipoOperacion() {
        boolean xValida = false;
        if (this.xDocumento[this.JCBDocumento.getSelectedIndex()][3].equals("2") && this.JCBDocumentoOperacion.getSelectedIndex() <= -1) {
            xValida = true;
        }
        return xValida;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosMovimiento() {
        this.xmodeloDocumento = new DefaultTableModel(new Object[0], new String[]{"id", "TipoDocumento", "NoConsecutivo", "Fecha", "Periodo", "Observación"}) { // from class: Presupuesto.JIFAnularDocumento.1
            Class[] types = {Integer.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTMovimiento.setModel(this.xmodeloDocumento);
        this.JTMovimiento.getColumnModel().getColumn(0).setPreferredWidth(1);
        this.JTMovimiento.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTMovimiento.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTMovimiento.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.JTMovimiento.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTMovimiento.getColumnModel().getColumn(5).setPreferredWidth(200);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloRubros() {
        this.xmodeloRubro = new DefaultTableModel(new Object[0], new String[]{"Rubro", "Valor"}) { // from class: Presupuesto.JIFAnularDocumento.2
            Class[] types = {String.class, Double.class};
            boolean[] canEdit = {false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTRubros.setModel(this.xmodeloRubro);
        this.JTRubros.getColumnModel().getColumn(0).setPreferredWidth(30);
        this.JTRubros.getColumnModel().getColumn(1).setPreferredWidth(50);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloAjustes() {
        this.xmodeloAjuste = new DefaultTableModel(new Object[0], new String[]{"id", "Documento", "Fecha", "Rubro", "Valor"}) { // from class: Presupuesto.JIFAnularDocumento.3
            Class[] types = {Integer.class, String.class, String.class, String.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTAjustes.setModel(this.xmodeloAjuste);
        this.JTAjustes.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTAjustes.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTAjustes.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTAjustes.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTAjustes.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTAjustes.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTAjustes.getColumnModel().getColumn(4).setPreferredWidth(30);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloMovRelacionado() {
        this.xmodeloMovRelacionado = new DefaultTableModel(new Object[0], new String[]{"id", "Cód.", "Documento", "Fecha", "Rubro", "Valor"}) { // from class: Presupuesto.JIFAnularDocumento.4
            Class[] types = {Integer.class, String.class, String.class, String.class, String.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTMovRelacionado.setModel(this.xmodeloMovRelacionado);
        this.JTMovRelacionado.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTMovRelacionado.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTMovRelacionado.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTMovRelacionado.getColumnModel().getColumn(1).setPreferredWidth(30);
        this.JTMovRelacionado.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTMovRelacionado.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.JTMovRelacionado.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTMovRelacionado.getColumnModel().getColumn(5).setPreferredWidth(30);
    }

    private void mBuscaAjustes(String varTipoDoc, int idMovimiento, int idPadre) {
        mCrearModeloAjustes();
        String sql = "select pp_movimiento.Id,pp_tipo_documentos.Nbre as tipoDocumento,  pp_movimiento.FechaD, \npp_periodo.Nbre as Periodo\n ,pp_detalle_movimiento.Id_Rubro as rubro, pp_detalle_movimiento.Valor\nfrom pp_movimiento \ninner join pp_periodo on (pp_movimiento.Id_Periodo=pp_periodo.Id)\ninner join pp_tipo_documentos on (pp_movimiento.Id_TipoDoc=pp_tipo_documentos.Id)\ninner join pp_clase_documento on (pp_tipo_documentos.Id_ClaseDoc=pp_clase_documento.Id)\ninner join pp_detalle_movimiento on (pp_movimiento.Id=pp_detalle_movimiento.Id_Movimiento)\nwhere pp_movimiento." + varTipoDoc + "='" + idMovimiento + "' and pp_clase_documento.IdPadre='" + idPadre + "' and pp_clase_documento.tipodocumento=2  and pp_movimiento.id_MotivoAnulacion=1\norder by pp_clase_documento.Id asc, pp_movimiento.FechaD desc";
        System.out.println("sqlAjuste-->" + sql);
        try {
            int xFila = 0;
            ResultSet xrs = this.xct.traerRs(sql);
            while (xrs.next()) {
                this.xmodeloAjuste.addRow(this.xdatos);
                this.xmodeloAjuste.setValueAt(Integer.valueOf(xrs.getInt("Id")), xFila, 0);
                this.xmodeloAjuste.setValueAt(xrs.getString("tipoDocumento"), xFila, 1);
                this.xmodeloAjuste.setValueAt(xrs.getString("FechaD"), xFila, 2);
                this.xmodeloAjuste.setValueAt(xrs.getString("rubro"), xFila, 3);
                this.xmodeloAjuste.setValueAt(Double.valueOf(xrs.getDouble("Valor")), xFila, 4);
                xFila++;
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFAnularDocumento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mBuscaMovRelacionados(String varTipoDoc, int idMovimiento, int idNext) {
        mCrearModeloMovRelacionado();
        String sql = "select pp_movimiento.Id,pp_movimiento.NoConcecutivo,pp_tipo_documentos.Nbre as tipoDocumento,  pp_movimiento.FechaD, \npp_periodo.Nbre as Periodo\n ,pp_detalle_movimiento.Id_Rubro as rubro, pp_detalle_movimiento.Valor\nfrom pp_movimiento \ninner join pp_periodo on (pp_movimiento.Id_Periodo=pp_periodo.Id)\ninner join pp_tipo_documentos on (pp_movimiento.Id_TipoDoc=pp_tipo_documentos.Id)\ninner join pp_clase_documento on (pp_tipo_documentos.Id_ClaseDoc=pp_clase_documento.Id)\ninner join pp_detalle_movimiento on (pp_movimiento.Id=pp_detalle_movimiento.Id_Movimiento)\nwhere pp_movimiento." + varTipoDoc + "='" + idMovimiento + "'  and pp_clase_documento.tipodocumento=1  and pp_tipo_documentos.Id_ClaseDoc='" + idNext + "' and pp_movimiento.id_MotivoAnulacion=1\norder by pp_clase_documento.Id asc, pp_movimiento.FechaD desc";
        System.out.println("sqlMovRel-->" + sql);
        try {
            int xFila = 0;
            ResultSet xrs = this.xct.traerRs(sql);
            while (xrs.next()) {
                this.xmodeloMovRelacionado.addRow(this.xdatos);
                this.xmodeloMovRelacionado.setValueAt(Integer.valueOf(xrs.getInt("Id")), xFila, 0);
                this.xmodeloMovRelacionado.setValueAt(Integer.valueOf(xrs.getInt("NoConcecutivo")), xFila, 1);
                this.xmodeloMovRelacionado.setValueAt(xrs.getString("tipoDocumento"), xFila, 2);
                this.xmodeloMovRelacionado.setValueAt(xrs.getString("FechaD"), xFila, 3);
                this.xmodeloMovRelacionado.setValueAt(xrs.getString("rubro"), xFila, 4);
                this.xmodeloMovRelacionado.setValueAt(Double.valueOf(xrs.getDouble("Valor")), xFila, 5);
                xFila++;
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFAnularDocumento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mBuscaRubros(int xidMov) {
        mCrearModeloRubros();
        String sql = "select pp_movimiento.Id,pp_tipo_documentos.Nbre as tipoDocumento, pp_movimiento.NoConcecutivo, pp_movimiento.FechaD, \npp_periodo.Nbre as Periodo\n ,pp_detalle_movimiento.Id_Rubro as rubro, pp_detalle_movimiento.Valor\nfrom pp_movimiento \ninner join pp_periodo on (pp_movimiento.Id_Periodo=pp_periodo.Id)\ninner join pp_tipo_documentos on (pp_movimiento.Id_TipoDoc=pp_tipo_documentos.Id)\ninner join pp_detalle_movimiento on (pp_movimiento.Id=pp_detalle_movimiento.Id_Movimiento)\nwhere pp_movimiento.Id='" + xidMov + "'";
        System.out.println("sqlRubro-->" + sql);
        try {
            int xFila = 0;
            ResultSet xrs = this.xct.traerRs(sql);
            while (xrs.next()) {
                this.xmodeloRubro.addRow(this.xdatos);
                this.xmodeloRubro.setValueAt(xrs.getString("rubro"), xFila, 0);
                this.xmodeloRubro.setValueAt(Double.valueOf(xrs.getDouble("Valor")), xFila, 1);
                xFila++;
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFAnularDocumento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r3v39, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v44, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v48, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v52, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JCBDocumento = new JComboBox<>();
        this.JTFNoDocumento = new JTextField();
        this.JYCAno = new JYearChooser();
        this.JCBDocumentoOperacion = new JComboBox<>();
        this.jScrollPane1 = new JScrollPane();
        this.JTMovimiento = new JTable();
        this.jScrollPane2 = new JScrollPane();
        this.JTRubros = new JTable();
        this.jScrollPane3 = new JScrollPane();
        this.JTAjustes = new JTable();
        this.jScrollPane4 = new JScrollPane();
        this.JTMovRelacionado = new JTable();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("ANULAR DOCUMENTO PRESUPUESTAL");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifAnularDocumentos");
        addInternalFrameListener(new InternalFrameListener() { // from class: Presupuesto.JIFAnularDocumento.5
            public void internalFrameOpened(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFAnularDocumento.this.formInternalFrameClosing(evt);
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }
        });
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTROS", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JCBDocumento.setFont(new Font("Arial", 1, 12));
        this.JCBDocumento.setBorder(BorderFactory.createTitledBorder((Border) null, "Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBDocumento.addItemListener(new ItemListener() { // from class: Presupuesto.JIFAnularDocumento.6
            public void itemStateChanged(ItemEvent evt) {
                JIFAnularDocumento.this.JCBDocumentoItemStateChanged(evt);
            }
        });
        this.JCBDocumento.addPropertyChangeListener(new PropertyChangeListener() { // from class: Presupuesto.JIFAnularDocumento.7
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFAnularDocumento.this.JCBDocumentoPropertyChange(evt);
            }
        });
        this.JTFNoDocumento.setFont(new Font("Arial", 1, 12));
        this.JTFNoDocumento.setBorder(BorderFactory.createTitledBorder((Border) null, "Cod. Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JYCAno.setBorder(BorderFactory.createTitledBorder((Border) null, "Año", 0, 0, new Font("Arial", 1, 13), Color.blue));
        this.JYCAno.setFont(new Font("Arial", 1, 12));
        this.JCBDocumentoOperacion.setFont(new Font("Arial", 1, 12));
        this.JCBDocumentoOperacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Documento Operación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBDocumentoOperacion.addItemListener(new ItemListener() { // from class: Presupuesto.JIFAnularDocumento.8
            public void itemStateChanged(ItemEvent evt) {
                JIFAnularDocumento.this.JCBDocumentoOperacionItemStateChanged(evt);
            }
        });
        this.JCBDocumentoOperacion.addPropertyChangeListener(new PropertyChangeListener() { // from class: Presupuesto.JIFAnularDocumento.9
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFAnularDocumento.this.JCBDocumentoOperacionPropertyChange(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JCBDocumento, -2, 278, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNoDocumento, -2, 122, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBDocumentoOperacion, -2, 278, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JYCAno, -2, 95, -2).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBDocumento).addComponent(this.JYCAno, -1, 54, 32767).addComponent(this.JCBDocumentoOperacion).addComponent(this.JTFNoDocumento)).addGap(5, 5, 5)));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE DOCUMENTO", 2, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JTMovimiento.setFont(new Font("Arial", 1, 12));
        this.JTMovimiento.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTMovimiento.setSelectionBackground(Color.white);
        this.JTMovimiento.setSelectionForeground(Color.red);
        this.JTMovimiento.addMouseListener(new MouseAdapter() { // from class: Presupuesto.JIFAnularDocumento.10
            public void mouseClicked(MouseEvent evt) {
                JIFAnularDocumento.this.JTMovimientoMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTMovimiento);
        this.jScrollPane2.setBorder(BorderFactory.createTitledBorder((Border) null, "RUBROS", 2, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JTRubros.setFont(new Font("Arial", 1, 12));
        this.JTRubros.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTRubros.setSelectionBackground(Color.white);
        this.JTRubros.setSelectionForeground(Color.red);
        this.jScrollPane2.setViewportView(this.JTRubros);
        this.jScrollPane3.setBorder(BorderFactory.createTitledBorder((Border) null, "AJUSTES", 2, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JTAjustes.setFont(new Font("Arial", 1, 12));
        this.JTAjustes.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTAjustes.setSelectionBackground(Color.white);
        this.JTAjustes.setSelectionForeground(Color.red);
        this.jScrollPane3.setViewportView(this.JTAjustes);
        this.jScrollPane4.setBorder(BorderFactory.createTitledBorder((Border) null, "MOVIMIENTO RELACIONADO", 2, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JTMovRelacionado.setFont(new Font("Arial", 1, 12));
        this.JTMovRelacionado.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTMovRelacionado.setSelectionBackground(Color.white);
        this.JTMovRelacionado.setSelectionForeground(Color.red);
        this.jScrollPane4.setViewportView(this.JTMovRelacionado);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jScrollPane1).addGroup(layout.createSequentialGroup().addComponent(this.jScrollPane2, -2, 275, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane3, -2, 311, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane4, -2, 311, -2).addGap(0, 0, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jScrollPane2, -2, 151, -2).addComponent(this.jScrollPane3, -2, 151, -2).addComponent(this.jScrollPane4, -2, 151, -2)).addContainerGap(16, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBDocumentoPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBDocumentoItemStateChanged(ItemEvent evt) {
        if (this.JCBDocumento.getSelectedIndex() != -1 && this.xLleno) {
            System.out.println("tipoDoc-->" + Integer.valueOf(this.xDocumento[this.JCBDocumento.getSelectedIndex()][3]));
            if (Integer.valueOf(this.xDocumento[this.JCBDocumento.getSelectedIndex()][3]).intValue() == 2) {
                System.out.println("idPadre-->" + Integer.valueOf(this.xDocumento[this.JCBDocumento.getSelectedIndex()][4]));
                this.JCBDocumentoOperacion.setVisible(true);
                this.JCBDocumentoOperacion.removeAllItems();
                String sql = "select pp_tipo_documentos.Id, pp_tipo_documentos.Nbre as tipoDoc from \npp_tipo_documentos\ninner join pp_clase_documento on (pp_tipo_documentos.Id_ClaseDoc=pp_clase_documento.Id)\nwhere pp_tipo_documentos.Id_ClaseDoc='" + Integer.valueOf(this.xDocumento[this.JCBDocumento.getSelectedIndex()][4]) + "'\nand pp_tipo_documentos.estado=1";
                this.xDocOperacion = this.xct.llenarCombo(sql, this.xDocOperacion, this.JCBDocumentoOperacion);
                this.JCBDocumentoOperacion.setSelectedIndex(-1);
                this.xct.cerrarConexionBd();
                this.xLlenoDoc = true;
            } else {
                this.JCBDocumentoOperacion.setVisible(false);
            }
            mCrearModeloMovRelacionado();
            mCrearModeloAjustes();
            mCrearModeloRubros();
            mCrearModeloDatosMovimiento();
            return;
        }
        System.out.println("No entra");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTMovimientoMouseClicked(MouseEvent evt) {
        String xVarTipoDoc;
        mBuscaRubros(Integer.valueOf(this.xmodeloDocumento.getValueAt(this.JTMovimiento.getSelectedRow(), 0).toString()).intValue());
        if (Integer.valueOf(this.xDocumento[this.JCBDocumento.getSelectedIndex()][3]).intValue() == 1) {
            System.out.println("this.xDocumento[this.JCBDocumento.getSelectedIndex()][1]-->" + this.xDocumento[this.JCBDocumento.getSelectedIndex()][1]);
            switch (this.xDocumento[this.JCBDocumento.getSelectedIndex()][1]) {
                case "9":
                    xVarTipoDoc = "IdDisponibilidad";
                    break;
                case "4":
                    xVarTipoDoc = "IdCompromiso";
                    break;
                case "5":
                    xVarTipoDoc = "IdObligacion";
                    break;
                default:
                    xVarTipoDoc = "Id";
                    System.out.println("Not in 10, 20 or 30");
                    break;
            }
            mBuscaAjustes(xVarTipoDoc, Integer.valueOf(this.xmodeloDocumento.getValueAt(this.JTMovimiento.getSelectedRow(), 0).toString()).intValue(), Integer.valueOf(this.xDocumento[this.JCBDocumento.getSelectedIndex()][1]).intValue());
            mBuscaMovRelacionados(xVarTipoDoc, Integer.valueOf(this.xmodeloDocumento.getValueAt(this.JTMovimiento.getSelectedRow(), 0).toString()).intValue(), Integer.valueOf(this.xDocumento[this.JCBDocumento.getSelectedIndex()][2]).intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBDocumentoOperacionItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBDocumentoOperacionPropertyChange(PropertyChangeEvent evt) {
    }

    public void mAnular() {
        System.out.println("JTMovimiento.getSelectedRow()-->" + this.JTMovimiento.getSelectedRow());
        if (this.JTMovimiento.getSelectedRow() != -1) {
            if (this.JTMovRelacionado.getRowCount() == 0) {
                if (this.JTAjustes.getRowCount() == 0) {
                    Anular frm = new Anular(null, true, "PP_Anula_MovimientosP", 26);
                    frm.setLocationRelativeTo(this);
                    frm.setVisible(true);
                    return;
                }
                JOptionPane.showMessageDialog(this, "No se puede anular, hay operaciones relacionados", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            JOptionPane.showMessageDialog(this, "No se puede anular, hay movimientos relacionados", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe seleccionar un movimiento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    public void mAnular_Registro(String xIdMot, String xObservacion) {
        Principal.xclasePresupuesto.mAnulaMovimientoPTO(xIdMot, xObservacion, this.xmodeloDocumento.getValueAt(this.JTMovimiento.getSelectedRow(), 0).toString());
        Principal.txtEstado.setText("ANULADO");
        mBuscaDocumento();
    }
}
