package com.genoma.plus.controller.enfermeria.dto;

import java.util.Date;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/enfermeria/dto/RegistroSignosVitalesDto.class */
public class RegistroSignosVitalesDto {
    private Long id;
    private Long idAtencion;
    private Integer idUsuarioPrograma;
    private String estadoGeneral;
    private String estadoConciencia;
    private Short tensionArterialSentadoD;
    private Short tensionArterialSentadoS;
    private Short tensionArterialAcostadoD;
    private Short tensionArterialAcostadoS;
    private Short tensionArterialPieD;
    private Short tensionArterialPieS;
    private String tensionArterialSentado;
    private String tensionArterialAcostado;
    private String tensionArterialPie;
    private Double tensionArterialMedia;
    private Boolean controlTA;
    private Short fecuencuaCardiaca;
    private Short frecuenciaRespiratoria;
    private Float talla;
    private Float peso;
    private Float imc;
    private String riesgoImc;
    private String riesgoObecidad;
    private String observacion;
    private Double temperatura;
    private Float ps2;
    private Boolean controlDm;
    private Float valorGlicemia;
    private Short perimetroCefalico;
    private Short perimetroAbdominal;
    private Short perimetroBrazo;
    private String riesgoPerimetoAbdominal;
    private Short idCRiesgo;
    private Double semanasGestacion;
    private Double alturaUterina;
    private Short frecuenciaCFh1;
    private Short frecuenciaCFh2;
    private String PresentacionFetalH1;
    private String PresentacionFetalH2;
    private String movFetalH1;
    private String movFetalH2;
    private String valoracionCuelloUterino;
    private String edemas;
    private String sintomaPEclampsia;
    private String saludOral;
    private Boolean embarazo;
    private Double metaHb;
    private Double pesoIdeal;
    private Double peGrasa;
    private String rePGrasa;
    private Double egEsfuerzo;
    private Double flexibilidad;
    private String registroFlexibilidad;
    private Short clasificacionRiesgoDm;
    private Short clasificacionRiesgoHta;
    private Double resultadoVMAX;
    private Double vmax;
    private String claVMAX;
    private Double frecMax;
    private Double frecMaxAlc;
    private String resultadoFrecMax;
    private Double irc;
    private String claIRC;
    private Short tensionASistolicaT;
    private Double resultadoITB;
    private String claITB;
    private Long idRemoto;
    private String autoExamenSeno;
    private Short perimetroBranquial;
    private Short perimetroPantorrilla;
    private Date fecha;
    private String usuarioS;
    private Short sintomatologiaUrinaria;
    private Short flujoVaginal;
    private Short cefaleaPersistente;
    private Short nauseasVomito;

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/enfermeria/dto/RegistroSignosVitalesDto$RegistroSignosVitalesDtoBuilder.class */
    @Generated
    public static class RegistroSignosVitalesDtoBuilder {

        @Generated
        private Long id;

        @Generated
        private Long idAtencion;

        @Generated
        private Integer idUsuarioPrograma;

        @Generated
        private String estadoGeneral;

        @Generated
        private String estadoConciencia;

        @Generated
        private Short tensionArterialSentadoD;

        @Generated
        private Short tensionArterialSentadoS;

        @Generated
        private Short tensionArterialAcostadoD;

        @Generated
        private Short tensionArterialAcostadoS;

        @Generated
        private Short tensionArterialPieD;

        @Generated
        private Short tensionArterialPieS;

        @Generated
        private String tensionArterialSentado;

        @Generated
        private String tensionArterialAcostado;

        @Generated
        private String tensionArterialPie;

        @Generated
        private Double tensionArterialMedia;

        @Generated
        private Boolean controlTA;

        @Generated
        private Short fecuencuaCardiaca;

        @Generated
        private Short frecuenciaRespiratoria;

        @Generated
        private Float talla;

        @Generated
        private Float peso;

        @Generated
        private Float imc;

        @Generated
        private String riesgoImc;

        @Generated
        private String riesgoObecidad;

        @Generated
        private String observacion;

        @Generated
        private Double temperatura;

        @Generated
        private Float ps2;

        @Generated
        private Boolean controlDm;

        @Generated
        private Float valorGlicemia;

        @Generated
        private Short perimetroCefalico;

        @Generated
        private Short perimetroAbdominal;

        @Generated
        private Short perimetroBrazo;

        @Generated
        private String riesgoPerimetoAbdominal;

        @Generated
        private Short idCRiesgo;

        @Generated
        private Double semanasGestacion;

        @Generated
        private Double alturaUterina;

        @Generated
        private Short frecuenciaCFh1;

        @Generated
        private Short frecuenciaCFh2;

        @Generated
        private String PresentacionFetalH1;

        @Generated
        private String PresentacionFetalH2;

        @Generated
        private String movFetalH1;

        @Generated
        private String movFetalH2;

        @Generated
        private String valoracionCuelloUterino;

        @Generated
        private String edemas;

        @Generated
        private String sintomaPEclampsia;

        @Generated
        private String saludOral;

        @Generated
        private Boolean embarazo;

        @Generated
        private Double metaHb;

        @Generated
        private Double pesoIdeal;

        @Generated
        private Double peGrasa;

        @Generated
        private String rePGrasa;

        @Generated
        private Double egEsfuerzo;

        @Generated
        private Double flexibilidad;

        @Generated
        private String registroFlexibilidad;

        @Generated
        private Short clasificacionRiesgoDm;

        @Generated
        private Short clasificacionRiesgoHta;

        @Generated
        private Double resultadoVMAX;

        @Generated
        private Double vmax;

        @Generated
        private String claVMAX;

        @Generated
        private Double frecMax;

        @Generated
        private Double frecMaxAlc;

        @Generated
        private String resultadoFrecMax;

        @Generated
        private Double irc;

        @Generated
        private String claIRC;

        @Generated
        private Short tensionASistolicaT;

        @Generated
        private Double resultadoITB;

        @Generated
        private String claITB;

        @Generated
        private Long idRemoto;

        @Generated
        private String autoExamenSeno;

        @Generated
        private Short perimetroBranquial;

        @Generated
        private Short perimetroPantorrilla;

        @Generated
        private Date fecha;

        @Generated
        private String usuarioS;

        @Generated
        private Short sintomatologiaUrinaria;

        @Generated
        private Short flujoVaginal;

        @Generated
        private Short cefaleaPersistente;

        @Generated
        private Short nauseasVomito;

