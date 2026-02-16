package Utilidades;

import Laboratorio.Render;
import com.genoma.plus.dto.historia.InformacionAgendaMedicaDTO;
import java.awt.Color;
import java.awt.Component;
import java.awt.Rectangle;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/SwingworkeTableModel_AgendaServicio.class */
public class SwingworkeTableModel_AgendaServicio extends SwingWorker<DefaultTableModel, List<InformacionAgendaMedicaDTO>> {
    private final JTable table;
    private final DefaultTableModel modeloModel;
    private List<InformacionAgendaMedicaDTO> listadoList;
    private Object[] datos;
    private Metodos metodos = new Metodos();
    private JLabel numeroRegistros;
    private int posicionScroll;

    public SwingworkeTableModel_AgendaServicio(JTable table, DefaultTableModel modeloModel, List<InformacionAgendaMedicaDTO> listadoList, JLabel numeroRegistros, int posicionScroll) {
        this.table = table;
        this.modeloModel = modeloModel;
        this.listadoList = listadoList;
        this.numeroRegistros = numeroRegistros;
        this.posicionScroll = posicionScroll;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: doInBackground, reason: merged with bridge method [inline-methods] */
    public DefaultTableModel m52doInBackground() throws Exception {
        Integer numero = 0;
        if (this.listadoList.size() != -1) {
            this.metodos.mEstablecerTextEditor(this.table, 3);
            this.metodos.mEstablecerTextEditor(this.table, 5);
            this.metodos.mEstablecerTextEditor(this.table, 6);
            this.metodos.mEstablecerTextEditor(this.table, 7);
            this.metodos.mEstablecerTextEditor(this.table, 56);
            for (int i = 0; i < this.listadoList.size(); i++) {
                this.modeloModel.addRow(this.datos);
                this.modeloModel.setValueAt(this.listadoList.get(i).getFechaIngreso(), i, 0);
                this.modeloModel.setValueAt(this.listadoList.get(i).getHoraIngreso(), i, 1);
                this.modeloModel.setValueAt(this.listadoList.get(i).getNumeroHistoria(), i, 2);
                this.modeloModel.setValueAt(this.listadoList.get(i).getNombreUsuario(), i, 3);
                this.modeloModel.setValueAt(this.listadoList.get(i).getIdSexo(), i, 4);
                this.modeloModel.setValueAt(this.listadoList.get(i).getEdad(), i, 5);
                this.modeloModel.setValueAt(this.listadoList.get(i).getNombreEmpresaCovenio(), i, 6);
                this.modeloModel.setValueAt(this.listadoList.get(i).getMotivoConsulta(), i, 7);
                this.modeloModel.setValueAt(this.listadoList.get(i).getEsAtencionEspecial(), i, 9);
                if (null == this.listadoList.get(i).getEsAtencionEspecial()) {
                    this.modeloModel.setValueAt(new JLabel(""), i, 8);
                } else {
                    switch (this.listadoList.get(i).getEsAtencionEspecial().intValue()) {
                        case 1:
                            this.modeloModel.setValueAt(new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Atencion Discapasitaods.png"))), i, 8);
                            break;
                        case 2:
                            this.modeloModel.setValueAt(new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Atencion Embarazada.png"))), i, 8);
                            break;
                        case 3:
                            this.modeloModel.setValueAt(new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Atencion Ancianos.png"))), i, 8);
                            break;
                        case 4:
                            this.modeloModel.setValueAt(new JLabel(new ImageIcon(getClass().getResource("/Imagenes/AtpNiños.png"))), i, 8);
                            break;
                        default:
                            this.modeloModel.setValueAt(new JLabel(""), i, 8);
                            break;
                    }
                }
                this.table.setDefaultRenderer(JLabel.class, new Render(this.listadoList.get(i).getEsAtencionEspecial().intValue(), 9));
                this.modeloModel.setValueAt(this.listadoList.get(i).getClasificacionTriage(), i, 10);
                this.modeloModel.setValueAt(this.listadoList.get(i).getNombreTipoConsulta(), i, 11);
                this.modeloModel.setValueAt(this.listadoList.get(i).getHoraIncial(), i, 12);
                this.modeloModel.setValueAt(this.listadoList.get(i).getEstadoTextoAtencion(), i, 13);
                this.modeloModel.setValueAt(this.listadoList.get(i).getNombreSexo(), i, 14);
                this.modeloModel.setValueAt(this.listadoList.get(i).getFechaNacimiento(), i, 15);
                this.modeloModel.setValueAt(this.listadoList.get(i).getHoraFinal(), i, 16);
                this.modeloModel.setValueAt(this.listadoList.get(i).getIdUsuarioAtendido(), i, 17);
                this.modeloModel.setValueAt(this.listadoList.get(i).getIdIngreso(), i, 18);
                this.modeloModel.setValueAt(this.listadoList.get(i).getIdClaseCita(), i, 19);
                this.modeloModel.setValueAt(this.listadoList.get(i).getIdTipohc(), i, 20);
                this.modeloModel.setValueAt(this.listadoList.get(i).getAsistida(), i, 21);
                this.modeloModel.setValueAt(this.listadoList.get(i).getIdCita(), i, 22);
                this.modeloModel.setValueAt(this.listadoList.get(i).getIdAtencion(), i, 23);
                this.modeloModel.setValueAt(this.listadoList.get(i).getIdTipoCita(), i, 24);
                this.modeloModel.setValueAt(this.listadoList.get(i).getEsRemitada(), i, 25);
                this.modeloModel.setValueAt(this.listadoList.get(i).getIdPrograma(), i, 26);
                this.modeloModel.setValueAt(this.listadoList.get(i).getEsSaludOcupacional(), i, 27);
                this.modeloModel.setValueAt(this.listadoList.get(i).getEsControl(), i, 28);
                this.modeloModel.setValueAt(this.listadoList.get(i).getEsOdontologica(), i, 29);
                this.modeloModel.setValueAt(this.listadoList.get(i).getIdTratamiento(), i, 30);
                this.modeloModel.setValueAt(this.listadoList.get(i).getCama(), i, 31);
                this.modeloModel.setValueAt(this.listadoList.get(i).getEnfermedadActual(), i, 32);
                this.modeloModel.setValueAt(this.listadoList.get(i).getEsPeriodico(), i, 33);
                this.modeloModel.setValueAt(this.listadoList.get(i).getEsControlHistoria(), i, 34);
                this.modeloModel.setValueAt(this.listadoList.get(i).getFechaIngreso(), i, 35);
                this.modeloModel.setValueAt(this.listadoList.get(i).getIdTipoAtencion(), i, 36);
                this.modeloModel.setValueAt(this.listadoList.get(i).getTipoAtencion(), i, 37);
                this.modeloModel.setValueAt(this.listadoList.get(i).getEmailUsuario(), i, 38);
                this.modeloModel.setValueAt(this.listadoList.get(i).getEmailsupervisor(), i, 39);
                this.modeloModel.setValueAt(this.listadoList.get(i).getIdTipoEmpresa(), i, 40);
                this.modeloModel.setValueAt(this.listadoList.get(i).getIdParentesco(), i, 41);
                this.modeloModel.setValueAt(this.listadoList.get(i).getTipoCita(), i, 42);
                this.modeloModel.setValueAt(this.listadoList.get(i).getTipoGuardado(), i, 43);
                this.modeloModel.setValueAt(this.listadoList.get(i).getFecha_HoraAtencion(), i, 44);
                this.modeloModel.setValueAt(this.listadoList.get(i).getIdUsuarioPrograma(), i, 45);
                this.modeloModel.setValueAt(this.listadoList.get(i).getIdOrden(), i, 46);
                this.modeloModel.setValueAt(this.listadoList.get(i).getIdProcedimiento(), i, 47);
                this.modeloModel.setValueAt(this.listadoList.get(i).getIdServicio(), i, 48);
                this.modeloModel.setValueAt(this.listadoList.get(i).getIdManPower(), i, 49);
                this.modeloModel.setValueAt(this.listadoList.get(i).getFiltradoAgenda(), i, 50);
                this.modeloModel.setValueAt(this.listadoList.get(i).getExpandirHistoria(), i, 51);
                this.modeloModel.setValueAt(this.listadoList.get(i).getTipoTratamiento(), i, 52);
                this.modeloModel.setValueAt(this.listadoList.get(i).getEsTriage(), i, 53);
                this.modeloModel.setValueAt(this.listadoList.get(i).getFormaHistoria(), i, 54);
                this.modeloModel.setValueAt(this.listadoList.get(i).getEstadoUsuarioUrgencias(), i, 55);
                this.modeloModel.setValueAt(this.listadoList.get(i).getEspecialidadInterconsulta(), i, 56);
                this.table.setDefaultRenderer(Object.class, new MiRender());
                numero = Integer.valueOf(numero.intValue() + 1);
            }
        }
        this.numeroRegistros.setText("" + numero);
        JTable jTable = this.table;
        JTable jTable2 = this.table;
        jTable.setAutoResizeMode(0);
        this.table.scrollRectToVisible(new Rectangle(this.table.getCellRect(20, 0, true)));
        return this.modeloModel;
    }

    protected void done() {
        DefaultTableModel model = null;
        try {
            try {
                model = (DefaultTableModel) get();
            } catch (ExecutionException ex) {
                Logger.getLogger(SwingworkeTableModel_AgendaServicio.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
            this.table.setModel(model);
        } catch (InterruptedException ex2) {
            ex2.printStackTrace();
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Utilidades/SwingworkeTableModel_AgendaServicio$MiRender.class */
    public class MiRender extends DefaultTableCellRenderer {
        public MiRender() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (table.getValueAt(row, 55) != null) {
                int valorCelda = Integer.parseInt(table.getValueAt(row, 55).toString());
                switch (valorCelda) {
                    case 0:
                        cell.setBackground(Color.CYAN);
                        cell.setForeground(Color.BLACK);
                        break;
                    case 1:
                        cell.setBackground(new Color(133, 218, 160));
                        cell.setForeground(Color.BLACK);
                        break;
                    case 2:
                        cell.setBackground(Color.ORANGE);
                        cell.setForeground(Color.BLACK);
                        break;
                    default:
                        cell.setBackground(Color.PINK);
                        cell.setForeground(Color.BLACK);
                        break;
                }
            }
            return cell;
        }
    }
}
