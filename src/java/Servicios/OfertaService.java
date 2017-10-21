/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Oferta;
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
@WebService(serviceName = "OfertaService")
public class OfertaService {

    @PersistenceContext
    EntityManager em;

    @WebMethod(operationName = "Listado_oferta")
    public List<Oferta> ListadoOferta() {
        List<Oferta> arr_cust = (List<Oferta>) em.createNativeQuery("select * from VIEW_OFERTA o", Oferta.class)
                .getResultList();
        return arr_cust;
    }

    @WebMethod(operationName = "Crear_oferta")
    public String CrearOferta(
            @WebParam(name = "id") int idd, @WebParam(name = "nombre") String nombre,
            @WebParam(name = "descripcion") String descripcion, @WebParam(name = "precio_normal") int precio_normal,
            @WebParam(name = "precio_oferta") int precio_oferta, @WebParam(name = "numero_visitas") int numero_visitas,
            @WebParam(name = "min_compras") int min_compras, @WebParam(name = "max_compras") int max_compras,
            @WebParam(name = "fecha_inicio") Date fecha_inicio, @WebParam(name = "fecha_actulizacion") Date fecha_actulizacion,
            @WebParam(name = "estado_id") int estado_id
    ) {
        try {
            StoredProcedureQuery query = em.createStoredProcedureQuery("CREAR_OFERTA");
            query.registerStoredProcedureParameter("ID_OFE", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("NOMB", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("DES", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("PREC_NORM", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("PREC_OFER", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("NUM_VISITA", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("MIN_COM", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("MAX_COMP", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("INI", Date.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("ACTU", Date.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("ESTADO", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("SALIDA", Number.class, ParameterMode.OUT);
            query.setParameter("ID_OFE", idd);
            query.setParameter("NOMB", nombre);
            query.setParameter("DES", descripcion);
            query.setParameter("PREC_NORM", precio_normal);
            query.setParameter("PREC_OFER", precio_oferta);
            query.setParameter("NUM_VISITAc", numero_visitas);
            query.setParameter("MIN_COM", min_compras);
            query.setParameter("MAX_COMP", max_compras);
            query.setParameter("INI", fecha_inicio);
            query.setParameter("ACTU", fecha_actulizacion);
            query.setParameter("ESTADO", estado_id);
            query.execute();
            return query.getOutputParameterValue("SALIDA").toString();
        } catch (Exception e) {
            return 0 + "";
        }
    }
    
    @WebMethod(operationName = "Modificar_oferta")
    public String ModificarOferta(
            @WebParam(name = "id") int idd, @WebParam(name = "nombre") String nombre,
            @WebParam(name = "descripcion") String descripcion, @WebParam(name = "precio_normal") int precio_normal,
            @WebParam(name = "precio_oferta") int precio_oferta, @WebParam(name = "numero_visitas") int numero_visitas,
            @WebParam(name = "min_compras") int min_compras, @WebParam(name = "max_compras") int max_compras,
            @WebParam(name = "fecha_inicio") Date fecha_inicio, @WebParam(name = "fecha_actulizacion") Date fecha_actulizacion,
            @WebParam(name = "estado_id") int estado_id
    ) {
        try {
            StoredProcedureQuery query = em.createStoredProcedureQuery("ACTUALIZAR_OFERTA");
            query.registerStoredProcedureParameter("ID_OFE", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("NOMB", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("DES", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("PREC_NORM", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("PREC_OFER", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("NUM_VISITA", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("MIN_COM", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("MAX_COMP", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("INI", Date.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("ACTU", Date.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("ESTADO", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("SALIDA", Number.class, ParameterMode.OUT);
            query.setParameter("ID_OFE", idd);
            query.setParameter("NOMB", nombre);
            query.setParameter("DES", descripcion);
            query.setParameter("PREC_NORM", precio_normal);
            query.setParameter("PREC_OFER", precio_oferta);
            query.setParameter("NUM_VISITAc", numero_visitas);
            query.setParameter("MIN_COM", min_compras);
            query.setParameter("MAX_COMP", max_compras);
            query.setParameter("INI", fecha_inicio);
            query.setParameter("ACTU", fecha_actulizacion);
            query.setParameter("ESTADO", estado_id);
            query.execute();
            return query.getOutputParameterValue("SALIDA").toString();
        } catch (Exception e) {
            return 0 + "";
        }
    }
    
    @WebMethod(operationName = "Eliminar_oferta")
    public String EliminarOferta(@WebParam(name = "id") int idd) {
        try {
            StoredProcedureQuery query = em.createStoredProcedureQuery("ELIMINAR_OFERTA");
            query.registerStoredProcedureParameter("ID_OFE", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("SALIDA", Number.class, ParameterMode.OUT);
            query.setParameter("ID_OFE", idd);
            query.execute();
            return query.getOutputParameterValue("SALIDA").toString();
        } catch (Exception e) {
            return 0 + "err";
        }
    }
}
