/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Producto;
import java.util.Date;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;

/**
 *
 * @author PC-Cristopher
 */
@WebService(serviceName = "ProductoService")
public class ProductoService {

    @PersistenceContext
    EntityManager em;

    @WebMethod(operationName = "Listado_productos")
    public List<Producto> ListadoProductos() {
        List<Producto> arr_cust = (List<Producto>) em.createNativeQuery("select * from VIEW_PRODUCTO p", Producto.class)
                .getResultList();
        return arr_cust;
    }

    @WebMethod(operationName = "Crear_producto")
    public String CrearProducto(
            @WebParam(name = "id") int id, @WebParam(name = "nombre") String nombre,
            @WebParam(name = "descripcion") String descripcion, @WebParam(name = "precio") int precio,
            @WebParam(name = "fecha_inicio") Date fecha_inicio, @WebParam(name = "fecha_actualizacion") Date fecha_actualizacion,
            @WebParam(name = "ruta_imagen") String ruta_imagen, @WebParam(name = "id_cagegoria") int id_cagegoria
    ) {
        try {
            StoredProcedureQuery query = em.createStoredProcedureQuery("CREAR_PRODUCTO");
            query.registerStoredProcedureParameter("ID_PRO", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("NOMB", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("DES", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("PREC", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("INI", Date.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("ACTU", Date.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("IMA", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("ID_C", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("SALIDA", Number.class, ParameterMode.OUT);
            query.setParameter("ID_PRO", id);
            query.setParameter("NOMB", nombre);
            query.setParameter("DES", descripcion);
            query.setParameter("PREC", precio);
            query.setParameter("INI", fecha_inicio);
            query.setParameter("ACTU", fecha_actualizacion);
            query.setParameter("IMA", ruta_imagen);
            query.setParameter("ID_C", id_cagegoria);
            query.execute();
            return query.getOutputParameterValue("SALIDA").toString();
        } catch (Exception e) {
            return 0 + "";
        }
    }
    
    @WebMethod(operationName = "Modificar_producto")
    public String ModificarProducto(
            @WebParam(name = "id") int id, @WebParam(name = "nombre") String nombre,
            @WebParam(name = "descripcion") String descripcion, @WebParam(name = "precio") int precio,
            @WebParam(name = "fecha_inicio") Date fecha_inicio, @WebParam(name = "fecha_actualizacion") Date fecha_actualizacion,
            @WebParam(name = "ruta_imagen") String ruta_imagen, @WebParam(name = "id_cagegoria") int id_cagegoria
    ) {
        try {
            StoredProcedureQuery query = em.createStoredProcedureQuery("ACTUALIZAR_PRODUCTO");
            query.registerStoredProcedureParameter("ID_PRO", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("NOMB", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("DES", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("PREC", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("INI", Date.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("ACTU", Date.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("IMA", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("ID_C", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("SALIDA", Number.class, ParameterMode.OUT);
            query.setParameter("ID_PRO", id);
            query.setParameter("NOMB", nombre);
            query.setParameter("DES", descripcion);
            query.setParameter("PREC", precio);
            query.setParameter("INI", fecha_inicio);
            query.setParameter("ACTU", fecha_actualizacion);
            query.setParameter("IMA", ruta_imagen);
            query.setParameter("ID_C", id_cagegoria);
            query.execute();
            em.getEntityManagerFactory().getCache().evictAll();
            return query.getOutputParameterValue("SALIDA").toString();
        } catch (Exception e) {
            return 0 + "";
        }
    }
    
    @WebMethod(operationName = "Eliminar_producto")
    public String EliminarProducto(@WebParam(name = "id") int idd) {
        try {
            StoredProcedureQuery query = em.createStoredProcedureQuery("ELIMINAR_PRODUCTO");
            query.registerStoredProcedureParameter("ID_PRO", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("SALIDA", Number.class, ParameterMode.OUT);
            query.setParameter("ID_PRO", idd);
            query.execute();
            return query.getOutputParameterValue("SALIDA").toString();
        } catch (Exception e) {
            return 0 + "err";
        }
    }
}
