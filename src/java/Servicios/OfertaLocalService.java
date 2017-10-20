/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Oferta;
import Entidades.Ofertalocal;
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
@WebService(serviceName = "OfertaLocalService")
public class OfertaLocalService {

    @PersistenceContext
    EntityManager em;

    @WebMethod(operationName = "Listado_oferta_local")
    public List<Ofertalocal> ListadoOfertaLocal() {
        TypedQuery<Ofertalocal> query = em.createNamedQuery("OfertaLocal.findAll", Ofertalocal.class);
        return query.getResultList();
    }

    @WebMethod(operationName = "Crear_oferta_local")
    public String CrearOfertaLocal(
            @WebParam(name = "id") int idd, @WebParam(name = "descripcion") String descripcion,
            @WebParam(name = "oferta_id") int oferta_id,@WebParam(name = "local_id") int local_id
    ) {
        try {
            StoredProcedureQuery query = em.createStoredProcedureQuery("CREAR_OFERTA_LOCAL");
            query.registerStoredProcedureParameter("ID_OFERL", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("DES", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("ID_OFER", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("ID_LOACL", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("SALIDA", Number.class, ParameterMode.OUT);
            query.setParameter("ID_OFERL", idd);
            query.setParameter("DES", descripcion);
            query.setParameter("ID_OFER", oferta_id);
            query.setParameter("ID_LOACL", local_id);
            query.execute();
            return query.getOutputParameterValue("SALIDA").toString();
        } catch (Exception e) {
            return 0 + "";
        }
    }
    
    @WebMethod(operationName = "Eliminar_oferta_local")
    public String EliminarOfertaLocal(@WebParam(name = "id") int idd) {
        try {
            StoredProcedureQuery query = em.createStoredProcedureQuery("ELIMINAR_OFERTALOCAL");
            query.registerStoredProcedureParameter("ID_OFELOC", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("SALIDA", Number.class, ParameterMode.OUT);
            query.setParameter("ID_OFELOC", idd);
            query.execute();
            return query.getOutputParameterValue("SALIDA").toString();
        } catch (Exception e) {
            return 0 + "err";
        }
    }
}
