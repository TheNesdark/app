package com.genoma.plus.controller.facturacion;

import Acceso.Principal;
import Utilidades.Metodos;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.genoma.plus.controller.facturacion.dto.DatosUsuarioRes;
import com.genoma.plus.controller.facturacion.dto.Identificacion;
import com.genoma.plus.controller.facturacion.dto.Persona;
import com.genoma.plus.controller.facturacion.dto.UsuarioResponse;
import com.genoma.plus.controller.facturacion.dto.rips.RipsConsolidadoDTO;
import com.genoma.plus.controller.facturacion.dto.validacionrips.CapitalizedNamingStrategy;
import com.genoma.plus.controller.facturacion.dto.validacionrips.ResultadoProcesoDTO;
import com.genoma.plus.controller.facturacion.dto.validacionrips.ValidacionRipsRespuesta;
import com.genoma.plus.controller.general.JIFRecursosMicroServicios;
import com.genoma.plus.controller.laboratorio.dto.CustomPresenter;
import com.genoma.plus.controller.parametrizacion.UserSisproDTO;
import com.genoma.plus.domains.models.domains.general.RecursosMicroserviciosDomain;
import com.genoma.plus.utils.CamelCaseDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.awt.Component;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/ProcesosValidacionRipsApi.class */
public class ProcesosValidacionRipsApi {
    private static Metodos metodos = new Metodos();
    private static UserSisproDTO dtoUserSisPro;
    private static String clave;
    private static boolean reps;
    private static boolean mecanismo;
    private static int tipoMecanismo;

