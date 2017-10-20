/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.CargarPuntos;
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
@WebService(serviceName = "CargarPuntosService")
public class CargarPuntosService {

    @PersistenceContext
    EntityManager em;

    @WebMethod(operationName = "Listado_cargar_puntos")
    public List<CargarPuntos> ListadoCargarPuntos() {
        TypedQuery<CargarPuntos> query = em.createNamedQuery("CargarPuntos.findAll", CargarPuntos.class);
        return query.getResultList();
    }

    @WebMethod(operationName = "Crear_cargar_puntos")
    public String CrearCargarPuntos(
            @WebParam(name = "id") int idd, @WebParam(name = "puntos") int desc,
            @WebParam(name = "id_punto") int id_punto, @WebParam(name = "id_desc") int id_desc) {
        try {
            StoredProcedureQuery query = em.createStoredProcedureQuery("CREAR_CARGAR_PUNTOS");
            query.registerStoredProcedureParameter("ID_CARGAR", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("PUNTOS", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("ID_PUNTO", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("ID_DES", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("SALIDA", Number.class, ParameterMode.OUT);
            query.setParameter("ID_CARGAR", idd);
            query.setParameter("PUNTOS", desc);
            query.setParameter("ID_PUNTO", desc);
            query.setParameter("ID_DES", desc);
            query.execute();
            return query.getOutputParameterValue("SALIDA").toString();
        } catch (Exception e) {
            return 0 + "";
        }
    }
}
