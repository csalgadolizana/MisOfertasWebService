package Entidades;

import Entidades.Cargo;
import Entidades.Estado;
import Entidades.InformeBi;
import Entidades.Persona;
import Entidades.Usuariooferta;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-10-22T01:51:09")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, Cargo> cargoIdcargo;
    public static volatile CollectionAttribute<Usuario, Usuariooferta> usuarioofertaCollection;
    public static volatile SingularAttribute<Usuario, BigDecimal> idUsuario;
    public static volatile SingularAttribute<Usuario, String> correo;
    public static volatile CollectionAttribute<Usuario, InformeBi> informeBiCollection;
    public static volatile SingularAttribute<Usuario, String> contrasena;
    public static volatile SingularAttribute<Usuario, Estado> estadoIdEstado;
    public static volatile SingularAttribute<Usuario, BigInteger> telefono;
    public static volatile SingularAttribute<Usuario, Date> actualizacion;
    public static volatile SingularAttribute<Usuario, Date> fechacreado;
    public static volatile SingularAttribute<Usuario, Persona> personaIdpersona;

}