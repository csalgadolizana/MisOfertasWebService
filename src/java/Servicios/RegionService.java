/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Region;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author PC-Cristopher
 */
@WebService(serviceName = "RegionService")
public class RegionService {

    @PersistenceContext
    EntityManager em;

    @WebMethod(operationName = "Listado_regiones")
    public List<Region> ListadoRegiones() {
        List<Region> arr_cust = (List<Region>) em.createNativeQuery("select * from VIEW_REGION r", Region.class)
                .getResultList();
        Comparator<Region> byIdRegion = (o1, o2) -> Integer.compare(o1.getIdRegion().intValue(), o2.getIdRegion().intValue());
        return arr_cust.stream().sorted(byIdRegion).collect(Collectors.toList());
    }
}
