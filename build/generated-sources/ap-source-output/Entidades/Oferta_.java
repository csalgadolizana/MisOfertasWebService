package Entidades;

import Entidades.DetalleNewsletter;
import Entidades.DetalleOferta;
import Entidades.Estado;
import Entidades.Informativo;
import Entidades.Ofertalocal;
import Entidades.OfertasVisitas;
import Entidades.Ofertavisi;
import Entidades.Usuariooferta;
import Entidades.Valoracion;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-10-20T23:50:31")
@StaticMetamodel(Oferta.class)
public class Oferta_ { 

    public static volatile SingularAttribute<Oferta, String> descripcion;
    public static volatile CollectionAttribute<Oferta, Ofertavisi> ofertavisiCollection;
    public static volatile SingularAttribute<Oferta, BigInteger> maximoCompra;
    public static volatile CollectionAttribute<Oferta, OfertasVisitas> ofertasVisitasCollection;
    public static volatile CollectionAttribute<Oferta, Valoracion> valoracionCollection;
    public static volatile SingularAttribute<Oferta, Date> inicio;
    public static volatile CollectionAttribute<Oferta, DetalleNewsletter> detalleNewsletterCollection;
    public static volatile SingularAttribute<Oferta, BigDecimal> idOferta;
    public static volatile CollectionAttribute<Oferta, DetalleOferta> detalleOfertaCollection;
    public static volatile SingularAttribute<Oferta, Estado> estadoIdEstado;
    public static volatile CollectionAttribute<Oferta, Ofertalocal> ofertalocalCollection;
    public static volatile SingularAttribute<Oferta, String> nombre;
    public static volatile SingularAttribute<Oferta, Informativo> informativo;
    public static volatile CollectionAttribute<Oferta, Usuariooferta> usuarioofertaCollection;
    public static volatile SingularAttribute<Oferta, BigInteger> precioNormal;
    public static volatile SingularAttribute<Oferta, BigInteger> precioOferta;
    public static volatile SingularAttribute<Oferta, BigInteger> numeroVisitas;
    public static volatile SingularAttribute<Oferta, Date> actualizacion;
    public static volatile SingularAttribute<Oferta, BigInteger> minimoCompra;

}