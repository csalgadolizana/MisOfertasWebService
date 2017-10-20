package Entidades;

import Entidades.Ciudad;
import Entidades.Descuento;
import Entidades.Estado;
import Entidades.OfertasVisitas;
import Entidades.Ofertavisi;
import Entidades.Persona;
import Entidades.Puntos;
import Entidades.Valoracion;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-10-20T01:52:55")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile CollectionAttribute<Cliente, Ofertavisi> ofertavisiCollection;
    public static volatile SingularAttribute<Cliente, Character> aceptaInformativo;
    public static volatile CollectionAttribute<Cliente, Puntos> puntosCollection;
    public static volatile SingularAttribute<Cliente, Date> fechaNacimiento;
    public static volatile CollectionAttribute<Cliente, OfertasVisitas> ofertasVisitasCollection;
    public static volatile CollectionAttribute<Cliente, Valoracion> valoracionCollection;
    public static volatile SingularAttribute<Cliente, Date> inicio;
    public static volatile SingularAttribute<Cliente, Estado> estadoIdEstado;
    public static volatile SingularAttribute<Cliente, Persona> personaIdpersona;
    public static volatile SingularAttribute<Cliente, BigDecimal> idCliente;
    public static volatile SingularAttribute<Cliente, String> correo;
    public static volatile SingularAttribute<Cliente, String> contrasena;
    public static volatile SingularAttribute<Cliente, Ciudad> ciudadIdCiudad;
    public static volatile SingularAttribute<Cliente, BigInteger> telefono;
    public static volatile SingularAttribute<Cliente, Date> actualizacion;
    public static volatile CollectionAttribute<Cliente, Descuento> descuentoCollection;

}