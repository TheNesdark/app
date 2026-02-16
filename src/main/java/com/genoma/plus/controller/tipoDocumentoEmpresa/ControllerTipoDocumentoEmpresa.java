package com.genoma.plus.controller.tipoDocumentoEmpresa;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.TipoDocumentoEmpresaDTO;
import com.genoma.plus.jpa.projection.ITipoDocumentoEmpresa;
import com.genoma.plus.jpa.projection.ITipoDocumentoEmpresaComboBoxDTO;
import com.genoma.plus.jpa.service.ITipoDocumentoEmpresaService;
import com.genoma.plus.jpa.service.impl.TipoDocumentoEmpresaServiceImpl;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/tipoDocumentoEmpresa/ControllerTipoDocumentoEmpresa.class */
public class ControllerTipoDocumentoEmpresa {
    VistaTipoDocumentoEmpresa vista;
    TipoDocumentoEmpresaServiceImpl service;
    TipoDocumentoEmpresaDTO tipoDocumentoEmpresaDTO;
    private DefaultTableModel xmodelo;
    private Object[] xDato;
    private byte[] pdfACargar;
    private String rutaArchivoACargar;
    Long idEmpresa;
    Long idPersonaCargo;
    String nombreEmpresa;
    String nombreUsuario;
    List<ITipoDocumentoEmpresaComboBoxDTO> listaTipoDocumentosConDiasVencimiento;
    List<ITipoDocumentoEmpresa> listaTipoDocumentosSubidosPorEmpresa;
    private final ITipoDocumentoEmpresaService xITipoDocumentoEmpresaService = (ITipoDocumentoEmpresaService) Principal.contexto.getBean(ITipoDocumentoEmpresaService.class);
    private Metodos xmt = new Metodos();

