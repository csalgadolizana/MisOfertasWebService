/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Usuario;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author PC-Cristopher
 */
@WebService(serviceName = "UsuarioService")
public class UsuarioService {

    @PersistenceContext
    EntityManager em;

    /**
     * Created by Cristopher Salgado Input String nombre de Usuario Input String
     * contraseña Output Usuario object
     */
    @WebMethod(operationName = "Autenticacion")
//    public Object Autenticar(@WebParam(name = "id") int idus) {
    public Usuario Autenticar(@WebParam(name = "correo") String correo, @WebParam(name = "contrasena") String contrasena) {
//        TypedQuery<Usuario> query = em.createNamedQuery("Usuario.findByUsernameAndPassword", Usuario.class);
//        Query query = em.createNativeQuery("SELECT * from TABLE( test_package.test_plsql_table(:id))", Usuario.class);
//        query.setParameter("id", idus);
//        Usuario u = (Usuario) query.getSingleResult();
////        query.setParameter("contrasena", contrasenaa);
//        return u;

        try {
            Query q = em.createNativeQuery("SELECT * from TABLE( autenticacion_package.function_return_user(?,?))", Usuario.class);
            q.setParameter(1, correo);
            q.setParameter(2, contrasena);
            List<Usuario> usuarios = q.getResultList();

            for (Usuario a : usuarios) {
//            System.out.println("Author "
//                    + a.getFirstName()
//                    + " "
//                    + a.getLastName());
                return a;
            }

        } catch (Exception e) {
            return new Usuario(BigDecimal.ZERO, "Error al iniciar sesion", e.getMessage(), BigInteger.TEN);
        }
//        return null;
        return new Usuario(BigDecimal.ZERO);
    }

    /**
     * Created by Cristopher Salgado Output List<Usuario> List
     */
    @WebMethod(operationName = "Listado_usuarios")
    public List<Usuario> ListadoUsuarios() {
        TypedQuery<Usuario> query = em.createNamedQuery("Usuario.findAll", Usuario.class);
        return query.getResultList();
    }
}
