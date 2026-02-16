package Laboratorio;

import Utilidades.ConsultasMySQL;
import giovynet.nativelink.SerialPort;
import giovynet.serial.Baud;
import giovynet.serial.Com;
import giovynet.serial.Parameters;
import java.sql.ResultSet;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:Laboratorio/EscribirPuerto.class */
public class EscribirPuerto {
    public void mEscribir() {
        try {
            SerialPort serialPort = new SerialPort();
            List<String> portsFree = serialPort.getFreeSerialPort();
            ConsultasMySQL xc = new ConsultasMySQL();
            if (portsFree != null && portsFree.size() > 0) {
                for (String str : portsFree) {
                }
                Parameters parameters = new Parameters();
                parameters.setPort(portsFree.get(0));
                parameters.setBaudRate(Baud._9600);
                Com com2 = new Com(parameters);
                ResultSet rs = xc.traerRs("SELECT  Id , DATE_FORMAT(FechaRecep,'%Y-%m-%d') FROM l_recepcion WHERE (DATE_FORMAT(FechaRecep,'%Y-%m-%d') ='2011-01-27') ");
                if (rs.next()) {
                    rs.beforeFirst();
                    while (rs.next()) {
                        String data = rs.getString(1);
                        for (int i = 0; i < data.toCharArray().length; i++) {
                            Thread.sleep(400L);
                            com2.sendSingleData(data.toCharArray()[i]);
                        }
                    }
                }
                rs.close();
                xc.cerrarConexionBd();
                com2.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mRecibir() {
        try {
            SerialPort serialPort = new SerialPort();
            List<String> portsFree = serialPort.getFreeSerialPort();
            if (portsFree != null && portsFree.size() > 0) {
                for (String str : portsFree) {
                }
                Parameters parameters = new Parameters();
                parameters.setPort(portsFree.get(0));
                parameters.setBaudRate(Baud._9600);
                Com com2 = new Com(parameters);
                String recibido = "";
                String caracter = "";
                while (!caracter.equals("\n")) {
                    caracter = com2.receiveSingleString();
                    recibido = recibido + caracter;
                }
                com2.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
