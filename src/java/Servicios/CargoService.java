/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.CargarPuntos;
import Entidades.Cargo;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author PC-Cristopher
 */
@WebService(serviceName = "CargoService")
public class CargoService {

    @PersistenceContext
    EntityManager em;

    @WebMethod(operationName = "Listado_cargos")
    public List<Cargo> ListadoCargos() {
        List<Cargo> arr_cust = (List<Cargo>) em.createNativeQuery("select * from VIEW_CARGO c", Cargo.class)
                .getResultList();
        return arr_cust;
    }
}
