/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Producto;
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
@WebService(serviceName = "PuntosService")
public class PuntosService {

    @PersistenceContext
    EntityManager em;

    @WebMethod(operationName = "Listado_puntos")
    public List<Puntos> ListadoPuntos() {
        TypedQuery<Puntos> query = em.createNamedQuery("Puntos.findAll", Puntos.class);
        return query.getResultList();
    }

    @WebMethod(operationName = "Crear_puntos")
    public String CrearPuntos(
            @WebParam(name = "id") int id, @WebParam(name = "total_puntos") int total_puntos,
            @WebParam(name = "fecha_actulizacion") Date fecha_actulizacion, @WebParam(name = "puntos_canjeados") int puntos_canjeados,
            @WebParam(name = "id_cliente") int id_cliente
    ) {
        try {
            StoredProcedureQuery query = em.createStoredProcedureQuery("CREAR_PUNTOS");
            query.registerStoredProcedureParameter("ID_P", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("TOTALP", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("FECHA_AC", Date.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("PUNTOC", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("ID_CLI", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("SALIDA", Number.class, ParameterMode.OUT);
            query.setParameter("ID_P", id);
            query.setParameter("TOTALP", total_puntos);
            query.setParameter("FECHA_AC", fecha_actulizacion);
            query.setParameter("PUNTOC", puntos_canjeados);
            query.setParameter("ID_CLI", id_cliente);
            query.execute();
            return query.getOutputParameterValue("SALIDA").toString();
        } catch (Exception e) {
            return 0 + "";
        }
    }
    
    @WebMethod(operationName = "Eliminar_puntos")
    public String EliminarPuntos(@WebParam(name = "id") int idd) {
        try {
            StoredProcedureQuery query = em.createStoredProcedureQuery("ELIMINAR_PUNTOS");
            query.registerStoredProcedureParameter("ID_PTS", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("SALIDA", Number.class, ParameterMode.OUT);
            query.setParameter("ID_PTS", idd);
            query.execute();
            return query.getOutputParameterValue("SALIDA").toString();
        } catch (Exception e) {
            return 0 + "err";
        }
    }
}
