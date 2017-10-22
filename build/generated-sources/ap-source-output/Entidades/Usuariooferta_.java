package Entidades;

import Entidades.Oferta;
import Entidades.Usuario;
import Entidades.UsuarioofertaPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-10-22T15:20:42")
@StaticMetamodel(Usuariooferta.class)
public class Usuariooferta_ { 

    public static volatile SingularAttribute<Usuariooferta, String> descripcion;
    public static volatile SingularAttribute<Usuariooferta, Oferta> oferta;
    public static volatile SingularAttribute<Usuariooferta, UsuarioofertaPK> usuarioofertaPK;
    public static volatile SingularAttribute<Usuariooferta, Usuario> usuario;

}