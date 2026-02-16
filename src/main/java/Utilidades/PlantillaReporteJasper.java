package Utilidades;

import Acceso.Principal;
import com.genoma.plus.dto.general.InformacionIpsDTO;
import com.genoma.plus.jpa.projection.IInformeProduccion;
import java.util.ArrayList;
import java.util.List;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/PlantillaReporteJasper.class */
public class PlantillaReporteJasper {
    private String subReporte;
    private String fechaInicial;
    private String fechaFinal;
    private String titulo;
    private String entidad;
    private String nombreUsuario;
    private List<IInformeProduccion> listaDetalleInforme = new ArrayList();
    private InformacionIpsDTO informacionIpsDTO = Principal.informacionIps;

    @Generated
    public void setSubReporte(String subReporte) {
        this.subReporte = subReporte;
    }

    @Generated
    public void setFechaInicial(String fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    @Generated
    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    @Generated
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Generated
    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    @Generated
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    @Generated
    public void setInformacionIpsDTO(InformacionIpsDTO informacionIpsDTO) {
        this.informacionIpsDTO = informacionIpsDTO;
    }

    @Generated
    public void setListaDetalleInforme(List<IInformeProduccion> listaDetalleInforme) {
        this.listaDetalleInforme = listaDetalleInforme;
    }

    @Generated
    public String getSubReporte() {
        return this.subReporte;
    }

    @Generated
    public String getFechaInicial() {
        return this.fechaInicial;
    }

    @Generated
    public String getFechaFinal() {
        return this.fechaFinal;
    }

    @Generated
    public String getTitulo() {
        return this.titulo;
    }

    @Generated
    public String getEntidad() {
        return this.entidad;
    }

    @Generated
    public String getNombreUsuario() {
        return this.nombreUsuario;
    }

    @Generated
    public InformacionIpsDTO getInformacionIpsDTO() {
        return this.informacionIpsDTO;
    }

    @Generated
    public List<IInformeProduccion> getListaDetalleInforme() {
        return this.listaDetalleInforme;
    }
}
