package com.genoma.plus.utils;

import Utilidades.CustomPopupMenuListener;
import Utilidades.Metodos;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import lombok.Generated;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/utils/UtilidadesGenericas.class */
public class UtilidadesGenericas<T> {
    private Metodos metodos = new Metodos();
    private SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Generated
    public void setFormato(SimpleDateFormat formato) {
        this.formato = formato;
    }

    @Generated
    public void setMetodos(Metodos metodos) {
        this.metodos = metodos;
    }

    @Generated
    public SimpleDateFormat getFormato() {
        return this.formato;
    }

    @Generated
    public Metodos getMetodos() {
        return this.metodos;
    }

    public void llenarCombo(JComboBox combo, List<T> datos) {
        if (!datos.isEmpty()) {
            combo.removeAllItems();
            if (!combo.getName().equals("empresaMision")) {
                AutoCompleteDecorator.decorate(combo);
            }
            switch (combo.getName()) {
                case "convenio":
                    datos.forEach(e -> {
                        String empresa;
                        if (e.getNbre().equals(e.getIdEmpresaCont().getNbre())) {
                            empresa = e.getNbre();
                        } else {
                            empresa = e.getNbre() + " - ( " + e.getIdEmpresaCont().getNbre() + " )";
                        }
                        combo.addItem(empresa);
                    });
                    if (datos.size() > 1) {
                        combo.setSelectedIndex(-1);
                        break;
                    }
                    break;
                case "convenioEmpresaArmada":
                    datos.forEach(e2 -> {
                        combo.addItem(e2.getNbre());
                    });
                    if (datos.size() > 1) {
                        combo.setSelectedIndex(-1);
                        break;
                    }
                    break;
                case "cuentaCobro":
                    datos.forEach(e3 -> {
                        combo.addItem(e3[0]);
                    });
                    if (datos.size() > 1) {
                        combo.setSelectedIndex(-1);
                        break;
                    }
                    break;
                case "claseCita":
                    datos.forEach(e4 -> {
                        combo.addItem(e4.getNbre());
                    });
                    if (datos.size() > 1) {
                        combo.setSelectedIndex(-1);
                        break;
                    }
                    break;
                case "tipoDocumento":
                    datos.forEach(e5 -> {
                        combo.addItem(e5.getNombre());
                    });
                    if (datos.size() > 1) {
                        combo.setSelectedIndex(-1);
                        break;
                    }
                    break;
                case "tipoDocumentoC":
                    datos.forEach(e6 -> {
                        combo.addItem(e6.getNbre());
                    });
                    if (datos.size() > 1) {
                        combo.setSelectedIndex(-1);
                        break;
                    }
                    break;
                case "sexo":
                    datos.forEach(e7 -> {
                        combo.addItem(e7.getNbre());
                    });
                    if (datos.size() > 1) {
                        combo.setSelectedIndex(-1);
                        break;
                    }
                    break;
                case "estadoCivil":
                    datos.forEach(e8 -> {
                        combo.addItem(e8.getNbre());
                    });
                    if (datos.size() > 1) {
                        combo.setSelectedIndex(-1);
                        break;
                    }
                    break;
                case "barrio":
                    datos.forEach(e9 -> {
                        combo.addItem(e9.getNbre());
                    });
                    if (datos.size() > 1) {
                        combo.setSelectedIndex(-1);
                        break;
                    }
                    break;
                case "tipoEtnia":
                    datos.forEach(e10 -> {
                        combo.addItem(e10.getNbre());
                    });
                    if (datos.size() > 1) {
                        combo.setSelectedIndex(-1);
                        break;
                    }
                    break;
                case "tipoPoblacionEspecial":
                    datos.forEach(e11 -> {
                        combo.addItem(e11.getNbre());
                    });
                    if (datos.size() > 1) {
                        combo.setSelectedIndex(-1);
                        break;
                    }
                    break;
                case "tipoAfiliado":
                    datos.forEach(e12 -> {
                        combo.addItem(e12.getNbre());
                    });
                    if (datos.size() > 1) {
                        combo.setSelectedIndex(-1);
                        break;
                    }
                    break;
                case "tipoAtencion":
                    datos.forEach(e13 -> {
                        combo.addItem(e13.getNbre());
                    });
                    if (datos.size() > 1) {
                        combo.setSelectedIndex(-1);
                        break;
                    }
                    break;
                case "contrato":
                    datos.forEach(e14 -> {
                        combo.addItem(e14.getNbreContrato());
                    });
                    if (datos.size() > 1) {
                        combo.setSelectedIndex(-1);
                        break;
                    }
                    break;
                case "especialidad":
                    datos.forEach(e15 -> {
                        combo.addItem(e15.getNbre());
                    });
                    if (datos.size() > 1) {
                        combo.setSelectedIndex(-1);
                        break;
                    }
                    break;
                case "nivelEstudio":
                    datos.forEach(e16 -> {
                        combo.addItem(e16.getNbre());
                    });
                    if (datos.size() > 1) {
                        combo.setSelectedIndex(-1);
                        break;
                    }
                    break;
                case "cargo":
                    datos.forEach(e17 -> {
                        combo.addItem(e17.getNbre());
                    });
                    if (datos.size() > 1) {
                        combo.setSelectedIndex(-1);
                        break;
                    }
                    break;
                case "servicio":
                    datos.forEach(e18 -> {
                        combo.addItem(e18.getNbre());
                    });
                    if (datos.size() > 1) {
                        combo.setSelectedIndex(-1);
                        break;
                    }
                    break;
                case "centroCosto":
                    datos.forEach(e19 -> {
                        combo.addItem(e19.getNbre());
                    });
                    if (datos.size() > 1) {
                        combo.setSelectedIndex(-1);
                        break;
                    }
                    break;
                case "finProcedimiento":
                    datos.forEach(e20 -> {
                        combo.addItem(e20.getNbre());
                    });
                    if (datos.size() > 1) {
                        combo.setSelectedIndex(-1);
                        break;
                    }
                    break;
                case "ItemsProcSuministro":
                    datos.forEach(e21 -> {
                        combo.addItem(e21.getNombre());
                    });
                    if (datos.size() > 0) {
                        combo.setSelectedIndex(-1);
                        break;
                    }
                    break;
                case "empresaMision":
                    datos.forEach(e22 -> {
                        combo.addItem(e22.getNombre());
                    });
                    if (datos.size() > 1) {
                        combo.setSelectedIndex(-1);
                        break;
                    }
                    break;
                case "profesional":
                    datos.forEach(e23 -> {
                        combo.addItem(e23.getGPersona().getApellido1().concat(" ").concat(e23.getGPersona().getApellido2().concat(" ").concat(e23.getGPersona().getNombre1().concat(" ").concat(e23.getGPersona().getNombre2()))));
                    });
                    if (datos.size() > 0) {
                        combo.setSelectedIndex(-1);
                        break;
                    }
                    break;
                case "municipioResidencia":
                case "municipioNacimiento":
                    datos.forEach(e24 -> {
                        combo.addItem(e24.getNombre());
                    });
                    if (datos.size() > 1) {
                        combo.setSelectedIndex(-1);
                        break;
                    }
                    break;
                case "subgrupo":
                    System.out.println("subgrupo " + datos.size());
                    datos.forEach(e25 -> {
                        combo.addItem(e25.getSubgruposervicioEntity().getNbre());
                    });
                    if (datos.size() > 1) {
                        combo.setSelectedIndex(-1);
                        break;
                    }
                    break;
                case "forma_pago":
                    System.out.println("subgrupo " + datos.size());
                    datos.forEach(e26 -> {
                        combo.addItem(e26.getNombre());
                    });
                    if (datos.size() > 1) {
                        combo.setSelectedIndex(-1);
                        break;
                    }
                    break;
                case "empresaAtencion":
                    System.out.println("subgrupo " + datos.size());
                    datos.forEach(e27 -> {
                        combo.addItem(e27.getNombre());
                    });
                    if (datos.size() > 1) {
                        combo.setSelectedIndex(-1);
                        break;
                    }
                    break;
                case "medio_pago":
                    System.out.println("subgrupo " + datos.size());
                    datos.forEach(e28 -> {
                        combo.addItem(e28.getNombre());
                    });
                    if (datos.size() > 1) {
                        combo.setSelectedIndex(-1);
                        break;
                    }
                    break;
            }
            combo.addPopupMenuListener(new CustomPopupMenuListener(true, false));
        }
    }

    public String calcularEdadAnnos(Date fechaNacimiento, Date fechaCorte) {
        LocalDate fNacimiento = new java.sql.Date(fechaNacimiento.getTime()).toLocalDate();
        String edad = "" + ChronoUnit.YEARS.between(fNacimiento, new java.sql.Date(fechaCorte.getTime()).toLocalDate());
        return edad;
    }

    public Date getUnirFechaHora(String fecha, String Hora) {
        Date fechaHora;
        System.out.println("" + fecha);
        System.out.println("" + Hora);
        try {
            fechaHora = this.formato.parse(fecha + " " + Hora);
        } catch (ParseException e) {
            fechaHora = new Date();
        }
        return fechaHora;
    }
}
