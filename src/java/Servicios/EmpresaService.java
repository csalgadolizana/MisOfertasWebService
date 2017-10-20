/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Cliente;
import Entidades.Empresa;
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
@WebService(serviceName = "EmpresaService")
public class EmpresaService {

    @PersistenceContext
    EntityManager em;

    @WebMethod(operationName = "Listado_empresa")
    public List<Empresa> ListadoEmpresa() {
        TypedQuery<Empresa> query = em.createNamedQuery("Empresa.findAll", Empresa.class);
        return query.getResultList();
    }

    @WebMethod(operationName = "Crear_empresa")
    public String CrearEmpresa(
            @WebParam(name = "id") int idd, @WebParam(name = "rut") String rut,
            @WebParam(name = "nombre") String nombre, @WebParam(name = "descripcion") String descripcion,
            @WebParam(name = "fecha_inicio") Date fecha_inicio, @WebParam(name = "fecha_actualizacion") Date fecha_actualizacion,
            @WebParam(name = "id_estado") String id_estado
    ) {
        try {
            StoredProcedureQuery query = em.createStoredProcedureQuery("CREAR_CLIENTE");
            query.registerStoredProcedureParameter("ID_EM", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("RUT", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("NOMB", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("DES", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("INI", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("ACTU", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("ID_ES", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("SALIDA", Number.class, ParameterMode.OUT);
            query.setParameter("ID_EM", idd);
            query.setParameter("RUT", rut);
            query.setParameter("NOMB", nombre);
            query.setParameter("DES", descripcion);
            query.setParameter("INI", fecha_inicio);
            query.setParameter("ACTU", fecha_actualizacion);
            query.setParameter("ID_ES", id_estado);
            query.execute();
            return query.getOutputParameterValue("SALIDA").toString();
        } catch (Exception e) {
            return 0 + "";
        }
    }
}
