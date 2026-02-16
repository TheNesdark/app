package Historia;

import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/* JADX INFO: loaded from: GenomaP.jar:Historia/MiImagen.class */
public class MiImagen {
    private int contador_de_objetos = 0;
    private Map map = new HashMap();
    private JPanel contenedor;
    private DefaultListModel listModel;
    public String imagen;

    public MiImagen(JPanel jpanel, DefaultListModel listModel) {
        this.contenedor = jpanel;
        this.listModel = listModel;
    }

    public void Nuevo_Objeto() {
        this.contador_de_objetos++;
        MiObjetoImagen tmp = new MiObjetoImagen("Objeto " + this.contador_de_objetos);
        tmp.setLocation(1, 1);
        tmp.setIcon(new ImageIcon(getClass().getResource("/Imagenes/" + this.imagen)));
        this.map.put("Objeto " + this.contador_de_objetos, tmp);
        this.listModel.addElement("Objeto " + this.contador_de_objetos);
        this.contenedor.add(tmp);
        this.contenedor.repaint();
    }

    public void Ocultar_Punto(String key) {
        MiObjetoImagen tmp = (MiObjetoImagen) this.map.get(key);
        tmp.setVisible(false);
        tmp.repaint();
    }
}
