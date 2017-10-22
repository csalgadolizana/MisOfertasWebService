package Entidades;

import Entidades.Cliente;
import Entidades.Descuento;
import Entidades.Empresa;
import Entidades.Oferta;
import Entidades.Usuario;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-10-22T15:20:42")
@StaticMetamodel(Estado.class)
public class Estado_ { 

    public static volatile SingularAttribute<Estado, String> descripcion;
    public static volatile SingularAttribute<Estado, BigDecimal> idEstado;
    public static volatile CollectionAttribute<Estado, Empresa> empresaCollection;
    public static volatile CollectionAttribute<Estado, Usuario> usuarioCollection;
    public static volatile CollectionAttribute<Estado, Oferta> ofertaCollection;
    public static volatile CollectionAttribute<Estado, Descuento> descuentoCollection;
    public static volatile CollectionAttribute<Estado, Cliente> clienteCollection;

}