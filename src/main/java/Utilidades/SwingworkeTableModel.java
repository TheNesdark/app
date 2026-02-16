package Utilidades;

import Acceso.Principal;
import Laboratorio.Render;
import com.genoma.plus.dto.historia.InformacionAgendaMedicaDTO;
import java.awt.Color;
import java.awt.Component;
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

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/SwingworkeTableModel.class */
public class SwingworkeTableModel extends SwingWorker<DefaultTableModel, List<InformacionAgendaMedicaDTO>> {
    private final JTable table;
    private final DefaultTableModel modeloModel;
    private List<InformacionAgendaMedicaDTO> listadoList;
    private Object[] datos;
    private Metodos metodos = new Metodos();
    private JLabel jlabel;

    public SwingworkeTableModel(JTable table, DefaultTableModel modeloModel, List<InformacionAgendaMedicaDTO> listadoList, JLabel jlabel) {
        this.table = table;
        this.modeloModel = modeloModel;
        this.listadoList = listadoList;
        this.jlabel = jlabel;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: doInBackground, reason: merged with bridge method [inline-methods] */
    public DefaultTableModel m51doInBackground() throws Exception {
        int nitems = 0;
        if (this.listadoList.size() != -1) {
            if (!Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") && !Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) {
                this.metodos.mEstablecerTextEditor(this.table, 1);
                this.metodos.mEstablecerTextEditor(this.table, 4);
                this.metodos.mEstablecerTextEditor(this.table, 7);
                this.metodos.mEstablecerTextEditor(this.table, 2);
            }
            for (int i = 0; i < this.listadoList.size(); i++) {
                this.modeloModel.addRow(this.datos);
                this.modeloModel.setValueAt(this.listadoList.get(i).getNumeroHistoria(), i, 0);
                this.modeloModel.setValueAt(this.listadoList.get(i).getNombreUsuario(), i, 1);
                this.modeloModel.setValueAt(this.listadoList.get(i).getEdad(), i, 2);
                this.modeloModel.setValueAt(this.listadoList.get(i).getIdSexo(), i, 3);
                this.modeloModel.setValueAt(this.listadoList.get(i).getNombreTipoConsulta(), i, 4);
                this.modeloModel.setValueAt(this.listadoList.get(i).getHoraIncial(), i, 5);
                this.modeloModel.setValueAt(this.listadoList.get(i).getEstadoTextoAtencion(), i, 6);
                this.modeloModel.setValueAt(this.listadoList.get(i).getNombreEmpresaCovenio(), i, 7);
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
                this.modeloModel.setValueAt(this.listadoList.get(i).getNombreSexo(), i, 10);
                this.modeloModel.setValueAt(this.listadoList.get(i).getFechaNacimiento(), i, 11);
                this.modeloModel.setValueAt(this.listadoList.get(i).getHoraFinal(), i, 12);
                this.modeloModel.setValueAt(this.listadoList.get(i).getIdUsuarioAtendido(), i, 13);
                this.modeloModel.setValueAt(this.listadoList.get(i).getIdIngreso(), i, 14);
                this.modeloModel.setValueAt(this.listadoList.get(i).getIdClaseCita(), i, 15);
                this.modeloModel.setValueAt(this.listadoList.get(i).getIdTipohc(), i, 16);
                this.modeloModel.setValueAt(this.listadoList.get(i).getAsistida(), i, 17);
                this.modeloModel.setValueAt(this.listadoList.get(i).getIdCita(), i, 18);
                this.modeloModel.setValueAt(this.listadoList.get(i).getIdAtencion(), i, 19);
                this.modeloModel.setValueAt(this.listadoList.get(i).getIdTipoCita(), i, 20);
                this.modeloModel.setValueAt(this.listadoList.get(i).getEsRemitada(), i, 21);
                this.modeloModel.setValueAt(this.listadoList.get(i).getIdPrograma(), i, 22);
                this.modeloModel.setValueAt(this.listadoList.get(i).getEsSaludOcupacional(), i, 23);
                this.modeloModel.setValueAt(this.listadoList.get(i).getEsControl(), i, 24);
                this.modeloModel.setValueAt(this.listadoList.get(i).getEsOdontologica(), i, 25);
                this.modeloModel.setValueAt(this.listadoList.get(i).getIdTratamiento(), i, 26);
                this.modeloModel.setValueAt(this.listadoList.get(i).getMotivoConsulta(), i, 27);
                this.modeloModel.setValueAt(this.listadoList.get(i).getEnfermedadActual(), i, 28);
                this.modeloModel.setValueAt(this.listadoList.get(i).getEsPeriodico(), i, 29);
                this.modeloModel.setValueAt(this.listadoList.get(i).getEsControlHistoria(), i, 30);
                this.modeloModel.setValueAt(this.listadoList.get(i).getFechaIngreso(), i, 31);
                this.modeloModel.setValueAt(this.listadoList.get(i).getIdTipoAtencion(), i, 32);
                this.modeloModel.setValueAt(this.listadoList.get(i).getTipoAtencion(), i, 33);
                this.modeloModel.setValueAt(this.listadoList.get(i).getEmailUsuario(), i, 34);
                this.modeloModel.setValueAt(this.listadoList.get(i).getEmailsupervisor(), i, 35);
                this.modeloModel.setValueAt(this.listadoList.get(i).getIdTipoEmpresa(), i, 36);
                this.modeloModel.setValueAt(this.listadoList.get(i).getIdParentesco(), i, 37);
                this.modeloModel.setValueAt(this.listadoList.get(i).getTipoCita(), i, 38);
                this.modeloModel.setValueAt(this.listadoList.get(i).getTipoGuardado(), i, 39);
                this.modeloModel.setValueAt(this.listadoList.get(i).getFecha_HoraAtencion(), i, 40);
                this.modeloModel.setValueAt(this.listadoList.get(i).getIdUsuarioPrograma(), i, 41);
                this.modeloModel.setValueAt(this.listadoList.get(i).getIdOrden(), i, 42);
                this.modeloModel.setValueAt(this.listadoList.get(i).getIdProcedimiento(), i, 43);
                this.modeloModel.setValueAt(this.listadoList.get(i).getIdServicio(), i, 44);
                this.modeloModel.setValueAt(this.listadoList.get(i).getIdManPower(), i, 45);
                this.modeloModel.setValueAt(this.listadoList.get(i).getFiltradoAgenda(), i, 46);
                this.modeloModel.setValueAt(this.listadoList.get(i).getExpandirHistoria(), i, 47);
                this.modeloModel.setValueAt(this.listadoList.get(i).getTipoTratamiento(), i, 48);
                this.modeloModel.setValueAt(this.listadoList.get(i).getEsTriage(), i, 49);
                this.modeloModel.setValueAt(this.listadoList.get(i).getFormaHistoria(), i, 50);
                this.modeloModel.setValueAt(this.listadoList.get(i).getUrlVideollamada(), i, 51);
                nitems++;
                this.table.setDefaultRenderer(Object.class, new MiRender());
            }
        }
        this.jlabel.setText(String.valueOf(nitems));
        return this.modeloModel;
    }

    protected void done() {
        DefaultTableModel model = null;
        try {
            try {
                model = (DefaultTableModel) get();
            } catch (ExecutionException ex) {
                Logger.getLogger(SwingworkeTableModel.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
            this.table.setModel(model);
        } catch (InterruptedException ex2) {
            ex2.printStackTrace();
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Utilidades/SwingworkeTableModel$MiRender.class */
    public class MiRender extends DefaultTableCellRenderer {
        public MiRender() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (table.getValueAt(row, 17) != null) {
                int valorCelda = Integer.parseInt(table.getValueAt(row, 17).toString());
                switch (valorCelda) {
                    case 0:
                        cell.setBackground(Color.CYAN);
                        cell.setForeground(Color.BLACK);
                        break;
                    case 1:
                        cell.setBackground(Color.PINK);
                        cell.setForeground(Color.BLACK);
                        break;
                    case 2:
                        cell.setBackground(Color.YELLOW);
                        cell.setForeground(Color.BLACK);
                        break;
                    default:
                        cell.setBackground(Color.MAGENTA);
                        cell.setForeground(Color.BLACK);
                        break;
                }
            }
            return cell;
        }
    }
}
