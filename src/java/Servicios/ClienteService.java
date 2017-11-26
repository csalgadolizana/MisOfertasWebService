/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Cliente;
import Utils.MailController;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.UserTransaction;

/**
 *
 * @author PC-Cristopher
 */
@WebService(serviceName = "ClienteService")
public class ClienteService {

    @PersistenceContext
    EntityManager em;

    @Resource
    UserTransaction utx;

    @WebMethod(operationName = "Autenticacion")
    public Cliente Autenticar(@WebParam(name = "correo") String correo, @WebParam(name = "contrasena") String contrasena) {
        try {
            em.getEntityManagerFactory().getCache().evictAll();
            Query q = em.createNativeQuery("SELECT * from TABLE( autenticacion_cliente_package.function_return_cliente(?,?))", Cliente.class);
            q.setParameter(1, correo);
            q.setParameter(2, contrasena);
            List<Cliente> clientes = q.getResultList();
            for (Cliente c : clientes) {
//                System.out.println("Cliente esta activo ??? == " + c.getIsonline());
                return c;
            }
        } catch (Exception e) {
            System.err.println("ClienteService -> Autenticar -> " + e.getMessage());
            return new Cliente(BigDecimal.ZERO);
        }
        return new Cliente(BigDecimal.ZERO);
    }

    @WebMethod(operationName = "Listado_clientes")
    public List<Cliente> ListadoCliente() {
        em.getEntityManagerFactory().getCache().evictAll();
        List<Cliente> arr_cust = (List<Cliente>) em.createNativeQuery("select * from VIEW_CLIENTE c", Cliente.class).getResultList();
//        arr_cust.forEach((x) -> upd(x));

        return arr_cust;
    }

    private void upd(Cliente c) {
        try {
            c.setIsonline(new BigInteger(1 + ""));
            utx.begin();
            c = em.merge(c);
            utx.commit();
        } catch (Exception e) {
            System.out.println("Error en upd(Cliente c) -> " + e.getMessage());
        }
    }

