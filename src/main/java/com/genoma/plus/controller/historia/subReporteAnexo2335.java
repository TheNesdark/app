package com.genoma.plus.controller.historia;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.component.ComponentBuilder;
import net.sf.dynamicreports.report.builder.component.HorizontalListBuilder;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/subReporteAnexo2335.class */
public class subReporteAnexo2335 {
    private HorizontalListBuilder datelleCups;

    public subReporteAnexo2335(HorizontalListBuilder datelleCups) {
        this.datelleCups = datelleCups;
    }

    public JasperReportBuilder build() {
        JasperReportBuilder report = DynamicReports.report();
        report.title(new ComponentBuilder[]{this.datelleCups});
        return report;
    }
}
