package Historia;

import Acceso.Principal;

/* JADX INFO: compiled from: JIFAgendaMedico_N.java */
/* JADX INFO: loaded from: GenomaP.jar:Historia/mRefrescarAgenda1.class */
class mRefrescarAgenda1 implements Runnable {
    private JIFAgendaMedico_N frmAgenda;
    public boolean xvalor = true;

    public mRefrescarAgenda1(JIFAgendaMedico_N agenda) {
        this.frmAgenda = agenda;
    }

    @Override // java.lang.Runnable
    public void run() {
        while (this.xvalor) {
            if (this.frmAgenda.xtipo == 0) {
                if (this.frmAgenda.xmodelo != null && this.frmAgenda.JDCFechaAgenda.getDate() != null && Principal.clasehistoriace.xjifagendan != null) {
                    if (clasesHistoriaCE.informacionAgendaMedicaDTO.getFiltradoAgenda().intValue() == 0) {
                        this.frmAgenda.mCargarDatosA();
                        this.frmAgenda.mCargarDatosCNP();
                        this.frmAgenda.mCargarDatos_Urgencias1();
                        this.frmAgenda.mCargarDatos_Hospitalizacion();
                        this.frmAgenda.mCargarDatos_Cx();
                        this.frmAgenda.mValidar_CitasEspeciales();
                        this.frmAgenda.xTab_AUgencias = 1;
                        this.frmAgenda.xACExterna = true;
                        this.frmAgenda.xAUrgencias = true;
                        this.frmAgenda.xASParto = true;
                        this.frmAgenda.xAHospit = true;
                    } else if (clasesHistoriaCE.informacionAgendaMedicaDTO.getFiltradoAgenda().intValue() == 1) {
                        this.frmAgenda.mCargarDatosA();
                        this.frmAgenda.mCargarDatosCNP();
                        this.frmAgenda.JTP_DatosAgenda.remove(3);
                        this.frmAgenda.JTP_DatosAgenda.remove(2);
                        this.frmAgenda.JTP_DatosAgenda.remove(1);
                        this.frmAgenda.xACExterna = true;
                    } else if (clasesHistoriaCE.informacionAgendaMedicaDTO.getFiltradoAgenda().intValue() == 2) {
                        this.frmAgenda.xTab_AUgencias = 0;
                        this.frmAgenda.mCargarDatos_Urgencias1();
                        if (!this.frmAgenda.xCRemovio) {
                            this.frmAgenda.JTP_DatosAgenda.remove(3);
                            this.frmAgenda.JTP_DatosAgenda.remove(2);
                            this.frmAgenda.JTP_DatosAgenda.remove(0);
                            this.frmAgenda.xAUrgencias = true;
                            this.frmAgenda.xCRemovio = true;
                        }
                    } else if (clasesHistoriaCE.informacionAgendaMedicaDTO.getFiltradoAgenda().intValue() == 3) {
                        this.frmAgenda.xTab_AUgencias = 0;
                        this.frmAgenda.mCargarDatos_Cx();
                        if (!this.frmAgenda.xCRemovio) {
                            this.frmAgenda.JTP_DatosAgenda.remove(3);
                            this.frmAgenda.JTP_DatosAgenda.remove(1);
                            this.frmAgenda.JTP_DatosAgenda.remove(0);
                            this.frmAgenda.xASParto = true;
                            this.frmAgenda.xCRemovio = true;
                        }
                    } else if (clasesHistoriaCE.informacionAgendaMedicaDTO.getFiltradoAgenda().intValue() == 4 || clasesHistoriaCE.informacionAgendaMedicaDTO.getFiltradoAgenda().intValue() == 5) {
                        this.frmAgenda.xTab_AUgencias = 0;
                        if (clasesHistoriaCE.informacionAgendaMedicaDTO.getFiltradoAgenda().intValue() == 5) {
                            this.frmAgenda.JCH_FSalaParto.setSelected(true);
                            this.frmAgenda.JCH_FSalaParto.setEnabled(false);
                            this.frmAgenda.mCargarDatos_HospitalizacionSP();
                        } else {
                            this.frmAgenda.mCargarDatos_Hospitalizacion();
                        }
                        if (!this.frmAgenda.xCRemovio) {
                            if (clasesHistoriaCE.informacionAgendaMedicaDTO.getFiltradoAgenda().intValue() == 5) {
                                this.frmAgenda.JTP_DatosAgenda.setTitleAt(3, "SALA DE PARTOS");
                            }
                            this.frmAgenda.JTP_DatosAgenda.remove(2);
                            this.frmAgenda.JTP_DatosAgenda.remove(1);
                            this.frmAgenda.JTP_DatosAgenda.remove(0);
                            this.frmAgenda.xAHospit = true;
                            this.frmAgenda.xCRemovio = true;
                        }
                    }
                }
            } else if (this.frmAgenda.xtipo == 1 && this.frmAgenda.xmodelo != null && this.frmAgenda.JDCFechaAgenda.getDate() != null) {
                if (clasesHistoriaCE.informacionAgendaMedicaDTO.getFiltradoAgenda().intValue() == 0) {
                    this.frmAgenda.mCargarDatosCNP();
                    this.frmAgenda.mCargarDatos_Urgencias1();
                    this.frmAgenda.mCargarDatos_Hospitalizacion();
                    this.frmAgenda.mValidar_CitasEspeciales();
                    this.frmAgenda.xACExterna = true;
                    this.frmAgenda.xAUrgencias = true;
                    this.frmAgenda.xASParto = true;
                    this.frmAgenda.xAHospit = true;
                } else if (clasesHistoriaCE.informacionAgendaMedicaDTO.getFiltradoAgenda().intValue() == 1) {
                    this.frmAgenda.mCargarDatosCNP();
                    this.frmAgenda.JTP_DatosAgenda.remove(3);
                    this.frmAgenda.JTP_DatosAgenda.remove(2);
                    this.frmAgenda.JTP_DatosAgenda.remove(1);
                    this.frmAgenda.xACExterna = true;
                } else if (clasesHistoriaCE.informacionAgendaMedicaDTO.getFiltradoAgenda().intValue() == 2) {
                    this.frmAgenda.mCargarDatos_Urgencias1();
                    this.frmAgenda.mCargarDatos_Hospitalizacion();
                    this.frmAgenda.mValidar_CitasEspeciales_Urgencias();
                    this.frmAgenda.JTP_DatosAgenda.remove(3);
                    this.frmAgenda.JTP_DatosAgenda.remove(2);
                    this.frmAgenda.JTP_DatosAgenda.remove(0);
                    this.frmAgenda.xAUrgencias = true;
                }
            }
            try {
                Thread.sleep(20000L);
            } catch (InterruptedException e) {
            }
        }
    }
}
