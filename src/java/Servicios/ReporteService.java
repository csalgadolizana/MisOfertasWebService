/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Puntos;
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
@WebService(serviceName = "ReporteService")
public class ReporteService {

    @PersistenceContext
    EntityManager em;

    @WebMethod(operationName = "Listado_reportes")
    public List<Puntos> ListadoReportes() {
        TypedQuery<Puntos> query = em.createNamedQuery("Puntos.findAll", Puntos.class);
        return query.getResultList();
    }

    @WebMethod(operationName = "Crear_reporte")
    public String CrearReporte(
            @WebParam(name = "id") int id, @WebParam(name = "local_id") int local_id
    ) {
        try {
            StoredProcedureQuery query = em.createStoredProcedureQuery("CREAR_REPORTE");
            query.registerStoredProcedureParameter("ID_REPO", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("LOC", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("SALIDA", Number.class, ParameterMode.OUT);
            query.setParameter("ID_REPO", id);
            query.setParameter("ID_REPO", local_id);
            query.execute();
            return query.getOutputParameterValue("SALIDA").toString();
        } catch (Exception e) {
            return 0 + "";
        }
    }
}