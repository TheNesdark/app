package Utilidades.tree;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.MenuParametrizacionEntity1;
import com.genoma.plus.jpa.entities.MenuSGCEntity;
import com.genoma.plus.jpa.service.MenuParametrizacionService;
import com.genoma.plus.jpa.service.MenuSGCService;
import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/tree/RegionStoreAdapter.class */
public class RegionStoreAdapter implements HierarchicalDataStore {
    private String xTablaMenu;
    private String xTablaMenuUsuario;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private final MenuSGCService serviceSGC = (MenuSGCService) Principal.contexto.getBean(MenuSGCService.class);
    private final MenuParametrizacionService serviceParam = (MenuParametrizacionService) Principal.contexto.getBean(MenuParametrizacionService.class);
    private Metodos xMetodos = new Metodos();
    private MenuParametrizacionEntity1 xParam;
    private MenuSGCEntity xSGC;
    private Connection connection;
    private String serverName;
    private String userName;
    private String password;
    private String dbName;

    public RegionStoreAdapter(String serverName, String dbName, String userName, String password) {
        this.serverName = serverName;
        this.userName = userName;
        this.dbName = dbName;
        this.password = password;
    }

    public RegionStoreAdapter(String xTablaMenu, String xTablaMenuUsuario) {
        this.xTablaMenu = xTablaMenu;
        this.xTablaMenuUsuario = xTablaMenuUsuario;
    }

    @Override // Utilidades.tree.HierarchicalDataStore
    public HierarchicalItem getItem(Object id) throws StorageException {
        Region r = null;
        String sql = " select " + this.xTablaMenu + ".`Id`, " + this.xTablaMenu + ".`menuName`, " + this.xTablaMenu + ".`parentId`," + this.xTablaMenuUsuario + ".`Estado` FROM " + this.xTablaMenuUsuario + " INNER JOIN " + this.xTablaMenu + " ON (" + this.xTablaMenuUsuario + ".`IdMenu` = " + this.xTablaMenu + ".`Id`)\n WHERE (" + this.xTablaMenuUsuario + ".`IdUsuario` ='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' AND " + this.xTablaMenuUsuario + ".`Estado`=1 AND " + this.xTablaMenuUsuario + ".`IdMenu`='" + id.toString() + "') order by " + this.xTablaMenu + ".`menuName` asc   ";
        try {
            ResultSet rs = this.xct.traerRs(sql);
            if (rs.first() && !rs.isAfterLast()) {
                r = new Region(Integer.valueOf(rs.getInt("Id")), rs.getString("menuName"));
                r.setParentId(Integer.valueOf(rs.getInt("parentId")));
            }
            rs.close();
            this.xct.cerrarConexionBd();
            return r;
        } catch (SQLException e) {
            throw new StorageException(e);
        }
    }

    @Override // Utilidades.tree.HierarchicalDataStore
    public Vector<HierarchicalItem> getChildItems(Object id) throws StorageException {
        Vector<HierarchicalItem> v = new Vector<>();
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT ").append(this.xTablaMenu).append(".`Id`, ").append(this.xTablaMenu).append(".`menuName`, ").append(this.xTablaMenu).append(".`parentId`,").append(this.xTablaMenuUsuario).append(".`Estado` FROM ");
        sql.append("baseserver");
        sql.append(".").append(this.xTablaMenuUsuario).append(" INNER JOIN ").append(this.xTablaMenu).append(" ON (").append(this.xTablaMenuUsuario).append(".`IdMenu` = ").append(this.xTablaMenu).append(".`Id`) WHERE (").append(this.xTablaMenuUsuario).append(".`IdUsuario` ='").append(Principal.usuarioSistemaDTO.getIdUsuarioSistema()).append("' AND ").append(this.xTablaMenuUsuario).append(".`Estado`=1 AND ").append(this.xTablaMenu).append(".`parentId`='").append(id.toString()).append("')");
        try {
            ResultSet rs = this.xct.traerRs(sql.toString());
            if (rs.first()) {
                while (!rs.isAfterLast()) {
                    Region r = new Region(Integer.valueOf(rs.getInt("Id")), rs.getString("menuName"));
                    r.setParentId(id);
                    v.addElement(r);
                    rs.next();
                }
            } else {
                v = null;
            }
            rs.close();
            this.xct.cerrarConexionBd();
            return v;
        } catch (SQLException e) {
            throw new StorageException(e);
        }
    }

    @Override // Utilidades.tree.HierarchicalDataStore
    public Vector<HierarchicalItem> getRootItems() throws StorageException {
        Vector<HierarchicalItem> v = new Vector<>();
        StringBuffer sql = new StringBuffer();
        sql.append("select * from ");
        sql.append("baseserver");
        sql.append(".").append(this.xTablaMenu).append(" where parentId=0");
        try {
            ResultSet rs = this.xct.traerRs(sql.toString());
            if (rs.first() && !rs.isAfterLast()) {
                while (!rs.isAfterLast()) {
                    Region r = new Region(Integer.valueOf(rs.getInt("Id")), rs.getString("menuName"));
                    r.setParentId(new Integer(-1));
                    v.addElement(r);
                    rs.next();
                }
            } else {
                v = null;
            }
            rs.close();
            this.xct.cerrarConexionBd();
            return v;
        } catch (SQLException e) {
            throw new StorageException(e);
        }
    }

