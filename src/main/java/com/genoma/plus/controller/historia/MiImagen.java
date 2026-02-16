package com.genoma.plus.controller.historia;

import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/MiImagen.class */
public class MiImagen {
    private JPanel contenedor;
    private DefaultListModel listModel;
    private int contador_de_objetos = 0;
    private Map map = new HashMap();
    public String imagen = "";

    public MiImagen(JPanel jpanel, DefaultListModel listModel) {
        this.contenedor = jpanel;
        this.listModel = listModel;
    }

    public void Nuevo_Objeto(int x, int y) {
        this.contador_de_objetos++;
        MiObjetoImagen tmp = new MiObjetoImagen("Objeto " + this.contador_de_objetos);
        tmp.setLocation(x, y);
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
