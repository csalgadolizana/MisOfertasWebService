/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Cargo;
import Entidades.Categoria;
import Entidades.Ciudad;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author PC-Cristopher
 */
@WebService(serviceName = "CiudadService")
public class CiudadService {

    /**
     * This is a sample web service operation
     */
   
    @PersistenceContext
    EntityManager em;

    @WebMethod(operationName = "Listado_ciudades")
    public List<Ciudad> ListadoCiudades() {
        List<Ciudad> arr_cust = (List<Ciudad>) em.createNativeQuery("select * from VIEW_CIUDAD c", Ciudad.class)
                .getResultList();
        return arr_cust;
    }
}
