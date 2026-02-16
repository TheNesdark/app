package Utilidades;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/DisenoLogEquipos.class */
public class DisenoLogEquipos extends Formatter {
    private static final DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss.SSS a");

    @Override // java.util.logging.Formatter
    public String format(LogRecord record) {
        StringBuilder builder = new StringBuilder(1000);
        builder.append(df.format(new Date(record.getMillis()))).append(" - ");
        builder.append("[").append(record.getLevel()).append("] - ");
        builder.append(formatMessage(record));
        builder.append("\n");
        return builder.toString();
    }

    @Override // java.util.logging.Formatter
    public String getHead(Handler h) {
        return super.getHead(h);
    }

    @Override // java.util.logging.Formatter
    public String getTail(Handler h) {
        return super.getTail(h);
    }
}
