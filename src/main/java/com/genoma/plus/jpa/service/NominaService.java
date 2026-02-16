package com.genoma.plus.jpa.service;

import co.com.genomaempresarial.ankara.dto.NominaIndividual;
import co.com.genomaempresarial.ankara.dto.NominaIndividualDeAjuste;
import com.genoma.plus.jpa.entity.ConceptoPorEmpleado;
import com.genoma.plus.jpa.entity.EmpleadoPagoProyection;
import com.genoma.plus.jpa.entity.EmpleadoPorNomina;
import com.genoma.plus.jpa.entity.EmpleadorProyection;
import com.genoma.plus.jpa.entity.EmpleadosNomina;
import com.genoma.plus.jpa.entity.IEliminandoPredecesor;
import com.genoma.plus.jpa.entity.INumeroSecuenciaXML;
import com.genoma.plus.jpa.entity.IProveedorXml;
import com.genoma.plus.jpa.entity.LugarDeGeneracion;
import com.genoma.plus.jpa.entity.NovedadesNomina;
import com.genoma.plus.jpa.entity.TRM;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/jpa/service/NominaService.class */
public interface NominaService {
    List<EmpleadoPorNomina> listaEmpleadosPorNomina(Integer num);

    List<ConceptoPorEmpleado> listaConceptoEmpleado(Integer num, Integer num2);

    LugarDeGeneracion lugarDeGeneracion();

    EmpleadorProyection getEmpleador();

    EmpleadoPagoProyection getEmpleadoPagoNomina(Integer num);

    List<EmpleadosNomina> obtenerEmpleados(String str);

    List<NovedadesNomina> obtenerNovedadesNomina(Integer num, Integer num2);

    String enviarNomina(NominaIndividual nominaIndividual, String str, String str2);

    IProveedorXml ObtenerProvedorXML();

    INumeroSecuenciaXML numeroSecuenciaXML(Integer num, Integer num2);

    List<EmpleadoPorNomina> listaEmpleadosPorNominaEnviadas(int i);

    TRM getTMR(String str);

    IEliminandoPredecesor getPredecesor(Integer num, Integer num2);

    String enviarNota(NominaIndividualDeAjuste nominaIndividualDeAjuste);
}
