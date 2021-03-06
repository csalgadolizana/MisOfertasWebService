/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.DetalleOferta;
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
@WebService(serviceName = "DetalleOfertaService")
public class DetalleOfertaService {

    @PersistenceContext
    EntityManager em;

    @WebMethod(operationName = "Listado_detalle_oferta")
    public List<DetalleOferta> ListadoDetalleOfertas() {
        List<DetalleOferta> arr_cust = (List<DetalleOferta>) em.createNativeQuery("select * from VIEW_DETALLEOFERTA d", DetalleOferta.class)
                .getResultList();
        return arr_cust;
    }

    @WebMethod(operationName = "Crear_detalle_oferta")
    public String CrearDetalleOferta(
            @WebParam(name = "id_detalle_oferta") int idDetalleOferta, @WebParam(name = "producto_id") int producto_id,
            @WebParam(name = "oferta_id") int oferta_id
    ) {
        try {
            StoredProcedureQuery query = em.createStoredProcedureQuery("CREAR_DETALLEOFERTA");
            query.registerStoredProcedureParameter("ID_DETOFE", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("PRDO", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("OFER", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("SALIDA", Number.class, ParameterMode.OUT);
            query.setParameter("ID_DETOFE", idDetalleOferta);
            query.setParameter("PRDO", producto_id);
            query.setParameter("OFER", oferta_id);
            query.execute();
            return query.getOutputParameterValue("SALIDA").toString();
        } catch (Exception e) {
            System.out.println("Error en -> CrearDetalleOferta() ->" + e.getMessage());
            return 0 + "";
        }
    }

    @WebMethod(operationName = "Eliminar_detalle_oferta")
    public String EliminarDetalleOferta(@WebParam(name = "id") int idd) {
        try {
            StoredProcedureQuery query = em.createStoredProcedureQuery("ELIMINAR_DETALLE_OFERTA");
            query.registerStoredProcedureParameter("ID_DO", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("SALIDA", Number.class, ParameterMode.OUT);
            query.setParameter("ID_DO", idd);
            query.execute();
            return query.getOutputParameterValue("SALIDA").toString();
        } catch (Exception e) {
            return 0 + "err";
        }
    }
}
