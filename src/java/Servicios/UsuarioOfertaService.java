/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Puntos;
import Entidades.Usuariooferta;
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
@WebService(serviceName = "UsuarioOfertaService")
public class UsuarioOfertaService {

    @PersistenceContext
    EntityManager em;

    @WebMethod(operationName = "Listado_usuario_oferta")
    public List<Usuariooferta> ListadoUsuarioOferta() {
        TypedQuery<Usuariooferta> query = em.createNamedQuery("Usuariooferta.findAll", Usuariooferta.class);
        return query.getResultList();
    }

    @WebMethod(operationName = "Crear_usuario_oferta")
    public String CrearUsuarioOferta(
            @WebParam(name = "id") int id, @WebParam(name = "descripcion") String descripcion,
            @WebParam(name = "id_usuario") int id_usuario, @WebParam(name = "id_oferta") int id_oferta
    ) {
        try {
            StoredProcedureQuery query = em.createStoredProcedureQuery("CREAR_USUARIO_OFERTA");
            query.registerStoredProcedureParameter("ID_REPO", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("DES", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("ID_USU", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("ID_OFE", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("SALIDA", Number.class, ParameterMode.OUT);
            query.setParameter("ID_REPO", id);
            query.setParameter("DES", descripcion);
            query.setParameter("ID_USU", id_usuario);
            query.setParameter("ID_OFE", id_oferta);
            query.execute();
            return query.getOutputParameterValue("SALIDA").toString();
        } catch (Exception e) {
            return 0 + "";
        }
    }
    
    @WebMethod(operationName = "Eliminar_usuario_oferta")
    public String EliminarUsuarioOferta(@WebParam(name = "id") int idd) {
        try {
            StoredProcedureQuery query = em.createStoredProcedureQuery("ELIMINAR_USUARIO_OFERTA");
            query.registerStoredProcedureParameter("ID_USUOFER", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("SALIDA", Number.class, ParameterMode.OUT);
            query.setParameter("ID_USUOFER", idd);
            query.execute();
            return query.getOutputParameterValue("SALIDA").toString();
        } catch (Exception e) {
            return 0 + "err";
        }
    }
}
