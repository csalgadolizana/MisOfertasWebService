/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Categoria;
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
@WebService(serviceName = "CategoriaService")
public class CategoriaService {

    @PersistenceContext
    EntityManager em;

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "Listado_categorias")
    public List<Categoria> ListadoCategorias() {
        TypedQuery<Categoria> query = em.createNamedQuery("Categoria.findAll", Categoria.class);
        return query.getResultList();
    }

    @WebMethod(operationName = "Crear_categoria")
    public String crearCategoria(@WebParam(name = "id") int idd, @WebParam(name = "desc") String desc) {
        try {
            StoredProcedureQuery query = em.createStoredProcedureQuery("CREAR_CATEGORIA");
            query.registerStoredProcedureParameter("ID_CAT", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("DES", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("SALIDA", Number.class, ParameterMode.OUT);
            query.setParameter("ID_CAT", idd);
            query.setParameter("DES", desc);
            query.execute();
            return query.getOutputParameterValue("SALIDA").toString();
        } catch (Exception e) {
            return 0 + "";
        }
    }
    
    @WebMethod(operationName = "Eliminar_categoria")
    public String EliminarCategoria(@WebParam(name = "id") int idd) {
        try {
            StoredProcedureQuery query = em.createStoredProcedureQuery("ELIMINAR_CATEGORIA");
            query.registerStoredProcedureParameter("ID_CATE", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("SALIDA", Number.class, ParameterMode.OUT);
            query.setParameter("ID_CATE", idd);
            query.execute();
            return query.getOutputParameterValue("SALIDA").toString();
        } catch (Exception e) {
            return 0 + "err";
        }
    }
}
