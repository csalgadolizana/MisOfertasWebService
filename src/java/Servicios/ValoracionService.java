/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Usuariooferta;
import Entidades.Valoracion;
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
@WebService(serviceName = "ValoracionService")
public class ValoracionService {

    @PersistenceContext
    EntityManager em;

    @WebMethod(operationName = "Listado_valoraciones")
    public List<Valoracion> ListadoValoracion() {
        TypedQuery<Valoracion> query = em.createNamedQuery("Valoracion.findAll", Valoracion.class);
        return query.getResultList();
    }

    @WebMethod(operationName = "Crear_valoracion")
    public String CrearValoracion(
            @WebParam(name = "id") int id, @WebParam(name = "nota") int nota,
            @WebParam(name = "boleta_adjunta") String boleta_adjunta, @WebParam(name = "fecha_valoracion") Date fecha_valoracion,
            @WebParam(name = "id_cliente") int id_cliente, @WebParam(name = "id_oferta") int id_oferta,
            @WebParam(name = "id_categoria") int id_categoria
    ) {
        try {
            StoredProcedureQuery query = em.createStoredProcedureQuery("CREAR_VALORACION");
            query.registerStoredProcedureParameter("ID_VALO", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("NOTA", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("BOLE", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("FECHA", Date.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("CLI_ID", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("OFER", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("CATE", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("SALIDA", Number.class, ParameterMode.OUT);
            query.setParameter("ID_VALO", id);
            query.setParameter("NOTA", nota);
            query.setParameter("BOLE", boleta_adjunta);
            query.setParameter("FECHA", fecha_valoracion);
            query.setParameter("CLI_ID", id_cliente);
            query.setParameter("OFER", id_oferta);
            query.setParameter("CATE", id_categoria);
            query.execute();
            return query.getOutputParameterValue("SALIDA").toString();
        } catch (Exception e) {
            return 0 + "";
        }
    }
    
    @WebMethod(operationName = "Modificar_valoracion")
    public String ModificarValoracion(
            @WebParam(name = "id") int id, @WebParam(name = "nota") int nota,
            @WebParam(name = "boleta_adjunta") String boleta_adjunta, @WebParam(name = "fecha_valoracion") Date fecha_valoracion,
            @WebParam(name = "id_cliente") int id_cliente, @WebParam(name = "id_oferta") int id_oferta,
            @WebParam(name = "id_categoria") int id_categoria
    ) {
        try {
            StoredProcedureQuery query = em.createStoredProcedureQuery("ACTUALIZAR_VALORACION");
            query.registerStoredProcedureParameter("ID_VALO", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("NOTA", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("BOLE", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("FECHA", Date.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("CLI_ID", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("OFER", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("CATE", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("SALIDA", Number.class, ParameterMode.OUT);
            query.setParameter("ID_VALO", id);
            query.setParameter("NOTA", nota);
            query.setParameter("BOLE", boleta_adjunta);
            query.setParameter("FECHA", fecha_valoracion);
            query.setParameter("CLI_ID", id_cliente);
            query.setParameter("OFER", id_oferta);
            query.setParameter("CATE", id_categoria);
            query.execute();
            return query.getOutputParameterValue("SALIDA").toString();
        } catch (Exception e) {
            return 0 + "";
        }
    }
    
    @WebMethod(operationName = "Eliminar_valoracion")
    public String EliminarValoracion(@WebParam(name = "id") int idd) {
        try {
            StoredProcedureQuery query = em.createStoredProcedureQuery("ELIMINAR_VALORACION");
            query.registerStoredProcedureParameter("ID_VAL", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("SALIDA", Number.class, ParameterMode.OUT);
            query.setParameter("ID_VAL", idd);
            query.execute();
            return query.getOutputParameterValue("SALIDA").toString();
        } catch (Exception e) {
            return 0 + "err";
        }
    }
}
