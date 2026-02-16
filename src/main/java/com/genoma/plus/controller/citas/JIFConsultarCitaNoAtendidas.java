package com.genoma.plus.controller.citas;

import Utilidades.ConsultasMySQL;
import Utilidades.CustomPopupMenuListener;
import Utilidades.Metodos;
import com.genoma.plus.dao.citas.InformesCitasDAO;
import com.genoma.plus.dao.impl.citas.InformesCitasDAOImpl;
import com.genoma.plus.dto.citas.ConsultarCitasNoAtendidasDTO;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/citas/JIFConsultarCitaNoAtendidas.class */
public class JIFConsultarCitaNoAtendidas extends JInternalFrame {
    private DefaultTableModel xModelo;
    private Object[] xDato;
    private String[] xidEspecialidad;
    private String[] xidPrograma;
    private String[] xidConvenio;
    private String[] xidProfesional;
    private InformesCitasDAO xInformesCitasDAO;
    private JButton JBTExportar;
    private JComboBox JCBConvenio;
    private JComboBox JCBEspecialidad;
    private JComboBox JCBProfesional;
    private JComboBox JCBPrograma;
    private JCheckBox JCHConvenio;
    private JCheckBox JCHEspecialidad;
    private JCheckBox JCHProfesional;
    private JCheckBox JCHPrograma;
    private JCheckBox JCHTodos;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPDatos;
    private JPanel JPFiltro;
    private JScrollPane JSDetalle;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    private String xNombre = "";
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private boolean xlleno = false;
    private int xvalidar = 0;

