/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Ciudad;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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
        List<Ciudad> arr_cust = (List<Ciudad>) em.createNativeQuery("select * from VIEW_CIUDAD c ", Ciudad.class)
                .getResultList();
        Comparator<Ciudad> byID = (ciu1, ciu2) -> Integer.compare(ciu1.getIdCiudad().intValue(), ciu2.getIdCiudad().intValue());
        return arr_cust.stream().sorted(byID).collect(Collectors.toList());
    }
}
