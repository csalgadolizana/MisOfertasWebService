/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Local;
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
@WebService(serviceName = "LocalService")
public class LocalService {

    @PersistenceContext
    EntityManager em;

    @WebMethod(operationName = "Listado_local")
    public List<Local> ListadoLocal() {
        TypedQuery<Local> query = em.createNamedQuery("Empresa.findAll", Local.class);
        return query.getResultList();
    }

    @WebMethod(operationName = "Crear_local")
    public String CrearLocal(
            @WebParam(name = "id") int idd, @WebParam(name = "direccion") String direccion,
            @WebParam(name = "nombre") String nombre, @WebParam(name = "id_empresa") int id_empresa,
            @WebParam(name = "id_ciudad") int id_ciudad
    ) {
        try {
            StoredProcedureQuery query = em.createStoredProcedureQuery("CREAR_LOCAL");
            query.registerStoredProcedureParameter("ID_LOC", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("DIRE", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("NOMB", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("ID_EMPRE", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("ID_CIUD", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("SALIDA", Number.class, ParameterMode.OUT);
            query.setParameter("ID_LOC", idd);
            query.setParameter("DIRE", direccion);
            query.setParameter("NOMB", nombre);
            query.setParameter("ID_EMPRE", id_empresa);
            query.setParameter("ID_CIUD", id_ciudad);
            query.execute();
            return query.getOutputParameterValue("SALIDA").toString();
        } catch (Exception e) {
            return 0 + "";
        }
    }
    
    @WebMethod(operationName = "Modificar_local")
    public String ModificarLocal(
            @WebParam(name = "id") int idd, @WebParam(name = "direccion") String direccion,
            @WebParam(name = "nombre") String nombre, @WebParam(name = "id_empresa") int id_empresa,
            @WebParam(name = "id_ciudad") int id_ciudad
    ) {
        try {
            StoredProcedureQuery query = em.createStoredProcedureQuery("ACTUALIZAR_LOCAL");
            query.registerStoredProcedureParameter("ID_LOC", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("DIRE", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("NOMB", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("ID_EMPRE", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("ID_CIUD", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("SALIDA", Number.class, ParameterMode.OUT);
            query.setParameter("ID_LOC", idd);
            query.setParameter("DIRE", direccion);
            query.setParameter("NOMB", nombre);
            query.setParameter("ID_EMPRE", id_empresa);
            query.setParameter("ID_CIUD", id_ciudad);
            query.execute();
            return query.getOutputParameterValue("SALIDA").toString();
        } catch (Exception e) {
            return 0 + "";
        }
    }
    
    @WebMethod(operationName = "Eliminar_local")
    public String EliminarLocal(@WebParam(name = "id") int idd) {
        try {
            StoredProcedureQuery query = em.createStoredProcedureQuery("ELIMINAR_LOCAL");
            query.registerStoredProcedureParameter("ID_LOC", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("SALIDA", Number.class, ParameterMode.OUT);
            query.setParameter("ID_LOC", idd);
            query.execute();
            return query.getOutputParameterValue("SALIDA").toString();
        } catch (Exception e) {
            return 0 + "err";
        }
    }
}