    public JIFConsultarCitaNoAtendidas() {
        initComponents();
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xInformesCitasDAO = (InformesCitasDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("informesCitasDAO");
    }

    public void mNuevo() {
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.xvalidar = 1;
        this.JCHTodos.setSelected(false);
        JCHTodosActionPerformed(null);
        this.JCBEspecialidad.removeAllItems();
        this.JCBPrograma.removeAllItems();
        this.JCBConvenio.removeAllItems();
        this.JCBProfesional.removeAllItems();
        mCrearTabla();
    }

    public void mBuscar() {
        if (!this.JCHEspecialidad.isSelected() && !this.JCHPrograma.isSelected() && !this.JCHConvenio.isSelected() && !this.JCHProfesional.isSelected()) {
            mCargarDatosTabla();
            return;
        }
        if (this.JCHEspecialidad.isSelected() && !this.JCHPrograma.isSelected() && !this.JCHConvenio.isSelected() && !this.JCHProfesional.isSelected()) {
            if (this.JCBEspecialidad.getSelectedIndex() != -1) {
                mCargarDatosTabla();
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una Especialidad", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                this.JCBEspecialidad.requestFocus();
                return;
            }
        }
        if (this.JCHEspecialidad.isSelected() && this.JCHPrograma.isSelected() && !this.JCHConvenio.isSelected() && !this.JCHProfesional.isSelected()) {
            if (this.JCBEspecialidad.getSelectedIndex() != -1) {
                if (this.JCBPrograma.getSelectedIndex() != -1) {
                    mCargarDatosTabla();
                    return;
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un Programa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    this.JCBPrograma.requestFocus();
                    return;
                }
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una Especialidad", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            this.JCBEspecialidad.requestFocus();
            return;
        }
        if (this.JCHEspecialidad.isSelected() && !this.JCHPrograma.isSelected() && this.JCHConvenio.isSelected() && !this.JCHProfesional.isSelected()) {
            if (this.JCBEspecialidad.getSelectedIndex() != -1) {
                if (this.JCBConvenio.getSelectedIndex() != -1) {
                    mCargarDatosTabla();
                    return;
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un Convenio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    this.JCBConvenio.requestFocus();
                    return;
                }
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una Especialidad", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            this.JCBEspecialidad.requestFocus();
            return;
        }
        if (this.JCHEspecialidad.isSelected() && !this.JCHPrograma.isSelected() && !this.JCHConvenio.isSelected() && this.JCHProfesional.isSelected()) {
            if (this.JCBEspecialidad.getSelectedIndex() != -1) {
                if (this.JCBProfesional.getSelectedIndex() != -1) {
                    mCargarDatosTabla();
                    return;
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un Profesional", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    this.JCBProfesional.requestFocus();
                    return;
                }
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una Especialidad", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            this.JCBEspecialidad.requestFocus();
            return;
        }
        if (!this.JCHEspecialidad.isSelected() && this.JCHPrograma.isSelected() && !this.JCHConvenio.isSelected() && !this.JCHProfesional.isSelected()) {
            if (this.JCBPrograma.getSelectedIndex() != -1) {
                mCargarDatosTabla();
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una Programa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                this.JCBPrograma.requestFocus();
                return;
            }
        }
        if (!this.JCHEspecialidad.isSelected() && this.JCHPrograma.isSelected() && this.JCHConvenio.isSelected() && !this.JCHProfesional.isSelected()) {
            if (this.JCBPrograma.getSelectedIndex() != -1) {
                if (this.JCBConvenio.getSelectedIndex() != -1) {
                    mCargarDatosTabla();
                    return;
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un Convenio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    this.JCBConvenio.requestFocus();
                    return;
                }
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una Programa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            this.JCBPrograma.requestFocus();
            return;
        }
        if (!this.JCHEspecialidad.isSelected() && this.JCHPrograma.isSelected() && !this.JCHConvenio.isSelected() && this.JCHProfesional.isSelected()) {
            if (this.JCBPrograma.getSelectedIndex() != -1) {
                if (this.JCBProfesional.getSelectedIndex() != -1) {
                    mCargarDatosTabla();
                    return;
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un Profesional", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    this.JCBProfesional.requestFocus();
                    return;
                }
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una Programa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            this.JCBPrograma.requestFocus();
            return;
        }
        if (!this.JCHEspecialidad.isSelected() && !this.JCHPrograma.isSelected() && this.JCHConvenio.isSelected() && !this.JCHProfesional.isSelected()) {
            if (this.JCBConvenio.getSelectedIndex() != -1) {
                mCargarDatosTabla();
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un Convenio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                this.JCBConvenio.requestFocus();
                return;
            }
        }
        if (!this.JCHEspecialidad.isSelected() && !this.JCHPrograma.isSelected() && this.JCHConvenio.isSelected() && this.JCHProfesional.isSelected()) {
            if (this.JCBConvenio.getSelectedIndex() != -1) {
                if (this.JCBProfesional.getSelectedIndex() != -1) {
                    mCargarDatosTabla();
                    return;
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un Profesional", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    this.JCBProfesional.requestFocus();
                    return;
                }
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un Convenio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            this.JCBConvenio.requestFocus();
            return;
        }
        if (!this.JCHEspecialidad.isSelected() && !this.JCHPrograma.isSelected() && !this.JCHConvenio.isSelected() && this.JCHProfesional.isSelected()) {
            if (this.JCBProfesional.getSelectedIndex() != -1) {
                mCargarDatosTabla();
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un Profesional", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                this.JCBProfesional.requestFocus();
                return;
            }
        }
        if (!this.JCHEspecialidad.isSelected() && this.JCHPrograma.isSelected() && this.JCHConvenio.isSelected() && this.JCHProfesional.isSelected()) {
            if (this.JCBProfesional.getSelectedIndex() != -1) {
                if (this.JCBPrograma.getSelectedIndex() != -1) {
                    if (this.JCBConvenio.getSelectedIndex() != -1) {
                        mCargarDatosTabla();
                        return;
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un Convenio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        this.JCBConvenio.requestFocus();
                        return;
                    }
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un Programa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                this.JCBPrograma.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un Profesional", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            this.JCBProfesional.requestFocus();
            return;
        }
        if (this.JCHEspecialidad.isSelected() && !this.JCHPrograma.isSelected() && this.JCHConvenio.isSelected() && this.JCHProfesional.isSelected()) {
            if (this.JCBEspecialidad.getSelectedIndex() != -1) {
                if (this.JCBProfesional.getSelectedIndex() != -1) {
                    if (this.JCBConvenio.getSelectedIndex() != -1) {
                        mCargarDatosTabla();
                        return;
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un Convenio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        this.JCBConvenio.requestFocus();
                        return;
                    }
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un Profesional", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                this.JCBProfesional.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una Especialidad", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            this.JCBEspecialidad.requestFocus();
            return;
        }
        if (this.JCHEspecialidad.isSelected() && this.JCHPrograma.isSelected() && !this.JCHConvenio.isSelected() && this.JCHProfesional.isSelected()) {
            if (this.JCBEspecialidad.getSelectedIndex() != -1) {
                if (this.JCBProfesional.getSelectedIndex() != -1) {
                    if (this.JCBPrograma.getSelectedIndex() != -1) {
                        mCargarDatosTabla();
                        return;
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un Programa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        this.JCBPrograma.requestFocus();
                        return;
                    }
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un Profesional", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                this.JCBProfesional.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una Especialidad", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            this.JCBEspecialidad.requestFocus();
            return;
        }
        if (this.JCHEspecialidad.isSelected() && this.JCHPrograma.isSelected() && this.JCHConvenio.isSelected() && !this.JCHProfesional.isSelected()) {
            if (this.JCBEspecialidad.getSelectedIndex() != -1) {
                if (this.JCBPrograma.getSelectedIndex() != -1) {
                    if (this.JCBConvenio.getSelectedIndex() != -1) {
                        mCargarDatosTabla();
                        return;
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un Convenio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        this.JCBConvenio.requestFocus();
                        return;
                    }
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un Profesional", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                this.JCBProfesional.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una Especialidad", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            this.JCBEspecialidad.requestFocus();
            return;
        }
        if (this.JCHEspecialidad.isSelected() && this.JCHPrograma.isSelected() && this.JCHConvenio.isSelected() && this.JCHProfesional.isSelected()) {
            if (this.JCBEspecialidad.getSelectedIndex() != -1) {
                if (this.JCBProfesional.getSelectedIndex() != -1) {
                    if (this.JCBPrograma.getSelectedIndex() != -1) {
                        if (this.JCBConvenio.getSelectedIndex() != -1) {
                            mCargarDatosTabla();
                            return;
                        } else {
                            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un Convenio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                            this.JCBConvenio.requestFocus();
                            return;
                        }
                    }
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un Programa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    this.JCBPrograma.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un Profesional", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                this.JCBProfesional.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una Especialidad", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            this.JCBEspecialidad.requestFocus();
        }
    }

    public void mImprimir() {
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla() {
        this.xModelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Hora", "Tipo Doc", "No. Documento", "Usuario", "Sexo", "Edad", "Tipo Edad", "Direccion", "Barrio", "Municipio", "Telefono", "Convenio", "Clase de Cita", "Programa", "Especialidad", "Profesional"}) { // from class: com.genoma.plus.controller.citas.JIFConsultarCitaNoAtendidas.1
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class, Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(200);
    }

    private void mCargarDatosTabla() {
        String Con1;
        String Con2;
        String Con3;
        String Con4;
        if (this.JCHEspecialidad.isSelected()) {
            Con1 = "    AND profesional1.`IdEspecialidad` ='" + this.xidEspecialidad[this.JCBEspecialidad.getSelectedIndex()] + "'\n";
        } else {
            Con1 = "";
        }
        if (this.JCHPrograma.isSelected()) {
            Con2 = "    AND `g_tipoprograma`.`Id_TipoPrograma` ='" + this.xidPrograma[this.JCBPrograma.getSelectedIndex()] + "'\n";
        } else {
            Con2 = "";
        }
        if (this.JCHConvenio.isSelected()) {
            Con3 = "    AND `f_empresacontxconvenio`.`Id` ='" + this.xidConvenio[this.JCBConvenio.getSelectedIndex()] + "'\n";
        } else {
            Con3 = "";
        }
        if (this.JCHProfesional.isSelected()) {
            Con4 = "    AND `profesional1`.`Id_Persona` ='" + this.xidProfesional[this.JCBProfesional.getSelectedIndex()] + "'\n";
        } else {
            Con4 = "";
        }
        String Condicion = Con1 + Con2 + Con3 + Con4;
        mCrearTabla();
        List<ConsultarCitasNoAtendidasDTO> list = this.xInformesCitasDAO.listCitasNoAtendidas(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), Condicion);
        for (int x = 0; x < list.size(); x++) {
            this.xModelo.addRow(this.xDato);
            this.xModelo.setValueAt(list.get(x).getIdCita(), x, 0);
            this.xModelo.setValueAt(list.get(x).getFecha(), x, 1);
            this.xModelo.setValueAt(list.get(x).getHora(), x, 2);
            this.xModelo.setValueAt(list.get(x).getTipoDoc(), x, 3);
            this.xModelo.setValueAt(list.get(x).getNDocumento(), x, 4);
            this.xModelo.setValueAt(list.get(x).getUsuario(), x, 5);
            this.xModelo.setValueAt(list.get(x).getSexo(), x, 6);
            this.xModelo.setValueAt(Integer.valueOf(list.get(x).getEdad()), x, 7);
            this.xModelo.setValueAt(list.get(x).getTipoEdad(), x, 8);
            this.xModelo.setValueAt(list.get(x).getDireccion(), x, 9);
            this.xModelo.setValueAt(list.get(x).getBarrio(), x, 10);
            this.xModelo.setValueAt(list.get(x).getMunicipio(), x, 11);
            this.xModelo.setValueAt(list.get(x).getTelefono(), x, 12);
            this.xModelo.setValueAt(list.get(x).getConvenio(), x, 13);
            this.xModelo.setValueAt(list.get(x).getClaseCita(), x, 14);
            this.xModelo.setValueAt(list.get(x).getPrograma(), x, 15);
            this.xModelo.setValueAt(list.get(x).getEspecialidad(), x, 16);
            this.xModelo.setValueAt(list.get(x).getProfesional(), x, 17);
        }
    }

    private void mLLenarCombo() {
        this.xlleno = false;
        this.JCBEspecialidad.removeAllItems();
        List<GCGenericoDTO> list1 = this.xInformesCitasDAO.listEspecialidadNoAtendidas(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
        this.xidEspecialidad = new String[list1.size()];
        for (int x = 0; x < list1.size(); x++) {
            this.xidEspecialidad[x] = String.valueOf(list1.get(x).getId());
            this.JCBEspecialidad.addItem(list1.get(x).getNombre());
            System.out.println("Consulta " + list1.get(x).getId());
            System.out.println("" + list1.get(x).getNombre());
        }
        this.JCBEspecialidad.addPopupMenuListener(new CustomPopupMenuListener(true, false));
        this.JCBEspecialidad.setSelectedIndex(-1);
        this.JCBPrograma.removeAllItems();
        List<GCGenericoDTO> list3 = this.xInformesCitasDAO.listProgramaNoAtendidas(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
        this.xidPrograma = new String[list3.size()];
        for (int x2 = 0; x2 < list3.size(); x2++) {
            this.xidPrograma[x2] = String.valueOf(list3.get(x2).getId());
            this.JCBPrograma.addItem(list3.get(x2).getNombre());
            System.out.println("Consulta " + list3.get(x2).getId());
            System.out.println("" + list3.get(x2).getNombre());
        }
        this.JCBPrograma.addPopupMenuListener(new CustomPopupMenuListener(true, false));
        this.JCBPrograma.setSelectedIndex(-1);
        this.JCBConvenio.removeAllItems();
        List<GCGenericoDTO> list2 = this.xInformesCitasDAO.listConvenioNoAtendidas(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
        this.xidConvenio = new String[list2.size()];
        for (int x3 = 0; x3 < list2.size(); x3++) {
            this.xidConvenio[x3] = String.valueOf(list2.get(x3).getId());
            this.JCBConvenio.addItem(list2.get(x3).getNombre());
            System.out.println("Consulta " + list2.get(x3).getId());
            System.out.println("" + list2.get(x3).getNombre());
        }
        this.JCBConvenio.addPopupMenuListener(new CustomPopupMenuListener(true, false));
        this.JCBConvenio.setSelectedIndex(-1);
        this.JCBProfesional.removeAllItems();
        List<GCGenericoDTO> list4 = this.xInformesCitasDAO.listProfesionalNoAtendidas(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
        this.xidProfesional = new String[list4.size()];
        for (int x4 = 0; x4 < list4.size(); x4++) {
            this.xidProfesional[x4] = String.valueOf(list4.get(x4).getId());
            this.JCBProfesional.addItem(list4.get(x4).getNombre());
            System.out.println("Consulta " + list4.get(x4).getId());
            System.out.println("" + list4.get(x4).getNombre());
        }
        this.JCBProfesional.addPopupMenuListener(new CustomPopupMenuListener(true, false));
        this.JCBProfesional.setSelectedIndex(-1);
        this.xlleno = true;
    }

    /* JADX WARN: Type inference failed for: r3v80, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCBEspecialidad = new JComboBox();
        this.JCBPrograma = new JComboBox();
        this.JPFiltro = new JPanel();
        this.JCHEspecialidad = new JCheckBox();
        this.JCHPrograma = new JCheckBox();
        this.JCHConvenio = new JCheckBox();
        this.JCHTodos = new JCheckBox();
        this.JCHProfesional = new JCheckBox();
        this.JCBConvenio = new JComboBox();
        this.JCBProfesional = new JComboBox();
        this.JBTExportar = new JButton();
        this.JTFRuta = new JTextField();
        this.JSDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONSULTAR CITAS NO ATENDIDAS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifconsultarcitasnoatendidas");
        this.JPDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACION", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.citas.JIFConsultarCitaNoAtendidas.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFConsultarCitaNoAtendidas.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.citas.JIFConsultarCitaNoAtendidas.3
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFConsultarCitaNoAtendidas.this.JDFechaFPropertyChange(evt);
            }
        });
        this.JCBEspecialidad.setFont(new Font("Arial", 1, 12));
        this.JCBEspecialidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEspecialidad.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.citas.JIFConsultarCitaNoAtendidas.4
            public void itemStateChanged(ItemEvent evt) {
                JIFConsultarCitaNoAtendidas.this.JCBEspecialidadItemStateChanged(evt);
            }
        });
        this.JCBPrograma.setFont(new Font("Arial", 1, 12));
        this.JCBPrograma.setBorder(BorderFactory.createTitledBorder((Border) null, "Programa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtros", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JCHEspecialidad.setFont(new Font("Arial", 1, 12));
        this.JCHEspecialidad.setText("Especialidad");
        this.JCHEspecialidad.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.citas.JIFConsultarCitaNoAtendidas.5
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarCitaNoAtendidas.this.JCHEspecialidadActionPerformed(evt);
            }
        });
        this.JCHPrograma.setFont(new Font("Arial", 1, 12));
        this.JCHPrograma.setText("Programa");
        this.JCHPrograma.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.citas.JIFConsultarCitaNoAtendidas.6
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarCitaNoAtendidas.this.JCHProgramaActionPerformed(evt);
            }
        });
        this.JCHConvenio.setFont(new Font("Arial", 1, 12));
        this.JCHConvenio.setText("Convenio");
        this.JCHConvenio.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.citas.JIFConsultarCitaNoAtendidas.7
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarCitaNoAtendidas.this.JCHConvenioActionPerformed(evt);
            }
        });
        this.JCHTodos.setFont(new Font("Arial", 1, 12));
        this.JCHTodos.setText("Todos");
        this.JCHTodos.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.citas.JIFConsultarCitaNoAtendidas.8
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarCitaNoAtendidas.this.JCHTodosActionPerformed(evt);
            }
        });
        this.JCHProfesional.setFont(new Font("Arial", 1, 12));
        this.JCHProfesional.setText("Profesional");
        this.JCHProfesional.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.citas.JIFConsultarCitaNoAtendidas.9
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarCitaNoAtendidas.this.JCHProfesionalActionPerformed(evt);
            }
        });
        GroupLayout JPFiltroLayout = new GroupLayout(this.JPFiltro);
        this.JPFiltro.setLayout(JPFiltroLayout);
        JPFiltroLayout.setHorizontalGroup(JPFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPFiltroLayout.createSequentialGroup().addComponent(this.JCHEspecialidad).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHPrograma).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHConvenio).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHProfesional).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHTodos)));
        JPFiltroLayout.setVerticalGroup(JPFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPFiltroLayout.createSequentialGroup().addGroup(JPFiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHEspecialidad).addComponent(this.JCHPrograma).addComponent(this.JCHConvenio).addComponent(this.JCHTodos).addComponent(this.JCHProfesional)).addGap(10, 10, 10)));
        this.JCBConvenio.setFont(new Font("Arial", 1, 12));
        this.JCBConvenio.setBorder(BorderFactory.createTitledBorder((Border) null, "Convenio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBProfesional.setFont(new Font("Arial", 1, 12));
        this.JCBProfesional.setBorder(BorderFactory.createTitledBorder((Border) null, "Profesional", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPDatosLayout = new GroupLayout(this.JPDatos);
        this.JPDatos.setLayout(JPDatosLayout);
        JPDatosLayout.setHorizontalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addComponent(this.JDFechaI, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFechaF, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPFiltro, -2, -1, -2)).addGroup(JPDatosLayout.createSequentialGroup().addComponent(this.JCBEspecialidad, -2, 215, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBProfesional, -2, 242, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBPrograma, -2, 242, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBConvenio, -2, 247, -2))).addContainerGap(-1, 32767)));
        JPDatosLayout.setVerticalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPFiltro, -2, -1, -2).addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaI, -2, 56, -2).addComponent(this.JDFechaF, -2, 56, -2))).addGap(10, 10, 10).addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBEspecialidad, -2, -1, -2).addComponent(this.JCBProfesional, -2, -1, -2).addComponent(this.JCBPrograma, -2, -1, -2).addComponent(this.JCBConvenio, -2, -1, -2)).addGap(16, 16, 16)));
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.citas.JIFConsultarCitaNoAtendidas.10
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarCitaNoAtendidas.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.citas.JIFConsultarCitaNoAtendidas.11
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarCitaNoAtendidas.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JSDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JSDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSDetalle).addComponent(this.JPDatos, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 637, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTExportar, -1, -1, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSDetalle, -2, 383, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBTExportar, -1, -1, 32767).addComponent(this.JTFRuta, -2, 50, -2)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
        if (this.xvalidar == 1) {
            mLLenarCombo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFPropertyChange(PropertyChangeEvent evt) {
        if (this.xvalidar == 1) {
            mLLenarCombo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEspecialidadItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (!this.JTFRuta.getText().isEmpty()) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.xmt.mTraerUrlBD(this.JTFRuta.getText()), getTitle());
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTFRuta.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                File xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(xfile.getAbsolutePath() + this.xmt.getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEspecialidadActionPerformed(ActionEvent evt) {
        if (this.JCHEspecialidad.isSelected()) {
            this.JCHTodos.setSelected(false);
            this.JCBEspecialidad.setVisible(true);
        } else {
            this.JCBEspecialidad.setVisible(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHProgramaActionPerformed(ActionEvent evt) {
        if (this.JCHPrograma.isSelected()) {
            this.JCHTodos.setSelected(false);
            this.JCBPrograma.setVisible(true);
        } else {
            this.JCBPrograma.setVisible(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHConvenioActionPerformed(ActionEvent evt) {
        if (this.JCHConvenio.isSelected()) {
            this.JCHTodos.setSelected(false);
            this.JCBConvenio.setVisible(true);
        } else {
            this.JCBConvenio.setVisible(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHTodosActionPerformed(ActionEvent evt) {
        if (this.JCHTodos.isSelected()) {
            this.JCHEspecialidad.setSelected(true);
            this.JCBEspecialidad.setVisible(true);
            this.JCHPrograma.setSelected(true);
            this.JCBPrograma.setVisible(true);
            this.JCHConvenio.setSelected(true);
            this.JCBConvenio.setVisible(true);
            this.JCHProfesional.setSelected(true);
            this.JCBProfesional.setVisible(true);
            return;
        }
        this.JCHEspecialidad.setSelected(false);
        this.JCBEspecialidad.setVisible(false);
        this.JCHPrograma.setSelected(false);
        this.JCBPrograma.setVisible(false);
        this.JCHConvenio.setSelected(false);
        this.JCBConvenio.setVisible(false);
        this.JCHProfesional.setSelected(false);
        this.JCBProfesional.setVisible(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHProfesionalActionPerformed(ActionEvent evt) {
        if (this.JCHProfesional.isSelected()) {
            this.JCHTodos.setSelected(false);
            this.JCBProfesional.setVisible(true);
        } else {
            this.JCBProfesional.setVisible(false);
        }
    }
}