    public static UsuarioResponse logueUsuario() {
        Response response;
        Throwable th;
        try {
            RecursosMicroserviciosDomain domain = metodos.getParametrosEncriptados("26", "findUsuarioSispro");
            String fullUrl = domain.getUrlRecurso();
            response = metodos.getResteasyClient().target(fullUrl).request().get();
            th = null;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        try {
            try {
                System.out.println("microservicio" + response);
                int statusCode = response.getStatus();
                if (statusCode == 200) {
                    CustomPresenter presenter = (CustomPresenter) metodos.getMapper().readValue((String) response.readEntity(String.class), CustomPresenter.class);
                    dtoUserSisPro = (UserSisproDTO) metodos.getMapper().readValue(metodos.getMapper().writeValueAsString(presenter.getData()), new TypeReference<UserSisproDTO>() { // from class: com.genoma.plus.controller.facturacion.ProcesosValidacionRipsApi.1
                    });
                }
                if (response != null) {
                    if (0 != 0) {
                        try {
                            response.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    } else {
                        response.close();
                    }
                }
                if (dtoUserSisPro != null) {
                    clave = dtoUserSisPro.getClave();
                    reps = dtoUserSisPro.getReps().booleanValue();
                    mecanismo = dtoUserSisPro.getTipoMecanismoValidacion().booleanValue();
                }
                if (mecanismo) {
                    tipoMecanismo = 1;
                } else {
                    tipoMecanismo = 0;
                }
                Identificacion identificacion = Identificacion.builder().numero(dtoUserSisPro.getDocumento()).tipo(dtoUserSisPro.getTipoDocumento()).build();
                Persona persona = Persona.builder().identificacion(identificacion).build();
                DatosUsuarioRes datosUsuarioRes = DatosUsuarioRes.builder().persona(persona).clave(clave).nit(Principal.informacionIps.getIdentificacion()).reps(reps).tipoMecanismoValidacion(tipoMecanismo).build();
                RecursosMicroserviciosDomain microserviciosDomain = metodos.getParametrosEncriptados("26", "LoginSISPRO");
                UsuarioResponse usuarioResponse = new UsuarioResponse();
                ObjectMapper objectMapper = new ObjectMapper();
                String json = null;
                try {
                    json = objectMapper.writeValueAsString(datosUsuarioRes);
                } catch (JsonProcessingException e2) {
                    Logger.getLogger(ProcesosValidacionRipsApi.class.getName()).log(Level.SEVERE, (String) null, e2);
                }
                System.out.println("json: " + json);
                System.out.println("microserviciosDomain.getUrlRecurso(): " + microserviciosDomain.getUrlRecurso());
                Response response2 = metodos.getResteasyClient().target(microserviciosDomain.getUrlRecurso()).request(new String[]{"application/json"}).post(Entity.entity(json, "application/json"));
                System.out.println("status: " + response2.getStatus());
                if (response2.getStatus() == 200) {
                    try {
                        usuarioResponse = (UsuarioResponse) metodos.getMapper().readValue((String) response2.readEntity(String.class), UsuarioResponse.class);
                    } catch (JsonProcessingException e3) {
                        Logger.getLogger(JIFRecursosMicroServicios.class.getName()).log(Level.SEVERE, (String) null, e3);
                    }
                } else {
                    System.out.println("error: " + ((String) response2.readEntity(String.class)));
                }
                response2.close();
                metodos.getResteasyClient().close();
                return usuarioResponse;
            } finally {
            }
        } finally {
        }
    }

    public static RipsConsolidadoDTO generacionFactura(Long idNumeroFactura, String numeroFactura, Integer tipoConvenio) {
        String nombreMicro;
        System.err.println("tipoConvenio" + tipoConvenio);
        RipsConsolidadoDTO ripsEnviadoDTO = RipsConsolidadoDTO.builder().build();
        if (tipoConvenio.intValue() == 1) {
            nombreMicro = "GeneracionRips";
        } else {
            nombreMicro = "GeneracionRipsCapitado";
        }
        RecursosMicroserviciosDomain microserviciosDomain = metodos.getParametrosEncriptados("26", nombreMicro);
        String fullUrl = microserviciosDomain.getUrlRecurso() + "/" + idNumeroFactura + "/" + tipoConvenio;
        System.err.println("fullUrl" + fullUrl);
        Response response = metodos.getResteasyClient().target(fullUrl).request().get();
        if (response.getStatus() == 200) {
            try {
                new CustomPresenter();
                CustomPresenter presenter = (CustomPresenter) metodos.getMapper().readValue((String) response.readEntity(String.class), CustomPresenter.class);
                System.out.println(" verificar que llega " + presenter.getData());
                ripsEnviadoDTO = (RipsConsolidadoDTO) metodos.getMapper().readValue(metodos.getMapper().writeValueAsString(presenter.getData()), new TypeReference<RipsConsolidadoDTO>() { // from class: com.genoma.plus.controller.facturacion.ProcesosValidacionRipsApi.2
                });
            } catch (JsonProcessingException e) {
                Logger.getLogger(ProcesosValidacionRipsApi.class.getName()).log(Level.SEVERE, (String) null, e);
            }
        }
        response.close();
        metodos.getResteasyClient().close();
        String urlBase = Principal.informacionIps.getUrlRecursosAnkara();
        String urlAjustada = Metodos.adjustPathSeparator(urlBase);
        String barra = metodos.getBarra();
        String numFactura = ripsEnviadoDTO.getRips().getNumFactura();
        System.out.println("URL base: " + urlBase);
        System.out.println("URL ajustada: " + urlAjustada);
        System.out.println("Barra: " + barra);
        System.out.println("Número de factura: " + numFactura);
        String urlRuta = Metodos.adjustPathSeparator(Principal.informacionIps.getUrlRecursosAnkara()) + metodos.getBarra() + ripsEnviadoDTO.getRips().getNumFactura() + metodos.getBarra();
        System.out.println("ruta: " + urlRuta);
        if (Metodos.getSystemSO().contains("win")) {
            getMetodoWindwosXml(urlRuta, ripsEnviadoDTO);
        } else {
            getMetodoLinuxXml(urlRuta, ripsEnviadoDTO);
        }
        return ripsEnviadoDTO;
    }

    private static void getMetodoLinuxXml(String urlRuta, RipsConsolidadoDTO ripsEnviadoDTO) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        Path pathCarpeta = Paths.get(urlRuta, new String[0]);
        System.out.println("carpeta -> " + pathCarpeta);
        if (Metodos.existeCarpeta(urlRuta)) {
            File archivoXml = Metodos.buscarArchivo(urlRuta, "root", "GenomaPlus2@", "ad", "xml");
            if (archivoXml != null) {
                String infoFile = leerContenidoArchivo(archivoXml.getAbsolutePath());
                ripsEnviadoDTO.setXmlFevFile(convertirABase64(infoFile));
                return;
            } else {
                ripsEnviadoDTO.setXmlFevFile("");
                return;
            }
        }
        ripsEnviadoDTO.setXmlFevFile("");
    }

    private static void getMetodoWindwosXml(String urlRuta, RipsConsolidadoDTO ripsEnviadoDTO) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        Path pathCarpeta = Paths.get(urlRuta, new String[0]);
        System.out.println("carpeta -> " + pathCarpeta);
        if (Files.exists(pathCarpeta, new LinkOption[0])) {
            File archivoXml = buscarArchivo("ad", "xml", urlRuta);
            System.out.println("ruta: " + archivoXml.getAbsolutePath());
            System.err.println("xml fue encontrado");
            if (archivoXml != null) {
                String infoFile = leerContenidoArchivo(archivoXml.getAbsolutePath());
                ripsEnviadoDTO.setXmlFevFile(convertirABase64(infoFile));
            } else {
                ripsEnviadoDTO.setXmlFevFile("");
            }
            try {
                System.out.println("respuesta : " + objectMapper.writeValueAsString(ripsEnviadoDTO));
                return;
            } catch (JsonProcessingException e) {
                Logger.getLogger(ProcesosValidacionRipsApi.class.getName()).log(Level.SEVERE, (String) null, e);
                return;
            }
        }
        System.err.println("xml no encontrado");
        ripsEnviadoDTO.setXmlFevFile("");
    }

