package Utilidades;

import Acceso.Principal;
import com.genoma.plus.jpa.entities.FTipofinprocedimiento;
import com.genoma.plus.jpa.entities.GProcedimiento;
import com.genoma.plus.jpa.entities.GProcedimientoFinalidad;
import com.genoma.plus.jpa.entities.GProcedimientoServiciosRipsEntity;
import com.genoma.plus.jpa.service.IFTipofinprocedimientoService;
import com.genoma.plus.jpa.service.IGProcedimientoFinalidadService;
import com.genoma.plus.jpa.service.IGProcedimientoServiciosRipsService;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.jdnc.incubator.jxcombobox.IncompatibleLookAndFeelException;
import org.jdesktop.jdnc.incubator.jxcombobox.JTableComboBox;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/CargarCombosVarios.class */
public class CargarCombosVarios {
    private DefaultTableModel modcombos;
    private final IFTipofinprocedimientoService iFTipofinprocedimientoService = (IFTipofinprocedimientoService) Principal.contexto.getBean(IFTipofinprocedimientoService.class);
    private final IGProcedimientoFinalidadService gProcedimientoFinalidadService = (IGProcedimientoFinalidadService) Principal.contexto.getBean(IGProcedimientoFinalidadService.class);
    private final IGProcedimientoServiciosRipsService iGProcedimientoServiciosRipsService = (IGProcedimientoServiciosRipsService) Principal.contexto.getBean(IGProcedimientoServiciosRipsService.class);

    public void cargarComboTableFinalidadPorProcedimientoAnexo1(JTableComboBox comboBox, Long idCodigo) {
        this.modcombos = new DefaultTableModel();
        new ArrayList();
        Object[] etiquetas = new Object[3];
        etiquetas[0] = "Id";
        etiquetas[1] = "Nombre";
        etiquetas[1] = "Codigo";
        this.modcombos.setColumnIdentifiers(etiquetas);
        System.out.println(" lista combo  antes ");
        List<GProcedimientoFinalidad> procedimientoFinalidads = this.gProcedimientoFinalidadService.findByProcedimientoOrderByNombre(idCodigo);
        System.out.println(" lista combo  despues ");
        if (!procedimientoFinalidads.isEmpty()) {
            procedimientoFinalidads.forEach(e -> {
                Object[] datosFila = {e.getFinalida().getId(), e.getFinalida().getNbre(), e.getFinalida().getCodigo()};
                this.modcombos.addRow(datosFila);
            });
        } else {
            List<FTipofinprocedimiento> fTipofinprocedimientos = this.iFTipofinprocedimientoService.listarFinProcedimiento();
            fTipofinprocedimientos.forEach(e2 -> {
                Object[] datosFila = {e2.getId(), e2.getNbre(), e2.getCodigo()};
                this.modcombos.addRow(datosFila);
            });
        }
        if (comboBox == null) {
            try {
                comboBox = new JTableComboBox();
            } catch (IncompatibleLookAndFeelException e3) {
                Logger.getLogger(CargarCombosVarios.class.getName()).log(Level.SEVERE, (String) null, e3);
            }
        }
        comboBox.setModel(this.modcombos, 1);
        if (this.modcombos.getRowCount() < 3) {
            comboBox.setSelectedIndex(0);
        }
    }

    public void cargarComboTableFinalidadPorProcedimiento(JTableComboBox comboBox, Long idCodigo) {
        this.modcombos = new DefaultTableModel();
        new ArrayList();
        Object[] etiquetas = {"Id", "Nombre"};
        this.modcombos.setColumnIdentifiers(etiquetas);
        System.out.println(" lista combo  antes " + idCodigo);
        List<GProcedimientoFinalidad> procedimientoFinalidads = this.gProcedimientoFinalidadService.findByProcedimientoOrderByNombre(idCodigo);
        System.out.println(" lista combo  despues ");
        if (!procedimientoFinalidads.isEmpty()) {
            procedimientoFinalidads.forEach(e -> {
                Object[] datosFila = {e.getFinalida().getId(), e.getFinalida().getNbre()};
                System.out.println("-------------- " + e.getFinalida().getId() + " :::::: " + e.getFinalida().getNbre());
                this.modcombos.addRow(datosFila);
            });
        } else {
            List<FTipofinprocedimiento> fTipofinprocedimientos = this.iFTipofinprocedimientoService.listarFinProcedimiento();
            fTipofinprocedimientos.forEach(e2 -> {
                Object[] datosFila = {e2.getId(), e2.getNbre()};
                this.modcombos.addRow(datosFila);
            });
        }
        if (comboBox == null) {
            try {
                comboBox = new JTableComboBox();
            } catch (IncompatibleLookAndFeelException e3) {
                Logger.getLogger(CargarCombosVarios.class.getName()).log(Level.SEVERE, (String) null, e3);
            }
        }
        comboBox.setModel(this.modcombos, 1);
        if (this.modcombos.getRowCount() < 2) {
            comboBox.setSelectedIndex(0);
        }
    }

    public void cargarComboTableFinalidadPorProcedimiento(JComboBox comboBox, Long idCodigo) {
        this.modcombos = new DefaultTableModel();
        new ArrayList();
        Object[] etiquetas = {"Id", "Nombre"};
        this.modcombos.setColumnIdentifiers(etiquetas);
        List<GProcedimientoFinalidad> procedimientoFinalidads = this.gProcedimientoFinalidadService.findByProcedimientoOrderByNombre(idCodigo);
        if (!procedimientoFinalidads.isEmpty()) {
            procedimientoFinalidads.forEach(e -> {
                comboBox.setSelectedItem(e.getFinalida().getNbre());
            });
        }
    }

    public void cargarComboBoxServicioGrupoProcedimiento(JComboBox comboBox, JComboBox comboBox1, Long idCodigo) {
        GProcedimiento gProcedimiento = new GProcedimiento();
        gProcedimiento.setId(idCodigo);
        new ArrayList();
        List<GProcedimientoServiciosRipsEntity> list = this.iGProcedimientoServiciosRipsService.findByProcedimientoOrderByNombre(gProcedimiento);
        if (!list.isEmpty()) {
            list.forEach(e -> {
                comboBox.setSelectedItem(e.getServicioRipsEntity().getIdGrupoServicio().getNombre());
                comboBox1.setSelectedItem(e.getServicioRipsEntity().getNombre());
            });
        }
    }

    public void cargarComboBoxServicioGrupoProcedimiento(JComboBox comboBox, Long idCodigo) {
        GProcedimiento gProcedimiento = new GProcedimiento();
        gProcedimiento.setId(idCodigo);
        new ArrayList();
        List<GProcedimientoServiciosRipsEntity> list = this.iGProcedimientoServiciosRipsService.findByProcedimientoOrderByNombre(gProcedimiento);
        if (!list.isEmpty()) {
            list.forEach(e -> {
                comboBox.setSelectedItem(e.getServicioRipsEntity().getIdGrupoServicio().getNombre());
            });
        }
    }

    public void cargarComboBoxServicioCodigoProcedimiento(JComboBox comboBox, Long idCodigo) {
        GProcedimiento gProcedimiento = new GProcedimiento();
        gProcedimiento.setId(idCodigo);
        new ArrayList();
        List<GProcedimientoServiciosRipsEntity> list = this.iGProcedimientoServiciosRipsService.findByProcedimientoOrderByNombre(gProcedimiento);
        if (!list.isEmpty()) {
            list.forEach(e -> {
                comboBox.setSelectedItem(e.getServicioRipsEntity().getIdGrupoServicio().getNombre());
            });
        }
    }
}