        @Generated
        RegistroSignosVitalesDtoBuilder() {
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder id(Long id) {
            this.id = id;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder idAtencion(Long idAtencion) {
            this.idAtencion = idAtencion;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder idUsuarioPrograma(Integer idUsuarioPrograma) {
            this.idUsuarioPrograma = idUsuarioPrograma;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder estadoGeneral(String estadoGeneral) {
            this.estadoGeneral = estadoGeneral;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder estadoConciencia(String estadoConciencia) {
            this.estadoConciencia = estadoConciencia;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder tensionArterialSentadoD(Short tensionArterialSentadoD) {
            this.tensionArterialSentadoD = tensionArterialSentadoD;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder tensionArterialSentadoS(Short tensionArterialSentadoS) {
            this.tensionArterialSentadoS = tensionArterialSentadoS;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder tensionArterialAcostadoD(Short tensionArterialAcostadoD) {
            this.tensionArterialAcostadoD = tensionArterialAcostadoD;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder tensionArterialAcostadoS(Short tensionArterialAcostadoS) {
            this.tensionArterialAcostadoS = tensionArterialAcostadoS;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder tensionArterialPieD(Short tensionArterialPieD) {
            this.tensionArterialPieD = tensionArterialPieD;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder tensionArterialPieS(Short tensionArterialPieS) {
            this.tensionArterialPieS = tensionArterialPieS;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder tensionArterialSentado(String tensionArterialSentado) {
            this.tensionArterialSentado = tensionArterialSentado;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder tensionArterialAcostado(String tensionArterialAcostado) {
            this.tensionArterialAcostado = tensionArterialAcostado;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder tensionArterialPie(String tensionArterialPie) {
            this.tensionArterialPie = tensionArterialPie;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder tensionArterialMedia(Double tensionArterialMedia) {
            this.tensionArterialMedia = tensionArterialMedia;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder controlTA(Boolean controlTA) {
            this.controlTA = controlTA;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder fecuencuaCardiaca(Short fecuencuaCardiaca) {
            this.fecuencuaCardiaca = fecuencuaCardiaca;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder frecuenciaRespiratoria(Short frecuenciaRespiratoria) {
            this.frecuenciaRespiratoria = frecuenciaRespiratoria;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder talla(Float talla) {
            this.talla = talla;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder peso(Float peso) {
            this.peso = peso;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder imc(Float imc) {
            this.imc = imc;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder riesgoImc(String riesgoImc) {
            this.riesgoImc = riesgoImc;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder riesgoObecidad(String riesgoObecidad) {
            this.riesgoObecidad = riesgoObecidad;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder observacion(String observacion) {
            this.observacion = observacion;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder temperatura(Double temperatura) {
            this.temperatura = temperatura;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder ps2(Float ps2) {
            this.ps2 = ps2;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder controlDm(Boolean controlDm) {
            this.controlDm = controlDm;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder valorGlicemia(Float valorGlicemia) {
            this.valorGlicemia = valorGlicemia;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder perimetroCefalico(Short perimetroCefalico) {
            this.perimetroCefalico = perimetroCefalico;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder perimetroAbdominal(Short perimetroAbdominal) {
            this.perimetroAbdominal = perimetroAbdominal;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder perimetroBrazo(Short perimetroBrazo) {
            this.perimetroBrazo = perimetroBrazo;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder riesgoPerimetoAbdominal(String riesgoPerimetoAbdominal) {
            this.riesgoPerimetoAbdominal = riesgoPerimetoAbdominal;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder idCRiesgo(Short idCRiesgo) {
            this.idCRiesgo = idCRiesgo;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder semanasGestacion(Double semanasGestacion) {
            this.semanasGestacion = semanasGestacion;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder alturaUterina(Double alturaUterina) {
            this.alturaUterina = alturaUterina;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder frecuenciaCFh1(Short frecuenciaCFh1) {
            this.frecuenciaCFh1 = frecuenciaCFh1;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder frecuenciaCFh2(Short frecuenciaCFh2) {
            this.frecuenciaCFh2 = frecuenciaCFh2;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder PresentacionFetalH1(String PresentacionFetalH1) {
            this.PresentacionFetalH1 = PresentacionFetalH1;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder PresentacionFetalH2(String PresentacionFetalH2) {
            this.PresentacionFetalH2 = PresentacionFetalH2;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder movFetalH1(String movFetalH1) {
            this.movFetalH1 = movFetalH1;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder movFetalH2(String movFetalH2) {
            this.movFetalH2 = movFetalH2;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder valoracionCuelloUterino(String valoracionCuelloUterino) {
            this.valoracionCuelloUterino = valoracionCuelloUterino;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder edemas(String edemas) {
            this.edemas = edemas;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder sintomaPEclampsia(String sintomaPEclampsia) {
            this.sintomaPEclampsia = sintomaPEclampsia;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder saludOral(String saludOral) {
            this.saludOral = saludOral;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder embarazo(Boolean embarazo) {
            this.embarazo = embarazo;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder metaHb(Double metaHb) {
            this.metaHb = metaHb;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder pesoIdeal(Double pesoIdeal) {
            this.pesoIdeal = pesoIdeal;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder peGrasa(Double peGrasa) {
            this.peGrasa = peGrasa;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder rePGrasa(String rePGrasa) {
            this.rePGrasa = rePGrasa;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder egEsfuerzo(Double egEsfuerzo) {
            this.egEsfuerzo = egEsfuerzo;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder flexibilidad(Double flexibilidad) {
            this.flexibilidad = flexibilidad;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder registroFlexibilidad(String registroFlexibilidad) {
            this.registroFlexibilidad = registroFlexibilidad;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder clasificacionRiesgoDm(Short clasificacionRiesgoDm) {
            this.clasificacionRiesgoDm = clasificacionRiesgoDm;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder clasificacionRiesgoHta(Short clasificacionRiesgoHta) {
            this.clasificacionRiesgoHta = clasificacionRiesgoHta;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder resultadoVMAX(Double resultadoVMAX) {
            this.resultadoVMAX = resultadoVMAX;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder vmax(Double vmax) {
            this.vmax = vmax;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder claVMAX(String claVMAX) {
            this.claVMAX = claVMAX;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder frecMax(Double frecMax) {
            this.frecMax = frecMax;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder frecMaxAlc(Double frecMaxAlc) {
            this.frecMaxAlc = frecMaxAlc;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder resultadoFrecMax(String resultadoFrecMax) {
            this.resultadoFrecMax = resultadoFrecMax;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder irc(Double irc) {
            this.irc = irc;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder claIRC(String claIRC) {
            this.claIRC = claIRC;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder tensionASistolicaT(Short tensionASistolicaT) {
            this.tensionASistolicaT = tensionASistolicaT;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder resultadoITB(Double resultadoITB) {
            this.resultadoITB = resultadoITB;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder claITB(String claITB) {
            this.claITB = claITB;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder idRemoto(Long idRemoto) {
            this.idRemoto = idRemoto;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder autoExamenSeno(String autoExamenSeno) {
            this.autoExamenSeno = autoExamenSeno;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder perimetroBranquial(Short perimetroBranquial) {
            this.perimetroBranquial = perimetroBranquial;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder perimetroPantorrilla(Short perimetroPantorrilla) {
            this.perimetroPantorrilla = perimetroPantorrilla;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder fecha(Date fecha) {
            this.fecha = fecha;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder usuarioS(String usuarioS) {
            this.usuarioS = usuarioS;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder sintomatologiaUrinaria(Short sintomatologiaUrinaria) {
            this.sintomatologiaUrinaria = sintomatologiaUrinaria;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder flujoVaginal(Short flujoVaginal) {
            this.flujoVaginal = flujoVaginal;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder cefaleaPersistente(Short cefaleaPersistente) {
            this.cefaleaPersistente = cefaleaPersistente;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDtoBuilder nauseasVomito(Short nauseasVomito) {
            this.nauseasVomito = nauseasVomito;
            return this;
        }

        @Generated
        public RegistroSignosVitalesDto build() {
            return new RegistroSignosVitalesDto(this.id, this.idAtencion, this.idUsuarioPrograma, this.estadoGeneral, this.estadoConciencia, this.tensionArterialSentadoD, this.tensionArterialSentadoS, this.tensionArterialAcostadoD, this.tensionArterialAcostadoS, this.tensionArterialPieD, this.tensionArterialPieS, this.tensionArterialSentado, this.tensionArterialAcostado, this.tensionArterialPie, this.tensionArterialMedia, this.controlTA, this.fecuencuaCardiaca, this.frecuenciaRespiratoria, this.talla, this.peso, this.imc, this.riesgoImc, this.riesgoObecidad, this.observacion, this.temperatura, this.ps2, this.controlDm, this.valorGlicemia, this.perimetroCefalico, this.perimetroAbdominal, this.perimetroBrazo, this.riesgoPerimetoAbdominal, this.idCRiesgo, this.semanasGestacion, this.alturaUterina, this.frecuenciaCFh1, this.frecuenciaCFh2, this.PresentacionFetalH1, this.PresentacionFetalH2, this.movFetalH1, this.movFetalH2, this.valoracionCuelloUterino, this.edemas, this.sintomaPEclampsia, this.saludOral, this.embarazo, this.metaHb, this.pesoIdeal, this.peGrasa, this.rePGrasa, this.egEsfuerzo, this.flexibilidad, this.registroFlexibilidad, this.clasificacionRiesgoDm, this.clasificacionRiesgoHta, this.resultadoVMAX, this.vmax, this.claVMAX, this.frecMax, this.frecMaxAlc, this.resultadoFrecMax, this.irc, this.claIRC, this.tensionASistolicaT, this.resultadoITB, this.claITB, this.idRemoto, this.autoExamenSeno, this.perimetroBranquial, this.perimetroPantorrilla, this.fecha, this.usuarioS, this.sintomatologiaUrinaria, this.flujoVaginal, this.cefaleaPersistente, this.nauseasVomito);
        }

        @Generated
        public String toString() {
            return "RegistroSignosVitalesDto.RegistroSignosVitalesDtoBuilder(id=" + this.id + ", idAtencion=" + this.idAtencion + ", idUsuarioPrograma=" + this.idUsuarioPrograma + ", estadoGeneral=" + this.estadoGeneral + ", estadoConciencia=" + this.estadoConciencia + ", tensionArterialSentadoD=" + this.tensionArterialSentadoD + ", tensionArterialSentadoS=" + this.tensionArterialSentadoS + ", tensionArterialAcostadoD=" + this.tensionArterialAcostadoD + ", tensionArterialAcostadoS=" + this.tensionArterialAcostadoS + ", tensionArterialPieD=" + this.tensionArterialPieD + ", tensionArterialPieS=" + this.tensionArterialPieS + ", tensionArterialSentado=" + this.tensionArterialSentado + ", tensionArterialAcostado=" + this.tensionArterialAcostado + ", tensionArterialPie=" + this.tensionArterialPie + ", tensionArterialMedia=" + this.tensionArterialMedia + ", controlTA=" + this.controlTA + ", fecuencuaCardiaca=" + this.fecuencuaCardiaca + ", frecuenciaRespiratoria=" + this.frecuenciaRespiratoria + ", talla=" + this.talla + ", peso=" + this.peso + ", imc=" + this.imc + ", riesgoImc=" + this.riesgoImc + ", riesgoObecidad=" + this.riesgoObecidad + ", observacion=" + this.observacion + ", temperatura=" + this.temperatura + ", ps2=" + this.ps2 + ", controlDm=" + this.controlDm + ", valorGlicemia=" + this.valorGlicemia + ", perimetroCefalico=" + this.perimetroCefalico + ", perimetroAbdominal=" + this.perimetroAbdominal + ", perimetroBrazo=" + this.perimetroBrazo + ", riesgoPerimetoAbdominal=" + this.riesgoPerimetoAbdominal + ", idCRiesgo=" + this.idCRiesgo + ", semanasGestacion=" + this.semanasGestacion + ", alturaUterina=" + this.alturaUterina + ", frecuenciaCFh1=" + this.frecuenciaCFh1 + ", frecuenciaCFh2=" + this.frecuenciaCFh2 + ", PresentacionFetalH1=" + this.PresentacionFetalH1 + ", PresentacionFetalH2=" + this.PresentacionFetalH2 + ", movFetalH1=" + this.movFetalH1 + ", movFetalH2=" + this.movFetalH2 + ", valoracionCuelloUterino=" + this.valoracionCuelloUterino + ", edemas=" + this.edemas + ", sintomaPEclampsia=" + this.sintomaPEclampsia + ", saludOral=" + this.saludOral + ", embarazo=" + this.embarazo + ", metaHb=" + this.metaHb + ", pesoIdeal=" + this.pesoIdeal + ", peGrasa=" + this.peGrasa + ", rePGrasa=" + this.rePGrasa + ", egEsfuerzo=" + this.egEsfuerzo + ", flexibilidad=" + this.flexibilidad + ", registroFlexibilidad=" + this.registroFlexibilidad + ", clasificacionRiesgoDm=" + this.clasificacionRiesgoDm + ", clasificacionRiesgoHta=" + this.clasificacionRiesgoHta + ", resultadoVMAX=" + this.resultadoVMAX + ", vmax=" + this.vmax + ", claVMAX=" + this.claVMAX + ", frecMax=" + this.frecMax + ", frecMaxAlc=" + this.frecMaxAlc + ", resultadoFrecMax=" + this.resultadoFrecMax + ", irc=" + this.irc + ", claIRC=" + this.claIRC + ", tensionASistolicaT=" + this.tensionASistolicaT + ", resultadoITB=" + this.resultadoITB + ", claITB=" + this.claITB + ", idRemoto=" + this.idRemoto + ", autoExamenSeno=" + this.autoExamenSeno + ", perimetroBranquial=" + this.perimetroBranquial + ", perimetroPantorrilla=" + this.perimetroPantorrilla + ", fecha=" + this.fecha + ", usuarioS=" + this.usuarioS + ", sintomatologiaUrinaria=" + this.sintomatologiaUrinaria + ", flujoVaginal=" + this.flujoVaginal + ", cefaleaPersistente=" + this.cefaleaPersistente + ", nauseasVomito=" + this.nauseasVomito + ")";
        }
    }

    @Generated
    public void setId(Long id) {
        this.id = id;
    }

    @Generated
    public void setIdAtencion(Long idAtencion) {
        this.idAtencion = idAtencion;
    }

    @Generated
    public void setIdUsuarioPrograma(Integer idUsuarioPrograma) {
        this.idUsuarioPrograma = idUsuarioPrograma;
    }

    @Generated
    public void setEstadoGeneral(String estadoGeneral) {
        this.estadoGeneral = estadoGeneral;
    }

    @Generated
    public void setEstadoConciencia(String estadoConciencia) {
        this.estadoConciencia = estadoConciencia;
    }

    @Generated
    public void setTensionArterialSentadoD(Short tensionArterialSentadoD) {
        this.tensionArterialSentadoD = tensionArterialSentadoD;
    }

    @Generated
    public void setTensionArterialSentadoS(Short tensionArterialSentadoS) {
        this.tensionArterialSentadoS = tensionArterialSentadoS;
    }

    @Generated
    public void setTensionArterialAcostadoD(Short tensionArterialAcostadoD) {
        this.tensionArterialAcostadoD = tensionArterialAcostadoD;
    }

    @Generated
    public void setTensionArterialAcostadoS(Short tensionArterialAcostadoS) {
        this.tensionArterialAcostadoS = tensionArterialAcostadoS;
    }

    @Generated
    public void setTensionArterialPieD(Short tensionArterialPieD) {
        this.tensionArterialPieD = tensionArterialPieD;
    }

    @Generated
    public void setTensionArterialPieS(Short tensionArterialPieS) {
        this.tensionArterialPieS = tensionArterialPieS;
    }

    @Generated
    public void setTensionArterialSentado(String tensionArterialSentado) {
        this.tensionArterialSentado = tensionArterialSentado;
    }

    @Generated
    public void setTensionArterialAcostado(String tensionArterialAcostado) {
        this.tensionArterialAcostado = tensionArterialAcostado;
    }

    @Generated
    public void setTensionArterialPie(String tensionArterialPie) {
        this.tensionArterialPie = tensionArterialPie;
    }

    @Generated
    public void setTensionArterialMedia(Double tensionArterialMedia) {
        this.tensionArterialMedia = tensionArterialMedia;
    }

    @Generated
    public void setControlTA(Boolean controlTA) {
        this.controlTA = controlTA;
    }

    @Generated
    public void setFecuencuaCardiaca(Short fecuencuaCardiaca) {
        this.fecuencuaCardiaca = fecuencuaCardiaca;
    }

    @Generated
    public void setFrecuenciaRespiratoria(Short frecuenciaRespiratoria) {
        this.frecuenciaRespiratoria = frecuenciaRespiratoria;
    }

    @Generated
    public void setTalla(Float talla) {
        this.talla = talla;
    }

    @Generated
    public void setPeso(Float peso) {
        this.peso = peso;
    }

    @Generated
    public void setImc(Float imc) {
        this.imc = imc;
    }

    @Generated
    public void setRiesgoImc(String riesgoImc) {
        this.riesgoImc = riesgoImc;
    }

    @Generated
    public void setRiesgoObecidad(String riesgoObecidad) {
        this.riesgoObecidad = riesgoObecidad;
    }

    @Generated
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @Generated
    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    @Generated
    public void setPs2(Float ps2) {
        this.ps2 = ps2;
    }

    @Generated
    public void setControlDm(Boolean controlDm) {
        this.controlDm = controlDm;
    }

    @Generated
    public void setValorGlicemia(Float valorGlicemia) {
        this.valorGlicemia = valorGlicemia;
    }

    @Generated
    public void setPerimetroCefalico(Short perimetroCefalico) {
        this.perimetroCefalico = perimetroCefalico;
    }

    @Generated
    public void setPerimetroAbdominal(Short perimetroAbdominal) {
        this.perimetroAbdominal = perimetroAbdominal;
    }

    @Generated
    public void setPerimetroBrazo(Short perimetroBrazo) {
        this.perimetroBrazo = perimetroBrazo;
    }

    @Generated
    public void setRiesgoPerimetoAbdominal(String riesgoPerimetoAbdominal) {
        this.riesgoPerimetoAbdominal = riesgoPerimetoAbdominal;
    }

    @Generated
    public void setIdCRiesgo(Short idCRiesgo) {
        this.idCRiesgo = idCRiesgo;
    }

    @Generated
    public void setSemanasGestacion(Double semanasGestacion) {
        this.semanasGestacion = semanasGestacion;
    }

    @Generated
    public void setAlturaUterina(Double alturaUterina) {
        this.alturaUterina = alturaUterina;
    }

    @Generated
    public void setFrecuenciaCFh1(Short frecuenciaCFh1) {
        this.frecuenciaCFh1 = frecuenciaCFh1;
    }

    @Generated
    public void setFrecuenciaCFh2(Short frecuenciaCFh2) {
        this.frecuenciaCFh2 = frecuenciaCFh2;
    }

    @Generated
    public void setPresentacionFetalH1(String PresentacionFetalH1) {
        this.PresentacionFetalH1 = PresentacionFetalH1;
    }

    @Generated
    public void setPresentacionFetalH2(String PresentacionFetalH2) {
        this.PresentacionFetalH2 = PresentacionFetalH2;
    }

    @Generated
    public void setMovFetalH1(String movFetalH1) {
        this.movFetalH1 = movFetalH1;
    }

    @Generated
    public void setMovFetalH2(String movFetalH2) {
        this.movFetalH2 = movFetalH2;
    }

    @Generated
    public void setValoracionCuelloUterino(String valoracionCuelloUterino) {
        this.valoracionCuelloUterino = valoracionCuelloUterino;
    }

    @Generated
    public void setEdemas(String edemas) {
        this.edemas = edemas;
    }

    @Generated
    public void setSintomaPEclampsia(String sintomaPEclampsia) {
        this.sintomaPEclampsia = sintomaPEclampsia;
    }

    @Generated
    public void setSaludOral(String saludOral) {
        this.saludOral = saludOral;
    }

    @Generated
    public void setEmbarazo(Boolean embarazo) {
        this.embarazo = embarazo;
    }

    @Generated
    public void setMetaHb(Double metaHb) {
        this.metaHb = metaHb;
    }

    @Generated
    public void setPesoIdeal(Double pesoIdeal) {
        this.pesoIdeal = pesoIdeal;
    }

    @Generated
    public void setPeGrasa(Double peGrasa) {
        this.peGrasa = peGrasa;
    }

    @Generated
    public void setRePGrasa(String rePGrasa) {
        this.rePGrasa = rePGrasa;
    }

    @Generated
    public void setEgEsfuerzo(Double egEsfuerzo) {
        this.egEsfuerzo = egEsfuerzo;
    }

    @Generated
    public void setFlexibilidad(Double flexibilidad) {
        this.flexibilidad = flexibilidad;
    }

    @Generated
    public void setRegistroFlexibilidad(String registroFlexibilidad) {
        this.registroFlexibilidad = registroFlexibilidad;
    }

    @Generated
    public void setClasificacionRiesgoDm(Short clasificacionRiesgoDm) {
        this.clasificacionRiesgoDm = clasificacionRiesgoDm;
    }

    @Generated
    public void setClasificacionRiesgoHta(Short clasificacionRiesgoHta) {
        this.clasificacionRiesgoHta = clasificacionRiesgoHta;
    }

    @Generated
    public void setResultadoVMAX(Double resultadoVMAX) {
        this.resultadoVMAX = resultadoVMAX;
    }

    @Generated
    public void setVmax(Double vmax) {
        this.vmax = vmax;
    }

    @Generated
    public void setClaVMAX(String claVMAX) {
        this.claVMAX = claVMAX;
    }

    @Generated
    public void setFrecMax(Double frecMax) {
        this.frecMax = frecMax;
    }

    @Generated
    public void setFrecMaxAlc(Double frecMaxAlc) {
        this.frecMaxAlc = frecMaxAlc;
    }

    @Generated
    public void setResultadoFrecMax(String resultadoFrecMax) {
        this.resultadoFrecMax = resultadoFrecMax;
    }

    @Generated
    public void setIrc(Double irc) {
        this.irc = irc;
    }

    @Generated
    public void setClaIRC(String claIRC) {
        this.claIRC = claIRC;
    }

    @Generated
    public void setTensionASistolicaT(Short tensionASistolicaT) {
        this.tensionASistolicaT = tensionASistolicaT;
    }

    @Generated
    public void setResultadoITB(Double resultadoITB) {
        this.resultadoITB = resultadoITB;
    }

    @Generated
    public void setClaITB(String claITB) {
        this.claITB = claITB;
    }

    @Generated
    public void setIdRemoto(Long idRemoto) {
        this.idRemoto = idRemoto;
    }

    @Generated
    public void setAutoExamenSeno(String autoExamenSeno) {
        this.autoExamenSeno = autoExamenSeno;
    }

    @Generated
    public void setPerimetroBranquial(Short perimetroBranquial) {
        this.perimetroBranquial = perimetroBranquial;
    }

    @Generated
    public void setPerimetroPantorrilla(Short perimetroPantorrilla) {
        this.perimetroPantorrilla = perimetroPantorrilla;
    }

    @Generated
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Generated
    public void setUsuarioS(String usuarioS) {
        this.usuarioS = usuarioS;
    }

    @Generated
    public void setSintomatologiaUrinaria(Short sintomatologiaUrinaria) {
        this.sintomatologiaUrinaria = sintomatologiaUrinaria;
    }

    @Generated
    public void setFlujoVaginal(Short flujoVaginal) {
        this.flujoVaginal = flujoVaginal;
    }

    @Generated
    public void setCefaleaPersistente(Short cefaleaPersistente) {
        this.cefaleaPersistente = cefaleaPersistente;
    }

    @Generated
    public void setNauseasVomito(Short nauseasVomito) {
        this.nauseasVomito = nauseasVomito;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof RegistroSignosVitalesDto)) {
            return false;
        }
        RegistroSignosVitalesDto other = (RegistroSignosVitalesDto) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$id = getId();
        Object other$id = other.getId();
        if (this$id == null) {
            if (other$id != null) {
                return false;
            }
        } else if (!this$id.equals(other$id)) {
            return false;
        }
        Object this$idAtencion = getIdAtencion();
        Object other$idAtencion = other.getIdAtencion();
        if (this$idAtencion == null) {
            if (other$idAtencion != null) {
                return false;
            }
        } else if (!this$idAtencion.equals(other$idAtencion)) {
            return false;
        }
        Object this$idUsuarioPrograma = getIdUsuarioPrograma();
        Object other$idUsuarioPrograma = other.getIdUsuarioPrograma();
        if (this$idUsuarioPrograma == null) {
            if (other$idUsuarioPrograma != null) {
                return false;
            }
        } else if (!this$idUsuarioPrograma.equals(other$idUsuarioPrograma)) {
            return false;
        }
        Object this$tensionArterialSentadoD = getTensionArterialSentadoD();
        Object other$tensionArterialSentadoD = other.getTensionArterialSentadoD();
        if (this$tensionArterialSentadoD == null) {
            if (other$tensionArterialSentadoD != null) {
                return false;
            }
        } else if (!this$tensionArterialSentadoD.equals(other$tensionArterialSentadoD)) {
            return false;
        }
        Object this$tensionArterialSentadoS = getTensionArterialSentadoS();
        Object other$tensionArterialSentadoS = other.getTensionArterialSentadoS();
        if (this$tensionArterialSentadoS == null) {
            if (other$tensionArterialSentadoS != null) {
                return false;
            }
        } else if (!this$tensionArterialSentadoS.equals(other$tensionArterialSentadoS)) {
            return false;
        }
        Object this$tensionArterialAcostadoD = getTensionArterialAcostadoD();
        Object other$tensionArterialAcostadoD = other.getTensionArterialAcostadoD();
        if (this$tensionArterialAcostadoD == null) {
            if (other$tensionArterialAcostadoD != null) {
                return false;
            }
        } else if (!this$tensionArterialAcostadoD.equals(other$tensionArterialAcostadoD)) {
            return false;
        }
        Object this$tensionArterialAcostadoS = getTensionArterialAcostadoS();
        Object other$tensionArterialAcostadoS = other.getTensionArterialAcostadoS();
        if (this$tensionArterialAcostadoS == null) {
            if (other$tensionArterialAcostadoS != null) {
                return false;
            }
        } else if (!this$tensionArterialAcostadoS.equals(other$tensionArterialAcostadoS)) {
            return false;
        }
        Object this$tensionArterialPieD = getTensionArterialPieD();
        Object other$tensionArterialPieD = other.getTensionArterialPieD();
        if (this$tensionArterialPieD == null) {
            if (other$tensionArterialPieD != null) {
                return false;
            }
        } else if (!this$tensionArterialPieD.equals(other$tensionArterialPieD)) {
            return false;
        }
        Object this$tensionArterialPieS = getTensionArterialPieS();
        Object other$tensionArterialPieS = other.getTensionArterialPieS();
        if (this$tensionArterialPieS == null) {
            if (other$tensionArterialPieS != null) {
                return false;
            }
        } else if (!this$tensionArterialPieS.equals(other$tensionArterialPieS)) {
            return false;
        }
        Object this$tensionArterialMedia = getTensionArterialMedia();
        Object other$tensionArterialMedia = other.getTensionArterialMedia();
        if (this$tensionArterialMedia == null) {
            if (other$tensionArterialMedia != null) {
                return false;
            }
        } else if (!this$tensionArterialMedia.equals(other$tensionArterialMedia)) {
            return false;
        }
        Object this$controlTA = getControlTA();
        Object other$controlTA = other.getControlTA();
        if (this$controlTA == null) {
            if (other$controlTA != null) {
                return false;
            }
        } else if (!this$controlTA.equals(other$controlTA)) {
            return false;
        }
        Object this$fecuencuaCardiaca = getFecuencuaCardiaca();
        Object other$fecuencuaCardiaca = other.getFecuencuaCardiaca();
        if (this$fecuencuaCardiaca == null) {
            if (other$fecuencuaCardiaca != null) {
                return false;
            }
        } else if (!this$fecuencuaCardiaca.equals(other$fecuencuaCardiaca)) {
            return false;
        }
        Object this$frecuenciaRespiratoria = getFrecuenciaRespiratoria();
        Object other$frecuenciaRespiratoria = other.getFrecuenciaRespiratoria();
        if (this$frecuenciaRespiratoria == null) {
            if (other$frecuenciaRespiratoria != null) {
                return false;
            }
        } else if (!this$frecuenciaRespiratoria.equals(other$frecuenciaRespiratoria)) {
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
        Object this$imc = getImc();
        Object other$imc = other.getImc();
        if (this$imc == null) {
            if (other$imc != null) {
                return false;
            }
        } else if (!this$imc.equals(other$imc)) {
            return false;
        }
        Object this$temperatura = getTemperatura();
        Object other$temperatura = other.getTemperatura();
        if (this$temperatura == null) {
            if (other$temperatura != null) {
                return false;
            }
        } else if (!this$temperatura.equals(other$temperatura)) {
            return false;
        }
        Object this$ps2 = getPs2();
        Object other$ps2 = other.getPs2();
        if (this$ps2 == null) {
            if (other$ps2 != null) {
                return false;
            }
        } else if (!this$ps2.equals(other$ps2)) {
            return false;
        }
        Object this$controlDm = getControlDm();
        Object other$controlDm = other.getControlDm();
        if (this$controlDm == null) {
            if (other$controlDm != null) {
                return false;
            }
        } else if (!this$controlDm.equals(other$controlDm)) {
            return false;
        }
        Object this$valorGlicemia = getValorGlicemia();
        Object other$valorGlicemia = other.getValorGlicemia();
        if (this$valorGlicemia == null) {
            if (other$valorGlicemia != null) {
                return false;
            }
        } else if (!this$valorGlicemia.equals(other$valorGlicemia)) {
            return false;
        }
        Object this$perimetroCefalico = getPerimetroCefalico();
        Object other$perimetroCefalico = other.getPerimetroCefalico();
        if (this$perimetroCefalico == null) {
            if (other$perimetroCefalico != null) {
                return false;
            }
        } else if (!this$perimetroCefalico.equals(other$perimetroCefalico)) {
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
        Object this$perimetroBrazo = getPerimetroBrazo();
        Object other$perimetroBrazo = other.getPerimetroBrazo();
        if (this$perimetroBrazo == null) {
            if (other$perimetroBrazo != null) {
                return false;
            }
        } else if (!this$perimetroBrazo.equals(other$perimetroBrazo)) {
            return false;
        }
        Object this$idCRiesgo = getIdCRiesgo();
        Object other$idCRiesgo = other.getIdCRiesgo();
        if (this$idCRiesgo == null) {
            if (other$idCRiesgo != null) {
                return false;
            }
        } else if (!this$idCRiesgo.equals(other$idCRiesgo)) {
            return false;
        }
        Object this$semanasGestacion = getSemanasGestacion();
        Object other$semanasGestacion = other.getSemanasGestacion();
        if (this$semanasGestacion == null) {
            if (other$semanasGestacion != null) {
                return false;
            }
        } else if (!this$semanasGestacion.equals(other$semanasGestacion)) {
            return false;
        }
        Object this$alturaUterina = getAlturaUterina();
        Object other$alturaUterina = other.getAlturaUterina();
        if (this$alturaUterina == null) {
            if (other$alturaUterina != null) {
                return false;
            }
        } else if (!this$alturaUterina.equals(other$alturaUterina)) {
            return false;
        }
        Object this$frecuenciaCFh1 = getFrecuenciaCFh1();
        Object other$frecuenciaCFh1 = other.getFrecuenciaCFh1();
        if (this$frecuenciaCFh1 == null) {
            if (other$frecuenciaCFh1 != null) {
                return false;
            }
        } else if (!this$frecuenciaCFh1.equals(other$frecuenciaCFh1)) {
            return false;
        }
        Object this$frecuenciaCFh2 = getFrecuenciaCFh2();
        Object other$frecuenciaCFh2 = other.getFrecuenciaCFh2();
        if (this$frecuenciaCFh2 == null) {
            if (other$frecuenciaCFh2 != null) {
                return false;
            }
        } else if (!this$frecuenciaCFh2.equals(other$frecuenciaCFh2)) {
            return false;
        }
        Object this$embarazo = getEmbarazo();
        Object other$embarazo = other.getEmbarazo();
        if (this$embarazo == null) {
            if (other$embarazo != null) {
                return false;
            }
        } else if (!this$embarazo.equals(other$embarazo)) {
            return false;
        }
        Object this$metaHb = getMetaHb();
        Object other$metaHb = other.getMetaHb();
        if (this$metaHb == null) {
            if (other$metaHb != null) {
                return false;
            }
        } else if (!this$metaHb.equals(other$metaHb)) {
            return false;
        }
        Object this$pesoIdeal = getPesoIdeal();
        Object other$pesoIdeal = other.getPesoIdeal();
        if (this$pesoIdeal == null) {
            if (other$pesoIdeal != null) {
                return false;
            }
        } else if (!this$pesoIdeal.equals(other$pesoIdeal)) {
            return false;
        }
        Object this$peGrasa = getPeGrasa();
        Object other$peGrasa = other.getPeGrasa();
        if (this$peGrasa == null) {
            if (other$peGrasa != null) {
                return false;
            }
        } else if (!this$peGrasa.equals(other$peGrasa)) {
            return false;
        }
        Object this$egEsfuerzo = getEgEsfuerzo();
        Object other$egEsfuerzo = other.getEgEsfuerzo();
        if (this$egEsfuerzo == null) {
            if (other$egEsfuerzo != null) {
                return false;
            }
        } else if (!this$egEsfuerzo.equals(other$egEsfuerzo)) {
            return false;
        }
        Object this$flexibilidad = getFlexibilidad();
        Object other$flexibilidad = other.getFlexibilidad();
        if (this$flexibilidad == null) {
            if (other$flexibilidad != null) {
                return false;
            }
        } else if (!this$flexibilidad.equals(other$flexibilidad)) {
            return false;
        }
        Object this$clasificacionRiesgoDm = getClasificacionRiesgoDm();
        Object other$clasificacionRiesgoDm = other.getClasificacionRiesgoDm();
        if (this$clasificacionRiesgoDm == null) {
            if (other$clasificacionRiesgoDm != null) {
                return false;
            }
        } else if (!this$clasificacionRiesgoDm.equals(other$clasificacionRiesgoDm)) {
            return false;
        }
        Object this$clasificacionRiesgoHta = getClasificacionRiesgoHta();
        Object other$clasificacionRiesgoHta = other.getClasificacionRiesgoHta();
        if (this$clasificacionRiesgoHta == null) {
            if (other$clasificacionRiesgoHta != null) {
                return false;
            }
        } else if (!this$clasificacionRiesgoHta.equals(other$clasificacionRiesgoHta)) {
            return false;
        }
        Object this$resultadoVMAX = getResultadoVMAX();
        Object other$resultadoVMAX = other.getResultadoVMAX();
        if (this$resultadoVMAX == null) {
            if (other$resultadoVMAX != null) {
                return false;
            }
        } else if (!this$resultadoVMAX.equals(other$resultadoVMAX)) {
            return false;
        }
        Object this$vmax = getVmax();
        Object other$vmax = other.getVmax();
        if (this$vmax == null) {
            if (other$vmax != null) {
                return false;
            }
        } else if (!this$vmax.equals(other$vmax)) {
            return false;
        }
        Object this$frecMax = getFrecMax();
        Object other$frecMax = other.getFrecMax();
        if (this$frecMax == null) {
            if (other$frecMax != null) {
                return false;
            }
        } else if (!this$frecMax.equals(other$frecMax)) {
            return false;
        }
        Object this$frecMaxAlc = getFrecMaxAlc();
        Object other$frecMaxAlc = other.getFrecMaxAlc();
        if (this$frecMaxAlc == null) {
            if (other$frecMaxAlc != null) {
                return false;
            }
        } else if (!this$frecMaxAlc.equals(other$frecMaxAlc)) {
            return false;
        }
        Object this$irc = getIrc();
        Object other$irc = other.getIrc();
        if (this$irc == null) {
            if (other$irc != null) {
                return false;
            }
        } else if (!this$irc.equals(other$irc)) {
            return false;
        }
        Object this$tensionASistolicaT = getTensionASistolicaT();
        Object other$tensionASistolicaT = other.getTensionASistolicaT();
        if (this$tensionASistolicaT == null) {
            if (other$tensionASistolicaT != null) {
                return false;
            }
        } else if (!this$tensionASistolicaT.equals(other$tensionASistolicaT)) {
            return false;
        }
        Object this$resultadoITB = getResultadoITB();
        Object other$resultadoITB = other.getResultadoITB();
        if (this$resultadoITB == null) {
            if (other$resultadoITB != null) {
                return false;
            }
        } else if (!this$resultadoITB.equals(other$resultadoITB)) {
            return false;
        }
        Object this$idRemoto = getIdRemoto();
        Object other$idRemoto = other.getIdRemoto();
        if (this$idRemoto == null) {
            if (other$idRemoto != null) {
                return false;
            }
        } else if (!this$idRemoto.equals(other$idRemoto)) {
            return false;
        }
        Object this$perimetroBranquial = getPerimetroBranquial();
        Object other$perimetroBranquial = other.getPerimetroBranquial();
        if (this$perimetroBranquial == null) {
            if (other$perimetroBranquial != null) {
                return false;
            }
        } else if (!this$perimetroBranquial.equals(other$perimetroBranquial)) {
            return false;
        }
        Object this$perimetroPantorrilla = getPerimetroPantorrilla();
        Object other$perimetroPantorrilla = other.getPerimetroPantorrilla();
        if (this$perimetroPantorrilla == null) {
            if (other$perimetroPantorrilla != null) {
                return false;
            }
        } else if (!this$perimetroPantorrilla.equals(other$perimetroPantorrilla)) {
            return false;
        }
        Object this$sintomatologiaUrinaria = getSintomatologiaUrinaria();
        Object other$sintomatologiaUrinaria = other.getSintomatologiaUrinaria();
        if (this$sintomatologiaUrinaria == null) {
            if (other$sintomatologiaUrinaria != null) {
                return false;
            }
        } else if (!this$sintomatologiaUrinaria.equals(other$sintomatologiaUrinaria)) {
            return false;
        }
        Object this$flujoVaginal = getFlujoVaginal();
        Object other$flujoVaginal = other.getFlujoVaginal();
        if (this$flujoVaginal == null) {
            if (other$flujoVaginal != null) {
                return false;
            }
        } else if (!this$flujoVaginal.equals(other$flujoVaginal)) {
            return false;
        }
        Object this$cefaleaPersistente = getCefaleaPersistente();
        Object other$cefaleaPersistente = other.getCefaleaPersistente();
        if (this$cefaleaPersistente == null) {
            if (other$cefaleaPersistente != null) {
                return false;
            }
        } else if (!this$cefaleaPersistente.equals(other$cefaleaPersistente)) {
            return false;
        }
        Object this$nauseasVomito = getNauseasVomito();
        Object other$nauseasVomito = other.getNauseasVomito();
        if (this$nauseasVomito == null) {
            if (other$nauseasVomito != null) {
                return false;
            }
        } else if (!this$nauseasVomito.equals(other$nauseasVomito)) {
            return false;
        }
        Object this$estadoGeneral = getEstadoGeneral();
        Object other$estadoGeneral = other.getEstadoGeneral();
        if (this$estadoGeneral == null) {
            if (other$estadoGeneral != null) {
                return false;
            }
        } else if (!this$estadoGeneral.equals(other$estadoGeneral)) {
            return false;
        }
        Object this$estadoConciencia = getEstadoConciencia();
        Object other$estadoConciencia = other.getEstadoConciencia();
        if (this$estadoConciencia == null) {
            if (other$estadoConciencia != null) {
                return false;
            }
        } else if (!this$estadoConciencia.equals(other$estadoConciencia)) {
            return false;
        }
        Object this$tensionArterialSentado = getTensionArterialSentado();
        Object other$tensionArterialSentado = other.getTensionArterialSentado();
        if (this$tensionArterialSentado == null) {
            if (other$tensionArterialSentado != null) {
                return false;
            }
        } else if (!this$tensionArterialSentado.equals(other$tensionArterialSentado)) {
            return false;
        }
        Object this$tensionArterialAcostado = getTensionArterialAcostado();
        Object other$tensionArterialAcostado = other.getTensionArterialAcostado();
        if (this$tensionArterialAcostado == null) {
            if (other$tensionArterialAcostado != null) {
                return false;
            }
        } else if (!this$tensionArterialAcostado.equals(other$tensionArterialAcostado)) {
            return false;
        }
        Object this$tensionArterialPie = getTensionArterialPie();
        Object other$tensionArterialPie = other.getTensionArterialPie();
        if (this$tensionArterialPie == null) {
            if (other$tensionArterialPie != null) {
                return false;
            }
        } else if (!this$tensionArterialPie.equals(other$tensionArterialPie)) {
            return false;
        }
        Object this$riesgoImc = getRiesgoImc();
        Object other$riesgoImc = other.getRiesgoImc();
        if (this$riesgoImc == null) {
            if (other$riesgoImc != null) {
                return false;
            }
        } else if (!this$riesgoImc.equals(other$riesgoImc)) {
            return false;
        }
        Object this$riesgoObecidad = getRiesgoObecidad();
        Object other$riesgoObecidad = other.getRiesgoObecidad();
        if (this$riesgoObecidad == null) {
            if (other$riesgoObecidad != null) {
                return false;
            }
        } else if (!this$riesgoObecidad.equals(other$riesgoObecidad)) {
            return false;
        }
        Object this$observacion = getObservacion();
        Object other$observacion = other.getObservacion();
        if (this$observacion == null) {
            if (other$observacion != null) {
                return false;
            }
        } else if (!this$observacion.equals(other$observacion)) {
            return false;
        }
        Object this$riesgoPerimetoAbdominal = getRiesgoPerimetoAbdominal();
        Object other$riesgoPerimetoAbdominal = other.getRiesgoPerimetoAbdominal();
        if (this$riesgoPerimetoAbdominal == null) {
            if (other$riesgoPerimetoAbdominal != null) {
                return false;
            }
        } else if (!this$riesgoPerimetoAbdominal.equals(other$riesgoPerimetoAbdominal)) {
            return false;
        }
        Object this$PresentacionFetalH1 = getPresentacionFetalH1();
        Object other$PresentacionFetalH1 = other.getPresentacionFetalH1();
        if (this$PresentacionFetalH1 == null) {
            if (other$PresentacionFetalH1 != null) {
                return false;
            }
        } else if (!this$PresentacionFetalH1.equals(other$PresentacionFetalH1)) {
            return false;
        }
        Object this$PresentacionFetalH2 = getPresentacionFetalH2();
        Object other$PresentacionFetalH2 = other.getPresentacionFetalH2();
        if (this$PresentacionFetalH2 == null) {
            if (other$PresentacionFetalH2 != null) {
                return false;
            }
        } else if (!this$PresentacionFetalH2.equals(other$PresentacionFetalH2)) {
            return false;
        }
        Object this$movFetalH1 = getMovFetalH1();
        Object other$movFetalH1 = other.getMovFetalH1();
        if (this$movFetalH1 == null) {
            if (other$movFetalH1 != null) {
                return false;
            }
        } else if (!this$movFetalH1.equals(other$movFetalH1)) {
            return false;
        }
        Object this$movFetalH2 = getMovFetalH2();
        Object other$movFetalH2 = other.getMovFetalH2();
        if (this$movFetalH2 == null) {
            if (other$movFetalH2 != null) {
                return false;
            }
        } else if (!this$movFetalH2.equals(other$movFetalH2)) {
            return false;
        }
        Object this$valoracionCuelloUterino = getValoracionCuelloUterino();
        Object other$valoracionCuelloUterino = other.getValoracionCuelloUterino();
        if (this$valoracionCuelloUterino == null) {
            if (other$valoracionCuelloUterino != null) {
                return false;
            }
        } else if (!this$valoracionCuelloUterino.equals(other$valoracionCuelloUterino)) {
            return false;
        }
        Object this$edemas = getEdemas();
        Object other$edemas = other.getEdemas();
        if (this$edemas == null) {
            if (other$edemas != null) {
                return false;
            }
        } else if (!this$edemas.equals(other$edemas)) {
            return false;
        }
        Object this$sintomaPEclampsia = getSintomaPEclampsia();
        Object other$sintomaPEclampsia = other.getSintomaPEclampsia();
        if (this$sintomaPEclampsia == null) {
            if (other$sintomaPEclampsia != null) {
                return false;
            }
        } else if (!this$sintomaPEclampsia.equals(other$sintomaPEclampsia)) {
            return false;
        }
        Object this$saludOral = getSaludOral();
        Object other$saludOral = other.getSaludOral();
        if (this$saludOral == null) {
            if (other$saludOral != null) {
                return false;
            }
        } else if (!this$saludOral.equals(other$saludOral)) {
            return false;
        }
        Object this$rePGrasa = getRePGrasa();
        Object other$rePGrasa = other.getRePGrasa();
        if (this$rePGrasa == null) {
            if (other$rePGrasa != null) {
                return false;
            }
        } else if (!this$rePGrasa.equals(other$rePGrasa)) {
            return false;
        }
        Object this$registroFlexibilidad = getRegistroFlexibilidad();
        Object other$registroFlexibilidad = other.getRegistroFlexibilidad();
        if (this$registroFlexibilidad == null) {
            if (other$registroFlexibilidad != null) {
                return false;
            }
        } else if (!this$registroFlexibilidad.equals(other$registroFlexibilidad)) {
            return false;
        }
        Object this$claVMAX = getClaVMAX();
        Object other$claVMAX = other.getClaVMAX();
        if (this$claVMAX == null) {
            if (other$claVMAX != null) {
                return false;
            }
        } else if (!this$claVMAX.equals(other$claVMAX)) {
            return false;
        }
        Object this$resultadoFrecMax = getResultadoFrecMax();
        Object other$resultadoFrecMax = other.getResultadoFrecMax();
        if (this$resultadoFrecMax == null) {
            if (other$resultadoFrecMax != null) {
                return false;
            }
        } else if (!this$resultadoFrecMax.equals(other$resultadoFrecMax)) {
            return false;
        }
        Object this$claIRC = getClaIRC();
        Object other$claIRC = other.getClaIRC();
        if (this$claIRC == null) {
            if (other$claIRC != null) {
                return false;
            }
        } else if (!this$claIRC.equals(other$claIRC)) {
            return false;
        }
        Object this$claITB = getClaITB();
        Object other$claITB = other.getClaITB();
        if (this$claITB == null) {
            if (other$claITB != null) {
                return false;
            }
        } else if (!this$claITB.equals(other$claITB)) {
            return false;
        }
        Object this$autoExamenSeno = getAutoExamenSeno();
        Object other$autoExamenSeno = other.getAutoExamenSeno();
        if (this$autoExamenSeno == null) {
            if (other$autoExamenSeno != null) {
                return false;
            }
        } else if (!this$autoExamenSeno.equals(other$autoExamenSeno)) {
            return false;
        }
        Object this$fecha = getFecha();
        Object other$fecha = other.getFecha();
        if (this$fecha == null) {
            if (other$fecha != null) {
                return false;
            }
        } else if (!this$fecha.equals(other$fecha)) {
            return false;
        }
        Object this$usuarioS = getUsuarioS();
        Object other$usuarioS = other.getUsuarioS();
        return this$usuarioS == null ? other$usuarioS == null : this$usuarioS.equals(other$usuarioS);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof RegistroSignosVitalesDto;
    }

    @Generated
    public int hashCode() {
        Object $id = getId();
        int result = (1 * 59) + ($id == null ? 43 : $id.hashCode());
        Object $idAtencion = getIdAtencion();
        int result2 = (result * 59) + ($idAtencion == null ? 43 : $idAtencion.hashCode());
        Object $idUsuarioPrograma = getIdUsuarioPrograma();
        int result3 = (result2 * 59) + ($idUsuarioPrograma == null ? 43 : $idUsuarioPrograma.hashCode());
        Object $tensionArterialSentadoD = getTensionArterialSentadoD();
        int result4 = (result3 * 59) + ($tensionArterialSentadoD == null ? 43 : $tensionArterialSentadoD.hashCode());
        Object $tensionArterialSentadoS = getTensionArterialSentadoS();
        int result5 = (result4 * 59) + ($tensionArterialSentadoS == null ? 43 : $tensionArterialSentadoS.hashCode());
        Object $tensionArterialAcostadoD = getTensionArterialAcostadoD();
        int result6 = (result5 * 59) + ($tensionArterialAcostadoD == null ? 43 : $tensionArterialAcostadoD.hashCode());
        Object $tensionArterialAcostadoS = getTensionArterialAcostadoS();
        int result7 = (result6 * 59) + ($tensionArterialAcostadoS == null ? 43 : $tensionArterialAcostadoS.hashCode());
        Object $tensionArterialPieD = getTensionArterialPieD();
        int result8 = (result7 * 59) + ($tensionArterialPieD == null ? 43 : $tensionArterialPieD.hashCode());
        Object $tensionArterialPieS = getTensionArterialPieS();
        int result9 = (result8 * 59) + ($tensionArterialPieS == null ? 43 : $tensionArterialPieS.hashCode());
        Object $tensionArterialMedia = getTensionArterialMedia();
        int result10 = (result9 * 59) + ($tensionArterialMedia == null ? 43 : $tensionArterialMedia.hashCode());
        Object $controlTA = getControlTA();
        int result11 = (result10 * 59) + ($controlTA == null ? 43 : $controlTA.hashCode());
        Object $fecuencuaCardiaca = getFecuencuaCardiaca();
        int result12 = (result11 * 59) + ($fecuencuaCardiaca == null ? 43 : $fecuencuaCardiaca.hashCode());
        Object $frecuenciaRespiratoria = getFrecuenciaRespiratoria();
        int result13 = (result12 * 59) + ($frecuenciaRespiratoria == null ? 43 : $frecuenciaRespiratoria.hashCode());
        Object $talla = getTalla();
        int result14 = (result13 * 59) + ($talla == null ? 43 : $talla.hashCode());
        Object $peso = getPeso();
        int result15 = (result14 * 59) + ($peso == null ? 43 : $peso.hashCode());
        Object $imc = getImc();
        int result16 = (result15 * 59) + ($imc == null ? 43 : $imc.hashCode());
        Object $temperatura = getTemperatura();
        int result17 = (result16 * 59) + ($temperatura == null ? 43 : $temperatura.hashCode());
        Object $ps2 = getPs2();
        int result18 = (result17 * 59) + ($ps2 == null ? 43 : $ps2.hashCode());
        Object $controlDm = getControlDm();
        int result19 = (result18 * 59) + ($controlDm == null ? 43 : $controlDm.hashCode());
        Object $valorGlicemia = getValorGlicemia();
        int result20 = (result19 * 59) + ($valorGlicemia == null ? 43 : $valorGlicemia.hashCode());
        Object $perimetroCefalico = getPerimetroCefalico();
        int result21 = (result20 * 59) + ($perimetroCefalico == null ? 43 : $perimetroCefalico.hashCode());
        Object $perimetroAbdominal = getPerimetroAbdominal();
        int result22 = (result21 * 59) + ($perimetroAbdominal == null ? 43 : $perimetroAbdominal.hashCode());
        Object $perimetroBrazo = getPerimetroBrazo();
        int result23 = (result22 * 59) + ($perimetroBrazo == null ? 43 : $perimetroBrazo.hashCode());
        Object $idCRiesgo = getIdCRiesgo();
        int result24 = (result23 * 59) + ($idCRiesgo == null ? 43 : $idCRiesgo.hashCode());
        Object $semanasGestacion = getSemanasGestacion();
        int result25 = (result24 * 59) + ($semanasGestacion == null ? 43 : $semanasGestacion.hashCode());
        Object $alturaUterina = getAlturaUterina();
        int result26 = (result25 * 59) + ($alturaUterina == null ? 43 : $alturaUterina.hashCode());
        Object $frecuenciaCFh1 = getFrecuenciaCFh1();
        int result27 = (result26 * 59) + ($frecuenciaCFh1 == null ? 43 : $frecuenciaCFh1.hashCode());
        Object $frecuenciaCFh2 = getFrecuenciaCFh2();
        int result28 = (result27 * 59) + ($frecuenciaCFh2 == null ? 43 : $frecuenciaCFh2.hashCode());
        Object $embarazo = getEmbarazo();
        int result29 = (result28 * 59) + ($embarazo == null ? 43 : $embarazo.hashCode());
        Object $metaHb = getMetaHb();
        int result30 = (result29 * 59) + ($metaHb == null ? 43 : $metaHb.hashCode());
        Object $pesoIdeal = getPesoIdeal();
        int result31 = (result30 * 59) + ($pesoIdeal == null ? 43 : $pesoIdeal.hashCode());
        Object $peGrasa = getPeGrasa();
        int result32 = (result31 * 59) + ($peGrasa == null ? 43 : $peGrasa.hashCode());
        Object $egEsfuerzo = getEgEsfuerzo();
        int result33 = (result32 * 59) + ($egEsfuerzo == null ? 43 : $egEsfuerzo.hashCode());
        Object $flexibilidad = getFlexibilidad();
        int result34 = (result33 * 59) + ($flexibilidad == null ? 43 : $flexibilidad.hashCode());
        Object $clasificacionRiesgoDm = getClasificacionRiesgoDm();
        int result35 = (result34 * 59) + ($clasificacionRiesgoDm == null ? 43 : $clasificacionRiesgoDm.hashCode());
        Object $clasificacionRiesgoHta = getClasificacionRiesgoHta();
        int result36 = (result35 * 59) + ($clasificacionRiesgoHta == null ? 43 : $clasificacionRiesgoHta.hashCode());
        Object $resultadoVMAX = getResultadoVMAX();
        int result37 = (result36 * 59) + ($resultadoVMAX == null ? 43 : $resultadoVMAX.hashCode());
        Object $vmax = getVmax();
        int result38 = (result37 * 59) + ($vmax == null ? 43 : $vmax.hashCode());
        Object $frecMax = getFrecMax();
        int result39 = (result38 * 59) + ($frecMax == null ? 43 : $frecMax.hashCode());
        Object $frecMaxAlc = getFrecMaxAlc();
        int result40 = (result39 * 59) + ($frecMaxAlc == null ? 43 : $frecMaxAlc.hashCode());
        Object $irc = getIrc();
        int result41 = (result40 * 59) + ($irc == null ? 43 : $irc.hashCode());
        Object $tensionASistolicaT = getTensionASistolicaT();
        int result42 = (result41 * 59) + ($tensionASistolicaT == null ? 43 : $tensionASistolicaT.hashCode());
        Object $resultadoITB = getResultadoITB();
        int result43 = (result42 * 59) + ($resultadoITB == null ? 43 : $resultadoITB.hashCode());
        Object $idRemoto = getIdRemoto();
        int result44 = (result43 * 59) + ($idRemoto == null ? 43 : $idRemoto.hashCode());
        Object $perimetroBranquial = getPerimetroBranquial();
        int result45 = (result44 * 59) + ($perimetroBranquial == null ? 43 : $perimetroBranquial.hashCode());
        Object $perimetroPantorrilla = getPerimetroPantorrilla();
        int result46 = (result45 * 59) + ($perimetroPantorrilla == null ? 43 : $perimetroPantorrilla.hashCode());
        Object $sintomatologiaUrinaria = getSintomatologiaUrinaria();
        int result47 = (result46 * 59) + ($sintomatologiaUrinaria == null ? 43 : $sintomatologiaUrinaria.hashCode());
        Object $flujoVaginal = getFlujoVaginal();
        int result48 = (result47 * 59) + ($flujoVaginal == null ? 43 : $flujoVaginal.hashCode());
        Object $cefaleaPersistente = getCefaleaPersistente();
        int result49 = (result48 * 59) + ($cefaleaPersistente == null ? 43 : $cefaleaPersistente.hashCode());
        Object $nauseasVomito = getNauseasVomito();
        int result50 = (result49 * 59) + ($nauseasVomito == null ? 43 : $nauseasVomito.hashCode());
        Object $estadoGeneral = getEstadoGeneral();
        int result51 = (result50 * 59) + ($estadoGeneral == null ? 43 : $estadoGeneral.hashCode());
        Object $estadoConciencia = getEstadoConciencia();
        int result52 = (result51 * 59) + ($estadoConciencia == null ? 43 : $estadoConciencia.hashCode());
        Object $tensionArterialSentado = getTensionArterialSentado();
        int result53 = (result52 * 59) + ($tensionArterialSentado == null ? 43 : $tensionArterialSentado.hashCode());
        Object $tensionArterialAcostado = getTensionArterialAcostado();
        int result54 = (result53 * 59) + ($tensionArterialAcostado == null ? 43 : $tensionArterialAcostado.hashCode());
        Object $tensionArterialPie = getTensionArterialPie();
        int result55 = (result54 * 59) + ($tensionArterialPie == null ? 43 : $tensionArterialPie.hashCode());
        Object $riesgoImc = getRiesgoImc();
        int result56 = (result55 * 59) + ($riesgoImc == null ? 43 : $riesgoImc.hashCode());
        Object $riesgoObecidad = getRiesgoObecidad();
        int result57 = (result56 * 59) + ($riesgoObecidad == null ? 43 : $riesgoObecidad.hashCode());
        Object $observacion = getObservacion();
        int result58 = (result57 * 59) + ($observacion == null ? 43 : $observacion.hashCode());
        Object $riesgoPerimetoAbdominal = getRiesgoPerimetoAbdominal();
        int result59 = (result58 * 59) + ($riesgoPerimetoAbdominal == null ? 43 : $riesgoPerimetoAbdominal.hashCode());
        Object $PresentacionFetalH1 = getPresentacionFetalH1();
        int result60 = (result59 * 59) + ($PresentacionFetalH1 == null ? 43 : $PresentacionFetalH1.hashCode());
        Object $PresentacionFetalH2 = getPresentacionFetalH2();
        int result61 = (result60 * 59) + ($PresentacionFetalH2 == null ? 43 : $PresentacionFetalH2.hashCode());
        Object $movFetalH1 = getMovFetalH1();
        int result62 = (result61 * 59) + ($movFetalH1 == null ? 43 : $movFetalH1.hashCode());
        Object $movFetalH2 = getMovFetalH2();
        int result63 = (result62 * 59) + ($movFetalH2 == null ? 43 : $movFetalH2.hashCode());
        Object $valoracionCuelloUterino = getValoracionCuelloUterino();
        int result64 = (result63 * 59) + ($valoracionCuelloUterino == null ? 43 : $valoracionCuelloUterino.hashCode());
        Object $edemas = getEdemas();
        int result65 = (result64 * 59) + ($edemas == null ? 43 : $edemas.hashCode());
        Object $sintomaPEclampsia = getSintomaPEclampsia();
        int result66 = (result65 * 59) + ($sintomaPEclampsia == null ? 43 : $sintomaPEclampsia.hashCode());
        Object $saludOral = getSaludOral();
        int result67 = (result66 * 59) + ($saludOral == null ? 43 : $saludOral.hashCode());
        Object $rePGrasa = getRePGrasa();
        int result68 = (result67 * 59) + ($rePGrasa == null ? 43 : $rePGrasa.hashCode());
        Object $registroFlexibilidad = getRegistroFlexibilidad();
        int result69 = (result68 * 59) + ($registroFlexibilidad == null ? 43 : $registroFlexibilidad.hashCode());
        Object $claVMAX = getClaVMAX();
        int result70 = (result69 * 59) + ($claVMAX == null ? 43 : $claVMAX.hashCode());
        Object $resultadoFrecMax = getResultadoFrecMax();
        int result71 = (result70 * 59) + ($resultadoFrecMax == null ? 43 : $resultadoFrecMax.hashCode());
        Object $claIRC = getClaIRC();
        int result72 = (result71 * 59) + ($claIRC == null ? 43 : $claIRC.hashCode());
        Object $claITB = getClaITB();
        int result73 = (result72 * 59) + ($claITB == null ? 43 : $claITB.hashCode());
        Object $autoExamenSeno = getAutoExamenSeno();
        int result74 = (result73 * 59) + ($autoExamenSeno == null ? 43 : $autoExamenSeno.hashCode());
        Object $fecha = getFecha();
        int result75 = (result74 * 59) + ($fecha == null ? 43 : $fecha.hashCode());
        Object $usuarioS = getUsuarioS();
        return (result75 * 59) + ($usuarioS == null ? 43 : $usuarioS.hashCode());
    }

    @Generated
    public String toString() {
        return "RegistroSignosVitalesDto(id=" + getId() + ", idAtencion=" + getIdAtencion() + ", idUsuarioPrograma=" + getIdUsuarioPrograma() + ", estadoGeneral=" + getEstadoGeneral() + ", estadoConciencia=" + getEstadoConciencia() + ", tensionArterialSentadoD=" + getTensionArterialSentadoD() + ", tensionArterialSentadoS=" + getTensionArterialSentadoS() + ", tensionArterialAcostadoD=" + getTensionArterialAcostadoD() + ", tensionArterialAcostadoS=" + getTensionArterialAcostadoS() + ", tensionArterialPieD=" + getTensionArterialPieD() + ", tensionArterialPieS=" + getTensionArterialPieS() + ", tensionArterialSentado=" + getTensionArterialSentado() + ", tensionArterialAcostado=" + getTensionArterialAcostado() + ", tensionArterialPie=" + getTensionArterialPie() + ", tensionArterialMedia=" + getTensionArterialMedia() + ", controlTA=" + getControlTA() + ", fecuencuaCardiaca=" + getFecuencuaCardiaca() + ", frecuenciaRespiratoria=" + getFrecuenciaRespiratoria() + ", talla=" + getTalla() + ", peso=" + getPeso() + ", imc=" + getImc() + ", riesgoImc=" + getRiesgoImc() + ", riesgoObecidad=" + getRiesgoObecidad() + ", observacion=" + getObservacion() + ", temperatura=" + getTemperatura() + ", ps2=" + getPs2() + ", controlDm=" + getControlDm() + ", valorGlicemia=" + getValorGlicemia() + ", perimetroCefalico=" + getPerimetroCefalico() + ", perimetroAbdominal=" + getPerimetroAbdominal() + ", perimetroBrazo=" + getPerimetroBrazo() + ", riesgoPerimetoAbdominal=" + getRiesgoPerimetoAbdominal() + ", idCRiesgo=" + getIdCRiesgo() + ", semanasGestacion=" + getSemanasGestacion() + ", alturaUterina=" + getAlturaUterina() + ", frecuenciaCFh1=" + getFrecuenciaCFh1() + ", frecuenciaCFh2=" + getFrecuenciaCFh2() + ", PresentacionFetalH1=" + getPresentacionFetalH1() + ", PresentacionFetalH2=" + getPresentacionFetalH2() + ", movFetalH1=" + getMovFetalH1() + ", movFetalH2=" + getMovFetalH2() + ", valoracionCuelloUterino=" + getValoracionCuelloUterino() + ", edemas=" + getEdemas() + ", sintomaPEclampsia=" + getSintomaPEclampsia() + ", saludOral=" + getSaludOral() + ", embarazo=" + getEmbarazo() + ", metaHb=" + getMetaHb() + ", pesoIdeal=" + getPesoIdeal() + ", peGrasa=" + getPeGrasa() + ", rePGrasa=" + getRePGrasa() + ", egEsfuerzo=" + getEgEsfuerzo() + ", flexibilidad=" + getFlexibilidad() + ", registroFlexibilidad=" + getRegistroFlexibilidad() + ", clasificacionRiesgoDm=" + getClasificacionRiesgoDm() + ", clasificacionRiesgoHta=" + getClasificacionRiesgoHta() + ", resultadoVMAX=" + getResultadoVMAX() + ", vmax=" + getVmax() + ", claVMAX=" + getClaVMAX() + ", frecMax=" + getFrecMax() + ", frecMaxAlc=" + getFrecMaxAlc() + ", resultadoFrecMax=" + getResultadoFrecMax() + ", irc=" + getIrc() + ", claIRC=" + getClaIRC() + ", tensionASistolicaT=" + getTensionASistolicaT() + ", resultadoITB=" + getResultadoITB() + ", claITB=" + getClaITB() + ", idRemoto=" + getIdRemoto() + ", autoExamenSeno=" + getAutoExamenSeno() + ", perimetroBranquial=" + getPerimetroBranquial() + ", perimetroPantorrilla=" + getPerimetroPantorrilla() + ", fecha=" + getFecha() + ", usuarioS=" + getUsuarioS() + ", sintomatologiaUrinaria=" + getSintomatologiaUrinaria() + ", flujoVaginal=" + getFlujoVaginal() + ", cefaleaPersistente=" + getCefaleaPersistente() + ", nauseasVomito=" + getNauseasVomito() + ")";
    }

    @Generated
    public static RegistroSignosVitalesDtoBuilder builder() {
        return new RegistroSignosVitalesDtoBuilder();
    }

    @Generated
    public RegistroSignosVitalesDto(Long id, Long idAtencion, Integer idUsuarioPrograma, String estadoGeneral, String estadoConciencia, Short tensionArterialSentadoD, Short tensionArterialSentadoS, Short tensionArterialAcostadoD, Short tensionArterialAcostadoS, Short tensionArterialPieD, Short tensionArterialPieS, String tensionArterialSentado, String tensionArterialAcostado, String tensionArterialPie, Double tensionArterialMedia, Boolean controlTA, Short fecuencuaCardiaca, Short frecuenciaRespiratoria, Float talla, Float peso, Float imc, String riesgoImc, String riesgoObecidad, String observacion, Double temperatura, Float ps2, Boolean controlDm, Float valorGlicemia, Short perimetroCefalico, Short perimetroAbdominal, Short perimetroBrazo, String riesgoPerimetoAbdominal, Short idCRiesgo, Double semanasGestacion, Double alturaUterina, Short frecuenciaCFh1, Short frecuenciaCFh2, String PresentacionFetalH1, String PresentacionFetalH2, String movFetalH1, String movFetalH2, String valoracionCuelloUterino, String edemas, String sintomaPEclampsia, String saludOral, Boolean embarazo, Double metaHb, Double pesoIdeal, Double peGrasa, String rePGrasa, Double egEsfuerzo, Double flexibilidad, String registroFlexibilidad, Short clasificacionRiesgoDm, Short clasificacionRiesgoHta, Double resultadoVMAX, Double vmax, String claVMAX, Double frecMax, Double frecMaxAlc, String resultadoFrecMax, Double irc, String claIRC, Short tensionASistolicaT, Double resultadoITB, String claITB, Long idRemoto, String autoExamenSeno, Short perimetroBranquial, Short perimetroPantorrilla, Date fecha, String usuarioS, Short sintomatologiaUrinaria, Short flujoVaginal, Short cefaleaPersistente, Short nauseasVomito) {
        this.id = id;
        this.idAtencion = idAtencion;
        this.idUsuarioPrograma = idUsuarioPrograma;
        this.estadoGeneral = estadoGeneral;
        this.estadoConciencia = estadoConciencia;
        this.tensionArterialSentadoD = tensionArterialSentadoD;
        this.tensionArterialSentadoS = tensionArterialSentadoS;
        this.tensionArterialAcostadoD = tensionArterialAcostadoD;
        this.tensionArterialAcostadoS = tensionArterialAcostadoS;
        this.tensionArterialPieD = tensionArterialPieD;
        this.tensionArterialPieS = tensionArterialPieS;
        this.tensionArterialSentado = tensionArterialSentado;
        this.tensionArterialAcostado = tensionArterialAcostado;
        this.tensionArterialPie = tensionArterialPie;
        this.tensionArterialMedia = tensionArterialMedia;
        this.controlTA = controlTA;
        this.fecuencuaCardiaca = fecuencuaCardiaca;
        this.frecuenciaRespiratoria = frecuenciaRespiratoria;
        this.talla = talla;
        this.peso = peso;
        this.imc = imc;
        this.riesgoImc = riesgoImc;
        this.riesgoObecidad = riesgoObecidad;
        this.observacion = observacion;
        this.temperatura = temperatura;
        this.ps2 = ps2;
        this.controlDm = controlDm;
        this.valorGlicemia = valorGlicemia;
        this.perimetroCefalico = perimetroCefalico;
        this.perimetroAbdominal = perimetroAbdominal;
        this.perimetroBrazo = perimetroBrazo;
        this.riesgoPerimetoAbdominal = riesgoPerimetoAbdominal;
        this.idCRiesgo = idCRiesgo;
        this.semanasGestacion = semanasGestacion;
        this.alturaUterina = alturaUterina;
        this.frecuenciaCFh1 = frecuenciaCFh1;
        this.frecuenciaCFh2 = frecuenciaCFh2;
        this.PresentacionFetalH1 = PresentacionFetalH1;
        this.PresentacionFetalH2 = PresentacionFetalH2;
        this.movFetalH1 = movFetalH1;
        this.movFetalH2 = movFetalH2;
        this.valoracionCuelloUterino = valoracionCuelloUterino;
        this.edemas = edemas;
        this.sintomaPEclampsia = sintomaPEclampsia;
        this.saludOral = saludOral;
        this.embarazo = embarazo;
        this.metaHb = metaHb;
        this.pesoIdeal = pesoIdeal;
        this.peGrasa = peGrasa;
        this.rePGrasa = rePGrasa;
        this.egEsfuerzo = egEsfuerzo;
        this.flexibilidad = flexibilidad;
        this.registroFlexibilidad = registroFlexibilidad;
        this.clasificacionRiesgoDm = clasificacionRiesgoDm;
        this.clasificacionRiesgoHta = clasificacionRiesgoHta;
        this.resultadoVMAX = resultadoVMAX;
        this.vmax = vmax;
        this.claVMAX = claVMAX;
        this.frecMax = frecMax;
        this.frecMaxAlc = frecMaxAlc;
        this.resultadoFrecMax = resultadoFrecMax;
        this.irc = irc;
        this.claIRC = claIRC;
        this.tensionASistolicaT = tensionASistolicaT;
        this.resultadoITB = resultadoITB;
        this.claITB = claITB;
        this.idRemoto = idRemoto;
        this.autoExamenSeno = autoExamenSeno;
        this.perimetroBranquial = perimetroBranquial;
        this.perimetroPantorrilla = perimetroPantorrilla;
        this.fecha = fecha;
        this.usuarioS = usuarioS;
        this.sintomatologiaUrinaria = sintomatologiaUrinaria;
        this.flujoVaginal = flujoVaginal;
        this.cefaleaPersistente = cefaleaPersistente;
        this.nauseasVomito = nauseasVomito;
    }

    @Generated
    public RegistroSignosVitalesDto() {
    }

    @Generated
    public Long getId() {
        return this.id;
    }

    @Generated
    public Long getIdAtencion() {
        return this.idAtencion;
    }

    @Generated
    public Integer getIdUsuarioPrograma() {
        return this.idUsuarioPrograma;
    }

    @Generated
    public String getEstadoGeneral() {
        return this.estadoGeneral;
    }

    @Generated
    public String getEstadoConciencia() {
        return this.estadoConciencia;
    }

    @Generated
    public Short getTensionArterialSentadoD() {
        return this.tensionArterialSentadoD;
    }

    @Generated
    public Short getTensionArterialSentadoS() {
        return this.tensionArterialSentadoS;
    }

    @Generated
    public Short getTensionArterialAcostadoD() {
        return this.tensionArterialAcostadoD;
    }

    @Generated
    public Short getTensionArterialAcostadoS() {
        return this.tensionArterialAcostadoS;
    }

    @Generated
    public Short getTensionArterialPieD() {
        return this.tensionArterialPieD;
    }

    @Generated
    public Short getTensionArterialPieS() {
        return this.tensionArterialPieS;
    }

    @Generated
    public String getTensionArterialSentado() {
        return this.tensionArterialSentado;
    }

    @Generated
    public String getTensionArterialAcostado() {
        return this.tensionArterialAcostado;
    }

    @Generated
    public String getTensionArterialPie() {
        return this.tensionArterialPie;
    }

    @Generated
    public Double getTensionArterialMedia() {
        return this.tensionArterialMedia;
    }

    @Generated
    public Boolean getControlTA() {
        return this.controlTA;
    }

    @Generated
    public Short getFecuencuaCardiaca() {
        return this.fecuencuaCardiaca;
    }

    @Generated
    public Short getFrecuenciaRespiratoria() {
        return this.frecuenciaRespiratoria;
    }

    @Generated
    public Float getTalla() {
        return this.talla;
    }

    @Generated
    public Float getPeso() {
        return this.peso;
    }

    @Generated
    public Float getImc() {
        return this.imc;
    }

    @Generated
    public String getRiesgoImc() {
        return this.riesgoImc;
    }

    @Generated
    public String getRiesgoObecidad() {
        return this.riesgoObecidad;
    }

    @Generated
    public String getObservacion() {
        return this.observacion;
    }

    @Generated
    public Double getTemperatura() {
        return this.temperatura;
    }

    @Generated
    public Float getPs2() {
        return this.ps2;
    }

    @Generated
    public Boolean getControlDm() {
        return this.controlDm;
    }

    @Generated
    public Float getValorGlicemia() {
        return this.valorGlicemia;
    }

    @Generated
    public Short getPerimetroCefalico() {
        return this.perimetroCefalico;
    }

    @Generated
    public Short getPerimetroAbdominal() {
        return this.perimetroAbdominal;
    }

    @Generated
    public Short getPerimetroBrazo() {
        return this.perimetroBrazo;
    }

    @Generated
    public String getRiesgoPerimetoAbdominal() {
        return this.riesgoPerimetoAbdominal;
    }

    @Generated
    public Short getIdCRiesgo() {
        return this.idCRiesgo;
    }

    @Generated
    public Double getSemanasGestacion() {
        return this.semanasGestacion;
    }

    @Generated
    public Double getAlturaUterina() {
        return this.alturaUterina;
    }

    @Generated
    public Short getFrecuenciaCFh1() {
        return this.frecuenciaCFh1;
    }

    @Generated
    public Short getFrecuenciaCFh2() {
        return this.frecuenciaCFh2;
    }

    @Generated
    public String getPresentacionFetalH1() {
        return this.PresentacionFetalH1;
    }

    @Generated
    public String getPresentacionFetalH2() {
        return this.PresentacionFetalH2;
    }

    @Generated
    public String getMovFetalH1() {
        return this.movFetalH1;
    }

    @Generated
    public String getMovFetalH2() {
        return this.movFetalH2;
    }

    @Generated
    public String getValoracionCuelloUterino() {
        return this.valoracionCuelloUterino;
    }

    @Generated
    public String getEdemas() {
        return this.edemas;
    }

    @Generated
    public String getSintomaPEclampsia() {
        return this.sintomaPEclampsia;
    }

    @Generated
    public String getSaludOral() {
        return this.saludOral;
    }

    @Generated
    public Boolean getEmbarazo() {
        return this.embarazo;
    }

    @Generated
    public Double getMetaHb() {
        return this.metaHb;
    }

    @Generated
    public Double getPesoIdeal() {
        return this.pesoIdeal;
    }

    @Generated
    public Double getPeGrasa() {
        return this.peGrasa;
    }

    @Generated
    public String getRePGrasa() {
        return this.rePGrasa;
    }

    @Generated
    public Double getEgEsfuerzo() {
        return this.egEsfuerzo;
    }

    @Generated
    public Double getFlexibilidad() {
        return this.flexibilidad;
    }

    @Generated
    public String getRegistroFlexibilidad() {
        return this.registroFlexibilidad;
    }

    @Generated
    public Short getClasificacionRiesgoDm() {
        return this.clasificacionRiesgoDm;
    }

    @Generated
    public Short getClasificacionRiesgoHta() {
        return this.clasificacionRiesgoHta;
    }

    @Generated
    public Double getResultadoVMAX() {
        return this.resultadoVMAX;
    }

    @Generated
    public Double getVmax() {
        return this.vmax;
    }

    @Generated
    public String getClaVMAX() {
        return this.claVMAX;
    }

    @Generated
    public Double getFrecMax() {
        return this.frecMax;
    }

    @Generated
    public Double getFrecMaxAlc() {
        return this.frecMaxAlc;
    }

    @Generated
    public String getResultadoFrecMax() {
        return this.resultadoFrecMax;
    }

    @Generated
    public Double getIrc() {
        return this.irc;
    }

    @Generated
    public String getClaIRC() {
        return this.claIRC;
    }

    @Generated
    public Short getTensionASistolicaT() {
        return this.tensionASistolicaT;
    }

    @Generated
    public Double getResultadoITB() {
        return this.resultadoITB;
    }

    @Generated
    public String getClaITB() {
        return this.claITB;
    }

    @Generated
    public Long getIdRemoto() {
        return this.idRemoto;
    }

    @Generated
    public String getAutoExamenSeno() {
        return this.autoExamenSeno;
    }

    @Generated
    public Short getPerimetroBranquial() {
        return this.perimetroBranquial;
    }

    @Generated
    public Short getPerimetroPantorrilla() {
        return this.perimetroPantorrilla;
    }

    @Generated
    public Date getFecha() {
        return this.fecha;
    }

    @Generated
    public String getUsuarioS() {
        return this.usuarioS;
    }

    @Generated
    public Short getSintomatologiaUrinaria() {
        return this.sintomatologiaUrinaria;
    }

    @Generated
    public Short getFlujoVaginal() {
        return this.flujoVaginal;
    }

    @Generated
    public Short getCefaleaPersistente() {
        return this.cefaleaPersistente;
    }

    @Generated
    public Short getNauseasVomito() {
        return this.nauseasVomito;
    }
}