    @Override // Utilidades.tree.HierarchicalDataStore
    public HierarchicalItem putItem(HierarchicalItem item) throws StorageException {
        HierarchicalItem returnItem = null;
        System.out.println("acrual: " + item.getId().toString());
        if (!"-1".equals(item.getId().toString()) && ItemRepetido(this.xTablaMenu, item.getData().toString(), item.getParentId().toString()).booleanValue()) {
            StringBuffer sql = new StringBuffer();
            sql.append("update ");
            sql.append("baseserver");
            sql.append(".").append(this.xTablaMenu).append(" set menuName='");
            sql.append(item.getData().toString());
            sql.append("', parentId=");
            sql.append(item.getParentId().toString());
            sql.append(" where Id=");
            sql.append(item.getId().toString());
            System.out.println("Actualiza Menu: " + ((Object) sql));
            int result = this.xct.ejecutaSQLUpdate(sql.toString());
            if (result > 0) {
                returnItem = item;
            }
            this.xct.cerrarConexionBd();
        } else {
            createItem(item);
        }
        return returnItem;
    }

    @Override // Utilidades.tree.HierarchicalDataStore
    public Object createItem(HierarchicalItem item) throws StorageException {
        Integer newId = -1;
        StringBuffer sql = new StringBuffer();
        if (!item.getData().toString().contains("new region") && ItemRepetido(this.xTablaMenu, item.getParentId().toString(), item.getData().toString()).booleanValue()) {
            sql.append("insert into ");
            sql.append("baseserver");
            sql.append(".").append(this.xTablaMenu).append(" set menuName='");
            sql.append(item.getData().toString());
            sql.append("', parentId=");
            sql.append(item.getParentId().toString());
            System.out.println("Inserta Menu" + ((Object) sql));
            try {
                ConsultasMySQL xct2 = new ConsultasMySQL();
                xct2.ejecutaSQLUpdate(sql.toString());
                xct2.cerrarConexionBd();
                StringBuffer sql2 = new StringBuffer();
                sql2.append("select Id from ");
                sql2.append("baseserver");
                sql2.append(".").append(this.xTablaMenu).append(" where menuName='");
                sql2.append(item.getData().toString());
                sql2.append("'");
                System.out.println("Consultar IdMenu Creado: " + ((Object) sql2));
                ResultSet rs = xct2.traerRs(sql2.toString());
                if (rs.first() && !rs.isAfterLast()) {
                    newId = Integer.valueOf(rs.getInt("Id"));
                    if (newId.intValue() > -1) {
                        grabarItemAUsuario(this.xTablaMenu, newId);
                    }
                }
                rs.close();
                xct2.cerrarConexionBd();
            } catch (Exception e) {
                throw new StorageException(e);
            }
        }
        return newId;
    }

    private Boolean ItemRepetido(String tabla, String idPadre, String nombre) {
        String repetido;
        if (tabla.equals("g_menu_conf_cal")) {
            repetido = this.serviceSGC.mBuscarRepetidosSGC(idPadre, nombre).getRepetido();
        } else {
            repetido = this.serviceParam.mBuscarRepetidosCONFI(idPadre, nombre).getRepetido();
        }
        try {
            if (!repetido.equals("0")) {
                JOptionPane.showMessageDialog((Component) null, "Ya existe un Item con este nombre: " + nombre);
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return Boolean.valueOf(repetido.equals("0"));
    }

    private void grabarItemAUsuario(String tabla, Integer idItem) {
        if (tabla.equals("g_menu_conf_cal")) {
            this.xSGC = new MenuSGCEntity();
            this.xSGC.setIdUsuario(Principal.usuarioSistemaDTO.getIdUsuarioSistema());
            this.xSGC.setIdMenu(idItem);
            this.xSGC.setEstado(1);
            this.xSGC.setFecha(this.xMetodos.getFechaActual());
            this.xSGC.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
            this.serviceSGC.mGrabarItemSGC(Principal.usuarioSistemaDTO.getIdUsuarioSistema(), idItem, Principal.usuarioSistemaDTO.getLogin());
            return;
        }
        this.xParam = new MenuParametrizacionEntity1();
        this.xParam.setIdUsuario(Principal.usuarioSistemaDTO.getIdUsuarioSistema());
        this.xParam.setIdMenu(idItem);
        this.xParam.setEstado(1);
        this.xParam.setFecha(this.xMetodos.getFechaActual());
        this.xParam.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
        this.serviceParam.mGrabarItemParametrizacion(Principal.usuarioSistemaDTO.getIdUsuarioSistema(), idItem, Principal.usuarioSistemaDTO.getLogin());
    }

    @Override // Utilidades.tree.HierarchicalDataStore
    public Object deleteItem(Object id) throws StorageException {
        Object deletedId = null;
        StringBuffer sql = new StringBuffer();
        sql.append("delete from ");
        sql.append("baseserver");
        sql.append(".").append(this.xTablaMenu).append(" where Id=");
        sql.append(id.toString());
        int result = this.xct.ejecutaSQLUpdate(sql.toString());
        if (result > 0) {
            deletedId = id;
        }
        this.xct.cerrarConexionBd();
        return deletedId;
    }

    private Connection getConnection() {
        if (this.connection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                StringBuffer buf = new StringBuffer();
                buf.append("jdbc:mysql://");
                buf.append(this.serverName);
                buf.append("/");
                buf.append(this.dbName);
                buf.append("?user=");
                buf.append(this.userName);
                buf.append("&password=");
                buf.append(this.password);
                this.connection = DriverManager.getConnection(buf.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.connection;
    }

    public void closeConnection() {
        if (this.connection != null) {
            try {
                this.connection.close();
                this.connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
