/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.OfertasVisitas;
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
@WebService(serviceName = "OfertaVisitaService")
public class OfertaVistaService {

    @PersistenceContext
    EntityManager em;

    @WebMethod(operationName = "Listado_oferta_visitas")
    public List<OfertasVisitas> ListadoOfertaVisitas() {
        TypedQuery<OfertasVisitas> query = em.createNamedQuery("OfertasVisitas.findAll", OfertasVisitas.class);
        return query.getResultList();
    }

    @WebMethod(operationName = "Crear_oferta_visitas")
    public String CrearOfertaVisitas(
            @WebParam(name = "fecha_vista") Date fecha_vista, @WebParam(name = "id_oferta_visita") int id_oferta_visita,
            @WebParam(name = "id_cliente") int id_cliente, @WebParam(name = "id_oferta") int id_oferta
    ) {
        try {
            StoredProcedureQuery query = em.createStoredProcedureQuery("CREAR_OFERTA_VISITA");
            query.registerStoredProcedureParameter("FECHV", Date.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("IDOFV", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("ID_CLI", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("ID_OFE", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("SALIDA", Number.class, ParameterMode.OUT);
            query.setParameter("FECHV", fecha_vista);
            query.setParameter("IDOFV", id_oferta_visita);
            query.setParameter("ID_CLI", id_cliente);
            query.setParameter("ID_OFE", id_oferta);
            query.execute();
            return query.getOutputParameterValue("SALIDA").toString();
        } catch (Exception e) {
            return 0 + "";
        }
    }
    
    @WebMethod(operationName = "Eliminar_oferta_visitas")
    public String EliminarOfertaVisita(@WebParam(name = "id") int idd) {
        try {
            StoredProcedureQuery query = em.createStoredProcedureQuery("ELIMINAR_OFERTAVISITA");
            query.registerStoredProcedureParameter("ID_OFEVISI", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("SALIDA", Number.class, ParameterMode.OUT);
            query.setParameter("ID_OFEVISI", idd);
            query.execute();
            return query.getOutputParameterValue("SALIDA").toString();
        } catch (Exception e) {
            return 0 + "err";
        }
    }
}
