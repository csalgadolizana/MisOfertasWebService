/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Empresa;
import java.util.Comparator;
import java.util.Date;
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
@WebService(serviceName = "EmpresaService")
public class EmpresaService {

    @PersistenceContext
    EntityManager em;

    @WebMethod(operationName = "Listado_empresa")
    public List<Empresa> ListadoEmpresa() {
        List<Empresa> arr_cust = (List<Empresa>) em.createNativeQuery("select * from VIEW_EMPRESA d", Empresa.class)
                .getResultList();
        return arr_cust;
    }

    @WebMethod(operationName = "Crear_empresa")
    public String CrearEmpresa(
            @WebParam(name = "rut") String rut,
            @WebParam(name = "nombre") String nombre, @WebParam(name = "descripcion") String descripcion,
            @WebParam(name = "id_estado") int id_estado
    ) {
        try {
            StoredProcedureQuery query = em.createStoredProcedureQuery("CREAR_EMPRESA");
            query.registerStoredProcedureParameter("ID_EM", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("RUT", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("NOMB", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("DES", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("INI", Date.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("ACTU", Date.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("ID_ES", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("SALIDA", Number.class, ParameterMode.OUT);
            List<Empresa> arr_cust = (List<Empresa>) em.createNativeQuery("select * from VIEW_EMPRESA d", Empresa.class).getResultList();
            Comparator<Empresa> com = (o1, o2) -> o1.getIdEmpresa().compareTo(o2.getIdEmpresa());
            int idd = arr_cust.stream().max(com).get().getIdEmpresa().intValue();
            System.out.println("valor maximo id " + idd + 1);
            query.setParameter("ID_EM", idd + 1);
            query.setParameter("RUT", rut);
            query.setParameter("NOMB", nombre);
            query.setParameter("DES", descripcion);
            query.setParameter("INI", new Date());
            query.setParameter("ACTU", new Date());
            query.setParameter("ID_ES", id_estado);
            query.execute();
            return query.getOutputParameterValue("SALIDA").toString();
        } catch (Exception e) {
            return 0 + " Error " + e.getMessage() + " ";
        }
    }

    @WebMethod(operationName = "Modificar_empresa")
    public String ModificarEmpresa(
            @WebParam(name = "idd") int idd, @WebParam(name = "rut") String rut,
            @WebParam(name = "nombre") String nombre, @WebParam(name = "descripcion") String descripcion,
            @WebParam(name = "id_estado") int id_estado
    ) {
        try {
            StoredProcedureQuery query = em.createStoredProcedureQuery("ACTUALIZAR_EMPRESA");
            query.registerStoredProcedureParameter("ID_EM", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("RUT", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("NOMB", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("DES", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("INI", Date.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("ACTU", Date.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("ID_ES", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("SALIDA", Number.class, ParameterMode.OUT);
            query.setParameter("ID_EM", idd);
            query.setParameter("RUT", rut);
            query.setParameter("NOMB", nombre);
            List<Empresa> arr_cust = (List<Empresa>) em.createNativeQuery("select * from VIEW_EMPRESA d", Empresa.class).getResultList();
            Date fech_ini = arr_cust.stream().filter((x) -> x.getIdEmpresa().intValue() == idd).findFirst().orElse(null).getInicio();
            query.setParameter("DES", descripcion);
            System.out.println(" Error en -> Modificar_empresa() -> 16");
            query.setParameter("INI", fech_ini);
            System.out.println(" Error en -> Modificar_empresa() -> 17");
            query.setParameter("ACTU", new Date());
            System.out.println(" Error en -> Modificar_empresa() -> 18");
            query.setParameter("ID_ES", id_estado);
            query.execute();
            em.getEntityManagerFactory().getCache().evictAll();
            return query.getOutputParameterValue("SALIDA").toString();
        } catch (Exception e) {
            System.out.println(" Error en -> Modificar_empresa() -> " + e.getMessage());
            return 0 + "";
        }
    }

    @WebMethod(operationName = "Eliminar_empresa")
    public String EliminarEmpresa(@WebParam(name = "id") int idd) {
        try {
            StoredProcedureQuery query = em.createStoredProcedureQuery("ELIMINAR_EMPRESA");
            query.registerStoredProcedureParameter("ID_EMPRE", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("SALIDA", Number.class, ParameterMode.OUT);
            query.setParameter("ID_EMPRE", idd);
            query.execute();
            return query.getOutputParameterValue("SALIDA").toString();
        } catch (Exception e) {
            return 0 + " Error " + e.getMessage() + " ";
        }
    }
}
