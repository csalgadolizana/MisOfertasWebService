/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.CargarPuntos;
import Entidades.Cliente;
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
@WebService(serviceName = "ClienteService")
public class ClienteService {

    @PersistenceContext
    EntityManager em;

    @WebMethod(operationName = "Listado_clientes")
    public List<Cliente> ListadoCliente() {
        TypedQuery<Cliente> query = em.createNamedQuery("Cliente.findAll", Cliente.class);
        return query.getResultList();
    }

    @WebMethod(operationName = "Crear_cliente")
    public String CrearCliente(
            @WebParam(name = "id") int idd, @WebParam(name = "fecha_nacimiento") Date fecha_nacimiento,
            @WebParam(name = "correo") String correo, @WebParam(name = "password") String password,
            @WebParam(name = "telefono") int telefono, @WebParam(name = "acepta_informativo") String acepta_informativo,
            @WebParam(name = "fecha_inicio") Date fecha_inicio, @WebParam(name = "fecha_actualizacion") Date fecha_actualizacion,
            @WebParam(name = "id_ciudad") int id_ciudad,
            @WebParam(name = "id_estado") String id_estado, @WebParam(name = "id_persona") int id_persona) {
        try {
            StoredProcedureQuery query = em.createStoredProcedureQuery("CREAR_CLIENTE");
            query.registerStoredProcedureParameter("ID_CLI", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("FECH", Date.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("CORRE", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("PASS", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("TE", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("ACEP", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("INI", Date.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("ACTU", Date.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("ID_CI", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("ID_ES", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("ID_PER", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("SALIDA", Number.class, ParameterMode.OUT);
            query.setParameter("ID_CLI", idd);
            query.setParameter("FECH", fecha_nacimiento);
            query.setParameter("CORRE", correo);
            query.setParameter("PASS", password);
            query.setParameter("TE", telefono);
            query.setParameter("ACEP", acepta_informativo);
            query.setParameter("INI", fecha_inicio);
            query.setParameter("ACTU", fecha_actualizacion);
            query.setParameter("ID_CI", id_ciudad);
            query.setParameter("ID_ES", id_estado);
            query.setParameter("ID_PER", id_persona);
            query.execute();
            return query.getOutputParameterValue("SALIDA").toString();
        } catch (Exception e) {
            return 0 + "";
        }
    }
    
    @WebMethod(operationName = "Eliminar_cliente")
    public String EliminarCliente(@WebParam(name = "id") int idd) {
        try {
            StoredProcedureQuery query = em.createStoredProcedureQuery("ELIMINAR_CLIENTE");
            query.registerStoredProcedureParameter("ID_CLI", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("SALIDA", Number.class, ParameterMode.OUT);
            query.setParameter("ID_CLI", idd);
            query.execute();
            return query.getOutputParameterValue("SALIDA").toString();
        } catch (Exception e) {
            return 0 + "err";
        }
    }
}
