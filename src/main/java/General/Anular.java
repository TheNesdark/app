package General;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.controller.contabilidad.JDFacturaEquivalente;
import com.genoma.plus.controller.sgc.JIFF_SC_EventoAdversoAnalisis;
import com.genoma.plus.controller.sgc.SC_JDEventoAdversoGestion;
import java.awt.Color;
import java.awt.Dimension;
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
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:General/Anular.class */
public class Anular extends JDialog {
    private Metodos metodos;
    private ConsultasMySQL consultas;
    private String sql;
    private String clave;
    private String frmLlamador;
    private int filaGrid;
    private int xmodulo;
    private Object[] dato;
    public DefaultTableModel modelo;
    private ResultSet rs;
    private JIFF_SC_EventoAdversoAnalisis xJIFF_SC_EventoAdversoAnalisis;
    SC_JDEventoAdversoGestion xAnalisEvento;
    private Integer forma;
    private int clic;
    private JDialog jDialog;
    private JButton btnCancelar;
    private JButton btnOk;
    private ButtonGroup buttonGroup1;
    private JTable grid;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JTextPane lblDetalle;
    private JPasswordField txtClave;
    private JTextArea txtDetalle;
    private JTextField txtLogin;
    private JTextField txtNombre;

    @Generated
    public Integer getForma() {
        return this.forma;
    }

    @Generated
    public void setForma(Integer forma) {
        this.forma = forma;
    }

    public Anular(Frame parent, boolean modal, String frm, int xmodulo) {
        super(parent, modal);
        this.metodos = new Metodos();
        this.consultas = new ConsultasMySQL();
        this.clave = "";
        this.filaGrid = 0;
        this.xmodulo = 0;
        this.forma = 0;
        this.clic = 0;
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.xmodulo = xmodulo;
        setLocationRelativeTo(null);
        this.frmLlamador = frm;
        this.grid.addMouseListener(new MouseAdapter() { // from class: General.Anular.1
            public void mouseClicked(MouseEvent e) {
                Anular.this.filaGrid = Anular.this.grid.rowAtPoint(e.getPoint());
            }
        });
        validarLlamador();
        mCrearModelo();
    }

    public Anular(Frame parent, boolean modal, String frm, int xmodulo, JDialog forma) {
        super(parent, modal);
        this.metodos = new Metodos();
        this.consultas = new ConsultasMySQL();
        this.clave = "";
        this.filaGrid = 0;
        this.xmodulo = 0;
        this.forma = 0;
        this.clic = 0;
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.xmodulo = xmodulo;
        setLocationRelativeTo(null);
        this.frmLlamador = frm;
        this.grid.addMouseListener(new MouseAdapter() { // from class: General.Anular.2
            public void mouseClicked(MouseEvent e) {
                Anular.this.filaGrid = Anular.this.grid.rowAtPoint(e.getPoint());
            }
        });
        validarLlamador();
        mCrearModelo();
        this.jDialog = forma;
    }

    public Anular(Frame parent, boolean modal, String frm, int xmodulo, int forma) {
        super(parent, modal);
        this.metodos = new Metodos();
        this.consultas = new ConsultasMySQL();
        this.clave = "";
        this.filaGrid = 0;
        this.xmodulo = 0;
        this.forma = 0;
        this.clic = 0;
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.xmodulo = xmodulo;
        setForma(Integer.valueOf(forma));
        setLocationRelativeTo(null);
        this.frmLlamador = frm;
        this.grid.addMouseListener(new MouseAdapter() { // from class: General.Anular.3
            public void mouseClicked(MouseEvent e) {
                Anular.this.filaGrid = Anular.this.grid.rowAtPoint(e.getPoint());
            }
        });
        validarLlamador();
        mCrearModelo();
    }

