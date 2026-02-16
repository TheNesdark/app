package Utilidades.tree;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/tree/GenericTransferable.class */
public class GenericTransferable implements Transferable {
    private Object data;
    private static final DataFlavor[] flavors = new DataFlavor[1];

    public GenericTransferable(Object data) {
        this.data = data;
    }

    public DataFlavor[] getTransferDataFlavors() {
        return flavors;
    }

    public boolean isDataFlavorSupported(DataFlavor flavor) {
        return true;
    }

    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
        return this.data;
    }

    static {
        flavors[0] = DataFlavor.stringFlavor;
    }
}
