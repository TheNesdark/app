package com.genoma.plus.controller.laboratorio.dto;

import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/dto/ListDetalleResultadosMaquinaDTO.class */
public class ListDetalleResultadosMaquinaDTO {
    private Integer idRecepcion;
    private Integer idProcedimiento;
    private String procedimiento;
    private Integer idProcedimientoProtocolo;
    private String formula;
    private Integer id_Protocolo;
    private String protocolo;
    private String unidad;
    private String valorRefecenciaMinimo;
    private String valorRefecenciaMaximo;
    private Integer validadoLaboratorio;
    private String validacion;
    private Integer nuneroOrdenI;
    private Integer orden;
    private Double resultado;
    private Integer idEquipo;
    private String abreviatura;
    private Integer fueraDeRango;
    private Integer edad;
    private Double talla;
    private Double peso;
    private Double perimetroAbdominal;
    private Double superficieCorporal;
    private String nombreEquipo;

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ListDetalleResultadosMaquinaDTO)) {
            return false;
        }
        ListDetalleResultadosMaquinaDTO other = (ListDetalleResultadosMaquinaDTO) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$idRecepcion = getIdRecepcion();
        Object other$idRecepcion = other.getIdRecepcion();
        if (this$idRecepcion == null) {
            if (other$idRecepcion != null) {
                return false;
            }
        } else if (!this$idRecepcion.equals(other$idRecepcion)) {
            return false;
        }
        Object this$idProcedimiento = getIdProcedimiento();
        Object other$idProcedimiento = other.getIdProcedimiento();
        if (this$idProcedimiento == null) {
            if (other$idProcedimiento != null) {
                return false;
            }
        } else if (!this$idProcedimiento.equals(other$idProcedimiento)) {
            return false;
        }
        Object this$idProcedimientoProtocolo = getIdProcedimientoProtocolo();
        Object other$idProcedimientoProtocolo = other.getIdProcedimientoProtocolo();
        if (this$idProcedimientoProtocolo == null) {
            if (other$idProcedimientoProtocolo != null) {
                return false;
            }
        } else if (!this$idProcedimientoProtocolo.equals(other$idProcedimientoProtocolo)) {
            return false;
        }
        Object this$id_Protocolo = getId_Protocolo();
        Object other$id_Protocolo = other.getId_Protocolo();
        if (this$id_Protocolo == null) {
            if (other$id_Protocolo != null) {
                return false;
            }
        } else if (!this$id_Protocolo.equals(other$id_Protocolo)) {
            return false;
        }
        Object this$validadoLaboratorio = getValidadoLaboratorio();
        Object other$validadoLaboratorio = other.getValidadoLaboratorio();
        if (this$validadoLaboratorio == null) {
            if (other$validadoLaboratorio != null) {
                return false;
            }
        } else if (!this$validadoLaboratorio.equals(other$validadoLaboratorio)) {
            return false;
        }
        Object this$nuneroOrdenI = getNuneroOrdenI();
        Object other$nuneroOrdenI = other.getNuneroOrdenI();
        if (this$nuneroOrdenI == null) {
            if (other$nuneroOrdenI != null) {
                return false;
            }
        } else if (!this$nuneroOrdenI.equals(other$nuneroOrdenI)) {
            return false;
        }
        Object this$orden = getOrden();
        Object other$orden = other.getOrden();
        if (this$orden == null) {
            if (other$orden != null) {
                return false;
            }
        } else if (!this$orden.equals(other$orden)) {
            return false;
        }
        Object this$resultado = getResultado();
        Object other$resultado = other.getResultado();
        if (this$resultado == null) {
            if (other$resultado != null) {
                return false;
            }
        } else if (!this$resultado.equals(other$resultado)) {
            return false;
        }
        Object this$idEquipo = getIdEquipo();
        Object other$idEquipo = other.getIdEquipo();
        if (this$idEquipo == null) {
            if (other$idEquipo != null) {
                return false;
            }
        } else if (!this$idEquipo.equals(other$idEquipo)) {
            return false;
        }
        Object this$fueraDeRango = getFueraDeRango();
        Object other$fueraDeRango = other.getFueraDeRango();
        if (this$fueraDeRango == null) {
            if (other$fueraDeRango != null) {
                return false;
            }
        } else if (!this$fueraDeRango.equals(other$fueraDeRango)) {
            return false;
        }
        Object this$edad = getEdad();
        Object other$edad = other.getEdad();
        if (this$edad == null) {
            if (other$edad != null) {
                return false;
            }
        } else if (!this$edad.equals(other$edad)) {
            return false;
        }
        Object this$talla = getTalla();
        Object other$talla = other.getTalla();
        if (this$talla == null) {
            if (other$talla != null) {
                return false;
            }
        } else if (!this$talla.equals(other$talla)) {
            return false;
        }
        Object this$peso = getPeso();
        Object other$peso = other.getPeso();
        if (this$peso == null) {
            if (other$peso != null) {
                return false;
            }
        } else if (!this$peso.equals(other$peso)) {
            return false;
        }
        Object this$perimetroAbdominal = getPerimetroAbdominal();
        Object other$perimetroAbdominal = other.getPerimetroAbdominal();
        if (this$perimetroAbdominal == null) {
            if (other$perimetroAbdominal != null) {
                return false;
            }
        } else if (!this$perimetroAbdominal.equals(other$perimetroAbdominal)) {
            return false;
        }
        Object this$superficieCorporal = getSuperficieCorporal();
        Object other$superficieCorporal = other.getSuperficieCorporal();
        if (this$superficieCorporal == null) {
            if (other$superficieCorporal != null) {
                return false;
            }
        } else if (!this$superficieCorporal.equals(other$superficieCorporal)) {
            return false;
        }
        Object this$procedimiento = getProcedimiento();
        Object other$procedimiento = other.getProcedimiento();
        if (this$procedimiento == null) {
            if (other$procedimiento != null) {
                return false;
            }
        } else if (!this$procedimiento.equals(other$procedimiento)) {
            return false;
        }
        Object this$formula = getFormula();
        Object other$formula = other.getFormula();
        if (this$formula == null) {
            if (other$formula != null) {
                return false;
            }
        } else if (!this$formula.equals(other$formula)) {
            return false;
        }
        Object this$protocolo = getProtocolo();
        Object other$protocolo = other.getProtocolo();
        if (this$protocolo == null) {
            if (other$protocolo != null) {
                return false;
            }
        } else if (!this$protocolo.equals(other$protocolo)) {
            return false;
        }
        Object this$unidad = getUnidad();
        Object other$unidad = other.getUnidad();
        if (this$unidad == null) {
            if (other$unidad != null) {
                return false;
            }
        } else if (!this$unidad.equals(other$unidad)) {
            return false;
        }
        Object this$valorRefecenciaMinimo = getValorRefecenciaMinimo();
        Object other$valorRefecenciaMinimo = other.getValorRefecenciaMinimo();
        if (this$valorRefecenciaMinimo == null) {
            if (other$valorRefecenciaMinimo != null) {
                return false;
            }
        } else if (!this$valorRefecenciaMinimo.equals(other$valorRefecenciaMinimo)) {
            return false;
        }
        Object this$valorRefecenciaMaximo = getValorRefecenciaMaximo();
        Object other$valorRefecenciaMaximo = other.getValorRefecenciaMaximo();
        if (this$valorRefecenciaMaximo == null) {
            if (other$valorRefecenciaMaximo != null) {
                return false;
            }
        } else if (!this$valorRefecenciaMaximo.equals(other$valorRefecenciaMaximo)) {
            return false;
        }
        Object this$validacion = getValidacion();
        Object other$validacion = other.getValidacion();
        if (this$validacion == null) {
            if (other$validacion != null) {
                return false;
            }
        } else if (!this$validacion.equals(other$validacion)) {
            return false;
        }
        Object this$abreviatura = getAbreviatura();
        Object other$abreviatura = other.getAbreviatura();
        if (this$abreviatura == null) {
            if (other$abreviatura != null) {
                return false;
            }
        } else if (!this$abreviatura.equals(other$abreviatura)) {
            return false;
        }
        Object this$nombreEquipo = getNombreEquipo();
        Object other$nombreEquipo = other.getNombreEquipo();
        return this$nombreEquipo == null ? other$nombreEquipo == null : this$nombreEquipo.equals(other$nombreEquipo);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof ListDetalleResultadosMaquinaDTO;
    }

    @Generated
    public int hashCode() {
        Object $idRecepcion = getIdRecepcion();
        int result = (1 * 59) + ($idRecepcion == null ? 43 : $idRecepcion.hashCode());
        Object $idProcedimiento = getIdProcedimiento();
        int result2 = (result * 59) + ($idProcedimiento == null ? 43 : $idProcedimiento.hashCode());
        Object $idProcedimientoProtocolo = getIdProcedimientoProtocolo();
        int result3 = (result2 * 59) + ($idProcedimientoProtocolo == null ? 43 : $idProcedimientoProtocolo.hashCode());
        Object $id_Protocolo = getId_Protocolo();
        int result4 = (result3 * 59) + ($id_Protocolo == null ? 43 : $id_Protocolo.hashCode());
        Object $validadoLaboratorio = getValidadoLaboratorio();
        int result5 = (result4 * 59) + ($validadoLaboratorio == null ? 43 : $validadoLaboratorio.hashCode());
        Object $nuneroOrdenI = getNuneroOrdenI();
        int result6 = (result5 * 59) + ($nuneroOrdenI == null ? 43 : $nuneroOrdenI.hashCode());
        Object $orden = getOrden();
        int result7 = (result6 * 59) + ($orden == null ? 43 : $orden.hashCode());
        Object $resultado = getResultado();
        int result8 = (result7 * 59) + ($resultado == null ? 43 : $resultado.hashCode());
        Object $idEquipo = getIdEquipo();
        int result9 = (result8 * 59) + ($idEquipo == null ? 43 : $idEquipo.hashCode());
        Object $fueraDeRango = getFueraDeRango();
        int result10 = (result9 * 59) + ($fueraDeRango == null ? 43 : $fueraDeRango.hashCode());
        Object $edad = getEdad();
        int result11 = (result10 * 59) + ($edad == null ? 43 : $edad.hashCode());
        Object $talla = getTalla();
        int result12 = (result11 * 59) + ($talla == null ? 43 : $talla.hashCode());
        Object $peso = getPeso();
        int result13 = (result12 * 59) + ($peso == null ? 43 : $peso.hashCode());
        Object $perimetroAbdominal = getPerimetroAbdominal();
        int result14 = (result13 * 59) + ($perimetroAbdominal == null ? 43 : $perimetroAbdominal.hashCode());
        Object $superficieCorporal = getSuperficieCorporal();
        int result15 = (result14 * 59) + ($superficieCorporal == null ? 43 : $superficieCorporal.hashCode());
        Object $procedimiento = getProcedimiento();
        int result16 = (result15 * 59) + ($procedimiento == null ? 43 : $procedimiento.hashCode());
        Object $formula = getFormula();
        int result17 = (result16 * 59) + ($formula == null ? 43 : $formula.hashCode());
        Object $protocolo = getProtocolo();
        int result18 = (result17 * 59) + ($protocolo == null ? 43 : $protocolo.hashCode());
        Object $unidad = getUnidad();
        int result19 = (result18 * 59) + ($unidad == null ? 43 : $unidad.hashCode());
        Object $valorRefecenciaMinimo = getValorRefecenciaMinimo();
        int result20 = (result19 * 59) + ($valorRefecenciaMinimo == null ? 43 : $valorRefecenciaMinimo.hashCode());
        Object $valorRefecenciaMaximo = getValorRefecenciaMaximo();
        int result21 = (result20 * 59) + ($valorRefecenciaMaximo == null ? 43 : $valorRefecenciaMaximo.hashCode());
        Object $validacion = getValidacion();
        int result22 = (result21 * 59) + ($validacion == null ? 43 : $validacion.hashCode());
        Object $abreviatura = getAbreviatura();
        int result23 = (result22 * 59) + ($abreviatura == null ? 43 : $abreviatura.hashCode());
        Object $nombreEquipo = getNombreEquipo();
        return (result23 * 59) + ($nombreEquipo == null ? 43 : $nombreEquipo.hashCode());
    }

    @Generated
    public String toString() {
        return "ListDetalleResultadosMaquinaDTO(idRecepcion=" + getIdRecepcion() + ", idProcedimiento=" + getIdProcedimiento() + ", procedimiento=" + getProcedimiento() + ", idProcedimientoProtocolo=" + getIdProcedimientoProtocolo() + ", formula=" + getFormula() + ", id_Protocolo=" + getId_Protocolo() + ", protocolo=" + getProtocolo() + ", unidad=" + getUnidad() + ", valorRefecenciaMinimo=" + getValorRefecenciaMinimo() + ", valorRefecenciaMaximo=" + getValorRefecenciaMaximo() + ", validadoLaboratorio=" + getValidadoLaboratorio() + ", validacion=" + getValidacion() + ", nuneroOrdenI=" + getNuneroOrdenI() + ", orden=" + getOrden() + ", resultado=" + getResultado() + ", idEquipo=" + getIdEquipo() + ", abreviatura=" + getAbreviatura() + ", fueraDeRango=" + getFueraDeRango() + ", edad=" + getEdad() + ", talla=" + getTalla() + ", peso=" + getPeso() + ", perimetroAbdominal=" + getPerimetroAbdominal() + ", superficieCorporal=" + getSuperficieCorporal() + ", nombreEquipo=" + getNombreEquipo() + ")";
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/dto/ListDetalleResultadosMaquinaDTO$ListDetalleResultadosMaquinaDTOBuilder.class */
    @Generated
    public static class ListDetalleResultadosMaquinaDTOBuilder {

        @Generated
        private Integer idRecepcion;

        @Generated
        private Integer idProcedimiento;

        @Generated
        private String procedimiento;

        @Generated
        private Integer idProcedimientoProtocolo;

        @Generated
        private String formula;

        @Generated
        private Integer id_Protocolo;

        @Generated
        private String protocolo;

        @Generated
        private String unidad;

        @Generated
        private String valorRefecenciaMinimo;

        @Generated
        private String valorRefecenciaMaximo;

        @Generated
        private Integer validadoLaboratorio;

        @Generated
        private String validacion;

        @Generated
        private Integer nuneroOrdenI;

        @Generated
        private Integer orden;

        @Generated
        private Double resultado;

        @Generated
        private Integer idEquipo;

        @Generated
        private String abreviatura;

        @Generated
        private Integer fueraDeRango;

        @Generated
        private Integer edad;

        @Generated
        private Double talla;

        @Generated
        private Double peso;

        @Generated
        private Double perimetroAbdominal;

        @Generated
        private Double superficieCorporal;

        @Generated
        private String nombreEquipo;

        @Generated
        ListDetalleResultadosMaquinaDTOBuilder() {
        }

        @Generated
        public ListDetalleResultadosMaquinaDTOBuilder idRecepcion(Integer idRecepcion) {
            this.idRecepcion = idRecepcion;
            return this;
        }

        @Generated
        public ListDetalleResultadosMaquinaDTOBuilder idProcedimiento(Integer idProcedimiento) {
            this.idProcedimiento = idProcedimiento;
            return this;
        }

        @Generated
        public ListDetalleResultadosMaquinaDTOBuilder procedimiento(String procedimiento) {
            this.procedimiento = procedimiento;
            return this;
        }

        @Generated
        public ListDetalleResultadosMaquinaDTOBuilder idProcedimientoProtocolo(Integer idProcedimientoProtocolo) {
            this.idProcedimientoProtocolo = idProcedimientoProtocolo;
            return this;
        }

        @Generated
        public ListDetalleResultadosMaquinaDTOBuilder formula(String formula) {
            this.formula = formula;
            return this;
        }

        @Generated
        public ListDetalleResultadosMaquinaDTOBuilder id_Protocolo(Integer id_Protocolo) {
            this.id_Protocolo = id_Protocolo;
            return this;
        }

        @Generated
        public ListDetalleResultadosMaquinaDTOBuilder protocolo(String protocolo) {
            this.protocolo = protocolo;
            return this;
        }

        @Generated
        public ListDetalleResultadosMaquinaDTOBuilder unidad(String unidad) {
            this.unidad = unidad;
            return this;
        }

        @Generated
        public ListDetalleResultadosMaquinaDTOBuilder valorRefecenciaMinimo(String valorRefecenciaMinimo) {
            this.valorRefecenciaMinimo = valorRefecenciaMinimo;
            return this;
        }

        @Generated
        public ListDetalleResultadosMaquinaDTOBuilder valorRefecenciaMaximo(String valorRefecenciaMaximo) {
            this.valorRefecenciaMaximo = valorRefecenciaMaximo;
            return this;
        }

        @Generated
        public ListDetalleResultadosMaquinaDTOBuilder validadoLaboratorio(Integer validadoLaboratorio) {
            this.validadoLaboratorio = validadoLaboratorio;
            return this;
        }

        @Generated
        public ListDetalleResultadosMaquinaDTOBuilder validacion(String validacion) {
            this.validacion = validacion;
            return this;
        }

        @Generated
        public ListDetalleResultadosMaquinaDTOBuilder nuneroOrdenI(Integer nuneroOrdenI) {
            this.nuneroOrdenI = nuneroOrdenI;
            return this;
        }

        @Generated
        public ListDetalleResultadosMaquinaDTOBuilder orden(Integer orden) {
            this.orden = orden;
            return this;
        }

        @Generated
        public ListDetalleResultadosMaquinaDTOBuilder resultado(Double resultado) {
            this.resultado = resultado;
            return this;
        }

        @Generated
        public ListDetalleResultadosMaquinaDTOBuilder idEquipo(Integer idEquipo) {
            this.idEquipo = idEquipo;
            return this;
        }

        @Generated
        public ListDetalleResultadosMaquinaDTOBuilder abreviatura(String abreviatura) {
            this.abreviatura = abreviatura;
            return this;
        }

        @Generated
        public ListDetalleResultadosMaquinaDTOBuilder fueraDeRango(Integer fueraDeRango) {
            this.fueraDeRango = fueraDeRango;
            return this;
        }

        @Generated
        public ListDetalleResultadosMaquinaDTOBuilder edad(Integer edad) {
            this.edad = edad;
            return this;
        }

        @Generated
        public ListDetalleResultadosMaquinaDTOBuilder talla(Double talla) {
            this.talla = talla;
            return this;
        }

        @Generated
        public ListDetalleResultadosMaquinaDTOBuilder peso(Double peso) {
            this.peso = peso;
            return this;
        }

        @Generated
        public ListDetalleResultadosMaquinaDTOBuilder perimetroAbdominal(Double perimetroAbdominal) {
            this.perimetroAbdominal = perimetroAbdominal;
            return this;
        }

        @Generated
        public ListDetalleResultadosMaquinaDTOBuilder superficieCorporal(Double superficieCorporal) {
            this.superficieCorporal = superficieCorporal;
            return this;
        }

        @Generated
        public ListDetalleResultadosMaquinaDTOBuilder nombreEquipo(String nombreEquipo) {
            this.nombreEquipo = nombreEquipo;
            return this;
        }

        @Generated
        public ListDetalleResultadosMaquinaDTO build() {
            return new ListDetalleResultadosMaquinaDTO(this.idRecepcion, this.idProcedimiento, this.procedimiento, this.idProcedimientoProtocolo, this.formula, this.id_Protocolo, this.protocolo, this.unidad, this.valorRefecenciaMinimo, this.valorRefecenciaMaximo, this.validadoLaboratorio, this.validacion, this.nuneroOrdenI, this.orden, this.resultado, this.idEquipo, this.abreviatura, this.fueraDeRango, this.edad, this.talla, this.peso, this.perimetroAbdominal, this.superficieCorporal, this.nombreEquipo);
        }

        @Generated
        public String toString() {
            return "ListDetalleResultadosMaquinaDTO.ListDetalleResultadosMaquinaDTOBuilder(idRecepcion=" + this.idRecepcion + ", idProcedimiento=" + this.idProcedimiento + ", procedimiento=" + this.procedimiento + ", idProcedimientoProtocolo=" + this.idProcedimientoProtocolo + ", formula=" + this.formula + ", id_Protocolo=" + this.id_Protocolo + ", protocolo=" + this.protocolo + ", unidad=" + this.unidad + ", valorRefecenciaMinimo=" + this.valorRefecenciaMinimo + ", valorRefecenciaMaximo=" + this.valorRefecenciaMaximo + ", validadoLaboratorio=" + this.validadoLaboratorio + ", validacion=" + this.validacion + ", nuneroOrdenI=" + this.nuneroOrdenI + ", orden=" + this.orden + ", resultado=" + this.resultado + ", idEquipo=" + this.idEquipo + ", abreviatura=" + this.abreviatura + ", fueraDeRango=" + this.fueraDeRango + ", edad=" + this.edad + ", talla=" + this.talla + ", peso=" + this.peso + ", perimetroAbdominal=" + this.perimetroAbdominal + ", superficieCorporal=" + this.superficieCorporal + ", nombreEquipo=" + this.nombreEquipo + ")";
        }
    }

    @Generated
    public void setIdRecepcion(Integer idRecepcion) {
        this.idRecepcion = idRecepcion;
    }

    @Generated
    public void setIdProcedimiento(Integer idProcedimiento) {
        this.idProcedimiento = idProcedimiento;
    }

    @Generated
    public void setProcedimiento(String procedimiento) {
        this.procedimiento = procedimiento;
    }

    @Generated
    public void setIdProcedimientoProtocolo(Integer idProcedimientoProtocolo) {
        this.idProcedimientoProtocolo = idProcedimientoProtocolo;
    }

    @Generated
    public void setFormula(String formula) {
        this.formula = formula;
    }

    @Generated
    public void setId_Protocolo(Integer id_Protocolo) {
        this.id_Protocolo = id_Protocolo;
    }

    @Generated
    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }

    @Generated
    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    @Generated
    public void setValorRefecenciaMinimo(String valorRefecenciaMinimo) {
        this.valorRefecenciaMinimo = valorRefecenciaMinimo;
    }

    @Generated
    public void setValorRefecenciaMaximo(String valorRefecenciaMaximo) {
        this.valorRefecenciaMaximo = valorRefecenciaMaximo;
    }

    @Generated
    public void setValidadoLaboratorio(Integer validadoLaboratorio) {
        this.validadoLaboratorio = validadoLaboratorio;
    }

    @Generated
    public void setValidacion(String validacion) {
        this.validacion = validacion;
    }

    @Generated
    public void setNuneroOrdenI(Integer nuneroOrdenI) {
        this.nuneroOrdenI = nuneroOrdenI;
    }

    @Generated
    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    @Generated
    public void setResultado(Double resultado) {
        this.resultado = resultado;
    }

    @Generated
    public void setIdEquipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

    @Generated
    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    @Generated
    public void setFueraDeRango(Integer fueraDeRango) {
        this.fueraDeRango = fueraDeRango;
    }

    @Generated
    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    @Generated
    public void setTalla(Double talla) {
        this.talla = talla;
    }

    @Generated
    public void setPeso(Double peso) {
        this.peso = peso;
    }

    @Generated
    public void setPerimetroAbdominal(Double perimetroAbdominal) {
        this.perimetroAbdominal = perimetroAbdominal;
    }

    @Generated
    public void setSuperficieCorporal(Double superficieCorporal) {
        this.superficieCorporal = superficieCorporal;
    }

    @Generated
    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    @Generated
    public static ListDetalleResultadosMaquinaDTOBuilder builder() {
        return new ListDetalleResultadosMaquinaDTOBuilder();
    }

    @Generated
    public ListDetalleResultadosMaquinaDTO(Integer idRecepcion, Integer idProcedimiento, String procedimiento, Integer idProcedimientoProtocolo, String formula, Integer id_Protocolo, String protocolo, String unidad, String valorRefecenciaMinimo, String valorRefecenciaMaximo, Integer validadoLaboratorio, String validacion, Integer nuneroOrdenI, Integer orden, Double resultado, Integer idEquipo, String abreviatura, Integer fueraDeRango, Integer edad, Double talla, Double peso, Double perimetroAbdominal, Double superficieCorporal, String nombreEquipo) {
        this.idRecepcion = idRecepcion;
        this.idProcedimiento = idProcedimiento;
        this.procedimiento = procedimiento;
        this.idProcedimientoProtocolo = idProcedimientoProtocolo;
        this.formula = formula;
        this.id_Protocolo = id_Protocolo;
        this.protocolo = protocolo;
        this.unidad = unidad;
        this.valorRefecenciaMinimo = valorRefecenciaMinimo;
        this.valorRefecenciaMaximo = valorRefecenciaMaximo;
        this.validadoLaboratorio = validadoLaboratorio;
        this.validacion = validacion;
        this.nuneroOrdenI = nuneroOrdenI;
        this.orden = orden;
        this.resultado = resultado;
        this.idEquipo = idEquipo;
        this.abreviatura = abreviatura;
        this.fueraDeRango = fueraDeRango;
        this.edad = edad;
        this.talla = talla;
        this.peso = peso;
        this.perimetroAbdominal = perimetroAbdominal;
        this.superficieCorporal = superficieCorporal;
        this.nombreEquipo = nombreEquipo;
    }

    @Generated
    public ListDetalleResultadosMaquinaDTO() {
    }

    @Generated
    public Integer getIdRecepcion() {
        return this.idRecepcion;
    }

    @Generated
    public Integer getIdProcedimiento() {
        return this.idProcedimiento;
    }

    @Generated
    public String getProcedimiento() {
        return this.procedimiento;
    }

    @Generated
    public Integer getIdProcedimientoProtocolo() {
        return this.idProcedimientoProtocolo;
    }

    @Generated
    public String getFormula() {
        return this.formula;
    }

    @Generated
    public Integer getId_Protocolo() {
        return this.id_Protocolo;
    }

    @Generated
    public String getProtocolo() {
        return this.protocolo;
    }

    @Generated
    public String getUnidad() {
        return this.unidad;
    }

    @Generated
    public String getValorRefecenciaMinimo() {
        return this.valorRefecenciaMinimo;
    }

    @Generated
    public String getValorRefecenciaMaximo() {
        return this.valorRefecenciaMaximo;
    }

    @Generated
    public Integer getValidadoLaboratorio() {
        return this.validadoLaboratorio;
    }

    @Generated
    public String getValidacion() {
        return this.validacion;
    }

    @Generated
    public Integer getNuneroOrdenI() {
        return this.nuneroOrdenI;
    }

    @Generated
    public Integer getOrden() {
        return this.orden;
    }

    @Generated
    public Double getResultado() {
        return this.resultado;
    }

    @Generated
    public Integer getIdEquipo() {
        return this.idEquipo;
    }

    @Generated
    public String getAbreviatura() {
        return this.abreviatura;
    }

    @Generated
    public Integer getFueraDeRango() {
        return this.fueraDeRango;
    }

    @Generated
    public Integer getEdad() {
        return this.edad;
    }

    @Generated
    public Double getTalla() {
        return this.talla;
    }

    @Generated
    public Double getPeso() {
        return this.peso;
    }

    @Generated
    public Double getPerimetroAbdominal() {
        return this.perimetroAbdominal;
    }

    @Generated
    public Double getSuperficieCorporal() {
        return this.superficieCorporal;
    }

    @Generated
    public String getNombreEquipo() {
        return this.nombreEquipo;
    }
}