    private void validarLlamador() {
        if (this.frmLlamador.equals("Egreso")) {
            setTitle("Motivos de Anulación de Egresos");
            return;
        }
        if (this.frmLlamador.equals("Recibo Caja")) {
            setTitle("Motivos de Anulación de Recibo Caja");
            return;
        }
        if (this.frmLlamador.equals("Traslados")) {
            setTitle("Motivos de Anulación de Traslados de Cama");
            return;
        }
        if (this.frmLlamador.equals("Citas")) {
            setTitle("Motivos de Desistencia de Citas");
            return;
        }
        if (this.frmLlamador.equals("CitaInterconsulta")) {
            setTitle("Motivos de Desistencia de Citas");
            return;
        }
        if (this.frmLlamador.equals("Atencion")) {
            setTitle("Motivos de Anulación de Triage");
            return;
        }
        if (this.frmLlamador.equals("Triage")) {
            setTitle("Motivos de Anulación de Triage");
            return;
        }
        if (this.frmLlamador.equals("Caja")) {
            setTitle("Motivo de Anulación Recibos");
            return;
        }
        if (this.frmLlamador.equals("TomaCACervix")) {
            setTitle("Motivos de Toma de Muestras de Citología CACervix");
            return;
        }
        if (this.frmLlamador.equals("Entradas")) {
            setTitle("Motivos de Anulación de Entradas al Inventario");
            return;
        }
        if (this.frmLlamador.equals("Despachos")) {
            setTitle("Motivos de Anulación de Despachos de Suministros");
            return;
        }
        if (this.frmLlamador.equals("Salidas")) {
            setTitle("Motivos de Anulación de Salidas de Suministros");
            return;
        }
        if (this.frmLlamador.equals("ITraslados")) {
            setTitle("Motivos de Anulación de Traslados de Suministros");
            return;
        }
        if (this.frmLlamador.equals("Faltantes")) {
            setTitle("Motivos de Anulación de Faltantes de Suministros");
            return;
        }
        if (this.frmLlamador.equals("Recepcion")) {
            setTitle("Motivos de Anulación de Toma de Muestras de Laboratorio");
            return;
        }
        if (this.frmLlamador.equals("TomaManual")) {
            setTitle("Toma de Muestra de Laboratorio");
            return;
        }
        if (this.frmLlamador.equals("Areas")) {
            setTitle("Areas de Laboratorio");
            return;
        }
        if (this.frmLlamador.equals("Protocolos")) {
            setTitle("Protocolos de Laboratorio");
            return;
        }
        if (this.frmLlamador.equals("ProtocoloxAreaxProcedimiento")) {
            setTitle("Protocolos Por Area por Procedimiento");
            return;
        }
        if (this.frmLlamador.equals("TipoResultado")) {
            setTitle("Tipos de Resultados");
            return;
        }
        if (this.frmLlamador.equals("ProtocoloxTipoResultado")) {
            setTitle("Protocolos por Tipos de Resultados");
            return;
        }
        if (this.frmLlamador.equals("ResultadoManual")) {
            setTitle("Toma de Resultados Manual");
            return;
        }
        if (this.frmLlamador.equals("Consolidado")) {
            setTitle("Motivos de Anulación de Factura");
            return;
        }
        if (this.frmLlamador.equals("Contabilidad")) {
            setTitle("Motivos de Anulación de Documentos Contables");
            return;
        }
        if (this.frmLlamador.equals("CIRUGÍA")) {
            setTitle("Motivos de Anulación de Cirugías");
            return;
        }
        if (this.frmLlamador.equals("Radicacion")) {
            setTitle("Motivos de Anulación Radicación de Factuas");
            return;
        }
        if (this.frmLlamador.equals("SeguimientosSo")) {
            setTitle("Motivos de Anulación Seguimientos SVE");
            return;
        }
        if (this.frmLlamador.equals("FacturacionUH")) {
            setTitle("Motivos de Anulación Ordenes Facturadas");
            return;
        }
        if (this.frmLlamador.equals("Liquidacion_N")) {
            setTitle("Motivos de Anulación N° Ordenes/Factura");
            return;
        }
        if (this.frmLlamador.equals("FacturacionUH_Egreso")) {
            setTitle("Motivos de Anulación Egreso");
            return;
        }
        if (this.frmLlamador.equals("xjifautorizacion_servicios")) {
            setTitle("Motivos de Anulación de Autorización de Servicios");
            return;
        }
        if (this.frmLlamador.equals("xjifautorizacion_servicios")) {
            setTitle("Anular Respuesta Glosa");
            return;
        }
        if (this.frmLlamador.equals("jifconsultarcuentacobroempresa")) {
            setTitle("Motivos de Anulación de Factura");
            return;
        }
        if (this.frmLlamador.equals("GESTIÓN EVENTO")) {
            setTitle("GESTIÓN EVENTO");
            this.xAnalisEvento = new SC_JDEventoAdversoGestion(null, true, Principal.xclasesgc.xJIFF_SC_EventoAdversoAnalisis);
            return;
        }
        if (this.frmLlamador.equals("ANÁLISIS EVENTO ADVERSO")) {
            setTitle("ANÁLISIS EVENTO ADVERSO");
            return;
        }
        if (this.frmLlamador.equals("PP_MoviManualesIngresos")) {
            setTitle("ANULACIÓN DE MOVIMIENTOS DE INGRESO");
            return;
        }
        if (this.frmLlamador.equals("PP_Solicitud")) {
            setTitle("ANULACIÓN DE SOLICITUDES");
            return;
        }
        if (this.frmLlamador.equals("PP_MovimientosP")) {
            setTitle("ANULACIÓN DE MOVIMIENTOS PRESUPUESTALES");
            return;
        }
        if (this.frmLlamador.equals("PP_Anula_MovimientosP")) {
            setTitle("ANULACIÓN DE MOVIMIENTOS PRESUPUESTALES");
            return;
        }
        if (this.frmLlamador.equals("Causación Nomina")) {
            setTitle("ANULACIÓN DE CAUSACIÓN NOMINA");
            return;
        }
        if (this.frmLlamador.equals("Orden Compra")) {
            setTitle("ANULACIÓN DE ORDEN COMPRA");
            return;
        }
        if (this.frmLlamador.equals("Requisicion")) {
            setTitle("ANULACIÓN REQUISICION");
            return;
        }
        if (this.frmLlamador.equals("Consultar Cuenta de Cobro")) {
            setTitle("ANULACIÓN REQUISICION DE DOCUMENTO CONTABLES");
            return;
        }
        if (this.frmLlamador.equals("GESTIÓN DE PAGOS")) {
            setTitle("ANULACIÓN DE PAGO");
            return;
        }
        if (this.frmLlamador.equals("xjpglosa")) {
            setTitle("ANULACIÓN DE GLOSA");
            return;
        }
        if (this.frmLlamador.equals("xjpglosaRespuestas")) {
            setTitle("ANULACIÓN DE RESPUESTA GLOSA");
            return;
        }
        if (this.frmLlamador.equals("xjpIngresoSeguimientos")) {
            setTitle("ANULACIÓN DE SEGUIMIENTOS");
            return;
        }
        if (this.frmLlamador.equals("xjphojatratamiento")) {
            setTitle("ANULACIÓN DE APLICACION DE SUMINISTRO");
            return;
        }
        if (this.frmLlamador.equals("jpcontroldiabetes")) {
            setTitle("ANULACIÓN DE CONTROL DE DIABETES");
            return;
        }
        if (this.frmLlamador.equals("JPAEventoECastPacienteGasto")) {
            setTitle("Anulacion de Factura de Gasto");
            return;
        }
        if (this.frmLlamador.equals("Caja Egreso")) {
            setTitle("Anulación de Recibo de Egreso");
            return;
        }
        if (this.frmLlamador.equals("Cierre Caja")) {
            setTitle("Anulación Cierre de Caja");
            return;
        }
        if (this.frmLlamador.equals("Registro de Recibos")) {
            setTitle("Anulación de Recibo de Caja Menor");
            return;
        }
        if (this.frmLlamador.equals("Radiologia")) {
            setTitle("Anulación de Recepcion de Radiologia");
            return;
        }
        if (this.frmLlamador.equals("SALIDA ADMINISTRATIVA")) {
            setTitle("ANULACIÓN SALIDA ADMINISTRATIVA");
            return;
        }
        if (this.frmLlamador.equals("ANULACIÓN DE ANEXO TECNICO 1")) {
            setTitle("ANULACIÓN DE ANEXO TECNICO 1");
            return;
        }
        if (this.frmLlamador.equals("Cierre Recibo Egreso")) {
            setTitle("ANULACIÓN CIERRE DE CAJA DE EGRESOS");
            return;
        }
        if (this.frmLlamador.equals("jifSolicitudPedidoInterno")) {
            setTitle("ANULACIÓN SOLICITUD INTERNA");
            return;
        }
        if (this.frmLlamador.equals("Prestamo")) {
            setTitle("ANULACIÓN DE PRESTAMO");
            return;
        }
        if (this.frmLlamador.equals("NovedadesNomina")) {
            setTitle("ANULACIÓN DE NOVEDADES");
        } else if (this.frmLlamador.equals("jpi_atencionEnfermeria")) {
            setTitle("ANULACIÓN DE ATENCIONES");
        } else if (this.frmLlamador.equals("citologiaPyP")) {
            setTitle("ANULACIÓN DE RESULTADO DE CITOLOGIA");
        }
    }

