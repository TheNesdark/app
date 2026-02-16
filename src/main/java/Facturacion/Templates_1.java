package Facturacion;

import java.awt.Color;
import java.util.Locale;
import net.sf.dynamicreports.report.base.expression.AbstractValueFormatter;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.ReportTemplateBuilder;
import net.sf.dynamicreports.report.builder.component.ComponentBuilder;
import net.sf.dynamicreports.report.builder.datatype.BigDecimalType;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.builder.tableofcontents.TableOfContentsCustomizerBuilder;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.constant.VerticalAlignment;
import net.sf.dynamicreports.report.definition.ReportParameters;

/* JADX INFO: loaded from: GenomaP.jar:Facturacion/Templates_1.class */
public class Templates_1 {
    public static final StyleBuilder rootStyle = DynamicReports.stl.style().setPadding(2);
    public static final StyleBuilder boldStyle = DynamicReports.stl.style(rootStyle).bold();
    public static final StyleBuilder italicStyle = DynamicReports.stl.style(rootStyle).italic();
    public static final StyleBuilder boldCenteredStyle = DynamicReports.stl.style(boldStyle).setAlignment(HorizontalAlignment.CENTER, VerticalAlignment.MIDDLE);
    public static final StyleBuilder bold12CenteredStyle = DynamicReports.stl.style(boldCenteredStyle).setFontSize(12);
    public static final StyleBuilder bold18CenteredStyle = DynamicReports.stl.style(boldCenteredStyle).setFontSize(18);
    public static final StyleBuilder bold22CenteredStyle = DynamicReports.stl.style(boldCenteredStyle).setFontSize(22);
    public static final StyleBuilder columnStyle = DynamicReports.stl.style(rootStyle).setVerticalAlignment(VerticalAlignment.MIDDLE);
    public static final StyleBuilder columnTitleStyle = DynamicReports.stl.style(columnStyle).setBorder(DynamicReports.stl.pen1Point()).setHorizontalAlignment(HorizontalAlignment.CENTER).setBackgroundColor(Color.LIGHT_GRAY).bold();
    public static final StyleBuilder groupStyle = DynamicReports.stl.style(boldStyle).setHorizontalAlignment(HorizontalAlignment.LEFT);
    public static final StyleBuilder subtotalStyle = DynamicReports.stl.style(boldStyle).setTopBorder(DynamicReports.stl.pen1Point());
    public static final ReportTemplateBuilder reportTemplate;
    public static final CurrencyType currencyType;
    public static final ComponentBuilder<?, ?> dynamicReportsComponent;
    public static final ComponentBuilder<?, ?> footerComponent;

    static {
        StyleBuilder crosstabGroupStyle = DynamicReports.stl.style(columnTitleStyle);
        StyleBuilder crosstabGroupTotalStyle = DynamicReports.stl.style(columnTitleStyle).setBackgroundColor(new Color(170, 170, 170));
        StyleBuilder crosstabGrandTotalStyle = DynamicReports.stl.style(columnTitleStyle).setBackgroundColor(new Color(140, 140, 140));
        StyleBuilder crosstabCellStyle = DynamicReports.stl.style(columnStyle).setBorder(DynamicReports.stl.pen1Point());
        TableOfContentsCustomizerBuilder tableOfContentsCustomizer = DynamicReports.tableOfContentsCustomizer().setHeadingStyle(0, DynamicReports.stl.style(rootStyle).bold());
        reportTemplate = DynamicReports.template().setLocale(Locale.ENGLISH).setColumnStyle(columnStyle).setColumnTitleStyle(columnTitleStyle).setGroupStyle(groupStyle).setGroupTitleStyle(groupStyle).setSubtotalStyle(subtotalStyle).highlightDetailEvenRows().crosstabHighlightEvenRows().setCrosstabGroupStyle(crosstabGroupStyle).setCrosstabGroupTotalStyle(crosstabGroupTotalStyle).setCrosstabGrandTotalStyle(crosstabGrandTotalStyle).setCrosstabCellStyle(crosstabCellStyle).setTableOfContentsCustomizer(tableOfContentsCustomizer);
        currencyType = new CurrencyType();
        DynamicReports.hyperLink("http://www.dynamicreports.org");
        dynamicReportsComponent = DynamicReports.cmp.horizontalList(new ComponentBuilder[]{DynamicReports.cmp.image(Templates_1.class.getResource("images/dynamicreports.png")).setFixedDimension(60, 60), DynamicReports.cmp.verticalList(new ComponentBuilder[]{DynamicReports.cmp.image(Templates_1.class.getResource("images/dynamicreports.png")).setFixedDimension(60, 60).setHorizontalAlignment(HorizontalAlignment.LEFT)})}).setFixedWidth(300);
        footerComponent = DynamicReports.cmp.pageXofY().setStyle(DynamicReports.stl.style(boldCenteredStyle).setTopBorder(DynamicReports.stl.pen1Point()));
    }

    public static ComponentBuilder<?, ?> createTitleComponent(String label) {
        return DynamicReports.cmp.horizontalList().add(new ComponentBuilder[]{dynamicReportsComponent});
    }

    public static CurrencyValueFormatter createCurrencyValueFormatter(String label) {
        return new CurrencyValueFormatter(label);
    }

    /* JADX INFO: loaded from: GenomaP.jar:Facturacion/Templates_1$CurrencyType.class */
    public static class CurrencyType extends BigDecimalType {
        private static final long serialVersionUID = 1;

        public String getPattern() {
            return "$ #,###.00";
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Facturacion/Templates_1$CurrencyValueFormatter.class */
    private static class CurrencyValueFormatter extends AbstractValueFormatter<String, Number> {
        private static final long serialVersionUID = 1;
        private String label;

        public CurrencyValueFormatter(String label) {
            this.label = label;
        }

        public String format(Number value, ReportParameters reportParameters) {
            return this.label + Templates_1.currencyType.valueToString(value, reportParameters.getLocale());
        }
    }
}