    public ControllerTipoDocumentoEmpresa(final VistaTipoDocumentoEmpresa vista, TipoDocumentoEmpresaServiceImpl service, Long idEmpresa, String nombreEmpresa, Long idPersonaCargo, String nombreUsuario) {
        this.vista = vista;
        this.service = service;
        this.idEmpresa = idEmpresa;
        this.idPersonaCargo = idPersonaCargo;
        this.nombreEmpresa = nombreEmpresa;
        this.nombreUsuario = nombreUsuario;
        Principal.cargarPantalla(vista);
        this.listaTipoDocumentosSubidosPorEmpresa = this.xITipoDocumentoEmpresaService.listaTipoDocumentoEmpresa(this.idEmpresa);
        this.listaTipoDocumentosConDiasVencimiento = this.xITipoDocumentoEmpresaService.listaTipoDocumentoEmpresaConDiasVenc();
        vista.lblEmpresa.setText(idEmpresa + " " + nombreEmpresa);
        vista.lblUsuario.setText(idPersonaCargo + " " + nombreUsuario);
        vista.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.tipoDocumentoEmpresa.ControllerTipoDocumentoEmpresa.1
            public void mouseClicked(MouseEvent evt) {
                ControllerTipoDocumentoEmpresa.this.JTFRutaMouseClicked(evt);
            }
        });
        vista.JBTCargar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.tipoDocumentoEmpresa.ControllerTipoDocumentoEmpresa.2
            public void actionPerformed(ActionEvent evt) {
                ControllerTipoDocumentoEmpresa.this.JBTCargarActionPerformed(evt);
            }
        });
        vista.JBTActivar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.tipoDocumentoEmpresa.ControllerTipoDocumentoEmpresa.3
            public void actionPerformed(ActionEvent evt) {
                ControllerTipoDocumentoEmpresa.this.JBTActivarActionPerformed(evt);
            }
        });
        vista.JCB_TipoDocumento.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.tipoDocumentoEmpresa.ControllerTipoDocumentoEmpresa.4
            public void itemStateChanged(ItemEvent evt) {
                ControllerTipoDocumentoEmpresa.this.JCB_TipoDocumentoItemStateChanged(evt);
            }
        });
        vista.JTB_Detalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.tipoDocumentoEmpresa.ControllerTipoDocumentoEmpresa.5
            public void mouseClicked(MouseEvent e) {
                int fila = vista.JTB_Detalle.rowAtPoint(e.getPoint());
                int columna = vista.JTB_Detalle.columnAtPoint(e.getPoint());
                if (vista.JTB_Detalle.getModel().getColumnClass(columna).equals(JButton.class)) {
                    ControllerTipoDocumentoEmpresa.this.xmt.AbrirArchivosblob(ControllerTipoDocumentoEmpresa.this.listaTipoDocumentosSubidosPorEmpresa.get(fila).getSoporte(), "Soporte", ".pdf", true);
                }
            }
        });
        mnuevo(vista);
    }

    private void mOpenFile(byte[] byteArray) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.vista.JTFRuta.getText());
            xfilec.setFileSelectionMode(2);
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("*PDF", new String[]{"pdf"});
            xfilec.setFileFilter(filtro);
            int xv = xfilec.showOpenDialog(this.vista);
            if (xv == 0) {
                File xfile = xfilec.getSelectedFile();
                this.vista.JTFRuta.setText(xfile.getAbsolutePath());
                this.vista.JBTCargar.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCargarActionPerformed(ActionEvent evt) {
        if (laRutaEnlaVistaNoDebeSerVacia(this.vista.JTFRuta.getText()) && diasVencimientoEnLaVistaDebeSerEnteroNoNuloMayorOIgualQueCero(this.vista.JTFDiasVenc.getText()) && validarFecha() && this.vista.JCB_TipoDocumento.getSelectedIndex() >= 0 && elementosComboBoxEnVistaCorrespondenAListaEnMemoria(this.listaTipoDocumentosConDiasVencimiento, this.vista.JCB_TipoDocumento) && validarItemSeleccionadoEnComboBoxCorrespondeAAlmacenadoEnLista(this.listaTipoDocumentosConDiasVencimiento, this.vista.JCB_TipoDocumento.getSelectedIndex(), this.vista.JCB_TipoDocumento.getSelectedItem().toString())) {
            System.err.println("voy a validar el convertir archivo");
            System.err.println("ruta archivo a Cargar premetodo validar " + this.rutaArchivoACargar);
            System.err.println("valor vista " + this.vista.JTFRuta.getText());
            if (elTipoDocumentoYaSeEncuentraActivo(this.listaTipoDocumentosConDiasVencimiento.get(this.vista.JCB_TipoDocumento.getSelectedIndex()).getId())) {
                JOptionPane.showMessageDialog(this.vista, "Para esta empresa ya se cargó y se encuentra activo este tipo de documento, por favor, desactivelo para cargar uno nuevo");
                return;
            }
            if (validarConvertirArchivoACargarEnByteArray(this.vista.JTFRuta.getText())) {
                this.rutaArchivoACargar = this.vista.JTFRuta.getText();
                try {
                    this.pdfACargar = convertirArchivoACargarEnByteArray(this.rutaArchivoACargar);
                } catch (Exception e) {
                    this.pdfACargar = null;
                    JOptionPane.showMessageDialog(this.vista, "Deba cargar un archivo pdf valido");
                }
                if (this.pdfACargar != null) {
                    System.err.println("llenare dto");
                    this.tipoDocumentoEmpresaDTO = new TipoDocumentoEmpresaDTO();
                    this.tipoDocumentoEmpresaDTO.setFechaDocumento(this.vista.JDCFechaDoc.getDate());
                    this.tipoDocumentoEmpresaDTO.setIdEmpresa(this.idEmpresa.longValue());
                    this.tipoDocumentoEmpresaDTO.setIdTipoDocumento(this.listaTipoDocumentosConDiasVencimiento.get(this.vista.JCB_TipoDocumento.getSelectedIndex()).getId());
                    this.tipoDocumentoEmpresaDTO.setSoporte(this.pdfACargar);
                    this.tipoDocumentoEmpresaDTO.setObservacion(this.vista.JTxtObservacion.getText());
                    this.tipoDocumentoEmpresaDTO.setDias(Long.parseLong(this.vista.JTFDiasVenc.getText()));
                    this.tipoDocumentoEmpresaDTO.setEstado(true);
                    this.tipoDocumentoEmpresaDTO.setIdPersonaCargo(this.idPersonaCargo.longValue());
                    int n = JOptionPane.showInternalConfirmDialog(this.vista, "¿Esta seguro de cargar el documento?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        try {
                            this.xITipoDocumentoEmpresaService.grabar(this.tipoDocumentoEmpresaDTO);
                            JOptionPane.showMessageDialog(this.vista, "¡Documento cargado con exito!");
                            mnuevo(this.vista);
                            return;
                        } catch (Exception e2) {
                            JOptionPane.showMessageDialog(this.vista, "¡Error al cargar documento!");
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            JOptionPane.showMessageDialog(this.vista, "Deba cargar un archivo pdf valido");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTActivarActionPerformed(ActionEvent evt) {
        if (this.vista.JTB_Detalle.getSelectedRow() > -1 && this.listaTipoDocumentosSubidosPorEmpresa.size() > 0) {
            if (this.vista.JTB_Detalle.getValueAt(this.vista.JTB_Detalle.getSelectedRow(), 0).equals(Long.valueOf(this.listaTipoDocumentosSubidosPorEmpresa.get(this.vista.JTB_Detalle.getSelectedRow()).getId()))) {
                if (this.listaTipoDocumentosSubidosPorEmpresa.get(this.vista.JTB_Detalle.getSelectedRow()).getActivo()) {
                    boolean rpta = mActualizarActivo(this.listaTipoDocumentosSubidosPorEmpresa.get(this.vista.JTB_Detalle.getSelectedRow()).getId(), false);
                    if (rpta) {
                        JOptionPane.showMessageDialog(this.vista, "¡Documento Desactivado!");
                        mnuevo(this.vista);
                        return;
                    } else {
                        JOptionPane.showMessageDialog(this.vista, "¡Error al desactivar documento!");
                        return;
                    }
                }
                boolean rpta2 = mActualizarActivo(this.listaTipoDocumentosSubidosPorEmpresa.get(this.vista.JTB_Detalle.getSelectedRow()).getId(), true);
                if (rpta2) {
                    JOptionPane.showMessageDialog(this.vista, "¡Documento Activado!");
                    mnuevo(this.vista);
                    return;
                } else {
                    JOptionPane.showMessageDialog(this.vista, "¡Error al activar documento!");
                    return;
                }
            }
            System.err.println("El id de la tabla no corresponde al de la lista");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCB_TipoDocumentoItemStateChanged(ItemEvent evt) {
        if (this.vista.JCB_TipoDocumento.getSelectedIndex() > -1 && !this.listaTipoDocumentosConDiasVencimiento.isEmpty() && this.listaTipoDocumentosConDiasVencimiento != null) {
            this.vista.JTFDiasVenc.setText(this.listaTipoDocumentosConDiasVencimiento.get(this.vista.JCB_TipoDocumento.getSelectedIndex()).getNDias().toString());
        }
    }

    private boolean llenarComboBox(VistaTipoDocumentoEmpresa vista) {
        try {
            vista.JCB_TipoDocumento.removeAllItems();
            this.listaTipoDocumentosConDiasVencimiento = this.xITipoDocumentoEmpresaService.listaTipoDocumentoEmpresaConDiasVenc();
            if (!this.listaTipoDocumentosConDiasVencimiento.isEmpty() && this.listaTipoDocumentosConDiasVencimiento != null) {
                for (int i = 0; i < this.listaTipoDocumentosConDiasVencimiento.size(); i++) {
                    vista.JCB_TipoDocumento.addItem(this.listaTipoDocumentosConDiasVencimiento.get(i).getNbre());
                }
                return true;
            }
            System.err.println("lista combo box  vacia y/o  nula");
            return false;
        } catch (Exception e) {
            System.err.println("error llenar combobox");
            return false;
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private DefaultTableModel mCrearModeloTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha Doc", "Tipo Doc", "Soporte", "Observacion", "Dias", "Fecha Cargue", "Usuario Carga", "Activo", "Vencido"}) { // from class: com.genoma.plus.controller.tipoDocumentoEmpresa.ControllerTipoDocumentoEmpresa.6
            Class[] types = {String.class, String.class, String.class, JButton.class, String.class, String.class, String.class, String.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        return this.xmodelo;
    }

    private void mListarTipoDocumentosPorEmpresaEnTabla(JTable tabla) {
        tabla.setAutoResizeMode(0);
        tabla.doLayout();
        DefaultTableModel modeloTabla = mCrearModeloTabla();
        tabla.setModel(modeloTabla);
        tabla.setDefaultRenderer(Object.class, new TipoDocumentoEmpresaTablaRender());
        int cantColumnas = tabla.getColumnCount();
        for (int i = 0; i < cantColumnas - 1; i++) {
            tabla.getColumnModel().getColumn(i).setPreferredWidth(120);
        }
        tabla.getColumnModel().getColumn(0).setPreferredWidth(30);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(120);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(120);
        tabla.getColumnModel().getColumn(4).setPreferredWidth(150);
        this.xmt.mEstablecerTextEditor(tabla, 4);
        tabla.getColumnModel().getColumn(5).setPreferredWidth(30);
        tabla.getColumnModel().getColumn(6).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(7).setPreferredWidth(150);
        this.xmt.mEstablecerTextEditor(tabla, 7);
        tabla.getColumnModel().getColumn(8).setPreferredWidth(60);
        tabla.getColumnModel().getColumn(9).setPreferredWidth(60);
        try {
            try {
                this.listaTipoDocumentosSubidosPorEmpresa = this.xITipoDocumentoEmpresaService.listaTipoDocumentoEmpresa(this.idEmpresa);
                if (!this.listaTipoDocumentosSubidosPorEmpresa.isEmpty() && this.listaTipoDocumentosSubidosPorEmpresa != null) {
                    System.err.println("tamaño listaTipoDocumentos: " + this.listaTipoDocumentosSubidosPorEmpresa.size());
                    for (int i2 = 0; i2 < this.listaTipoDocumentosSubidosPorEmpresa.size(); i2++) {
                        modeloTabla.addRow(this.xDato);
                        modeloTabla.setValueAt(Long.valueOf(this.listaTipoDocumentosSubidosPorEmpresa.get(i2).getId()), i2, 0);
                        modeloTabla.setValueAt(this.listaTipoDocumentosSubidosPorEmpresa.get(i2).getFechaDocumento(), i2, 1);
                        modeloTabla.setValueAt(this.listaTipoDocumentosSubidosPorEmpresa.get(i2).getNbre(), i2, 2);
                        modeloTabla.setValueAt(new JButton("Abrir"), i2, 3);
                        modeloTabla.setValueAt(this.listaTipoDocumentosSubidosPorEmpresa.get(i2).getObservacion(), i2, 4);
                        modeloTabla.setValueAt(Long.valueOf(this.listaTipoDocumentosSubidosPorEmpresa.get(i2).getDias()), i2, 5);
                        modeloTabla.setValueAt(this.listaTipoDocumentosSubidosPorEmpresa.get(i2).getFecha(), i2, 6);
                        modeloTabla.setValueAt(this.listaTipoDocumentosSubidosPorEmpresa.get(i2).getPersonaCargo(), i2, 7);
                        modeloTabla.setValueAt(Boolean.valueOf(this.listaTipoDocumentosSubidosPorEmpresa.get(i2).getActivo()), i2, 8);
                        if (elDocumentoEstaVencido(this.listaTipoDocumentosSubidosPorEmpresa.get(i2).getFechaDocumento(), this.listaTipoDocumentosSubidosPorEmpresa.get(i2).getDias())) {
                            modeloTabla.setValueAt(true, i2, 9);
                        } else {
                            modeloTabla.setValueAt(false, i2, 9);
                        }
                    }
                } else {
                    System.err.println("lista tabla  vacia y/o  nula");
                }
                tabla.setDefaultRenderer(Object.class, new TipoDocumentoEmpresaTablaRender());
            } catch (Exception e) {
                System.err.println("error llenar tabla");
                e.printStackTrace();
                tabla.setDefaultRenderer(Object.class, new TipoDocumentoEmpresaTablaRender());
            }
        } catch (Throwable th) {
            tabla.setDefaultRenderer(Object.class, new TipoDocumentoEmpresaTablaRender());
            throw th;
        }
    }

    private void mnuevo(VistaTipoDocumentoEmpresa vista) {
        vista.JDCFechaDoc.setDate(this.xmt.getFechaActual());
        vista.JCB_TipoDocumento.removeAllItems();
        vista.JTFDiasVenc.setText("");
        vista.JTFRuta.setText("C:\\\\Genoma\\\\plantilla");
        vista.JTB_Detalle.removeAll();
        vista.JTxtObservacion.setText("");
        llenarComboBox(vista);
        mListarTipoDocumentosPorEmpresaEnTabla(vista.JTB_Detalle);
    }

    private boolean validarConvertirArchivoACargarEnByteArray(String rutaArchivo) {
        try {
            System.err.println("ruta: " + rutaArchivo);
            Path pdfPath = Paths.get(rutaArchivo, new String[0]);
            Files.readAllBytes(pdfPath);
            return true;
        } catch (Exception e) {
            System.err.println("Error al convertir archivo a cargar en bytes");
            return false;
        }
    }

    private byte[] convertirArchivoACargarEnByteArray(String rutaArchivo) throws IOException {
        Path pdfPath = Paths.get(rutaArchivo, new String[0]);
        this.pdfACargar = Files.readAllBytes(pdfPath);
        return this.pdfACargar;
    }

    private boolean validarFecha() {
        try {
            this.xmt.formatoAMD1.format(this.vista.JDCFechaDoc.getDate());
            return true;
        } catch (Exception e) {
            System.err.println("No es posible validar formato de la fecha");
            return false;
        }
    }

    private boolean diasVencimientoEnLaVistaDebeSerEnteroNoNuloMayorOIgualQueCero(String textoDiasVencimientoVista) {
        try {
            int diasVencimiento = Integer.parseInt(textoDiasVencimientoVista);
            if (diasVencimiento >= 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            System.err.println("Error al convertir a entero el texto para validar dias vencimiento");
            return false;
        }
    }

    private boolean validarItemSeleccionadoEnComboBoxCorrespondeAAlmacenadoEnLista(List<ITipoDocumentoEmpresaComboBoxDTO> listaTipoDocumentosConDiasVencimiento, int indiceSeleccionadoComboBox, String nombreSeleccionadoComboBox) {
        boolean rpta = false;
        if (indiceSeleccionadoComboBox >= 0) {
            try {
                if (listaTipoDocumentosConDiasVencimiento.size() > 0) {
                    if (listaTipoDocumentosConDiasVencimiento.get(indiceSeleccionadoComboBox).getNbre().equalsIgnoreCase(nombreSeleccionadoComboBox)) {
                        rpta = true;
                    }
                }
            } catch (Exception e) {
                rpta = false;
                System.err.println("El elemento seleccionado en el combo no corresponde al almacenado en memoria");
            }
        }
        return rpta;
    }

    private boolean laRutaEnlaVistaNoDebeSerVacia(String rutaVista) {
        boolean rpta = false;
        try {
            if (!rutaVista.isEmpty() && rutaVista != null) {
                rpta = true;
            }
        } catch (Exception e) {
            rpta = false;
        }
        return rpta;
    }

    private boolean elementosComboBoxEnVistaCorrespondenAListaEnMemoria(List<ITipoDocumentoEmpresaComboBoxDTO> listaTipoDocumentosConDiasVencimiento, JComboBox comboBox) {
        boolean rpta = true;
        if (comboBox.getItemCount() == listaTipoDocumentosConDiasVencimiento.size()) {
            for (int i = 0; i < listaTipoDocumentosConDiasVencimiento.size(); i++) {
                if (!comboBox.getItemAt(i).toString().equalsIgnoreCase(listaTipoDocumentosConDiasVencimiento.get(i).getNbre())) {
                    rpta = false;
                }
            }
        } else {
            rpta = false;
        }
        return rpta;
    }

    private boolean elDocumentoEstaVencido(Date fechaDocumento, long diasVencimietno) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaInicial = dateFormat.parse(fechaDocumento.toString());
        Date fechaFinal = dateFormat.parse(this.xmt.getFechaActualLocalTime().toString());
        if (((int) ((fechaFinal.getTime() - fechaInicial.getTime()) / 86400000)) >= diasVencimietno) {
            return true;
        }
        return false;
    }

    private boolean elTipoDocumentoYaSeEncuentraActivo(long idTipoDocumento) {
        boolean rpta = false;
        if (this.xITipoDocumentoEmpresaService.listaTipoDocumentoEmpresaFiltradaPorTipoDocumento(this.idEmpresa, Long.valueOf(idTipoDocumento)).size() > 1) {
            rpta = true;
        }
        return rpta;
    }

    private boolean mActualizarActivo(long id, boolean activo) {
        boolean rpta = this.xITipoDocumentoEmpresaService.actualizarActivo(activo, id);
        return rpta;
    }
}
