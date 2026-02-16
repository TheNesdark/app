package com.genoma.plus.controller.transicion;

import Utilidades.ConexionBaseOracle;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/transicion/JIF_HojaTratamiento.class */
public class JIF_HojaTratamiento extends JInternalFrame {
    private ConexionBaseOracle baseOracle;
    private DefaultTableModel modeloDefaultTableModel;
    private DefaultTableModel modeloAplicacion;
    private Object[] dato;
    private String sql;
    private JButton JBT_Duplicar;
    private JButton JBT_Eliminar;
    private JLabel JL_NombreUsuario;
    private JPanel JP_InformacionUsuario;
    private JScrollPane JSP_DetalleAplicacion;
    private JScrollPane JSP_DetalleAtenciones;
    private JTable JTB_DetalleAplicacion;
    private JTable JTB_DetalleAtenciones;
    private JTextField JTF_NDocumento;

    public JIF_HojaTratamiento() {
        initComponents();
    }

    /* JADX WARN: Type inference failed for: r3v26, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v31, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JP_InformacionUsuario = new JPanel();
        this.JTF_NDocumento = new JTextField();
        this.JL_NombreUsuario = new JLabel();
        this.JSP_DetalleAtenciones = new JScrollPane();
        this.JTB_DetalleAtenciones = new JTable();
        this.JSP_DetalleAplicacion = new JScrollPane();
        this.JTB_DetalleAplicacion = new JTable();
        this.JBT_Duplicar = new JButton();
        this.JBT_Eliminar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONSULTAR HOJA DE TRATAMIENTO");
        setFont(new Font("Arial", 1, 14));
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jif_hojatratamiento");
        this.JP_InformacionUsuario.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN USUARIO", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTF_NDocumento.setFont(new Font("Arial", 1, 12));
        this.JTF_NDocumento.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Documento", 0, 0, new Font("Arial", 1, 12)));
        this.JTF_NDocumento.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.transicion.JIF_HojaTratamiento.1
            public void focusLost(FocusEvent evt) {
                JIF_HojaTratamiento.this.JTF_NDocumentoFocusLost(evt);
            }
        });
        this.JTF_NDocumento.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.transicion.JIF_HojaTratamiento.2
            public void keyPressed(KeyEvent evt) {
                JIF_HojaTratamiento.this.JTF_NDocumentoKeyPressed(evt);
            }
        });
        this.JL_NombreUsuario.setBackground(new Color(255, 255, 255));
        this.JL_NombreUsuario.setFont(new Font("Arial", 1, 12));
        this.JL_NombreUsuario.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre Usuario", 0, 0, new Font("Arial", 1, 12)));
        GroupLayout JP_InformacionUsuarioLayout = new GroupLayout(this.JP_InformacionUsuario);
        this.JP_InformacionUsuario.setLayout(JP_InformacionUsuarioLayout);
        JP_InformacionUsuarioLayout.setHorizontalGroup(JP_InformacionUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JP_InformacionUsuarioLayout.createSequentialGroup().addContainerGap().addComponent(this.JTF_NDocumento, -2, 151, -2).addGap(32, 32, 32).addComponent(this.JL_NombreUsuario, -2, 601, -2).addContainerGap(-1, 32767)));
        JP_InformacionUsuarioLayout.setVerticalGroup(JP_InformacionUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JP_InformacionUsuarioLayout.createSequentialGroup().addContainerGap().addGroup(JP_InformacionUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTF_NDocumento, -2, 50, -2).addComponent(this.JL_NombreUsuario, -2, 50, -2)).addContainerGap(15, 32767)));
        this.JSP_DetalleAtenciones.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE ATENCIONES", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTB_DetalleAtenciones.setFont(new Font("Arial", 1, 12));
        this.JTB_DetalleAtenciones.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_DetalleAtenciones.setRowHeight(25);
        this.JTB_DetalleAtenciones.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.transicion.JIF_HojaTratamiento.3
            public void mouseClicked(MouseEvent evt) {
                JIF_HojaTratamiento.this.JTB_DetalleAtencionesMouseClicked(evt);
            }
        });
        this.JSP_DetalleAtenciones.setViewportView(this.JTB_DetalleAtenciones);
        this.JSP_DetalleAplicacion.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE APLICACIÓN DE TRATAMIENTO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTB_DetalleAplicacion.setFont(new Font("Arial", 1, 12));
        this.JTB_DetalleAplicacion.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_DetalleAplicacion.setRowHeight(25);
        this.JTB_DetalleAplicacion.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.transicion.JIF_HojaTratamiento.4
            public void keyPressed(KeyEvent evt) {
                JIF_HojaTratamiento.this.JTB_DetalleAplicacionKeyPressed(evt);
            }
        });
        this.JSP_DetalleAplicacion.setViewportView(this.JTB_DetalleAplicacion);
        this.JBT_Duplicar.setFont(new Font("Arial", 1, 14));
        this.JBT_Duplicar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBT_Duplicar.setText("Duplicar Items");
        this.JBT_Duplicar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.transicion.JIF_HojaTratamiento.5
            public void actionPerformed(ActionEvent evt) {
                JIF_HojaTratamiento.this.JBT_DuplicarActionPerformed(evt);
            }
        });
        this.JBT_Eliminar.setFont(new Font("Arial", 1, 14));
        this.JBT_Eliminar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Cancelar30x30.png")));
        this.JBT_Eliminar.setText("Eliminar Items");
        this.JBT_Eliminar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.transicion.JIF_HojaTratamiento.6
            public void actionPerformed(ActionEvent evt) {
                JIF_HojaTratamiento.this.JBT_EliminarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSP_DetalleAplicacion).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP_InformacionUsuario, -1, -1, 32767).addComponent(this.JSP_DetalleAtenciones)).addGroup(layout.createSequentialGroup().addComponent(this.JBT_Duplicar, -2, 181, -2).addGap(18, 18, 18).addComponent(this.JBT_Eliminar, -2, 181, -2))).addGap(0, 0, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(15, 15, 15).addComponent(this.JP_InformacionUsuario, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JSP_DetalleAtenciones, -2, 133, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSP_DetalleAplicacion, -2, 253, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBT_Duplicar, -2, 50, -2).addComponent(this.JBT_Eliminar, -2, 50, -2)).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_NDocumentoFocusLost(FocusEvent evt) {
        llenarDatosIngreso();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_NDocumentoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            llenarDatosIngreso();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_DetalleAtencionesMouseClicked(MouseEvent evt) {
        if (this.JTB_DetalleAtenciones.getSelectedRow() != -1 && this.JTB_DetalleAtenciones.getRowCount() != -1) {
            llenarTablaDetalle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_DetalleAplicacionKeyPressed(KeyEvent evt) {
        if (this.JTB_DetalleAplicacion.getSelectedRow() != -1 && evt.getKeyCode() == 10) {
            actualizarDatos();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_DuplicarActionPerformed(ActionEvent evt) {
        int numeroConsecutivo;
        if (this.JTB_DetalleAplicacion.getSelectedRow() != -1) {
            try {
                this.sql = "select (max(tqmovimientoconductasd.qm3_seq)+1) d from tqmovimientoconductasd     WHERE (tqmovimientoconductasd.qm3_cod=LPAD('" + this.JTF_NDocumento.getText() + "', 14, '0') \nAND tqmovimientoconductasd.qm3_tipo='W62' AND  tqmovimientoconductasd.qm3_num_in='" + this.JTB_DetalleAtenciones.getValueAt(this.JTB_DetalleAtenciones.getSelectedRow(), 0) + "'  AND  tqmovimientoconductasd.qm3_num='" + this.JTB_DetalleAplicacion.getValueAt(this.JTB_DetalleAplicacion.getSelectedRow(), 9) + "' \n    )";
                this.baseOracle = new ConexionBaseOracle();
                ResultSet rs = this.baseOracle.traerRs(this.sql);
                if (rs.next()) {
                    numeroConsecutivo = rs.getInt("d");
                } else {
                    numeroConsecutivo = 1;
                }
                this.sql = "Insert into TQMOVIMIENTOCONDUCTASD (QM3_COD_ZONA,QM3_COD,QM3_SEQK,QM3_TIPO,QM3_NUM,QM3_SEQ,QM3_COD_TIPOCON,QM3_NUM_CONSE,QM3_FCH,QM3_COD_ARTIC,QM3_COD_MEDICO,QM3_COD_ENTIDAD,QM3_NOM_DESC,QM3_NOM_PRES,QM3_CANT1,QM3_FCH_VENCE,QM3_COD_USU,QM3_FCH_DIG,QM3_HORA_DIG,QM3_COD_USUMOD,QM3_FCH_DIGMOD,QM3_HORA_DIGMOD,QM3_EST_EJECU,QM3_HORA_ALIM,QM3_EST_REPARTIR,QM3_NUM_MESES,QM3_TIPO_ORD,QM3_EST_VIA,QM3_COD_MED,QM3_COD_VIA,QM3_FUTURO50,QM3_EST_BMP,QM3_NOM_OBS,QM3_NUM_X,QM3_NUM_Y,QM3_FUTURO80,QM3_TIPO_QLO,QM3_NUM_QLO,QM3_SEQ_QLO,QM3_ESTADO_ORDV,QM3_ESTADO_ORDN,QM3_CANT_DES,QM3_CANT_DEV,QM3_CANT_APLI,QM3_CANT_SALDO,QM3_COD_TIPO_INDI,QM3_EST_FINACON_P,QM3_COD_TIPO_NTE,QM3_FUTURO38,QM3_SEQ_QJR,QM3_COD_SUPER,QM3_COD_CONVE,QM3_NUM_LADO,QM3_COD_TIPOD,QM3_COD_DIENTE,QM3_VR_VENTA,QM3_VR_TOTAL,QM3_VR_3,QM3_VR_4,QM3_VR_5,QM3_VR_6,QM3_VR_7,QM3_VR_8,QM3_VR_9,QM3_VR_10,QM3_VR_11,QM3_VR_12,QM3_VR_13,QM3_VR_14,QM3_VR_15,QM3_VR_16,QM3_VR_17,QM3_VR_18,QM3_VR_19,QM3_VR_20,QM3_VR_21,QM3_VR_22,QM3_VR_23,QM3_VR_24,QM3_VR_25,QM3_VR_26,QM3_VR_27,QM3_VR_28,QM3_VR_29,QM3_VR_30,QM3_VR_31,QM3_VR_32,QM3_VR_33,QM3_VR_34,QM3_VR_35,QM3_VR_36,QM3_VR_37,QM3_VR_38,QM3_VR_39,QM3_VR_40,QM3_VR_41,QM3_VR_42,QM3_VR_43,QM3_VR_44,QM3_VR_45,QM3_VR_46,QM3_VR_47,QM3_VR_48,QM3_VR_49,QM3_VR_50,QM3_VR_51,QM3_VR_52,QM3_VR_53,QM3_VR_54,QM3_VR_55,QM3_VR_56,QM3_VR_57,QM3_VR_58,QM3_VR_59,QM3_VR_60,QM3_TIPO_ATENCION,QM3_COBRAR,QM3_COD_ESPTE,QM3_COD_TIPOATENTE,QM3_CANT_SALDOF,QM3_EST_MENOR,QM3_NUM_DOSIS,QM3_NUM_FRE,QM3_NUM_DUR,QM3_COD_CAMPO1,QM3_COD_ROW,QM3_COD_COL,QM3_COD_PLANTI,QM3_EST_FRE,QM3_EST_DOSIS,QM3_FCH_VENCE2,QM3_BODEGA1,QM3_FCH_EVO,QM3_HORA_EVO,QM3_NOM_OBSJ,QM3_TIPO_ANE3,QM3_NUM_ANE3,QM3_EST_GEN_ANE3,QM3_SEQ_ANE3,QM3_EST_POS_DX,QM3_EST_SUS,QM3_FCH_INICIO,QM3_HORA_INICIO,QM3_EST_SUSP,QM3_FCH_SUSP,QM3_HORA_SUSP,QM3_CANT_D7,QM3_CANT_D8,QM3_CANT_D9,QM3_CANT_D10,QM3_CANT_D11,QM3_CANT_D12,QM3_CANT_D1,QM3_CANT_D2,QM3_CANT_D3,QM3_CANT_D4,QM3_CANT_D5,QM3_CANT_D6,QM3_CANT_N7,QM3_CANT_N8,QM3_CANT_N9,QM3_CANT_N10,QM3_CANT_N11,QM3_CANT_N12,QM3_CANT_N1,QM3_CANT_N2,QM3_CANT_N3,QM3_CANT_N4,QM3_CANT_N5,QM3_CANT_N6,QM3_EST_CERRAR,QM3_GEN_QM3_QLO,QM3_EST_DX_PER,QM3_EST_ENVIADO,QM3_TIPONPOS,QM3_NUMNPOS,QM3_AFEC_NPOS,QM3_TIPO_REP,QM3_NUM_REP,QM3_EST_GEN_REP,QM3_SEQ_REP,QM3_MARCA_SAL,QM3_TIPO_IN,QM3_NUM_IN,QM3_TIPO_CTA,QM3_NUM_CTA,QM3_EST_ANULADO,QM3_FCH_ANULA,QM3_HORA_ANULA,QM3_USU_ANULA,QM3_COD_ANULA,QM3_TIPO_TUAUT,QM3_NUM_TUAUT,QM3_SEQ_TUAUT,QM3_EST_TERMINA,QM3_FCH_TERMINA,QM3_HORA_TERMINA,QM3_FUTURO)    \nselect QM3_COD_ZONA,QM3_COD,QM3_SEQK,QM3_TIPO,QM3_NUM,\n'" + numeroConsecutivo + "',QM3_COD_TIPOCON,QM3_NUM_CONSE,QM3_FCH,QM3_COD_ARTIC,QM3_COD_MEDICO,QM3_COD_ENTIDAD,QM3_NOM_DESC,QM3_NOM_PRES,QM3_CANT1,QM3_FCH_VENCE,QM3_COD_USU,QM3_FCH_DIG,QM3_HORA_DIG,QM3_COD_USUMOD,QM3_FCH_DIGMOD,QM3_HORA_DIGMOD,QM3_EST_EJECU,QM3_HORA_ALIM,QM3_EST_REPARTIR,QM3_NUM_MESES,QM3_TIPO_ORD,QM3_EST_VIA,QM3_COD_MED,QM3_COD_VIA,QM3_FUTURO50,QM3_EST_BMP,QM3_NOM_OBS,QM3_NUM_X,QM3_NUM_Y,QM3_FUTURO80,QM3_TIPO_QLO,QM3_NUM_QLO,QM3_SEQ_QLO,QM3_ESTADO_ORDV,QM3_ESTADO_ORDN,QM3_CANT_DES,QM3_CANT_DEV,QM3_CANT_APLI,QM3_CANT_SALDO,QM3_COD_TIPO_INDI,QM3_EST_FINACON_P,QM3_COD_TIPO_NTE,QM3_FUTURO38,QM3_SEQ_QJR,QM3_COD_SUPER,QM3_COD_CONVE,QM3_NUM_LADO,QM3_COD_TIPOD,QM3_COD_DIENTE,QM3_VR_VENTA,QM3_VR_TOTAL,QM3_VR_3,QM3_VR_4,QM3_VR_5,QM3_VR_6,QM3_VR_7,QM3_VR_8,QM3_VR_9,QM3_VR_10,QM3_VR_11,QM3_VR_12,QM3_VR_13,QM3_VR_14,QM3_VR_15,QM3_VR_16,QM3_VR_17,QM3_VR_18,QM3_VR_19,QM3_VR_20,QM3_VR_21,QM3_VR_22,QM3_VR_23,QM3_VR_24,QM3_VR_25,QM3_VR_26,QM3_VR_27,QM3_VR_28,QM3_VR_29,QM3_VR_30,QM3_VR_31,QM3_VR_32,QM3_VR_33,QM3_VR_34,QM3_VR_35,QM3_VR_36,QM3_VR_37,QM3_VR_38,QM3_VR_39,QM3_VR_40,QM3_VR_41,QM3_VR_42,QM3_VR_43,QM3_VR_44,QM3_VR_45,QM3_VR_46,QM3_VR_47,QM3_VR_48,QM3_VR_49,QM3_VR_50,QM3_VR_51,QM3_VR_52,QM3_VR_53,QM3_VR_54,QM3_VR_55,QM3_VR_56,QM3_VR_57,QM3_VR_58,QM3_VR_59,QM3_VR_60,QM3_TIPO_ATENCION,QM3_COBRAR,QM3_COD_ESPTE,QM3_COD_TIPOATENTE,QM3_CANT_SALDOF,QM3_EST_MENOR,QM3_NUM_DOSIS,QM3_NUM_FRE,QM3_NUM_DUR,QM3_COD_CAMPO1,QM3_COD_ROW,QM3_COD_COL,QM3_COD_PLANTI,QM3_EST_FRE,QM3_EST_DOSIS,QM3_FCH_VENCE2,QM3_BODEGA1,QM3_FCH_EVO,QM3_HORA_EVO,QM3_NOM_OBSJ,QM3_TIPO_ANE3,QM3_NUM_ANE3,QM3_EST_GEN_ANE3,QM3_SEQ_ANE3,QM3_EST_POS_DX,QM3_EST_SUS,QM3_FCH_INICIO,QM3_HORA_INICIO,QM3_EST_SUSP,QM3_FCH_SUSP,QM3_HORA_SUSP,QM3_CANT_D7,QM3_CANT_D8,QM3_CANT_D9,QM3_CANT_D10,QM3_CANT_D11,QM3_CANT_D12,QM3_CANT_D1,QM3_CANT_D2,QM3_CANT_D3,QM3_CANT_D4,QM3_CANT_D5,QM3_CANT_D6,QM3_CANT_N7,QM3_CANT_N8,QM3_CANT_N9,QM3_CANT_N10,QM3_CANT_N11,QM3_CANT_N12,QM3_CANT_N1,QM3_CANT_N2,QM3_CANT_N3,QM3_CANT_N4,QM3_CANT_N5,QM3_CANT_N6,QM3_EST_CERRAR,QM3_GEN_QM3_QLO,QM3_EST_DX_PER,QM3_EST_ENVIADO,QM3_TIPONPOS,QM3_NUMNPOS,QM3_AFEC_NPOS,QM3_TIPO_REP,QM3_NUM_REP,QM3_EST_GEN_REP,QM3_SEQ_REP,QM3_MARCA_SAL,QM3_TIPO_IN,QM3_NUM_IN,QM3_TIPO_CTA,QM3_NUM_CTA,QM3_EST_ANULADO,QM3_FCH_ANULA,QM3_HORA_ANULA,QM3_USU_ANULA,QM3_COD_ANULA,QM3_TIPO_TUAUT,QM3_NUM_TUAUT,QM3_SEQ_TUAUT,QM3_EST_TERMINA,QM3_FCH_TERMINA,QM3_HORA_TERMINA,QM3_FUTURO\n from TQMOVIMIENTOCONDUCTASD\n WHERE (tqmovimientoconductasd.qm3_cod=LPAD('" + this.JTF_NDocumento.getText() + "', 14, '0') \nAND tqmovimientoconductasd.qm3_tipo='W62' AND  tqmovimientoconductasd.qm3_num_in='" + this.JTB_DetalleAtenciones.getValueAt(this.JTB_DetalleAtenciones.getSelectedRow(), 0) + "'  AND  tqmovimientoconductasd.qm3_num='" + this.JTB_DetalleAplicacion.getValueAt(this.JTB_DetalleAplicacion.getSelectedRow(), 9) + "' \nand tqmovimientoconductasd.qm3_fch_evo='" + this.JTB_DetalleAplicacion.getValueAt(this.JTB_DetalleAplicacion.getSelectedRow(), 0) + "' and tqmovimientoconductasd.qm3_hora_evo='" + this.JTB_DetalleAplicacion.getValueAt(this.JTB_DetalleAplicacion.getSelectedRow(), 1) + "' and QM3_COD_ARTIC='" + this.JTB_DetalleAplicacion.getValueAt(this.JTB_DetalleAplicacion.getSelectedRow(), 7) + "'\n    )  ";
                this.baseOracle.ejecutar(this.sql);
                this.sql = "  insert into  TQOBSERVACIONESMEDICAMEL(QLL_TIPO,QLL_NUM,QLL_SEQ,QLL_COD_USU,QLL_FCH_DIG,QLL_HORA_DIG,QLL_COD_USUMOD,QLL_FCH_DIGMOD,QLL_HORA_DIGMOD,QLL_NOM_TERM,QLL_NOM_TERMMOD,QLL_NOM_OBS,QLL_FUTURO)\n  select \n  QLL_TIPO,QLL_NUM,'" + numeroConsecutivo + "', QLL_COD_USU,QLL_FCH_DIG,QLL_HORA_DIG,QLL_COD_USUMOD,QLL_FCH_DIGMOD,QLL_HORA_DIGMOD,QLL_NOM_TERM,QLL_NOM_TERMMOD,QLL_NOM_OBS,QLL_FUTURO\n  from \n  TQOBSERVACIONESMEDICAMEL  where QLL_NUM='" + this.JTB_DetalleAplicacion.getValueAt(this.JTB_DetalleAplicacion.getSelectedRow(), 9) + "' and QLL_TIPO='W62' AND QLL_SEQ='" + this.JTB_DetalleAplicacion.getValueAt(this.JTB_DetalleAplicacion.getSelectedRow(), 8) + "'";
                this.baseOracle.ejecutar(this.sql);
                this.baseOracle.CerrarConexion();
                llenarTablaDetalle();
            } catch (SQLException ex) {
                Logger.getLogger(JIF_HojaTratamiento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_EliminarActionPerformed(ActionEvent evt) {
        if (this.JTB_DetalleAplicacion.getSelectedRow() != -1) {
            try {
                this.sql = "delete  from  TQOBSERVACIONESMEDICAMEL  where QLL_NUM='" + this.JTB_DetalleAplicacion.getValueAt(this.JTB_DetalleAplicacion.getSelectedRow(), 9) + "' and QLL_TIPO='W62' AND QLL_SEQ='" + this.JTB_DetalleAplicacion.getValueAt(this.JTB_DetalleAplicacion.getSelectedRow(), 8) + "'";
                this.baseOracle.ejecutar(this.sql);
                this.sql = "delete from tqmovimientoconductasd WHERE (tqmovimientoconductasd.qm3_cod=LPAD('" + this.JTF_NDocumento.getText() + "', 14, '0') \nAND tqmovimientoconductasd.qm3_tipo='W62' AND  tqmovimientoconductasd.qm3_num_in='" + this.JTB_DetalleAtenciones.getValueAt(this.JTB_DetalleAtenciones.getSelectedRow(), 0) + "'  AND  tqmovimientoconductasd.qm3_num='" + this.JTB_DetalleAplicacion.getValueAt(this.JTB_DetalleAplicacion.getSelectedRow(), 9) + "' \nand QM3_COD_ARTIC='" + this.JTB_DetalleAplicacion.getValueAt(this.JTB_DetalleAplicacion.getSelectedRow(), 7) + "'\n    )  ";
                this.baseOracle.ejecutar(this.sql);
                this.baseOracle.CerrarConexion();
                llenarTablaDetalle();
            } catch (SQLException ex) {
                Logger.getLogger(JIF_HojaTratamiento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    private void llenarDatosIngreso() {
        if (!this.JTF_NDocumento.getText().isEmpty()) {
            try {
                crearTablaDetalleAplicacion();
                this.baseOracle = new ConexionBaseOracle();
                this.sql = "select d.nombreUsuario, d.numeroIngreso, d.idEntidad, d.nombreEntidad\n , d.fechaIngreso\n, d.fechaSalida, d.idSala \n, tmsalas.sal_nombre nombreSala\n\nfrom (\nSELECT \ntmusuariosfacturacion.kc2_papellido|| ' ' ||tmusuariosfacturacion.kc2_sapellido|| ' ' ||tmusuariosfacturacion.kc2_pnombre|| ' ' || tmusuariosfacturacion.kc2_snombre nombreUsuario \n\n, tqmovimientohc.qm1_num_in numeroIngreso, tqmovimientohc.qm1_num_ent idEntidad, \ntmentidades.ent_nombre nombreEntidad\n , tmadmision.kc4_fch fechaIngreso\n , tmadmision.kc4_fch_s fechaSalida\n , tmadmision.kc4_sala idSala   \n \n \nFROM TQMOVIMIENTOHC INNER JOIN TQMOVIMIENTOCONDUCTASD ON (tqmovimientohc.qm1_num_conse=tqmovimientoconductasd.qm3_num_conse)\nAND (tqmovimientohc.qm1_cod=tqmovimientoconductasd.qm3_cod)\ninner join TMUSUARIOSFACTURACION on (tmusuariosfacturacion.kc2_cod=tqmovimientohc.qm1_cod)\ninner join tmentidades on ( tqmovimientohc.qm1_num_ent = tmentidades.ent_cod)\ninner join tmadmision on ( tmadmision.kc4_num_cuenta = tqmovimientohc.qm1_num_cuenta) and (tmadmision.kc4_cod=tqmovimientohc.qm1_cod)\nWHERE (tqmovimientohc.qm1_cod=LPAD('" + this.JTF_NDocumento.getText() + "', 14, '0') AND tqmovimientoconductasd.qm3_tipo='W62')\n\nORDER BY tqmovimientoconductasd.qm3_nom_desc asc) d \ninner  JOIN TMSALAS ON (tmsalas.sal_cod=d.idSala )\n-- where d.idSala is not null\nGROUP by d.nombreUsuario, d.numeroIngreso,  d.idEntidad, d.nombreEntidad\n, d.fechaIngreso\n , d.fechaSalida, d.idSala ,  tmsalas.sal_nombre";
                ResultSet rs = this.baseOracle.traerRs(this.sql);
                if (rs.next()) {
                    this.JL_NombreUsuario.setText(rs.getString("nombreUsuario"));
                    crearTablaDetalleAtenciones();
                    rs.beforeFirst();
                    int fila = 0;
                    while (rs.next()) {
                        this.modeloDefaultTableModel.addRow(this.dato);
                        this.modeloDefaultTableModel.setValueAt(Long.valueOf(rs.getLong("numeroIngreso")), fila, 0);
                        this.modeloDefaultTableModel.setValueAt(rs.getString("nombreEntidad"), fila, 1);
                        this.modeloDefaultTableModel.setValueAt(rs.getString("fechaIngreso"), fila, 2);
                        this.modeloDefaultTableModel.setValueAt(rs.getString("fechaSalida"), fila, 3);
                        this.modeloDefaultTableModel.setValueAt(rs.getString("nombreSala"), fila, 4);
                        fila++;
                    }
                } else {
                    crearTablaDetalleAtenciones();
                    crearTablaDetalleAplicacion();
                    this.baseOracle.CerrarConexion();
                }
            } catch (SQLException ex) {
                Logger.getLogger(JIF_HojaTratamiento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    private void llenarTablaDetalle() {
        if (!this.JTF_NDocumento.getText().isEmpty() && this.JTB_DetalleAtenciones.getSelectedRow() != -1) {
            try {
                this.baseOracle = new ConexionBaseOracle();
                this.sql = "SELECT \ntmusuariosfacturacion.kc2_papellido|| ' ' ||tmusuariosfacturacion.kc2_sapellido|| ' ' ||tmusuariosfacturacion.kc2_pnombre|| ' ' || tmusuariosfacturacion.kc2_snombre nombreUsuario \n, case  tmusuariosfacturacion.kc2_estado_civil\n        when  'V' then\n        'VIUDO' \n         when  'U' then\n        'UNION LIBRE' \n         when  'D' then\n        'DIVORCIADO' \n         when  'C' then\n        'CASADO' \n        ELSE 'SOLTERO' END estadoCivil\n, tmusuariosfacturacion.kc2_tipo_docto tipoDocumento\n, LTRIM(tmadmision.kc4_cod, '0') numeroDocumento\n, case  tmusuariosfacturacion.kc2_sexo \n        when  'F' then\n        'FEMENINO' \n         when  'M' then\n        'MASCULINO' \n        ELSE 'INDETERMINADO' END idSexo\n\n, tqmovimientohc.qm1_num_in numeroIngreso, tqmovimientohc.qm1_num_ent idEntidad \n, tqmovimientohc.qm1_cod_sala idSala\n, tmentidades.ent_nombre nombreEntidad\n, tmusuariosfacturacion.kc2_estrato\n , tmadmision.kc4_fch  fechaIngreso\n ,tmadmision.kc4_fch_s  fechaSalida\n ,tqmovimientoconductasd.qm3_fch_evo fechaDigitacion\n, LPAD(tqmovimientoconductasd.qm3_hora_evo, 8, '0')  horaDigitacion\n , tqmovimientoconductasd.qm3_nom_desc nombreItems\n , tqmovimientoconductasd.qm3_nom_pres nombrePresentacion\n , tqmovimientoconductasd.qm3_cant1 cantidad\n  , tqmovimientoconductasd.qm3_cant_apli cantidadAplicada\n  , tqobservacionesmedicamel.qll_nom_obs observacion\n  , tmmedicos.med_nombre nombreMedico\n  , tmmedicos2.med2_nom_archfoto urlFirma\n  , tqmovimientoconductasd.qm3_cod_artic codigoMedicamento\n  , tqmovimientoconductasd.qm3_seq numeroSecuencia\n  , tqmovimientoconductasd.qm3_num numeroOrden\n  , ips.me_nom nombreIps\n  , ips.me_dir direccionIps\n   , ips.me_dir_internet correoIps\n    , ips.me_nit nitIps\n    , 'x:'||ips.me2_nom_logoemp rutaImagen , \n   'x:'|| ips.me2_nom_rutafirmas || '\\'||tmmedicos2.med2_nom_archfoto rutasFirmas\nFROM \nTQMOVIMIENTOHC INNER JOIN TQMOVIMIENTOCONDUCTASD ON (tqmovimientohc.qm1_num_conse=tqmovimientoconductasd.qm3_num_conse)\nAND (tqmovimientohc.qm1_cod=tqmovimientoconductasd.qm3_cod)\ninner join TMUSUARIOSFACTURACION on (tmusuariosfacturacion.kc2_cod=tqmovimientohc.qm1_cod)\ninner join tmentidades on ( tqmovimientohc.qm1_num_ent = tmentidades.ent_cod)\ninner join tmmedicos on ( tmmedicos.med_cod = tqmovimientoconductasd.qm3_cod_medico)\ninner join tmmedicos2 on ( tmmedicos2.med2_cod =  tmmedicos.med_cod)\ninner join tmadmision on ( tmadmision.kc4_num_cuenta = tqmovimientohc.qm1_num_cuenta) and (tmadmision.kc4_cod=tqmovimientohc.qm1_cod)\ninner join tiarticulos on ( tiarticulos.mi_artic= tqmovimientoconductasd.qm3_cod_artic) \nleft join timarcas on ( tiarticulos.mi_marca=timarcas.ma_marca) \n left join tqobservacionesmedicamel on (tqobservacionesmedicamel.qll_num=tqmovimientoconductasd.qm3_num) \n and (tqobservacionesmedicamel.qll_seq=tqmovimientoconductasd.qm3_seq) and (tqobservacionesmedicamel.qll_tipo=tqmovimientoconductasd.qm3_tipo)\n , (select txempresas.me_nom,txempresas.me_dir, txempresas.me_dir_internet, txempresas.me_nit,txempresas2.me2_nom_logoemp, txempresas2.me2_nom_rutaimagen , txempresas2.me2_nom_rutafirmas, txempresas2.me2_nom_server from txempresas inner join txempresas2 on (txempresas.me_emp1=txempresas2.me2_emp1) where txempresas.me_emp1='01') ips\n    WHERE (tqmovimientohc.qm1_cod=LPAD('" + this.JTF_NDocumento.getText() + "', 14, '0') AND tqmovimientoconductasd.qm3_tipo='W62' AND  tqmovimientohc.qm1_num_in='" + this.JTB_DetalleAtenciones.getValueAt(this.JTB_DetalleAtenciones.getSelectedRow(), 0) + "' \n    and tqmovimientoconductasd.qm3_nom_pres is not null\n --AND timarcas.ma_marca<>1034\n)\n\nORDER BY tqmovimientoconductasd.qm3_nom_desc asc, tqmovimientoconductasd.qm3_fch_evo  asc, tqmovimientoconductasd.qm3_hora_evo asc";
                ResultSet rs = this.baseOracle.traerRs(this.sql);
                if (rs.next()) {
                    crearTablaDetalleAplicacion();
                    int fila = 0;
                    rs.beforeFirst();
                    while (rs.next()) {
                        this.modeloAplicacion.addRow(this.dato);
                        this.modeloAplicacion.setValueAt(rs.getString("fechaDigitacion"), fila, 0);
                        this.modeloAplicacion.setValueAt(rs.getString("horaDigitacion"), fila, 1);
                        this.modeloAplicacion.setValueAt(rs.getString("nombreItems"), fila, 2);
                        this.modeloAplicacion.setValueAt(rs.getString("nombrePresentacion"), fila, 3);
                        this.modeloAplicacion.setValueAt(rs.getString("cantidad"), fila, 4);
                        this.modeloAplicacion.setValueAt(rs.getString("observacion"), fila, 5);
                        this.modeloAplicacion.setValueAt(rs.getString("nombreMedico"), fila, 6);
                        this.modeloAplicacion.setValueAt(rs.getString("codigoMedicamento"), fila, 7);
                        this.modeloAplicacion.setValueAt(rs.getString("numeroSecuencia"), fila, 8);
                        this.modeloAplicacion.setValueAt(rs.getString("numeroOrden"), fila, 9);
                        fila++;
                    }
                } else {
                    crearTablaDetalleAplicacion();
                    this.baseOracle.CerrarConexion();
                }
            } catch (SQLException ex) {
                Logger.getLogger(JIF_HojaTratamiento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearTablaDetalleAtenciones() {
        this.modeloDefaultTableModel = new DefaultTableModel(new Object[0], new String[]{"idIngreso", "Nombre Entidad", "Fecha Ingreso", "Fecha Egreso", "Salsa"}) { // from class: com.genoma.plus.controller.transicion.JIF_HojaTratamiento.7
            Class[] types = {Long.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTB_DetalleAtenciones;
        JTable jTable2 = this.JTB_DetalleAtenciones;
        jTable.setAutoResizeMode(0);
        this.JTB_DetalleAtenciones.setModel(this.modeloDefaultTableModel);
        this.JTB_DetalleAtenciones.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTB_DetalleAtenciones.getColumnModel().getColumn(1).setPreferredWidth(400);
        this.JTB_DetalleAtenciones.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTB_DetalleAtenciones.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTB_DetalleAtenciones.getColumnModel().getColumn(4).setPreferredWidth(300);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearTablaDetalleAplicacion() {
        this.modeloAplicacion = new DefaultTableModel(new Object[0], new String[]{"Fecha", "Hora", "Nombre", "Presentación", "Cantidad", "Observación", "Profesional", "Codigo Medicamento", "Numero Secuencia", "Numero Orden"}) { // from class: com.genoma.plus.controller.transicion.JIF_HojaTratamiento.8
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Integer.class, Integer.class};
            boolean[] canEdit = {true, true, true, true, true, true, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTB_DetalleAplicacion;
        JTable jTable2 = this.JTB_DetalleAplicacion;
        jTable.setAutoResizeMode(0);
        this.JTB_DetalleAplicacion.setModel(this.modeloAplicacion);
        this.JTB_DetalleAplicacion.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTB_DetalleAplicacion.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTB_DetalleAplicacion.getColumnModel().getColumn(2).setPreferredWidth(400);
        this.JTB_DetalleAplicacion.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTB_DetalleAplicacion.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTB_DetalleAplicacion.getColumnModel().getColumn(5).setPreferredWidth(300);
        this.JTB_DetalleAplicacion.getColumnModel().getColumn(6).setPreferredWidth(200);
        this.JTB_DetalleAplicacion.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTB_DetalleAplicacion.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTB_DetalleAplicacion.getColumnModel().getColumn(9).setPreferredWidth(100);
    }

    private void actualizarDatos() {
        this.sql = "update tqmovimientoconductasd set  tqmovimientoconductasd.qm3_fch_evo='" + this.JTB_DetalleAplicacion.getValueAt(this.JTB_DetalleAplicacion.getSelectedRow(), 0) + "',  tqmovimientoconductasd.qm3_hora_evo='" + this.JTB_DetalleAplicacion.getValueAt(this.JTB_DetalleAplicacion.getSelectedRow(), 1) + "'\n,  tqmovimientoconductasd.qm3_cant1='" + this.JTB_DetalleAplicacion.getValueAt(this.JTB_DetalleAplicacion.getSelectedRow(), 4) + "'\n,  tqmovimientoconductasd.qm3_nom_desc='" + this.JTB_DetalleAplicacion.getValueAt(this.JTB_DetalleAplicacion.getSelectedRow(), 2) + "'\n,  tqmovimientoconductasd.qm3_nom_pres='" + this.JTB_DetalleAplicacion.getValueAt(this.JTB_DetalleAplicacion.getSelectedRow(), 3) + "'\n WHERE (tqmovimientoconductasd.qm3_cod=LPAD('" + this.JTF_NDocumento.getText() + "', 14, '0') AND tqmovimientoconductasd.qm3_tipo='W62' AND   tqmovimientoconductasd.qm3_num_in='" + this.JTB_DetalleAtenciones.getValueAt(this.JTB_DetalleAtenciones.getSelectedRow(), 0) + "'\n and tqmovimientoconductasd.qm3_cod_artic ='" + this.JTB_DetalleAplicacion.getValueAt(this.JTB_DetalleAplicacion.getSelectedRow(), 7) + "' and   tqmovimientoconductasd.qm3_seq ='" + this.JTB_DetalleAplicacion.getValueAt(this.JTB_DetalleAplicacion.getSelectedRow(), 8) + "' and  tqmovimientoconductasd.qm3_num='" + this.JTB_DetalleAplicacion.getValueAt(this.JTB_DetalleAplicacion.getSelectedRow(), 9) + "')";
        this.baseOracle = new ConexionBaseOracle();
        this.baseOracle.ejecutar(this.sql);
        this.sql = " update tqobservacionesmedicamel set tqobservacionesmedicamel.qll_nom_obs='" + this.JTB_DetalleAplicacion.getValueAt(this.JTB_DetalleAplicacion.getSelectedRow(), 5) + "'\n where tqobservacionesmedicamel.qll_tipo='W62' and tqobservacionesmedicamel.qll_seq='" + this.JTB_DetalleAplicacion.getValueAt(this.JTB_DetalleAplicacion.getSelectedRow(), 8) + "' and tqobservacionesmedicamel.qll_num='" + this.JTB_DetalleAplicacion.getValueAt(this.JTB_DetalleAplicacion.getSelectedRow(), 9) + "'";
        this.baseOracle.ejecutar(this.sql);
    }

    public void nuevo() {
        this.JTF_NDocumento.setText("");
        this.JL_NombreUsuario.setText("");
        crearTablaDetalleAplicacion();
        crearTablaDetalleAtenciones();
    }

    public void imprimir() {
        Metodos metodos = new Metodos();
        String[][] parametros = new String[3][2];
        parametros[0][0] = "idIngreso";
        parametros[0][1] = this.JTB_DetalleAtenciones.getValueAt(this.JTB_DetalleAtenciones.getSelectedRow(), 0).toString();
        parametros[1][0] = "idDocumento";
        parametros[1][1] = this.JTF_NDocumento.getText();
        parametros[2][0] = "nombreSala";
        parametros[2][1] = this.JTB_DetalleAtenciones.getValueAt(this.JTB_DetalleAtenciones.getSelectedRow(), 4).toString();
        metodos.GenerarPDFOracle(metodos.getRutaRep() + "Hoja_Tratamiento_ClincaPajonal", parametros);
    }
}
