package Inventarios;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.dto.general.InformacionIpsDTO;
import com.genoma.plus.dto.inventario.InformeInventarioGeneralDTO;
import com.genoma.plus.jpa.projection.IInformacionInventario;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:Inventarios/ImpresionInfomes.class */
public class ImpresionInfomes {
    private final Metodos metodos = new Metodos();
    private final InformacionIpsDTO informacionIpsDTO = Principal.informacionIps;
    private String usuarioSistemas = Principal.usuarioSistemaDTO.getNombreUsuario();
    private String rutaFirmas = this.metodos.mRutaSoporte("SUBREPORTFIRMA_DIR");
    private String rutaSubReportes = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();

    public void inventarioGeneral(List<IInformacionInventario> informacionInventarios, Boolean abrirPDF, Date fechaCorte, String Bodega, Boolean filtroDetalleLote) {
        InformeInventarioGeneralDTO inventarioGeneralDTO = new InformeInventarioGeneralDTO();
        inventarioGeneralDTO.setInformacionIpsDTO(this.informacionIpsDTO);
        inventarioGeneralDTO.setInformacionInventarios(informacionInventarios);
        inventarioGeneralDTO.setRutaFirmas(this.rutaFirmas);
        inventarioGeneralDTO.setRutaSubReportes(this.rutaSubReportes);
        inventarioGeneralDTO.setUsuarioSistemas(this.usuarioSistemas);
        inventarioGeneralDTO.setFechaCorte(fechaCorte);
        inventarioGeneralDTO.setBodega(Bodega);
        inventarioGeneralDTO.setFiltroDetalle(filtroDetalleLote);
        this.metodos.GenerarPDF(this.metodos.getRutaRep() + "I_InventarioGeneralAgrupadoCategoria", inventarioGeneralDTO, "I_InventarioGeneralAgrupadoCategoria", abrirPDF.booleanValue());
    }
}
