package General;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/* JADX INFO: loaded from: GenomaP.jar:General/ImportFile_xlsx.class */
public class ImportFile_xlsx {
    private Workbook wb;
    private Object[] listaColumna;
    private int indiceColumna;
    private DefaultTableModel modeloT;

    public String Importar(File archivo, JTable tablaD) {
        String respuesta = "No se pudo realizar la importación";
        this.modeloT = new DefaultTableModel();
        tablaD.setModel(this.modeloT);
        try {
            this.wb = WorkbookFactory.create(new FileInputStream(archivo));
            Sheet hoja = this.wb.getSheetAt(0);
            Iterator<Row> filaIterator = hoja.rowIterator();
            int indiceFila = -1;
            while (filaIterator.hasNext()) {
                indiceFila++;
                Row fila = filaIterator.next();
                Iterator<Cell> columnaIterator = fila.cellIterator();
                this.indiceColumna = -1;
                this.listaColumna = new Object[this.modeloT.getColumnCount()];
                while (columnaIterator.hasNext()) {
                    this.indiceColumna++;
                    Cell celda = columnaIterator.next();
                    if (indiceFila == 0) {
                        this.modeloT.addColumn(celda.getStringCellValue());
                    } else if (celda != null) {
                        switch (celda.getCellType()) {
                            case 0:
                                this.listaColumna[this.indiceColumna] = Double.valueOf(celda.getNumericCellValue());
                                break;
                            case 1:
                                this.listaColumna[this.indiceColumna] = celda.getStringCellValue();
                                break;
                            case 2:
                            case 3:
                            default:
                                this.listaColumna[this.indiceColumna] = celda.getDateCellValue();
                                break;
                            case 4:
                                this.listaColumna[this.indiceColumna] = Boolean.valueOf(celda.getBooleanCellValue());
                                break;
                        }
                    }
                }
                if (indiceFila != 0) {
                    this.modeloT.addRow(this.listaColumna);
                }
            }
            respuesta = "Importación Exitosa";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respuesta;
    }

    public DefaultTableModel getModeloT() {
        return this.modeloT;
    }

    public void setModeloT(DefaultTableModel modeloT) {
        this.modeloT = modeloT;
    }
}