    @WebMethod(operationName = "Crear_cliente")
    public String CrearCliente(
            @WebParam(name = "id") int idd, @WebParam(name = "fecha_nacimiento") Date fecha_nacimiento,
            @WebParam(name = "correo") String correo, @WebParam(name = "password") String password,
            @WebParam(name = "telefono") int telefono, @WebParam(name = "acepta_informativo") String acepta_informativo,
            @WebParam(name = "fecha_inicio") Date fecha_inicio, @WebParam(name = "fecha_actualizacion") Date fecha_actualizacion,
            @WebParam(name = "id_ciudad") int id_ciudad,
            @WebParam(name = "id_estado") int id_estado, @WebParam(name = "id_persona") int id_persona) {
        try {
            StoredProcedureQuery query = em.createStoredProcedureQuery("CREAR_CLIENTE");
            query.registerStoredProcedureParameter("ID_CLI", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("FECH", Date.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("CORRE", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("PASS", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("TE", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("ACEP", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("INI", Date.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("ACTU", Date.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("ID_CI", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("ID_ES", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("ID_PER", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("isonlinee", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("SALIDA", Number.class, ParameterMode.OUT);
            query.setParameter("FECH", fecha_nacimiento);
            query.setParameter("CORRE", correo);
            query.setParameter("PASS", password);
            query.setParameter("TE", telefono);
            query.setParameter("ACEP", acepta_informativo);
            query.setParameter("INI", fecha_inicio);
            query.setParameter("ACTU", fecha_actualizacion);
            query.setParameter("ID_CI", id_ciudad);
            query.setParameter("ID_ES", id_estado);
            query.setParameter("ID_PER", id_persona);
            query.setParameter("isonlinee", 1);
            query.execute();
            try {
                MailController mailController = new MailController();
                System.err.println("Enviando Mail.");
                System.err.println("Enviando Mail..");
                System.err.println("Enviando Mail...");
                System.err.println("Enviando Mail....");
                System.err.println("Enviando Mail.....");
                System.err.println(correo);
                mailController.enviarBienvenida(correo, "Bienvenido a mis ofertas", "Estas abriendo tu mundo a nuevas ofertas ", "Esperamos que disfutes de las ofertas que estan disponibles es nuestra tienda", "Saludos de todo el equipo de misOfertas :)");
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
            return query.getOutputParameterValue("SALIDA").toString();
        } catch (Exception e) {
            return 0 + "" + e.getMessage();
        }
    }

    @WebMethod(operationName = "Modificar_cliente")
    public String ModificarCliente(
            @WebParam(name = "id") int idd, @WebParam(name = "fecha_nacimiento") Date fecha_nacimiento,
            @WebParam(name = "correo") String correo, @WebParam(name = "password") String password,
            @WebParam(name = "telefono") int telefono, @WebParam(name = "acepta_informativo") String acepta_informativo,
            @WebParam(name = "fecha_inicio") Date fecha_inicio,
            @WebParam(name = "id_ciudad") int id_ciudad,
            @WebParam(name = "id_estado") int id_estado, @WebParam(name = "id_persona") int id_persona) {
        try {
            StoredProcedureQuery query = em.createStoredProcedureQuery("ACTUALIZAR_CLIENTE");
            query.registerStoredProcedureParameter("ID_CLI", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("FECH", Date.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("CORRE", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("PASS", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("TE", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("ACEP", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("INI", Date.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("ACTU", Date.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("ID_CI", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("ID_ES", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("ID_PER", Number.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("SALIDA", Number.class, ParameterMode.OUT);
            query.setParameter("ID_CLI", idd);
            query.setParameter("FECH", fecha_nacimiento);
            query.setParameter("CORRE", correo);
            query.setParameter("PASS", password);
            query.setParameter("TE", telefono);
            query.setParameter("ACEP", acepta_informativo);
            query.setParameter("INI", fecha_inicio);
            query.setParameter("ACTU", new Date());
            query.setParameter("ID_CI", id_ciudad);
            query.setParameter("ID_ES", id_estado);
            query.setParameter("ID_PER", id_persona);
            query.execute();
            em.getEntityManagerFactory().getCache().evictAll();
            return query.getOutputParameterValue("SALIDA").toString();
        } catch (Exception e) {
            System.err.println("Error en -> ModificarCliente() ->" + e.getMessage());
            return 0 + "";
        }
    }

    @WebMethod(operationName = "Eliminar_cliente")
    public String EliminarCliente(@WebParam(name = "id") int idd) {
        try {
            StoredProcedureQuery query = em.createStoredProcedureQuery("ELIMINAR_CLIENTE");
            query
                    .registerStoredProcedureParameter("ID_CLI", Number.class,
                            ParameterMode.IN);
            query
                    .registerStoredProcedureParameter("SALIDA", Number.class,
                            ParameterMode.OUT);
            query.setParameter("ID_CLI", idd);
            query.execute();
            return query.getOutputParameterValue("SALIDA").toString();
        } catch (Exception e) {
            return 0 + "err";
        }
    }

    @WebMethod(operationName = "inicia_sesion_cliente")
    public int IniciarSesionCliente(@WebParam(name = "id") int idd) {
        try {
            Cliente c = em.find(Cliente.class, BigDecimal.valueOf(idd));
            c.setIsonline(new BigInteger(1 + ""));
            utx.begin();
            c = em.merge(c);
            utx.commit();
            return 1;
        } catch (Exception e) {
            System.err.println("Error en -> IniciarSesionCliente() ->" + e.getMessage());
            return 0;
        }
    }

    @WebMethod(operationName = "cerrar_sesion_cliente")
    public int CerrarSesionCliente(@WebParam(name = "id") int idd) {
        try {
            Cliente c = em.find(Cliente.class, BigDecimal.valueOf(idd));
            c.setIsonline(new BigInteger(2 + ""));
            utx.begin();
            c = em.merge(c);
            utx.commit();
            return 1;
        } catch (Exception e) {
            System.err.println("Error en -> CerrarSesionCliente() ->" + e.getMessage());
            return 0;
        }
    }

    @WebMethod(operationName = "buscar_cliente")
    public Cliente BuscarCliente(@WebParam(name = "id") int idd) {
        try {
            Cliente c = em.find(Cliente.class, BigDecimal.valueOf(idd));
            return c;
        } catch (Exception e) {
            System.err.println("Error en -> BuscarCliente() ->" + e.getMessage());
            return null;
        }
    }

}