    private void buscarUsuario() {
        this.sql = "SELECT w_persona.Id_persona, w_persona.NUsuario, g_usuario_sist.Clave FROM  w_persona INNER JOIN  g_usuario_sist ON (w_persona.Id_persona = g_usuario_sist.Id_Persona) WHERE (g_usuario_sist.Login ='" + this.txtLogin.getText() + "' AND g_usuario_sist.Estado =0 AND g_usuario_sist.Anular =1)";
        System.out.println("" + this.sql);
        this.rs = this.consultas.traerRs(this.sql);
        try {
            if (this.rs.next()) {
                this.txtNombre.setText(this.rs.getString(2));
                this.clave = this.rs.getString(3);
                this.rs.close();
                this.consultas.cerrarConexionBd();
            } else {
                this.metodos.mostrarMensaje("El Nombre de Usuario no existe");
                this.txtLogin.setText("");
                this.txtClave.setText("");
                this.txtNombre.setText("");
                this.clave = "";
                mCrearModelo();
            }
            this.rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    private void mCrearModelo() {
        this.modelo = new DefaultTableModel() { // from class: General.Anular.4
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.modelo.addColumn("");
        this.modelo.addColumn("Nombre");
        this.grid.setModel(this.modelo);
        this.grid.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(0).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(0).setMinWidth(0);
        this.grid.getColumnModel().getColumn(1).setPreferredWidth(100);
    }

    private void crearGrid() {
        this.sql = "SELECT Id, Nbre FROM g_motivoanulacion WHERE (Modulo ='" + this.xmodulo + "' AND Estado =0) ORDER BY Nbre ASC";
        mCrearModelo();
        System.out.println(this.sql);
        try {
            this.rs = this.consultas.traerRs(this.sql);
            this.filaGrid = 0;
            while (this.rs.next()) {
                this.modelo.addRow(this.dato);
                this.modelo.setValueAt(this.rs.getString(1), this.filaGrid, 0);
                this.modelo.setValueAt(this.rs.getString(2), this.filaGrid, 1);
                this.filaGrid++;
            }
            this.filaGrid = 0;
            this.rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    private void desistir() {
        if (!this.txtDetalle.getText().isEmpty()) {
            this.clic++;
            System.err.println(this.frmLlamador);
            if (this.clic == 1) {
                if (this.frmLlamador.equals("Citas")) {
                    Principal.clasescita.desistirCita(this.txtDetalle.getText(), this.modelo.getValueAt(this.filaGrid, 0).toString(), Principal.clasescita.frmCita.listaProfesional[Principal.clasescita.frmCita.filaArbol][0]);
                } else if (this.frmLlamador.equals("CitaNP")) {
                    Principal.clasescita.frmCitaNP.desistirCita(this.modelo.getValueAt(this.filaGrid, 1).toString(), this.modelo.getValueAt(this.filaGrid, 0).toString());
                } else if (this.frmLlamador.equals("CitaTerapia")) {
                    Principal.clasescita.desistirCita(this.txtDetalle.getText(), this.modelo.getValueAt(this.filaGrid, 0).toString(), Principal.clasescita.frmCitaTerapia.listaProfesional[Principal.clasescita.frmCitaTerapia.filaArbol][0]);
                } else if (this.frmLlamador.equals("CitaInterconsulta")) {
                    Principal.clasescita.desistirCita(this.txtDetalle.getText(), this.modelo.getValueAt(this.filaGrid, 0).toString(), Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString());
                } else if (this.frmLlamador.equals("Atencion")) {
                    Principal.claseenfer.frmAtencion.anularServicios(this.modelo.getValueAt(this.filaGrid, 0).toString());
                } else if (this.frmLlamador.equals("Egreso") || this.frmLlamador.equals("Egreso")) {
                    Principal.clasefacturacion.frmFacturac.frmEgreso.anular();
                } else if (this.frmLlamador.equals("Consolidado")) {
                    Principal.clasefacturacion.frmFacturac.frmc.AnularFacturayLiq(this.modelo.getValueAt(this.filaGrid, 0).toString(), this.modelo.getValueAt(this.filaGrid, 1).toString(), this.txtDetalle.getText());
                } else if (this.frmLlamador.equals("Anular Respuesta Glosa")) {
                    Principal.xclasegc.xjifgestioncartera.mAnular_RGlosa(this.modelo.getValueAt(this.filaGrid, 0).toString(), this.modelo.getValueAt(this.filaGrid, 1).toString(), this.txtDetalle.getText());
                } else if (this.frmLlamador.equals("Respuesta Glosa")) {
                    Principal.xclasegc.xjifgestioncartera.mAnular_Glosa(this.modelo.getValueAt(this.filaGrid, 0).toString(), this.modelo.getValueAt(this.filaGrid, 1).toString(), this.txtDetalle.getText());
                } else if (this.frmLlamador.equals("Ingreso")) {
                    if (getForma().intValue() == 1) {
                        Principal.clasefacturacion.anularLiquidacionMasivamente(this.modelo.getValueAt(this.filaGrid, 0).toString(), this.modelo.getValueAt(this.filaGrid, 1).toString(), this.txtDetalle.getText(), Principal.clasefacturacion.frmFacturac.frmIngreso.getIdLiquidacion(), Principal.clasefacturacion.frmFacturac.frmIngreso.getIdFacturaCapita(), Principal.clasefacturacion.frmFacturac.frmIngreso.getIdFacturaEvento());
                        Principal.clasefacturacion.frmFacturac.frmOrdenes.anular(this.modelo.getValueAt(this.filaGrid, 0).toString(), this.txtDetalle.getText(), getForma());
                        Principal.clasefacturacion.frmFacturac.frmIngreso.anular(this.modelo.getValueAt(this.filaGrid, 0).toString(), this.txtDetalle.getText());
                    } else {
                        Principal.clasefacturacion.frmFacturac.frmIngreso.anular(this.modelo.getValueAt(this.filaGrid, 0).toString(), this.txtDetalle.getText());
                    }
                } else if (this.frmLlamador.equals("Ordenes")) {
                    Principal.clasefacturacion.frmFacturac.frmOrdenes.anular(this.modelo.getValueAt(this.filaGrid, 0).toString(), this.txtDetalle.getText(), getForma());
                } else if (this.frmLlamador.equals("xjpglosaRespuestas")) {
                    Principal.clasefacturacion.xjiliqServicio.xJPGlosa.mAnular_RGlosa(this.modelo.getValueAt(this.filaGrid, 0).toString(), this.modelo.getValueAt(this.filaGrid, 1).toString(), this.txtDetalle.getText());
                } else if (this.frmLlamador.equals("xjpglosa")) {
                    Principal.clasefacturacion.xjiliqServicio.xJPGlosa.mAnular_Glosa(this.modelo.getValueAt(this.filaGrid, 0).toString(), this.modelo.getValueAt(this.filaGrid, 1).toString(), this.txtDetalle.getText());
                } else if (this.frmLlamador.equals("Entradas")) {
                    Principal.xClaseInventario.frmEntrada.anularEntrada(this.modelo.getValueAt(this.filaGrid, 0).toString());
                } else if (this.frmLlamador.equals("Despachos")) {
                    Principal.xClaseInventario.frmDespacho.anularDespacho(this.modelo.getValueAt(this.filaGrid, 0).toString(), this.txtDetalle.getText());
                } else if (this.frmLlamador.equals("Salidas")) {
                    Principal.xClaseInventario.frmSalida.anularSalida(this.modelo.getValueAt(this.filaGrid, 0).toString());
                } else if (this.frmLlamador.equals("ITraslados")) {
                    Principal.xClaseInventario.frmTraslado.anularTraslado(this.modelo.getValueAt(this.filaGrid, 0).toString());
                } else if (this.frmLlamador.equals("Faltantes")) {
                    Principal.xClaseInventario.frmFaltante.anularFaltante(this.modelo.getValueAt(this.filaGrid, 0).toString());
                } else if (this.frmLlamador.equals("Recepcion")) {
                    Principal.claselab.frmRecep.anularOrden(this.modelo.getValueAt(this.filaGrid, 0).toString());
                } else if (this.frmLlamador.equals("TomaManual")) {
                    Principal.claselab.frmRecepManual.anularOrden(this.modelo.getValueAt(this.filaGrid, 0).toString());
                } else if (this.frmLlamador.equals("TipoResultado")) {
                    Principal.claselab.frmTipoRes.anularTipo(this.modelo.getValueAt(this.filaGrid, 0).toString());
                } else if (this.frmLlamador.equals("ResultadoManual")) {
                    Principal.claselab.frmResultManual.anularRegistro(this.modelo.getValueAt(this.filaGrid, 0).toString());
                } else if (this.frmLlamador.equals("Caja")) {
                    Principal.clasecaja.anularRecibo(this.modelo.getValueAt(this.filaGrid, 0).toString(), this.txtDetalle.getText());
                } else if (this.frmLlamador.equals("Contabilidad")) {
                    Principal.xclase.xjifdoccontable.mAnularC(this.modelo.getValueAt(this.filaGrid, 0).toString(), this.txtDetalle.getText());
                } else if (this.frmLlamador.equals("Radicacion")) {
                    Principal.xclase.xjifradicacion.mAnularRadicacion(this.modelo.getValueAt(this.filaGrid, 0).toString(), this.txtDetalle.getText());
                } else if (this.frmLlamador.equals("Factura Interna")) {
                    Principal.xclase.xjifradicacion.mAnularFacInterna(this.modelo.getValueAt(this.filaGrid, 0).toString(), this.txtDetalle.getText());
                } else if (this.frmLlamador.equals("Factura_Radicacion")) {
                    Principal.xclase.xjifradicacion.mAnularFactura_Radicacion(this.modelo.getValueAt(this.filaGrid, 0).toString(), this.txtDetalle.getText());
                } else if (this.frmLlamador.equals("Liquidacion_Radicacion")) {
                    Principal.xclase.xjifcomprobante.mAnularDoc(this.modelo.getValueAt(this.filaGrid, 0).toString(), this.txtDetalle.getText());
                } else if (this.frmLlamador.equals("SeguimientosSo")) {
                    Principal.xclaseso.xjifseguimientosve.mAnular(this.modelo.getValueAt(this.filaGrid, 1).toString(), this.txtDetalle.getText());
                } else if (this.frmLlamador.equals("Recibo Caja")) {
                    Principal.clasefacturacion.frmFacturac.frmOrdenes.xJp_RCaja.mAnular(this.modelo.getValueAt(this.filaGrid, 0).toString(), this.txtDetalle.getText());
                } else if (this.frmLlamador.equals("FacturacionUH")) {
                    Principal.clasefacturacion.xjiliqServicio.xjpprocedimiento.mAnular(this.modelo.getValueAt(this.filaGrid, 0).toString(), this.txtDetalle.getText());
                } else if (this.frmLlamador.equals("FacturacionUH_Egreso")) {
                    Principal.clasefacturacion.xjiliqServicio.xJPEgresoUrgencias.mAnular(this.modelo.getValueAt(this.filaGrid, 0).toString(), this.txtDetalle.getText());
                } else if (this.frmLlamador.equals("Liquidacion_N")) {
                    Principal.clasefacturacion.xjiliqServicio.xjpconsolidado.mAnular(this.modelo.getValueAt(this.filaGrid, 0).toString(), this.modelo.getValueAt(this.filaGrid, 1).toString(), this.txtDetalle.getText());
                } else if (this.frmLlamador.equals("xjifautorizacion_servicios")) {
                    Principal.clasefacturacion.xjifautorizacion_servicio.mAnular(this.modelo.getValueAt(this.filaGrid, 0).toString(), this.modelo.getValueAt(this.filaGrid, 1).toString(), this.txtDetalle.getText());
                } else if (this.frmLlamador.equals("FacturacionQX")) {
                    Principal.clasefacturacion.xjiliqServicio.xJPQuirurgico.mAnular(this.modelo.getValueAt(this.filaGrid, 0).toString(), this.txtDetalle.getText());
                } else if (this.frmLlamador.equals("CIRUGÍA")) {
                    Principal.xclaseCirugia.xjif_progracion_cx.mAnularC(this.modelo.getValueAt(this.filaGrid, 0).toString(), this.txtDetalle.getText());
                } else if (this.frmLlamador.equals("jifconsultarcuentacobroempresa")) {
                    Principal.xclasegc.xjifconsultarcuentas.mAnular(this.modelo.getValueAt(this.filaGrid, 0).toString(), this.modelo.getValueAt(this.filaGrid, 1).toString(), this.txtDetalle.getText());
                } else if (this.frmLlamador.equals("GESTIÓN EVENTO")) {
                    this.xAnalisEvento.mAnular(this.modelo.getValueAt(this.filaGrid, 0).toString(), this.txtDetalle.getText());
                } else if (this.frmLlamador.equals("ANÁLISIS EVENTO ADVERSO")) {
                    Principal.xclasesgc.xJIFF_SC_EventoAdversoAnalisis.mAnular(this.modelo.getValueAt(this.filaGrid, 0).toString(), this.txtDetalle.getText());
                } else if (this.frmLlamador.equals("PP_MoviManualesIngresos")) {
                    Principal.xclasePresupuesto.xJIFFMovimientoManual.mAnular_Registro(this.modelo.getValueAt(this.filaGrid, 0).toString(), this.txtDetalle.getText());
                } else if (this.frmLlamador.equals("PP_Solicitud")) {
                    Principal.xclasePresupuesto.xJIFFSolicitudPTO.mAnular_Registro(this.modelo.getValueAt(this.filaGrid, 0).toString(), this.txtDetalle.getText());
                } else if (this.frmLlamador.equals("PP_Solicitudv2")) {
                    Principal.xclasePresupuesto.xJIFFSolicitudPTO_v2.mAnular_Registro(this.modelo.getValueAt(this.filaGrid, 0).toString(), this.txtDetalle.getText());
                } else if (this.frmLlamador.equals("PP_MovimientosP")) {
                    Principal.xclasePresupuesto.xJIFFMovimiento.mAnular_Registro(this.modelo.getValueAt(this.filaGrid, 0).toString(), this.txtDetalle.getText());
                } else if (this.frmLlamador.equals("PP_Anula_MovimientosP")) {
                    Principal.xclasePresupuesto.xJIFAnularDocumento.mAnular_Registro(this.modelo.getValueAt(this.filaGrid, 0).toString(), this.txtDetalle.getText());
                } else if (this.frmLlamador.equals("Causación Nomina")) {
                    Principal.claserecursoshumanos.xJif_CausacionNomina.mAnular(this.modelo.getValueAt(this.filaGrid, 0).toString(), this.txtDetalle.getText());
                } else if (this.frmLlamador.equals("Orden Compra")) {
                    Principal.clasecomprabn.xjifcomprasbs.mAnular(this.modelo.getValueAt(this.filaGrid, 0).toString(), this.txtDetalle.getText());
                } else if (this.frmLlamador.equals("Requisicion")) {
                    Principal.clasecomprabn.xjifrequisicion.mAnular(this.modelo.getValueAt(this.filaGrid, 0).toString(), this.txtDetalle.getText());
                } else if (this.frmLlamador.equals("Consultar Cuenta de Cobro")) {
                    Principal.xclase.xJIFConsultarCuentaCobro.mAnularC(this.modelo.getValueAt(this.filaGrid, 0).toString(), this.txtDetalle.getText());
                } else if (this.frmLlamador.equals("GESTIÓN DE PAGOS")) {
                    Principal.xclasegc.xJifPagosGrupales.mAnular(this.modelo.getValueAt(this.filaGrid, 0).toString(), this.txtDetalle.getText());
                } else if (this.frmLlamador.equals("xjpIngresoSeguimientos")) {
                    Principal.clasefacturacion.xjiliqServicio.xJPIngresoSeguimientos.mAnular_Seguimiento(this.modelo.getValueAt(this.filaGrid, 0).toString(), this.modelo.getValueAt(this.filaGrid, 1).toString(), this.txtDetalle.getText());
                } else if (this.frmLlamador.equals("ORDEN_SALIDA")) {
                    Principal.clasefacturacion.xjiliqServicio.xJPOrdenSalidaIngreso.anular(this.txtDetalle.getText());
                } else if (this.frmLlamador.equals("SALIDA ADMINISTRATIVA")) {
                    Principal.clasefacturacion.xjiliqServicio.ingresoSalidaAdministrativa.anularDetalle(this.txtDetalle.getText(), this.modelo.getValueAt(this.filaGrid, 1).toString());
                } else if (this.frmLlamador.equals("ANULACIÓN DE ANEXO TECNICO 1")) {
                    Principal.clasefacturacion.xjiliqServicio.formularioAnexo1.anularDetalle(this.modelo.getValueAt(this.filaGrid, 1).toString(), this.txtDetalle.getText());
                } else if (this.frmLlamador.equals("xjphojatratamiento")) {
                    Principal.claseenfer.xjifhc_uhh.xJPHojaTratamiento.mAnularSuministro();
                } else if (this.frmLlamador.equals("xjphojatratamiento1")) {
                    Principal.clasefacturacion.xjiliqServicio.xJPHojaTratamiento.mAnularSuministro();
                } else if (this.frmLlamador.equals("jpcontroldiabetes")) {
                    Principal.claseenfer.xjifhc_uhh.xJPControlDiabetes.mAnular(this.modelo.getValueAt(this.filaGrid, 0).toString(), this.txtDetalle.getText());
                } else if (this.frmLlamador.equals("JPAEventoECastPacienteGasto")) {
                    Principal.clasefacturacion.xjiliqServicio.jPAEventoECastPacienteGasto.anular(this.modelo.getValueAt(this.filaGrid, 0).toString(), this.txtDetalle.getText());
                } else if (this.frmLlamador.equals("Caja Egreso")) {
                    Principal.clasecaja.xJIFRecibosEgresos.anularRecibo(this.modelo.getValueAt(this.filaGrid, 1).toString(), this.txtDetalle.getText());
                } else if (this.frmLlamador.equals("Cierre Caja")) {
                    Principal.clasecaja.frmCierre.anularCierre(this.modelo.getValueAt(this.filaGrid, 1).toString(), this.txtDetalle.getText());
                } else if (this.frmLlamador.equals("Registro de Recibos")) {
                    Principal.clascajamenor.xjifregistrorecibos.mAnular(this.modelo.getValueAt(this.filaGrid, 0).toString(), this.txtDetalle.getText());
                } else if (this.frmLlamador.equals("Radiologia")) {
                    Principal.claseimagendx.xjifrecepcion.anularOrden(this.modelo.getValueAt(this.filaGrid, 0).toString());
                } else if (this.frmLlamador.equals("Factura Interna Nueva")) {
                    JDFacturaEquivalente e = (JDFacturaEquivalente) this.jDialog;
                    e.anularDocumento(this.modelo.getValueAt(this.filaGrid, 0).toString(), this.txtDetalle.getText());
                } else if (this.frmLlamador.equals("Cierre Recibo Egreso")) {
                    Principal.clasecaja.xJIFCierreEgresos.anularCierre(this.modelo.getValueAt(this.filaGrid, 1).toString(), this.txtDetalle.getText());
                } else if (this.frmLlamador.equals("jifSolicitudPedidoInterno")) {
                    Principal.clasegeneral.solicitudPedidoInterno.anularBase(this.modelo.getValueAt(this.filaGrid, 1).toString(), this.txtDetalle.getText());
                } else if (this.frmLlamador.equals("jifsolicitud_new")) {
                    Principal.xclasePresupuesto.jifsolicitud_new.mAnular_Registro(this.modelo.getValueAt(this.filaGrid, 0).toString(), this.txtDetalle.getText());
                } else if (this.frmLlamador.equals("jiffmovimiento_new")) {
                    Principal.xclasePresupuesto.jIFFMovimiento_new.mAnular_Registro(this.modelo.getValueAt(this.filaGrid, 0).toString(), this.txtDetalle.getText());
                } else if (this.frmLlamador.equals("jifcompromiso_presupuestal")) {
                    Principal.xclasePresupuesto.jifcompromisopresupuestal.mAnular_Registro(this.modelo.getValueAt(this.filaGrid, 0).toString(), this.txtDetalle.getText());
                } else if (this.frmLlamador.equals("jpi_atencionEnfermeria")) {
                    Principal.claseenfer.xjifhc_uhh.atencionEnfermeria.anularDatos(this.modelo.getValueAt(this.filaGrid, 1).toString(), this.txtDetalle.getText());
                } else if (this.frmLlamador.equals("jifbitacora")) {
                    Principal.clasegeneral.jifbitacora.anularDatos(this.modelo.getValueAt(this.filaGrid, 1).toString(), this.txtDetalle.getText());
                } else if (this.frmLlamador.equals("jifSolicitudPedidoInterno")) {
                    Principal.clasegeneral.solicitudPedidoInterno.anularBase(this.modelo.getValueAt(this.filaGrid, 1).toString(), this.txtDetalle.getText());
                } else if (this.frmLlamador.equals("Prestamo")) {
                    Principal.claserecursoshumanos.xJIFPrestamos.anularBase(this.modelo.getValueAt(this.filaGrid, 1).toString(), this.txtDetalle.getText());
                } else if (this.frmLlamador.equals("NovedadesNomina")) {
                    if (Principal.claserecursoshumanos != null) {
                        Principal.claserecursoshumanos.xJIFNovedadesNomina.anularBase(this.modelo.getValueAt(this.filaGrid, 1).toString(), this.txtDetalle.getText());
                    }
                    if (Principal.clasegeneral != null) {
                        Principal.clasegeneral.xJIFNovedadesNomina.anularBase(this.modelo.getValueAt(this.filaGrid, 1).toString(), this.txtDetalle.getText());
                    }
                } else if (this.frmLlamador.equals("citologiaPyP") && Principal.clasepyp != null) {
                    Principal.clasepyp.frmToma.anularResultado(this.modelo.getValueAt(this.filaGrid, 1).toString(), this.txtDetalle.getText());
                }
            }
            this.consultas.cerrarConexionBd();
            dispose();
            return;
        }
        JOptionPane.showMessageDialog(this, "La observación no puede ser nula", "VALIDAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.txtDetalle.requestFocus();
    }

    private void validarClave() {
        if (this.clave.equals(this.metodos.getEncryptedPassword(new String(this.txtClave.getPassword()))) && !this.txtNombre.getText().isEmpty()) {
            this.grid.setEnabled(true);
            this.txtDetalle.setEnabled(true);
            this.btnOk.setEnabled(true);
            crearGrid();
            return;
        }
        mCrearModelo();
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.jPanel1 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.grid = new JTable();
        this.jScrollPane2 = new JScrollPane();
        this.lblDetalle = new JTextPane();
        this.jScrollPane3 = new JScrollPane();
        this.txtDetalle = new JTextArea();
        this.jPanel2 = new JPanel();
        this.txtLogin = new JTextField();
        this.txtNombre = new JTextField();
        this.txtClave = new JPasswordField();
        this.btnOk = new JButton();
        this.btnCancelar = new JButton();
        setDefaultCloseOperation(2);
        setTitle("Anulación");
        setMinimumSize(new Dimension(690, 552));
        setName("Anular");
        this.jPanel1.setBorder(BorderFactory.createEtchedBorder());
        this.jPanel1.setName("panelFondo");
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "MOTIVO DE DESISTENCIA DE CITAS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.grid.setFont(new Font("Arial", 1, 12));
        this.grid.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.grid.setRowHeight(25);
        this.grid.setSelectionBackground(new Color(255, 255, 255));
        this.grid.setSelectionForeground(new Color(255, 0, 0));
        this.grid.setSelectionMode(0);
        this.jScrollPane1.setViewportView(this.grid);
        this.lblDetalle.setEditable(false);
        this.lblDetalle.setFont(new Font("Arial", 1, 12));
        this.lblDetalle.setForeground(new Color(255, 0, 0));
        this.lblDetalle.setText("Si usted no esta autorizado para realizar esta ANULACIÓN, por favor no continué con este proceso.");
        this.jScrollPane2.setViewportView(this.lblDetalle);
        this.jScrollPane3.setBorder(BorderFactory.createTitledBorder((Border) null, "OBSERVACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.txtDetalle.setColumns(20);
        this.txtDetalle.setRows(5);
        this.txtDetalle.setEnabled(false);
        this.jScrollPane3.setViewportView(this.txtDetalle);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jScrollPane1, GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane3, GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane2, GroupLayout.Alignment.LEADING, -1, 648, 32767)).addGap(14, 14, 14)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -2, 170, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane3, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane2, -2, 33, -2).addContainerGap(22, 32767)));
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "USUARIO AUTORIZADO PARA ANULAR", 0, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.txtLogin.setFont(new Font("Arial", 1, 12));
        this.txtLogin.setBorder(BorderFactory.createTitledBorder((Border) null, "Usuario", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtLogin.addFocusListener(new FocusAdapter() { // from class: General.Anular.5
            public void focusLost(FocusEvent evt) {
                Anular.this.txtLoginFocusLost(evt);
            }
        });
        this.txtLogin.addActionListener(new ActionListener() { // from class: General.Anular.6
            public void actionPerformed(ActionEvent evt) {
                Anular.this.txtLoginActionPerformed(evt);
            }
        });
        this.txtNombre.setFont(new Font("Arial", 1, 12));
        this.txtNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre de Usuario Autorizado", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtNombre.setDisabledTextColor(new Color(0, 0, 0));
        this.txtNombre.setEnabled(false);
        this.txtClave.setToolTipText("Contraseña");
        this.txtClave.setBorder(BorderFactory.createTitledBorder((Border) null, "Clave", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtClave.addFocusListener(new FocusAdapter() { // from class: General.Anular.7
            public void focusLost(FocusEvent evt) {
                Anular.this.txtClaveFocusLost(evt);
            }
        });
        this.txtClave.addKeyListener(new KeyAdapter() { // from class: General.Anular.8
            public void keyPressed(KeyEvent evt) {
                Anular.this.txtClaveKeyPressed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.txtLogin, -2, 140, -2).addGap(12, 12, 12).addComponent(this.txtClave, -2, 140, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.txtNombre, -2, 340, -2).addContainerGap(-1, 32767)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtLogin, -2, 50, -2).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtClave, -2, 50, -2).addComponent(this.txtNombre, -2, 50, -2))).addGap(23, 23, 23)));
        this.btnOk.setFont(new Font("Arial", 1, 12));
        this.btnOk.setForeground(new Color(0, 0, 153));
        this.btnOk.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.btnOk.setText("Ok");
        this.btnOk.setEnabled(false);
        this.btnOk.addActionListener(new ActionListener() { // from class: General.Anular.9
            public void actionPerformed(ActionEvent evt) {
                Anular.this.btnOkActionPerformed(evt);
            }
        });
        this.btnCancelar.setFont(new Font("Arial", 1, 12));
        this.btnCancelar.setForeground(new Color(0, 0, 153));
        this.btnCancelar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.btnCancelar.setText("Cancelar");
        this.btnCancelar.addActionListener(new ActionListener() { // from class: General.Anular.10
            public void actionPerformed(ActionEvent evt) {
                Anular.this.btnCancelarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel2, -2, -1, -2).addComponent(this.jPanel1, -2, -1, -2).addGroup(layout.createSequentialGroup().addComponent(this.btnOk, -2, 230, -2).addGap(212, 212, 212).addComponent(this.btnCancelar, -2, 230, -2))).addContainerGap(16, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(8, 8, 8).addComponent(this.jPanel2, -2, 90, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btnOk, -2, 50, -2).addComponent(this.btnCancelar, -2, 50, -2)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnCancelarActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnOkActionPerformed(ActionEvent evt) {
        desistir();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtLoginActionPerformed(ActionEvent evt) {
        this.txtClave.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtLoginFocusLost(FocusEvent evt) {
        buscarUsuario();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtClaveKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 40 || evt.getKeyCode() == 10 || evt.getKeyCode() == 38) {
            validarClave();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtClaveFocusLost(FocusEvent evt) {
        validarClave();
    }
}
