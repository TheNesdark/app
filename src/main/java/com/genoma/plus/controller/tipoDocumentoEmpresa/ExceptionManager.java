package com.genoma.plus.controller.tipoDocumentoEmpresa;

/* JADX INFO: compiled from: NotificacionEmail.java */
/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/tipoDocumentoEmpresa/ExceptionManager.class */
class ExceptionManager {
    ExceptionManager() {
    }

    public static void ManageException(Exception e) {
        System.out.println("Se ha producido una exception");
        System.out.println(e.getMessage());
        e.printStackTrace(System.out);
    }
}
