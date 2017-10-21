package Entidades;

import Entidades.Descuento;
import Entidades.Producto;
import Entidades.Valoracion;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-10-20T23:50:31")
@StaticMetamodel(Categoria.class)
public class Categoria_ { 

    public static volatile SingularAttribute<Categoria, String> descripcion;
    public static volatile CollectionAttribute<Categoria, Valoracion> valoracionCollection;
    public static volatile CollectionAttribute<Categoria, Producto> productoCollection;
    public static volatile SingularAttribute<Categoria, BigDecimal> idCategoria;
    public static volatile CollectionAttribute<Categoria, Descuento> descuentoCollection;

}