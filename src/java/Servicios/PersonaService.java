/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Persona;
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
@WebService(serviceName = "PersonaService")
public class PersonaService {

    @PersistenceContext
    EntityManager em;

    @WebMethod(operationName = "Listado_personas")
    public List<Persona> ListadoPersona() {
        List<Persona> arr_cust = (List<Persona>) em.createNativeQuery("select * from VIEW_PERSONA p", Persona.class)
                .getResultList();
        return arr_cust;
    }

    @WebMethod(operationName = "Crear_persona")
    public String CrearPersona(
            @WebParam(name = "id") int id, @WebParam(name = "nombre") String nombre,
            @WebParam(name = "apellido") String apellido, @WebParam(name = "rut") String rut,
            @WebParam(name = "sexo") int sexo
    ) {
        try {
            StoredProcedureQuery query = em.createStoredProcedureQuery("CREAR_PERSONA");
            query.registerStoredProcedureParameter("ID_PER", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("NOMB", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("APE", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("RUT", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("SE", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("SALIDA", Number.class, ParameterMode.OUT);
            query.setParameter("ID_PER", id);
            query.setParameter("NOMB", nombre);
            query.setParameter("APE", apellido);
            query.setParameter("RUT", rut);
            query.setParameter("SE", sexo);
            query.execute();
            return query.getOutputParameterValue("SALIDA").toString();
        } catch (Exception e) {
            return 0 + "";
        }
    }

    @WebMethod(operationName = "Modificar_persona")
    public String ModificarPersona(
            @WebParam(name = "id") int id, @WebParam(name = "nombre") String nombre,
            @WebParam(name = "apellido") String apellido, @WebParam(name = "rut") String rut,
            @WebParam(name = "sexo") int sexo
    ) {
        try {
            StoredProcedureQuery query = em.createStoredProcedureQuery("ACTUALIZAR_PERSONA");
            query.registerStoredProcedureParameter("ID_PER", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("NOMB", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("APE", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("RUTT", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("SE", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("SALIDA", Number.class, ParameterMode.OUT);
            query.setParameter("ID_PER", id);
            query.setParameter("NOMB", nombre);
            query.setParameter("APE", apellido);
            query.setParameter("RUTT", rut);
            query.setParameter("SE", sexo);
            query.execute();
            em.getEntityManagerFactory().getCache().evictAll();
            return query.getOutputParameterValue("SALIDA").toString();
        } catch (Exception e) {
            System.out.println("Error en -> ModificarPersona() -> "+e.getMessage());
            return 0 + "";
        }
    }

    @WebMethod(operationName = "Eliminar_persona")
    public String EliminarPersona(@WebParam(name = "id") int idd) {
        try {
            StoredProcedureQuery query = em.createStoredProcedureQuery("ELIMINAR_PERSONA");
            query.registerStoredProcedureParameter("ID_PERSO", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("SALIDA", Number.class, ParameterMode.OUT);
            query.setParameter("ID_PERSO", idd);
            query.execute();
            return query.getOutputParameterValue("SALIDA").toString();
        } catch (Exception e) {
            return 0 + "err";
        }
    }
}