    public static String leerContenidoArchivo(String nombreArchivo) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String linea = reader.readLine();
                if (linea != null) {
                    sb.append(linea);
                } else {
                    reader.close();
                    return sb.toString();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String convertirABase64(String contenido) {
        byte[] bytes = contenido.getBytes();
        return Base64.getEncoder().encodeToString(bytes);
    }

    public static File buscarArchivo(String prefijo, String extension, String rutaCarpeta) {
        File carpeta = new File(rutaCarpeta);
        if (!carpeta.isDirectory()) {
            JOptionPane.showMessageDialog((Component) null, "La ruta especificada no es una carpeta.", "ERROR", 0);
            throw new IllegalArgumentException("La ruta especificada no es una carpeta.");
        }
        File[] archivos = carpeta.listFiles();
        if (archivos != null) {
            for (File archivo : archivos) {
                if (archivo.isFile() && archivo.getName().startsWith(prefijo) && archivo.getName().toLowerCase().endsWith(extension.toLowerCase())) {
                    return archivo;
                }
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.fasterxml.jackson.core.JsonProcessingException */
    public static void validacionRips1(Long idNumeroFactura, String numeroFactura, Integer tipoConvenio, String urlExportacion) throws JsonProcessingException {
        try {
            RecursosMicroserviciosDomain microserviciosDomain = metodos.getParametrosEncriptados("26", "ValidacionRipsSispro");
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            RipsConsolidadoDTO ripsEnviadoDTO = generacionFactura(idNumeroFactura, numeroFactura, tipoConvenio);
            JsonNode rootNode = objectMapper.readTree(objectMapper.writeValueAsString(ripsEnviadoDTO));
            String cleanedJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode);
            System.out.println("JSON limpio: " + cleanedJson);
            UsuarioResponse usuarioResponse = logueUsuario();
            Response response = enviarPeticion(cleanedJson, microserviciosDomain, usuarioResponse);
            procesarRespuesta(response, idNumeroFactura, objectMapper, urlExportacion);
        } catch (Exception ex) {
            Logger.getLogger(ProcesosValidacionRipsApi.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.fasterxml.jackson.core.JsonProcessingException */
    public static String validacionRips(Long idNumeroFactura, String numeroFactura, Integer tipoConvenio, String urlExportacion) throws JsonProcessingException {
        try {
            RecursosMicroserviciosDomain microserviciosDomain = metodos.getParametrosEncriptados("26", "ValidacionRipsSispro");
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            RipsConsolidadoDTO ripsEnviadoDTO = generacionFactura(idNumeroFactura, numeroFactura, tipoConvenio);
            JsonNode rootNode = objectMapper.readTree(objectMapper.writeValueAsString(ripsEnviadoDTO));
            String cleanedJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode);
            UsuarioResponse usuarioResponse = logueUsuario();
            Response response = enviarPeticion(cleanedJson, microserviciosDomain, usuarioResponse);
            boolean procesoExitoso = procesarRespuesta(response, idNumeroFactura, objectMapper, urlExportacion);
            if (procesoExitoso) {
                return "Validación exitosa.";
            }
            return "Error al procesar la respuesta.";
        } catch (Exception ex) {
            Logger.getLogger(ProcesosValidacionRipsApi.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            return "Excepción: " + ex.getMessage();
        }
    }

    private static void removeNullFields(JsonNode node) {
        if (!node.isObject()) {
            if (node.isArray()) {
                Iterator it = node.iterator();
                while (it.hasNext()) {
                    JsonNode item = (JsonNode) it.next();
                    removeNullFields(item);
                }
                return;
            }
            return;
        }
        ObjectNode objectNode = (ObjectNode) node;
        if (objectNode.isArray()) {
            List<String> fieldsToRemove = new ArrayList<>();
            objectNode.fields().forEachRemaining(entry -> {
                JsonNode child = (JsonNode) entry.getValue();
                if (child.isNull()) {
                    fieldsToRemove.add(entry.getKey());
                } else {
                    removeNullFields(child);
                }
            });
            objectNode.getClass();
            fieldsToRemove.forEach(objectNode::remove);
        }
    }

    private static Response enviarPeticion(String json, RecursosMicroserviciosDomain microserviciosDomain, UsuarioResponse usuarioResponse) {
        System.out.println("========== ENVÍO DE PETICIÓN ==========");
        if (microserviciosDomain == null) {
            System.err.println("❌ microserviciosDomain es NULL");
            return null;
        }
        System.out.println("URL del microservicio: " + microserviciosDomain.getUrlRecurso());
        if (usuarioResponse == null || usuarioResponse.getToken() == null) {
            System.err.println("❌ usuarioResponse o su token es NULL");
            return null;
        }
        System.out.println("Token usado (primeros 20 caracteres): " + usuarioResponse.getToken().substring(0, Math.min(20, usuarioResponse.getToken().length())) + "...");
        if (json == null) {
            System.err.println("❌ El JSON enviado es NULL");
            return null;
        }
        System.out.println("JSON enviado:\n" + json);
        System.out.println("=======================================");
        return metodos.getResteasyClient().target(microserviciosDomain.getUrlRecurso()).request(new String[]{"application/json"}).header("Authorization", "Bearer " + usuarioResponse.getToken()).post(Entity.entity(json, "application/json"));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.fasterxml.jackson.core.JsonProcessingException */
    private static boolean procesarRespuesta(Response response, Long idNumeroFactura, ObjectMapper objectMapper, String urlExportacion) throws JsonProcessingException {
        try {
            int statusCode = response.getStatus();
            String jsonResponse = (String) response.readEntity(String.class);
            Logger.getLogger(ProcesosValidacionRipsApi.class.getName()).log(Level.INFO, "Código de estado: {0}, Respuesta: {1}", new Object[]{Integer.valueOf(statusCode), jsonResponse});
            Gson gson = new GsonBuilder().registerTypeAdapter(ResultadoProcesoDTO.class, new CamelCaseDeserializer()).create();
            ResultadoProcesoDTO respuestaValidacion = (ResultadoProcesoDTO) gson.fromJson(jsonResponse, ResultadoProcesoDTO.class);
            if (respuestaValidacion == null || esRespuestaVacia(respuestaValidacion)) {
                respuestaValidacion = crearRespuestaGenerica();
            }
            registrarValidacion(respuestaValidacion, idNumeroFactura, objectMapper);
            if (respuestaValidacion.isResultState()) {
                Logger.getLogger(ProcesosValidacionRipsApi.class.getName()).log(Level.INFO, "La respuesta contiene ResultState: true");
                return true;
            }
            return false;
        } catch (Exception ex) {
            Logger.getLogger(ProcesosValidacionRipsApi.class.getName()).log(Level.SEVERE, "Excepción al procesar la respuesta", (Throwable) ex);
            return false;
        }
    }

    private static boolean esRespuestaVacia(ResultadoProcesoDTO respuesta) {
        if (respuesta == null) {
            Logger.getLogger(ProcesosValidacionRipsApi.class.getName()).log(Level.WARNING, "La respuesta es nula.");
            return true;
        }
        if (respuesta.getResultadosValidacion() == null || respuesta.getResultadosValidacion().isEmpty()) {
            Logger.getLogger(ProcesosValidacionRipsApi.class.getName()).log(Level.WARNING, "El campo resultadosValidacion es nulo o vacío.");
            return true;
        }
        return false;
    }

    private static ResultadoProcesoDTO crearRespuestaGenerica() {
        return ResultadoProcesoDTO.builder().resultState(false).procesoId(0).numFactura("ERROR").codigoUnicoValidacion("ERROR").codigoUnicoValidacionToShow("SERVIDOR DEL MINISTERIO NO RESPONDE").fechaRadicacion("N/A").rutaArchivos("N/A").resultadosValidacion(Collections.emptyList()).build();
    }

    private void generarCuv(Long idNumeroFactura, String urlExportacion, String numeroFactura) {
        crearCarpetaSiNoExiste(numeroFactura, urlExportacion);
        System.err.println("urlExportacion: " + urlExportacion);
        System.err.println("metodos.getBarra(): " + metodos.getBarra());
        System.err.println("numeroFactura: " + numeroFactura);
        String nombreArchivo = numeroFactura + "CUV.json";
        String rutaArchivo = urlExportacion + metodos.getBarra() + numeroFactura + metodos.getBarra() + nombreArchivo;
        System.err.println("rutaArchivo: " + rutaArchivo);
        RecursosMicroserviciosDomain microserviciosDomain = metodos.getParametrosEncriptados("26", "GenerarCuv");
        String fullUrl = microserviciosDomain.getUrlRecurso() + "/" + idNumeroFactura + "/true";
        System.err.println("fullUrl: " + fullUrl);
        Response response = metodos.getResteasyClient().target(fullUrl).request().get();
        if (response.getStatus() == 200) {
            try {
                String jsonResponse = (String) response.readEntity(String.class);
                System.out.println("JSON recibido: " + jsonResponse);
                CustomPresenter presenter = (CustomPresenter) metodos.getMapper().readValue(jsonResponse, CustomPresenter.class);
                System.out.println("Datos en el presenter: " + presenter.getData());
                ValidacionRipsRespuesta resultadoProcesoDTO = (ValidacionRipsRespuesta) metodos.getMapper().readValue(metodos.getMapper().writeValueAsString(presenter.getData()), new TypeReference<ValidacionRipsRespuesta>() { // from class: com.genoma.plus.controller.facturacion.ProcesosValidacionRipsApi.3
                });
                ResultadoProcesoDTO resultadoProceso = resultadoProcesoDTO.getResponse();
                if (resultadoProceso != null) {
                    System.out.println("Código Único de Validación: " + resultadoProceso.getCodigoUnicoValidacion());
                    guardarJson(resultadoProceso, rutaArchivo);
                    System.out.println("Archivo JSON sobrescrito.");
                }
            } catch (JsonProcessingException e) {
                Logger.getLogger(ProcesosValidacionRipsApi.class.getName()).log(Level.SEVERE, (String) null, e);
            }
        }
        response.close();
        metodos.getResteasyClient().close();
    }

    private static void registrarValidacion(ResultadoProcesoDTO respuestaValidacion, Long idNumeroFactura, ObjectMapper objectMapper) throws JsonProcessingException {
        if (respuestaValidacion == null) {
            throw new IllegalArgumentException("respuestaValidacion cannot be null");
        }
        if (idNumeroFactura == null) {
            throw new IllegalArgumentException("idNumeroFactura cannot be null");
        }
        if (objectMapper == null) {
            throw new IllegalArgumentException("objectMapper cannot be null");
        }
        RecursosMicroserviciosDomain microserviciosDomain = metodos.getParametrosEncriptados("26", "registerValidacionRips");
        if (microserviciosDomain == null || microserviciosDomain.getUrlRecurso() == null) {
            throw new IllegalArgumentException("microserviciosDomain or its URL cannot be null");
        }
        System.err.println("urlRegistrar" + microserviciosDomain.getUrlRecurso());
        if (Principal.usuarioSistemaDTO == null || Principal.usuarioSistemaDTO.getNombreCargoUsuario() == null || Principal.usuarioSistemaDTO.getNombreUsuario() == null) {
            throw new IllegalArgumentException("Principal.usuarioSistemaDTO or its properties cannot be null");
        }
        ValidacionRipsRespuesta respuesta = ValidacionRipsRespuesta.builder().cargo(Principal.usuarioSistemaDTO.getNombreCargoUsuario()).estado(true).fechaRegistro(LocalDateTime.now()).idFacturaEvento(idNumeroFactura).numeroFacturaEvento(respuestaValidacion.getNumFactura()).response(respuestaValidacion).usuario(Principal.usuarioSistemaDTO.getNombreUsuario()).build();
        metodos.getResteasyClient().target(microserviciosDomain.getUrlRecurso()).request(new String[]{"application/json"}).post(Entity.entity(objectMapper.writeValueAsString(respuesta), "application/json"));
    }

    private static void crearJsonValidacionStatusOk(ResultadoProcesoDTO respuestaValidacion, Long idNumeroFactura, ObjectMapper objectMapper) throws JsonProcessingException {
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.fasterxml.jackson.core.JsonProcessingException */
    public void acciones(Long idFacturaEvento, String numeroFactura, int modalidadContrato, JInternalFrame frame, String urlExportacion) throws JsonProcessingException {
        Object[] botones = {"Validación Evento ApiRips", "Bitacora Validación", "Generación carpeta", "Generación CUV", "Cerrar"};
        int n = JOptionPane.showInternalOptionDialog(frame, "Que desea realizar?", "VALIDACIÓN", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
        switch (n) {
            case 0:
                String resultado = validacionRips(idFacturaEvento, numeroFactura, Integer.valueOf(modalidadContrato), urlExportacion);
                if ("Validación exitosa.".equals(resultado)) {
                    cargarModalBitacora(idFacturaEvento, frame);
                } else {
                    cargarModalBitacora(idFacturaEvento, frame);
                    System.out.println("Error en la validación: " + resultado);
                }
                break;
            case 1:
                cargarModalBitacora(idFacturaEvento, frame);
                break;
            case 2:
                generarArhivosMasivos(idFacturaEvento, numeroFactura, modalidadContrato, frame, urlExportacion);
                System.err.println("modalidadContrato" + modalidadContrato);
                break;
            case 3:
                generarCuv(idFacturaEvento, urlExportacion, numeroFactura);
                generarArhivosMasivos(idFacturaEvento, numeroFactura, modalidadContrato, frame, urlExportacion);
                break;
        }
    }

    public void generarArhivosMasivos(Long idFacturaEvento, String numeroFactura, int modalidadContrato, JInternalFrame frame, String urlExportacion) {
        RipsConsolidadoDTO consolidadoDTO = generacionFactura(idFacturaEvento, numeroFactura, Integer.valueOf(modalidadContrato));
        crearCarpetaSiNoExiste(numeroFactura, urlExportacion);
        crearArchivosCarpeta(numeroFactura, consolidadoDTO, urlExportacion);
        crearxml(numeroFactura, urlExportacion);
    }

    private void crearCarpetaSiNoExiste(String numeroFactura, String urlExportacion) {
        String ruta = urlExportacion + metodos.getBarra() + numeroFactura;
        File carpeta = new File(ruta);
        if (!carpeta.exists()) {
            boolean creado = carpeta.mkdirs();
            if (creado) {
                System.out.println("Carpeta creada exitosamente.");
                return;
            } else {
                System.out.println("No se pudo crear la carpeta.");
                return;
            }
        }
        System.out.println("La carpeta ya existe.");
    }

    public void cargarModalBitacora(Long idFacturaEvento, JInternalFrame frame) {
        JDDetalleValidacionRips dDetalleValidacionRips = new JDDetalleValidacionRips(null, true, idFacturaEvento);
        dDetalleValidacionRips.setLocationRelativeTo(frame);
        dDetalleValidacionRips.setVisible(true);
    }

    private void crearArchivosCarpeta(String numeroFactura, RipsConsolidadoDTO consolidadoDTO, String urlExportacion) {
        String ruta = urlExportacion + metodos.getBarra() + numeroFactura;
        String rutaArchivoJson = numeroFactura + ".json";
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
            objectWriter.writeValue(new File(ruta + metodos.getBarra() + rutaArchivoJson), consolidadoDTO.getRips());
            System.out.println("JSON guardado en el archivo correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar el JSON en el archivo: " + e.getMessage());
        }
    }

    private void crearxml(String numeroFactura, String urlExportacion) {
        String ruta = urlExportacion + metodos.getBarra() + numeroFactura;
        new File(ruta);
        String urlRuta = Principal.informacionIps.getUrlRecursosAnkara() + metodos.getBarra() + numeroFactura + metodos.getBarra();
        Path pathCarpeta = Paths.get(urlRuta, new String[0]);
        if (Files.exists(pathCarpeta, new LinkOption[0])) {
            try {
                File archivoXml = buscarArchivo("ad", "xml", urlRuta);
                if (archivoXml != null) {
                    Path archivoOrigen = Paths.get(archivoXml.getAbsolutePath(), new String[0]);
                    Path archivoDestino = Paths.get(ruta, archivoXml.getName());
                    Files.copy(archivoOrigen, archivoDestino, StandardCopyOption.REPLACE_EXISTING);
                } else {
                    System.out.println("No se encontró ningún archivo XML en la ruta especificada.");
                }
            } catch (IOException ex) {
                Logger.getLogger(ProcesosValidacionRipsApi.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    private void eliminarCarpeta(String rutaCarpeta) {
        Path pathCarpeta = Paths.get(rutaCarpeta, new String[0]);
        File carpeta = new File(rutaCarpeta);
        if (carpeta.exists()) {
            try {
                Files.deleteIfExists(pathCarpeta);
            } catch (IOException e) {
                System.out.println("Error al eliminar la carpeta: " + e.getMessage());
            }
        }
    }

    private void guardarJson(ResultadoProcesoDTO resultadoProceso, String rutaArchivo) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.setPropertyNamingStrategy(new CapitalizedNamingStrategy());
        try {
            ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
            objectWriter.writeValue(new File(rutaArchivo), resultadoProceso);
            System.out.println("JSON guardado en el archivo correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar el JSON en el archivo: " + e.getMessage());
        }
    }

    private void eliminarCarpetaV2(String rutaCarpeta) {
        Path pathCarpeta = Paths.get(rutaCarpeta, new String[0]);
        if (Files.exists(pathCarpeta, new LinkOption[0])) {
            try {
                Files.walkFileTree(pathCarpeta, new SimpleFileVisitor<Path>() { // from class: com.genoma.plus.controller.facturacion.ProcesosValidacionRipsApi.4
                    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                        Files.delete(file);
                        return FileVisitResult.CONTINUE;
                    }

                    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
                    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                        Files.delete(dir);
                        return FileVisitResult.CONTINUE;
                    }
                });
            } catch (IOException e) {
                System.out.println("Error al eliminar la carpeta: " + e.getMessage());
            }
        }
    }
}
