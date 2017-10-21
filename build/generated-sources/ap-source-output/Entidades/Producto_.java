package Entidades;

import Entidades.Categoria;
import Entidades.DetalleOferta;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-10-21T15:23:50")
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile SingularAttribute<Producto, String> descripcion;
    public static volatile SingularAttribute<Producto, BigInteger> precio;
    public static volatile SingularAttribute<Producto, Categoria> categoriaIdCategoria;
    public static volatile SingularAttribute<Producto, Date> inicio;
    public static volatile SingularAttribute<Producto, String> imagen;
    public static volatile CollectionAttribute<Producto, DetalleOferta> detalleOfertaCollection;
    public static volatile SingularAttribute<Producto, BigDecimal> idProducto;
    public static volatile SingularAttribute<Producto, String> nombre;
    public static volatile SingularAttribute<Producto, Date> actualizacion;

}