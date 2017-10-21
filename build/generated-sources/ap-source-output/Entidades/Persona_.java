package Entidades;

import Entidades.Cliente;
import Entidades.Sexo;
import Entidades.Usuario;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-10-20T23:50:31")
@StaticMetamodel(Persona.class)
public class Persona_ { 

    public static volatile SingularAttribute<Persona, String> apellidos;
    public static volatile SingularAttribute<Persona, String> rut;
    public static volatile SingularAttribute<Persona, Sexo> sexoIdSexo;
    public static volatile SingularAttribute<Persona, BigDecimal> idpersona;
    public static volatile CollectionAttribute<Persona, Usuario> usuarioCollection;
    public static volatile SingularAttribute<Persona, String> nombre;
    public static volatile CollectionAttribute<Persona, Cliente> clienteCollection;

}