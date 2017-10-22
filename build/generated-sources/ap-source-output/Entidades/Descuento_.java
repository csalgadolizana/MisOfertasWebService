package Entidades;

import Entidades.CargarPuntos;
import Entidades.Categoria;
import Entidades.Cliente;
import Entidades.DescuentoPK;
import Entidades.Estado;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-10-22T01:51:09")
@StaticMetamodel(Descuento.class)
public class Descuento_ { 

    public static volatile SingularAttribute<Descuento, String> codigo;
    public static volatile SingularAttribute<Descuento, Estado> estado;
    public static volatile SingularAttribute<Descuento, Categoria> categoriaIdCategoria;
    public static volatile SingularAttribute<Descuento, BigInteger> tope;
    public static volatile SingularAttribute<Descuento, BigInteger> puntosUsados;
    public static volatile CollectionAttribute<Descuento, CargarPuntos> cargarPuntosCollection;
    public static volatile SingularAttribute<Descuento, Date> inicio;
    public static volatile SingularAttribute<Descuento, Cliente> clienteIdCliente;
    public static volatile SingularAttribute<Descuento, DescuentoPK> descuentoPK;
    public static volatile SingularAttribute<Descuento, Date> actualizacion;

}