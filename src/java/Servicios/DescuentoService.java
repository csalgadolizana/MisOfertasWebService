/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Descuento;
import java.util.Date;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

/**
 *
 * @author PC-Cristopher
 */
@WebService(serviceName = "DescuentoService")
public class DescuentoService {

    @PersistenceContext
    EntityManager em;

    @WebMethod(operationName = "Listado_descuento")
    public List<Descuento> ListadoDescuento() {
        List<Descuento> arr_cust = (List<Descuento>) em.createNativeQuery("select * from VIEW_DESCUENTO d", Descuento.class)
                .getResultList();
        return arr_cust;
    }

    @WebMethod(operationName = "Crear_descuento")
    public String CrearDescuento(
            @WebParam(name = "id") int idd, @WebParam(name = "codigo") String codigo,
            @WebParam(name = "tope") int tope, @WebParam(name = "valor") int valor,
            @WebParam(name = "puntos_usados") int puntos_usados, @WebParam(name = "fecha_inicio") Date fecha_inicio,
            @WebParam(name = "fecha_actualizacion") Date fecha_actualizacion, @WebParam(name = "id_cliente") int id_cliente,
            @WebParam(name = "estado_id") int estado_id, @WebParam(name = "categoria_id") int categoria_id
    ) {
        try {
            StoredProcedureQuery query = em.createStoredProcedureQuery("CREAR_DESCUENTO");
            query.registerStoredProcedureParameter("ID_DES", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("CODI", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("TOP", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("VALOR", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("PU", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("INI", Date.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("ACTU", Date.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("ID_CLI", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("ID_ES", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("ID_CAT", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("SALIDA", Number.class, ParameterMode.OUT);
            query.setParameter("ID_CLI", idd);
            query.setParameter("CODI", codigo);
            query.setParameter("TOP", tope);
            query.setParameter("VALOR", valor);
            query.setParameter("PU", puntos_usados);
            query.setParameter("INI", fecha_inicio);
            query.setParameter("ACTU", fecha_actualizacion);
            query.setParameter("ID_CLI", id_cliente);
            query.setParameter("ID_ES", estado_id);
            query.setParameter("ID_CAT", categoria_id);
            query.execute();
            return query.getOutputParameterValue("SALIDA").toString();
        } catch (Exception e) {
            return 0 + "";
        }
    }
    
    @WebMethod(operationName = "Modificar_descuento")
    public String ModificarDescuento(
            @WebParam(name = "id") int idd, @WebParam(name = "codigo") String codigo,
            @WebParam(name = "tope") int tope, @WebParam(name = "valor") int valor,
            @WebParam(name = "puntos_usados") int puntos_usados, @WebParam(name = "fecha_inicio") Date fecha_inicio,
            @WebParam(name = "fecha_actualizacion") Date fecha_actualizacion, @WebParam(name = "id_cliente") int id_cliente,
            @WebParam(name = "estado_id") int estado_id, @WebParam(name = "categoria_id") int categoria_id
    ) {
        try {
            StoredProcedureQuery query = em.createStoredProcedureQuery("ACTUALIZAR_DESCUENTO");
            query.registerStoredProcedureParameter("ID_DES", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("CODI", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("TOP", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("VALOR", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("PU", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("INI", Date.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("ACTU", Date.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("ID_CLI", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("ID_ES", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("ID_CAT", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("SALIDA", Number.class, ParameterMode.OUT);
            query.setParameter("ID_CLI", idd);
            query.setParameter("CODI", codigo);
            query.setParameter("TOP", tope);
            query.setParameter("VALOR", valor);
            query.setParameter("PU", puntos_usados);
            query.setParameter("INI", fecha_inicio);
            query.setParameter("ACTU", fecha_actualizacion);
            query.setParameter("ID_CLI", id_cliente);
            query.setParameter("ID_ES", estado_id);
            query.setParameter("ID_CAT", categoria_id);
            query.execute();
            em.getEntityManagerFactory().getCache().evictAll();
            return query.getOutputParameterValue("SALIDA").toString();
        } catch (Exception e) {
            System.err.println("Error en -> ModificarDescuento() ->" + e.getMessage());
            return 0 + "";
        }
    }
    
    @WebMethod(operationName = "Eliminar_descuento")
    public String EliminarDescuento(@WebParam(name = "id") int idd) {
        try {
            StoredProcedureQuery query = em.createStoredProcedureQuery("ELIMINAR_DESCUENTO");
            query.registerStoredProcedureParameter("ID_DES", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("SALIDA", Number.class, ParameterMode.OUT);
            query.setParameter("ID_DES", idd);
            query.execute();
            return query.getOutputParameterValue("SALIDA").toString();
        } catch (Exception e) {
            return 0 + "err";
        }
    }
}
